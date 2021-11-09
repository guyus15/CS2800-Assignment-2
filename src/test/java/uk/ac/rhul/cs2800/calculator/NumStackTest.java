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
  
  @Test // Test 2
  void testPushFiveTimes() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that we can successfully push onto the stack more than once
     * with every as expected.
     */
    
    numStack.push(0.0f); // 1
    numStack.push(1.0f); // 2
    numStack.push(2.0f); // 3
    numStack.push(3.0f); // 4
    numStack.push(4.0f); // 5
    
    //Check if the size increases when we push (should be 5 in this case)
    assertEquals(numStack.size(), 5);
    // Check if the top most stack item is the item we last pushed.
    assertEquals(numStack.stack.top().getNumber(), 4.0f);
  }
}