package com.spring.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private  SomeDependency someDependency ;
    public  SomeClass (SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready ");
    }
    @PostConstruct // so when we have to initialize something just after the dependency injection means
    // when we start application it does dependency injection first just after that we need some initialization then we need to use this
    public  void initialize () {
        someDependency.getReady();
    }
    @PreDestroy // if you want to clean up just before application close or like just before
   // beans to be removed from the IOC container it is typically use for resource close
    // in our case when program ends then Spring begins the shutdown process and will remove beans
    public  void cleanUp () {
        System.out.println("Cleaning up things .......");
    }
}

@Component
class SomeDependency {
    void getReady () {
        System.out.println("Getting ready buddy!!!!!");
    }

}
@Configuration
@ComponentScan // by default if you do not provide any package name then it will scan components of current package
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args) {
      try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
          System.out.println("hello testing    =======");
      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it
