package timeplaner.gui.events.handlers;


import javafx.scene.Scene;
import timeplaner.gui.events.ProjectEventHandler;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;

import java.util.concurrent.atomic.AtomicReference;

public interface SceneHandlersFactory {

    AtomicReference<SceneHandlersFactory> INSTANCE = new AtomicReference<>();

    ProjectEventHandler<ChangeChildrenVisibilityEvent> getVisibilityHandler();

}
