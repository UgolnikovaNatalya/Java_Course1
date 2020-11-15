package ru.specialist.hello.java.HelloApp.GUI;


import java.awt.*;

public class Square extends Rectangle {

    // ***************** Constructors ******************

    public Square() {
    }

    public Square(Color color, int x, int y, int size) {
        super(color, x, y, size, size);
    }

    // ***************** Pseudo Properties ******************

    public int getSize() {
        return width;
    }

    public void setSize(int size) {
        width = height = size;
    }

    // ***************** Properties ******************

    @Override
    public void setHeight(int height) {
        this.width = this.height = height;
    }

    @Override
    public void setWidth(int width) {
//        this.width = this.height = width;
        super.setWidth(width);
        super.setHeight(width);
    }
}
