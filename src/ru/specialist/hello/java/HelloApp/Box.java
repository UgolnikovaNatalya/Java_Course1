package ru.specialist.hello.java.HelloApp;

/**
 * Класс описывающий коробку
 * @author Igor Morenko (emailto:imorenko@yandex.ru)
 */

public class Box implements Comparable <Box>, AutoCloseable  {
    // Java Bean

    // ***************** Constants ********************

    /** Стандартный типоразмер коробки: Малая */
    public static final char TYPE_SIZE_SMALL = 'S';
    /** Стандартный типоразмер коробки: Средняя */
    public static final char TYPE_SIZE_MEDIUM = 'M';
    /** Стандартный типоразмер коробки: Большая */
    public static final char TYPE_SIZE_LARGE = 'L';

    // ***************** Satic Fields *************

    public static int defaultSize = 1; // for class

    // ***************** Fields *************

    /**
     * Ширина коробки
     */
    private int width; // for instance of class

    /**
     * Высота коробки
     */
    private int height;

    /**
     * Длина коробки
     */
    private int length;

    // ************** Getters & Setters ******************

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
        hash = 0; // clear cache
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        hash = 0; // clear cache
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
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
    public static double perimeter(int width, int height, int length) {
        return (width + height + length) * 4;
    }

    /**
     * Вычислить площадь поверхности коробки
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     * @return площадь поверхности коробки
     */
    public static double squareSurface(int width, int height, int length) {
        return (width * height + width * length + height * length) * 2;
    }

    /**
     * Вычислить объем коробки
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     * @return объем коробки
     */
    public static double volume(int width, int height, int length) {
        return width * height * length;
    }

    // ************** Pseudo Properties (ReadOnly) **************

    /**
     * Получить длину ребер коробки (периметр)
     * @return длина ребер коробки
     */
    public double getPerimeter() {
        return perimeter(this.width, this.height, this.length);
    }

    /**
     * Получить площадь поверхности коробки
     * @return площадь поверхности коробки
     */
    public double getSquareSurface() {
        return squareSurface(width, height, length);
    }

    /**
     * Получить объем коробки
     * @return объем коробки
     */
    public double getVolume() {
        return volume(width, height, length);
    }

    // ******************* Constructors ***************

    /**
     * Конструктор коробки по умолчанию
     */
    public Box() {
        this(defaultSize);
    }

    /**
     * Конструктор коробки с заданными разерами
     * @param width ширина коробки
     * @param height высота коробки
     * @param length длина коробки
     */
    public Box(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    /**
     * Конструктор кубической коробки
     * @param size размер коробки
     */
    public Box(int size) {
        this(size, size, size);
//        width = height = length = size;
    }

    /**
     * Конструктор коробки стандартного типоразмера
     * @param typeSize типоразмер коробки
     */
    public Box(char typeSize) {
        switch (typeSize) {
            case TYPE_SIZE_SMALL:
                width = 1;
                height = 2;
                length = 3;
                break;
            case TYPE_SIZE_MEDIUM:
                width = 4;
                height = 5;
                length = 6;
                break;
            case TYPE_SIZE_LARGE:
                width = 7;
                height = 8;
                length = 9;
                break;
            default:
                width = height = length = defaultSize;
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
    public Box(TypeSize typeSize) {
        switch (typeSize) {
            case Small:
                width = 1;
                height = 2;
                length = 3;
                break;
            case Medium:
                width = 4;
                height = 5;
                length = 6;
                break;
            case Large:
                width = 7;
                height = 8;
                length = 9;
                break;
            default:
                width = height = length = defaultSize;
        }
    }

    // ******************* Fabric Method (Alternate Constructor) **************

    /**
     * Конструктор коробки стандартного типоразмера
     * @param typeSize типоразмер коробки
     * @return ссылка на новый экземпляр коробки
     */
    public static Box createStandardBox(TypeSize typeSize) {
//        switch (typeSize) {
//            case Small:  return new Box(1, 2, 3);
//            case Medium: return new Box(4, 5, 6);
//            case Large:  return new Box(7, 8, 9);
//            default:     return new Box();
//        }
        // JDK12+ (enable previe) JDK14+
        return switch (typeSize) {
            case Small  -> new Box(1, 2, 3);
            case Medium -> new Box(4, 5, 6);
            case Large  -> new Box(7, 8, 9);
            default     -> new Box();
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
        return "Box{"
                + "width=" + width
                + ", height=" + height
                + ", length=" + length
                + '}';
    }

//    public Object toString(String name) {
//        return name + " = " + toString();
//    }

    // ***************** Equals & HashCode* ************************* = 123456

    // ***************** Equals & HashCode ************************** = 123456

    private int hash = 0; // cache for hashCode

    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = 5;
            hash = 97 * hash + this.width;
            hash = 97 * hash + this.height;
            hash = 97 * hash + this.length;
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
        final Box other = (Box) obj;
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (this.length != other.length) {
            return false;
        }
        return true;

    }

    /**
     * Интерфейс Comparable <Box>
     * Метод сравнения 2 коробок
     * @param other ссылка на другой объект
     * this - ссылка на текущий объект
     * 0 = b1==b2
     * >0 = b1>b2
     * <0 = b1<b2
     * @return
     */
    @Override
    public int compareTo(Box other) {
        if (this == other) return 0;
        if (other == null) return 1; //this > null
        return Double.compare(this.getVolume(), other.getVolume());
    }

}
