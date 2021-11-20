package uk.ac.rhul.cs2800.calculator;

/**
 *  Allows the calculation of String expressions. 
 *
 * @author chamb
 */
public final class Calculator {

  // Does not need to be public as all access to the Calculator is done via getInstance().
  private Calculator() {}
  
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
  public float evaluate(String stringToEvaluate) {
    return 0;
  }
}
