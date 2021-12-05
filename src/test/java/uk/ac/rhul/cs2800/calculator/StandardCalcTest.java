package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the StandardCalc class. 
 *
 * @author chamb
 */
public class StandardCalcTest {
  
  StandardCalc stdCalc;
  
  @BeforeEach
  void createStandardCalc() {
    stdCalc = new StandardCalc();
  }
  
  @Test // Test 1
  void testInvalidExpression() {
    /*
     * This test ensures that an InvalidExpressionException is thrown when 
     * an invalid expression is given as a parameter to evaluate().
     * 
     * To get this test to work I first had to create the StandardCalc class. In order 
     * for an exception be raised when an incorrect expression is given, I also created
     * an InvalidExceptionException to be thrown when this happens. 
     */
    
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("test"));
  }
  
  @Test // Test 2
  void testValidExpression()
      throws 
      InvalidExpressionException, 
      BadTypeException, 
      EmptyStackException {
    /*
     * This test ensures that the stringToEvaluate is successfully converted 
     * to Postfix notation and passed to an instance of the RevPolishCalc's evaluate()
     * method with the correct answer.
     * 
     */
    
    assertEquals(8, stdCalc.evaluate("( 5 * 2 ) - 2"));
    
  }
  
  @Test // Test 5
  void testZeroDivisionExpression() {
    /*
     * This test ensures that when we try to divide by zero, we will get an
     * InvalidExpressionException thrown.
     */
    
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("10 / 0"));
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("( 5 / 0 ) + 1"));
  }
  
  @Test // Test 6
  void testNegativeNumbersExpression()
      throws
      InvalidExpressionException,
      BadTypeException,
      EmptyStackException {
    /*
     * This test ensures that for each operation, using negative
     * numbers has the correct outcome.
     */
    
    assertEquals(2, stdCalc.evaluate("5 + -3"));
    assertEquals(-10, stdCalc.evaluate("( -10 + -20 ) / 3"));
    assertEquals(49, stdCalc.evaluate("-7 * -7"));
    assertEquals(2, stdCalc.evaluate("-3 + 5"));
    assertEquals(2, stdCalc.evaluate("( -3 ) + 5"));
  }
  
  @Test // Test 3
  void testConvertInfixToPostfix() throws
      InvalidExpressionException,
      BadTypeException,
      EmptyStackException {
    /*
     * This test will ensure that the convert() method will correctly convert a Infix 
     * expression string to a Postfix expression string.
     * 
     * To make this test work, I had to implement a convert method in the StandardCalc class
     * which converts infix expressions into postfix expressions. The method uses an operator
     * stack to keep track of the operation order.
     */
    
    // Checking that the conversion works with a variety of expressions.
    assertEquals("5 3 10 * +", stdCalc.convert("5 + 3 * 10"));
    assertEquals("5 6 7 + * 2 -", stdCalc.convert("( 5 * ( 6 + 7 ) ) - 2"));
    assertEquals("5 10 * 22 1 - +", stdCalc.convert("( 5 * 10 ) + ( 22 - 1 )"));
    assertEquals("5 10 0.1 * 10 + /", stdCalc.convert("5 / ( 10 * 0.1 ) + 10"));
    assertEquals("5 6 7 + 8 + *", stdCalc.convert("5 * ( ( 6 + 7 ) + 8 )"));
  }
  
  @Test // Test 4
  void testConvertInfixToPostfixWithInvalidStrings()
      throws
      InvalidExpressionException,
      BadTypeException,
      EmptyStackException {
    
    /*
     * This test ensures that an InvalidExpressionException will be thrown if 
     * we try and enter an invalid string as a parameter for the convert() method.
     */
    
    // These should not be valid as they contain non-numerical characters that aren't symbols.
    assertThrows(InvalidExpressionException.class, () -> stdCalc.convert("a + b"));
    assertThrows(InvalidExpressionException.class, () -> stdCalc.convert("( 5 + b ) / 10"));
    
  }
  
  @Test // Test 5
  void testConvertInfixToPostfixWithUnbalancedOperands() {
    /*
     * This test ensures that an InvalidExpressionException will be thrown if
     * we try and enter an expression string which does not have balanced operands
     * (i.e. 3 + ...)
     * 
     * To make this test work I had to add a try...catch statement to the RevPolishCalc's
     * evaluate method. This ensures that if an Exception occurs (this will happen
     * if there are unbalanced operands), an InvalidExpressionException will occur.
     */
    
    // These should not be valid as they contain unbalanced operands.
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("3 +"));
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("(10 / 2) +"));
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("10 * 9 * /"));
  }
}
