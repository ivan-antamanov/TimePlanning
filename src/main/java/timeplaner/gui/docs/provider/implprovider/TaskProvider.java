package timeplaner.gui.docs.provider.implprovider;

import javafx.scene.Parent;
import timeplaner.bo.impl.TaskController;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.subdocuments.impl.Task;
import timeplaner.gui.SceneFactory;
import timeplaner.gui.docs.parents.impldoc.PlanParent;
import timeplaner.gui.docs.parents.impldoc.TaskParent;
import timeplaner.gui.docs.provider.AbstractProvider;
import timeplaner.gui.docs.skeletons.impl.TaskSkeleton;
import timeplaner.gui.events.EventProcessor;
import timeplaner.gui.events.ProjectEventHandler;
import timeplaner.gui.events.events.sceneevents.ChangeChildrenVisibilityEvent;
import timeplaner.gui.events.events.taskevents.CreateTaskEvent;
import timeplaner.gui.events.events.taskevents.LoadDocumentEvent;
import timeplaner.gui.events.events.taskevents.SaveTaskEvent;
import timeplaner.gui.events.handlers.SceneHandlersFactory;

import java.util.logging.Logger;


public class TaskProvider extends AbstractProvider<TaskController, TaskParent, Task> {

    private Logger logger = Logger.getLogger(TaskProvider.class.getName());

    public TaskProvider(SessionFactory localSession) {
        parent = new TaskParent(new TaskSkeleton());
        controller = new TaskController(localSession);
        registrationEvents();
    }

    @Override
    public TaskParent newNode() {
        return parent.getDocParent();
    }

    @Override
    public TaskParent updateNode(Task task) {
        return parent.updateDocParent(task);
    }

    @Override
    public TaskParent getNode() {
        return parent.getDocParent();
    }

    @Override
    protected void registrationEvents() {
//        this.generalScene = generalScene; //todo delete from here
        EventProcessor.register(SaveTaskEvent.class, saveTaskHandler);
        EventProcessor.register(LoadDocumentEvent.class, loadTaskHandler);
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
            Task task = (Task) parent.getDocument();
            logger.info("Try to save Task with Id: " + task.getId());
            controller.createDocument(task);
            parent.showSuccessDialog();
        }
    };

    ProjectEventHandler<LoadDocumentEvent> loadTaskHandler = new ProjectEventHandler<LoadDocumentEvent>() {
        @Override
        public void handle(LoadDocumentEvent event) {
            logger.info("Button \"Load Task\" was pressed"); //fixme
            Task task = controller.getDocument((Task) event.getDocument()); //fixme: too long +addd validation for null and NumberFormatException
            updateTaskNode(task);
            EventProcessor.send(new ChangeChildrenVisibilityEvent(parent.getClass(), SceneFactory.INSTANCE.get()));
        }
    };

    private ProjectEventHandler<CreateTaskEvent> createTaskEventHandler = new ProjectEventHandler<CreateTaskEvent>() {
        @Override
        public void handle(CreateTaskEvent event) {
            logger.info("Button \"Create new Task\" was pressed");
            newNode(); //fixme: too long +addd validation for null and NumberFormatException
            EventProcessor.send(new ChangeChildrenVisibilityEvent(parent.getClass(), SceneFactory.INSTANCE.get()));
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
        return parent.updateDocParent(task);
    }


}
