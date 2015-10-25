package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.ArrayList;
import java.util.List;

public class ScoreVisitor {
    private final ScoreRow scoreRow;
    private final List<PinCount> scoreList;

    public ScoreVisitor(ScoreRow scoreRow) {
        this.scoreRow = scoreRow;
        scoreList = new ArrayList<>();
        buildScoreList();
    }

    public List<PinCount> scoreList() {
        return scoreList;
    }

    private void buildScoreList() {
        scoreTenthFrame();
        PinCount tenthFirstRoll = scoreRow.tenthFrameFirstRollPinfall();
        PinCount tenthSecondRoll = scoreRow.tenthFrameSecondRollPinfall();
        scoreRegularFrames(tenthFirstRoll, tenthSecondRoll);
        padScoreList();
    }

    private void padScoreList() {
        for (int index = scoreList.size() ; index < 10 ; index++) {
            scoreList.add(PinCount.EMPTY);
        }
    }

    private void scoreRegularFrames(final PinCount tenthFirstRoll, final PinCount tenthSecondRoll) {
        PinCount nextBall = tenthFirstRoll;
        PinCount secondNextBall = tenthSecondRoll;
        for (int index = scoreRow.list.size() - 1 ; index >= 0 ; index--) {
            RegularFrame currentFrame = scoreRow.list.get(index);
            scoreRegularFrame(currentFrame, nextBall, secondNextBall);
            updateLaterFrames();
            secondNextBall = determineSecondNextBall(currentFrame, nextBall);
            nextBall = determineNextBall(currentFrame);
        }
    }

    private void updateLaterFrames() {
        if (!scoreList.isEmpty()) {
            PinCount firstScore = scoreList.get(0);
            updateLaterFrames(firstScore);
        }
    }

    private void updateLaterFrames(PinCount firstScore) {
        for (int index = 1; index < scoreList.size(); index++) {
            PinCount updatedScore = scoreList.get(index).plus(firstScore);
            scoreList.remove(index);
            scoreList.add(index, updatedScore);
        }
    }

    private PinCount determineNextBall(RegularFrame currentFrame) {
        return currentFrame.firstRollPinfall();
    }

    private PinCount determineSecondNextBall(RegularFrame currentFrame, PinCount nextBall) {
        return currentFrame.isStrike() ? nextBall : currentFrame.secondRollPinfall();
    }

    private void scoreRegularFrame(RegularFrame frame, PinCount nextBall, PinCount secondNextBall) {
        PinCount singleFrameScore = frame.singleFrameScore(nextBall, secondNextBall);
        if (!PinCount.EMPTY.equals(singleFrameScore)) {
            scoreList.add(0, singleFrameScore);
        }
    }

    private void scoreTenthFrame() {
        TenthFrame frame = scoreRow.tenthFrame;
        if (frame.isFull()) {
            scoreList.add(frame.singleFrameScore());
        }
    }
}
