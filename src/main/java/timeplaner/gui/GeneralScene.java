package timeplaner.gui;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GeneralScene {


    private Parent parent;

    private Scene scene;

    public GeneralScene(Parent parent) {
        this.parent = parent;
        scene = new Scene(parent);
    }

    public void setRoot(Parent value){
        parent = value;
        scene.setRoot(value);

    }

    public void updateScene(Parent value){
        ((Pane) scene.getRoot()).getChildren().removeAll();
        ((Pane) scene.getRoot()).getChildren().add(value);
    }

    public Scene getScene() {
        return scene;
    }

}
