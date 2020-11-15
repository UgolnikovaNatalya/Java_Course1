package ru.specialist.hello.java.HelloApp;

import java.math.BigInteger;
import java.util.Random;

/**
 * Мой первый класс на языке Java
 * @author Igor Morenko (imorenko@yandex.ru)
 * @version 1.0
 * @since 1.8
 * @see ПриветМир
 */
public class HelloApp {

    /**
     * Главный метод программы
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        HelloApp app = new HelloApp();

        // TODO code application logic here
        System.out.println("Hello World!");
        System.out.println("Привет Мир!");
        System.out.println(sayHello("Igor Morenko"));
        System.out.println(app.скажиПривет("Игорь Моренко"));

        // literal integer
        System.out.println(10);   // 10 dec
        System.out.println(010);  // 8 oct
        System.out.println(0x10); // 16 hex
        System.out.println(0b10); // 2 bin

        // wraper
        int i = Integer.parseInt("12345");
        System.out.println(i);
        System.out.println(Integer.toString(i));
        System.out.println(Integer.toString(i, 20)); // 20-ричная система исчисления
        System.out.println(Integer.toHexString(i));

        int j = 0;
        System.out.println("j = " + j);

        // приведение типов
        byte b1 = 1;
        short s1 = -10; // неявное преобразование (implicit)
        short s2 = b1;
        b1 = (byte) s1; // явное преобразование (приведение типа) (explicit)
        char c1 = (char) s1; // signed -> unsigned
        System.out.println("c1 = " + c1);
        System.out.println("c1 = " + (int)c1);

        byte b2 = 2;
        byte b3 = (byte) (b1 + b2); // byte + byte = int -> byte
        short s3 = (short) (s1 - s2); // short - short = int -> short
        i = b1 + b2; // int -> int

        long l1 = 123_456_789_012L;
        i = (int) (l1 * b1); // long -> int
        long l2 = l1 * b1; // long -> long

        j = 1_934_567_890;

        i = j + j;
        System.out.println("i = " + i);
        long l = (long)j + j; // long + int = long -> long
        System.out.println("l = " + l);
        l = (long)(j + j); // int + int = int -> long
        System.out.println("l = " + l);

        java.math.BigInteger bi1 = new BigInteger("1234567890123456");
        java.math.BigInteger bi2 = new BigInteger("234567890123456");
        BigInteger bi3 = bi1.add(bi2); //bi1 + bi2;
        System.out.println("bi3 = " + bi3);

        java.math.BigDecimal bd;

        float f1 = 0.5f;
        double d1 = 1.5;

        float f2 = i + f1; // int + float = float -> float
        f2 = (float) (i + d1); // int + double = double -> float


        i = 10;
        System.out.println("i++ = " + (i++)); // 10
        System.out.println("i = " + i);       // 11
        i = 10;
        System.out.println("++i = " + (++i)); // 11
        System.out.println("i = " + i);       // 11

        i = 10;
        System.out.println("i-- = " + (i--)); // 10
        System.out.println("i = " + i);       // 9
        i = 10;
        System.out.println("--i = " + (--i)); // 9
        System.out.println("i = " + i);       // 9

        i = 10;
        j = 15;
        i = i + j;
        i += j;

        // bit operation
        b1 = 0b0100_1111;
        b2 = (byte) ~b1;  // ~byte -> int => byte
        System.out.println("\n   b1 = " + byteToBinaryString(b1));
        System.out.println("  ~b1 = " + byteToBinaryString(b2));

        System.out.println("   b1 = " + intToBinaryString(b1));
        System.out.println("  ~b1 = " + intToBinaryString(b2));

        b1 = 0b00101101;
        b2 = 0b01001111;
        b3 = (byte) (b1 & b2); // byte & byte -> int => byte
        System.out.println("\n   b1 = " + byteToBinaryString(b1));
        System.out.println("   b2 = " + byteToBinaryString(b2));
        System.out.println("b1&b2 = " + byteToBinaryString(b3));

        b3 = (byte) (b1 | b2); // byte & byte -> int => byte
        System.out.println("\n   b1 = " + byteToBinaryString(b1));
        System.out.println("   b2 = " + byteToBinaryString(b2));
        System.out.println("b1|b2 = " + byteToBinaryString(b3));

        b3 = (byte) (b1 ^ b2); // byte & byte -> int => byte
        System.out.println("\n   b1 = " + byteToBinaryString(b1));
        System.out.println("   b2 = " + byteToBinaryString(b2));
        System.out.println("b1^b2 = " + byteToBinaryString(b3));

        {
            i = 12345;
            int magicNumber = 0xA5A55A5A; // key encode/decode
            System.out.println("\ni = " + i + " \t" + intToBinaryString(i));
            System.out.println("m = " + magicNumber + " " + intToBinaryString(magicNumber));
            i = i ^ magicNumber; // encode (encrypt)
            System.out.println("i = " + i + " " + intToBinaryString(i));
            i ^= magicNumber; // decode (decrypt)
            System.out.println("i = " + i + " \t" + intToBinaryString(i));
        }
//        System.out.println("magicNumber = " + magicNumber);

//        System.out.println("i = " + Integer.toString(i, 3)); // троичная система исчисления

        System.out.println(("1" + 1) + 1); // 111
        System.out.println((1 + 1) + "1");  // 21

        // !  <=> -, + (знак число) унарная операция
        // AND <=> *, /, %
        // OR  <=> +, -

        // битовые операторы сдвига:
        // << - сдвиг влево,
        // >> - знаковый сдиг вправо,
        // >>> - беззнаковый сдвиг вправо
        i  = 1;
        System.out.println("\n   i = " + intToBinaryString(i) + " " + i);
        System.out.println("i<<2 = " + intToBinaryString(i << 2) + " " + (i << 2));
        System.out.println("i<<8 = " + intToBinaryString(i << 8) + " " + (i << 8));
        i = 12345;
        System.out.println("\n   i = " + intToBinaryString(i) + " " + i);
        System.out.println("i<<2 = " + intToBinaryString(i << 2) + " " + (i << 2)); // = i * 4 (2^2)
        System.out.println("i<<8 = " + intToBinaryString(i << 8) + " " + (i << 8)); // = i * 256 (2^8)
        System.out.println("i<<20= " + intToBinaryString(i << 20) + " " + (i << 20));

        System.out.println("\n   i = " + intToBinaryString(i) + " " + i);
        System.out.println("i>>2 = " + intToBinaryString(i >> 2) + " " + (i >> 2)); // = i / 4
        System.out.println("i>>8 = " + intToBinaryString(i >> 8) + " " + (i >> 8)); // = i / 256
        System.out.println("i>>20= " + intToBinaryString(i >> 20) + " " + (i >> 20));

        i = -12345;
        System.out.println("\n   i = " + intToBinaryString(i) + " " + i);
        System.out.println("i>>2 = " + intToBinaryString(i >> 2) + " " + (i >> 2)); // = i / 4
        System.out.println("i>>8 = " + intToBinaryString(i >> 8) + " " + (i >> 8)); // = i / 256
        System.out.println("i>>20= " + intToBinaryString(i >> 20) + " " + (i >> 20));

        System.out.println("\n    i = " + intToBinaryString(i) + " " + i);
        System.out.println("i>>>2 = " + intToBinaryString(i >>> 2) + " " + (i >>> 2));
        System.out.println("i>>>8 = " + intToBinaryString(i >>> 8) + " " + (i >>> 8));
        System.out.println("i>>>20= " + intToBinaryString(i >>> 20) + " " + (i >>> 20));

        f1 = 12345.67f;
        System.out.println("f1 = " + intToBinaryString(Float.floatToIntBits(f1)));
        d1 = 12345.67;
        System.out.println("d1 = " + longToBinaryString(Double.doubleToLongBits(d1)));
        System.out.println("d1 = " + longToBinaryString2(Double.doubleToLongBits(d1)));

        // Logical operator: &&, ||, !, ==, !=, <, >, <=, >=

        boolean lb = !(i == 0);// <=> i != 0
        System.out.println("lb = " + lb);

        String str1 = null; //"Igor";
//        lb = (str1 != null) & (str1.length() == 4); // bool & bool => bool
        lb = (str1 != null) && (str1.length() == 4);
//        lb = (str1.length() == 4) && (str1 != null);
        System.out.println("lb = " + lb);

        // условия
        boolean lb1 = false, lb2 = true;
        if (lb1 == lb2) // сравнение
            System.out.println("lb1 == lb2");
        else
            System.out.println("lb1 != lb2");
        if (lb1 = lb2) // warning!!!!!!!!!!! - присваивание
            System.out.println("lb1 == lb2!!!");
        if (b1 == b2)
            System.out.println("b1 == b2!!!");
        if ((b1 = b2) == 1)
            System.out.println("b1=b2 == 1!!!");

        b1 = b2 = b3 = 0;

//        if (1 = b1) System.out.println(""); // C/C++

        if (lb1 == lb2) b1 = 0; else b1 = 1;
        if (lb1 == lb2) {
            // true
            b1 = 0;
        } else {
            // false
            b1 = 1;
        }

//        String name = "Leonidovich";
//        if (name.equals("Igor") && name.length() < 10)
//            System.out.println("name '" + name + "' => Имя");
//        else if (name.equals("Morenko"))
//            System.out.println("name '" + name + "' => Фамилия");
//        else if (name.equals("Leonidovich"))
//            System.out.println("name '" + name + "' => Отчество");

        i = (int) (Math.random() * 6);
        i = new Random().nextInt(6);
        System.out.println("#### if-else-if ####");
        if (i == 0)
            System.out.println("Zero " + i);
        else if (i == 1)
            System.out.println("One " + i);
        else if (i == 2 || i == 3)
            System.out.println("Two or Three " + i);
        else
            System.out.println("Great Three " + i);

        System.out.println("#### switch ####");
        switch (i) {
            case 0:
                System.out.println("Zero " + i);
                break;
            case 1:
                System.out.println("One " + i);
                break;
            case 2:
            case 3:
                System.out.println("Two or Three " + i);
                break;
            default:
                System.out.println("Great Three " + i);
                break;
        }
        switch (i) {
            case 0: System.out.println("Ноль " + i); break;
            case 1: System.out.println("Один " + i); break;
            case 2: case 3: System.out.println("Два или Три " + i); break;
//            default: System.out.println("Больше Трех " + i);
        }

        System.out.println("#### rule switch ####");
        // JDK11+ (11,12,13 - --enable-preview, 14 - release)
        System.out.println(
                switch (i) {
                    case 0 -> "Zero ";
                    case 1 -> "One ";
                    case 2, 3 -> "Two or Three ";
                    default ->  "Great Three ";
                } + i + " // rule switch"
        );

        String text = "Unknown";
        if ((i % 2) == 0)
            text = "Чет";
        else
            text = "Нечет";
        System.out.println("text = " + text);

        text = (i % 2) == 0 ? "Even" : "Odd";
        System.out.println("text = " + text);

        b1 = 1;
        b2 = 3;
        b3 = b1 > b2 ? b1 : b2; // max(b1, b2)
        System.out.println("b3 = " + b3);
        b3 = (byte) Math.max(b1, b2);

        i = (int) (Math.random() * 200 - 100);//  -100..100
        i = new Random().nextInt(200) - 100;

        d1 = 0.445367201;
        double d2 = 0.4453672;
        if (d1 == d2)
            System.out.println("d1 == d2");
        else
            System.out.println("d1 != d2");

        if (Math.abs(d1 - d2) < 1e-6)
            System.out.println("d1 == d2");
        else
            System.out.println("d1 != d2");

        Double dd1 = d1;
        Double dd2 = d2;
        if (dd1.equals(dd2))
            System.out.println("dd1 == dd2");
        else
            System.out.println("dd1 != dd2");

        System.out.println(1.0/0.0); // +inf = 0x7ff0000000000000L
        System.out.println(-1.0/0.0); // -inf = 0xfff0000000000000L
        System.out.println(0.0/0.0);  // nan - Not-a-Number = 0x7ff8000000000000L

        int month = new Random().nextInt(11) + 1; // 1..12
        int days = getMonthDays(month);
        System.out.printf("days of %d month = %d\n", month, days);

        int year = 2000 + new Random().nextInt(25); // 2000..2025
        month = 2;
        days = getMonthDays(month, year);
        System.out.printf("days of %d month and %d year = %d\n", month, year, days);

        // loop
        System.out.println("#### while ####");
        i = 0;
        while (i < args.length)
            System.out.println(args[i++]);
//        i = 0;
        while (i < args.length) {
            System.out.println(args[i]);
            i++;
        }

        System.out.println("#### do-while (repeat-until) ####");
        if (args.length > 0) {
            i = 0;
            do
                System.out.println(args[i++]);
            while (i < args.length);
            i = 0;
            do {
                System.out.println(args[i]);
                i++;
            } while (i < args.length);
        }

        System.out.println("#### for ####");
        for (int idx = 0; idx < args.length; idx++)
            System.out.println(args[idx]);

        for (int x = 4, y = 5; x < 5; x++, y -= 2)
            System.out.printf("[%d, %d]\n", x, y);

        i = 0;
        for (; i < 5;) System.out.println(i++);

        // JDK5+
        System.out.println("#### foreach ####");
        for (String arg : args) // array or collection
            System.out.println(arg);

        System.out.println("#### break, continue ####");
        for (int k = 0; k < 10; k++) {
            if (k > 5) break;
            if (k % 2 != 0) continue;
            System.out.println(k);
        }

        // JDK5+
//        boolean flagStop = false, flagSkip = false;
        yearLoop: for (year = 2015; year <= 2025; year++) {
            monthLoop: for (month = 1; month <= 12; month++) {
                if (year != 2020 && month > 2) continue yearLoop;
                System.out.printf("%d.%02d => %d days\n", year, month, getMonthDays(month, year));
                if (year == 2020 && month == 7) break yearLoop;
            }
        }

        Integer x = 1; // boxing
        Integer y = 2;
        x = Integer.valueOf(1);//new Integer(1);
        Integer z = x + y; // auto unboxing + boxing -  JDK5+
        z = Integer.valueOf(x.intValue() + y.intValue());


//        System.exit(-1);
    }

    /**
     * Метод создания приветственного сообщения
     * @param name имя приветствуемого
     * @return приветственное сообщение
     */
    public static String sayHello(String name) {
        return "\nHello\t\"" + name + "\"!";
    }

