package drafts.project;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class StartController {

    private GeneralScene mainScene;
    private TaskController taskController = new TaskController();


    private Button buttonLoadTask = new Button("Load Task");
    private Button buttonCreateTask = new Button("Create Task");
    private TextField taskIdText = new TextField("0");

    private EventHandler loadTaskEvent = new EventHandler() {
        public void handle(Event event) {
            System.out.println("Button \"Load Task\" was pressed");
            Parent taskParent = getTaskParentViewById(Integer.parseInt(taskIdText.getText()));
            updateScene(taskParent);
            getMainScene();
        }
    };

    private EventHandler createTaskEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            System.out.println("Button \"Create new Task\" was pressed");
            Parent taskParent = getTaskNewTaskParent();
            updateScene(taskParent);
            getMainScene();
        }
    };

    private MenuBar getMenu(){ //todo rebuild
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");

        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        menuFile.getItems().addAll(saveItem,exitItem);

        Menu menuOptions = new Menu("Option");
        MenuItem badSightedItem = new MenuItem("Bad-Sighted version");

        menuOptions.getItems().addAll(badSightedItem);

        menuBar.getMenus().addAll(menuFile, menuOptions);
        return menuBar;
    }

    private Pane getHigherPanel(){
        VBox menuPane = new VBox(getMenu());
        menuPane.setVisible(true);
        menuPane.setAlignment(Pos.TOP_CENTER);
        return menuPane;
    }

    public GeneralScene updateScene(Parent parent){
        mainScene.setRoot(getHigherPanel());
        this.setRoot(parent);
        return mainScene;

    }


    public Scene getMainScene() {
        mainScene = new GeneralScene(getHigherPanel());
        this.setRoot(getStartParent());
        return mainScene;
    }

    public void setRoot(Parent parent){
        ((Pane) mainScene.getRoot()).getChildren().addAll( parent);
    }

    private Parent getTaskParentViewById(int taskId) {
        return taskController.returnTaskParentById(taskId);
    }

    private Parent getTaskNewTaskParent(){
        return taskController.returnNewTaskParent();
    }

    private Parent getStartParent() {
        registrationMouseClicked(loadTaskEvent, buttonLoadTask);
        registrationMouseClicked(createTaskEvent,buttonCreateTask);
        FlowPane startPane = new FlowPane();
        startPane.setOrientation(Orientation.HORIZONTAL);
        startPane.setAlignment(Pos.CENTER);
        startPane.setMinSize(600,600);
        startPane.setMaxSize(820,820);
        startPane.getChildren().add(buttonCreateTask);
        startPane.getChildren().add(buttonLoadTask);
        startPane.getChildren().add(taskIdText);
        return startPane;
    }

    private void registrationMouseClicked(EventHandler eventHandler, Parent component){
        component.addEventHandler(MouseEvent.MOUSE_CLICKED ,eventHandler);
    }
}
