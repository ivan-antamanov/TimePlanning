package timeplaner.entities;


import timeplaner.entities.maindocuments.AbstractMainDocument;

import java.io.Serializable;
import java.time.*;

public class StubDocument implements DocumentModel, Serializable {

    private String name;
    private String description;
    private LocalDate createDate;
    private Long id;
//    private Logger logActivity; todo Add logger as Class
//    private People people; todo Add people as Class
//    private VisualMarker visualMarker todo Add Marker as Class
//    private Report report todo Add Marker as report or make it as utils class
    private Boolean docWasChanged;
    private Period period;
    private Person owner;
    private AbstractMainDocument mainDocument;
    private Type type;


    public StubDocument() {
        this("No Name", "Put description");
    }

    public StubDocument(Long id) {
        this.id = id;
    }

    public StubDocument(String name, String description) {
        this.name = name;
        this.description = description;
        createDate = LocalDate.now();
        id = setUniqueId();
//        this.period = period;
    }

    private long setUniqueId() {
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Africa/Cairo"));
        return zdt.toInstant().toEpochMilli();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public AbstractMainDocument getMainDocument() {
        return mainDocument;
    }

    public void setMainDocument(AbstractMainDocument mainDocument) {
        this.mainDocument = mainDocument;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDocWasChanged() {
        return docWasChanged;
    }

    public void setDocWasChanged(Boolean docWasChanged) {
        this.docWasChanged = docWasChanged;
    }
}
