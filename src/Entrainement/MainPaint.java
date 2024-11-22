package Entrainement;

import java.awt.GridLayout;

import javax.swing.JFrame;


public class MainPaint
{

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Java - Exo 01");
        window.setSize(1000, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// always add a "main panel" in the frame (default container)
        PaintPanel mainPanel = new PaintPanel();
// set the Layout Manager on the main panel
        mainPanel.setLayout(new GridLayout(1, 4));
        mainPanel.addMouseListener(new MousePaint(mainPanel));
        window.add(mainPanel);
        window.setVisible(true);
    }

}