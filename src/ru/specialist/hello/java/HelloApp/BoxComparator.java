package ru.specialist.hello.java.HelloApp;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {

    /**
     * Конструктор для выбора последовательности распечатки результата
     * от большего к меньшему или наоборот.
     * По умолчанию используется по возрастанию
     */
    private final int sign;
    /**
     * Конструктор определяющий где выводить null значения
     * в начале или в конце
     */
    private final int nulls;

    public BoxComparator() {
        sign = 1;
        nulls = 1; //nulls first
    }

    public BoxComparator(boolean asc) {
        sign = asc ? 1 : -1;
        nulls = 1;
    }

    public BoxComparator(boolean asc, boolean nullsFirst) {
        sign = asc ? 1 : -1;
        nulls = nullsFirst ? 1: -1;
    }

    /**
     * Используем не CompareTo а просто Compare
     * потому что этот класс будет реализовывать сравнение 2х объектов
     * Если мы хотим выводить информацию в обратном порядке(по убыванию)
     * то добавляем "-": -Double.compare(b1.getVolume(),b2.getVolume())
     * @param b1 ссылка на первый ящик
     * @param b2 ссылка на 2 ящик
     * @return
     */
    @Override
    public int compare(Box b1, Box b2) {
        if (b1==b2) return 0; //b1 == b2
        if (b1==null) return -nulls; //null < b2
        if (b2 == null) return nulls; //b1 > null
        return sign * Double.compare(b1.getVolume(),b2.getVolume());
    }
}
