package com.android.fury.a30day.sport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.App;
import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Not_net;
import com.android.fury.a30day.R;
import com.android.fury.a30day.Suport.Suport_me;
import com.android.fury.a30day.alarm.sport.NotificationEventReceiver6;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.android.fury.a30day.food.food;
import com.android.fury.a30day.page.Page_2;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Created by fury on 10/11/2016.
 */
public class sport extends Activity implements View.OnClickListener {

    private final int _splashTime = 1000;
    private final int _splashTime2 = 500;

    ImageView back_page, btn_menu;

    LinearLayout sports, diet, dmusic, settings, about, help, exit;

    String menu_exit, language1, about_alertdialog_6, about_alertdialog_7, about_alertdialog_8, about_alertdialog_9, no, yes, music_check, music_off_check, vibre_check, fars, en, de, ca, am, ch;

    DrawerLayout drawerlayout;

    MediaPlayer click;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    SharedPreferences sport_namber;

    SharedPreferences.Editor nameEditor_sport_namber;


    TextView txt_sport_2, comingso, txt_sport_2_day, txt_sport_3, txt_sport_3_day, txt_sport_4, txt_sport_4_day, txt_sport_5, txt_sport_5_day, txt_sport_6, txt_sport_6_day, txt_sport_7, txt_sport_7_day, txt_sport_8, txt_sport_8_day, txt_sport_9, txt_sport_9_day, txt_sport_10, txt_sport_10_day, txt_sport_11, txt_sport_11_day, txt_sport_12, txt_sport_12_day, txt_sport_13, txt_sport_13_day, txt_sport_14, txt_sport_14_day, txt_sport_15, txt_sport_15_day, txt_sport_16, txt_sport_16_day, txt_sport_17, txt_sport_17_day, txt_sport_18, txt_sport_18_day, txt_sport_19, txt_sport_19_day, txt_sport_20, txt_sport_20_day, txt_sport_21, txt_sport_21_day, txt_sport_22, txt_sport_22_day, txt_sport_23, txt_sport_23_day, txt_sport_24, txt_sport_24_day, txt_sport_25, txt_sport_25_day, txt_sport_26, txt_sport_26_day, txt_sport_27, txt_sport_27_day, txt_sport_28, txt_sport_28_day, txt_sport_29, txt_sport_29_day, txt_sport_30, txt_sport_30_day, txt_sport_1, txt_sport_1_day;

    ImageView btn_2_sport_star, btn_2_sport_lock, btn_2_sport, btn_3_sport_star, btn_3_sport_lock, btn_3_sport, btn_4_sport_star, btn_4_sport_lock, btn_4_sport, btn_5_sport_star, btn_5_sport_lock, btn_5_sport, btn_6_sport_star, btn_6_sport_lock, btn_6_sport, btn_7_sport_star, btn_7_sport_lock, btn_7_sport, btn_8_sport_star, btn_8_sport_lock, btn_8_sport, btn_9_sport_star, btn_9_sport_lock, btn_9_sport, btn_10_sport_star, btn_10_sport, btn_11_sport_star, btn_11_sport_lock, btn_11_sport, btn_12_sport_star, btn_12_sport_lock, btn_12_sport, btn_13_sport_star, btn_13_sport_lock, btn_13_sport, btn_14_sport_star, btn_14_sport_lock, btn_14_sport, btn_15_sport_star, btn_15_sport_lock, btn_15_sport, btn_16_sport_star, btn_16_sport_lock, btn_16_sport, btn_17_sport_star, btn_17_sport_lock, btn_17_sport, btn_18_sport_star, btn_18_sport_lock, btn_18_sport, btn_19_sport_star, btn_19_sport_lock, btn_19_sport, btn_20_sport_star, btn_20_sport, btn_21_sport_star, btn_21_sport_lock, btn_21_sport, btn_22_sport_star, btn_22_sport_lock, btn_22_sport, btn_23_sport_star, btn_23_sport_lock, btn_23_sport, btn_24_sport_star, btn_24_sport_lock, btn_24_sport, btn_25_sport_star, btn_25_sport_lock, btn_25_sport, btn_26_sport_star, btn_26_sport_lock, btn_26_sport, btn_27_sport_star, btn_27_sport_lock, btn_27_sport, btn_28_sport_star, btn_28_sport_lock, btn_28_sport, btn_29_sport_star, btn_29_sport_lock, btn_29_sport, btn_30_sport_star, btn_30_sport_lock, btn_30_sport, btn_1_sport_star, btn_1_sport;

    //final private String APP_ID = "app8f399ff0cb6c4f83b4";
    //final private String ZONE_ID = "vzded9a79e5bd84c7d9b";

    CardView com_son_sport;

    //AdColonyVideoAd ad, ad1, ad2;

    int help_play, zaban, sport_page;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MyDatabaseHelper_lan language;

    MaterialTapTargetPrompt mFabPrompt;

    Typeface type3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

