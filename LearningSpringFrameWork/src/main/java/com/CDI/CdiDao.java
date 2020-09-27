package com.CDI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CdiDao {

    Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Inject
    CdiConnection jdbcConnection;


    public CdiConnection getJdbcConnection() {

        return jdbcConnection;
    }

    public void setJdbcConnection(CdiConnection jdbcConnection) {

        this.jdbcConnection = jdbcConnection;
    }

    // execute this method immediately once the constructor has been created and all its dependencies has been autowired

    @PostConstruct
    public void postConstruct(){
        logger.info("Inside Post construct");
    }


    // before you destroy this created bean, execute the following method
    @PreDestroy
    public  void preDestroy(){
        logger.info("Cleaning  all the necessary stuff of the bean before destroying it");
    }
}
