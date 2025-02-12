import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Timer;

public class WorkingFunctions {
    private static class FileModifier{
        File file = new File("Storage");
        private void CreateFile(){
            if(!file.exists()){
                try{
                    file.createNewFile();
                }catch (Exception e){
                    System.out.println("not done");
                }
            }
        }
        private  void WriteFile(String input){
            if (file.exists()){
                try{
                    FileWriter fw = new FileWriter(file);
                    fw.write(input);
                    fw.close();
                }catch (Exception e){
                    System.out.println("not done");
                }
            }
        }
        private String ReadFile() {
            if (file.exists()) {
                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader);
                    try {
                        String line = reader.readLine();
                        return line;
                    } catch (Exception e) {
                        System.out.println("no buffer done");
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("not done");
                }
            }
            return "";
        }
    }
    public static class FileFunction{
        public void FileCreatorFunction(String filename){
            File file = new File(filename);
            if (!file.exists()){
                try {
                    file.createNewFile();
                }catch (Exception e){
                    new LogWriting().LogWriter(file.getName()+" creation error");
                }
            }
        }
        public String FileReaderFunction(String filename){
            File file = new File(filename);
            if (file.exists()) {
                try {
                    FileReader fileReader = new FileReader(filename);
                    BufferedReader reader = new BufferedReader(fileReader);
                    try {
                        String line = reader.readLine();
                        return line;
                    } catch (Exception e) {
                        new LogWriting().LogWriter(file.getName()+" not abel to read");
                    }
                    reader.close();
                } catch (Exception e) {
                    new LogWriting().LogWriter(file.getName()+" no buffer done");
                }
            }
            return "";
        }
        public void FileWriterFunction(String filename,String input){
            File file = new File(filename);
            if (file.exists()) {
                try {
                    FileWriter writer = new FileWriter(filename);
                    writer.write(input);
                    writer.close();
                } catch (Exception e) {

                }
            }
        }
        public void FileDelFunction(String filename) {
            File file = new File(filename);
            if (file.exists()) {
                file.delete();
            }
        }
        public String FileExtensidn(File file){
            int i = file.getName().lastIndexOf(".");
            if(i==-1) {
                return "";
            }
            return file.getName().substring(i);
        }
    }
    public static class Nameing{
        String casualname = "*TextEditor";
        String sourcename = "Storage";
        private String ReadFileAnyWhere(){
            File file = new File(sourcename);
            if (file.exists()) {
                try {
                    FileReader fileReader = new FileReader(sourcename);
                    BufferedReader reader = new BufferedReader(fileReader);
                    try {
                        String line = reader.readLine();
                        return line;
                    } catch (Exception e) {
                        System.out.println("no buffer done");
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("not done");
                }
            }
            return "";
        }
        public void DocumentUpdate(GuiDesign menushortcut,String command){
            String name = new File(ReadFileAnyWhere()).getName();
            switch (command) {
                case "update":
                    if (menushortcut.interFace.window.getTitle() != casualname) {
                        menushortcut.interFace.window.setTitle("*" + name);
                        new LogWriting().LogWriter("name changed to "+menushortcut.interFace.window.getTitle());
                    }
                    break;
                case "remove":
                    if (menushortcut.interFace.window.getTitle() != casualname) {
                        menushortcut.interFace.window.setTitle(name);
                        new LogWriting().LogWriter("name changed to "+menushortcut.interFace.window.getTitle());
                    }
                    break;
            }
        }
    }
    public static class SaveFunction  {
        String name2= DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss").format(LocalDateTime.now());
        private void SetAfterMath(String input,TextAreaMod interFace,String name){
            interFace.window.setTitle(name);
            new FileModifier().CreateFile();
            new FileModifier().WriteFile(input);
        }
        public  void Exit(TextAreaMod interFace) {
            new Theme().ThemeMarginal();
            new LogWriting().LogWriter("exit method start");
            if (interFace.window.getTitle()=="*TextEditor" ) {
                int decision = JOptionPane.showConfirmDialog(null, "Want to save it?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                if (decision == JOptionPane.YES_OPTION) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showSaveDialog(new MainWindow());
                    fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
                    if (fileChooser.getSelectedFile()!=null) {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        if (file.exists() && file.isFile()) {
                            int decsission = JOptionPane.showConfirmDialog(null, "File exist want to change name or Replace?", "Warning", JOptionPane.YES_NO_OPTION);
                            if (decsission == JOptionPane.YES_OPTION) {
                                file.delete();
                                try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile().getName())) {
                                    fw.write(interFace.jTextArea.getText());
                                    fw.close();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SetAfterMath(fileChooser.getSelectedFile().getAbsolutePath(), interFace, fileChooser.getSelectedFile().getName());
                            } else if (decsission == JOptionPane.NO_OPTION) {
                                File fileName = new File(fileChooser.getSelectedFile().getName() + name2);
                                try {
                                    fileName.createNewFile();
                                } catch (Exception e) {
                                    new LogWriting().LogWriter("error in creating file");
                                }
                                if (fileName.exists()) {
                                    try (FileWriter fw = new FileWriter(fileName)) {
                                        fw.write(interFace.jTextArea.getText());
                                        fw.close();
                                    } catch (Exception e) {
                                        new LogWriting().LogWriter("error in writing file");
                                    }
                                    SetAfterMath(fileChooser.getSelectedFile().getName() + name2, interFace, fileName.getName());
                                    new LogWriting().LogWriter("the frame name set to"+fileName.getName());
                                }
                            }
                        } else {
                            try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile())) {
                                fw.write(interFace.jTextArea.getText());
                                fw.close();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            SetAfterMath(fileChooser.getSelectedFile().getAbsolutePath(), interFace, fileChooser.getSelectedFile().getName());
                        }
                    }else{
                        System.out.println("null");
                    }
                }else if (decision == JOptionPane.NO_OPTION ) {
                    System.exit(0);
                } else if (decision == JOptionPane.CANCEL_OPTION) {
                    interFace.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        }
        public void Recheck(TextAreaMod interFace){
            new LogWriting().LogWriter("recheck method start");
            String extraname = "*"+new File(new FileFunction().FileReaderFunction("Storage")).getName();
            if (interFace.window.getTitle().equals(extraname)) {
                File selectedfile = new File(new FileFunction().FileReaderFunction("Storage"));
                int option = JOptionPane.showConfirmDialog(null,"Want to Save it ?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
                switch(option) {
                    case JOptionPane.YES_OPTION:
                        try {
                            FileWriter fw = new FileWriter(selectedfile);
                            fw.write(interFace.jTextArea.getText());
                            fw.close();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case JOptionPane.NO_OPTION:{
                        System.exit(0);
                    }
                    case JOptionPane.CANCEL_OPTION:
                        interFace.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        break;
                }
            }
        }
        public void Save(TextAreaMod interFace){
            new LogWriting().LogWriter("save method start");
            File save = new File("save");
            if (interFace.window.getTitle()!="*TextEditor") {
                String filepath = new FileModifier().ReadFile();
                System.out.println(filepath);
                try {
                    FileWriter fw = new FileWriter(filepath);
                    fw.write(interFace.jTextArea.getText());
                    fw.close();
                } catch (Exception e) {
                    new LogWriting().LogWriter("save error");
                }
                interFace.window.setTitle(new File(new FileFunction().FileReaderFunction("Storage")).getName());
            }
        }
        public void  Reset(GuiDesign menuShortcut){
            File [] array = { new File("autosave"), new File("BackTheme"),
                    new File("ForeTheme"), new File("DarkTheme"),
                    new File("NormalTheme"),new File("TextEditor.log")};
            if (array[0].exists()){
                array[0].delete();
                new LogWriting().LogWriter(array[0].getName()+" deleted");
                new Theme.AutosaveTheme().HighlightOFF(menuShortcut);
            }
            if (array[1].exists()){
                array[1].delete();
                new LogWriting().LogWriter(array[1].getName()+" deleted");
            }
            if (array[2].exists()){
                array[2].delete();
                new LogWriting().LogWriter(array[2].getName()+" deleted");
            }
            if (array[3].exists()){
                array[3].delete();
                new LogWriting().LogWriter(array[3].getName()+" deleted");
            }
            if (array[4].exists()){
                array[4].delete();
                new LogWriting().LogWriter(array[4].getName()+" deleted");
            }
            new LogWriting().LogWriter("All reseted to normal");
        }
        public void saveas(TextAreaMod interFace) {
            new LogWriting().LogWriter("saveas function start");
            new Theme().ThemeMarginal();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(new MainWindow());
            fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
            if (fileChooser.getSelectedFile()!=null) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                if (file.exists() && file.isFile()) {
                    int decsission = JOptionPane.showConfirmDialog(null, "File exist want to change name or Replace?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (decsission == JOptionPane.YES_OPTION) {
                        file.delete();
                        try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile())) {
                            fw.write(interFace.jTextArea.getText());
                        } catch (Exception e) {
                            new LogWriting().LogWriter("errorring selecting file");
                        }
                        SetAfterMath(fileChooser.getSelectedFile().getAbsolutePath(),interFace,fileChooser.getSelectedFile().getName());

                    } else if (decsission == JOptionPane.NO_OPTION) {
                        File fileName = new File(fileChooser.getSelectedFile().getAbsolutePath()+name2);
                        try{
                            fileName.createNewFile();
                        }catch (Exception e){
                            new LogWriting().LogWriter(fileName.getName()+" creation error");
                        }
                        if (fileName.exists()) {
                            try (FileWriter fw = new FileWriter(fileName)) {
                                fw.write(interFace.jTextArea.getText());
                                fw.close();
                            } catch (Exception e) {
                                new LogWriting().LogWriter(fileName.getName()+" not found");
                            }
                           SetAfterMath(fileChooser.getSelectedFile().getAbsolutePath()+name2,interFace,fileName.getName());
                            System.out.println(fileName);
                        }
                    }
                } else {
                    try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile())) {
                        fw.write(interFace.jTextArea.getText());
                    } catch (Exception e) {
                        new LogWriting().LogWriter("errorring selecting file");
                    }
                    SetAfterMath(fileChooser.getSelectedFile().getAbsolutePath(),interFace,fileChooser.getSelectedFile().getName());
                }
            }
        }
        public void open(TextAreaMod interFace){
            new Theme().ThemeMarginal();
            if(new File("Title").exists()){
                new FileFunction().FileWriterFunction("Title",interFace.window.getTitle());
            }
            interFace.window.setTitle(null);
            JFileChooser showDialog = new JFileChooser();
            showDialog.setDialogTitle("Open a file");
            showDialog.showOpenDialog(new MainWindow());
            if (showDialog.getSelectedFile()!=null) {
                if (showDialog.getSelectedFile().getName().endsWith(".docx")) {
                    interFace.window.setTitle(new FileFunction().FileReaderFunction("Title"));
                    JOptionPane.showConfirmDialog(null,"Dont open as its in .docx signature","Warning",JOptionPane.DEFAULT_OPTION);
                    new LogWriting().LogWriter("docx not opening");
                }else if(showDialog.getSelectedFile().getName().endsWith(".pdf")){
                    interFace.window.setTitle(new FileFunction().FileReaderFunction("Title"));
                    JOptionPane.showConfirmDialog(null,"Dont open as its in .pdf signature","Warning",JOptionPane.DEFAULT_OPTION);
                    new LogWriting().LogWriter("not opening .pdf");
                }else{
                    interFace.jTextArea.setText("");
                    SetAfterMath(showDialog.getSelectedFile().getAbsolutePath(), interFace, showDialog.getSelectedFile().getName());
                    System.out.println(new FileFunction().FileExtensidn(showDialog.getSelectedFile()));
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(showDialog.getSelectedFile().getAbsolutePath()));
                        String st;
                        while ((st = reader.readLine()) != null) {
                            interFace.jTextArea.append(st + "\n");
                        }
                        reader.close();
                    } catch (Exception e) {
                    }
                }
                new LogWriting().LogWriter("frame window name "+interFace.window.getTitle()+" set");
                new LogWriting().LogWriter("file "+showDialog.getSelectedFile().getName()+" selected");
            }else{
                interFace.window.setTitle(new File(new FileFunction().FileReaderFunction("Title")).getName());
            }
        }
    }
    /// ---SaveClass
    public static class Autosave{
        private static  boolean run;
        public void autosave(TextAreaMod interFace,String Command) {
            Timer time = new Timer();
            if (Command=="on") {
                run=true;
                if (interFace.window.getTitle() != "*TextEditor" ) {
                    File autosave = new File("autosave");
                    //autosave.getE
                if (!autosave.exists()){
                        try {
                            autosave.createNewFile();
                        }catch (Exception e){
                            new LogWriting().LogWriter(autosave.getName()+" creation error");
                        }
                    }
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (run) {
                                System.out.println("Autosave Start");
                                String filepath = new FileModifier().ReadFile();
                                try {
                                    FileWriter fw = new FileWriter(filepath);
                                    fw.write(interFace.jTextArea.getText());
                                    fw.close();
                                } catch (Exception e) {
                                    new LogWriting().LogWriter("Not Working");
                                }
                            }else{
                                time.cancel();
                                time.purge();
                            }
                        }
                    }, 100, 100);
                }else{
                    JOptionPane.showConfirmDialog(null,"Please Save it First","Warning!!",JOptionPane.DEFAULT_OPTION);
                }
            }else if (Command=="off"){
                if (interFace.window.getTitle()=="*TextEditor"){
                    JOptionPane.showConfirmDialog(null,"Please Save it First","Warning!!",JOptionPane.DEFAULT_OPTION);
                }else {
                    run = false;
                    new LogWriting().LogWriter("Stopping Autosave");
                }
            }else if(Command=="certainoff"){
                run=false;
            }
        }
        public void DisableAutosave(){
            run=false;
        }
        public void ListenerAutosave(TextAreaMod interFace) {
            File autosave = new File("autosave");
            if (!interFace.window.getTitle().equals("*TextEditor")) {
                    run = true;
                    Timer time = new Timer();
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (run) {
                                if (autosave.exists()) {
                                    System.out.println(new FileFunction().FileExtensidn(new File(new FileFunction().FileReaderFunction("Storage"))));
                                    interFace.window.setTitle(new File(new FileFunction().FileReaderFunction("Storage")).getName());
                                    new LogWriting().LogWriter("Autosave Continue");
                                    System.out.println("Autosave Continue");
                                    String filepath = new FileModifier().ReadFile();
                                    try {
                                        FileWriter fw = new FileWriter(filepath);
                                        fw.write(interFace.jTextArea.getText());
                                        fw.close();
                                    } catch (Exception e) {
                                        new LogWriting().LogWriter("wrtiting error");
                                    }
                                } else {
                                    time.cancel();
                                    time.purge();
                                }
                            }
                        }
                    }, 100, 100);
            }
        }
        public void EnableAutosave(GuiDesign menuShortcut){
            File autosave = new File("autosave");
            if(autosave.exists()) {
                menuShortcut.ON.setEnabled(false);
                menuShortcut.ON.setForeground(java.awt.Color.BLACK);
                menuShortcut.ON.setBackground(java.awt.Color.RED);
                new LogWriting().LogWriter("on is reded now");
            }
        }
    }
    public static class monitor {
        private static boolean run = true;

        public void TrackEmergency(TextAreaMod interFace) {
            File file = new File("Tracker.log");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    new LogWriting().LogWriter(file.getName() + " creation error");
                }
            }
            Timer running = new Timer();
            run=true;
            running.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (run) {
                        try {
                            if (interFace.window.getTitle().equals("*TextEditor")) {
                                new LogWriting().LogWriter("tracker start");
                                FileWriter fw = new FileWriter(file.getName());
                                fw.write(interFace.jTextArea.getText());
                                fw.close();
                            }
                            else{
                                running.cancel();
                                running.purge();
                                new LogWriting().LogWriter("tracker killed");
                            }
                        } catch (Exception e) {
                            new LogWriting().LogWriter("tracker timmer not run");
                        }
                    }
                }
            }, 100, 100);
        }
        public void ShowTrackemergency(TextAreaMod interFace) {
            File file = new File("Tracker.log");
            if (file.exists() && interFace.window.getTitle().equals("*TextEditor")) {
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    try {
                        run=false;
                        System.out.println("killed tracker");
                        String read;
                        while (!(read = reader.readLine()).equals(null)) {
                            interFace.jTextArea.append(read + "\n");
                        }
                    } catch (Exception e) {
                        new LogWriting().LogWriter(file.getName()+" Not reading");
                    }
                    reader.close();
                } catch (Exception e) {
                   new LogWriting().LogWriter("error happening at reading on trackerfile");
                }
            } 
        }
    }
    public void OpenAnything(TextAreaMod interFace,String filepath){
        File file = new File(filepath);
        if (filepath!="dont write the file") {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                new LogWriting().LogWriter("find the file");
                new LogWriting().LogWriter("read start");
                String st;
                while ((st = reader.readLine()) != null) {
                    new LogWriting().LogWriter("uploaded to textarea");
                    interFace.jTextArea.append(st + "\n");
                }
                reader.close();
            } catch (Exception e) {
                new LogWriting().LogWriter("error to finding file xx terminated");
            }
            new SaveFunction().SetAfterMath(filepath, interFace, file.getName());
        }else{
            new LogWriting().LogWriter("entering argument less env");
        }
    }
    public void Recover(String Command,UndoManager undo){
        try {
            if(Command=="undo"){
                if (undo.canUndo()){
                    undo.undo();
                    new LogWriting().LogWriter("pressed ctrl+z to undoing");
                }
            }else if (Command=="redo"){
                if (undo.canRedo()){
                    undo.redo();
                    new LogWriting().LogWriter("pressed ctrl+r to redoing");
                }
            }
        }catch (Exception e){
            new LogWriting().LogWriter("error no file found");
        }
    }
    public String LineNumberDeploy(JTextArea textArea) {
        int caretPosition = textArea.getDocument().getLength();
        Element root = textArea.getDocument().getDefaultRootElement();
        StringBuilder lineneumber = new StringBuilder();
        lineneumber.append("1. ").append(System.lineSeparator());
        for (int i = 2; i <= root.getElementIndex(caretPosition) +1; i++) {
            lineneumber.append(i + ". ").append(System.lineSeparator());
        }
        return lineneumber.toString();
    }
    public static class LogWriting{
        final static String name = "TextEditor.log";
        File logcreate = new File(name);
        public void LogWriter(String input){
            try{
                FileWriter writer = new FileWriter(logcreate,true);
                writer.write(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss").format(LocalDateTime.now()) +" ---------- "+input+"\n");
                writer.close();
            }catch (Exception e){
                LogWriter("no writing");
            }
        }
        public void Logcreator(){
            if(!logcreate.exists()){
                try {
                    logcreate.createNewFile();
                    LogWriter(name+" created");
                }catch (Exception e){
                    LogWriter(name+" creation failed");
                }
            }else{
                LogWriter(name+" existed so no need to create");
            }
        }
        public void ConsoleLogReader(JTextArea textArea){
            Timer time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    File file = new File("TextEditor.log");
                    if(file.exists()){
                        try{
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            String st;
                            ArrayList<Object> pop = new ArrayList<>();
                            while ((st=reader.readLine())!=null) {
                                pop.add(st + "\n");
                            }
                            textArea.setText(String.valueOf(pop));
                        }catch (Exception e){
                            new WorkingFunctions.LogWriting().LogWriter("error To read");
                        }
                    }else{
                        new WorkingFunctions.LogWriting().LogWriter("error to get "+file.getName()+" file");
                    }
                }
            },100,100);
        }
    }
}
