package interview;



import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        String target = "purple";
        String target1 = "skateboard";
        String[] wordBank = {"purp", "p", "ur", "le" , "purpl"};
        String[] wordBank1 = {"ab" , "abc", "cd" , "def", "abcd"};

        Map<String, Boolean> memo = new HashMap<>();
        Map<String, Integer> memo1 = new HashMap<>();

        System.out.println(constructPossible(target, wordBank, memo));
        System.out.println(constructPossible(target1, wordBank1, memo));
        System.out.println(waysToConstructPossible(target, wordBank, memo1));
        System.out.println(waysToConstructPossible(target1, wordBank1, memo1));

    }

    private static boolean constructPossible(String target, String[] bank, Map<String, Boolean> memo) {
        if(memo.containsKey(target))    return memo.get(target);
        if(target.length() == 0)    return true;

        for(int i = 0 ; i < bank.length; i++) {
            String prefix = bank[i];
            if(target.startsWith(prefix)) {
                String suffix = target.substring(prefix.length());
                boolean isPossible = constructPossible(suffix, bank, memo);
                if(isPossible) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    private static int waysToConstructPossible(String target, String[] bank, Map<String, Integer> memo) {
        if(memo.containsKey(target))    return memo.get(target);
        if(target.length() == 0)    return 1;

        int count = 0;
        for(int i = 0 ; i < bank.length; i++) {
            String prefix = bank[i];
            if(target.startsWith(prefix)) {
                String suffix = target.substring(prefix.length());
                int isPossible = waysToConstructPossible(suffix, bank, memo);
                count += isPossible;
            }
        }
        memo.put(target, count);
        return count;
    }
}
