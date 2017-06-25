package timeplaner.entities.subdocuments;


import timeplaner.entities.auxiliary.Priority;
import timeplaner.entities.auxiliary.Status;

import java.util.List;

public abstract class AbstractAction extends AbstractSubDocument implements DocumentAction {
//    private Reminder reminder todo realisation
    private Priority priority;
    private Status status;
    private List<AbstractAction> linkedSubDocs;

    public AbstractAction() {
        super();
    }

    public AbstractAction(Long id) {
        super(id);
    }

    public AbstractAction(String name, String description) {
        super(name, description);
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<AbstractAction> getLinkedSubDocs() {
        return linkedSubDocs;
    }

    public void setLinkedSubDocs(List<AbstractAction> linkedSubDocs) {
        this.linkedSubDocs = linkedSubDocs;
    }

    //    public abstract AbstractAction typeOfDocument();
}
