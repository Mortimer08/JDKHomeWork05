package org.example.stage;

import java.util.HashMap;

public class Door {
    private boolean opened;
    private boolean withPrize;
    private int doorStatus;


    protected void putPrize() {
        withPrize = true;
    }

    protected boolean isWithPrise() {
        return withPrize;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened() {
        opened = true;
    }


}
