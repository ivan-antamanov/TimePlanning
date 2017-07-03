package timeplaner.gui.docs.parents;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import timeplaner.entities.DocumentModel;
import timeplaner.gui.docs.skeletons.PlanSkeleton;

public abstract class AbstractMainDocParent extends Parent implements PlanParent,ParentDocument {

    protected PlanSkeleton skeleton;

    public AbstractMainDocParent(PlanSkeleton skeleton) {
        this.skeleton = skeleton;
    }

    protected abstract Pane getGeneralPane();

//    public abstract Parent getDocParent();

    public DocumentModel getDocument(){
        return skeleton.getDocument();
    }






}
