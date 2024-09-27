package com.spring.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// As we know by default it is eager initialization which means when we run this file first it will initialise the beans
// it means Some initialization logic will print at the top

// now if we use Lazy annotation then in such case beans will be load only when if that is used
// means if we call that bean then only that will be load
@Component
class ClassA{

}

@Component
@Lazy
class CLassB {
   private ClassA classA;
   public CLassB (ClassA classA){
       // logic constructor injections
       System.out.println("Some initialization logic");
       this.classA = classA;
   }
   void doSomething(){
       System.out.println("yes yes I am doing man ");
   }
}

@Configuration
@ComponentScan // by default if you do not provide any package name then it will scan components of current package
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
      try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
          System.out.println("Beans initializations are done ---");
          context.getBean(CLassB.class).doSomething();
      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it
