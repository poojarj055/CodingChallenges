// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class:
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
//   If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

class LRUCache {
private final int capacity;
private final LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new LinkedHashMap<Integer, Integer>(10,0.8f,true){
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
            return size()>capacity;
        }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

