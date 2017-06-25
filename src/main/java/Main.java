import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeplaner.gui.docs.parents.implpanel.MenuPanel;
import timeplaner.gui.events.handlers.SceneHandlersFactory;
import timeplaner.gui.events.handlers.impl.SceneHandlersFactoryImpl;
import timeplaner.gui.docs.provider.implprovider.PlanProviderImpl;
import timeplaner.gui.docs.provider.implprovider.TaskProviderImpl;
import timeplaner.dao.LocalSession;

import java.util.logging.Logger;

public class Main extends Application {

    private Logger logger = Logger.getLogger(Main.class.getName());

    public void start(Stage primaryStage) throws Exception {
        logger.info("Start Application");
        setFactories();
        LocalSession session = new LocalSession();
        MenuPanel menuPanel = new MenuPanel();
        Scene scene = new Scene(menuPanel.getHigherPanel(),725, 400);

        PlanProviderImpl planProvider = new PlanProviderImpl(session, scene);
        TaskProviderImpl taskProvider = new TaskProviderImpl(session, scene);
        taskProvider.getParent().setVisible(false);
        taskProvider.getParent().managedProperty().bind(taskProvider.getParent().visibleProperty());

        ((Pane)(scene.getRoot())).getChildren().addAll(planProvider.getPlanParentImpl(), taskProvider.getParent());

        primaryStage.setScene(scene);
        primaryStage.show();
//        primaryStage.setResizable(false);
    }

    private void setFactories(){
        SceneHandlersFactory.INSTANCE.set(new SceneHandlersFactoryImpl());
    }


    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
