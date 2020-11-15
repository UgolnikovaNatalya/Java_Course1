package ru.specialist.hello.java.HelloApp;

public class TestBox {
    public static void main(String[] args) {

        Box b1 = new Box(1, 2, 3);
//        b1.width = 1;
//        b1.height = 2;
//        b1.length = 3;
        printBox("b1", b1);

        Box b2 = new Box(10);
//        b2.width = b2.height = b2.length = 10;
        printBox("b2", b2);

        Box b3 = new Box(Box.TYPE_SIZE_MEDIUM);
        printBox("b3", b3);

        Box b4 = new Box(Box.TypeSize.Large);
        printBox("b4", b4);

        Box b5 = new Box();
        printBox("b5", b5);

        Box.defaultSize = 4;

        Box b6 = new Box(Box.TypeSize.Default);
        printBox("b6", b6);
        System.out.println("b5 = " + b5);

        System.out.println("defaultSize = " + Box.defaultSize);
        System.out.println("defaultSize = " + b1.defaultSize);
        System.out.println("defaultSize = " + b5.defaultSize);
        b1.defaultSize = 33;
        System.out.println("defaultSize = " + Box.defaultSize);
        System.out.println("defaultSize = " + b1.defaultSize);
        System.out.println("defaultSize = " + b5.defaultSize);

        System.out.println("volume(5, 6, 9) = " + (new Box(5, 6, 9)).getVolume());
        System.out.println("volume(5, 6, 9) = " + Box.volume(5, 6, 9));

        Box b7 = Box.createStandardBox(Box.TypeSize.Small); // fabric method
        printBox("b7", b7);

        // Equals
        System.out.println("b1 == b7 => " + (b1 == b7));
        System.out.println("b1.equals(b7) => " + b1.equals(b7));
        System.out.println("b1.equals(b2) => " + b1.equals(b2));
        b2.setWidth(1);
        b2.setHeight(2);
        b2.setLength(3);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b1.equals(b2) => " + b1.equals(b2));

        //Test BoxGen

        BoxGen<Integer> bg1 = new BoxGen<>(1,2,3);
        printBox("bg1", bg1);

        BoxGen<Float> bg2 = new BoxGen<>(1.5f, 2.5f, 3.5f);
        printBox("bg2",bg2);

        BoxGen<Long> bg3 = new BoxGen<>(10L, 25L, 35L);
        printBox("bg3",bg3);

        BoxGen<Double> bg4 = new BoxGen<>();
        printBox("bg4",bg4);

//        BoxGen<String> bg5 = new BoxGen<>("ширина", "высота", "длина");
//        printBox("bg4",bg4);
        BoxGen <Byte> bg5 = new BoxGen<>();
        bg5.setWidth((byte)1);

        BoxGen bg6 = new BoxGen<>(Double.valueOf(1), Byte.valueOf((byte) 2), Long.valueOf(3));
        printBox("bg6", bg6);

        //JDK 10+
        var bg7 = new BoxGen<Long>(); //BoxGen <Long>
        var bg8 = new BoxGen<>(); // BoxGen <Number>
        var i = 1; // int
        var l= 123L; //long
        var s = "Hello"; // String
//        var v;    так писать нельзя, тк невозможно определить тип данных
        var bg9 = BoxGen.createStandardBox(BoxGen.TypeSize.Medium);

    }

    private static void printBox(String name, BoxGen box) {
        System.out.println(name + " = " + box.toString());
        System.out.println(name + ".perimeter = " + box.getPerimeter());
        System.out.println(name + ".squareSurface = " + box.getSquareSurface());
        System.out.println(name + ".volume = " + box.getVolume());
    }
    private static void printBox(String name, Box box) {
        System.out.println(name + " = " + box.toString());
        System.out.println(name + ".perimeter = " + box.getPerimeter());
        System.out.println(name + ".squareSurface = " + box.getSquareSurface());
        System.out.println(name + ".volume = " + box.getVolume());
    }
}

