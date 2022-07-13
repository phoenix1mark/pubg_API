package com.example.myapplicationapipbg.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserTest {


    private static void parser(JSONObject jsonObject, String parentId, List<Map<String, String>> result) throws JSONException {
        String currentId = parentId;

        if (jsonObject.has("id") && jsonObject.has("title")) {
            Map<String, String> object = new HashMap<>();
            currentId = jsonObject.getString("id");
            object.put("id", currentId);
            object.put("name", jsonObject.getString("title"));
            object.put("parent", parentId);
            result.add(object);
        }




/*        for (Map.Entry<String, JsonElement> fieldName : jsonObject.entrySet())
            if (jsonObject.get(fieldName.getKey()) instanceof JsonArray) {
                JsonArray array = jsonObject.getAsJsonArray(fieldName.getKey());
                for (int i = 0; i < array.size(); i++)
                    parser(array.get(i).getAsJsonObject(), currentId, result);
            }*/
    }



}
