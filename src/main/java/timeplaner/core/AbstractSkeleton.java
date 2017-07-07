package timeplaner.core;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import timeplaner.core.entities.DocumentModel;


public abstract class AbstractSkeleton<T extends Skeleton, V extends DocumentModel> implements Skeleton<T,V> {

    protected TextField name;
    protected Text id;
    protected Text creationDate;

    protected TextArea description = new TextArea();

    protected Button backButton = new Button("Back");

    protected AbstractSkeleton() {
        name = new TextField();
        id = new Text();
        creationDate = new Text();
        registrationEvents();
    }

    protected abstract void registrationEvents();

    public Button getBackButton() {
        backButton.setAlignment(Pos.BASELINE_RIGHT);
        return backButton;
    }
}
