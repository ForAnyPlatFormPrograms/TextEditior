import javax.swing.*;
import java.awt.*;

public class SizeWindow extends SubWindow{
    JList list ;
    JScrollPane scrollPane = new JScrollPane();
    JPanel panelScollpane = new JPanel();
    JPanel panelWriting = new JPanel();
    JTextField textField = new JTextField("Hello World");
    SizeWindow(){
        this.setTitle("size");
        this.setLayout(new FlowLayout());
        panelWriting.setLayout(new GridLayout());
        panelWriting.add(textField);
        panelScollpane.setLayout(new GridLayout());
        String sizes[]={"10","20","30","40","50","60","70","80","90","100"};
        list=new JList(sizes);
        scrollPane.add(list);
        scrollPane.setViewportView(list);
        panelScollpane.add(scrollPane);
        this.add(panelScollpane);
        this.add(panelWriting);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
}
