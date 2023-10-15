import javax.swing.*;
import java.awt.*;

public class FontWindow extends SubWindow{
    JScrollPane scrollPane = new JScrollPane();
    JList list;
    FontWindow(){
        String fonts[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        list = new JList(fonts);
        scrollPane.add(list);
        scrollPane.setViewportView(list);
        this.setSize(200,300);
        this.setLayout(new GridLayout());
        this.setTitle("Fonts");
        this.add(scrollPane);
        this.setVisible(true);

    }
}
