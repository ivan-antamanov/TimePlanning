package drafts.common;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by iantaman on 15.05.2017.
 */
public class TestController extends Application {


    public void start(Stage primaryStage) throws Exception {
              Controller controller = new Controller();
              primaryStage.setScene(controller.getConcreteScene());
              primaryStage.show();
                  }
}
