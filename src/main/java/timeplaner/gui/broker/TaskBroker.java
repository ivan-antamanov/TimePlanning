package timeplaner.gui.broker;

import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.taskevents.LoadTaskEvent;
import timeplaner.documents.auxiliary.Priority;
import timeplaner.documents.auxiliary.Status;
import timeplaner.documents.subdocuments.AbstractAction;
import timeplaner.documents.subdocuments.impl.Task;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import static timeplaner.gui.auxiliary.LabelFields.*;

public class TaskBroker {

    private TextField taskName = new TextField();
    private ChoiceBox<String> priorityChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> statusChoiceBox = new ChoiceBox<>();
    private TextArea taskDescription = new TextArea();
    private TextField taskCreationDate = new TextField();
    private TextField taskId = new TextField();
    private TextField taskPeriod = new TextField();
    private TextField linkedTask = new TextField();
    private TextField mainDocument = new TextField();

    private Button saveButton = new Button("Save Task");

    public TaskBroker() {
        priorityChoiceBox.getItems().addAll(Priority.getAllNames());
        statusChoiceBox.getItems().addAll(Status.getAllNames());
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            EventProcessor.send(new LoadTaskEvent(Long.parseLong(taskId.getText())));
        });
    }


    public TaskBroker updateTaskView(AbstractAction action) { //fixme: not create new object
        taskName = new TextField(action.getName());
        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        taskDescription = new TextArea(action.getDescription());
        taskCreationDate = new TextField(action.getCreateDate().toString());
        taskId = new TextField(action.getId().toString());
        return this;
    }

    public TaskBroker newTaskView() {
        taskName.clear();
//        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
//        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        taskDescription.clear();
        taskCreationDate = new TextField(LocalDate.now().toString());
        taskId.clear(); //todo generate unique id;
        return this;
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

        if (isBlank.test(taskName.getText())) {
            taskNameHypLink.setText("No Task Name");
        } else {
            taskNameHypLink.setText(taskName.getText());
        }

        return Arrays.asList(mainProjectHypLink, taskNameHypLink);
    }


    public Map<Text, Control> getLabelAndControlMapLeft() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        getLabelAndControlMap.putIfAbsent(NAME_LABEL.getTextLabel(), taskName);
        getLabelAndControlMap.putIfAbsent(PRIORITY_LABEL.getTextLabel(), priorityChoiceBox);
        getLabelAndControlMap.putIfAbsent(STATUS_LABEL.getTextLabel(), statusChoiceBox);
        getLabelAndControlMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), taskCreationDate);
        getLabelAndControlMap.putIfAbsent(ID_LABEL.getTextLabel(), taskId);

        return getLabelAndControlMap;
    }

    public Map<Text, Control> getLabelAndControlMapCenter() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        customizeDescription(taskDescription);
        getLabelAndControlMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), taskDescription);

        return getLabelAndControlMap;
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


    private TextArea customizeDescription(TextArea taskDescription) {
        taskDescription.setMinHeight(170);
        taskDescription.setMinWidth(400);
        return taskDescription;
    }


    public Task getTaskFromNode() {
        Task task = new Task(taskName.getText(), Long.parseLong(taskId.getText()), taskDescription.getText());
        Priority priority = Priority.getByName(priorityChoiceBox.getValue());
        Status status = Status.getByName(statusChoiceBox.getValue());
        task.setPriority(priority);
        task.setStatus(status);
        return task;
    }

    public void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you: Task was successfully created!");
        alert.showAndWait();
    }

}
