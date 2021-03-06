package uk.ac.rhul.cs2800.calculator;

/**
 * The entry point for the program, logic regarding how the program will appear (GUI or ASCII view)
 * will stem from here.
 *
 * @author Guy Chamberlain-Webber
 */
public class Driver {

  static CalcController calcController;

  /**
   * The main method for the Driver class.
   *
   * @param args the program's arguments.
   */
  public static void main(String[] args) {

    calcController = new CalcController();

    // This determines if the program has been run using a GUI.
    if (System.console() == null) {
      // Launch GUI application
      System.out.println("Running the GUI application.");

      // Initiates a new thread to run the GUI view application on.
      // This code allows the decoupling of the main class and the GuiView class.
      new Thread() {
        @Override
        public void run() {
          javafx.application.Application.launch(GuiView.class);
        }
      }.start();

    } else {
      // Launch ASCII application
      AsciiViewController asciiView = new AsciiViewController();
      calcController.setView(asciiView);
      asciiView.mainMenu();
    }
  }
}
