package com.spring.learnSpring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.spring.learnSpring.game") // here we need to pass the package of components
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
      try(var contest = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
          // here spring will look for class which have implemented GamingConsole
          // If more than one classes are implemented then it will look for annotation Primary and Qualifier
          // here since we have two implementations and SuperContra is primary that's why that will be called
         contest.getBean(GamingConsole.class).down();
         // to call mario we can specify the Qualifier
          contest.getBean("marioGame", GamingConsole.class).down();
          contest.getBean(GameRunner.class).run();
      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it

//Spring will scan the com.spring.learnSpring.game package.
//It will register any class annotated with @Component (or related annotations like @Service, @Repository, etc.) as a bean.
//        Beans for GamingConsole and GameRunner will be created (assuming they are annotated with @Component in that package).
//These beans will then be retrieved and used in the main method.