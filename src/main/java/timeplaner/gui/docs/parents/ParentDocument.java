package timeplaner.gui.docs.parents;


import timeplaner.entities.subdocuments.AbstractAction;

public interface ParentDocument {

    public void showSuccessDialog();

    public AbstractSubDocParent updateTaskParent(AbstractAction action);

    

}
