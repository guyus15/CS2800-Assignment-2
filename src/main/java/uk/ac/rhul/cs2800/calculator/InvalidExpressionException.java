package uk.ac.rhul.cs2800.calculator;

/**
 * This exception should be thrown when an invalid expression arises.
 *
 * @author chamb
 */
public class InvalidExpressionException extends Exception {
  
  private static final long serialVersionUID = 1L;

  /**
   * Creates a new instance of a InvalidExpressionException.
   *
   * @param errorMessage The error message to be shown when the error is thrown.
   */
  public InvalidExpressionException(String errorMessage) {
    super(errorMessage);
  }
}
