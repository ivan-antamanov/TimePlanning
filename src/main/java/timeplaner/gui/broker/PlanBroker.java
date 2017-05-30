package timeplaner.gui.broker;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import timeplaner.controller.PlanController;
import timeplaner.controller.TaskController;
import timeplaner.documents.subdocuments.impl.Task;
import timeplaner.gui.layouts.TaskLayout;

import java.util.ArrayList;
import java.util.List;

public class PlanBroker {

//    private PlanController planController;

//    public PlanBroker(PlanController planController) {
//        this.planController = planController;
//    }

    private Button buttonLoadTask = new Button("Load Task");
    private Button buttonCreateTask = new Button("Create Task");
    private TextField taskIdText = new TextField("0");


//
//    private Parent updateScene(Parent parentTask){
//        planController.getGeneralScene().setRoot(parentTask);
//        return parentTask;
//    }

    public List<Control> getControlBottom() { //fixme there should be only buttons
        List<Control> controls = new ArrayList<>(0);
        customizeCreateTaskButton(buttonCreateTask);
        customizeLoadButton(buttonLoadTask);
        controls.add(buttonCreateTask);
        controls.add(buttonLoadTask);
        controls.add(taskIdText);
        return controls;
    }

    private Button customizeLoadButton(Button loadButton) {
        loadButton.setAlignment(Pos.BOTTOM_RIGHT);
        return loadButton;
    }

    private Button customizeCreateTaskButton(Button createTaskButton) {
        createTaskButton.setAlignment(Pos.BOTTOM_RIGHT);
        return createTaskButton;
    }

    public void setCreateTaskEvent(EventHandler eventCreateTask){
        buttonCreateTask.addEventHandler(MouseEvent.MOUSE_CLICKED, eventCreateTask);
    }

    public void setLoadTaskEvent(EventHandler eventLoadTask){
        buttonLoadTask.addEventHandler(MouseEvent.MOUSE_CLICKED, eventLoadTask);
    }

    public TextField getTaskIdText() {
        return taskIdText;
    }
}
