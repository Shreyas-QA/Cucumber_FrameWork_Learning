package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="FeatureFile",glue={"StepDefination"})
public class Runner {
	
	
}