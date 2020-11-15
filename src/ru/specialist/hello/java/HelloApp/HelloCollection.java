package ru.specialist.hello.java.HelloApp;


import java.lang.reflect.Method;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class HelloCollection {
    public static void main(String[] args) {
//        -----------------------------Collections---------------------------
        /**
         * Collection<Integer> intCol - Это интерфейс
         * Интерфейс описывает базовый функционал
         * (добавить, посмотреть есть ли объект, удалить
         * очистить, посмотреть размер, перебрать элементы коллекции)
         *
         * В КОЛЛЕКАЦИЯХ ХРАНЯТСЯ ССЫЛКИ НА ОБЪЕКТЫ!!!
         * НЕ ХРАНЯТСЯ ПРИМИТИВНЫЕ ТИПЫ!!!
         *
         * ArrayList см. ниже
         *
         * LinkedList - связанный список на основе элементов и связи между ними.
         * В качестве LinkedList лучше всего подходит представление вагонов
         * поезда сцепленных последовательно.
         * удобен когда важнее быстродействие операций вставки/удаления,
         * которые в LinkedList выполняются за константное время.
         *
         * если часто вставляете/удаляете - выбирайте в пользу LinkedList,
         * в противном случае ArrayList
         */
        Collection<Integer> intCol = new HashSet<>();

//        Добавление элементов
        intCol.add(1); // Добавляем на самом деле Integer.valueOf(1)
        intCol.add(10); // тут идет автоматический боксинг
        intCol.add(15);
        intCol.add(-22);
        intCol.add(0);
        intCol.add(null);
        System.out.println("intCol: " + intCol);

//        Удаление элементов
        intCol.remove(10);
        System.out.println("intCol: " + intCol);
        System.out.println("IntCol.size = " + intCol.size());
//        Проверка наличия элемента
        System.out.println("IntCol.contains (15) = " + intCol.contains(15));
        System.out.println("IntCol.contains (null) = " + intCol.contains(null));


//      Перебор элементов
        Iterator<Integer> iterator = intCol.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
//      --------------------List----------------------------------
        System.out.println("------------ArrayList-----------");
        /**
         * ArrayList - это список на основе массива. Не используется для
         * многопоточности!
         * Для многопоточности используем: Vector. Но в последнее время
         * принято его заменять на ArrayList для непоточной коллекции
         * следует использовать, когда в приоритете доступ по
         * индексу, так как эти операции выполняются за константное время.
         */
        Collection<String> strCol = new ArrayList<>();
        strCol.add("Hello");
        strCol.add("World");
        strCol.add("123");
        strCol.add("JavaSE");
        strCol.add("first");
        System.out.println("strCol: " + strCol);

        Collection<Box> boxCol = new HashSet<>();
        boxCol.add(new Box(1,2,3));
        boxCol.add(new Box(10));
        boxCol.add(new Box(Box.TYPE_SIZE_MEDIUM));
        boxCol.add(new Box(Box.TypeSize.Large));
        System.out.println("Boxcol: " + boxCol);

        List<String> strList = new ArrayList<>();
        strList.add("one");
        strList.add("two");
        strList.add("three");
        System.out.println("strList: " + strList);
        strList.add(0,"zero");
        System.out.println("strList: " + strList);
        System.out.println("strList [2] = " + strList.get(2));
        strList.set(2,"два");
        System.out.println("strList = " + strList);
//        Поиск по индексу
        System.out.println("one = " + strList.indexOf("one"));
        strList.add(null);
        strList.add(null);
        strList.add("one");
        System.out.println("strList = " + strList);
        System.out.println("null = " + strList.indexOf(null));

//      ---------------------Работа с итератором------------------------------

        /**
         * Создаем итератор iter
         * hasNext - проверка "можно ли двигаться дальше"
         * если можно, то извлекаю значение iter.next()
         * Распечатываем
         * Если ссылка имеет значение null If(next == null)
         * то мы ее удаляем iter.remove()
         */
        System.out.println("Iterator with remove");
        for (Iterator<String>iter = strList.iterator(); iter.hasNext();)
        {
            String next = iter.next();
            System.out.println(next);
            if (next==null){
                iter.remove();
            }
        }
        System.out.println("strList = " + strList);

//      Работа с for-each
        /**
         * FOR each - только для чтения!
         * мы не можем добавлять, редактировать перемещать, как с ListIterator
         */
        System.out.println("For-each");

        for (String element:strList) {
            System.out.println(element);
        }
//        Итератор для ListIterator
        /**
         * Собственный итератор List
         * У strList берем ListIterator и тогда мы сможем
         * брать значения не с начала, а с конца strList.listIterator(strList.size())
         * проверяем, есть ли предыдущие элементы (не дошли ли мы до начала)
         * iter.hasPrevious()
         * и берем предыдущий элемент String prev = iter.previous();
         * Распечатываем с конца в начало sout (prev)
         * И проверяем, если предыдущий элемент равен "два"
         * if(prev.equals ("два"))
         * то заменяем его на "two"
         * iter.set("two")
         * и если позиция равна"three", то добавяем 2.5
         * iter.add ("2.5")
         */

        System.out.println("listIterator with set and add");
        for (ListIterator<String> iter = strList.listIterator(strList.size());
             iter.hasPrevious();){
            String prev = iter.previous();
            System.out.println(prev);
            if (prev.equals("два")){

                iter.set("two");
            }
            if (prev.equals("three")){
                iter.add("2.5");
            }
        }            System.out.println("strList = " + strList);
//        -------------------------Набор Set-ов-----------------------------
        System.out.println("----------Sets-------------");
        /**
         * Интерфейс SET Ничего не расширяет,
         * но дает гарантию того, что все, кто будут реализовывать  set
         * не будут иметь повторений в своем наборе (выводе на экран)
         * Т.е. будет выводить только то, что есть в наборе, но сколько
         * повторений не будет HashSet<>()
         */
        System.out.println("-----------HashSet------------");
        Set<Integer> intSet = new HashSet<>();
        intSet.add(1);
        intSet.add(10);
        intSet.add(-15);
        intSet.add(22);
        intSet.add(10);
        intSet.add(1);
        intSet.add(15);
        intSet.add(null);
        System.out.println("intSet: " + intSet);
        System.out.println("intSet = " + intSet.size());
//         ---------------TreeSet--------------
        /**
         * TreeSet не мжет хранить значения null!!!
         * Null нельзя хранить, т.к. используется equals
         * Расширяет абстрактный Set и реализует
         * SortedSet который, в свою очередь имеет компоратор
         * и выводит числа по порядку
         */
        System.out.println("------------TreeSet-----------");
        Set<Integer> intTSet = new TreeSet<>();
        intTSet.add(1);
        intTSet.add(10);
        intTSet.add(-15);
        intTSet.add(22);
        intTSet.add(10);
        intTSet.add(1);
        intTSet.add(15);
//        intSet.add(null);
        System.out.println("intTSet: " + intTSet);

//        -----------Sorted Set------------------
        /**
         * SortedSet выводит данные отсортированно
         */
        System.out.println("------------Sorted Set-----------");
        SortedSet<Integer> intSSet = new TreeSet<>();
        intSSet.add(1);
        intSSet.add(10);
        intSSet.add(-15);
        intSSet.add(22);
        intSSet.add(10);
        intSSet.add(1);
        intSSet.add(15);
//        intSet.add(null);
        System.out.println("intSSet: " + intSSet);
        System.out.println("intSSet = " + intSSet.size());
        System.out.println("intSSet.first = " + intSSet.first());
        System.out.println("intSSet.last = " + intSSet.last());
        System.out.println("intSSet.headSet = " + intSSet.headSet(10));
        System.out.println("intSSet.tailSet = " + intSSet.tailSet(10));
//      ------Box Set--------------
        System.out.println("---------------Box Set---------------");
        /**
         * Набор уникальных значений
         * повторений не будет
         * Тут используется HashCode & equals
         * Можем хранить null значения, тк объекты сравниваются через equals
         * Выводит на 1 меньше, тк два элемента ссылаются на один и тот же объект
         * Box (1.2.3) & Box.TypeSize.Small
         * Инфа хранится в виде массива со сслыками на списски по HashCode
         *
         */
        Set<Box> boxSet = new HashSet<>();
        boxSet.add(new Box());
        boxSet.add(new Box(1, 2, 3));
        boxSet.add(new Box(3, 2, 1));
        boxSet.add(new Box(10));
        boxSet.add(new Box(Box.TYPE_SIZE_MEDIUM));
        boxSet.add(new Box(Box.TypeSize.Small));
        boxSet.add(new Box(Box.TypeSize.Large));
        System.out.println("BoxSet: " + boxSet);
        System.out.println("BoxSet.size: " + boxSet.size());

//        -----------------Tree Set------------------------
        System.out.println("Box TreeSet");
        /**
         * Инфа хранится в виде бинарного дерева.
         * И не может хранить null значения!!
         * При создании конструктора элементы должны
         * реализовывать интерфейс comparable, который умеет
         * сравниватьобъекты между собой.
         * Пустой конструктор он не сможет сравнить и выдаст ошибку.
         * Поэтому нам надо переписать метод CompareTo для Box (см.вкладку Box)
         * Переписав метод CompareTo мы сравниваем объем коробок, а поскольку
         * Box (1.2.3) & Box (3.2.1) & Box.TypeSize.Small имееют одинаковый объем
         * то будут ссылаться на один и тот же объект.
         * Переписываем метод CompareTo чтобы обойти ошибку ClassCastException
         */

//        Set<Box> boxTSet = new TreeSet<>();

        /**
         *Comparator <Box>.comparable
         * Компоратор - отдельный класс, который будет сравнивать 2 объектаю
         * Его можно передать в в качестве нового конструктора
         * false - последовательность вывода инфы на экран
         */

//        Set<Box> boxTSet = new TreeSet<>(new BoxComparator());
//        Set<Box> boxTSet = new TreeSet<>(new BoxComparator(false));
        Set<Box> boxTSet = new TreeSet<>(new BoxComparator(false, false));
        boxTSet.add(new Box());
        boxTSet.add(new Box(1, 2, 3));
        boxTSet.add(new Box(3, 2, 1));
        boxTSet.add(new Box(10));
        boxTSet.add(new Box(Box.TYPE_SIZE_MEDIUM));
        boxTSet.add(new Box(Box.TypeSize.Small));
        boxTSet.add(new Box(Box.TypeSize.Large));
        boxTSet.add(null);
        System.out.println("BoxSet: " + boxTSet);
        System.out.println("BoxSet.size: " + boxTSet.size());

//        List sort
        System.out.println("List sorted");
        List<Integer> intList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            intList.add(new Random().nextInt(201) - 100);
        }
        System.out.println("intList: " + intList);
        Collections.sort(intList);
        System.out.println("intList sorted: " + intList);
/**
 * Создали анонимный класс для сортировка от большего к меньшему.
 * Но он слишком громоздкий
 * Вместо него можно использовать лямбда выражения
 */
        Collections.sort(intList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("intList sorted: " + intList);

        /**
         * Лямбда-выражение.
         * Тут выводим от меньшего к большему
         */

        Collections.sort(intList, (o1, o2) -> o1 - o2);
        System.out.println("intList sorted: " + intList);

        Collections.sort(intList, (i1, i2) -> i1 - i2);
        System.out.println("intList sorted: " + intList);

        Collections.sort(intList, HelloCollection::compareInteger);
        System.out.println("intList sorted: " + intList);

/**
 * Потоковая обработка. Сортировка от большего к меньшему
 */
//        intList.stream().forEach(System.out::println);
/**
 * Потоковая обработка. Сортировка значений, которые > 0
 * Лямбда-выражение
 * У потоков есть промежуточный оператор: filter
 * входящий поток: intList.stream()
 * исходящий поток: i -> i > 0 (выполняется условие)
 * и терминальный оператор: foreach (выполняет действие
 * для каждого значения после фильтрации)
 * Можно делать некоторые мат. операции, кроме инкремента/декремента
 * т.к. внешние переменные внутри лямбда-выражений
 *  и анонимных классов, могут быть только FINAL!!!
 */
//        intList.stream().filter(i -> i > 0).forEach(System.out::println);
        /**
         * limited(5) промежуточное вычисление,
         * которое выведет только 5 положительных чисел
         * Лямбда-выражение
         */
        intList.stream().filter(i -> i > 0).limit(5).forEach(e -> System.out.println(e+1));
        //так нельзя!!!!
//        final int sum = 0;
//        intList.stream().filter(i -> i > 0).forEach(e ->sum = sum + e); //потоковая обрабока

        System.out.println("-----------Map---------------");
        /**
         * Map - словарь
         */
        Map<Integer, String> dict1 = new TreeMap<>();
        dict1.put (1, "one");
        dict1.put (2, "two");
        dict1.put (4, "four");
        dict1.put (0, "zero");
        dict1.put (3, "три");
        System.out.println("dict1 = " + dict1);
        System.out.println("dict1.get = " + dict1.get(2));

        Map<String, Integer> dict2 = new HashMap<>();
        dict2.put("zero", 0);
        dict2.put("one", 1);
        dict2.put("two", 2);
        dict2.put("three", 3);
        System.out.println("dict2 = " + dict2);
        System.out.println("dict2.get(three) = " + dict2.get("three"));

        Map<String, Box> boxMap1= new HashMap<>();
        Map<Box, String> boxMap2= new HashMap<>();

        for (Box.TypeSize typeSize : Box.TypeSize.values()) {
            boxMap1.put(typeSize.name(), new Box(typeSize));
            boxMap2.put(new Box(typeSize), typeSize.name());
        }
        System.out.println("boxMap1 = " + boxMap1);
        System.out.println("boxMap2 = " + boxMap2);
        System.out.println("\nboxMap1(Medium) = " + boxMap1.get("Medium"));
        System.out.println("boxMap2 (1, 2, 3) = " + boxMap2.get(new Box(1,2,3)));

/**
 * Многомерная коллекцияю. Внетри коллекции List
 * Хранится ссылка Set
 * на коллекции наборов String
 */
        List<Set<String>> colCol;
        Map<Class, List<Method>> cacheMethod;


        /**
         * None Generic Type
         * Позволяет хранить в коллекции любые типы данных.
         * и чтобы нам пробить сумму, без ошибки, которая укажет,
         * что, String & other types невозможно посчитать
         * надо х привести к int: sum += (int) x;
         */
        System.out.println("-------------Generic Type-------------");

//        Collection intCol2 = new ArrayList(); // Collection <Object>
//        intCol2.add(Integer.valueOf(1)); // Boxing Java 5> None Generic
//        intCol2.add(10);
//        intCol2.add(-15);
//        intCol2.add(22);
//        intCol2.add(31);
//        intCol2.add("31");
//        intCol2.add(new Box(1, 2, 3));
//        sum = 0;
//        for (Object x : intCol2) { // Для None Generic
//            sum += (int) x; // Для None Generic
//            В версиях > 5 надо было писать так
//            Чтобы избежать ошибки невозможности посчитать String
//            if (x instanceof Integer) { // Исключает null
//            sum += ((Integer) x).intValue(); // Unboxing Java 5 >
//            }
//------------------------------------------------------------------------
/**
 * Generic Type
 * Позволяет избегать ошибок, тк изначально
 * не разрешает создавать типы данных отличных от заявленных
 */
//        Generic Type!

        Collection<Integer> intCol2 = new ArrayList(); //Collection <Integer>
        intCol2.add(1);
        intCol2.add(10);
        intCol2.add(-15);
        intCol2.add(22);
        intCol2.add(31);
//        intCol2.add(null); //Для искл ошибки см стр.410

        int sum = 0;
        for (Integer x : intCol2) {
            sum += x;
        }
//        Запись идентична с:
//        for (Object obj : intCol2) {
//            Integer x = (Integer) obj;
//            sum += x;
//        }
        System.out.println("sum = " + sum);
//        ----------------------------------------
        /**
         * Перебираем Мар-ы
         */

        System.out.println("\n------------For-each-----------");

        for (String key : boxMap1.keySet()) {
            System.out.println(key + boxMap1.get(key));
        }

        System.out.println("\n---------Объем ящиков с помощью Values()-----------");
        double totalVolume = 0;
        for (Box box:boxMap1.values()) {
            totalVolume +=box.getVolume();
        }
        System.out.println("Total Volume: " + totalVolume);

        System.out.println("--------For-each по коллекции e ntrySet-----------");
        /**
         * Набор записей entry в которых,
         * в качестве ключа String
         * в качестве значения Box
         * Это тот случай, когда можно использовать var
         * чтобы не мучиться с типом данных
         */
//        for (Map.Entry<String, Box> entry : boxMap1.entrySet()) {
        for (var entry : boxMap1.entrySet()) {
            System.out.println( entry.getKey() + " -> " + entry.getValue());
        }

    }

    public static int compareInteger (Integer i1, Integer i2){
        return i2-i1;
    }
}
//лекция на 5.10.20

