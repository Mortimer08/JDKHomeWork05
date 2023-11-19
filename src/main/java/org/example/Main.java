package org.example;

import org.example.stage.ShowMan;

public class Main {
    public static void main(String[] args) {
        ShowMan showMan = new ShowMan();
        int gamerVictoryCounter = 0;
        int attempts = 1000;
        for (int i = 0; i < attempts; i++) {
            if (showMan.startGame()) {
                gamerVictoryCounter++;
            }
        }
        System.out.printf("Gamer won %d times from %d (%d%%)",
                gamerVictoryCounter, attempts, (gamerVictoryCounter * 100 / attempts));
        System.out.println();
    }
}