package timeplaner.core.entities;


public enum Type {

    PROJECT("PlanDocument", true),
    TASK("TaskDocument", false),


    ;

    String typeName;
    Boolean mainDocument;

    Type(String typeName, Boolean mainDocument) {
        this.typeName = typeName;
        this.mainDocument = mainDocument;
    }

    public String getTypeName() {
        return typeName;
    }

    public Boolean isMainDocument() {
        return mainDocument;
    }
}
