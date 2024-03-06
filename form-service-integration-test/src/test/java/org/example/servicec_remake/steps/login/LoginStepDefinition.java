package org.example.servicec_remake.steps.login;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.SneakyThrows;
import org.example.servicec_remake.RunCucumberTest;
import org.example.servicec_remake.steps.HttpRequestFactory;
import org.example.servicec_remake.steps.dto.LoginResponse;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginStepDefinition {

    private static final String LOGIN = "/v1/authentication";

    @Getter
    private LoginResponse loginResponse;

    @SneakyThrows
    @When("the user {string} logs in with password {string}")
    public void logs_in_with(String userName, String password) {

        String input = String.format("""
                {
                    "userName": "%s",
                    "password": "%s"
                }
                """, userName, password);

        HttpRequest request = HttpRequestFactory.createPost(RunCucumberTest.SERVICE_URL + LOGIN, input, null);

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200) {
            loginResponse = new ObjectMapper().readValue(response.body(),
                    LoginResponse.class);
        }
    }
    @Then("the user receives a token")
    public void the_form_service_returns_a_token() {
        Assertions.assertNotNull(loginResponse.getToken());
    }
}
