package timeplaner.gui.docs.provider.implprovider;

import javafx.scene.Scene;
import timeplaner.entities.Document;
import timeplaner.gui.docs.parents.AbstractSubDocParent;
import timeplaner.gui.docs.parents.impldoc.TaskParentImpl;
import timeplaner.gui.docs.provider.AbstractTaskProvider;
import timeplaner.gui.docs.skeletons.impl.TaskSkeletonImpl;
import timeplaner.gui.events.ProjectEventHandler;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadTaskEvent;
import timeplaner.gui.events.events.taskevents.SaveTaskEvent;
import timeplaner.bo.TaskController;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.dao.LocalSession;
import timeplaner.gui.events.handlers.SceneHandlersFactory;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


public class TaskProviderImpl extends AbstractTaskProvider {

    private Logger logger = Logger.getLogger(TaskProviderImpl.class.getName());


    private Scene generalScene;
    //    private TaskSkeletonImpl taskCascade = new TaskSkeletonImpl();
//    private TaskParentImpl taskParentImpl = new TaskParentImpl();
    private TaskController taskController;

    public TaskProviderImpl(LocalSession localSession, Scene generalScene) {
        taskParent = new TaskParentImpl(new TaskSkeletonImpl());
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
            Task task = (Task) taskParent.getDocument();
            logger.info("Try to save Task with Id: " + task.getId()); //todo as logger
            try {
                taskController.saveTask(task);
                taskParent.showSuccessDialog();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    ProjectEventHandler<LoadTaskEvent> loadTaskHandler = new ProjectEventHandler<LoadTaskEvent>() {
        @Override
        public void handle(LoadTaskEvent event) {
            logger.info("Button \"Load Task\" was pressed"); //fixme
            Task task = taskController.returnTaskById(event.getId()); //fixme: too long +addd validation for null and NumberFormatException
            updateTaskNode(task);
            EventProcessor.send(new ChangeChildrenVisibilityEvent(taskParent.getClass(), generalScene));
        }
    };

    private ProjectEventHandler<CreateTaskEvent> createTaskEventHandler = new ProjectEventHandler<CreateTaskEvent>() {
        @Override
        public void handle(CreateTaskEvent event) {
            logger.info("Button \"Create new Task\" was pressed");
            newTaskNode(); //fixme: too long +addd validation for null and NumberFormatException
            EventProcessor.send(new ChangeChildrenVisibilityEvent(taskParent.getClass(), generalScene));
        }
    };

    private AbstractSubDocParent updateTaskNode(Task task) {
        return taskParent.updateTaskParent(task);//fixme too long line

    }

    private AbstractSubDocParent newTaskNode() {
        return taskParent.getDocParent();//fixme too long line

    }

    public AbstractSubDocParent getParent() {
        return taskParent.getDocParent();
    }

    @Override
    protected void registrationEvents() {

    }

    @Override
    protected void showSuccessDialog() {

    }
}
