package trie;

public class MyTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        for (int i = 0; i < keys.length ; i++)
            trie.insert(keys[i]);

        System.out.println(trie.search("the"));
        System.out.println(trie.search("these"));
        System.out.println(trie.search("their"));
        System.out.println(trie.search("thaw"));
        //System.out.println(trie.search("the"));
    }
}

class Node {
    private static final int SIZE = 26;
    Node[] child;
    boolean isEnd;

    public Node() {
        child = new Node[SIZE];
        isEnd = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String str) {
        Node temp = root;
        int len = str.length();

        for(int i = 0 ; i < len ; i++) {
            int index = str.charAt(i) - 'a';

            if(temp.child[index] == null)
                temp.child[index] = new Node();

            temp = temp.child[index];
        }
        temp.isEnd = true;
    }

    public boolean search(String str) {
        int len = str.length();
        Node temp = root;

        for(int i = 0 ; i < len; i++) {
            int index = str.charAt(i) - 'a';
            if(temp.child[index] == null)   return false;
            temp = temp.child[index];
        }
        return temp.isEnd;
    }
}
