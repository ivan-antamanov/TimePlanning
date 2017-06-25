package timeplaner.gui.docs.parents;


import javafx.scene.Parent;
import timeplaner.entities.Document;
import timeplaner.entities.subdocuments.DocumentAction;

public interface ParentDocument {

    public void showSuccessDialog(); //todo put to Utils

    public Parent updateDocParent(Document document);

    public Parent getDocParent();

    

}
