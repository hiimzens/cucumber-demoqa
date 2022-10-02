package com.demoqa.steps;

import com.demoqa.utils.PropertiesFileUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class StepHooks {
    public static WebDriver driver;
    public static String baseURI;

    @BeforeAll
    public static void beforeAll() throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile("src/test/resources/configs/dev.properties");
        PropertiesFileUtil.appendSystemProperties(properties);
        baseURI = System.getProperty("API_URL");

    }
    @Before()
    public void beforeScenario(){
        String browser = System.getProperty("browser");
        if(browser!=null && !browser.isEmpty()){
            System.setProperty("BROWSER_TYPE",browser);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));
    }
    @After()
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image.png", scenario.getName());
        }
        driver.quit();
    }
}
