package ru.specialist.hello.java.HelloApp;

public class PrivetMir {
    /**
     * Главный метод программы
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println(скажиПривет("Игорь"));
    }

    /**
     * Метод создания приветственного сообщения
     * @param имя имя приветствуемого
     * @return приветственное сообщение
     */
    public static String скажиПривет(String имя) {
        return "Привет " + имя + "!";
    }
}
