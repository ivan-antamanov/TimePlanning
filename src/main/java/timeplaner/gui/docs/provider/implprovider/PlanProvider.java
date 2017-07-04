package timeplaner.gui.docs.provider.implprovider;


import timeplaner.bo.impl.PlanController;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.maindocuments.impl.Plan;
import timeplaner.gui.docs.parents.impldoc.PlanParent;
import timeplaner.gui.docs.provider.AbstractProvider;
import timeplaner.gui.docs.skeletons.impl.PlanSkeleton;

public class PlanProvider extends AbstractProvider<PlanController, PlanParent, Plan> {

    PlanController planController;

    public PlanProvider(SessionFactory localSession) {
        parent = new PlanParent(new PlanSkeleton());
        planController = new PlanController(localSession);
    }

    @Override
    protected void registrationEvents() {
    }

    @Override
    protected void showSuccessDialog() {
        throw new UnsupportedOperationException("Operation showSuccessDialog not supported yet");
    }

    @Override
    public PlanParent newNode() {
        throw new UnsupportedOperationException("Operation newNode not supported yet");
    }

    @Override
    public PlanParent updateNode(Plan plan) {
        throw new UnsupportedOperationException("Operation updateNode not supported yet");
    }

    @Override
    public PlanParent getNode() {
        return parent.getDocParent();
    }
}
