package uk.ac.rhul.cs2800.calculator;

/**
 * This exception should be thrown when a method which requires the stack 
 * to have a size greater than zero is called, but the actual stack size is 
 * zero.
 *
 * @author chamb
 */
public class EmptyStackException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Creates a new instance of an EmptyStackException.
   *
   * @param errorMessage The error message to be shown when the error is thrown.
   */
  public EmptyStackException(String errorMessage) {
    super(errorMessage);
  }
}
