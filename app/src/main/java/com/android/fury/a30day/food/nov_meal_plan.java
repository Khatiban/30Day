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
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by fury on 1/21/2017.
 */
public class nov_meal_plan extends Activity implements View.OnClickListener {


    ImageView imag_gyah, imag_mede, imag_heart, imag_deiabet, imag_medium, imag_much;

    Button btn_start_meal;

    MyDatabaseHelper_lan language;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    public static MediaPlayer click;

    public static Vibrator vb;

    String music_check, music_off_check, vibre_check;

    int s_1, s_2, s_3, s_4, s_5, set_1, set_2, set_3, set_4, set_5;

    SharedPreferences meal_save;

    SharedPreferences.Editor nameEditor_meal_save;

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

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("fa");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

            } else if (dadeha.toString().length() == 2) {
                //english.usa.canada

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("en");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

            } else if (dadeha.toString().length() == 3) {
                //chine

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("zh");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

            } else if (dadeha.toString().length() == 6) {
                //german

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("de");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }


        setContentView(R.layout.nov_meal_plan);


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
            FirebaseCrash.report(new Exception("2"));
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
            FirebaseCrash.report(new Exception("3"));
        }


        imag_gyah = (ImageView) findViewById(R.id.imag_gyah);
        imag_mede = (ImageView) findViewById(R.id.imag_mede);
        imag_heart = (ImageView) findViewById(R.id.imag_heart);
        imag_deiabet = (ImageView) findViewById(R.id.imag_deiabet);
        btn_start_meal = (Button) findViewById(R.id.btn_start_meal);


        imag_gyah.setOnClickListener(this);
        imag_mede.setOnClickListener(this);
        imag_heart.setOnClickListener(this);
        imag_deiabet.setOnClickListener(this);
        btn_start_meal.setOnClickListener(this);


        s_1 = 1;
        s_2 = 1;
        s_3 = 1;
        s_4 = 1;
        s_5 = 1;
        set_1 = 1;
        set_2 = 1;
        set_3 = 1;
        set_4 = 1;
        set_5 = 1;

        try {

            meal_save = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            nameEditor_meal_save = meal_save.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }

        FirebaseCrash.log("log 3");
        System.gc();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imag_gyah:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("5"));
                }

                try {
                    click = MediaPlayer.create(nov_meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("6"));
                }

                if (set_1 == 1) {

                    imag_gyah.setImageResource(R.drawable.grass_on);

                    s_1 = 2;

                    set_1 = 2;
                } else if (set_1 == 2) {

                    imag_gyah.setImageResource(R.drawable.grass_off);

                    s_1 = 1;

                    set_1 = 1;
                }


                break;
            case R.id.imag_mede:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("7"));
                }

                try {
                    click = MediaPlayer.create(nov_meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("8"));
                }

                if (set_2 == 1) {

                    imag_mede.setImageResource(R.drawable.stomach_on);

                    s_2 = 2;

                    set_2 = 2;
                } else if (set_2 == 2) {

                    imag_mede.setImageResource(R.drawable.stomach_off);

                    s_2 = 1;

                    set_2 = 1;
                }


                break;
            case R.id.imag_heart:

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
                    click = MediaPlayer.create(nov_meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("10"));
                }

                if (set_3 == 1) {

                    imag_heart.setImageResource(R.drawable.heart_on);

                    s_3 = 2;

                    set_3 = 2;
                } else if (set_3 == 2) {

                    imag_heart.setImageResource(R.drawable.heart_off);

                    s_3 = 1;

                    set_3 = 1;
                }

                break;
            case R.id.imag_deiabet:

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
                    click = MediaPlayer.create(nov_meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("12"));
                }


                if (set_4 == 1) {

                    imag_deiabet.setImageResource(R.drawable.deiabet_on2);

                    s_4 = 2;

                    set_4 = 2;
                } else if (set_4 == 2) {

                    imag_deiabet.setImageResource(R.drawable.deiabet_off2);

                    s_4 = 1;

                    set_4 = 1;
                }


                break;
            case R.id.btn_start_meal:

                nameEditor_meal_save.putInt("nov_meal_gyah", s_1);
                nameEditor_meal_save.putInt("nov_meal_mede", s_2);
                nameEditor_meal_save.putInt("nov_meal_heart", s_3);
                nameEditor_meal_save.putInt("nov_meal_deiabet", s_4);
                nameEditor_meal_save.putInt("nov_meal_sped", 3);
                nameEditor_meal_save.commit();

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
                    click = MediaPlayer.create(nov_meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                }


                Intent start = new Intent(this, Meal_plan.class);
                start.putExtra("nov_meal", 1);
                startActivity(start);
                finish();


                break;


        }
        FirebaseCrash.log("log 2");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(nov_meal_plan.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("19"));
            }

            try {
                click = MediaPlayer.create(nov_meal_plan.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("20"));
            }

            FirebaseCrash.log("log 1");
            finish();
        }
        return false;
    }


}
