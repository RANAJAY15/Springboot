package com.example.Employee.Controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    private int a = 7 , b = 5;

    @Test
    public void testAddition() {
        int result = calculator.add(a, b);
        System.out.println("Addition: " + result);
        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.sub(a, b);
        System.out.println("Subtraction: " + result);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        int result = calculator.mul(a, b);
        System.out.println("Multiplication: " + result);
        assertEquals(35, result);
    }

    @Test
    public void testDivision() {
        int result = calculator.div(a, b);
        System.out.println("Division: " + result);
        assertEquals(1, result);
    }

    @Test
    public void testModulo() {
        int result = calculator.mod(a, b);
        System.out.println("Modulo: " + result);
        assertEquals(2, result);
    }
}
