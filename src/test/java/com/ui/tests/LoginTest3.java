package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;

public class LoginTest3 {

    public static void main(String[] args){
        HomePage homePage = new HomePage(Browser.EDGE);
        String userName = homePage.goToLoginPage().doLoginWith("repano2553@hopesx.com", "password").getUserName();
        System.out.println(userName);
    }

}
