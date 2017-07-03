package timeplaner.gui.docs.parents;


import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import timeplaner.entities.DocumentModel;
import timeplaner.gui.docs.skeletons.SubDocSkeleton;

public abstract class AbstractSubDocParent extends Parent implements ParentDocument {

    protected SubDocSkeleton skeleton;

    public AbstractSubDocParent(SubDocSkeleton skeleton) {
        this.skeleton = skeleton;
    }

    protected abstract Pane getGeneralPane();

    public DocumentModel getDocument(){
        return skeleton.getDocument();
    }

}
