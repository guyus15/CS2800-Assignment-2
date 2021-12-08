package uk.ac.rhul.cs2800.calculator;

import java.util.Scanner;

/**
 * The main view for the command-line version of the Calculator. Along with the GuiView, this will
 * be the main way that user's interact with the application.
 *
 * @author Guy Chamberlain-Webber
 */
public class AsciiViewController implements CalcView {
  
  Scanner scanner;
  CalcController observer;
  
  String currentExpression; // The current expression for the calculator to calculate.
  
  /**
   * Creates an instance of the {@code AsciiViewController}.
   */
  public AsciiViewController() {
    scanner = new Scanner(System.in);    
  }
  
  /**
   * The main menu for the ASCII interface, will be the main view of the 
   * ASCII view.
   *
   * @throws BadTypeException this will never be thrown due to the use of a facade.
   * @throws EmptyStackException this be thrown if the current stack is empty.
   * @throws InvalidExpressionException this will be thrown if the given expression is invalid.
   */
  public void mainMenu() {
    
    boolean shouldQuit = false;
    
    while (!shouldQuit) {
      showOptions();
      
      String userInput = scanner.nextLine();
      
      switch (userInput) {
        case "1":
          performCalculation();
          break;
        case "2":
          System.out.println("Switched to infix mode.\n");
          observer.setExpressionType(true);
          break;
        case "3":
          System.out.println("Switched to postfix mode.\n");
          observer.setExpressionType(false);
          break;
        case "4":
          System.out.println("Exited.");
          break;
        default:
          System.out.println("Invalid input. Please enter a value 1-4.");
      }
    }
  }
  
  /**
   * Prints out the calculator options to the user.
   */
  private void showOptions() {
    
    String optionString = "Choose one from the following:\n"
                          + "1) Calculate\n"
                          + "2) Change to infix mode\n"
                          + "3) Change to postfix mode\n"
                          + "4) Exit\n"; 
    
    System.out.println(optionString);
  }
  
  /**
   * Gets an expression from the user and uses it as an expression to be
   * evaluated.
   */
  private void performCalculation() {
    System.out.println("Enter an expression to be calculated: ");
    currentExpression = scanner.nextLine();
    
    try {
      setAnswer("Answer: " + Float.toString(observer.calculate(currentExpression)) + "\n");
    } catch (Exception e) {
      setAnswer(e.getMessage());
    }
  }
  
  /**
   * Gets from input the expression that the user would like to evaluate.
   */
  public String getExpression() {
    return currentExpression;
  }
  
  /**
   * Outputs the value of a successfully evaluated expression.
   */
  public void setAnswer(String str) {
    System.out.println(str);
  }
  
  /**
   * Add a {@code Calculator} observer.
   */
  public void addCalcObserver(CalcController observer) {
    this.observer = observer;
  }
}
