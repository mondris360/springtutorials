package com.component.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ComponentDao {

    Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ComponentConnection jdbcConnection;


    public ComponentConnection getJdbcConnection() {

        return jdbcConnection;
    }

    public void setJdbcConnection(ComponentConnection jdbcConnection) {

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
