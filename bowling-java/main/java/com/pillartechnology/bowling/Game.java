package com.pillartechnology.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();
    private int currentFrameIndex = 0;

    public Game() {
        for(int i = 0; i < 9; i++) {
            frames.add(new Frame());
        }

        frames.add(new TenthFrame());
    }

    public void roll(int pins) {
        getCurrentFrame().addRoll(pins);

        for(int i = 0; i < currentFrameIndex; i++) {
            frames.get(i).onRolled(pins);
        }

        if(getCurrentFrame().isCompleted()) {
            currentFrameIndex++;
        }
    }

    public int getScore() {
        int score = 0;

        for(Frame frame : frames) {
            Integer frameScore = frame.getScore();
            if(frameScore != null) {
                score += frameScore;
            }
        }

        return score;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    private Frame getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }
}
