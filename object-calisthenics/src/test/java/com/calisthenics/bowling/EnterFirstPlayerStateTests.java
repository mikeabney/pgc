package com.calisthenics.bowling;

import com.calisthenics.StringResult;
import com.calisthenics.bowling.states.EnterAnotherPlayerState;
import com.calisthenics.bowling.states.EnterFirstPlayerState;
import com.calisthenics.bowling.states.InitialState;
import com.calisthenics.ioModules.FakeInput;
import com.calisthenics.ioModules.FakeInputFactory;
import com.calisthenics.ioModules.FakeOutput;
import com.calisthenics.ioModules.FakeOutputFactory;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.output.OutputLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class EnterFirstPlayerStateTests {

    private EnterFirstPlayerState state;

    @Before
    public void TestSetup() {
        IOModuleFactory ioFactory = new IOModuleFactory(new FakeInputFactory(), new FakeOutputFactory());
        state = new EnterFirstPlayerState(ioFactory.build(), ioFactory);
    }

    @Test
    public void startingStateShouldDisplayWelcomeMessage() {
        StringResult result = FakeOutput.output;
        OutputLine message = EnterFirstPlayerState.MESSAGE;
        assertTrue(result.equals(message.toString()));
    }

    @Test
    public void afterInputShouldAskForAnotherPlayer() {
        FakeInput.fakeInput = new InputLine("Test Player");
        BowlingState result = state.process();
        Class<EnterAnotherPlayerState> expectedNewState = EnterAnotherPlayerState.class;
        assertTrue(expectedNewState.isInstance(result));
    }

    @Test
    public void nullInputShouldShowSameState() {
        FakeInput.fakeInput = null;
        BowlingState result = state.process();
        Class<EnterFirstPlayerState> expectedNewState = EnterFirstPlayerState.class;
        assertTrue(expectedNewState.isInstance(result));
    }
}
