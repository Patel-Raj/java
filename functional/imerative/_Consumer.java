package functional.imerative;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    // This is also a functional interface.
    static Consumer<Customer> greetCustomer = customer
            -> System.out.println("Hi " + customer.getName());

    static BiConsumer<Customer, Customer> greetTwoCustomer = (customer1, customer2)
            -> System.out.println("Hi " + customer1.getName() + " , " + customer2.getName());

    public static void main(String[] args) {
        Customer raj = new Customer("raj" , Gender.MALE);
        Customer rutva = new Customer("rutva" , Gender.FEMALE);
        greetCustomer.accept(raj);
        greetTwoCustomer.accept(raj, rutva);
    }
}

class Customer {
    private final String name;
    private final Gender gender;

    Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}