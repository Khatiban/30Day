package com.android.fury.a30day.sport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;


/**
 * Created by fury on 9/29/2016.
 */
public class sport_start extends Activity {

    Vibrator vb;

    private final int _splashTime = 5000;

    int time_1 = 1;
    int time_2 = 1;
    int time_3 = 1;
    int time_4 = 1;

    MediaPlayer click;

    String vibre_check, language1, music_off_check, music_check;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    ImageView sport_start_back, img_start_sport_1, img_start_sport_2, img_start_sport_3, img_start_sport_4, img_start_sport_5, img_start_sport_6, img_start_sport_7;

    TextView txt_sport_start_name_1, txt_sport_start_name_2, txt_sport_start_name_3, txt_sport_start_name_4, txt_sport_start_name_5, txt_sport_start_name_6, txt_sport_start_name_7, sport_start_txt_day, img_sport_start_1, img_sport_start_2, img_sport_start_3, img_sport_start_4, img_sport_start_5, img_sport_start_6, img_sport_start_7;

    RelativeLayout btn_sport_start_1;

    int por_1, volome_off, sport_page, sport_page_set, show;


    private ScheduledThreadPoolExecutor mDialogDaemon;

    int help_play, inzabn;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MaterialTapTargetPrompt mFabPrompt, mFabPrompt2, mFabPrompt3, mFabPrompt4, mFabPrompt5, mFabPrompt6, mFabPrompt7;

    MyDatabaseHelper_lan language;

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
        setContentView(R.layout.sport_s);

        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            help_play = one_play_preferences.getInt("Help_play_4", 1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }

        try {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }


        String f = "fa";
        if (f == language1) {
            inzabn = 1;
        } else {
            inzabn = 2;
        }

        final Bundle sport_v1 = getIntent().getExtras();

        try {

            por_1 = sport_v1.getInt("sport_v_por");
            volome_off = sport_v1.getInt("sport_v_volume1");
            sport_page = sport_v1.getInt("sport_v_number_day");
            sport_page_set = sport_v1.getInt("sport_v_number_day_set_1");

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }


