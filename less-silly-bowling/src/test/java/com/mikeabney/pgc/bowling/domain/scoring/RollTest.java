package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Assert;
import org.junit.Test;

public class RollTest {
    @Test
    public void shouldAllowReasonableRollAndRememberData() {
        createRollAndAssertRemembered(new PinCount(6), new PinCount(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNegativeStartingPins() {
        createRollAndAssertRemembered(new PinCount(-1), PinCount.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNegativePinfall() {
        createRollAndAssertRemembered(PinCount.TEN, new PinCount(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowPinfallGreaterThanStartingPins() {
        createRollAndAssertRemembered(PinCount.TEN, new PinCount(11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowMoreThanTenStartingPins() {
        createRollAndAssertRemembered(new PinCount(11), new PinCount(1));
    }

    private void createRollAndAssertRemembered(PinCount startingPins, PinCount pinfall) {
        Roll roll = Roll.withPinfall(startingPins, pinfall);
        assertRollRemembered(startingPins, pinfall, roll);
    }

    private void assertRollRemembered(PinCount startingPins, PinCount pinfall, Roll roll) {
        PinCount pinfallFromRoll = roll.fallenPins();
        Assert.assertEquals(pinfall, pinfallFromRoll);

        PinCount remainingPinsFromRoll = roll.standingPins();
        PinCount calculatedStartingPins = pinfallFromRoll.plus(remainingPinsFromRoll);
        Assert.assertEquals(startingPins, calculatedStartingPins);
    }
}
