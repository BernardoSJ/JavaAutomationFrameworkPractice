package com.ui.dataproviders;

import com.google.gson.Gson;

import java.io.File;

public class LoginDataProvider {

    public void loginDataProvider(){
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "\\testData\\loginData.json");
    }

}
