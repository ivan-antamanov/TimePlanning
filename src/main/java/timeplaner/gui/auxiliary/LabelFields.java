package timeplaner.gui.auxiliary;


import javafx.scene.text.Text;

public enum LabelFields {

    RIGHT_SLASH(" / "),
    NAME_LABEL("Name"),
    STATUS_LABEL("Status"),
    PRIORITY_LABEL("Priority"),
    DESCRIPTION_LABEL("Description"),
    CREATION_DATE_LABEL("Creation Date"),
    PERIOD_LABEL("Period"),
    LINKED_TASK_LABEL("Linked Task"),
    MAIN_DOC_LABEL("Main Document"),
    ID_LABEL("ID")
    ;

    private String name;
    private Text textLabel;

    LabelFields(String name) {
        this.name = name + ":";
    }

    public Text getTextLabel() {
        return new Text(this.name());
    }
}
