package uk.ac.rhul.cs2800.calculator;

/**
 *  Allows the calculation of String expressions. Based off Dave Cohen's code. 
 *
 * @author chamb, Dave Cohen
 */
public class Calculator {

  // Does not need to be public as all access to the Calculator is done via getInstance().
  protected Calculator() {}
  
  public static Calculator instance = null;
  
  /**
   * Accessing the Calculator Singleton pattern. The first time this is called
   * a new instance of a Calculator will be created.
   *
   * @return the current instance of the Calculator Singleton.
   */
  public static Calculator getInstance() {
    if (instance == null) {
      instance = new Calculator();
    }
    
    return instance;
  }
  
  /**
   * Called when we want to evaluate an arithmetic expression String.
   *
   * @param stringToEvaluate the String to be evaluated.
   * @return the evaluation of the arithmetic expression String
   */
  public static float evaluate(String stringToEvaluate) throws InvalidExpressionException {
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
