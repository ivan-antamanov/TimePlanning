package timeplaner.bo;


import timeplaner.dao.DocumentDao;
import timeplaner.dao.SessionFactory;
import timeplaner.dao.TODELETE.LocalSession;
import timeplaner.dao.TODELETE.TaskDao;
import timeplaner.dao.impl.TaskDaoImpl;
import timeplaner.entities.DocumentModel;
import timeplaner.entities.subdocuments.impl.Task;

import java.io.IOException;
import java.text.ParseException;


public class TaskController {

//    private SessionFactory localSession;
    private TaskDaoImpl taskDao;


    public TaskController(SessionFactory localSession) {
        this.taskDao = new TaskDaoImpl(localSession) ;
    }

    private Task getTaskById(Task task) {
        return taskDao.read(task);
    }

    public Task returnTaskById(Task task) {
        return getTaskById(task);

    }

    public void saveTask(Task task) {
//        System.out.println("Try to save task with Id:" + task.getId());
          taskDao.update(task);
    }

}
