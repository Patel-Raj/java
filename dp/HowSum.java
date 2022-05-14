package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        int num = 7;
        int[] arr = {5,3,4,1};
        Map<Integer, Boolean> memo = new HashMap<>();
        List<Integer> track = new ArrayList<>();
        System.out.println(howSum(num, arr, memo, track));
        System.out.println(track);
    }
    private static boolean howSum(int num, int[] arr, Map<Integer, Boolean> memo, List<Integer> track) {
        if(memo.containsKey(num))   return memo.get(num);
        if(num < 0) return false;
        if(num == 0)    return true;

        for(int i = 0 ; i < arr.length; i++) {
            boolean isPossible = howSum(num-arr[i], arr, memo, track);
            if(isPossible)  {
                track.add(arr[i]);
                memo.put(num, true);
                return true;
            }
        }
        memo.put(num, false);
        return false;
    }

}
