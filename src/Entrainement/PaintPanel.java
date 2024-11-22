package Entrainement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel
{

    class Shape
    {
        public int xS, yS;
        public Color c;
        Shape(int x, int y)
        {
            this.xS = x; this.yS = y;
        }
    }
    class Rectangle extends Shape {
        public int xS, yS;
        public Color color;
        Rectangle(int x, int y) {
            super(x, y);
        }
    }

    private ArrayList<Shape> shapes;

    PaintPanel()
    {
        shapes = new ArrayList<Shape>();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        for (Shape s: this.shapes)
            g.drawRect(s.xS, s.yS, 100, 50);
        this.repaint();
    }

    public void setClick(int x, int y)
    {
        shapes.add(new Shape(x, y));
    }


}