package com.parabank.testdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final String JSON_FILE_PATH = "resources/TestDataFile.json";

    public static Object[][] getTestData(String scenarioName) {
        List<Object[]> testDataList = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(JSON_FILE_PATH));
            JSONArray scenarioData = (JSONArray) jsonObject.get(scenarioName);
            for (Object obj : scenarioData) {
                JSONObject data = (JSONObject) obj;
                if (data != null) {
                    testDataList.add(new Object[]{data});
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return testDataList.toArray(new Object[0][0]);
    }


}



