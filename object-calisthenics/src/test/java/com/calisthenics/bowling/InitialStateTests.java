package com.calisthenics.bowling;

import com.calisthenics.StringResult;
import com.calisthenics.bowling.states.EnterFirstPlayerState;
import com.calisthenics.ioModules.FakeInputFactory;
import com.calisthenics.ioModules.FakeOutput;
import com.calisthenics.ioModules.FakeOutputFactory;
import com.calisthenics.bowling.states.InitialState;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.output.OutputLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class InitialStateTests {

    private InitialState state;

    @Before
    public void TestSetup() {
        IOModuleFactory ioFactory = new IOModuleFactory(new FakeInputFactory(), new FakeOutputFactory());
        state = new InitialState(ioFactory);
    }

    @Test
    public void startingAppShouldDisplayWelcomeMessage() {
        StringResult result = FakeOutput.output;
        OutputLine message = InitialState.MESSAGE;
        assertTrue(result.equals(message.toString()));
    }

    @Test
    public void startingAppShouldMoveToEnterFirstPlayerState() {
        BowlingState result = state.process();
        Class<EnterFirstPlayerState> expectedNewState = EnterFirstPlayerState.class;
        assertTrue(expectedNewState.isInstance(result));
    }
}
