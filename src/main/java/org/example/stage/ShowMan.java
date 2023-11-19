package org.example.stage;

import org.example.Gamer;
import org.example.ui.ConsoleUI;
import org.example.ui.HiddenUI;
import org.example.ui.UI;

import java.util.Random;

/**
 * Class ShowMan has some doors
 * Quantity of doors defined by DOORS_QUANTITY
 *
 */
public class ShowMan {
    private final int DOORS_QUANTITY = 5;
    private final Door[] doors = new Door[DOORS_QUANTITY];
    private boolean gameOver;
    private boolean gamerWon;
    private int doorWithPrize;
    private final Random rnd = new Random();
    private Gamer gamer;
    private final UI ui;

    /**
     * Constructor defines whether show man will be print messages in console (ConsoleUI)
     * or not (HiddenUI)
     */
    public ShowMan() {
        this.ui = new HiddenUI(this);
    }

    /**
     * @return true if Gamer won the game
     */
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

    /**
     * Initialization of game.
     * Create new Gamer
     * Set flags gamerWon, gameOver
     * Create doors and place a prize
     */
    public void initGame() {
        gamer = new Gamer();
        gamerWon = false;
        gameOver = false;
        int happyDoorNumber = rnd.nextInt(3);
        for (int i = 0; i < DOORS_QUANTITY; i++) {
            doors[i] = new Door();
            if (i == happyDoorNumber) {
                doorWithPrize = i;
                doors[i].putPrize();
            }
        }
    }

    /**
     * Make gamer to choose the door
     * @param doors is doors in game
     */
    public void getGamerChoice(Door[] doors) {
        gamer.makeDecision(doors);
    }

    /**
     * Opening the door
     * @return number of door to open
     */
    public int openDoor() {
        int doorToOpenNumber = getDoorToOpenNumber();
        doors[doorToOpenNumber].setOpened();
        return doorToOpenNumber;
    }

    /**
     * Choosing number of door to open
     * @return number of door to open
     */
    public int getDoorToOpenNumber() {
        int doorToOpenNumber = -1;
        for (int i = 0; i < doors.length; i++) {
            // chooses a door which is not opened, not chosen by gamer and not had a prize behind it
            if (!doors[i].isOpened() && i != getGamerDecision()) {
                if (!doors[i].isWithPrise()) {
                    doorToOpenNumber = i;
                }
            }
        }
        if (doorToOpenNumber < 0) {
            doorToOpenNumber = doorWithPrize;
        }
        return doorToOpenNumber;
    }

    /**
     * Checking if the game is over
     */
    public void checkIfGameOver() {
        int openedDoorsCount = 0;
        for (Door door : doors) {
            if (door.isOpened()) {
                openedDoorsCount++;
            }
        }
        // The game is over if there is just one door unopened
        gameOver = ((doors.length - openedDoorsCount) == 1);
    }

    /**
     * Checking if the gamer won
     */
    public void checkIfGamerWon() {
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isWithPrise() && i == gamer.getDecision()) {
                gamerWon = true;
                return;
            }
        }
        gamerWon = false;
    }

    /**
     *
     * @return doors
     */
    public Door[] getDoors() {
        return doors;
    }

    /**
     * Checking if the door has a prize.
     * return proper result only in a UI
     * @param ui user interface
     * @param door which need to be checked
     * @return true if there is a prize behind the door
     */
    public boolean isDoorWithPrise(UI ui, Door door) {
        if (this.ui.equals(ui)) {
            return door.isWithPrise();
        }
        return false;
    }

    /**
     * Get number of door, chosen by gamer
     * @return number of door, chosen by gamer
     */
    public int getGamerDecision() {
        return gamer.getDecision();
    }
}
