package timeplaner.entities.subdocuments.impl;

import timeplaner.entities.subdocuments.AbstractAction;


public class Task extends AbstractAction {

    public Task() {
        super();
    }

    public Task(Long id) {
        super(id);
    }

    public Task(String name, String description) {
        super(name, description);
    }

}
