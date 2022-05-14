package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {5,3,4,7};
        int len = arr.length;
        int[] mem = new int[1000];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        List<Integer> way = new ArrayList<>();
        System.out.println(isPossible(10, arr, mem , way));
        System.out.println(way.toString());

    }

    public static boolean isPossible(int num, int[] arr, int[] mem, List<Integer> way) {
        if(num < 0) return false;
        if(mem[num] == 1)   return true;
        if(mem[num] == 0)   return false;

        for(int i = 0 ; i < arr.length; i++) {
            boolean res = isPossible(num - arr[i], arr, mem, way);
            //mem[num - arr[i]] = res ? 1 : 0;
            if(res) {
                mem[num] = 1;
                way.add(arr[i]);
                return true;
            }
        }
        mem[num] = 0;
        return false;
    }
}
