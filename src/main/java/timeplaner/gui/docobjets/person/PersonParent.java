package timeplaner.gui.docobjets.person;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import timeplaner.core.AbstractDocParent;
import timeplaner.core.entities.PersonDocument;
import timeplaner.core.entities.subdocuments.impl.TaskDocument;
import timeplaner.gui.utils.BorderUtils;
import timeplaner.gui.utils.ParentUtils;

import java.util.List;
import java.util.Map;

public class PersonParent extends AbstractDocParent<PersonDocument, PersonSkeleton, PersonParent> {


    public PersonParent(PersonSkeleton skeleton) {
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
        centerPane.getChildren().addAll(getPlanList(skeleton.getTaskList()));
//        skeleton.updateTaskList(Arrays.asList("First task", "Second TaskDocument")); //FIXME should be real plans
        HBox bottomPane = new HBox();
        bottomPane.getChildren().addAll(skeleton.getButtonBottom()); //FIXME flow

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
    public PersonParent getDocParent() {
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

    public Pane getPlanList(Map<Text, Control> planInfoMap) {
        FlowPane plansPane = customizeAndCreateListPane();
        planInfoMap.forEach(((text, control) -> plansPane.getChildren().addAll(text, control)));
        return plansPane;
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

    public void updateCatalog(List<String> catalog){
        skeleton.updateTaskList(catalog);
    }

    @Override
    public void showSuccessDialog() {

    }

    @Override
    public PersonParent updateDocParent(PersonDocument documentModel) {
        return null;
    }


}
