import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import timeplaner.controller.PlanController;
import javafx.application.Application;
import javafx.stage.Stage;
import timeplaner.gui.GeneralScene;
import timeplaner.gui.broker.PlanBroker;
import timeplaner.gui.layouts.PlanLayout;
import timeplaner.gui.nodes.PlanParent;
import timeplaner.gui.nodes.TaskParent;
import timeplaner.plugin.LocalSession;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        LocalSession session = new LocalSession();
        PlanParent planParent = new PlanParent(session);
        TaskParent taskParent = new TaskParent(session);
        taskParent.setVisible(false);
        GeneralScene generalScene = new GeneralScene(getHigherPanel());
        generalScene.setParentList(planParent.getPlanParent(), taskParent);

        primaryStage.setScene(generalScene);
        primaryStage.show();
//        primaryStage.setResizable(false);
    }

    private MenuBar getMenu() { //todo rebuild
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");

        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        menuFile.getItems().addAll(saveItem, exitItem);

        Menu menuOptions = new Menu("Option");
        MenuItem badSightedItem = new MenuItem("Bad-Sighted version");

        menuOptions.getItems().addAll(badSightedItem);

        menuBar.getMenus().addAll(menuFile, menuOptions);
        return menuBar;
    }

    private Pane getHigherPanel() {
        VBox menuPane = new VBox(getMenu());
        menuPane.setVisible(true);
        menuPane.setAlignment(Pos.TOP_CENTER);
        return menuPane;
    }







    public static void main(String[] args) {
        launch(Main.class, args);
    }

}
