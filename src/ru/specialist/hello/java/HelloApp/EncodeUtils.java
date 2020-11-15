package ru.specialist.hello.java.HelloApp;

import java.util.Random;

public class EncodeUtils {
    /**
     * Метод кодирования массива
     * @param array ссылка на массив
     * @param magicNumber ключ для кодирования/декодирования
     */
    public static void arrayEncode(int[] array, int magicNumber /* local variable */) {
//        array = new int[20]; // ref on new array
        // XOR
//        for (int i = 0; i < array.length; i++) {
////            magicNumber = ~magicNumber;
//            System.out.println(HelloApp.intToBinaryString(magicNumber));
//            magicNumber = cyclicShiftLeft(magicNumber);
//            array[i] ^= magicNumber;
//        }
        // 0101001010
        // 1010010100
        // 0100101001
        // 1001010010
        arrayEncode(array, magicNumber, 0);
    }

    public static void arrayEncode(int[] array, int magicNumber, int algoritm) {
        for (int i = 0; i < array.length; i++) {
            switch (algoritm) {
                case 1: magicNumber = ~magicNumber; break;
                case 2: magicNumber = cyclicShiftLeft(magicNumber);
                case 3: magicNumber = cyclicShiftRight(magicNumber);
            }
            array[i] ^= magicNumber;
        }
    }

    public static void arrayEncode(byte[] array, byte magicNumber, int algoritm) {
    }

    public static void main(String[] args) {
        int[] array = new int[10]; // ref on object Array int
        int magicNumber = 0xA5A55A5A;

        // fill array random value -100..100
        fillArrayRandom(array);
        array = fillArrayRandom(10);
        // print array
        printArray(array);
        // encode Array
        arrayEncode(array, magicNumber, 0);
        // print array
        printArray(array);
        // decode array
        arrayEncode(array, magicNumber);
        // print array
        printArray(array);
    }

    private static final String BASE64_CHARS = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzu0123456789+/";
    // length = size * 8/6 = size * 1.4
    public static String base64Encode(byte[] data) {
        // 0101010 0101010 01010101 10101010
        // 01010 100101 010010 101011 010101 0
        //   g     H       9      +     =
        return "";
    }

    public static byte[] base64Decode(String data) {
        return null;
    }

    private static void fillArrayRandom(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(200) - 100;
        }
    }

    // Overload
    private static int[] fillArrayRandom(int n) {  // createArrayRandom
        int array[] = new int[n];
        fillArrayRandom(array);
        return array;
    }

    private static void printArray(int[] array) {
        System.out.print("Array: [ ");
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

    private static int cyclicShiftLeft(int magicNumber) {
        return (magicNumber << 1) | ((magicNumber >> 31) & 1);
    }

    private static int cyclicShiftRight(int magicNumber) {
        return (magicNumber >>> 1) | ((magicNumber & 1) << 31 );
    }
}

