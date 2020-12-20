package pl.coderslab.Spring01hibernate.testing;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    @Test
    public void givenTwoStringsWhenConcatThenReturnOneStringBuildFromTwo() {
        // given
        First first = new First();
        String firstValue = "Test";
        String secondValue = "Java";

        //when
        String result = first.concatString(firstValue, secondValue);

        //then
        assertThat(result.length(), is(firstValue.length() + secondValue.length()));
        assertThat(result, is(not("JavaTest")));
        assertThat(result, is("TestJava"));
    }

    @Test(expected = NullPointerException.class)
    public void givenOneStringAndNullWhenConcatThenRaiseNullPointerException() {
        // given
        First first = new First();
        String firstValue = null;
        String secondValue = "Test";

        // when
        first.concatString(firstValue, secondValue);
    }

    @Test
    public void givenTwoNumbersWhenMultiplyThenGiveCorrectResult() {
        // given
        First first = new First();
        int firstValue = 6;
        int secondValue = 5;

        //when
        int result = first.multiply(firstValue, secondValue);

        //then
        assertThat(result, is(30));
    }

}