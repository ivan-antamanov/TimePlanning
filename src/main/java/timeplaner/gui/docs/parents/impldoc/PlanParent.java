package timeplaner.gui.docs.parents.impldoc;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.additional.BorderUtils;
import timeplaner.gui.docs.carcases.impl.PlanSkeleton;
import timeplaner.gui.docs.parents.GuiDocument;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PlanParent extends Parent implements GuiDocument {


    PlanSkeleton skeleton = new PlanSkeleton();

    public PlanParent getGeneralPane() {
        VBox left = new VBox();
        left.getChildren().addAll(getPlanInfoParent(), getTaskInfoParent(new Task())); //todo rebuild

        VBox right = new VBox();
        right.getChildren().addAll(getTaskList(skeleton.getTaskList()), returnButtonPlanParent(skeleton.getButtonBottom()));
        skeleton.updateTaskList(Arrays.asList("First task", "Second Task"));
        HBox all = new HBox();
        all.getChildren().addAll(left, right);
        all.setAlignment(Pos.CENTER);
//        all.setMinSize(700, 1700); //all.setMinSize(700, 400);

//        all.setMaxSize(820, 1820);
        this.getChildren().addAll(all);
        return this;

    }

    public Pane getPlanInfoParent() {
        return getInfoPane(skeleton.getPlanInfoMap(), skeleton.getPlanInfoConstantMap());
    }

    public Pane getTaskInfoParent(Task task) {
        return getInfoPane(skeleton.getTaskInfoMap(task), skeleton.getTaskInfoConstantMap(task));
    }

    public Pane getTaskList(Map<Text, Control> tasksInfoMap) {
        FlowPane tasksPane = customizeAndCreateListPane();
        tasksInfoMap.forEach(((text, control) -> tasksPane.getChildren().addAll(text, control)));
        return tasksPane;
    }

    private FlowPane customizeAndCreateListPane() {
        FlowPane rightPane = new FlowPane();
        rightPane.setMinSize(250, 200);
        rightPane.setMaxSize(250,330);
        rightPane.setHgap(10);
        rightPane.setVgap(10);
        rightPane.setBorder(BorderUtils.getTaskBorder());
        rightPane.setAlignment(Pos.TOP_LEFT);
        rightPane.setOrientation(Orientation.VERTICAL);
        return rightPane;
    }

    private Pane getInfoPane(Map<Text, Control> planInfoMap,  Map<Text, Text> textConstantMap) { //todo in parent class
        GridPane planInfoPane = customizeAndCreateInfoPane();
        int firstColumn = 0;
        int secondColumn = 1;
        for (Map.Entry<Text, Control> entry : planInfoMap.entrySet()) {
            Text label = entry.getKey();
            Control control = entry.getValue();
            control.setMaxWidth(Double.MAX_VALUE);
            planInfoPane.addColumn(firstColumn, label);
            planInfoPane.addColumn(secondColumn, control);
        }

        for (Map.Entry<Text, Text> entry : textConstantMap.entrySet()) {
            Text label = entry.getKey();
            Text labelValue = entry.getValue();
            planInfoPane.addColumn(firstColumn, label);
            planInfoPane.addColumn(secondColumn, labelValue);
        }

        return planInfoPane;
    }

    private GridPane customizeAndCreateInfoPane() {
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(5, 5, 5, 5));
        leftPane.setVgap(10);
        leftPane.setBorder(BorderUtils.getTaskBorder());
        leftPane.setMaxWidth(250);
        return leftPane;
    }

    public FlowPane returnButtonPlanParent(List<Control> controls) {
        FlowPane buttonPane = (FlowPane) customizeButtonsPane();
        controls.forEach(control -> buttonPane.getChildren().add(control));
        return buttonPane;
    }

    private Pane customizeButtonsPane() {
        FlowPane startPane = new FlowPane();

        return startPane;
    }

}
