package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.ScoreRow;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;

import java.util.List;
import java.util.stream.Stream;

public class ScoresheetRow {
    private final Name name;
    private final ScoreRow scoreRow;

    public ScoresheetRow(Name name) {
        this(name, ScoreRow.EMPTY);
    }

    private ScoresheetRow(Name name, ScoreRow scoreRow) {
        this.name = name;
        this.scoreRow = scoreRow;
    }

    public String printName() {
        return name.print();
    }

    public ScoresheetRow roll(PinCount pinCount) {
        return new ScoresheetRow(name, scoreRow.roll(pinCount));
    }

    public Stream<RegularFrame> regularFrames() {
        return scoreRow.regularFrames();
    }

    public TenthFrame tenthFrame() {
        return scoreRow.tenthFrame();
    }

    public List<PinCount> frameScores() {
        return scoreRow.frameScores();
    }
}
