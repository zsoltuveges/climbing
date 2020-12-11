package hu.company.climbing.measure.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeasurementCalculatorTest {
    private MeasurementCalculator measurementCalculator;

    @BeforeEach
    void init() {
        measurementCalculator = new MeasurementCalculator(Arrays.asList(1, 2, 3, -30, 5, 7));
        measurementCalculator.calculate();
    }


    @Test
    void getSteepestAscent() {
        List<Integer> steepestAscent = measurementCalculator.getSteepestAscent();
        assertEquals(steepestAscent, Arrays.asList(-30, 5));
    }

    @Test
    void getSteepestDescent() {
        List<Integer> steepestDescent = measurementCalculator.getSteepestDescent();
        assertEquals(steepestDescent, Arrays.asList(3, -30));
    }
}