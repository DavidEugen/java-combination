package com.example.combination.file.service;

import java.io.*;

public class FileReadBasic {
    //https://jeong-pro.tistory.com/69
    public static void main(String[] args) {
        String filePath = "./upload-dir/";
        String fileName = "HELP.md";

        try {
            File file = new File(filePath + fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                System.out.println(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
