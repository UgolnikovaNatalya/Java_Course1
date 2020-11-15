package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class FillOval extends Oval {

    // **************** Constructors ****************

    public FillOval() {
    }

    public FillOval(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
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

