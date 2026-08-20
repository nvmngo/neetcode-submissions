class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //The intuition for this question
        /* 
        Re-describing the specification of the question:
        - Starting with the beginWord
        - Iterating through wordList
            - Pick anyword that you choose to substitute too
            - WHERE the selected word, need to have ONE exact position
            having the different characters
        - Keep picking other words until we reach endWord
        
        The algorithm:      ** USING BFS **
        - Add the 'beginWord' string into a Queue
        - While (Queue not empty)
            - Pop the layer of the iteration
                - Then offer in possible situations for the next iteration
                - Within those added situations
                    - IF those contains 'endWord' -> RETURN the ITERATION
        - If the Queue emptied out
            -> There is no such paths
            -> Return 0;
        */

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 1;
        int length = wordList.size();
        int[] visited = new int[length];

        while (!queue.isEmpty()) {
            for (int i = 0, n = queue.size(); i < n; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return res;
                }

                for (int j = 0; j < length; j++) {
                    if (visited[j] == 0) {
                        if (isValid(curr, wordList.get(j))) {
                            queue.offer(wordList.get(j));
                            visited[j] = 1;
                        }
                    }
                }
            }

            res++;
        }

        return 0;

    }

    public boolean isValid(String one, String two) {
        int count = 0;
        for (int i = 0, n = one.length(); i < n; i++) {
            if (one.charAt(i) != two.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
