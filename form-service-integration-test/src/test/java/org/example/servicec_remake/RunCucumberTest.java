package org.example.servicec_remake;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"})
public class RunCucumberTest {

    public static final String SERVICE_URL = "http://173.249.3.182:5598";
}
