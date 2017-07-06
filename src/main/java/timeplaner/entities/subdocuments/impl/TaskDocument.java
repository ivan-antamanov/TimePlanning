package timeplaner.entities.subdocuments.impl;

import timeplaner.entities.subdocuments.AbstractAction;


public class TaskDocument extends AbstractAction {

    public TaskDocument() {
        super();
    }

    public TaskDocument(Long id) {
        super(id);
    }

    public TaskDocument(String name, String description) {
        super(name, description);
    }

}
