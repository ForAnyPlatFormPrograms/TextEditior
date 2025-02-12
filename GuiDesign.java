import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class GuiDesign {
    public  String filepath;
    TextAreaMod interFace = new TextAreaMod();
    JMenuBar menuBar = new JMenuBar();
    final UndoManager undoManager = new UndoManager();

    JMenu File = new JMenu("File");
    JMenuItem New = new JMenuItem("New");
    JMenuItem Exit = new JMenuItem("Exit");
    JMenuItem Reset = new JMenuItem("Reset");
    JMenuItem Open = new JMenuItem("Open");
    JMenuItem Save = new JMenuItem("Save");
    JMenu Autosave = new JMenu("Autosave");
    JMenuItem ON = new JMenuItem("ON");
    JMenuItem OFF = new JMenuItem("OFF");
    JMenuItem SaveAs = new JMenuItem("SaveAs");

    JMenu Edit = new JMenu("Edit");
    JMenuItem Font = new JMenuItem("Font");
    JMenuItem Redo = new JMenuItem("Redo");
    JMenuItem Undo = new JMenuItem("Undo");
    JMenuItem Size = new JMenuItem("Size");
    JMenuItem log = new JMenuItem("Log");

    JMenu Color = new JMenu("Color");
    JMenuItem Fonts = new JMenuItem("Fonts");
    JMenuItem Area = new JMenuItem("Area");
    JMenuItem DarkTheme = new JMenuItem("Dark Theme");
    JMenuItem Normal = new JMenuItem("Normal");

    JMenu Bold = new JMenu("Bold");
    JMenu Italic = new JMenu("Italic");

    JMenu Help = new JMenu("Help");
    JMenuItem About = new JMenuItem("About");
    JMenuItem help = new JMenuItem("help");
    GuiDesign dsignMain;
    LineNumberArea lineNumberArea = new LineNumberArea(interFace.jTextArea);
    GuiDesign()  {
        //File
        File.add(New);
        File.add(Open);
        File.add(Reset);
        File.add(Save);
        File.add(Autosave);
        Autosave.add(ON);
        Autosave.add(OFF);
        File.add(SaveAs);
        File.add(Exit);
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
        Edit.add(log);
        menuBar.add(Edit);

        Help.add(About);
        Help.add(help);
        menuBar.add(Help);

        menuBar.add(Bold);
        menuBar.add(Italic);

        //Theming
        new Theme().SetTheme(lineNumberArea,interFace,menuBar,File,New,Reset,Exit,Open,Save,SaveAs,Edit,
                Font,Redo,Undo,Size,Color,Fonts,Area,DarkTheme,Normal,Bold,Italic,Help,About,help,Autosave,ON,OFF);

        interFace.window.setJMenuBar(menuBar);


        interFace.jScrollPane.getViewport().add(interFace.jTextArea);
        interFace.jScrollPane.setRowHeaderView(lineNumberArea);
        interFace.window.add(interFace.jScrollPane);
    }
}
