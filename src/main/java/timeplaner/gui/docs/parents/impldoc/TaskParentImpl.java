package timeplaner.gui.docs.parents.impldoc;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.entities.Document;
import timeplaner.entities.subdocuments.AbstractAction;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.docs.parents.AbstractSubDocParent;
import timeplaner.gui.docs.parents.ParentDocument;
import timeplaner.gui.docs.skeletons.SubDocSkeleton;
import timeplaner.gui.utils.BorderUtils;
import timeplaner.gui.utils.ParentUtils;

import java.util.List;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.RIGHT_SLASH;

public class TaskParentImpl extends AbstractSubDocParent implements ParentDocument {


    public TaskParentImpl(SubDocSkeleton skeleton) {
        super(skeleton);
    }

    @Override
    protected Pane getGeneralPane() {
        VBox mainPane = (VBox) customizeTaskPane();
        mainPane.getChildren().add(getMainBorderPanePane());
        mainPane.getChildren().add(getButtonBottom(skeleton.getButtonsBottom()));
        return mainPane;
    }

    @Override
    public Parent getDocParent() {
//        skeleton.updateSkeleton(getDocument());
        this.getChildren().clear();
        this.getChildren().addAll(getGeneralPane());
        return this;
    }

    @Override
    public Parent updateDocParent(Document document) {
        skeleton.updateSkeleton(document);
        this.getChildren().clear();
        this.getChildren().addAll(getDocParent());
        return this;
    }

    @Override
    public void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you: Task was successfully created!");
        alert.showAndWait();
    }

    private Pane customizeTaskPane() {
        VBox mainPane = new VBox();
        return mainPane;
    }

    protected Pane getMainBorderPanePane() {
        BorderPane generalPane = new BorderPane();

        generalPane.setBorder(BorderUtils.getOtherTaskBorder());
        Pane topPane = getTopPane(skeleton.getHyperLinkTop());
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

    private Pane getTopPane(List<Hyperlink> hyperLinkTop) {
        FlowPane topPane = (FlowPane) returnHyperLinkTopPane();
        topPane.getChildren().addAll(hyperLinkTop.get(0), RIGHT_SLASH.getTextLabel(), hyperLinkTop.get(1));
        return topPane;
    }

    private Pane returnHyperLinkTopPane() {
        FlowPane topPane = new FlowPane();
        topPane.setOrientation(Orientation.HORIZONTAL);
        return topPane;
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
