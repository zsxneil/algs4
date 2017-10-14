package com.my.chapter1_3;

import com.my.util.StdOut;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 计算输入的表达式的值。只支持+ - * /，以及sqrt()
 * 表达式不能省略任何括号，数字和字符均以空白字符相隔
 * 用两个栈，一个保存运算符，一个保存操作数
 *
 * 算法：
 *  -将操作数压入操作数栈
 *  -将运算符压入运算符栈
 *  -忽略左括号
 *  -当遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
 * Created by Administrator on 2017/10/14.
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        //String evaluater = "sqrt ( 4 )";
        //String evaluater = "( 1 - 2 )";
        String evaluater = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] evaluaters = evaluater.split(" "); //字符串必须以单空格隔开
        for(int i=0; i<evaluaters.length; i++) {
            //读取字符，如果是运算符则压入栈
            String s = evaluaters[i];
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) { //如果是右括号，弹出运算符合操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v= Math.sqrt(v);
                vals.push(v);
            }
            //如果字符既非运算符也不是括号，将它作为double值压入栈
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
