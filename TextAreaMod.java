import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.awt.*;

public class TextAreaMod {
    JTextArea jTextArea = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane(jTextArea);
    MainWindow window = new MainWindow();
    TextAreaMod() {
        DefaultCaret caret = (DefaultCaret) jTextArea.getCaret();
        jTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEditable(true);
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
}
