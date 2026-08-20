class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //The intuition for this question
        /* 

        CREATE A GRAPH - NODES APPROACH
        ------------------------------------------------------------
        Consider this question with a 'Directed Graph' approach
        WHERE if [a, b], which means 'b' is needed to complete 'a'
        THUS, 'b' -> 'a'

        The structure can not be finished if and only if:
        - The 'number of course' given in the prerequisites DOES NOT EQUAL
        to the 'numCourses'
            - WHICH just means that we did not finish all the given course

        - and, IF IN OUR GRAPH, exist a certain 'loop'
            - WHICH, in order to finish a subject within the loop,
            you would not be able to start it, due to the prerequisites
        
        The algorithm for this question would be:
        - Create a HashMap, storing the entries of KEY & VALUE pairs
            - Course index -> Course Node
        - Loop through the prerequisites
            - Create node if not existed
            - Connect the node to each other
        - IF THE NUMBER OF NODES < numCourses
            - RETURN FALSE
        
        - Then check for loop,
            - Can do this by implementing a slow & fast pointer
            - RETURN FALSE if there is a loop
            - otherwise, RETURN TRUE

        ------------------------------------------------------------
        FASTER APPROACH: Use the 'prerequisites' matrix directly as our graph

        Each row of the matrix has 2 columns, 
            The first showing the index of a given course
            The second, shows the index of the prerequisite course
        
        Thus, in order to do (let just call the current row to be n) finish n[0],
        n[1] need to be finish. 
        BY THAT, it leads to 2 different situations:
        WHETHER:
            n[1] does not need any prerequisite
        OR  n[1] requires the completion of another course

        and the n[1] can not be completed, if and only if:
            along the direction of tracing the prerequisite, 
            exists a previous mentioned course (for example n[0])
            -> makes it impossible to do n[0],
                SINCE to do n[1] -> need n[0] -> need n[1]

        The algorithm for this question will be:
        - Consider each of the existing subject
            - checking WHETER is it possible to COMPLETE the course
        - IF a subject is missing from the prerequisites
            - return false
        */

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
