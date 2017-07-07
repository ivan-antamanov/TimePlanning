package timeplaner.core.entities.maindocuments;

import timeplaner.core.entities.subdocuments.impl.Aim;

import java.util.List;


public abstract class AbstractPlan extends AbstractMainDocument {
    private Aim aim;
    private List<Aim> aims;

    public AbstractPlan(String name, String description) {
        super(name, description);
    }

    public Aim getAim() {
        return aim;
    }

    public void setAim(Aim aim) {
        this.aim = aim;
    }

    public List<Aim> getAims() {
        return aims;
    }

    public void setAims(List<Aim> aims) {
        this.aims = aims;
    }
}
