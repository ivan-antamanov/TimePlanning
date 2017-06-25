package timeplaner.gui.docs.skeletons;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static timeplaner.gui.utils.LabelFields.TASK_LIST;

public abstract class AbstractMainDocSkeleton extends AbstractSkeleton implements PlanSkeleton {

    protected ListView<String> docList = new ListView<>();
    protected Button loadButton;
    protected Button createButton;
    protected Button deleteButton;

    @Override
    public Map<Text, Control> getTaskList(){
        Map<Text, Control> tasksInfoMap = new LinkedHashMap<>();
        tasksInfoMap.putIfAbsent(TASK_LIST.getTextLabel(), docList);
        docList.setMaxHeight(300);
        return tasksInfoMap;
    }

    @Override
    public void updateTaskList(List<String> projectsTask){
        docList.getItems().addAll(projectsTask);
    }

    @Override
    public List<Control> getButtonBottom() { //fixme there should be only buttons
        List<Control> controls = new ArrayList<>(0);
//        customizeCreateTaskButton(createButton);
//        customizeLoadButton(loadButton);
        controls.add(createButton);
        controls.add(loadButton);
        controls.add(deleteButton);
        return controls;
    }


}
