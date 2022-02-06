package com.github.ankurpathak;
//FileReader in = new FileReader(System.getProperty("user.dir") + "/input.txt");

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        var map = new HashMap<>();
        map.put(null, "Hello");

        System.out.println(map.get(null));
    }

}