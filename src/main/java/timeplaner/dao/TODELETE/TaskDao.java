package timeplaner.dao.TODELETE;


import timeplaner.entities.subdocuments.impl.Task;

public interface TaskDao {

    public Task createTask(Task task) throws Exception;

    public Task readTask(Long taskId) throws Exception;

    public void updateTask(Task task) throws Exception;

    public void deleteTask(Long taskId) throws Exception;

    public void getAllTask() throws Exception;
}
