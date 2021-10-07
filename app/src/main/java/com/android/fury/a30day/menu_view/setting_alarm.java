package com.android.fury.a30day.menu_view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.SwitchCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.android.fury.a30day.alarm.DialogUniversalInfoUtils;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by fury on 3/5/2017.
 */
public class setting_alarm extends Activity {

    MediaPlayer click;

    Vibrator vb;

    String music_check, music_off_check, vibre_check;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;
    MyDatabaseHelper_lan language;

    ImageView im_setting_alarm_1,im_setting_alarm_2,im_setting_alarm_3,im_setting_alarm_4,im_setting_alarm_5,im_setting_alarm_6;

    TextView txt_sit_why;

    SwitchCompat checkBox_Sit_alarm_sobhane, checkBox_Sit_alarm_myanvade_1, checkBox_Sit_alarm_nahar , checkBox_Sit_alarm_myanvade_2, checkBox_Sit_alarm_sport ,checkBox_Sit_alarm_sham ;

    private SharedPreferences alarm_preferences;
    private SharedPreferences.Editor alarm_editor;
    private boolean CHECKED_STATE, CHECKED_STATE_2, CHECKED_STATE_3, CHECKED_STATE_4, CHECKED_STATE_5 , CHECKED_STATE_6;

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


        setContentView(R.layout.alarm);


        im_setting_alarm_1 = (ImageView) findViewById(R.id.im_setting_alarm_1);
        im_setting_alarm_2 = (ImageView) findViewById(R.id.im_setting_alarm_2);
        im_setting_alarm_3 = (ImageView) findViewById(R.id.im_setting_alarm_3);
        im_setting_alarm_4 = (ImageView) findViewById(R.id.im_setting_alarm_4);
        im_setting_alarm_5 = (ImageView) findViewById(R.id.im_setting_alarm_5);
        im_setting_alarm_6 = (ImageView) findViewById(R.id.im_setting_alarm_6);
        checkBox_Sit_alarm_sobhane = (SwitchCompat) findViewById(R.id.checkBox_Sit_alarm_sobhane);
        checkBox_Sit_alarm_myanvade_1 = (SwitchCompat) findViewById(R.id.checkBox_Sit_alarm_myanvade_1);
        checkBox_Sit_alarm_nahar = (SwitchCompat) findViewById(R.id.checkBox_Sit_alarm_nahar);
        checkBox_Sit_alarm_myanvade_2 = (SwitchCompat) findViewById(R.id.checkBox_Sit_alarm_myanvade_2);
        checkBox_Sit_alarm_sport = (SwitchCompat) findViewById(R.id.checkBox_Sit_alarm_sport);
        checkBox_Sit_alarm_sham = (SwitchCompat) findViewById(R.id.checkBox_Sit_alarm_sham);
        txt_sit_why = (TextView) findViewById(R.id.txt_sit_why);
        Button btnback = (Button) findViewById(R.id.btn_sit_background);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                    click = MediaPlayer.create(setting_alarm.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }

