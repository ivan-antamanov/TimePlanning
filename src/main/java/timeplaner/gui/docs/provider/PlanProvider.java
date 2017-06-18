package timeplaner.gui.docs.provider;


import javafx.scene.Parent;
import javafx.scene.Scene;
import timeplaner.bo.PlanController;
import timeplaner.gui.docs.parents.impldoc.PlanParent;
import timeplaner.dao.LocalSession;

public class PlanProvider {

    PlanParent planParent = new PlanParent();
    PlanController planController;

    public PlanProvider(LocalSession localSession, Scene generalScene) {
        planController = new PlanController(localSession);
    }



    public Parent getPlanParent(){
        return planParent.getGeneralPane();
    }
}
