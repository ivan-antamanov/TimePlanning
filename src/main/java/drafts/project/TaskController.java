package drafts.project;


import entities.documents.subdocuments.AbstractAction;
import entities.documents.subdocuments.impl.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


public class TaskController {

    private Scene taskScene;
    private AbstractAction action;
    private SaveLoader saveLoader = new SaveLoader();
    private TaskLayoutController taskLayoutController;
    //todo AbstractTaskController


    private Task getTaskViewById(int taskId) {
        try {
            try {
                return saveLoader.findTaskById(taskId);
            } catch (IOException e) {
                System.out.println("Task with Id: " + taskId + " was not found");
            } catch (ClassNotFoundException e) {
                System.out.println("Not correct type for Id: " + taskId);
            }
        } catch (ParseException e) {
            System.out.println("task was not found");
        }
        return null;
    }

    public Parent returnTaskParentById(int taskId) {
        Task task = getTaskViewById(taskId);
        taskLayoutController = new TaskLayoutController(task);
        return taskLayoutController.returnTaskParent(task);
    }

    public Parent returnNewTaskParent(){
        Date date = new Date();
        long id = date.getTime();

        taskLayoutController = new TaskLayoutController();
        return taskLayoutController.returnNewTaskParent();
    }

    public void saveTask(Task task){
        try {
            System.out.println("Try to save task with Id:" +task.getId());
            saveLoader.saveTask(task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //        private AnchorPane addAnchorPane(Pane pane){
//        AnchorPane anchorPane = new AnchorPane();
//        anchorPane.getChildren().add(pane);
//        return anchorPane;
//    }


}
