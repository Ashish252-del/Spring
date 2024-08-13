package com.spring.examples.h1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XmlConfigurationLauncherApplication {
    public static void main(String[] args) {
        // note resource folder is by default classPath
      try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
      }
    }
}

// note -->  basically as of now we are using java configuration but earlier we were having xml file for
// configuration and the location of file must be in main/java/resources
// after making file you need to search spring xml configuration example in google and need to pick up context schema code
// whatever we define in java we can also define in xml
