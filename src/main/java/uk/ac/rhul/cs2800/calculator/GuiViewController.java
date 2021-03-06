package uk.ac.rhul.cs2800.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Binds the GUI components declared in the {@code Calculator} FXML file together. Lets us read and
 * write their values.
 *
 * @author Guy Chamberlain-Webber
 */
public class GuiViewController implements CalcView {

  /**
   * The input field of the GUI, this is where the use will enter expressions.
   */
  @FXML
  TextField inputText;

  /**
   * The output field of the GUI, this is where the result of the calculation will be displayed.
   */
  @FXML
  TextField outputText;


  /**
   * The calculate button. The user will press this to calculate their entered expression.
   */
  @FXML
  Button calculateButton;

  /**
   * The infix radio button. The user will press this to calculate infix expressions.
   */
  @FXML
  RadioButton infixRadio;


  /**
   * The postfix radio button. The user will press this to calculate postfix expressions.
   */
  @FXML
  RadioButton postfixRadio;


  CalcController observer;

  /**
   * Called upon the controller's initialisation. Sets the state of the radio buttons.
   */
  public void initialize() {
    infixRadio.setSelected(true); // Initially selected.
    postfixRadio.setSelected(false); // Initially unselected.
  }

  /**
   * Returns the expression given as input to the {@code inputText} text field.
   */
  public String getExpression() {
    return inputText.getText();
  }

  /**
   * Set the output text of the GUI.
   */
  public void setAnswer(String text) {
    outputText.setText(text);
  }

  /**
   * Assign a {@code Calculator} observer.
   */
  public void addCalcObserver(CalcController observer) {
    this.observer = observer;
  }

  /**
   * Responsible for notifying the CalcController observer that we want to perform a calculation.
   *
   * @param event the button click event.
   */
  @FXML
  private void submitExpression(ActionEvent event) {
    event.consume();

    try {
      String answer = Float.toString(observer.calculate(inputText.getText()));
      setAnswer(answer);

      outputText.setStyle("-fx-background-color: white;"); // Reset red error background colour.
    } catch (Exception e) {
      setAnswer(e.getMessage());

      outputText.setStyle("-fx-background-color: red;"); // Set red error background colour.
    }
  }

  /**
   * Sets the mode of the calculator to calculate infix expressions.
   *
   * @param event the event associated with the button press.
   */
  @FXML
  private void setToInfix(ActionEvent event) {
    event.consume();

    // Set the expression type to be infix.
    observer.setExpressionType(true);

    // Resetting the opposite button so it doesn't look like its active.
    postfixRadio.setSelected(false);
  }


  /**
   * Sets the mode of the calculator to calculate postfix expressions.
   *
   * @param event the event associated with the button press.
   */
  @FXML
  private void setToPostfix(ActionEvent event) {
    event.consume();

    // Set the expression type to be postfix.
    observer.setExpressionType(false);

    // Resetting the opposite button so it doesn't look like its active.
    infixRadio.setSelected(false);
  }
}
