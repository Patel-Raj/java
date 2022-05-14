package functional.imerative;

import com.sun.source.tree.BreakTree;


import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    // Simple function
    static Function<Integer, Integer> incrementByOne = number -> number+1;
    static Function<Integer, Integer> multiplyByTen = number -> number*10;
    static TestInterface testInterface = number -> number*2;
    static Function<Integer, Integer> incrementAndMultiplyByTen = incrementByOne.andThen(multiplyByTen).andThen(testInterface);

    // Bifunction
    static BiFunction<Integer, Integer, Integer> incrementAndMultiplyBiFunction =
             (number1, number2) -> (number1+1)*number2;

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Raj" ,Gender.MALE),
                new Person("Ranu" ,Gender.FEMALE),
                new Person("Rutva" ,Gender.FEMALE)
        );

        Integer ans = incrementAndMultiplyByTen.apply(3);
        System.out.println(ans);
        System.out.println(incrementByOne.andThen(multiplyByTen).apply(10));
        System.out.println(incrementAndMultiplyBiFunction.apply(10, 2));

        TestInterface testInterface = (str) -> str;

        System.out.println(incrementAndMultiplyByTen.apply(10));

        InterfaceOne interfaceOne = new InterfaceOne() {
            @Override
            public int show(int a) {
                return 0;
            }
        };
        InterfaceTwo interfaceTwo = new Main()::mango;
        interfaceTwo.show();

        Integer val = 10;
        
        Optional<Integer> integer = Optional.of(val);
        if(integer.isPresent()){
            System.out.println("yes");
        }


    }

    public String mango() {
        return "AMango";
    }

}

class Person {
    private final String name;
    private final Gender gender;

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}

enum Gender {
    MALE, FEMALE;
}

@FunctionalInterface
interface TestInterface extends Function<Integer, Integer>{
}

interface InterfaceOne {
    int show(int a);
}

@FunctionalInterface
interface InterfaceTwo {
    void show();
}


class ABC {
    public String mango() {
        return "";
    }
    public void hello() {
        InterfaceTwo interfaceTwo = new ABC()::mango;
        interfaceTwo.show();
    }
}
interface A {
    void abc();
    static void abcd() {

    }

    static void pqer() {
        abcd();
    }

    default void defaultMehtod() {
        abcd();
    }
}

interface B {
    void abc();
    void absdfsc();
}

interface C extends A,B {

}

class D implements C, A, B {

    @Override
    public void abc() {
        String str;

    }

    @Override
    public void absdfsc() {

    }
}

