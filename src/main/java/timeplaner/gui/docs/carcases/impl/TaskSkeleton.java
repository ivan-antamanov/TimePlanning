package timeplaner.gui.docs.carcases.impl;

import javafx.scene.Parent;
import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;
import timeplaner.gui.events.EventProcessor;
import timeplaner.entities.auxiliary.Priority;
import timeplaner.entities.auxiliary.Status;
import timeplaner.entities.subdocuments.AbstractAction;
import timeplaner.entities.subdocuments.impl.Task;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.apache.commons.lang.StringUtils;
import timeplaner.gui.events.events.taskevents.SaveTaskEvent;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import static timeplaner.gui.additional.LabelFields.*;

public class TaskSkeleton extends AbstractSkeleton {
    private TextField mainDocument = new TextField();
    private ChoiceBox<String> priorityChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> statusChoiceBox = new ChoiceBox<>();
    private TextField taskPeriod = new TextField();
    private TextField linkedTask = new TextField();

    private Button saveButton ;

    public TaskSkeleton() {
        super();

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
    }

    @Override
    public AbstractSkeleton newSkeleton(AbstractDocument abstractDocument) {
        Task task = (Task) abstractDocument;
        name.clear();
//        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
//        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        description.clear();
        creationDate.setText(task.getCreateDate().toString());
        id.setText(String.valueOf(task.getId()));
        return this;
    }

    @Override
    public AbstractSkeleton updateSkeleton(AbstractDocument abstractDocument) {//fixme: not create new object
        Task task = (Task) abstractDocument;
        name = new TextField(task.getName());
        priorityChoiceBox.getSelectionModel().select(  task.getPriority().getName());
        statusChoiceBox.getSelectionModel().select(task.getStatus().getName());
        description = new TextArea(task.getDescription());
        creationDate.setText(task.getCreateDate().toString());
        id.setText(task.getId().toString());
        return this;
    }

    @Override
    public AbstractDocument getDocument() {
        Task task = new Task(name.getText(), description.getText());
        Priority priority = Priority.getByName(priorityChoiceBox.getValue());
        Status status = Status.getByName(statusChoiceBox.getValue());
        task.setPriority(priority);
        task.setStatus(status);
        return task;
    }

    public List<Hyperlink> getHyperLinkTop() {
        Predicate<String> isBlank = StringUtils::isBlank;
        Hyperlink mainProjectHypLink = new Hyperlink();
        Hyperlink taskNameHypLink = new Hyperlink();
        if (isBlank.test(mainDocument.getText())) {
            mainProjectHypLink.setText("No Main Project");
        } else {
            mainProjectHypLink.setText(mainDocument.getText());
        }

        if (isBlank.test(name.getText())) {
            taskNameHypLink.setText("No Task Name");
        } else {
            taskNameHypLink.setText(name.getText());
        }

        return Arrays.asList(mainProjectHypLink, taskNameHypLink);
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

    private TextArea customizeDescription(TextArea taskDescription) {
        taskDescription.autosize();
//        taskDescription.setMinWidth(120);
        return taskDescription;
    }

    public Map<Text, Control> getLabelAndControlMapBottom() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        getLabelAndControlMap.putIfAbsent(LINKED_TASK_LABEL.getTextLabel(), linkedTask);

        return getLabelAndControlMap;
    }

    public List<Button> getButtonsBottom() {
        List<Button> buttons = new ArrayList<>(0);
        customizeSaveButton(saveButton);
        buttons.add(saveButton);
        return buttons;
    }

    private Button customizeSaveButton(Button saveButton) {
        saveButton.setAlignment(Pos.TOP_CENTER);
//        saveButton.addEventFilter();
        return saveButton;
    }


//    public void addSaveEvent(ProjectEventHandler saveEvent){
//        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            EventProcessor.send(new LoadTaskEvent(Long.parseLong(taskId.getText())));
//        });
//    }


}
