package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/7/12
 * @description --
 */


public class _208ImplementTrie {
    class TrieNode {
        boolean isEnd = false;
        // 直接创建一个26字母的数组，这样已经可以考虑到所有的下一位字母的情况
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public _208ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            int letter = word.charAt(i) - 'a';
            if (p.children[letter] == null) {
                p.children[letter] = new TrieNode();
            }
            p = p.children[letter];
        }
        // 此时在最后一个字母，将isEnd置为true
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            int letter = word.charAt(i) - 'a';
            if (p.children[letter] == null) return false;
            else p = p.children[letter];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int letter = prefix.charAt(i) - 'a';
            if (p.children[letter] == null) return false;
            else p = p.children[letter];
        }
        return true;
    }
}