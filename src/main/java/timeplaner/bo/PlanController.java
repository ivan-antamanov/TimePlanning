package timeplaner.bo;


import timeplaner.dao.LocalSession;


public class PlanController {

//    private GeneralScene generalScene;
    private LocalSession localSession;

    public PlanController(LocalSession localSession) {
        this.localSession = localSession;
    }

//    private Task getTaskById(int taskId) {
//        try {
//            try {
//                return localSession.findTaskById(taskId);
//            } catch (IOException e) {
//                System.out.println("Task with Id: " + taskId + " was not found");
//            } catch (ClassNotFoundException e) {
//                System.out.println("Not correct type for Id: " + taskId);
//            }
//        } catch (ParseException e) {
//            System.out.println("task was not found");
//        }
//        return null;
//    }
//
//    public Task returnTaskById(int taskId) {
//        return getTaskById(taskId);
//
//    }

//    public LocalSession getLocalSession() {
//        return localSession;
//    }

//    public GeneralScene getGeneralScene() {
//        return generalScene;
//    }

//    public void setGeneralScene(GeneralScene generalScene) {
//        this.generalScene = generalScene;
//    }


//    public GeneralScene updateScene(Parent parent){
//        mainScene.setRoot(getHigherPanel());
//        this.setRoot(parent);
//        return mainScene;
//
//    }

//    private Task getTaskById(int taskId) {
//        try {
//            try {
//                return localSession.findTaskById(taskId);
//            } catch (IOException e) {
//                System.out.println("Task with Id: " + taskId + " was not found");
//            } catch (ClassNotFoundException e) {
//                System.out.println("Not correct type for Id: " + taskId);
//            }
//        } catch (ParseException e) {
//            System.out.println("task was not found");
//        }
//        return null;
//    }
//
//    public Task returnTaskById(int taskId) {
//        return getTaskById(taskId);
//
//    }


//    public Scene getMainScene() {
//        mainScene = new GeneralScene(getHigherPanel());
//        this.setRoot(getStartParent());
//        return mainScene;
//    }

//    public void setRoot(Parent parent){
//        ((Pane) mainScene.getRoot()).getChildren().addAll( parent);
//    }
//
//    private Task getTaskParentViewById(int taskId) {
//        return taskController.returnTaskParentById(taskId);
//    }
//
//    private Parent getTaskNewTaskParent(){
//        return taskController.returnNewTaskParent();
//    }

//
//
//    private void registrationMouseClicked(ProjectEventHandler eventHandler, Parent component){
//        component.addEventHandler(MouseEvent.MOUSE_CLICKED ,eventHandler);
//    }
}
