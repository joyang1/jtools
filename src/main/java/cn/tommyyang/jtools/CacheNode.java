package cn.tommyyang.jtools;

/**
 *
 * @Author : TommyYang
 * @Time : 2019-05-24 18:17
 * @Software: IntelliJ IDEA
 * @File : CacheNode.java
 *
 */
public class CacheNode {

    CacheNode pre;
    CacheNode next;
    Object key;
    Object value;

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public CacheNode() {
    }
}
