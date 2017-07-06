package timeplaner.gui.events.events.taskevents;


import timeplaner.entities.DocumentModel;
import timeplaner.gui.events.events.ProjectEvent;

public class LoadDocumentEvent<T extends DocumentModel> implements ProjectEvent {

    Long id;
    T document;

    public LoadDocumentEvent(Long id) {
        this.id = id;
    }

//    public LoadDocumentEvent(T document){
//        this.task = task;
//    }

//    public Long getId() {
//        return id;
//    }

    public T getDocument() {
        return document;
    }
}
