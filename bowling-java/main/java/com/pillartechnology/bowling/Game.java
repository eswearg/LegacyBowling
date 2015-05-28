package com.pillartechnology.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int[] rolls =new int[21];
    private int currentRoll;

    private List<Frame> frames = new ArrayList<>();
    private int currentFrameIndex = 0;

    public Game() {
        for(int i = 0; i < 9; i++) {
            frames.add(new Frame());
        }

        frames.add(new TenthFrame());
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;

        if(getCurrentFrame().isCompleted()) {
            currentFrameIndex++;
        }

        for(int i = 0; i < currentFrameIndex; i++) {
            frames.get(i).onRolled(pins);
        }

        getCurrentFrame().addRoll(pins);
    }

    public int getScore() {
        int score = 0;
        int frameIndex = 0;

        for(int frame = 0; frame < 10; frame++) {

            if(isStrike(rolls[frameIndex])) {
                score += rolls[frameIndex] + getStrikeBonus(frameIndex);
                frameIndex++;
            }
            else if(isSpare(frameIndex)) {
                score += getStandardFrameScore(frameIndex) + getSpareBonus(frameIndex);
                frameIndex += 2;
            }
            else {
                score += getStandardFrameScore(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private int getSpareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int getStrikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int getStandardFrameScore(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    private Frame getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }

    private Frame getPreviousFrame() {
        return frames.get(currentFrameIndex - 1);
    }
}
