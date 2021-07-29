package Runner;



import java.io.File;

import java.io.IOException;
import io.cucumber.junit.CucumberOptions;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import Resources.AutomatedEmail;
import io.cucumber.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.sorting.SortingMethod;



	@RunWith(Cucumber.class)
	@CucumberOptions(features= "src/test/resources/Features/frontend",
	glue={"steps"})
	

      
		
	public class Runnerclass
	{	
		 
		
		
	}


