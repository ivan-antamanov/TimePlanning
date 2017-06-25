package timeplaner.gui.docs.skeletons.impl;


import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;
import timeplaner.entities.maindocuments.AbstractProject;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.docs.skeletons.AbstractMainDocSkeleton;
import timeplaner.gui.docs.skeletons.AbstractSkeleton;
import timeplaner.gui.docs.skeletons.PlanSkeleton;
import timeplaner.gui.docs.skeletons.Skeleton;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadTaskEvent;

import java.util.LinkedHashMap;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.*;

public class PlanSkeletonImpl extends AbstractMainDocSkeleton implements PlanSkeleton {

    private Hyperlink mainDocument = new Hyperlink();

    private TextField taskIdText = new TextField("0");

    public PlanSkeletonImpl() {
        super();
    }

    @Override
    protected void registrationEvents() {
        createButton = new Button("Create Task");
        loadButton = new Button("Edit task");
        deleteButton = new Button("Delete Task");
        createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> EventProcessor.send(new CreateTaskEvent()));
        loadButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                EventProcessor.send(new LoadTaskEvent(Long.valueOf(taskIdText.getText()))));
    }

    @Override
    public Skeleton newSkeleton(Document document) {
        return new PlanSkeletonImpl();
    }

    @Override
    public Skeleton updateSkeleton(Document document) {
        throw new UnsupportedOperationException("Functionality Update document not Implemented yet");
    }

    @Override
    public AbstractProject getDocument() {
        throw new UnsupportedOperationException("Functionality Update document not Implemented yet");
        //need todo implementation;
    }

    public Map<Text, Control> getThisDocInfoMap(){ //todo think how to rebuild these methods
        Map<Text, Control> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(NAME_LABEL.getTextLabel(), name);
        planInfoMap.putIfAbsent(MAIN_DOC_LABEL.getTextLabel(), mainDocument);
//        planInfoMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), description);
        return planInfoMap;
    }

    public Map<Text, Text> getThisDocInfoConstantMap(){
        Map<Text, Text> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), creationDate);
        planInfoMap.putIfAbsent(ID_LABEL.getTextLabel(), id);
        return planInfoMap;
    }

    public Map<Text, Control> getChildDocInfoMap(Task task){
        Map<Text, Control> taskInfoMap = new LinkedHashMap<>();
        taskInfoMap.putIfAbsent(NAME_LABEL.getTextLabel(), new TextField(task.getName()));
        taskInfoMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), new TextField(task.getDescription()));
        return taskInfoMap;
    }

    public Map<Text, Text> getChildDocInfoConstantMap(Task task){
        Map<Text, Text> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), new Text(task.getCreateDate().toString()));
        return planInfoMap;
    }

//    private Button customizeLoadButton(Button loadButton) {
//        loadButton.setAlignment(Pos.BOTTOM_RIGHT);
//        return loadButton;
//    }
//
//    private Button customizeCreateTaskButton(Button createTaskButton) {
//        createTaskButton.setAlignment(Pos.BOTTOM_RIGHT);
//        return createTaskButton;
//    }

    public void setCreateTaskEventHandler(EventHandler eventCreateTask) {
        createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventCreateTask);
    }

    public void setLoadTaskEventHandler(EventHandler eventLoadTask) {
        loadButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventLoadTask);
    }

    public TextField getTaskIdText() {
        return taskIdText;
    }

}
