package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This test case tests the Calculator class. 
 *
 * @author chamb
 */
public class CalculatorTest {
  
  @Test // Test 1 
  void testSingleton() {
    
    /*
     * Test that when getInstance() is called and the instance is 
     * null (which it is initially), a new instance of 
     * a Calculator is instantiated.
     */
    assertEquals(Calculator.instance, null); // Initially null
    
    Calculator.getInstance(); // Assign instance when first used.
    
    // Check Calculator instance is now of type Calculator.
    assertEquals(Calculator.instance.getClass(), Calculator.class);
  }
  
  
  @Test // Test 2
  void testInvalidEvaluate() throws InvalidExpressionException {
    /*
     * This test ensures that when an invalid expression string is given
     * as a parameter to the evaluate() method, an InvalidExpressionException 
     * is thrown.
     * 
     * For this test to pass, I had to implement conditions within the evaluate()
     * method which state if a string is invalid. This includes the string being blank,
     * empty, or if it does not contain any integers. I also had to create an
     * InvalidExpressionException if this is true.
     */
    
    assertThrows(InvalidExpressionException.class, () -> Calculator.evaluate("test"));
  }
  
  @Test // Test 3
  void testValidEvaluate() throws InvalidExpressionException {
    /*
     * This test ensures that when a valid expression string is given as 
     * a parameter to the evaluate() method, a fake value of 0 is returned.
     */
    
    assertEquals(Calculator.evaluate("3 2 +"), 0);
  }
}
