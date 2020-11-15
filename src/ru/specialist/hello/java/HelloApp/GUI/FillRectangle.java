package ru.specialist.hello.java.HelloApp.GUI;

import java.awt.*;

public class FillRectangle extends Rectangle {

    // **************** Constructors ****************

    public FillRectangle() {
    }

    public FillRectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    // **************** Methods *********************

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(oldColor);
    }

    @Override
    public boolean isFill() {
        return true;
    }
}
