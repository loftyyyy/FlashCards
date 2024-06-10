package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlashCards {

    public static void main(String[] args){
        File file = new File("Test.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("hello");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
