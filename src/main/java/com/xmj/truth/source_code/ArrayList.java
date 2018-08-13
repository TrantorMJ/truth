package com.xmj.truth.source_code;

import java.util.*;

/**
 * author xiumj
 * create 2018-08-13 15:46
 * desc ArrayList源代分析
 * modXCount:该字段继承自java.util.AbstractList,为了防止在多线程操作的情况下，list发生结构性的变化
 * remark 未完成
 */
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    // 默认初始容量为10
    private static final int DEFAULT_CAPACITY = 10;

    // 空对象数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    // 空对象数组，供默认构造方法调用
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    // 当前数据存放的地方，不参与序列化
    transient Object[] elementData;

    // 当前列表大小
    private int size;

    // 带参数构造方法
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = this.EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // 无参构造方法
    public ArrayList() {
        this.elementData = this.DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // Collection构造函数
    public ArrayList(Collection<? extends E> c) {

        // 1.将Collection转换为Object数组，并将数组地址赋给elementData
        elementData = c.toArray();

        // 更新size的值，同时判断size的大小，如果size的值大于0，则进行深拷贝，否则将空列表赋值给elementData
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            this.elementData = this.EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 将ArrayList的容量设置为当前size的大小，去除没有用到的null值空间
     * <p>
     * ArrayList的size个数就是ArrayList的元素个数,length是ArrayList申请的内容空间长度。ArrayList每次都会预申请多一点空间，以便添加元素的时候不需要每次都进行扩容操作
     */
    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }


    public void insureCapacity(int minCapacity) {
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                ? 0
                : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    // 获取最小扩容容量
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    // 判断是否需要扩容
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * ArrayList动态扩容核心方法
     */
    private void grow(int minCapacity) {

        // 获取ArrayList中elementData数组的内存空间长度
        int oldCapacity = elementData.length;
        // 扩容至原来的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        // 再判断一下数组的容量够不够，够了就直接使用这个长度创建新数组，不够就将新数组设置为需要的长度
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;

        // 判断有没有超过最大限制
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);

    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;

    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }


    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
    

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
