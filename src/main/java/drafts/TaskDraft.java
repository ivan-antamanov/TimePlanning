package drafts;


import entities.documents.subdocuments.Task;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class TaskDraft extends Application {

    Task document;


    public void start(Stage primaryStage) throws Exception {

    }


    private Scene convertDocumentToNode() {
        Text nameLabel = new Text("Name");
        TextField nameText = new TextField(document.getName());

        Text mainDocLabel = new Text("Main Document");
        TextField mainDocText = new TextField(document.getMainDocument().getName()); //todo check if document is present

        Text descriptionLabel = new Text("Description");
        TextField descriptionText = new TextField(document.getDescription());


        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(5, 10, 50, 25));

        gridPane.setMinSize(500, 500);
        gridPane.setVgap(25);
        gridPane.setHgap(25);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameText, 1, 0);

        gridPane.add(mainDocLabel, 0, 1);
        gridPane.add(mainDocText, 1, 1);

        gridPane.add(descriptionLabel, 1, 2);

        gridPane.add(descriptionText, 2, 2);

        return new Scene(gridPane);
    }


    public Task getDocument() {
        return document;
    }

    public void setDocument(Task document) {
        this.document = document;
    }
}
