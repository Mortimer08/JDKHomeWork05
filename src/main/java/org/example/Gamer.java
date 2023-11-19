package org.example;

import org.example.stage.Door;

import java.util.Random;

public class Gamer {
    private int decision;
    private final Random rnd = new Random();

    public Gamer() {
        decision = -1;
    }

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

    private void changeDecision(Door[] doors) {

        for (int i = 0; i < doors.length; i++) {
            if (!doors[i].isOpened() && i != decision) {
                decision = i;
                return;
            }
        }
    }


    public int getDecision() {
        return decision;
    }
}
