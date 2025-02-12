import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ActionAll {
    static File customBackTheme = new File("CustomBackTheme");
    static File customForeTheme = new File("CustomForeTheme");
    static File darkTheme = new File("DarkTheme");
    static File normalTheme = new File("NormalTheme");
    public void MainAction(GuiDesign menuShortcut,String input,String filepath){
        menuShortcut.New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuShortcut.interFace.window.dispose();
                Main.main(new String[]{});
            }
        });

        menuShortcut.Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions.SaveFunction().Reset(menuShortcut);
            }
        });

        menuShortcut.menuBar.addAncestorListener(new AncestorListener() {

            @Override
            public void ancestorAdded(AncestorEvent event) {

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                menuShortcut.Redo.setVisible(false);
                menuShortcut.Undo.setVisible(false);
                menuShortcut.log.setVisible(false);
            }
        });

        menuShortcut.Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions.SaveFunction().Exit(menuShortcut.interFace);
            }
        });

        menuShortcut.Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions.SaveFunction().Save(menuShortcut.interFace);
            }
        });

        menuShortcut.SaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions.SaveFunction().saveas(menuShortcut.interFace);
            }
        });

        menuShortcut.Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions.Autosave().DisableAutosave();
                new WorkingFunctions.SaveFunction().open(menuShortcut.interFace);
            }
        });


        menuShortcut.About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutWindow();
            }
        });

        menuShortcut.File.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){
                    File autosave = new File("autosave");
                    if(autosave.exists()){
                        menuShortcut.ON.setEnabled(false);
                        menuShortcut.ON.setForeground(java.awt.Color.BLACK);
                        menuShortcut.ON.setBackground(java.awt.Color.RED);
                    }
                }
            }
        });

        menuShortcut.ON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions.LogWriting().LogWriter("autosave entering 1 state");
                if(!new File("autosave").exists()){
                    new WorkingFunctions.LogWriting().LogWriter("error creation "+new File("autosave").getName()+" file");
                    new WorkingFunctions.LogWriting().LogWriter("autosave return to 0 state");
                }
                menuShortcut.ON.setEnabled(false);
                menuShortcut.OFF.setEnabled(true);
                new Theme.AutosaveTheme().HighlightOn(menuShortcut);
                new WorkingFunctions.Autosave().autosave(menuShortcut.interFace, "on");
            }
        });

        menuShortcut.OFF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File autosave = new File("autosave");
                if(autosave.exists()){
                    autosave.delete();
                    new WorkingFunctions.LogWriting().LogWriter("autosave return to 0 state");
                    menuShortcut.ON.setEnabled(true);
                    new Theme.AutosaveTheme().HighlightOFF(menuShortcut);
                    new WorkingFunctions.Autosave().autosave(menuShortcut.interFace, "off");
                    menuShortcut.OFF.setEnabled(false);
                }else {
                    menuShortcut.ON.setEnabled(true);
                    new Theme.AutosaveTheme().HighlightOFF(menuShortcut);
                    new WorkingFunctions.Autosave().autosave(menuShortcut.interFace, "off");
                    menuShortcut.OFF.setEnabled(false);
                }
            }
        });

        menuShortcut.log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Consolelog().ShowLog("hello");
            }
        });

        menuShortcut.interFace.jTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){
                    new WorkingFunctions.Autosave().ListenerAutosave(menuShortcut.interFace);
                    new WorkingFunctions.monitor().TrackEmergency(menuShortcut.interFace);
                }
            }
        });

        menuShortcut.interFace.window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                new WorkingFunctions.FileFunction().FileCreatorFunction("Title");
                new WorkingFunctions.FileFunction().FileDelFunction("Storage");
                new WorkingFunctions.FileFunction().FileDelFunction("TextEditor.log");
                new WorkingFunctions.Autosave().EnableAutosave(menuShortcut);
                new WorkingFunctions.monitor().TrackEmergency(menuShortcut.interFace);
                new WorkingFunctions.LogWriting().Logcreator();
                new WorkingFunctions.LogWriting().LogWriter("log writing start");
                new WorkingFunctions.monitor().ShowTrackemergency(menuShortcut.interFace);
                new WorkingFunctions.LogWriting().LogWriter("tracker tracking input");
                if(new File("autosave").exists()){
                    new WorkingFunctions.LogWriting().LogWriter("autosave 1 defined by user");
                }else{
                    new WorkingFunctions.LogWriting().LogWriter("autosave 0 definded by user");
                }
                if (input=="do"){
                    new WorkingFunctions.LogWriting().LogWriter("entering userdefined input env");
                    new WorkingFunctions().OpenAnything(menuShortcut.interFace,filepath);
                }
            }
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                new WorkingFunctions.LogWriting().LogWriter("terminating all process");
                new WorkingFunctions.LogWriting().LogWriter(menuShortcut.interFace.window.getTitle()+" terminated");
                new WorkingFunctions.SaveFunction().Exit(menuShortcut.interFace);
                new WorkingFunctions.SaveFunction().Recheck(menuShortcut.interFace);
                new WorkingFunctions.FileFunction().FileDelFunction("Storage");
            }
        });

        menuShortcut.interFace.jTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                menuShortcut.lineNumberArea.setText(new WorkingFunctions().LineNumberDeploy(menuShortcut.interFace.jTextArea));
                if (!menuShortcut.interFace.window.getTitle().equals("*TextEditor")) {
                    if (!new File("autosave").exists()) {
                        if (menuShortcut.interFace.jTextArea.getDocument().getLength() != new File(new WorkingFunctions.FileFunction().
                                FileReaderFunction("Storage")).length()) {
                            new WorkingFunctions.Nameing().DocumentUpdate(menuShortcut, "update");
                            new WorkingFunctions.LogWriting().LogWriter("name changed to " + menuShortcut.interFace.window.getTitle());
                        } else if (menuShortcut.interFace.jTextArea.getDocument().getLength() == new File(new WorkingFunctions.FileFunction().
                                FileReaderFunction("Storage")).length()) {
                            new WorkingFunctions.Nameing().DocumentUpdate(menuShortcut, "remove");
                            new WorkingFunctions.LogWriting().LogWriter("name changed to " + menuShortcut.interFace.window.getTitle());
                        } else {
                            new WorkingFunctions.LogWriting().LogWriter("autosave existed");
                        }
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!menuShortcut.interFace.window.getTitle().equals("*TextEditor")) {
                    if (!new File("autosave").exists()) {
                        if (menuShortcut.interFace.jTextArea.getDocument().getLength() == new File(new WorkingFunctions.FileFunction().
                                FileReaderFunction("Storage")).length()) {
                            new WorkingFunctions.Nameing().DocumentUpdate(menuShortcut, "remove");
                        } else if (menuShortcut.interFace.jTextArea.getDocument().getLength() != new File(new WorkingFunctions.FileFunction().
                                FileReaderFunction("Storage")).length()) {
                            new WorkingFunctions.Nameing().DocumentUpdate(menuShortcut, "update");
                        }
                    }
                }
                menuShortcut.lineNumberArea.setText(new WorkingFunctions().LineNumberDeploy(menuShortcut.interFace.jTextArea));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                menuShortcut.lineNumberArea.setText(new WorkingFunctions().LineNumberDeploy(menuShortcut.interFace.jTextArea));
            }
        });

        menuShortcut.interFace.window.setVisible(true);


    }
    public void SubAction(GuiDesign menuShortcut) {
        UndoManager undoManager = new UndoManager();
        Action Undo =new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions().Recover("undo",undoManager);
            }
        };
        Action Redo = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkingFunctions().Recover("redo",undoManager);
            }
        };
        Action log = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Consolelog().ShowLog("");
            }
        };
        new KeyBindings().keys(menuShortcut,Undo,Redo,log);
         menuShortcut.interFace.jTextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
             @Override
             public void undoableEditHappened(UndoableEditEvent undoableEditEvent) {
                 undoManager.addEdit(undoableEditEvent.getEdit());
             }
         });
         menuShortcut.Size.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                     SizeWindow sizeWindow = new SizeWindow(menuShortcut);
                     sizeWindow.textField.setText(String.valueOf(menuShortcut.interFace.jTextArea.getFont().getSize()));
                     sizeWindow.list.addKeyListener(new KeyAdapter() {
                         @Override
                         public void keyPressed(KeyEvent e) {
                             String selectSize = (String) sizeWindow.list.getSelectedValue();
                             int size = Integer.parseInt(selectSize);
                             if (e.getKeyCode()==KeyEvent.VK_UP){
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                                 menuShortcut.lineNumberArea.setFont(new Font(menuShortcut.lineNumberArea.getFont().getName(),
                                         menuShortcut.lineNumberArea.getFont().getStyle(),size));
                                 sizeWindow.textField.setText(selectSize);
                             }
                             if (e.getKeyCode() == KeyEvent.VK_DOWN){
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                                 menuShortcut.lineNumberArea.setFont(new Font(menuShortcut.lineNumberArea.getFont().getName(),
                                         menuShortcut.lineNumberArea.getFont().getStyle(),size));
                                 sizeWindow.textField.setText(selectSize);
                             }
                             if (e.getKeyCode() == KeyEvent.VK_ENTER){
                                 menuShortcut.Size.setEnabled(true);
                                 sizeWindow.dispose();
                             }
                         }
                     });
                     sizeWindow.list.addMouseListener(new MouseAdapter() {
                         @Override
                         public void mouseClicked(MouseEvent e) {
                             if (e.getClickCount()==2){
                                 String selectSize = (String) sizeWindow.list.getSelectedValue();
                                 int size = Integer.parseInt(selectSize);
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                                 menuShortcut.lineNumberArea.setFont(new Font(menuShortcut.lineNumberArea.getFont().getName(),
                                         menuShortcut.lineNumberArea.getFont().getStyle(),size));
                                 sizeWindow.dispose();
                                 menuShortcut.Size.setEnabled(true);
                             };
                             if(e.getClickCount()==1){
                                 sizeWindow.textField.setText((String) sizeWindow.list.getSelectedValue());
                             }
                         }
                     });
                     sizeWindow.textField.addKeyListener(new KeyAdapter() {
                         @Override
                         public void keyPressed(KeyEvent e) {
                             if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                                 int size = Integer.parseInt(sizeWindow.textField.getText());
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                                 menuShortcut.lineNumberArea.setFont(new Font(menuShortcut.lineNumberArea.getFont().getName(),
                                         menuShortcut.lineNumberArea.getFont().getStyle(),size));
                                 menuShortcut.Size.setEnabled(true);
                                 sizeWindow.dispose();
                             }
                         }
                     });
             }
         });
         menuShortcut.Font.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 FontWindow fontWindow = new FontWindow(menuShortcut);
                 fontWindow.list.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent mouseEvent) {
                         if (mouseEvent.getClickCount()==1){
                             String selectFonts = (String) fontWindow.list.getSelectedValue();
                             int getSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFonts,Font.PLAIN,getSize));
                             menuShortcut.lineNumberArea.setFont(new Font(selectFonts,Font.PLAIN,getSize));
                         }else {
                             System.out.println("pressed");
                         }
                     }
                 });
                 fontWindow.list.addKeyListener(new KeyAdapter() {
                     @Override
                     public void keyReleased(KeyEvent e) {
                         if (e.getKeyCode()==KeyEvent.VK_DOWN){
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                             menuShortcut.lineNumberArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                         }
                         if (e.getKeyCode()==KeyEvent.VK_UP) {
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize = menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont, Font.PLAIN, FontDefaultSize));
                             menuShortcut.lineNumberArea.setFont(new Font(selectFont, Font.PLAIN, FontDefaultSize));
                         }
                     }
                     @Override
                     public void keyPressed(KeyEvent e) {
                         if (e.getKeyCode()==KeyEvent.VK_DOWN){
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                             menuShortcut.lineNumberArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                         }
                         if (e.getKeyCode()==KeyEvent.VK_UP) {
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize = menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont, Font.PLAIN, FontDefaultSize));
                             menuShortcut.lineNumberArea.setFont(new Font(selectFont, Font.PLAIN, FontDefaultSize));
                         }
                         if (e.getKeyCode()==KeyEvent.VK_ENTER){
                             menuShortcut.Font.setEnabled(true);
                             fontWindow.window.dispose();
                         }
                     }

                 });
                 fontWindow.list.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                         if (e.getClickCount()==2) {
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize = menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont, Font.PLAIN, FontDefaultSize));
                             menuShortcut.lineNumberArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                             fontWindow.window.dispose();
                             menuShortcut.Font.setEnabled(true);
                             fontWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
                         }
                     }
                 });
             }
         });
         menuShortcut.Bold.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent mouseEvent) {
                 if (mouseEvent.getClickCount()==1){
                     menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                             menuShortcut.interFace.jTextArea.getFont().getStyle()|java.awt.Font.BOLD,menuShortcut.interFace.jTextArea.getFont().getSize()));
                 }
                 else if (mouseEvent.getClickCount()==2){
                     menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                             Font.PLAIN,menuShortcut.interFace.jTextArea.getFont().getSize()));
                 }
             }
         });
        menuShortcut.Italic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount()==1){
                    menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                            menuShortcut.interFace.jTextArea.getFont().getStyle()| Font.ITALIC,menuShortcut.interFace.jTextArea.getFont().getSize()));
                }
                else if (mouseEvent.getClickCount()==2){
                    menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                            Font.PLAIN,menuShortcut.interFace.jTextArea.getFont().getSize()));
                }
            }
        });
        menuShortcut.Fonts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Theme().activeCustomForeground(menuShortcut);
            }
        });
        menuShortcut.Area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               new Theme().activeCustomBackground(menuShortcut);
            }
        });
        menuShortcut.DarkTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(customForeTheme.exists()){
                    System.out.println("pussy");
                    customForeTheme.delete();
                }
                new Theme().Dark(menuShortcut);
            }
        });
        
        menuShortcut.Normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Theme().Normal(menuShortcut);
        }
        });
    }
}