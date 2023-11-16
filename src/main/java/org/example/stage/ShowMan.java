package org.example.stage;

import org.example.Gamer;
import org.example.stage.ui.ConsoleUI;
import org.example.stage.ui.HiddenUI;
import org.example.stage.ui.UI;

import java.util.Random;

public class ShowMan {
    private final int DOORS_QUANTITY = 3;
    private Door[] doors = new Door[DOORS_QUANTITY];
    private boolean gameOver;
    private boolean gamerWon;
    private int doorWithPrize;
    private final Random rnd = new Random();
    private Gamer gamer;
    private UI ui;

    public ShowMan() {
        this.ui = new HiddenUI(this);
    }

    public boolean startGame() {

        initGame();
        while (!gameOver) {
            ui.showDoors();
            getGamerChoice(doors);
            ui.showGamerChoice();

            ui.showShowManAction(openDoor());
            checkIfGameOver();
            checkIfGamerWon();
        }

        if (gamerWon) {
            ui.gamerWonMessage();
        } else ui.gamerLostMessage();
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
    }

    public void getGamerChoice(Door[] doors) {
        gamer.makeDecision(doors);
    }

    public int openDoor() {
        int doorToOpenNumber = getDoorToOpenNumber();
        doors[doorToOpenNumber].setOpened();
        return doorToOpenNumber;
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
        int openedDoorsCount = 0;
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isOpened()) {
                openedDoorsCount++;
            }
        }
        gameOver = ((doors.length - openedDoorsCount) == 1);
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

    public Door[] getDoors() {
        return doors;
    }

    public boolean isDoorWithPrise(UI ui, Door door) {
        if (this.ui.equals(ui)) {
            return door.isWithPrise();
        }
        return false;
    }

    public int getGamerDecision() {
        return gamer.getDecision();
    }
}
