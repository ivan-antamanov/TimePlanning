package timeplaner.gui.docs.skeletons;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public abstract class AbstractSkeleton implements Skeleton {

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

}
