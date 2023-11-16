package org.example.stage.ui;

import org.example.stage.ShowMan;

public class ConsoleUI implements UI {
    ShowMan showMan;

    public ConsoleUI(ShowMan showMan) {
        this.showMan = showMan;

    }

    @Override
    public void showDoors() {
        printDoors();
    }

    @Override
    public void showGamerChoice() {
        System.out.println("Gamer choose door number " + showMan.getGamerDecision());
    }

    @Override
    public void showShowManAction(int openedDoorNumber) {
        System.out.println("ShowMan opened door number " + openedDoorNumber);
    }

    @Override
    public void gamerWonMessage() {
        System.out.println("Gamer won!");
    }

    @Override
    public void gamerLostMessage() {
        System.out.println("Gamer lost");
    }

    public void printDoors() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < showMan.getDoors().length; i++) {
            sb.append("is ");

            if (showMan.getDoors()[i].isOpened()) {
                sb.append("opened");
            } else sb.append("closed");
            sb.append("; there is ");
            if (showMan.isDoorWithPrise(this, showMan.getDoors()[i])) {
                sb.append("a PRIZE");
            } else sb.append("nothing");
            System.out.printf("Door %d %s behind it\n", i, sb.toString());
            sb.delete(0, sb.length());
        }
    }

}
