class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;    

        this.cache = new HashMap<>();

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.previous = this.left;
    }

    public void remove(Node n) {
        n.previous.next = n.next;
        n.next.previous = n.previous;

        n.previous = null;
        n.next = null;
    }

    public void insert(Node n) {
        //insert the node to the right of the linkedList
        n.previous = this.right.previous;
        this.right.previous.next = n;
        n.next = this.right;
        this.right.previous = n;
    }
    
    public int get(int key) {  
        if (cache.containsKey(key)) {
            //TODO: update the linkedList
            this.remove(cache.get(key));
            this.insert(cache.get(key));

            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            this.remove(cache.get(key));
        }

        else if (cache.size() == capacity) {
            this.cache.remove(this.left.next.key);
            this.remove(this.left.next);

        }
        
        cache.put(key, new Node(key, value));
        this.insert(cache.get(key));
    }
}


public class Node {

    public int key;
    public int value;
    public Node next;
    public Node previous;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;

        this.next = null;
        this.previous = null;
    }
}