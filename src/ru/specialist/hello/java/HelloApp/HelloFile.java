package ru.specialist.hello.java.HelloApp;


import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class HelloFile {

    public static void main(String[] args) throws IOException {

        File dir = new File("C:\\temp\\test\\1"); //проверяет наличие каталога
        System.out.println("dir.exists = " + dir.exists());
        /**
         * если каталога не существует, то мы создаем его
         * mkdir - создает каталог внутри существующего (одинарный)
         * mkdirs - создает цепочку каталога
         * правильно пользоваться вторым
         */
        if (!dir.exists()) {
            System.out.println("Create dir - " + dir.mkdirs());
        }

        /**
         * Создаем новый файл
         * @param dir - директорий в который создаем файл
         * @param test.tst - имя и расширение файла, которого создаем
         */
        File file = new File(dir, "test.tst");
        System.out.println("file.exists = " + file.exists());
        if (!file.exists()) {
            System.out.println("Make new file - " + file.createNewFile());
        }

        dir(new File("C:\\temp"));

        //Binary Files

        File binFile = new File(dir, "test.bin");
        writeToBinaryFile(binFile);
//        readFromBinaryFile(binFile);
//        readFromBinaryFile2(binFile);

        //Text file
        File txtFile = new File(dir,"test.txt");
//        writeToTextFile(txtFile);
//        readFromTextFile(txtFile);
        writeToTextFile2(txtFile);
        try {
            readFromTextFile2(txtFile);
            readFromTextFile2(new File("test123.txt"));
        } catch (IOException ex){
            //ошибка из try-catch
            System.err.println("I/O Error (try-catch): " + ex.getMessage());}
        catch (MyException ex){
            //ошибка из try-catch
            System.err.println("My Error (try-catch): " + ex.getMessage());
        }


    }



    //-------------------------Methods-------------------------------

    /**
     * Метод чтения файла
     * Такое чтение используется с Java7+
     * далее использовались Try-catch с ресурсами
     *
     * @param binFile имя файла, которого будем чиать
     */
    private static void readFromBinaryFile2(File binFile) {

        //1.open file to read
        try (InputStream in = new FileInputStream(binFile);
             Box box = new Box();) {
            box.open();
            //2.read from file
            int x;
            while ((x = in.read()) != -1) {
                System.out.println(x);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    //3. auto close file
    //in.close()
    //box.close()


    /**
     * Метод чтения файла
     * Такое чтение использовалось до Java 1.7
     * далее использовались Try-catch с ресурсами
     * @param binFile имя файла, которого будем чиать
     */
    private static void readFromBinaryFile(File binFile) {
        /**
         * try -попробовать первый метод. Если что-то неладно
         * то попадаем в catch
         * Последовательность try-catch очень важно
         * Например ошибка FileNotFound  явл. наследником от IOException
         * работает как instanceOff, то есть сравнивает, подходит файл к
         * данному типу данных (ошибок) или нет. Сранивает.
         * Движение от частного к общему, при написании exceptions
         * Наследников от RunTimeException отлавливать не обязательно
         * а вот от class Exception (IOExcept, FileNotFound) необходимо!!
         */

        InputStream in = null;
        //1.open file to read
        try {
            in = new FileInputStream(binFile);
            //2.read from file
//            int x = in.read(); // читает по 1 байту, x = 0..255, EOF -> -1
            int x;
            while ((x = in.read()) !=-1){
                System.out.println(x);
            }
            x= 1/0; //Run time exception
        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }catch (RuntimeException ex){
            System.err.println("Run time error: " + ex.getMessage());
        }  finally {
            //3. close file
            if (in!=null){
                try {
                    in.close();
                }catch (IOException ex){
                    System.err.println("Error: " + ex.getMessage());
                }
            }

        }
    }

    /**
     * Метод записи бинарного файла
     * OutputStream - абстрактный класс, пожтому мы не можем его создать
     * и создаем спец. файл: FileOutputStream - класс, который расширяет
     * OutputStream
     * @param binFile имя файла
     */
    private static void writeToBinaryFile(File binFile) throws IOException {
        //1. Open file for written
        OutputStream out = new FileOutputStream(binFile);
        //2. write to file
        /**
         * Запись побайтно
         */
        for (int i = 0; i < 256; i++) {
            out.write(i);
        }
        /**
         * Запись массивом
         */
        byte[] buffer = new byte[256];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }
        out.write(buffer);
        //3. close file
        out.close();
    }

    /**
     * Утилита которая автоматизирует выполнение вызова операции
     * @param path
     */
    private static void dir(File path) {
        if (!path.isDirectory()) return;

        System.out.println("Содержимое папки: " + path.getAbsolutePath()); //абсолютный путь
        int numDirs = 0, numFiles = 0;
        long totalLength = 0;
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");
        for (File file : path.listFiles()){
            if (file.isDirectory()){
                numDirs ++;
            }
            if (file.isFile()){
                numFiles ++;
                totalLength += file.length();
            }
            System.out.printf("%s %s %c%c%c%c %,12d %s \n",
                    dataFormat.format(new Date(file.lastModified())), //Дата
                    file.isDirectory()?"<DIR>":" //  ", // Каталог || !каталог
                    file.canRead() ? 'r' : '-',
                    file.canWrite() ? 'w' : '-',
                    file.canExecute() ? 'x': '-',
                    file.isHidden() ? 'h':' ',
                    file.length(), // Длина файла
                    file.getName()); //Имя файла

        }
        /**
         * %,15d
         * , - групповой разделитель (ед-цаю десятки, сотни и тд)
         * 15 - количество символов для целых чисел
         */
        System.out.printf("    %,3d Файлов    %,15d  байт\n", numFiles, totalLength);
        System.out.printf("    %,3d Папок     %,15d  байт свободно\n", numDirs, path.getFreeSpace());
    }

    /**
     * Копирование файлов
     * @param srcFile - откуда копируем
     * @param dstFile - куда копируем
     */

    private static void copyBinaryFile2(File srcFile, File dstFile) {

        //1.open file to read
        try (InputStream in = new FileInputStream(srcFile); // для чтения
             OutputStream out = new FileOutputStream(dstFile);) // для записи
        {

            //2.read from file
            byte [] buffer = new byte[13];
            int len;
            while ((len = in.read(buffer)) != -1) {
                //3. Запись
                out.write(buffer, 0, len); //пишем из buffer с 0 смещением в len
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }//4. auto close file
        //in.close()
        //out.close()
    }

    /**
     * Сжатие файлов
     * Копирование в сжатый
     * @param srcFile - чтение файла
     * @param dstFile - запись в файл и сжатие
     */

    private static void compressBinaryFile2(File srcFile, File dstFile) {

        //1.open file to read
        try (InputStream in = new FileInputStream(srcFile); // для чтения
             //выходной файл сжатый в Gzip (сжимаем только один файл)
             // a Zip может содержать в себе несколько файлов (посложнее будет)
             OutputStream out = new GZIPOutputStream(new FileOutputStream(dstFile));) // для записи
        {

            //2.read from file
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                //3. Запись
                out.write(buffer, 0, len); //пишем из buffer с 0 смещением в len
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Копирование из жатого файла
     * @param srcFile - сжатый файл
     * @param dstFile - обычный файл, куда копируем
     */

    private static void deCompressBinaryFile2(File srcFile, File dstFile) {

        //1.open file to read
        //читаем из сжатого файла в обычный
        try (InputStream in = new GZIPInputStream(new FileInputStream(srcFile)); // для чтения
             OutputStream out = new FileOutputStream(dstFile);) // для записи
        {

            //2.read from file
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                //3. Запись
                out.write(buffer, 0, len); //пишем из buffer с 0 смещением в len
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Посимвольное создание файла
     * @param txtFile - файл который будет на выходе
     * Charset.forName - задаем кодировку выходного файла
     */
    private static void writeToTextFile(File txtFile) {
        //1. Open File for write
        try (Writer wr = new FileWriter(txtFile, Charset.forName("cp1251"));) {
            wr.write("Hello World!\n");
            wr.write("Привет Мир!");
        }catch (IOException ex){
            System.err.println("Error: " + ex.getMessage());
        }
        //auto close
    }

    /**
     * PrintWriter - построчное создание
     * @param txtFile
     */
    private static void writeToTextFile2(File txtFile) {
        //1. Open File for write
        try (PrintWriter wr = new PrintWriter(txtFile, Charset.forName("cp1251"));) {
            //2. Write
            wr.println("Hello World!");
            wr.println("Привет Мир!");
        }catch (IOException ex){
            System.err.println("Error: " + ex.getMessage());
        }
        //auto close
    }

    /**
     * Посимвольное чтение
     * @param txtFile
     */

    private static void readFromTextFile (File txtFile) {
        // open
        try (Reader rd = new FileReader(txtFile, Charset.forName(CHARSET_WIN))){
            int ch;
            // read
            while ((ch = rd.read()) != -1){
                System.out.print((char)ch);
            }
        }catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        } // auto close
    }

    /**
     * Построковое чтение
     * Удобнее
     * @param txtFile
     */

//    private static void readFromTextFile2 (File txtFile) throws Exception {
    //Вместо общей ошибки будем вызывать мою

    private static void readFromTextFile2(File txtFile) throws MyException, IOException {
        // open
        try (BufferedReader rd = new BufferedReader(new FileReader(txtFile, Charset.forName(CHARSET_WIN)));) {
            String line;
            // read
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                if (line.contains("Hello")) throw new MyException("Встретили слово Привет!", "Hello");
            }
        } catch (IOException ex) {
            System.err.println("Error readFromTextFile2: " + ex.getMessage());
//            throw new MyException("Ошибка ввода/вывода - ");
            throw ex;
        }
        // close
    }


    //Русские кодировки
    public static final String CHARSET_WIN = "cp1251";
    public static final String CHARSET_DOS = "cp866";
    public static final String CHARSET_ISO = "iso8859-5";
    public static final String CHARSET_KOI8R = "koi8-r";
    public static final String CHARSET_UTF8 = "utf-8";

}
