package timeplaner.entities.subdocuments;

import timeplaner.entities.AbstractDocument;
import timeplaner.entities.maindocuments.AbstractMainDocument;


public abstract class AbstractSubDocument extends AbstractDocument {
    private AbstractMainDocument mainDocument;

    public AbstractSubDocument() {
        super();
    }

    public AbstractSubDocument(Long id) {
        super(id);
    }

    public AbstractSubDocument(String name, String description) {
        super(name, description);
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
