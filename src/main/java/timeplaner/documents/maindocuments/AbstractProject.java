package timeplaner.documents.maindocuments;

import timeplaner.documents.subdocuments.impl.Aim;

import java.util.List;


public abstract class AbstractProject extends AbstractMainDocument {
    private Aim aim;
    private List<Aim> aims;

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
