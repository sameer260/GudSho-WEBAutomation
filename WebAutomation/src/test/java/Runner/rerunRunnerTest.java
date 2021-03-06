/*package Runner;

import java.io.File;
import java.io.IOException;
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
@io.cucumber.junit.CucumberOptions(features="@target/rerun.txt",
glue={"steps"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		  "pretty","json:target/cucumber-reports/Cucumber.json", 
		  "junit:target/cucumber-reports/Cucumber.xml",
		  "html:target/cucumber-reports/htmlreports.html"},
           monochrome=true)

public class rerunRunnerTest {
	
	@BeforeClass
	public static void logger() throws IOException {
		
		  PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/java/Resources/log4j.properties");

	}

	@AfterClass
	public static void JVMreports() throws IOException {
		File reportOutputDirectory = new File("target/JVM");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add("target/cucumber-reports/Cucumber.json");
		String buildNumber = "1";
		String project = "gudsho";
		Configuration configuration = new Configuration(reportOutputDirectory, project);
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Environment", "QA");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Platform", "Windows 10");
		configuration.setSortingMethod(SortingMethod.NATURAL);
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread(){
			public void run() {
				try {
					AutomatedEmail.sendemail();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	  }	
		
	}*/
