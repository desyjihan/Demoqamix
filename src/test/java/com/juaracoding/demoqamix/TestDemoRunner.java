package com.juaracoding.demoqamix;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
				features = "src/test/resources/features/Demo.feature", 
				glue = "com.juaracoding.demoqamix", 
				plugin = {"pretty", "html:target/cucumber-reports.html"})

public class TestDemoRunner extends AbstractTestNGCucumberTests {
}
