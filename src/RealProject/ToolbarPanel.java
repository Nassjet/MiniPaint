package RealProject;

import javax.swing.*;
import java.awt.*;

public class ToolbarPanel extends JPanel {

    public ToolbarPanel(DrawingPanel drawingPanel) {

        setLayout(new BorderLayout()); // pareil BorderLayout les autres layout sont compliqués pour rien imo

        // JToolbar (inutile de créer manuellement une toolbar)
        JToolBar toolBar = new JToolBar();

        // Création de tout mes boutons
        JButton btnCarre = new JButton("Carre");
        JButton btnRectangle = new JButton("Rectangle");
        JButton btnTriangle = new JButton("Triangle");
        JButton btnCercle = new JButton("Cercle");
        JButton btnOval = new JButton("Oval");
        JButton btnCrayon = new JButton("Crayon");
        JButton btnGomme = new JButton("Gomme");
        JButton btnColorChooser = new JButton("Couleur");

        // Ajout des boutons à la toolbar
        toolBar.add(btnCarre);
        toolBar.add(btnRectangle);
        toolBar.add(btnTriangle);
        toolBar.add(btnCercle);
        toolBar.add(btnOval);
        toolBar.add(btnCrayon);
        toolBar.add(btnGomme);
        toolBar.add(btnColorChooser);

        //les listeners pour effectuer l'action adéquate
        btnCarre.addActionListener(e -> drawingPanel.setCurrentShape("Carre"));
        btnRectangle.addActionListener(e -> drawingPanel.setCurrentShape("Rectangle"));
        btnTriangle.addActionListener(e -> drawingPanel.setCurrentShape("Triangle"));
        btnCercle.addActionListener(e -> drawingPanel.setCurrentShape("Cercle"));
        btnOval.addActionListener(e -> drawingPanel.setCurrentShape("Oval"));
        btnCrayon.addActionListener(e -> drawingPanel.setCurrentShape("Crayon"));
        btnGomme.addActionListener(e -> drawingPanel.setCurrentShape("Gomme"));

        // Pour la couleur on fait appelle à JcolorChooser (incroyable gain de temps)

        btnColorChooser.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Choisir une couleur", drawingPanel.getCurrentColor());
            if (newColor != null) {
                drawingPanel.setCurrentColor(newColor);
            }
        });

        //ajout de la toolbar au panel, mais en vrai peu importe la direction ça prendra la place qu'il faut
        add(toolBar, BorderLayout.SOUTH);
    }
}