package com.university.lab.lab5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void testFailsFastOnNegativeAltitude() {
        assertThrows(IllegalArgumentException.class,
                () -> MathUtils.calculateGravitationalPotentialEnergy(-1));
    }

    @Test
    public void testZeroAltitudeGivesZeroEnergy() {
        assertEquals(0.0, MathUtils.calculateGravitationalPotentialEnergy(0), 0.0001);
    }

    @Test
    public void testPositiveAltitudeGivesPositiveEnergy() {
        double result = MathUtils.calculateGravitationalPotentialEnergy(10);
        assertTrue(result > 0);
        assertEquals(98.1, result, 0.0001);
    }
}
