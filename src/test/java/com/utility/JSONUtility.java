package com.utility;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {

    public static Environment readJSON(Env env){
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
        FileReader fileReader = null;
        Config config = null;
        Environment environment = null;
        try {
            fileReader = new FileReader(jsonFile);
            config = gson.fromJson(fileReader, Config.class);
            environment = config.getEnvironments().get(""+env);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return environment;

    }

}
