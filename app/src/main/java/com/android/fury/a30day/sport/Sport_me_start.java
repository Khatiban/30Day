package com.android.fury.a30day.sport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by fury on 1/16/2017.
 */
public class Sport_me_start extends Activity implements View.OnClickListener {

    //

    ImageView btn_sport_me_tedad_3, btn_sport_me_tedad_4, btn_sport_me_tedad_5, btn_sport_me_tedad_6, btn_sport_me_tedad_7, btn_sport_me_time_30, btn_sport_me_time_45, btn_sport_me_time_60, btn_sport_me_time_estraht_10, btn_sport_me_time_estraht_20, btn_sport_me_time_estraht_30, btn_menu_5;


    LinearLayout lin_sport_me_sport_im_1, lin_sport_me_sport_im_2, lin_sport_me_sport_im_3, lin_sport_me_sport_im_4, lin_sport_me_sport_im_5, lin_sport_me_sport_im_6, lin_sport_me_sport_im_7, lin_sport_me_sport_im_8, lin_sport_me_sport_im_9, lin_sport_me_sport_im_10, lin_sport_me_sport_im_11, lin_sport_me_sport_im_12, lin_sport_me_sport_im_13, lin_sport_me_sport_im_14, lin_sport_me_sport_im_15, lin_sport_me_sport_im_16, lin_sport_me_sport_im_17, lin_sport_me_sport_im_18;


    TextView txt_sport_me_sport_im_1, txt_sport_me_sport_im_2, txt_sport_me_sport_im_3, txt_sport_me_sport_im_4, txt_sport_me_sport_im_5, txt_sport_me_sport_im_6, txt_sport_me_sport_im_7, txt_sport_me_sport_im_8, txt_sport_me_sport_im_9, txt_sport_me_sport_im_10, txt_sport_me_sport_im_11, txt_sport_me_sport_im_12, txt_sport_me_sport_im_13, txt_sport_me_sport_im_14, txt_sport_me_sport_im_15, txt_sport_me_sport_im_16, txt_sport_me_sport_im_17, txt_sport_me_sport_im_18, text_colore_spot_me;


    Button btn_start_sport_me;

    MyDatabaseHelper_lan language;

    int a, send_noe_1, send_noe_2, send_noe_3, send_noe_4, send_noe_5, send_noe_6, send_noe_7, send_noe_8, send_noe_9, send_noe_10, send_noe_11, send_noe_12, send_noe_13, send_noe_14, send_noe_15, send_noe_16, send_noe_17, send_noe_18, n_1, n_2, n_3, n_4, n_5, n_6, n_7, n_8, n_9, n_10, n_11, n_12, n_13, n_14, n_15, n_16, n_17, n_18, tedad_kol, b, m_1, m_2, m_3, m_4, m_5, m_6, m_7, m_8, m_9, m_10, m_11, m_12, m_13, m_14, m_15, m_16, m_17, m_18, online_music, c_1, c_2, c_3, c_4, c_5, c_6, c_7, c_8, c_9, c_10, c_11, c_12, c_13, c_14, c_15, c_16, c_17, c_18, k, h, mo_1, tedad_kol_c;


    double cal_1, cal_2, cal_3, cal_4, cal_5, cal_6, cal_7, cal_8, cal_9, cal_10, cal_11, cal_12, cal_13, cal_14, cal_15, cal_16, cal_17, cal_18, jame_cal, kol_cal, tghsim_time, kol_time, time_, rest;

    String s_1, s_2, s_3, s_4, music_check, music_off_check, vibre_check, st_, st_not, st_por;

    MediaPlayer click;
//mp

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    private ScheduledThreadPoolExecutor mDialogDaemon;

    //DecimalFormat df;

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


        setContentView(R.layout.sport_me_start);


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


        //tedad sport
        btn_sport_me_tedad_3 = (ImageView) findViewById(R.id.btn_sport_me_tedad_3);
        btn_sport_me_tedad_4 = (ImageView) findViewById(R.id.btn_sport_me_tedad_4);
        btn_sport_me_tedad_5 = (ImageView) findViewById(R.id.btn_sport_me_tedad_5);
        btn_sport_me_tedad_6 = (ImageView) findViewById(R.id.btn_sport_me_tedad_6);
        btn_sport_me_tedad_7 = (ImageView) findViewById(R.id.btn_sport_me_tedad_7);


