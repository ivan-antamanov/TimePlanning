package drafts.project;


import entities.documents.AbstractDocument;
import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GeneralScene extends Scene {

    private AbstractDocument document;

    public GeneralScene(@NamedArg("root") Parent root) {
        super(root);
    }


}
