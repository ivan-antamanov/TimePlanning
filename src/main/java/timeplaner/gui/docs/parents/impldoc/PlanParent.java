package timeplaner.gui.docs.parents.impldoc;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import timeplaner.entities.maindocuments.impl.Plan;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.docs.parents.AbstractDocParent;
import timeplaner.gui.docs.skeletons.impl.PlanSkeleton;
import timeplaner.gui.utils.BorderUtils;
import timeplaner.gui.utils.ParentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PlanParent extends AbstractDocParent<Plan, PlanSkeleton, PlanParent> {

    public PlanParent(PlanSkeleton skeleton) {
        super(skeleton);
    }

    @Override
    protected Pane getGeneralPane() {
        return null;
    }

    @Override
    public PlanParent getDocParent() {
        if(this.getChildren().isEmpty()) {
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
        }
        return this;

    }

    public Pane getPlanInfoParent() {
        return ParentUtils.getInfoPane(skeleton.getThisDocInfoMap(), skeleton.getThisDocInfoConstantMap());
    }

    public Pane getTaskInfoParent(Task task) {
        return ParentUtils.getInfoPane(skeleton.getChildDocInfoMap(task), skeleton.getChildDocInfoConstantMap(task));
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

    public FlowPane returnButtonPlanParent(List<Control> controls) {
        FlowPane buttonPane = (FlowPane) customizeButtonsPane();
        controls.forEach(control -> buttonPane.getChildren().add(control));
        return buttonPane;
    }

    private Pane customizeButtonsPane() {
        FlowPane startPane = new FlowPane();

        return startPane;
    }

    @Override
    public void showSuccessDialog() {
        throw new UnsupportedOperationException("Operation updateNode not supported yet");
    }

    @Override
    public PlanParent updateDocParent(Plan plan) {
        return null;
    }

}
