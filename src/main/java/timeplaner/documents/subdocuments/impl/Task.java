package timeplaner.documents.subdocuments.impl;

import timeplaner.documents.subdocuments.AbstractAction;


public class Task extends AbstractAction {

    public Task() {
    }

    public Task(Long id) {
        super(id);
    }

    public Task(String name, String description) {
        super(name, description);
    }

    public Task(String name, Long id, String description) {
        super(name, id, description);
    }
}
