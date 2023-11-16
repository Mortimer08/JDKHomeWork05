package org.example.stage;

import org.example.Gamer;

import java.util.Random;

public class ShowMan {
    private final int DOORS_QUANTITY = 3;
    private Door[] doors = new Door[DOORS_QUANTITY];
    private boolean gameOver;
    private boolean gamerWon;
    private int doorWithPrize;
    private final Random rnd = new Random();
    private Gamer gamer;

    public boolean startGame() {

        initGame();
        while (!gameOver) {
            showDoors();
            getGamerChoice(doors);
//            System.out.println("Gamer choose door number " + gamer.getDecision());
            openDoor();
            checkIfGameOver();
            checkIfGamerWon();
        }

        /*if (gamerWon) {
            System.out.println("Gamer won!");
        } else System.out.println("Gamer lost");*/
        return gamerWon;
    }

    public void initGame() {
        gamer = new Gamer();
        int happyDoorNumber = rnd.nextInt(3);
        for (int i = 0; i < DOORS_QUANTITY; i++) {
            doors[i] = new Door();
            if (i == happyDoorNumber) {
                doorWithPrize = i;
                doors[i].putPrize();
            }
        }
//        System.out.println("The game started");
    }

    public void getGamerChoice(Door[] doors) {
        gamer.makeDecision(doors);
    }

    public void openDoor() {
        int doorToOpenNumber = getDoorToOpenNumber();
        doors[doorToOpenNumber].setOpened();
//        System.out.println("ShowMan opened door number " + doorToOpenNumber);
    }

    public int getDoorToOpenNumber() {
        int doorToOpenNumber = -1;
        for (int i = 0; i < doors.length; i++) {
            if (!doors[i].isOpened()) {
                if (!doors[i].isWithPrise()) {
                    doorToOpenNumber = i;
                }
            }
        }
        if (doorToOpenNumber < 0) {
            doorToOpenNumber = doorWithPrize;
        }
        ;
        return doorToOpenNumber;
    }

    public void checkIfGameOver() {
        for (int i = 0; i < doors.length; i++) {
            if (!doors[i].isOpened()) {
                gameOver = false;
                return;
            }
        }
        gameOver = true;
    }

    public void checkIfGamerWon() {
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isWithPrise() && i == gamer.getDecision()) {
                gamerWon = true;
                return;
            }
        }
        gamerWon = false;
    }

    public void showDoors() {
        /*StringBuilder sb = new StringBuilder();

        for (int i = 0; i < doors.length; i++) {
            sb.append("is ");

            if (doors[i].isOpened()) {
                sb.append("opened");
            } else sb.append("closed");
            sb.append("; there is ");
            if (doors[i].isWithPrise()) {
                sb.append("a PRIZE");
            } else sb.append("nothing");
            System.out.printf("Door %d %s behind it\n", i, sb.toString());
            sb.delete(0, sb.length());
        }*/
    }
}
