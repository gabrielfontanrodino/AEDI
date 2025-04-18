package es.uvigo.esei.aed1.activity6;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueueExerciseTestCase;
import es.uvigo.esei.aed1.activity6.implementation.LinkedQueue2Ref;
import es.uvigo.esei.aed1.activity6.implementation.RoundLinkedQueue;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static es.uvigo.esei.aed1.activity6.Activity6.*;
import static es.uvigo.esei.aed1.activity6.IsEqualToQueue.equalToQueue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Activity6Test {

    private Queue<Integer> queue1, queue2;
    private final Queue<Integer> queue3;
    private Queue<Integer> expected;

    public Activity6Test() {
        queue1 = new LinkedQueue<>();
        queue2 = new LinkedQueue<>();
        queue3 = new LinkedQueue<>();
        expected = new LinkedQueue<>();
    }

    @BeforeEach
    public void setUp() {
        for (int i = 1; i <= 10; i++) {
            queue1.add(i);
        }
        for (int i = 11; i <= 20; i++) {
            queue2.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            queue3.add(5);
        }
    }

    private static <T> Queue<T> arrayToQueue(T... array) {
        Queue<T> queue = new LinkedQueue<>();
        for (T value : array) {
            queue.add(value);
        }
        return queue;
    }

    /**
     * Test of concat method, of class Activity6.
     */
    @Test
    public void testConcatNullFirstParameter() {
        queue1 = null;

        assertThrows(NullPointerException.class, () -> {
            concat(queue1, queue2);
        });
    }

    @Test
    public void testConcatNullSecondParameter() {
        queue2 = null;

        assertThrows(NullPointerException.class, () -> {
            concat(queue1, queue2);
        });
    }

    @Test
    public void testConcat() {
        concat(queue1, queue2);

        for (int i = 1; i <= 20; i++) {
            expected.add(i);
        }

        assertThat(queue1, is(equalToQueue(expected)));
    }

    /**
     * Test of mix method, of class Activity6.
     */
    @Test
    public void testMixNullFirstParameter() {
        queue1 = null;

        assertThrows(NullPointerException.class, () -> {
            mix(queue1, queue2);
        });
    }

    @Test
    public void testMixNullSecondParameter() {
        queue2 = null;

        assertThrows(NullPointerException.class, () -> {
            mix(queue1, queue2);
        });
    }

    @Test
    public void testMix() {
        expected = arrayToQueue(11, 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 6, 17, 7, 18, 8, 19, 9, 20, 10);
        Queue<Integer> result = mix(queue1, queue2);

        assertThat(result, is(equalToQueue(expected)));
    }

    /**
     * Test of copy method, of class Activity6.
     */
    @Test
    public void testCopyNull() {
        queue1 = null;

        assertThrows(NullPointerException.class, () -> {
            copy(queue1);
        });
    }

    @Test
    public void testCopy() {
        Queue<Integer> result = copy(queue1);

        assertThat(queue1, is(equalToQueue(result)));
        ;
    }

    /**
     * Test of mixInOrderly method, of class Activity6.
     */
    @Test
    public void testMixInOrderlyNullFirstParameter() {
        queue1 = null;

        assertThrows(NullPointerException.class, () -> {
            mixInOrderly(queue1, queue2);
        });
    }

    @Test
    public void testMixInOrderlyNullSecondParameter() {
        queue2 = null;

        assertThrows(NullPointerException.class, () -> {
            mixInOrderly(queue1, queue2);
        });
    }

    @Test
    public void testMixInOrderly() {
        for (int i = 1; i <= 20; i++) {
            expected.add(i);
        }
        Queue<Integer> result = mixInOrderly(queue1, queue2);

        assertThat(result, is(equalToQueue(expected)));
    }

    /**
     * Test of moveToFront method, of class Activity6.
     */
    @Test
    public void testMoveToFrontNull() {
        queue1 = null;

        assertThrows(NullPointerException.class, () -> {
            moveToFront(queue1, 5);
        });
    }

    @Test
    public void testMoveToFront() {
        expected = arrayToQueue(5, 1, 2, 3, 4, 6, 7, 8, 9, 10);
        moveToFront(queue1, 5);

        assertThat(queue1, is(equalToQueue(expected)));
    }

    /**
     * Test of josephus method, of class Activity6.
     */
    @Test
    public void testJosephus() {
        Queue<Integer> soldiers = queue1;
        int initialPos = 2;
        int jump = 5;
        Integer exResult = 5;
        Integer result = josephus(soldiers, initialPos, jump);
        assertEquals(exResult, result);
    }

    /**
     * Test of equalsValues method, of class Activity6.
     */
    @Test
    public void testLinkedQueue2RefEqualsValuesNull() {
        CustomQueueExerciseTestCase test = new CustomQueueExerciseTestCase(LinkedQueue2Ref::new);

        test.testEqualsValuesNull();
    }

    @Test
    public void testLinkedQueue2RefNotEqualsValues() {
        CustomQueueExerciseTestCase test = new CustomQueueExerciseTestCase(LinkedQueue2Ref::new);

        test.testNotEqualsValues();
    }

    @Test
    public void testLinkedQueue2RefEqualsValues() {
        CustomQueueExerciseTestCase test = new CustomQueueExerciseTestCase(LinkedQueue2Ref::new);

        test.testEqualsValues();
    }

    @Test
    public void testRoundLinkedQueueEqualsValuesNull() {
        CustomQueueExerciseTestCase test = new CustomQueueExerciseTestCase(RoundLinkedQueue::new);

        test.testEqualsValuesNull();
    }

    @Test
    public void testRoundLinkedQueueNotEqualsValues() {
        CustomQueueExerciseTestCase test = new CustomQueueExerciseTestCase(RoundLinkedQueue::new);

        test.testNotEqualsValues();
    }

    @Test
    public void testRoundLinkedQueueEqualsValues() {
        CustomQueueExerciseTestCase test = new CustomQueueExerciseTestCase(RoundLinkedQueue::new);

        test.testEqualsValues();
    }

}
