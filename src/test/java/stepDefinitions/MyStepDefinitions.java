package stepDefinitions;

import com.example.endtoendTest.pages.LoginPageModelImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
public class MyStepDefinitions {
    LoginPageModelImpl loginPageModel = new LoginPageModelImpl();



    public MyStepDefinitions() throws IOException {
    }

    @Given("^on login page$")
    public void on_login_page() throws Throwable {
        loginPageModel.geLoginPage();
    }

    @When("^fill in use name \"([^\"]*)\" and password \"([^\"]*)\" and click Sign in$")
    public void fill_in_use_name_something_and_password_something_and_click_sign_in(String strArg1, String strArg2) throws Throwable {
        loginPageModel.fillInInputsAndClickSignIn();
    }

    @Then("^validate cabinet name wih \"([^\"]*)\"$")
    public void validate_cabinet_name_wih_something(String strArg1) throws Throwable {
        loginPageModel.validatePage(strArg1);
        loginPageModel.closePage();
    }

}