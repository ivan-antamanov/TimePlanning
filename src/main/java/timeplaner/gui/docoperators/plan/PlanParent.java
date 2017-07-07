package timeplaner.gui.docoperators.plan;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.core.entities.maindocuments.impl.PlanDocument;
import timeplaner.core.entities.subdocuments.impl.TaskDocument;
import timeplaner.core.AbstractDocParent;
import timeplaner.gui.utils.BorderUtils;
import timeplaner.gui.utils.ParentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PlanParent extends AbstractDocParent<PlanDocument, PlanSkeleton, PlanParent> {

    public PlanParent(PlanSkeleton skeleton) {
        super(skeleton);
    }

    @Override
    protected Pane getGeneralPane() {
        BorderPane generalPane = new BorderPane();
        generalPane.setBorder(BorderUtils.getOtherTaskBorder());

        Pane topPane = ParentUtils.getTopPane(skeleton.getDocument(), skeleton.getBackButton());

        VBox leftInfoPane = new VBox();
        leftInfoPane.getChildren().addAll(getPlanInfoParent(), getTaskInfoParent(new TaskDocument()));

        VBox centerPane = new VBox();
        centerPane.getChildren().addAll(getTaskList(skeleton.getTaskList()));
        skeleton.updateTaskList(Arrays.asList("First task", "Second TaskDocument")); //FIXME should be real tasks
        HBox bottomPane = new HBox();
        bottomPane.getChildren().addAll(returnButtonPlanParent(skeleton.getButtonBottom()));

        generalPane.setPrefWidth(400);
        centerPane.setMaxHeight(250);
        generalPane.autosize();

        generalPane.setTop(topPane);
        generalPane.setLeft(leftInfoPane);
        generalPane.setCenter(centerPane);
        generalPane.setBottom(bottomPane);
        return generalPane;
    }

    @Override
    public PlanParent getDocParent() {
        if(this.getChildren().isEmpty()) {
            this.getChildren().addAll(getGeneralPane());
        }
        return this;

    }

    public Pane getPlanInfoParent() {
        return ParentUtils.getInfoPane(skeleton.getThisDocInfoMap(), skeleton.getThisDocInfoConstantMap());
    }

    public Pane getTaskInfoParent(TaskDocument taskDocument) {
        return ParentUtils.getInfoPane(skeleton.getChildDocInfoMap(taskDocument), skeleton.getChildDocInfoConstantMap(taskDocument));
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
        buttonPane.setBorder(BorderUtils.getOtherTaskBorder());
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
    public PlanParent updateDocParent(PlanDocument planDocument) {
        return null;
    }

}
