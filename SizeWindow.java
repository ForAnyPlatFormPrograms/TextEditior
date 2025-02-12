import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SizeWindow extends SubWindow{
    SubWindow window = this;
    JList list ;
    JScrollPane scrollPane = new JScrollPane();
    JPanel panelScollpane = new JPanel();
    JTextField textField = new JTextField(4);
    SizeWindow(GuiDesign menuShortcut){
        window.setTitle("size");
        window.setLayout(new FlowLayout());
        textField.setBounds(0,0,50,50);
        String sizes[]={"10","20","30","40","50","60","70","80","90","100"};
        list=new JList(sizes);
        scrollPane.add(list);
        scrollPane.setViewportView(list);
        panelScollpane.add(scrollPane);
        window.add(panelScollpane);
        window.add(textField);
        window.setResizable(false);
        window.setVisible(true);
        window.pack();
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                menuShortcut.Size.setEnabled(false);
            }
            @Override
            public void windowClosing(WindowEvent e) {
                menuShortcut.Size.setEnabled(true);

            }
        });
    }

}
