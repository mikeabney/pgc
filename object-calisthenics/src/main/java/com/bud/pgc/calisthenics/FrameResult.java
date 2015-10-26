package com.bud.pgc.calisthenics;

/**
 * Created by Bud on 10/20/2015.
 */
public enum FrameResult {
    Incomplete(false),
    Complete(true);

    private final boolean complete;

    private FrameResult(boolean complete){
        this.complete = complete;
    }

    public boolean isComplete(){
        return complete;
    }
}
