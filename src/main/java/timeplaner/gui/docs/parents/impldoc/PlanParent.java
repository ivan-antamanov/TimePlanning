package timeplaner.gui.docs.parents.impldoc;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import timeplaner.gui.docs.parents.GuiDocument;

import java.util.List;

public class PlanParent extends Parent implements GuiDocument {


    public PlanParent returnButtonPlanParent(List<Control> controls){
        FlowPane buttonPane = (FlowPane) customizeButtonsPane();
        controls.forEach(control -> buttonPane.getChildren().add(control));
        this.getChildren().addAll(buttonPane);
        return this;
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
