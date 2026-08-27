class CountSquares {

    private HashMap<Integer, List<int[]>> xValues;
    private HashMap<Integer, List<int[]>> yValues;

    private int count;

    public CountSquares() {
        this.xValues = new HashMap<>(); // map an x value -> list of points with that x - val
        this.yValues = new HashMap<>(); // map an y value -> list of points with that y - val
        this.count = 0;                 // counter for the number points
    }
    
    public void add(int[] point) {
        this.count++;

        this.xValues.putIfAbsent(point[0], new ArrayList<int[]>());  // registering the different map for this key 
        this.yValues.putIfAbsent(point[1], new ArrayList<int[]>());

        this.xValues.get(point[0]).add(point);
        this.yValues.get(point[1]).add(point);   // registering the different point to this key
    }
    
    public int count(int[] point) {
        // edge cases
        if (this.count < 3) { return 0; }    // where there is not enough points to form a square

        if (!this.xValues.containsKey(point[0]) || !this.yValues.containsKey(point[1])) {   // where there is no point
            return 0;                                                                       // that can be matched
        }

        // implementation
        int res = 0;
        // looping through each of the different points on the same x-line
        for (int[] x : this.xValues.get(point[0])) {
            // skipping if identical point
            if (x[0] == point[0] && x[1] == point[1]) {
                continue;
            }
            
            // selected combination
            int length = Math.abs(point[1] - x[1]);

            for (int[] y : this.yValues.get(point[1])) {
                // if matching length
                if (Math.abs(point[0] - y[0]) == length) {

                    for (int[] fin : this.xValues.get(y[0])) {
                        if (fin[1] == x[1]) {
                            res++;
                        }
                    }
                } 
            }
        }

        return res;
    }
}
