package timeplaner.gui.docs.parents;


import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import timeplaner.entities.subdocuments.AbstractAction;
import timeplaner.gui.docs.skeletons.SubDocSkeleton;

public abstract class AbstractSubDocParent extends Parent implements ParentDocument {

    protected SubDocSkeleton skeleton;

    public AbstractSubDocParent(SubDocSkeleton skeleton) {
        this.skeleton = skeleton;
    }

    protected abstract Pane getGeneralPane();

    public abstract AbstractSubDocParent getDocParent();

    public AbstractAction getDocument(){
        return skeleton.getDocument();
    }

}
