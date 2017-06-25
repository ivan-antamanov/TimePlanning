package timeplaner.gui.docs.provider.implprovider;

import javafx.scene.Parent;
import javafx.scene.Scene;
import timeplaner.entities.Document;
import timeplaner.gui.SceneFactory;
import timeplaner.gui.docs.parents.PlanParent;
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
import java.util.logging.Logger;


public class TaskProviderImpl extends AbstractTaskProvider {

    private Logger logger = Logger.getLogger(TaskProviderImpl.class.getName());


//    private Scene generalScene;
    private TaskController taskController;

    public TaskProviderImpl(LocalSession localSession, Scene generalScene) {
        taskParent = new TaskParentImpl(new TaskSkeletonImpl());
        taskController = new TaskController(localSession);
        registrationEvents();
    }

    @Override
    public Parent newNode() {
        return taskParent.getDocParent();
    }

    @Override
    public Parent updateNode(Document document) {
        return taskParent.updateDocParent(document);
    }

    @Override
    public Parent getNode() {
        return taskParent.getDocParent();
    }

    @Override
    protected void registrationEvents() {
//        this.generalScene = generalScene; //todo delete frome here
        EventProcessor.register(SaveTaskEvent.class, saveTaskHandler);
        EventProcessor.register(LoadTaskEvent.class, loadTaskHandler);
        EventProcessor.register(CreateTaskEvent.class, createTaskEventHandler);
        EventProcessor.register(ChangeChildrenVisibilityEvent.class, SceneHandlersFactory.INSTANCE.get().getVisibilityHandler());
//        EventProcessor.register(ChangeChildrenVisibilityEvent.class, goBackEventHandler);
        }

    @Override
    protected void showSuccessDialog() {
        throw new UnsupportedOperationException("Operation showSuccessDialog not supported yet");
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
            EventProcessor.send(new ChangeChildrenVisibilityEvent(taskParent.getClass(), SceneFactory.INSTANCE.get()));
        }
    };

    private ProjectEventHandler<CreateTaskEvent> createTaskEventHandler = new ProjectEventHandler<CreateTaskEvent>() {
        @Override
        public void handle(CreateTaskEvent event) {
            logger.info("Button \"Create new Task\" was pressed");
            newNode(); //fixme: too long +addd validation for null and NumberFormatException
            EventProcessor.send(new ChangeChildrenVisibilityEvent(taskParent.getClass(), SceneFactory.INSTANCE.get()));
        }
    };

    private ProjectEventHandler<ChangeChildrenVisibilityEvent> goBackEventHandler = new ProjectEventHandler<ChangeChildrenVisibilityEvent>() {
        @Override
        public void handle(ChangeChildrenVisibilityEvent event) {
            logger.info("Button GoBack was pressed");
            EventProcessor.send(new ChangeChildrenVisibilityEvent(PlanParent.class, SceneFactory.INSTANCE.get()));
        }
    };

    private Parent updateTaskNode(Task task) {
        return taskParent.updateDocParent(task);
    }


}
