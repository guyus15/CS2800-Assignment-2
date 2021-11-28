package uk.ac.rhul.cs2800.calculator;

/**
 * A Reverse Polish Calculator implementation of the Calculator. Supports evaluating
 * postfix expressions.
 *
 * @author chamb
 */
public class RevPolishCalc extends Calculator {
  
  NumStack numStack;
  
  /**
   * The constructor for the RevPolishCalc, inherited from the Calculator super class.
   */
  public RevPolishCalc() {
    super();
    
    numStack = new NumStack();
  }
  
  /**
   * Get the evaluation of a postfix arithmetic expression string.
   *
   * @param stringToEvaluate the String to be evaluated.
   * @return the evaluation of the postfix arithmetic expression string.
   * @throws BadTypeException this will never be thrown as we are using a stack facade.
   * @throws EmptyStackException if we try to operate on a stack with a size of zero.
   */
  @Override
  public float evaluate(String stringToEvaluate)
      throws
      InvalidExpressionException,
      BadTypeException,
      EmptyStackException {
    
    // Inherit this for error checking of the string expression.
    super.evaluate(stringToEvaluate);
    
    for (String current : stringToEvaluate.split(" ")) {
      
      Symbol currentSymbol = Symbol.INVALID;
      
      // This means that the current part of the string is a symbol.
      if ((currentSymbol = Symbol.toSymbol(current)) != Symbol.INVALID) {
        
        try { // Using a try statement allows us to catch any unbalanced operands. 
          
          // Perform the operation with last two numbers in the numStack.
          float num2 = numStack.pop();
          float num1 = numStack.pop();
          float result = performOperation(num1, num2, currentSymbol);
          
          // Push the result back on to the stack.
          numStack.push(result);
        } catch (EmptyStackException e) {
          // This means the expression string is invalid. Throw an error.
          throw new InvalidExpressionException("Invalid expression. Unbalanced operands.");
        } catch (ArithmeticException e) {
          // This means the expression is performing an illegal operation. Throw an error.
          throw new InvalidExpressionException("Invalid expression. Division by zero.");
        }
        
      } else { 
        try {
          float num = Float.parseFloat(current);
          
          // If the program gets here without throwing an exception, the current part
          // of the string is a float.
          numStack.push(num);
        } catch (NumberFormatException e) {
          // This means that the expression string contains something invalid. Throw an error.
          throw new InvalidExpressionException("Invalid expression. Non-numerical values.");
        }
      }
    }
    
    // If there is still more than one item in the stack then the expression is invalid.
    // Throw an error.
    if (numStack.size() > 1) {
      throw new InvalidExpressionException("Invalid expression. Unbalanced operands.");
    }
    
    // Return the final number in the stack, this will be the final result.
    return numStack.pop();
  }
  
  
  /**
   * Performs an operation on two numbers, depending on the Symbol given.
   *
   * @param num1 the first number.
   * @param num2 the second number.
   * @param symbol the operation Symbol.
   * @return the result of the operation on the two numbers.
   */
  float performOperation(float num1, float num2, Symbol symbol) {
    
    // Check if we are trying to divide by zero. If so, throw error.
    if (num2 == 0 && symbol == Symbol.DIVIDE) {
      throw new ArithmeticException("Cannot divide by zero.");
    }
    
    switch (symbol) {
      case TIMES:
        return num1 * num2;
      case DIVIDE:
        return num1 / num2;
      case PLUS:
        return num1 + num2;
      case MINUS:
        return num1 - num2;
      default:
        return Float.MAX_VALUE;
    }
  }
  
}
