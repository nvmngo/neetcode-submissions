class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        char[] letters = word.toCharArray();

        TrieNode current = root;
        for (char c : letters) {
            current = addWordHelper(current, c);
        }

        current.isEnd = true;
    }

    public TrieNode addWordHelper(TrieNode root, char c) {
        if (root.children[c - 'a'] == null) {
            root.children[c - 'a'] = new TrieNode();
        }

        return root.children[c - 'a'];
    }

    public boolean search(String word) {
        //do normal searching, when encounter a '.', check if following children match following char
        char[] letters = word.toCharArray();

        return searchHelperSpecial(root, letters);
    }

    public boolean searchHelperSpecial(TrieNode root, char[] letters) {

        if (root == null) return false;

        TrieNode current = root;

        for (int i = 0, n = letters.length; i < n; i++) {
            if (letters[i] != '.') {
                current = searchHelper(current, letters[i]);

                if (current == null) {
                    return false;
                }
            }

            else {

                if (i == letters.length - 1) {
                    for (TrieNode child : current.children) {
                        if (child != null) {
                            if (child.isEnd) return true;
                        }
                    }

                    return false;
                }

                for (TrieNode child : current.children) {
                    if (searchHelperSpecial(child, Arrays.copyOfRange(letters, i + 1, letters.length)) == true) {
                        return true;
                    }
                }
                return false;
            }
        }

        return current.isEnd;
    }

    public TrieNode searchHelper(TrieNode root, char c) {
        if (root.children[c - 'a'] == null) return null;

        return root.children[c- 'a'];
    }
}

class TrieNode {
    
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}
