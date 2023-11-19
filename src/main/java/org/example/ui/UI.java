package org.example.ui;

/**
 * Uses by Show Man to print messages
 */
public interface UI {
    void showDoors();

    void showGamerChoice();

    void showShowManAction(int openedDoorNumber);

    void gamerWonMessage();

    void gamerLostMessage();
}
