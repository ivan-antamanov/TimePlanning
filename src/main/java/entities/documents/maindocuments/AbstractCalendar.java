package entities.documents.maindocuments;


public abstract class AbstractCalendar extends AbstractMainDocument {
    public AbstractDairy dairy;

    public AbstractDairy getDairy() {
        return dairy;
    }

    public void setDairy(AbstractDairy dairy) {
        this.dairy = dairy;
    }
}
