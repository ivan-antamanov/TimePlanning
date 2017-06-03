package timeplaner.gui.docparents.impl;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.List;

public class PlanParent extends Parent {


    public Parent returnButtonPlanParent(List<Control> controls){
        FlowPane buttonPane = (FlowPane) customizeButtonsPane();
        controls.forEach(control -> buttonPane.getChildren().add(control));
        return buttonPane;
    }

    private Pane customizeButtonsPane(){
        FlowPane startPane = new FlowPane();
        startPane.setOrientation(Orientation.HORIZONTAL);
        startPane.setAlignment(Pos.CENTER);
        startPane.setMinSize(700,400);
        startPane.setMaxSize(820,420);
        return startPane;
    }

}
