package com.example.financialappnbp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Math math;

    @Before
    public void init(){
        math = new Math();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addTest() {
        double addition = math.Addition(5, 16);
        assertEquals(21, addition);
    }

    @Test
    public void differenceTest() {
        double difference = math.Difference(10, 2);
        assertEquals(8, difference);
    }

    @Test
    public void multiplicationTest() {
        double multiplication = math.Multiplication(5, 16);
        assertEquals(80, multiplication);
    }

    @Test
    public void divisionTest() {
        double division = math.Division(150, 3);
        assertEquals(50, division);
    }

}