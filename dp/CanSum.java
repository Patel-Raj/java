package dp;


import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        int num = 300;
        int[] arr = {7,14};
        Map<Integer, Boolean> memo = new HashMap<>();

        System.out.println(canSum(num, arr, memo));
    }

    private static boolean canSum(int num, int[] arr, Map<Integer, Boolean> memo) {
        if(memo.containsKey(num))   return memo.get(num);
        if(num < 0) return false;
        if(num == 0)    return true;

        for(int i = 0 ; i < arr.length; i++) {
            boolean isPossible = canSum(num-arr[i], arr, memo);
            if(isPossible)  {
                memo.put(num, true);
                return true;
            }
        }
        memo.put(num, false);
        return false;
    }
}
