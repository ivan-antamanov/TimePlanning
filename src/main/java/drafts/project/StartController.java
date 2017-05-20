package drafts.project;


import entities.documents.subdocuments.impl.Task;
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

import java.text.ParseException;


public class StartController {

    private Scene startScene;

    private Button buttonLoadTask = new Button("Load Task");
    private TextField taskIdText = new TextField("0");

    private EventHandler loadTaskEvent = new EventHandler() {
        public void handle(Event event) {
            System.out.println("Button was pressed");
            Parent taskParent = getTaskParentView(Integer.parseInt(taskIdText.getText()));
            startScene.setRoot(taskParent);
        }
    };

    public Scene getStartScene() {
        startScene = new Scene(getParent());
        return startScene;
    }

    private Task getTask(int taskId) {
        try {
            return ActionLoader.findTaskById(taskId);
        } catch (ParseException e) {
            System.out.println("WARNING: Value is not number"); //to move try-catch date to another class
        }
        return null;
    }

    private Parent getTaskParentView(int taskId) {
        Task task = getTask(taskId);
        TaskController taskController = new TaskController(task);
        return taskController.returnTaskParent();
    }

    private Parent getParent() {
        registrationMouseClicked(loadTaskEvent, buttonLoadTask);
        FlowPane startPane = new FlowPane();
        startPane.setOrientation(Orientation.HORIZONTAL);
        startPane.setAlignment(Pos.CENTER);
        startPane.setMinSize(500,500);
        startPane.getChildren().add(buttonLoadTask);
        startPane.getChildren().add(taskIdText);
        return startPane;
    }

    private void registrationMouseClicked(EventHandler eventHandler, Parent component){
        component.addEventHandler(MouseEvent.MOUSE_CLICKED ,eventHandler);
    }
}
