package com.example.myapplicationapipbg.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public  class Thread2ResultMatchesForPlayer {


    public static ArrayList reguest2 (String globalResAPI) throws ExecutionException, InterruptedException {   /// получаем 5 последних матчей игрока из общего ответа \\\
        Log.e("поток 2 запущен", "ДА");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<ArrayList> future = executorService.submit(() -> {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONObject jsonResporense = new JSONObject(globalResAPI);
            JSONArray jsonArray = jsonResporense.getJSONArray("data");
            JSONObject userInfo = jsonArray.getJSONObject(0); // account c date


            JSONObject matches1 = new JSONObject(userInfo.getString("relationships"));
            String wert = matches1.getString("matches");

            JSONObject matches2 = new JSONObject(wert);
            JSONArray jsonArray3 = matches2.getJSONArray("data");

            try {
                JSONObject userInfo3 = jsonArray3.getJSONObject(0); // account c date
                String res5 = userInfo3.getString("id");
                arrayList.add(res5);
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                JSONObject userInfo4 = jsonArray3.getJSONObject(1); // account c date
                String res6 = userInfo4.getString("id");
                arrayList.add(res6);
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                JSONObject userInfo5 = jsonArray3.getJSONObject(2); // account c date
                String res7 = userInfo5.getString("id");
                arrayList.add(res7);
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                JSONObject userInfo6 = jsonArray3.getJSONObject(3); // account c date
                String res8 = userInfo6.getString("id");
                arrayList.add(res8);
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                JSONObject userInfo7 = jsonArray3.getJSONObject(4); // account c date
                String res9 = userInfo7.getString("id");
                arrayList.add(res9);
            } catch (Exception e){
                e.printStackTrace();
            }




            Log.e("поток 2 распарсил катки", "ДА");

            /// Получили 5 последних айдишек матчей (res5 самый свежий)///

            Log.e("Арейлист в потоке 2 создан", "ДА");

            /*Log.e("arrayList.add(res5)", arrayList.get(0) +"");*/


            Log.e("arrayList.add фулл)", arrayList.toString() +"");
            return arrayList;


        });
        executorService.shutdown();
        Log.e("экзекютор 2 получил задание", "ДА");

        ArrayList res1 = future.get();



        return res1;
    }
}

//Morpeh38