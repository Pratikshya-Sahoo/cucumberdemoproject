package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\Users\\Star\\eclipse-workspace\\practise\\features\\loginwebshop.feature",
							glue="stepdefs")

public class Testrunner1{
}
