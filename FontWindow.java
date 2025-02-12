import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontWindow extends SubWindow{
    SubWindow window = this;
    JScrollPane scrollPane = new JScrollPane();
    JList list;
    FontWindow(GuiDesign menuShortcut){
        String fonts[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        list = new JList(fonts);
        scrollPane.add(list);
        scrollPane.setViewportView(list);
        this.setSize(200,300);
        this.setLayout(new GridLayout());
        this.setTitle("Fonts");
        this.add(scrollPane);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public  void windowOpened(WindowEvent e){
                menuShortcut.Font.setEnabled(false);
            }
            @Override
            public void windowClosing(WindowEvent e) {
                menuShortcut.Font.setEnabled(true);
                window.dispose();
            }
        });
    }

}

