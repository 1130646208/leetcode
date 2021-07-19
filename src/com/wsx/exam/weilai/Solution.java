package com.wsx.exam.weilai;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shuangxing.wang
 * @date 2021/7/18
 * 括号序列是否合法
 */
public class Solution {
    public static boolean isValid (String s) {
        if ((s.length() & 1) == 1 || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(16);
        // write code here
        char[] string = s.toCharArray();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char ch: s.toCharArray()){
            //首次
            if (stack.isEmpty()) {
                if (map.get(ch) == null) {
                    return false;
                }
                stack.push(map.get(ch));
                continue;
            }
            //看栈顶元素是否等于当前元素
            if (ch == stack.peek()) {
                //等于就pop出来，相当于匹配了一对括号
                stack.pop();
            } else {
                //不能匹配成功并且来的是右括号 直接返回false
                if (map.get(ch) == null) {
                    return false;
                }
                //不能匹配并且来的是左括号，入栈相对应的有右括号
                stack.push(map.get(ch));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("["));
        System.out.println(isValid("]"));
        System.out.println(isValid("{}}"));
        System.out.println(isValid("[{]}"));
        System.out.println(isValid(""));
        System.out.println("-------------");
        System.out.println(isValid("[]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("[{}]{}{}()"));
        System.out.println(isValid("({[]})"));

    }
}
