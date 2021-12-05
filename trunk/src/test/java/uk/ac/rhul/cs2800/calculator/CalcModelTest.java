package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test tests the CalcModel class.
 *
 * @author chamb
 */
public class CalcModelTest {
  
  CalcModel calcModel;
  
  @BeforeEach
  void createCalcModel() {
    calcModel = new CalcModel();
  }
  
  @Test // Test 1
  void testStateSwitching() {
    /*
     * This test ensures that we run the setType() method on the CalcModel
     * class, the current calculator state toggles between StandardCalc and 
     * RevPolishCalc depending on the isInfix boolean.
     * 
     * To get this test to work correctly, I had to first create the CalcModel class.
     * The CalcModel follows a state design pattern which means that we can obscure the
     * calculator that is used from other classes. I had to add the setType() method
     * which toggles between the two types of calculators.
     */
    
    assertEquals(calcModel.currentCalc.getClass(), StandardCalc.class);
    
    // Switch to RevPolishCalc.
    calcModel.setType(false);
    
    assertEquals(calcModel.currentCalc.getClass(), RevPolishCalc.class);
    
    // Switch to StandardCalc.
    calcModel.setType(true);
    
    assertEquals(calcModel.currentCalc.getClass(), StandardCalc.class);
  }
  
  @Test // Test 2
  void testSwitchStateEvaluation() throws
      InvalidExpressionException,
      EmptyStackException,
      BadTypeException {
    /*
     * This test ensures that when we switch the state of the CalcModel,
     * we can get the correct evaluation of an expression string depending 
     * on the state that the calculator is currently in.
     * 
     * To get this test to work I had to create an evaluate() method in the 
     * CalcModel class which runs the evaluate() method on the currentCalc.
     * This could either be StandardCalc or RevPolishCalc depending on the state.
     */
    
    assertEquals(15, calcModel.evaluate("( 5 * 9 ) / 3"));
    
    // Switch to RevPolishCalc.
    calcModel.setType(false);
    
    assertEquals(15, calcModel.evaluate("5 9 * 3 /"));
    
    // Switch to StandardCalc.
    calcModel.setType(true);

    assertEquals(55, calcModel.evaluate("( 121 / 11 ) * 5"));
  }
  
  @Test // Test 3
  void testWrongExpressionForCurrentState() {
    /*
     * This test ensures that if we try run an expression for the wrong
     * calculator, the corresponding errors are thrown.
     */

    // Switch to RevPolishCalc.
    calcModel.setType(false);
    
    // Try to evaluate an Infix expression should give throw an error.
    assertThrows(InvalidExpressionException.class, () -> calcModel.evaluate("6 * 10"));
  }
}
