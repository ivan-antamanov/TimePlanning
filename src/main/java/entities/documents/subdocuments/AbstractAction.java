package entities.documents.subdocuments;


import entities.documents.auxiliary.Priority;
import entities.documents.auxiliary.Status;
import entities.documents.maindocuments.AbstractMainDocument;

import java.time.Period;
import java.util.Date;
import java.util.List;

public abstract class AbstractAction extends AbstractSubDocument {
//    private Reminder reminder todo realisation
    private Priority priority;
    private Status status;
    private List<AbstractAction> linkedSubDocs;

    public AbstractAction() {
    }

    public AbstractAction(String name, String description, Period period) {
        super(name, description, period);
    }

    public AbstractAction(String name, Integer id, String description, Period period) {
        super(name, id, description, period);
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
