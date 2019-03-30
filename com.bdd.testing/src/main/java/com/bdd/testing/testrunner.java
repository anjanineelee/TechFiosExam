package com.bdd.testing;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;// type this import manually 

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Administrator\\TechFios-Projects\\com.bdd.testing\\src\\test\\java\\feature", //the path of the feature package files
		glue= {"stepdefinition"}, //the path of the step definition is package name
		monochrome = true,plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report", "json:target/cucumber-reports/cucumber-json-report.json", "junit:target/cucumber-reports/Cucumber.xml" },
		dryRun=false //to check the mapping is proper between feature file and step def file
		//tags = {"~@SmokeTest", "~@RegressionTest", "~@End2End"}
		//tags = {"@White"} //only runs the scenario listed in tag
		)

//features ="the path of the feature package"
//glue = stepdefinition pacakage name
//dryRun = true when u want the steps for stepdefinition while executing the testcases make to false
//tags used when u want to run particular scenario 
public class testrunner {

}
