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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe gère la configuration du WebDriver et les captures d'écran en cas d'échec des tests.
 * Elle utilise Cucumber pour intégrer les étapes de test.
 */
public class Setup {

        public static WebDriver driver;

        /**
         * Cette méthode est exécutée après chaque scénario de test.
         * Elle prend une capture d'écran si le scénario échoue et ferme le navigateur.
         *
         * @param scenario Le scénario de test Cucumber
         */
        @After
        public void takeScreenShotsOnStepFailure(Scenario scenario) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            driver.quit();
        }

        /**
         * Cette méthode est exécutée avant chaque scénario de test.
         * Elle initialise le WebDriver en fonction des paramètres de configuration.
         *
         * @throws MalformedURLException si l'URL du serveur Selenium Grid est mal formée
         */
        @Before
        public void setupDriverAndPages() throws MalformedURLException {

            // Chargement des propriétés de configuration
            String url = ConfigReader.getProperty("homePageUrl");
            boolean useGrid = Boolean.parseBoolean(ConfigReader.getProperty("useGrid"));
            int seconds = Integer.parseInt(ConfigReader.getProperty("timeout"));

            // Configuration des options du navigateur
            if (useGrid) {
                String gridUrl = ConfigReader.getProperty("gridUrl");
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(ConfigReader.getProperty("browser"));
                driver = new RemoteWebDriver(new URL(gridUrl), desiredCapabilities);
            }
            else {
                boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
                switch (ConfigReader.getProperty("browser").toLowerCase()) {
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        if (headless) edgeOptions.addArguments("--headless");
                        edgeOptions.addArguments("start-maximized");
                        driver = new EdgeDriver(edgeOptions);
                        break;

                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        if (headless) firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("start-maximized");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        if (headless) chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--disable-extensions");
                        chromeOptions.addArguments("--disable-popup-blocking");
                        chromeOptions.addArguments("--no-default-browser-check");


                        driver = new ChromeDriver(chromeOptions);
                        break;
                }
            }
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

        }


    }
