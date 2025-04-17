package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;

import java.time.Duration;


public class Setup {

        public static WebDriver driver;


        @After
        public void takeScreenShotsOnStepFailure(Scenario scenario) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            driver.quit();
        }

        @Before
        public void setupDriverAndPages(){
            String url = ConfigReader.getProperty("homePageUrl");
            int seconds = Integer.parseInt(ConfigReader.getProperty("timeout"));
            boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
            switch (ConfigReader.getProperty("browser").toLowerCase()){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (headless) edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--maximize");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions= new FirefoxOptions();
                    if (headless) firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--maximize");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--maximize");
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }

            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

        }


    }
