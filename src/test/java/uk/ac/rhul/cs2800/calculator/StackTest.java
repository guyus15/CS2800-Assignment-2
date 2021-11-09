package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the Stack class.
 *
 * @author chamb
 */
public class StackTest {

  Stack stack;

  @BeforeEach
  void createStack() {
    stack = new Stack();
  }

  @Test // Test 1
  void testFloatEntryPush() throws BadTypeException {
    /*
     * This test ensures that we can push entries of type float
     * to the stack.
     * 
     * To make this test work I had to create a push method for the 
     * Stack class with a float as a parameter.
     */
    
    float testNumber = 0.0f;
    stack.push(testNumber);
    // Check if size increases when we push
    assertEquals(stack.size, 1);
    // Check if top most stack item is the item we just pushed
    assertEquals(stack.entries.get(stack.size - 1).getNumber(), testNumber);
  }
  
  @Test // Test 2
  void testStringEntryPush() throws BadTypeException {
    /*
     * This test ensures that we can push entries of type String
     * to the stack.
     * 
     * To make this test work I had to overload the push method in the  
     * Stack class to support String types.
     */
    
    String testString = "test";
    stack.push(testString);
    // Check if size increases when we push
    assertEquals(stack.size, 1);
    // Check if top most stack item is the item we just pushed
    assertEquals(stack.entries.get(stack.size - 1).getString(), testString);
  }
  
  @Test // Test 3
  void testSymbolEntryPush() throws BadTypeException {
    /*
     * This test ensures that we can push entries of type Symbol
     * to the stack.
     * 
     * To make this test work I had to overload the push method in the  
     * Stack class to support Symbol types.
     */
    
    Symbol testSymbol = Symbol.INVALID;
    stack.push(testSymbol);
    // Check if size increases when we push
    assertEquals(stack.size, 1);
    // Check if top most stack item is the item we just pushed
    assertEquals(stack.entries.get(stack.size - 1).getSymbol(), testSymbol);
  }
  
  @Test // Test 4
  void testAllEntryPush() throws BadTypeException {
    /*
     * This test ensures that we can push entries with all of the different
     * types of data: number, string and symbol.
     */
    
    float testNumber = 0.0f;
    String testString = "test";
    Symbol testSymbol = Symbol.INVALID;
    
    stack.push(testNumber);
    stack.push(testString);
    stack.push(testSymbol);
    
    // Check if the size of the stack is 3 after adding 3 items
    assertEquals(stack.size, 3);
    // Check each stack entry is the correct value
    assertEquals(stack.entries.get(0).getNumber(), testNumber);
    assertEquals(stack.entries.get(1).getString(), testString);
    assertEquals(stack.entries.get(2).getSymbol(), testSymbol);
  }
  
  @Test // Test 5
  void testPopWhenEmpty() throws EmptyStackException {
    /*
     * This test ensures that when calling pop on an empty stack,
     * an EmptyStackException will be thrown.
     * 
     * To make this test work I had to create an EmptyStackException class
     * and throw it in the pop method if the size of the stack was zero.
     */
    
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }
  
  @Test // Test 6
  void testPushThenPop() throws EmptyStackException, BadTypeException {
    /*  
     * This test ensures that the size of the stack changes when we push and pop
     * 
     * To make this test work I had to update the stack size in both the push and pop
     * methods.
     */
    
    stack.push(0.0f);
    stack.pop();
    
    assertEquals(stack.size, 0);
  }
  
  @Test // Test 10
  void testSizeWhenPop() throws EmptyStackException {
    /*
     * This test ensures that the size of the stack
     * decreases when we pop off an object and the stack contains
     * multiple objects.
     * 
     * To make this test work I had to decrement the stack's
     * size in the pop method.
     */
    
    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.pop();
    
    assertEquals(stack.size(), 2);
  }
  
  @Test // Test 7
  void testBadException() throws BadTypeException {
    /*
     * This test ensures that a BadTypeException will be thrown
     * when trying to call the getString() and getSymbol() methods
     * on an entry who's type is float.
     * 
     * To make this test pass I had to add a check to the get methods to see
     * the current entry type.
     */
    
    float testNumber = 0.0f;
    
    stack.push(testNumber);
    
    assertThrows(BadTypeException.class, () -> stack.entries.get(0).getString());
    assertThrows(BadTypeException.class, () -> stack.entries.get(0).getSymbol());
    assertEquals(stack.entries.get(0).getNumber(), testNumber);
  }
  
  @Test // Test 8
  void testSizeWhenPush() {
    /*
     * This test ensures that the size increases
     * when we push on to the stack.
     * 
     * To make this test work I had to create a size method
     * in the Stack class which returns the stack's size.
     */
    
    stack.push("test");
    assertEquals(stack.size(), 1);
  }
  
  @Test // Test 9
  void testSizeAfterFivePush() {
    /*
     * This test ensures that after pushing x amount of times,
     * the size is equal to x. 
     */
    
    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    
    assertEquals(stack.size(), 5);
  }
  
  
  @Test // Test 11
  void testPopReturnValue() throws EmptyStackException, BadTypeException {
    /*
     * This test ensures that when the pop method is called,
     * the correct entry from the stack is returned. 
     * 
     * To make this test work I had to add a return to the pop
     * method which returns the entry which has just been removed 
     * from the stack.
     */
    
    float testNumber = 1.0f;
    String testString = "test";
    Symbol testSymbol = Symbol.INVALID;
    
    stack.push(testNumber);
    stack.push(testString);
    stack.push(testSymbol);
    
    assertEquals(stack.pop().getSymbol(), testSymbol);
    assertEquals(stack.pop().getString(), testString);
    assertEquals(stack.pop().getNumber(), testNumber);
  }
  
  @Test // Test 12
  void testPushThenTop() throws EmptyStackException, BadTypeException {
    /*
     * This test ensures that the top method returns the 
     * top-most object of the stack.
     * 
     * To make this test work, I had to add a top method to the 
     * stack class which returns the object at the top of the stack.
     */
    
    float testNumber = 0.0f;
    stack.push(testNumber);
    assertEquals(stack.top().getNumber(), testNumber);
  }
  
  @Test // Test 13
  void testTopWhenEmpty() throws EmptyStackException {
    /*
     * This test ensures that an EmptyStackException will be thrown if 
     * the top method is called when the stack size is zero.
     * 
     * To make this test work I had to add a throw EmptyStackException 
     * in the top method when the size of the stack is zero.
     */
    
    assertThrows(EmptyStackException.class, () -> stack.top());
  }
}
