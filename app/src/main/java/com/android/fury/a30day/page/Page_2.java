package com.android.fury.a30day.page;

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
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.fury.a30day.App;
import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Not_net;
import com.android.fury.a30day.R;
import com.android.fury.a30day.Suport.Suport_me;
import com.android.fury.a30day.alarm.nahar.NotificationEventReceiver3;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.android.fury.a30day.food.food;
import com.android.fury.a30day.sport.sport;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Created by ehsan on 8/2/2016.
 */
public class Page_2 extends Activity implements View.OnClickListener {


    private final int _splashTime = 1000;
    private final int _splashTime2 = 500;

    DrawerLayout drawerlayout;

    public static Activity fa;

    ImageView btn_back_page2, btn_menu;

    Button start_sport, start_food;

    MediaPlayer click;

    LinearLayout sports, diet, dmusic, settings, about, help, exit;

    String menu_exit, about_alertdialog_6, about_alertdialog_7, about_alertdialog_8, about_alertdialog_9, no, yes, music_check, music_off_check, vibre_check, fars, en, de, ca, am, ch, language1;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    int help_play, zaban;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MaterialTapTargetPrompt mFabPrompt;

    MyDatabaseHelper_lan language;

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
        setContentView(R.layout.root_page_2);


        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            help_play = one_play_preferences.getInt("Help_play_2", 1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        fa = this;


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
            FirebaseCrash.report(new Exception("3"));
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
            FirebaseCrash.report(new Exception("4"));
        }


        //az bein bordn shekle scrollview
        ScrollView sView = (ScrollView) findViewById(R.id.scrollview_1);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        btn_menu = (ImageView) findViewById(R.id.btn_menu);
        about = (LinearLayout) findViewById(R.id.lin_menu_ab);
        diet = (LinearLayout) findViewById(R.id.lin_menu_d);
        dmusic = (LinearLayout) findViewById(R.id.lin_menu_dm);
        exit = (LinearLayout) findViewById(R.id.lin_menu_ex);
        settings = (LinearLayout) findViewById(R.id.lin_menu_sit);
        sports = (LinearLayout) findViewById(R.id.lin_menu_sp);
        help = (LinearLayout) findViewById(R.id.lin_menu_gu);
        btn_back_page2 = (ImageView) findViewById(R.id.btn_back_page2);
        start_sport = (Button) findViewById(R.id.sport_start);
        start_food = (Button) findViewById(R.id.im_001);

        btn_menu.setOnClickListener(this);
        about.setOnClickListener(this);
        dmusic.setOnClickListener(this);
        diet.setOnClickListener(this);
        sports.setOnClickListener(this);
        settings.setOnClickListener(this);
        exit.setOnClickListener(this);
        help.setOnClickListener(this);
        btn_back_page2.setOnClickListener(this);
        start_sport.setOnClickListener(this);
        start_food.setOnClickListener(this);

        //sliding view
        drawerlayout = (DrawerLayout) findViewById(R.id.root_page_1);

