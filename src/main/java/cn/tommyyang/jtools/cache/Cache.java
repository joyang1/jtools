package cn.tommyyang.jtools.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author : TommyYang
 * @Time : 2019-06-09 22:50
 * @Software: IntelliJ IDEA
 * @File : Cache.java
 */
public class Cache {

    /**
     * 键值对集合
     */
    private static final Map<String, Entity> map = new HashMap<>();

    /**
     * 定时器线程池，用于清除过期缓存
     */
    private static final ScheduledExecutorService excutor = Executors.newSingleThreadScheduledExecutor();

    /**
     * 读取缓存
     *
     * @param key 键
     * @return value 值
     */
    public synchronized static Object get(String key) {
        Entity entity = map.get(key);
        return entity == null ? null : entity.value;
    }

    /**
     * 添加缓存
     *
     * @param key   键
     * @param value 值
     */
    public synchronized static void put(String key, Object value) {
        Cache.put(key, value);
    }

    /**
     * 读取缓存
     *
     * @param key   键
     * @param clazz 值类型
     * @return value
     */
    public synchronized static <T> T get(String key, Class<T> clazz) {
        return clazz.cast(Cache.get(key));
    }

    /**
     * 添加缓存
     *
     * @param key    键
     * @param data   值
     * @param expire 过期时间，单位：毫秒， 0表示无限长
     */
    public synchronized static void put(final String key, Object data, long expire) {
        Cache.remove(key);

        if (expire > 0) {
            Future future = excutor.schedule(new Runnable() {
                @Override
                public void run() {
                    map.remove(key);
                }
            }, expire, TimeUnit.MILLISECONDS);

            map.put(key, new Entity(data, future));
        } else {
            map.put(key, new Entity(data, null));
        }
    }

    /**
     * 清除缓存
     *
     * @param key 键
     * @return value 值
     */
    public synchronized static Object remove(String key) {
        Entity entity = map.remove(key);

        if (entity == null) {
            return null;
        }

        if (entity.future != null) {
            entity.future.cancel(true);
        }

        return entity.value;
    }

    /**
     * @return size
     */
    public synchronized static int size() {
        return map.size();
    }


    /**
     * 缓存实体类
     */
    private static class Entity {

        /**
         * 键值对的value
         */
        private Object value;


        /**
         * 定时器Future
         */
        private Future future;


        public Entity(Object value, Future future) {
            this.value = value;
            this.future = future;
        }

    }

}
