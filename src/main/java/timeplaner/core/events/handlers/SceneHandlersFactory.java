package timeplaner.core.events.handlers;


import timeplaner.core.events.ProjectEventHandler;
import timeplaner.core.events.events.sceneevents.ChangeChildrenVisibilityEvent;

import java.util.concurrent.atomic.AtomicReference;

public interface SceneHandlersFactory {

    AtomicReference<SceneHandlersFactory> INSTANCE = new AtomicReference<>();

    ProjectEventHandler<ChangeChildrenVisibilityEvent> getVisibilityHandler();

}
