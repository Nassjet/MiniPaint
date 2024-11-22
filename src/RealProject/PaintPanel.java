package RealProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintPanel extends JPanel {
    private static final int STROKE_SIZE = 8;
    private Color color;
    private int x, y;

    public PaintPanel(int targetWidth, int targetHeight) {
        super();
        setPreferredSize(new Dimension(targetWidth, targetHeight));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);

        color = Color.BLACK; // Initialisation par défaut de la couleur

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(x, y, STROKE_SIZE, STROKE_SIZE);
                g.dispose();

                System.out.println("CLICKED");
                System.out.println(e.getX());
                System.out.println(e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Optionnel : gestion du glisser
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Optionnel : actions à effectuer lors de la relâche de la souris
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }
}