package entities.documents.auxiliary;


public enum Priority {
    //create common class for statuses and prioritises?

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
}
