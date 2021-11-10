package uk.ac.rhul.cs2800.calculator;

/**
 * The OpStack class acts as a facade for the Stack class to hide unnecessary detail. 
 *
 * @author chamb
 */
public class OpStack {
  
  Stack stack;

  /**
   *  Creates a new instance of the OpStack class.
   */
  public OpStack() {
    stack = new Stack();
  }
  
  /**
   * Push a symbol value onto the stack.
   *
   * @param symbolValue The symbol value to be pushed onto the stack.
   */
  public void push(Symbol symbolValue) {
    stack.push(symbolValue);
  }
  
  /**
   * Pop a value off the stack.
   *
   * @return The value of the Symbol which has been popped off the stack.
   * @throws EmptyStackException when called if the stack size is zero.
   */
  public Symbol pop() throws BadTypeException, EmptyStackException {
    return stack.pop().getSymbol();
  }
  
  /**
   * Returns true if the OpStack is empty.
   *
   * @return true or false depending if OpStack contains any items.
   */
  public boolean isEmpty() {
    return size() == 0;
  }
  
  int size() {
    return stack.size();
  }
}
