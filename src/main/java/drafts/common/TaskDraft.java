package drafts.common;


import timeplaner.entities.subdocuments.impl.Task;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TaskDraft extends Application {

    private Task document;


    public void start(Stage primaryStage) throws Exception {
        setDocument(getTask());

        Scene scene = convertDocumentToNode();

        primaryStage.setTitle("TimeApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Task getTask(){
        Task task = new Task();
        task.setName("Implement GUI part");
        task.setDescription("Need to implement uml-class diagram for GUI and starting code implementation");
        return task;
    }

    private Scene convertDocumentToNode() {
        Text nameLabel = new Text("Name");
        TextField nameText = new TextField(document.getName());

        Text mainDocLabel = new Text("Main GuiDocument");
        TextField mainDocText = new TextField(); //todo check if document is present

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

        gridPane.add(descriptionLabel, 0, 2);

        gridPane.add(descriptionText, 1, 2);

        return new Scene(gridPane);
    }


    public Task getDocument() {
        return document;
    }

    public void setDocument(Task document) {
        this.document = document;
    }

    public static void main(String[] args) {



        launch(args);
    }
}
