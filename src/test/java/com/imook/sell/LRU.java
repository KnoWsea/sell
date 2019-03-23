package com.imook.sell;

import com.imook.sell.single.Apple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author KnoWsea
 * @create 2019-03-21 23:24
 */
public class LRU {
    private int capacity;

    private Map<Integer, Object> cache;

    LinkedList<Integer> list;

    public LRU(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        list = new LinkedList<>();
    }

    public void put(int key, Object value){
        cache.put(key, value);
        if(!list.contains(key)){
            list.add(key);
        }
        afterPut();
    }

    public void afterPut(){
        if(list.size() > capacity){
            Integer key = list.removeFirst();
            cache.remove(key);
        }
    }

    public Object get(Integer key) throws Exception {
        if(cache.containsKey(key)){
            list.remove(key);
            list.add(key);
            return cache.get(key);
        }else{
            throw new Exception("值不存在");
        }
    }
}
class test{
    public static void main(String[] args) throws Exception {
        LRU lru = new LRU(5);
        lru.put(1,"233232");
        lru.put(2, 13213);
        lru.put(3, new Apple());
        lru.get(2);
        lru.get(1);
        lru.put(4, 1.21221);
        lru.put(5, 'd');
        lru.put(6, 'f');
        System.out.println(lru.get(3));
    }
}
