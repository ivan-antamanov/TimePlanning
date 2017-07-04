package timeplaner.gui.docs.skeletons.impl;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import timeplaner.entities.auxiliary.Priority;
import timeplaner.entities.auxiliary.Status;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.SceneFactory;
import timeplaner.gui.docs.parents.impldoc.PlanParent;
import timeplaner.gui.docs.skeletons.AbstractSkeleton;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.events.events.taskevents.SaveTaskEvent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.*;

public class TaskSkeleton extends AbstractSkeleton<TaskSkeleton, Task> {

protected TextField mainDocument = new TextField(); //todo take out instantiating
    protected ChoiceBox<String> priorityChoiceBox = new ChoiceBox<>();
    protected ChoiceBox<String> statusChoiceBox = new ChoiceBox<>();
    protected TextField taskPeriod = new TextField();
    protected TextField linkedTask = new TextField();
    protected Button saveButton ;

    public TaskSkeleton() {
        registrationEvents();
    }

    @Override
    protected void registrationEvents() {
        priorityChoiceBox = new ChoiceBox<>();
        statusChoiceBox = new ChoiceBox<>();
        priorityChoiceBox.getItems().addAll(Priority.getAllNames());
        statusChoiceBox.getItems().addAll(Status.getAllNames());
        saveButton = new Button("Save Task");
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            EventProcessor.send(new SaveTaskEvent());
        });
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                EventProcessor.send(new ChangeChildrenVisibilityEvent(PlanParent.class, SceneFactory.INSTANCE.get())));
    }

    @Override
    public TaskSkeleton newSkeleton(Task task) {
        name.clear();
//        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
//        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        description.clear();
        creationDate.setText(task.getCreateDate().toString());
        id.setText(String.valueOf(task.getId()));
        return this;
    }

    @Override
    public TaskSkeleton updateSkeleton(Task task) {//fixme: not create new object
        name = new TextField(task.getName());
        priorityChoiceBox.getSelectionModel().select(  task.getPriority().getName());
        statusChoiceBox.getSelectionModel().select(task.getStatus().getName());
        description = new TextArea(task.getDescription());
        creationDate.setText(task.getCreateDate().toString());
        id.setText(task.getId().toString());
        return this;
    }

    @Override
    public Task getDocument() {
        Task task = new Task(name.getText(), description.getText());
        Priority priority = Priority.getByName(priorityChoiceBox.getValue());
        Status status = Status.getByName(statusChoiceBox.getValue());
        task.setPriority(priority);
        task.setStatus(status);
        return task;
    }

    public Map<Text, Control> getLabelAndControlMapLeft() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        getLabelAndControlMap.putIfAbsent(NAME_LABEL.getTextLabel(), name);
        getLabelAndControlMap.putIfAbsent(PRIORITY_LABEL.getTextLabel(), priorityChoiceBox);
        getLabelAndControlMap.putIfAbsent(STATUS_LABEL.getTextLabel(), statusChoiceBox);

        return getLabelAndControlMap;
    }

    public Map<Text, Text> getConstantLabelsMap(){
        Map<Text, Text> getLabelsMap = new LinkedHashMap<>();
        getLabelsMap.putIfAbsent(ID_LABEL.getTextLabel(), id);
        getLabelsMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), creationDate);
        return getLabelsMap;
    }

    public Map<Text, Control> getLabelAndControlMapCenter() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        customizeDescription(description);
        getLabelAndControlMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), description);

        return getLabelAndControlMap;
    }

    public Map<Text, Control> getLabelAndControlMapBottom() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        getLabelAndControlMap.putIfAbsent(LINKED_TASK_LABEL.getTextLabel(), linkedTask);

        return getLabelAndControlMap;
    }

    private TextArea customizeDescription(TextArea taskDescription) {
        taskDescription.autosize();
//        taskDescription.setMinWidth(120);
        return taskDescription;
    }

    public List<Button> getButtonsBottom() {
        List<Button> buttons = new ArrayList<>(0);
        customizeSaveButton(saveButton);
        buttons.add(saveButton);
//        buttons.add(backButton);
        return buttons;
    }

    public Button customizeSaveButton(Button saveButton) {
        saveButton.setAlignment(Pos.TOP_CENTER);
//        saveButton.addEventFilter();
        return saveButton;
    }
}
