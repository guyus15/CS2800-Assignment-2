package uk.ac.rhul.cs2800.calculator;

/**
 * Is a State design pattern designed to encapsulate RevPolishCalc and
 * StandardCalc classes so they can be used under the same class. 
 *
 * @author chamb
 */
public class CalcModel {
  
  Calculator currentCalc; // Current calculator, either of type StandardCalc or RevPolishCalc.
  StandardCalc standardCalc;
  RevPolishCalc revPolishCalc;
  
  /**
   * The constructor for the CalcModel class.
   */
  public CalcModel() {
    standardCalc = new StandardCalc();
    revPolishCalc = new RevPolishCalc();
    
    currentCalc = standardCalc; // By default the state of the calculator is infix.
  }
 
  /**
   * Toggles the state of the calculator between 
   * standard and reverse Polish.
   *
   * @param isInfix a boolean determining if the calculator should be infix or not. 
  Will be postfix if this is false.
   */
  public void setType(boolean isInfix) {
    if (isInfix) {
      currentCalc = standardCalc;
    } else {
      currentCalc = revPolishCalc;
    }
  }
  
  /**
   * Get the result of the arithmetic expression string.
   *
   * @param expression the expression to be evaluated.
   * @return the evaluation of the string expression.
   * @throws BadTypeException never gets thrown due to the use of facade.
   * @throws EmptyStackException when called if the stack size is zero.
   * @throws InvalidExpressionException thrown if the given expression is invalid.
   */
  public float evaluate(String expression) throws
      InvalidExpressionException,
      EmptyStackException,
      BadTypeException {
    return currentCalc.evaluate(expression);
  }
  
}
