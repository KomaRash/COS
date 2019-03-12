package Sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GraphsGroupForm group = new GraphsGroupForm();

        Scene scene = new Scene(group);
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.setTitle("Fourier Transform");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}