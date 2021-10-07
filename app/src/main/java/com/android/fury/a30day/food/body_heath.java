package com.android.fury.a30day.food;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by fury on 9/21/2016.
 */
public class body_heath extends Activity implements View.OnClickListener {

    ImageView btn_menu_5;

    public static MediaPlayer click;

    String music_off_check, vibre_check, music_check;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    Double h_w, se, sea1, lbs, in1, in2, in3, in4, sea2, sea3, sea, sea4, sea5, sea6, sea7, sea8, sea9, sea10, sea11;

    private int CHECKED_STATE_4, CHECKED_STATE_5, CHECKED_STATE_6, CHECKED_STATE_7, CHECKED_STATE_8, CHECKED_STATE_9, CHECKED_STATE_10;

    DiscreteSeekBar seekbar_waist, seekbar_hip, seekbar_skelet, seekbar_fat, seekbar_fat2, seekbar_fat3, seekbar_fat4;

    TextView wist_1, hip_1, txt_food_health_2, txt_food_health_3, skelet_1, txt_food_skeleton_2, txt_food_skeleton_3, txt_food_fat_2_horof, txt_food_fat_3_horof, txt_food_fat_4_horof, txt_food_fat_5_horof, txt_food_fat_1, txt_food_fat_2, txt_food_health_1, txt_food_m_p_s_b_h, txt_food_skeleton_1, txt_food_m_p_s_b_sk, txt_food_fat, txt_food_m_p_s_fat_h;

    CardView card_view4, card_view6, card_view7;

    String strI_3, strI, strI_2, strI_1, send_wist, send_hip, end_w_h, strI_5, strI_6, send_skelet, strI_8, strI_9, strI_10, strI_11, strI_13, strI_12, strI_15, strI_14, send_fat_1, send_fat_2, send_fat_3, send_fat_4, end_fat, food_male_plan_10_23_m, food_male_plan_10_23_s, food_male_plan_10_23_b, food_male_plan_10_28_1, food_male_plan_10_28_2, food_male_plan_10_28_3, food_male_plan_10_28_4, food_male_plan_10_28_5, food_male_plan_10_28_6, food_male_plan_10_18_kh, food_male_plan_10_19_good, food_male_plan_10_19_vgood, wist_not, h_w_not, hip_not, gender_w, tall_w, weight_w;

    int minimumVal_1, minimumVal_2, minimumVal_3, minimumVal_4, minimumVal_5, minimumVal_6;


    public static SharedPreferences seek_weight_preferences, seek_old_preferences, seek_skelet_preferences, seek_fat_waist_preferences, seek_fat_for_preferences, seek_fat_hip_preferences, seek_fat_wrist_preferences;
    public static SharedPreferences.Editor seek_weight_editor, seek_old_editor, seek_skelet_editor, seek_fat_waist_editor, seek_fat_for_editor, seek_fat_hip_editor, seek_fat_wrist_editor;

    DecimalFormat df;

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


        //start activ
        setContentView(R.layout.body_h);


        // gerd konndeh adad
        df = new DecimalFormat("#.##");

        h_w_not = (String) getText(R.string.food_h_w_not);
        wist_not = (String) getText(R.string.food_waist_not);
        hip_not = (String) getText(R.string.food_hip_not);
        food_male_plan_10_18_kh = (String) getText(R.string.food_male_plan_10_18_kh);
        food_male_plan_10_19_good = (String) getText(R.string.food_male_plan_10_19_good);
        food_male_plan_10_19_vgood = (String) getText(R.string.food_male_plan_10_19_vgood);
        food_male_plan_10_23_s = (String) getText(R.string.food_male_plan_10_23_s);
        food_male_plan_10_23_m = (String) getText(R.string.food_male_plan_10_23_m);
        food_male_plan_10_23_b = (String) getText(R.string.food_male_plan_10_23_b);
        food_male_plan_10_28_1 = (String) getText(R.string.food_male_plan_10_28_1);
        food_male_plan_10_28_2 = (String) getText(R.string.food_male_plan_10_28_2);
        food_male_plan_10_28_3 = (String) getText(R.string.food_male_plan_10_28_3);
        food_male_plan_10_28_4 = (String) getText(R.string.food_male_plan_10_28_4);
        food_male_plan_10_28_5 = (String) getText(R.string.food_male_plan_10_28_5);
        food_male_plan_10_28_6 = (String) getText(R.string.food_male_plan_10_28_6);


