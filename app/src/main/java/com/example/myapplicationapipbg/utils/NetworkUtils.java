package com.example.myapplicationapipbg.utils;

import android.net.Uri;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String PUBG_API_BASE_URL = "https://api.pubg.com/shards/steam/players";
    private static final String PUBG_API_BASE_MATCHES = "https://api.pubg.com/shards/steam/matches";

    private static final String PUBG_USERS_GET = "filter[playerNames]";


    public static URL generateURL(String userId) {
        Log.e("полученный генератором ID VK", userId);
        Uri builtUri = Uri.parse(PUBG_API_BASE_URL)
                .buildUpon()
                .appendQueryParameter(PUBG_USERS_GET, userId)
                .build();


        URL url = null;

        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.e("блок TRY/CATCH закончил свою работу в методе generate URL----", " ДА");
        Log.e("возвращаемый url в генераторе URL", builtUri.toString());
        return url;

    }


    public static String getResponseFromURL(URL url) throws IOException  {
        Log.e("метод getResponseFromURL запущен---", "ДА");
        /*HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();*/
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        Log.e("СОЕДИНЕНИЕ УСТАНОВЛЕНО---", "ДА");
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkM2ZhNWNlMC0xYjIxLTAxMzYtOTQzNS01NWIwMmE2ZWVmZDkiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTIyOTQ4MDg0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6IjExbWFyazEtbWFpbC1ydS1zLWFwcCJ9.8BKtoElp333S-KsnUs2FJyq9dbm5a-IqpbBxi0BMXuU");
        urlConnection.setRequestProperty("Accept", "application/json");

        InputStream in = urlConnection.getInputStream();
        Log.e("InputStream поток получил данные---", "ДА");
        Scanner scanner = new Scanner(in);
        Log.e("Создан объект класса Scanner---", "ДА");
        scanner.useDelimiter("\\A");
        boolean hasInput = scanner.hasNext();
        Log.e("Сканнер считал данные---", "ДА");
        urlConnection.disconnect();
        Log.e("Соединение штатно разорвано", "ДА");
            return scanner.next();

    }


    public static String getResponseFromMatchRes (String matchID) throws IOException  { // получаем полный ответ от вервера (Матч)
        Log.e("метод getResponseFromMatchRes запущен---", "ДА");
        Uri builtUri = Uri.parse(PUBG_API_BASE_MATCHES)
                .buildUpon()
                .appendPath(matchID)
                .build();

            URL url = new URL(builtUri.toString());



        Log.e("Такой получился путь для матчей---", url + "");


        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        Log.e("СОЕДИНЕНИЕ УСТАНОВЛЕНО- getResponseFromMatchRes--", "ДА");
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Accept", "application/json");
        InputStream in = urlConnection.getInputStream();
        Log.e("InputStream поток получил данные---", "ДА");
        Scanner scanner = new Scanner(in);
        Log.e("Создан объект класса Scanner---", "ДА");

        Log.e("Сканнер считал данные---", "ДА");


        Log.e("Соединение штатно разорвано", "ДА");
        /*Log.e("Результат работы getResponseFromMatchRes", scanner.next() + "");*/

            return scanner.next();

        /*Log.e("метод getResponseFromMatchRes завершил работу---", "ДА");*/




    }
}



