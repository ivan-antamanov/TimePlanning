package timeplaner.gui.docs.parents;


import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import timeplaner.entities.DocumentModel;
import timeplaner.gui.docs.skeletons.Skeleton;

public abstract class AbstractDocParent<T extends DocumentModel, S extends Skeleton<S, T> ,V extends AbstractDocParent>
        extends Parent implements ParentDocument<T,V> {

    protected S skeleton;

    public AbstractDocParent(S skeleton) {
        this.skeleton = skeleton;
    }

    protected abstract Pane getGeneralPane();

    public T getDocument() {
        return skeleton.getDocument();
    }


}
