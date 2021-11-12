package uk.ac.rhul.cs2800.calculator;

/**
 * The StrStack class acts acts a facade for the Stack class to hide unnecessary detail. 
 *
 * @author chamb
 */
public class StrStack {
  
  Stack stack;
  
  /**
   * Creates a new instance of the StrStack class.
   */
  public StrStack() {
    stack = new Stack();
  }
  
  /**
   * Push a string value onto the stack.
   *
   * @param stringValue The String value to be pushed onto the stack.
   */
  public void push(String stringValue) {
    stack.push(stringValue);
  }
  
  /**
   * Pop a value of the stack.
   *
   * @return The value of the String which has been popped off the stack.
   * @throws BadTypeException this will never be thrown.
   * @throws EmptyStackException when called if the stack size is zero.
   */
  public String pop() throws BadTypeException, EmptyStackException {
    try {
      return stack.pop().getString();
    } catch (BadTypeException bte) {
      // BadTypeException will never be thrown because a string will always be returned.
      return "";
    }
  }
  
  /**
   * Returns true if the StrStack is empty.
   *
   * @return true or false depending if StrStack contains any items. 
   */
  public boolean isEmpty() {
    return size() == 0;
  }
  
  
  int size() {
    return stack.size();
  }
}
