package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the NumStack class. 
 *
 * @author chamb
 */
public class NumStackTest {
  NumStack numStack;
  
  @BeforeEach
  void createNumStack() {
    numStack = new NumStack();
  }
  
  @Test // Test 1
  void testFloatValuePush() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that we can push entries of type float
     * to the NumStack without error.
     * 
     * To make this test work, I had to create a push method for the NumStack
     * class, as well as a private size method so the class can keep track of 
     * the stack's size.
     */
 
    float testNumber = 0.0f;
    numStack.push(testNumber);
    // Check if size increases when we push
    assertEquals(numStack.size(), 1);
    // Check if top most stack item is the item we just pushed
    assertEquals(numStack.stack.top().getNumber(), testNumber);
  }
}
