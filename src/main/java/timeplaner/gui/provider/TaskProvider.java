package timeplaner.gui.provider;

import javafx.scene.Scene;
import timeplaner.gui.docparents.impl.TaskParent;
import timeplaner.gui.events.ProjectEventHandler;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadTaskEvent;
import timeplaner.gui.events.events.taskevents.SaveTaskEvent;
import timeplaner.controller.TaskController;
import timeplaner.documents.subdocuments.impl.Task;
import timeplaner.gui.broker.TaskBroker;
import timeplaner.dao.LocalSession;
import timeplaner.gui.events.handlers.SceneHandlersFactory;


public class TaskProvider {

    private Scene generalScene;
    private TaskBroker taskBroker = new TaskBroker();
    private TaskParent taskParent = new TaskParent();
    private TaskController taskController;


    public TaskProvider(LocalSession localSession, Scene generalScene) {
        taskController = new TaskController(localSession);
        this.generalScene = generalScene;
        EventProcessor.register(SaveTaskEvent.class, saveTaskHandler);
        EventProcessor.register(LoadTaskEvent.class, loadTaskHandler);
        EventProcessor.register(CreateTaskEvent.class, createTaskEventHandler);
        EventProcessor.register(ChangeChildrenVisibilityEvent.class, SceneHandlersFactory.INSTANCE.get().getVisibilityHandler());
    }


    private ProjectEventHandler<SaveTaskEvent> saveTaskHandler = new ProjectEventHandler<SaveTaskEvent>() {
        @Override
        public void handle(SaveTaskEvent event) {
            Task task = taskBroker.getTaskFromNode();
            System.out.println("Try to save Task with Id: " + task.getId()); //todo as logger
            taskController = new TaskController(new LocalSession());//fixme
            taskController.saveTask(task);
            taskBroker.showSuccessDialog();
        }
    };

    ProjectEventHandler<LoadTaskEvent> loadTaskHandler = new ProjectEventHandler<LoadTaskEvent>() {
        @Override
        public void handle(LoadTaskEvent event) {
            System.out.println("Button \"Load Task\" was pressed"); //fixme

            Task task = taskController.returnTaskById(event.getId()); //fixme: too long +addd validation for null and NumberFormatException
            updateTaskNode(task);
            EventProcessor.send(new ChangeChildrenVisibilityEvent(this.getClass(), generalScene));
        }
    };

    private ProjectEventHandler<CreateTaskEvent> createTaskEventHandler = new ProjectEventHandler<CreateTaskEvent>() {
        @Override
        public void handle(CreateTaskEvent event) {
            System.out.println("Button \"Create new Task\" was pressed");
            newTaskNode(); //fixme: too long +addd validation for null and NumberFormatException
            EventProcessor.send(new ChangeChildrenVisibilityEvent(this.getClass(), generalScene));


        }
    };

    private TaskParent updateTaskNode(Task task) {
       return taskParent.getTaskParent(taskBroker.updateTaskView(task));//fixme too long line

    }

    private TaskParent newTaskNode() {
        return taskParent.getTaskParent(taskBroker.newTaskView());//fixme too long line

    }

    public TaskParent getParent() {
        return taskParent.getTaskParent(taskBroker);
    }
}
