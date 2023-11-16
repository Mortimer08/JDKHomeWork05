package org.example;

import org.example.stage.Door;

import java.util.Random;

public class Gamer {
    private int decision;
    Random rnd = new Random();

    public int makeDecision(Door[] doors) {
        boolean isAnyDoorOpened = false;
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isOpened()) {
                isAnyDoorOpened = true;
                break;
            }
        }
        if (isAnyDoorOpened) {
            changeDecision(doors);
        } else {
            decision = rnd.nextInt(doors.length);
        }
        return decision;
    }

    private void changeDecision(Door[] doors) {
        System.out.println("Gamer changes decision: " + getDecision());

        for (int i = 0; i < doors.length; i++) {
            if (!doors[i].isOpened() && i != decision) {
                decision = i;
                return;
            }
        }
        System.out.println("to: " + getDecision());
    }

    ;

    public int getDecision() {
        return decision;
    }
}
