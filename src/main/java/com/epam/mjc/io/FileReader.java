package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(absolutePath)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> map = stringToMap(sb.toString());
        String name = map.get("Name");
        int age = Integer.parseInt(map.get("Age"));
        String email = map.get("Email");
        long phone = Long.parseLong(map.get("Phone"));

        return new Profile(name, age, email, phone);
    }

    public Map<String, String> stringToMap(String text) {
        Map<String, String> map = new LinkedHashMap<>();

        String[] profile = text.split("(: )|\n");
        for (int i = 0; i < profile.length; i += 2) {
            map.put(profile[i], profile[i + 1]);
        }
        return map;
    }
}
