package com.mikeabney.pgc.bowling.domain.scoring;

class EmptyFrame extends Frame {
    public static final Frame INSTANCE = new EmptyFrame();

    @Override
    public Frame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new StrikeFrame();
        }
        return new OneRollFrame(Roll.withPinfall(PinCount.TEN, pinfall));
    }

    private EmptyFrame() {
    }
}
