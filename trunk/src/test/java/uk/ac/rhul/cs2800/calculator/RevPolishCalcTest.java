package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the RevPolishCalc class.
 *
 * @author Guy Chamberlain-Webber
 */
public class RevPolishCalcTest {

  RevPolishCalc revPolishCalc;

  @BeforeEach
  void createRevPolishCalc() {
    revPolishCalc = new RevPolishCalc();
  }

  @Test // Test 1
  void testInvalidEvaluation() {
    /*
     * This test ensures that an InvalidExpressionException is thrown when an invalid expression is
     * given as a parameter to evaluate().
     * 
     * To get this test to work I first had to create the StandardCalc class with an evaluate method
     * which inherits from the Calculator super class.
     */

    assertThrows(InvalidExpressionException.class, () -> revPolishCalc.evaluate("test"));
  }

  @Test // Test 2
  void testValidEvaluation()
      throws InvalidExpressionException, BadTypeException, EmptyStackException {
    /*
     * This test ensures that the evaluate method of the RevPolishCalc class returns the correct
     * answer of the String expression.
     */

    assertEquals(63, revPolishCalc.evaluate("5 6 7 + * 2 -"));
    assertEquals(8, revPolishCalc.evaluate("5 2 * 2 -"));
  }

  @Test // Test 7
  void testEvaluationWithUnbalancedOperands() {
    /*
     * This test ensures that the evaluate method of the RevPolishCalc class throws an
     * InvalidExpressionException if the operands of an expression are unbalanced (i.e. 3 + ...).
     * 
     * To make this test work, I had to add a check at the end of the evaluate method of the
     * RevPolishCalc class which determines if the number stack still contains more than one item.
     * If it does, then the given expression is invalid so it will throw an
     * InvalidExpressionException.
     */

    // These should not be valid as they contain unbalanced operands.
    assertThrows(InvalidExpressionException.class, () -> revPolishCalc.evaluate("3 +"));
    assertThrows(InvalidExpressionException.class,
        () -> revPolishCalc.evaluate("3 5 76 5 + - / - -"));
    assertThrows(InvalidExpressionException.class,
        () -> revPolishCalc.evaluate("3 4 5 4 3 3 - / *"));
  }

  @Test // Test 3
  void testPerformOperation() {
    /*
     * This test ensures that the correct result is returned for each operation passed into the
     * performOperation method of the RevPolishCalc class.
     */

    assertEquals(35, revPolishCalc.performOperation(7, 5, Symbol.TIMES));
    assertEquals(2, revPolishCalc.performOperation(10, 5, Symbol.DIVIDE));
    assertEquals(20, revPolishCalc.performOperation(13, 7, Symbol.PLUS));
    assertEquals(22, revPolishCalc.performOperation(54, 32, Symbol.MINUS));

  }

  @Test // Test 4
  void testPerformOperationInvalidSymbol() {
    /*
     * This test ensures that calling the performOperation method returns the Float.MAX_VALUE when
     * the passed symbol is invalid.
     */

    assertEquals(Float.MAX_VALUE, revPolishCalc.performOperation(0, 0, Symbol.INVALID));
  }

  @Test // Test 5
  void testPerformOperationZeroDivision() {
    /*
     * This test ensures that a divide by zero error is thrown if we are trying to divide by zero.
     */

    assertThrows(ArithmeticException.class,
        () -> revPolishCalc.performOperation(5, 0, Symbol.DIVIDE));
  }

  @Test // Test 6
  void testPerformOperationNegativeNumbers() {
    /*
     * This test ensures that for each operation, using negative numbers has the correct outcome.
     */

    assertEquals(-35, revPolishCalc.performOperation(7, -5, Symbol.TIMES));
    assertEquals(-2, revPolishCalc.performOperation(10, -5, Symbol.DIVIDE));
    assertEquals(6, revPolishCalc.performOperation(13, -7, Symbol.PLUS));
    assertEquals(86, revPolishCalc.performOperation(54, -32, Symbol.MINUS));
  }

}
