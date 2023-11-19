package org.example.stage;

import java.util.HashMap;

/**
 * Class door has properties opened, with prize
 */
public class Door {
    private boolean opened;
    private boolean withPrize;

    /**
     * Put a prize behind a door
     */
    protected void putPrize() {
        withPrize = true;
    }

    /**
     *
     * @return true if the door has a prize
     */
    protected boolean isWithPrise() {
        return withPrize;
    }

    /**
     *
     * @return true if the door is opened
     */
    public boolean isOpened() {
        return opened;
    }

    /**
     * Make door opened
     */
    public void setOpened() {
        opened = true;
    }


}
