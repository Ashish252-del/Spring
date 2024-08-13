package com.spring.learnSpring.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // spring will create instance of it by itself
//By adding @Component above the MarioGame class definition,
// you're instructing Spring to manage this class as a bean.
// This means Spring will automatically create an instance of
// MarioGame when your application starts up.
@Qualifier("MarioGameQualifier")
public class MarioGame implements GamingConsole{
    public void  up (){
        System.out.println("Jump");
    }
    public void  down (){
        System.out.println("Go into a hole");
    }
    public void  left (){
        System.out.println("Go back");
    }
    public void  right (){
        System.out.println("Accelerate");
    }

}
