package LeetCode.TrieNode;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_208 {
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ',0,new HashMap<>());
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        TrieNode nextNode;
        for(int i = 0;i<word.length();i++)
        {
            char currC = word.charAt(i);
            Map<Character,TrieNode> childMap = curr.nodeMap;
            if(childMap.containsKey(currC))
            {
                nextNode = childMap.get(currC);
            }
            else
            {
                nextNode = new TrieNode(currC,0,new HashMap<>());
                childMap.put(currC,nextNode);
            }
            curr = nextNode;
        }
        curr.freq++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++)
        {
            char currC = word.charAt(i);
            Map<Character,TrieNode> childMap = curr.nodeMap;
            if(!childMap.containsKey(currC))
                return false;
            curr = childMap.get(currC);
        }
        if(curr.freq == 0) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0;i<prefix.length();i++)
        {
            char currC = prefix.charAt(i);
            Map<Character,TrieNode> childMap = curr.nodeMap;
            if(!childMap.containsKey(currC))
                return false;
            curr = childMap.get(currC);
        }
        return true;
    }
}

class TrieNode {
    char ch;
    int freq;
    Map<Character, TrieNode> nodeMap;

    public TrieNode(char ch, int freq, Map<Character, TrieNode> nodeMap) {
        this.ch = ch;
        this.freq = freq;
        this.nodeMap = nodeMap;
    }
}

