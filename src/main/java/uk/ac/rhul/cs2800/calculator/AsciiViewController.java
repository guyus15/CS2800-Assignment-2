package uk.ac.rhul.cs2800.calculator;

import java.util.Scanner;

/**
 * The main view for the command-line version of the Calculator. Along with the GuiView,
 * this will be the main way that user's interact with the application.
 *
 * @author chamb
 */
public class AsciiViewController implements CalcView {
  
  Scanner scanner;
  
  /**
   * Creates an instance of the {@code AsciiViewController}.
   */
  public AsciiViewController() {
    scanner = new Scanner(System.in);
  }
  
  /**
   * Gets from input the expression that the user would like to evaluate.
   */
  public String getExpression() {
    System.out.println("Enter an expression to be evaluated: ");
    return scanner.nextLine();
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
  public void addCalcObserver() {
    return;
  }

  
  /**
   * Add a {@code Type} observer.
   */
  public void addTypeObserver() {
    return;
  }
  
}
