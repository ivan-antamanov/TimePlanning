package entities.documents.subdocuments;

import entities.documents.AbstractDocument;
import entities.documents.maindocuments.AbstractMainDocument;


public abstract class AbstractSubDocument extends AbstractDocument {
    private AbstractMainDocument mainDocument;
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
