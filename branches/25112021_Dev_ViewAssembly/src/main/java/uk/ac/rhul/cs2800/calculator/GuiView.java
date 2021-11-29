package uk.ac.rhul.cs2800.calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main GUI view for the Calculator. Along with the ASCII view, this will be the way that user's
 * interact with the application.
 *
 * @author chamb
 */
public class GuiView extends Application {
  
  static FXMLLoader loader;
  
  @Override
  public void start(Stage primaryStage) {
    Parent root;
    
    try {
      loader = new FXMLLoader();
      loader.setClassLoader(getClass().getClassLoader());
      loader.setLocation(getClass().getClassLoader().getResource("Calculator.fxml"));
      
      root = loader.load();
      
    } catch (IOException e) {
      
      e.printStackTrace();
      return;
    }
        
    Scene scene = new Scene(root, 600, 400);

    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
