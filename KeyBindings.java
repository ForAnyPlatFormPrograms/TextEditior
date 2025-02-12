import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class KeyBindings {

    public void keys(GuiDesign menuShortcut, Action Undo, Action Redo ,Action log){
        menuShortcut.New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuShortcut.Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));
        menuShortcut.Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menuShortcut.Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        menuShortcut.SaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
        menuShortcut.Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        menuShortcut.Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        menuShortcut.log.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        menuShortcut.interFace.jTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK),"undo");
        menuShortcut.interFace.jTextArea.getActionMap().put("undo", Undo);
        menuShortcut.interFace.jTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK),"redo");
        menuShortcut.interFace.jTextArea.getActionMap().put("redo",Redo);
        menuShortcut.interFace.jTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK),"log");
        menuShortcut.interFace.jTextArea.getActionMap().put("log",log);
        menuShortcut.Font.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
        menuShortcut.Size.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
        menuShortcut.Normal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
        menuShortcut.DarkTheme.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
    }
}
