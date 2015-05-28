package com.pillartechnology.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    protected List<Integer> rolls = new ArrayList<>();
    private List<Integer> bonuses = new ArrayList<>();

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    public String getScore() {
        if(!isCompleted())
            return "";

        int score = 0;

        for(Integer roll : rolls) {
            score += roll;
        }

        return Integer.toString(score + getBonus());
    }

    public void onRolled(int pins) {
        if(!isScorable()) {
            bonuses.add(pins);
        }
    }

    private int getBonus() {
        int score = 0;

        for(Integer bonus : bonuses) {
            score += bonus;
        }

        return score;
    }

    public boolean isCompleted() {
        return isStrike() || rolls.size() == 2;
    }

    public boolean isScorable() {
        return (rolls.size() == 2 && rolls.get(0) + rolls.get(1) < 10)
                || ((isSpare() && bonuses.size() == 1))
                || ((isStrike() && bonuses.size() == 2));
    }

    public boolean isSpare() {
        return rolls.size() == 2 && rolls.get(0) + rolls.get(1) == 10;
    }

    public boolean isStrike() {
        return rolls.size() == 1 && rolls.get(0) == 10;
    }
}
