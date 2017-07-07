package timeplaner.core.events.events.sceneevents;


import javafx.scene.Scene;
import timeplaner.core.events.events.ProjectEvent;

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

