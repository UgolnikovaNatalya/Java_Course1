package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.Color;

public class Circle extends Oval {
    // ***************** Constructors ******************

    public Circle() {
    }

    public Circle(Color color, int x, int y, int r) {
        super(color, x, y, 2 * r, 2 * r);
    }

    // ***************** Pseudo Properties ******************

    public int getRadius() {
        return width / 2;
    }

    public void setRadius(int r) {
        width = height = 2 * r;
    }

    // ***************** Properties ******************

    @Override
    public void setHeight(int height) {
        this.width = this.height = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = this.height = width;
    }

}

