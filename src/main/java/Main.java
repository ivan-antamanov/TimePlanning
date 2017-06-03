import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeplaner.gui.auxiliary.panels.MenuPanel;
import timeplaner.gui.events.handlers.SceneHandlersFactory;
import timeplaner.gui.events.handlers.impl.SceneHandlersFactoryImpl;
import timeplaner.gui.provider.PlanProvider;
import timeplaner.gui.provider.TaskProvider;
import timeplaner.dao.LocalSession;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        setFactories();



        LocalSession session = new LocalSession();
        MenuPanel menuPanel = new MenuPanel();
        Scene scene = new Scene(menuPanel);
        PlanProvider planProvider = new PlanProvider(session, scene);
        TaskProvider taskProvider = new TaskProvider(session, scene);
        taskProvider.getParent().setVisible(false);
        ((Pane)(scene.getRoot())).getChildren().addAll(planProvider.getPlanParent(), taskProvider.getParent());

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
