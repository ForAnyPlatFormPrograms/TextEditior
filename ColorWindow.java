import javax.swing.*;

public class ColorWindow extends SubWindow{
    JColorChooser colorChooser = new JColorChooser();
    ColorWindow(){
        this.add(colorChooser);
    }
}
