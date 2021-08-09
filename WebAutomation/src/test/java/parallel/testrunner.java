package parallel;

import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(features= "src/test/resources/parallel/Paywall.feature",
glue={"parallel"},
plugin= {"timeline:test-output-thread/"}


		)

	
public class testrunner
{
	
}
