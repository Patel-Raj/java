import java.util.*;

// Iteration through a map
public class MyMap {
    public static void main(String args[]) {

        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "abc");
        myMap.put(2, "ppp");
        myMap.put(3, "abc");
        myMap.put(4, "ppp");

        String[] arr = myMap.values().toArray(new String[0]);
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println("----------");

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(null);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        map.put(1, 1001);
        map.put(2, 1002);
        map.put(3, 1003);
        map.put(-3, 1003);

        System.out.println(map.keySet());
        Map<String, List<String>> map112 = new HashMap<>();


        ArrayList<Integer> lis[] = new ArrayList[10];

        for(int i = 0 ; i < lis.length; i++) {

        }

        Iterator iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry aa = (Map.Entry) iterator.next();
            System.out.println(aa.getKey() + " " + aa.getValue());
        }

        /////////
        System.out.println("----------");

        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(1, 1001);
        treeMap.put(2, 1002);
        treeMap.put(3, 1003);
        treeMap.put(-3, 1003);

        Iterator treeIterator = treeMap.entrySet().iterator();

        while(treeIterator.hasNext()) {
            Map.Entry aa = (Map.Entry) treeIterator.next();
            System.out.println(aa.getKey() + " " + aa.getValue());
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pp = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return 0;
            }
        });

        HashMap<Integer, HashSet<Integer>> map1 = new HashMap<>();

        String str = "";
        char ch[] = str.toCharArray();
        System.out.println(ch.length);
        str = String.valueOf(ch);


        System.out.println(str);

        StringBuilder sb = new StringBuilder();


        for(Map.Entry entry : map1.entrySet()) {

        }

        ///

        for(int i : map1.keySet()) {
            map1.get(i).size();
        }
    }
}
