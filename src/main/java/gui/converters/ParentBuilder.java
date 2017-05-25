package gui.converters;


import drafts.project.TaskController;
import entities.documents.auxiliary.Priority;
import entities.documents.auxiliary.Status;
import entities.documents.subdocuments.AbstractAction;
import entities.documents.subdocuments.impl.Task;
import gui.auxiliary.BorderUtils;
import gui.auxiliary.FontUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.apache.commons.lang.StringUtils;

import static gui.auxiliary.LabelFields.*;

public class ParentBuilder {

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

    {
        priorityChoiceBox.getItems().addAll(Priority.getAllNames());
        statusChoiceBox.getItems().addAll(Status.getAllNames());
    }



    public ParentBuilder(AbstractAction action) {
        setTaskNodes(action);
    }

    public ParentBuilder() {
    }

    public Parent returnTaskParent(AbstractAction action) {
        return null;
    }

    public Parent returnNewTaskParent() {
        return getGeneralPane();
    }

    private void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you: Task was successfully created!");
        alert.showAndWait();
    }

    private void setTaskNodes(AbstractAction action) {
        taskName = new TextField(action.getName());
        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        taskDescription = new TextArea(action.getDescription());
        taskCreationDate = new TextField(action.getCreateDate().toString());
        taskId = new TextField(action.getId().toString());
//        taskPeriod = new TextField(action.getPeriod().toString());
        //todo rebuild as List
//        linkedTask = new TextField(action.getLinkedSubDocs().get(0).getName());
//        mainDocument = new TextField(action.getMainDocument().getName());
    }

    private Task getTaskFromNode() {
        Task task = new Task(taskName.getText(), Long.parseLong(taskId.getText()), taskDescription.getText());
        Priority priority = Priority.getByName(priorityChoiceBox.getValue());
        Status status = Status.getByName(statusChoiceBox.getValue());
        task.setPriority(priority);
        task.setStatus(status);
        return task;
    }



    private Pane getGeneralPane() {

        BorderPane generalPane = new BorderPane();

        Pane topPane = getTopPane();
        Pane leftPane = getLeftPane();
        Pane centerPane = getCenterPane();
        Pane bottomPane = getBottomPane();

        generalPane.setPrefWidth(750);
        generalPane.autosize();

        generalPane.setTop(topPane);
        generalPane.setLeft(leftPane);
        generalPane.setCenter(centerPane);
        generalPane.setBottom(bottomPane);
        return generalPane;
    }

    private Text getAddressTask(TextField taskName) {
        Text taskAddress = null;
        if (StringUtils.isBlank(taskName.getText())) {
            return taskAddress = new Text("NO Name");
        }
        return taskAddress = new Text(taskName.getText());

    }

    private Pane getTopPane() { //fixme one method for Exist task, one for new
        FlowPane topPane = new FlowPane();
        Text taskAddress = getAddressTask(taskName);

//        FontUtils.setTopLinkFont(projectAddress);
        FontUtils.setTopLinkFont(taskAddress);
        FontUtils.setTopLinkFont(PREFIX); //fixme static method need to change

        topPane.setOrientation(Orientation.HORIZONTAL);
//        topPane.getChildren().add(projectAddress);
        topPane.getChildren().add(PREFIX);
        topPane.getChildren().add(taskAddress); //fixme ??
        return topPane;
    }

    private Pane getLeftPane() {
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(5, 5, 5, 5));
        leftPane.setVgap(10);
        leftPane.setBorder(BorderUtils.getTaskBorder());
        leftPane.add(NAME_LABEL, 0, 0);
        leftPane.add(taskName, 1, 0);

        leftPane.add(PRIORITY_LABEL, 0, 1);
        leftPane.add(priorityChoiceBox, 1, 1);

        leftPane.add(STATUS_LABEL, 0, 2);
        leftPane.add(statusChoiceBox, 1, 2);

//        leftPane.add(PERIOD_LABEL, 0, 3);
//        leftPane.add(taskPeriod, 1, 3);
        leftPane.add(CREATION_DATE_LABEL, 0, 3);
        leftPane.add(taskCreationDate, 1, 3);
        leftPane.add(new Text("ID: "), 0, 4);
        leftPane.add(taskId, 1, 4);

        return leftPane;
    }

    private Pane getCenterPane() {
        FlowPane centerPane = new FlowPane();
        centerPane.setMinSize(400, 200);
        centerPane.setHgap(10);
        centerPane.setVgap(10);
        centerPane.setBorder(BorderUtils.getTaskBorder());
        centerPane.setAlignment(Pos.BASELINE_LEFT);
        centerPane.setOrientation(Orientation.VERTICAL);


        centerPane.getChildren().add(DESCRIPTION_LABEL);
        taskDescription.setPrefHeight(170);
        taskDescription.setPrefWidth(centerPane.getWidth());
        centerPane.getChildren().add(taskDescription);
        return centerPane;
    }

    private Pane getBottomPane() {

        FlowPane bottomPane = new FlowPane();
        saveButton.setAlignment(Pos.BASELINE_RIGHT);
        bottomPane.setOrientation(Orientation.VERTICAL);
        bottomPane.getChildren().add(LINKED_TASK_LABEL);
        bottomPane.getChildren().add(linkedTask);
//        saveButton.addEventFilter(MouseEvent.MOUSE_CLICKED, saveEvent);
        bottomPane.getChildren().add(saveButton);
        return bottomPane;
    }

}
