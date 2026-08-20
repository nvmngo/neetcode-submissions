class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // the intuition for this question
        /* 
        Two sub-problems for this question:
        - Whether the structure can be COMPLETED
        - The order of the courses

        Follow the same pattern as the previous question to implement this
        - Create a HashMap storing entries of key-value pair
            - Where the 'key' will be the 'course index'
            - and the 'value' will be the 'course requisites'
        */

        //Creating the HashMap
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            hashMap.put(Integer.valueOf(i), new ArrayList<Integer>());
        }

        for (int i = 0, n = prerequisites.length; i < n; i++) {
            List<Integer> prereq = hashMap.get(Integer.valueOf(prerequisites[i][0]));
            prereq.add(prerequisites[i][1]);
        }

        //Defining the return result
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[numCourses];
        int[] added = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (canComplete(numCourses, hashMap, i, visited, res, added) == false) {
                return new int[0];
            }
        }
        
        for (int i = 0; i<  numCourses; i++) {
            if (added[i] == 0) {
                res.add(i);
            }
        }

        int[] resArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    //implement a helper method: determining whether the current course can be 'complete'
    public boolean canComplete(int numCourses, HashMap<Integer, List<Integer>> hashMap, int course, int[] visited, List<Integer> res, int[] added) {
        //base case    
        if (visited[course] == 1) {
            return false;
        }

        //recursive case
        visited[course] = 1;
        List<Integer> prereqs = hashMap.get(Integer.valueOf(course));
        for (int prereq : prereqs) {
            if (canComplete(numCourses, hashMap, prereq, visited, res, added) == false) {
                visited[course] = 0;
                return false;
            }
        }
        
        visited[course] = 0;
        prereqs.clear();
        if (added[course] == 0) {
            res.add(Integer.valueOf(course));
            added[course] = 1;
        }
        return true;
    }
}   
