package com.example.myapplicationapipbg.utils;

import static com.example.myapplicationapipbg.utils.NetworkUtils.generateURL;
import static com.example.myapplicationapipbg.utils.NetworkUtils.getResponseFromURL;

import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread1ResultAPI {


    public static String reguest1 (EditText searchField) { //получаем полный профиль по никнейму///
        String res1 = null;

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {

            Log.e("поток 1 запущен", "ДА");
            URL generatedURL = generateURL(searchField.getText().toString());
            Log.e("generateURL выполнился ---", "ДА");

            String response = null;
            try {
                response = getResponseFromURL(generatedURL);
                Log.e("значение resporence получено в блоке TRU----", "ДА");
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            Log.e(" Полученное значение resporence в reguest1 ----", response +"ДА"); /// Sma1L2  IRONMAN_15
            return response;

        });

        executorService.shutdown();
        Log.e("экзекютор получил задание", "ДА");
        try {
            res1 = future.get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return res1;

    }

}
