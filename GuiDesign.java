import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import java.awt.*;

public class GuiDesign{

    JTextArea jTextArea = new JTextArea();
    Document doc = jTextArea.getDocument();
    JScrollPane jScrollPane = new JScrollPane(jTextArea);
    MainWindow window = new MainWindow();
    GuiDesign() {
        window.setLayout(new GridLayout(0, 1));
        DefaultCaret caret = (DefaultCaret) jTextArea.getCaret();
        jTextArea.setFont(new Font("Serif", Font.PLAIN, 15));
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEditable(true);
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jScrollPane.add(jTextArea);
        jScrollPane.setViewportView(jTextArea);
    }
}
