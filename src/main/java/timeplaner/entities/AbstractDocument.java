package timeplaner.entities;


import java.io.Serializable;
import java.time.Period;
import java.util.Date;

public class AbstractDocument implements Document, Serializable {

    private String name;
    private Long id;
    private String description;
//    private Logger logActivity; todo Add logger as Class
//    private People people; todo Add people as Class
//    private VisualMarker visualMarker todo Add Marker as Class
//    private Report report todo Add Marker as report or make it as utils class
    private Boolean docWasChanged;
    private Date createDate = new Date();
    private Period period;

    public AbstractDocument() {
    }

    public AbstractDocument(Long id) {
        this.id = id;
    }

    public AbstractDocument(String name, String description) {
        this(name, null, description);
    }

    public AbstractDocument(String name, Long id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.createDate = new Date();
//        this.period = period;
    }



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
