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
 
  /**
   * Pop a value off the stack.
   *
   * @return The value of the float which has been popped off the stack.
   * @throws EmptyStackException when called if the stack size is zero.
   */
  public float pop() throws BadTypeException, EmptyStackException {
    return stack.pop().getNumber();
  }
  
  /**
   * Returns true if the NumStack is empty.
   *
   * @return true or false depending if NumStack contains any items.
   */
  public boolean isEmpty() {
    return size() == 0;
  }
  
  int size() {
    return stack.size();
  }
  
}
