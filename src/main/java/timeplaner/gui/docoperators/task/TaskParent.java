package timeplaner.gui.docoperators.task;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.core.entities.subdocuments.impl.TaskDocument;
import timeplaner.core.AbstractDocParent;
import timeplaner.gui.utils.BorderUtils;
import timeplaner.gui.utils.ParentUtils;

import java.util.List;
import java.util.Map;

public class TaskParent extends AbstractDocParent<TaskDocument, TaskSkeleton, TaskParent> {

    public TaskParent(TaskSkeleton skeleton) {
        super(skeleton);
    }

    @Override
    protected Pane getGeneralPane() {
        VBox mainPane = (VBox) customizeTaskPane();
        mainPane.getChildren().add(getMainBorderPane());
        mainPane.getChildren().add(getButtonBottom(skeleton.getButtonsBottom()));
        return mainPane;
    }

    @Override
    public TaskParent getDocParent() {
//        skeleton.updateSkeleton(getDocument());
        if( this.getChildren().isEmpty()) {
            this.getChildren().clear();
            this.getChildren().addAll(getGeneralPane());
        }
        return this;
    }

    @Override
    public TaskParent updateDocParent(TaskDocument taskDocument) {
        skeleton.updateSkeleton(taskDocument);
        this.getChildren().clear();
        this.getChildren().addAll(getDocParent());
        return this;
    }

    @Override
    public void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you: TaskDocument was successfully created!");
        alert.showAndWait();
    }

    private Pane customizeTaskPane() {
        VBox mainPane = new VBox();
        return mainPane;
    }

    protected Pane getMainBorderPane() {
        BorderPane generalPane = new BorderPane();

        generalPane.setBorder(BorderUtils.getOtherTaskBorder());
        Pane topPane = ParentUtils.getTopPane(skeleton.getDocument(), skeleton.getBackButton());
        Pane leftInfoPane = ParentUtils.getInfoPane(skeleton.getLabelAndControlMapLeft(), skeleton.getConstantLabelsMap());
        Pane centerPane = getCenterPane(skeleton.getLabelAndControlMapCenter());
        Pane bottomPane = getBottomPane(skeleton.getLabelAndControlMapBottom());

        generalPane.setPrefWidth(400);
        centerPane.setMaxHeight(230);
        generalPane.autosize();

        generalPane.setTop(topPane);
        generalPane.setLeft(leftInfoPane);
        generalPane.setCenter(centerPane);
        generalPane.setBottom(bottomPane);
        return generalPane;
    }



    private Pane getCenterPane(Map<Text, Control> textControlMap) {
        FlowPane centerPane = customizeAndCreateCenterPane();
        textControlMap.forEach((text, control) -> centerPane.getChildren().addAll(text, control));
        return centerPane;
    }

    private FlowPane customizeAndCreateCenterPane() {
        FlowPane rightPane = new FlowPane();
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

}
