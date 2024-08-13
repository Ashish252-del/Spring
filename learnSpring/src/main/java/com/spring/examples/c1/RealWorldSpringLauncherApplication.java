package com.spring.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan // by default if you do not provide any package name then it will scan components of current package
public class RealWorldSpringLauncherApplication {
    public static void main(String[] args) {
      try(var context = new AnnotationConfigApplicationContext(RealWorldSpringLauncherApplication.class)){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
          System.out.println(context.getBean(BusinessCalculationService.class).findmax());

      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it
