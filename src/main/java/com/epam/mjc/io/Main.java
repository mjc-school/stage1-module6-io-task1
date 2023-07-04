package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/Profile.txt");
        Profile profile = new FileReader().getDataFromFile(file);

        System.out.println("Name: " + profile.getName());
        System.out.println("Age: " + profile.getAge());
        System.out.println("Email: " + profile.getEmail());
        System.out.println("Phone: " + profile.getPhone());
    }
}
