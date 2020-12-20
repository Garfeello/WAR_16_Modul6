package pl.coderslab.Spring01hibernate.suite;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleSample2Test {

    @Test
    public void testPow() {
        double firstValue = 3;
        double secondValue = 3;

        double result = Math.pow(firstValue, secondValue);

        assertEquals(27.0, result);
    }

    @Test
    public void testPow2() {
        double firstValue = 2;
        double secondValue = 2;

        double result = Math.pow(firstValue, secondValue);

        assertEquals(4, result);
    }

}
