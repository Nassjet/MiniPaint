package RealProject;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MiniPaintGUI();
            } // appel de mon MiniPaintGUI
        });
    }
}
