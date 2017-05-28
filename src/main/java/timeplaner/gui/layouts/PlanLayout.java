package timeplaner.gui.layouts;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import timeplaner.gui.broker.PlanBroker;

import java.util.List;

public class PlanLayout {

    PlanBroker planBroker;

    public PlanLayout(PlanBroker planBroker) {
        this.planBroker = planBroker;
    }




    public Parent returnButtonPlanParent(List<Control> controls){
        FlowPane buttonPane = (FlowPane) customizeButtonsPane();
        controls.forEach(control -> buttonPane.getChildren().add(control));
        return buttonPane;
    }

    private Pane customizeButtonsPane(){
        FlowPane startPane = new FlowPane();
        startPane.setOrientation(Orientation.HORIZONTAL);
        startPane.setAlignment(Pos.CENTER);
        startPane.setMinSize(700,600);
        startPane.setMaxSize(820,820);
        return startPane;
    }

}
