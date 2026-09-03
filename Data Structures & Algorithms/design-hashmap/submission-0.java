class MyHashMap {

    private ArrayList<Integer> keyList;
    private ArrayList<Integer> valList; 

    public MyHashMap() {
        this.keyList = new ArrayList<>();
        this.valList = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if (!keyList.contains(key)) {
            keyList.add(key);
            valList.add(value);
        }

        else {
            int index = keyList.indexOf(key);
            valList.remove(index);
            valList.add(index, value);
        }
    }
    
    public int get(int key) {
        return (keyList.contains(key)) ? valList.get(keyList.indexOf(key)) : -1;
    }
    
    public void remove(int key) {
        if (!keyList.contains(key)) { return; }

        int index = keyList.indexOf(key);
        keyList.remove(index);
        valList.remove(index);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */