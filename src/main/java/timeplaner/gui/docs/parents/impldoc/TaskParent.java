package timeplaner.gui.docs.parents.impldoc;


import javafx.scene.control.Alert;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.additional.BorderUtils;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.gui.docs.carcases.impl.TaskSkeleton;
import timeplaner.gui.docs.parents.GuiDocument;

import java.util.List;
import java.util.Map;

import static timeplaner.gui.additional.LabelFields.RIGHT_SLASH;

public class TaskParent extends Parent implements GuiDocument {

    private TaskSkeleton skeleton = new TaskSkeleton();

    public TaskParent getTaskParent() {
        skeleton.newSkeleton(new Task());
        if (this.getChildren().isEmpty()) {
            this.getChildren().addAll(getParent(skeleton));
            return this;
        }
        return this;
    }

    public Task getTaskFromNode() {
        return (Task) skeleton.getDocument();
    }

    public TaskParent updateTaskParent(Task task) {
        skeleton.updateSkeleton(task);
        this.getChildren().clear();
        this.getChildren().addAll(getParent(skeleton));
        return this;
    }

    private VBox getParent(TaskSkeleton taskSkeleton) {
        VBox mainPane = (VBox) customizeTaskPane();
        mainPane.getChildren().add(getGeneralPane(taskSkeleton));
        mainPane.getChildren().add(getButtonBottom(taskSkeleton.getButtonsBottom()));
        return mainPane;
    }

    private Pane customizeTaskPane() {
        VBox mainPane = new VBox();
        return mainPane;
    }

    private Pane getGeneralPane(TaskSkeleton taskSkeleton) {
        BorderPane generalPane = new BorderPane();

        generalPane.setBorder(BorderUtils.getOtherTaskBorder());
        Pane topPane = getTopPane(taskSkeleton.getHyperLinkTop());
        Pane leftPane = getLeftPane(taskSkeleton.getLabelAndControlMapLeft(), taskSkeleton.getConstantLabelsMap());
        Pane centerPane = getCenterPane(taskSkeleton.getLabelAndControlMapCenter());
        Pane bottomPane = getBottomPane(taskSkeleton.getLabelAndControlMapBottom());

        generalPane.setPrefWidth(400);
        centerPane.setMaxHeight(230);
        generalPane.autosize();

        generalPane.setTop(topPane);
        generalPane.setLeft(leftPane);
        generalPane.setCenter(centerPane);
        generalPane.setBottom(bottomPane);
        return generalPane;
    }

    private Pane getTopPane(List<Hyperlink> hyperLinkTop) {
        FlowPane topPane = (FlowPane) returnHyperLinkTopPane();
//        topPane.setAlignment(Pos.TOP_CENTER);
        topPane.getChildren().addAll(hyperLinkTop.get(0), RIGHT_SLASH.getTextLabel(), hyperLinkTop.get(1));
//        FontUtils.setTopLinkFont(RIGHT_SLASH.getTextLabel());
        return topPane;
    }

    private Pane returnHyperLinkTopPane() {
        FlowPane topPane = new FlowPane();
        topPane.setOrientation(Orientation.HORIZONTAL);
        return topPane;
    }

    private Pane getLeftPane(Map<Text, Control> textControlMap, Map<Text, Text> textConstantMap) { //todo rebuild && Another Class
        GridPane leftPane = customizeAndCreateLeftPane();
        int firstColumn = 0;
        int secondColumn = 1;
        for (Map.Entry<Text, Control> entry : textControlMap.entrySet()) {
            Text label = entry.getKey();
            Control control = entry.getValue();
            control.setMaxWidth(Double.MAX_VALUE);
            leftPane.addColumn(firstColumn, label);
            leftPane.addColumn(secondColumn, control);
        }

        for (Map.Entry<Text, Text> entry : textConstantMap.entrySet()) {
            Text label = entry.getKey();
            Text labelValue = entry.getValue();
            leftPane.addColumn(firstColumn, label);
            leftPane.addColumn(secondColumn, labelValue);
        }

        return leftPane;
    }

    private GridPane customizeAndCreateLeftPane() {
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(5, 5, 5, 5));
        leftPane.setVgap(10);
        leftPane.setBorder(BorderUtils.getTaskBorder());
        leftPane.setMaxWidth(250);
        return leftPane;
    }

    private Pane getCenterPane(Map<Text, Control> textControlMap) {
        FlowPane centerPane = customizeAndCreateCenterPane();
        textControlMap.forEach((text, control) -> centerPane.getChildren().addAll(text, control));
        return centerPane;
    }

    private FlowPane customizeAndCreateCenterPane() {
        FlowPane rightPane = new FlowPane();
//        rightPane.setMinSize(400, 200);
//        rightPane.setMaxSize(400,300);
        rightPane.setHgap(10);
        rightPane.setVgap(10);
        rightPane.setBorder(BorderUtils.getTaskBorder());
        rightPane.setAlignment(Pos.TOP_LEFT);
        rightPane.setOrientation(Orientation.VERTICAL);
        return rightPane;
    }

    private Pane getButtonBottom(List<Button> buttons) {
        HBox btnLayout = (HBox) customizedAndCreateButtonBottomPane();
        buttons.forEach(btn -> btnLayout.getChildren().addAll(btn));
        return btnLayout;
    }

    private Pane customizedAndCreateButtonBottomPane() {
        HBox btnLayout = new HBox();
        btnLayout.setBorder(BorderUtils.getOtherTaskBorder());
        btnLayout.setAlignment(Pos.BOTTOM_RIGHT);
        return btnLayout;
    }


    private Pane getBottomPane(Map<Text, Control> textControlMap) {
        FlowPane bottomPane = (FlowPane) customizeAndCreateBottomPane();
        textControlMap.forEach(((text, control) -> bottomPane.getChildren().addAll(text, control)));
        return bottomPane;
    }

    private Pane customizeAndCreateBottomPane() {
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.TOP_LEFT);
        bottomPane.setMinHeight(20);
        bottomPane.setMaxHeight(50);
        bottomPane.setOrientation(Orientation.VERTICAL);
        bottomPane.setBorder(BorderUtils.getTaskBorder());
        return bottomPane;
    }

    public void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you: Task was successfully created!");
        alert.showAndWait();
    }
}
