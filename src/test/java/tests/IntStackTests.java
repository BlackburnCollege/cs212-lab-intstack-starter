package tests;

/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
import mypackage.IntStack;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IntStackTests {

    @Test
    @DisplayName("Push pop push toString")
    void sizesStack() {
        IntStack is = new IntStack();
        assertEquals("[]", is.toString(), "empty stack print");
        assertEquals(0, is.size(), "size of empty stack");
        is.push(5);
        assertEquals("[5, ]", is.toString(), "Stack print after 1 push");
        assertEquals(1, is.size(), "size of stack after 1 push");
        assertEquals(5, is.pop(), "pop failed to return the correct value (1 pop after 1 push).");
        assertEquals("[]", is.toString(), "empty stack print after popping last element (1 pop after 1 push)");
        assertEquals(0, is.size(), "size of empty stack after popping last element (1 pop after 1 push)");
    }

    @Test
    @DisplayName("Excessive popping")
    void toStringStack() {
        IntStack is = new IntStack();

        is.push(10).push(13).push(15);
        assertEquals("[10, 13, 15, ]", is.toString(), "toString failed to be as expected after pushing 10, 13, & 15");
        assertEquals(3, is.size(), "size of stack after 3 pushes.");
        assertEquals(15, is.pop(), "pop did not return the correct value (3 pushes, 1 pop).");
        assertEquals(13, is.pop(), "pop did not return the correct value (3 pushes, 2 pops).");
        assertEquals(10, is.pop(), "pop did not return the correct value (3 pushes, 3 pops).");
        assertEquals("[]", is.toString(), "empty stack print (3 pushes, 3 pops)");
        assertEquals(0, is.size(), "size of empty stack (3 pushes, 3 pops)");
        assertEquals(null, is.pop(), "pop did not return the correct value (null) (3 pushes, 4 pops).");
        assertEquals(null, is.pop(), "pop did not return the correct value (null) (3 pushes, 5 pops).");
        assertEquals("[]", is.toString(), "empty stack print (3 pushes, 5 pops)");
        assertEquals(0, is.size(), "size of empty stack (3 pushes, 5 pops)");
        is.pop();
        assertEquals("[]", is.toString(), "empty stack print");
        assertEquals(0, is.size(), "size of empty stack");

    }

//    @ParameterizedTest(name = "{0} + {1} = {2}")
//    @CsvSource({
//        "0,    1,   1",
//        "1,    2,   3",
//        "49,  51, 100",
//        "1,  100, 101"
//    })
//    void add(int first, int second, int expectedResult) {
//        Calculator calculator = new Calculator();
//        assertEquals(expectedResult, calculator.add(first, second),
//                () -> first + " + " + second + " should equal " + expectedResult);
//    }
}
