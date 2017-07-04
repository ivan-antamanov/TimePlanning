package timeplaner.gui.docs.parents;


import timeplaner.entities.DocumentModel;

public interface ParentDocument<T extends DocumentModel, V extends AbstractDocParent> {

    public void showSuccessDialog(); //todo put to Utils

    public V updateDocParent(T documentModel);

    public V getDocParent();

    
}
