import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTextArea label = new JTextArea();
        if (args.length!=0) {
            for (String val : args) {
                label.append(val+" ");
            }
            String filepath = label.getText();
            frame.setVisible(false);
            frame.add(label);
            frame.dispose();
            GuiDesign menu = new GuiDesign();
            new ActionAll().SubAction(menu);
            new ActionAll().MainAction(menu,"do", label.getText());
        }else{
            GuiDesign menu = new GuiDesign();
            new ActionAll().SubAction(menu);
            new ActionAll().MainAction(menu,"dont","dont write the file");
        }
    }
}