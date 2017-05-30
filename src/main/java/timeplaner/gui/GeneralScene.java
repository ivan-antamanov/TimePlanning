package timeplaner.gui;


import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeneralScene extends Scene {


    private Parent parent;

    private List<Parent> parents;

    public GeneralScene(@NamedArg("root") Parent root) {
        super(root);
    }

    public void setParentList(Parent... elements) {
        ((Pane) this.getRoot()).getChildren().addAll(elements);
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    private MenuBar getMenu() { //todo rebuild
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");

        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        menuFile.getItems().addAll(saveItem, exitItem);

        Menu menuOptions = new Menu("Option");
        MenuItem badSightedItem = new MenuItem("Bad-Sighted version");

        menuOptions.getItems().addAll(badSightedItem);

        menuBar.getMenus().addAll(menuFile, menuOptions);
        return menuBar;
    }

    private Pane getHigherPanel() {
        VBox menuPane = new VBox(getMenu());
        menuPane.setVisible(true);
        menuPane.setAlignment(Pos.TOP_CENTER);
        return menuPane;
    }

}
