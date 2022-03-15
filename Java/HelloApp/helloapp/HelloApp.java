package helloapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Reflection reflection = new Reflection();
       reflection.setFraction(0.7);
       Text txt = new Text("Hello World");
       txt.setFill(Color.RED);
       txt.setFont(Font.font("sans-serif", FontWeight.BOLD, 30));
       txt.setEffect(reflection);
        
       Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE),new Stop(1, Color.BLACK)};
       LinearGradient lg = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
       StackPane root = new StackPane();
       root.getChildren().add(txt);

        Scene scene = new Scene(root, 300, 250);
        scene.setFill(lg);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
