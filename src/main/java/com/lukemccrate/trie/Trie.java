package com.lukemccrate.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmccrate on 9/18/2017.
 */
public class Trie {
    private TrieNode head;

    public Trie() {
        head = new TrieNode("", false);
    }

    public void add(String val) {
        TrieNode curr = head;
        int pos = 1;
        while(pos < val.length() && curr.get(val.substring(0, pos)) != null){
            curr = curr.get(val.substring(0, pos));
            pos++;
        }
        if(pos == val.length()){
            curr.makeWord();
        } else {
            for (; pos <= val.length(); pos++) {
                if (pos <= val.length() - 1) {
                    curr.addBranch(new TrieNode(val.substring(0, pos), false));
                    curr = curr.get(val.substring(0, pos));
                } else {
                    curr.addBranch(new TrieNode(val.substring(0, pos), true));
                }
            }
        }
    }

    public void print() {
        head.print("", true);
    }

    private class TrieNode {
        private String val;
        private boolean word;
        private List<TrieNode> branches;

        protected TrieNode(String val, boolean word) {
            this.val = val;
            this.word = word;
            branches = new ArrayList<>();
        }

        protected List<TrieNode> getBranches(){
            return branches;
        }

        protected TrieNode get(String val) {
            for(int i = 0; i < branches.size(); i++) {
                if(branches.get(i).val.equals(val)){
                    return branches.get(i);
                }
            }
            return null;
        }

        protected void addBranch(TrieNode val) {
            branches.add(val);
        }

        protected void makeWord() {
            word = true;
        }

        protected void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + val);
            for (int i = 0; i < branches.size() - 1; i++) {
                branches.get(i).print(prefix + (isTail ? "    " : "│   "), false);
            }
            if (branches.size() > 0) {
                branches.get(branches.size() - 1)
                        .print(prefix + (isTail ?"    " : "│   "), true);
            }
        }
    }
}
