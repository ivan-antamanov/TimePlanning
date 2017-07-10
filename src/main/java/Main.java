import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeplaner.core.events.SceneFactory;
import timeplaner.core.events.handlers.SceneHandlersFactory;
import timeplaner.core.events.handlers.impl.SceneHandlersFactoryImpl;
import timeplaner.gui.docobjets.panel.MenuPanel;
import timeplaner.gui.docobjets.person.PersonProvider;
import timeplaner.gui.docobjets.plan.PlanProvider;
import timeplaner.gui.docobjets.task.TaskProvider;
import timeplaner.plugin.dao.LocalSessionFactoryImpl;

import java.util.logging.Logger;

//import timeplaner.plugin.dao.TODELETE.LocalSession;

public class Main extends Application {

    private Logger logger = Logger.getLogger(Main.class.getName());
    Scene generalScene;
    MenuPanel menuPanel = new MenuPanel();


    public void start(Stage primaryStage) throws Exception {
        logger.info("Start Application");
        LocalSessionFactoryImpl session = new LocalSessionFactoryImpl();
        generalScene = new Scene(menuPanel.getHigherPanel(),725, 400);
        setFactories();

        PersonProvider personProvider = new PersonProvider(session);
        PlanProvider planProvider = new PlanProvider(session);
        TaskProvider taskProvider = new TaskProvider(session);

        planProvider.getNode().setVisible(false);
        planProvider.getNode().managedProperty().bind(planProvider.getNode().visibleProperty());
        taskProvider.getNode().setVisible(false);
        taskProvider.getNode().managedProperty().bind(taskProvider.getNode().visibleProperty());

        ((Pane)(generalScene.getRoot())).getChildren().addAll(planProvider.getNode(), taskProvider.getNode(), personProvider.getNode());

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
