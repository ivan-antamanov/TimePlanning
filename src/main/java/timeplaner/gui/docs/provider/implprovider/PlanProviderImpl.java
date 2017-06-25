package timeplaner.gui.docs.provider.implprovider;


import javafx.scene.Parent;
import javafx.scene.Scene;
import timeplaner.bo.PlanController;
import timeplaner.entities.Document;
import timeplaner.gui.docs.parents.impldoc.PlanParentImpl;
import timeplaner.dao.LocalSession;
import timeplaner.gui.docs.provider.AbstractPlanProvider;
import timeplaner.gui.docs.skeletons.impl.PlanSkeletonImpl;

import java.util.List;

public class PlanProviderImpl extends AbstractPlanProvider {

    PlanController planController;

    public PlanProviderImpl(LocalSession localSession, Scene generalScene) {
        planParent = new PlanParentImpl(new PlanSkeletonImpl());
        planController = new PlanController(localSession);
    }

    public Parent getPlanParentImpl(){
        return planParent.getDocParent();
    }


    @Override
    protected void registrationEvents() {

    }

    @Override
    protected void showSuccessDialog() {
        throw new UnsupportedOperationException("Operation showSuccessDialog not supported yet");
    }

    @Override
    public Parent newNode() {
        throw new UnsupportedOperationException("Operation newNode not supported yet");
    }

    @Override
    public Parent updateNode(Document document) {
        throw new UnsupportedOperationException("Operation updateNode not supported yet");
    }

    @Override
    public Parent getNode() {
        throw new UnsupportedOperationException("Operation updateNode not supported yet");
    }
}
