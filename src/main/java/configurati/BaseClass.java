package configurati;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void create() {
        driver = DriverFactory.greateDriver(WEBDRIVERS.CHROMECLEAN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public static void end() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
