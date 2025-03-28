package com.dsa.trie;

public class Trie {
    TrieNode root;

    public Trie () {
        root = new TrieNode ( );
    }

    public void insert ( String text ) {
        TrieNode node = root;
        for (int i = 0; i < text.length ( ); i++) {
            Character c = text.charAt ( i );
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode ( );
            }
            node = node.children[c - 'a'];
        }

        node.isEnd = true;
    }

    public boolean search ( String text ) {
        TrieNode node = root;
        for (int i = 0; i < text.length ( ); i++) {
            Character c = text.charAt ( i );

            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }

        if (!node.isEnd) {
            return false;
        }

        return true;
    }

    public boolean startsWith ( String text ) {
        TrieNode node = root;

        for (int i = 0; i < text.length ( ); i++) {
            Character c = text.charAt ( i );
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];

        }

        return true;
    }


    public static void main ( String[] args ) {
        Trie trie = new Trie ( );

        // Insert words for more thorough testing.
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("banana");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("car");
        trie.insert("cat");
        trie.insert("dog");
        trie.insert("do");

        // Test search method
        System.out.println("Search 'apple': " + (trie.search("apple") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("Search 'app': " + (trie.search("app") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("Search 'application': " + (trie.search("application") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("Search 'appl': " + (trie.search("appl") ? "\u001B[32mFailed\u001B[0m" : "\u001B[31mFailed\u001B[0m")); // Should be false
        System.out.println("Search 'banana': " + (trie.search("banana") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("Search 'ban': " + (trie.search("ban") ? "\u001B[32mFailed\u001B[0m" : "\u001B[31mFailed\u001B[0m")); // Should be false
        System.out.println("Search 'dog': " + (trie.search("dog") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("Search 'do': " + (trie.search("do") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("Search 'd': " + (trie.search("d") ? "\u001B[32mFailed\u001B[0m" : "\u001B[31mFailed\u001B[0m")); // should be false
        System.out.println("Search 'xyz': " + (trie.search("xyz") ? "\u001B[32mFailed\u001B[0m" : "\u001B[31mFailed\u001B[0m")); // should be false

        // Test startsWith method
        System.out.println("startsWith 'app': " + (trie.startsWith("app") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'appl': " + (trie.startsWith("appl") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'bana': " + (trie.startsWith("bana") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'car': " + (trie.startsWith("car") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'ca': " + (trie.startsWith("ca") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'd': " + (trie.startsWith("d") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'do': " + (trie.startsWith("do") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'dog': " + (trie.startsWith("dog") ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
        System.out.println("startsWith 'xyz': " + (trie.startsWith("xyz") ? "\u001B[31mFailed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
    }
}
