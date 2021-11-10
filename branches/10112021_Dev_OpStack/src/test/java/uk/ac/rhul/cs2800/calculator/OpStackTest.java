package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
  
  @Test // Test 2
  void testPushFiveTimes() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that we can successfully push onto the stack more than once with every as
     * expected.
     */
    
    opStack.push(Symbol.INVALID);
    opStack.push(Symbol.INVALID);
    opStack.push(Symbol.INVALID);
    opStack.push(Symbol.INVALID);
    opStack.push(Symbol.INVALID);
    
    // Check if the size increases when we push (should be 5 in this case)
    assertEquals(opStack.size(), 5);
    // Check if the top most stack item is the item we last pushed.
    assertEquals(opStack.stack.top().getSymbol(), Symbol.INVALID);
  }
  
  @Test // Test 3
  void testPushThenPop() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that the program follows the intended behaviour when we push a value before
     * popping it.
     * 
     * To make this test work, I had to add a pop method to the OpStack class which calls the
     * underlying pop method of the Stack class and returns the value.
     */
    
    Symbol testSymbol = Symbol.INVALID;
    opStack.push(testSymbol);
    Symbol poppedSymbol = opStack.pop();
    
    // Check that the value we pushed on and the value we pushed off are equal.
    assertEquals(poppedSymbol, testSymbol);
  }
  
  @Test // Test 4
  void testSizeWhenPop() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that the size of the NumStack decreases when we pop off an object and the
     * stack contains multiple objects.
     */

    opStack.push(Symbol.INVALID);
    opStack.push(Symbol.INVALID);
    opStack.push(Symbol.INVALID);

    opStack.pop();
    
    assertEquals(opStack.size(), 2);
  }
  
  @Test // Test 5
  void testPopWhenEmpty() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that when calling pop on an empty stack, an EmptyStackException will be
     * thrown.
     */

    assertThrows(EmptyStackException.class, () -> opStack.pop());
  }
}
