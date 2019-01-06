package com.example.andrew.myapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

import static java.security.AccessController.getContext;

public class DataSample {

    public static List<DataItem> dataItemList;

    static {
        dataItemList = new ArrayList<>();

        dataItemList.add(new DataItem(1 ,"item1","1", "2","3","4","5","6:25",""));
        dataItemList.add(new DataItem(2 ,"item2","23", "24","53","43","52","8:12",""));
        dataItemList.add(new DataItem(3 ,"item3","35","64", "132","123","42","10:32",""));
        dataItemList.add(new DataItem(4 ,"item4","", "","","","","",""));
        dataItemList.add(new DataItem(5 ,"item5","", "","","","","",""));
        dataItemList.add(new DataItem(6 ,"item6","", "","","","","",""));
        dataItemList.add(new DataItem(7 ,"item7","", "","","","","",""));
        dataItemList.add(new DataItem(8 ,"item8","", "","","","","",""));
        dataItemList.add(new DataItem(9 ,"item9","", "","","","","",""));
        dataItemList.add(new DataItem(10 ,"item10","", "","","","","",""));


    }

    private void generateList(){
        File folder = new File("your/path");

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
}
