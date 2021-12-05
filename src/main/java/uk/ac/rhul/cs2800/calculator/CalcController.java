package uk.ac.rhul.cs2800.calculator;

/**
 * Links together the model and view elements of the calculator to
 * allow them to behave together. Implements the observer design pattern.
 *
 * @author chamb
 */
public class CalcController {
  CalcModel model;
  CalcView view;
  
  
  /**
   * The constructor for the CalcController class.
   */
  public CalcController() {
    model = new CalcModel();
    view = new GuiViewController();
    
    view.addCalcObserver(this);
  }
  
  /**
   * Set the view of the CalcController.
   *
   * @param view the view for the CalcController's view to be set to.
   */
  public void setView(CalcView view) {
    /*
     * This method had to be created so we could set the view after the CalcController
     * had already been created. Otherwise, the view instance of this class would 
     * not be any use to us.
     */
    
    this.view = view;
    view.addCalcObserver(this);
  }
  
  /**
   * Is notified when a calculation is required.
   *
   * @return the resulting expression of the calculation.
   * @throws BadTypeException will never be thrown due to the use of a facade.
   * @throws EmptyStackException will be thrown if the stack is empty.
   * @throws InvalidExpressionException will be thrown if the give expression is invalid.
   */
  public float calculate(String expression) throws
      InvalidExpressionException,
      EmptyStackException,
      BadTypeException {
    return model.evaluate(expression);
  }
  
  /**
   * Is notified when a change of the expression type is indicated.
   */
  public void setExpressionType(boolean isInfix) {
    model.setType(isInfix);
  }
}
