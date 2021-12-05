package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the Driver class.
 *
 * @author chamb
 */
public class DriverTest {

  // We keep track of the original system output so we can reset it after each test.
  final PrintStream standardOut = System.out;
  // We set up a output captor so we can see what the program outputs
  final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    // Here, we assign our custom outputCaptor to the output stream.
    System.setOut(new PrintStream(outputCaptor));
  }

  @Test
  void testGuiOutput() {
    /*
     * This test ensures that when we run the application with the GUI (this is the default mode),
     * that the output suits the branch of the condition statement which launches the JavaFX GUI.
     */

    Driver.main(null);

    if (System.console() == null) {
      // Checking that the output is as expected (GUI view).
      assertEquals("Running the GUI application.", outputCaptor.toString().trim());
    } else {
      // Checking that the output is as expected (ASCII view).
      assertEquals("Running the ASCII application.", outputCaptor.toString().trim());
    }
  }

  @AfterEach
  void reset() {
    // Here, we reset the output stream to the original standard out.
    System.setOut(standardOut);
  }

}
