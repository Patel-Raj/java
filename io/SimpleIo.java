package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SimpleIo {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Asvds");
        String a;
        int n = 10;
        System.out.println(Math.random()*n);
        System.out.println(Math.random()*n);
        System.out.println(Math.random()*n);
        System.out.println(Math.random()*n);
        System.out.println(Math.random()*n);

        InputReader io = new InputReader();

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> al;
        int mat[][] = new int[5][5];
        //Arrays.fill(mat, 10);
        for(int[] arr : mat) {
            Arrays.fill(arr, 10);
        }
        System.out.println(mat[4][3]);
        System.out.println((int)Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);
        String s1 = io.next();
        String s2 = io.next();
        System.out.println(s1);
        System.out.println(s2);
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }
        public String next() {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
    }
}
