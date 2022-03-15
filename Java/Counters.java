package counters;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counters extends Applet {

    int count;
    Button Btn1;
    Button Btn2;

    @Override
    public void init() {

        Btn1 = new Button("Increment");
        Btn1.addActionListener(new MyButtonListener());
        add(Btn1);

        Btn2 = new Button("Decrement");
        Btn2.addActionListener(new MyButtonListener2());
        add(Btn2);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Count now is:" + count, 50, 200);
    }

    class MyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            count++;
            repaint();
        }
    }

    class MyButtonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            count--;
            repaint();
        }
    }
}
