package com.calisthenics.bowling;

import com.calisthenics.StringResult;
import com.calisthenics.bowling.states.EnterAnotherPlayerState;
import com.calisthenics.bowling.states.EnterFirstPlayerState;
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
public class EnterAnotherPlayerStateTests {

    private EnterAnotherPlayerState state;

    @Before
    public void TestSetup() {
        IOModuleFactory ioFactory = new IOModuleFactory(new FakeInputFactory(), new FakeOutputFactory());
        state = new EnterAnotherPlayerState(ioFactory.build(), ioFactory);
    }

    @Test
    public void startingStateShouldAskForPlayerName() {
        StringResult result = FakeOutput.output;
        OutputLine message = EnterAnotherPlayerState.MESSAGE;
        assertTrue(result.equals(message.toString()));
    }

    @Test
    public void afterInputShouldAskForAnotherPlayer() {
        FakeInput.fakeInput = new InputLine("Test Player 2");
        BowlingState result = state.process();
        Class<EnterAnotherPlayerState> expectedNewState = EnterAnotherPlayerState.class;
        assertTrue(expectedNewState.isInstance(result));
    }

    @Test
    public void nullInputShouldGoToStartGameState() {
        FakeInput.fakeInput = null;
        BowlingState result = state.process();
        Class<StartGameState> expectedNewState = StartGameState.class;
        assertTrue(expectedNewState.isInstance(result));
    }
}