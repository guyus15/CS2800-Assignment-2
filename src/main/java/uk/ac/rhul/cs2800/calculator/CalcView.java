package uk.ac.rhul.cs2800.calculator;

/**
 * An interface designed to be used for encapsulating views with the {@code Calculator}.
 *
 * @author chamb
 */
public interface CalcView {

  /**
   * Returns a string expression given as input.
   *
   * @return a string expression.
   */
  String getExpression();
  
  /**
   * Sets the value of an evaluation.
   *
   * @param str the value of an evaluation.
   */
  void setAnswer(String str);
  
  /**
   * Add a {@code Calculator} observer.
   */
  void addCalcObserver();
  
  /**
   * Add a {@code Type} observer.
   */
  void addTypeObserver();
}
