import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Theme {
    static File customBackTheme = new File("BackTheme");
    static File customForeTheme = new File("ForeTheme");
    static File darkTheme = new File("DarkTheme");
    static File normalTheme = new File("NormalTheme");

    public void Dark(GuiDesign menuShortcut) {
        new ThemeSet().ThemeMenu(Color.BLACK, Color.WHITE, menuShortcut.lineNumberArea,menuShortcut.interFace, Color.BLACK, Color.WHITE,
                menuShortcut.menuBar, menuShortcut.File, menuShortcut.New,menuShortcut.Reset,
                menuShortcut.Exit, menuShortcut.Open, menuShortcut.Save, menuShortcut.SaveAs, menuShortcut.Edit,
                menuShortcut.Font, menuShortcut.Redo, menuShortcut.Undo, menuShortcut.Size, menuShortcut.Color,
                menuShortcut.Fonts, menuShortcut.Area, menuShortcut.DarkTheme, menuShortcut.Normal,
                menuShortcut.Bold, menuShortcut.Italic, menuShortcut.Help, menuShortcut.About, menuShortcut.help,
                menuShortcut.Autosave, menuShortcut.ON, menuShortcut.OFF);

        if (customForeTheme.exists()) {
            customForeTheme.delete();
        }
        if (customBackTheme.exists()){
            customBackTheme.delete();
        }
        if (normalTheme.exists()) {
            normalTheme.delete();
        }
        if (!darkTheme.exists()) {
            try {
                darkTheme.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void Normal(GuiDesign menuShortcut) {
        new ThemeSet().ThemeMenu(Color.WHITE, Color.BLACK, menuShortcut.lineNumberArea,menuShortcut.interFace, Color.WHITE, Color.BLACK, menuShortcut.menuBar,
                menuShortcut.File, menuShortcut.New, menuShortcut.Reset,menuShortcut.Exit,
                menuShortcut.Open, menuShortcut.Save, menuShortcut.SaveAs, menuShortcut.Edit,
                menuShortcut.Font, menuShortcut.Redo, menuShortcut.Undo, menuShortcut.Size, menuShortcut.Color,
                menuShortcut.Fonts, menuShortcut.Area, menuShortcut.DarkTheme, menuShortcut.Normal,
                menuShortcut.Bold, menuShortcut.Italic, menuShortcut.Help, menuShortcut.About, menuShortcut.help,
                menuShortcut.Autosave, menuShortcut.ON, menuShortcut.OFF);

        if (customForeTheme.exists()){
            customForeTheme.delete();
        }
        if (customBackTheme.exists()) {
            customBackTheme.delete();
        }
        if (darkTheme.exists()) {
            darkTheme.delete();
        }
        if (!normalTheme.exists()) {
            try {
                normalTheme.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class GuiTheme {

        public void DefaultDark(LineNumberArea linenumberarea,TextAreaMod interFace,
                                JMenuBar menuBar, JMenu File, JMenuItem New, JMenuItem Reset,JMenuItem Exit,
                                JMenuItem Open, JMenuItem Save, JMenuItem SaveAs, JMenu Edit, JMenuItem Font,
                                JMenuItem Redo, JMenuItem Undo, JMenuItem Size, JMenu Color1,
                                JMenuItem Fonts, JMenuItem Area, JMenuItem DarkTheme,
                                JMenuItem Normal, JMenu Bold, JMenu Italic, JMenu Help, JMenuItem About, JMenuItem help,
                                JMenu Autosave, JMenuItem ON, JMenuItem OFF) {
            new ThemeSet().ThemeMenu(Color.BLACK, Color.WHITE, linenumberarea,interFace, Color.BLACK, Color.WHITE, menuBar, File, New, Reset,Exit, Open, Save, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color1, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
        }

        public void DefaultNormal(LineNumberArea linenumberarea,TextAreaMod interFace,
                                  JMenuBar menuBar, JMenu File, JMenuItem New, JMenuItem Reset,JMenuItem Exit,
                                  JMenuItem Open, JMenuItem Save, JMenuItem SaveAs, JMenu Edit, JMenuItem Font,
                                  JMenuItem Redo, JMenuItem Undo, JMenuItem Size, JMenu Color1,
                                  JMenuItem Fonts, JMenuItem Area, JMenuItem DarkTheme,
                                  JMenuItem Normal, JMenu Bold, JMenu Italic, JMenu Help, JMenuItem About, JMenuItem help,
                                  JMenu Autosave, JMenuItem ON, JMenuItem OFF) {
            new ThemeSet().ThemeMenu(Color.WHITE, Color.BLACK, linenumberarea,interFace, Color.WHITE, Color.BLACK, menuBar, File, Reset,New, Exit, Open, Save, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color1, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
        }

        public void CustomUserTheme(LineNumberArea linenumberarea,TextAreaMod interFace,
                                    JMenuBar menuBar, JMenu File, JMenuItem New, JMenuItem Reset,JMenuItem Exit,
                                    JMenuItem Open, JMenuItem Save, JMenu Autosave, JMenuItem ON, JMenuItem OFF, JMenuItem SaveAs, JMenu Edit, JMenuItem Font,
                                    JMenuItem Redo, JMenuItem Undo, JMenuItem Size, JMenu Color1,
                                    JMenuItem Fonts, JMenuItem Area, JMenuItem DarkTheme,
                                    JMenuItem Normal, JMenu Bold, JMenu Italic, JMenu Help, JMenuItem About, JMenuItem help
        ) {

            if (customForeTheme.exists()&&!customBackTheme.exists()) {
                try {
                    FileReader filefg = new FileReader(customForeTheme);
                    BufferedReader readerfg = new BufferedReader(filefg);
                    try {
                        String line = readerfg.readLine();
                        Color colorfg = Color.decode(line);
                        new ThemeSet().ThemeMenu(Color.BLACK, Color.WHITE,linenumberarea ,interFace, interFace.jTextArea.getBackground(), colorfg, menuBar,
                                File, New, Reset,Exit, Open, Save, SaveAs, Edit,
                                Font, Redo, Undo, Size, Color1, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);

                    } catch (Exception e) {
                        System.out.println("not done");
                    }
                    readerfg.close();
                } catch (Exception e) {
                    System.out.println("not done");
                }
                if (darkTheme.exists()) {
                    darkTheme.delete();
                }
                if (normalTheme.exists()) {
                    normalTheme.delete();
                }
            }
            else if (customBackTheme.exists()&&!customForeTheme.exists()) {
                try {
                    FileReader filebg = new FileReader(customBackTheme);
                    BufferedReader readerbg = new BufferedReader(filebg);
                    try {
                        String linebg = readerbg.readLine();
                        Color colorbg = Color.decode(linebg);
                        new ThemeSet().ThemeMenu(Color.BLACK, Color.WHITE, linenumberarea,interFace, colorbg, interFace.jTextArea.getForeground(), menuBar,
                                File, New, Reset,Exit, Open, Save, SaveAs, Edit,
                                Font, Redo, Undo, Size, Color1, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    readerbg.close();
                }catch (Exception e){
                    System.out.println("Error");
                }
                if (darkTheme.exists()) {
                    darkTheme.delete();
                }
                if (normalTheme.exists()) {
                    normalTheme.delete();
                }
            }
             else if (customBackTheme.exists()&&customBackTheme.exists()) {
                try {
                    FileReader filebg = new FileReader(customBackTheme);
                    FileReader filefg = new FileReader(customForeTheme);
                    BufferedReader readerbg = new BufferedReader(filebg);
                    BufferedReader readerfg = new BufferedReader(filefg);
                    try {
                        String linebg = readerbg.readLine();
                        Color colorbg = Color.decode(linebg);
                        String linefg = readerfg.readLine();
                        Color colorfg = Color.decode(linefg);
                        new ThemeSet().ThemeMenu(Color.BLACK, Color.WHITE, linenumberarea,interFace, colorbg, colorfg, menuBar,
                                File, New, Reset, Exit, Open, Save, SaveAs, Edit,
                                Font, Redo, Undo, Size, Color1, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
                    } catch (Exception e) {
                        System.out.println("not donw");;
                    }
                    readerbg.close();
                    readerfg.close();
                } catch (Exception e) {
                    System.out.println("Error");
                }
                if (darkTheme.exists()) {
                    darkTheme.delete();
                }
                if (normalTheme.exists()) {
                    normalTheme.delete();
                }
            } else {
                DefaultNormal(linenumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, SaveAs, Edit,
                        Font, Redo, Undo, Size, Color1, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
                if (darkTheme.exists()) {
                    darkTheme.delete();
                }
                if (normalTheme.exists()) {
                    normalTheme.delete();
                }
            }
        }
    }

    public void activeCustomBackground(GuiDesign menuShortcut) {
        Color color = new JColorChooser().showDialog(new MainWindow(), "choose Background", menuShortcut.interFace.jTextArea.getBackground());
        menuShortcut.interFace.jTextArea.setBackground(color);
        if (darkTheme.exists()) {
            darkTheme.delete();
            normalTheme.delete();
        } else if (normalTheme.exists()) {
            darkTheme.delete();
            normalTheme.delete();
        }
        if (!customBackTheme.exists()) {
            try {
                customBackTheme.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (customBackTheme.exists()) {
            try {
                FileWriter Writer = new FileWriter(customBackTheme);
                Writer.write(String.valueOf(color.getRGB()));
                Writer.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void activeCustomForeground(GuiDesign menuShortcut) {
        Color color = JColorChooser.showDialog(new MainWindow(), "choose Font Color", menuShortcut.interFace.jTextArea.getForeground());
        menuShortcut.interFace.jTextArea.setForeground(color);
        menuShortcut.interFace.jTextArea.setCaretColor(color);
        if (darkTheme.exists()) {
            darkTheme.delete();
            normalTheme.delete();
        } else if (normalTheme.exists()) {
            darkTheme.delete();
            normalTheme.delete();
        }
        if (!customForeTheme.exists()) {
            try {
                customForeTheme.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (customForeTheme.exists()) {
            try {
                FileWriter Writer = new FileWriter(customForeTheme);
                Writer.write(String.valueOf(color.getRGB()));
                Writer.close();
            } catch (Exception e) {
                System.out.println("cant");
            }
        }
    }

    public void SetTheme(LineNumberArea lineNumberarea,TextAreaMod interFace,
                         JMenuBar menuBar, JMenu File, JMenuItem New, JMenuItem Reset,JMenuItem Exit,
                         JMenuItem Open, JMenuItem Save, JMenuItem SaveAs, JMenu Edit, JMenuItem Font,
                         JMenuItem Redo, JMenuItem Undo, JMenuItem Size, JMenu Color,
                         JMenuItem Fonts, JMenuItem Area, JMenuItem DarkTheme,
                         JMenuItem Normal, JMenu Bold, JMenu Italic, JMenu Help, JMenuItem About, JMenuItem help,
                         JMenu Autosave, JMenuItem ON, JMenuItem OFF) {
        if (darkTheme.exists()) {
            new GuiTheme().DefaultDark(lineNumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
        } else if (normalTheme.exists()) {
            new GuiTheme().DefaultNormal(lineNumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
        } else if (customBackTheme.exists()) {
            new GuiTheme().CustomUserTheme(lineNumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, Autosave, ON, OFF, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help);
        } else if (customForeTheme.exists()) {
            new GuiTheme().CustomUserTheme(lineNumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, Autosave, ON, OFF, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help);
        } else if (customForeTheme.exists() && customBackTheme.exists()) {
            new GuiTheme().CustomUserTheme(lineNumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, Autosave, ON, OFF, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help);
        } else {
            new GuiTheme().DefaultNormal(lineNumberarea,interFace, menuBar, File, New, Reset, Exit, Open, Save, SaveAs, Edit,
                    Font, Redo, Undo, Size, Color, Fonts, Area, DarkTheme, Normal, Bold, Italic, Help, About, help, Autosave, ON, OFF);
        }
    }

    public static class AutosaveTheme {

        public void HighlightOn(GuiDesign menushortcut) {
            if (normalTheme.exists()) {
                menushortcut.OFF.setBackground(Color.WHITE);
                menushortcut.OFF.setForeground(Color.BLACK);
                menushortcut.ON.setBackground(Color.RED);
                menushortcut.ON.setForeground(Color.BLACK);
            }
            if (customBackTheme.exists() || customForeTheme.exists() || darkTheme.exists()) {
                menushortcut.OFF.setBackground(Color.BLACK);
                menushortcut.OFF.setForeground(Color.WHITE);
                menushortcut.ON.setBackground(Color.RED);
                menushortcut.ON.setForeground(Color.BLACK);
            } else {
                menushortcut.OFF.setBackground(Color.WHITE);
                menushortcut.OFF.setForeground(Color.BLACK);
                menushortcut.ON.setBackground(Color.RED);
                menushortcut.ON.setForeground(Color.BLACK);
            }
        }

        public void HighlightOFF(GuiDesign menushortcut) {
            if (normalTheme.exists()) {
                menushortcut.ON.setBackground(Color.WHITE);
                menushortcut.ON.setForeground(Color.BLACK);
                menushortcut.OFF.setBackground(Color.RED);
                menushortcut.OFF.setForeground(Color.BLACK);
            }
            if (customBackTheme.exists() | customForeTheme.exists() | darkTheme.exists()) {
                menushortcut.ON.setBackground(Color.BLACK);
                menushortcut.ON.setForeground(Color.WHITE);
                menushortcut.OFF.setBackground(Color.RED);
                menushortcut.OFF.setForeground(Color.BLACK);
            } else {
                menushortcut.ON.setBackground(Color.WHITE);
                menushortcut.ON.setForeground(Color.BLACK);
                menushortcut.OFF.setBackground(Color.RED);
                menushortcut.OFF.setForeground(Color.BLACK);
            }
        }
    }

    public void ThemeMarginal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("theming not done");
        }
    }
}
