package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class FillSquare extends Square {

    // ***************** Constructors ******************

    public FillSquare() {
    }

    public FillSquare(Color color, int x, int y, int size) {
        super(color, x, y, size);
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

