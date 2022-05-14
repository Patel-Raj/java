package mapandlist;

import java.util.*;

class Account {
    int val;
    public void print() {
        int i = val;
        val = i+1;
        System.out.println(Thread.currentThread().getName() + " " + val);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Triplet {
    int i;
    int j;
    int k;

    public Triplet(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;

    }

    @Override
    public boolean equals(Object tt) {
        Triplet t = (Triplet)tt;
        int arr1[] = {t.i, t.j, t.k};
        Arrays.sort(arr1);
        int arr2[] = {this.i, this.j, this.k};
        Arrays.sort(arr2);

        return (arr1[0] == arr2[0]) &&(arr1[1] == arr2[1]) &&(arr1[2] == arr2[2]);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;
        int arr2[] = {this.i, this.j, this.k};
        Arrays.sort(arr2);
        hash = arr2[0] + prime*hash;
        hash = arr2[1] + prime*hash;
        hash = arr2[2] + prime*hash;
        return hash;
    }
}

class Worker implements Runnable {
    Account account = new Account();


    @Override
    public void run() {
        print();
    }

    private  void print() {
        for(int i = 1; i < 100; i++) {
            account.print();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println((char)('a'+1));
        Set<Triplet> set = new HashSet<>();
        set.add(new Triplet(1,2,3));
        set.add(new Triplet(1,3,2));
        System.out.println(set.size());
        /*
        Worker worker = new Worker();
        Thread t1 = new Thread(new Worker());
        Thread t2 = new Thread(new Worker());
        t1.setName("one");
        t2.setName("two");
        t1.start();
        t2.start();



        Animal cat = new Animal("cat", 2);
        Animal dog = new Animal("dog", 3);
        Animal cow = new Animal("cow", 4);
        Animal tiger = new Animal("tiger", 5);

        
        PriorityQueue<Animal> pq = new PriorityQueue<>((a1,a2) ->  a1.age - a2.age);
        pq.add(cat);
        pq.add(dog);
        pq.add(cow);
        pq.add(tiger);

        System.out.println(pq.peek());

        A ani = new B();

*/
    }
}

class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class C {

}

class D extends C {

}

class A extends Object{
    C on(C param) {
        System.out.println("Called from A");
        ArrayList<B> al;
        return null;
    }

    final void m1() {

    }
}

class B extends A {
    protected D on(int a) {
        System.out.println("Called from B");
        return null;
    }
}

class S {

    final int a;
    final static int b;

    static {
        b = 20;

    }
    public S() {
        a = 10;
    }
}

interface I1 {
    void m1();
}

interface I2 {
    void m1();
}

class Ab {
    public void m1() {}
}

class II extends Ab implements I1, I2 {
}

class S1 {
    public S1(int a) {
        System.out.println("S1");
    }
}

class S2 extends S1 {
    public S2() throws Exception {
        super(5);
        System.out.println("S2");
        p1();
    }

    void p1() throws Exception {
        throw new MyException("abcd");
    }
}

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

class Outer {

    private int x;

    Inner inner = new Inner();

    class Inner {
        public Inner() {
            x = 10;
        }
        public void printX() {
            System.out.println(x);
            Set<Integer> set = new HashSet<>();

        }
    }
}

class Aa {
    int a;
    int b;
    int c;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aa aa = (Aa) o;
        return a == aa.a &&
                b == aa.b &&
                c == aa.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}

