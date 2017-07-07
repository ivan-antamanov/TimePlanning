package timeplaner.core.events;


import javafx.scene.Scene;

import java.util.concurrent.atomic.AtomicReference;

public interface SceneFactory {

    static AtomicReference<Scene> INSTANCE = new AtomicReference<>();

    Scene getScene();
}
