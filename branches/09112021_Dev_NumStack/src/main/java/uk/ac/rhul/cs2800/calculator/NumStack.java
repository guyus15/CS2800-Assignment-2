package uk.ac.rhul.cs2800.calculator;


/**
 * The NumStack class acts as a facade for the Stack class to hide unnecessary detail.
 *
 * @author chamb
 */
public class NumStack {
  
  Stack stack;
  
  
  /**
   * Creates a new instance of the NumStack class.
   */
  public NumStack() {
    stack = new Stack();
  }
  
  
  /**
   * Push a float value onto the stack.
   *
   * @param floatValue The float value to be pushed onto the stack.
   */
  public void push(float floatValue) {
    stack.push(floatValue);
  }
 
 
  int size() {
    return stack.size();
  }
  
}
