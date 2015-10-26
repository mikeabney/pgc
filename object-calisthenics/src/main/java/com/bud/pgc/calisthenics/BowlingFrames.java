package com.bud.pgc.calisthenics;

/**
 * Created by Work on 10/20/2015.
 */
public class BowlingFrames {

    private final Frame[] frames;

    public BowlingFrames(){
        frames = new Frame[10];
    }

    public String displayRolls() {
        return "";
    }

    public FrameResult addRoll(Pins pins) {
        if(this.currentFrame() == 10){

        }
    }

    private int currentFrame() {
        return 0;
    }
}
