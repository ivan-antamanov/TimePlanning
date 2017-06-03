package timeplaner.gui;


import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import timeplaner.gui.events.ProjectEventHandler;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;

public class GeneralScene extends Scene {


    private GeneralScene generalScene = this;
    private Parent parent;

    public GeneralScene(@NamedArg("root") Parent root) {
        super(root);
    }

    public ObservableList<Node> getParents() {
        return ((Pane) generalScene.getRoot()).getChildren();
    }

//    ProjectEventHandler<ChangeChildrenVisibilityEvent> changeVisibilityHandler =

}