        //noe sport li
        lin_sport_me_sport_im_1 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_1);
        lin_sport_me_sport_im_2 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_2);
        lin_sport_me_sport_im_3 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_3);
        lin_sport_me_sport_im_4 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_4);
        lin_sport_me_sport_im_5 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_5);
        lin_sport_me_sport_im_6 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_6);
        lin_sport_me_sport_im_7 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_7);
        lin_sport_me_sport_im_8 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_8);
        lin_sport_me_sport_im_9 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_9);
        lin_sport_me_sport_im_10 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_10);
        lin_sport_me_sport_im_11 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_11);
        lin_sport_me_sport_im_12 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_12);
        lin_sport_me_sport_im_13 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_13);
        lin_sport_me_sport_im_14 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_14);
        lin_sport_me_sport_im_15 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_15);
        lin_sport_me_sport_im_16 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_16);
        lin_sport_me_sport_im_17 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_17);
        lin_sport_me_sport_im_18 = (LinearLayout) findViewById(R.id.lin_sport_me_sport_im_18);

        //noe sport txt
        txt_sport_me_sport_im_1 = (TextView) findViewById(R.id.txt_sport_me_sport_im_1);
        txt_sport_me_sport_im_2 = (TextView) findViewById(R.id.txt_sport_me_sport_im_2);
        txt_sport_me_sport_im_3 = (TextView) findViewById(R.id.txt_sport_me_sport_im_3);
        txt_sport_me_sport_im_4 = (TextView) findViewById(R.id.txt_sport_me_sport_im_4);
        txt_sport_me_sport_im_5 = (TextView) findViewById(R.id.txt_sport_me_sport_im_5);
        txt_sport_me_sport_im_6 = (TextView) findViewById(R.id.txt_sport_me_sport_im_6);
        txt_sport_me_sport_im_7 = (TextView) findViewById(R.id.txt_sport_me_sport_im_7);
        txt_sport_me_sport_im_8 = (TextView) findViewById(R.id.txt_sport_me_sport_im_8);
        txt_sport_me_sport_im_9 = (TextView) findViewById(R.id.txt_sport_me_sport_im_9);
        txt_sport_me_sport_im_10 = (TextView) findViewById(R.id.txt_sport_me_sport_im_10);
        txt_sport_me_sport_im_11 = (TextView) findViewById(R.id.txt_sport_me_sport_im_11);
        txt_sport_me_sport_im_12 = (TextView) findViewById(R.id.txt_sport_me_sport_im_12);
        txt_sport_me_sport_im_13 = (TextView) findViewById(R.id.txt_sport_me_sport_im_13);
        txt_sport_me_sport_im_14 = (TextView) findViewById(R.id.txt_sport_me_sport_im_14);
        txt_sport_me_sport_im_15 = (TextView) findViewById(R.id.txt_sport_me_sport_im_15);
        txt_sport_me_sport_im_16 = (TextView) findViewById(R.id.txt_sport_me_sport_im_16);
        txt_sport_me_sport_im_17 = (TextView) findViewById(R.id.txt_sport_me_sport_im_17);
        txt_sport_me_sport_im_18 = (TextView) findViewById(R.id.txt_sport_me_sport_im_18);


        DiscreteSeekBar seekbar_weight = (DiscreteSeekBar) findViewById(R.id.seekbar_tedad);




        //time sport
        btn_sport_me_time_30 = (ImageView) findViewById(R.id.btn_sport_me_time_30);
        btn_sport_me_time_45 = (ImageView) findViewById(R.id.btn_sport_me_time_45);
        btn_sport_me_time_60 = (ImageView) findViewById(R.id.btn_sport_me_time_60);


        //time estrahat
        btn_sport_me_time_estraht_10 = (ImageView) findViewById(R.id.btn_sport_me_time_estraht_10);
        btn_sport_me_time_estraht_20 = (ImageView) findViewById(R.id.btn_sport_me_time_estraht_20);
        btn_sport_me_time_estraht_30 = (ImageView) findViewById(R.id.btn_sport_me_time_estraht_30);

        // start sport
        btn_start_sport_me = (Button) findViewById(R.id.btn_start_sport_me);

        //back page
        btn_menu_5 = (ImageView) findViewById(R.id.btn_menu_5);

        //txt calr
        text_colore_spot_me = (TextView) findViewById(R.id.text_colore_spot_me);


        a = 1;
        k = 1;
        h = 1;
        send_noe_1 = 0;
        send_noe_2 = 0;
        send_noe_3 = 0;
        send_noe_4 = 0;
        send_noe_5 = 0;
        send_noe_6 = 0;
        send_noe_7 = 0;
        send_noe_8 = 0;
        send_noe_9 = 0;
        send_noe_10 = 0;
        send_noe_11 = 0;
        send_noe_12 = 0;
        send_noe_13 = 0;
        send_noe_14 = 0;
        send_noe_15 = 0;
        send_noe_16 = 0;
        send_noe_17 = 0;
        send_noe_18 = 0;
        n_1 = 1;
        n_2 = 1;
        n_3 = 1;
        n_4 = 1;
        n_5 = 1;
        n_6 = 1;
        n_7 = 1;
        n_8 = 1;
        n_9 = 1;
        n_10 = 1;
        n_11 = 1;
        n_12 = 1;
        n_13 = 1;
        n_14 = 1;
        n_15 = 1;
        n_16 = 1;
        n_17 = 1;
        n_18 = 1;
        c_1 = 1;
        c_2 = 1;
        c_3 = 1;
        c_4 = 1;
        c_5 = 1;
        c_6 = 1;
        c_7 = 1;
        c_8 = 1;
        c_9 = 1;
        c_10 = 1;
        c_11 = 1;
        c_12 = 1;
        c_13 = 1;
        c_14 = 1;
        c_15 = 1;
        c_16 = 1;
        c_17 = 1;
        c_18 = 1;
        tedad_kol = 0;
        tedad_kol_c = 0;
        b = 0;
        m_1 = 1;
        m_2 = 1;
        m_3 = 1;
        m_4 = 1;
        m_5 = 1;
        m_6 = 1;
        m_7 = 1;
        m_8 = 1;
        m_9 = 1;
        m_10 = 1;
        m_11 = 1;
        m_12 = 1;
        m_13 = 1;
        m_14 = 1;
        m_15 = 1;
        m_16 = 1;
        m_17 = 1;
        m_18 = 1;
        online_music = 0;
        cal_1 = 0;
        cal_2 = 0;
        cal_3 = 0;
        cal_4 = 0;
        cal_5 = 0;
        cal_6 = 0;
        cal_7 = 0;
        cal_8 = 0;
        cal_9 = 0;
        cal_10 = 0;
        cal_11 = 0;
        cal_12 = 0;
        cal_13 = 0;
        cal_14 = 0;
        cal_15 = 0;
        cal_16 = 0;
        cal_17 = 0;
        cal_18 = 0;
        mo_1 = 1;
        st_ = (String) getText(R.string.text_sport_me_tost_por_tedad);
        st_not = (String) getText(R.string.text_sport_me_tost_not_tedad);
        //df = new DecimalFormat("#.#");


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

                        jame_cal = 0;
                        kol_cal = 0;

                        jame_cal = cal_1 + cal_2 + cal_3 + cal_4 + cal_5 + cal_6 + cal_7 + cal_8 + cal_9 + cal_10 + cal_11 + cal_12 + cal_13 + cal_14 + cal_15 + cal_16 + cal_17 + cal_18;
                        kol_cal = jame_cal * b;
                        tghsim_time = kol_cal / 100;
                        kol_time = ((tghsim_time * time_) + (tghsim_time * rest)) + kol_cal;
                        //   kol_time = Double.valueOf(df.format(kol_time));

                        s_1 = (String) getText(R.string.text_sport_me_txt_clr_1);
                        s_3 = (String) getText(R.string.text_sport_me_txt_clr_2);
                        s_2 = String.valueOf(kol_time);

                        s_4 = s_1 + s_2 + s_3;

                        text_colore_spot_me.setText(s_4);

                        // Do something worthwhile
                    }
                });
            }
        }, 0L, 1000L, TimeUnit.MILLISECONDS);


        btn_sport_me_tedad_3.setOnClickListener(this);
        btn_sport_me_tedad_4.setOnClickListener(this);
        btn_sport_me_tedad_5.setOnClickListener(this);
        btn_sport_me_tedad_6.setOnClickListener(this);
        btn_sport_me_tedad_7.setOnClickListener(this);


        lin_sport_me_sport_im_1.setOnClickListener(this);
        lin_sport_me_sport_im_2.setOnClickListener(this);
        lin_sport_me_sport_im_3.setOnClickListener(this);
        lin_sport_me_sport_im_4.setOnClickListener(this);
        lin_sport_me_sport_im_5.setOnClickListener(this);
        lin_sport_me_sport_im_6.setOnClickListener(this);
        lin_sport_me_sport_im_7.setOnClickListener(this);
        lin_sport_me_sport_im_8.setOnClickListener(this);
        lin_sport_me_sport_im_9.setOnClickListener(this);
        lin_sport_me_sport_im_10.setOnClickListener(this);
        lin_sport_me_sport_im_11.setOnClickListener(this);
        lin_sport_me_sport_im_12.setOnClickListener(this);
        lin_sport_me_sport_im_13.setOnClickListener(this);
        lin_sport_me_sport_im_14.setOnClickListener(this);
        lin_sport_me_sport_im_15.setOnClickListener(this);
        lin_sport_me_sport_im_16.setOnClickListener(this);
        lin_sport_me_sport_im_17.setOnClickListener(this);
        lin_sport_me_sport_im_18.setOnClickListener(this);


        seekbar_weight.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                if (value >= 0 && value <= 5) {

                    b = 5;

                } else if (value >= 6 && value <= 10) {

                    b = 10;

                } else if (value >= 11 && value <= 15) {

                    b = 15;

                } else if (value >= 16 && value <= 20) {

                    b = 20;

                } else if (value >= 21 && value <= 25) {

                    b = 25;

                } else if (value >= 26 && value <= 30) {

                    b = 30;

                } else if (value >= 31 && value <= 35) {

                    b = 35;

                } else if (value >= 36 && value <= 40) {

                    b = 40;

                } else if (value >= 41 && value <= 50) {

                    b = 50;

                }
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });

        btn_sport_me_time_30.setOnClickListener(this);
        btn_sport_me_time_45.setOnClickListener(this);
        btn_sport_me_time_60.setOnClickListener(this);

        btn_sport_me_time_estraht_10.setOnClickListener(this);
        btn_sport_me_time_estraht_20.setOnClickListener(this);
        btn_sport_me_time_estraht_30.setOnClickListener(this);

        btn_start_sport_me.setOnClickListener(this);

        btn_menu_5.setOnClickListener(this);


        FirebaseCrash.log("log 8");
        System.gc();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_sport_me_tedad_3:

                a = 3;
                tedad_harackat(a);

                break;

            case R.id.btn_sport_me_tedad_4:

                a = 4;
                tedad_harackat(a);

                break;

            case R.id.btn_sport_me_tedad_5:

                a = 5;
                tedad_harackat(a);

                break;

            case R.id.btn_sport_me_tedad_6:

                a = 6;
                tedad_harackat(a);

                break;

            case R.id.btn_sport_me_tedad_7:

                a = 7;
                tedad_harackat(a);

                break;


            case R.id.lin_sport_me_sport_im_1:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_1 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_1 == 1) {

                        haracat_varzshi(1, a);
                        cal_1 = 0.3;
                        n_1++;
                    } else if (n_1 == 2) {

                        haracat_varzshi(20, a);
                        cal_1 = 0;
                        n_1--;
                    }

                }


                break;

            case R.id.lin_sport_me_sport_im_2:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_2 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_2 == 1) {

                        haracat_varzshi(2, a);
                        cal_2 = 10;
                        n_2++;
                    } else if (n_2 == 2) {

                        haracat_varzshi(21, a);
                        cal_2 = 0;
                        n_2--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_3:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_3 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_3 == 1) {

                        haracat_varzshi(3, a);
                        cal_3 = 4;
                        n_3++;
                    } else if (n_3 == 2) {

                        haracat_varzshi(22, a);
                        cal_3 = 0;
                        n_3--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_4:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_4 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_4 == 1) {

                        haracat_varzshi(4, a);
                        cal_4 = 0.53;
                        n_4++;
                    } else if (n_4 == 2) {

                        haracat_varzshi(23, a);
                        cal_4 = 0;
                        n_4--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_5:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_5 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_5 == 1) {

                        haracat_varzshi(5, a);
                        cal_5 = 0.53;
                        n_5++;
                    } else if (n_5 == 2) {

                        haracat_varzshi(24, a);
                        cal_5 = 0;
                        n_5--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_6:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_6 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_6 == 1) {

                        haracat_varzshi(6, a);
                        cal_6 = 5;
                        n_6++;
                    } else if (n_6 == 2) {

                        haracat_varzshi(25, a);
                        cal_6 = 0;
                        n_6--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_7:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_7 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_7 == 1) {

                        haracat_varzshi(7, a);
                        cal_7 = 14;
                        n_7++;
                    } else if (n_7 == 2) {

                        haracat_varzshi(26, a);
                        cal_7 = 0;
                        n_7--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_8:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_8 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_8 == 1) {

                        haracat_varzshi(8, a);
                        cal_8 = 10;
                        n_8++;
                    } else if (n_8 == 2) {

                        haracat_varzshi(27, a);
                        cal_8 = 0;
                        n_8--;
                    }

                }

                break;

            case R.id.lin_sport_me_sport_im_9:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_9 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_9 == 1) {

                        haracat_varzshi(9, a);
                        cal_9 = 1.5;
                        n_9++;
                    } else if (n_9 == 2) {

                        haracat_varzshi(28, a);
                        cal_9 = 0;
                        n_9--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_10:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_10 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_10 == 1) {

                        haracat_varzshi(10, a);
                        cal_10 = 8;
                        n_10++;
                    } else if (n_10 == 2) {

                        haracat_varzshi(29, a);
                        cal_10 = 0;
                        n_10--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_11:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_11 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_11 == 1) {

                        haracat_varzshi(11, a);
                        cal_11 = 1;
                        n_11++;
                    } else if (n_11 == 2) {

                        haracat_varzshi(30, a);
                        cal_11 = 0;
                        n_11--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_12:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_12 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_12 == 1) {

                        haracat_varzshi(12, a);
                        cal_12 = 5;
                        n_12++;
                    } else if (n_12 == 2) {

                        haracat_varzshi(31, a);
                        cal_12 = 0;
                        n_12--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_13:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_13 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_13 == 1) {

                        haracat_varzshi(13, a);
                        cal_13 = 10;
                        n_13++;
                    } else if (n_13 == 2) {

                        haracat_varzshi(32, a);
                        cal_13 = 0;
                        n_13--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_14:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_14 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_14 == 1) {

                        haracat_varzshi(14, a);
                        cal_14 = 3;
                        n_14++;
                    } else if (n_14 == 2) {

                        haracat_varzshi(33, a);
                        cal_14 = 0;
                        n_14--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_15:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_15 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_15 == 1) {

                        haracat_varzshi(15, a);
                        cal_15 = 14;
                        n_15++;
                    } else if (n_15 == 2) {

                        haracat_varzshi(34, a);
                        cal_15 = 0;
                        n_15--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_16:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_16 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_16 == 1) {

                        haracat_varzshi(16, a);
                        cal_16 = 10;
                        n_16++;
                    } else if (n_16 == 2) {

                        haracat_varzshi(35, a);
                        cal_16 = 0;
                        n_16--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_17:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_17 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_17 == 1) {

                        haracat_varzshi(17, a);
                        cal_17 = 10;
                        n_17++;
                    } else if (n_17 == 2) {

                        haracat_varzshi(36, a);
                        cal_17 = 0;
                        n_17--;
                    }
                }

                break;

            case R.id.lin_sport_me_sport_im_18:

                if (a == 1) {

                    Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                } else if (tedad_kol == a && n_18 == 1) {

                    st_por = st_ + a;
                    Toast.makeText(this, st_por, Toast.LENGTH_LONG).show();

                } else {

                    if (n_18 == 1) {

                        haracat_varzshi(18, a);
                        cal_18 = 0.34;
                        n_18++;
                    } else if (n_18 == 2) {

                        haracat_varzshi(37, a);
                        cal_18 = 0;
                        n_18--;
                    }
                }

                break;

            case R.id.btn_sport_me_time_30:

                k = 30;
                time(k);
                time_ = 2;

                break;

            case R.id.btn_sport_me_time_45:

                k = 45;
                time(k);
                time_ = 1;

                break;

            case R.id.btn_sport_me_time_60:

                k = 60;
                time(k);
                time_ = 0;

                break;

            case R.id.btn_sport_me_time_estraht_10:

                h = 10;
                time_reset(h);
                rest = 2;

                break;

            case R.id.btn_sport_me_time_estraht_20:

                h = 20;
                time_reset(h);
                rest = 1;

                break;

            case R.id.btn_sport_me_time_estraht_30:

                h = 30;
                time_reset(h);
                rest = 0;

                break;

            case R.id.btn_start_sport_me:

                try {

                    if (a == 1) {

                        Toast.makeText(this, st_not, Toast.LENGTH_LONG).show();

                    } else if (tedad_kol != a) {

                        String no_h = (String) getText(R.string.text_sport_me_txt_no_har);
                        Toast.makeText(this, no_h, Toast.LENGTH_LONG).show();

                    } else if (b == 0) {

                        String no_te = (String) getText(R.string.text_sport_me_txt_no_te);
                        Toast.makeText(this, no_te, Toast.LENGTH_LONG).show();

                    } else if (k == 1) {

                        String no_ti = (String) getText(R.string.text_sport_me_txt_no_ti);
                        Toast.makeText(this, no_ti, Toast.LENGTH_LONG).show();

                    } else if (h == 1) {

                        String no_ti_re = (String) getText(R.string.text_sport_me_txt_no_ti_re);
                        Toast.makeText(this, no_ti_re, Toast.LENGTH_LONG).show();

                    } else {

                        Intent start_sport_me = new Intent(Sport_me_start.this, Sport_me.class);
                        start_sport_me.putExtra("tedad_kol", a);
                        start_sport_me.putExtra("now_harkat_1", send_noe_1);
                        start_sport_me.putExtra("now_harkat_2", send_noe_2);
                        start_sport_me.putExtra("now_harkat_3", send_noe_3);
                        start_sport_me.putExtra("now_harkat_4", send_noe_4);
                        start_sport_me.putExtra("now_harkat_5", send_noe_5);
                        start_sport_me.putExtra("now_harkat_6", send_noe_6);
                        start_sport_me.putExtra("now_harkat_7", send_noe_7);
                        start_sport_me.putExtra("now_harkat_8", send_noe_8);
                        start_sport_me.putExtra("now_harkat_9", send_noe_9);
                        start_sport_me.putExtra("now_harkat_10", send_noe_10);
                        start_sport_me.putExtra("now_harkat_11", send_noe_11);
                        start_sport_me.putExtra("now_harkat_12", send_noe_12);
                        start_sport_me.putExtra("now_harkat_13", send_noe_13);
                        start_sport_me.putExtra("now_harkat_14", send_noe_14);
                        start_sport_me.putExtra("now_harkat_15", send_noe_15);
                        start_sport_me.putExtra("now_harkat_16", send_noe_16);
                        start_sport_me.putExtra("now_harkat_17", send_noe_17);
                        start_sport_me.putExtra("now_harkat_18", send_noe_18);
                        start_sport_me.putExtra("time", k);
                        start_sport_me.putExtra("time_rest", h);
                        start_sport_me.putExtra("sport_me_por", 1);
                        startActivity(start_sport_me);

                        finish();

                    }

                } catch (Exception e) {
                }

                break;

            case R.id.btn_menu_5:

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            finish();
                        }
                    }, 500);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("2"));
                }

                break;

        }
        FirebaseCrash.log("log 7");
        System.gc();

    }


    public void tedad_harackat(int i) {

        try {

            vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (vibre_check == music_off_check) {
                vb.cancel();
            } else {
                vb.vibrate(100);
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }

        try {
            click = MediaPlayer.create(Sport_me_start.this, R.raw.button);
            if (music_check == music_off_check) {
                click.stop();
            } else {
                click.start();
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }

        if (i == 3) {

            try {

                btn_sport_me_tedad_3.setImageResource(R.drawable.sport_me_t3_on);
                btn_sport_me_tedad_4.setImageResource(R.drawable.sport_me_t4_off);
                btn_sport_me_tedad_5.setImageResource(R.drawable.sport_me_t5_off);
                btn_sport_me_tedad_6.setImageResource(R.drawable.sport_me_t6_off);
                btn_sport_me_tedad_7.setImageResource(R.drawable.sport_me_t7_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("5"));
                btn_sport_me_tedad_3.setImageResource(R.drawable.sport_me_t3_on);
            }

        } else if (i == 4) {

            try {

                btn_sport_me_tedad_3.setImageResource(R.drawable.sport_me_t3_off);
                btn_sport_me_tedad_4.setImageResource(R.drawable.sport_me_t4_on);
                btn_sport_me_tedad_5.setImageResource(R.drawable.sport_me_t5_off);
                btn_sport_me_tedad_6.setImageResource(R.drawable.sport_me_t6_off);
                btn_sport_me_tedad_7.setImageResource(R.drawable.sport_me_t7_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
                btn_sport_me_tedad_4.setImageResource(R.drawable.sport_me_t4_on);
            }

        } else if (i == 5) {

            try {

                btn_sport_me_tedad_3.setImageResource(R.drawable.sport_me_t3_off);
                btn_sport_me_tedad_4.setImageResource(R.drawable.sport_me_t4_off);
                btn_sport_me_tedad_5.setImageResource(R.drawable.sport_me_t5_on);
                btn_sport_me_tedad_6.setImageResource(R.drawable.sport_me_t6_off);
                btn_sport_me_tedad_7.setImageResource(R.drawable.sport_me_t7_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
                btn_sport_me_tedad_5.setImageResource(R.drawable.sport_me_t5_on);
            }

        } else if (i == 6) {

            try {

                btn_sport_me_tedad_3.setImageResource(R.drawable.sport_me_t3_off);
                btn_sport_me_tedad_4.setImageResource(R.drawable.sport_me_t4_off);
                btn_sport_me_tedad_5.setImageResource(R.drawable.sport_me_t5_off);
                btn_sport_me_tedad_6.setImageResource(R.drawable.sport_me_t6_on);
                btn_sport_me_tedad_7.setImageResource(R.drawable.sport_me_t7_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("8"));
                btn_sport_me_tedad_6.setImageResource(R.drawable.sport_me_t6_on);
            }

        } else {

            try {

                btn_sport_me_tedad_3.setImageResource(R.drawable.sport_me_t3_off);
                btn_sport_me_tedad_4.setImageResource(R.drawable.sport_me_t4_off);
                btn_sport_me_tedad_5.setImageResource(R.drawable.sport_me_t5_off);
                btn_sport_me_tedad_6.setImageResource(R.drawable.sport_me_t6_off);
                btn_sport_me_tedad_7.setImageResource(R.drawable.sport_me_t7_on);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("9"));
                btn_sport_me_tedad_7.setImageResource(R.drawable.sport_me_t7_on);
            }

        }

        FirebaseCrash.log("log 6");
        check_tedad();
        System.gc();

    }


    public void haracat_varzshi(int o, int e) {


        vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibre_check == music_off_check) {
            vb.cancel();
        } else {
            vb.vibrate(100);
        }

        click = MediaPlayer.create(Sport_me_start.this, R.raw.button);
        if (music_check == music_off_check) {
            click.stop();
        } else {
            click.start();
        }


        int q;
        q = 0;

        if (o >= 1 && o <= 18) {

            q = 1;

        } else if (o >= 20 && o <= 38) {

            q = 2;

        }


        if (q == 1) {

            tedad_kol = tedad_kol + mo_1;
            if (o == 1) {

                lin_sport_me_sport_im_1.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_1.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_1 = 1;

            } else if (o == 2) {

                lin_sport_me_sport_im_2.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_2.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_2 = 2;

            } else if (o == 3) {

                lin_sport_me_sport_im_3.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_3.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_3 = 3;

            } else if (o == 4) {

                lin_sport_me_sport_im_4.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_4.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_4 = 3;

            } else if (o == 5) {

                lin_sport_me_sport_im_5.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_5.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_5 = 3;

            } else if (o == 6) {

                lin_sport_me_sport_im_6.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_6.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_6 = 3;

            } else if (o == 7) {

                lin_sport_me_sport_im_7.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_7.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_7 = 3;

            } else if (o == 8) {

                lin_sport_me_sport_im_8.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_8.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_8 = 3;

            } else if (o == 9) {

                lin_sport_me_sport_im_9.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_9.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_9 = 3;

            } else if (o == 10) {

                lin_sport_me_sport_im_10.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_10.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_10 = 3;

            } else if (o == 11) {

                lin_sport_me_sport_im_11.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_11.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_11 = 3;

            } else if (o == 12) {

                lin_sport_me_sport_im_12.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_12.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_12 = 3;

            } else if (o == 13) {

                lin_sport_me_sport_im_13.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_13.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_13 = 3;

            } else if (o == 14) {

                lin_sport_me_sport_im_14.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_14.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_14 = 3;

            } else if (o == 15) {

                lin_sport_me_sport_im_15.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_15.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_15 = 3;

            } else if (o == 16) {

                lin_sport_me_sport_im_16.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_16.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_16 = 3;

            } else if (o == 17) {

                lin_sport_me_sport_im_17.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_17.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_17 = 3;

            } else if (o == 18) {

                lin_sport_me_sport_im_18.setBackgroundResource(R.drawable.sport_me_backg_music_on);
                txt_sport_me_sport_im_18.setTextColor(getResources().getColor(R.color.background_sport));

                send_noe_18 = 3;

            }

        } else if (q == 2) {

            tedad_kol = tedad_kol - mo_1;

            if (o == 20) {

                lin_sport_me_sport_im_1.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_1.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_1 = 0;

            } else if (o == 21) {

                lin_sport_me_sport_im_2.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_2.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_2 = 0;

            } else if (o == 22) {

                lin_sport_me_sport_im_3.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_3.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_3 = 0;

            } else if (o == 23) {

                lin_sport_me_sport_im_4.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_4.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_4 = 0;

            } else if (o == 24) {

                lin_sport_me_sport_im_5.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_5.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_5 = 0;

            } else if (o == 25) {

                lin_sport_me_sport_im_6.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_6.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_6 = 0;

            } else if (o == 26) {

                lin_sport_me_sport_im_7.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_7.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_7 = 0;

            } else if (o == 27) {

                lin_sport_me_sport_im_8.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_8.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_8 = 0;

            } else if (o == 28) {

                lin_sport_me_sport_im_9.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_9.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_9 = 0;

            } else if (o == 29) {

                lin_sport_me_sport_im_10.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_10.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_10 = 0;

            } else if (o == 30) {

                lin_sport_me_sport_im_11.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_11.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_11 = 0;

            } else if (o == 31) {

                lin_sport_me_sport_im_12.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_12.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_12 = 0;

            } else if (o == 32) {

                lin_sport_me_sport_im_13.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_13.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_13 = 0;

            } else if (o == 33) {

                lin_sport_me_sport_im_14.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_14.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_14 = 0;

            } else if (o == 34) {

                lin_sport_me_sport_im_15.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_15.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_15 = 0;

            } else if (o == 35) {

                lin_sport_me_sport_im_16.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_16.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_16 = 0;

            } else if (o == 36) {

                lin_sport_me_sport_im_17.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_17.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_17 = 0;

            } else if (o == 37) {

                lin_sport_me_sport_im_18.setBackgroundResource(R.drawable.sport_me_backg_music);
                txt_sport_me_sport_im_18.setTextColor(getResources().getColor(R.color.color30day));

                send_noe_18 = 0;

            }
        }
        FirebaseCrash.log("log 5");
        System.gc();
    }



    public void time(int i) {

        try {

            vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (vibre_check == music_off_check) {
                vb.cancel();
            } else {
                vb.vibrate(100);
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("10"));
        }

        try {
            click = MediaPlayer.create(Sport_me_start.this, R.raw.button);
            if (music_check == music_off_check) {
                click.stop();
            } else {
                click.start();
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("11"));
        }

        if (i == 30) {

            try {

                btn_sport_me_time_30.setImageResource(R.drawable.sport_me_h30_on);
                btn_sport_me_time_45.setImageResource(R.drawable.sport_me_ti45_off);
                btn_sport_me_time_60.setImageResource(R.drawable.sport_me_ti60_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
                btn_sport_me_time_30.setImageResource(R.drawable.sport_me_h30_on);
            }

        } else if (i == 45) {

            try {

                btn_sport_me_time_30.setImageResource(R.drawable.sport_me_h30_off);
                btn_sport_me_time_45.setImageResource(R.drawable.sport_me_ti45_on);
                btn_sport_me_time_60.setImageResource(R.drawable.sport_me_ti60_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("13"));
                btn_sport_me_time_45.setImageResource(R.drawable.sport_me_ti45_on);
            }

        } else if (i == 60) {

            try {

                btn_sport_me_time_30.setImageResource(R.drawable.sport_me_h30_off);
                btn_sport_me_time_45.setImageResource(R.drawable.sport_me_ti45_off);
                btn_sport_me_time_60.setImageResource(R.drawable.sport_me_ti60_on);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("14"));
                btn_sport_me_time_60.setImageResource(R.drawable.sport_me_ti60_on);
            }

        }
        FirebaseCrash.log("log 4");
        System.gc();
    }

    public void time_reset(int i) {

        try {

            vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (vibre_check == music_off_check) {
                vb.cancel();
            } else {
                vb.vibrate(100);
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("15"));
        }

        try {
            click = MediaPlayer.create(Sport_me_start.this, R.raw.button);
            if (music_check == music_off_check) {
                click.stop();
            } else {
                click.start();
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("16"));
        }

        if (i == 10) {

            try {

                btn_sport_me_time_estraht_10.setImageResource(R.drawable.sport_me_h10_on);
                btn_sport_me_time_estraht_20.setImageResource(R.drawable.sport_me_h20_off);
                btn_sport_me_time_estraht_30.setImageResource(R.drawable.sport_me_h30_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("17"));
                btn_sport_me_time_estraht_10.setImageResource(R.drawable.sport_me_h10_on);
            }

        } else if (i == 20) {

            try {

                btn_sport_me_time_estraht_10.setImageResource(R.drawable.sport_me_h10_off);
                btn_sport_me_time_estraht_20.setImageResource(R.drawable.sport_me_h20_on);
                btn_sport_me_time_estraht_30.setImageResource(R.drawable.sport_me_h30_off);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("18"));
                btn_sport_me_time_estraht_20.setImageResource(R.drawable.sport_me_h20_on);
            }

        } else if (i == 30) {

            try {

                btn_sport_me_time_estraht_10.setImageResource(R.drawable.sport_me_h10_off);
                btn_sport_me_time_estraht_20.setImageResource(R.drawable.sport_me_h20_off);
                btn_sport_me_time_estraht_30.setImageResource(R.drawable.sport_me_h30_on);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("19"));
                btn_sport_me_time_estraht_30.setImageResource(R.drawable.sport_me_h30_on);
            }

        }
        FirebaseCrash.log("log 3");
        System.gc();
    }


    public void check_tedad() {

        if (tedad_kol >= a) {

            if (tedad_kol >= a && n_18 == 2) {

                haracat_varzshi(37, a);
                cal_18 = 0;
                n_18--;

            }

            if (tedad_kol >= a && n_17 == 2) {

                haracat_varzshi(36, a);
                cal_17 = 0;
                n_17--;

            }

            if (tedad_kol >= a && n_16 == 2) {

                haracat_varzshi(35, a);
                cal_16 = 0;
                n_16--;

            }

            if (tedad_kol >= a && n_15 == 2) {

                haracat_varzshi(34, a);
                cal_15 = 0;
                n_15--;

            }

            if (tedad_kol >= a && n_14 == 2) {

                haracat_varzshi(33, a);
                cal_14 = 0;
                n_14--;

            }

            if (tedad_kol >= a && n_13 == 2) {

                haracat_varzshi(32, a);
                cal_13 = 0;
                n_13--;

            }

            if (tedad_kol >= a && n_12 == 2) {

                haracat_varzshi(31, a);
                cal_12 = 0;
                n_12--;

            }

            if (tedad_kol >= a && n_11 == 2) {

                haracat_varzshi(30, a);
                cal_11 = 0;
                n_11--;

            }

            if (tedad_kol >= a && n_10 == 2) {

                haracat_varzshi(29, a);
                cal_10 = 0;
                n_10--;

            }

            if (tedad_kol >= a && n_9 == 2) {

                haracat_varzshi(28, a);
                cal_9 = 0;
                n_9--;

            }

            if (tedad_kol >= a && n_8 == 2) {

                haracat_varzshi(27, a);
                cal_8 = 0;
                n_8--;

            }

            if (tedad_kol >= a && n_7 == 2) {

                haracat_varzshi(26, a);
                cal_7 = 0;
                n_7--;

            }

            if (tedad_kol >= a && n_6 == 2) {

                haracat_varzshi(25, a);
                cal_6 = 0;
                n_6--;

            }

            if (tedad_kol >= a && n_5 == 2) {

                haracat_varzshi(24, a);
                cal_5 = 0;
                n_5--;

            }

            if (tedad_kol >= a && n_4 == 2) {

                haracat_varzshi(23, a);
                cal_4 = 0;
                n_4--;

            }

            if (tedad_kol >= a && n_3 == 2) {

                haracat_varzshi(22, a);
                cal_3 = 0;
                n_3--;

            }

            if (tedad_kol >= a && n_2 == 2) {

                haracat_varzshi(21, a);
                cal_2 = 0;
                n_2--;

            }

            if (tedad_kol >= a && n_1 == 2) {

                haracat_varzshi(20, a);
                cal_1 = 0;
                n_1--;

            }


        }
        FirebaseCrash.log("log 2");
        System.gc();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(Sport_me_start.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("20"));
            }

            try {
                click = MediaPlayer.create(Sport_me_start.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("21"));
            }

            finish();
            FirebaseCrash.log("log 1");
        }
        return false;
    }


}
