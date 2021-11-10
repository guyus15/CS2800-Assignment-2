package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the OpStack class. 
 *
 * @author chamb
 */
public class OpStackTest {
  OpStack opStack;
  
  @BeforeEach
  void createOpStack() {
    opStack = new OpStack();
  }
  
  @Test // Test 1
  void testSymbolPush() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that we can push entries of type float to the OpStack without error.
     * 
     * To make this test work, I had to create a push method for the OpStack class, as well as a
     * private size method so the class can keep track of the stack's size.
     */
    
    Symbol testSymbol = Symbol.INVALID;
    opStack.push(testSymbol);
    // Check if size increases when we push
    assertEquals(opStack.size(), 1);
    // Check if top most stack item is the item we just pushed
    assertEquals(opStack.stack.top().getSymbol(), testSymbol);
  }
}
