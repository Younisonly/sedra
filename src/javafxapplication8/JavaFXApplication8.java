package javafxapplication8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication8 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MainScreen mainScreen = new MainScreen();
        
        Scene scene = new Scene(mainScreen, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
