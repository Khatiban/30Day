package com.android.fury.a30day.food;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
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
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.android.fury.a30day.sport.sport;
import com.astuetz.PagerSlidingTabStrip;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by ehsan on 8/2/2016.
 */
public class food_page_org extends AppCompatActivity implements View.OnClickListener {


    private final int _splashTime = 1000;
    private final int _splashTime2 = 500;

    ImageView btn_back_page2, btn_menu;

    DrawerLayout drawerlayout;

    public static Activity fa;

    MediaPlayer click;

    LinearLayout sports, diet, dmusic, settings, about, help, exit;

    String menu_exit, about_alertdialog_6, about_alertdialog_7, no, yes, music_check, music_off_check, vibre_check, fars, en, de, ca, am, ch;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    public static String d, c, language;
    public static int zaban;

    public static Resources resources;

    MyDatabaseHelper_lan language1;

    private boolean CHECKED_STATE_5;

    private SharedPreferences food_preferences;
    private SharedPreferences.Editor food_editor;

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

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("fa");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language = "fa";

            } else if (dadeha.toString().length() == 2) {
                //english.usa.canada

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("en");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language = "en";

            } else if (dadeha.toString().length() == 3) {
                //chine

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("zh");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language = "zh";

            } else if (dadeha.toString().length() == 6) {
                //german

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("de");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language = "de";

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }


        //start activ
        setContentView(R.layout.root_food_page_org);

        d = (String) getText(R.string.det);
        c = (String) getText(R.string.cal_f);


        fars = "fa";
        en = "en";
        de = "de";
        ca = "en";
        am = "en";
        ch = "zh";
        if (language == fars) {
            zaban = 1;
        } else if (language == en) {
            zaban = 2;
        } else if (language == de) {
            zaban = 3;
        } else if (language == ca) {
            zaban = 2;
        } else if (language == am) {
            zaban = 2;
        } else if (language == ch) {
            zaban = 4;
        }

        try {

            Bundle colery = getIntent().getExtras();
            String colery_ = colery.getString("bmr_food_1");

            TextView s = (TextView) findViewById(R.id.colery_1);
            s.setText(colery_);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }

        try {

            // Get the ViewPager and set it's PagerAdapter so that it can display items
            ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
            viewPager.setAdapter(new food_page_org_viewpager(getSupportFragmentManager()));

            // Give the PagerSlidingTabStrip the ViewPager
            PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
            // Attach the view pager to the tab strip
            tabsStrip.setViewPager(viewPager);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
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


        try {

            food_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            food_editor = food_preferences.edit();
            CHECKED_STATE_5 = food_preferences.getBoolean("check_show_food", true);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("get save food info"));
        }


        //az bein bordn shekle scrollview
        ScrollView sView = (ScrollView) findViewById(R.id.scrollview_1);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        btn_menu = (ImageView) findViewById(R.id.btn_menu_2);
        about = (LinearLayout) findViewById(R.id.lin_menu_ab);
        diet = (LinearLayout) findViewById(R.id.lin_menu_d);
        dmusic = (LinearLayout) findViewById(R.id.lin_menu_dm);
        exit = (LinearLayout) findViewById(R.id.lin_menu_ex);
        settings = (LinearLayout) findViewById(R.id.lin_menu_sit);
        sports = (LinearLayout) findViewById(R.id.lin_menu_sp);
        help = (LinearLayout) findViewById(R.id.lin_menu_gu);
        btn_back_page2 = (ImageView) findViewById(R.id.btn_back_page2);


        btn_menu.setOnClickListener(this);
        about.setOnClickListener(this);
        dmusic.setOnClickListener(this);
        diet.setOnClickListener(this);
        sports.setOnClickListener(this);
        settings.setOnClickListener(this);
        exit.setOnClickListener(this);
        help.setOnClickListener(this);
        btn_back_page2.setOnClickListener(this);

        //sliding view
        drawerlayout = (DrawerLayout) findViewById(R.id.root_food_page_org);

        menu_exit = (String) getText(R.string.menu_exit2);
        no = (String) getText(R.string.no);
        yes = (String) getText(R.string.yes);


        FirebaseCrash.log("log 6");
        System.gc();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu_2:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("6"));
                }

                try {

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("7"));
                }

                try {

                    if (drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerlayout.closeDrawer(Gravity.LEFT);
                    } else {
                        drawerlayout.openDrawer(Gravity.LEFT);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("8"));
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
                    FirebaseCrash.report(new Exception("9"));
                }

                try {

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("10"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            food_page_org.this.overridePendingTransition(R.anim.out,
                                    R.anim.in);
                            finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                    finish();
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
                    FirebaseCrash.report(new Exception("12"));
                }

                try {

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("13"));
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

                                        click = MediaPlayer.create(food_page_org.this, R.raw.button);
                                        if (music_check == music_off_check) {
                                            click.stop();
                                        } else {
                                            click.start();
                                        }

                                    } catch (Exception e) {
                                        FirebaseCrash.report(new Exception("15"));
                                    }

                                    new Handler().postDelayed(new Thread() {
                                        @Override
                                        public void run() {
                                            super.run();

                                            App.close();

                                        }
                                    }, _splashTime);
                                    sDialog.setTitleText(menu_exit)
                                            .setContentText("خروج")
                                            .setConfirmText("می خوای بری !")
                                            .showCancelButton(false)
                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                }
                            })
                            .show();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                    App.close();
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

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
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
                            Intent about_1 = new Intent(food_page_org.this, com.android.fury.a30day.menu_view.about.class);
                            about_1.putExtra("about_back", 2);
                            food_page_org.this.startActivity(about_1);
                            finish();
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

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
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
                            Intent about_2 = new Intent(food_page_org.this, com.android.fury.a30day.menu_view.setting.class);
                            about_2.putExtra("setting_back", 5);
                            food_page_org.this.startActivity(about_2);
                            finish();
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

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
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
                            Intent suport = new Intent(food_page_org.this, Suport_me.class);
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

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
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
                            if (app_net.getInstance(food_page_org.this).isOnline()) {

                                Intent music = new Intent(food_page_org.this, com.android.fury.a30day.menu_view.music.class);
                                music.putExtra("d_m_b", 2);
                                food_page_org.this.startActivity(music);
                                finish();

                            } else {

                                Intent music_not = new Intent(food_page_org.this, Not_net.class);
                                music_not.putExtra("d_m_b", 2);
                                food_page_org.this.startActivity(music_not);
                                finish();

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

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
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
                            Intent sport_menu = new Intent(food_page_org.this, sport.class);
                            sport_menu.putExtra("sport_back", 2);
                            food_page_org.this.startActivity(sport_menu);
                            finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }


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
                    FirebaseCrash.report(new Exception("45"));
                }

                try {

                    click = MediaPlayer.create(food_page_org.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("46"));
                }


                if (CHECKED_STATE_5) {

                    try {

                        new Handler().postDelayed(new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                finish();
                            }
                        }, _splashTime2);

                    } catch (Exception e) {
                        finish();
                    }

                } else {
                    try {
                        new Handler().postDelayed(new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                String go_music = (String) getText(R.string.food_go_food);
                                Toast.makeText(food_page_org.this, go_music, Toast.LENGTH_LONG).show();
                            }
                        }, _splashTime2);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("68"));
                    }
                }


                break;


            //finish scorllview


            //start page


        }
        FirebaseCrash.log("log 4");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(food_page_org.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("47"));
            }

            try {

                click = MediaPlayer.create(food_page_org.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("48"));
            }

            try {

                food_page_org.this.overridePendingTransition(R.anim.out,
                        R.anim.in);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("49"));
            }
            FirebaseCrash.log("log 3");
            finish();
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        App.activity_food_page_org = this;
        FirebaseCrash.log("log 1");
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.activity_food_page_org = null;
        FirebaseCrash.log("log 2");
        System.gc();
    }
}