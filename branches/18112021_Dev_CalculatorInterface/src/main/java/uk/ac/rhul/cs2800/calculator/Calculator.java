package uk.ac.rhul.cs2800.calculator;

/**
 *  An abstract class designed to define the implementation of Calculators 
 *  for the calculation of String expressions. 
 *
 * @author chamb
 */
public abstract class Calculator {
  
  /**
   * Create an instance of a Calculator.
   */
  public Calculator() {}
  
  /**
   * Get the evaluation of an arithmetic expression String.
   *
   * @param stringToEvaluate the String to be evaluated.
   * @return the evaluation of the arithmetic expression String
   */
  public float evaluate(String stringToEvaluate) throws InvalidExpressionException {
    /*
     * An expression is considered invalid if the stringToEvaluate is 
     * blank, empty or does not contain any integers (determined by matches(".*\\d.*"))
     */
    if (stringToEvaluate.isBlank()
        || stringToEvaluate.isEmpty()
        || !stringToEvaluate.matches(".*\\d.*")) {
      throw new InvalidExpressionException("Invalid expression.");
    }
    
    return 0;
  }
}
