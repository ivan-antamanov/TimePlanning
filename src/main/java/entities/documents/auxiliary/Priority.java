package entities.documents.auxiliary;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Priority {
    //todo create common class for statuses and prioritises?

    CRITICAL("CRITICAL"),
    NORMAL("NORMAL"),
    TRIVIAL("TRIVIAL"),
    ;

    private String name;
    private String comment;

    Priority(String name) {
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
        Priority [] priorities = Priority.values();
        int namesSize = priorities.length;
        String[] priorityNames = new String[namesSize];
        for (int i=0; i<=namesSize-1; i++) {
            priorityNames[i] = priorities[i].getName();
        }
        return priorityNames;
    }

    public static Priority getByName(String name){
        List<Priority> priorities = Arrays.asList(values());
        for (Priority priority : priorities) {
            if(priority.getName().equals(name)){
                return priority;
            }
        }
        return null;
    }
}
