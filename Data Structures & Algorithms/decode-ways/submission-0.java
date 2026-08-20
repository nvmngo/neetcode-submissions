class Solution {
    public int numDecodings(String s) {
        //The intuition for this question
        /* 
        The numbers of ways we can decode the String 
        "xxxx"

        is:
        - The number of ways we can decode the following "xxx" 
        WHERE we're considering the first "x" as the FIRST character
        
        ADD WITH

        - The number of ways we can decode the following "xx"
        WHERE we're considering the first "xx" as the FIRST character

        Perform this recursively + memoization

        ------------------
        The algorithm:
        ------------------
        
        - Implement a helper function -> input a String -> output the number of decodes
            - The method will recursively call the following recursive case
            - THE BASE CASE:
                - if (s.charAt(0) == '0') //Meaning the encode starting with '0'
                    - RETURN 0;
            - Else, create a HashMap, containing KEY & VALUE pair
                WHERE, the 'key' represent the different string
                AND, the 'value' will be the NUMBER of DECODES dedicated for that string
        */

        HashMap<String, Integer> hashMap = new HashMap<>();
        return numDecodeHelper(s, hashMap);
    }

    //implement a helper method
    public int numDecodeHelper(String s, HashMap<String, Integer> hashMap) {
        
        //base case
        if (s.length() == 0) {
            return 1;
        }
        
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (hashMap.containsKey(s)) {
            return hashMap.get(s);
        }

        if (s.length() == 1) {
            return 1;
        }

        //recursive case
        int wayOne = numDecodeHelper(s.substring(1, s.length()), hashMap);
        int wayTwo = 0;
        
        if (Integer.valueOf(s.substring(0, 2)) <= 26) {
            wayTwo = numDecodeHelper(s.substring(2, s.length()), hashMap);
        }
        
        int res = wayOne + wayTwo;
        hashMap.put(s, res);

        return res;
    }
}
