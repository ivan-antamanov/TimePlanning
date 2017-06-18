package timeplaner.bo;


import timeplaner.dao.LocalSession;
import timeplaner.entities.subdocuments.impl.Task;

import java.io.IOException;
import java.text.ParseException;


public class TaskController {


    private LocalSession localSession;

    public TaskController(LocalSession localSession) {
        this.localSession = localSession;
    }

    private Task getTaskById(Long taskId) {
        try {
            try {
                return localSession.findTaskById(taskId);
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

    public Task returnTaskById(Long taskId) {
        return getTaskById(taskId);

    }

    public void saveTask(Task task) throws IOException {

        System.out.println("Try to save task with Id:" + task.getId());
        localSession.saveTask(task);

    }

}
