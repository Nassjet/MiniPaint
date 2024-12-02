package RealProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe DrawingPanel qui permet de dessiner des formes diverses telles que des
 * carrés, des rectangles, des triangles, des cercles, des lignes à main levée, et une gomme pour effacer.
 */
public class DrawingPanel extends JPanel {
    private Color color;  // Stockage pour la couleur actuelle
    private int startX, startY, currentX, currentY; // Positions de la souris (début et actuelle)
    private String currentShape = "Crayon"; // Forme par défaut
    private boolean drawingInProgress = false;  // Indique si un dessin est en cours
    private static final int ERASE_RADIUS = 20; // Rayon de la gomme

    /**
     * Constructeur de la classe DrawingPanel.
     *
     * @param targetWidth  La largeur cible du JPanel.
     * @param targetHeight La hauteur cible du JPanel.
     */
    public DrawingPanel(int targetWidth, int targetHeight) {
        super();
        setPreferredSize(new Dimension(targetWidth, targetHeight));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);

        color = Color.BLACK; // Initialisation par défaut de la couleur

        MouseAdapter ma = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                if (currentShape.equals("Gomme")) {
                    erase(e.getX(), e.getY());
                } else {
                    drawingInProgress = true;
                    if (currentShape.equals("Crayon")) {
                        currentX = startX;
                        currentY = startY;
                    }
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentShape.equals("Crayon")) {
                    Graphics g = getGraphics();
                    g.setColor(color);
                    g.drawLine(currentX, currentY, e.getX(), e.getY());
                    g.dispose();
                    currentX = e.getX();
                    currentY = e.getY();
                } else if (currentShape.equals("Gomme")) {
                    erase(e.getX(), e.getY());
                } else {
                    currentX = e.getX();
                    currentY = e.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawingInProgress = false;
                if (!currentShape.equals("Crayon") && !currentShape.equals("Gomme")) {
                    drawShape(getGraphics(), startX, startY, currentX, currentY);
                }
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    /**
     * Définit la forme actuelle à dessiner ou l'outil à utiliser.
     *
     * @param shape Le type de forme ou d'outil (ex : "Carre", "Rectangle", "Triangle", "Crayon", "Gomme").
     */
    public void setCurrentShape(String shape) {
        this.currentShape = shape;
    }

    /**
     * Définit la couleur actuelle pour le dessin.
     *
     * @param color La couleur à utiliser pour dessiner.
     */
    public void setCurrentColor(Color color) {
        this.color = color;
    }

    /**
     * Obtient la couleur actuelle utilisée pour le dessin.
     *
     * @return La couleur actuelle.
     */
    public Color getCurrentColor() {
        return this.color;
    }

    /**
     * Efface une section du dessin en traçant un cercle de couleur de fond.
     *
     * @param x La position en x du centre de la gomme.
     * @param y La position en y du centre de la gomme.
     */
    private void erase(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(getBackground());  // La gomme dessine avec la couleur de fond (efface)
        g.fillOval(x - ERASE_RADIUS, y - ERASE_RADIUS, ERASE_RADIUS * 2, ERASE_RADIUS * 2);
        g.dispose();
    }

    /**
     * Dessine une forme à partir des coordonnées commencées jusqu'à celle relâchées.
     *
     * @param g      L'objet Graphics pour dessiner.
     * @param startX La position de départ en x.
     * @param startY La position de départ en y.
     * @param endX   La position de fin en x.
     * @param endY   La position de fin en y.
     */
    private void drawShape(Graphics g, int startX, int startY, int endX, int endY) {
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int width = Math.abs(endX - startX);
        int height = Math.abs(endY - startY);

        g.setColor(color);

        switch (currentShape) {
            case "Carre":
                g.fillRect(x, y, width, width);
                break;
            case "Rectangle":
                g.fillRect(x, y, width, height);
                break;
            case "Triangle":
                // Calcul des coordonnées des trois sommets du triangle
                int[] xPoints = {startX, endX, (startX + endX) / 2};
                int[] yPoints = {startY, startY, endY};

                // Création du triangle et dessin
                Polygon triangle = new Polygon(xPoints, yPoints, 3);
                g.fillPolygon(triangle);
                break;

            case "Cercle":
                g.fillOval(x, y, width, height);
                break;
        }

        g.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawingInProgress && !currentShape.equals("Crayon") && !currentShape.equals("Gomme")) {
            g.setColor(color);
            drawShape(g, startX, startY, currentX, currentY);
        }
    }
}