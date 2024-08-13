package com.spring.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class yourBusinessClass{
    // 1--> Field injection
    // now for field dependency injection we just need to use annotation
   // @Autowired --> spring is doing by itself dependency1 = new Dependency1();
    Dependency1 dependency1;
   // @Autowired
    Dependency2 dependency2;


    //2--> Constructor injection
    // for constructor injection event you don't need to use annotation
    public  yourBusinessClass (Dependency1 d1 , Dependency2 d2) {
        System.out.println("yourBusinessClass dependency injection ");
        this.dependency1 = d1;
        this.dependency2 = d2;
    }

    // 3--> setter injection
    // you need to make setter and need to use annotation for dependency injection
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }
}

@Component
class Dependency1{}
@Component
class Dependency2{}



@Configuration
@ComponentScan // by default if you do not provide any package name then it will scan components of current package
public class DependencyInjectionLauncherApplication {
    public static void main(String[] args) {
      try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it
