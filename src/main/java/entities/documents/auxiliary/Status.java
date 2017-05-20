package entities.documents.auxiliary;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