        ImageView btn_food_body_3 = (ImageView) findViewById(R.id.btn_food_body_3);
        ImageView btn_food_body_2 = (ImageView) findViewById(R.id.btn_food_body_2);
        ImageView btn_food_body_1 = (ImageView) findViewById(R.id.btn_food_body_1);

        try {

            Bundle colery = getIntent().getExtras();
            gender_w = colery.getString("gender_food_3");
            tall_w = colery.getString("tall_food_3");
            weight_w = colery.getString("weight_food_meghdar_3");

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        try {

            seek_weight_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_weight_editor = seek_weight_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }

        try {

            seek_old_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_old_editor = seek_old_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }

        try {

            seek_skelet_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_skelet_editor = seek_skelet_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("5"));
        }

        try {

            seek_fat_waist_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_fat_waist_editor = seek_fat_waist_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("6"));
        }

        try {

            seek_fat_for_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_fat_for_editor = seek_fat_for_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("7"));
        }

        try {

            seek_fat_hip_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_fat_hip_editor = seek_fat_hip_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("8"));
        }

        try {

            seek_fat_wrist_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_fat_wrist_editor = seek_fat_wrist_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("9"));
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
            FirebaseCrash.report(new Exception("10"));
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
            FirebaseCrash.report(new Exception("11"));
        }


        btn_menu_5 = (ImageView) findViewById(R.id.btn_menu_5);

        btn_menu_5.setOnClickListener(this);


        seekbar_waist = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_k);
        seekbar_hip = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_b);

        wist_1 = (TextView) findViewById(R.id.txt_food_m_p_s_k_1);
        hip_1 = (TextView) findViewById(R.id.txt_food_m_p_s_b_1);
        txt_food_health_2 = (TextView) findViewById(R.id.txt_food_health_2);
        txt_food_health_3 = (TextView) findViewById(R.id.txt_food_health_3);

        card_view4 = (CardView) findViewById(R.id.card_view4_bo);

        txt_food_health_1 = (TextView) findViewById(R.id.txt_food_health_1);
        txt_food_m_p_s_b_h = (TextView) findViewById(R.id.txt_food_m_p_s_b_h);

        try {

            txt_food_health_1.setVisibility(View.GONE);
            txt_food_m_p_s_b_h.setVisibility(View.GONE);
            txt_food_health_2.setVisibility(View.GONE);
            txt_food_health_3.setVisibility(View.GONE);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("12"));
        }


        minimumVal_5 = 51;

        try {

            CHECKED_STATE_5 = seek_weight_preferences.getInt("seek_waist_1", 50);
            seekbar_waist.setProgress(CHECKED_STATE_5);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("13"));
        }
        strI_3 = String.valueOf(CHECKED_STATE_5);
        if (CHECKED_STATE_5 >= minimumVal_5) {
            wist_1.setText(strI_3);
        } else {
            wist_1.setText("50");
        }
        seekbar_waist.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_weight_editor.putInt("seek_waist_1", value);
                    seek_weight_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("14"));
                }


                strI = String.valueOf(value);

                if (value >= minimumVal_5) {
                    try {

                        seekbar_waist.setProgress(value);
                        wist_1.setText(strI);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("15"));
                    }

                } else {
                    wist_1.setText("50");
                }
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        try {

            CHECKED_STATE_4 = seek_old_preferences.getInt("seek_hip_1", 50);
            seekbar_hip.setProgress(CHECKED_STATE_4);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("16"));
        }
        strI_2 = String.valueOf(CHECKED_STATE_4);
        if (CHECKED_STATE_4 >= minimumVal_5) {
            hip_1.setText(strI_2);
        } else {
            hip_1.setText("50");
        }
        seekbar_hip.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_old_editor.putInt("seek_hip_1", value);
                    seek_old_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }


                strI_1 = String.valueOf(value);

                if (value >= minimumVal_5) {
                    try {

                        seekbar_hip.setProgress(value);
                        hip_1.setText(strI_1);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("18"));
                    }

                } else {

                    hip_1.setText("50");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        card_view6 = (CardView) findViewById(R.id.card_view6_bo);

        txt_food_skeleton_2 = (TextView) findViewById(R.id.txt_food_skeleton_2);
        txt_food_skeleton_3 = (TextView) findViewById(R.id.txt_food_skeleton_3);
        skelet_1 = (TextView) findViewById(R.id.txt_food_m_p_s_sk_1);
        txt_food_skeleton_1 = (TextView) findViewById(R.id.txt_food_skeleton_1);
        txt_food_m_p_s_b_sk = (TextView) findViewById(R.id.txt_food_m_p_s_b_sk);
        seekbar_skelet = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_sk);

        try {

            txt_food_skeleton_2.setVisibility(View.GONE);
            txt_food_skeleton_3.setVisibility(View.GONE);
            txt_food_skeleton_1.setVisibility(View.GONE);
            txt_food_m_p_s_b_sk.setVisibility(View.GONE);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("19"));
        }


        minimumVal_6 = 10;

        try {

            CHECKED_STATE_6 = seek_skelet_preferences.getInt("seek_skelet_1", 10);
            seekbar_skelet.setProgress(CHECKED_STATE_6);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("20"));
        }
        strI_5 = String.valueOf(CHECKED_STATE_6);
        if (CHECKED_STATE_6 >= minimumVal_6) {
            skelet_1.setText(strI_5);
        } else {
            skelet_1.setText("10");
        }
        seekbar_skelet.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_skelet_editor.putInt("seek_skelet_1", value);
                    seek_skelet_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("21"));
                }


                strI_6 = String.valueOf(value);

                if (value >= minimumVal_6) {
                    try {

                        seekbar_skelet.setProgress(value);
                        skelet_1.setText(strI_6);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("22"));
                    }

                } else {

                    skelet_1.setText("10");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        card_view7 = (CardView) findViewById(R.id.card_view7_bo);

        txt_food_fat_2_horof = (TextView) findViewById(R.id.txt_food_m_p_fat_1);
        txt_food_fat_3_horof = (TextView) findViewById(R.id.txt_food_m_p_fat_b_1);
        txt_food_fat_4_horof = (TextView) findViewById(R.id.txt_food_m_p_s_fat_2);
        txt_food_fat_5_horof = (TextView) findViewById(R.id.txt_food_m_p_s_fat_3);
        txt_food_fat = (TextView) findViewById(R.id.txt_food_fat_1);
        txt_food_m_p_s_fat_h = (TextView) findViewById(R.id.txt_food_m_p_s_fat_h);
        txt_food_fat_1 = (TextView) findViewById(R.id.txt_food_fat_2);
        txt_food_fat_2 = (TextView) findViewById(R.id.txt_food_fat_3);
        seekbar_fat = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_fat);
        seekbar_fat2 = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_fat2);
        seekbar_fat3 = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_fat3);
        seekbar_fat4 = (DiscreteSeekBar) findViewById(R.id.seekbar_m_p_fat4);

        try {

            txt_food_fat.setVisibility(View.GONE);
            txt_food_m_p_s_fat_h.setVisibility(View.GONE);
            txt_food_fat_1.setVisibility(View.GONE);
            txt_food_fat_2.setVisibility(View.GONE);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("23"));
        }


        minimumVal_1 = 20;
        minimumVal_2 = 50;
        minimumVal_3 = 30;
        minimumVal_4 = 10;


        try {

            CHECKED_STATE_7 = seek_fat_wrist_preferences.getInt("seek_fat_1", 20);
            seekbar_fat.setProgress(CHECKED_STATE_7);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("24"));
        }
        strI_8 = String.valueOf(CHECKED_STATE_7);
        if (CHECKED_STATE_7 >= minimumVal_1) {
            txt_food_fat_2_horof.setText(strI_8);
        } else {
            txt_food_fat_2_horof.setText("20");
        }
        seekbar_fat.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_fat_wrist_editor.putInt("seek_fat_1", value);
                    seek_fat_wrist_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("25"));
                }


                strI_9 = String.valueOf(value);

                if (value >= minimumVal_1) {
                    try {

                        seekbar_fat.setProgress(value);
                        txt_food_fat_2_horof.setText(strI_9);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("26"));
                    }

                } else {

                    txt_food_fat_2_horof.setText("20");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        try {

            CHECKED_STATE_8 = seek_fat_waist_preferences.getInt("seek_fat_2", 50);
            seekbar_fat2.setProgress(CHECKED_STATE_8);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("27"));
        }
        strI_10 = String.valueOf(CHECKED_STATE_8);
        if (CHECKED_STATE_8 >= minimumVal_2) {
            txt_food_fat_3_horof.setText(strI_10);
        } else {
            txt_food_fat_3_horof.setText("50");
        }
        seekbar_fat2.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_fat_waist_editor.putInt("seek_fat_2", value);
                    seek_fat_waist_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("28"));
                }


                strI_11 = String.valueOf(value);

                if (value >= minimumVal_2) {
                    try {

                        seekbar_fat2.setProgress(value);
                        txt_food_fat_3_horof.setText(strI_11);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("29"));
                    }

                } else {

                    txt_food_fat_3_horof.setText("50");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        try {

            CHECKED_STATE_9 = seek_fat_hip_preferences.getInt("seek_fat_3", 30);
            seekbar_fat3.setProgress(CHECKED_STATE_9);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("30"));
        }
        strI_12 = String.valueOf(CHECKED_STATE_9);
        if (CHECKED_STATE_9 >= minimumVal_3) {
            txt_food_fat_4_horof.setText(strI_12);
        } else {
            txt_food_fat_4_horof.setText("30");
        }
        seekbar_fat3.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_fat_hip_editor.putInt("seek_fat_3", value);
                    seek_fat_hip_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("31"));
                }


                strI_13 = String.valueOf(value);

                if (value >= minimumVal_3) {
                    try {

                        seekbar_fat3.setProgress(value);
                        txt_food_fat_4_horof.setText(strI_13);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("32"));
                    }

                } else {

                    txt_food_fat_4_horof.setText("30");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        try {

            CHECKED_STATE_10 = seek_fat_for_preferences.getInt("seek_fat_4", 10);
            seekbar_fat4.setProgress(CHECKED_STATE_10);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("33"));
        }
        strI_14 = String.valueOf(CHECKED_STATE_10);
        if (CHECKED_STATE_10 >= minimumVal_4) {
            txt_food_fat_5_horof.setText(strI_14);
        } else {
            txt_food_fat_5_horof.setText("10");
        }
        seekbar_fat4.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_fat_for_editor.putInt("seek_fat_4", value);
                    seek_fat_for_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("34"));
                }


                strI_15 = String.valueOf(value);

                if (value >= minimumVal_4) {
                    try {

                        seekbar_fat4.setProgress(value);
                        txt_food_fat_5_horof.setText(strI_15);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("35"));
                    }

                } else {

                    txt_food_fat_5_horof.setText("10");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
            }
        });


        btn_food_body_3.setOnClickListener(this);
        btn_food_body_2.setOnClickListener(this);
        btn_food_body_1.setOnClickListener(this);

        FirebaseCrash.log("log 3");
        System.gc();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu_5:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("36"));
                }
                try {

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("37"));
                }


                finish();
                break;
            case R.id.btn_food_body_3:

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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }

                try {

                    txt_food_health_1.setVisibility(View.VISIBLE);
                    txt_food_m_p_s_b_h.setVisibility(View.VISIBLE);
                    txt_food_health_2.setVisibility(View.VISIBLE);
                    txt_food_health_3.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("40"));
                }


                int waist_age_s = seek_weight_preferences.getInt("seek_waist_1", 50);
                int hip_age_s = seek_old_preferences.getInt("seek_hip_1", 50);


                if (waist_age_s == 50 && hip_age_s == 50) {

                    Toast.makeText(body_heath.this, h_w_not, Toast.LENGTH_LONG).show();

                } else if (waist_age_s != 50 && hip_age_s == 50) {

                    Toast.makeText(body_heath.this, hip_not, Toast.LENGTH_LONG).show();

                } else if (waist_age_s == 50 && hip_age_s != 50) {

                    Toast.makeText(body_heath.this, wist_not, Toast.LENGTH_LONG).show();

                } else if (waist_age_s != 50 && hip_age_s != 50) {

                    try {

                        send_wist = String.valueOf(seek_weight_preferences.getInt("seek_waist_1", 50));
                        send_hip = String.valueOf(seek_old_preferences.getInt("seek_hip_1", 50));

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("41"));
                    }


                    if (gender_w.length() == 4) {

                        h_w = (Double.parseDouble(send_wist) / Double.parseDouble(send_hip));
                        end_w_h = String.valueOf(h_w);

                        txt_food_health_2.setText(end_w_h);

                        if (h_w >= 1) {
                            txt_food_health_3.setText(food_male_plan_10_18_kh);
                        } else if (h_w <= 0.99 && h_w >= 0.89) {

                            txt_food_health_3.setText(food_male_plan_10_19_good);

                        } else if (h_w <= 0.88 && h_w >= 0.20) {

                            txt_food_health_3.setText(food_male_plan_10_19_vgood);

                        }

                    } else if (gender_w.length() == 6) {

                        h_w = (Double.parseDouble(send_wist) / Double.parseDouble(send_hip));

                        end_w_h = String.valueOf(h_w);

                        txt_food_health_2.setText(end_w_h);

                        if (h_w >= 1) {

                            txt_food_health_3.setText(food_male_plan_10_18_kh);

                        } else if (h_w <= 0.99 && h_w >= 0.50) {

                            txt_food_health_3.setText(food_male_plan_10_19_good);

                        } else if (h_w <= 0.49 && h_w >= 0.20) {

                            txt_food_health_3.setText(food_male_plan_10_19_vgood);

                        }
                    }
                }


                break;


            case R.id.btn_food_body_2:

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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("43"));
                }


                try {

                    txt_food_skeleton_2.setVisibility(View.VISIBLE);
                    txt_food_skeleton_3.setVisibility(View.VISIBLE);
                    txt_food_skeleton_1.setVisibility(View.VISIBLE);
                    txt_food_m_p_s_b_sk.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }


                if (gender_w.length() == 4) {

                    try {

                        send_skelet = String.valueOf(seek_skelet_preferences.getInt("seek_skelet_1", 10));

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("45"));
                    }


                    se = (Double.parseDouble(tall_w) / Double.parseDouble(send_skelet));
                    end_w_h = String.valueOf(se);

                    txt_food_skeleton_2.setText(end_w_h);

                    if (se >= 10.4) {
                        txt_food_skeleton_3.setText(food_male_plan_10_23_s);
                    } else if (se <= 10.3 && se >= 9.6) {

                        txt_food_skeleton_3.setText(food_male_plan_10_23_m);

                    } else if (se <= 9.5) {

                        txt_food_skeleton_3.setText(food_male_plan_10_23_b);

                    }

                } else if (gender_w.length() == 6) {

                    try {

                        send_skelet = String.valueOf(seek_skelet_preferences.getInt("seek_skelet_1", 10));

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("46"));
                    }


                    se = (Double.parseDouble(tall_w) / Double.parseDouble(send_skelet));

                    end_w_h = String.valueOf(se);

                    txt_food_skeleton_2.setText(end_w_h);

                    if (se >= 11) {

                        txt_food_skeleton_3.setText(food_male_plan_10_23_s);

                    } else if (se <= 10.99 && se >= 10.1) {

                        txt_food_skeleton_3.setText(food_male_plan_10_23_m);

                    } else if (se <= 10) {

                        txt_food_skeleton_3.setText(food_male_plan_10_23_b);

                    }

                }


                break;

            case R.id.btn_food_body_1:

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

                    click = MediaPlayer.create(this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("48"));
                }

                try {

                    txt_food_fat.setVisibility(View.VISIBLE);
                    txt_food_m_p_s_fat_h.setVisibility(View.VISIBLE);
                    txt_food_fat_1.setVisibility(View.VISIBLE);
                    txt_food_fat_2.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("49"));
                }


                if (gender_w.length() == 4) {

                    try {

                        send_fat_1 = String.valueOf(seek_fat_wrist_preferences.getInt("seek_fat_1", 20));
                        send_fat_2 = String.valueOf(seek_fat_waist_preferences.getInt("seek_fat_2", 50));
                        send_fat_3 = String.valueOf(seek_fat_hip_preferences.getInt("seek_fat_3", 30));
                        send_fat_4 = String.valueOf(seek_fat_for_preferences.getInt("seek_fat_4", 10));

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("50"));
                    }


                    lbs = (Double.parseDouble(weight_w) * 2.2046);
                    in1 = (Double.parseDouble(send_fat_1) / 2.54);
                    in2 = (Double.parseDouble(send_fat_2) / 2.54);
                    in3 = (Double.parseDouble(send_fat_3) / 2.54);
                    in4 = (Double.parseDouble(send_fat_4) / 2.54);


                    sea1 = ((lbs * 1.082) + 94.42);
                    sea2 = (sea1 - (in2 * 4.15));
                    sea3 = ((lbs - sea2) * 100);

                    sea = (sea3 / lbs);
                    sea = Double.valueOf(df.format(sea));
                    end_fat = String.valueOf(sea);

                    txt_food_fat_1.setText(end_fat);

                    if (sea <= 1.99) {

                        txt_food_fat_2.setText(food_male_plan_10_28_1);

                    } else if (sea >= 2 && sea <= 5.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_2);

                    } else if (sea >= 6 && sea <= 13.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_3);

                    } else if (sea >= 14 && sea <= 17.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_4);

                    } else if (sea >= 18 && sea <= 24.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_5);

                    } else if (sea >= 25) {

                        txt_food_fat_2.setText(food_male_plan_10_28_6);

                    }


                } else if (gender_w.length() == 6) {

                    try {

                        send_fat_1 = String.valueOf(seek_fat_wrist_preferences.getInt("seek_fat_1", 20));
                        send_fat_2 = String.valueOf(seek_fat_waist_preferences.getInt("seek_fat_2", 50));
                        send_fat_3 = String.valueOf(seek_fat_hip_preferences.getInt("seek_fat_3", 30));
                        send_fat_4 = String.valueOf(seek_fat_for_preferences.getInt("seek_fat_4", 10));

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("51"));
                    }


                    lbs = (Double.parseDouble(weight_w) * 2.2046);
                    in1 = (Double.parseDouble(send_fat_1) / 2.54);
                    in2 = (Double.parseDouble(send_fat_2) / 2.54);
                    in3 = (Double.parseDouble(send_fat_3) / 2.54);
                    in4 = (Double.parseDouble(send_fat_4) / 2.54);


                    sea1 = (lbs * 0.732);
                    sea2 = (sea1 + 8.987);
                    sea3 = (in1 / 3.14);
                    sea4 = (in2 * 0.157);
                    sea5 = (in3 * 0.249);
                    sea6 = (in4 * 0.434);
                    sea7 = (sea2 + sea3);
                    sea8 = (sea7 - sea4);
                    sea9 = (sea8 - sea5);
                    sea10 = (sea9 + sea6);
                    sea11 = ((lbs - sea10) * 100);


                    sea = (sea11 / lbs);
                    sea = Double.valueOf(df.format(sea));
                    end_fat = String.valueOf(sea);

                    txt_food_fat_1.setText(end_fat);


                    if (sea <= 9.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_1);

                    } else if (sea >= 10 && sea <= 13.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_2);

                    } else if (sea >= 14 && sea <= 20.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_3);

                    } else if (sea >= 21 && sea <= 24.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_4);

                    } else if (sea >= 25 && sea <= 31.999) {

                        txt_food_fat_2.setText(food_male_plan_10_28_5);

                    } else if (sea >= 32) {

                        txt_food_fat_2.setText(food_male_plan_10_28_6);

                    }


                }


                break;


        }
        FirebaseCrash.log("log 2");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(body_heath.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("52"));
            }
            try {

                click = MediaPlayer.create(this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("53"));
            }
            FirebaseCrash.log("log 1");
            finish();
        }
        return false;
    }
}
