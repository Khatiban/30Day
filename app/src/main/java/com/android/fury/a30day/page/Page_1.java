package com.android.fury.a30day.page;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.App;
import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Not_net;
import com.android.fury.a30day.PermissionHandler;
import com.android.fury.a30day.R;
import com.android.fury.a30day.Suport.Suport_me;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.android.fury.a30day.food.food;
import com.android.fury.a30day.sport.sport;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Created by ehsan on 7/14/2016.
 */
public class Page_1 extends Activity implements View.OnClickListener, SlidingDrawer.OnDrawerOpenListener, SlidingDrawer.OnDrawerCloseListener {


    SlidingDrawer sd;
    TextView start, start_text, text_guide;
    ImageView btn_menu;
    DrawerLayout drawerlayout;

    public static MediaPlayer click;

    LinearLayout sports, diet, dmusic, settings, about, help, exit;

    String menu_exit, about_alertdialog_6, about_alertdialog_7, about_alertdialog_8, about_alertdialog_9, no, yes, music_off_check, vibre_check, music_check, fars, en, de, ca, am, ch, language1;

    private final int _splashTime = 1000;
    private final int _splashTime2 = 500;

    public static Activity fa;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    int oneplay, help_play, zaban, update;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MyDatabaseHelper_lan language;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("fa");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

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
        } catch (Resources.NotFoundException e) {
            FirebaseCrash.report(new Exception("1"));
            //...
        }

        //start activ
        setContentView(R.layout.root_page_1);


        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            oneplay = one_play_preferences.getInt("one_play_app", 3);
            help_play = one_play_preferences.getInt("Help_play_1", 1);
            update = one_play_preferences.getInt("update", 3);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        text_guide = (TextView) findViewById(R.id.text_guide);
        //sorll_help = (ScrollView) findViewById(R.id.sorll_help);

        fars = "fa";
        en = "en";
        de = "de";
        ca = "en";
        am = "en";
        ch = "zh";
        if (language1 == fars) {

            String sh1 = "با برنامه 30 روز پس از سی روز به راحتی لاغر شوید و لاغر ماندن";
            String sh2 = "همراه با اپلیکیشن 30 روز تا 10 کیلو در ماه وزن کم کنید با برنامه غذایی اپلیکیشن و تمرینات ورزشی وزن خود را پایین بیاورید ";
            String sh3 = "بدون دارو لاغر شوید ";
            String sh4 = "ویدیو های تمرینات ورزشی همراه با موزیک های انرژی دهنده";
            String sh5 = "فقط با روزی 10 دقیقه ورزش و برنامه غذایی لاغر شوید";
            String sh6 = "بیش از 100 نوع طرز تهیه غذاهای بین المللی (برای کم کردن وزن)";
            String sh7 = "همراه با ویدیو آموزش طرز تهیه غذاهای بین المللی ";
            String sh8 = "ده ها ویدیو ورزشی مختلف برای تمام اعضای بدن ";
            String sh9 = "برنامه غذایی بر اساس اطلاعات شما";
            String sh10 = "ده ها موزیک جذاب و انرژی دهنده";
            String sh11 = "پشتیبانی از 6 زبان دنیا";
            String sh12 = "بیش از 300 نوع کاری مواد غذایی";
            String sh13 = "کالری بیش از 200 نوع فعالیت روزمره";
            String sh14 = "همراه با سخنگوی فارسی در هنگام ورزش";
            String sh15 = "همراه با اپلیکیشن  30 روز  به تناسب اندام و سلامتی برسید و اندام خود را با روزی 10 دقیقه ورزش حفظ کنید";
            String sh16 = "هنگام انجام دادن تمرینات ورزشی از هدفون برای گوش دادن به موزیک استفاده کنید تا انرژی بیشتر بگیرید ( اگر خواستید می توانید در حال انجام تمرینات ورزشی اینترنت را وصل کنید تا موزیک های جدید پخش شود و بیشتر لذت ببرید )";
            String sh = sh1 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh2 + System.getProperty("line.separator") + sh3 + System.getProperty("line.separator")
                    + sh4 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh5 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh6 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh7 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh8 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh9 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh10 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh11 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh12 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh13 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh14 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh15 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh16 + System.getProperty("line.separator") + System.getProperty("line.separator");

            try {

                text_guide.setText(sh);
                text_guide.setMovementMethod(new ScrollingMovementMethod());
                //sorll_help.addView(text_guide);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("3"));
            }


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
        } catch (Resources.NotFoundException e) {
            FirebaseCrash.report(new Exception("4"));
            //...
        } catch (Exception i) {
            // This will catch any exception, because they are all descended from Exception
        } catch (Throwable ignored) {
        }
        //az bein bordn shekle scrollview
        ScrollView sView = (ScrollView) findViewById(R.id.scrollview_1);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        start = (TextView) findViewById(R.id.btn_start1);
        sd = (SlidingDrawer) findViewById(R.id.slide_1);
        start_text = (TextView) findViewById(R.id.start_text);
        btn_menu = (ImageView) findViewById(R.id.btn_menu);
        about = (LinearLayout) findViewById(R.id.lin_menu_ab);
        diet = (LinearLayout) findViewById(R.id.lin_menu_d);
        dmusic = (LinearLayout) findViewById(R.id.lin_menu_dm);
        exit = (LinearLayout) findViewById(R.id.lin_menu_ex);
        settings = (LinearLayout) findViewById(R.id.lin_menu_sit);
        sports = (LinearLayout) findViewById(R.id.lin_menu_sp);
        help = (LinearLayout) findViewById(R.id.lin_menu_gu);
        ImageView ss = (ImageView) findViewById(R.id.btn_back_page2);
        ss.setVisibility(View.INVISIBLE);

        start.setOnClickListener(this);
        sd.setOnDrawerOpenListener(this);
        sd.setOnDrawerCloseListener(this);
        btn_menu.setOnClickListener(this);
        about.setOnClickListener(this);
        dmusic.setOnClickListener(this);
        diet.setOnClickListener(this);
        sports.setOnClickListener(this);
        settings.setOnClickListener(this);
        exit.setOnClickListener(this);
        help.setOnClickListener(this);

        //sliding view
        drawerlayout = (DrawerLayout) findViewById(R.id.root_page_1);

        menu_exit = (String) getText(R.string.menu_exit2);
        no = (String) getText(R.string.no);
        yes = (String) getText(R.string.yes);
        about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
        about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);


        try {
            if (update == 3 && help_play != 1) {

                String ver = (String) getText(R.string.ver_new);
                String new_ver_1 = (String) getText(R.string.ver_new_1);//bug
                String new_ver_2 = (String) getText(R.string.ver_new_2);//set 6.0
                String new_ver_3 = (String) getText(R.string.ver_new_3);//ui
                String new_ver_4 = (String) getText(R.string.ver_new_4);//cal list
                String new_ver_5 = (String) getText(R.string.ver_new_5);//error in api 24 or 25
                String new_ver = new_ver_1 + System.getProperty("line.separator") + new_ver_2 + System.getProperty("line.separator") + new_ver_3
                        + System.getProperty("line.separator") + new_ver_4 + System.getProperty("line.separator") + new_ver_5 ;
                String ok = (String) getText(R.string.ok);

                new SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
                        .setTitleText(ver)
                        .setContentText(new_ver)
                        .setConfirmText(ok)
                        .showCancelButton(false)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                if (vibre_check == music_off_check) {
                                    vb.cancel();
                                } else {
                                    vb.vibrate(100);
                                }

                                click = MediaPlayer.create(Page_1.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }
                                sDialog.cancel();
                            }
                        })
                        .show();


            }
        } catch (Resources.NotFoundException e) {
            FirebaseCrash.report(new Exception("8"));
            //...
        } catch (Exception i) {
            // This will catch any exception, because they are all descended from Exception
        } catch (Throwable ignored) {
        }

        one_play_editor.putInt("update", 4);
        one_play_editor.apply();

        if (Build.VERSION.SDK_INT >= 22) {
            checkPermissions();
        }

        try {
            if (help_play == 1) {

                String s1 = (String) getText(R.string.Help_start_1_1);
                String s2 = (String) getText(R.string.Help_start_1_2);


                new MaterialTapTargetPrompt.Builder(Page_1.this)
                        .setTarget(start)
                        .setPrimaryText(s1)
                        .setSecondaryText(s2)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                one_play_editor.putInt("Help_play_1", 2);
                                one_play_editor.commit();
                            }

                            @Override
                            public void onHidePromptComplete() {

                            }
                        })
                        .show();

            }
        } catch (Resources.NotFoundException e) {
            FirebaseCrash.report(new Exception("8"));
            //...
        } catch (Exception i) {
            // This will catch any exception, because they are all descended from Exception
        } catch (Throwable ignored) {
        }
        FirebaseCrash.log("log 8");
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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    if (drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerlayout.closeDrawer(Gravity.LEFT);
                    } else {
                        drawerlayout.openDrawer(Gravity.LEFT);
                    }
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("9"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
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

                    click = MediaPlayer.create(Page_1.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

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

                                    click = MediaPlayer.create(Page_1.this, R.raw.button);
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
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("11"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_1 = new Intent(Page_1.this, com.android.fury.a30day.menu_view.about.class);
                            about_1.putExtra("about_back", 3);
                            Page_1.this.startActivity(about_1);
                        }
                    }, _splashTime2);
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("12"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
                }

                break;

            case R.id.btn_start1:

                try {
                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent Page_2 = new Intent(Page_1.this, Page_2.class);
                            startActivity(Page_2);
                            finish();
                        }
                    }, _splashTime2);
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("13"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent setting = new Intent(Page_1.this, com.android.fury.a30day.menu_view.setting.class);
                            setting.putExtra("setting_back", 1);
                            Page_1.this.startActivity(setting);
                            Page_1.this.finish();
                        }
                    }, _splashTime2);
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("14"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent suport = new Intent(Page_1.this, Suport_me.class);
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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            if (app_net.getInstance(Page_1.this).isOnline()) {

                                Intent music = new Intent(Page_1.this, com.android.fury.a30day.menu_view.music.class);
                                music.putExtra("d_m_b", 1);
                                Page_1.this.startActivity(music);

                            } else {

                                Intent music_not = new Intent(Page_1.this, Not_net.class);
                                music_not.putExtra("d_m_b", 1);
                                Page_1.this.startActivity(music_not);

                            }


                        }
                    }, _splashTime2);
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("17"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent sport_menu = new Intent(Page_1.this, sport.class);
                            sport_menu.putExtra("sport_back", 3);
                            Page_1.this.startActivity(sport_menu);
                        }
                    }, _splashTime2);
                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("18"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
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

                    click = MediaPlayer.create(Page_1.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent food_ = new Intent(Page_1.this, food.class);
                            food_.putExtra("zaban_fo", zaban);
                            Page_1.this.startActivity(food_);
                        }
                    }, _splashTime2);


                } catch (Resources.NotFoundException e) {
                    FirebaseCrash.report(new Exception("19"));
                    //...
                } catch (Exception i) {
                    // This will catch any exception, because they are all descended from Exception
                } catch (Throwable ignored) {
                }

                break;

        }
        FirebaseCrash.log("log 6");
    }

    @Override
    public void onDrawerOpened() {
        start.setVisibility(View.INVISIBLE);
        start_text.setVisibility(View.INVISIBLE);
        FirebaseCrash.log("log 5");
    }

    @Override
    public void onDrawerClosed() {
        start_text.setVisibility(View.VISIBLE);
        start.setVisibility(View.VISIBLE);
        FirebaseCrash.log("log 4");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(Page_1.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (vibre_check == music_off_check) {
                vb.cancel();
            } else {
                vb.vibrate(100);
            }

            click = MediaPlayer.create(Page_1.this, R.raw.button);
            if (music_check == music_off_check) {
                click.stop();
            } else {
                click.start();
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

                                click = MediaPlayer.create(Page_1.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        super.run();
                                        Toast.makeText(Page_1.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
                                        finish();
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
            FirebaseCrash.log("log 3");
        }
        return false;
    }


    @Override
    protected void onStart() {
        super.onStart();
        App.activity_page_1 = this;
        FirebaseCrash.log("log 2");
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.activity_page_1 = null;
        FirebaseCrash.log("log 1");
        System.gc();
    }
    private void checkPermissions(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            new PermissionHandler().checkPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE, new PermissionHandler.OnPermissionResponse() {
                @Override
                public void onPermissionGranted() {
                    // permission granted
                    // your code
                }

                @Override
                public void onPermissionDenied() {
                    // User canceled permission
                    Toast.makeText(Page_1.this,"در صورت نپذیرفتن درخواست ها برنامه با مشکل مواجه می شود!", Toast.LENGTH_LONG).show();
                }
            });
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            new PermissionHandler().checkPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, new PermissionHandler.OnPermissionResponse() {
                @Override
                public void onPermissionGranted() {
                    // permission granted
                    // your code
                }

                @Override
                public void onPermissionDenied() {
                    // User canceled permission
                    Toast.makeText(Page_1.this,"در صورت نپذیرفتن درخواست ها برنامه با مشکل مواجه می شود!", Toast.LENGTH_LONG).show();
                }
            });
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            new PermissionHandler().checkPermission(this, android.Manifest.permission.READ_PHONE_STATE, new PermissionHandler.OnPermissionResponse() {
                @Override
                public void onPermissionGranted() {
                    // permission granted
                    // your code
                }

                @Override
                public void onPermissionDenied() {
                    // User canceled permission
                    Toast.makeText(Page_1.this,"در صورت نپذیرفتن درخواست ها برنامه با مشکل مواجه می شود!", Toast.LENGTH_LONG).show();
                }
            });
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent intent = new Intent("PERMISSION_RECEIVER");
        intent.putExtra("requestCode",requestCode);
        intent.putExtra("permissions",permissions);
        intent.putExtra("grantResults",grantResults);
        sendBroadcast(intent);
    }

}