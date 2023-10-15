import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SubWindow extends JFrame {
    position pos = new position();
    SubWindow(){
        SubWindow window;
        window = this;
        this.setSize(400,300);
        this.setVisible(true);
        this.setLocation(pos.x,pos.y);
        /*
        System.out.println(pos.x);
        System.out.println(pos.y);

         */
        this.setResizable(false);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                window.dispose();
                //JOptionPane.showMessageDialog(window,"Closing");
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
    }
}
