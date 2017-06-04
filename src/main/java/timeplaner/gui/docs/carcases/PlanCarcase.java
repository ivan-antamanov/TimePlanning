package timeplaner.gui.docs.carcases;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadTaskEvent;

import java.util.ArrayList;
import java.util.List;

public class PlanCarcase {


    private Button buttonLoadTask = new Button("Load Task");
    private Button buttonCreateTask = new Button("Create Task");
    private TextField taskIdText = new TextField("0");

    public PlanCarcase() {
        buttonCreateTask.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> EventProcessor.send(new CreateTaskEvent()));
        buttonLoadTask.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                EventProcessor.send(new LoadTaskEvent(Long.valueOf(taskIdText.getText()))));
    }

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

    public void setCreateTaskEventHandler(EventHandler eventCreateTask) {
        buttonCreateTask.addEventHandler(MouseEvent.MOUSE_CLICKED, eventCreateTask);
    }

    public void setLoadTaskEventHandler(EventHandler eventLoadTask) {
        buttonLoadTask.addEventHandler(MouseEvent.MOUSE_CLICKED, eventLoadTask);
    }

    public TextField getTaskIdText() {
        return taskIdText;
    }
}
