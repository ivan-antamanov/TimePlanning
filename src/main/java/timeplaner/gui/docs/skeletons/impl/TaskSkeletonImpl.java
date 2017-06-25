package timeplaner.gui.docs.skeletons.impl;

import timeplaner.entities.AbstractDocument;
import timeplaner.entities.subdocuments.AbstractAction;
import timeplaner.gui.docs.skeletons.AbstractSubDocSkeleton;
import timeplaner.gui.docs.skeletons.Skeleton;
import timeplaner.gui.docs.skeletons.SubDocSkeleton;
import timeplaner.gui.events.EventProcessor;
import timeplaner.entities.auxiliary.Priority;
import timeplaner.entities.auxiliary.Status;
import timeplaner.entities.subdocuments.impl.Task;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import timeplaner.gui.events.events.taskevents.SaveTaskEvent;

public class TaskSkeletonImpl extends AbstractSubDocSkeleton implements SubDocSkeleton {

    private Button saveButton ;

    public TaskSkeletonImpl() {
        super();

    }

    @Override
    protected void registrationEvents() {
        priorityChoiceBox = new ChoiceBox<>();
        statusChoiceBox = new ChoiceBox<>();
        priorityChoiceBox.getItems().addAll(Priority.getAllNames());
        statusChoiceBox.getItems().addAll(Status.getAllNames());
        saveButton = new Button("Save Task");
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            EventProcessor.send(new SaveTaskEvent());
        });
    }

    @Override
    public Skeleton newSkeleton(AbstractDocument abstractDocument) {
//        Task task = (Task) abstractDocument;
        name.clear();
//        priorityChoiceBox.getSelectionModel().select(action.getPriority().getName());
//        statusChoiceBox.getSelectionModel().select(action.getStatus().getName());
        description.clear();
        creationDate.setText(abstractDocument.getCreateDate().toString());
        id.setText(String.valueOf(abstractDocument.getId()));
        return this;
    }

    @Override
    public Skeleton updateSkeleton(AbstractDocument abstractDocument) {//fixme: not create new object
        Task task = (Task) abstractDocument;
        name = new TextField(task.getName());
        priorityChoiceBox.getSelectionModel().select(  task.getPriority().getName());
        statusChoiceBox.getSelectionModel().select(task.getStatus().getName());
        description = new TextArea(task.getDescription());
        creationDate.setText(task.getCreateDate().toString());
        id.setText(task.getId().toString());
        return this;
    }

    @Override
    public AbstractAction getDocument() {
        Task task = new Task(name.getText(), description.getText());
        Priority priority = Priority.getByName(priorityChoiceBox.getValue());
        Status status = Status.getByName(statusChoiceBox.getValue());
        task.setPriority(priority);
        task.setStatus(status);
        return task;
    }

//    public void addSaveEvent(ProjectEventHandler saveEvent){
//        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            EventProcessor.send(new LoadTaskEvent(Long.parseLong(taskId.getText())));
//        });
//    }

}
