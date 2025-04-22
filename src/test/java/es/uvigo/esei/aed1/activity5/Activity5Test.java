package es.uvigo.esei.aed1.activity5;

import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static es.uvigo.esei.aed1.activity5.Activity5.*;
import static es.uvigo.esei.aed1.activity5.IsEqualToStack.equalToStack;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class Activity5Test {

    private Stack<Integer> stack;

    public Activity5Test() {
        stack = new LinkedStack<>();
    }

    @BeforeEach
    public void setUp() {
        for (int i = 10; i < 20; i++) {
            stack.push(i);
        }
    }

    private static <T> Stack<T> arrayToStack(T... array) {
        Stack<T> stack = new LinkedStack<>();
        for (T value : array) {
            stack.push(value);
        }
        return stack;
    }

    /**
     * Test of reverseWords method, of class Activity5.
     */
    @Test
    public void testReverseWords() {
        String text = "esto es una prueba";
        String expResult = "otse se anu abeurp";
        String result = reverseWords(text);

        assertEquals(expResult, result);
    }

    /**
     * Test of equalStacks method, of class Activity5.
     */
    @Test
    public void testEqualStacksTrue() {
        Stack<Integer> result = arrayToStack(10, 11, 12, 13, 14, 15, 16, 17, 18, 19);

        assertTrue(equalStacks(stack, result));
    }

    @Test
    public void testEqualStacksFalse() {
        Stack<Integer> result = arrayToStack(10, 12, 14, 16, 18, 20, 22, 24, 26, 28);

        assertFalse(equalStacks(stack, result));
    }

    @Test
    public void testEqualStacksNullFirstParameter() {
        stack = null;

        Stack<Integer> stack2 = new LinkedStack<>();

        assertThrows(NullPointerException.class, () -> {
            equalStacks(stack, stack2);
        });
    }

    @Test
    public void testEqualStacksNullSecondParameter() {
        Stack<Integer> stack2 = null;

        assertThrows(NullPointerException.class, () -> {
            equalStacks(stack, stack2);
        });
    }

    /**
     * Test of copy method, of class Activity5.
     */
    @Test
    public void testCopyNull() {
        stack = null;

        assertThrows(NullPointerException.class, () -> {
            copy(stack);
        });
    }

    /**
     * Test of copy method, of class Activity5.
     */
    @Test
    public void testCopyNullMessage() {
        stack = null;

        Exception exception = assertThrows(NullPointerException.class, () -> {
            copy(stack);
        });

        assertThat(exception.getMessage(), is("The stack is null"));
    }

    @Test
    public void testCopy() {
        Stack<Integer> result = copy(stack);

        assertThat(result, is(equalToStack(stack)));
    }

    /**
     * Test of fromBase10ToBase2 method, of class Activity5.
     */
    @Test
    public void testFromBase10ToBase21digit() {
        int numberBase10 = 1;
        String expected = "1";
        String result = fromBase10ToBase2(numberBase10);

        assertEquals(expected, result);
    }

    @Test
    public void testFromBase10ToBase2MoreDigits() {
        int numberBase10 = 134;
        String expected = "10000110";
        String result = fromBase10ToBase2(numberBase10);

        assertEquals(expected, result);
    }

    /**
     * Test of getNumDiamonds method, of class Activity5.
     */
    @Test
    public void testGetNumDiamonds() {
        String sand = "<..<..>.><..><";
        int expected = 3;
        int result = getNumDiamonds(sand);

        assertEquals(expected, result);
    }

    @Test
    public void testGetNumDiamondsLong() {
        String sand = "..<.><>>>...<.<<<>..>..>";
        int expected = 5;
        int result = getNumDiamonds(sand);

        assertEquals(expected, result);
    }

    /**
     * Test of codifyMessage method, of class Activity5.
     */
    @Test
    public void testCodifyMessage() {
        String message = "Bond, James Bond";
        String expected = "BoJ ,dnameB sodn";
        String result = codifyMessage(message);

        assertEquals(expected, result);
    }

    @Test
    public void testCodifyMessageLong() {
        String message = "Espiar es una cosa muy fea. ¡El que busca encuentra!";
        String expected = "Epsia re sunac osam uf yea¡ .Eq lueb ucsa ecnuertna!";
        String result = codifyMessage(message);

        assertEquals(expected, result);
    }

    /**
     * Test of unstackAnItem method, of class Activity5.
     */
    @Test
    public void testUnstackAnItemNull() {
        stack = null;

        assertThrows(NullPointerException.class, ()
                -> unstackAnItem(stack, 3));
    }

    @Test
    public void testUnstackAnItemIllegal() {

        assertThrows(IllegalArgumentException.class, ()
                -> unstackAnItem(stack, 0));

    }

    @Test
    public void testUnstackAnItemMiddle() {
        Integer expected = 15;
        Integer result = unstackAnItem(stack, 5);

        assertEquals(expected, result);
    }

    @Test
    public void testUnstackAnItemFirst() {
        Integer expected = 19;
        Integer result = unstackAnItem(stack, 1);

        assertEquals(expected, result);
    }

    @Test
    public void testUnstackAnItemLast() {
        Integer expectec = 10;
        Integer result = unstackAnItem(stack, 10);

        assertEquals(expectec, result);
    }

    /**
     * Test of isWellParentized method, of class Activity5.
     */
    @Test
    public void testIsWellParentized() {
        String mathExpression = "{[()]}";
        boolean expected = true;
        boolean result = isWellParentized(mathExpression);

        assertEquals(expected, result);
    }

    @Test
    public void testIsWellParentizedClose() {
        String mathExpression = "[()]}";
        boolean expected = false;
        boolean result = isWellParentized(mathExpression);

        assertEquals(expected, result);
    }

    @Test
    public void testIsWellParentizedOpen() {
        String mathExpression = "{[()}";
        boolean expected = false;
        boolean result = isWellParentized(mathExpression);

        assertEquals(expected, result);
    }

    @Test
    public void testIsWellParentizedType() {
        String mathExpression = "{[(}]}";
        boolean expected = false;
        boolean result = isWellParentized(mathExpression);

        assertEquals(expected, result);
    }

    @Test
    public void testIsWellParentized1() {
        String mathExpression = "())(";
        boolean expected = false;
        boolean result = isWellParentized(mathExpression);

        assertEquals(expected, result);
    }

    /**
     * Test of addDigits method, of class Activity5.
     */
    @Test
    public void testAddDigits() {
        int number = 64323;
        String expected = "6 + 4 + 3 + 2 + 3 = 18";
        String result = addDigits(number);

        assertEquals(expected, result);
    }

    @Test
    public void testAddDigits2() {
        int number = 2910;
        String expected = "2 + 9 + 1 + 0 = 12";
        String result = addDigits(number);

        assertEquals(expected, result);
    }

    /**
     * Test of removeCharDuplicated method, of class Activity5.
     */
    @Test
    public void testRemoveCharDuplicated() {
        String text = "careermonk";
        String expResult = "camonk";
        String result = removeCharDuplicated(text);

        assertEquals(expResult, result);
    }

    /**
     * Test of replaceValues method, of class Activity5.
     */
    @Test
    public void testReplaceNull() {
        stack = null;
        Integer oldValue = 2;
        Integer newValue = 12;

        assertThrows(NullPointerException.class, ()
                -> replaceValues(stack, oldValue, newValue));
    }

    @Test
    public void testReplaceValues() {
        Stack<Integer> expected = arrayToStack(10, 11, 2, 13, 14, 15, 16, 17, 18, 19);
        Integer oldValue = 2;
        Integer newValue = 12;
        replaceValues(stack, oldValue, newValue);

        assertThat(stack, is(equalToStack(expected)));
    }

    /**
     * Test of pushValuesLimited method, of class Activity5.
     */
    @Test
    public void testPushValuesLimitedNull() {
        stack = null;

        assertThrows(NullPointerException.class, ()
                -> pushValuesLimited(stack, 2));
    }

    @Test
    public void testPushValuesLimited() {
        Stack<Integer> expected = arrayToStack(11, 12, 13, 14, 15, 16, 17, 18, 19, 5);
        pushValuesLimited(stack, 5);

        assertThat(stack, is(equalToStack(expected)));
    }

}
