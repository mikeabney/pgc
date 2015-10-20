package com.bud.pgc.calisthenics;

/**
 * Created by Work on 10/20/2015.
 */
public enum Roll {
    GutterBall("0"),
    One("1"),
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Spare("/"),
    Strike("X");

    private final String display;

    private Roll(String string){
        this.display = string;
    }
}
