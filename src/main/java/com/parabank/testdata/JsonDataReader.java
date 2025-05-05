package com.parabank.testdata;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonDataReader {
    private static final String FILE_PATH = "resources/TestDataFile.json";
     public static String getItem(String nodeName, String itemKey) {
         String item = new String();
         Gson gson = new Gson();
         try (Reader reader = new FileReader(FILE_PATH)) {
             JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
             JsonArray jsonArray = jsonObject.getAsJsonArray(nodeName);
             if (jsonArray != null) {
                 for (JsonElement element : jsonArray) {
                     JsonObject node = element.getAsJsonObject();
                     if (node.has(itemKey)) {
                         item=(node.get(itemKey).getAsString());
                     }
                 }
             } else {
                 System.out.println("No data found for node: " + nodeName);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return item;
     }
    }
