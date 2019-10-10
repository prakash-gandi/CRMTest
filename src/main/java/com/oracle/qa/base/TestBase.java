package com.oracle.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;
   public static Properties prop;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream fileis = new FileInputStream("\\CRMTest\\src\\main\\java\\com\\oracle\\qa\\config\\config.properties");
            prop.load(fileis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "\\CRMTest\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\CRMTest\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
