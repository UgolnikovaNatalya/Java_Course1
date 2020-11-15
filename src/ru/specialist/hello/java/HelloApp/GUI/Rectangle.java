package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class Rectangle extends AbstractShape {

    // **************** Fields **********************

    protected int width;
    protected int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    // **************** Constructors ****************

    public Rectangle() {
    }

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    // **************** Methods *********************

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.drawRect(x, y, width, height);
        g.setColor(oldColor);
    }

    @Override
    public final double getSquare() {
        return width * height;
    }

    @Override
    public final double getPerimeter() {
        return (width + height) * 2;
    }

    // **************** Cast to String **************

    @Override
    public String toString() {
        return super.toString()
                + ", width=" + width
                + ", height=" + height
                + '}';
    }
}
