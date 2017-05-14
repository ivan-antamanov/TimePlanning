package entities.documents.maindocuments;

import entities.documents.AbstractDocument;
import entities.documents.subdocuments.Task;

public abstract class AbstractMainDocument extends AbstractDocument {

    private Task subDocument;

    public Task getSubDocument() {
        return subDocument;
    }

    public void setSubDocument(Task subDocument) {
        this.subDocument = subDocument;
    }
}
