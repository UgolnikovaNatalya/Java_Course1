package ru.specialist.hello.java.HelloApp;

import java.util.StringTokenizer;

public class HelloString {
    public static void main(String[] args) {

        String s1 = "Hello World!"; // LATIN1
        String s2 = new String("Hello World!");

        String s3 = s1 + s2;

        int l = "Привет".length(); // UTF16

        s3 = s1.concat(s2);

        System.out.println("s1 == s2 => " + (s1 == s2));
        System.out.println("s1 equals s2 => " + s1.equals(s2)); // !!!!!!
        System.out.println("s1 equals s2 => " + s1.equalsIgnoreCase(s2)); // !!!!!!

        String s4 = "Hello World!";
        System.out.println("s1 == s4 => " + (s1 == s4));

        System.out.println("s1 == Data.str => " + (s1 == Data.str));


        System.out.println("s1.intern == s2.intern => " + (s1.intern() == s2.intern()));

        System.out.println("s1 compareTo s2 => " + s1.compareTo(s2));
        System.out.println("s1 compareTo s2 => " + s1.compareToIgnoreCase(s2));

//        testPlus();
//        testConcat();
//        testStringBuilder();
        testStringBuffer();

        String text = "\tПлан экстренного реагирования был запущен после того,как 17 июля в населенном пункте выявили 16 'случаев' заражения.В \"Урумчи\" временно запретили людям массово собираться в одном месте.\n\r\t<<Местных>> жителей призвали не совершать необязательные поездки за пределы населенного пункта,а также обязали брать анализы у всех, кому все-таки требуется уехать. Отмечается, что будет также проведено бесплатное тестирование для всего города.\n\r";
        printByWord(text);
/*
План
экстренного
реагирования
...
города
words = xxx
*/
        printByWord(text);
        printByWord2(text);
        printByWord3(text);
        printByWord4(text);

        System.out.println("Вывод 12345 в строковом формате с ведущими нулями до 8 знаков");
        int x = 12345;
        System.out.println("X= " + String.format("%08d", x)); //этот метод очень медленныйб тк является универсальным.
        System.out.println("X= " + intToString(x, 8)); //будет работать быстрее, тк спец сделать под эту задачу
        //Проверить, что данное число заканчивается на 345
        System.out.println(intToString(x, 8).matches(".*345")); //matches - используется для regexp выражений
        System.out.println(((x%1000)==345));
        //123__
        System.out.println(Integer.toString(x).matches("123..")); //matches - используется для regexp выражений
        System.out.println(((x/100)==123));
        //*23__
        System.out.println(Integer.toString(x).matches(".*23..")); //matches - используется для regexp выражений
        System.out.println(((x/100) % 100 == 23));


    }

    /**
     * Метод вывода числа до необходимого количества символов с ведущими нулями
     * @param x число, которое вводит пользователь
     * @param n количество символов, которое необходимо вывести
     * @return возвращает число пользователя с необходимым количеством символом
     */
    private static String intToString(int x, int n) {
        char [] buffer = new char[n];
        for (int i = 0; i < n; i++, x/=10) {
            buffer[n-i-1] = (char)('0' + x % 10);
        } return new String(buffer);
    }

    /**
     * Количество символов в тексте
     */
    private static final int TEST_COUNT = 10000;

    /**
     * Тестовая строка вычислений скорости обработки
     */
    private static final String TEST_STRING = "dskakhkasdnkashfasnbkdhasfbmavlskav;mavblasmvlasjnvlanvlasnglasfnvl";


    private static void testPlus() {
        System.out.println("#### testPlus() ####");
        printMemoryInfo();
        long startTime = System.currentTimeMillis(); //System.nanoTime() более точное измерение
        String str = TEST_STRING;
        long totalLength = str.length();
        for (int i = 0; i < TEST_COUNT; i++) {
            str += TEST_STRING;
            totalLength += str.length();
        }
        System.out.println("str.length = " + str.length());
        System.out.println("totalLength = " + totalLength);
        System.out.println("duration = " + (System.currentTimeMillis() - startTime) + " ms");
        printMemoryInfo();
    }

    private static void testConcat() {
        System.out.println("#### testConcat() ####");
        printMemoryInfo();
        long startTime = System.currentTimeMillis();
        String str = TEST_STRING;
        long totalLength = str.length();
        for (int i = 0; i < TEST_COUNT; i++) {
            str = str.concat(TEST_STRING);
            totalLength += str.length();
        }
        System.out.println("str.length = " + str.length());
        System.out.println("totalLength = " + totalLength);
        System.out.println("duration = " + (System.currentTimeMillis() - startTime) + " ms");
        printMemoryInfo();
    }

