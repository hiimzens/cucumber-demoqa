package com.demoqa.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com/demoqa/steps"},
        monochrome = true
)
public class CucumberTest extends AbstractTestNGCucumberTests{
        @Override
        @DataProvider(parallel = false)
        public Object[][]scenarios(){
            return super.scenarios();
        }
}


