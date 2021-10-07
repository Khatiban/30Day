package com.android.fury.a30day.menu_view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.page.Page_2;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;


public class about extends Activity implements View.OnClickListener {

    Button about_back, instagram, email, phone;

    MediaPlayer click;

    String about_alertdialog_1, about_alertdialog_4_1, go, about_alertdialog_2, about_alertdialog_12, about_alertdialog_4, about_alertdialog_10, about_alertdialog_11, OK, music_check, music_off_check, vibre_check;

    Vibrator vb;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;
    MyDatabaseHelper_lan language;

    int sport_page;

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


        //start activ
        setContentView(R.layout.about);

        Bundle sitting_b = getIntent().getExtras();
        sport_page = sitting_b.getInt("about_back");


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


        about_back = (Button) findViewById(R.id.about_back);
        email = (Button) findViewById(R.id.about_email);
        phone = (Button) findViewById(R.id.about_tel);
        instagram = (Button) findViewById(R.id.about_inestagram);

        about_back.setOnClickListener(this);
        email.setOnClickListener(this);
        phone.setOnClickListener(this);
        instagram.setOnClickListener(this);

        about_alertdialog_1 = (String) getText(R.string.about_alertdialog_1);
        about_alertdialog_2 = (String) getText(R.string.about_alertdialog_2);
        about_alertdialog_4 = (String) getText(R.string.about_alertdialog_4);
        about_alertdialog_10 = (String) getText(R.string.about_alertdialog_10);
        about_alertdialog_11 = (String) getText(R.string.about_alertdialog_11);
        about_alertdialog_12 = (String) getText(R.string.about_alertdialog_12);
        about_alertdialog_4_1 = (String) getText(R.string.about_alertdialog_4_1);
        OK = (String) getText(R.string.ok);
        go = (String) getText(R.string.go);

        FirebaseCrash.log("log 3");
        System.gc();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.about_back:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("4"));
                }

                try {

                    click = MediaPlayer.create(about.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("5"));
                }


                if (sport_page == 2) {
                    Intent ssss = new Intent(about.this, Page_2.class);
                    startActivity(ssss);
                } else if (sport_page == 4) {
                } else {

                }
                finish();
                break;

            case R.id.about_email:

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

                    click = MediaPlayer.create(about.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("7"));
                }

                SweetAlertDialog sd = new SweetAlertDialog(this);
                sd.setTitleText(about_alertdialog_1);
                sd.setContentText(about_alertdialog_2);
                sd.setCustomImage(R.drawable.about_email);
                sd.setCancelText(OK);
                sd.setConfirmText(about_alertdialog_12);
                sd.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
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
                            FirebaseCrash.report(new Exception("8"));
                        }

                        try {

                            click = MediaPlayer.create(about.this, R.raw.button);
                            if (music_check == music_off_check) {
                                click.stop();
                            } else {
                                click.start();
                            }

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("9"));
                        }

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.setType("text/html");
                        email.putExtra(Intent.EXTRA_EMAIL, "furystudio1@gmail.com");
                        email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                        email.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                        startActivity(email);
                    }
                });
                sd.show();
                break;

            case R.id.about_inestagram:

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

                    click = MediaPlayer.create(about.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }

                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText(about_alertdialog_4)
                        .setContentText(about_alertdialog_4_1)
                        .setCustomImage(R.drawable.about_inestagram)
                        .setCancelText(OK)
                        .setConfirmText(go)
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
                                    FirebaseCrash.report(new Exception("12"));
                                }

                                try {

                                    click = MediaPlayer.create(about.this, R.raw.button);
                                    if (music_check == music_off_check) {
                                        click.stop();
                                    } else {
                                        click.start();
                                    }

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("13"));
                                }

                                Uri uri = Uri.parse("http://instagram.com/_u/fury_studio_ir");
                                Intent inestagram = new Intent(Intent.ACTION_VIEW, uri);
                                inestagram.setPackage("com.instagram.android");
                                try {
                                    startActivity(inestagram);
                                } catch (ActivityNotFoundException e) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://instagram.com/fury_studio_ir")));
                                }
                            }
                        })
                        .show();
                break;

            case R.id.about_tel:

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

                    click = MediaPlayer.create(about.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }


                try {

                    new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                            .setTitleText(about_alertdialog_10)
                            .setContentText(null)
                            .setCancelText(OK)
                            .setConfirmText(about_alertdialog_11)
                            .setCustomImage(R.drawable.about_tel)
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
                                        FirebaseCrash.report(new Exception("16"));
                                    }

                                    try {

                                        click = MediaPlayer.create(about.this, R.raw.button);
                                        if (music_check == music_off_check) {
                                            click.stop();
                                        } else {
                                            click.start();
                                        }

                                    } catch (Exception e) {
                                        FirebaseCrash.report(new Exception("17"));
                                    }

                                    Intent Cal = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+989152280935"));
                                    startActivity(Cal);
                                }
                            })
                            .show();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                    Intent Cal = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+989152280935"));
                    startActivity(Cal);
                }

                break;

        }
        FirebaseCrash.log("log 2");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(about.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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

                click = MediaPlayer.create(about.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("20"));
            }

            if (sport_page == 2) {
                Intent ssss = new Intent(about.this, Page_2.class);
                startActivity(ssss);
            } else if (sport_page == 4) {
            } else {

            }
            finish();
            FirebaseCrash.log("log 1");
        }
        return false;
    }
}
