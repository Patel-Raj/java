package functional.imerative;

import java.util.Comparator;
import java.util.function.Supplier;

public class _Supplier {

    // Supplier takes no input and just returns the output.
    static Supplier<String> returnName = () -> "Raj";


    static MyInterface myInterface = name -> System.out.println(name);

    static Comparator<Integer> comp = (i1, i2) -> i2-i1;

    public static void main(String[] args) {
        System.out.println(returnName.get());
        myInterface.printIt("Rajaajaj");
        System.out.println(comp.compare(10,20));
    }
}

interface MyInterface {
    void printIt(String str);
}