package javafx_test;/**
 * Created by iantaman on 09.02.2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Title");

        final Parameters params = getParameters();
        final List<String> parameters = params.getRaw();
        final String imageUrl = !parameters.isEmpty() ? parameters.get(0) : "";

        primaryStage.show();
    }
}
