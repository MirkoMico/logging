package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    Logger logger= LoggerFactory.getLogger(BasicController.class);
    @Autowired
    private BasicService basicService;
    @Autowired
    private Environment environment;



    @GetMapping("/")
    public String greeting(){
        logger.info("welcome");
        return "greeting";

    }
    @GetMapping("/exp")
    public Integer[] calculation(){
        int n1=Integer.parseInt(environment.getProperty("customEnvs.n1"));
        int n2=Integer.parseInt(environment.getProperty("customEnvs.n2"));

        logger.info("starting calculation");
        Integer[] calcPowerArray=basicService.calculation(n1,n2);

        logger.info("ending calculation");

        return calcPowerArray;
    }

    @GetMapping("/get-errors")
    public void error(){
        logger.error("this is the error");
    }
}