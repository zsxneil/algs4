package com.my.chapter1_3.exercise;

import com.my.chapter1_3.Stack;
import com.my.util.StdOut;

/**
 * 判断括号是否配对
 * Created by neil on 2017/10/14.
 */
public class Parentheses {
    public static void main(String[] args) {
        String str1 = "[()]{}{[()()][]()}";
        String str2 = "[(])";
        StdOut.println(isParentheses(str1));
        StdOut.println(isParentheses(str2));

    }

    public static boolean isParentheses(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<chars.length;i++) {
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')') {
                if (!stack.pop().equals('('))
                    return false;
            } else if (c == ']') {
                if (!stack.pop().equals('['))
                    return false;
            } else if (c == '}') {
                if (!stack.pop().equals('{'))
                    return false;
            }
        }
        return  true;
    }
}
