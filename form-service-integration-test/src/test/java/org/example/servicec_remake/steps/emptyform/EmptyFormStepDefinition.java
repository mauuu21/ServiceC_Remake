package org.example.servicec_remake.steps.emptyform;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.servicec_remake.RunCucumberTest;
import org.example.servicec_remake.steps.HttpRequestFactory;
import org.example.servicec_remake.steps.login.LoginStepDefinition;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class EmptyFormStepDefinition {

    private static final String EmPTY_FORM = "/v1/forms";

    private HttpResponse<String> response;

    private final LoginStepDefinition login;

    @SneakyThrows
    @When("the user {string} sends an empty form as {string}")
    public void send_an_empty_form(String userName, String fileName) {

        String input = new String(this.getClass().getClassLoader().getResourceAsStream(fileName + ".jason").readAllBytes());
        String token = login.getLoginResponse().getToken();
        HttpRequest request = HttpRequestFactory.createPost(RunCucumberTest.SERVICE_URL + EmPTY_FORM, input, token);

        response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        }

    @Then("the Forms end-point returns HTTP status code {int}")
    public void form_service_end_point_returns(Integer statusCode) {
        Assertions.assertEquals(statusCode, response.statusCode());
    }
}
