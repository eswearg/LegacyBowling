package com.pillartechnology.bowling;

public class TenthFrame extends Frame {

    @Override
    public boolean isCompleted() {
        return (rolls.size() == 2 && rolls.get(0) + rolls.get(1) < 10)
                || rolls.size() == 3;
    }

    @Override
    public boolean isScorable() {
        return isCompleted();
    }
}