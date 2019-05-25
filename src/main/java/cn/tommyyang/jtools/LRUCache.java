package cn.tommyyang.jtools;

import java.util.HashMap;

/**
 * @Author : TommyYang
 * @Time : 2019-05-24 18:14
 * @Software: IntelliJ IDEA
 * @File : LRUCache.java
 */

public class LRUCache<K, V> {

    private int currentCacheSize;
    private final int cacheCapcity;
    private HashMap<K, CacheNode> caches;
    private CacheNode first;
    private CacheNode last;

    public LRUCache(int size) {
        this.currentCacheSize = 0;
        this.cacheCapcity = size;
        caches = new HashMap<K, CacheNode>(size);
    }

    /**
     *
     * when node is first, we do nothing
     * when node is last, we need to change node's pre node to last, then move node to  first
     * when node in caches, we need to change the link of node's next node, then move node to first
     * when node not in caches, we just move node to first
     *
     * @param node
     *
     * return void
     *
     * */
    private void moveToFirst(CacheNode node){
        if (this.first == node){
            return;
        }

        if (node.next != null){
            node.next.pre = node.pre;
        }

        if (node.pre != null){
            node.pre.next = node.next;
        }

        if (this.last == node){
            this.last = this.last.pre;
        }

        if (this.first == null || last == null){
            this.first = this.last = node;
            return;
        }

        node.next = first;
        first.pre = node;
        this.first = node;
        this.first.pre = null;

    }

    /**
     *
     *
     * */
    private void removeLast(){
        if (this.last != null){

            return;
        }
    }
}
