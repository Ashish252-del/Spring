package com.spring.learnSpring.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // making it as component not spring will create instance of it's by itself
// now since we have make it as component hence spring will look for a implementation of
public class GameRunner {
    // initially it was tightly coupled we are making it loosely coupled using interface GamingConsole
    // interface for autowiring now let say there is two classes which implements GamingConsole
    // int such situation spring will confuse which on to use hence we need to add annotation primary to give priority to one
    // or use can use qualifier annotation as well for giving priority to specific ones

    GamingConsole game;
    public GameRunner(@Qualifier("MarioGameQualifier") // it is constructor base dependencies injection
                      GamingConsole game) {
        this.game = game;
   }
    public void run() {
        System.out.println("game is running -----"+ game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
