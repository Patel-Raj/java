package interview;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSubsetProduct {
    public static void main(String[] args) {
        new Solver().solve();
        new Solver().backspace();
    }
}

class Solver {

    public void solve() {
        final long MOD = 1000000007;
        int[] arr = {1,2,3};
        int len = arr.length;
        long pow[] = new long[len];
        long result = 1;
        pow[0] = 1;
        for(int i = 1; i < len; i++) {
            pow[i] = (pow[i-1]*2)%MOD;
        }
        for(int i = 0; i < len; i++) {
            long times = pow[i];
            for(long j = 1; j <= times; j++) {
                result = (result*arr[i])%MOD;
            }
            System.out.println(result);
        }
        System.out.println(result);
    }

    public void backspace() {
        String str = "ABC#DD#E";
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != '#') {
                deque.add(ch);
            }
            else {
                if(deque.size() > 0) {
                    deque.removeLast();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!deque.isEmpty()) {
            stringBuilder.append(deque.poll());
        }
        System.out.println(stringBuilder.toString());
    }
}