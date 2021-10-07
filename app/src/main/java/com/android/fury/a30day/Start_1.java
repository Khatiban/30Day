package com.android.fury.a30day;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.google.firebase.crash.FirebaseCrash;


public class Start_1 extends Activity {


    private final int _splashTime = 850;

    MyDatabaseHelper_lan language;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    int oneplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_1);

        String id = "1";
        String lan = "f";

        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            oneplay = one_play_preferences.getInt("lang", 1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

        if (oneplay == 1) {

            try {

                language = new MyDatabaseHelper_lan(this);

                language.deleteData(id);

                language.insertData(lan, id);

                one_play_editor.putInt("lang", 2);
                one_play_editor.apply();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("2"));
            }

        }


        FirebaseCrash.log("log 2");


        System.gc();
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {

            new Handler().postDelayed(new Thread() {

                @Override
                public void run() {
                    super.run();


                    Intent uou = new Intent(Start_1.this, Start_2.class);
                    startActivity(uou);
                    Start_1.this.finish();
                }
            }, _splashTime);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }
        FirebaseCrash.log("log 1");

        System.gc();
    }

}