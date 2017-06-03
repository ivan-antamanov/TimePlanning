package timeplaner.gui.events.events.taskevents;


import timeplaner.documents.subdocuments.impl.Task;
import timeplaner.gui.events.events.ProjectEvent;

public class LoadTaskEvent implements ProjectEvent {

    Long id;
    Task task;

    public LoadTaskEvent(Long id) {
        this.id = id;
    }

    public LoadTaskEvent(Task task){
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }
}
