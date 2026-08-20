class PrefixTree {

    TreeNode root;

    public PrefixTree() {
        this.root = new TreeNode();
    }

    public void insert(String word) {
        //deliminating the word into letters
        char[] letters = word.toCharArray();
        
        TreeNode current = root;

        //for each character, add it into the prefix tree
        for (char c : letters) {
            current = insertHelper(current, c);
        }

        current.end = true;
    }

    public TreeNode insertHelper(TreeNode root, char c) {
        //check if the node 'c' have already exist in root children
        if (root.children[c - 'a'] == null) {
            TreeNode child = new TreeNode();
            root.children[c - 'a'] = child;
            return child;
        }
        return root.children[c - 'a'];
    }

    public boolean search(String word) {
        char[] letters = word.toCharArray();

        TreeNode current = root;
        
        for (char c : letters) {
            current = searchHelper(current, c);
            
            if (current == null) return false;
        }

        if (current.end == true) return true;
        return false;
    }

    public TreeNode searchHelper(TreeNode root, char c) {
        if (root.children[c - 'a'] == null) return null;
        else return root.children[c - 'a'];
    }

    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        TreeNode current = root;

        for (char c : letters) {
            current = searchHelper(current, c);

            if (current == null) { return false; }
        }

        return true;
    }
}

class TreeNode {
    
    TreeNode[] children;
    boolean end;

    TreeNode() {
        this.children = new TreeNode[26];
        this.end = false;
    }

    TreeNode(boolean bool) {
        this.children = new TreeNode[26];
        this.end = bool;
    }

}