package ru.specialist.hello.java.HelloApp;

import java.util.Objects;

/**
 * Класс описывающий коробку
 * @author Igor Morenko (emailto:imorenko@yandex.ru)
 * @param <T> тип измерения размеров коробки
 */
public class BoxGen<T extends Number> { // Generic Type

    // ***************** Constants ********************

    /** Стандартный типоразмер коробки: Малая */
    public static final char TYPE_SIZE_SMALL = 'S';
    /** Стандартный типоразмер коробки: Средняя */
    public static final char TYPE_SIZE_MEDIUM = 'M';
    /** Стандартный типоразмер коробки: Большая */
    public static final char TYPE_SIZE_LARGE = 'L';

    // ***************** Satic Fields *************

    public static Double defaultSize = 1.0; // for class

    // ***************** Fields *************

    /**
     * Ширина коробки
     */
    private T width; // for instance of class

    /**
     * Высота коробки
     */
    private T height;

    /**
     * Длина коробки
     */
    private T length;

    // ************** Getters & Setters ******************

    /**
     *
     * @return
     */
    public T getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(T width) {
        this.width = width;
        hash = 0; // clear cache
    }

    public T getHeight() {
        return height;
    }

    public void setHeight(T height) {
        this.height = height;
        hash = 0; // clear cache
    }

    public T getLength() {
        return length;
    }

    public void setLength(T length) {
        this.length = length;
        hash = 0; // clear cache
    }

    // ************** Static Methods **************

    /**
     * Вычислить длину ребер коробки (периметр)
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     * @return длина ребер коробки
     */
    public static double perimeter(double width, double height, double length) {
        return (width + height + length) * 4;
    }

    /**
     * Вычислить площадь поверхности коробки
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     * @return площадь поверхности коробки
     */
    public static double squareSurface(double width, double height, double length) {
        return (width * height + width * length + height * length) * 2;
    }

    /**
     * Вычислить объем коробки
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     * @return объем коробки
     */
    public static double volume(double width, double height, double length) {
        return width * height * length;
    }

    /**
     * Функция по борьбе с null значениями
     * @param <T> тип измерения размеров коробки
     * @param value знчачение
     * @return значение типа double
     */
    private static <T extends Number> double nvl(T value) {
        return value != null ? value.doubleValue() : 0.0;
//        return Objects.requireNonNullElse(value, 0.0).doubleValue();
    }

    // ************** Pseudo Properties (ReadOnly) **************

    /**
     * Получить длину ребер коробки (периметр)
     * @return длина ребер коробки
     */
    public double getPerimeter() {
        return perimeter(nvl(width), nvl(height), nvl(length));
    }

    /**
     * Получить площадь поверхности коробки
     * @return площадь поверхности коробки
     */
    public double getSquareSurface() {
        return squareSurface(nvl(width), nvl(height), nvl(length));
    }

    /**
     * Получить объем коробки
     * @return объем коробки
     */
    public double getVolume() {
        return volume(nvl(width), nvl(height), nvl(length));
    }

    // ******************* Constructors ***************

    /**
     * Конструктор коробки по умолчанию
     */
    public BoxGen() {
        this((T)defaultSize);
    }

    /**
     * Конструктор коробки с заданными разерами
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     */
    public BoxGen(T width, T height, T length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    /**
     * Конструктор кубической коробки
     * @param size размер коробки
     */
    public BoxGen(T size) {
        this(size, size, size);
//        width = height = length = size;
    }

    /**
     * Конструктор коробки стандартного типоразмера
     * @param typeSize типоразмер коробки
     */
    public BoxGen(char typeSize) {
        switch (typeSize) {
            case TYPE_SIZE_SMALL:
                width = (T)Integer.valueOf(1);
                height = (T)Integer.valueOf(2);
                length = (T)Integer.valueOf(3);
                break;
            case TYPE_SIZE_MEDIUM:
                width = (T)Integer.valueOf(4);
                height = (T)Integer.valueOf(5);
                length = (T)Integer.valueOf(6);
                break;
            case TYPE_SIZE_LARGE:
                width = (T)Integer.valueOf(7);
                height = (T)Integer.valueOf(8);
                length = (T)Integer.valueOf(9);
                break;
            default:
                width = height = length = (T)defaultSize;
        }
    }

    /**
     * Перечисление стандартных типоразмеров коробки
     */
    public static enum TypeSize {
        /** По умолчанию */
        Default,
        /** Малая */
        Small,
        /** Средняя */
        Medium,
        /** Большая */
        Large
    }

    /**
     * Конструктор коробки стандартного типоразмера
     * @param typeSize типоразмер коробки
     */
    public BoxGen(TypeSize typeSize) {
        switch (typeSize) {
            case Small:
                width = (T)Integer.valueOf(1);
                height = (T)Integer.valueOf(2);
                length = (T)Integer.valueOf(3);
                break;
            case Medium:
                width = (T)Integer.valueOf(4);
                height = (T)Integer.valueOf(5);
                length = (T)Integer.valueOf(6);
                break;
            case Large:
                width = (T)Integer.valueOf(7);
                height = (T)Integer.valueOf(8);
                length = (T)Integer.valueOf(9);
                break;
            default:
                width = height = length = (T)defaultSize;
        }
    }

    // ******************* Fabric Method (Alternate Constructor) **************

    /**
     * Конструктор коробки стандартного типоразмера
     * @param typeSize типоразмер коробки
     * @return ссылка на новый экземпляр коробки
     */
    public static BoxGen createStandardBox(TypeSize typeSize) {
//        switch (typeSize) {
//            case Small:  return new Box(1, 2, 3);
//            case Medium: return new Box(4, 5, 6);
//            case Large:  return new Box(7, 8, 9);
//            default:     return new Box();
//        }
        // JDK12+ (enable previe) JDK14+
        return switch (typeSize) {
            case Small  -> new BoxGen(1, 2, 3);
            case Medium -> new BoxGen(4, 5, 6);
            case Large  -> new BoxGen(7, 8, 9);
            default     -> new BoxGen();
        };
    }

    // ******************* Methods ***************

    /**
     * Метод открытия корбки
     */
    public void open() {
        System.out.println("Открыли коробку");
    }

    /**
     * Метод закрытия коробки
     */
    public void close() {
        System.out.println("Закрыть коробку");
    }

    // **************** Cast to String **********************

    @Override
    public String toString() {
        return "BoxGen{"
                + "width=" + width
                + ", height=" + height
                + ", length=" + length
                + '}';
    }

    // ***************** Equals & HashCode **************************

    private int hash = 0; // cache for hashCode

    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = 5;
            hash = 97 * hash + Objects.hashCode(this.width);
            hash = 97 * hash + Objects.hashCode(this.height);
            hash = 97 * hash + Objects.hashCode(this.length);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        final BoxGen other = (BoxGen) obj;
        if (!Objects.equals(this.width, other.width)) { // class equals
            return false;
        }
        if (!Objects.equals(this.height, other.height)) {
            return false;
        }
        if (!Objects.equals(this.length, other.length)) {
            return false;
        }
        return true;
    }

}
