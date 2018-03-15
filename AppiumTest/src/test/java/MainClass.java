import io.appium.java_client.MobileElement;
import com.google.common.annotations.VisibleForTesting;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Capabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
/*Changes for appcenter */
import java.util.List;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.http.HttpClient;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class MainClass {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedIOSDriver<MobileElement> driver;

    @Before
    public void setup () throws MalformedURLException{

        System.out.println("Setting up capabilities");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","iPhone Simulator");
        cap.setCapability("app", "/Users/darrystonem/Downloads/TESTALBA/AlbaDevelop/CalSmoke-cal.ipa");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("platformVersion", "11.2");
        /*driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);*/
        /*Changes for appcenter */
        driver = Factory.createIOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        /*Changes for appcenter */
    }
    @After
    public void teardown() {
        /*Changes for appcenter */
        driver.label("Stopping App");
        /*Changes for appcenter */
        System.out.println("Finishing test");
        driver.quit();
    }

    @Test
    public void SimpleTest() throws IOException, InterruptedException {

        System.out.println("Starting test");

        driver.findElementByAccessibilityId("text").sendKeys("Nombre Apellido");
    }
}