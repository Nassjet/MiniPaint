package Entrainement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePaint implements MouseListener
{
    private PaintPanel paint;

    public MousePaint(PaintPanel p) {this.paint = p;}

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("CLICKED");
        System.out.println(e.getX());
        System.out.println(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("PRESSED");
        System.out.println(e.getX());
        System.out.println(e.getY());
        this.paint.setClick(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("RELEASED");
        System.out.println(e.getX());
        System.out.println(e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("ENTERED");
        System.out.println(e.getX());
        System.out.println(e.getY());

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("EXITED");
        System.out.println(e.getX());
        System.out.println(e.getY());


    }

}