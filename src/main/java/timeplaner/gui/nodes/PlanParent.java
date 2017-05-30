package timeplaner.gui.nodes;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import timeplaner.controller.PlanController;
import timeplaner.controller.TaskController;
import timeplaner.documents.subdocuments.impl.Task;
import timeplaner.gui.GeneralScene;
import timeplaner.gui.broker.PlanBroker;
import timeplaner.gui.broker.TaskBroker;
import timeplaner.gui.layouts.PlanLayout;
import timeplaner.gui.layouts.TaskLayout;
import timeplaner.plugin.LocalSession;

import java.util.List;
import java.util.stream.Collectors;

public class PlanParent extends Parent {

    PlanBroker planBroker = new PlanBroker();
    PlanLayout planLayout = new PlanLayout();
    PlanController planController;

    public PlanParent(LocalSession localSession) {
        planController = new PlanController(localSession);
        planBroker.setLoadTaskEvent(loadTaskEvent);
        planBroker.setCreateTaskEvent(createTaskEvent);

    }

    private EventHandler loadTaskEvent = new EventHandler() {
        public void handle(Event event) {
            System.out.println("Button \"Load Task\" was pressed"); //fixme

            Task task = planController.returnTaskById(Integer.parseInt(planBroker.getTaskIdText().getText())); //fixme: too long +addd validation for null and NumberFormatException
            List<Parent> parents = ((GeneralScene) ((Button) event.getSource()).getScene()).getParents();

            parents.stream()
                    .filter(parent -> parent.equals(this))
                    .forEach(parent -> parent.setVisible(false));
            List<Parent> taskParentInList = parents.stream()
                    .filter(parent -> parent instanceof TaskParent)
                    .collect(Collectors.toList());
            TaskParent taskParent = ((TaskParent) taskParentInList.get(0)).getTaskNode(task);
            taskParent.setVisible(true);

//            TaskBroker taskBroker = new TaskBroker(taskController);
//            TaskLayout taskLayout = new TaskLayout(taskBroker);
//            taskBroker.updateTaskNodes(task);
//            Parent parentTask = taskLayout.returnNewTaskParent();
//            updateScene(parentTask);
        }
    };

    private EventHandler createTaskEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            System.out.println("Button \"Create new Task\" was pressed");
//            Task task = planController.returnTaskById(Integer.parseInt(planBroker.getTaskIdText().getText())); //fixme: too long +addd validation for null and NumberFormatException
            List<Parent> parents = ((GeneralScene) ((Button) event.getSource()).getScene()).getParents();

            parents.stream()
                    .filter(parent -> parent.equals(this))
                    .forEach(parent -> parent.setVisible(false));
            List<Parent> taskParentInList = parents.stream()
                    .filter(parent -> parent instanceof TaskParent)
                    .collect(Collectors.toList());
            TaskParent taskParent = ((TaskParent) taskParentInList.get(0)).getTaskNode();
            taskParent.setVisible(true);
        }
    };

    public Parent getPlanParent(){
        return planLayout.returnButtonPlanParent(planBroker.getControlBottom());
    }
}
