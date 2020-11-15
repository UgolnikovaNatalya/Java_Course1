package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public abstract class AbstractShape {

    // **************** Fields **********************

    public Color color;
    public int x;
    public int y;

    // **************** Constructors ****************

    public AbstractShape() {
    }

    public AbstractShape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // **************** Methods *********************

    public abstract void draw(Graphics g);

    public double getPerimeter() {
        return 0.0;
    }

    public double getSquare() {
        return 0.0;
    }

    public boolean isFill() {
        return false;
    }

    // **************** Cast to String **************

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{"
                + "color=" + color
                + ", x=" + x
                + ", y=" + y;
    }

}


