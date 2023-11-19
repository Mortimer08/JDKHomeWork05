package org.example;

import org.example.stage.Door;

import java.util.Random;
/**
 * Class Gamer has decision - number of chosen door
 * Random uses to make decision
 */
public class Gamer {

    private int decision;
    private final Random rnd = new Random();

    /**
     * Constructor set decision without of doors numbers
     */
    public Gamer() {
        decision = -1;
    }

    /**
     * Method chooses number of door.
     * In case at least one door is opened calls change decision
     * @param doors to make choice between them
     */
    public void makeDecision(Door[] doors) {
        boolean isAnyDoorOpened = false;
        for (Door door : doors) {
            if (door.isOpened()) {
                isAnyDoorOpened = true;
                break;
            }
        }
        if (isAnyDoorOpened) {
            changeDecision(doors);
        } else {
            decision = rnd.nextInt(doors.length);
        }
    }

    /**
     * Method changes decision, means chooses different unopened door
     *
     * @param doors to change decision
     *
     */
    private void changeDecision(Door[] doors) {

        for (int i = 0; i < doors.length; i++) {
            if (!doors[i].isOpened() && i != decision) {
                decision = i;
                return;
            }
        }
    }

    /**
     *
     * @return number of chosen door
     */
    public int getDecision() {
        return decision;
    }
}

