package me.dvsgn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_208 {
}

class Trie_208 {
    private char value;
    Set<Trie_208> children = new HashSet<>();

    public Trie_208() {

    }

    public Trie_208(char value) {
        this.value = value;
    }

    public void insert(String word) {
        var temp = this;

        for (char c : word.toCharArray()) {
            var trie = new Trie_208(c);

        }
    }

    public boolean search(String word) {
        return false;
    }

    public boolean startsWith(String prefix) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trie_208 trie208 = (Trie_208) o;
        return value == trie208.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
