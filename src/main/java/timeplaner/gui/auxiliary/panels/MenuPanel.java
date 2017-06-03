package timeplaner.gui.auxiliary.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuPanel extends Pane implements Panel {

    public MenuPanel() {
        this.getChildren().addAll(getHigherPanel());
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
