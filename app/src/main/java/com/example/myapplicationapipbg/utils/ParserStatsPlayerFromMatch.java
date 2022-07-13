package com.example.myapplicationapipbg.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParserStatsPlayerFromMatch {

   /* public static String reguest4 (String jsonMatch) {


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {

            JSONObject jsonResporense = new JSONObject(jsonMatch);
            JSONArray jsonArray = jsonResporense.getJSONArray("included");
            JSONObject userInfo = jsonArray.getJSONObject(100); // account c date









            *//*JSONObject matches1 = new JSONObject(userInfo.getString("relationships"));*//*


            return userInfo.toString();


*//*            JSONObject matches1 = new JSONObject(userInfo.getString("relationships"));
            String wert = matches1.getString("matches");

            JSONObject matches2 = new JSONObject(wert);
            JSONArray jsonArray3 = matches2.getJSONArray("data");

            JSONObject userInfo3 = jsonArray3.getJSONObject(0); // account c date
            String res5 = userInfo3.getString("id");*//*
        });


        executorService.shutdown();
        Log.e("экзекютор 2 получил задание", "ДА");
        String res1 = null;
        try {
            res1 = future.get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return res1;
    }*/



}
