package com.lukemccrate.trie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lmccrate on 9/18/2017.
 */
public class Test {

    public static void main(String[] args) {
        List<String> temp = null;
        try {
            temp = Files.lines(new File("words_alpha.txt").toPath()).map(s -> s.trim()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(temp);
        Trie foo = new Trie();
        foo.addAll(temp);
        foo.print();
    }
}
