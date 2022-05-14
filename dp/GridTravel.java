package dp;

import java.util.HashMap;
import java.util.Map;

public class GridTravel {
    public static void main(String[] args) {
        int m = 0;
        int n = 2;
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(countWays(m, n, memo));
    }

    private static int countWays(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        if(memo.containsKey(key))   return memo.get(key);
        if(m == 0 || n == 0)    return 0;
        if(m == 1 && n ==1) return 1;

        int ways = countWays(m-1, n, memo) + countWays(m, n-1, memo);
        memo.put(key, ways);
        return ways;
    }
}
