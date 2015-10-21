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

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class DataPersistenceIntegrationTests {

    private BowlingState state;

    @Before
    public void TestSetup() {
        IOModuleFactory ioFactory = new IOModuleFactory(new FakeInputFactory(), new FakeOutputFactory());
        state = new EnterFirstPlayerState(ioFactory.build(), ioFactory);
        FakeInput.fakeInput = new InputLine("Player 1");
        state = state.process();
        FakeInput.fakeInput = new InputLine("Player 2");
        state = state.process();
        FakeInput.fakeInput = new InputLine("Player 3");
        state = state.process();
    }

    @Test
    public void thereShouldBeThreePlayers() {
        assertEquals(3, state.players.size());
    }
}
