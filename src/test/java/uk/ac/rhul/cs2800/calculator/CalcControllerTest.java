package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the {@code CalcController} class. 
 *
 * @author chamb
 */
public class CalcControllerTest {
  
  CalcController observer;
  CalcView observable;
  
  @BeforeEach
  void createObservableAndObserver() {
    observer = new CalcController();
    observable = new GuiViewController();
  }
  
  @Test // Test 1
  void testObservableAndObserver() throws
      InvalidExpressionException,
      EmptyStackException,
      BadTypeException {
    /*
     * This test ensures that the calculate method in the CalcController class
     * works as expected when we set it to observe an observable like the
     * GuiViewController.
     * 
     * To make this test work, I had to first create a CalcController class.
     * This class has a model attribute which references an instance of a model
     * to perform calculations. The class has a calculate() method which calls the model's
     * evaluate() method which is different depending on the calculator state.
     */
    
    observable.addCalcObserver(observer);
    
    assertEquals(5, observer.calculate("( 5 * 2 ) / 2"));
  }
  
  @Test // Test 2
  void testChangingModelType() {
    /*
     * This test ensures that we can set the expression type through the view interface
     * so that the model's calculator state will update when the user presses the 
     * radio buttons.
     * 
     * To make this test pass, I had to create a setExpressionType() method in the CalcController
     * class which takes a boolean (true for infix and false for postfix). This is passed to the
     * class' model attribute which then sets the state of the calculator.
     */
    
    observable.addCalcObserver(observer);

    assertEquals(StandardCalc.class, observer.model.currentCalc.getClass());
    
    // Set the expression type to infix.
    observer.setExpressionType(false);
    
    assertEquals(RevPolishCalc.class, observer.model.currentCalc.getClass());
    
    // Set the expression type to postfix.
    observer.setExpressionType(true);
    
    assertEquals(StandardCalc.class, observer.model.currentCalc.getClass());
  }
}

