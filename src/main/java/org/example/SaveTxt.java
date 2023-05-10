package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTxt {
    private String fileWay;
    private ReaderTxt readerTxt;
    private SearchComparison searchComparison;


    public SaveTxt(String fileWay, SearchComparison searchComparison) {
        this.fileWay = fileWay;
        this.readerTxt = readerTxt;
        this.searchComparison = searchComparison;
    }


    public SaveTxt save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileWay))) {

            if (searchComparison.getArrayOne().size() >= searchComparison.getArrayTwo().size() &
                    searchComparison.getArrayOne().size() != 1) {

                for (int j = 0; searchComparison.getArrayOfIndex()[0].length > j; j++) {

                    int maxIndex = 0;
                    for (int i = 0; searchComparison.getArrayOfIndex().length > i; i++) {

                        if (searchComparison.getArrayOfIndex()[i][j] > searchComparison.getArrayOfIndex()[maxIndex][j]) {
                            maxIndex = i;
                        }
                    }

                    if (searchComparison.getArrayOfIndex()[maxIndex][j] > 0) {
                        bw.write(searchComparison.getArrayOne().get(j) +
                                ":" +
                                searchComparison.getArrayTwo().get(maxIndex) +
                                "\n");
                    } else {
                        bw.write(searchComparison.getArrayOne().get(j) + ":?\n");
                    }
                }

            } else if (searchComparison.getArrayOne().size() < searchComparison.getArrayTwo().size()) {

                for (int i = 0; searchComparison.getArrayOfIndex()[0].length > i; i++) {

                    int maxIndex = 0;
                    for (int j = 0; searchComparison.getArrayOfIndex().length > j; j++) {

                        if (searchComparison.getArrayOfIndex()[i][j] > searchComparison.getArrayOfIndex()[i][maxIndex]) {
                            maxIndex = j;
                        }
                    }

                    if (searchComparison.getArrayOfIndex()[i][maxIndex] > 0) {
                        bw.write(searchComparison.getArrayTwo().get(i) +
                                ":" +
                                searchComparison.getArrayOne().get(maxIndex) +
                                "\n"
                        );
                    } else {
                        bw.write(searchComparison.getArrayTwo().get(i) + ":?\n");
                    }
                }

            } else if (searchComparison.getArrayOne().size() == searchComparison.getArrayTwo().size() &&
                    searchComparison.getArrayOne().size() == 1) {
                bw.write(searchComparison.getArrayOne().get(0) +
                        ":" +
                        searchComparison.getArrayTwo().get(0) +
                        "\n");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
