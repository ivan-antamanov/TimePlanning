package entities.documents.maindocuments;

import entities.documents.subdocuments.AbstractSchedule;
import entities.documents.subdocuments.impl.Schedule;

import java.util.List;


public abstract class AbstractDairy extends AbstractMainDocument {

    public List<AbstractSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<AbstractSchedule> schedules) {
        this.schedules = schedules;
    }

    private List<AbstractSchedule> schedules;

}
