
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class KeyBindings {
    final UndoManager undoManager = new UndoManager();
    GuiDsignMain menuShortcut = new GuiDsignMain();
    Action Undo;
    Action Redo;

    KeyBindings() {
         Undo =new UndoAction();
         Redo = new RedoAction();
         menuShortcut.New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
         menuShortcut.Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));
         menuShortcut.Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
         menuShortcut.Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
         menuShortcut.SaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
         menuShortcut.Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
         menuShortcut.Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
         menuShortcut.interFace.jTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK),"undo");
         menuShortcut.interFace.jTextArea.getActionMap().put("undo", Undo);
         menuShortcut.interFace.jTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK),"redo");
         menuShortcut.interFace.jTextArea.getActionMap().put("redo",Redo);
         menuShortcut.Font.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
         menuShortcut.Size.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
         menuShortcut.Normal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
        menuShortcut.DarkTheme.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));


         //undo redo
         menuShortcut.interFace.jTextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
             @Override
             public void undoableEditHappened(UndoableEditEvent undoableEditEvent) {
                 undoManager.addEdit(undoableEditEvent.getEdit());
             }
         });
         menuShortcut.Size.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                     SizeWindow sizeWindow = new SizeWindow();
                     sizeWindow.textField.setText("Size: "+String.valueOf(menuShortcut.interFace.jTextArea.getFont().getSize()));
                     sizeWindow.list.addKeyListener(new KeyAdapter() {
                         @Override
                         public void keyPressed(KeyEvent e) {
                             if (e.getKeyCode()==KeyEvent.VK_UP){
                                 String selectSize = (String) sizeWindow.list.getSelectedValue();
                                 int size = Integer.parseInt(selectSize);
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                             }
                             if (e.getKeyCode() == KeyEvent.VK_DOWN){
                                 String selectSize = (String) sizeWindow.list.getSelectedValue();
                                 int size = Integer.parseInt(selectSize);
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                             }
                             if (e.getKeyCode() == KeyEvent.VK_ENTER){
                                 sizeWindow.dispose();
                             }
                         }
                     });
                     sizeWindow.list.addMouseListener(new MouseAdapter() {
                         @Override
                         public void mouseClicked(MouseEvent e) {
                             if (e.getClickCount()==1){
                                 String selectSize = (String) sizeWindow.list.getSelectedValue();
                                 int size = Integer.parseInt(selectSize);
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                             };

                         }
                     });
                     sizeWindow.textField.addKeyListener(new KeyAdapter() {
                         @Override
                         public void keyReleased(KeyEvent e) {
                             if (e.getKeyCode()==KeyEvent.VK_ENTER){
                                 int size = Integer.parseInt(sizeWindow.textField.getText());
                                 menuShortcut.interFace.jTextArea.setFont(new Font(menuShortcut.interFace.jTextArea.getFont().getName(),
                                         menuShortcut.interFace.jTextArea.getFont().getStyle(),size));
                             }
                         }
                     });
                     sizeWindow.addWindowListener(new WindowListener() {
                         @Override
                         public void windowOpened(WindowEvent windowEvent) {
                             menuShortcut.Size.setEnabled(false);
                         }

                         @Override
                         public void windowClosing(WindowEvent windowEvent) {
                             sizeWindow.dispose();
                             menuShortcut.Size.setEnabled(true);
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
         });
         menuShortcut.Font.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {

                 FontWindow fontWindow = new FontWindow();
                 System.out.println(fontWindow.getDefaultCloseOperation());
                 fontWindow.list.addMouseListener(new MouseListener() {
                     @Override
                     public void mouseClicked(MouseEvent mouseEvent) {
                         if (mouseEvent.getClickCount()==1){
                             String selectFonts = (String) fontWindow.list.getSelectedValue();
                             int getSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFonts,Font.PLAIN,getSize));
                         }
                     }

                     @Override
                     public void mousePressed(MouseEvent mouseEvent) {

                     }

                     @Override
                     public void mouseReleased(MouseEvent mouseEvent) {

                     }

                     @Override
                     public void mouseEntered(MouseEvent mouseEvent) {

                     }

                     @Override
                     public void mouseExited(MouseEvent mouseEvent) {

                     }
                 });
                 fontWindow.list.addKeyListener(new KeyAdapter() {
                     @Override
                     public void keyReleased(KeyEvent e) {
                         if (e.getKeyCode()==KeyEvent.VK_DOWN){
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                         }
                         if (e.getKeyCode()==KeyEvent.VK_UP){
                                 String selectFont = (String) fontWindow.list.getSelectedValue();
                                 int FontDefaultSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                                 menuShortcut.interFace.jTextArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                         }
                         if (e.getKeyCode()==KeyEvent.VK_ENTER){
                             fontWindow.dispose();
                             menuShortcut.Font.setEnabled(true);
                         }
                     }
                     @Override
                     public void keyPressed(KeyEvent e) {
                         if (e.getKeyCode()==KeyEvent.VK_DOWN){
                             String selectFont = (String) fontWindow.list.getSelectedValue();
                             int FontDefaultSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                             menuShortcut.interFace.jTextArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                         }
                         if (e.getKeyCode()==KeyEvent.VK_UP){
                                 String selectFont = (String) fontWindow.list.getSelectedValue();
                                 int FontDefaultSize= menuShortcut.interFace.jTextArea.getFont().getSize();
                                 menuShortcut.interFace.jTextArea.setFont(new Font(selectFont,Font.PLAIN,FontDefaultSize));
                         }
                     }

                 });
                 fontWindow.addWindowListener(new WindowListener() {
                     @Override
                     public void windowOpened(WindowEvent windowEvent) {

                         
                         menuShortcut.Font.setEnabled(false);
                     }

                     @Override
                     public void windowClosing(WindowEvent windowEvent) {
                        menuShortcut.Font.setEnabled(true);
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
                Color color = JColorChooser.showDialog(menuShortcut.Fonts,"choose",menuShortcut.interFace.jTextArea.getForeground());
                menuShortcut.interFace.jTextArea.setForeground(color);
            }
        });
        menuShortcut.Area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color color = JColorChooser.showDialog(menuShortcut.Fonts,"choose",menuShortcut.interFace.jTextArea.getBackground());
                menuShortcut.interFace.jTextArea.setBackground(color);
                System.out.println(color);
            }
        });
        menuShortcut.DarkTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuShortcut.menuBar.setBackground(Color.BLACK);
                menuShortcut.File.setOpaque(true);
                menuShortcut.File.setBackground(Color.BLACK);
                menuShortcut.File.setForeground(Color.WHITE);
                
                menuShortcut.Edit.setOpaque(true);
                menuShortcut.Edit.setBackground(Color.BLACK);
                menuShortcut.Edit.setForeground(Color.WHITE);
                
                menuShortcut.Help.setOpaque(true);
                menuShortcut.Help.setBackground(Color.BLACK);
                menuShortcut.Help.setForeground(Color.WHITE);
                
                menuShortcut.Bold.setOpaque(true);
                menuShortcut.Bold.setBackground(Color.BLACK);
                menuShortcut.Bold.setForeground(Color.WHITE);

                menuShortcut.Italic.setOpaque(true);
                menuShortcut.Italic.setBackground(Color.BLACK);
                menuShortcut.Italic.setForeground(Color.WHITE);

                menuShortcut.New.setOpaque(true);
                menuShortcut.New.setBackground(Color.BLACK);
                menuShortcut.New.setForeground(Color.WHITE);

                menuShortcut.Open.setOpaque(true);
                menuShortcut.Open.setBackground(Color.BLACK);
                menuShortcut.Open.setForeground(Color.WHITE);

                menuShortcut.Save.setOpaque(true);
                menuShortcut.Save.setBackground(Color.BLACK);
                menuShortcut.Save.setForeground(Color.WHITE);

                menuShortcut.SaveAs.setOpaque(true);
                menuShortcut.SaveAs.setBackground(Color.BLACK);
                menuShortcut.SaveAs.setForeground(Color.WHITE);

                menuShortcut.Exit.setOpaque(true);
                menuShortcut.Exit.setBackground(Color.BLACK);
                menuShortcut.Exit.setForeground(Color.WHITE);

                menuShortcut.Font.setOpaque(true);
                menuShortcut.Font.setBackground(Color.BLACK);
                menuShortcut.Font.setForeground(Color.WHITE);

                menuShortcut.Color.setOpaque(true);
                menuShortcut.Color.setBackground(Color.BLACK);
                menuShortcut.Color.setForeground(Color.WHITE);

                menuShortcut.Fonts.setOpaque(true);
                menuShortcut.Fonts.setBackground(Color.BLACK);
                menuShortcut.Fonts.setForeground(Color.WHITE);

                menuShortcut.Area.setOpaque(true);
                menuShortcut.Area.setBackground(Color.BLACK);
                menuShortcut.Area.setForeground(Color.WHITE);

                menuShortcut.DarkTheme.setOpaque(true);
                menuShortcut.DarkTheme.setBackground(Color.BLACK);
                menuShortcut.DarkTheme.setForeground(Color.WHITE);

                menuShortcut.Normal.setOpaque(true);
                menuShortcut.Normal.setBackground(Color.BLACK);
                menuShortcut.Normal.setForeground(Color.WHITE);

                menuShortcut.Size.setOpaque(true);
                menuShortcut.Size.setBackground(Color.BLACK);
                menuShortcut.Size.setForeground(Color.WHITE);

                menuShortcut.Undo.setOpaque(true);
                menuShortcut.Undo.setBackground(Color.BLACK);
                menuShortcut.Undo.setForeground(Color.WHITE);

                menuShortcut.Redo.setOpaque(true);
                menuShortcut.Redo.setBackground(Color.BLACK);
                menuShortcut.Redo.setForeground(Color.WHITE);

                menuShortcut.About.setOpaque(true);
                menuShortcut.About.setBackground(Color.BLACK);
                menuShortcut.About.setForeground(Color.WHITE);

                menuShortcut.help.setOpaque(true);
                menuShortcut.help.setBackground(Color.BLACK);
                menuShortcut.help.setForeground(Color.WHITE);

                menuShortcut.menuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                menuShortcut.interFace.jTextArea.setBackground(Color.BLACK);
                menuShortcut.interFace.jTextArea.setForeground(Color.WHITE);
                menuShortcut.interFace.jTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                menuShortcut.interFace.jTextArea.setCaretColor(Color.WHITE);

                File darkTheme = new File("DarkTheme");
                if (! darkTheme.exists()){
                   try{
                       darkTheme.createNewFile();
                   } catch (Exception e) {
                       throw new RuntimeException(e);
                   }
                }
                else {
                    System.out.println("Already Existed");
                }
            }
        });
        
        menuShortcut.Normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuShortcut.menuBar.setBackground(Color.WHITE);
                menuShortcut.File.setOpaque(true);
                menuShortcut.File.setBackground(Color.WHITE);
                menuShortcut.File.setForeground(Color.BLACK);

                menuShortcut.Edit.setOpaque(true);
                menuShortcut.Edit.setBackground(Color.WHITE);
                menuShortcut.Edit.setForeground(Color.BLACK);

                menuShortcut.Help.setOpaque(true);
                menuShortcut.Help.setBackground(Color.WHITE);
                menuShortcut.Help.setForeground(Color.BLACK);

                menuShortcut.Bold.setOpaque(true);
                menuShortcut.Bold.setBackground(Color.WHITE);
                menuShortcut.Bold.setForeground(Color.BLACK);

                menuShortcut.Italic.setOpaque(true);
                menuShortcut.Italic.setBackground(Color.WHITE);
                menuShortcut.Italic.setForeground(Color.BLACK);

                menuShortcut.New.setOpaque(true);
                menuShortcut.New.setBackground(Color.WHITE);
                menuShortcut.New.setForeground(Color.BLACK);

                menuShortcut.Open.setOpaque(true);
                menuShortcut.Open.setBackground(Color.WHITE);
                menuShortcut.Open.setForeground(Color.BLACK);

                menuShortcut.Save.setOpaque(true);
                menuShortcut.Save.setBackground(Color.WHITE);
                menuShortcut.Save.setForeground(Color.BLACK);

                menuShortcut.SaveAs.setOpaque(true);
                menuShortcut.SaveAs.setBackground(Color.WHITE);
                menuShortcut.SaveAs.setForeground(Color.BLACK);

                menuShortcut.Exit.setOpaque(true);
                menuShortcut.Exit.setBackground(Color.WHITE);
                menuShortcut.Exit.setForeground(Color.BLACK);

                menuShortcut.Font.setOpaque(true);
                menuShortcut.Font.setBackground(Color.WHITE);
                menuShortcut.Font.setForeground(Color.BLACK);

                menuShortcut.Color.setOpaque(true);
                menuShortcut.Color.setBackground(Color.WHITE);
                menuShortcut.Color.setForeground(Color.BLACK);

                menuShortcut.Fonts.setOpaque(true);
                menuShortcut.Fonts.setBackground(Color.WHITE);
                menuShortcut.Fonts.setForeground(Color.BLACK);

                menuShortcut.Area.setOpaque(true);
                menuShortcut.Area.setBackground(Color.WHITE);
                menuShortcut.Area.setForeground(Color.BLACK);

                menuShortcut.DarkTheme.setOpaque(true);
                menuShortcut.DarkTheme.setBackground(Color.WHITE);
                menuShortcut.DarkTheme.setForeground(Color.BLACK);

                menuShortcut.Normal.setOpaque(true);
                menuShortcut.Normal.setBackground(Color.WHITE);
                menuShortcut.Normal.setForeground(Color.BLACK);

                menuShortcut.Size.setOpaque(true);
                menuShortcut.Size.setBackground(Color.WHITE);
                menuShortcut.Size.setForeground(Color.BLACK);

                menuShortcut.Undo.setOpaque(true);
                menuShortcut.Undo.setBackground(Color.WHITE);
                menuShortcut.Undo.setForeground(Color.BLACK);

                menuShortcut.Redo.setOpaque(true);
                menuShortcut.Redo.setBackground(Color.WHITE);
                menuShortcut.Redo.setForeground(Color.BLACK);

                menuShortcut.About.setOpaque(true);
                menuShortcut.About.setBackground(Color.WHITE);
                menuShortcut.About.setForeground(Color.BLACK);

                menuShortcut.help.setOpaque(true);
                menuShortcut.help.setBackground(Color.WHITE);
                menuShortcut.help.setForeground(Color.BLACK);

                menuShortcut.menuBar.setBorder(BorderFactory.createLineBorder(Color.WHITE));

                menuShortcut.interFace.jTextArea.setBackground(Color.WHITE);
                menuShortcut.interFace.jTextArea.setForeground(Color.BLACK);
                menuShortcut.interFace.jTextArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                menuShortcut.interFace.jTextArea.setCaretColor(Color.BLACK);

                File darkTheme = new File("DarkTheme");
                if (darkTheme.exists()){
                    darkTheme.delete();
                }
                else {
                    System.out.println("Never Been Created");
                }
            }
        });
    }

    public class UndoAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            } catch (CannotUndoException e) {
            }
        }
    }

    public  class RedoAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try{
                if (undoManager.canRedo()){
                    undoManager.redo();
                }
            } catch (Exception e) {
            }
        }
    }
}

