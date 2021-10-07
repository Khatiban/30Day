package com.android.fury.a30day.sport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Database.MyDatabaseHelper_voice;
import com.android.fury.a30day.R;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by fury on 9/26/2016.
 */
public class sport_relax extends Activity {

    private final int _splashTime = 1000;
    private final int _splashTime30 = 30000;

    ImageView im_sport_rl_1, im_sport_rl_2, im_sport_rl_3, im_sport_rl_4, im_sport_rl_5, im_sport_rl_6, im_sport_rl_7, im_sport_rl_8, im_sport_rl_9;


    LinearLayout im_sport_rl_30, im_sport_rl_10, im_sport_rl_11, im_sport_rl_12, im_sport_rl_13, im_sport_rl_14, im_sport_rl_15, im_sport_rl_16, im_sport_rl_17, im_sport_rl_18, im_sport_rl_19, im_sport_rl_20, im_sport_rl_21, im_sport_rl_22, im_sport_rl_23, im_sport_rl_24, im_sport_rl_25, im_sport_rl_26, im_sport_rl_27, im_sport_rl_28, im_sport_rl_29;

    RelativeLayout im_sport_rel_30, im_sport_rel_10, im_sport_rel_11, im_sport_rel_12, im_sport_rel_13, im_sport_rel_14, im_sport_rel_15, im_sport_rel_16, im_sport_rel_17, im_sport_rel_18, im_sport_rel_19, im_sport_rel_20, im_sport_rel_21, im_sport_rel_22, im_sport_rel_23, im_sport_rel_24, im_sport_rel_25, im_sport_rel_26, im_sport_rel_27, im_sport_rel_28, im_sport_rel_29;


    String music_check, fa, language, music_off_check, vibre_check, voice_check_1, voice_off_check_1;


    SharedPreferences sport_namber;

    SharedPreferences.Editor nameEditor_sport_namber;

    int sport_page, sport_page_set, set, sport_volume, sport_v_por, por;

    MediaPlayer click, music_get_ready, music_one, music_two, music_three;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;
    MyDatabaseHelper_voice voice_data;

    final Handler handler = new Handler();
    Thread thread;


    //final private ual unityadlisner = new ual();

    MyDatabaseHelper_lan language1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            //start zaban
            language1 = new MyDatabaseHelper_lan(this);
            Cursor r_lan = language1.showAllData();
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

