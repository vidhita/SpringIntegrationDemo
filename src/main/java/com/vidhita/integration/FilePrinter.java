package com.vidhita.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FilePrinter {

    public void print(File file){

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
