package com.xmj.truth.util;

import java.util.ArrayList;
import java.util.List;

/**
 * author xiumj
 * create 2018-08-28 15:41
 * desc 字符串工具类
 */
public class StringUtils {

    /**
     * 解析数学表表达式字符串
     * 运算符号只包含 + - * /
     *
     * @param mathExp
     * @return
     */
    public static List<String> parseMathExp(String mathExp) {
        List<String> expList = new ArrayList<>();
        int length = mathExp.length();
        for (int lo = 0, hi = 0; hi < length; hi++) {
            char chr = mathExp.charAt(hi);
            if (isOperator(chr)) {
                if (lo != hi) {
                    expList.add(mathExp.substring(lo, hi));
                }
                expList.add(String.valueOf(chr));
                lo = hi + 1;
            } else if (hi == length - 1) {
                expList.add(mathExp.substring(lo, length));
            }
        }
        return expList;
    }

    private static boolean isOperator(char chr) {
        boolean isMatch;
        switch (chr) {
            case '+':
            case '-':
            case '*':
            case '/':
                isMatch = true;
                break;
            default:
                isMatch = false;
                break;
        }
        return isMatch;
    }

    public static void main(String[] args) {
        String input = "11";
        List<String> expList = parseMathExp(input);
        System.out.println("expList = " + expList);
    }
}
