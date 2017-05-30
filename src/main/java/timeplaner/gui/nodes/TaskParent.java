package timeplaner.gui.nodes;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import timeplaner.controller.TaskController;
import timeplaner.documents.subdocuments.impl.Task;
import timeplaner.gui.broker.TaskBroker;
import timeplaner.gui.layouts.TaskLayout;
import timeplaner.plugin.LocalSession;


public class TaskParent extends Parent {

    private TaskBroker taskBroker = new TaskBroker();
    private TaskLayout taskLayout = new TaskLayout();
    private TaskController taskController;


    private EventHandler saveEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            Task task = taskBroker.getTaskFromNode();
            System.out.println("Try to save Task with Id: " + task.getId()); //todo as logger
            taskController = new TaskController(new LocalSession());
            taskController.saveTask(task);
            taskBroker.showSuccessDialog();
        }
    };



    public TaskParent(LocalSession localSession) {
        taskController = new TaskController(localSession);
        taskBroker.addSaveEvent(saveEvent);

    }

    public TaskParent getTaskNode(Task task){
        this.getChildren().addAll(taskLayout.getTaskPane(taskBroker.updateTaskView(task)));//fixme too long line
        return this;
    }

    public TaskParent getTaskNode(){
        this.getChildren().addAll(taskLayout.getTaskPane(taskBroker.newTaskView()));//fixme too long line
        return this;
    }


    private void setChildren(){
        this.getChildren().addAll(taskLayout.getTaskPane(taskBroker));

    }



//    public List<Button> getButtonsBottom() {
//        List<Button> buttons = new ArrayList<>(0);
//        customizeSaveButton(saveButton);
//        buttons.add(saveButton);
//        return buttons;
//    }
//
//    private Button customizeSaveButton(Button saveButton) {
//        saveButton.setAlignment(Pos.TOP_CENTER);
//        saveButton.addEventFilter(MouseEvent.MOUSE_CLICKED, saveEvent);
//        return saveButton;
//    }

}
