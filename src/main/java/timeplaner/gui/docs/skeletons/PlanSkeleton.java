package timeplaner.gui.docs.skeletons;


import javafx.scene.control.Control;
import javafx.scene.text.Text;
import timeplaner.entities.subdocuments.impl.Task;

import java.util.List;
import java.util.Map;

public interface PlanSkeleton extends Skeleton {

    public void updateTaskList(List<String> projectsTask);
    public List<Control> getButtonBottom();
    public Map<Text, Control> getTaskList();

    public Map<Text, Text> getThisDocInfoConstantMap();
    public Map<Text, Control> getThisDocInfoMap();

    public Map<Text, Control> getChildDocInfoMap(Task task);

    public Map<Text, Text> getChildDocInfoConstantMap(Task task);

//    public AbstractPlan getDocument();
}
