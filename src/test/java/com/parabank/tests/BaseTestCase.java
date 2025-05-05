package com.parabank.tests;


import com.google.common.collect.ImmutableMap;
import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.OpenAccountPage;
import com.parabank.pages.RegisterPage;
import com.parabank.pages.TransferFundsPage;
import com.parabank.utilities.TestExecutionListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Listeners(TestExecutionListener.class)
public class BaseTestCase extends BaseTest {
    private static int testCount = 0;
    private static final int RESTART_THRESHOLD = 5;

    public OpenAccountPage openAccountPage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public TransferFundsPage transferFundsPage;


    @BeforeSuite
    public void setAllureEnvironment() {
        String env = System.getProperty("Environment");
        String URL = "";

        if (env != null) {


            if (env.equalsIgnoreCase("Dev")) {
                URL = properties.getProperty("devurl");

            } else if (env.equalsIgnoreCase("Uat")) {
                URL = properties.getProperty("uaturl");
            }

        } else {
            URL = properties.getProperty("url");
        }

        String osName = System.getProperty("os.name").toLowerCase();

        System.out.println("osname" + osName);
        String userName = osName.contains("windows") ? System.getProperty("user.name") : System.getenv("GITLAB_USER_NAME");

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("OS", System.getProperty("os.name").toLowerCase())
                        .put("URL", URL).put("User", userName)
                        .build());
    }


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        if (testCount % RESTART_THRESHOLD == 0) {
            tearDownMain();
            System.out.println("No of browsers open" + RESTART_THRESHOLD);
        }

        initialization();


        loginPage = new LoginPage(driverThreadLocal.get());
        openAccountPage = new OpenAccountPage(driverThreadLocal.get());
        registerPage=new RegisterPage(driverThreadLocal.get());
        transferFundsPage=new TransferFundsPage(driverThreadLocal.get());
        testCount++;

    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        tearDownMain();

    }


}
