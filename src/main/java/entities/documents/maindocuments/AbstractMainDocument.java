package entities.documents.maindocuments;

import entities.documents.AbstractDocument;
import entities.documents.subdocuments.AbstractSubDocument;

public abstract class AbstractMainDocument extends AbstractDocument {

    private AbstractSubDocument subDocument;

    public AbstractSubDocument getSubDocument() {
        return subDocument;
    }

    public void setSubDocument(AbstractSubDocument subDocument) {
        this.subDocument = subDocument;
    }
}
