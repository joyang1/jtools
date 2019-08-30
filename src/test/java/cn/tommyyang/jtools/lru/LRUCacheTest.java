package cn.tommyyang.jtools.lru;

import cn.tommyyang.jtools.lru.LRUCache;
import cn.tommyyang.jtools.lru.LRUCache1;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @Author : TommyYang
 * @Time : 2019-05-26 22:13
 * @Software: IntelliJ IDEA
 * @File : LRUCacheTest.java
 *
 */
public class LRUCacheTest {

    @Test
    public void testLRU(){
        LRUCache<String, String> lruCache = new LRUCache<String, String>(3);
        lruCache.put("a", "111");
        lruCache.put("b", "222");
        lruCache.put("c", "333");
        lruCache.put("d", "444");

        Assert.assertTrue(lruCache.getCaches().size() == 3);
        Assert.assertTrue(lruCache.getFirst().getKey().toString().equals("d"));
        Assert.assertTrue(lruCache.getLast().getKey().toString().equals("b"));
    }

    @Test
    public void testLRU1(){
        LRUCache1<String, String> lruCache = new LRUCache1<String, String>(3);
        lruCache.put("a", "111");
        lruCache.put("b", "222");
        lruCache.put("c", "333");
        lruCache.put("d", "444");

        Assert.assertTrue(lruCache.size() == 3);
        System.out.println(lruCache.values());
    }

}
