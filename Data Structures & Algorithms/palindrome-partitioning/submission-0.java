class Solution {
    public List<List<String>> partition(String s) {
        //Declaring returning list
        List<List<String>> res = new LinkedList<>();
        
        /*
        Intuition on this question:
        - Go through every different situation,
        WHERE a situation will be defined by the current list, and the un-splitted remains
        CREATE a helper function to determine whether the current option is splitting is creating a palindrome
            IF (PALINDROME)
                EITHER CUT
                OR IGNORE
            IF NOT (PALINDROME)
                IGNORE (SKIPPING)
        */

        List<String> current = new LinkedList<>();
        current.add(s);

        partitionHelper(0, current, res);

        return res;
    }

    public void partitionHelper(int index, List<String> current, List<List<String>> res) {
        //base case
        if (index == current.get(current.size() - 1).length() - 1) {
            if (isPalindrome(current.get(current.size() - 1))) {
                res.add(new LinkedList<>(current));
            }
            return;
        }

        

        //recursive case
            //CASE 1:   isPalindrome
        if (isPalindrome(current.get(current.size() - 1).substring(0, index + 1))) {
            //CHOICE 1: SPLIT
            String s = current.remove(current.size() - 1);
            current.add(s.substring(0, index + 1));
            current.add(s.substring(index + 1, s.length()));

            partitionHelper(0, current, res);

            //undo
            current.remove(current.size() - 1);
            current.remove(current.size() - 1);
            current.add(s);

            //CHOICE 2: SKIP
            partitionHelper(index + 1, current, res);
        }

        else {
            partitionHelper(index + 1, current, res);
        }
        
    }

    public boolean isPalindrome(String s) {
        //using 2 pointers
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) { return false; }
            l++;
            r--;
        }

        return true;
    }

}
