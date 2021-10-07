package com.android.fury.a30day.sport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_music;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Database.MyDatabaseHelper_voice;
import com.android.fury.a30day.R;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by fury on 1/20/2017.
 */
public class Sport_me extends Activity implements View.OnClickListener {

    MyDatabaseHelper_lan language1;


    Vibrator vb;

    MediaPlayer music, music_go, click, music_complate, music_puase, music_resumed;

    MyDatabaseHelper_music music_data;
    MyDatabaseHelper_voice voice_data;
    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    String mo1 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-1-set-2-3-4-5-6-after-4.mp3";//DJ F.A.X
    String mo2 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-2-set-2-3-4-5-6-after-music-1.mp3";//DJ F.A.X
    String mo3 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-3-set-2-3-4-5-6-after-music-2.mp3";//DJ F.A.X
    String mo4 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-4-set-2-3-4-5-6.mp3";//DJ AL
    String mo5 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-5-set-2-3-4-5-6.mp3";//DJ AL
    String mo6 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-6-set-2-3-4-5-6.mp3";//DJ Hosein Aerial
    String mo7 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-7-set-2-3-4-5-6.mp3";//DJ DELBAR
    String mo9 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-9-set-2-3-4-5-6.mp3";//DJ RaMiN
    String mo10 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-10.mp3";//DJ F.A.X
    String mo11 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-11-set-2-3-4-5-6.mp3";//DJ RaMiN
    String mo12 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-12-set-2-3-4-5-6-ICY-MONCEY.mp3";//DJ RaMiN
    String mo13 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-13-set-2-3-4-5-6.mp3";//DJ RaMiN
    String mo14 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-15.mp3";//DJ F.A.X
    String m;

    String time, music_check_1, music_off_check_1, voice_check_1, voice_off_check_1, music_check, music_off_check, vibre_check, language, fa, en, de;

    final Handler handler = new Handler();
    Thread thread;

    int tedad_kol, now_harkat_1, now_harkat_2, now_harkat_3, now_harkat_4, now_harkat_5, now_harkat_6, now_harkat_7, now_harkat_8, now_harkat_9, now_harkat_10, now_harkat_11, now_harkat_12, now_harkat_13, now_harkat_14, now_harkat_15, now_harkat_16, now_harkat_17, now_harkat_18, time_sport, time_rest, image_1, image_2, image_3, image_4, timeout, volome_off;

    CardView card_view_hp;

    TextView txt_sport_v_time, txt_sport_dj;


    ImageView btn_stop_resume_sport, btn_volume_sport, batery, btn_sport_v_back, im_sport_v_time_2, im_sport_v_time_3, im_sport_v_time_4, im_sport_v_time_5, im_sport_v_time_6, im_sport_v_time_7, im_sport_v_time_8, im_sport_v_time_9, im_sport_v_time_10, im_sport_v_time_11, im_sport_v_time_12, im_sport_v_time_hid, im_sport_v_time_hid2, im_sports_1;

    private final int _splashTime = 500;
    private int _splashTime60;

    AudioManager audioManager;

    int s, a, time_stop, time_stop2, btn_stop, por_1, timestart, min, max, khodkar_1, music_of, seda;


    private ScheduledThreadPoolExecutor mDialogDaemon, mDialogDaemon_time;

    Intent d;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;


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

        try {
            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }

        //start activ
        setContentView(R.layout.sport_me);


