package timeplaner.entities.maindocuments;

import timeplaner.entities.StubDocument;
import timeplaner.entities.subdocuments.AbstractSubDocument;

public abstract class AbstractMainDocument extends StubDocument {

    private AbstractSubDocument subDocument;

    public AbstractMainDocument() {
        super();
    }

    public AbstractSubDocument getSubDocument() {
        return subDocument;
    }

    public void setSubDocument(AbstractSubDocument subDocument) {
        this.subDocument = subDocument;
    }
}
