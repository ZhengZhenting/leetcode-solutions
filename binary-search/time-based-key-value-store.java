class TimeMap {
    //TreeMap是Java中基于红黑树的有序Map,按key升序排列,O(log n)
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
		
        TreeMap<Integer, String> tMap = map.get(key);
		
		//floorEntry(timestamp),找到≤ timestamp 的最大时间戳对应的键值对,没找到就返回""
		//比如：
		//get("alice", 1) → floorEntry(1) → {1,"happy"} → "happy"
        //get("alice", 2) → floorEntry(2) → {1,"happy"} → "happy" (2不存在，取最近的1)
        //get("alice", 3) → floorEntry(3) → {3,"sad"}   → "sad"
        Map.Entry<Integer, String> entry = tMap.floorEntry(timestamp);
		
        return entry == null ? "" : entry.getValue();
    }
}
