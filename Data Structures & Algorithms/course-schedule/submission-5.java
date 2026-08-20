class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //iterating through each of the subject
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (canFinishHelper(numCourses, prerequisites, i, visited) == false) {
                return false;
            };
        }

        return true;
    }

    //implement a helper method: checking whether subject 'index' can be completed
    public boolean canFinishHelper(int numCourses, int[][] prerequisites, int index, List<Integer> visited) {
        
        if (visited.contains(Integer.valueOf(index))) {
            return false;
        }
        visited.add(Integer.valueOf(index));

        //finding all requisite of the course index
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == index) {
                if (canFinishHelper(numCourses, prerequisites, prerequisites[i][1], visited) == false) {
                    visited.remove(visited.size() - 1);
                    return false;
                }
            }
        }

        visited.remove(visited.size() - 1);
        return true;
    }
}
