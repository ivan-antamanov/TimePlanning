import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeplaner.gui.docs.parents.implpanel.MenuPanel;
import timeplaner.gui.events.handlers.SceneHandlersFactory;
import timeplaner.gui.events.handlers.impl.SceneHandlersFactoryImpl;
import timeplaner.gui.docs.provider.PlanProvider;
import timeplaner.gui.docs.provider.TaskProvider;
import timeplaner.dao.LocalSession;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        setFactories();
        LocalSession session = new LocalSession();
        MenuPanel menuPanel = new MenuPanel();
        Scene scene = new Scene(menuPanel.getHigherPanel(),725, 400);

        PlanProvider planProvider = new PlanProvider(session, scene);
        TaskProvider taskProvider = new TaskProvider(session, scene);
        taskProvider.getParent().setVisible(false);
        taskProvider.getParent().managedProperty().bind(taskProvider.getParent().visibleProperty());

        ((Pane)(scene.getRoot())).getChildren().addAll(planProvider.getPlanParent(), taskProvider.getParent());

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private void setFactories(){
        SceneHandlersFactory.INSTANCE.set(new SceneHandlersFactoryImpl());
    }


    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
