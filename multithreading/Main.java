package multithreading;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //new MyAnotherThread().start();

        StringBuilder sb = new StringBuilder(10);
        sb.append('v');
        sb.append('v');
        sb.append('v');
        sb.setCharAt(2,'c');
        System.out.println(sb.toString());
    }
}

class TestClass {

    public synchronized void printNumbers(int threadNumber) {

        for (int i = 1; i < 500; i++) {
            System.out.println(i + " " + threadNumber);
        }
    }
}

class MyThread implements Runnable {

    TestClass testClass;
    int num;
    public MyThread(TestClass testClass, int num) {
        this.testClass = testClass;
        this.num = num;
    }

    @Override
    public void run() {
        //testClass.printNumbers(num);
        printMyNumbers();
    }

    public synchronized void printMyNumbers() {
        for (int i = 1; i < 500; i++) {
            System.out.println(i + " " + num);
        }
    }
}

class MyAnotherThread extends Thread {

    @Override
    public void run() {
        TestClass testClass = new TestClass();
        TestClass testClass2 = new TestClass();

        MyThread myThread = new MyThread(testClass ,1);
        Thread t1 = new Thread(myThread);
        t1.start();

        MyThread myThread2 = new MyThread(testClass2, 2);
        Thread t2 = new Thread(myThread2);
        t2.start();

        /*
        for(int i = 1; i <= 5; i++) {
            System.out.println("MyAnotherThread " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

         */
    }
}