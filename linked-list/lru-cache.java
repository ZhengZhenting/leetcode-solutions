class LRUCache {
    Map<Integer,Integer> map;
    int capacity;

    public LRUCache(int capacity) {
	//LinkedHashMap(int initialCapacity,float loadFactor,boolean accessOrder)
	//开启accessOrder = true,每次访问元素，该元素会被移动到链表尾部（最新）
	//LinkedHashMap自带removeEldestEntry方法，默认return false
	//这里override改写成return size() > LRUCache.this.capacity;，如果当前元素数量 > 容量，会返回true,删除eldest的元素
        this.capacity=capacity;
        this.map=new LinkedHashMap<>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key,-1);        
    }
    
    public void put(int key, int value) {
        map.put(key,value);        
    }
}
