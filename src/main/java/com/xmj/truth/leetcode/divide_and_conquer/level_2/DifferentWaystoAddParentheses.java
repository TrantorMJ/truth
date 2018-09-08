package com.xmj.truth.leetcode.divide_and_conquer.level_2;

import java.util.ArrayList;
import java.util.List;

/**
 * author xiumj
 * create 2018-08-28 10:38
 * desc 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的* 结果。有效的运算符号包含 +, - 以及 *
 */
public class DifferentWaystoAddParentheses {

    private static final List<String> OPETATOR_LIST = new ArrayList<String>() {{
        add("+");
        add("-");
        add("*");
    }};

    public static List<Integer> diffWaysToCompute(String input) {
        List<String> params = splitMathExp(input);
        return diffWaysToCompute(params, 0, params.size() - 1);
    }

    private static List<Integer> diffWaysToCompute(List<String> params, int lo, int hi) {
        List<Integer> result = new ArrayList<>();
        if (lo == hi) { // 表达式只有一个参数，返回该数字
            int num = Integer.parseInt(params.get(lo));
            result.add(num);
        } else if (lo + 2 == hi) { // 表达式有两个参数，返回计算后的结果
            int num1 = Integer.parseInt(params.get(lo));
            int num2 = Integer.parseInt(params.get(hi));
            result.add(compute(num1, num2, params.get(lo + 1)));
        } else { // 表达式有多个参数
            for (int i = lo; i < hi; i += 2) {
                List<Integer> result1 = diffWaysToCompute(params, lo, i);
                //System.out.println("lo = " + lo + ", i = " + i + ", result1 = " + result1);
                List<Integer> result2 = diffWaysToCompute(params, i + 2, hi);
                //System.out.println("i+2 = " + (i + 2) + ", hi = " + hi + ", result2 = " + result2);
                for (Integer num1 : result1) {
                    for (Integer num2 : result2) {
                        result.add(compute(num1, num2, params.get(i + 1)));
                    }
                }
            }
        }
        return result;
    }

    private static List<String> splitMathExp(String mathExp) {
        List<String> result = new ArrayList<>();
        for (int lo = 0, hi = 0; hi < mathExp.length(); hi++) {
            if (OPETATOR_LIST.contains(String.valueOf(mathExp.charAt(hi)))) {
                result.add(mathExp.substring(lo, hi));
                result.add(String.valueOf(mathExp.charAt(hi)));
                lo = hi + 1;
            } else if (hi == (mathExp.length() - 1)) {
                result.add(mathExp.substring(lo, mathExp.length()));
            }
        }
        System.out.println("result = " + result);
        return result;
    }

    private static int compute(int num1, int num2, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                result = num1 / num2;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "11";
        List<Integer> output = diffWaysToCompute(input);
        System.out.println("output = " + output);
    }
}
