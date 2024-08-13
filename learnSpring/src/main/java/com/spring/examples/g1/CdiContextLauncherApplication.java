package com.spring.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// we need to add cdi dependency in pom file for using the cdi annotation
//@Component
@Named
class BusinessService {
    private  DataService dataService;

    public DataService getDataService() {
        return dataService;
    }
   // @Autowired
    @Inject
    public  void setDataService (DataService dataService) {
        System.out.println("Performing Injection");
        this.dataService = dataService;
    }
}
//@Component
@Named
class DataService {

}
@Configuration
@ComponentScan // by default if you do not provide any package name then it will scan components of current package
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
      try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
          System.out.println(context.getBean(BusinessService.class).getDataService());
      }
    }
}

