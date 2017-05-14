package entities.documents;


public class AbstractDocument implements Document {

    private String name;
    private Integer id;
    private String description;
//    private Logger logActivity; todo Add logger as Class
//    private People people; todo Add people as Class
//    private VisualMarker visualMarker todo Add Marker as Class
//    private Report report todo Add Marker as report or make it as utils class
    private Boolean docWasChanged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
