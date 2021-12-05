package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the StrStack class.
 *
 * @author chamb
 */
public class StrStackTest {
  StrStack strStack;
  
  @BeforeEach
  void createStrStack() {
    strStack = new StrStack();
  }
  
  @Test // Test 1
  void testStringValuePush() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that we can push entries of type string to the StrStack without error.
     *
     * To make this test work, I had to create a push method for the StrStack class, as well as a 
     * private size method so the class can keep track of the stack's size.
     */
    
    String testString = "test";
    strStack.push(testString);
    // Check if size increases when we push.
    assertEquals(strStack.size(), 1);
    // Check if the top most stack item is the item we just pushed.
    assertEquals(strStack.stack.top().getString(), testString);
  }
  
  @Test // Test 2
  void testPushFiveTimes() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that we can successfully push onto the stack more than once with every as
     * expected.
     */
    
    strStack.push("this");
    strStack.push("is");
    strStack.push("a");
    strStack.push("test");
    
    // Check if the size increases when we push (should be 4 in this case)
    assertEquals(strStack.size(), 4);
    // Check if the top most stack item is the item we last pushed.
    assertEquals(strStack.stack.top().getString(), "test");
  }
  
  @Test // Test 3
  void testPushThenPop() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that the program follows the intended behaviour when we push a value before
     * popping it.
     * 
     * To make this test work, I had to add a pop method to the StrStack class which calls the
     * underlying pop method of the Stack class and returns the value.
     */
    
    String testString = "test";
    strStack.push(testString);
    String poppedString = strStack.pop();
    
    // Check that the value we pushed on and the value we pushed off are equal.
    assertEquals(poppedString, testString);
  }
  
  @Test // Test 4
  void testSizeWhenPop() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that the size of the StrStack decreases when we pop off an object and the
     * stack contains multiple objects.
     */
    
    strStack.push("a");
    strStack.push("b");
    strStack.push("c");
    
    strStack.pop();
    
    assertEquals(strStack.size(), 2);
  }
  
  @Test // Test 5
  void testPopWhenEmpty() throws BadTypeException, EmptyStackException {
    /*
     * This test ensures that when calling pop on an empty stack, an EmptyStackException will be
     * thrown.
     */

    assertThrows(EmptyStackException.class, () -> strStack.pop());
  }
  
  @Test // Test 6
  void testIsEmpty() {
    /*
     * This test ensures that the isEmpty method returns true when the stack contains no elements.
     * 
     * To make this test work, I had to add a isEmpty method to the StrStack which uses
     * the size of the stack to determine if it is empty.
     */

    assertEquals(strStack.isEmpty(), true);
  }
  
  @Test // Test 7
  void testIsNotEmpty() {
    /*
     * This test ensures that the isEmpty method returns false 
     * when the stack contains some elements.
     */
    
    strStack.push("test");
    assertEquals(strStack.isEmpty(), false);
  }
  
}
