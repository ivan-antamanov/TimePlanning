package javafx_test;/**
 * Created by iantaman on 11.02.2017.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StackPaneExample extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing a Circle
        Circle circle = new Circle(20);
        circle.setFill(Color.DARKSLATEBLUE);
        circle.setStroke(Color.BLACK);



        StackPane stackPane = new StackPane();

        //Setting the margin for the circle
        stackPane.setMargin(circle,new Insets(0));

        ObservableList list = stackPane.getChildren();

        //Adding all the nodes to the pane
//        list.addAll(square, circle);

        //Creating a scene object
        Scene scene = new Scene(stackPane);

        //Setting title to the Stage
        stage.setTitle("Stack Pane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}