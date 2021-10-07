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
import android.preference.PreferenceManager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.android.fury.a30day.page.Page_2;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class sport_v extends Activity implements View.OnClickListener {

    private ScheduledThreadPoolExecutor mDialogDaemon, mDialogDaemon_time;

    TextView txt_sport_v_time, txt_sport_dj;

    ImageView btn_stop_resume_sport, btn_volume_sport, batery, btn_sport_v_back, im_sport_v_time_2, im_sport_v_time_3, im_sport_v_time_4, im_sport_v_time_5, im_sport_v_time_6, im_sport_v_time_7, im_sport_v_time_8, im_sport_v_time_9, im_sport_v_time_10, im_sport_v_time_11, im_sport_v_time_12, im_sport_v_time_hid, im_sport_v_time_hid2, im_sports_1;

    String time, music_check_1, music_off_check_1, voice_check_1, voice_off_check_1, music_check, music_off_check, vibre_check, language, fa, en, de;

    int s, a, sport_page, f, sport_page_set, time_stop, time_stop2, btn_stop, volome_off, por_1, timeout, timestart;

    int nuve_play;

    MyDatabaseHelper_music music_data;
    MyDatabaseHelper_voice voice_data;
    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    int time_1 = 1;
    int time_2 = 1;
    int time_3 = 1;
    int time_4 = 1;

    MediaPlayer music, click, music_go, music_complate, music_puase, music_resumed;

    Vibrator vb;

    Intent d;

    private final int _splashTime = 500;
    private final int _splashTime60 = 60000;
    private final int _splashTime_hp_1 = 1500;

    final Handler handler = new Handler();
    Thread thread;

    CardView card_view_hp;

    AudioManager audioManager;

    SharedPreferences sport_namber;

    SharedPreferences.Editor nameEditor_sport_namber;

    int help_play, seda;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MaterialTapTargetPrompt mFabPrompt, mFabPrompt2, mFabPrompt3, mFabPrompt4, mFabPrompt5, mFabPrompt6;

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

        FirebaseCrash.log("log 1");

        //start activ
        setContentView(R.layout.sport_v);

        try {
            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            help_play = one_play_preferences.getInt("Help_play_5", 1);
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }
        try {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }

        try {
            sport_namber = PreferenceManager.getDefaultSharedPreferences(this);
            nameEditor_sport_namber = sport_namber.edit();
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
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
            FirebaseCrash.report(new Exception("5"));
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
            FirebaseCrash.report(new Exception("6"));
        }


        fa = "fa";
        en = "en";
        de = "de";


        if (language == fa) {
            try {
                music_go = MediaPlayer.create(sport_v.this, R.raw.go_fa);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }
        } else if (language == en) {
            try {
                music_go = MediaPlayer.create(sport_v.this, R.raw.go_en);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("8"));
            }

        } else if (language == de) {
            try {
                music_go = MediaPlayer.create(sport_v.this, R.raw.go_de);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("9"));
            }
        } else {
            try {
                music_go = MediaPlayer.create(sport_v.this, R.raw.go_en);
                if (voice_check_1 == voice_off_check_1) {
                    music_go.stop();
                } else {
                    music_go.start();
                }
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("10"));
            }
        }

        final Bundle sport_v1 = getIntent().getExtras();

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

        volome_off = sport_v1.getInt("sport_v_volume1");


        try {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("11"));
        }

        timestart = 0;
        btn_stop = 1;
        time_stop = 1;
        time_stop2 = 1;
        s = 61;

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

                                }
                                s = a;
                            }
                            // Do something worthwhile
                        }
                    });
                }
            }, 0L, 1000L, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("14"));
        }
        // This process will execute immediately, then execute every 3 seconds.
        FirebaseCrash.log("log 2");


        por_1 = sport_v1.getInt("sport_v_por");
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
            FirebaseCrash.report(new Exception("22"));
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
            FirebaseCrash.report(new Exception("23"));
        }

        FirebaseCrash.log("log 3");

        sport_page = sport_v1.getInt("sport_v_number_day");
        sport_page_set = sport_v1.getInt("sport_v_number_day_set_1");

        if (sport_page == 1) {
            f = 1;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("24"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 1, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("25"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 2, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("26"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 3, 1, 3);

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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("27"));
                }

            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(5, 7, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("28"));
                }
            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 3, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("29"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();


                    end_sport_voise("sport_number_show_11", 11);
                    nameEditor_sport_namber.putInt("sport_number_show_set_1", 1);
                    nameEditor_sport_namber.apply();

                    music_online(2, 9, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("30"));
                }

            }


        } else if (sport_page == 2) {
            f = 2;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(1, 3);

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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);

                    card_start();


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("31"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 1, 3, 4);

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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("32"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(3, 4, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("33"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 3, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_4_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_4_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("34"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(1, 1, 1, 3);

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
                                        im_sports_1.setImageResource(R.drawable.sport_5_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_5_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("35"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 5, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("36"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_12", 12);

                    music_online(5, 7, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("37"));
                }

            }


        } else if (sport_page == 3) {
            f = 3;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_11_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_11_2);
                                    }

                                    // Do something worthwhile
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("38"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(3, 4, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(3, 14, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(4, 6, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("40"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);

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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("41"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 5, 4, 1);

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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("42"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_13", 13);

                    music_online(3, 4, 4, 1);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("43"));
                }

            }


        } else if (sport_page == 4) {
            f = 4;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }


            } else if (sport_page_set == 2) {

                try {

                    end_page();

                    music_online(5, 7, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_4_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_4_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("45"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);

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
                                        im_sports_1.setImageResource(R.drawable.sport_5_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_5_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("46"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 14, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("47"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(3, 5, 4, 1);

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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("48"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 1, 3, 4);

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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("49"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_14", 14);

                    music_online(3, 4, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_11_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_11_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("50"));
                }

            }


        } else if (sport_page == 5) {
            f = 5;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);

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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("51"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(3, 14, 3, 4);

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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("52"));
                }

            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("53"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 5, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("54"));
                }

            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(3, 4, 3, 4);

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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("55"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("56"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_15", 15);

                    music_online(1, 3, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("57"));
                }
            }


        } else if (sport_page == 6) {
            f = 6;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("58"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 14, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("59"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("60"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("61"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(4, 6, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("62"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(5, 7, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_4_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_4_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("63"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_16", 16);

                    music_online(1, 1, 2, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_5_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_5_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("64"));
                }

            }


        } else if (sport_page == 7) {
            f = 7;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("65"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 3, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("66"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(3, 4, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("67"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 5, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("68"));
                }


            } else if (sport_page_set == 5) {
                try {
                    end_page();

                    music_online(2, 9, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("69"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 1, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_11_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_11_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("70"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_17", 17);

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("71"));
                }


            }


        } else if (sport_page == 8) {
            f = 8;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);

                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("72"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(5, 7, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("73"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(3, 4, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("74"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_15_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_15_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("75"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(3, 5, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_11_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_11_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("76"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(4, 6, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("77"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_18", 18);

                    music_online(3, 14, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("78"));
                }

            }


        } else if (sport_page == 9) {
            f = 9;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("79"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 3, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("80"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 10, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("81"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_15_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_15_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("82"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("83"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 9, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("84"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_19", 19);

                    music_online(3, 5, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("85"));
                }

            }


        } else if (sport_page == 10) {
            f = 10;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("86"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 2, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("86"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("87"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_15_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_15_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("88"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(4, 6, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("89"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("90"));
                }

            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_21", 11);

                    nameEditor_sport_namber.putInt("sport_number_show_set_2", 1);
                    nameEditor_sport_namber.apply();

                    music_online(1, 3, 2, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_11_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_11_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("91"));
                }


            }


        } else if (sport_page == 11) {
            f = 11;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("92"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(3, 4, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("93"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(4, 6, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("94"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(5, 7, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("95"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 9, 2, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("96"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("97"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_22", 12);

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("98"));
                }

            }


        } else if (sport_page == 12) {
            f = 12;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("99"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_4_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_4_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("100"));
                }


            } else if (sport_page_set == 3) {

                end_page();

                music_online(1, 1, 1, 3);


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
                                    im_sports_1.setImageResource(R.drawable.sport_5_1);
                                } else if (time_stop == 2) {
                                    time_stop = 1;
                                    im_sports_1.setImageResource(R.drawable.sport_5_2);
                                }
                            }
                        });
                    }
                }, 0L, 1200L, TimeUnit.MILLISECONDS);


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 2, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("101"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(1, 3, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("102"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 4, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_11_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_11_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("103"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_23", 13);

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("104"));
                }
            }


        } else if (sport_page == 13) {
            f = 13;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);

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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("105"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(3, 5, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("106"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_12_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_12_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("107"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("108"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_4_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_4_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("109"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 1, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_5_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_5_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("110"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_24", 14);

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("111"));
                }

            }


        } else if (sport_page == 14) {
            f = 14;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);

                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("112"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 3, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("113"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 9, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("114"));
                }

            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 10, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("115"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_12_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_12_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("116"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_15_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_15_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("117"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_25", 15);

                    music_online(3, 14, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("118"));
                }
            }


        } else if (sport_page == 15) {
            f = 15;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("119"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("120"));
                }

            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 9, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("121"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(4, 6, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("122"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(3, 14, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("123"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 1, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_4_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_4_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("124"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_26", 16);

                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_5_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_5_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("125"));
                }

            }


        } else if (sport_page == 16) {
            f = 16;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);

                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("126"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("127"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(3, 5, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("128"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 10, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("129"));
                }

            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(3, 4, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_17_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_17_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("130"));
                }

            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_15_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_15_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("131"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_27", 17);

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("132"));
                }
            }


        } else if (sport_page == 17) {
            f = 17;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("133"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 3, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("134"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(4, 6, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("135"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 10, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("136"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_12_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_12_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("137"));
                }

            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("138"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_28", 18);

                    music_online(2, 12, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("139"));
                }
            }


        } else if (sport_page == 18) {
            f = 18;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("140"));
                }
            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 2, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("141"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 3, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("142"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("143"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(3, 5, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("144"));
                }

            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 14, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("145"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_29", 19);

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_10_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_10_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("146"));
                }
            }


        } else if (sport_page == 19) {
            f = 19;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("147"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 1, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("148"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 10, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("149"));
                }

            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(4, 6, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("150"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 11, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_10_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_10_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("151"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 14, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("152"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_20", 20);

                    music_online(5, 7, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("153"));
                }
            }


        } else if (sport_page == 20) {
            f = 20;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("154"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("155"));
                }

            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 1, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("156"));
                }

            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 2, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("157"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(1, 10, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_10_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_10_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("158"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 11, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("159"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_301", 21);

                    nameEditor_sport_namber.putInt("sport_number_show_set_3", 1);
                    nameEditor_sport_namber.apply();

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_12_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_12_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("160"));
                }
            }


        } else if (sport_page == 21) {
            f = 21;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("161"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(5, 7, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_3_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_3_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("162"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(4, 6, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("163"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 4, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("164"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 10, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("165"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 11, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("166"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_32", 12);

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("167"));
                }
            }


        } else if (sport_page == 22) {
            f = 22;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("168"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("169"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 12, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("170"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 3, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("171"));
                }

            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(1, 2, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_10_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_10_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("172"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 14, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("173"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_33", 13);

                    music_online(2, 13, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_12_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_12_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("174"));
                }
            }


        } else if (sport_page == 23) {
            f = 23;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("175"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("176"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 10, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("177"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_2_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_2_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("178"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(1, 1, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("179"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 14, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_9_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_9_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("180"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_34", 14);

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_12_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_12_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("181"));
                }
            }

        } else if (sport_page == 24) {
            f = 24;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("182"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 11, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("183"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_2_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_2_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("184"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 5, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("185"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(1, 3, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("186"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(1, 10, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_10_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_10_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("187"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_35", 15);

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("188"));
                }
            }


        } else if (sport_page == 25) {
            f = 25;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("189"));
                }

            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_2_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_2_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("190"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("191"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 14, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("192"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 12, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_10_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_10_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("193"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("194"));
                }

            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_36", 16);

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("195"));
                }
            }


        } else if (sport_page == 26) {
            f = 26;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("196"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(2, 11, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("197"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_16_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_16_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("198"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 5, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("199"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 12, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_17_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_17_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("200"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 11, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("201"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_37", 17);

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("202"));
                }
            }


        } else if (sport_page == 27) {
            f = 27;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("203"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 1, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("204"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(1, 2, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_2_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_2_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_2_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("205"));
                }

            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 3, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("206"));
                }

            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_16_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_16_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("207"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(3, 14, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_17_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_17_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("208"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_38", 18);

                    music_online(2, 12, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("209"));
                }
            }


        } else if (sport_page == 28) {
            f = 28;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("210"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(1, 10, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("211"));
                }

            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_16_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_16_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("212"));
                }

            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(3, 14, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_8_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_8_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_8_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("213"));
                }

            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("214"));
                }

            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 12, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("215"));
                }

            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_39", 19);

                    music_online(3, 5, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("216"));
                }
            }


        } else if (sport_page == 29) {
            f = 29;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("217"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(3, 4, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_14_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_14_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("218"));
                }


            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 12, 2, 2);

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
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_16_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_16_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("219"));
                }

            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(2, 1, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("220"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 13, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("221"));
                }


            } else if (sport_page_set == 6) {
                try {
                    end_page();

                    music_online(3, 14, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("222"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_30", 20);


                    music_online(5, 7, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("223"));
                }
            }


        } else if (sport_page == 30) {
            f = 30;
            if (sport_page_set == 1) {
                try {

                    end_page();

                    music_offline(4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_13_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_13_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_13_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);


                    card_start();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("224"));
                }


            } else if (sport_page_set == 2) {
                try {

                    end_page();

                    music_online(3, 5, 1, 3);


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
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_6_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_6_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_6_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("225"));
                }

            } else if (sport_page_set == 3) {
                try {

                    end_page();

                    music_online(2, 9, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_1_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_1_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("226"));
                }


            } else if (sport_page_set == 4) {
                try {

                    end_page();

                    music_online(1, 10, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_7_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_7_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("227"));
                }


            } else if (sport_page_set == 5) {
                try {

                    end_page();

                    music_online(2, 11, 4, 1);


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
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_16_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_16_1);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_16_3);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("228"));
                }


            } else if (sport_page_set == 6) {
                try {

                    end_page();

                    music_online(2, 12, 2, 2);


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
                                        im_sports_1.setImageResource(R.drawable.sport_18_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_18_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("229"));
                }


            } else if (sport_page_set == 7) {
                try {

                    end_page_sport();

                    end_sport_voise("sport_number_show_40", 30);

                    music_online(2, 13, 3, 4);


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
                                        im_sports_1.setImageResource(R.drawable.sport_17_1);
                                    } else if (time_stop == 2) {
                                        time_stop = 3;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    } else if (time_stop == 3) {
                                        time_stop = 4;
                                        im_sports_1.setImageResource(R.drawable.sport_17_3);
                                    } else if (time_stop == 4) {
                                        time_stop = 1;
                                        im_sports_1.setImageResource(R.drawable.sport_17_2);
                                    }
                                }
                            });
                        }
                    }, 0L, 1200L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("230"));
                }
            }

        }

        FirebaseCrash.log("log 4");


        if (help_play == 1) {
            final String s1 = (String) getText(R.string.Help_start_8_1);
            final String s11 = (String) getText(R.string.Help_start_9_1);
            final String s22 = (String) getText(R.string.Help_start_9_2);
            final String s111 = (String) getText(R.string.Help_start_10_1);
            final String s222 = (String) getText(R.string.Help_start_10_2);
            final String s11111 = (String) getText(R.string.Help_start_12_1);
            final String s22222 = (String) getText(R.string.Help_start_12_2);
            final String s111111 = (String) getText(R.string.Help_start_13_1);
            final String s222222 = (String) getText(R.string.Help_start_13_2);
            final String s1111 = (String) getText(R.string.Help_start_11_1);
            final String s2222 = (String) getText(R.string.Help_start_11_2);

            final LinearLayout cv_al_1 = (LinearLayout) findViewById(R.id.cv_al_1);

            mFabPrompt = new MaterialTapTargetPrompt.Builder(sport_v.this)
                    .setTarget(txt_sport_v_time)
                    .setPrimaryText(s1)
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


            mFabPrompt2 = new MaterialTapTargetPrompt.Builder(sport_v.this)
                    .setTarget(cv_al_1)
                    .setPrimaryText(s11)
                    .setSecondaryText(s22)
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


            try {


                mFabPrompt3 = new MaterialTapTargetPrompt.Builder(sport_v.this)
                        .setTarget(btn_volume_sport)
                        .setPrimaryText(s111)
                        .setSecondaryText(s222)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                mFabPrompt3 = null;
                                time_3 = 2;
                                mFabPrompt4 = new MaterialTapTargetPrompt.Builder(sport_v.this)
                                        .setTarget(im_sports_1)
                                        .setPrimaryText(s1111)
                                        .setSecondaryText(s2222)
                                        .setBackgroundColourFromRes(R.color.color30day)
                                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                                            @Override
                                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                                //Do something such as storing a value so that this prompt is never shown again
                                                mFabPrompt4 = null;
                                                time_4 = 2;
                                                mFabPrompt5 = new MaterialTapTargetPrompt.Builder(sport_v.this)
                                                        .setTarget(btn_stop_resume_sport)
                                                        .setPrimaryText(s11111)
                                                        .setSecondaryText(s22222)
                                                        .setBackgroundColourFromRes(R.color.color30day)
                                                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                                                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                                                            @Override
                                                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                                                //Do something such as storing a value so that this prompt is never shown again
                                                                mFabPrompt5 = null;
                                                                time_1 = 2;
                                                                mFabPrompt6 = new MaterialTapTargetPrompt.Builder(sport_v.this)
                                                                        .setTarget(btn_sport_v_back)
                                                                        .setPrimaryText(s111111)
                                                                        .setSecondaryText(s222222)
                                                                        .setBackgroundColourFromRes(R.color.color30day)
                                                                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                                                                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                                                                            @Override
                                                                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                                                                //Do something such as storing a value so that this prompt is never shown again
                                                                                mFabPrompt6 = null;
                                                                            }

                                                                            @Override
                                                                            public void onHidePromptComplete() {
                                                                            }
                                                                        })
                                                                        .show();
                                                            }

                                                            @Override
                                                            public void onHidePromptComplete() {
                                                            }
                                                        })
                                                        .show();
                                            }

                                            @Override
                                            public void onHidePromptComplete() {
                                            }
                                        })
                                        .show();
                            }

                            @Override
                            public void onHidePromptComplete() {
                            }
                        })
                        .create();
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("238"));

                one_play_editor.putInt("Help_play_5", 3);
                one_play_editor.apply();

                mFabPrompt = null;
                mFabPrompt2 = null;
                mFabPrompt3 = null;
                mFabPrompt4 = null;
                mFabPrompt5 = null;
                mFabPrompt6 = null;

            }


        }

        FirebaseCrash.log("log 5");
        System.gc();

    }


    public void card_start() {

        try {
            if (audioManager.isWiredHeadsetOn()) {
            } else {
                new Handler().postDelayed(new Thread() {

                    @Override
                    public void run() {
                        super.run();
                        new Handler().postDelayed(new Thread() {

                            @Override
                            public void run() {
                                super.run();
                                card_view_hp.setVisibility(View.VISIBLE);
                                card_view_hp.setAnimation(AnimationUtils.loadAnimation(sport_v.this, R.anim.in));
                                new Handler().postDelayed(new Thread() {

                                    @Override
                                    public void run() {
                                        super.run();
                                        new Handler().postDelayed(new Thread() {

                                            @Override
                                            public void run() {
                                                super.run();
                                                card_view_hp.setAnimation(AnimationUtils.loadAnimation(sport_v.this, R.anim.out));
                                                card_view_hp.setVisibility(View.INVISIBLE);
                                            }
                                        }, _splashTime_hp_1);
                                    }
                                }, _splashTime_hp_1);
                            }
                        }, _splashTime_hp_1);
                    }
                }, _splashTime_hp_1);
            }
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("card_start"));
        }

    }


    public void end_sport_voise(final String key, final int namber) {

        try {

            handler.postDelayed(thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    if (language == fa) {
                        music_complate = MediaPlayer.create(sport_v.this, R.raw.workout_completed_fa);
                        music_complate.start();
                    } else if (language == en) {
                        music_complate = MediaPlayer.create(sport_v.this, R.raw.workout_completed_en);
                        music_complate.start();
                    } else if (language == de) {
                        music_complate = MediaPlayer.create(sport_v.this, R.raw.workout_completed_de);
                        music_complate.start();
                    } else {
                        music_complate = MediaPlayer.create(sport_v.this, R.raw.workout_completed_en);
                        music_complate.start();
                    }
                    nameEditor_sport_namber.putInt(key, namber);
                    nameEditor_sport_namber.commit();
                }
            }, 58000);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("voise_end"));
        }
    }


    public void end_page() {

        try {
            handler.postDelayed(thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    d = new Intent(sport_v.this, sport_relax.class);
                    d.putExtra("sport_v_number_day_r", sport_page);
                    d.putExtra("sport_v_number_day_set_1_r", sport_page_set);
                    d.putExtra("sport_v_volome", volome_off);
                    d.putExtra("sport_v_por1", por_1);
                    startActivity(d);
                    stopService(new Intent(sport_v.this, Back_Music_Online.class));
                    stopService(new Intent(sport_v.this, Back_Music.class));
                    sport_v.this.finish();
                }
            }, _splashTime60);
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("voise_end"));
        }

    }


    public void end_page_sport() {

        try {

            handler.postDelayed(thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    d = new Intent(sport_v.this, sport_end.class);
                    d.putExtra("sport_v_number_day_r", sport_page);
                    startActivity(d);
                    if (nuve_play == 1){
                        stopService(new Intent(sport_v.this, Back_Music.class));
                    }else if (nuve_play == 2){
                        stopService(new Intent(sport_v.this, Back_Music_Online.class));
                    }
                    sport_v.this.finish();
                }
            }, _splashTime60);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("voise_end"));
        }
    }

    public void music_offline(int n, int m) {

        if (n == 1) {
            try {
                txt_sport_dj.setText(R.string.sport_dj1_offline);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("music offline text dj 1"));
            }
        } else if (n == 2) {
            try {
                txt_sport_dj.setText(R.string.sport_dj2_offline);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("music offline text dj 2"));
            }
        } else if (n == 3) {
            try {
                txt_sport_dj.setText(R.string.sport_dj3_offline);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("music offline text dj 3"));
            }
        } else if (n == 4) {
            try {
                txt_sport_dj.setText(R.string.sport_dj2);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("music offline text dj 4"));
            }
        } else if (n == 5) {
            try {
                txt_sport_dj.setText(R.string.sport_dj5);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("music offline text dj 5"));
            }
        }

        nuve_play = 1;
        one_play_editor.putInt("nov_music_offline", m);
        one_play_editor.putString("music_check_offline", music_check_1);
        one_play_editor.putString("music_off_check_offline", music_off_check_1);
        one_play_editor.commit();

        startService(new Intent(this, Back_Music.class));

    }



    public void music_online(int n, int m, int nn, int mm) {
        if (music_check_1 == music_off_check_1) {
        } else {
            if (app_net.getInstance(this).isOnline()) {
                if (n == 1) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj1);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music online text dj 1"));
                    }
                } else if (n == 2) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj2);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music online text dj 2"));
                    }
                } else if (n == 3) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj3);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music online text dj 3"));
                    }
                } else if (n == 4) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj4);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music online text dj 4"));
                    }
                } else if (n == 5) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj5);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music online text dj 5"));
                    }
                }

                nuve_play = 2;
                one_play_editor.putInt("nov_music_offline", m);
                one_play_editor.putInt("nov_music_online", 1);
                one_play_editor.putString("music_check_offline", music_check_1);
                one_play_editor.putString("music_off_check_offline", music_off_check_1);
                one_play_editor.commit();

                startService(new Intent(this, Back_Music_Online.class));

            } else {
                if (nn == 1) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj1_offline);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music offline_online text dj 1"));
                    }
                } else if (nn == 2) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj2_offline);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music offline_online text dj 2"));
                    }
                } else if (nn == 3) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj3_offline);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music offline_online text dj 3"));
                    }
                } else if (nn == 4) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj2);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music offline_online text dj 4"));
                    }
                } else if (nn == 5) {
                    try {
                        txt_sport_dj.setText(R.string.sport_dj5);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("music offline_online text dj 5"));
                    }
                }

                nuve_play = 2;
                one_play_editor.putInt("nov_music_online_mm", mm);
                one_play_editor.putInt("nov_music_online", 2);
                one_play_editor.putString("music_check_offline", music_check_1);
                one_play_editor.putString("music_off_check_offline", music_off_check_1);
                one_play_editor.commit();

                startService(new Intent(this, Back_Music_Online.class));

            }
        }
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
                    FirebaseCrash.report(new Exception("239"));
                }

                try {
                    click = MediaPlayer.create(sport_v.this, R.raw.button);
                    click.prepare();
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("240"));
                }


                if (btn_stop == 1) {
                    if (voice_check_1 == voice_off_check_1) {
                    } else {
                        if (language == fa) {
                            try {
                                music_puase = MediaPlayer.create(sport_v.this, R.raw.workout_paused_fa);
                                music_puase.prepare();
                                music_puase.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("241"));
                            }
                        } else if (language == en) {
                            try {
                                music_puase = MediaPlayer.create(sport_v.this, R.raw.workout_paused_en);
                                music_puase.prepare();
                                music_puase.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("242"));
                            }
                        } else if (language == de) {
                            try {
                                music_puase = MediaPlayer.create(sport_v.this, R.raw.workout_paused_de);
                                music_puase.prepare();
                                music_puase.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("243"));
                            }
                        } else {
                            try {
                                music_puase = MediaPlayer.create(sport_v.this, R.raw.workout_paused_en);
                                music_puase.prepare();
                                music_puase.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("244"));
                            }
                        }
                    }
                    btn_stop = 2;
                    try {
                        btn_stop_resume_sport.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("245"));
                    }

                    time_stop2 = 2;
                    time_stop = 5;
                    timeout = _splashTime60;
                    try {
                        handler.removeCallbacks(thread);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("246"));
                    }

                    if (music_check_1 == music_off_check_1) {
                    } else {
                        try {
                            if (nuve_play == 1){
                                Back_Music.music.pause();
                            }else if (nuve_play == 2){
                                Back_Music_Online.music.pause();
                            }
                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("247"));
                        }
                    }

                } else if (btn_stop == 2) {

                    if (music_check_1 == music_off_check_1) {
                    } else {
                        if (seda == 1) {
                        } else {
                            try {
                                if (nuve_play == 1){
                                    Back_Music.music.start();
                                }else if (nuve_play == 2){
                                    Back_Music_Online.music.start();
                                }
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("248"));
                            }
                        }
                    }

                    if (voice_check_1 == voice_off_check_1) {
                    } else {
                        if (language == fa) {
                            try {
                                music_resumed = MediaPlayer.create(sport_v.this, R.raw.workout_resumed_fa);
                                music_resumed.prepare();
                                music_resumed.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("249"));
                            }

                        } else if (language == en) {
                            try {
                                music_resumed = MediaPlayer.create(sport_v.this, R.raw.workout_resumed_en);
                                music_resumed.prepare();
                                music_resumed.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("250"));
                            }

                        } else if (language == de) {
                            try {
                                music_resumed = MediaPlayer.create(sport_v.this, R.raw.workout_resumed_de);
                                music_resumed.prepare();
                                music_resumed.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("251"));
                            }

                        } else {
                            try {
                                music_resumed = MediaPlayer.create(sport_v.this, R.raw.workout_resumed_en);
                                music_resumed.prepare();
                                music_resumed.start();
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("252"));
                            }
                        }
                    }

                    btn_stop = 1;
                    time_stop = 1;
                    time_stop2 = 1;
                    try {
                        btn_stop_resume_sport.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("253"));
                    }
                    try {
                        handler.postDelayed(thread, 60000 - timestart);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("254"));
                    }

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
                    FirebaseCrash.report(new Exception("255"));
                }
                try {
                    click = MediaPlayer.create(sport_v.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("256"));
                }

                if (volome_off == 1) {
                    volome_off = 2;

                    try {
                        btn_volume_sport.setImageResource(R.drawable.volume_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("257"));
                    }

                    try {
                        if (nuve_play == 1){
                            Back_Music.music.pause();
                        }else if (nuve_play == 2){
                            Back_Music_Online.music.pause();
                        }
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("258"));
                    }

                    seda = 1;

                } else if (volome_off == 2) {
                    volome_off = 1;
                    try {
                        btn_volume_sport.setImageResource(R.drawable.volume_high);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("259"));
                    }

                    try {
                        if (nuve_play == 1){
                            Back_Music.music.start();
                        }else if (nuve_play == 2){
                            Back_Music_Online.music.start();
                        }
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("260"));
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
                    FirebaseCrash.report(new Exception("261"));
                }

                try {
                    click = MediaPlayer.create(sport_v.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("262"));
                }

                if (help_play == 1) {
                    try {
                        mFabPrompt6 = null;
                        one_play_editor.putInt("Help_play_5", 3);
                        one_play_editor.commit();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("263"));
                        one_play_editor.putInt("Help_play_5", 3);
                        one_play_editor.commit();
                    }
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

                                    click = MediaPlayer.create(sport_v.this, R.raw.button);
                                    if (music_check == music_off_check) {
                                        click.stop();
                                    } else {
                                        click.start();
                                    }

                                    handler.removeCallbacks(thread);

                                    if (help_play == 1) {

                                        Intent ss = new Intent(sport_v.this, Page_2.class);
                                        startActivity(ss);
                                        if (nuve_play == 1){
                                            stopService(new Intent(sport_v.this, Back_Music.class));
                                        }else if (nuve_play == 2){
                                            stopService(new Intent(sport_v.this, Back_Music_Online.class));
                                        }
                                        sport_v.this.finish();

                                    } else {
                                        if (nuve_play == 1){
                                        stopService(new Intent(sport_v.this, Back_Music.class));
                                    }else if (nuve_play == 2){
                                            stopService(new Intent(sport_v.this, Back_Music_Online.class));
                                    }
                                        sport_v.this.finish();
                                    }
                                }
                            })
                            .show();

                } catch (Exception e) {
                    handler.removeCallbacks(thread);

                    if (help_play == 1) {

                        Intent ss = new Intent(sport_v.this, Page_2.class);
                        startActivity(ss);
                        if (nuve_play == 1){
                            stopService(new Intent(sport_v.this, Back_Music.class));
                        }else if (nuve_play == 2){
                            stopService(new Intent(sport_v.this, Back_Music_Online.class));
                        }
                        sport_v.this.finish();

                    } else {
                        if (nuve_play == 1){
                            stopService(new Intent(sport_v.this, Back_Music.class));
                        }else if (nuve_play == 2){
                            stopService(new Intent(sport_v.this, Back_Music_Online.class));
                        }
                        sport_v.this.finish();
                    }
                    FirebaseCrash.report(new Exception("alert 2"));
                }

                break;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        if (btn_stop == 1) {

            btn_stop = 2;
            try {
                btn_stop_resume_sport.setImageResource(R.drawable.btn_volume_sport);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("265"));
            }

            time_stop2 = 2;
            time_stop = 5;
            timeout = _splashTime60;
            try {
                handler.removeCallbacks(thread);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("266"));
            }

            if (music_check_1 == music_off_check_1) {
            } else {
                try {
                    if (nuve_play == 1){
                        Back_Music.music.pause();
                    }else if (nuve_play == 2){
                        Back_Music_Online.music.pause();
                    }
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("267"));
                }
            }
        }
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(thread);
        if (nuve_play == 1){
            stopService(new Intent(sport_v.this, Back_Music.class));
        }else if (nuve_play == 2){
            stopService(new Intent(sport_v.this, Back_Music_Online.class));
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(sport_v.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
            handler.removeCallbacks(thread);
            if (nuve_play == 1){
                stopService(new Intent(sport_v.this, Back_Music.class));
            }else if (nuve_play == 2){
                stopService(new Intent(sport_v.this, Back_Music_Online.class));
            }
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
                FirebaseCrash.report(new Exception("268"));
            }

            try {
                click = MediaPlayer.create(sport_v.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("269"));
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

                                click = MediaPlayer.create(sport_v.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                handler.removeCallbacks(thread);
                                if (nuve_play == 1){
                                    stopService(new Intent(sport_v.this, Back_Music.class));
                                }else if (nuve_play == 2){
                                    stopService(new Intent(sport_v.this, Back_Music_Online.class));
                                }
                                sport_v.this.finish();
                            }
                        })
                        .show();

            } catch (Exception e) {
                handler.removeCallbacks(thread);
                if (nuve_play == 1){
                    stopService(new Intent(sport_v.this, Back_Music.class));
                }else if (nuve_play == 2){
                    stopService(new Intent(sport_v.this, Back_Music_Online.class));
                }
                FirebaseCrash.report(new Exception("alert 1"));
                sport_v.this.finish();
            }


        }
        return false;
    }

}
