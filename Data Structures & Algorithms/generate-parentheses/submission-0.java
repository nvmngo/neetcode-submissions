class Solution {
    public List<String> generateParenthesis(int n) {
        
        //declaring return result
        List<String> res = new ArrayList<>();

        //the intuition for this question:
        /*
        - We will have a open parens & closing parens counter
        - if the count for the open parens & closing parens EQUALS -> must add a open parens
        - else, either select open or closing
        */

        String current = "";
        helper(n, n, current, res);
        return res;
    }

    //implement helper function
    public void helper(int opens, int closens, String current, List<String> res) {

        //base case
        if (opens == 0 && closens == 0) {
            res.add("" + current);
            return;
        }

        //IF :  open parens = closing parens
        if (opens == closens) {
            current += "(";
            helper(opens - 1, closens, current, res);
            current = current.substring(0, current.length() - 1);
        }

        else {
            //Choice 1: choose open parens
            if (opens > 0) {
                current += "(";
                helper(opens - 1, closens, current, res);
                //undo
                current = current.substring(0, current.length() - 1);
            }

            //Choice 2: choose closen parens
            current += ")";
            helper(opens, closens - 1, current, res);
            current = current.substring(0, current.length() - 1);
        }
    }
}