        menu_exit = (String) getText(R.string.menu_exit2);
        no = (String) getText(R.string.no);
        yes = (String) getText(R.string.yes);
        about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
        about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);

        fars = "fa";
        en = "en";
        de = "de";
        ca = "en";
        am = "en";
        ch = "zh";
        if (language1 == fars) {
            zaban = 1;

            type3 = Typeface.createFromAsset(getAssets(), "fa_font_1.ttf");

            start_sport.setTypeface(type3);
            start_food.setTypeface(type3);

        } else if (language1 == en) {
            zaban = 2;

            type3 = Typeface.createFromAsset(getAssets(), "en_font_1.otf");

            start_sport.setTypeface(type3);
            start_food.setTypeface(type3);

        } else if (language1 == de) {
            zaban = 3;

            type3 = Typeface.createFromAsset(getAssets(), "en_font_1.otf");

            start_sport.setTypeface(type3);
            start_food.setTypeface(type3);

        } else if (language1 == ca) {
            zaban = 2;

            type3 = Typeface.createFromAsset(getAssets(), "en_font_1.otf");

            start_sport.setTypeface(type3);
            start_food.setTypeface(type3);

        } else if (language1 == am) {
            zaban = 2;

            type3 = Typeface.createFromAsset(getAssets(), "en_font_1.otf");

            start_sport.setTypeface(type3);
            start_food.setTypeface(type3);

        } else if (language1 == ch) {
            zaban = 4;

        }


        if (help_play == 1) {

            String s1 = (String) getText(R.string.Help_start_2_1);
            String s2 = (String) getText(R.string.Help_start_2_2);

            try {

                mFabPrompt = new MaterialTapTargetPrompt.Builder(Page_2.this)
                        .setTarget(start_sport)
                        .setPrimaryText(s1)
                        .setSecondaryText(s2)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt = null;
                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .show();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("5"));
            }


        } else if (help_play == 2) {

            String s11 = (String) getText(R.string.Help_start_14_1);
            String s22 = (String) getText(R.string.Help_start_14_2);

            try {


                mFabPrompt = new MaterialTapTargetPrompt.Builder(Page_2.this)
                        .setTarget(start_food)
                        .setPrimaryText(s11)
                        .setSecondaryText(s22)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                mFabPrompt = null;

                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .show();


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }


        }
        FirebaseCrash.log("log 5");
        System.gc();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("8"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("9"));
                }

                try {

                    if (drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerlayout.closeDrawer(Gravity.LEFT);
                    } else {
                        drawerlayout.openDrawer(Gravity.LEFT);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("10"));
                }

                break;

            case R.id.btn_back_page2:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("12"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent back_page = new Intent(Page_2.this, Page_1.class);
                            Page_2.this.startActivity(back_page);
                            finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("13"));
                }

                break;

            case R.id.lin_menu_ex:

                try {

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

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }

                try {
                    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText(about_alertdialog_7)
                            .setContentText(about_alertdialog_6)
                            .setCancelText(no)
                            .setConfirmText(yes)
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

                                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                                    if (music_check == music_off_check) {
                                        click.stop();
                                    } else {
                                        click.start();
                                    }

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
                    FirebaseCrash.report(new Exception("16"));
                }

                break;


            case R.id.lin_menu_ab:

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

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_1 = new Intent(Page_2.this, com.android.fury.a30day.menu_view.about.class);
                            about_1.putExtra("about_back", 3);
                            Page_2.this.startActivity(about_1);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("19"));
                }

                break;


            case R.id.lin_menu_sit:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("20"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("21"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_2 = new Intent(Page_2.this, com.android.fury.a30day.menu_view.setting.class);
                            about_2.putExtra("setting_back", 2);
                            Page_2.this.startActivity(about_2);
                            Page_2.this.finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("22"));
                }

                break;


            case R.id.lin_menu_gu:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("23"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("24"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent suport = new Intent(Page_2.this, Suport_me.class);
                            startActivity(suport);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("start support"));
                }
                break;

            case R.id.lin_menu_dm:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("40"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            if (app_net.getInstance(Page_2.this).isOnline()) {

                                Intent music = new Intent(Page_2.this, com.android.fury.a30day.menu_view.music.class);
                                music.putExtra("d_m_b", 1);
                                Page_2.this.startActivity(music);

                            } else {

                                Intent music_not = new Intent(Page_2.this, Not_net.class);
                                music_not.putExtra("d_m_b", 1);
                                Page_2.this.startActivity(music_not);

                            }
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("41"));
                }

                break;

            case R.id.lin_menu_sp:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("42"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("43"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent sport_menu = new Intent(Page_2.this, sport.class);
                            sport_menu.putExtra("sport_back", 3);
                            Page_2.this.startActivity(sport_menu);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }


                break;

            case R.id.sport_start:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("45"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("46"));
                }


                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();

                            Intent sport_menu = new Intent(Page_2.this, sport.class);
                            sport_menu.putExtra("sport_back", 3);
                            Page_2.this.startActivity(sport_menu);

                            if (help_play == 1) {
                                one_play_editor.putInt("Help_play_2", 2);
                                one_play_editor.commit();
                                Page_2.this.finish();

                            }

                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("47"));
                }


                break;

            case R.id.im_001:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("48"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("49"));
                }

                try {

                    one_play_editor.putInt("Help_play_2", 3);
                    one_play_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("50"));
                }


                new Handler().postDelayed(new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        Intent sport_menu = new Intent(Page_2.this, food.class);
                        sport_menu.putExtra("zaban_fo", zaban);
                        Page_2.this.startActivity(sport_menu);
                    }
                }, _splashTime2);


                break;

            case R.id.lin_menu_d:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("52"));
                }

                try {

                    click = MediaPlayer.create(Page_2.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("53"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent food_ = new Intent(Page_2.this, food.class);
                            food_.putExtra("zaban_fo", zaban);
                            Page_2.this.startActivity(food_);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("54"));
                    Intent food_ = new Intent(Page_2.this, food.class);
                    food_.putExtra("zaban_fo", zaban);
                    Page_2.this.startActivity(food_);
                }

                break;
        }
        FirebaseCrash.log("log 4");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(Page_2.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("55"));
            }

            try {

                click = MediaPlayer.create(Page_2.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("56"));
            }

            Intent back_page = new Intent(Page_2.this, Page_1.class);
            Page_2.this.startActivity(back_page);
            finish();
            FirebaseCrash.log("log 3");
        }
        return false;
    }


    @Override
    protected void onStart() {
        super.onStart();

        App.activity_page_2 = this;
        FirebaseCrash.log("log 2");
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        App.activity_page_2 = null;
        FirebaseCrash.log("log 1");
        System.gc();
    }


}
