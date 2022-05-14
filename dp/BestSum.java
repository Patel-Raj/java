package dp;

import java.util.*;

public class BestSum {
    public static void main(String[] args) {
        int num = 7;
        int[] arr = {5,3,4,7};
        Map<Integer, List<Integer>> memo = new HashMap<>();

        List<Integer> ans = bestSum(num, arr, memo);
        System.out.println(ans);
    }

    private static List<Integer> bestSum(int num, int[] arr, Map<Integer, List<Integer>> memo) {
        if(memo.containsKey(num))   return memo.get(num);
        if(num < 0) return null;
        if(num == 0)    return new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            List<Integer> temp = bestSum(num - arr[i], arr, memo);

            if(temp != null) {
                List<Integer> l1 = new ArrayList<>(temp);

                //Collections.copy(l1, temp);
                l1.add(arr[i]);
                if(memo.containsKey(num)) {
                    if(l1.size() < memo.get(num).size()) {
                        memo.put(num, l1);
                    }
                } else {
                    memo.put(num, l1);
                }
            }
        }
        return memo.get(num);
    }
}
