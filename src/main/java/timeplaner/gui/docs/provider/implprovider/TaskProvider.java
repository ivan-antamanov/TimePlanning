package timeplaner.gui.docs.provider.implprovider;

import javafx.scene.Parent;
import timeplaner.bo.impl.TaskController;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.subdocuments.impl.TaskDocument;
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


public class TaskProvider extends AbstractProvider<TaskController, TaskParent, TaskDocument> {

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
    public TaskParent updateNode(TaskDocument taskDocument) {
        return parent.updateDocParent(taskDocument);
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


    private ProjectEventHandler<SaveTaskEvent> saveTaskHandler = event -> {
        TaskDocument taskDocument =  parent.getDocument();
        logger.info("Try to save TaskDocument with Id: " + taskDocument.getId());
        controller.createDocument(taskDocument);
        parent.showSuccessDialog();
    };

    ProjectEventHandler<LoadDocumentEvent> loadTaskHandler = event -> {
        logger.info("Button \"Load TaskDocument\" was pressed"); //fixme
        TaskDocument taskDocument = controller.getDocument((TaskDocument) event.getDocument()); //fixme: too long +addd validation for null and NumberFormatException
        updateTaskNode(taskDocument);
        EventProcessor.send(new ChangeChildrenVisibilityEvent(parent.getClass(), SceneFactory.INSTANCE.get()));
    };

    private ProjectEventHandler<CreateTaskEvent> createTaskEventHandler = event -> {
        logger.info("Button \"Create new TaskDocument\" was pressed");
        newNode(); //fixme: too long +addd validation for null and NumberFormatException
        EventProcessor.send(new ChangeChildrenVisibilityEvent(parent.getClass(), SceneFactory.INSTANCE.get()));
    };

    private ProjectEventHandler<ChangeChildrenVisibilityEvent> goBackEventHandler = event -> {
        logger.info("Button GoBack was pressed");
        EventProcessor.send(new ChangeChildrenVisibilityEvent(PlanParent.class, SceneFactory.INSTANCE.get()));
    };

    private Parent updateTaskNode(TaskDocument taskDocument) {
        return parent.updateDocParent(taskDocument);
    }


}
