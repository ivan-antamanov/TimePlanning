package drafts.project;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        StartController startController = new StartController();
        primaryStage.setScene(startController.getMainScene());
        primaryStage.show();
//        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
