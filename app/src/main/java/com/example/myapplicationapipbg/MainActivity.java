package com.example.myapplicationapipbg;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationapipbg.utils.ParseLastMapFromFiveMatches;
import com.example.myapplicationapipbg.utils.Thread1ResultAPI;
import com.example.myapplicationapipbg.utils.Thread2ResultMatchesForPlayer;
import com.example.myapplicationapipbg.utils.Thread3ParserForMatch;
import com.example.myapplicationttt.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public EditText searchField;
    private TextView result;
    String globalResAPI; // сюда приходят данные из 1 потока
    ArrayList resultThread2;// сюда приходят данные из 2 потока
    Button clearButton;

    LinearLayout globResLay;

    LinearLayout linL1;
    LinearLayout linL2;
    LinearLayout linL3;
    LinearLayout linL4;
    LinearLayout linL5;



    TextView rankRes1;
    TextView rankRes2;
    TextView rankRes3;
    TextView rankRes4;
    TextView rankRes5;

    TextView mapRes1;
    TextView mapRes2;
    TextView mapRes3;
    TextView mapRes4;
    TextView mapRes5;

    TextView dateRes1;
    TextView dateRes2;
    TextView dateRes3;
    TextView dateRes4;
    TextView dateRes5;


    ArrayList map1res;
    ArrayList map2res;
    ArrayList map3res;
    ArrayList map4res;
    ArrayList map5res;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchField = findViewById(R.id.et_search_field);
        Button searchButton = findViewById(R.id.b_search_vk);
        result = findViewById(R.id.tv_result);
        Button b1 = findViewById(R.id.button1);
        Button clearButton = findViewById(R.id.clearBtn);

        dateRes1 = findViewById(R.id.dateTexrViev1);
        dateRes2 = findViewById(R.id.dateTexrViev2);
        dateRes3 = findViewById(R.id.dateTexrViev3);
        dateRes4 = findViewById(R.id.dateTexrViev4);
        dateRes5 = findViewById(R.id.dateTexrViev5);
        mapRes1 = findViewById(R.id.l_1_tw_4);
        mapRes2 = findViewById(R.id.l_2_tw_4);
        mapRes3 = findViewById(R.id.l_3_tw_4);
        mapRes4 = findViewById(R.id.l_4_tw_4);
        mapRes5 = findViewById(R.id.l_5_tw_4);

        globResLay = findViewById(R.id.global_5_matchLL);


        linL1 = findViewById(R.id.l_l_1);
        linL2 = findViewById(R.id.l_l_2);
        linL3 = findViewById(R.id.l_l_3);
        linL4 = findViewById(R.id.l_l_4);
        linL5 = findViewById(R.id.l_l_5);

        rankRes1 = findViewById(R.id.l_1_tw_2);
        rankRes2 = findViewById(R.id.l_2_tw_2);
        rankRes3 = findViewById(R.id.l_3_tw_2);
        rankRes4 = findViewById(R.id.l_4_tw_2);
        rankRes5 = findViewById(R.id.l_5_tw_2);





        b1.setOnClickListener(new View.OnClickListener() {  // Вторая кнопка


             @SuppressLint("LongLogTag")
             @Override
             public void onClick(View v) {
                 String nameOfUser = searchField.getText().toString();

                 Log.e("что лежит в name of user!!!", nameOfUser);
                 try {
                     resultThread2 = Thread2ResultMatchesForPlayer.reguest2(globalResAPI); /// получили 5 последних матчей и записали в resultThread2
                 } catch (ExecutionException | InterruptedException e) {
                     e.printStackTrace();
                 }




                 try {
                     map1res = ParseLastMapFromFiveMatches.reguest7(Thread3ParserForMatch.reguest3(resultThread2.get(0).toString()), nameOfUser);
                     Log.e("map1res---", map1res + "");
                     map2res = ParseLastMapFromFiveMatches.reguest7(Thread3ParserForMatch.reguest3(resultThread2.get(1).toString()), nameOfUser);
                     Log.e("map2res---", map2res + "");
                     map3res = ParseLastMapFromFiveMatches.reguest7(Thread3ParserForMatch.reguest3(resultThread2.get(2).toString()), nameOfUser);
                     Log.e("map3res---", map3res + "");
                     map4res = ParseLastMapFromFiveMatches.reguest7(Thread3ParserForMatch.reguest3(resultThread2.get(3).toString()), nameOfUser);
                     Log.e("map4res---", map4res + "");
                     map5res = ParseLastMapFromFiveMatches.reguest7(Thread3ParserForMatch.reguest3(resultThread2.get(4).toString()), nameOfUser);
                     Log.e("map5res---", map5res + "");
                 } catch (Exception e){
                     result.setText("Error");
                     e.printStackTrace();
                 }



                 //// TEST OUTPUT ////

                     Log.e("Предрезультат ---", "\n" + map1res + "\n" + map2res + "\n" + map3res + "\n" + map4res + "\n" + map5res);

                     try {
                         dateRes1.setText(map1res.get(0).toString());
                         mapRes1.setText(map1res.get(1).toString());
                         rankRes1.setText(map1res.get(2).toString());
                     } catch (Exception e){
                         dateRes1.setText("Матч не найден");
                         mapRes1.setText("");
                         rankRes1.setText("");
                         e.printStackTrace();
                     }

                     try {
                         dateRes2.setText(map2res.get(0).toString());
                         mapRes2.setText(map2res.get(1).toString());
                         rankRes2.setText(map2res.get(2).toString());
                     }catch (Exception e){
                         dateRes2.setText("Матч не найден");
                         mapRes2.setText("");
                         rankRes2.setText("");
                         e.printStackTrace();
                     }

                     try {
                         dateRes3.setText(map3res.get(0).toString());
                         mapRes3.setText(map3res.get(1).toString());
                         rankRes3.setText(map3res.get(2).toString());
                     }catch (Exception e){
                         dateRes3.setText("Матч не найден");
                         mapRes3.setText("");
                         rankRes3.setText("");
                         e.printStackTrace();
                     }

                     try {
                         dateRes4.setText(map4res.get(0).toString());
                         mapRes4.setText(map4res.get(1).toString());
                         rankRes4.setText(map4res.get(2).toString());
                     }catch (Exception e){
                         dateRes4.setText("Матч не найден");
                         mapRes4.setText("");
                         rankRes4.setText("");
                         e.printStackTrace();
                     }

                     try {
                         dateRes5.setText(map5res.get(0).toString());
                         mapRes5.setText(map5res.get(1).toString());
                         rankRes5.setText(map5res.get(2).toString());
                     }catch (Exception e){
                         dateRes5.setText("Матч не найден");
                         mapRes5.setText("");
                         rankRes5.setText("");
                         e.printStackTrace();
                     }

                     globResLay.setVisibility(View.VISIBLE);



             }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {   //сценарий нажатия кнопки//
                b1.setVisibility(View.INVISIBLE);
                globResLay.setVisibility(View.INVISIBLE);

                Log.e("Запускается второй поток---", "ДА");
                globalResAPI = Thread1ResultAPI.reguest1(searchField);  //запуск потока с выходом в интернет//
                Log.e("ut1 Значение в globalResAPI ---", globalResAPI + "");

                if (globalResAPI != null){
                    b1.setVisibility(View.VISIBLE);

                    result.setText("Данные получены");
                } else {
                    b1.setVisibility(View.INVISIBLE);
                    result.setText("Ничего не найдено");
                }

                Log.e("Выполнилась установка текста в UI---", "ДА");

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globResLay.setVisibility(View.INVISIBLE);

                try {
                    map1res.clear();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    dateRes1.setText("Очищено");
                    mapRes1.setText("");
                    rankRes1.setText("");
                }


                try {
                    map2res.clear();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    dateRes2.setText("Очищено");
                    mapRes2.setText("");
                    rankRes2.setText("");
                }

                try {
                    map3res.clear();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    dateRes3.setText("Очищено");
                    mapRes3.setText("");
                    rankRes3.setText("");
                }

                try {
                    map4res.clear();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    dateRes4.setText("Очищено");
                    mapRes4.setText("");
                    rankRes4.setText("");
                }

                try {
                    map5res.clear();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    dateRes5.setText("Очищено");
                    mapRes5.setText("");
                    rankRes5.setText("");
                }
            }
        });
    }
}