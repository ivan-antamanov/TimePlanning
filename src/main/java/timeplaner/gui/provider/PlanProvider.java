package timeplaner.gui.provider;


import javafx.scene.Parent;
import javafx.scene.Scene;
import timeplaner.controller.PlanController;
import timeplaner.gui.broker.PlanBroker;
import timeplaner.gui.docparents.impl.PlanParent;
import timeplaner.dao.LocalSession;

public class PlanProvider extends Parent {

    PlanBroker planBroker = new PlanBroker();
    PlanParent planParent = new PlanParent();
    PlanController planController;

    public PlanProvider(LocalSession localSession, Scene generalScene) {
        planController = new PlanController(localSession);
    }



    public Parent getPlanParent(){
        return planParent.returnButtonPlanParent(planBroker.getControlBottom());
    }
}
