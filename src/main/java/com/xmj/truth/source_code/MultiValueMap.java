package com.xmj.truth.source_code;

import com.sun.istack.internal.Nullable;

import java.util.List;
import java.util.Map;

/**
 * author xiumj
 * create 2018-08-15 09:29
 * desc MultiValueMap接口
 */
public interface MultiValueMap<K, V> extends Map<K, List<V>> {
    /**
     * 返回给定键的第一个值。
     *
     * @param key
     * @return
     */
    @Nullable
    V getFirst(K key);

    /**
     * 将给定的单个值添加到给定键的当前值列表中。
     *
     * @param key
     * @param value
     */
    void add(K key, @Nullable V value);

    /**
     * 将给定列表的所有值添加到给定键的当前值列表中。
     *
     * @param key
     * @param values
     */
    void addAll(K key, List<? extends V> values);

    /**
     * 将给定{@code MultiValueMap}的所有值添加到当前值。
     *
     * @param values
     */
    void addAll(MultiValueMap<K, V> values);

    /**
     * 在给定键下设置给定的单个值。
     *
     * @param key
     * @param value
     */
    void set(K key, @Nullable V value);

    /**
     * 设置下面给定的值。
     *
     * @param values
     */
    void setAll(Map<K, V> values);

    /**
     * 返回此{@code MultiValueMap}中包含的第一个值。
     *
     * @return
     */
    Map<K, V> toSingleValueMap();

}
