package ru.specialist.hello.java.HelloApp.GUI;


import javax.swing.*;
import java.awt.*;

public class TestGUI extends JComponent {

    public static void main(String[] args) {
        System.out.println("@@@@ main()");

        JFrame frame = new JFrame("Test GUI");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestGUI());
        frame.setVisible(true);
    }

    private final AbstractShape[] shapes = new AbstractShape[20];

    public TestGUI() {
        System.out.println("@@@@ TestGUI.<init>()");
        // initialize shape array
        shapes[0] = new Line(Color.BLUE, 10, 10, 100, 60);
        shapes[1] = new Rectangle(Color.GREEN, 50, 200, 120, 90);
        shapes[2] = new FillRectangle(Color.YELLOW, 60, 210, 100, 70);
        shapes[3] = new Oval(Color.CYAN, 250, 200, 120, 90);
        shapes[4] = new FillOval(Color.MAGENTA, 250, 200, 100, 70);
        shapes[5] = new Text(Color.RED, 50, 20, "Hello World!");
        shapes[6] = new Circle(Color.BLACK, 450, 200, 60);
        shapes[7] = new FillCircle(Color.LIGHT_GRAY, 450, 200, 50);
        shapes[8] = new Square(Color.BLACK, 450, 400, 120);
        shapes[9] = new FillSquare(Color.LIGHT_GRAY, 460, 410, 100);

        // Calculate Statistics
        calculateStatistics();
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("@@@@ paint()");
        for (AbstractShape shape : shapes) {
            if (shape == null) continue; // skip

            System.out.println("Draw: " + shape);
            shape.draw(g);
        }
    }

    private void calculateStatistics() {
        System.out.println("@@@@ calculateStatistics()");
        // TODO: count, cntLine, cntRect, cntOval, cntText, totalSquare
        int count = 0, cntLine = 0, cntRect = 0, cntOval = 0, cntText = 0, cntFill = 0;
        double totalSquare = 0.0;

        for (AbstractShape shape : shapes) {
            if (shape == null) continue; // skip
            System.out.println("Analize: " + shape);
            count++;

            totalSquare += shape.getPerimeter() * 1; // m*m
//            if (shape instanceof FillOval || shape instanceof FillRectangle || shape instanceof FillCircle || shape instanceof FillSquare) {
//            if (shape.getClass().getSimpleName().startsWith("Fill")) {
            if (shape.isFill()) {
                System.out.println("ФИГУРА ЗАКРАШЕННАЯ");
                cntFill++;
                totalSquare += shape.getSquare(); // m*m
            }

            if (shape instanceof Line /*line*/) { // JDK14++ (--enable-preview)
                cntLine++;
                final Line line = (Line) shape;
                totalSquare += line.getLineSize();
            } else if (shape instanceof Rectangle) {
                cntRect++;
            } else if (shape instanceof Oval) {
                System.out.println("OVAL!!!!");
                cntOval++;
            } else if (shape instanceof Text) {
                cntText++;
            }

            if (shape.getClass() == Oval.class) {
                System.out.println("ОВАЛ!!!!");
            }

        }
        System.out.println("count = " + count);
        System.out.println("cntLine = " + cntLine);
        System.out.println("cntRect = " + cntRect);
        System.out.println("cntOval = " + cntOval);
        System.out.println("cntText = " + cntText);
        System.out.println("cntFill = " + cntFill);
        System.out.println("totalSquare = " + totalSquare);
    }

}

