package com.spring.framework.master.LearningSpringFrameWork;

import com.spring.framework.master.LearningSpringFrameWork.Scope.PersonDAO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class LearningSpringFrameWorkApplicationScope {
        // creating a logger to display logs  instead of always using system.out.println()
    private static Logger LOGGER = LoggerFactory.getLogger(LearningSpringFrameWorkApplicationScope.class);

    public static void main(String[] args) {
        ApplicationContext  applicationContext =  SpringApplication.run(LearningSpringFrameWorkApplicationScope.class, args);

        PersonDAO personDAO1 =  applicationContext.getBean(PersonDAO.class);
        PersonDAO personDAO2 =  applicationContext.getBean(PersonDAO.class);

        // print out object log
//        LOGGER.info("{}", personDAO1);
//        // log the JDBC Connection  object
//        LOGGER.info("{}", personDAO1.getJdbcConnection());
//
//        LOGGER.info("{}", personDAO2);
//        // log the JDBC Connection  object
//        LOGGER.info("{}", personDAO2.getJdbcConnection());
        System.out.println("===========================");
        System.out.println(personDAO1);
        System.out.println(personDAO1.getJdbcConnection());
        System.out.println("============================");

        System.out.println("===========================");
        System.out.println(personDAO2);
        System.out.println(personDAO2.getJdbcConnection());
        System.out.println("============================");

    }
}
