import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeplaner.gui.SceneFactory;
import timeplaner.gui.docs.parents.implpanel.MenuPanel;
import timeplaner.gui.events.handlers.SceneHandlersFactory;
import timeplaner.gui.events.handlers.impl.SceneHandlersFactoryImpl;
import timeplaner.gui.docs.provider.implprovider.PlanProviderImpl;
import timeplaner.gui.docs.provider.implprovider.TaskProviderImpl;
import timeplaner.dao.LocalSession;

import java.util.logging.Logger;

public class Main extends Application {

    private Logger logger = Logger.getLogger(Main.class.getName());
    Scene generalScene;
    MenuPanel menuPanel = new MenuPanel();


    public void start(Stage primaryStage) throws Exception {
        logger.info("Start Application");
        LocalSession session = new LocalSession();
        generalScene = new Scene(menuPanel.getHigherPanel(),725, 400);
        setFactories();

        PlanProviderImpl planProvider = new PlanProviderImpl(session, generalScene);
        TaskProviderImpl taskProvider = new TaskProviderImpl(session, generalScene);
        taskProvider.getNode().setVisible(false);
        taskProvider.getNode().managedProperty().bind(taskProvider.getNode().visibleProperty());

        ((Pane)(generalScene.getRoot())).getChildren().addAll(planProvider.getPlanParentImpl(), taskProvider.getNode());

        primaryStage.setScene(generalScene);
        primaryStage.show();
//        primaryStage.setResizable(false);
    }

    private void setFactories(){
        SceneHandlersFactory.INSTANCE.set(new SceneHandlersFactoryImpl());
        SceneFactory.INSTANCE.set(generalScene);
    }


    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
