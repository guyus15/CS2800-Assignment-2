package uk.ac.rhul.cs2800.calculator;

/**
 *  Allows the calculation of String expressions. 
 *
 * @author chamb
 */
public interface Calculator {

  /**
   * Called when we want to evaluate an arithmetic expression String.
   *
   * @param stringToEvaluate the String to be evaluated.
   * @return the evaluation of the String
   */
  public float evaluate(String stringToEvaluate);  
}
