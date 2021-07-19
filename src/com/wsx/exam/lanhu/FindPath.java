package com.wsx.exam.lanhu;

import java.util.Scanner;

/**
 * @author wsx
 * @date 2021/7/17
 */
public class FindPath {
    public static int result = 0;
    public static int n = 4;
    public static int m = 4;

    public static void main(String[] args) {
        int[][] map = new int[n][m];
        for (int i=0; i < n; i++){
            for (int j=0; j < m; j ++){
                map[i][j] = new Scanner(System.in).nextInt();
            }
        }
        int res = countPath(map, n ,m);
        System.out.println("路径条数：" + res);

    }
    public static int countPath(int[][] map, int n, int m) {
        // write code here
        //先找到经理的位置
        int managerX=0, managerY = 0;

        for (int i=0; i < n; i++){
            for (int j=0; j < m; j ++){
                if (map[i][j] == 1){
                    managerX = j;
                    managerY = i;
                }
            }
        }

        dfs(map, 3, new int[]{managerX, managerY});
        return result;
    }

    /**
     * 左0，右1
     * 上0，下1
     * axis:当前横纵坐标
     */
    public static void dfs(int[][] map, int direction, int[] axis){
        //n:行 m:列
        int m = map[0].length-1;
        int n = map.length-1;
        //递归终止：遇到-1，超出边界，找到2
        if (axis[0] < 0 || axis[0] > m || axis[1] < 0 || axis[1] > n){
            return;
        }
        if (map[axis[1]][axis[0]] == -1){
            return;
        }
        if (map[axis[1]][axis[0]] == 2) {
            result ++;
            return;
        }
        //左上
        if (direction == 0){
            dfs(map, direction, new int[]{axis[0]-1, axis[1]});
            dfs(map, direction, new int[]{axis[0], axis[1]-1});
        } else if (direction == 1){
            // 左下
            dfs(map, direction, new int[]{axis[0]-1, axis[1]});
            dfs(map, direction, new int[]{axis[0], axis[1]+1});
        } else if (direction == 2){
            //右上
            dfs(map, direction, new int[]{axis[0]+1, axis[1]});
            dfs(map, direction, new int[]{axis[0], axis[1]-1});
        } else {
            //右下
            dfs(map, direction, new int[]{axis[0]+1, axis[1]});
            dfs(map, direction, new int[]{axis[0], axis[1]+1});
        }
    }
}
