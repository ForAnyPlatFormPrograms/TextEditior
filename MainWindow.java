import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow extends  JFrame {
    position pos = new position();

    //JFrame this = new JFrame();
    MainWindow() {
        MainWindow frame;
        frame = this;
        this.setTitle("*Untitled");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        this.setSize(800, 700);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocation(pos.x, pos.y);
        System.out.println(pos.x);
        System.out.println(pos.y);
    }
}
