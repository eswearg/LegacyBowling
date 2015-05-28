package com.pillartechnology.bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameTest {
    @Test
    public void getScore_WithGutterGame_Returns0() {
        Game game = new Game();
        for(int i = 0; i < 21; i++) {
            game.roll(0);
        }

        assertThat(game.getScore(), is(0));
    }

    @Test
    public void getScore_WithAllOnes_Returns20() {
        Game game = new Game();
        for(int i = 0; i < 20; i++) {
            game.roll(1);
        }

        assertThat(game.getScore(), is(20));
    }

    @Test
    public void getScore_WithSpare_ReturnsScoreWithSpareBonus() {
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(1);

        assertThat(game.getScore(), is(12));
    }

    @Test
    public void getScore_WithStrike_ReturnsScoreWithStrikeBonus() {
        Game game = new Game();
        game.roll(10);
        game.roll(1);
        game.roll(1);

        assertThat(game.getScore(), is(14));
    }

    @Test
    public void getScore_WithFullGame_ReturnsCorrectScore() {
        Game game = new Game();
        rollFullGame(game);

        assertThat(game.getScore(), is(133));
    }

    @Test
    public void getFrame_WithOneFrameAndTwoRolls_ReturnsCorrectScore() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);

        assertThat(game.getFrames().get(0).getScore(), is("2"));
    }

    @Test
    public void getFrame_WithTwoFramesAndFourRolls_ReturnsCorrectScore() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);

        assertThat(game.getFrames().get(0).getScore(), is("2"));
    }

    @Test
    public void getFrame_WithSpareAndNoFollowupRolls_ReturnsNothing() {
        Game game = new Game();
        game.roll(5);
        game.roll(5);

        assertThat(game.getFrames().get(0).getScore(), is(""));
    }

    @Test
    public void getFrame_WithSpare_ReturnsCorrectScore() {
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(1);

        assertThat(game.getFrames().get(0).getScore(), is("11"));
    }

    @Test
    public void getFrame_WithStrikeAndNoFollowupRolls_ReturnsNothing() {
        Game game = new Game();
        game.roll(10);

        assertThat(game.getFrames().get(0).getScore(), is(""));
    }

    @Test
    public void getFrame_WithStrikeAndOneFollowupRolls_ReturnsNothing() {
        Game game = new Game();
        game.roll(10);
        game.roll(1);

        assertThat(game.getFrames().get(0).getScore(), is(""));
    }

    @Test
    public void getFrame_WithStrike_ReturnsCorrectScore() {
        Game game = new Game();
        game.roll(10);
        game.roll(1);
        game.roll(1);

        assertThat(game.getFrames().get(0).getScore(), is("12"));
    }

    @Test
    public void getFrame_WithTwoStrikes_ReturnsCorrectScore() {
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(1);

        assertThat(game.getFrames().get(0).getScore(), is("21"));
    }

    @Test
    public void getFrame_WithThreeStrikes_ReturnsCorrectScore() {
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertThat(game.getFrames().get(0).getScore(), is("30"));
    }

    @Test
    public void getFrame_WithFullGame_ReturnsCorrectScore() {
        Game game = new Game();
        rollFullGame(game);

        assertThat(game.getFrames().get(0).getScore(), is("5"));
        assertThat(game.getFrames().get(1).getScore(), is("9"));
        assertThat(game.getFrames().get(2).getScore(), is("15"));
        assertThat(game.getFrames().get(3).getScore(), is("20"));
        assertThat(game.getFrames().get(4).getScore(), is("11"));
        assertThat(game.getFrames().get(5).getScore(), is("1"));
        assertThat(game.getFrames().get(6).getScore(), is("16"));
        assertThat(game.getFrames().get(7).getScore(), is("20"));
        assertThat(game.getFrames().get(8).getScore(), is("20"));
        assertThat(game.getFrames().get(9).getScore(), is("16"));
    }

    private void rollFullGame(Game game) {
        game.roll(1); // 1
        game.roll(4);

        game.roll(4); // 2
        game.roll(5);

        game.roll(6); // 3
        game.roll(4);

        game.roll(5); // 4
        game.roll(5);

        game.roll(10); // 5

        game.roll(0); // 6
        game.roll(1);

        game.roll(7); // 7
        game.roll(3);

        game.roll(6); // 8
        game.roll(4);

        game.roll(10); // 9

        game.roll(2); // 10
        game.roll(8);
        game.roll(6);
    }
}