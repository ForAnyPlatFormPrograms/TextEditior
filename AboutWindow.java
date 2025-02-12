//import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AboutWindow {
    JDialog window = new JDialog();
    JTextArea textArea = new JTextArea();
    JPanel panelImage=new JPanel();
    JPanel panelText=new JPanel();
    JLabel imageSet = new JLabel();
    AboutWindow(){
        window.setLocationRelativeTo(null);
        window.setTitle("About");
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        window.setLayout(new GridLayout());
        File customBackTheme = new File("CustomBackTheme.txt");
        File customForeTheme = new File("CustomForeTheme.txt");
        File darkTheme = new File("DarkTheme");
        File normalTheme = new File("NormalTheme");
        if (customBackTheme.exists()||customForeTheme.exists()||darkTheme.exists()){
            textArea.setBackground(Color.BLACK);
            textArea.setForeground(Color.WHITE);
        }else if(normalTheme.exists()){
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
        }else{
            textArea.setBackground(Color.LIGHT_GRAY);
            textArea.setForeground(Color.BLACK);
        }
        textArea.setText("IntelliJ IDEA 2024.3.1.1 (Community Edition) Build #IC-243.22562.218, built on December 18, 2024\n" +
                "Runtime version: 21.0.5+8-b631.28 amd64 (JCEF 122.1.9) VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.\n" +
                "Toolkit: sun.awt.windows.WToolkit Windows 10.0 GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation\n" +
                "Memory: 2048M Cores: 8 Registry: ide.experimental.ui=true i18n.locale=\n" +
                "llm.show.ai.promotion.window.on.start=false\n" +
                "Kotlin: 243.22562.218-IJ\n");
        textArea.setEditable(false);
        textArea.setFocusable(false);
        window.add(textArea);
        window.pack();
        window.setVisible(true);
    }
}
