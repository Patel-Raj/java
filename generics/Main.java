package generics;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Printer<Animal> animalPrinter = new Printer<>(animal);
        animalPrinter.print();

        List<Animal> animalList = new ArrayList<>();
    }
}

class Printer<T extends Animal> {

    T object;

    public Printer(T object) {
        this.object = object;
    }

    public void print() {
        object.eat();
    }
}

abstract class Animal  {
    abstract void eat();
}

class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("Cat is eating");
    }
}

class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog is eating");
    }
}