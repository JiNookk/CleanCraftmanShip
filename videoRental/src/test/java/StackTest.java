import Ch2.Stack.Stack;
import Ch2.Stack.UnderflowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setup() {
        stack = new Stack();
    }

    @Test
    void canCreateStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterOnePush_isNotEmpty() {
        stack.push(0);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
    }

    @Test
    void afterOnePushAndPop_isEmpty() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    void afterTwoPush_sizeIsTwo() {
        stack.push(0);
        stack.push(0);
        assertEquals(2, stack.getSize());
    }

    @Test
    void poppingEmptyStack_throwsUnderflow() {
        assertThrows(UnderflowException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void afterPushingX_willPopX() {
        stack.push(99);
        assertEquals(99, stack.pop());

        stack.push(88);
        assertEquals(88, stack.pop());
    }

    @Test
    void afterPushingXandY_willPopYthenX() {
        stack.push(99);
        stack.push(88);

        assertEquals(88, stack.pop());
        assertEquals(99, stack.pop());
    }
}
