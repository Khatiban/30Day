package com.android.fury.a30day.sport;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_music;
import com.android.fury.a30day.Database.MyDatabaseHelper_voice;
import com.android.fury.a30day.R;
import com.android.fury.a30day.instagram;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

import com.android.fury.a30day.alert.SweetAlertDialog;

/**
 * Created by fury on 10/1/2016.
 */
public class sport_end extends Activity {

    TextView btn_sport_end_1, txt_sport_end_4, txt_sport_end_2;

    MyDatabaseHelper_music music_data;
    MyDatabaseHelper_voice voice_data;

    String music_check_1, fars, music_off_check_1, voice_check_1, voice_off_check_1;

    MediaPlayer music;

    ImageView im_aword_sport_end, im_aword_sport_end2, im_aword_sport_end3;


    private final int _splashTime = 500;
    private final int _splashTime2 = 12000;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

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

                fars = "fa";

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
        setContentView(R.layout.sport_e);

        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        final Bundle sport_v1 = getIntent().getExtras();

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


        try {

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
            FirebaseCrash.report(new Exception("4"));
        }


        try {

            music = MediaPlayer.create(sport_end.this, R.raw.theaward);
            if (music_check_1 == music_off_check_1) {
                music.stop();
            } else {
                music.start();
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("5"));
        }


        btn_sport_end_1 = (TextView) findViewById(R.id.btn_sport_end_1);
        txt_sport_end_4 = (TextView) findViewById(R.id.txt_sport_end_4);
        txt_sport_end_2 = (TextView) findViewById(R.id.txt_sport_end_2);
        im_aword_sport_end = (ImageView) findViewById(R.id.im_aword_sport_end);
        im_aword_sport_end2 = (ImageView) findViewById(R.id.im_aword_sport_end2);
        im_aword_sport_end3 = (ImageView) findViewById(R.id.im_aword_sport_end3);
        final CardView card_view_hp = (CardView) findViewById(R.id.card_view_hp);


        String fa = "fa";
        if (fars == fa) {
            try {

                txt_sport_end_4.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }


        }

        FirebaseCrash.log("log 2");


