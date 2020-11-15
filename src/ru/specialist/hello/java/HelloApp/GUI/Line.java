package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class Line extends AbstractShape {

    // **************** Fields **********************

    public int x2;
    public int y2;

    // **************** Constructors ****************

    public Line() {
    }

    public Line(Color color, int x1, int y1, int x2, int y2) {
        super(color, x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    // **************** Methods *********************

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.drawLine(x, y, x2, y2);
        g.setColor(oldColor);
    }

    public double getLineSize() {
        return Math.hypot(x2 - x, y2 - y);
//        return Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
    }

    // **************** Cast to String **************

    @Override
    public String toString() {
        return super.toString()
                + ", x2=" + x2
                + ", y2=" + y2
                + '}';
    }
}


