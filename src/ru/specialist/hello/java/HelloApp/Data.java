package ru.specialist.hello.java.HelloApp;

public class Data {
    // ************ Primitive **************

    // Integer
    byte b;     // size = 1 byte; -128..+127; default = 0
    short s;    // size = 2 byte; -32768..+32767 (signed)
    int i = 123;// size = 4 byte; -2147483648..+2147483647
    long l = 12_345_678_901L;  // size = 8 byte; - .... +

    // Real
    float f = 0.5f; // size = 4 byte
    double d = 0.5; // size = 8 byte

    // Character
    char c;   // size = 2 byte; 0..65535 (unsigned); UTF-16

    // Logical
    boolean lb; // true, false; default: false

    // *************** References ******************

    static String str = "Hello World!"; // field of class
    Object obj = null; // default: null
//    HelloApp app = new HelloApp(); // field of instance class

    // Wrapper for Primitive type
    Byte bb;
    Short ss;
    Integer ii;
    Long ll;

    Float ff;
    Double dd;

    Character cc;

    Boolean lbb;

    {
        // Functions
//        HelloApp.getMonthDays2(1); // protected static - function
//        HelloApp.getMonthDays(3);  // package static
//        HelloApp.getMonthDays(2, 2020); // public static

//        new HelloApp().скажиПривет("World"); // not static
    }
}
