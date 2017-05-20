package drafts.common;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by iantaman on 15.05.2017.
 */
public class Controller {

    Scene scene;
    Parent root;
    Button buttonRegister = new Button("Check Scene");
    public Scene getScene() {
        return scene;
    }



    EventHandler<javafx.scene.input.MouseEvent> eventEventHandler = new EventHandler<javafx.scene.input.MouseEvent>() {
        public void handle(MouseEvent event) {
            if( event.getSource().equals(buttonRegister)){
                Stage stage = (Stage) buttonRegister.getScene().getWindow();
                Text textLabel = new Text("Text Hi");
                GridPane group = new GridPane();
                group.add(textLabel,0,0);
                group.setAlignment(Pos.CENTER);
                group.autosize();
                stage.setScene(new Scene(group));
            }

        }

    };

    public Scene getConcreteScene(){

        buttonRegister.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventEventHandler);
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.setMinSize(500, 500);
        gridPane.add(buttonRegister,0,0);
        Scene firstScene = new Scene(gridPane);
        return firstScene;
    }
}
