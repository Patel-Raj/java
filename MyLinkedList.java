import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String args[]) {
        LinkedList<Integer> ls = new LinkedList<>();
        ls.add(10);
        ls.add(20);
        ls.add(30);
        ls.add(1,5);
        System.out.println(ls);

        for(int i = 0 ; i < ls.size(); i++) {
            ls.get(i);
        }
    }
}
