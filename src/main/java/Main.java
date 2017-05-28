import timeplaner.controller.PlanController;
import javafx.application.Application;
import javafx.stage.Stage;
import timeplaner.gui.GeneralScene;
import timeplaner.gui.broker.PlanBroker;
import timeplaner.gui.layouts.PlanLayout;
import timeplaner.plugin.LocalSession;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        LocalSession session = new LocalSession();
        PlanController planController = new PlanController(session);
        PlanBroker planBroker = new PlanBroker(planController);
        PlanLayout planLayout = new PlanLayout(planBroker);
        GeneralScene generalScene = new GeneralScene(planLayout.returnButtonPlanParent(planBroker.getControlBottom()));
        primaryStage.setScene(generalScene.getScene());
        primaryStage.show();
//        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
