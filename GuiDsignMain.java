import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
class GuiDsignMain implements ActionListener{
    public  String filepath;
    GuiDesign interFace = new GuiDesign();
    JMenuBar menuBar = new JMenuBar();
    JToolBar toolBar = new JToolBar();
    JComboBox SizecomboBox = new JComboBox(new String[]{"i1","i2"});
    JPanel panel = new JPanel();
    final UndoManager undoManager = new UndoManager();



    JMenu File = new JMenu("File");

    JMenuItem New = new JMenuItem("New");
    JMenuItem Exit = new JMenuItem("Exit");
    JMenuItem Open = new JMenuItem("Open");
    JMenuItem Save = new JMenuItem("Save");
    JMenuItem SaveAs = new JMenuItem("SaveAs");





    JMenu Edit = new JMenu("Edit");

    JMenuItem Font = new JMenuItem("Font");
    JMenuItem Redo = new JMenuItem("Redo");
    JMenuItem Undo = new JMenuItem("Undo");
    JMenuItem Size = new JMenuItem("Size");

    JMenu Color = new JMenu("Color");
    JMenuItem Fonts = new JMenuItem("Fonts");
    JMenuItem Area = new JMenuItem("Area");
    JMenuItem DarkTheme = new JMenuItem("Dark Theme");
    JMenuItem Normal = new JMenuItem("Normal");

    JMenuItem Copy = new JMenuItem("Copy");
    JMenuItem Paste = new JMenuItem("Paste");

    JMenu Bold = new JMenu("Bold");
    JMenu Italic = new JMenu("Italic");
    
    


    JMenu Help = new JMenu("Help");
    JMenuItem About = new JMenuItem("About");
    JMenuItem help = new JMenuItem("help");
    GuiDsignMain dsignMain;
    
