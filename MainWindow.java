//import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Random;

public class MainWindow extends  JFrame {
    Random random = new Random();
    int x =random.nextInt(200,500);
    int y =random.nextInt(100,101);

    MainWindow() {
        this.setTitle("*TextEditor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        this.setLocation(x, y);
    }
}