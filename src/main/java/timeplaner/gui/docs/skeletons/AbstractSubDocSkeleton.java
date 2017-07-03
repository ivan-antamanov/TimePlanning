package timeplaner.gui.docs.skeletons;


import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.function.Predicate;

import static timeplaner.gui.utils.LabelFields.*;
import static timeplaner.gui.utils.LabelFields.CREATION_DATE_LABEL;
import static timeplaner.gui.utils.LabelFields.DESCRIPTION_LABEL;

public abstract class AbstractSubDocSkeleton extends AbstractSkeleton implements SubDocSkeleton {

    protected TextField mainDocument = new TextField(); //todo take out instantiating
    protected ChoiceBox<String> priorityChoiceBox = new ChoiceBox<>();
    protected ChoiceBox<String> statusChoiceBox = new ChoiceBox<>();
    protected TextField taskPeriod = new TextField();
    protected TextField linkedTask = new TextField();
    protected Button saveButton ;


    public AbstractSubDocSkeleton() {
        saveButton = new Button("SaveButton");
    }

    public List<Hyperlink> getHyperLinkTop() {
        Predicate<String> isBlank = StringUtils::isBlank;
        Hyperlink mainProjectHypLink = new Hyperlink();
        Hyperlink taskNameHypLink = new Hyperlink();
        if (isBlank.test(mainDocument.getText())) {
            mainProjectHypLink.setText("No Main Plan");
        } else {
            mainProjectHypLink.setText(mainDocument.getText());
        }

        if (isBlank.test(name.getText())) {
            taskNameHypLink.setText("No Task Name");
        } else {
            taskNameHypLink.setText(name.getText());
        }

        return Arrays.asList(mainProjectHypLink, taskNameHypLink);
    }

    public Map<Text, Control> getLabelAndControlMapLeft() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        getLabelAndControlMap.putIfAbsent(NAME_LABEL.getTextLabel(), name);
        getLabelAndControlMap.putIfAbsent(PRIORITY_LABEL.getTextLabel(), priorityChoiceBox);
        getLabelAndControlMap.putIfAbsent(STATUS_LABEL.getTextLabel(), statusChoiceBox);

        return getLabelAndControlMap;
    }

    public Map<Text, Text> getConstantLabelsMap(){
        Map<Text, Text> getLabelsMap = new LinkedHashMap<>();
        getLabelsMap.putIfAbsent(ID_LABEL.getTextLabel(), id);
        getLabelsMap.putIfAbsent(CREATION_DATE_LABEL.getTextLabel(), creationDate);
        return getLabelsMap;
    }

    public Map<Text, Control> getLabelAndControlMapCenter() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        customizeDescription(description);
        getLabelAndControlMap.putIfAbsent(DESCRIPTION_LABEL.getTextLabel(), description);

        return getLabelAndControlMap;
    }

    public Map<Text, Control> getLabelAndControlMapBottom() {
        Map<Text, Control> getLabelAndControlMap = new LinkedHashMap<>();
        getLabelAndControlMap.putIfAbsent(LINKED_TASK_LABEL.getTextLabel(), linkedTask);

        return getLabelAndControlMap;
    }

    private TextArea customizeDescription(TextArea taskDescription) {
        taskDescription.autosize();
//        taskDescription.setMinWidth(120);
        return taskDescription;
    }

    public List<Button> getButtonsBottom() {
        List<Button> buttons = new ArrayList<>(0);
        customizeSaveButton(saveButton);
        buttons.add(saveButton);
        buttons.add(backButton);
        return buttons;
    }

    public Button customizeSaveButton(Button saveButton) {
        saveButton.setAlignment(Pos.TOP_CENTER);
//        saveButton.addEventFilter();
        return saveButton;
    }

}
