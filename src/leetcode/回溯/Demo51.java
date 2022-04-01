package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* N皇后
* */
public class Demo51 {
    List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        Demo51 demo = new Demo51();
        List<List<String>> lists = demo.solveNQueens(4);
        for (List<String> l:lists
        ){
            System.out.println(l);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        // 棋盘初始化
        char[][] chessboard = new char[n][n];
        for (char[] c:chessboard
        ){
            Arrays.fill(c, '.');
        }
        backtracking(n, 0, chessboard);
        return res;

    }

    private void backtracking(int n, int row, char[][] chessboard){
        if (row == n){
            res.add(Array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 如果放置合法
            if (isValid(row, i, n, chessboard)){
                chessboard[row][i] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][i] = '.';
            }
        }
    }
    // 将char二维数组转成字符串数组
    private List Array2List(char[][] chessboard){
       List<String> list = new ArrayList<>();
        for (char[] c :
                chessboard) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    // 检验棋盘放置是否合理
    public boolean isValid(int row, int col, int n, char[][] chessboard){
        // 检验列是否重复
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q'){
                return false;
            }
        }

        // 检验45°对角线，检验当前位置
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0 ; i--, j--) {
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }

        // 检查135°的
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