                language1 = "fa";

            } else if (dadeha.toString().length() == 2) {
                //english.usa.canada

                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                language1 = "en";

            } else if (dadeha.toString().length() == 3) {
                //chine

                Locale locale = new Locale("zh");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                language1 = "zh";

            } else if (dadeha.toString().length() == 6) {
                //german

                Locale locale = new Locale("de");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                language1 = "de";

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }


        //start activ
        setContentView(R.layout.root_sport);

        Bundle sitting_b = getIntent().getExtras();
        sport_page = sitting_b.getInt("sport_back");

        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            help_play = one_play_preferences.getInt("Help_play_3", 1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        fars = "fa";
        en = "en";
        de = "de";
        ca = "en";
        am = "en";
        ch = "zh";
        if (language1 == fars) {
            zaban = 1;
        } else if (language1 == en) {
            zaban = 2;
        } else if (language1 == de) {
            zaban = 3;
        } else if (language1 == ca) {
            zaban = 2;
        } else if (language1 == am) {
            zaban = 2;
        } else if (language1 == ch) {
            zaban = 4;
        }

        try {

            sport_namber = PreferenceManager.getDefaultSharedPreferences(this);
            nameEditor_sport_namber = sport_namber.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }


        try {

            //save music
            sound_data = new MyDatabaseHelper_sound(this);
            Cursor res = sound_data.showAllData();
            StringBuffer data = new StringBuffer();
            while (res.moveToNext()) {
                data.append(res.getString(1));
            }
            if (data.toString().length() == 4) {
                music_check = "true";
            } else if (data.toString().length() == 5) {
                music_check = "false";
            } else {
                music_check = "true";
            }
            music_off_check = "false";

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }

        try {

            //save vibre
            vibre_data = new MyDatabaseHelper_vibre(this);
            Cursor res_2 = vibre_data.showAllData();
            StringBuffer data_2 = new StringBuffer();
            while (res_2.moveToNext()) {
                data_2.append(res_2.getString(1));
            }
            if (data_2.toString().length() == 4) {
                vibre_check = "true";
            } else if (data_2.toString().length() == 5) {
                vibre_check = "false";
            } else {
                vibre_check = "true";
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("5"));
        }


        /**AdColony.configure( this , "version:1.0,store:google" , APP_ID , ZONE_ID );

         ad = new AdColonyVideoAd( ZONE_ID ).withListener(new AdColonyAdListener() {
        @Override public void onAdColonyAdAttemptFinished(AdColonyAd adColonyAd) {

        nameEditor_sport_namber.putInt( "sport_number_show_11", 11 );
        nameEditor_sport_namber.putInt( "sport_number_show_set_1", 1 );
        nameEditor_sport_namber.apply();

        Intent s = new Intent(sport.this , sport_start.class);
        s.putExtra("sport_v_number_day" , 1);
        s.putExtra("sport_v_number_day_set_1" , 1);
        s.putExtra("sport_v_volume1" , 1);
        s.putExtra("sport_v_por" , 1);
        startActivity(s);

        sport.this.finish();

        }

        @Override public void onAdColonyAdStarted(AdColonyAd adColonyAd) {

        }
        });



         ad1 = new AdColonyVideoAd( ZONE_ID ).withListener(new AdColonyAdListener() {
        @Override public void onAdColonyAdAttemptFinished(AdColonyAd adColonyAd) {

        nameEditor_sport_namber.putInt( "sport_number_show_21", 11 );
        nameEditor_sport_namber.putInt( "sport_number_show_set_2", 1 );
        nameEditor_sport_namber.apply();

        Intent s = new Intent(sport.this , sport_start.class);
        s.putExtra("sport_v_number_day" , 10);
        s.putExtra("sport_v_number_day_set_1" , 1);
        s.putExtra("sport_v_volume1" , 1);
        s.putExtra("sport_v_por" , 1);
        startActivity(s);

        sport.this.finish();

        }

        @Override public void onAdColonyAdStarted(AdColonyAd adColonyAd) {

        }
        });



         ad2 = new AdColonyVideoAd( ZONE_ID ).withListener(new AdColonyAdListener() {
        @Override public void onAdColonyAdAttemptFinished(AdColonyAd adColonyAd) {

        nameEditor_sport_namber.putInt( "sport_number_show_31", 11 );
        nameEditor_sport_namber.putInt( "sport_number_show_set_3", 1 );
        nameEditor_sport_namber.apply();

        Intent s = new Intent(sport.this , sport_start.class);
        s.putExtra("sport_v_number_day" , 20);
        s.putExtra("sport_v_number_day_set_1" , 1);
        s.putExtra("sport_v_volume1" , 1);
        s.putExtra("sport_v_por" , 1);
        startActivity(s);

        sport.this.finish();

        }

        @Override public void onAdColonyAdStarted(AdColonyAd adColonyAd) {

        }
        });**/


        txt_sport_2 = (TextView) findViewById(R.id.txt_sport_2);
        txt_sport_2_day = (TextView) findViewById(R.id.txt_sport_2_day);
        txt_sport_3 = (TextView) findViewById(R.id.txt_sport_3);
        txt_sport_3_day = (TextView) findViewById(R.id.txt_sport_3_day);
        txt_sport_4_day = (TextView) findViewById(R.id.txt_sport_4_day);
        txt_sport_4 = (TextView) findViewById(R.id.txt_sport_4);
        txt_sport_5_day = (TextView) findViewById(R.id.txt_sport_5_day);
        txt_sport_5 = (TextView) findViewById(R.id.txt_sport_5);
        txt_sport_6_day = (TextView) findViewById(R.id.txt_sport_6_day);
        txt_sport_6 = (TextView) findViewById(R.id.txt_sport_6);
        txt_sport_7_day = (TextView) findViewById(R.id.txt_sport_7_day);
        txt_sport_7 = (TextView) findViewById(R.id.txt_sport_7);
        txt_sport_8_day = (TextView) findViewById(R.id.txt_sport_8_day);
        txt_sport_8 = (TextView) findViewById(R.id.txt_sport_8);
        txt_sport_9_day = (TextView) findViewById(R.id.txt_sport_9_day);
        txt_sport_9 = (TextView) findViewById(R.id.txt_sport_9);
        txt_sport_10_day = (TextView) findViewById(R.id.txt_sport_10_day);
        txt_sport_10 = (TextView) findViewById(R.id.txt_sport_10);
        txt_sport_11_day = (TextView) findViewById(R.id.txt_sport_11_day);
        txt_sport_11 = (TextView) findViewById(R.id.txt_sport_11);
        txt_sport_12_day = (TextView) findViewById(R.id.txt_sport_12_day);
        txt_sport_12 = (TextView) findViewById(R.id.txt_sport_12);
        txt_sport_13_day = (TextView) findViewById(R.id.txt_sport_13_day);
        txt_sport_13 = (TextView) findViewById(R.id.txt_sport_13);
        txt_sport_14_day = (TextView) findViewById(R.id.txt_sport_14_day);
        txt_sport_14 = (TextView) findViewById(R.id.txt_sport_14);
        txt_sport_15_day = (TextView) findViewById(R.id.txt_sport_15_day);
        txt_sport_15 = (TextView) findViewById(R.id.txt_sport_15);
        txt_sport_16_day = (TextView) findViewById(R.id.txt_sport_16_day);
        txt_sport_16 = (TextView) findViewById(R.id.txt_sport_16);
        txt_sport_17_day = (TextView) findViewById(R.id.txt_sport_17_day);
        txt_sport_17 = (TextView) findViewById(R.id.txt_sport_17);
        txt_sport_18_day = (TextView) findViewById(R.id.txt_sport_18_day);
        txt_sport_18 = (TextView) findViewById(R.id.txt_sport_18);
        txt_sport_19_day = (TextView) findViewById(R.id.txt_sport_19_day);
        txt_sport_19 = (TextView) findViewById(R.id.txt_sport_19);
        txt_sport_20_day = (TextView) findViewById(R.id.txt_sport_20_day);
        txt_sport_20 = (TextView) findViewById(R.id.txt_sport_20);
        txt_sport_21_day = (TextView) findViewById(R.id.txt_sport_21_day);
        txt_sport_21 = (TextView) findViewById(R.id.txt_sport_21);
        txt_sport_22_day = (TextView) findViewById(R.id.txt_sport_22_day);
        txt_sport_22 = (TextView) findViewById(R.id.txt_sport_22);
        txt_sport_23_day = (TextView) findViewById(R.id.txt_sport_23_day);
        txt_sport_23 = (TextView) findViewById(R.id.txt_sport_23);
        txt_sport_24_day = (TextView) findViewById(R.id.txt_sport_24_day);
        txt_sport_24 = (TextView) findViewById(R.id.txt_sport_24);
        txt_sport_25_day = (TextView) findViewById(R.id.txt_sport_25_day);
        txt_sport_25 = (TextView) findViewById(R.id.txt_sport_25);
        txt_sport_26_day = (TextView) findViewById(R.id.txt_sport_26_day);
        txt_sport_26 = (TextView) findViewById(R.id.txt_sport_26);
        txt_sport_27_day = (TextView) findViewById(R.id.txt_sport_27_day);
        txt_sport_27 = (TextView) findViewById(R.id.txt_sport_27);
        txt_sport_28_day = (TextView) findViewById(R.id.txt_sport_28_day);
        txt_sport_28 = (TextView) findViewById(R.id.txt_sport_28);
        txt_sport_29_day = (TextView) findViewById(R.id.txt_sport_29_day);
        txt_sport_29 = (TextView) findViewById(R.id.txt_sport_29);
        txt_sport_30_day = (TextView) findViewById(R.id.txt_sport_30_day);
        txt_sport_30 = (TextView) findViewById(R.id.txt_sport_30);
        txt_sport_1_day = (TextView) findViewById(R.id.txt_sport_1_day);
        txt_sport_1 = (TextView) findViewById(R.id.txt_sport_1);
        comingso = (TextView) findViewById(R.id.comingso);

        btn_2_sport_star = (ImageView) findViewById(R.id.btn_2_sport_star);
        btn_2_sport_lock = (ImageView) findViewById(R.id.btn_2_sport_lock);
        btn_2_sport = (ImageView) findViewById(R.id.btn_2_sport);
        btn_3_sport_star = (ImageView) findViewById(R.id.btn_3_sport_star);
        btn_3_sport_lock = (ImageView) findViewById(R.id.btn_3_sport_lock);
        btn_3_sport = (ImageView) findViewById(R.id.btn_3_sport);
        btn_4_sport_star = (ImageView) findViewById(R.id.btn_4_sport_star);
        btn_4_sport_lock = (ImageView) findViewById(R.id.btn_4_sport_lock);
        btn_4_sport = (ImageView) findViewById(R.id.btn_4_sport);
        btn_5_sport_star = (ImageView) findViewById(R.id.btn_5_sport_star);
        btn_5_sport_lock = (ImageView) findViewById(R.id.btn_5_sport_lock);
        btn_5_sport = (ImageView) findViewById(R.id.btn_5_sport);
        btn_6_sport_star = (ImageView) findViewById(R.id.btn_6_sport_star);
        btn_6_sport_lock = (ImageView) findViewById(R.id.btn_6_sport_lock);
        btn_6_sport = (ImageView) findViewById(R.id.btn_6_sport);
        btn_7_sport_star = (ImageView) findViewById(R.id.btn_7_sport_star);
        btn_7_sport_lock = (ImageView) findViewById(R.id.btn_7_sport_lock);
        btn_7_sport = (ImageView) findViewById(R.id.btn_7_sport);
        btn_8_sport_star = (ImageView) findViewById(R.id.btn_8_sport_star);
        btn_8_sport_lock = (ImageView) findViewById(R.id.btn_8_sport_lock);
        btn_8_sport = (ImageView) findViewById(R.id.btn_8_sport);
        btn_9_sport_star = (ImageView) findViewById(R.id.btn_9_sport_star);
        btn_9_sport_lock = (ImageView) findViewById(R.id.btn_9_sport_lock);
        btn_9_sport = (ImageView) findViewById(R.id.btn_9_sport);
        btn_10_sport_star = (ImageView) findViewById(R.id.btn_10_sport_star);
        btn_10_sport = (ImageView) findViewById(R.id.btn_10_sport);
        btn_11_sport_star = (ImageView) findViewById(R.id.btn_11_sport_star);
        btn_11_sport_lock = (ImageView) findViewById(R.id.btn_11_sport_lock);
        btn_11_sport = (ImageView) findViewById(R.id.btn_11_sport);
        btn_12_sport_star = (ImageView) findViewById(R.id.btn_12_sport_star);
        btn_12_sport_lock = (ImageView) findViewById(R.id.btn_12_sport_lock);
        btn_12_sport = (ImageView) findViewById(R.id.btn_12_sport);
        btn_13_sport_star = (ImageView) findViewById(R.id.btn_13_sport_star);
        btn_13_sport_lock = (ImageView) findViewById(R.id.btn_13_sport_lock);
        btn_13_sport = (ImageView) findViewById(R.id.btn_13_sport);
        btn_14_sport_star = (ImageView) findViewById(R.id.btn_14_sport_star);
        btn_14_sport_lock = (ImageView) findViewById(R.id.btn_14_sport_lock);
        btn_14_sport = (ImageView) findViewById(R.id.btn_14_sport);
        btn_15_sport_star = (ImageView) findViewById(R.id.btn_15_sport_star);
        btn_15_sport_lock = (ImageView) findViewById(R.id.btn_15_sport_lock);
        btn_15_sport = (ImageView) findViewById(R.id.btn_15_sport);
        btn_16_sport_star = (ImageView) findViewById(R.id.btn_16_sport_star);
        btn_16_sport_lock = (ImageView) findViewById(R.id.btn_16_sport_lock);
        btn_16_sport = (ImageView) findViewById(R.id.btn_16_sport);
        btn_17_sport_star = (ImageView) findViewById(R.id.btn_17_sport_star);
        btn_17_sport_lock = (ImageView) findViewById(R.id.btn_17_sport_lock);
        btn_17_sport = (ImageView) findViewById(R.id.btn_17_sport);
        btn_18_sport_star = (ImageView) findViewById(R.id.btn_18_sport_star);
        btn_18_sport_lock = (ImageView) findViewById(R.id.btn_18_sport_lock);
        btn_18_sport = (ImageView) findViewById(R.id.btn_18_sport);
        btn_19_sport_star = (ImageView) findViewById(R.id.btn_19_sport_star);
        btn_19_sport_lock = (ImageView) findViewById(R.id.btn_19_sport_lock);
        btn_19_sport = (ImageView) findViewById(R.id.btn_19_sport);
        btn_20_sport_star = (ImageView) findViewById(R.id.btn_20_sport_star);
        btn_20_sport = (ImageView) findViewById(R.id.btn_20_sport);
        btn_21_sport_star = (ImageView) findViewById(R.id.btn_21_sport_star);
        btn_21_sport_lock = (ImageView) findViewById(R.id.btn_21_sport_lock);
        btn_21_sport = (ImageView) findViewById(R.id.btn_21_sport);
        btn_22_sport_star = (ImageView) findViewById(R.id.btn_22_sport_star);
        btn_22_sport_lock = (ImageView) findViewById(R.id.btn_22_sport_lock);
        btn_22_sport = (ImageView) findViewById(R.id.btn_22_sport);
        btn_23_sport_star = (ImageView) findViewById(R.id.btn_23_sport_star);
        btn_23_sport_lock = (ImageView) findViewById(R.id.btn_23_sport_lock);
        btn_23_sport = (ImageView) findViewById(R.id.btn_23_sport);
        btn_24_sport_star = (ImageView) findViewById(R.id.btn_24_sport_star);
        btn_24_sport_lock = (ImageView) findViewById(R.id.btn_24_sport_lock);
        btn_24_sport = (ImageView) findViewById(R.id.btn_24_sport);
        btn_25_sport_star = (ImageView) findViewById(R.id.btn_25_sport_star);
        btn_25_sport_lock = (ImageView) findViewById(R.id.btn_25_sport_lock);
        btn_25_sport = (ImageView) findViewById(R.id.btn_25_sport);
        btn_26_sport_star = (ImageView) findViewById(R.id.btn_26_sport_star);
        btn_26_sport_lock = (ImageView) findViewById(R.id.btn_26_sport_lock);
        btn_26_sport = (ImageView) findViewById(R.id.btn_26_sport);
        btn_27_sport_star = (ImageView) findViewById(R.id.btn_27_sport_star);
        btn_27_sport_lock = (ImageView) findViewById(R.id.btn_27_sport_lock);
        btn_27_sport = (ImageView) findViewById(R.id.btn_27_sport);
        btn_28_sport_star = (ImageView) findViewById(R.id.btn_28_sport_star);
        btn_28_sport_lock = (ImageView) findViewById(R.id.btn_28_sport_lock);
        btn_28_sport = (ImageView) findViewById(R.id.btn_28_sport);
        btn_29_sport_star = (ImageView) findViewById(R.id.btn_29_sport_star);
        btn_29_sport_lock = (ImageView) findViewById(R.id.btn_29_sport_lock);
        btn_29_sport = (ImageView) findViewById(R.id.btn_29_sport);
        btn_30_sport_star = (ImageView) findViewById(R.id.btn_30_sport_star);
        btn_30_sport_lock = (ImageView) findViewById(R.id.btn_30_sport_lock);
        btn_30_sport = (ImageView) findViewById(R.id.btn_30_sport);
        btn_1_sport_star = (ImageView) findViewById(R.id.btn_1_sport_star);
        btn_1_sport = (ImageView) findViewById(R.id.btn_1_sport);
        com_son_sport = (CardView) findViewById(R.id.com_son_sport);

        btn_1_sport.setOnClickListener(this);
        btn_1_sport_star.setOnClickListener(this);
        btn_30_sport.setOnClickListener(this);
        btn_30_sport_star.setOnClickListener(this);
        btn_29_sport.setOnClickListener(this);
        btn_29_sport_star.setOnClickListener(this);
        btn_28_sport.setOnClickListener(this);
        btn_28_sport_star.setOnClickListener(this);
        btn_27_sport.setOnClickListener(this);
        btn_27_sport_star.setOnClickListener(this);
        btn_26_sport.setOnClickListener(this);
        btn_26_sport_star.setOnClickListener(this);
        btn_25_sport.setOnClickListener(this);
        btn_25_sport_star.setOnClickListener(this);
        btn_24_sport.setOnClickListener(this);
        btn_24_sport_star.setOnClickListener(this);
        btn_23_sport.setOnClickListener(this);
        btn_23_sport_star.setOnClickListener(this);
        btn_22_sport.setOnClickListener(this);
        btn_22_sport_star.setOnClickListener(this);
        btn_21_sport.setOnClickListener(this);
        btn_21_sport_star.setOnClickListener(this);
        btn_20_sport.setOnClickListener(this);
        btn_20_sport_star.setOnClickListener(this);
        btn_19_sport.setOnClickListener(this);
        btn_19_sport_star.setOnClickListener(this);
        btn_18_sport.setOnClickListener(this);
        btn_18_sport_star.setOnClickListener(this);
        btn_17_sport.setOnClickListener(this);
        btn_17_sport_star.setOnClickListener(this);
        btn_16_sport.setOnClickListener(this);
        btn_16_sport_star.setOnClickListener(this);
        btn_15_sport.setOnClickListener(this);
        btn_15_sport_star.setOnClickListener(this);
        btn_14_sport.setOnClickListener(this);
        btn_14_sport_star.setOnClickListener(this);
        btn_13_sport.setOnClickListener(this);
        btn_13_sport_star.setOnClickListener(this);
        btn_12_sport.setOnClickListener(this);
        btn_12_sport_star.setOnClickListener(this);
        btn_11_sport.setOnClickListener(this);
        btn_11_sport_star.setOnClickListener(this);
        btn_10_sport.setOnClickListener(this);
        btn_10_sport_star.setOnClickListener(this);
        btn_9_sport.setOnClickListener(this);
        btn_9_sport_star.setOnClickListener(this);
        btn_8_sport.setOnClickListener(this);
        btn_8_sport_star.setOnClickListener(this);
        btn_7_sport.setOnClickListener(this);
        btn_7_sport_star.setOnClickListener(this);
        btn_6_sport.setOnClickListener(this);
        btn_6_sport_star.setOnClickListener(this);
        btn_5_sport.setOnClickListener(this);
        btn_5_sport_star.setOnClickListener(this);
        btn_4_sport.setOnClickListener(this);
        btn_4_sport_star.setOnClickListener(this);
        btn_3_sport.setOnClickListener(this);
        btn_3_sport_star.setOnClickListener(this);
        btn_2_sport.setOnClickListener(this);
        btn_2_sport_star.setOnClickListener(this);
        com_son_sport.setOnClickListener(this);

        try {

            type3 = Typeface.createFromAsset(getAssets(), "en_font_1.otf");

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("6"));
        }

        try {

            txt_sport_1.setTypeface(type3);
            txt_sport_2.setTypeface(type3);
            txt_sport_3.setTypeface(type3);
            txt_sport_4.setTypeface(type3);
            txt_sport_5.setTypeface(type3);
            txt_sport_6.setTypeface(type3);
            txt_sport_7.setTypeface(type3);
            txt_sport_8.setTypeface(type3);
            txt_sport_9.setTypeface(type3);
            txt_sport_10.setTypeface(type3);
            txt_sport_11.setTypeface(type3);
            txt_sport_12.setTypeface(type3);
            txt_sport_13.setTypeface(type3);
            txt_sport_14.setTypeface(type3);
            txt_sport_15.setTypeface(type3);
            txt_sport_16.setTypeface(type3);
            txt_sport_17.setTypeface(type3);
            txt_sport_18.setTypeface(type3);
            txt_sport_19.setTypeface(type3);
            txt_sport_20.setTypeface(type3);
            txt_sport_21.setTypeface(type3);
            txt_sport_22.setTypeface(type3);
            txt_sport_23.setTypeface(type3);
            txt_sport_24.setTypeface(type3);
            txt_sport_25.setTypeface(type3);
            txt_sport_26.setTypeface(type3);
            txt_sport_27.setTypeface(type3);
            txt_sport_28.setTypeface(type3);
            txt_sport_29.setTypeface(type3);
            txt_sport_30.setTypeface(type3);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("7"));
        }


        int s1 = 1;
        int s2 = 1;
        int s3 = 1;
        int sport_1_1 = 11;
        int sport_1_2 = 12;
        int sport_1_3 = 13;
        int sport_1_4 = 14;
        int sport_1_5 = 15;
        int sport_1_6 = 16;
        int sport_1_7 = 17;
        int sport_1_8 = 18;
        int sport_1_9 = 19;
        int sport_1 = sport_namber.getInt("sport_number_show_set_1", 0);
        int sport_1_1_s = sport_namber.getInt("sport_number_show_11", 0);
        int sport_1_2_s = sport_namber.getInt("sport_number_show_12", 0);
        int sport_1_3_s = sport_namber.getInt("sport_number_show_13", 0);
        int sport_1_4_s = sport_namber.getInt("sport_number_show_14", 0);
        int sport_1_5_s = sport_namber.getInt("sport_number_show_15", 0);
        int sport_1_6_s = sport_namber.getInt("sport_number_show_16", 0);
        int sport_1_7_s = sport_namber.getInt("sport_number_show_17", 0);
        int sport_1_8_s = sport_namber.getInt("sport_number_show_18", 0);
        int sport_1_9_s = sport_namber.getInt("sport_number_show_19", 0);
        if (s1 == sport_1) {

            try {

                com_son_sport.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("8"));
            }


            if (sport_1_1 == sport_1_1_s) {

                try {

                    btn_1_sport_star.setVisibility(View.VISIBLE);
                    btn_1_sport.setVisibility(View.INVISIBLE);
                    txt_sport_1.setVisibility(View.VISIBLE);
                    txt_sport_1_day.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("9"));
                }

                try {

                    txt_sport_1.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_1_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("10"));
                }


            } else {

                try {

                    btn_1_sport_star.setVisibility(View.INVISIBLE);
                    btn_1_sport.setVisibility(View.VISIBLE);
                    txt_sport_1.setVisibility(View.VISIBLE);
                    txt_sport_1_day.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }


            }

            if (sport_1_2 == sport_1_2_s) {

                try {

                    btn_2_sport_star.setVisibility(View.VISIBLE);
                    btn_2_sport.setVisibility(View.INVISIBLE);
                    txt_sport_2.setVisibility(View.VISIBLE);
                    txt_sport_2_day.setVisibility(View.VISIBLE);
                    btn_2_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_2.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_2_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("12"));
                }


            } else {

                try {

                    btn_2_sport_star.setVisibility(View.INVISIBLE);
                    btn_2_sport.setVisibility(View.VISIBLE);
                    txt_sport_2.setVisibility(View.VISIBLE);
                    txt_sport_2_day.setVisibility(View.VISIBLE);
                    btn_2_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("13"));
                }


            }

            if (sport_1_3 == sport_1_3_s) {

                try {

                    btn_3_sport_star.setVisibility(View.VISIBLE);
                    btn_3_sport.setVisibility(View.INVISIBLE);
                    txt_sport_3.setVisibility(View.VISIBLE);
                    txt_sport_3_day.setVisibility(View.VISIBLE);
                    btn_3_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_3.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_3_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("14"));
                }


            } else {

                try {

                    btn_3_sport_star.setVisibility(View.INVISIBLE);
                    btn_3_sport.setVisibility(View.VISIBLE);
                    txt_sport_3.setVisibility(View.VISIBLE);
                    txt_sport_3_day.setVisibility(View.VISIBLE);
                    btn_3_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }


            }

            if (sport_1_4 == sport_1_4_s) {

                try {

                    btn_4_sport_star.setVisibility(View.VISIBLE);
                    btn_4_sport.setVisibility(View.INVISIBLE);
                    txt_sport_4.setVisibility(View.VISIBLE);
                    txt_sport_4_day.setVisibility(View.VISIBLE);
                    btn_4_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_4.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_4_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                }


            } else {

                try {

                    btn_4_sport_star.setVisibility(View.INVISIBLE);
                    btn_4_sport.setVisibility(View.VISIBLE);
                    txt_sport_4.setVisibility(View.VISIBLE);
                    txt_sport_4_day.setVisibility(View.VISIBLE);
                    btn_4_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }


            }
            if (sport_1_5 == sport_1_5_s) {

                try {

                    btn_5_sport_star.setVisibility(View.VISIBLE);
                    btn_5_sport.setVisibility(View.INVISIBLE);
                    txt_sport_5.setVisibility(View.VISIBLE);
                    txt_sport_5_day.setVisibility(View.VISIBLE);
                    btn_5_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_5.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_5_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                }


            } else {

                try {

                    btn_5_sport_star.setVisibility(View.INVISIBLE);
                    btn_5_sport.setVisibility(View.VISIBLE);
                    txt_sport_5.setVisibility(View.VISIBLE);
                    txt_sport_5_day.setVisibility(View.VISIBLE);
                    btn_5_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("19"));
                }


            }

            if (sport_1_6 == sport_1_6_s) {

                try {

                    btn_6_sport_star.setVisibility(View.VISIBLE);
                    btn_6_sport.setVisibility(View.INVISIBLE);
                    txt_sport_6.setVisibility(View.VISIBLE);
                    txt_sport_6_day.setVisibility(View.VISIBLE);
                    btn_6_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_6.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_6_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("20"));
                }


            } else {

                try {

                    btn_6_sport_star.setVisibility(View.INVISIBLE);
                    btn_6_sport.setVisibility(View.VISIBLE);
                    txt_sport_6.setVisibility(View.VISIBLE);
                    txt_sport_6_day.setVisibility(View.VISIBLE);
                    btn_6_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("21"));
                }


            }

            if (sport_1_7 == sport_1_7_s) {

                try {

                    btn_7_sport_star.setVisibility(View.VISIBLE);
                    btn_7_sport.setVisibility(View.INVISIBLE);
                    txt_sport_7.setVisibility(View.VISIBLE);
                    txt_sport_7_day.setVisibility(View.VISIBLE);
                    btn_7_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_7.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_7_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("22"));
                }


            } else {

                try {

                    btn_7_sport_star.setVisibility(View.INVISIBLE);
                    btn_7_sport.setVisibility(View.VISIBLE);
                    txt_sport_7.setVisibility(View.VISIBLE);
                    txt_sport_7_day.setVisibility(View.VISIBLE);
                    btn_7_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("23"));
                }


            }

            if (sport_1_8 == sport_1_8_s) {

                try {

                    btn_8_sport_star.setVisibility(View.VISIBLE);
                    btn_8_sport.setVisibility(View.INVISIBLE);
                    txt_sport_8.setVisibility(View.VISIBLE);
                    txt_sport_8_day.setVisibility(View.VISIBLE);
                    btn_8_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_8.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_8_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("24"));
                }


            } else {

                try {

                    btn_8_sport_star.setVisibility(View.INVISIBLE);
                    btn_8_sport.setVisibility(View.VISIBLE);
                    txt_sport_8.setVisibility(View.VISIBLE);
                    txt_sport_8_day.setVisibility(View.VISIBLE);
                    btn_8_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("25"));
                }


            }

            if (sport_1_9 == sport_1_9_s) {

                try {

                    btn_9_sport_star.setVisibility(View.VISIBLE);
                    btn_9_sport.setVisibility(View.INVISIBLE);
                    txt_sport_9.setVisibility(View.VISIBLE);
                    txt_sport_9_day.setVisibility(View.VISIBLE);
                    btn_9_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_9.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_9_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("26"));
                }


            } else {

                try {

                    btn_9_sport_star.setVisibility(View.INVISIBLE);
                    btn_9_sport.setVisibility(View.VISIBLE);
                    txt_sport_9.setVisibility(View.VISIBLE);
                    txt_sport_9_day.setVisibility(View.VISIBLE);
                    btn_9_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("27"));
                }


            }


        } else {

            try {

                btn_2_sport_star.setVisibility(View.INVISIBLE);
                btn_2_sport.setVisibility(View.INVISIBLE);
                txt_sport_2.setVisibility(View.INVISIBLE);
                txt_sport_2_day.setVisibility(View.INVISIBLE);
                btn_2_sport_lock.setVisibility(View.VISIBLE);

                btn_3_sport_star.setVisibility(View.INVISIBLE);
                btn_3_sport.setVisibility(View.INVISIBLE);
                txt_sport_3.setVisibility(View.INVISIBLE);
                txt_sport_3_day.setVisibility(View.INVISIBLE);
                btn_3_sport_lock.setVisibility(View.VISIBLE);

                btn_4_sport_star.setVisibility(View.INVISIBLE);
                btn_4_sport.setVisibility(View.INVISIBLE);
                txt_sport_4.setVisibility(View.INVISIBLE);
                txt_sport_4_day.setVisibility(View.INVISIBLE);
                btn_4_sport_lock.setVisibility(View.VISIBLE);

                btn_5_sport_star.setVisibility(View.INVISIBLE);
                btn_5_sport.setVisibility(View.INVISIBLE);
                txt_sport_5.setVisibility(View.INVISIBLE);
                txt_sport_5_day.setVisibility(View.INVISIBLE);
                btn_5_sport_lock.setVisibility(View.VISIBLE);

                btn_6_sport_star.setVisibility(View.INVISIBLE);
                btn_6_sport.setVisibility(View.INVISIBLE);
                txt_sport_6.setVisibility(View.INVISIBLE);
                txt_sport_6_day.setVisibility(View.INVISIBLE);
                btn_6_sport_lock.setVisibility(View.VISIBLE);

                btn_7_sport_star.setVisibility(View.INVISIBLE);
                btn_7_sport.setVisibility(View.INVISIBLE);
                txt_sport_7.setVisibility(View.INVISIBLE);
                txt_sport_7_day.setVisibility(View.INVISIBLE);
                btn_7_sport_lock.setVisibility(View.VISIBLE);

                btn_8_sport_star.setVisibility(View.INVISIBLE);
                btn_8_sport.setVisibility(View.INVISIBLE);
                txt_sport_8.setVisibility(View.INVISIBLE);
                txt_sport_8_day.setVisibility(View.INVISIBLE);
                btn_8_sport_lock.setVisibility(View.VISIBLE);

                btn_9_sport_star.setVisibility(View.INVISIBLE);
                btn_9_sport.setVisibility(View.INVISIBLE);
                txt_sport_9.setVisibility(View.INVISIBLE);
                txt_sport_9_day.setVisibility(View.INVISIBLE);
                btn_9_sport_lock.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("28"));
            }


        }


        int sport_2_1 = 11;
        int sport_2_2 = 12;
        int sport_2_3 = 13;
        int sport_2_4 = 14;
        int sport_2_5 = 15;
        int sport_2_6 = 16;
        int sport_2_7 = 17;
        int sport_2_8 = 18;
        int sport_2_9 = 19;
        int sport_2_10 = 20;
        int sport_2 = sport_namber.getInt("sport_number_show_set_2", 0);
        int sport_2_1_s = sport_namber.getInt("sport_number_show_21", 0);
        int sport_2_2_s = sport_namber.getInt("sport_number_show_22", 0);
        int sport_2_3_s = sport_namber.getInt("sport_number_show_23", 0);
        int sport_2_4_s = sport_namber.getInt("sport_number_show_24", 0);
        int sport_2_5_s = sport_namber.getInt("sport_number_show_25", 0);
        int sport_2_6_s = sport_namber.getInt("sport_number_show_26", 0);
        int sport_2_7_s = sport_namber.getInt("sport_number_show_27", 0);
        int sport_2_8_s = sport_namber.getInt("sport_number_show_28", 0);
        int sport_2_9_s = sport_namber.getInt("sport_number_show_29", 0);
        int sport_2_10_s = sport_namber.getInt("sport_number_show_20", 0);

        if (s2 == sport_2) {


            if (sport_2_1 == sport_2_1_s) {

                try {

                    btn_10_sport_star.setVisibility(View.VISIBLE);
                    btn_10_sport.setVisibility(View.INVISIBLE);
                    txt_sport_10.setVisibility(View.VISIBLE);
                    txt_sport_10_day.setVisibility(View.VISIBLE);

                    txt_sport_10.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_10_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("29"));
                }


            } else {

                try {

                    btn_10_sport_star.setVisibility(View.INVISIBLE);
                    btn_10_sport.setVisibility(View.VISIBLE);
                    txt_sport_10.setVisibility(View.VISIBLE);
                    txt_sport_10_day.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("30"));
                }


            }

            if (sport_2_2 == sport_2_2_s) {

                try {

                    btn_11_sport_star.setVisibility(View.VISIBLE);
                    btn_11_sport.setVisibility(View.INVISIBLE);
                    txt_sport_11.setVisibility(View.VISIBLE);
                    txt_sport_11_day.setVisibility(View.VISIBLE);
                    btn_11_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_11.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_11_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("31"));
                }


            } else {

                try {

                    btn_11_sport_star.setVisibility(View.INVISIBLE);
                    btn_11_sport.setVisibility(View.VISIBLE);
                    txt_sport_11.setVisibility(View.VISIBLE);
                    txt_sport_11_day.setVisibility(View.VISIBLE);
                    btn_11_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("32"));
                }


            }

            if (sport_2_3 == sport_2_3_s) {

                try {

                    btn_12_sport_star.setVisibility(View.VISIBLE);
                    btn_12_sport.setVisibility(View.INVISIBLE);
                    txt_sport_12.setVisibility(View.VISIBLE);
                    txt_sport_12_day.setVisibility(View.VISIBLE);
                    btn_12_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_12.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_12_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("33"));
                }


            } else {

                try {

                    btn_12_sport_star.setVisibility(View.INVISIBLE);
                    btn_12_sport.setVisibility(View.VISIBLE);
                    txt_sport_12.setVisibility(View.VISIBLE);
                    txt_sport_12_day.setVisibility(View.VISIBLE);
                    btn_12_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("34"));
                }


            }

            if (sport_2_4 == sport_2_4_s) {

                try {

                    btn_13_sport_star.setVisibility(View.VISIBLE);
                    btn_13_sport.setVisibility(View.INVISIBLE);
                    txt_sport_13.setVisibility(View.VISIBLE);
                    txt_sport_13_day.setVisibility(View.VISIBLE);
                    btn_13_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_13.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_13_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("35"));
                }


            } else {

                try {

                    btn_13_sport_star.setVisibility(View.INVISIBLE);
                    btn_13_sport.setVisibility(View.VISIBLE);
                    txt_sport_13.setVisibility(View.VISIBLE);
                    txt_sport_13_day.setVisibility(View.VISIBLE);
                    btn_13_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("36"));
                }


            }
            if (sport_2_5 == sport_2_5_s) {

                try {

                    btn_14_sport_star.setVisibility(View.VISIBLE);
                    btn_14_sport.setVisibility(View.INVISIBLE);
                    txt_sport_14.setVisibility(View.VISIBLE);
                    txt_sport_14_day.setVisibility(View.VISIBLE);
                    btn_14_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_14.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_14_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("37"));
                }


            } else {

                try {

                    btn_14_sport_star.setVisibility(View.INVISIBLE);
                    btn_14_sport.setVisibility(View.VISIBLE);
                    txt_sport_14.setVisibility(View.VISIBLE);
                    txt_sport_14_day.setVisibility(View.VISIBLE);
                    btn_14_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("38"));
                }


            }

            if (sport_2_6 == sport_2_6_s) {

                try {

                    btn_15_sport_star.setVisibility(View.VISIBLE);
                    btn_15_sport.setVisibility(View.INVISIBLE);
                    txt_sport_15.setVisibility(View.VISIBLE);
                    txt_sport_15_day.setVisibility(View.VISIBLE);
                    btn_15_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_15.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_15_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }


            } else {

                try {

                    btn_15_sport_star.setVisibility(View.INVISIBLE);
                    btn_15_sport.setVisibility(View.VISIBLE);
                    txt_sport_15.setVisibility(View.VISIBLE);
                    txt_sport_15_day.setVisibility(View.VISIBLE);
                    btn_15_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("40"));
                }


            }

            if (sport_2_7 == sport_2_7_s) {

                try {

                    btn_16_sport_star.setVisibility(View.VISIBLE);
                    btn_16_sport.setVisibility(View.INVISIBLE);
                    txt_sport_16.setVisibility(View.VISIBLE);
                    txt_sport_16_day.setVisibility(View.VISIBLE);
                    btn_16_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_16.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_16_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("41"));
                }


            } else {

                try {

                    btn_16_sport_star.setVisibility(View.INVISIBLE);
                    btn_16_sport.setVisibility(View.VISIBLE);
                    txt_sport_16.setVisibility(View.VISIBLE);
                    txt_sport_16_day.setVisibility(View.VISIBLE);
                    btn_16_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("42"));
                }


            }

            if (sport_2_8 == sport_2_8_s) {

                try {

                    btn_17_sport_star.setVisibility(View.VISIBLE);
                    btn_17_sport.setVisibility(View.INVISIBLE);
                    txt_sport_17.setVisibility(View.VISIBLE);
                    txt_sport_17_day.setVisibility(View.VISIBLE);
                    btn_17_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_17.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_17_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("43"));
                }


            } else {

                try {

                    btn_17_sport_star.setVisibility(View.INVISIBLE);
                    btn_17_sport.setVisibility(View.VISIBLE);
                    txt_sport_17.setVisibility(View.VISIBLE);
                    txt_sport_17_day.setVisibility(View.VISIBLE);
                    btn_17_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }


            }

            if (sport_2_9 == sport_2_9_s) {

                try {

                    btn_18_sport_star.setVisibility(View.VISIBLE);
                    btn_18_sport.setVisibility(View.INVISIBLE);
                    txt_sport_18.setVisibility(View.VISIBLE);
                    txt_sport_18_day.setVisibility(View.VISIBLE);
                    btn_18_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_18.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_18_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("45"));
                }


            } else {

                try {

                    btn_18_sport_star.setVisibility(View.INVISIBLE);
                    btn_18_sport.setVisibility(View.VISIBLE);
                    txt_sport_18.setVisibility(View.VISIBLE);
                    txt_sport_18_day.setVisibility(View.VISIBLE);
                    btn_18_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("46"));
                }


            }

            if (sport_2_10 == sport_2_10_s) {

                try {

                    btn_19_sport_star.setVisibility(View.VISIBLE);
                    btn_19_sport.setVisibility(View.INVISIBLE);
                    txt_sport_19.setVisibility(View.VISIBLE);
                    txt_sport_19_day.setVisibility(View.VISIBLE);
                    btn_19_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_19.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_19_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("47"));
                }


            } else {

                try {

                    btn_19_sport_star.setVisibility(View.INVISIBLE);
                    btn_19_sport.setVisibility(View.VISIBLE);
                    txt_sport_19.setVisibility(View.VISIBLE);
                    txt_sport_19_day.setVisibility(View.VISIBLE);
                    btn_19_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("48"));
                }


            }


        } else {

            try {

                btn_11_sport_star.setVisibility(View.INVISIBLE);
                btn_11_sport.setVisibility(View.INVISIBLE);
                txt_sport_11.setVisibility(View.INVISIBLE);
                txt_sport_11_day.setVisibility(View.INVISIBLE);
                btn_11_sport_lock.setVisibility(View.VISIBLE);

                btn_12_sport_star.setVisibility(View.INVISIBLE);
                btn_12_sport.setVisibility(View.INVISIBLE);
                txt_sport_12.setVisibility(View.INVISIBLE);
                txt_sport_12_day.setVisibility(View.INVISIBLE);
                btn_12_sport_lock.setVisibility(View.VISIBLE);

                btn_13_sport_star.setVisibility(View.INVISIBLE);
                btn_13_sport.setVisibility(View.INVISIBLE);
                txt_sport_13.setVisibility(View.INVISIBLE);
                txt_sport_13_day.setVisibility(View.INVISIBLE);
                btn_13_sport_lock.setVisibility(View.VISIBLE);

                btn_14_sport_star.setVisibility(View.INVISIBLE);
                btn_14_sport.setVisibility(View.INVISIBLE);
                txt_sport_14.setVisibility(View.INVISIBLE);
                txt_sport_14_day.setVisibility(View.INVISIBLE);
                btn_14_sport_lock.setVisibility(View.VISIBLE);

                btn_15_sport_star.setVisibility(View.INVISIBLE);
                btn_15_sport.setVisibility(View.INVISIBLE);
                txt_sport_15.setVisibility(View.INVISIBLE);
                txt_sport_15_day.setVisibility(View.INVISIBLE);
                btn_15_sport_lock.setVisibility(View.VISIBLE);

                btn_16_sport_star.setVisibility(View.INVISIBLE);
                btn_16_sport.setVisibility(View.INVISIBLE);
                txt_sport_16.setVisibility(View.INVISIBLE);
                txt_sport_16_day.setVisibility(View.INVISIBLE);
                btn_16_sport_lock.setVisibility(View.VISIBLE);

                btn_17_sport_star.setVisibility(View.INVISIBLE);
                btn_17_sport.setVisibility(View.INVISIBLE);
                txt_sport_17.setVisibility(View.INVISIBLE);
                txt_sport_17_day.setVisibility(View.INVISIBLE);
                btn_17_sport_lock.setVisibility(View.VISIBLE);

                btn_18_sport_star.setVisibility(View.INVISIBLE);
                btn_18_sport.setVisibility(View.INVISIBLE);
                txt_sport_18.setVisibility(View.INVISIBLE);
                txt_sport_18_day.setVisibility(View.INVISIBLE);
                btn_18_sport_lock.setVisibility(View.VISIBLE);

                btn_19_sport_star.setVisibility(View.INVISIBLE);
                btn_19_sport.setVisibility(View.INVISIBLE);
                txt_sport_19.setVisibility(View.INVISIBLE);
                txt_sport_19_day.setVisibility(View.INVISIBLE);
                btn_19_sport_lock.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("49"));
            }


        }


        int sport_3_1 = 11;
        int sport_3_2 = 12;
        int sport_3_3 = 13;
        int sport_3_4 = 14;
        int sport_3_5 = 15;
        int sport_3_6 = 16;
        int sport_3_7 = 17;
        int sport_3_8 = 18;
        int sport_3_9 = 19;
        int sport_3_10 = 20;
        int sport_3_11 = 30;
        int sport_3 = sport_namber.getInt("sport_number_show_set_3", 0);
        int sport_3_1_s = sport_namber.getInt("sport_number_show_31", 0);
        int sport_3_2_s = sport_namber.getInt("sport_number_show_32", 0);
        int sport_3_3_s = sport_namber.getInt("sport_number_show_33", 0);
        int sport_3_4_s = sport_namber.getInt("sport_number_show_34", 0);
        int sport_3_5_s = sport_namber.getInt("sport_number_show_35", 0);
        int sport_3_6_s = sport_namber.getInt("sport_number_show_36", 0);
        int sport_3_7_s = sport_namber.getInt("sport_number_show_37", 0);
        int sport_3_8_s = sport_namber.getInt("sport_number_show_38", 0);
        int sport_3_9_s = sport_namber.getInt("sport_number_show_39", 0);
        int sport_3_10_s = sport_namber.getInt("sport_number_show_30", 0);
        int sport_3_11_s = sport_namber.getInt("sport_number_show_40", 0);


        if (s3 == sport_3) {


            if (sport_3_1 == sport_3_1_s) {

                try {

                    btn_20_sport_star.setVisibility(View.VISIBLE);
                    btn_20_sport.setVisibility(View.INVISIBLE);
                    txt_sport_20.setVisibility(View.VISIBLE);
                    txt_sport_20_day.setVisibility(View.VISIBLE);

                    txt_sport_20.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_20_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("50"));
                }


            } else {

                try {

                    btn_20_sport_star.setVisibility(View.INVISIBLE);
                    btn_20_sport.setVisibility(View.VISIBLE);
                    txt_sport_20.setVisibility(View.VISIBLE);
                    txt_sport_20_day.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("51"));
                }


            }

            if (sport_3_2 == sport_3_2_s) {

                try {

                    btn_21_sport_star.setVisibility(View.VISIBLE);
                    btn_21_sport.setVisibility(View.INVISIBLE);
                    txt_sport_21.setVisibility(View.VISIBLE);
                    txt_sport_21_day.setVisibility(View.VISIBLE);
                    btn_21_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_21.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_21_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("52"));
                }


            } else {

                try {

                    btn_21_sport_star.setVisibility(View.INVISIBLE);
                    btn_21_sport.setVisibility(View.VISIBLE);
                    txt_sport_21.setVisibility(View.VISIBLE);
                    txt_sport_21_day.setVisibility(View.VISIBLE);
                    btn_21_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("53"));
                }


            }

            if (sport_3_3 == sport_3_3_s) {

                try {

                    btn_22_sport_star.setVisibility(View.VISIBLE);
                    btn_22_sport.setVisibility(View.INVISIBLE);
                    txt_sport_22.setVisibility(View.VISIBLE);
                    txt_sport_22_day.setVisibility(View.VISIBLE);
                    btn_22_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_22.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_22_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("54"));
                }


            } else {

                try {

                    btn_22_sport_star.setVisibility(View.INVISIBLE);
                    btn_22_sport.setVisibility(View.VISIBLE);
                    txt_sport_22.setVisibility(View.VISIBLE);
                    txt_sport_22_day.setVisibility(View.VISIBLE);
                    btn_22_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("55"));
                }


            }

            if (sport_3_4 == sport_3_4_s) {

                try {

                    btn_23_sport_star.setVisibility(View.VISIBLE);
                    btn_23_sport.setVisibility(View.INVISIBLE);
                    txt_sport_23.setVisibility(View.VISIBLE);
                    txt_sport_23_day.setVisibility(View.VISIBLE);
                    btn_23_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_23.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_23_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("56"));
                }


            } else {

                try {

                    btn_23_sport_star.setVisibility(View.INVISIBLE);
                    btn_23_sport.setVisibility(View.VISIBLE);
                    txt_sport_23.setVisibility(View.VISIBLE);
                    txt_sport_23_day.setVisibility(View.VISIBLE);
                    btn_23_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("57"));
                }


            }
            if (sport_3_5 == sport_3_5_s) {

                try {

                    btn_24_sport_star.setVisibility(View.VISIBLE);
                    btn_24_sport.setVisibility(View.INVISIBLE);
                    txt_sport_24.setVisibility(View.VISIBLE);
                    txt_sport_24_day.setVisibility(View.VISIBLE);
                    btn_24_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_24.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_24_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("58"));
                }


            } else {

                try {

                    btn_24_sport_star.setVisibility(View.INVISIBLE);
                    btn_24_sport.setVisibility(View.VISIBLE);
                    txt_sport_24.setVisibility(View.VISIBLE);
                    txt_sport_24_day.setVisibility(View.VISIBLE);
                    btn_24_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("59"));
                }


            }

            if (sport_3_6 == sport_3_6_s) {

                try {

                    btn_25_sport_star.setVisibility(View.VISIBLE);
                    btn_25_sport.setVisibility(View.INVISIBLE);
                    txt_sport_25.setVisibility(View.VISIBLE);
                    txt_sport_25_day.setVisibility(View.VISIBLE);
                    btn_25_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_25.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_25_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("60"));
                }


            } else {

                try {

                    btn_25_sport_star.setVisibility(View.INVISIBLE);
                    btn_25_sport.setVisibility(View.VISIBLE);
                    txt_sport_25.setVisibility(View.VISIBLE);
                    txt_sport_25_day.setVisibility(View.VISIBLE);
                    btn_25_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("61"));
                }


            }

            if (sport_3_7 == sport_3_7_s) {

                try {

                    btn_26_sport_star.setVisibility(View.VISIBLE);
                    btn_26_sport.setVisibility(View.INVISIBLE);
                    txt_sport_26.setVisibility(View.VISIBLE);
                    txt_sport_26_day.setVisibility(View.VISIBLE);
                    btn_26_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_26.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_26_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("62"));
                }


            } else {

                try {

                    btn_26_sport_star.setVisibility(View.INVISIBLE);
                    btn_26_sport.setVisibility(View.VISIBLE);
                    txt_sport_26.setVisibility(View.VISIBLE);
                    txt_sport_26_day.setVisibility(View.VISIBLE);
                    btn_26_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("63"));
                }


            }

            if (sport_3_8 == sport_3_8_s) {

                try {

                    btn_27_sport_star.setVisibility(View.VISIBLE);
                    btn_27_sport.setVisibility(View.INVISIBLE);
                    txt_sport_27.setVisibility(View.VISIBLE);
                    txt_sport_27_day.setVisibility(View.VISIBLE);
                    btn_27_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_27.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_27_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("64"));
                }


            } else {

                try {

                    btn_27_sport_star.setVisibility(View.INVISIBLE);
                    btn_27_sport.setVisibility(View.VISIBLE);
                    txt_sport_27.setVisibility(View.VISIBLE);
                    txt_sport_27_day.setVisibility(View.VISIBLE);
                    btn_27_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("65"));
                }


            }

            if (sport_3_9 == sport_3_9_s) {

                try {

                    btn_28_sport_star.setVisibility(View.VISIBLE);
                    btn_28_sport.setVisibility(View.INVISIBLE);
                    txt_sport_28.setVisibility(View.VISIBLE);
                    txt_sport_28_day.setVisibility(View.VISIBLE);
                    btn_28_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_28.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_28_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("66"));
                }


            } else {

                try {

                    btn_28_sport_star.setVisibility(View.INVISIBLE);
                    btn_28_sport.setVisibility(View.VISIBLE);
                    txt_sport_28.setVisibility(View.VISIBLE);
                    txt_sport_28_day.setVisibility(View.VISIBLE);
                    btn_28_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("67"));
                }


            }

            if (sport_3_10 == sport_3_10_s) {

                try {

                    btn_29_sport_star.setVisibility(View.VISIBLE);
                    btn_29_sport.setVisibility(View.INVISIBLE);
                    txt_sport_29.setVisibility(View.VISIBLE);
                    txt_sport_29_day.setVisibility(View.VISIBLE);
                    btn_29_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_29.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_29_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("68"));
                }


            } else {

                try {

                    btn_29_sport_star.setVisibility(View.INVISIBLE);
                    btn_29_sport.setVisibility(View.VISIBLE);
                    txt_sport_29.setVisibility(View.VISIBLE);
                    txt_sport_29_day.setVisibility(View.VISIBLE);
                    btn_29_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("69"));
                }


            }

            if (sport_3_11 == sport_3_11_s) {

                try {

                    btn_30_sport_star.setVisibility(View.VISIBLE);
                    btn_30_sport.setVisibility(View.INVISIBLE);
                    txt_sport_30.setVisibility(View.VISIBLE);
                    txt_sport_30_day.setVisibility(View.VISIBLE);
                    btn_30_sport_lock.setVisibility(View.INVISIBLE);

                    txt_sport_30.setTextColor(getResources().getColor(R.color.color30day_dark));
                    txt_sport_30_day.setTextColor(getResources().getColor(R.color.color30day_dark));

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("70"));
                }


            } else {

                try {

                    btn_30_sport_star.setVisibility(View.INVISIBLE);
                    btn_30_sport.setVisibility(View.VISIBLE);
                    txt_sport_30.setVisibility(View.VISIBLE);
                    txt_sport_30_day.setVisibility(View.VISIBLE);
                    btn_30_sport_lock.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("71"));
                }


            }


        } else {

            try {

                btn_21_sport_star.setVisibility(View.INVISIBLE);
                btn_21_sport.setVisibility(View.INVISIBLE);
                txt_sport_21.setVisibility(View.INVISIBLE);
                txt_sport_21_day.setVisibility(View.INVISIBLE);
                btn_21_sport_lock.setVisibility(View.VISIBLE);

                btn_22_sport_star.setVisibility(View.INVISIBLE);
                btn_22_sport.setVisibility(View.INVISIBLE);
                txt_sport_22.setVisibility(View.INVISIBLE);
                txt_sport_22_day.setVisibility(View.INVISIBLE);
                btn_22_sport_lock.setVisibility(View.VISIBLE);

                btn_23_sport_star.setVisibility(View.INVISIBLE);
                btn_23_sport.setVisibility(View.INVISIBLE);
                txt_sport_23.setVisibility(View.INVISIBLE);
                txt_sport_23_day.setVisibility(View.INVISIBLE);
                btn_23_sport_lock.setVisibility(View.VISIBLE);

                btn_24_sport_star.setVisibility(View.INVISIBLE);
                btn_24_sport.setVisibility(View.INVISIBLE);
                txt_sport_24.setVisibility(View.INVISIBLE);
                txt_sport_24_day.setVisibility(View.INVISIBLE);
                btn_24_sport_lock.setVisibility(View.VISIBLE);

                btn_25_sport_star.setVisibility(View.INVISIBLE);
                btn_25_sport.setVisibility(View.INVISIBLE);
                txt_sport_25.setVisibility(View.INVISIBLE);
                txt_sport_25_day.setVisibility(View.INVISIBLE);
                btn_25_sport_lock.setVisibility(View.VISIBLE);

                btn_26_sport_star.setVisibility(View.INVISIBLE);
                btn_26_sport.setVisibility(View.INVISIBLE);
                txt_sport_26.setVisibility(View.INVISIBLE);
                txt_sport_26_day.setVisibility(View.INVISIBLE);
                btn_26_sport_lock.setVisibility(View.VISIBLE);

                btn_27_sport_star.setVisibility(View.INVISIBLE);
                btn_27_sport.setVisibility(View.INVISIBLE);
                txt_sport_27.setVisibility(View.INVISIBLE);
                txt_sport_27_day.setVisibility(View.INVISIBLE);
                btn_27_sport_lock.setVisibility(View.VISIBLE);

                btn_28_sport_star.setVisibility(View.INVISIBLE);
                btn_28_sport.setVisibility(View.INVISIBLE);
                txt_sport_28.setVisibility(View.INVISIBLE);
                txt_sport_28_day.setVisibility(View.INVISIBLE);
                btn_28_sport_lock.setVisibility(View.VISIBLE);

                btn_29_sport_star.setVisibility(View.INVISIBLE);
                btn_29_sport.setVisibility(View.INVISIBLE);
                txt_sport_29.setVisibility(View.INVISIBLE);
                txt_sport_29_day.setVisibility(View.INVISIBLE);
                btn_29_sport_lock.setVisibility(View.VISIBLE);

                btn_30_sport_star.setVisibility(View.INVISIBLE);
                btn_30_sport.setVisibility(View.INVISIBLE);
                txt_sport_30.setVisibility(View.INVISIBLE);
                txt_sport_30_day.setVisibility(View.INVISIBLE);
                btn_30_sport_lock.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("72"));
            }


        }