        final int page_day = sport_v1.getInt("sport_v_number_day_r");
        if (page_day == 1) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_1);

            new Handler().postDelayed(new Thread() {

                @Override
                public void run() {
                    super.run();
                    try {

                        card_view_hp.setVisibility(View.VISIBLE);
                        card_view_hp.setAnimation(AnimationUtils.loadAnimation(sport_end.this, R.anim.in));

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("7"));
                    }

                    try {

                        new Handler().postDelayed(new Thread() {

                            @Override
                            public void run() {
                                super.run();

                                new Handler().postDelayed(new Thread() {

                                    @Override
                                    public void run() {
                                        super.run();

                                        card_view_hp.setAnimation(AnimationUtils.loadAnimation(sport_end.this, R.anim.out));
                                        card_view_hp.setVisibility(View.GONE);

                                    }
                                }, _splashTime2);

                            }
                        }, _splashTime);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("8"));
                    }


                }
            }, _splashTime);

        } else if (page_day == 2) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_2);

        } else if (page_day == 3) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_3);

        } else if (page_day == 4) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_4);

        } else if (page_day == 5) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_5);

        } else if (page_day == 6) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_6);

        } else if (page_day == 7) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_7);

        } else if (page_day == 8) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_8);

        } else if (page_day == 9) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_9);

        } else if (page_day == 10) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_10);

        } else if (page_day == 11) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_11);

        } else if (page_day == 12) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_12);

        } else if (page_day == 13) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_13);

        } else if (page_day == 14) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_14);

        } else if (page_day == 15) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_15);

        } else if (page_day == 16) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_16);

        } else if (page_day == 17) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_17);

        } else if (page_day == 18) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_18);

        } else if (page_day == 19) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_19);

        } else if (page_day == 20) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_20);

        } else if (page_day == 21) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_21);

        } else if (page_day == 22) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_22);

        } else if (page_day == 23) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_23);

        } else if (page_day == 24) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_24);

        } else if (page_day == 25) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_25);

        } else if (page_day == 26) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_26);

        } else if (page_day == 27) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_27);

        } else if (page_day == 28) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_28);

        } else if (page_day == 29) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_29);

        } else if (page_day == 30) {

            txt_sport_end_2.setText(R.string.sport_end_txt_cup_30);

        }


        try {

            new Handler().postDelayed(new Thread() {

                @Override
                public void run() {
                    super.run();

                    new Handler().postDelayed(new Thread() {

                        @Override
                        public void run() {
                            super.run();

                            im_aword_sport_end.setVisibility(View.VISIBLE);
                            im_aword_sport_end2.setVisibility(View.VISIBLE);

                            new Handler().postDelayed(new Thread() {

                                @Override
                                public void run() {
                                    super.run();

                                    im_aword_sport_end.setVisibility(View.INVISIBLE);
                                    im_aword_sport_end2.setVisibility(View.INVISIBLE);
                                    im_aword_sport_end3.setVisibility(View.VISIBLE);


                                    new Handler().postDelayed(new Thread() {

                                        @Override
                                        public void run() {
                                            super.run();

                                            im_aword_sport_end.setVisibility(View.INVISIBLE);
                                            im_aword_sport_end2.setVisibility(View.INVISIBLE);
                                            im_aword_sport_end3.setVisibility(View.INVISIBLE);


                                        }
                                    }, _splashTime);

                                }
                            }, _splashTime);

                        }
                    }, _splashTime);


                }
            }, _splashTime);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("9"));
        }


        btn_sport_end_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (page_day == 1) {

                    int oneplay = one_play_preferences.getInt("insta", 1);

                    if (oneplay == 1) {
                        try {

                            Intent ins = new Intent(sport_end.this, instagram.class);
                            startActivity(ins);

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("10"));
                        }


                    } else {
                    }
                    finish();
                } else if (page_day == 10) {

                    int oneplay1 = one_play_preferences.getInt("insta", 1);

                    if (oneplay1 == 1) {

                        try {

                            Intent ins = new Intent(sport_end.this, instagram.class);
                            startActivity(ins);

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("11"));
                        }


                    } else {
                    }
                    finish();
                } else if (page_day == 20) {

                    int oneplay2 = one_play_preferences.getInt("insta", 1);

                    if (oneplay2 == 1) {

                        try {

                            Intent ins = new Intent(sport_end.this, instagram.class);
                            startActivity(ins);

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("12"));
                        }

                    } else {
                    }
                    finish();
                } else if (page_day == 30) {

                    final int oneplay3 = one_play_preferences.getInt("insta", 1);

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        if (oneplay3 == 1) {

                                            Intent ins = new Intent(sport_end.this, instagram.class);
                                            startActivity(ins);

                                        } else {
                                        }

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        if (oneplay3 == 1) {

                            Intent ins = new Intent(sport_end.this, instagram.class);
                            startActivity(ins);

                        } else {
                        }

                        finish();
                    }


                } else if (page_day == 21) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 22) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 23) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 24) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 25) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 26) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 27) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }


                } else if (page_day == 28) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        finish();
                    }

                } else if (page_day == 29) {

                    String ok = (String) getText(R.string.ok);
                    String titl = (String) getText(R.string.Help_sport_ez_ti);
                    String matn1 = (String) getText(R.string.Help_sport_ez_mt_1);
                    String matn2 = (String) getText(R.string.Help_sport_ez_mt_2);
                    String matn3 = (String) getText(R.string.Help_sport_ez_mt_3);
                    String matn = matn1
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn2
                            + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + matn3;

                    try {

                        new SweetAlertDialog(sport_end.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(titl)
                                .setContentText(matn)
                                .setConfirmText(ok)
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        finish();

                                    }
                                })
                                .show();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("13"));
                        finish();
                    }

                } else {

                    finish();

                }


            }
        });
        FirebaseCrash.log("log 1");
        System.gc();
    }
}
