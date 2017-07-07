import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeplaner.plugin.dao.LocalSessionFactoryImpl;
import timeplaner.core.events.SceneFactory;
import timeplaner.gui.docoperators.panel.MenuPanel;
import timeplaner.gui.docoperators.person.PersonProvider;
import timeplaner.gui.docoperators.task.TaskProvider;
import timeplaner.core.events.handlers.SceneHandlersFactory;
import timeplaner.core.events.handlers.impl.SceneHandlersFactoryImpl;
import timeplaner.gui.docoperators.plan.PlanProvider;
//import timeplaner.plugin.dao.TODELETE.LocalSession;

import java.util.logging.Logger;

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
