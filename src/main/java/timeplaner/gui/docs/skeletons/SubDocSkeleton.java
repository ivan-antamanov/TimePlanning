package timeplaner.gui.docs.skeletons;


import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import timeplaner.entities.subdocuments.AbstractAction;

import java.util.List;
import java.util.Map;

public interface SubDocSkeleton extends Skeleton {

    public List<Hyperlink> getHyperLinkTop();

    public Map<Text, Control> getLabelAndControlMapLeft();

    public Map<Text, Text> getConstantLabelsMap();

    public Map<Text, Control> getLabelAndControlMapCenter();

    public Map<Text, Control> getLabelAndControlMapBottom();

    public List<Button> getButtonsBottom();

    public Button customizeSaveButton(Button saveButton);

    public AbstractAction getDocument();
}
