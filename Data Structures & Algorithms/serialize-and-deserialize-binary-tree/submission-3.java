/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
        take advantage out of PRE-ORDER and IN-ORDER
        encode the trees into a double array of PRE-ORDER and IN-ORDER
    
            OR
        
        use BFS to have an array, indicating the level


        - but PRE-ORDER and IN-ORDER would only be enough for binary tree with unique value
        - thus we need to go with the BFS approach, storing the value of the tree in each level
        */

        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = 0, n = queue.size(); i < n; i++) {
                TreeNode node = queue.poll();
                
                if (node == null) {
                    res.add(null);
                    continue;
                }

                res.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        String resString = "";
        for (int i = 0, n = res.size(); i < n - 1; i++) {
            resString += (res.get(i) + ",");
        }
        resString += res.get(res.size() - 1);

        return resString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;

        String[] values = data.split(",");

        //declaring the root
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(values[i]));
        i++;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (i < values.length) {
            if (values[i].equals("null")) queue.peek().left = null;
            else {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(left);

                queue.peek().left = left;
            }

            i++;

            if (values[i].equals("null")) queue.peek().right = null;
            else {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(right);

                queue.peek().right = right;
            }

            queue.poll();
            i++;
        }

        return root;
        
    }

}
