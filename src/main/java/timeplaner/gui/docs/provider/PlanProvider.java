package timeplaner.gui.docs.provider;


import javafx.scene.Parent;
import javafx.scene.Scene;
import timeplaner.controller.PlanController;
import timeplaner.gui.docs.carcases.PlanCarcase;
import timeplaner.gui.docs.parents.impldoc.PlanParent;
import timeplaner.dao.LocalSession;

public class PlanProvider {

    PlanCarcase planCarcase = new PlanCarcase();
    PlanParent planParent = new PlanParent();
    PlanController planController;

    public PlanProvider(LocalSession localSession, Scene generalScene) {
        planController = new PlanController(localSession);
    }



    public Parent getPlanParent(){
        return planParent.returnButtonPlanParent(planCarcase.getControlBottom());
    }
}
