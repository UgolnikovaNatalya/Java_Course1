package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class FillCircle extends Circle {

    // ***************** Constructors ******************

    public FillCircle() {
    }

    public FillCircle(Color color, int x, int y, int r) {
        super(color, x, y, r);
    }

    // **************** Methods *********************

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(x - width / 2, y - height / 2, width, height);
        g.setColor(oldColor);
    }

    @Override
    public boolean isFill() {
        return true;
    }
}

