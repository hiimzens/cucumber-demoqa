package com.demoqa.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtil {
    public static JsonObject loadJsonFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        JsonElement fileElement = JsonParser.parseReader((new FileReader(absolutePath)));
        return fileElement.getAsJsonObject();
    }
}