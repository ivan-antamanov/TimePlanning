package timeplaner.gui.additional;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FontUtils {

    public static void setTopLinkFont(Text textLabel){
        textLabel.setFont(Font.font("Veranda",20));
        textLabel.setFill(Color.BLUE);
    }
}
