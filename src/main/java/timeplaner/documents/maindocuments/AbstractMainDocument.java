package timeplaner.documents.maindocuments;

import timeplaner.documents.AbstractDocument;
import timeplaner.documents.subdocuments.AbstractSubDocument;

public abstract class AbstractMainDocument extends AbstractDocument {

    private AbstractSubDocument subDocument;

    public AbstractSubDocument getSubDocument() {
        return subDocument;
    }

    public void setSubDocument(AbstractSubDocument subDocument) {
        this.subDocument = subDocument;
    }
}
