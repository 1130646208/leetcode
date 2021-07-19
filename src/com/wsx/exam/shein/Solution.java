package com.wsx.exam.shein;

import java.util.Arrays;

/**
 * @author shuangxing.wang
 * @date 2021/7/14
 */
public class Solution {

    public static void main(String[] args) {

        String[] sa = {
                "a  b    c                       ",
                "  a  b    c                        ",
                "     a  ba      c                                    "
        };
        for (String s: sa){
            changespaceto20(s);
        }

    }
    public static String changespaceto20(String str) {
        char[] chars = str.toCharArray();
        int spaceNum = 0;
        int chNum = 0;
        int originRightIndex = -1;
        boolean flag = false;

        for (int i = chars.length-1; i >= 0 ; i--) {
            if (chars[i] == ' ' && !flag) {
                continue;
            } else if (chars[i] == ' ') {
                spaceNum ++;
            } else {
                chNum ++;
                if (!flag){
                    originRightIndex = i;
                    flag = true;
                }
            }
        }

        int newRightIndex = chNum + spaceNum * 3 - 1;
        for (int i = originRightIndex; i >= 0; i--){
            if (chars[i] == ' '){
                chars[newRightIndex--] = '0';
                chars[newRightIndex--] = '2';
                chars[newRightIndex--] = '%';
            } else {
                chars[newRightIndex--] = chars[i];
            }
        }
        System.out.println(chars);
        return Arrays.toString(chars);
    }
}
