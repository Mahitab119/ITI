package multipleline;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.function.Consumer;

public class MultipleLine extends Applet implements MouseListener, MouseMotionListener {

    Point pnt1 = new Point(); //global
    Point pnt2 = new Point();
    ArrayList<Points> p = new ArrayList<Points>();

    class Points {

        Point p1 = new Point();
        Point p2 = new Point();

        Points(Point pa, Point pb) {
            p1 = pa;
            p2 = pb;
        }

        void setPoint2(Point ptt) {
            p2 = ptt;
        }
    }

    public void init() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //global
        pnt1 = e.getPoint();
        //constructor	
        Points po = new Points(pnt1, pnt2);
        //arraylist
        p.add(po);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        Points pp = p.get(p.size() - 1);
        pp.setPoint2(e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Points pp = p.get(p.size() - 1);
        pp.setPoint2(e.getPoint());
        pnt2 = e.getPoint();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        
        /* for(Points pt:p){
	 g.drawLine(pt.p1.x,pt.p1.y,pt.p2.x,pt.p2.y);
		 }*/
         
        p.forEach((Points pt) -> {
            g.drawLine(pt.p1.x, pt.p1.y, pt.p2.x, pt.p2.y);
        });

    }
}
