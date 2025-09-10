package com.masterproject.app;


public class Main {
    public static void main(String[] args) {
        System.out.println("Dette er fra main");
        App.main(new String[]{});
        String str = "/Users/alhu/VSC/MCP-Apache-Wayang-test/WayangTest/Test.txt";
        WordCount.run(str);

    } 
}