package entities.documents.subdocuments.impl;

import entities.documents.subdocuments.AbstractAction;

import java.time.Period;
import java.util.Date;


public class Task extends AbstractAction {

    public Task() {
    }

    public Task(String name, String description, Period period) {
        super(name, description, period);
    }

    public Task(String name, Integer id, String description, Period period) {
        super(name, id, description, period);
    }
}
