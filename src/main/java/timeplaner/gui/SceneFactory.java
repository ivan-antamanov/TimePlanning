package timeplaner.gui;


import javafx.scene.Scene;
import timeplaner.gui.events.handlers.SceneHandlersFactory;

import java.util.concurrent.atomic.AtomicReference;

public interface SceneFactory {

    static AtomicReference<Scene> INSTANCE = new AtomicReference<>();

    Scene getScene();
}
