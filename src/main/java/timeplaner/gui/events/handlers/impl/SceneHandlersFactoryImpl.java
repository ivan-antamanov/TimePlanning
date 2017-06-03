package timeplaner.gui.events.handlers.impl;


import javafx.scene.layout.Pane;
import timeplaner.gui.docparents.Document;
import timeplaner.gui.events.ProjectEventHandler;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.events.handlers.SceneHandlersFactory;

public class SceneHandlersFactoryImpl implements SceneHandlersFactory {
    @Override
    public ProjectEventHandler<ChangeChildrenVisibilityEvent> getVisibilityHandler() {
        return event -> {
            ((Pane) event.getScene().getRoot()).getChildren().stream()
                    .filter( parent -> parent instanceof Document)
                    .forEach( parent -> parent.setVisible(false));
            ((Pane) event.getScene().getRoot()).getChildren().stream()
                    .filter( parent -> parent.getClass().equals(event.getClazz()))
                    .forEach( parent -> parent.setVisible(true));
            System.out.println("[p");
        };
    }
}
