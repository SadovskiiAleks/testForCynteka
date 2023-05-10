package org.example;

import java.util.ArrayList;

public class Compare {
    private ReaderTxt readerTxt;
    private SearchComparison searchComparison;
    private SaveTxt safeTxt;
    private String fileWayIn;
    private String fileWayOut;
    private ArrayList<String> array = new ArrayList<>();


    public Compare(String fileWayIn, String fileWayOut) {
        readerTxt = new ReaderTxt(fileWayIn).read();
        this.fileWayIn = fileWayIn;
        this.fileWayOut = fileWayOut;
        searchComparison = new SearchComparison(readerTxt.getArrayOne(), readerTxt.getArrayTwo());
    }

    public void safeCompare() {
        safeTxt = new SaveTxt(fileWayOut, searchComparison).save();

    }


    @Override
    public String toString() {
        return readerTxt.getArrayOne().toString() + "\n" + readerTxt.getArrayTwo().toString();
    }

    public SearchComparison getSearchComparison() {
        return searchComparison;
    }
}
