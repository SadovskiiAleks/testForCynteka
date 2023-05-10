package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReaderTxt {
    private BufferedReader br = null;
    private String fileWay;
    private ArrayList<String> arrayTwo = new ArrayList<>();
    private ArrayList<String> arrayOne = new ArrayList<>();

    public ReaderTxt(String fileWay) {

        this.fileWay = fileWay;
    }

    public ReaderTxt read() {
        String line = null;

        try {
            br = new BufferedReader(new FileReader(fileWay));

            int base = Integer.parseInt(br.readLine());
            for (int i = 0; base > i; i++) {
                arrayOne.add(br.readLine());
            }

            int search = Integer.parseInt(br.readLine());
            for (int i = 0; search > i; i++) {
                arrayTwo.add(br.readLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия потока");
                }
            }
        }
        return this;
    }

    public ArrayList<String> getArrayTwo() {
        return arrayTwo;
    }

    public ArrayList<String> getArrayOne() {
        return arrayOne;
    }
}


