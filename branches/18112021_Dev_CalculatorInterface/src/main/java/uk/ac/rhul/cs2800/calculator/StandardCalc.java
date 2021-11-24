package uk.ac.rhul.cs2800.calculator;

/**
 * A standard implementation of the Calculator class. This will support the evaluation of String
 * expressions.
 *
 * @author chamb
 */
public class StandardCalc extends Calculator {

  /**
   * The constructor for the StandardCalc, inherited from the Calculator super class.
   */
  public StandardCalc() {
    super();
  }

  @Override
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
