package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class Text extends AbstractShape {

    // **************** Fields **********************

    public String text;

    // **************** Constructors ****************

    public Text() {
    }

    public Text(Color color, int x1, int y1, String text) {
        super(color, x1, y1);
        this.text = text;
    }

    // **************** Methods *********************

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.drawString(text, x, y);
        g.setColor(oldColor);
    }

    // **************** Cast to String **************

    @Override
    public String toString() {
        return super.toString()
                + ", text=" + text
                + '}';
    }
}

