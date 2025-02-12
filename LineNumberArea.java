import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class LineNumberArea extends JTextArea{
    LineNumberArea(JTextArea jTextArea){
        setFocusable(false);
        setText("1. ");
        setEditable(false);
        setForeground(jTextArea.getForeground());
        setBackground(Color.LIGHT_GRAY);
        setFont(new Font(jTextArea.getFont().getName(), jTextArea.getFont().getStyle(),jTextArea.getFont().getSize()));
    }
}
