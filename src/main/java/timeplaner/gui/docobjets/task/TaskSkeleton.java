package timeplaner.gui.docobjets.task;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import timeplaner.core.AbstractSkeleton;
import timeplaner.core.entities.auxiliary.Priority;
import timeplaner.core.entities.auxiliary.Status;
import timeplaner.core.entities.subdocuments.impl.TaskDocument;
import timeplaner.core.events.EventProcessor;
import timeplaner.core.events.SceneFactory;
import timeplaner.core.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.docobjets.plan.PlanParent;
import timeplaner.gui.docobjets.task.events.SaveTaskEvent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.*;

public class TaskSkeleton extends AbstractSkeleton<TaskSkeleton, TaskDocument> {

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
        saveButton = new Button("Save TaskDocument");
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            EventProcessor.send(new SaveTaskEvent());
        });
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                EventProcessor.send(new ChangeChildrenVisibilityEvent(PlanParent.class, SceneFactory.INSTANCE.get())));
    }

    @Override
    public TaskSkeleton newSkeleton(TaskDocument taskDocument) {
        name.clear();
//        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
//        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        description.clear();
        creationDate.setText(taskDocument.getCreateDate().toString());
        id.setText(String.valueOf(taskDocument.getId()));
        return this;
    }

    @Override
    public TaskSkeleton updateSkeleton(TaskDocument taskDocument) {//fixme: not create new object
        name = new TextField(taskDocument.getName());
        priorityChoiceBox.getSelectionModel().select(  taskDocument.getPriority().getName());
        statusChoiceBox.getSelectionModel().select(taskDocument.getStatus().getName());
        description = new TextArea(taskDocument.getDescription());
        creationDate.setText(taskDocument.getCreateDate().toString());
        id.setText(taskDocument.getId().toString());
        return this;
    }

    @Override
    public TaskDocument getDocument() {
        TaskDocument taskDocument = new TaskDocument(name.getText(), description.getText());
        Priority priority = Priority.getByName(priorityChoiceBox.getValue());
        Status status = Status.getByName(statusChoiceBox.getValue());
        taskDocument.setPriority(priority);
        taskDocument.setStatus(status);
        return taskDocument;
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
