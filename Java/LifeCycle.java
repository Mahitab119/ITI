package lifecycle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LifeCycle extends Application {
    public LifeCycle()
    {
        String name = Thread.currentThread().getName();
        System.out.println("CONSTRACTOR CURRENT THREAD IS "+ name);
    }
    @Override
    public void init() throws Exception
    {
        String name = Thread.currentThread().getName();
        System.out.println("INIT CURRENT THREAD IS "+ name);
        super.init();
    }
    @Override
    public void start(Stage primaryStage) {
        String name = Thread.currentThread().getName();
        System.out.println("START CURRENT THREAD IS "+ name);
        
        StackPane root = new StackPane();
        root.getChildren().add(new Text("HELLO LIFE CYCLE"));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop() throws Exception
    {
        String name = Thread.currentThread().getName();
        System.out.println("STOP CURRENT THREAD IS "+ name);
        super.stop();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
