package com.lukemccrate.trie;

/**
 * Created by lmccrate on 9/18/2017.
 */
public class Test {

    public static void main(String[] args) {
        Trie foo = new Trie();
        foo.add("temporary");
        foo.add("temp");
        //foo.add("ant");
        foo.print();
    }
}
