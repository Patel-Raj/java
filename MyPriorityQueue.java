import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class Pair {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class PairComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.freq - o1.freq;
    }
}

public class MyPriorityQueue {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(-5);
        
        //System.out.println(pq.peek());
       // System.out.println(pq.poll());
        System.out.println("------------");

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new PairComparator());
        priorityQueue.add(new Pair('a',-100));
        priorityQueue.add(new Pair('b',100));


        Iterator it = priorityQueue.iterator();
        while(it.hasNext()) {
            System.out.println(((Pair) it.next()).ch);
        }

        System.out.println(priorityQueue.poll().ch);
        System.out.println(priorityQueue.poll().ch);

        StringBuilder sb = new StringBuilder();

        System.out.println("------------");

        PriorityQueue<Integer> ppq = new PriorityQueue<>();
        ppq.add(10);
        ppq.add(-10);
        ppq.add(100);
        ppq.add(20);

        while(!ppq.isEmpty()) {
            System.out.println(ppq.poll());
        }

        Iterator iit = ppq.iterator();
        while (iit.hasNext()) {
            System.out.println(iit.next());
        }

        System.out.println("---------------__++");

        PriorityQueue<Integer> pr1 = new PriorityQueue<>(new IntegerComp());
        pr1.add(1);
        pr1.add(2);
        pr1.add(3);

        for(int i : pr1) {

            System.out.println(i);
        }
        String st1 = "abcd", s42 = "aac";
        System.out.println(st1.compareTo(s42));

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(null));

        StringBuilder s1 = new StringBuilder("abc");
        StringBuilder sb1 = new StringBuilder("abc");

        String s11 = new String("abcd");
        String s22 = new String("abcd");
        System.out.println(s11.equals(s22));

        PriorityQueue<Integer> pr2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}

class IntegerComp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}