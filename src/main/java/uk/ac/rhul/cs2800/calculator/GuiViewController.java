package uk.ac.rhul.cs2800.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Binds the GUI components declared in the {@code Calculator} FXML file together.
 * Lets us read and write their values. 
 *
 * @author chamb
 */
public class GuiViewController implements View {
  
  @FXML
  TextField inputText;
  @FXML
  TextField outputText;
  @FXML 
  Button calculateButton;
  @FXML
  RadioButton infixRadio;
  @FXML
  RadioButton postfixRadio;
  
  /**
   * Returns the expression given as input to the {@code inputText} text field.
   */
  public String getExpression() {
    return inputText.getText();
  }
  
  /**
   * Sets the value of the {@code outputText} text field to {@code str}.
   *
   * @param str the value to set the {@code outputText} text field to. 
   */
  public void setAnswer(String str) {
    outputText.setText(str);
  }
  
  
  /**
   * Add a {@code Calculator} observer.
   */
  public void addCalcObserver() {
    return;
  }
  
  /**
   * Add a {@code Type} observer.
   */
  public void addTypeObserver() {
    return;
  }
  
  @FXML
  private void submitExpression(ActionEvent event) {
    event.consume();
    
    System.out.println(getExpression());
    setAnswer("test answer");
  }
}
