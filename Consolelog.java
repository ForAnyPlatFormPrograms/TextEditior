import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class Consolelog {
    SubWindow frame = new SubWindow();
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane();
    public void ShowLog(String input){
        frame.setLayout(new GridLayout());
        frame.setTitle("Log Window");
        new WorkingFunctions.LogWriting().ConsoleLogReader(textArea);
        textArea.update(textArea.getGraphics());
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scrollPane.getViewport().add(textArea);
        frame.add(scrollPane);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
