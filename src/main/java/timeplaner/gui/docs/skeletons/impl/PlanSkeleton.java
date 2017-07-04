package timeplaner.gui.docs.skeletons.impl;


import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import timeplaner.entities.maindocuments.impl.Plan;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.docs.skeletons.AbstractSkeleton;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadDocumentEvent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.*;

public class PlanSkeleton extends AbstractSkeleton<PlanSkeleton, Plan> {

    protected ListView<String> docList = new ListView<>();
    protected Button loadButton;
    protected Button createButton;
    protected Button deleteButton;

    private Hyperlink mainDocument = new Hyperlink();
    private TextField taskIdText = new TextField("0");

    public PlanSkeleton() {
        super();
    }

    @Override
    protected void registrationEvents() {
        createButton = new Button("Create Task");
        loadButton = new Button("Edit task");
        deleteButton = new Button("Delete Task");
        createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> EventProcessor.send(new CreateTaskEvent()));
        loadButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                EventProcessor.send(new LoadDocumentEvent(Long.valueOf(taskIdText.getText()))));
    }

    @Override
    public PlanSkeleton newSkeleton(Plan documentModel) {
        return new PlanSkeleton();
    }

    @Override
    public PlanSkeleton updateSkeleton(Plan documentModel) {
        throw new UnsupportedOperationException("Functionality Update documentModel not Implemented yet");
    }

    @Override
    public Plan getDocument() {
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

    public Map<Text, Control> getTaskList(){
        Map<Text, Control> tasksInfoMap = new LinkedHashMap<>();
        tasksInfoMap.putIfAbsent(TASK_LIST.getTextLabel(), docList);
        docList.setMaxHeight(300);
        return tasksInfoMap;
    }


    public void updateTaskList(List<String> projectsTask){
        docList.getItems().addAll(projectsTask);
    }

    public List<Control> getButtonBottom() { //fixme there should be only buttons
        List<Control> controls = new ArrayList<>(0);
//        customizeCreateTaskButton(createButton);
//        customizeLoadButton(loadButton);
        controls.add(createButton);
        controls.add(loadButton);
        controls.add(deleteButton);
        return controls;
    }

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
