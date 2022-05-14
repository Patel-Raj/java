package functional.imerative;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    // Takes one input and return boolean as output
    // There are bi predicates as well but now its clear
    static Predicate<String> phoneValidator = (phone) -> {
        phone.charAt(0);
        return phone.length() == 10;
    };

    public static void main(String[] args) {
        System.out.println(phoneValidator.test("7575s087701"));
    }
}
