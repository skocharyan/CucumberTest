package com.example.endtoendTest.pages;

public interface LoginPageModel {
    boolean geLoginPage();

    void fillInInputsAndClickSignIn();

    boolean validatePage();

    void closePage();

}
