package timeplaner.gui.utils;


import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Map;

public class ParentUtils {

    public static GridPane getInfoPane(Map<Text, Control> textControlMap, Map<Text, Text> textConstantMap) { //todo rebuild && Another Class
        GridPane leftPane = customizeInfoPane();
        int firstColumn = 0;
        int secondColumn = 1;
        for (Map.Entry<Text, Control> entry : textControlMap.entrySet()) {
            Text label = entry.getKey();
            Control control = entry.getValue();
            control.setMaxWidth(Double.MAX_VALUE);
            leftPane.addColumn(firstColumn, label);
            leftPane.addColumn(secondColumn, control);
        }

        for (Map.Entry<Text, Text> entry : textConstantMap.entrySet()) {
            Text label = entry.getKey();
            Text labelValue = entry.getValue();
            leftPane.addColumn(firstColumn, label);
            leftPane.addColumn(secondColumn, labelValue);
        }

        return leftPane;
    }

    private static GridPane customizeInfoPane() {
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(5, 5, 5, 5));
        leftPane.setVgap(10);
        leftPane.setBorder(BorderUtils.getTaskBorder());
        leftPane.setMaxWidth(250);
        return leftPane;
    }



}
