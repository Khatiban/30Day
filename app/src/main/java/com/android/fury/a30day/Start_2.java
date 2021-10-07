package com.android.fury.a30day;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.PageStart.PageStart;
import com.android.fury.a30day.alarm.ads.NotificationEventReceiver;
import com.android.fury.a30day.alarm.myanvade1.NotificationEventReceiver1;
import com.android.fury.a30day.alarm.myanvade2.NotificationEventReceiver2;
import com.android.fury.a30day.alarm.nahar.NotificationEventReceiver3;
import com.android.fury.a30day.alarm.sham.NotificationEventReceiver4;
import com.android.fury.a30day.alarm.sobhane.NotificationEventReceiver5;
import com.android.fury.a30day.alarm.sport.NotificationEventReceiver6;
import com.android.fury.a30day.page.Page_1;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * Created by ehsan on 7/5/2016.
 */
public class Start_2 extends Activity {


    int oneplay, auto_t,play_ads;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    //Intent intent;
    //NotificationCompat.Builder my_notif;

    //public static final int uniqueID = 98745;

    MyDatabaseHelper_lan language;

    Boolean play_sobhane,play_myanvade_1,play_nahar,play_myanvade_2,play_sport,play_sham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            oneplay = one_play_preferences.getInt("one_play_app", 3);
            play_ads = one_play_preferences.getInt("play_ads", 0);
            play_sobhane = one_play_preferences.getBoolean("check_show_alarm_1", true);
            play_myanvade_1 = one_play_preferences.getBoolean("check_show_alarm_2", true);
            play_nahar = one_play_preferences.getBoolean("check_show_alarm_3", true);
            play_myanvade_2 = one_play_preferences.getBoolean("check_show_alarm_4", true);
            play_sport = one_play_preferences.getBoolean("check_show_alarm_5", true);
            play_sham = one_play_preferences.getBoolean("check_show_alarm_6", true);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }

        NotificationEventReceiver.cancelAlarm(getApplicationContext());
        NotificationEventReceiver1.cancelAlarm(getApplicationContext());
        NotificationEventReceiver2.cancelAlarm(getApplicationContext());
        NotificationEventReceiver3.cancelAlarm(getApplicationContext());
        NotificationEventReceiver4.cancelAlarm(getApplicationContext());
        NotificationEventReceiver5.cancelAlarm(getApplicationContext());
        NotificationEventReceiver6.cancelAlarm(getApplicationContext());

        Calendar rightNow = Calendar.getInstance();
        int date = rightNow.get(Calendar.HOUR_OF_DAY);

        if (date == 1){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 2){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 3){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 4){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 5){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 6){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 7){
            if (play_myanvade_1){
                NotificationEventReceiver1.setupAlarm(getApplicationContext());
            }else {
                if (play_nahar){
                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                }else {
                    if (play_myanvade_2){
                        NotificationEventReceiver2.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sport){
                            NotificationEventReceiver6.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sham){
                                NotificationEventReceiver4.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sobhane){
                                    NotificationEventReceiver5.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 8){
            if (play_myanvade_1){
                NotificationEventReceiver1.setupAlarm(getApplicationContext());
            }else {
                if (play_nahar){
                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                }else {
                    if (play_myanvade_2){
                        NotificationEventReceiver2.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sport){
                            NotificationEventReceiver6.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sham){
                                NotificationEventReceiver4.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sobhane){
                                    NotificationEventReceiver5.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 9){
            if (play_myanvade_1){
                NotificationEventReceiver1.setupAlarm(getApplicationContext());
            }else {
                if (play_nahar){
                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                }else {
                    if (play_myanvade_2){
                        NotificationEventReceiver2.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sport){
                            NotificationEventReceiver6.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sham){
                                NotificationEventReceiver4.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sobhane){
                                    NotificationEventReceiver5.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 10){
            if (play_nahar){
                NotificationEventReceiver3.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_2){
                    NotificationEventReceiver2.setupAlarm(getApplicationContext());
                }else {
                    if (play_sport){
                        NotificationEventReceiver6.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sham){
                            NotificationEventReceiver4.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sobhane){
                                NotificationEventReceiver5.setupAlarm(getApplicationContext());
                            }else {
                                if (play_myanvade_1){
                                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 11){
            if (play_nahar){
                NotificationEventReceiver3.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_2){
                    NotificationEventReceiver2.setupAlarm(getApplicationContext());
                }else {
                    if (play_sport){
                        NotificationEventReceiver6.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sham){
                            NotificationEventReceiver4.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sobhane){
                                NotificationEventReceiver5.setupAlarm(getApplicationContext());
                            }else {
                                if (play_myanvade_1){
                                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 12){
            if (play_nahar){
                NotificationEventReceiver3.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_2){
                    NotificationEventReceiver2.setupAlarm(getApplicationContext());
                }else {
                    if (play_sport){
                        NotificationEventReceiver6.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sham){
                            NotificationEventReceiver4.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sobhane){
                                NotificationEventReceiver5.setupAlarm(getApplicationContext());
                            }else {
                                if (play_myanvade_1){
                                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 13){
            if (play_myanvade_2){
                NotificationEventReceiver2.setupAlarm(getApplicationContext());
            }else {
                if (play_sport){
                    NotificationEventReceiver6.setupAlarm(getApplicationContext());
                }else {
                    if (play_sham){
                        NotificationEventReceiver4.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sobhane){
                            NotificationEventReceiver5.setupAlarm(getApplicationContext());
                        }else {
                            if (play_myanvade_1){
                                NotificationEventReceiver1.setupAlarm(getApplicationContext());
                            }else {
                                if (play_nahar){
                                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 14){
            if (play_myanvade_2){
                NotificationEventReceiver2.setupAlarm(getApplicationContext());
            }else {
                if (play_sport){
                    NotificationEventReceiver6.setupAlarm(getApplicationContext());
                }else {
                    if (play_sham){
                        NotificationEventReceiver4.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sobhane){
                            NotificationEventReceiver5.setupAlarm(getApplicationContext());
                        }else {
                            if (play_myanvade_1){
                                NotificationEventReceiver1.setupAlarm(getApplicationContext());
                            }else {
                                if (play_nahar){
                                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 15){
            if (play_myanvade_2){
                NotificationEventReceiver2.setupAlarm(getApplicationContext());
            }else {
                if (play_sport){
                    NotificationEventReceiver6.setupAlarm(getApplicationContext());
                }else {
                    if (play_sham){
                        NotificationEventReceiver4.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sobhane){
                            NotificationEventReceiver5.setupAlarm(getApplicationContext());
                        }else {
                            if (play_myanvade_1){
                                NotificationEventReceiver1.setupAlarm(getApplicationContext());
                            }else {
                                if (play_nahar){
                                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 16){
            if (play_myanvade_2){
                NotificationEventReceiver2.setupAlarm(getApplicationContext());
            }else {
                if (play_sport){
                    NotificationEventReceiver6.setupAlarm(getApplicationContext());
                }else {
                    if (play_sham){
                        NotificationEventReceiver4.setupAlarm(getApplicationContext());
                    }else {
                        if (play_sobhane){
                            NotificationEventReceiver5.setupAlarm(getApplicationContext());
                        }else {
                            if (play_myanvade_1){
                                NotificationEventReceiver1.setupAlarm(getApplicationContext());
                            }else {
                                if (play_nahar){
                                    NotificationEventReceiver3.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 17){
            if (play_sport){
                NotificationEventReceiver6.setupAlarm(getApplicationContext());
            }else {
                if (play_sham){
                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                }else {
                    if (play_sobhane){
                        NotificationEventReceiver5.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_1){
                            NotificationEventReceiver1.setupAlarm(getApplicationContext());
                        }else {
                            if (play_nahar){
                                NotificationEventReceiver3.setupAlarm(getApplicationContext());
                            }else {
                                if (play_myanvade_2){
                                    NotificationEventReceiver2.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 18){
            if (play_ads == 3){
                NotificationEventReceiver.setupAlarm(getApplicationContext());
            }else {
                if (play_sham){
                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                }else {
                    if (play_sobhane){
                        NotificationEventReceiver5.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_1){
                            NotificationEventReceiver1.setupAlarm(getApplicationContext());
                        }else {
                            if (play_nahar){
                                NotificationEventReceiver3.setupAlarm(getApplicationContext());
                            }else {
                                if (play_myanvade_2){
                                    NotificationEventReceiver2.setupAlarm(getApplicationContext());
                                }else {
                                    if (play_sport){
                                        NotificationEventReceiver6.setupAlarm(getApplicationContext());
                                    }else {

                                    }
                                }
                            }
                        }
                    }
                }
            }
            play_ads = play_ads + 1 ;
            one_play_editor.putInt("play_ads", play_ads);
            one_play_editor.apply();
        }else if (date == 19){
            if (play_ads == 3){
                NotificationEventReceiver.setupAlarm(getApplicationContext());
            }else {
                if (play_sham){
                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                }else {
                    if (play_sobhane){
                        NotificationEventReceiver5.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_1){
                            NotificationEventReceiver1.setupAlarm(getApplicationContext());
                        }else {
                            if (play_nahar){
                                NotificationEventReceiver3.setupAlarm(getApplicationContext());
                            }else {
                                if (play_myanvade_2){
                                    NotificationEventReceiver2.setupAlarm(getApplicationContext());
                                }else {
                                    if (play_sport){
                                        NotificationEventReceiver6.setupAlarm(getApplicationContext());
                                    }else {

                                    }
                                }
                            }
                        }
                    }
                }
            }
            play_ads = play_ads + 1 ;
            one_play_editor.putInt("play_ads", play_ads);
            one_play_editor.apply();
        }else if (date == 20){
            if (play_sham){
                NotificationEventReceiver4.setupAlarm(getApplicationContext());
            }else {
                if (play_sobhane){
                    NotificationEventReceiver5.setupAlarm(getApplicationContext());
                }else {
                    if (play_myanvade_1){
                        NotificationEventReceiver1.setupAlarm(getApplicationContext());
                    }else {
                        if (play_nahar){
                            NotificationEventReceiver3.setupAlarm(getApplicationContext());
                        }else {
                            if (play_myanvade_2){
                                NotificationEventReceiver2.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sport){
                                    NotificationEventReceiver6.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 21){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 22){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else if (date == 23){
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }else {
            if (play_sobhane){
                NotificationEventReceiver5.setupAlarm(getApplicationContext());
            }else {
                if (play_myanvade_1){
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                }else {
                    if (play_nahar){
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    }else {
                        if (play_myanvade_2){
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        }else {
                            if (play_sport){
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            }else {
                                if (play_sham){
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        }


        try {

            //start zaban
            language = new MyDatabaseHelper_lan(this);
            Cursor r_lan = language.showAllData();
            StringBuffer dadeha = new StringBuffer();
            while (r_lan.moveToNext()) {
                dadeha.append(r_lan.getString(1));
            }
            if (dadeha.toString().length() == 1) {
                //farsi

                Locale locale = new Locale("fa");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } else if (dadeha.toString().length() == 2) {
                //english.usa.canada

                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } else if (dadeha.toString().length() == 3) {
                //chine

                Locale locale = new Locale("zh");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } else if (dadeha.toString().length() == 6) {
                //german

                Locale locale = new Locale("de");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

        //start activ
        setContentView(R.layout.start_2);

        TextView textView2 = (TextView) findViewById(R.id.textView2);

        int min = 1;
        int max = 15;

        Random y = new Random();

        try {

            auto_t = y.nextInt(max - min + 1) + min;

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("auto_t "));
            auto_t = 5;
        }

        if (auto_t == 1) {
            textView2.setText(R.string.jomallat_avval_app_1);
        } else if (auto_t == 2) {
            textView2.setText(R.string.jomallat_avval_app_2);
        } else if (auto_t == 3) {
            textView2.setText(R.string.jomallat_avval_app_3);
        } else if (auto_t == 4) {
            textView2.setText(R.string.jomallat_avval_app_4);
        } else if (auto_t == 5) {
            textView2.setText(R.string.jomallat_avval_app_5);
        } else if (auto_t == 6) {
            textView2.setText(R.string.jomallat_avval_app_6);
        } else if (auto_t == 7) {
            textView2.setText(R.string.jomallat_avval_app_7);
        } else if (auto_t == 8) {
            textView2.setText(R.string.jomallat_avval_app_8);
        } else if (auto_t == 9) {
            textView2.setText(R.string.jomallat_avval_app_9);
        } else if (auto_t == 10) {
            textView2.setText(R.string.jomallat_avval_app_10);
        } else if (auto_t == 11) {
            textView2.setText(R.string.jomallat_avval_app_11);
        } else if (auto_t == 12) {
            textView2.setText(R.string.jomallat_avval_app_12);
        } else if (auto_t == 13) {
            textView2.setText(R.string.jomallat_avval_app_13);
        } else if (auto_t == 14) {
            textView2.setText(R.string.jomallat_avval_app_14);
        } else if (auto_t == 15) {
            textView2.setText(R.string.jomallat_avval_app_15);
        }


        try {

            ImageView _30day = (ImageView) findViewById(R.id.imageView);
            Animation day = AnimationUtils.loadAnimation(Start_2.this, R.anim.in_start);
            _30day.startAnimation(day);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }

        try {


            Animation day2 = AnimationUtils.loadAnimation(Start_2.this, R.anim.in_start2);
            textView2.startAnimation(day2);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }



        FirebaseCrash.log("log 2");

        System.gc();
    }

    @Override
    protected void onStart() {
        super.onStart();
        int _splashTime = 3000;

        if (oneplay == 3) {
            try {

                new Handler().postDelayed(new Thread() {

                    @Override
                    public void run() {
                        super.run();

                        one_play_editor.putInt("one_play_app", 1);
                        one_play_editor.apply();

                        Intent uou = new Intent(Start_2.this, PageStart.class);
                        startActivity(uou);
                        Start_2.this.finish();

                    }

                    ;
                }, _splashTime);

            } catch (Resources.NotFoundException e) {
                FirebaseCrash.report(new Exception("5"));
            }
        } else {

            try {

                new Handler().postDelayed(new Thread() {

                    @Override
                    public void run() {
                        super.run();
                        Intent uou = new Intent(Start_2.this, Page_1.class);
                        startActivity(uou);
                        Start_2.this.finish();
                    }

                    ;
                }, _splashTime);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }

        }

        FirebaseCrash.log("log 1");

        System.gc();
    }


    @Override
    protected void onStop() {
        super.onStop();
        System.gc();

        FirebaseCrash.log("log 3");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //int _splashTime2 = 10000;
        //my_notif = new NotificationCompat.Builder(this);
        //my_notif.setAutoCancel( true );
        //my_notif.setSmallIcon(R.id.about_inestagram);
        //my_notif.setTicker(getResources().getText(R.string.btn_30day));
        // my_notif.setWhen(_splashTime2);
        //my_notif.setContentTitle(getResources().getText(R.string.btn_30day));
        //my_notif.setContentText(getResources().getText(R.string.text_notication));
        //intent = new Intent( this , Start_1.class);
        //PendingIntent pi = PendingIntent.getActivities(this , 0 , new Intent[] {intent}  , PendingIntent.FLAG_UPDATE_CURRENT );
        //my_notif.setContentIntent(pi);
        //NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
        //nm.notify(uniqueID , my_notif.build());

        FirebaseCrash.log("log 4");

        System.gc();
    }





}

