package excpetions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestExceptions {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println(e.getClass());
        } finally {
            System.out.println("Number format finally");
        }
        //readFile();
        int a = 10;
        try {
            if (a < 20)
                throw new MyException("a < 10");
        } catch (MyException e) {
            //e.printStackTrace();
        }

    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("abc.txt");
    }

    @Override
    protected TestExceptions clone() throws CloneNotSupportedException {
        return (TestExceptions) super.clone();
    }
}

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}