    GuiDsignMain()  {
        System.out.println(filepath);

        File test = new File("test");


        dsignMain =this;
        //File
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(SaveAs);
        File.add(Exit);
        New.addActionListener(this);
        Exit.addActionListener(this);
        Open.addActionListener(this);
        Save.addActionListener(this);
        SaveAs.addActionListener(this);
        menuBar.add(File);

        //Edit
        Edit.add(Font);

        Edit.add(Color);
        Color.add(Fonts);
        Color.add(Area);
        Color.add(DarkTheme);
        Color.add(Normal);

        Edit.add(Size);
        Edit.add(Undo);
        Edit.add(Redo);
        Redo.addActionListener(this);
        Undo.addActionListener(this);
        menuBar.add(Edit);



        Help.add(About);
        Help.add(help);
        About.addActionListener(this);
        menuBar.add(Help);


        menuBar.add(Bold);
        menuBar.add(Italic);

        //Dark

        java.io.File testFile = new File("DarkTheme");
        if (testFile.exists()){
            menuBar.setBackground(java.awt.Color.BLACK);
            File.setOpaque(true);
            File.setBackground(java.awt.Color.BLACK);
            File.setForeground(java.awt.Color.WHITE);

            Edit.setOpaque(true);
            Edit.setBackground(java.awt.Color.BLACK);
            Edit.setForeground(java.awt.Color.WHITE);

            Help.setOpaque(true);
            Help.setBackground(java.awt.Color.BLACK);
            Help.setForeground(java.awt.Color.WHITE);

            Bold.setOpaque(true);
            Bold.setBackground(java.awt.Color.BLACK);
            Bold.setForeground(java.awt.Color.WHITE);

            Italic.setOpaque(true);
            Italic.setBackground(java.awt.Color.BLACK);
            Italic.setForeground(java.awt.Color.WHITE);

            New.setOpaque(true);
            New.setBackground(java.awt.Color.BLACK);
            New.setForeground(java.awt.Color.WHITE);

            Open.setOpaque(true);
            Open.setBackground(java.awt.Color.BLACK);
            Open.setForeground(java.awt.Color.WHITE);

            Save.setOpaque(true);
            Save.setBackground(java.awt.Color.BLACK);
            Save.setForeground(java.awt.Color.WHITE);

            SaveAs.setOpaque(true);
            SaveAs.setBackground(java.awt.Color.BLACK);
            SaveAs.setForeground(java.awt.Color.WHITE);

            Exit.setOpaque(true);
            Exit.setBackground(java.awt.Color.BLACK);
            Exit.setForeground(java.awt.Color.WHITE);

            Font.setOpaque(true);
            Font.setBackground(java.awt.Color.BLACK);
            Font.setForeground(java.awt.Color.WHITE);

            Color.setOpaque(true);
            Color.setBackground(java.awt.Color.BLACK);
            Color.setForeground(java.awt.Color.WHITE);

            Fonts.setOpaque(true);
            Fonts.setBackground(java.awt.Color.BLACK);
            Fonts.setForeground(java.awt.Color.WHITE);

            Area.setOpaque(true);
            Area.setBackground(java.awt.Color.BLACK);
            Area.setForeground(java.awt.Color.WHITE);

            DarkTheme.setOpaque(true);
            DarkTheme.setBackground(java.awt.Color.BLACK);
            DarkTheme.setForeground(java.awt.Color.WHITE);

            Normal.setOpaque(true);
            Normal.setBackground(java.awt.Color.BLACK);
            Normal.setForeground(java.awt.Color.WHITE);

            Size.setOpaque(true);
            Size.setBackground(java.awt.Color.BLACK);
            Size.setForeground(java.awt.Color.WHITE);

            Undo.setOpaque(true);
            Undo.setBackground(java.awt.Color.BLACK);
            Undo.setForeground(java.awt.Color.WHITE);

            Redo.setOpaque(true);
            Redo.setBackground(java.awt.Color.BLACK);
            Redo.setForeground(java.awt.Color.WHITE);

            About.setOpaque(true);
            About.setBackground(java.awt.Color.BLACK);
            About.setForeground(java.awt.Color.WHITE);

            help.setOpaque(true);
            help.setBackground(java.awt.Color.BLACK);
            help.setForeground(java.awt.Color.WHITE);

            menuBar.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));

