package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenMain {
    public static void main(String[] args) {
        List<List<String>> res = new Solution().solveNQueens(4);
        for(List<String> list : res) {
            for(String str : list) {
                System.out.println(str);
            }
        }
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();

        findSol(grid, 0 , 0, n, res);
        return res;
    }
    private void findSol(boolean[][] grid, int r, int c, int n, List<List<String>> res) {
        if(r >= n)  return;

        //for(int i = r; i < n; i++) {
        for(int j = c; j < n; j++) {
            if(checkIfPossible(grid, r, j, n)) {
                grid[r][j] = true;
                findSol(grid, r+1, 0, n, res);
                if(r == n-1) {
                    if(isStateGood(grid, n)) {
                        saveResult(grid, n, res);
                    }
                }
                grid[r][j] = false;
            }
        }
        //}
    }

    private boolean checkIfPossible(boolean[][]grid, int r, int c, int n) {
        boolean present = grid[r][c];
        // up
        for(int i = r-1; i>=0; i--) {
            present = present || grid[i][c];
        }

        // left
        for(int j = c-1; j>=0; j--) {
            present = present || grid[r][j];
        }

        // left diag
        for(int i = r-1, j = c-1; i >=0 && j>=0; j--, i--) {
            present = present || grid[i][j];
        }

        // right diag
        for(int i = r-1, j = c+1; i >=0 && j< n; j++, i--) {
            present = present || grid[i][j];
        }
        return !present;
    }

    private boolean isStateGood(boolean[][]grid, int n) {
        int totalCount = 0;
        int rowCount = 0;
        int colCount = 0;

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                if(grid[i][j]) {
                    totalCount++;
                    rowCount++;
                    if(rowCount >=2 )   return false;
                }
                if(grid[j][i]) {
                    colCount++;
                    if(colCount >=2 )   return false;
                }
            }
            rowCount = 0;
            colCount = 0;
        }
        if(totalCount < n)  return false;
        return true;
    }

    private void saveResult(boolean[][]grid, int n, List<List<String>> res) {
        StringBuilder sb;
        ArrayList<String> al = new ArrayList<>();

        for(int i = 0 ; i < n; i++) {
            sb = new StringBuilder();
            for(int j = 0 ; j < n; j++) {
                if(grid[i][j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            al.add(sb.toString());
        }
        res.add(al);
    }
}