package ra.hul.tests.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ra.hul.framework.web.driver.DriverManager;

public class BaseWebTest {

    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
