package com.parabank.base;

import com.parabank.utilities.TestUtils;
import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
public class BaseTest {
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();//paralel execution gitlab
    protected static Properties properties;

    public BaseTest() {
        super();
        loadProperties();
    }

    private void loadProperties() {
        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "src/main/java/com/parabank/config/config.properties");
            properties.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public void initialization() {
        String browserName = properties.getProperty("browser");
        WebDriver rdriver = getDriver(browserName); // Get the shared driver instance
        SelfHealingDriver driver= SelfHealingDriver.createTestDriver(rdriver);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        // Load URL based on environment
        loadUrl(driver);
    }



    private void loadUrl(WebDriver driver) {
        String env = System.getProperty("Environment");
        String baseUrl = properties.getProperty("url");
        if ("Dev".equalsIgnoreCase(env)) {
            driver.get(properties.getProperty("devurl"));
            System.out.println("Test Url is"+properties.getProperty("devurl"));
        }
        else {
            driver.get(baseUrl);
            System.out.println("Test Url is"+baseUrl);

        }
    }

    protected WebDriver getDriver(String browserName) {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            driver = createDriver(browserName);
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    private WebDriver createDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            configureChromeOptions(options);
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }
        return driver;
    }

    private void configureChromeOptions(ChromeOptions options) {
        String os = System.getProperty("os.name").toLowerCase();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        if (os.contains("win")) {
            options.addArguments("--start-maximized");
            //options.addArguments("--headless=new");
        } else {

            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=2000,1080");
            options.addArguments("--start-maximized");
            options.addArguments("--verbose");
            options.addArguments("plugins.plugins_list", "[{'enabled': False, 'name': 'Chrome PDF Viewer'}]");
            options.addArguments("download.extensions_to_open", "applications/pdf");
            options.addArguments("safebrowsing.enabled", "False");
            options.setAcceptInsecureCerts(true);


        }
        options.setCapability("acceptInsecureCerts", true);
        options.setCapability("goog:loggingPrefs", logPrefs);
    }

    public void tearDownMain() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driverThreadLocal.remove(); // Clean up ThreadLocal
        }
    }
}