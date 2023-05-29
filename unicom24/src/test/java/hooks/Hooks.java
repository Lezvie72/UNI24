package hooks;

import testContext.TestContext;
import base.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;
import properties.BaseProperties;
import util.Browsers;
import util.WebDriverFactory;

import java.io.File;
import java.util.HashMap;

public class Hooks extends Base {


    public static void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    @Before
    public void before(Scenario scenario) {
        System.out.println(scenario.getName());
        System.out.println(scenario.getSourceTagNames());
    }


    @Before
    public void setup() {
        BaseProperties.createDownloadDirURL();
        driver = WebDriverFactory.getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        if (SystemUtils.IS_OS_LINUX) {
            BaseProperties.createDownloadDir();
            deleteAllFilesFolder(BaseProperties.createDownloadDirURL());

        } else {
            BaseProperties.createDownloadDir();
            deleteAllFilesFolder(BaseProperties.createDownloadDirURL());
        }
    }

    public static ChromeOptions chromeOptions() {
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", BaseProperties.createDownloadDirURL());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        return chromeOptions;
    }

    @Before
    public void setUpAssert() {
        sa = new SoftAssert();
    }

    @After
    public void test(){
        sa.assertAll();
        sa = new SoftAssert();
    }

    @After
    public void updateCountOfStart() {
        TestContext.countOfStart = 0;
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
