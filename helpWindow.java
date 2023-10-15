import javax.swing.*;
import java.awt.*;

public class helpWindow {
    SubWindow window = new SubWindow();
    JTextArea textArea = new JTextArea();
    helpWindow(){
        window.setLocationRelativeTo(null);
        window.setTitle("About");
        window.setLayout(new GridLayout());
        textArea.setText("IntelliJ IDEA 2022.2.2" +
                "IntelliJ IDEA 2022.2.2 (Edu)\n" +
                "Build #IE-222.4345.35, built on October 26, 2022\n" +
                "Runtime version: 17.0.4.1+7-b469.62 amd64\n" +
                "VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.\n" +
                "Linux 6.5.0-1-amd64\n" +
                "GC: G1 Young Generation, G1 Old Generation\n" +
                "Memory: 982M\n" +
                "Cores: 2\n" +
                "\n" +
                "Kotlin: 222-1.7.10-release-334-IJ4345.35\n" +
                "Current Desktop: GNOME");
        textArea.setEditable(false);
        window.add(textArea);
        window.setVisible(true);
    }
}
