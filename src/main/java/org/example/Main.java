package org.example;

import org.example.stage.ShowMan;

public class Main {
    public static void main(String[] args) {
        int attempts = 1000000;
        int gamerVictoryCount = 0;
        ShowMan showMan = new ShowMan();
        for (int i = 0; i < attempts; i++) {

            if (showMan.startGame()) {
                gamerVictoryCount++;
            }
            ;
        }
        System.out.printf("Gamer won %d times from %d\n", gamerVictoryCount, gamerVictoryCount);
    }
}