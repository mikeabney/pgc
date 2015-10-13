package com.calisthenics.bowling;

import com.calisthenics.StringResult;
import com.calisthenics.ioModules.FakeInputFactory;
import com.calisthenics.ioModules.FakeOutput;
import com.calisthenics.ioModules.FakeOutputFactory;
import com.calisthenics.bowling.states.InitialState;
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
        state = new InitialState(new FakeInputFactory(), new FakeOutputFactory());
    }

    @Test
    public void startingAppShouldAskForAName() {
        StringResult result = FakeOutput.output;
        assertTrue(result.equals(InitialState.MESSAGE));
    }
}
