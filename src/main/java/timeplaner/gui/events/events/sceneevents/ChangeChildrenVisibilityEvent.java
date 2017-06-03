package timeplaner.gui.events.events.sceneevents;


import javafx.scene.Scene;
import timeplaner.gui.events.events.ProjectEvent;

public class ChangeChildrenVisibilityEvent implements ProjectEvent {

    Class clazz;
    Scene scene;

    public ChangeChildrenVisibilityEvent(Class clazz, Scene scene) {
        this.clazz = clazz;
        this.scene = scene;
    }

    public Class getClazz() {
        return clazz;
    }

    public Scene getScene() {
        return scene;
    }
}

