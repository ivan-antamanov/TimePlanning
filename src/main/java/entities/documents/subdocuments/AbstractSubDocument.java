package entities.documents.subdocuments;

import entities.documents.AbstractDocument;
import entities.documents.maindocuments.AbstractMainDocument;

import java.time.Period;
import java.util.Date;


public abstract class AbstractSubDocument extends AbstractDocument {
    private AbstractMainDocument mainDocument;

    public AbstractSubDocument() {
    }

    public AbstractSubDocument(Long id) {
        super(id);
    }

    public AbstractSubDocument(String name, String description) {
        super(name, description);
    }

    public AbstractSubDocument(String name, Long id, String description) {
        super(name, id, description);
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
