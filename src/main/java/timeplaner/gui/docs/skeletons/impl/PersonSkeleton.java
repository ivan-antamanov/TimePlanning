package timeplaner.gui.docs.skeletons.impl;


import javafx.scene.control.*;
import javafx.scene.text.Text;
import timeplaner.entities.PersonDocument;
import timeplaner.entities.subdocuments.impl.TaskDocument;
import timeplaner.gui.docs.skeletons.AbstractSkeleton;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.*;
import static timeplaner.gui.utils.LabelFields.TASK_LIST;


public class PersonSkeleton extends AbstractSkeleton<PersonSkeleton, PersonDocument> {

    protected ChoiceBox<String> gender = new ChoiceBox<>();
    protected TextField surname = new TextField();
    protected TextField birthDate = new TextField();

    protected ListView<String> docList = new ListView<>();
    protected Button loadButton;
    protected Button createButton;
    protected Button deleteButton;

    @Override
    protected void registrationEvents() {
        gender.getItems().addAll(PersonDocument.Gender.getAllGenders());
        createButton = new Button("Create Plan");
        loadButton = new Button("Edit Plan");
        deleteButton = new Button("Delete Plan");

        //todo button event

    }

    @Override
    public PersonSkeleton newSkeleton(PersonDocument personDocument) {
        name.clear();
        surname.clear();
        description.clear();
        creationDate.setText(personDocument.getCreateDate().toString());
        id.setText(String.valueOf(personDocument.getId()));
        birthDate.clear();
        return this;
    }

    @Override
    public PersonSkeleton updateSkeleton(PersonDocument personDocument) {
        name.setText(personDocument.getName());
        surname.setText(personDocument.getSurName());
        gender.getSelectionModel().select(personDocument.getGender().getString());
        description.setText(personDocument.getDescription());
        creationDate.setText(personDocument.getCreateDate().toString());
        id.setText(String.valueOf(personDocument.getId()));
        return this;
    }

    @Override
    public PersonDocument getDocument() {
        PersonDocument personDocument = new PersonDocument(name.getText(), description.getText());
        personDocument.setGender(PersonDocument.Gender.getGender(gender.getValue()));
        personDocument.setDescription(description.getText());
        personDocument.setSurName(surname.getText());
        return personDocument;
    }

    public Map<Text, Control> getThisDocInfoMap(){ //todo think how to rebuild these methods
        Map<Text, Control> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(NAME_LABEL.getTextLabel(), name);
        planInfoMap.putIfAbsent(SURNAME.getTextLabel(), surname);
        planInfoMap.putIfAbsent(BIRTHDAY.getTextLabel(), birthDate);
        planInfoMap.putIfAbsent(GENDER.getTextLabel(), gender);
//        planInfoMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), description);
        return planInfoMap;
    }

    public Map<Text, Text> getThisDocInfoConstantMap(){
        Map<Text, Text> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), creationDate);
        planInfoMap.putIfAbsent(ID_LABEL.getTextLabel(), id);
        return planInfoMap;
    }

    public Map<Text, Control> getChildDocInfoMap(TaskDocument taskDocument){
        Map<Text, Control> taskInfoMap = new LinkedHashMap<>();
        taskInfoMap.putIfAbsent(NAME_LABEL.getTextLabel(), new TextField(taskDocument.getName()));
        taskInfoMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), new TextField(taskDocument.getDescription()));
        return taskInfoMap;
    }

    public Map<Text, Text> getChildDocInfoConstantMap(TaskDocument taskDocument){
        Map<Text, Text> planInfoMap = new LinkedHashMap<>();
        planInfoMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), new Text(taskDocument.getCreateDate().toString()));
        return planInfoMap;
    }

    public Map<Text, Control> getTaskList(){
        Map<Text, Control> tasksInfoMap = new LinkedHashMap<>();
        tasksInfoMap.putIfAbsent(TASK_LIST.getTextLabel(), docList);
        docList.setMaxHeight(220);
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

}
