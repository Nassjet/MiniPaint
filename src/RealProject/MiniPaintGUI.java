
package RealProject;

import javax.swing.*;
import java.awt.*;

public class MiniPaintGUI extends JFrame {
    public MiniPaintGUI() {
        JFrame window = new JFrame("MiniPaint");
        window.setSize(800, 500);
        window.setLocationRelativeTo(null); // Centre la fenêtre
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ferme l'application entière

        addGuiComponents(window.getContentPane()); // on ajoute nos JPanel à la JFrmae

        window.setVisible(true); // Affiche la fenêtre
        window.pack(); // Ajuste la taille de la fenêtre
    }

    private void addGuiComponents(Container contentPane) {
        JPanel paintPanel = new JPanel(); // JPanel de base
        paintPanel.setLayout(new BorderLayout()); // je spécifie le borderlayout pour m'en rappeler
        paintPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // bordure noire pour voir qu'il existe bien


        DrawingPanel drawingPanel = new DrawingPanel(800, 450);
        paintPanel.add(drawingPanel, BorderLayout.CENTER); // Ajouter zone de dessin au centre (south west et east sont mangés par Center)
        ToolbarPanel toolbarPanel = new ToolbarPanel(drawingPanel);
        paintPanel.add(toolbarPanel, BorderLayout.NORTH); // Toolbar prend tout le north, retournes voir le schéma du BorderLayout pour mieux comprendre

        contentPane.add(paintPanel);
    }


}
