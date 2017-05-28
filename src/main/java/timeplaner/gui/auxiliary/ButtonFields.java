package timeplaner.gui.auxiliary;


import java.awt.*;

public enum ButtonFields {

    LOAD_BUTTON("Load"),
    SAVE_BUTTON("Save"),
    CREATE_BUTTON("Create"),
    ;

    private String name;
    private Button button;

    ButtonFields(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getButton() {
        return new Button(name);
    }
}
