package drafts.project;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;


public class StartController {

    private Scene startScene;
    private TaskController taskController = new TaskController();


    private Button buttonLoadTask = new Button("Load Task");
    private Button buttonCreateTask = new Button("Create Task");
    private TextField taskIdText = new TextField("0");

    private EventHandler loadTaskEvent = new EventHandler() {
        public void handle(Event event) {
            System.out.println("Button \"Load Task\" was pressed");
            Parent taskParent = getTaskParentViewById(Integer.parseInt(taskIdText.getText()));
            startScene.setRoot(taskParent);
        }
    };

    private EventHandler createTaskEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            System.out.println("Button \"Create new Task\" was pressed");
            Parent taskParent = getTaskNewTaskParent();
            startScene.setRoot(taskParent);
        }
    };



    public Scene getStartScene() {
        startScene = new Scene(getParent());
        return startScene;
    }

    private Parent getTaskParentViewById(int taskId) {
        return taskController.returnTaskParentById(taskId);
    }

    private Parent getTaskNewTaskParent(){
        return taskController.returnNewTaskParent();
    }

    private Parent getParent() {
        registrationMouseClicked(loadTaskEvent, buttonLoadTask);
        registrationMouseClicked(createTaskEvent,buttonCreateTask);
        FlowPane startPane = new FlowPane();
        startPane.setOrientation(Orientation.HORIZONTAL);
        startPane.setAlignment(Pos.CENTER);
        startPane.setMinSize(600,600);
        startPane.setMaxSize(800,800);
        startPane.setMaxSize(800,800);
        startPane.getChildren().add(buttonCreateTask);
        startPane.getChildren().add(buttonLoadTask);
        startPane.getChildren().add(taskIdText);
        return startPane;
    }

    private void registrationMouseClicked(EventHandler eventHandler, Parent component){
        component.addEventHandler(MouseEvent.MOUSE_CLICKED ,eventHandler);
    }
}