//az bein bordn shekle scrollview
        ScrollView sView = (ScrollView) findViewById(R.id.scrollview_2);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        //az bein bordn shekle scrollview
        ScrollView sView2 = (ScrollView) findViewById(R.id.scrollView_sport);
        sView2.setVerticalScrollBarEnabled(false);
        sView2.setHorizontalScrollBarEnabled(false);


        about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
        about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);
        about_alertdialog_8 = (String) getText(R.string.about_alertdialog_8);
        about_alertdialog_9 = (String) getText(R.string.about_alertdialog_9);
        menu_exit = (String) getText(R.string.menu_exit2);
        no = (String) getText(R.string.no);
        yes = (String) getText(R.string.yes);


        about = (LinearLayout) findViewById(R.id.lin_menu_ab_1);
        diet = (LinearLayout) findViewById(R.id.lin_menu_d_1);
        dmusic = (LinearLayout) findViewById(R.id.lin_menu_dm_1);
        exit = (LinearLayout) findViewById(R.id.lin_menu_ex_1);
        settings = (LinearLayout) findViewById(R.id.lin_menu_sit_1);
        sports = (LinearLayout) findViewById(R.id.lin_menu_sp_1);
        help = (LinearLayout) findViewById(R.id.lin_menu_gu_1);


        about.setOnClickListener(this);
        dmusic.setOnClickListener(this);
        diet.setOnClickListener(this);
        sports.setOnClickListener(this);
        settings.setOnClickListener(this);
        help.setOnClickListener(this);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    new SweetAlertDialog(sport.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText(about_alertdialog_7)
                            .setContentText(about_alertdialog_6)
                            .setCancelText(no)
                            .setConfirmText(yes)
                            .showCancelButton(true)
                            .setCancelClickListener(null)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {


                                    new Handler().postDelayed(new Thread() {
                                        @Override
                                        public void run() {
                                            super.run();

                                            App.close();

                                        }
                                    }, _splashTime);
                                    sDialog.setTitleText(menu_exit)
                                            .setContentText(about_alertdialog_8)
                                            .setConfirmText(about_alertdialog_9)
                                            .showCancelButton(false)
                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                }
                            })
                            .show();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("73"));
                }


            }
        });


        drawerlayout = (DrawerLayout) findViewById(R.id.root_sport);

        back_page = (ImageView) findViewById(R.id.btn_back_page2);
        btn_menu = (ImageView) findViewById(R.id.btn_menu);

        back_page.setOnClickListener(this);
        btn_menu.setOnClickListener(this);

        if (help_play == 1) {

            String s11 = (String) getText(R.string.Help_start_3_1);
            String s22 = (String) getText(R.string.Help_start_3_2);

            try {

                mFabPrompt = new MaterialTapTargetPrompt.Builder(this)
                        .setTarget(btn_1_sport)
                        .setPrimaryText(s11)
                        .setSecondaryText(s22)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt = null;
                                one_play_editor.putInt("Help_play_3", 2);
                                one_play_editor.commit();

                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .show();


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("75"));
            }


        }
        FirebaseCrash.log("log 6");
        System.gc();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_back_page2:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("76"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("77"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();

                            if (sport_page == 2) {
                                Intent ssss = new Intent(sport.this, Page_2.class);
                                startActivity(ssss);
                            } else if (sport_page == 4) {
                                Intent ssss = new Intent(sport.this, food.class);
                                ssss.putExtra("zaban_fo", zaban);
                                startActivity(ssss);
                            } else {

                            }

                            finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("78"));
                }


                break;

            case R.id.btn_menu:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("79"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("80"));
                }


                if (drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerlayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerlayout.openDrawer(Gravity.LEFT);
                }
                break;


            case R.id.lin_menu_ab_1:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("81"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("82"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_1 = new Intent(sport.this, com.android.fury.a30day.menu_view.about.class);
                            about_1.putExtra("about_back", 3);
                            sport.this.startActivity(about_1);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("83"));
                }

                break;

            case R.id.lin_menu_sit_1:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("84"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("85"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_2 = new Intent(sport.this, com.android.fury.a30day.menu_view.setting.class);
                            about_2.putExtra("setting_back", 3);
                            sport.this.startActivity(about_2);
                            sport.this.finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("86"));
                }

                break;

            case R.id.lin_menu_gu_1:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("87"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("88"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent suport = new Intent(sport.this, Suport_me.class);
                            startActivity(suport);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("start support"));
                }
                break;

            case R.id.lin_menu_dm_1:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("103"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("104"));
                }

                new Handler().postDelayed(new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        if (app_net.getInstance(sport.this).isOnline()) {

                            Intent music = new Intent(sport.this, com.android.fury.a30day.menu_view.music.class);
                            music.putExtra("d_m_b", 1);
                            sport.this.startActivity(music);

                        } else {

                            Intent music_not = new Intent(sport.this, Not_net.class);
                            music_not.putExtra("d_m_b", 1);
                            sport.this.startActivity(music_not);

                        }
                    }
                }, _splashTime2);
                break;

            case R.id.lin_menu_sp_1:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("105"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("106"));
                }

                new Handler().postDelayed(new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        String go_music = (String) getText(R.string.sport_go_sport);
                        Toast.makeText(sport.this, go_music, Toast.LENGTH_LONG).show();
                    }
                }, _splashTime2);

                break;

            case R.id.lin_menu_d_1:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("107"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("108"));
                }

                new Handler().postDelayed(new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        Intent food_ = new Intent(sport.this, food.class);
                        food_.putExtra("zaban_fo", zaban);
                        sport.this.startActivity(food_);
                        sport.this.finish();
                    }
                }, _splashTime2);


                break;


            case R.id.btn_1_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("109"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("110"));
                }


                /**if (app_net.getInstance( this ).isOnline()) {


                 String food_male_plan_give_ads = (String) getText(R.string.food_male_plan_give_ads);
                 String food_male_plan_pls = (String) getText(R.string.food_male_plan_pls);

                 final SweetAlertDialog sd = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                 sd.setTitleText(food_male_plan_give_ads);
                 sd.setContentText(food_male_plan_pls);
                 sd.showCancelButton(false);
                 sd.show();

                 AdColony.addAdAvailabilityListener(new AdColonyAdAvailabilityListener() {
                @Override public void onAdColonyAdAvailabilityChange(final boolean b, String s) {

                runOnUiThread( new Runnable() {
                @Override public void run() {
                if (b) {

                ad.show();

                } else {
                }
                }
                } );

                }
                });



                 new Handler().postDelayed(new Thread() {
                @Override public void run() {
                super.run();

                String food_male_plan_not_net_ok = (String)getText(R.string.food_male_plan_not_net_ok);
                String food_male_plan_stop_time_1 = (String)getText(R.string.food_male_plan_stop_time_1);
                String food_male_plan_stop_time_2 = (String)getText(R.string.food_male_plan_stop_time_2);

                new SweetAlertDialog( sport.this , SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText( food_male_plan_stop_time_1 )
                .setContentText( food_male_plan_stop_time_2 )
                .setConfirmText( food_male_plan_not_net_ok )
                .setCustomImage( R.drawable.net_off )
                .showCancelButton( false )
                .setConfirmClickListener( null )
                .show();

                }
                }, 60000);



                 }else {


                 String food_male_plan_not_net = (String)getText(R.string.food_male_plan_not_net);
                 String food_male_plan_not_net_ok = (String)getText(R.string.food_male_plan_not_net_ok);
                 String food_male_plan_not_net_text_1 = (String)getText(R.string.food_male_plan_not_net_text_1);
                 String food_male_plan_not_net_text_2 = (String)getText(R.string.food_male_plan_not_net_text_2);
                 String food_male_plan_not_net_text = food_male_plan_not_net_text_1 + System.getProperty("line.separator")
                 + "" + System.getProperty("line.separator") + food_male_plan_not_net_text_2 + "" + System.getProperty("line.separator") ;


                 new SweetAlertDialog( this , SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                 .setTitleText( food_male_plan_not_net )
                 .setContentText( food_male_plan_not_net_text )
                 .setConfirmText( food_male_plan_not_net_ok )
                 .setCustomImage( R.drawable.net_off )
                 .showCancelButton( false )
                 .setConfirmClickListener( null )
                 .show();


                 }**/


                Intent sb = new Intent(sport.this, sport_start.class);
                sb.putExtra("sport_v_number_day", 1);
                sb.putExtra("sport_v_number_day_set_1", 1);
                sb.putExtra("sport_v_volume1", 1);
                sb.putExtra("sport_v_por", 1);
                startActivity(sb);

                sport.this.finish();


                break;

            case R.id.btn_1_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("111"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("112"));
                }


                Intent s = new Intent(sport.this, sport_start.class);
                s.putExtra("sport_v_number_day", 1);
                s.putExtra("sport_v_number_day_set_1", 1);
                s.putExtra("sport_v_volume1", 1);
                s.putExtra("sport_v_por", 1);
                startActivity(s);

                sport.this.finish();


                break;

            case R.id.btn_2_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("113"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("114"));
                }


                Intent s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 2);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();


                break;

            case R.id.btn_2_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("115"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("116"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 2);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);

                sport.this.finish();


                break;


            case R.id.btn_3_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("117"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("118"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 3);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);

                sport.this.finish();

                break;

            case R.id.btn_3_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("119"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("120"));
                }

                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 3);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();
                break;


            case R.id.btn_4_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("121"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("122"));
                }

                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 4);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_4_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("123"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("124"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 4);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;


            case R.id.btn_5_sport:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("125"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("126"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 5);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_5_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("127"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("128"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 5);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;


            case R.id.btn_6_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("129"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("130"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 6);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_6_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("131"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("132"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 6);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);

                sport.this.finish();
                break;


            case R.id.btn_7_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("133"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("134"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 7);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_7_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("135"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("136"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 7);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_8_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("137"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("138"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 8);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_8_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("139"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 8);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;


            case R.id.btn_9_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("140"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("141"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 9);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_9_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("142"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("143"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 9);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;


            case R.id.btn_10_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("144"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("145"));
                }


                /**if (app_net.getInstance( this ).isOnline()) {


                 String food_male_plan_give_ads = (String) getText(R.string.food_male_plan_give_ads);
                 String food_male_plan_pls = (String) getText(R.string.food_male_plan_pls);

                 final SweetAlertDialog sd = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                 sd.setTitleText(food_male_plan_give_ads);
                 sd.setContentText(food_male_plan_pls);
                 sd.showCancelButton(false);
                 sd.show();


                 AdColony.addAdAvailabilityListener(new AdColonyAdAvailabilityListener() {
                @Override public void onAdColonyAdAvailabilityChange(final boolean b, String s) {

                runOnUiThread( new Runnable() {
                @Override public void run() {
                if (b) {

                ad1.show();

                } else {
                }
                }
                } );

                }
                });

                 new Handler().postDelayed(new Thread() {
                @Override public void run() {
                super.run();

                String food_male_plan_not_net_ok = (String)getText(R.string.food_male_plan_not_net_ok);
                String food_male_plan_stop_time_1 = (String)getText(R.string.food_male_plan_stop_time_1);
                String food_male_plan_stop_time_2 = (String)getText(R.string.food_male_plan_stop_time_2);

                new SweetAlertDialog( sport.this , SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText( food_male_plan_stop_time_1 )
                .setContentText( food_male_plan_stop_time_2 )
                .setConfirmText( food_male_plan_not_net_ok )
                .setCustomImage( R.drawable.net_off )
                .showCancelButton( false )
                .setConfirmClickListener( null )
                .show();

                }
                }, 60000);

                 }else {


                 String food_male_plan_not_net = (String) getText(R.string.food_male_plan_not_net);
                 String food_male_plan_not_net_ok = (String) getText(R.string.food_male_plan_not_net_ok);
                 String food_male_plan_not_net_text_1 = (String) getText(R.string.food_male_plan_not_net_text_1);
                 String food_male_plan_not_net_text_2 = (String) getText(R.string.food_male_plan_not_net_text_2);
                 String food_male_plan_not_net_text = food_male_plan_not_net_text_1 + System.getProperty("line.separator")
                 + "" + System.getProperty("line.separator") + food_male_plan_not_net_text_2;


                 new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                 .setTitleText(food_male_plan_not_net)
                 .setContentText(food_male_plan_not_net_text)
                 .setConfirmText(food_male_plan_not_net_ok)
                 .setCustomImage(R.drawable.net_off)
                 .showCancelButton(false)
                 .setConfirmClickListener(null)
                 .show();

                 }**/


                Intent sw = new Intent(sport.this, sport_start.class);
                sw.putExtra("sport_v_number_day", 10);
                sw.putExtra("sport_v_number_day_set_1", 1);
                sw.putExtra("sport_v_volume1", 1);
                sw.putExtra("sport_v_por", 1);
                startActivity(sw);

                sport.this.finish();


                break;

            case R.id.btn_10_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("146"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("147"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 10);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();


                break;

            case R.id.btn_11_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("148"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("149"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 11);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_11_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("150"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("151"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 11);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_12_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("152"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("153"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 12);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_12_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("154"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("155"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 12);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();
                break;

            case R.id.btn_13_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("156"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("157"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 13);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_13_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("158"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("159"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 13);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();


                break;

            case R.id.btn_14_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("160"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("161"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 14);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_14_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("162"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("163"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 14);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);

                sport.this.finish();
                break;

            case R.id.btn_15_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("164"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("165"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 15);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_15_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("166"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("167"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 15);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);

                sport.this.finish();
                break;

            case R.id.btn_16_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("168"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("169"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 16);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_16_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("170"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("171"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 16);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_17_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("172"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("173"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 17);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_17_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("174"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("175"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 17);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_18_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("176"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("177"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 18);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_18_sport_star:


                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("178"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("179"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 18);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_19_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("180"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("181"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 19);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_19_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("182"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("183"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 19);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();


                break;


            case R.id.btn_20_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("184"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("185"));
                }

                /**if (app_net.getInstance( this ).isOnline()) {


                 String food_male_plan_give_ads = (String) getText(R.string.food_male_plan_give_ads);
                 String food_male_plan_pls = (String) getText(R.string.food_male_plan_pls);

                 final SweetAlertDialog sd = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                 sd.setTitleText(food_male_plan_give_ads);
                 sd.setContentText(food_male_plan_pls);
                 sd.showCancelButton(false);
                 sd.show();


                 AdColony.addAdAvailabilityListener(new AdColonyAdAvailabilityListener() {
                @Override public void onAdColonyAdAvailabilityChange(final boolean b, String s) {

                runOnUiThread( new Runnable() {
                @Override public void run() {
                if (b) {

                ad2.show();

                } else {
                }
                }
                } );

                }
                });


                 new Handler().postDelayed(new Thread() {
                @Override public void run() {
                super.run();

                String food_male_plan_not_net_ok = (String)getText(R.string.food_male_plan_not_net_ok);
                String food_male_plan_stop_time_1 = (String)getText(R.string.food_male_plan_stop_time_1);
                String food_male_plan_stop_time_2 = (String)getText(R.string.food_male_plan_stop_time_2);

                new SweetAlertDialog( sport.this , SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText( food_male_plan_stop_time_1 )
                .setContentText( food_male_plan_stop_time_2 )
                .setConfirmText( food_male_plan_not_net_ok )
                .setCustomImage( R.drawable.net_off )
                .showCancelButton( false )
                .setConfirmClickListener( null )
                .show();

                }
                }, 60000);

                 }else {


                 String food_male_plan_not_net = (String) getText(R.string.food_male_plan_not_net);
                 String food_male_plan_not_net_ok = (String) getText(R.string.food_male_plan_not_net_ok);
                 String food_male_plan_not_net_text_1 = (String) getText(R.string.food_male_plan_not_net_text_1);
                 String food_male_plan_not_net_text_2 = (String) getText(R.string.food_male_plan_not_net_text_2);
                 String food_male_plan_not_net_text = food_male_plan_not_net_text_1 + System.getProperty("line.separator")
                 + "" + System.getProperty("line.separator") + food_male_plan_not_net_text_2;


                 new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                 .setTitleText(food_male_plan_not_net)
                 .setContentText(food_male_plan_not_net_text)
                 .setConfirmText(food_male_plan_not_net_ok)
                 .setCustomImage(R.drawable.net_off)
                 .showCancelButton(false)
                 .setConfirmClickListener(null)
                 .show();

                 }**/


                Intent se = new Intent(sport.this, sport_start.class);
                se.putExtra("sport_v_number_day", 20);
                se.putExtra("sport_v_number_day_set_1", 1);
                se.putExtra("sport_v_volume1", 1);
                se.putExtra("sport_v_por", 1);
                startActivity(se);

                sport.this.finish();


                break;

            case R.id.btn_20_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("186"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("187"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 20);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_21_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("188"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("189"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 21);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_21_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("190"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("191"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 21);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_22_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("192"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("193"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 22);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_22_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("194"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("195"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 22);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_23_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("196"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("197"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 23);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_23_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("198"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("199"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 23);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_24_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("200"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("201"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 24);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_24_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("202"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("203"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 24);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_25_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("204"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("205"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 25);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();


                break;

            case R.id.btn_25_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("206"));
                }
                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("207"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 25);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_26_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("208"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("209"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 26);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_26_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("210"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("211"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 26);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_27_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("212"));
                }
                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("213"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 27);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_27_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("214"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("215"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 27);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_28_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("216"));
                }
                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("217"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 28);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_28_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("218"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("219"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 28);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_29_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("220"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("221"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 29);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_29_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("222"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("223"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 29);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_30_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("224"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("225"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 30);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.btn_30_sport_star:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("226"));
                }

                try {

                    click = MediaPlayer.create(sport.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("227"));
                }


                s2 = new Intent(sport.this, sport_start.class);
                s2.putExtra("sport_v_number_day", 30);
                s2.putExtra("sport_v_number_day_set_1", 1);
                s2.putExtra("sport_v_volume1", 1);
                s2.putExtra("sport_v_por", 1);
                startActivity(s2);


                sport.this.finish();

                break;

            case R.id.com_son_sport:

                final Intent sport_me = new Intent(this, Sport_me_start.class);

                try {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            startActivity(sport_me);
                            finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("228"));

                    Toast.makeText(this, "متاسفانه حافظه رم بیش از حد پر است . حافظه را خالی کنید و دباره تلاش کنید", Toast.LENGTH_LONG).show();

                }


                break;


        }
        FirebaseCrash.log("log 5");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(sport.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            try {

                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (vibre_check == music_off_check) {
                    vb.cancel();
                } else {
                    vb.vibrate(100);
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("229"));
            }

            try {
                click = MediaPlayer.create(sport.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("230"));
            }


            if (sport_page == 2) {
                try {
                    Intent ssss = new Intent(sport.this, Page_2.class);
                    startActivity(ssss);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("231"));
                }

            } else if (sport_page == 4) {
                try {
                    Intent ssss = new Intent(sport.this, food.class);
                    ssss.putExtra("zaban_fo", zaban);
                    startActivity(ssss);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("232"));
                }

            } else {

            }

            try {
                this.overridePendingTransition(R.anim.out,
                        R.anim.in);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("233"));
            }

            finish();
            FirebaseCrash.log("log 3");
        }
        return false;
    }


    @Override
    public void onStart() {
        super.onStart();

        App.activity_sport_start = this;
        FirebaseCrash.log("log 2");
        System.gc();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        App.activity_sport_start = null;
        FirebaseCrash.log("log 1");
        System.gc();
    }


}