    private static void testStringBuilder() {
        System.out.println("#### testStringBuilder() ####");
        printMemoryInfo();
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(TEST_STRING);
        for (int i = 0; i < TEST_COUNT; i++) {
            sb.append(TEST_STRING);
        }
        String str = sb.toString();
        System.out.println("str.length = " + str.length());
        System.out.println("duration = " + (System.currentTimeMillis() - startTime) + " ms");
        printMemoryInfo();
    }

    private static void testStringBuffer() {
        System.out.println("#### testStringBuffer() ####");
        printMemoryInfo();
        long startTime = System.currentTimeMillis(); //System.nanoTime(); более точное измерение времени
        StringBuffer sb = new StringBuffer(TEST_STRING);
        for (int i = 0; i < TEST_COUNT; i++) {
            sb.append(TEST_STRING);
        }
        String str = sb.toString();
        System.out.println("str.length = " + str.length());
        System.out.println("duration = " + (System.currentTimeMillis() - startTime) + " ms");
        printMemoryInfo();
    }

    private static final long MEGA = 1024 * 1024;

    private static void printMemoryInfo() {
        Runtime r = Runtime.getRuntime();
        long max = r.maxMemory() / MEGA;
        long total = r.totalMemory() / MEGA;
        long free = r.freeMemory() / MEGA;
        long usage = (r.totalMemory() - r.freeMemory()) / MEGA;
        System.out.printf("memory: {%d:%d:%d:%d} MB\n", max, total, usage, free);
    }

    private static void printByWord(String text) {
        System.out.println("----------Way 1 (String split) ----------");
        int words = 0;
        for (String word:text.split("[\\s\\.\\,\\-\\'\\(\\)\\[\\]\\{\\}\"<>\\?]") //regexp
        ) {
            if (!word.isBlank()){
                System.out.println(word);
                words++;
            }
        }
        System.out.println("Words: " + words);
    }

    public static final String DELIMITER = "\t\n\r\f.,:;{ }[ ] - + = < > ! ? / | \' \\ \"";

    public static void printByWord2 (String text) {
        System.out.println("----------Way 2 (String tokenizer (C style))----------");
        //strtok C/C++
        //2 по скорости
        int words = 0;
        StringTokenizer tokenizer = new StringTokenizer(text, DELIMITER);
        while ( tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            words++;
            System.out.println(word);
        }
        //--------or-----------
//        for (StringTokenizer tokenizer = new StringTokenizer(text, DELIMITER);
//             tokenizer.hasMoreTokens();){
//            String word = tokenizer.nextToken();
//            words++;
//            System.out.println(word);
//        }
        System.out.println("Words: " + words);
    }

    public static void printByWord3 (String text) {
        //Самый быстрый
        System.out.println("----------Way 3 (Manual (for))----------");
        int words = 0;
        int startWord = 0, endWord = 0;
        for (int i = 0;  i < text.length(); i++) {
            if(DELIMITER.indexOf(text.charAt(i)) >= 0) {
                //ищем символ из текста в разделителях
                //а не разделитель в тексте
                if (startWord == endWord){
                    //skip
                    startWord++; endWord++;
                }
                else {
                    //endWord
                    String word = text.substring(startWord, endWord);
                    words++;
                    System.out.println(word);
                    startWord = endWord = i + 1;
                }
            }else {
                endWord++;
            }
        }
        if (startWord!=endWord){
            String word = text.substring(startWord);
            words ++;
        }
        System.out.println("Words: " + words);
    }

    public static void printByWord4 (String text) {
        System.out.println("----------Way 4 String replace all----------");
//        text = text.replaceAll("[\\s\\.\\,\\-\\'\\(\\)\\[\\]\\{\\}\"<>\\?]+", "\n").strip(); //for version 11 <
        text = text
                .replaceAll("[\\s\\.\\,\\-\\'\\(\\)\\[\\]\\{\\}\"<>\\?]+", "\n")
                .replaceAll("^\n|\n$", ""); //^-начало слова $- зконец слова
        int words = 0;
        for (String word:text.split("\n")) {
            words++;
        }
        System.out.println(text);
        System.out.println("Words: " + words);
        //посчитай количество слов!
        //сколько переводов на новую строку == количеству слов
    }

}
