package entities.documents.subdocuments.impl;

import entities.documents.subdocuments.AbstractAction;

import java.time.Period;
import java.util.Date;


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
