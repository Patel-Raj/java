package dp;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        String target = "abcdef";
        String[] bank = {"ab", "abc", "cd", "def", "abcd"};

        Map<String, Boolean> memo = new HashMap<>();

        System.out.println(canConstruct(target, bank, memo));
    }

    private static boolean canConstruct(String target, String[] bank, Map<String, Boolean> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target == null || target.equals("")) return true;

        for(int i = 0 ; i < bank.length; i++) {
            String prefix = bank[i];
            if(target.startsWith(prefix)) {
                boolean isPossible = canConstruct(target.substring(prefix.length()), bank, memo);
                if(isPossible) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }
}