            interFace.jTextArea.setBackground(java.awt.Color.BLACK);
            interFace.jTextArea.setForeground(java.awt.Color.WHITE);
            interFace.jTextArea.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
            interFace.jTextArea.setCaretColor(java.awt.Color.WHITE);
        }

        else {

            menuBar.setBackground(java.awt.Color.WHITE);
            File.setOpaque(true);
            File.setBackground(java.awt.Color.WHITE);
            File.setForeground(java.awt.Color.BLACK);

            Edit.setOpaque(true);
            Edit.setBackground(java.awt.Color.WHITE);
            Edit.setForeground(java.awt.Color.BLACK);

            Help.setOpaque(true);
            Help.setBackground(java.awt.Color.WHITE);
            Help.setForeground(java.awt.Color.BLACK);

            Bold.setOpaque(true);
            Bold.setBackground(java.awt.Color.WHITE);
            Bold.setForeground(java.awt.Color.BLACK);

            Italic.setOpaque(true);
            Italic.setBackground(java.awt.Color.WHITE);
            Italic.setForeground(java.awt.Color.BLACK);

            New.setOpaque(true);
            New.setBackground(java.awt.Color.WHITE);
            New.setForeground(java.awt.Color.BLACK);

            Open.setOpaque(true);
            Open.setBackground(java.awt.Color.WHITE);
            Open.setForeground(java.awt.Color.BLACK);

            Save.setOpaque(true);
            Save.setBackground(java.awt.Color.WHITE);
            Save.setForeground(java.awt.Color.BLACK);

            SaveAs.setOpaque(true);
            SaveAs.setBackground(java.awt.Color.WHITE);
            SaveAs.setForeground(java.awt.Color.BLACK);

            Exit.setOpaque(true);
            Exit.setBackground(java.awt.Color.WHITE);
            Exit.setForeground(java.awt.Color.BLACK);

            Font.setOpaque(true);
            Font.setBackground(java.awt.Color.WHITE);
            Font.setForeground(java.awt.Color.BLACK);

            Color.setOpaque(true);
            Color.setBackground(java.awt.Color.WHITE);
            Color.setForeground(java.awt.Color.BLACK);

            Fonts.setOpaque(true);
            Fonts.setBackground(java.awt.Color.WHITE);
            Fonts.setForeground(java.awt.Color.BLACK);

            Area.setOpaque(true);
            Area.setBackground(java.awt.Color.WHITE);
            Area.setForeground(java.awt.Color.BLACK);

            DarkTheme.setOpaque(true);
            DarkTheme.setBackground(java.awt.Color.WHITE);
            DarkTheme.setForeground(java.awt.Color.BLACK);

            Normal.setOpaque(true);
            Normal.setBackground(java.awt.Color.WHITE);
            Normal.setForeground(java.awt.Color.BLACK);

            Size.setOpaque(true);
            Size.setBackground(java.awt.Color.WHITE);
            Size.setForeground(java.awt.Color.BLACK);

            Undo.setOpaque(true);
            Undo.setBackground(java.awt.Color.WHITE);
            Undo.setForeground(java.awt.Color.BLACK);

            Redo.setOpaque(true);
            Redo.setBackground(java.awt.Color.WHITE);
            Redo.setForeground(java.awt.Color.BLACK);

            About.setOpaque(true);
            About.setBackground(java.awt.Color.WHITE);
            About.setForeground(java.awt.Color.BLACK);

            help.setOpaque(true);
            help.setBackground(java.awt.Color.WHITE);
            help.setForeground(java.awt.Color.BLACK);

            menuBar.setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE));
        }

        interFace.window.setJMenuBar(menuBar);
        interFace.window.add(interFace.jScrollPane);
        interFace.window.setVisible(true);
        //window.window.pack();

        interFace.window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                String str1 = "*Untitled";
                String str2 = interFace.window.getTitle();
                    if (str1==str2){
                        if (JOptionPane.showConfirmDialog(null,"You need to save it first","OK",JOptionPane.DEFAULT_OPTION)==JOptionPane.OK_OPTION){
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        fileChooser.showSaveDialog(null);
                        java.io.File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        if (file.exists() && file.isFile()){
                            int decsission = JOptionPane.showConfirmDialog(null,"it's Existed file please choose another name","Warning",JOptionPane.YES_NO_OPTION);
                            if (decsission==JOptionPane.YES_OPTION) {
                                fileChooser.showSaveDialog(null);
                                while (1==1) {
                                    fileChooser.showSaveDialog(null);
                                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                    if (!file.exists()){
                                        try(FileWriter fw = new FileWriter(fileChooser.getSelectedFile())){
                                            fw.write(interFace.jTextArea.getText());
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                        interFace.window.setTitle(fileChooser.getSelectedFile().getName());
                                        break;
                                    }
                                }
                            }
                            else{
                                JOptionPane.showConfirmDialog(null,"OK","OK",JOptionPane.OK_OPTION);
                            }
                        }else{
                            try(FileWriter fw = new FileWriter(fileChooser.getSelectedFile())){
                                fw.write(interFace.jTextArea.getText());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            interFace.window.setTitle(fileChooser.getSelectedFile().getName());
                        }
                    }else{
                        System.exit(0);
                    }
                }

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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()== New){
            interFace.window.dispose();
            new KeyBindings();
        }
        if (actionEvent.getSource()== Exit){
            String str1 = "*Untitled";
            String str2 = interFace.window.getTitle();
            if (str1==str2){
                if (JOptionPane.showConfirmDialog(null,"You need to save it first","OK",JOptionPane.DEFAULT_OPTION)==JOptionPane.OK_OPTION){
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.showSaveDialog(null);
                    java.io.File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    if (file.exists() && file.isFile()){
                        int decsission = JOptionPane.showConfirmDialog(null,"it's Existed file please choose another name","Warning",JOptionPane.YES_NO_OPTION);
                        if (decsission==JOptionPane.YES_OPTION) {
                            fileChooser.showSaveDialog(null);
                            while (1==1) {
                                fileChooser.showSaveDialog(null);
                                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                if (!file.exists()){
                                    try(FileWriter fw = new FileWriter(fileChooser.getSelectedFile())){
                                        fw.write(interFace.jTextArea.getText());
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                    interFace.window.setTitle(fileChooser.getSelectedFile().getName());
                                    System.exit(0);
                                    break;
                                }
                            }
                        }
                        else{
                            JOptionPane.showConfirmDialog(null,"OK","OK",JOptionPane.OK_OPTION);
                        }
                    }else{
                        try(FileWriter fw = new FileWriter(fileChooser.getSelectedFile())){
                            fw.write(interFace.jTextArea.getText());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        interFace.window.setTitle(fileChooser.getSelectedFile().getName());
                    }
                }
            }else{
                System.exit(0);
            }
        }
        if (actionEvent.getSource()==Open){
            interFace.jTextArea.setText("");
            JFileChooser showDialog = new JFileChooser();
            showDialog.showOpenDialog(null);
            filepath=showDialog.getSelectedFile().getAbsolutePath();

                try{
                    BufferedReader br = new BufferedReader(new FileReader(filepath));
                    String s1="",s2="";
                    while ((s1=br.readLine())!=null) {
                        interFace.jTextArea.append(s1+"\n");
                        //s1= br.readLine();
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                interFace.window.setTitle(showDialog.getSelectedFile().getName());

        }
        if (actionEvent.getSource()==Save){
            StringBuffer stringBuffer = new StringBuffer();
            try {
                Path path = Path.of(filepath);
                Scanner scanner = new Scanner(new File(filepath));
                while (scanner.hasNextLine()){
                    stringBuffer.append(scanner.nextLine()+System.lineSeparator());
                }
                String filecontents = stringBuffer.toString();
                scanner.close();
                String Old = Files.readString(path);
                String New = interFace.jTextArea.getText();
               filecontents=filecontents.replaceAll(Old,New);
                FileWriter fileWriter = new FileWriter(filepath);
                fileWriter.append(filecontents);
                fileWriter.flush();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (actionEvent.getSource()==SaveAs) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.showSaveDialog(null);
            filepath =fileChooser.getSelectedFile().getAbsolutePath();
            java.io.File file = new File(filepath);

            if (file.exists() && file.isFile()) {
                    int decsission = JOptionPane.showConfirmDialog(null, "it's Existed file please choose another name", "Warning", JOptionPane.YES_NO_OPTION);
                    if (decsission == JOptionPane.YES_OPTION) {
                        fileChooser.showSaveDialog(null);
                        while (1 == 1) {
                            fileChooser.showSaveDialog(null);
                            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                            if (!file.exists()) {
                                try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile())) {
                                    fw.write(interFace.jTextArea.getText());
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                interFace.window.setTitle(fileChooser.getSelectedFile().getName());
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null, "OK", "OK", JOptionPane.OK_OPTION);
                    }
                } else {
                    try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile())) {
                        fw.write(interFace.jTextArea.getText());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
               
                    interFace.window.setTitle(fileChooser.getSelectedFile().getName());
                }
        }
        if (actionEvent.getSource()==Redo){
            try{
                if (undoManager.canRedo());{
                    undoManager.redo();
                }
            } catch (Exception e) {
            }
        }
        if (actionEvent.getSource()==Undo){
            try{
                if (undoManager.canUndo()){
                    undoManager.undo();
                }
            } catch (Exception e) {

            }
        }
        if (actionEvent.getSource()==About){
            new helpWindow();
        }
    }
}