        HorizontalScrollView sView = (HorizontalScrollView) findViewById(R.id.ho_scroll);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

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
            FirebaseCrash.report(new Exception("5"));
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
            FirebaseCrash.report(new Exception("6"));
        }


        sport_start_back = (ImageView) findViewById(R.id.sport_start_back);
        btn_sport_start_1 = (RelativeLayout) findViewById(R.id.btn_sport_start_1);
        txt_sport_start_name_1 = (TextView) findViewById(R.id.txt_sport_start_name_1);
        txt_sport_start_name_2 = (TextView) findViewById(R.id.txt_sport_start_name_2);
        txt_sport_start_name_3 = (TextView) findViewById(R.id.txt_sport_start_name_3);
        txt_sport_start_name_4 = (TextView) findViewById(R.id.txt_sport_start_name_4);
        txt_sport_start_name_5 = (TextView) findViewById(R.id.txt_sport_start_name_5);
        txt_sport_start_name_6 = (TextView) findViewById(R.id.txt_sport_start_name_6);
        txt_sport_start_name_7 = (TextView) findViewById(R.id.txt_sport_start_name_7);
        img_sport_start_1 = (TextView) findViewById(R.id.img_sport_start_1);
        img_sport_start_2 = (TextView) findViewById(R.id.img_sport_start_2);
        img_sport_start_3 = (TextView) findViewById(R.id.img_sport_start_3);
        img_sport_start_4 = (TextView) findViewById(R.id.img_sport_start_4);
        img_sport_start_5 = (TextView) findViewById(R.id.img_sport_start_5);
        img_sport_start_6 = (TextView) findViewById(R.id.img_sport_start_6);
        img_sport_start_7 = (TextView) findViewById(R.id.img_sport_start_7);
        sport_start_txt_day = (TextView) findViewById(R.id.sport_start_txt_day);
        img_start_sport_1 = (ImageView) findViewById(R.id.img_start_sport_1);
        img_start_sport_2 = (ImageView) findViewById(R.id.img_start_sport_2);
        img_start_sport_3 = (ImageView) findViewById(R.id.img_start_sport_3);
        img_start_sport_4 = (ImageView) findViewById(R.id.img_start_sport_4);
        img_start_sport_5 = (ImageView) findViewById(R.id.img_start_sport_5);
        img_start_sport_6 = (ImageView) findViewById(R.id.img_start_sport_6);
        img_start_sport_7 = (ImageView) findViewById(R.id.img_start_sport_7);
        final LinearLayout alakiha_22 = (LinearLayout) findViewById(R.id.alakiha_22);
        final TextView txt_sport_start_name_1 = (TextView) findViewById(R.id.txt_sport_start_name_1);
        final TextView img_sport_start_1 = (TextView) findViewById(R.id.img_sport_start_1);

        if (help_play == 1) {

            final String s11 = (String) getText(R.string.Help_start_4_1);
            final String s22 = (String) getText(R.string.Help_start_4_2);
            final String s111 = (String) getText(R.string.Help_start_5_1);
            final String s222 = (String) getText(R.string.Help_start_5_2);
            final String s1111 = (String) getText(R.string.Help_start_6_1);
            final String s2222 = (String) getText(R.string.Help_start_6_2);
            final String s11111 = (String) getText(R.string.Help_start_7_1);
            final String s22222 = (String) getText(R.string.Help_start_7_2);


            try {

                mFabPrompt = new MaterialTapTargetPrompt.Builder(this)
                        .setTarget(txt_sport_start_name_1)
                        .setPrimaryText(s111)
                        .setSecondaryText(s222)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt = null;
                                mFabPrompt2.show();
                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .show();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }


            try {

                mFabPrompt2 = new MaterialTapTargetPrompt.Builder(sport_start.this)
                        .setTarget(img_sport_start_1)
                        .setPrimaryText(s1111)
                        .setSecondaryText(s2222)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt2 = null;
                                mFabPrompt3.show();
                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .create();


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("11"));
            }

            try {


                mFabPrompt3 = new MaterialTapTargetPrompt.Builder(sport_start.this)
                        .setTarget(alakiha_22)
                        .setPrimaryText(s11)
                        .setSecondaryText(s22)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt3 = null;
                                mFabPrompt4.show();
                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .create();


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
            }

            try {


                mFabPrompt4 = new MaterialTapTargetPrompt.Builder(sport_start.this)
                        .setTarget(btn_sport_start_1)
                        .setPrimaryText(s11111)
                        .setSecondaryText(s22222)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt4 = null;

                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .create();


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("13"));
            }


        }


        sport_start_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    time_4 = 2;
                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("14"));
                }

                try {

                    click = MediaPlayer.create(sport_start.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }

                try {

                    Intent ss = new Intent(sport_start.this, sport.class);
                    ss.putExtra("sport_back", 3);
                    startActivity(ss);
                    finish();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                }


            }
        });


        btn_sport_start_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }


                try {

                    click = MediaPlayer.create(sport_start.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }

                try {

                    one_play_editor.putInt("Help_play_4", 2);
                    one_play_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                }

                try {

                    Intent ssss = new Intent(sport_start.this, sport_v.class);

                    ssss.putExtra("sport_v_number_day", sport_page);
                    ssss.putExtra("sport_v_number_day_set_1", sport_page_set);
                    ssss.putExtra("sport_v_volume1", volome_off);
                    ssss.putExtra("sport_v_por", por_1);

                    startActivity(ssss);
                    finish();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("19"));
                }


            }
        });
        FirebaseCrash.log("log 3");


        if (sport_page == 1) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_13);
            img_sport_start_1.setText(R.string.sport_start_txt_5_1);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_4);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_5);
            img_sport_start_7.setText(R.string.sport_start_txt_5_6);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_1);


        } else if (sport_page == 2) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_4);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_5);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_6);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_4);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_1);
            img_sport_start_5.setText(R.string.sport_start_txt_5_1);
            img_sport_start_6.setText(R.string.sport_start_txt_5_1);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_2);

        } else if (sport_page == 3) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_11);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_13);
            img_sport_start_1.setText(R.string.sport_start_txt_5_3);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_7);
            img_sport_start_4.setText(R.string.sport_start_txt_5_3);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_8);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_3);

        } else if (sport_page == 4) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_4);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_5);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_11);
            img_sport_start_1.setText(R.string.sport_start_txt_5_3);
            img_sport_start_2.setText(R.string.sport_start_txt_5_3);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_7);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_9);
            img_sport_start_7.setText(R.string.sport_start_txt_5_1);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_4);

        } else if (sport_page == 5) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_13);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_7);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_8);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_5);

        } else if (sport_page == 6) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_9);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_4);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_5);
            img_sport_start_1.setText(R.string.sport_start_txt_5_3);
            img_sport_start_2.setText(R.string.sport_start_txt_5_7);
            img_sport_start_3.setText(R.string.sport_start_txt_5_6);
            img_sport_start_4.setText(R.string.sport_start_txt_5_2);
            img_sport_start_5.setText(R.string.sport_start_txt_5_8);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_2);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_6);

        } else if (sport_page == 7) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_9);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_11);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_7);
            img_sport_start_5.setText(R.string.sport_start_txt_5_1);
            img_sport_start_6.setText(R.string.sport_start_txt_5_1);
            img_sport_start_7.setText(R.string.sport_start_txt_5_10);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_7);

        } else if (sport_page == 8) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_15);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_11);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_1);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_6);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_1);
            img_sport_start_5.setText(R.string.sport_start_txt_5_1);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_8);

        } else if (sport_page == 9) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_15);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_9);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_3);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_9);

        } else if (sport_page == 10) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_9);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_15);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_11);
            img_sport_start_1.setText(R.string.sport_start_txt_5_3);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_2);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_10);
            img_sport_start_7.setText(R.string.sport_start_txt_5_1);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_10);

        } else if (sport_page == 11) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_13);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_2);
            img_sport_start_6.setText(R.string.sport_start_txt_5_10);
            img_sport_start_7.setText(R.string.sport_start_txt_5_2);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_11);

        } else if (sport_page == 12) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_4);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_5);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_9);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_11);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_13);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_1);
            img_sport_start_6.setText(R.string.sport_start_txt_5_3);
            img_sport_start_7.setText(R.string.sport_start_txt_5_2);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_12);

        } else if (sport_page == 13) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_12);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_14);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_4);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_5);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_1);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_3);
            img_sport_start_7.setText(R.string.sport_start_txt_5_11);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_13);

        } else if (sport_page == 14) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_12);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_15);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_7);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_11);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_6);
            img_sport_start_7.setText(R.string.sport_start_txt_5_6);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_14);

        } else if (sport_page == 15) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_4);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_5);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_3);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_2);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_2);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_15);

        } else if (sport_page == 16) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_15);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_14);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_12);
            img_sport_start_5.setText(R.string.sport_start_txt_5_2);
            img_sport_start_6.setText(R.string.sport_start_txt_5_1);
            img_sport_start_7.setText(R.string.sport_start_txt_5_1);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_16);

        } else if (sport_page == 17) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_12);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_9);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_8);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_12);
            img_sport_start_4.setText(R.string.sport_start_txt_5_3);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_3);
            img_sport_start_7.setText(R.string.sport_start_txt_5_6);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_17);

        } else if (sport_page == 18) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_8);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_10);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_9);
            img_sport_start_4.setText(R.string.sport_start_txt_5_9);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_11);
            img_sport_start_7.setText(R.string.sport_start_txt_5_6);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_18);

        } else if (sport_page == 19) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_8);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_10);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_1);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_1);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_11);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_19);

        } else if (sport_page == 20) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_10);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_12);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_9);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_12);
            img_sport_start_7.setText(R.string.sport_start_txt_5_1);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_20);

        } else if (sport_page == 21) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_3);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_13);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_9);
            img_sport_start_3.setText(R.string.sport_start_txt_5_9);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_2);
            img_sport_start_6.setText(R.string.sport_start_txt_5_12);
            img_sport_start_7.setText(R.string.sport_start_txt_5_2);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_21);

        } else if (sport_page == 22) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_8);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_10);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_12);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_1);
            img_sport_start_4.setText(R.string.sport_start_txt_5_13);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_12);
            img_sport_start_7.setText(R.string.sport_start_txt_5_1);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_22);

        } else if (sport_page == 23) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_14);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_2);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_9);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_12);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_1);
            img_sport_start_3.setText(R.string.sport_start_txt_5_9);
            img_sport_start_4.setText(R.string.sport_start_txt_5_1);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_3);
            img_sport_start_7.setText(R.string.sport_start_txt_5_3);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_23);

        } else if (sport_page == 24) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_2);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_10);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_2);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_13);
            img_sport_start_5.setText(R.string.sport_start_txt_5_9);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_12);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_24);

        } else if (sport_page == 25) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_2);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_10);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_8);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_3);
            img_sport_start_3.setText(R.string.sport_start_txt_5_9);
            img_sport_start_4.setText(R.string.sport_start_txt_5_1);
            img_sport_start_5.setText(R.string.sport_start_txt_5_3);
            img_sport_start_6.setText(R.string.sport_start_txt_5_3);
            img_sport_start_7.setText(R.string.sport_start_txt_5_12);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_25);

        } else if (sport_page == 26) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_14);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_16);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_17);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_8);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_1);
            img_sport_start_3.setText(R.string.sport_start_txt_5_2);
            img_sport_start_4.setText(R.string.sport_start_txt_5_9);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_3);
            img_sport_start_7.setText(R.string.sport_start_txt_5_12);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_26);

        } else if (sport_page == 27) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_2);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_14);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_16);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_17);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_1);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_1);
            img_sport_start_6.setText(R.string.sport_start_txt_5_1);
            img_sport_start_7.setText(R.string.sport_start_txt_5_12);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_27);

        } else if (sport_page == 28) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_14);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_16);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_8);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_18);
            img_sport_start_1.setText(R.string.sport_start_txt_5_9);
            img_sport_start_2.setText(R.string.sport_start_txt_5_1);
            img_sport_start_3.setText(R.string.sport_start_txt_5_1);
            img_sport_start_4.setText(R.string.sport_start_txt_5_3);
            img_sport_start_5.setText(R.string.sport_start_txt_5_1);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_12);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_28);

        } else if (sport_page == 29) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_14);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_16);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_6);
            img_sport_start_1.setText(R.string.sport_start_txt_5_2);
            img_sport_start_2.setText(R.string.sport_start_txt_5_1);
            img_sport_start_3.setText(R.string.sport_start_txt_5_3);
            img_sport_start_4.setText(R.string.sport_start_txt_5_1);
            img_sport_start_5.setText(R.string.sport_start_txt_5_4);
            img_sport_start_6.setText(R.string.sport_start_txt_5_2);
            img_sport_start_7.setText(R.string.sport_start_txt_5_9);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_29);

        } else if (sport_page == 30) {

            txt_sport_start_name_1.setText(R.string.sport_start_txt_5_name_13);
            txt_sport_start_name_2.setText(R.string.sport_start_txt_5_name_6);
            txt_sport_start_name_3.setText(R.string.sport_start_txt_5_name_1);
            txt_sport_start_name_4.setText(R.string.sport_start_txt_5_name_7);
            txt_sport_start_name_5.setText(R.string.sport_start_txt_5_name_16);
            txt_sport_start_name_6.setText(R.string.sport_start_txt_5_name_18);
            txt_sport_start_name_7.setText(R.string.sport_start_txt_5_name_17);
            img_sport_start_1.setText(R.string.sport_start_txt_5_3);
            img_sport_start_2.setText(R.string.sport_start_txt_5_3);
            img_sport_start_3.setText(R.string.sport_start_txt_5_6);
            img_sport_start_4.setText(R.string.sport_start_txt_5_6);
            img_sport_start_5.setText(R.string.sport_start_txt_5_6);
            img_sport_start_6.setText(R.string.sport_start_txt_5_11);
            img_sport_start_7.setText(R.string.sport_start_txt_5_6);
            sport_start_txt_day.setText(R.string.sport_start_txt_day_30);

        }


        show = 1;


        if (mDialogDaemon != null) {
            try {

                mDialogDaemon.shutdown();
                mDialogDaemon = null;

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("20"));
            }

        }
        try {

            mDialogDaemon = new ScheduledThreadPoolExecutor(1);
            // This process will execute immediately, then execute every 3 seconds.
            mDialogDaemon.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (show == 1) {

                                if (sport_page == 1) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_1);

                                } else if (sport_page == 2) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_4_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_5_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_6_1);

                                } else if (sport_page == 3) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_11_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_1);

                                } else if (sport_page == 4) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_4_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_5_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_11_1);

                                } else if (sport_page == 5) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_1);

                                } else if (sport_page == 6) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_9_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_4_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_5_1);

                                } else if (sport_page == 7) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_9_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_11_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);

                                } else if (sport_page == 8) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_15_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_11_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_1_1);

                                } else if (sport_page == 9) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_15_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_9_1);

                                } else if (sport_page == 10) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_9_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_15_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_11_1);

                                } else if (sport_page == 11) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_1);

                                } else if (sport_page == 12) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_4_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_5_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_9_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_11_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_1);

                                } else if (sport_page == 13) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_12_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_14_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_4_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_5_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);

                                } else if (sport_page == 14) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_12_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_15_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_7_1);

                                } else if (sport_page == 15) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_4_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_5_1);

                                } else if (sport_page == 16) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_15_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_14_1);

                                } else if (sport_page == 17) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_12_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_9_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_8_1);

                                } else if (sport_page == 18) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_8_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_10_1);

                                } else if (sport_page == 19) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_8_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_1_1);

                                } else if (sport_page == 20) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_12_1);

                                } else if (sport_page == 21) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_1);

                                } else if (sport_page == 22) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_8_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_12_1);

                                } else if (sport_page == 23) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_2_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_9_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_12_1);

                                } else if (sport_page == 24) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_2_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_10_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);

                                } else if (sport_page == 25) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_2_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_8_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);

                                } else if (sport_page == 26) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_16_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_17_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_8_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);

                                } else if (sport_page == 27) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_2_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_14_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_16_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_17_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);

                                } else if (sport_page == 28) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_16_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_8_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_1);


                                } else if (sport_page == 29) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_16_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_6_1);

                                } else if (sport_page == 30) {


                                    img_start_sport_1.setImageResource(R.drawable.sport_13_1);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_1);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_1);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_1);
                                    img_start_sport_5.setImageResource(R.drawable.sport_16_1);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_1);
                                    img_start_sport_7.setImageResource(R.drawable.sport_17_1);

                                }
                                // Do something worthwhile
                                show = 2;
                            } else if (show == 2) {

                                if (sport_page == 1) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_3);

                                } else if (sport_page == 2) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_4_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_5_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_6_3);

                                } else if (sport_page == 3) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_11_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_3);

                                } else if (sport_page == 4) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_4_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_5_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_11_2);

                                } else if (sport_page == 5) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_3);

                                } else if (sport_page == 6) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_9_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_5.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_4_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_5_2);

                                } else if (sport_page == 7) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_9_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_11_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 8) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_15_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_11_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_1_2);

                                } else if (sport_page == 9) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_15_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_7.setImageResource(R.drawable.sport_9_2);

                                } else if (sport_page == 10) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_9_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_15_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_11_2);

                                } else if (sport_page == 11) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_3);

                                } else if (sport_page == 12) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_4_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_5_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_9_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_11_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_3);

                                } else if (sport_page == 13) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_12_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_14_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_4_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_5_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 14) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_12_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_15_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_7_2);

                                } else if (sport_page == 15) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_4_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_5_2);

                                } else if (sport_page == 16) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_15_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_14_2);

                                } else if (sport_page == 17) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_5.setImageResource(R.drawable.sport_12_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_9_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_8_3);

                                } else if (sport_page == 18) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_8_3);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_10_2);

                                } else if (sport_page == 19) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_8_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_1_2);

                                } else if (sport_page == 20) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_12_2);

                                } else if (sport_page == 21) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_3_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_13_3);

                                } else if (sport_page == 22) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_8_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_12_2);

                                } else if (sport_page == 23) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_2_3);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_9_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_12_2);

                                } else if (sport_page == 24) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_2_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_10_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 25) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_2_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_10_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_8_3);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 26) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_16_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_5.setImageResource(R.drawable.sport_17_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_8_3);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 27) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_2_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_14_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_16_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_17_3);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 28) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_16_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_8_3);
                                    img_start_sport_5.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_18_2);

                                } else if (sport_page == 29) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_2.setImageResource(R.drawable.sport_14_2);
                                    img_start_sport_3.setImageResource(R.drawable.sport_16_3);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_6.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_6_3);

                                } else if (sport_page == 30) {

                                    img_start_sport_1.setImageResource(R.drawable.sport_13_3);
                                    img_start_sport_2.setImageResource(R.drawable.sport_6_3);
                                    img_start_sport_3.setImageResource(R.drawable.sport_1_2);
                                    img_start_sport_4.setImageResource(R.drawable.sport_7_2);
                                    img_start_sport_5.setImageResource(R.drawable.sport_16_3);
                                    img_start_sport_6.setImageResource(R.drawable.sport_18_2);
                                    img_start_sport_7.setImageResource(R.drawable.sport_17_3);

                                }

                                show = 1;
                            }
                        }
                    });
                }
            }, 0L, 1000L, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("21"));
        }


        FirebaseCrash.log("log 2");
        System.gc();


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(sport_start.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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

                click = MediaPlayer.create(sport_start.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("23"));
            }


            try {

                Intent sss = new Intent(sport_start.this, sport.class);
                sss.putExtra("sport_back", 3);
                startActivity(sss);
                finish();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("24"));
            }
            FirebaseCrash.log("log 1");
        }
        return false;
    }

}
