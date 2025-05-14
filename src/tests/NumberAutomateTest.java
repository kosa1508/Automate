package tests;


import src.NumberAutomate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberAutomateTest {
    @Test
    void test() {
        // тесты
        src.Automate numberAuto = NumberAutomate.NUMBER_AUTOMATE;
        assertTrue(numberAuto.test("3.14"));
        assertTrue(numberAuto.test("-17.5"));
        assertTrue(numberAuto.test("+.2"));
        assertTrue(numberAuto.test("1000"));
        assertTrue(numberAuto.test("-100."));
        assertTrue(numberAuto.test("0.0"));
        assertTrue(numberAuto.test("0"));

        assertFalse(numberAuto.test("+-17"));
        assertFalse(numberAuto.test("12.12."));
        assertFalse(numberAuto.test("1e10"));
        assertFalse(numberAuto.test("1+2"));
        assertFalse(numberAuto.test("+."));
        assertFalse(numberAuto.test("17-2"));
        assertFalse(numberAuto.test("."));
    }
}