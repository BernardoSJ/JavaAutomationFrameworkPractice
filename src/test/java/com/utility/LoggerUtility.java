package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger;

    private LoggerUtility(){

    }

    public void getLogger(Class<?> clazz){
        logger = LogManager.getLogger(clazz);
    }

    

}
