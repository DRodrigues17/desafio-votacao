package com.br.org.dbserver.danielrodrigues.desafiovotacao.scheduler;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.SessaoRepository;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Predicate;

@Slf4j
@RequiredArgsConstructor
@Component
public class EncerrarVotacao {
    @Autowired
    PautaService pautaService;
    @Autowired
    SessaoRepository sessaoRepository;

    @Scheduled(fixedRate = 50000)
    private void finalizarSessoesQueJaPassaramDoHorarioDeFechamento() {
        Predicate<SessaoDeVoto> jaPassouDoHorarioDeFechamento = sessao -> LocalDateTime.now().isAfter(sessao.getHoraDeFechamento());
        Predicate<SessaoDeVoto> sessaoNaoEncerrada = sessao -> !sessao.isEncerrada();

        sessaoRepository
                .findAll()
                .stream()
                .filter(jaPassouDoHorarioDeFechamento)
                .filter(sessaoNaoEncerrada)
                .forEach(sessao -> {
                    sessao.definirSessaoComoEncerrada();
                    sessaoRepository.save(sessao);

                    SituacaoPauta situacaoPauta = sessao.descobrirResultadoDaVotacao();

                    pautaService.alterarSituacaoDaPauta(sessao.getIdDaPauta(), situacaoPauta);

                    log.info("a sessao " + sessao.getId() + " foi encerrada com sucesso no momento " + LocalDateTime.now(ZoneId.systemDefault()));
                });
    }
}
