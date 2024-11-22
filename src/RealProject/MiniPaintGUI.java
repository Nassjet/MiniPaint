package RealProject;

import javax.swing.*;
import java.awt.*;

public class MiniPaintGUI extends JFrame {
    public MiniPaintGUI() {
        JFrame window = new JFrame("MiniPaint");
        window.setSize(800, 500);
        window.setLocationRelativeTo(null); // Centre la fenêtre
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addGuiComponents(window.getContentPane());

        window.setVisible(true); // Affiche la fenêtre
        window.pack(); // Ajuste la taille de la fenêtre
    }

    private void addGuiComponents(Container contentPane) {
        JPanel paintPanel = new JPanel();
        paintPanel.setLayout(new BorderLayout());
        paintPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // bordure noire pour voir qu'il existe bien

        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 1, 10, 10)); // Espace de 5px entre les cellules


        paintPanel.add(toolbar, BorderLayout.NORTH);

        // Ajouter une zone de dessin
        PaintPanel drawingPanel = new PaintPanel(800, 450);
        paintPanel.add(drawingPanel, BorderLayout.CENTER); // Ajouter zone de dessin au centre

        contentPane.add(paintPanel);
    }
}


