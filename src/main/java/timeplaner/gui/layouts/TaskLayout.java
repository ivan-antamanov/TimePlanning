package timeplaner.gui.layouts;


import timeplaner.documents.subdocuments.AbstractAction;
import timeplaner.gui.auxiliary.BorderUtils;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.gui.broker.TaskBroker;

import java.util.List;
import java.util.Map;

import static timeplaner.gui.auxiliary.LabelFields.RIGHT_SLASH;

public class TaskLayout {

    TaskBroker taskBroker;

    public TaskLayout(TaskBroker taskBroker) {
        this.taskBroker = taskBroker;
    }

//    public Parent returnTaskParent(AbstractAction action) {
//        return getGeneralPane();
//    }

    public Parent returnNewTaskParent() {
        return getGeneralPane();
    }


    public Pane getGeneralPane() { //todo Another Class
        BorderPane generalPane = new BorderPane();
        Pane topPane = getTopPane(taskBroker.getHyperLinkTop());
        Pane leftPane = getLeftPane(taskBroker.getLabelAndControlMapLeft());
        Pane centerPane = getCenterPane(taskBroker.getLabelAndControlMapCenter());
        Pane bottomPane = getBottomPane(taskBroker.getLabelAndControlMapBottom());

        generalPane.setPrefWidth(400);
        generalPane.autosize();

        generalPane.setTop(topPane);
        generalPane.setLeft(leftPane);
        generalPane.setCenter(centerPane);
        generalPane.setBottom(bottomPane);
        return generalPane;
    }

    private Pane getTopPane(List<Hyperlink> hyperLinkTop) { //fixme one method for Exist task, one for new ; todo Another Class
        FlowPane topPane = (FlowPane) returnHyperLinkTopPane();
        topPane.getChildren().addAll(hyperLinkTop.get(0),RIGHT_SLASH.getTextLabel(), hyperLinkTop.get(1) );
//        FontUtils.setTopLinkFont(RIGHT_SLASH.getTextLabel());
        return topPane;
    }

    private Pane returnHyperLinkTopPane(){
        FlowPane topPane = new FlowPane();
        topPane.setOrientation(Orientation.HORIZONTAL);
        return topPane;
    }

    private Pane getLeftPane(Map<Text, Control> textControlMap) { //todo Another Class
        GridPane leftPane = customizeAndCreateLeftGridPane();

        for (Map.Entry<Text, Control> entry : textControlMap.entrySet()) {
            Text label = entry.getKey();
            Control control = entry.getValue();
            control.setPrefWidth(Double.MAX_VALUE);
            for (int i = 0; i < textControlMap.size(); i++) {
                leftPane.addColumn(i, label, control);
            }
        }

        return leftPane;
    }

    private GridPane customizeAndCreateLeftGridPane() {
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(5, 5, 5, 5));
        leftPane.setVgap(10);
        leftPane.setBorder(BorderUtils.getTaskBorder());
        return leftPane;
    }

    private Pane getCenterPane(Map<Text, Control> textControlMap) { //todo Another Class
        FlowPane centerPane = (FlowPane) customizeAndCreateCenterPane();
        textControlMap.forEach((text, control) -> centerPane.getChildren().addAll(text, control));
        return centerPane;
    }

    private Pane customizeAndCreateCenterPane(){
        FlowPane rightPane = new FlowPane();
        rightPane.setMinSize(400, 200);
        rightPane.setHgap(10);
        rightPane.setVgap(10);
        rightPane.setBorder(BorderUtils.getTaskBorder());
        rightPane.setAlignment(Pos.BASELINE_LEFT);
        rightPane.setOrientation(Orientation.VERTICAL);
        return rightPane;
    }

    private Pane customizeAndCreateBottomPane(){
        FlowPane bottomPane = new FlowPane();
        bottomPane.setOrientation(Orientation.VERTICAL);
        return bottomPane;
    }

    private Pane getButtonBottom(List<Button> buttons){
        HBox btnLayout = (HBox) customizedAndCreateButtonBottomPane();
        buttons.forEach(btn -> btnLayout.getChildren().addAll(btn));
        return btnLayout;
    }

    private Pane customizedAndCreateButtonBottomPane(){
        HBox buttonLayout = new HBox();
        return buttonLayout;
    }


    private Pane getBottomPane(Map<Text, Control> textControlMap) { //todo Another Class
        FlowPane bottomPane = (FlowPane) customizeAndCreateBottomPane();
        textControlMap.forEach(((text, control) -> bottomPane.getChildren().addAll(text, control)));
        return bottomPane;
    }
}
