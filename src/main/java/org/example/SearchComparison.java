package org.example;

import java.util.ArrayList;

public class SearchComparison {

    private ArrayList<String> arrayOne = new ArrayList<>();
    private ArrayList<String> arrayTwo = new ArrayList<>();
    private int[][] arrayOfIndex;

    public SearchComparison(ArrayList<String> arrayOne, ArrayList<String> arrayTwo) {
        this.arrayOne = arrayOne;
        this.arrayTwo = arrayTwo;
        this.search();
    }

    private void search() {

        // Можно заменить тернарным оператором
        if (arrayOne.size() > arrayTwo.size()) {
            arrayOfIndex = new int[arrayOne.size()][arrayOne.size()];
        } else {
            arrayOfIndex = new int[arrayTwo.size()][arrayTwo.size()];
        }

        for (int i = 0; arrayTwo.size() > i; i++) {

            for (int j = 0; arrayOne.size() > j; j++) {
                String[] parts = arrayTwo.get(i).split(" ");

                for (String s : parts) {
                    arrayOfIndex[i][j] += searchWood(arrayOne.get(j), s);
                }
            }
        }
    }

    private int searchWood(String string, String word) {
        String wordOne;
        String wordTwo;
        String wordThree;
        if (string.contains(word)) {
            return 1;
        } else if (string.contains(wordOne = word.substring(0, word.length() - 1))) {
            return 1;
        } else if (string.contains(wordTwo = wordOne.substring(0, word.length() - 1))) {
            return 1;
        } else if (string.contains(wordThree = wordTwo.substring(0, word.length() - 1))) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        for (int i = 0; arrayOfIndex.length > i; i++) {
            System.out.println();
            for (int j = 0; arrayOfIndex[0].length > j; j++) {
                System.out.print(arrayOfIndex[i][j]);
                System.out.print(" ");
            }
        }
        return null;
    }

    public ArrayList<String> getArrayOne() {
        return arrayOne;
    }

    public ArrayList<String> getArrayTwo() {
        return arrayTwo;
    }

    public int[][] getArrayOfIndex() {
        return arrayOfIndex;
    }
}
