package ru.specialist.hello.java.HelloApp;


public class MyException extends Exception {
    /**
     * Creates a new instance of <code>MyException</code> without detail
     * message.
     */
    public MyException(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Constructs an instance of <code>MyException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MyException(String msg, String keyword) {
        super(msg);
        this.keyword = keyword;
    }

    private final String keyword;

    public String getKeyword() {
        return keyword;
    }
}

