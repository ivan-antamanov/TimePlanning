package timeplaner.gui.docs.parents;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import timeplaner.entities.AbstractDocument;
import timeplaner.gui.docs.carcases.Skeleton;

public abstract class AbstractParent extends Parent {

    Skeleton skeleton;

    public AbstractParent(Skeleton skeleton) {
        this.skeleton = skeleton;
    }

    protected abstract Pane getGeneralPane();

    protected abstract AbstractParent getParent(Skeleton skeleton);

    public AbstractDocument getDocument(){
        return skeleton.getDocument();
    }

}
