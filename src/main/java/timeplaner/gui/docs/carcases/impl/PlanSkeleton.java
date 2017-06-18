package timeplaner.gui.docs.carcases.impl;


import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadTaskEvent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static timeplaner.gui.additional.LabelFields.*;

public class PlanSkeleton extends AbstractSkeleton {

    private Hyperlink mainDocument = new Hyperlink();

    private ListView<String> taskList = new ListView<>();
    private Button loadButton;
    private Button createButton;
    private Button deleteButton;
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
                EventProcessor.send(new LoadTaskEvent(Long.valueOf(taskIdText.getText()))));
    }

    @Override
    public AbstractSkeleton newSkeleton(AbstractDocument abstractDocument) {
        return null;
    }

    @Override
    public AbstractSkeleton updateSkeleton(AbstractDocument abstractDocument) {
        return null;
    }

    @Override
    public AbstractDocument getDocument() {
        return null;
    }

    public Map<Text, Control> getPlanInfoMap(){ //todo think how to rebuild these methods
        Map<Text, Control> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(NAME_LABEL.getTextLabel(), name);
        planInfoMap.putIfAbsent(MAIN_DOC_LABEL.getTextLabel(), mainDocument);
//        planInfoMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), description);
        return planInfoMap;
    }

    public Map<Text, Text> getPlanInfoConstantMap(){
        Map<Text, Text> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), creationDate);
        planInfoMap.putIfAbsent(ID_LABEL.getTextLabel(), id);
        return planInfoMap;
    }

    public Map<Text, Control> getTaskInfoMap(Task task){
        Map<Text, Control> taskInfoMap = new LinkedHashMap<>();
        taskInfoMap.putIfAbsent(NAME_LABEL.getTextLabel(), new TextField(task.getName()));
        taskInfoMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), new TextField(task.getDescription()));
        return taskInfoMap;
    }

    public Map<Text, Text> getTaskInfoConstantMap(Task task){
        Map<Text, Text> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), new Text(task.getCreateDate().toString()));
        return planInfoMap;
    }

    public Map<Text, Control> getTaskList(){
        Map<Text, Control> tasksInfoMap = new LinkedHashMap<>();
        tasksInfoMap.putIfAbsent(TASK_LIST.getTextLabel(), taskList);
        taskList.setMaxHeight(300);
        return tasksInfoMap;
    }

    public void updateTaskList(List<String> projectsTask){
        taskList.getItems().addAll(projectsTask);
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
