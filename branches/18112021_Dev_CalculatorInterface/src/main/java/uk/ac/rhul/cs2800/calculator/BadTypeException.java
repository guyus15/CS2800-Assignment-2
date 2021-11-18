package uk.ac.rhul.cs2800.calculator;

/**
 * This exception should be thrown when a given type is not expected.
 *
 * @author chamb
 */
public class BadTypeException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Creates a new instance of a BadTypeException.
   *
   * @param errorMessage The error message to be shown when the error is thrown.
   */
  public BadTypeException(String errorMessage) {
    super(errorMessage);
  }
}
