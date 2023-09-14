package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.SessaoStub;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static com.br.org.dbserver.danielrodrigues.desafiovotacao.SqlProvider.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SessaoControllerImplTest {
    private final String URL = "/sessoes";
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = this.port;
    }

    @Test
    @SqlGroup(
            {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirPauta),
                    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = limparDB)})
    void deveAbrirUmaSessaoComSucesso() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(SessaoStub.gerarRequest())
                .when()
                .post(URL)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.CREATED.value())
                .body("idSessao", equalTo(1))
                .body("encerrada", equalTo(false));
    }

    @Test
    @SqlGroup(
            {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirPauta),
                    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = limparDB)})
    void deveAbrirUmaSessaoSemHoraDeFechamentoPreDefinidoComSucesso() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(SessaoStub.gerarRequestSemHoraDeFechamentoDefinido())
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body(containsString("\"situacao\":\"PARA_VOTAR\""));

    }

    @Test
    @SqlGroup(
            {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirPauta),
                    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirSessao),
                    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = limparDB)})
    void deveBuscarResultadoDaSessaoComSucesso() {
        RestAssured.given()
                .when()
                .get(URL + "/1")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("numeroDeVotos", equalTo(0));
    }
}