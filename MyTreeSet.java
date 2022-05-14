import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String args[]) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(1);
        ts.add(2);

        Iterator it = ts.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // TreeSet with custom objects

        TreeSet<Pair1> ts1 = new TreeSet<>(new PairComp1());
        
        Pair1 p1 = new Pair1(1,2);
        Pair1 p2 = new Pair1(10,20);
        ts1.add(p1);
        ts1.add(p2);
        p2.a = 1;
        p2.b = 2;
        //ts1.add(p);


        for(Pair1 pp : ts1) {
            System.out.println(pp.toString());
        }

    }
}

class Pair1 {
    int a;
    int b;

    public Pair1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Pair1{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

class PairComp1 implements Comparator<Pair1>{

    @Override
    public int compare(Pair1 o1, Pair1 o2) {
        return (o1.a == o2.a) && (o1.b == o2.b) ? 0 : o1.a - o2.a;
    }
}