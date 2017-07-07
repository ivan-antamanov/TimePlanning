package timeplaner.gui.utils;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.apache.commons.lang.StringUtils;
import timeplaner.core.entities.StubDocument;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static timeplaner.gui.utils.LabelFields.RIGHT_SLASH;

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

    private static  <S extends StubDocument> List<Hyperlink> getHyperLinkTop(S document) {
        Predicate<String> isBlank = StringUtils::isBlank;
        Hyperlink mainProjectHypLink = new Hyperlink();
        Hyperlink taskNameHypLink = new Hyperlink();
        if (Objects.isNull(document.getMainDocument()) || isBlank.test(document.getMainDocument().getName())) {
            mainProjectHypLink.setText("No Main PlanDocument");
        } else {
            mainProjectHypLink.setText(document.getMainDocument().getName());
        }

        if (isBlank.test(document.getName())) {
            taskNameHypLink.setText("No TaskDocument Name");
        } else {
            taskNameHypLink.setText(document.getName());
        }

        return Arrays.asList(mainProjectHypLink, taskNameHypLink);
    }


    public static  <S extends StubDocument> Pane getTopPane(S document , Button backButton) { //todo rebuild
        List<Hyperlink> hyperLinkTop = getHyperLinkTop(document);
        FlowPane topPane = (FlowPane) returnHyperLinkTopPane();
        topPane.getChildren().addAll(backButton, hyperLinkTop.get(0), RIGHT_SLASH.getTextLabel(), hyperLinkTop.get(1));
        return topPane;
    }

    private static Pane returnHyperLinkTopPane() {
        FlowPane topPane = new FlowPane();
        topPane.setOrientation(Orientation.HORIZONTAL);
        return topPane;
    }
}
