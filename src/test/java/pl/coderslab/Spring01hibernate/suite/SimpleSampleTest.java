package pl.coderslab.Spring01hibernate.suite;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleSampleTest {

    @Test
    public void givenToNumber6And4WhenAddingThenResultIs10() {
        int firstValue = 6;
        int secondValue = 4;

        int result = Math.addExact(firstValue, secondValue);

        assertEquals(10, result);
        assertTrue(true);
        assertEquals(3.3, 3.4, 2);
    }

    @Test
    public void givenToNumber10And4WhenAddingThenResultIs14() {
        int firstValue = 10;
        int secondValue = 4;

        int result = Math.addExact(firstValue, secondValue);

        assertEquals(14, result);
    }

}
