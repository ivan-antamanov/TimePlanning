package timeplaner.gui.docs.parents.impldoc;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.entities.subdocuments.AbstractAction;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.docs.parents.AbstractMainDocParent;
import timeplaner.gui.docs.parents.AbstractSubDocParent;
import timeplaner.gui.docs.skeletons.AbstractMainDocSkeleton;
import timeplaner.gui.utils.BorderUtils;
import timeplaner.gui.docs.parents.ParentDocument;
import timeplaner.gui.utils.ParentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PlanParentImpl extends AbstractMainDocParent implements ParentDocument {


//    PlanSkeletonImpl skeleton = new PlanSkeletonImpl();

    public PlanParentImpl(AbstractMainDocSkeleton skeleton) {
        super(skeleton);
    }

    @Override
    protected Pane getGeneralPane() {
        return null;
    }

    @Override
    public AbstractMainDocParent getDocParent() {
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

    }

    @Override
    public AbstractSubDocParent updateTaskParent(AbstractAction action) {
        return null;
    }
}
