package endtoendTest;

import com.example.endtoendTest.enums.BrowserEnum;
import com.example.endtoendTest.pages.LoginPageModelImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginPageTest {
   private Logger logger;
   private LoginPageModelImpl loginPageModel;

    @BeforeClass
    public void beforeClass() throws IOException {
         logger = LogManager.getLogger(LoginPageTest.class);
         loginPageModel = new LoginPageModelImpl();
         loginPageModel.setBrowserName(BrowserEnum.CHROME);

    }
    @Test
    public void getLoginPage(){
      Boolean s =   loginPageModel.geLoginPage();
        Assert.assertTrue(s);
    }
    @Test(dependsOnMethods = "getLoginPage")
    public void fillInUsernameAnsPassword(){
        loginPageModel.fillInInputsAndClickSignIn();
    }
    @Test(dependsOnMethods = "fillInUsernameAnsPassword")
    public void validateUserCabinetPage(){
        loginPageModel.validatePage();
    }
    @AfterClass
    public void afterClass(){
        loginPageModel.closePage();
    }



}
