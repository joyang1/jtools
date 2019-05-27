package cn.tommyyang.jtools;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : TommyYang
 * @Time : 2019-05-27 22:57
 * @Software: IntelliJ IDEA
 * @File : LRUCache1.java
 */
public class LRUCache1<K,V> extends LinkedHashMap<K, V> {

    private final int cacheCapcity;

    public LRUCache1(int initialCapacity) {
        super((int)Math.ceil(initialCapacity/0.75) + 1, 0.75f, true);
        this.cacheCapcity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > this.cacheCapcity;
    }
}
