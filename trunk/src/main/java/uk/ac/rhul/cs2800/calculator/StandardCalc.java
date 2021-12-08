package uk.ac.rhul.cs2800.calculator;

/**
 * A standard implementation of the Calculator class. This will support the evaluation of String
 * expressions.
 *
 * @author chamb
 */
public class StandardCalc extends Calculator {

  OpStack opStack;
  
  RevPolishCalc revPolishCalc;
  
  /**
   * The constructor for the StandardCalc, inherited from the Calculator super class.
   */
  public StandardCalc() {
    super();

    opStack = new OpStack();
    revPolishCalc = new RevPolishCalc();
  }

  /**
   * Get the evaluation of an infix arithmetic expression string.
   *
   * @param stringToEvaluate the String to be evaluated.
   * @return the evaluation of the infix arithmetic expression string.
   * @throws EmptyStackException when called if the stack size is zero.
   * @throws BadTypeException this will never be thrown due the use of facade.
   */
  @Override
  public float evaluate(String stringToEvaluate)
      throws
      InvalidExpressionException,
      BadTypeException,
      EmptyStackException {
    // Inherit this for error checking of the string expression..
    super.evaluate(stringToEvaluate);

    // Convert the infix expression to a postfix expression.
    String expression = convert(stringToEvaluate);

    // Ultimately uses the reverse Polish calculator anyway to perform the calculation.
    return revPolishCalc.evaluate(expression);
  }

  
  /**
   * Converts an infix string expression to a postfix string expression.
   *
   * @param infixString the infix string expression to be converted.
   * @return the resulting postfix expression.
   * @throws InvalidExpressionException if the given infix string is invalid.
   * @throws BadTypeException this will never be thrown as we are using a stack facade.
   * @throws EmptyStackException if we try to operate on a stack with a size of zero.
   */
  String convert(String infixString) throws 
      InvalidExpressionException, 
      BadTypeException,
      EmptyStackException {
    
    String postfix = new String(""); // A string to store the final postfix expression
    
    Symbol poppedSymbol = Symbol.INVALID;
    
    // Iterates through every item in the string separated by a space.
    for (String current : infixString.split(" ")) {
      
      Symbol currentSymbol = Symbol.INVALID;
      
      // This means that the current part of the string is a symbol.
      if ((currentSymbol = Symbol.toSymbol(current)) != Symbol.INVALID) {
          
        if (currentSymbol == Symbol.LEFT_BRACKET) {
          
          opStack.push(currentSymbol);
          
        } else if (currentSymbol == Symbol.RIGHT_BRACKET) {
          
          // This will pop items off the opStack until it reaches a left bracket.
          // As it pops it will add the returned Symbol to the postfix string.
          while ((poppedSymbol = opStack.pop()) != Symbol.LEFT_BRACKET) {
            postfix += poppedSymbol.toString() + " ";
          }
          
        } else {
          
          opStack.push(currentSymbol);
        }
      } else {
        
        try {
          Float.parseFloat(current);
          
          // If the program gets here without throwing an exception, the current part
          // of the string is a float.
          postfix += current + " ";
        } catch (NumberFormatException e) {
          throw new InvalidExpressionException("Invalid expression. Non-numerical values.");
        }
      }
    }
    
    // Add anything still left in the stack to the postfix string.
    while (!opStack.isEmpty()) {
      postfix += opStack.pop().toString() + " ";
    }
    
    // Removes any unwanted white space from front and back of the postfix string.
    return postfix.strip();
  }
}
