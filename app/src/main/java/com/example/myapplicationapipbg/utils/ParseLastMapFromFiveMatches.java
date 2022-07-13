package com.example.myapplicationapipbg.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParseLastMapFromFiveMatches {

    public static ArrayList<String> reguest7 (String stringJ, String nickName) {


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<ArrayList> future = executorService.submit(() -> {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            ArrayList <String> arr1 = new ArrayList<>(2);

/////////////////парс
            JSONObject object1 = new JSONObject(stringJ);
            String str1 =  object1.getJSONObject("data").toString();
            JSONObject object2 = new JSONObject(str1);
            String str2 =  object2.getJSONObject("attributes").toString();
            JSONObject object3 = new JSONObject(str2);

            arr1.add(object3.get("createdAt").toString());// index 0
            arr1.add(object3.get("mapName").toString()); // index 1
///////////////

            JSONArray arrayIncluded = object1.getJSONArray("included");


            for (int i = 0; i < arrayIncluded.length(); i++) {
                String rep1 = "";

                JSONObject jsOBJ1 = arrayIncluded.getJSONObject(i);
                rep1 = jsOBJ1.getString("type");

                if (rep1.equals("participant") && jsOBJ1.getJSONObject("attributes").getJSONObject("stats").getString("name").equals(nickName) ){
                    arr1.add(jsOBJ1.getJSONObject("attributes").getJSONObject("stats").getString("winPlace") + "\n"); //index 2
                    arr1.add("Килов   " + jsOBJ1.getJSONObject("attributes").getJSONObject("stats").getInt("kills") + "\n"); //index 3
                    arr1.add("Как умер   " + jsOBJ1.getJSONObject("attributes").getJSONObject("stats").getString("deathType") + "\n"); //index 4
                }

            }


            Log.e("7й поток закончил работу", "ДА");
            Log.e("результать 7го потока за виток", arr1.toString());


            return arr1;
        });


        executorService.shutdown();
        Log.e("экзекютор 7 получил задание", "ДА");
        ArrayList <String> res1 = null;
        try {
            res1 = future.get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return res1;
    }


}