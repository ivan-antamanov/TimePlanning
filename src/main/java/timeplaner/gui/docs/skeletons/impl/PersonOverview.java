package timeplaner.gui.docs.skeletons.impl;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;
import timeplaner.gui.docs.skeletons.AbstractSkeleton;
import timeplaner.gui.docs.skeletons.Skeleton;

import java.time.LocalDate;

public class PersonOverview extends AbstractSkeleton {

    private Text birthDate;
    private Text gender;



    @Override
    public Skeleton newSkeleton(AbstractDocument abstractDocument) {
        return null;
    }

    @Override
    public Skeleton updateSkeleton(AbstractDocument abstractDocument) {
        return null;
    }

//    @Override
    public Document getDocument() {
        return null;
    }

    @Override
    protected void registrationEvents() {

    }
}
