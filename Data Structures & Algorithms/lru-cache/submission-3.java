class LRUCache {

    private int capacity;  
    private LinkedList<Integer> queue;
    private HashMap<Integer, Integer> hashMap;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.hashMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            queue.remove(Integer.valueOf(key));
            queue.offer(key);
            return hashMap.get(key);
        } 
        return -1;
    }
    
    public void put(int key, int value) {

        if (hashMap.containsKey(key)) {
            queue.remove(Integer.valueOf(key));
        }

        else if (queue.size() == capacity) {
            hashMap.remove(queue.poll());
        }

        queue.offer(key);
        hashMap.put(key, value);
    }
}
