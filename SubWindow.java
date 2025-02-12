import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class SubWindow extends JDialog {
    JDialog dialog = this;
    Random random = new Random();
    int x =random.nextInt(200,500);
    int y =random.nextInt(100,101);
    SubWindow(){
        new Theme().ThemeMarginal();
        SubWindow window;
        window = this;
        this.setLayout(null);
        this.setVisible(true);
        this.setLocation(x,y);
        this.setResizable(false);
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        dialog.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        dialog.setAlwaysOnTop(true);
        new Theme().ThemeMarginal();
    }
}
