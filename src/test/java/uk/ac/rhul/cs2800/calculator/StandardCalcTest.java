package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
     * This tests ensures that an InvalidExpressionException is thrown when 
     * an invalid expression is given as a parameter to evaluate().
     * 
     * To get this test to work I first had to create the StandardCalc class. In order 
     * for an exception be raised when an incorrect expression is given, I also created
     * an InvalidExceptionException to be thrown when this happens. 
     */
    
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("test"));
  }
}