                language = "fa";

            } else if (dadeha.toString().length() == 2) {
                //english.usa.canada

                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                language = "en";

            } else if (dadeha.toString().length() == 3) {
                //chine

                Locale locale = new Locale("zh");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                language = "zh";

            } else if (dadeha.toString().length() == 6) {
                //german

                Locale locale = new Locale("de");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                language = "de";

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }


        //start activ
        setContentView(R.layout.relax);

        try {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        try {

            //save voice
            voice_data = new MyDatabaseHelper_voice(this);
            Cursor res1 = voice_data.showAllData();
            StringBuffer data1 = new StringBuffer();
            while (res1.moveToNext()) {
                data1.append(res1.getString(1));
            }
            if (data1.toString().length() == 4) {
                voice_check_1 = "true";
            } else if (data1.toString().length() == 5) {
                voice_check_1 = "false";
            } else {
                voice_check_1 = "true";
            }
            voice_off_check_1 = "false";

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }


        fa = "fa";
        final String en = "en";
        final String de = "de";


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


        TextView sport_rielax_txt_3 = (TextView) findViewById(R.id.sport_rielax_txt_3);


        if (app_net.getInstance(this).isOnline()) {
            try {

                sport_rielax_txt_3.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }


        } else {
            try {

                sport_rielax_txt_3.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }


        }


        Bundle sport_relax = getIntent().getExtras();

        try {

            sport_namber = PreferenceManager.getDefaultSharedPreferences(this);
            nameEditor_sport_namber = sport_namber.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("8"));
        }


        im_sport_rl_1 = (ImageView) findViewById(R.id.im_sport_rl_1);
        im_sport_rl_2 = (ImageView) findViewById(R.id.im_sport_rl_2);
        im_sport_rl_3 = (ImageView) findViewById(R.id.im_sport_rl_3);
        im_sport_rl_4 = (ImageView) findViewById(R.id.im_sport_rl_4);
        im_sport_rl_5 = (ImageView) findViewById(R.id.im_sport_rl_5);
        im_sport_rl_6 = (ImageView) findViewById(R.id.im_sport_rl_6);
        im_sport_rl_7 = (ImageView) findViewById(R.id.im_sport_rl_7);
        im_sport_rl_8 = (ImageView) findViewById(R.id.im_sport_rl_8);
        im_sport_rl_9 = (ImageView) findViewById(R.id.im_sport_rl_9);

        if (language == fa) {

            im_sport_rel_30 = (RelativeLayout) findViewById(R.id.im_sport_rl_30);
            im_sport_rel_10 = (RelativeLayout) findViewById(R.id.im_sport_rl_10);
            im_sport_rel_11 = (RelativeLayout) findViewById(R.id.im_sport_rl_11);
            im_sport_rel_12 = (RelativeLayout) findViewById(R.id.im_sport_rl_12);
            im_sport_rel_13 = (RelativeLayout) findViewById(R.id.im_sport_rl_13);
            im_sport_rel_14 = (RelativeLayout) findViewById(R.id.im_sport_rl_14);
            im_sport_rel_15 = (RelativeLayout) findViewById(R.id.im_sport_rl_15);
            im_sport_rel_16 = (RelativeLayout) findViewById(R.id.im_sport_rl_16);
            im_sport_rel_17 = (RelativeLayout) findViewById(R.id.im_sport_rl_17);
            im_sport_rel_18 = (RelativeLayout) findViewById(R.id.im_sport_rl_18);
            im_sport_rel_19 = (RelativeLayout) findViewById(R.id.im_sport_rl_19);
            im_sport_rel_20 = (RelativeLayout) findViewById(R.id.im_sport_rl_20);
            im_sport_rel_21 = (RelativeLayout) findViewById(R.id.im_sport_rl_21);
            im_sport_rel_22 = (RelativeLayout) findViewById(R.id.im_sport_rl_22);
            im_sport_rel_23 = (RelativeLayout) findViewById(R.id.im_sport_rl_23);
            im_sport_rel_24 = (RelativeLayout) findViewById(R.id.im_sport_rl_24);
            im_sport_rel_25 = (RelativeLayout) findViewById(R.id.im_sport_rl_25);
            im_sport_rel_26 = (RelativeLayout) findViewById(R.id.im_sport_rl_26);
            im_sport_rel_27 = (RelativeLayout) findViewById(R.id.im_sport_rl_27);
            im_sport_rel_28 = (RelativeLayout) findViewById(R.id.im_sport_rl_28);
            im_sport_rel_29 = (RelativeLayout) findViewById(R.id.im_sport_rl_29);

        } else {

            im_sport_rl_30 = (LinearLayout) findViewById(R.id.im_sport_rl_30);
            im_sport_rl_10 = (LinearLayout) findViewById(R.id.im_sport_rl_10);
            im_sport_rl_11 = (LinearLayout) findViewById(R.id.im_sport_rl_11);
            im_sport_rl_12 = (LinearLayout) findViewById(R.id.im_sport_rl_12);
            im_sport_rl_13 = (LinearLayout) findViewById(R.id.im_sport_rl_13);
            im_sport_rl_14 = (LinearLayout) findViewById(R.id.im_sport_rl_14);
            im_sport_rl_15 = (LinearLayout) findViewById(R.id.im_sport_rl_15);
            im_sport_rl_16 = (LinearLayout) findViewById(R.id.im_sport_rl_16);
            im_sport_rl_17 = (LinearLayout) findViewById(R.id.im_sport_rl_17);
            im_sport_rl_18 = (LinearLayout) findViewById(R.id.im_sport_rl_18);
            im_sport_rl_19 = (LinearLayout) findViewById(R.id.im_sport_rl_19);
            im_sport_rl_20 = (LinearLayout) findViewById(R.id.im_sport_rl_20);
            im_sport_rl_21 = (LinearLayout) findViewById(R.id.im_sport_rl_21);
            im_sport_rl_22 = (LinearLayout) findViewById(R.id.im_sport_rl_22);
            im_sport_rl_23 = (LinearLayout) findViewById(R.id.im_sport_rl_23);
            im_sport_rl_24 = (LinearLayout) findViewById(R.id.im_sport_rl_24);
            im_sport_rl_25 = (LinearLayout) findViewById(R.id.im_sport_rl_25);
            im_sport_rl_26 = (LinearLayout) findViewById(R.id.im_sport_rl_26);
            im_sport_rl_27 = (LinearLayout) findViewById(R.id.im_sport_rl_27);
            im_sport_rl_28 = (LinearLayout) findViewById(R.id.im_sport_rl_28);
            im_sport_rl_29 = (LinearLayout) findViewById(R.id.im_sport_rl_29);

        }

        FirebaseCrash.log("log 6");

        if (app_net.getInstance(this).isOnline()) {

            //if (UnityAds.canShow()){
            //    UnityAds.show();
            //}else {
            //    UnityAds.init(this , "1152759" , unityadlisner);
            //}
            try {

                im_sport_rl_1.setVisibility(View.INVISIBLE);
                im_sport_rl_2.setVisibility(View.INVISIBLE);
                im_sport_rl_3.setVisibility(View.INVISIBLE);
                im_sport_rl_4.setVisibility(View.INVISIBLE);
                im_sport_rl_5.setVisibility(View.INVISIBLE);
                im_sport_rl_6.setVisibility(View.INVISIBLE);
                im_sport_rl_7.setVisibility(View.INVISIBLE);
                im_sport_rl_8.setVisibility(View.INVISIBLE);
                im_sport_rl_9.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("9"));
            }


            if (language == fa) {

                try {

                    im_sport_rel_10.setVisibility(View.INVISIBLE);
                    im_sport_rel_11.setVisibility(View.INVISIBLE);
                    im_sport_rel_12.setVisibility(View.INVISIBLE);
                    im_sport_rel_13.setVisibility(View.INVISIBLE);
                    im_sport_rel_14.setVisibility(View.INVISIBLE);
                    im_sport_rel_15.setVisibility(View.INVISIBLE);
                    im_sport_rel_16.setVisibility(View.INVISIBLE);
                    im_sport_rel_17.setVisibility(View.INVISIBLE);
                    im_sport_rel_18.setVisibility(View.INVISIBLE);
                    im_sport_rel_19.setVisibility(View.INVISIBLE);
                    im_sport_rel_20.setVisibility(View.INVISIBLE);
                    im_sport_rel_21.setVisibility(View.INVISIBLE);
                    im_sport_rel_22.setVisibility(View.INVISIBLE);
                    im_sport_rel_23.setVisibility(View.INVISIBLE);
                    im_sport_rel_24.setVisibility(View.INVISIBLE);
                    im_sport_rel_25.setVisibility(View.INVISIBLE);
                    im_sport_rel_26.setVisibility(View.INVISIBLE);
                    im_sport_rel_27.setVisibility(View.INVISIBLE);
                    im_sport_rel_28.setVisibility(View.INVISIBLE);
                    im_sport_rel_29.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("10"));
                }


            } else {
                try {

                    im_sport_rl_10.setVisibility(View.INVISIBLE);
                    im_sport_rl_11.setVisibility(View.INVISIBLE);
                    im_sport_rl_12.setVisibility(View.INVISIBLE);
                    im_sport_rl_13.setVisibility(View.INVISIBLE);
                    im_sport_rl_14.setVisibility(View.INVISIBLE);
                    im_sport_rl_15.setVisibility(View.INVISIBLE);
                    im_sport_rl_16.setVisibility(View.INVISIBLE);
                    im_sport_rl_17.setVisibility(View.INVISIBLE);
                    im_sport_rl_18.setVisibility(View.INVISIBLE);
                    im_sport_rl_19.setVisibility(View.INVISIBLE);
                    im_sport_rl_20.setVisibility(View.INVISIBLE);
                    im_sport_rl_21.setVisibility(View.INVISIBLE);
                    im_sport_rl_22.setVisibility(View.INVISIBLE);
                    im_sport_rl_23.setVisibility(View.INVISIBLE);
                    im_sport_rl_24.setVisibility(View.INVISIBLE);
                    im_sport_rl_25.setVisibility(View.INVISIBLE);
                    im_sport_rl_26.setVisibility(View.INVISIBLE);
                    im_sport_rl_27.setVisibility(View.INVISIBLE);
                    im_sport_rl_28.setVisibility(View.INVISIBLE);
                    im_sport_rl_29.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }


            }


            try {


                new Handler().postDelayed(new Thread() {

                    @Override
                    public void run() {
                        super.run();

                        if (language == fa) {

                            im_sport_rel_29.setVisibility(View.VISIBLE);

                            im_sport_rel_30.setVisibility(View.INVISIBLE);

                        } else {

                            im_sport_rl_29.setVisibility(View.VISIBLE);

                            im_sport_rl_30.setVisibility(View.INVISIBLE);

                        }


                        new Handler().postDelayed(new Thread() {

                            @Override
                            public void run() {
                                super.run();

                                if (language == fa) {

                                    im_sport_rel_29.setVisibility(View.INVISIBLE);

                                    im_sport_rel_28.setVisibility(View.VISIBLE);

                                } else {

                                    im_sport_rl_29.setVisibility(View.INVISIBLE);

                                    im_sport_rl_28.setVisibility(View.VISIBLE);

                                }


                                new Handler().postDelayed(new Thread() {

                                    @Override
                                    public void run() {
                                        super.run();

                                        if (language == fa) {

                                            im_sport_rel_28.setVisibility(View.INVISIBLE);

                                            im_sport_rel_27.setVisibility(View.VISIBLE);

                                        } else {

                                            im_sport_rl_28.setVisibility(View.INVISIBLE);

                                            im_sport_rl_27.setVisibility(View.VISIBLE);

                                        }


                                        new Handler().postDelayed(new Thread() {

                                            @Override
                                            public void run() {
                                                super.run();

                                                if (language == fa) {

                                                    im_sport_rel_27.setVisibility(View.INVISIBLE);

                                                    im_sport_rel_26.setVisibility(View.VISIBLE);

                                                } else {

                                                    im_sport_rl_27.setVisibility(View.INVISIBLE);

                                                    im_sport_rl_26.setVisibility(View.VISIBLE);

                                                }


                                                new Handler().postDelayed(new Thread() {

                                                    @Override
                                                    public void run() {
                                                        super.run();

                                                        if (language == fa) {

                                                            im_sport_rel_26.setVisibility(View.INVISIBLE);

                                                            im_sport_rel_25.setVisibility(View.VISIBLE);

                                                        } else {

                                                            im_sport_rl_26.setVisibility(View.INVISIBLE);

                                                            im_sport_rl_25.setVisibility(View.VISIBLE);

                                                        }


                                                        new Handler().postDelayed(new Thread() {

                                                            @Override
                                                            public void run() {
                                                                super.run();

                                                                if (language == fa) {

                                                                    im_sport_rel_25.setVisibility(View.INVISIBLE);

                                                                    im_sport_rel_24.setVisibility(View.VISIBLE);

                                                                } else {

                                                                    im_sport_rl_25.setVisibility(View.INVISIBLE);

                                                                    im_sport_rl_24.setVisibility(View.VISIBLE);

                                                                }


                                                                new Handler().postDelayed(new Thread() {

                                                                    @Override
                                                                    public void run() {
                                                                        super.run();

                                                                        if (language == fa) {

                                                                            im_sport_rel_24.setVisibility(View.INVISIBLE);

                                                                            im_sport_rel_23.setVisibility(View.VISIBLE);

                                                                        } else {

                                                                            im_sport_rl_24.setVisibility(View.INVISIBLE);

                                                                            im_sport_rl_23.setVisibility(View.VISIBLE);

                                                                        }


                                                                        new Handler().postDelayed(new Thread() {

                                                                            @Override
                                                                            public void run() {
                                                                                super.run();


                                                                                if (language == fa) {

                                                                                    im_sport_rel_23.setVisibility(View.INVISIBLE);

                                                                                    im_sport_rel_22.setVisibility(View.VISIBLE);

                                                                                } else {

                                                                                    im_sport_rl_23.setVisibility(View.INVISIBLE);

                                                                                    im_sport_rl_22.setVisibility(View.VISIBLE);

                                                                                }


                                                                                new Handler().postDelayed(new Thread() {

                                                                                    @Override
                                                                                    public void run() {
                                                                                        super.run();

                                                                                        if (language == fa) {

                                                                                            im_sport_rel_22.setVisibility(View.INVISIBLE);

                                                                                            im_sport_rel_21.setVisibility(View.VISIBLE);

                                                                                        } else {

                                                                                            im_sport_rl_22.setVisibility(View.INVISIBLE);

                                                                                            im_sport_rl_21.setVisibility(View.VISIBLE);

                                                                                        }


                                                                                        new Handler().postDelayed(new Thread() {

                                                                                            @Override
                                                                                            public void run() {
                                                                                                super.run();

                                                                                                if (language == fa) {

                                                                                                    im_sport_rel_21.setVisibility(View.INVISIBLE);

                                                                                                    im_sport_rel_20.setVisibility(View.VISIBLE);

                                                                                                } else {

                                                                                                    im_sport_rl_21.setVisibility(View.INVISIBLE);

                                                                                                    im_sport_rl_20.setVisibility(View.VISIBLE);

                                                                                                }


                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                    @Override
                                                                                                    public void run() {
                                                                                                        super.run();

                                                                                                        if (language == fa) {

                                                                                                            im_sport_rel_20.setVisibility(View.INVISIBLE);

                                                                                                            im_sport_rel_19.setVisibility(View.VISIBLE);

                                                                                                        } else {

                                                                                                            im_sport_rl_20.setVisibility(View.INVISIBLE);

                                                                                                            im_sport_rl_19.setVisibility(View.VISIBLE);

                                                                                                        }


                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                            @Override
                                                                                                            public void run() {
                                                                                                                super.run();

                                                                                                                if (language == fa) {

                                                                                                                    im_sport_rel_19.setVisibility(View.INVISIBLE);

                                                                                                                    im_sport_rel_18.setVisibility(View.VISIBLE);

                                                                                                                } else {

                                                                                                                    im_sport_rl_19.setVisibility(View.INVISIBLE);

                                                                                                                    im_sport_rl_18.setVisibility(View.VISIBLE);

                                                                                                                }


                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                    @Override
                                                                                                                    public void run() {
                                                                                                                        super.run();

                                                                                                                        if (language == fa) {

                                                                                                                            im_sport_rel_18.setVisibility(View.INVISIBLE);

                                                                                                                            im_sport_rel_17.setVisibility(View.VISIBLE);

                                                                                                                        } else {

                                                                                                                            im_sport_rl_18.setVisibility(View.INVISIBLE);

                                                                                                                            im_sport_rl_17.setVisibility(View.VISIBLE);

                                                                                                                        }


                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                            @Override
                                                                                                                            public void run() {
                                                                                                                                super.run();

                                                                                                                                if (language == fa) {

                                                                                                                                    im_sport_rel_17.setVisibility(View.INVISIBLE);

                                                                                                                                    im_sport_rel_16.setVisibility(View.VISIBLE);

                                                                                                                                } else {

                                                                                                                                    im_sport_rl_17.setVisibility(View.INVISIBLE);

                                                                                                                                    im_sport_rl_16.setVisibility(View.VISIBLE);

                                                                                                                                }


                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                    @Override
                                                                                                                                    public void run() {
                                                                                                                                        super.run();

                                                                                                                                        if (language == fa) {

                                                                                                                                            im_sport_rel_16.setVisibility(View.INVISIBLE);

                                                                                                                                            im_sport_rel_15.setVisibility(View.VISIBLE);

                                                                                                                                        } else {

                                                                                                                                            im_sport_rl_16.setVisibility(View.INVISIBLE);

                                                                                                                                            im_sport_rl_15.setVisibility(View.VISIBLE);

                                                                                                                                        }


                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                            @Override
                                                                                                                                            public void run() {
                                                                                                                                                super.run();

                                                                                                                                                if (language == fa) {

                                                                                                                                                    im_sport_rel_15.setVisibility(View.INVISIBLE);

                                                                                                                                                    im_sport_rel_14.setVisibility(View.VISIBLE);

                                                                                                                                                } else {

                                                                                                                                                    im_sport_rl_15.setVisibility(View.INVISIBLE);

                                                                                                                                                    im_sport_rl_14.setVisibility(View.VISIBLE);

                                                                                                                                                }


                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                    @Override
                                                                                                                                                    public void run() {
                                                                                                                                                        super.run();

                                                                                                                                                        if (language == fa) {

                                                                                                                                                            im_sport_rel_14.setVisibility(View.INVISIBLE);

                                                                                                                                                            im_sport_rel_13.setVisibility(View.VISIBLE);

                                                                                                                                                        } else {

                                                                                                                                                            im_sport_rl_14.setVisibility(View.INVISIBLE);

                                                                                                                                                            im_sport_rl_13.setVisibility(View.VISIBLE);

                                                                                                                                                        }


                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                            @Override
                                                                                                                                                            public void run() {
                                                                                                                                                                super.run();

                                                                                                                                                                if (language == fa) {

                                                                                                                                                                    im_sport_rel_13.setVisibility(View.INVISIBLE);

                                                                                                                                                                    im_sport_rel_12.setVisibility(View.VISIBLE);

                                                                                                                                                                } else {

                                                                                                                                                                    im_sport_rl_13.setVisibility(View.INVISIBLE);

                                                                                                                                                                    im_sport_rl_12.setVisibility(View.VISIBLE);

                                                                                                                                                                }


                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                    @Override
                                                                                                                                                                    public void run() {
                                                                                                                                                                        super.run();

                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                            im_sport_rel_12.setVisibility(View.INVISIBLE);

                                                                                                                                                                            im_sport_rel_11.setVisibility(View.VISIBLE);

                                                                                                                                                                        } else {

                                                                                                                                                                            im_sport_rl_12.setVisibility(View.INVISIBLE);

                                                                                                                                                                            im_sport_rl_11.setVisibility(View.VISIBLE);

                                                                                                                                                                        }


                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                            @Override
                                                                                                                                                                            public void run() {
                                                                                                                                                                                super.run();

                                                                                                                                                                                if (language == fa) {

                                                                                                                                                                                    im_sport_rel_11.setVisibility(View.INVISIBLE);

                                                                                                                                                                                    im_sport_rel_10.setVisibility(View.VISIBLE);

                                                                                                                                                                                } else {

                                                                                                                                                                                    im_sport_rl_11.setVisibility(View.INVISIBLE);

                                                                                                                                                                                    im_sport_rl_10.setVisibility(View.VISIBLE);

                                                                                                                                                                                }


                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void run() {
                                                                                                                                                                                        super.run();

                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                            im_sport_rel_10.setVisibility(View.INVISIBLE);

                                                                                                                                                                                            im_sport_rl_9.setVisibility(View.VISIBLE);

                                                                                                                                                                                        } else {

                                                                                                                                                                                            im_sport_rl_10.setVisibility(View.INVISIBLE);

                                                                                                                                                                                            im_sport_rl_9.setVisibility(View.VISIBLE);

                                                                                                                                                                                        }


                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                            @Override
                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                super.run();

                                                                                                                                                                                                im_sport_rl_9.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                im_sport_rl_8.setVisibility(View.VISIBLE);

                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                        super.run();

                                                                                                                                                                                                        im_sport_rl_8.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                        im_sport_rl_7.setVisibility(View.VISIBLE);

                                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                                super.run();

                                                                                                                                                                                                                im_sport_rl_7.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                im_sport_rl_6.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                                        super.run();


                                                                                                                                                                                                                        im_sport_rl_6.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                        im_sport_rl_5.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_fa);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        } else if (language == en) {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_en);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        } else if (language == de) {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_de);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        } else {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_en);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        }

                                                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                                                super.run();

                                                                                                                                                                                                                                im_sport_rl_5.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                im_sport_rl_4.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                                                        super.run();

                                                                                                                                                                                                                                        im_sport_rl_4.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                        im_sport_rl_1.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.fa_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        } else if (language == en) {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.en_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        } else if (language == de) {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.de_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        } else {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.en_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                                                                super.run();

                                                                                                                                                                                                                                                im_sport_rl_1.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                                im_sport_rl_3.setVisibility(View.VISIBLE);
                                                                                                                                                                                                                                                if (language == fa) {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.fa_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                } else if (language == en) {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.en_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                } else if (language == de) {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.de_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                } else {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.en_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                                                                        super.run();

                                                                                                                                                                                                                                                        im_sport_rl_3.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                                        im_sport_rl_2.setVisibility(View.VISIBLE);


                                                                                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.fa_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        } else if (language == en) {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.en_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        } else if (language == de) {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.de_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        } else {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.en_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        }


                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }, _splashTime);

                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }, _splashTime);

                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }, _splashTime);

                                                                                                                                                                                                            }
                                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                                    }
                                                                                                                                                                                                }, _splashTime);


                                                                                                                                                                                            }
                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                    }
                                                                                                                                                                                }, _splashTime);


                                                                                                                                                                            }
                                                                                                                                                                        }, _splashTime);


                                                                                                                                                                    }
                                                                                                                                                                }, _splashTime);


                                                                                                                                                            }
                                                                                                                                                        }, _splashTime);

                                                                                                                                                    }
                                                                                                                                                }, _splashTime);

                                                                                                                                            }
                                                                                                                                        }, _splashTime);

                                                                                                                                    }
                                                                                                                                }, _splashTime);

                                                                                                                            }
                                                                                                                        }, _splashTime);

                                                                                                                    }
                                                                                                                }, _splashTime);

                                                                                                            }
                                                                                                        }, _splashTime);

                                                                                                    }
                                                                                                }, _splashTime);

                                                                                            }
                                                                                        }, _splashTime);

                                                                                    }
                                                                                }, _splashTime);

                                                                            }
                                                                        }, _splashTime);

                                                                    }
                                                                }, _splashTime);

                                                            }
                                                        }, _splashTime);

                                                    }
                                                }, _splashTime);

                                            }
                                        }, _splashTime);

                                    }
                                }, _splashTime);

                            }
                        }, _splashTime);

                    }
                }, _splashTime);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
            }

        } else {

            try {

                im_sport_rl_1.setVisibility(View.INVISIBLE);
                im_sport_rl_2.setVisibility(View.INVISIBLE);
                im_sport_rl_3.setVisibility(View.INVISIBLE);
                im_sport_rl_4.setVisibility(View.INVISIBLE);
                im_sport_rl_5.setVisibility(View.INVISIBLE);
                im_sport_rl_6.setVisibility(View.INVISIBLE);
                im_sport_rl_7.setVisibility(View.INVISIBLE);
                im_sport_rl_8.setVisibility(View.INVISIBLE);
                im_sport_rl_9.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("13"));
            }


            if (language == fa) {

                try {

                    im_sport_rel_10.setVisibility(View.INVISIBLE);
                    im_sport_rel_11.setVisibility(View.INVISIBLE);
                    im_sport_rel_12.setVisibility(View.INVISIBLE);
                    im_sport_rel_13.setVisibility(View.INVISIBLE);
                    im_sport_rel_14.setVisibility(View.INVISIBLE);
                    im_sport_rel_15.setVisibility(View.INVISIBLE);
                    im_sport_rel_16.setVisibility(View.INVISIBLE);
                    im_sport_rel_17.setVisibility(View.INVISIBLE);
                    im_sport_rel_18.setVisibility(View.INVISIBLE);
                    im_sport_rel_19.setVisibility(View.INVISIBLE);
                    im_sport_rel_20.setVisibility(View.INVISIBLE);
                    im_sport_rel_21.setVisibility(View.INVISIBLE);
                    im_sport_rel_22.setVisibility(View.INVISIBLE);
                    im_sport_rel_23.setVisibility(View.INVISIBLE);
                    im_sport_rel_24.setVisibility(View.INVISIBLE);
                    im_sport_rel_25.setVisibility(View.INVISIBLE);
                    im_sport_rel_26.setVisibility(View.INVISIBLE);
                    im_sport_rel_27.setVisibility(View.INVISIBLE);
                    im_sport_rel_28.setVisibility(View.INVISIBLE);
                    im_sport_rel_29.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("14"));
                }


            } else {

                try {

                    im_sport_rl_10.setVisibility(View.INVISIBLE);
                    im_sport_rl_11.setVisibility(View.INVISIBLE);
                    im_sport_rl_12.setVisibility(View.INVISIBLE);
                    im_sport_rl_13.setVisibility(View.INVISIBLE);
                    im_sport_rl_14.setVisibility(View.INVISIBLE);
                    im_sport_rl_15.setVisibility(View.INVISIBLE);
                    im_sport_rl_16.setVisibility(View.INVISIBLE);
                    im_sport_rl_17.setVisibility(View.INVISIBLE);
                    im_sport_rl_18.setVisibility(View.INVISIBLE);
                    im_sport_rl_19.setVisibility(View.INVISIBLE);
                    im_sport_rl_20.setVisibility(View.INVISIBLE);
                    im_sport_rl_21.setVisibility(View.INVISIBLE);
                    im_sport_rl_22.setVisibility(View.INVISIBLE);
                    im_sport_rl_23.setVisibility(View.INVISIBLE);
                    im_sport_rl_24.setVisibility(View.INVISIBLE);
                    im_sport_rl_25.setVisibility(View.INVISIBLE);
                    im_sport_rl_26.setVisibility(View.INVISIBLE);
                    im_sport_rl_27.setVisibility(View.INVISIBLE);
                    im_sport_rl_28.setVisibility(View.INVISIBLE);
                    im_sport_rl_29.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }


            }


            try {


                new Handler().postDelayed(new Thread() {

                    @Override
                    public void run() {
                        super.run();

                        if (language == fa) {

                            im_sport_rel_29.setVisibility(View.VISIBLE);

                            im_sport_rel_30.setVisibility(View.INVISIBLE);

                        } else {

                            im_sport_rl_29.setVisibility(View.VISIBLE);

                            im_sport_rl_30.setVisibility(View.INVISIBLE);

                        }


                        new Handler().postDelayed(new Thread() {

                            @Override
                            public void run() {
                                super.run();

                                if (language == fa) {

                                    im_sport_rel_29.setVisibility(View.INVISIBLE);

                                    im_sport_rel_28.setVisibility(View.VISIBLE);

                                } else {

                                    im_sport_rl_29.setVisibility(View.INVISIBLE);

                                    im_sport_rl_28.setVisibility(View.VISIBLE);

                                }


                                new Handler().postDelayed(new Thread() {

                                    @Override
                                    public void run() {
                                        super.run();

                                        if (language == fa) {

                                            im_sport_rel_28.setVisibility(View.INVISIBLE);

                                            im_sport_rel_27.setVisibility(View.VISIBLE);

                                        } else {

                                            im_sport_rl_28.setVisibility(View.INVISIBLE);

                                            im_sport_rl_27.setVisibility(View.VISIBLE);

                                        }


                                        new Handler().postDelayed(new Thread() {

                                            @Override
                                            public void run() {
                                                super.run();

                                                if (language == fa) {

                                                    im_sport_rel_27.setVisibility(View.INVISIBLE);

                                                    im_sport_rel_26.setVisibility(View.VISIBLE);

                                                } else {

                                                    im_sport_rl_27.setVisibility(View.INVISIBLE);

                                                    im_sport_rl_26.setVisibility(View.VISIBLE);

                                                }


                                                new Handler().postDelayed(new Thread() {

                                                    @Override
                                                    public void run() {
                                                        super.run();

                                                        if (language == fa) {

                                                            im_sport_rel_26.setVisibility(View.INVISIBLE);

                                                            im_sport_rel_25.setVisibility(View.VISIBLE);

                                                        } else {

                                                            im_sport_rl_26.setVisibility(View.INVISIBLE);

                                                            im_sport_rl_25.setVisibility(View.VISIBLE);

                                                        }


                                                        new Handler().postDelayed(new Thread() {

                                                            @Override
                                                            public void run() {
                                                                super.run();

                                                                if (language == fa) {

                                                                    im_sport_rel_25.setVisibility(View.INVISIBLE);

                                                                    im_sport_rel_24.setVisibility(View.VISIBLE);

                                                                } else {

                                                                    im_sport_rl_25.setVisibility(View.INVISIBLE);

                                                                    im_sport_rl_24.setVisibility(View.VISIBLE);

                                                                }


                                                                new Handler().postDelayed(new Thread() {

                                                                    @Override
                                                                    public void run() {
                                                                        super.run();

                                                                        if (language == fa) {

                                                                            im_sport_rel_24.setVisibility(View.INVISIBLE);

                                                                            im_sport_rel_23.setVisibility(View.VISIBLE);

                                                                        } else {

                                                                            im_sport_rl_24.setVisibility(View.INVISIBLE);

                                                                            im_sport_rl_23.setVisibility(View.VISIBLE);

                                                                        }


                                                                        new Handler().postDelayed(new Thread() {

                                                                            @Override
                                                                            public void run() {
                                                                                super.run();


                                                                                if (language == fa) {

                                                                                    im_sport_rel_23.setVisibility(View.INVISIBLE);

                                                                                    im_sport_rel_22.setVisibility(View.VISIBLE);

                                                                                } else {

                                                                                    im_sport_rl_23.setVisibility(View.INVISIBLE);

                                                                                    im_sport_rl_22.setVisibility(View.VISIBLE);

                                                                                }


                                                                                new Handler().postDelayed(new Thread() {

                                                                                    @Override
                                                                                    public void run() {
                                                                                        super.run();


                                                                                        if (language == fa) {

                                                                                            im_sport_rel_22.setVisibility(View.INVISIBLE);

                                                                                            im_sport_rel_21.setVisibility(View.VISIBLE);

                                                                                        } else {

                                                                                            im_sport_rl_22.setVisibility(View.INVISIBLE);

                                                                                            im_sport_rl_21.setVisibility(View.VISIBLE);

                                                                                        }


                                                                                        new Handler().postDelayed(new Thread() {

                                                                                            @Override
                                                                                            public void run() {
                                                                                                super.run();

                                                                                                if (language == fa) {

                                                                                                    im_sport_rel_21.setVisibility(View.INVISIBLE);

                                                                                                    im_sport_rel_20.setVisibility(View.VISIBLE);

                                                                                                } else {

                                                                                                    im_sport_rl_21.setVisibility(View.INVISIBLE);

                                                                                                    im_sport_rl_20.setVisibility(View.VISIBLE);

                                                                                                }


                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                    @Override
                                                                                                    public void run() {
                                                                                                        super.run();

                                                                                                        if (language == fa) {

                                                                                                            im_sport_rel_20.setVisibility(View.INVISIBLE);

                                                                                                            im_sport_rel_19.setVisibility(View.VISIBLE);

                                                                                                        } else {

                                                                                                            im_sport_rl_20.setVisibility(View.INVISIBLE);

                                                                                                            im_sport_rl_19.setVisibility(View.VISIBLE);

                                                                                                        }


                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                            @Override
                                                                                                            public void run() {
                                                                                                                super.run();

                                                                                                                if (language == fa) {

                                                                                                                    im_sport_rel_19.setVisibility(View.INVISIBLE);

                                                                                                                    im_sport_rel_18.setVisibility(View.VISIBLE);

                                                                                                                } else {

                                                                                                                    im_sport_rl_19.setVisibility(View.INVISIBLE);

                                                                                                                    im_sport_rl_18.setVisibility(View.VISIBLE);

                                                                                                                }


                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                    @Override
                                                                                                                    public void run() {
                                                                                                                        super.run();


                                                                                                                        if (language == fa) {

                                                                                                                            im_sport_rel_18.setVisibility(View.INVISIBLE);

                                                                                                                            im_sport_rel_17.setVisibility(View.VISIBLE);

                                                                                                                        } else {

                                                                                                                            im_sport_rl_18.setVisibility(View.INVISIBLE);

                                                                                                                            im_sport_rl_17.setVisibility(View.VISIBLE);

                                                                                                                        }


                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                            @Override
                                                                                                                            public void run() {
                                                                                                                                super.run();

                                                                                                                                if (language == fa) {

                                                                                                                                    im_sport_rel_17.setVisibility(View.INVISIBLE);

                                                                                                                                    im_sport_rel_16.setVisibility(View.VISIBLE);

                                                                                                                                } else {

                                                                                                                                    im_sport_rl_17.setVisibility(View.INVISIBLE);

                                                                                                                                    im_sport_rl_16.setVisibility(View.VISIBLE);

                                                                                                                                }


                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                    @Override
                                                                                                                                    public void run() {
                                                                                                                                        super.run();

                                                                                                                                        if (language == fa) {

                                                                                                                                            im_sport_rel_16.setVisibility(View.INVISIBLE);

                                                                                                                                            im_sport_rel_15.setVisibility(View.VISIBLE);

                                                                                                                                        } else {

                                                                                                                                            im_sport_rl_16.setVisibility(View.INVISIBLE);

                                                                                                                                            im_sport_rl_15.setVisibility(View.VISIBLE);

                                                                                                                                        }


                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                            @Override
                                                                                                                                            public void run() {
                                                                                                                                                super.run();

                                                                                                                                                if (language == fa) {

                                                                                                                                                    im_sport_rel_15.setVisibility(View.INVISIBLE);

                                                                                                                                                    im_sport_rel_14.setVisibility(View.VISIBLE);

                                                                                                                                                } else {

                                                                                                                                                    im_sport_rl_15.setVisibility(View.INVISIBLE);

                                                                                                                                                    im_sport_rl_14.setVisibility(View.VISIBLE);

                                                                                                                                                }


                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                    @Override
                                                                                                                                                    public void run() {
                                                                                                                                                        super.run();

                                                                                                                                                        if (language == fa) {

                                                                                                                                                            im_sport_rel_14.setVisibility(View.INVISIBLE);

                                                                                                                                                            im_sport_rel_13.setVisibility(View.VISIBLE);

                                                                                                                                                        } else {

                                                                                                                                                            im_sport_rl_14.setVisibility(View.INVISIBLE);

                                                                                                                                                            im_sport_rl_13.setVisibility(View.VISIBLE);

                                                                                                                                                        }


                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                            @Override
                                                                                                                                                            public void run() {
                                                                                                                                                                super.run();

                                                                                                                                                                if (language == fa) {

                                                                                                                                                                    im_sport_rel_13.setVisibility(View.INVISIBLE);

                                                                                                                                                                    im_sport_rel_12.setVisibility(View.VISIBLE);

                                                                                                                                                                } else {

                                                                                                                                                                    im_sport_rl_13.setVisibility(View.INVISIBLE);

                                                                                                                                                                    im_sport_rl_12.setVisibility(View.VISIBLE);

                                                                                                                                                                }


                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                    @Override
                                                                                                                                                                    public void run() {
                                                                                                                                                                        super.run();

                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                            im_sport_rel_12.setVisibility(View.INVISIBLE);

                                                                                                                                                                            im_sport_rel_11.setVisibility(View.VISIBLE);

                                                                                                                                                                        } else {

                                                                                                                                                                            im_sport_rl_12.setVisibility(View.INVISIBLE);

                                                                                                                                                                            im_sport_rl_11.setVisibility(View.VISIBLE);

                                                                                                                                                                        }


                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                            @Override
                                                                                                                                                                            public void run() {
                                                                                                                                                                                super.run();

                                                                                                                                                                                if (language == fa) {

                                                                                                                                                                                    im_sport_rel_11.setVisibility(View.INVISIBLE);

                                                                                                                                                                                    im_sport_rel_10.setVisibility(View.VISIBLE);

                                                                                                                                                                                } else {

                                                                                                                                                                                    im_sport_rl_11.setVisibility(View.INVISIBLE);

                                                                                                                                                                                    im_sport_rl_10.setVisibility(View.VISIBLE);

                                                                                                                                                                                }


                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void run() {
                                                                                                                                                                                        super.run();

                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                            im_sport_rel_10.setVisibility(View.INVISIBLE);

                                                                                                                                                                                            im_sport_rl_9.setVisibility(View.VISIBLE);

                                                                                                                                                                                        } else {

                                                                                                                                                                                            im_sport_rl_10.setVisibility(View.INVISIBLE);

                                                                                                                                                                                            im_sport_rl_9.setVisibility(View.VISIBLE);

                                                                                                                                                                                        }


                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                            @Override
                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                super.run();

                                                                                                                                                                                                im_sport_rl_9.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                im_sport_rl_8.setVisibility(View.VISIBLE);

                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                        super.run();

                                                                                                                                                                                                        im_sport_rl_8.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                        im_sport_rl_7.setVisibility(View.VISIBLE);

                                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                                super.run();

                                                                                                                                                                                                                im_sport_rl_7.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                im_sport_rl_6.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                                        super.run();


                                                                                                                                                                                                                        im_sport_rl_6.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                        im_sport_rl_5.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_fa);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        } else if (language == en) {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_en);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        } else if (language == de) {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_de);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        } else {

                                                                                                                                                                                                                            music_get_ready = MediaPlayer.create(sport_relax.this, R.raw.get_ready_en);
                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                music_get_ready.stop();
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                music_get_ready.start();
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                        }

                                                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                                                super.run();

                                                                                                                                                                                                                                im_sport_rl_5.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                im_sport_rl_4.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                                                        super.run();

                                                                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.fa_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        } else if (language == en) {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.en_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        } else if (language == de) {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.de_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        } else {

                                                                                                                                                                                                                                            music_three = MediaPlayer.create(sport_relax.this, R.raw.en_3);
                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                music_three.stop();
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                music_three.start();
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                        im_sport_rl_4.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                        im_sport_rl_1.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                                        new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                            public void run() {
                                                                                                                                                                                                                                                super.run();

                                                                                                                                                                                                                                                if (language == fa) {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.fa_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                } else if (language == en) {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.en_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                } else if (language == de) {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.de_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                } else {

                                                                                                                                                                                                                                                    music_two = MediaPlayer.create(sport_relax.this, R.raw.en_2);
                                                                                                                                                                                                                                                    if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                        music_two.stop();
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        music_two.start();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                im_sport_rl_1.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                                im_sport_rl_3.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                                                new Handler().postDelayed(new Thread() {

                                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                                    public void run() {
                                                                                                                                                                                                                                                        super.run();

                                                                                                                                                                                                                                                        if (language == fa) {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.fa_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        } else if (language == en) {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.en_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        } else if (language == de) {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.de_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        } else {

                                                                                                                                                                                                                                                            music_one = MediaPlayer.create(sport_relax.this, R.raw.en_1);
                                                                                                                                                                                                                                                            if (voice_check_1 == voice_off_check_1) {
                                                                                                                                                                                                                                                                music_one.stop();
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                music_one.start();
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        im_sport_rl_3.setVisibility(View.INVISIBLE);

                                                                                                                                                                                                                                                        im_sport_rl_2.setVisibility(View.VISIBLE);

                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }, _splashTime);

                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }, _splashTime);

                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }, _splashTime);

                                                                                                                                                                                                            }
                                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                                    }
                                                                                                                                                                                                }, _splashTime);


                                                                                                                                                                                            }
                                                                                                                                                                                        }, _splashTime);

                                                                                                                                                                                    }
                                                                                                                                                                                }, _splashTime);


                                                                                                                                                                            }
                                                                                                                                                                        }, _splashTime);


                                                                                                                                                                    }
                                                                                                                                                                }, _splashTime);


                                                                                                                                                            }
                                                                                                                                                        }, _splashTime);

                                                                                                                                                    }
                                                                                                                                                }, _splashTime);

                                                                                                                                            }
                                                                                                                                        }, _splashTime);

                                                                                                                                    }
                                                                                                                                }, _splashTime);

                                                                                                                            }
                                                                                                                        }, _splashTime);

                                                                                                                    }
                                                                                                                }, _splashTime);

                                                                                                            }
                                                                                                        }, _splashTime);

                                                                                                    }
                                                                                                }, _splashTime);

                                                                                            }
                                                                                        }, _splashTime);

                                                                                    }
                                                                                }, _splashTime);

                                                                            }
                                                                        }, _splashTime);

                                                                    }
                                                                }, _splashTime);

                                                            }
                                                        }, _splashTime);

                                                    }
                                                }, _splashTime);

                                            }
                                        }, _splashTime);

                                    }
                                }, _splashTime);

                            }
                        }, _splashTime);

                    }
                }, _splashTime);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("16"));
            }
        }


        try {

            sport_page = sport_relax.getInt("sport_v_number_day_r");
            sport_page_set = sport_relax.getInt("sport_v_number_day_set_1_r");
            sport_volume = sport_relax.getInt("sport_v_volome");
            sport_v_por = sport_relax.getInt("sport_v_por1");

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("17"));
        }


        set = sport_page_set + 1;
        por = sport_v_por + 1;

        if (sport_page_set == 6) {

            TextView sport_rielax_txt_2 = (TextView) findViewById(R.id.sport_rielax_txt_2);
            try {

                sport_rielax_txt_2.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("18"));
            }


        }
        try {

            handler.postDelayed(thread = new Thread() {

                @Override
                public void run() {
                    super.run();


                    Intent uou = new Intent(sport_relax.this, sport_v.class);
                    uou.putExtra("sport_v_number_day_set_1", set);
                    uou.putExtra("sport_v_number_day", sport_page);
                    uou.putExtra("sport_v_volume1", sport_volume);
                    uou.putExtra("sport_v_por", por);
                    startActivity(uou);

                    sport_relax.this.finish();


                }
            }, _splashTime30);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("19"));
        }


        FirebaseCrash.log("log 5");
        System.gc();

    }


    //private class ual implements IUnityAdsListener {
