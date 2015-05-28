package com.pillartechnology.bowling;

public class TenthFrame extends Frame {

    @Override
    public boolean isCompleted() {
        return rolls.size() == 3;
    }
}
