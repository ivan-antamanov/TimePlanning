package drafts.project;


import entities.documents.subdocuments.AbstractAction;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import static gui.auxiliary.LabelFields.*;


public class TaskController {

    private Scene taskScene;
    private AbstractAction action;
    private ActionLoader actionLoader;
    //    todo LayoutController
    //todo AbstractTaskController
    private TextField taskName;
    private TextField taskStatus;
    private TextField taskPriority;
    private TextField taskDescription;
    private TextField taskCreationDate;
    private TextField taskPeriod;
    private TextField linkedTask;
    private TextField mainDocument;


    public TaskController(AbstractAction action) {
        this.action = action;
        setTaskNodes();
    }

    private void setTaskNodes() {
        taskName = new TextField(action.getName());
        taskStatus = new TextField(action.getStatus().name());
        taskPriority = new TextField(action.getPriority().name());
        taskDescription = new TextField(action.getDescription());
        taskCreationDate = new TextField(action.getCreateDate().toString());
        taskPeriod = new TextField(action.getPeriod().toString());
        //todo rebuild as List
        linkedTask = new TextField(action.getLinkedSubDocs().get(0).getName());
        mainDocument = new TextField(action.getMainDocument().getName());
    }

    public Parent returnTaskParent() {
        return getGeneralPane();
    }

    private Pane getGeneralPane() {
        BorderPane generalPane = new BorderPane();
        generalPane.setTop(getTopPane());
        generalPane.setLeft(getLeftPane());
        generalPane.setRight(getRightPane());
        generalPane.setBottom(getBottomPane());
        return generalPane;
    }

    private Pane getTopPane() {
        FlowPane topPane = new FlowPane();
        topPane.setOrientation(Orientation.HORIZONTAL);
        topPane.getChildren().add(mainDocument);
        topPane.getChildren().add(PREFIX);
        topPane.getChildren().add(taskName);
        return topPane;
    }

    private Pane getLeftPane() {
        GridPane leftPane = new GridPane();
        leftPane.add(NAME_LABEL, 0, 0);
        leftPane.add(taskName, 1, 0);
        leftPane.add(PRIORITY_LABEL, 0, 1);
        leftPane.add(taskPriority, 1, 1);
        leftPane.add(STATUS_LABEL, 0, 2);
        leftPane.add(taskStatus, 1, 2);
        leftPane.add(PERIOD_LABEL, 0, 3);
        leftPane.add(taskPeriod, 1, 3);
        leftPane.add(CREATION_DATE_LABEL, 0, 4);
        leftPane.add(taskCreationDate, 1, 4);
        return leftPane;
    }

    private Pane getRightPane() {
        FlowPane rightPane = new FlowPane();
        rightPane.setOrientation(Orientation.VERTICAL);
        rightPane.getChildren().add(DESCRIPTION_LABEL);
        rightPane.getChildren().add(taskDescription);
        return rightPane;
    }

    private Pane getBottomPane() {
        FlowPane bottomPane = new FlowPane();
        bottomPane.setOrientation(Orientation.VERTICAL);
        bottomPane.getChildren().add(LINKED_TASK_LABEL);
        bottomPane.getChildren().add(linkedTask);
        return bottomPane;
    }

}
