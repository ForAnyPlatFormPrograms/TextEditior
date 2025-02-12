import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThemeSet {
    public void ThemeMenu(Color background,Color foreground,LineNumberArea lineNumberarea,TextAreaMod interFace,Color back, Color fore,
                          JMenuBar menuBar, JMenu File, JMenuItem New, JMenuItem Reset,JMenuItem Exit,
                          JMenuItem Open, JMenuItem Save, JMenuItem SaveAs, JMenu Edit, JMenuItem Font,
                          JMenuItem Redo, JMenuItem Undo, JMenuItem Size, JMenu Color1,
                          JMenuItem Fonts, JMenuItem Area , JMenuItem DarkTheme,
                          JMenuItem Normal, JMenu Bold, JMenu Italic, JMenu Help, JMenuItem About, JMenuItem help,
                          JMenu Autosave,JMenuItem ON,JMenuItem OFF){
        UIManager.put("TabbedPane.selected", Color.GREEN);
        menuBar.setBackground(background);
        File.setOpaque(false);
        File.setBackground(background);
        File.setForeground(foreground);

        Edit.setOpaque(true);
        Edit.setBackground(background);
        Edit.setForeground(foreground);

        Help.setOpaque(true);
        Help.setBackground(background);
        Help.setForeground(foreground);

        Bold.setOpaque(true);
        Bold.setBackground(background);
        Bold.setForeground(foreground);

        Italic.setOpaque(true);
        Italic.setBackground(background);
        Italic.setForeground(foreground);

        New.setOpaque(true);
        New.setBackground(background);
        New.setForeground(foreground);

        Open.setOpaque(true);
        Open.setBackground(background);
        Open.setForeground(foreground);

        Reset.setOpaque(true);
        Reset.setBackground(background);
        Reset.setForeground(foreground);

        Save.setOpaque(true);
        Save.setBackground(background);
        Save.setForeground(foreground);

        SaveAs.setOpaque(true);
        SaveAs.setBackground(background);
        SaveAs.setForeground(foreground);

        Exit.setOpaque(true);
        Exit.setBackground(background);
        Exit.setForeground(foreground);

        Font.setOpaque(true);
        Font.setBackground(background);
        Font.setForeground(foreground);

        Color1.setOpaque(true);
        Color1.setBackground(background);
        Color1.setForeground(foreground);

        Fonts.setOpaque(true);
        Fonts.setBackground(background);
        Fonts.setForeground(foreground);

        Area.setOpaque(true);
        Area.setBackground(background);
        Area.setForeground(foreground);

        DarkTheme.setOpaque(true);
        DarkTheme.setBackground(background);
        DarkTheme.setForeground(foreground);

        Normal.setOpaque(true);
        Normal.setBackground(background);
        Normal.setForeground(foreground);

        Size.setOpaque(true);
        Size.setBackground(background);
        Size.setForeground(foreground);

        Undo.setOpaque(true);
        Undo.setBackground(background);
        Undo.setForeground(foreground);

        Redo.setOpaque(true);
        Redo.setBackground(background);
        Redo.setForeground(foreground);

        About.setOpaque(true);
        About.setBackground(background);
        About.setForeground(foreground);

        help.setOpaque(true);
        help.setBackground(background);
        help.setForeground(foreground);

        Autosave.setOpaque(true);
        Autosave.setBackground(background);
        Autosave.setForeground(foreground);

        ON.setOpaque(true);
        ON.setBackground(background);
        ON.setForeground(foreground);

        OFF.setOpaque(true);
        OFF.setBackground(background);
        OFF.setForeground(foreground);

        menuBar.setBorder(BorderFactory.createLineBorder(background));

        interFace.jTextArea.setBackground(back);
        interFace.jTextArea.setForeground(fore);
        interFace.jTextArea.setBorder(BorderFactory.createLineBorder(background));
        interFace.jTextArea.setCaretColor(fore);

        lineNumberarea.setBackground(back);
        lineNumberarea.setForeground(fore);
        interFace.jTextArea.setBorder(BorderFactory.createLineBorder(background));
    }
}
