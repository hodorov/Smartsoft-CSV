package com.smartsoft.main.service;

import com.smartsoft.main.model.Record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVService {

    public static List<Record> parseCSVFileToRecords() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("./test_case.csv"));
        ArrayList<Record> records = new ArrayList<>();
        file.readLine(); // Drop 1-st line
        String line;
        while ((line = file.readLine()) != null) {
            records.add(new Record(line));
        }
        file.close();
        return records;
    }
}
