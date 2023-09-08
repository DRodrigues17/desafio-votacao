package com.br.org.dbserver.danielrodrigues.desafiovotacao.scheduler;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.SessaoRepository;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Predicate;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Component
public class EncerrarVotacao {
    private static final Logger LOGGER = Logger.getLogger(EncerrarVotacao.class.getName());
    PautaService pautaService;

    SessaoRepository sessaoRepository;

    @Scheduled(fixedRate = 50000)
    private void finalizarSessoesQueJaPassaramDoHorarioDeFechamento() {
        Predicate<SessaoDeVoto> jaPassouDoHorarioDeFechamento = sessao -> LocalDateTime.now().isAfter(sessao.getHoraDeFechamento());

        sessaoRepository
                .findAll()
                .stream()
                .filter(jaPassouDoHorarioDeFechamento)
                .forEach(sessao -> {
                    sessao.definirSessaoComoEncerrada();
                    sessaoRepository.save(sessao);

                    SituacaoPauta situacaoPauta = sessao.descobrirResultadoDaVotacao();

                    pautaService.alterarSituacaoDaPauta(sessao.getIdDaPauta(), situacaoPauta);

                    LOGGER.info("a sessao " + sessao.getId() + " foi encerrada com sucesso no momento " + LocalDateTime.now(ZoneId.systemDefault()));
                });
    }
}
