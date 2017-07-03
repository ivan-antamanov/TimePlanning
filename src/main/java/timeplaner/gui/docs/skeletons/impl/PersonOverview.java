package timeplaner.gui.docs.skeletons.impl;


import javafx.scene.text.Text;
import timeplaner.entities.DocumentModel;
import timeplaner.gui.docs.skeletons.AbstractSkeleton;
import timeplaner.gui.docs.skeletons.Skeleton;

public class PersonOverview extends AbstractSkeleton {

    private Text birthDate;
    private Text gender;


    @Override
    public Skeleton newSkeleton(DocumentModel documentModel) {
        throw new UnsupportedOperationException("Operation newSkeleton not supported yet");
    }

    @Override
    public Skeleton updateSkeleton(DocumentModel documentModel) {
        throw new UnsupportedOperationException("Operation newSkeleton not supported yet");
    }

//    @Override
    public DocumentModel getDocument() {
        return null;
    }

    @Override
    protected void registrationEvents() {

    }
}
