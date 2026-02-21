package com.utility;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {


    private LoggerUtility(){

    }

    public static Logger getLogger(Class<?> clazz){

        Logger logger = LogManager.getLogger(clazz);

        return logger;
    }

    

}
