package com.calisthenics.bowling;

import com.calisthenics.StringResult;
import com.calisthenics.bowling.states.AskForScoreState;
import com.calisthenics.bowling.states.EnterAnotherPlayerState;
import com.calisthenics.bowling.states.StartGameState;
import com.calisthenics.ioModules.FakeInput;
import com.calisthenics.ioModules.FakeInputFactory;
import com.calisthenics.ioModules.FakeOutput;
import com.calisthenics.ioModules.FakeOutputFactory;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.output.OutputLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class StartGameStateTests {

    private StartGameState state;

    @Before
    public void TestSetup() {
        IOModuleFactory ioFactory = new IOModuleFactory(new FakeInputFactory(), new FakeOutputFactory());
        state = new StartGameState(ioFactory.build(), ioFactory);
    }

    @Test
    public void startingStateShouldDisplayStartGameMessage() {
        StringResult result = FakeOutput.output;
        OutputLine message = StartGameState.MESSAGE;
        assertTrue(result.equals(message.toString()));
    }

    @Test
    public void stateShouldStartAskingForScore() {
        FakeInput.fakeInput = null;
        BowlingState result = state.process();
        Class<AskForScoreState> expectedNewState = AskForScoreState.class;
        assertTrue(expectedNewState.isInstance(result));
    }
}
