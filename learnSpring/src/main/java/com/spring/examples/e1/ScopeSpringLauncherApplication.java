package com.spring.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// As we know by default it is eager initialization which means when we run this file first it will initialise the beans
// it means Some initialization logic will print at the top

// now if we use Lazy annotation then in such case beans will be load only when if that is used
// means if we call that bean then only that will be load
@Component // it is singleton scope means where we call it spring will give same instance
class Normal{

}

@Component // Prototype scope means whenever we call spring will give everytime new instance
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Prototype {

}

@Configuration
@ComponentScan // by default if you do not provide any package name then it will scan components of current package
public class ScopeSpringLauncherApplication {
    public static void main(String[] args) {
      try(var context = new AnnotationConfigApplicationContext(ScopeSpringLauncherApplication.class)){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
          // you will be able to see same hashcode for both print of Normal and different hashcode of both
          // print of Prototype 
          System.out.println(context.getBean(Normal.class));
          System.out.println(context.getBean(Normal.class));
          System.out.println(context.getBean(Prototype.class));
          System.out.println(context.getBean(Prototype.class));

      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it
