package com.pillartechnology.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    protected List<Integer> rolls = new ArrayList<>();

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    public String getScore() {
        int score = 0;

        for(Integer roll : rolls) {
            score += roll;
        }

        return Integer.toString(score);
    }

    public boolean isCompleted() {
        return rolls.size() == 2;
    }
}
