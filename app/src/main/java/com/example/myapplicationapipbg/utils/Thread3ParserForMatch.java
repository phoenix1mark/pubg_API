package com.example.myapplicationapipbg.utils;



import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Thread3ParserForMatch {   //// В этом потоке получаем всю инфу по матчу
    static String res1 = null;

    public static String reguest3(String matchID) {

        Log.e("reguest3 начал работу", "ДА");


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future <String> future2 = executorService.submit(() -> {


            try {
                res1 = NetworkUtils.getResponseFromMatchRes(matchID);

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                return res1;
            }




/*        JSONObject jsonObject1 = new JSONObject(a);
        JSONArray jsonArray = jsonObject1.getJSONArray("data");

       *//* JSONObject userInfo3 = jsonArray.getJSONObject(0);*//*

         String res2 = jsonArray.getString(1);
            Log.e("Ебучий re2  3 потоке)", res2 + "");*/

        });
        executorService.shutdown();
        Log.e("reguest3 задания получены", "ДА");

        try {
            Log.e("reguest3 ветка ждёт", "ДА");
            Thread3ParserForMatch.res1 = future2.get(1, TimeUnit.DAYS);
            Log.e("reguest3 ветка подождала", "ДА");
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }

        if (res1 == null){
            return "sdfsdf";
        }else {
            return res1;
        }



    }
}