package timeplaner.gui.docs.parents;


import javafx.scene.Parent;
import timeplaner.entities.DocumentModel;

public interface ParentDocument {

    public void showSuccessDialog(); //todo put to Utils

    public Parent updateDocParent(DocumentModel documentModel);

    public Parent getDocParent();

    

}
