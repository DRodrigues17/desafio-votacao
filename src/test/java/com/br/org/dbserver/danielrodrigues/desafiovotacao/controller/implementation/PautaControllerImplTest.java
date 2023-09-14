package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.PautaStub;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static com.br.org.dbserver.danielrodrigues.desafiovotacao.SqlProvider.inserirPauta;
import static com.br.org.dbserver.danielrodrigues.desafiovotacao.SqlProvider.limparDB;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PautaControllerImplTest {
    private final String URL = "/pautas";
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = this.port;
    }

    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = limparDB)
    @Test
    void deveCadastrarPautaComSucesso() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(PautaStub.gerarRequest())
                .when()
                .post(URL)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.CREATED.value())
                .body(containsString("\"nome\":\"uso de uniforme\",\"descricao\":\"nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office\""));
    }

    @Test
    @SqlGroup(
            {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirPauta),
                    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = limparDB)})
    void deveBuscarPautaComSucesso() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(URL + "/1")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.OK.value())
                .body(containsString("\"situacao\":\"PARA_VOTAR\""));
    }
}