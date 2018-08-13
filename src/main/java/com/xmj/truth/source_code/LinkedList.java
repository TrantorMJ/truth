package com.xmj.truth.source_code;

import java.io.Serializable;
import java.util.*;

/**
 * author xiumj
 * create 2018-08-01 18:44
 * desc LinkedList源码分析
 * remark 未完成
 */
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {

    /**
     * 节点类
     *
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * transient:
     * 1.被transient修饰的变量不再是对象持久化的一部分；
     * 2.transient只能修饰变量，不能修饰类和方法；
     * 3.一个静态变量不管是否被transient修饰，均不能被序列化
     * 4.transient只有在类实现的是Serializable接口时才有效
     */
    transient int size = 0;

    /**
     * 指向头结点
     * 不变式: (first==null&&last==null)||(first.prev==null&&first.item!=null)
     */
    transient Node<E> first;

    /**
     * 指向尾节点
     * 不变式: (first==null&&last==null)||(last.next==null&&last.item!=null)
     */
    transient Node<E> last;

    /**
     * 构造一个空链表
     */
    public LinkedList() {
    }

    /**
     * 链接e作为第一个元素
     *
     * @param e
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node(null, e, f);
        first = newNode;
        if (f == null) // 如果原链表为空链表，则将last指针指向新节点，此时first和last指针指向同一个节点，否则将原头结点的next指针指向新节点
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++; // 此变量用于记录链表结构被修改的次数
    }

    /**
     * 链接e作为最后一个元素
     *
     * @param e
     */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node(l, e, null);
        if (l == null) // 如果原链表为空链表，则将first指针指向新节点，此时first和last指针指向同一个节点，否则将原尾节点的prev指针指向新节点
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 在非空节点succ前插入节点e
     *
     * @param e
     * @param succ
     */
    void linkBefore(E e, Node<E> succ) {
        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) // 如果原链表只有一个节点，则将first指针指向新节点，否则将succ的前一个节点的next指针指向新节点
            first = newNode;
        else
            prev.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 删除头结点
     *
     * @param f
     * @return
     */
    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // 防止对象游离
        if (next == null) // 如果原链表只有一个节点，则将last指针指向null，否则将原头结点后一个节点的prev节点指向null
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;

    }

    /**
     * 删除尾节点
     *
     * @param l
     * @return
     */
    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // 防止对象游离
        last = prev;
        if (prev == null) // 如果原链表只有一个节点，则将first指针指向null，否则将原尾结点后一个节点的next节点指向null
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * 删除非空节点x
     *
     * @param x
     * @return
     */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * 返回链表的第一个节点值
     *
     * @return
     */
    public E getFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    /**
     * 返回链表的最后一个节点值
     *
     * @return
     */
    public E getLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    /**
     * 删除并返回链表的第一个节点
     *
     * @return
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    /**
     * 删除并返回链表的最后一个节点
     *
     * @return
     */
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    /**
     * 在链表头部添加节点
     *
     * @param e
     */
    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * 在链表尾部添加节点
     *
     * @param e
     */
    public void addLast(E e) {
        linkLast(e);
    }

    /**
     * 链表是否包含指定的值
     *
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * 删除链表中第一个匹配的元素
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将指定集合中的元素添加到链表的末尾
     *
     * @param c
     * @return
     */
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        }

        // 找到插入点位置，当前节点和前一个节点
        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            E e = (E) o;
            Node<E> newNode = new Node(pred, e, null);
            if (pred == null) {
                first = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }

    /**
     * 移除链表中的所有元素
     */
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            // 保存当前节点下一个节点的引用
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = x.next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    /**
     * 用指定值替换指定位置的节点的值，返回旧值
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 在指定位置之前插入指定的值
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /**
     * 移除指定位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }


    /**
     * 判断指定位置的元素是否存在
     *
     * @param index
     * @return
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 返回指定位置的元素
     *
     * @param index
     * @return
     */
    Node<E> node(int index) {
        // 判断索引位置是在链表前半部分还是后半部分
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 返回指定元素在链表中第一次出现的位置，如果该元素不存在，返回-1
     * 指定元素可以为null
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * 返回指定元素在链表中最后一次出现的位置
     *
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

    /**
     * 选取链表的第一个元素
     *
     * @return
     */
    public E peek() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

    public E element() {
        return getFirst();
    }

    public E poll() {
        final Node<E> f = first;
        return (f == null) ? null : unlink(f);
    }

    public E remove() {
        return removeFirst();
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peekFirst() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

    public E peekLast() {
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }

    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            next = index == size ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            checkForComodification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();
            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

        int i = 0;
        Object[] result = a;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;

        if (a.length > size)
            a[size] = null;

        return a;
    }
}
