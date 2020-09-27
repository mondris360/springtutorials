package com.spring.framework.master.LearningSpringFrameWork;

import com.CDI.CdiDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.CDI")
public class LearningSpringFrameWorkApplicationCdi {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LearningSpringFrameWorkApplicationCdi.class);

        ApplicationContext applicationContext =  SpringApplication.run(LearningSpringFrameWorkApplicationCdi.class, args);
        CdiDao cdiDao =  applicationContext.getBean(CdiDao.class);

        logger.info("Inside CDI Bean");




    }
}
