package timeplaner.controller;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import timeplaner.documents.subdocuments.impl.Task;
import timeplaner.gui.GeneralScene;
import timeplaner.plugin.LocalSession;

import java.io.IOException;
import java.text.ParseException;


public class PlanController {

    private GeneralScene generalScene;
    private LocalSession localSession;

    public PlanController(LocalSession localSession) {
        this.localSession = localSession;
    }

    public LocalSession getLocalSession() {
        return localSession;
    }

    public GeneralScene getGeneralScene() {
        return generalScene;
    }

    public void setGeneralScene(GeneralScene generalScene) {
        this.generalScene = generalScene;
    }

    private MenuBar getMenu(){ //todo rebuild
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");

        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        menuFile.getItems().addAll(saveItem,exitItem);

        Menu menuOptions = new Menu("Option");
        MenuItem badSightedItem = new MenuItem("Bad-Sighted version");

        menuOptions.getItems().addAll(badSightedItem);

        menuBar.getMenus().addAll(menuFile, menuOptions);
        return menuBar;
    }

    private Pane getHigherPanel(){
        VBox menuPane = new VBox(getMenu());
        menuPane.setVisible(true);
        menuPane.setAlignment(Pos.TOP_CENTER);
        return menuPane;
    }

//    public GeneralScene updateScene(Parent parent){
//        mainScene.setRoot(getHigherPanel());
//        this.setRoot(parent);
//        return mainScene;
//
//    }



//    private Task getTaskById(int taskId) {
//        try {
//            try {
//                return localSession.findTaskById(taskId);
//            } catch (IOException e) {
//                System.out.println("Task with Id: " + taskId + " was not found");
//            } catch (ClassNotFoundException e) {
//                System.out.println("Not correct type for Id: " + taskId);
//            }
//        } catch (ParseException e) {
//            System.out.println("task was not found");
//        }
//        return null;
//    }
//
//    public Task returnTaskById(int taskId) {
//        return getTaskById(taskId);
//
//    }


//    public Scene getMainScene() {
//        mainScene = new GeneralScene(getHigherPanel());
//        this.setRoot(getStartParent());
//        return mainScene;
//    }

//    public void setRoot(Parent parent){
//        ((Pane) mainScene.getRoot()).getChildren().addAll( parent);
//    }
//
//    private Task getTaskParentViewById(int taskId) {
//        return taskController.returnTaskParentById(taskId);
//    }
//
//    private Parent getTaskNewTaskParent(){
//        return taskController.returnNewTaskParent();
//    }

//
//
//    private void registrationMouseClicked(EventHandler eventHandler, Parent component){
//        component.addEventHandler(MouseEvent.MOUSE_CLICKED ,eventHandler);
//    }
}
