package com.github.ankurpathak;
//FileReader inFile = new FileReader(System.getProperty("user.dir") + "/input.txt");


import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {

        var list = new LinkedList<Integer>();

        list.add(4);
        var itr4 = list.listIterator(list.size() - 1);


        list.add(5);
        var itr5 = list.listIterator(list.size() - 1);


        list.listIterator(list.size() - 1).add(5);

        itr4.next();
        itr4.remove();


        itr5.next();
        itr5.remove();


    }
}








