class TimeMap {

    private HashMap<String, HashMap<Integer, String>> keyMap;

    public TimeMap() {
        this.keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!this.keyMap.containsKey(key)) {
            this.keyMap.put(key, new HashMap<Integer, String>());
        }

        this.keyMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        
        if (!this.keyMap.containsKey(key)) {
            return "";
        }

        Integer[] time = this.keyMap.get(key).keySet().toArray(new Integer[0]);
        Arrays.sort(time);

        int left = 0;
        int right = time.length - 1;
        Integer ans = null;
        while (left <= right) {
            int middle = left + (right - left)/2;

            if (time[middle] == timestamp) {
                ans = time[middle];
                break;
            } else if (time[middle] < timestamp) {
                ans = time[middle];
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (ans == null) { return ""; }
        else {
            return this.keyMap.get(key).get(ans);
        }
    }
}
