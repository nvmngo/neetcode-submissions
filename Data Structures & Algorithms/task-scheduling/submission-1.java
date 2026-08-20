class Solution {
    public int leastInterval(char[] tasks, int n) {
        //The intuition for this question:
        /* 
        The 'priority' of the different tasks:
        - The number of 'instances' of a task
            -> The 'larger' the amount of that task - the 'earlier' that 
            specific task gonne be done
        - The number of cycle needed til this task can be performed again

        The algorithm:
        - Create a HashMap, storing the entries of 'key' && 'value' pairs
        WHERE the 'key' shows the specific task
        AND the 'value' shows number of tasks of that type left
        - Implement a 'max-heap'
        WHERE the 'priority' is based on the number of instances of tasks of that type is left
        - Implement a CoolDown Queue, storing the task type that currently in cooldown
        POP the task, whenever that task is ready back to do

        - while (both the HEAP && QUEUE is NOT empty) {
            //each iteration here will be counted as one CPU cycle
            
            - Increment the cycle count

            - Decrement the cooldown of the task in Queue
                - If the cooldown = -1
                    -> Add the task back into the Heap

            - IF (!heap.isEmpty()) 
                - Poll out the task with most 'frequency'
                - Complete the task by:
                    - Update the new frequency into the HashMap
                    - IF (none of that task type is left) { Dont need to add it to the Queue }
                      ELSE { Add the task type into the Queue + the number of cycle needed til 
                      the next use }
        }

        RETURN cycle count
        */
        
        //Declaring the needed Data Structures
        HashMap<Character, Integer> hashMap = new HashMap<>();
        PriorityQueue<String[]> heap = new PriorityQueue<>(
            Comparator.comparingInt((String[] a) -> Integer.parseInt(a[0])).reversed()
        );
        Queue<String[]> queue = new LinkedList<>();

        //Registering entries of Key & Value pairs
        for (char task : tasks) {
            if (!hashMap.containsKey(task)) {
                hashMap.put(task, 0);
            }
            hashMap.put(task, hashMap.get(task) + 1);
        }
        //Registering the entries of task into the heap
        for (char key : hashMap.keySet()) {
            heap.offer(new String[]{String.valueOf(hashMap.get(key)), String.valueOf(key)});
        }

        //Starting the iteration
        int count = 0;
        while (!(heap.isEmpty() && queue.isEmpty())) {
            //increment the cycle count
            count++;
            //decrement the cooldown in queue
            if (!queue.isEmpty()) {
                for (String[] cooldown : queue) {
                    cooldown[0] = String.valueOf( Integer.parseInt(cooldown[0]) - 1 );
                }

                while (!queue.isEmpty() && queue.peek()[0].equals("-1")) {
                    String[] cooldown = queue.poll();
                    heap.offer(new String[]{String.valueOf(hashMap.get(cooldown[1].charAt(0))), cooldown[1]});
                }
            }

            //polling out tasks
            if (!heap.isEmpty()) {
                String[] task = heap.poll();
                hashMap.put(task[1].charAt(0), hashMap.get(task[1].charAt(0)) - 1);

                if (hashMap.get(task[1].charAt(0)) != 0) {
                    queue.offer(new String[]{String.valueOf(n), task[1]});
                }
            }
        }

        return count;
    }
}