    // classic switch
    private static int getMonthDays1(int month) {
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = 28;
        }
        return days;
    }

    // switch lambda
    protected static int getMonthDays2(int month) {
        int days = 0;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 4, 6, 9, 11 -> days = 30;
            case 2 -> days = 28;
        }
        return days;
    }

    // rule switch
    static int getMonthDays(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
    }

    // rule switch JDK14+
    public static int getMonthDays(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
//            case 2 -> year % 4 == 0 ? 29 : 28;
            case 2 -> {
                if (year % 4 == 0)
                    yield 29;
                else
                    yield 28;
            }
            default -> 0;
        };
    }

    /**
     * Метод создания приветственного сообщения
     * @param имя имя приветствуемого
     * @return приветственное сообщение
     */
    public final String скажиПривет(String имя) {
        return "Привет " + имя + "!";
    }

    public static String byteToBinaryString(byte x) {
        char[] buffer = new char[Byte.SIZE];
        for (int i = 0, mask = 0x80; i < buffer.length; i++, mask >>>= 1) {
            buffer[i] = (x & mask) == 0 ? '0' : '1';
        }
        return new String(buffer);
    }

    public static String intToBinaryString(int x) {
        char[] buffer = new char[Integer.SIZE];
        for (int i = 0, mask = 0x80000000; i < buffer.length; i++, mask >>>= 1) {
            buffer[i] = (x & mask) == 0 ? '0' : '1';
        }
        return new String(buffer);
    }

    public static String longToBinaryString(long x) {
        char[] buffer = new char[Long.SIZE];
        long mask = 0x8000000000000000L;
        for (int i = 0; i < buffer.length; i++, mask >>>= 1) {
            buffer[i] = (x & mask) == 0 ? '0' : '1';
        }
        return new String(buffer);
    }

    public static String longToBinaryString2(long x) {
        char[] buffer = new char[Long.SIZE];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (x >>> (Long.SIZE - i - 1) & 1) == 0 ? '0' : '1';
        }
        return new String(buffer);
    }

}
