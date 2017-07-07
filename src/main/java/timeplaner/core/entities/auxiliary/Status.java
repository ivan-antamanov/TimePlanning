package timeplaner.core.entities.auxiliary;

import java.util.Arrays;
import java.util.List;

public enum Status {

    OPEN("OPEN"),
    WORK_DONE("WORK DONE"),
    IN_PROGRESS("IN PROGRESS"),
    ON_HOLD("OH HOLD"),
    ;

    private String name;
    private String comment;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static String[] getAllNames(){
        Status [] statuses = Status.values();
        int namesSize = statuses.length;
        String[] statusNames = new String[namesSize];
        for (int i=0; i<=namesSize-1; i++) {
            statusNames[i] = statuses[i].getName();
        }
        return statusNames;
    }

    public static Status getByName(String name){
        List<Status> statuses = Arrays.asList(values());
        for (Status status : statuses) {
            if(status.getName().equals(name)){
                return status;
            }
        }
        return null;
    }
}
