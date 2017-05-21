package gui.auxiliary;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class BorderUtils {

    public static Border getTaskBorder() {
        BorderStroke borderStroke = new BorderStroke(
                Color.AQUAMARINE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        return new Border(borderStroke);
    }
}
