package com.mikeabney.pgc.bowling.domain.scoring;

public interface Frame {
    Frame roll(PinCount pinfall);
    boolean isFull();
}
