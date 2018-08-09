package com.xmj.truth.learn_code;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * author xiumj
 * create 2018-08-03 15:01
 * desc
 */
public class learnst {

    /**
     * 拼接url和请求参数
     *
     * @param urlPath
     * @param paramList
     * @return
     *//*
    private static String makeUpUrl(String urlPath, List<Param> paramList) {
        String baseUrl = urlPath;
        int index = 0;
        for (Param param : paramList) {
            String shortPath = 0 == index ? "?" : "&";
            String name = param.getName();
            String value = param.getValue();
            if (value != null || !"".equals(value)) {
                shortPath += name + "=" + value;
                baseUrl += shortPath;
                index++;
            }
        }
    }

    @Data
    public static class Param {
        private String name;
        private String value;
    }

    public static String signUrl(String url, List<Param> paramList, String algorithm, String secret) {
        Map<String, String> sortedParams = new TreeMap<>();
        paramList.stream().forEach(param -> {
            String name = param.getName();
            String value = param.getValue();
            if (value != null || !"".equals(value)) {
                sortedParams.put(name, value);
            }
        });
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

    }*/
}