                finish();

            }
        });

        try {

            Typeface typeface = Typeface.createFromAsset(getAssets(), "fa_font_1.ttf");
            checkBox_Sit_alarm_sobhane.setSwitchTypeface(typeface);
            checkBox_Sit_alarm_myanvade_1.setSwitchTypeface(typeface);
            checkBox_Sit_alarm_nahar.setSwitchTypeface(typeface);
            checkBox_Sit_alarm_myanvade_2.setSwitchTypeface(typeface);
            checkBox_Sit_alarm_sport.setSwitchTypeface(typeface);
            checkBox_Sit_alarm_sham.setSwitchTypeface(typeface);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }

        try {

            alarm_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            alarm_editor = alarm_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("getSharedPreferences checkBox"));
        }


        try {

            CHECKED_STATE = alarm_preferences.getBoolean("check_show_alarm_1", true);
            checkBox_Sit_alarm_sobhane.setChecked(CHECKED_STATE);

            if (checkBox_Sit_alarm_sobhane.isChecked()) {

                try {
                    im_setting_alarm_1.setImageResource(R.drawable.alarm_check_on);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 6"));
                }

            } else {

                try {
                    im_setting_alarm_1.setImageResource(R.drawable.alarm_off);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 5"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("alarm checkBox 1"));
        }
        checkBox_Sit_alarm_sobhane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    alarm_editor.putBoolean("check_show_alarm_1", isChecked);
                    alarm_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 2"));
                }

                if (checkBox_Sit_alarm_sobhane.isChecked()) {

                    try {
                        im_setting_alarm_1.setImageResource(R.drawable.alarm_check_on);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 3"));
                    }

                } else {

                    try {
                        im_setting_alarm_1.setImageResource(R.drawable.alarm_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 4"));
                    }

                }
            }
        });





        try {

            CHECKED_STATE_2 = alarm_preferences.getBoolean("check_show_alarm_2", true);
            checkBox_Sit_alarm_myanvade_1.setChecked(CHECKED_STATE_2);

            if (checkBox_Sit_alarm_myanvade_1.isChecked()) {

                try {
                    im_setting_alarm_2.setImageResource(R.drawable.alarm_check_on);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 7"));
                }

            } else {

                try {
                    im_setting_alarm_2.setImageResource(R.drawable.alarm_off);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 8"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("alarm checkBox 9"));
        }
        checkBox_Sit_alarm_myanvade_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    alarm_editor.putBoolean("check_show_alarm_2", isChecked);
                    alarm_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 10"));
                }

                if (checkBox_Sit_alarm_myanvade_1.isChecked()) {

                    try {
                        im_setting_alarm_2.setImageResource(R.drawable.alarm_check_on);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 11"));
                    }

                } else {

                    try {
                        im_setting_alarm_2.setImageResource(R.drawable.alarm_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 12"));
                    }

                }
            }
        });






        try {

            CHECKED_STATE_3 = alarm_preferences.getBoolean("check_show_alarm_3", true);
            checkBox_Sit_alarm_nahar.setChecked(CHECKED_STATE_3);

            if (checkBox_Sit_alarm_nahar.isChecked()) {

                try {
                    im_setting_alarm_3.setImageResource(R.drawable.alarm_check_on);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 13"));
                }

            } else {

                try {
                    im_setting_alarm_3.setImageResource(R.drawable.alarm_off);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 14"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("alarm checkBox 15"));
        }
        checkBox_Sit_alarm_nahar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    alarm_editor.putBoolean("check_show_alarm_3", isChecked);
                    alarm_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 16"));
                }

                if (checkBox_Sit_alarm_nahar.isChecked()) {

                    try {
                        im_setting_alarm_3.setImageResource(R.drawable.alarm_check_on);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 17"));
                    }

                } else {

                    try {
                        im_setting_alarm_3.setImageResource(R.drawable.alarm_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 18"));
                    }

                }
            }
        });






        try {

            CHECKED_STATE_4 = alarm_preferences.getBoolean("check_show_alarm_4", true);
            checkBox_Sit_alarm_myanvade_2.setChecked(CHECKED_STATE_4);

            if (checkBox_Sit_alarm_myanvade_2.isChecked()) {

                try {
                    im_setting_alarm_4.setImageResource(R.drawable.alarm_check_on);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 19"));
                }

            } else {

                try {
                    im_setting_alarm_4.setImageResource(R.drawable.alarm_off);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 20"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("alarm checkBox 21"));
        }
        checkBox_Sit_alarm_myanvade_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    alarm_editor.putBoolean("check_show_alarm_4", isChecked);
                    alarm_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 22"));
                }

                if (checkBox_Sit_alarm_myanvade_2.isChecked()) {

                    try {
                        im_setting_alarm_4.setImageResource(R.drawable.alarm_check_on);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 23"));
                    }

                } else {

                    try {
                        im_setting_alarm_4.setImageResource(R.drawable.alarm_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 24"));
                    }

                }
            }
        });






        try {

            CHECKED_STATE_5= alarm_preferences.getBoolean("check_show_alarm_5", true);
            checkBox_Sit_alarm_sport.setChecked(CHECKED_STATE_5);

            if (checkBox_Sit_alarm_sport.isChecked()) {

                try {
                    im_setting_alarm_5.setImageResource(R.drawable.alarm_check_on);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 25"));
                }

            } else {

                try {
                    im_setting_alarm_5.setImageResource(R.drawable.alarm_off);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 26"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("alarm checkBox 27"));
        }
        checkBox_Sit_alarm_sport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    alarm_editor.putBoolean("check_show_alarm_5", isChecked);
                    alarm_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 28"));
                }

                if (checkBox_Sit_alarm_sport.isChecked()) {

                    try {
                        im_setting_alarm_5.setImageResource(R.drawable.alarm_check_on);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 29"));
                    }

                } else {

                    try {
                        im_setting_alarm_5.setImageResource(R.drawable.alarm_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 30"));
                    }

                }
            }
        });





        try {

            CHECKED_STATE_6 = alarm_preferences.getBoolean("check_show_alarm_6", true);
            checkBox_Sit_alarm_sham.setChecked(CHECKED_STATE_6);

            if (checkBox_Sit_alarm_sham.isChecked()) {

                try {
                    im_setting_alarm_6.setImageResource(R.drawable.alarm_check_on);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 31"));
                }

            } else {

                try {
                    im_setting_alarm_6.setImageResource(R.drawable.alarm_off);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 32"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("alarm checkBox 33"));
        }
        checkBox_Sit_alarm_sham.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    alarm_editor.putBoolean("check_show_alarm_6", isChecked);
                    alarm_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("alarm checkBox 34"));
                }

                if (checkBox_Sit_alarm_sham.isChecked()) {

                    try {
                        im_setting_alarm_6.setImageResource(R.drawable.alarm_check_on);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 35"));
                    }

                } else {

                    try {
                        im_setting_alarm_6.setImageResource(R.drawable.alarm_off);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("alarm checkBox 36"));
                    }

                }
            }
        });




        txt_sit_why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                (new DialogUniversalInfoUtils(setting_alarm.this)).showDialog();

            }
        });



        FirebaseCrash.log("log 2");
        System.gc();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(setting_alarm.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("10"));
            }

            try {

                click = MediaPlayer.create(setting_alarm.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }


            } catch (Exception e) {
                FirebaseCrash.report(new Exception("11"));
            }

            finish();
            FirebaseCrash.log("log 1");
        }
        return false;
    }

}