//
    //    @Override
    //    public void onHide() {
//
    //    }
//
    //    @Override
    //    public void onShow() {
//
    //    }
//
    //    @Override
    //    public void onVideoStarted() {
//
    //    }
//
    //    @Override
    //    public void onVideoCompleted(String s, boolean b) {
//
    //    }
//
    //    @Override
    //    public void onFetchCompleted() {
//
    //    }
//
    //    @Override
    //    public void onFetchFailed() {
//
    //    }
    //}


    @Override
    protected void onStop() {
        super.onStop();
        try {

            handler.removeCallbacks(thread);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("20"));
        }
        FirebaseCrash.log("log 4");
        System.gc();
    }


    @Override
    protected void onResume() {
        super.onResume();

        //UnityAds.changeActivity(this);
        FirebaseCrash.log("log 3");
        System.gc();
    }

    @Override
    public void onPause() {
        super.onPause();

        try {

            handler.removeCallbacks(thread);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("21"));
        }
        FirebaseCrash.log("log 2");
        System.gc();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(sport_relax.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("22"));
            }

            try {

                click = MediaPlayer.create(sport_relax.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("23"));
            }


            String sport_day_back_1 = (String) getText(R.string.sport_day_back_1);
            String sport_day_back_2 = (String) getText(R.string.sport_day_back_2);
            String sport_day_back_3 = (String) getText(R.string.sport_day_back_3);
            String sport_day_back_4 = (String) getText(R.string.sport_day_back_4);

            try {

                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText(sport_day_back_1)
                        .setContentText(sport_day_back_2)
                        .setCancelText(sport_day_back_4)
                        .setConfirmText(sport_day_back_3)
                        .showCancelButton(true)
                        .setCancelClickListener(null)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                if (vibre_check == music_off_check) {
                                    vb.cancel();
                                } else {
                                    vb.vibrate(100);
                                }

                                click = MediaPlayer.create(sport_relax.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }
                                handler.removeCallbacks(thread);
                                sport_relax.this.finish();
                            }
                        })
                        .show();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("alert 24"));
                handler.removeCallbacks(thread);

                sport_relax.this.finish();
            }
            FirebaseCrash.log("log 1");
        }
        return false;
    }


}
