package com.android.fury.a30day.menu_view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_flag;
import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by Fury on 8/23/2016.
 */
public class setting_language extends Activity implements View.OnClickListener {


    Button btnback;

    ImageView btnen, btnfr, btngr, btnusa, btnch, btnfa;

    TextView txt_sit_title;

    MediaPlayer click;

    Vibrator vb;

    String music_check, music_off_check, vibre_check, id_flag, lan, id;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;
    MyDatabaseHelper_flag flag_data;

    SharedPreferences preferences_fa_font;
    SharedPreferences.Editor nameEditor_fa_font;

    MyDatabaseHelper_lan language;

    int back_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language);

        try {

            Bundle sitting_b = getIntent().getExtras();
            back_b = sitting_b.getInt("setting_back");

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

        try {

            language = new MyDatabaseHelper_lan(this);
            flag_data = new MyDatabaseHelper_flag(this);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        Cursor r_lan = language.showAllData();
        StringBuffer dadeha = new StringBuffer();
        while (r_lan.moveToNext()) {
            dadeha.append(r_lan.getString(1));
        }
        if (dadeha.toString().length() == 1) {
            //farsi
            try {

                Locale locale = new Locale("fa");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("3"));
            }


        } else if (dadeha.toString().length() == 2) {
            //english.usa.canada
            try {

                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("4"));
            }


        } else if (dadeha.toString().length() == 3) {
            //chine
            try {

                Locale locale = new Locale("zh");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("5"));
            }


        } else if (dadeha.toString().length() == 6) {
            //german
            try {

                Locale locale = new Locale("de");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }


        }


        try {

            preferences_fa_font = PreferenceManager.getDefaultSharedPreferences(this);
            nameEditor_fa_font = preferences_fa_font.edit();
            nameEditor_fa_font.putInt("font_langu_1", 2);
            nameEditor_fa_font.apply();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("7"));
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
            FirebaseCrash.report(new Exception("8"));
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
            FirebaseCrash.report(new Exception("9"));
        }


        btnback = (Button) findViewById(R.id.btn_sit_background);
        btnen = (ImageView) findViewById(R.id.im_sit_en);
        btnfa = (ImageView) findViewById(R.id.im_sit_fa);
        btnfr = (ImageView) findViewById(R.id.im_sit_fr);
        btngr = (ImageView) findViewById(R.id.im_sit_gr);
        btnusa = (ImageView) findViewById(R.id.im_sit_usa);
        btnch = (ImageView) findViewById(R.id.im_sit_ch);
        txt_sit_title = (TextView) findViewById(R.id.txt_sit_title);


        btnback.setOnClickListener(this);
        btnen.setOnClickListener(this);
        btnfa.setOnClickListener(this);
        btnfr.setOnClickListener(this);
        btngr.setOnClickListener(this);
        btnusa.setOnClickListener(this);
        btnch.setOnClickListener(this);

        FirebaseCrash.log("log 3");
        System.gc();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_sit_background:

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

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }


                Intent uou = new Intent(setting_language.this, setting.class);
                uou.putExtra("setting_back", back_b);
                this.overridePendingTransition(R.anim.out,
                        R.anim.in);
                startActivity(uou);
                finish();
                break;

            case R.id.im_sit_fa:

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

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("13"));
                }

                id = "1";
                lan = "f";
                try {

                    language.deleteData(id);
                    language.insertData(lan, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("14"));
                }


                try {

                    nameEditor_fa_font.putInt("font_langu_1", 2);
                    nameEditor_fa_font.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }


                id_flag = "1";
                String flag_fa = "fa";
                try {

                    flag_data.deleteData(id_flag);
                    flag_data.insertData(flag_fa, id_flag);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                }


                try {

                    String languageToLoad_fa = "fa";
                    Locale locale_fa = new Locale(languageToLoad_fa);
                    Locale.setDefault(locale_fa);
                    Configuration config_fa = new Configuration();
                    config_fa.locale = locale_fa;
                    getBaseContext().getResources().updateConfiguration(config_fa,
                            getBaseContext().getResources().getDisplayMetrics());

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }


                txt_sit_title.setText(R.string.setting_language);


                break;

            case R.id.im_sit_en:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                }

                try {

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("19"));
                }


                id = "1";
                lan = "en";
                try {

                    language.deleteData(id);
                    language.insertData(lan, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("20"));
                }

                try {

                    nameEditor_fa_font.putInt("font_langu_1", 1);
                    nameEditor_fa_font.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("21"));
                }


                id_flag = "1";
                String flag_en = "eng";
                try {

                    flag_data.deleteData(id_flag);
                    flag_data.insertData(flag_en, id_flag);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("22"));
                }


                try {

                    String languageToLoad_en = "en";
                    Locale locale_en = new Locale(languageToLoad_en);
                    Locale.setDefault(locale_en);
                    Configuration config_en = new Configuration();
                    config_en.locale = locale_en;
                    getBaseContext().getResources().updateConfiguration(config_en,
                            getBaseContext().getResources().getDisplayMetrics());


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("23"));
                }


                txt_sit_title.setText(R.string.setting_language);


                break;

            case R.id.im_sit_usa:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("24"));
                }

                try {

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("25"));
                }


                id = "1";
                lan = "en";
                try {

                    language.deleteData(id);
                    language.insertData(lan, id);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("26"));
                }

                try {

                    nameEditor_fa_font.putInt("font_langu_1", 1);
                    nameEditor_fa_font.apply();


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("27"));
                }


                try {

                    id_flag = "1";
                    String flag_usa = "usai";
                    flag_data.deleteData(id_flag);
                    flag_data.insertData(flag_usa, id_flag);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("28"));
                }


                try {

                    String languageToLoad_usa = "en";
                    Locale locale_usa = new Locale(languageToLoad_usa);
                    Locale.setDefault(locale_usa);
                    Configuration config_usa = new Configuration();
                    config_usa.locale = locale_usa;
                    getBaseContext().getResources().updateConfiguration(config_usa,
                            getBaseContext().getResources().getDisplayMetrics());


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("29"));
                }


                txt_sit_title.setText(R.string.setting_language);


                break;

            case R.id.im_sit_ch:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("30"));
                }

                try {

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("31"));
                }


                id = "1";
                lan = "chi";
                try {

                    language.deleteData(id);
                    language.insertData(lan, id);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("32"));
                }


                try {

                    nameEditor_fa_font.putInt("font_langu_1", 1);
                    nameEditor_fa_font.apply();


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("33"));
                }


                id_flag = "1";
                String flag_ch = "china";

                try {

                    flag_data.deleteData(id_flag);
                    flag_data.insertData(flag_ch, id_flag);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("34"));
                }


                try {

                    String languageToLoad_ch = "zh";
                    Locale locale_ch = new Locale(languageToLoad_ch);
                    Locale.setDefault(locale_ch);
                    Configuration config_ch = new Configuration();
                    config_ch.locale = locale_ch;
                    getBaseContext().getResources().updateConfiguration(config_ch,
                            getBaseContext().getResources().getDisplayMetrics());


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("35"));
                }


                txt_sit_title.setText(R.string.setting_language);


                break;

            case R.id.im_sit_fr:

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

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("37"));
                }

                id = "1";
                lan = "en";
                try {

                    language.deleteData(id);
                    language.insertData(lan, id);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("38"));
                }


                try {

                    nameEditor_fa_font.putInt("font_langu_1", 1);
                    nameEditor_fa_font.apply();


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }


                id_flag = "1";
                String flag_ca = "canada";
                try {

                    flag_data.deleteData(id_flag);
                    flag_data.insertData(flag_ca, id_flag);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("40"));
                }


                try {

                    String languageToLoad_ca = "en";
                    Locale locale_ca = new Locale(languageToLoad_ca);
                    Locale.setDefault(locale_ca);
                    Configuration config_ca = new Configuration();
                    config_ca.locale = locale_ca;
                    getBaseContext().getResources().updateConfiguration(config_ca,
                            getBaseContext().getResources().getDisplayMetrics());


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("41"));
                }


                txt_sit_title.setText(R.string.setting_language);


                break;

            case R.id.im_sit_gr:

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

                    click = MediaPlayer.create(setting_language.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("43"));
                }


                id = "1";
                lan = "german";
                try {

                    language.deleteData(id);
                    language.insertData(lan, id);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }


                try {

                    nameEditor_fa_font.putInt("font_langu_1", 3);
                    nameEditor_fa_font.apply();


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("45"));
                }


                id_flag = "1";
                String flag_gr = "germany";
                try {

                    flag_data.deleteData(id_flag);
                    flag_data.insertData(flag_gr, id_flag);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("46"));
                }

                try {

                    String languageToLoad_gr = "de";
                    Locale locale_gr = new Locale(languageToLoad_gr);
                    Locale.setDefault(locale_gr);
                    Configuration config_gr = new Configuration();
                    config_gr.locale = locale_gr;
                    getBaseContext().getResources().updateConfiguration(config_gr,
                            getBaseContext().getResources().getDisplayMetrics());


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("47"));
                }


                txt_sit_title.setText(R.string.setting_language);


                break;


        }
        FirebaseCrash.log("log 2");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(setting_language.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("48"));
            }

            try {

                click = MediaPlayer.create(setting_language.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("49"));
            }


            Intent uou = new Intent(setting_language.this, setting.class);
            uou.putExtra("setting_back", back_b);
            startActivity(uou);
            finish();
            FirebaseCrash.log("log 1");
        }
        return false;
    }

}
