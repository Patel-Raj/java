package trie;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class TestTest {
    public static void main(String[] args) {
        List<Animal> l1 = new ArrayList<>();
        List<Animal> l2 = new ArrayList<>();
        Animal cat = new Animal("cat");
        Animal dog = new Animal("dog");
        l1.add(cat);
        l1.add(dog);
        System.out.println(cat);
        System.out.println(dog);
        List<Animal> l3 = (ArrayList<Animal>) ((ArrayList<Animal>) l1).clone();
        System.out.println(l3.get(0));



        Animal a2 = cat.clone();
        System.out.println(cat == a2);

        System.out.println("-----");
        Animal arr[] = {cat, dog};
        Animal arr2[] = Arrays.copyOf(arr, arr.length);
        System.out.println(arr[0] == arr2[0]);
        System.out.println("-----");
        Map<String, List<String>> maap = new HashMap<>();
        maap.put("abc", null);
        System.out.println(maap.containsKey("abc"));

    }
}

class Animal implements Serializable {
    String name;
    public Animal(String name) {
        this.name = name;
    }

    public Animal clone() {
        Animal animal = new Animal(this.name);
        return animal;
    }
}
