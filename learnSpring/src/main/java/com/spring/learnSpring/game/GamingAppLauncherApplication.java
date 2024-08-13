package com.spring.learnSpring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.spring.learnSpring.game") // here we need to pass the package of components
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
      try(var contest = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
         contest.getBean(GamingConsole.class).down();
         contest.getBean(GameRunner.class).run();
      }
    }
}

// note --> here spring comes in picture in a project you may have multiple objects and dependencies to
// for wiring , so basically spring do it by himself object creation and dependencies injection you do not need to worry about it
