package entities.documents.subdocuments;

import entities.documents.AbstractDocument;
import entities.documents.maindocuments.AbstractMainDocument;

import java.time.Period;
import java.util.Date;


public abstract class AbstractSubDocument extends AbstractDocument {
    private AbstractMainDocument mainDocument;

    public AbstractSubDocument() {
    }

    public AbstractSubDocument(String name, String description, Period period) {
        super(name, description, period);
    }

    public AbstractSubDocument(String name, Integer id, String description, Period period) {
        super(name, id, description, period);
    }
//    private TimeTracker timeTracker todo realization
//    private Attachment attachment todo realization
//    private Priority priority todo realization


    public AbstractMainDocument getMainDocument() {
        return mainDocument;
    }

    public void setMainDocument(AbstractMainDocument mainDocument) {
        this.mainDocument = mainDocument;
    }
}
