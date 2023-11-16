package org.example.stage;

import org.example.Gamer;

import java.util.Random;

public class ShowMan {
    private final int DOORS_QUANTITY = 3;
    private Door[] doors = new Door[DOORS_QUANTITY];
    private boolean gameOver;
    private final Random rnd = new Random();
    private Gamer gamer;

    public void startGame() {
        gamer = new Gamer();
        initGame();
        while (!gameOver) {
            getGamerChoice(doors);
            openDoor();
            checkIfGameOver();
        }
    }

    public void initGame() {
        int happyDoorNumber = rnd.nextInt(3);
        for (int i = 0; i < DOORS_QUANTITY; i++) {
            if (i == happyDoorNumber) {
                doors[i].putPrize();
            }
        }
        System.out.println("The game started");

    }

    public void getGamerChoice(Door[] doors) {
        gamer.makeDecision(doors);
    }

    public void openDoor() {
        for (int i = 0; i < doors.length; i++) {
            if (!doors[i].isWithPrise() && i != gamer.getDecision()) {
                doors[i].setOpened();
                System.out.println("ShowMan open the door number" + i);
                return;
            }
        }
    }

    public void checkIfGameOver() {
        int openedDoors = 0;
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isOpened()) {
                openedDoors++;
            }
        }
        gameOver = (doors.length - openedDoors) == 1;
    }
}
