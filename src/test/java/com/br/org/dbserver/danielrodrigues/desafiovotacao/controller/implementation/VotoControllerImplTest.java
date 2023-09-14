package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.VotoStub;
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
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VotoControllerImplTest {
    private final String URL = "/votos";
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = this.port;
    }

    @Test
    @SqlGroup(
            {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirPauta),
                    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirSessao),
                    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = inserirAssociado),
                    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = limparDB)})
    void deveVotarComSucesso() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(VotoStub.gerarRequestPositivo())
                .when().log().all()
                .post(URL)
                .then().log().all()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.CREATED.value())
                .body("cpfAssociado", equalTo("13093250064"))
                .body("idSessao", equalTo(1))
                .body("decisao", equalTo("SIM"));
    }
}