        try {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        try {

            //save music
            music_data = new MyDatabaseHelper_music(this);
            Cursor res3 = music_data.showAllData();
            StringBuffer data3 = new StringBuffer();
            while (res3.moveToNext()) {
                data3.append(res3.getString(1));
            }
            if (data3.toString().length() == 4) {
                music_check_1 = "true";
            } else if (data3.toString().length() == 5) {
                music_check_1 = "false";
            } else {
                music_check_1 = "true";
            }
            music_off_check_1 = "false";

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
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
            FirebaseCrash.report(new Exception("4"));
        }

        fa = "fa";
        en = "en";
        de = "de";


        if (language == fa) {

            try {

                music_go = MediaPlayer.create(Sport_me.this, R.raw.go_fa);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("5"));
            }

        } else if (language == en) {

            try {

                music_go = MediaPlayer.create(Sport_me.this, R.raw.go_en);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }


        } else if (language == de) {

            try {

                music_go = MediaPlayer.create(Sport_me.this, R.raw.go_de);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }

        } else {

            try {

                music_go = MediaPlayer.create(Sport_me.this, R.raw.go_en);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("8"));
            }

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
            FirebaseCrash.report(new Exception("9"));
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
            FirebaseCrash.report(new Exception("10"));
        }


        Bundle sport_me_1 = getIntent().getExtras();

        tedad_kol = sport_me_1.getInt("tedad_kol");
        now_harkat_1 = sport_me_1.getInt("now_harkat_1");
        now_harkat_2 = sport_me_1.getInt("now_harkat_2");
        now_harkat_3 = sport_me_1.getInt("now_harkat_3");
        now_harkat_4 = sport_me_1.getInt("now_harkat_4");
        now_harkat_5 = sport_me_1.getInt("now_harkat_5");
        now_harkat_6 = sport_me_1.getInt("now_harkat_6");
        now_harkat_7 = sport_me_1.getInt("now_harkat_7");
        now_harkat_8 = sport_me_1.getInt("now_harkat_8");
        now_harkat_9 = sport_me_1.getInt("now_harkat_9");
        now_harkat_10 = sport_me_1.getInt("now_harkat_10");
        now_harkat_11 = sport_me_1.getInt("now_harkat_11");
        now_harkat_12 = sport_me_1.getInt("now_harkat_12");
        now_harkat_13 = sport_me_1.getInt("now_harkat_13");
        now_harkat_14 = sport_me_1.getInt("now_harkat_14");
        now_harkat_15 = sport_me_1.getInt("now_harkat_15");
        now_harkat_16 = sport_me_1.getInt("now_harkat_16");
        now_harkat_17 = sport_me_1.getInt("now_harkat_17");
        now_harkat_18 = sport_me_1.getInt("now_harkat_18");
        time_sport = sport_me_1.getInt("time");
        time_rest = sport_me_1.getInt("time_rest");
        por_1 = sport_me_1.getInt("sport_me_por");

        txt_sport_v_time = (TextView) findViewById(R.id.txt_sport_v_time);
        txt_sport_dj = (TextView) findViewById(R.id.txt_sport_dj);
        batery = (ImageView) findViewById(R.id.batery);
        im_sport_v_time_hid = (ImageView) findViewById(R.id.im_sport_v_time_hid);
        im_sport_v_time_2 = (ImageView) findViewById(R.id.im_sport_v_time_2);
        im_sport_v_time_3 = (ImageView) findViewById(R.id.im_sport_v_time_3);
        im_sport_v_time_4 = (ImageView) findViewById(R.id.im_sport_v_time_4);
        im_sport_v_time_5 = (ImageView) findViewById(R.id.im_sport_v_time_5);
        im_sport_v_time_6 = (ImageView) findViewById(R.id.im_sport_v_time_6);
        im_sport_v_time_7 = (ImageView) findViewById(R.id.im_sport_v_time_7);
        im_sport_v_time_8 = (ImageView) findViewById(R.id.im_sport_v_time_8);
        im_sport_v_time_9 = (ImageView) findViewById(R.id.im_sport_v_time_9);
        im_sport_v_time_10 = (ImageView) findViewById(R.id.im_sport_v_time_10);
        im_sport_v_time_11 = (ImageView) findViewById(R.id.im_sport_v_time_11);
        im_sport_v_time_12 = (ImageView) findViewById(R.id.im_sport_v_time_12);
        im_sport_v_time_hid2 = (ImageView) findViewById(R.id.im_sport_v_time_hid2);
        im_sports_1 = (ImageView) findViewById(R.id.im_sports_1);
        card_view_hp = (CardView) findViewById(R.id.card_view_hp);
        btn_stop_resume_sport = (ImageView) findViewById(R.id.btn_stop_resume_sport);
        btn_volume_sport = (ImageView) findViewById(R.id.btn_volume_sport);
        btn_sport_v_back = (ImageView) findViewById(R.id.btn_sport_v_back);

        btn_stop_resume_sport.setOnClickListener(this);
        btn_volume_sport.setOnClickListener(this);
        btn_sport_v_back.setOnClickListener(this);

        _splashTime60 = time_sport * 1000;
        volome_off = 1;

        if (tedad_kol == 3) {

            im_sport_v_time_6.setVisibility(View.GONE);
            im_sport_v_time_7.setVisibility(View.GONE);
            im_sport_v_time_8.setVisibility(View.GONE);
            im_sport_v_time_9.setVisibility(View.GONE);
            im_sport_v_time_10.setVisibility(View.GONE);
            im_sport_v_time_11.setVisibility(View.GONE);
            im_sport_v_time_12.setVisibility(View.GONE);
            im_sport_v_time_hid2.setVisibility(View.GONE);

        } else if (tedad_kol == 4) {

            im_sport_v_time_8.setVisibility(View.GONE);
            im_sport_v_time_9.setVisibility(View.GONE);
            im_sport_v_time_10.setVisibility(View.GONE);
            im_sport_v_time_11.setVisibility(View.GONE);
            im_sport_v_time_12.setVisibility(View.GONE);
            im_sport_v_time_hid2.setVisibility(View.GONE);

        } else if (tedad_kol == 5) {

            im_sport_v_time_10.setVisibility(View.GONE);
            im_sport_v_time_11.setVisibility(View.GONE);
            im_sport_v_time_12.setVisibility(View.GONE);
            im_sport_v_time_hid2.setVisibility(View.GONE);

        } else if (tedad_kol == 6) {

            im_sport_v_time_12.setVisibility(View.GONE);
            im_sport_v_time_hid2.setVisibility(View.GONE);

        } else if (tedad_kol == 7) {
        }


        try {

            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("11"));
        }


        timestart = 0;


        btn_stop = 1;

        time_stop = 1;
        time_stop2 = 1;

        s = time_sport + 1;

        if (mDialogDaemon_time != null) {
            try {

                mDialogDaemon_time.shutdown();
                mDialogDaemon_time = null;

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
            }
        }
        try {

            mDialogDaemon_time = new ScheduledThreadPoolExecutor(1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("13"));
        }

        try {

            mDialogDaemon_time.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (time_stop2 == 1) {

                                int timestart_sport = timestart;
                                timestart = 1000 + timestart_sport;

                                a = s - 1;
                                time = String.valueOf(a);

                                txt_sport_v_time.setText(time);

                                if (a == 5) {

                                    new Handler().postDelayed(new Thread() {
                                        @Override
                                        public void run() {
                                            super.run();

                                            txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day));

                                        }
                                    }, _splashTime);

                                    txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day_hide));

                                } else if (a == 4) {

                                    new Handler().postDelayed(new Thread() {

                                        @Override
                                        public void run() {
                                            super.run();

                                            txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day));

                                        }
                                    }, _splashTime);

                                    txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day_hide));

                                } else if (a == 3) {

                                    new Handler().postDelayed(new Thread() {

                                        @Override
                                        public void run() {
                                            super.run();

                                            txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day));

                                        }
                                    }, _splashTime);

                                    txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day_hide));

                                } else if (a == 2) {

                                    new Handler().postDelayed(new Thread() {

                                        @Override
                                        public void run() {
                                            super.run();

                                            txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day));

                                        }
                                    }, _splashTime);

                                    txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day_hide));

                                } else if (a == 1) {

                                    new Handler().postDelayed(new Thread() {

                                        @Override
                                        public void run() {
                                            super.run();

                                            txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day));

                                        }
                                    }, _splashTime);

                                    txt_sport_v_time.setTextColor(getResources().getColor(R.color.color30day_hide));

                                } else {
                                }

                                s = a;

                            } else {
                            }

                            // Do something worthwhile
                        }
                    });
                }
            }, 0L, 1000L, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("14"));
        }


        if (por_1 == 1) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("15"));
            }

        } else if (por_1 == 2) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day);
                im_sport_v_time_2.setImageResource(R.color.background_sport);
                im_sport_v_time_3.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("16"));
            }

        } else if (por_1 == 3) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day);
                im_sport_v_time_2.setImageResource(R.color.background_sport);
                im_sport_v_time_3.setImageResource(R.color.color30day);
                im_sport_v_time_4.setImageResource(R.color.background_sport);
                im_sport_v_time_5.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("17"));
            }

        } else if (por_1 == 4) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day);
                im_sport_v_time_2.setImageResource(R.color.background_sport);
                im_sport_v_time_3.setImageResource(R.color.color30day);
                im_sport_v_time_4.setImageResource(R.color.background_sport);
                im_sport_v_time_5.setImageResource(R.color.color30day);
                im_sport_v_time_6.setImageResource(R.color.background_sport);
                im_sport_v_time_7.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("18"));
            }

        } else if (por_1 == 5) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day);
                im_sport_v_time_2.setImageResource(R.color.background_sport);
                im_sport_v_time_3.setImageResource(R.color.color30day);
                im_sport_v_time_4.setImageResource(R.color.background_sport);
                im_sport_v_time_5.setImageResource(R.color.color30day);
                im_sport_v_time_6.setImageResource(R.color.background_sport);
                im_sport_v_time_7.setImageResource(R.color.color30day);
                im_sport_v_time_8.setImageResource(R.color.background_sport);
                im_sport_v_time_9.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("19"));
            }

        } else if (por_1 == 6) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day);
                im_sport_v_time_2.setImageResource(R.color.background_sport);
                im_sport_v_time_3.setImageResource(R.color.color30day);
                im_sport_v_time_4.setImageResource(R.color.background_sport);
                im_sport_v_time_5.setImageResource(R.color.color30day);
                im_sport_v_time_6.setImageResource(R.color.background_sport);
                im_sport_v_time_7.setImageResource(R.color.color30day);
                im_sport_v_time_8.setImageResource(R.color.background_sport);
                im_sport_v_time_9.setImageResource(R.color.color_red);
                im_sport_v_time_10.setImageResource(R.color.background_sport);
                im_sport_v_time_11.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("20"));
            }

        } else if (por_1 == 7) {

            try {

                im_sport_v_time_hid.setImageResource(R.color.color30day);
                im_sport_v_time_2.setImageResource(R.color.background_sport);
                im_sport_v_time_3.setImageResource(R.color.color30day);
                im_sport_v_time_4.setImageResource(R.color.background_sport);
                im_sport_v_time_5.setImageResource(R.color.color30day);
                im_sport_v_time_6.setImageResource(R.color.background_sport);
                im_sport_v_time_7.setImageResource(R.color.color30day);
                im_sport_v_time_8.setImageResource(R.color.background_sport);
                im_sport_v_time_9.setImageResource(R.color.color_red);
                im_sport_v_time_10.setImageResource(R.color.background_sport);
                im_sport_v_time_11.setImageResource(R.color.color_red);
                im_sport_v_time_12.setImageResource(R.color.background_sport);
                im_sport_v_time_hid2.setImageResource(R.color.color30day_hide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("21"));
            }

        }

        if (music_check_1 == music_off_check_1) {
        } else {
            if (app_net.getInstance(this).isOnline()) {
                min = 1;
                max = 14;

                Random r = new Random();

                khodkar_1 = r.nextInt(max - min + 1) + min;

                if (khodkar_1 == 1) {

                    txt_sport_dj.setText(R.string.sport_dj1);
                    m = mo1;

                } else if (khodkar_1 == 2) {

                    txt_sport_dj.setText(R.string.sport_dj1);
                    m = mo2;

                } else if (khodkar_1 == 3) {

                    txt_sport_dj.setText(R.string.sport_dj1);
                    m = mo3;

                } else if (khodkar_1 == 4) {

                    txt_sport_dj.setText(R.string.sport_dj3);
                    m = mo4;

                } else if (khodkar_1 == 5) {

                    txt_sport_dj.setText(R.string.sport_dj3);
                    m = mo5;

                } else if (khodkar_1 == 6) {

                    txt_sport_dj.setText(R.string.sport_dj4);
                    m = mo6;

                } else if (khodkar_1 == 7) {

                    txt_sport_dj.setText(R.string.sport_dj5);
                    m = mo7;

                } else if (khodkar_1 == 8) {

                    txt_sport_dj.setText(R.string.sport_dj1);
                    m = mo14;

                } else if (khodkar_1 == 9) {

                    txt_sport_dj.setText(R.string.sport_dj2);
                    m = mo9;

                } else if (khodkar_1 == 10) {

                    txt_sport_dj.setText(R.string.sport_dj1);
                    m = mo10;

                } else if (khodkar_1 == 11) {

                    txt_sport_dj.setText(R.string.sport_dj2);
                    m = mo11;

                } else if (khodkar_1 == 12) {

                    txt_sport_dj.setText(R.string.sport_dj2);
                    m = mo12;

                } else if (khodkar_1 == 13) {

                    txt_sport_dj.setText(R.string.sport_dj2);
                    m = mo13;

                } else if (khodkar_1 == 14) {

                    txt_sport_dj.setText(R.string.sport_dj1);
                    m = mo14;

                }

                one_play_editor.putString("sport_me_music_url", m);
                one_play_editor.putString("music_check_offline", music_check_1);
                one_play_editor.putString("music_off_check_offline", music_off_check_1);
                one_play_editor.apply();

            } else {

                min = 1;
                max = 4;

                Random r = new Random();

                khodkar_1 = r.nextInt(max - min + 1) + min;

                int shom = 1;

                if (khodkar_1 == 1) {

                    txt_sport_dj.setText(R.string.sport_dj2_offline);
                    shom = 1;

                } else if (khodkar_1 == 2) {

                    txt_sport_dj.setText(R.string.sport_dj2);
                    shom = 2;

                } else if (khodkar_1 == 3) {

                    txt_sport_dj.setText(R.string.sport_dj1_offline);
                    shom = 3;

                } else if (khodkar_1 == 4) {

                    txt_sport_dj.setText(R.string.sport_dj3_offline);
                    shom = 4;

                }

                one_play_editor.putInt("sport_me_music", shom);
                one_play_editor.putString("music_check_offline", music_check_1);
                one_play_editor.putString("music_off_check_offline", music_off_check_1);
                one_play_editor.apply();

            }
            startService(new Intent(Sport_me.this, Back_Music_Me.class));
        }


        if (tedad_kol == 3) {

            if (por_1 == 1) {

                kol_kar(1);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 2) {

                kol_kar(2);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 3) {

                kol_kar(3);

                kor_finish_end();

            }


        } else if (tedad_kol == 4) {

            if (por_1 == 1) {

                kol_kar(1);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 2) {

                kol_kar(2);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 3) {

                kol_kar(3);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 4) {

                kol_kar(4);

                kor_finish_end();

            }


        } else if (tedad_kol == 5) {

            if (por_1 == 1) {

                kol_kar(1);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 2) {

                kol_kar(2);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 3) {

                kol_kar(3);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 4) {

                kol_kar(4);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 5) {

                kol_kar(5);

                kor_finish_end();

            }


        } else if (tedad_kol == 6) {

            if (por_1 == 1) {

                kol_kar(1);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 2) {

                kol_kar(2);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 3) {

                kol_kar(3);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 4) {

                kol_kar(4);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 5) {

                kol_kar(5);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 6) {

                kol_kar(6);

                kor_finish_end();

            }


        } else if (tedad_kol == 7) {

            if (por_1 == 1) {

                kol_kar(1);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 2) {

                kol_kar(2);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 3) {

                kol_kar(3);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 4) {

                kol_kar(4);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 5) {

                kol_kar(5);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 6) {

                kol_kar(6);

                por_1 = por_1 + 1;

                kor_finish();

            } else if (por_1 == 7) {

                kol_kar(7);

                kor_finish_end();

            }

        }

        FirebaseCrash.log("log 7");


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_stop_resume_sport:

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

                    click = MediaPlayer.create(Sport_me.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("23"));
                }


                if (btn_stop == 1) {

                    if (voice_check_1 == voice_off_check_1) {
                    } else {
                        if (language == fa) {
                            try {

                                music_puase = MediaPlayer.create(Sport_me.this, R.raw.workout_paused_fa);
                                music_puase.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("24"));
                            }


                        } else if (language == en) {
                            try {

                                music_puase = MediaPlayer.create(Sport_me.this, R.raw.workout_paused_en);
                                music_puase.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("25"));
                            }


                        } else if (language == de) {
                            try {

                                music_puase = MediaPlayer.create(Sport_me.this, R.raw.workout_paused_de);
                                music_puase.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("26"));
                            }


                        } else {
                            try {

                                music_puase = MediaPlayer.create(Sport_me.this, R.raw.workout_paused_en);
                                music_puase.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("27"));
                            }


                        }
                    }

                    btn_stop = 2;
                    try {

                        btn_stop_resume_sport.setImageResource(R.drawable.btn_volume_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("28"));
                    }


                    time_stop2 = 2;
                    time_stop = 5;
                    timeout = _splashTime60;
                    try {

                        handler.removeCallbacks(thread);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("29"));
                    }


                    if (music_check_1 == music_off_check_1) {
                    } else {
                        try {

                            Back_Music_Me.music.pause();

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("30"));
                        }


                    }

                } else if (btn_stop == 2) {

                    if (music_check_1 == music_off_check_1) {
                    } else {

                        if (seda == 1) {

                        } else {
                            try {

                                Back_Music_Me.music.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("31"));
                            }
                        }

                    }

                    if (voice_check_1 == voice_off_check_1) {
                    } else {
                        if (language == fa) {
                            try {

                                music_resumed = MediaPlayer.create(Sport_me.this, R.raw.workout_resumed_fa);
                                music_resumed.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("32"));
                            }


                        } else if (language == en) {
                            try {

                                music_resumed = MediaPlayer.create(Sport_me.this, R.raw.workout_resumed_en);
                                music_resumed.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("33"));
                            }


                        } else if (language == de) {
                            try {

                                music_resumed = MediaPlayer.create(Sport_me.this, R.raw.workout_resumed_de);
                                music_resumed.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("34"));
                            }


                        } else {
                            try {

                                music_resumed = MediaPlayer.create(Sport_me.this, R.raw.workout_resumed_en);
                                music_resumed.start();

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("35"));
                            }


                        }
                    }


                    btn_stop = 1;
                    time_stop = 1;
                    time_stop2 = 1;
                    try {

                        btn_stop_resume_sport.setImageResource(R.drawable.btn_stop_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("36"));
                    }

                    try {

                        handler.postDelayed(thread, _splashTime60 - timestart);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("37"));
                    }


                } else {

                }


                break;

            case R.id.btn_volume_sport:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("38"));
                }

                try {

                    click = MediaPlayer.create(Sport_me.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }


                if (volome_off == 1) {
                    volome_off = 2;

                    try {

                        btn_volume_sport.setImageResource(R.drawable.volume_off);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("40"));
                    }


                    try {

                        Back_Music_Me.music.pause();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("41"));
                    }

                    seda = 1;


                } else if (volome_off == 2) {
                    volome_off = 1;
                    try {

                        btn_volume_sport.setImageResource(R.drawable.volume_high);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("42"));
                    }


                    try {

                        Back_Music_Me.music.start();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("43"));
                    }


                    seda = 2;


                }


                break;

            case R.id.btn_sport_v_back:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }

                try {

                    click = MediaPlayer.create(Sport_me.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("45"));
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

                                    click = MediaPlayer.create(Sport_me.this, R.raw.button);
                                    if (music_check == music_off_check) {
                                        click.stop();
                                    } else {
                                        click.start();
                                    }

                                    handler.removeCallbacks(thread);
                                    stopService(new Intent(Sport_me.this, Back_Music_Me.class));
                                    Sport_me.this.finish();


                                }
                            })
                            .show();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("46"));
                    stopService(new Intent(Sport_me.this, Back_Music_Me.class));
                    Sport_me.this.finish();

                }


                break;

        }
    }


    public void kol_kar(int ghesmat) {


        if (now_harkat_1 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_1_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_1_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_1_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_1_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("47"));
            }

            now_harkat_1 = 0;

        } else if (now_harkat_2 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_2_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_2_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_2_3", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_2_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("48"));
            }
            now_harkat_2 = 0;

        } else if (now_harkat_3 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_3_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_3_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_3_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_3_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("49"));
            }
            now_harkat_3 = 0;

        } else if (now_harkat_4 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_4_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_4_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_4_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_4_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("50"));
            }
            now_harkat_4 = 0;

        } else if (now_harkat_5 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_5_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_5_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_5_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_5_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("51"));
            }
            now_harkat_5 = 0;

        } else if (now_harkat_6 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_6_2", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_6_1", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_6_3", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_6_1", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("52"));
            }
            now_harkat_6 = 0;

        } else if (now_harkat_7 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_7_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_7_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_7_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_7_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("53"));
            }
            now_harkat_7 = 0;

        } else if (now_harkat_8 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_8_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_8_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_8_3", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_8_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("54"));
            }
            now_harkat_8 = 0;

        } else if (now_harkat_9 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_9_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_9_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_9_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_9_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("55"));
            }
            now_harkat_9 = 0;

        } else if (now_harkat_10 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_10_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_10_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_10_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_10_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("56"));
            }
            now_harkat_10 = 0;

        } else if (now_harkat_11 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_11_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_11_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_11_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_11_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("57"));
            }
            now_harkat_11 = 0;

        } else if (now_harkat_12 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_12_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_12_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_12_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_12_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("58"));
            }
            now_harkat_12 = 0;

        } else if (now_harkat_13 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_13_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_13_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_13_3", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_13_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("59"));
            }
            now_harkat_13 = 0;

        } else if (now_harkat_14 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_14_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_14_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_14_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_14_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("60"));
            }
            now_harkat_14 = 0;

        } else if (now_harkat_15 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_15_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_15_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_15_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_15_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("61"));
            }
            now_harkat_15 = 0;

        } else if (now_harkat_16 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_16_2", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_16_1", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_16_3", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_16_1", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("62"));
            }
            now_harkat_16 = 0;

        } else if (now_harkat_17 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_17_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_17_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_17_3", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_17_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("63"));
            }
            now_harkat_17 = 0;

        } else if (now_harkat_18 != 0) {

            try {

                image_1 = getResources().getIdentifier("sport_18_1", "drawable", getPackageName());
                image_2 = getResources().getIdentifier("sport_18_2", "drawable", getPackageName());
                image_3 = getResources().getIdentifier("sport_18_1", "drawable", getPackageName());
                image_4 = getResources().getIdentifier("sport_18_2", "drawable", getPackageName());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("64"));
            }
            now_harkat_18 = 0;

        }

        if (mDialogDaemon != null) {
            mDialogDaemon.shutdown();
            mDialogDaemon = null;
        }
        mDialogDaemon = new ScheduledThreadPoolExecutor(1);
        // This process will execute immediately, then execute every 3 seconds.
        mDialogDaemon.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (time_stop == 1) {
                            time_stop = 2;

                            im_sports_1.setImageResource(image_1);

                        } else if (time_stop == 2) {
                            time_stop = 3;

                            im_sports_1.setImageResource(image_2);

                        } else if (time_stop == 3) {
                            time_stop = 4;

                            im_sports_1.setImageResource(image_3);

                        } else if (time_stop == 4) {
                            time_stop = 1;

                            im_sports_1.setImageResource(image_4);

                        }

                        // Do something worthwhile
                    }
                });
            }
        }, 0L, 1200L, TimeUnit.MILLISECONDS);


        FirebaseCrash.log("log 5");

    }


    public void kor_finish() {

        handler.postDelayed(thread = new Thread() {
            @Override
            public void run() {
                super.run();

                d = new Intent(Sport_me.this, Sport_me_relax.class);
                d.putExtra("now_harkat_1", now_harkat_1);
                d.putExtra("now_harkat_2", now_harkat_2);
                d.putExtra("now_harkat_3", now_harkat_3);
                d.putExtra("now_harkat_4", now_harkat_4);
                d.putExtra("now_harkat_5", now_harkat_5);
                d.putExtra("now_harkat_6", now_harkat_6);
                d.putExtra("now_harkat_7", now_harkat_7);
                d.putExtra("now_harkat_8", now_harkat_8);
                d.putExtra("now_harkat_9", now_harkat_9);
                d.putExtra("now_harkat_10", now_harkat_10);
                d.putExtra("now_harkat_11", now_harkat_11);
                d.putExtra("now_harkat_12", now_harkat_12);
                d.putExtra("now_harkat_13", now_harkat_13);
                d.putExtra("now_harkat_14", now_harkat_14);
                d.putExtra("now_harkat_15", now_harkat_15);
                d.putExtra("now_harkat_16", now_harkat_16);
                d.putExtra("now_harkat_17", now_harkat_17);
                d.putExtra("now_harkat_18", now_harkat_18);
                d.putExtra("tedad_kol", tedad_kol);
                d.putExtra("time", time_sport);
                d.putExtra("time_rest", time_rest);
                d.putExtra("sport_me_por", por_1);
                startActivity(d);

                handler.removeCallbacks(thread);
                stopService(new Intent(Sport_me.this, Back_Music_Me.class));
                Sport_me.this.finish();

            }
        }, _splashTime60);
        FirebaseCrash.log("log 4");
    }

    public void kor_finish_end() {

        handler.postDelayed(thread = new Thread() {
            @Override
            public void run() {
                super.run();

                if (language == fa) {

                    music_complate = MediaPlayer.create(Sport_me.this, R.raw.workout_completed_fa);
                    music_complate.start();

                } else if (language == en) {

                    music_complate = MediaPlayer.create(Sport_me.this, R.raw.workout_completed_en);
                    music_complate.start();

                } else if (language == de) {

                    music_complate = MediaPlayer.create(Sport_me.this, R.raw.workout_completed_de);
                    music_complate.start();

                } else {

                    music_complate = MediaPlayer.create(Sport_me.this, R.raw.workout_completed_en);
                    music_complate.start();

                }

            }
        }, (_splashTime60) - 2000);

        handler.postDelayed(thread = new Thread() {
            @Override
            public void run() {
                super.run();

                d = new Intent(Sport_me.this, Sport_me_end.class);
                startActivity(d);
                stopService(new Intent(Sport_me.this, Back_Music_Me.class));
                Sport_me.this.finish();

            }
        }, _splashTime60);
        FirebaseCrash.log("log 3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(thread);
        stopService(new Intent(Sport_me.this, Back_Music_Me.class));

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (btn_stop == 1) {

            btn_stop = 2;
            try {

                btn_stop_resume_sport.setImageResource(R.drawable.btn_volume_sport);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("66"));
            }


            time_stop2 = 2;
            time_stop = 5;
            timeout = _splashTime60;
            try {

                handler.removeCallbacks(thread);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("67"));
            }


            if (music_check_1 == music_off_check_1) {
            } else {
                try {

                    Back_Music_Me.music.pause();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("68"));
                }


            }

        }
        FirebaseCrash.log("log 2");
        System.gc();


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(Sport_me.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
            handler.removeCallbacks(thread);
            stopService(new Intent(Sport_me.this, Back_Music_Me.class));
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
                FirebaseCrash.report(new Exception("69"));
            }

            try {

                click = MediaPlayer.create(Sport_me.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("70"));
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

                                click = MediaPlayer.create(Sport_me.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                handler.removeCallbacks(thread);
                                stopService(new Intent(Sport_me.this, Back_Music_Me.class));
                                Sport_me.this.finish();
                            }
                        })
                        .show();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("71"));

                handler.removeCallbacks(thread);
                stopService(new Intent(Sport_me.this, Back_Music_Me.class));
                Sport_me.this.finish();

            }
            FirebaseCrash.log("log 1");
        }
        return false;
    }


}
