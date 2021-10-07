package com.android.fury.a30day.menu_view;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_flag;
import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_music;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Database.MyDatabaseHelper_voice;
import com.android.fury.a30day.R;
import com.android.fury.a30day.Start_1;
import com.android.fury.a30day.food.food;
import com.android.fury.a30day.page.Page_1;
import com.android.fury.a30day.page.Page_2;
import com.android.fury.a30day.sport.sport;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by ehsan on 8/2/2016.
 */
public class setting extends Activity implements View.OnClickListener {

    public setting() {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        music_editor.putBoolean("check", _sound.isChecked());
        music_editor.commit();

        vibr_editor.putBoolean("check_vibre", vibre.isChecked());
        vibr_editor.commit();
    }

    ImageView back;
    TextView clean,txt_set_Notificaton2;
    AlertDialog.Builder clean_a, clean_a2;
    String ok, language1, stop, clean_txt1, clean_txt2, _true_sound, id_sound, _true_vibr, clean_txt3, clean_txt4, clean_txt5, clean_txt6, _true_music, _true_voice, fars, en, de, ca, am, ch;
    ImageView flag_ir, flag_usa, flag_en, flag_ch, flag_gr, flag_fr, im_setting_show_food;
    RelativeLayout lin_lan;

    MediaPlayer click;

    Vibrator vb;

    private static Context context;

    private SharedPreferences sound_preferences, voice_preferences, vibr_preferences, Music_preferences, food_preferences;
    private SharedPreferences.Editor music_editor, voice_editor, vibr_editor, sound_editor, food_editor;
    private boolean CHECKED_STATE, CHECKED_STATE_2, CHECKED_STATE_3, CHECKED_STATE_4, CHECKED_STATE_5;

    private static final String SCHEME = "package";

    private SwitchCompat _sound, voice, vibre, _music, checkBox_Sit_show_food;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;
    MyDatabaseHelper_flag flag_data;
    MyDatabaseHelper_music music_data;
    MyDatabaseHelper_voice voice_data;

    private final int _splashTime2 = 500;

    int sport_page, zaban;

    MyDatabaseHelper_lan language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

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
        setContentView(R.layout.setting);

        Bundle sitting_b = getIntent().getExtras();
        sport_page = sitting_b.getInt("setting_back");


        fars = "fa";
        en = "en";
        de = "de";
        ca = "en";
        am = "en";
        ch = "zh";
        if (language1 == fars) {
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

        try {

            sound_data = new MyDatabaseHelper_sound(this);
            vibre_data = new MyDatabaseHelper_vibre(this);
            music_data = new MyDatabaseHelper_music(this);
            voice_data = new MyDatabaseHelper_voice(this);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        lin_lan = (RelativeLayout) findViewById(R.id.lin_setting_3);
        back = (ImageView) findViewById(R.id.setting_back);
        clean = (TextView) findViewById(R.id.txt_set_clean_2);
        txt_set_Notificaton2 = (TextView) findViewById(R.id.txt_set_Notificaton2);
        flag_ir = (ImageView) findViewById(R.id.imageView6);
        flag_en = (ImageView) findViewById(R.id.imageView3);
        flag_usa = (ImageView) findViewById(R.id.imageView8);
        flag_gr = (ImageView) findViewById(R.id.imageView7);
        flag_fr = (ImageView) findViewById(R.id.imageView4);
        flag_ch = (ImageView) findViewById(R.id.imageView5);
        im_setting_show_food = (ImageView) findViewById(R.id.im_setting_show_food);
        voice = (SwitchCompat) findViewById(R.id.checkBox_Sit_voice);
        vibre = (SwitchCompat) findViewById(R.id.checkBox_Sit_vibrates);
        _sound = (SwitchCompat) findViewById(R.id.checkBox_Sit_sound);
        _music = (SwitchCompat) findViewById(R.id.checkBox_Sit_music);
        checkBox_Sit_show_food = (SwitchCompat) findViewById(R.id.checkBox_Sit_show_food);

        try {

            Typeface typeface = Typeface.createFromAsset(getAssets(), "en_font_1.otf");
            voice.setSwitchTypeface(typeface);
            vibre.setSwitchTypeface(typeface);
            _sound.setSwitchTypeface(typeface);
            _music.setSwitchTypeface(typeface);
            checkBox_Sit_show_food.setSwitchTypeface(typeface);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }


        back.setOnClickListener(this);
        clean.setOnClickListener(this);
        lin_lan.setOnClickListener(this);
        txt_set_Notificaton2.setOnClickListener(this);

        ok = (String) getText(R.string.ok);
        stop = (String) getText(R.string.stop);
        clean_txt1 = (String) getText(R.string.setting_clear_3);
        clean_txt2 = (String) getText(R.string.setting_clear_4);
        clean_txt3 = (String) getText(R.string.setting_clear_5);
        clean_txt4 = (String) getText(R.string.setting_clear_6);
        clean_txt5 = (String) getText(R.string.setting_clear_7);
        clean_txt6 = (String) getText(R.string.setting_clear_8);

        flag_data = new MyDatabaseHelper_flag(this);
        Cursor res_3 = flag_data.showAllData();
        StringBuffer data_3 = new StringBuffer();
        while (res_3.moveToNext()) {
            data_3.append(res_3.getString(1));
        }
        if (data_3.toString().length() == 2) {
            try {

                flag_ir.setVisibility(View.VISIBLE);
                flag_en.setVisibility(View.INVISIBLE);
                flag_gr.setVisibility(View.INVISIBLE);
                flag_ch.setVisibility(View.INVISIBLE);
                flag_fr.setVisibility(View.INVISIBLE);
                flag_usa.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("4"));
            }

        } else if (data_3.toString().length() == 3) {
            try {

                flag_en.setVisibility(View.VISIBLE);
                flag_usa.setVisibility(View.INVISIBLE);
                flag_gr.setVisibility(View.INVISIBLE);
                flag_ch.setVisibility(View.INVISIBLE);
                flag_fr.setVisibility(View.INVISIBLE);
                flag_ir.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("5"));
            }

        } else if (data_3.toString().length() == 4) {
            try {

                flag_usa.setVisibility(View.VISIBLE);
                flag_en.setVisibility(View.INVISIBLE);
                flag_gr.setVisibility(View.INVISIBLE);
                flag_ch.setVisibility(View.INVISIBLE);
                flag_fr.setVisibility(View.INVISIBLE);
                flag_ir.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }

        } else if (data_3.toString().length() == 5) {
            try {

                flag_ch.setVisibility(View.VISIBLE);
                flag_usa.setVisibility(View.INVISIBLE);
                flag_fr.setVisibility(View.INVISIBLE);
                flag_gr.setVisibility(View.INVISIBLE);
                flag_en.setVisibility(View.INVISIBLE);
                flag_ir.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }

        } else if (data_3.toString().length() == 6) {
            try {

                flag_fr.setVisibility(View.VISIBLE);
                flag_usa.setVisibility(View.INVISIBLE);
                flag_gr.setVisibility(View.INVISIBLE);
                flag_ch.setVisibility(View.INVISIBLE);
                flag_en.setVisibility(View.INVISIBLE);
                flag_ir.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("8"));
            }

        } else if (data_3.toString().length() == 7) {
            try {

                flag_gr.setVisibility(View.VISIBLE);
                flag_usa.setVisibility(View.INVISIBLE);
                flag_fr.setVisibility(View.INVISIBLE);
                flag_ch.setVisibility(View.INVISIBLE);
                flag_en.setVisibility(View.INVISIBLE);
                flag_ir.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("9"));
            }

        } else {
            try {

                flag_en.setVisibility(View.VISIBLE);
                flag_usa.setVisibility(View.INVISIBLE);
                flag_fr.setVisibility(View.INVISIBLE);
                flag_gr.setVisibility(View.INVISIBLE);
                flag_ch.setVisibility(View.INVISIBLE);
                flag_ir.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("10"));
            }

        }

        try {

            Music_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            music_editor = Music_preferences.edit();
            CHECKED_STATE_4 = Music_preferences.getBoolean("check_music_sport", true);
            _music.setChecked(CHECKED_STATE_4);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("11"));
        }

        _music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {

                    music_editor.putBoolean("check_music_sport", isChecked);
                    music_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("12"));
                }


                if (_music.isChecked()) {
                    _true_music = "true";
                    id_sound = "1";
                    try {

                        music_data.deleteData(id_sound);

                        music_data.insertData(_true_music, id_sound);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("13"));
                    }


                } else {
                    _true_music = "false";
                    id_sound = "1";
                    try {

                        music_data.deleteData(id_sound);

                        music_data.insertData(_true_music, id_sound);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("14"));
                    }


                }

            }
        });


        try {

            sound_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            sound_editor = sound_preferences.edit();
            CHECKED_STATE = sound_preferences.getBoolean("check_music", true);
            _sound.setChecked(CHECKED_STATE);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("15"));
        }
        _sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    sound_editor.putBoolean("check_music", isChecked);
                    sound_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();

                            Page_1.fa.finish();
                            if (_sound.isChecked()) {
                                _true_sound = "true";
                                id_sound = "1";
                                sound_data.deleteData(id_sound);

                                sound_data.insertData(_true_sound, id_sound);

                            } else {
                                _true_sound = "false";
                                id_sound = "1";
                                sound_data.deleteData(id_sound);

                                sound_data.insertData(_true_sound, id_sound);

                            }

                            Intent refresh_music = new Intent(setting.this, Start_1.class);
                            startActivity(refresh_music);
                            finish();

                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }


            }
        });


        try {

            voice_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            voice_editor = voice_preferences.edit();
            CHECKED_STATE_2 = voice_preferences.getBoolean("check_voice", true);
            voice.setChecked(CHECKED_STATE_2);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("18"));
        }
        voice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    voice_editor.putBoolean("check_voice", isChecked);
                    voice_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("19"));
                }


                if (voice.isChecked()) {
                    _true_voice = "true";
                    id_sound = "1";
                    try {

                        voice_data.deleteData(id_sound);

                        voice_data.insertData(_true_voice, id_sound);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("20"));
                    }


                } else {
                    _true_voice = "false";
                    id_sound = "1";
                    try {

                        voice_data.deleteData(id_sound);

                        voice_data.insertData(_true_voice, id_sound);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("21"));
                    }


                }

            }
        });

        try {

            vibr_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            vibr_editor = vibr_preferences.edit();
            CHECKED_STATE_3 = vibr_preferences.getBoolean("check_vibre", true);
            vibre.setChecked(CHECKED_STATE_3);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("22"));
        }

        vibre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    Page_1.fa.finish();
                    vibr_editor.putBoolean("check_vibre", isChecked);
                    vibr_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("23"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();

                            if (vibre.isChecked()) {
                                _true_vibr = "true";
                                vibre_data.deleteData(id_sound);

                                vibre_data.insertData(_true_vibr, id_sound);
                            } else {
                                _true_vibr = "false";
                                vibre_data.deleteData(id_sound);

                                vibre_data.insertData(_true_vibr, id_sound);
                            }
                            Intent refresh_vibre = new Intent(setting.this, Start_1.class);
                            startActivity(refresh_vibre);
                            finish();

                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("24"));
                }


            }
        });


        try {

            food_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            food_editor = food_preferences.edit();
            CHECKED_STATE_5 = food_preferences.getBoolean("check_show_food", true);
            checkBox_Sit_show_food.setChecked(CHECKED_STATE_5);

            if (checkBox_Sit_show_food.isChecked()) {

                try {
                    im_setting_show_food.setImageResource(R.drawable.show_food);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("food show 3"));
                }

            } else {

                try {
                    im_setting_show_food.setImageResource(R.drawable.hide_food);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("food show 4"));
                }

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("food show 1"));
        }
        checkBox_Sit_show_food.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {

                    food_editor.putBoolean("check_show_food", isChecked);
                    food_editor.apply();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("food show 2"));
                }

                if (checkBox_Sit_show_food.isChecked()) {

                    try {
                        im_setting_show_food.setImageResource(R.drawable.show_food);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("food show 3"));
                    }

                } else {

                    try {
                        im_setting_show_food.setImageResource(R.drawable.hide_food);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("food show 4"));
                    }

                }


            }
        });


        FirebaseCrash.log("log 3");
        System.gc();
    }


    public static Context getContext() {
        return context;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_back:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre.isChecked()) {
                        vb.vibrate(100);
                    } else {
                        vb.cancel();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("25"));
                }
                try {

                    click = MediaPlayer.create(setting.this, R.raw.button);
                    if (_sound.isChecked()) {
                        click.start();
                    } else {
                        click.stop();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("26"));
                }


                if (sport_page == 1) {
                    Intent ssss = new Intent(setting.this, Page_1.class);
                    startActivity(ssss);
                } else if (sport_page == 2) {
                    Intent ssss = new Intent(setting.this, Page_2.class);
                    startActivity(ssss);
                } else if (sport_page == 3) {
                    Intent ssss = new Intent(setting.this, sport.class);
                    startActivity(ssss);
                } else if (sport_page == 4) {
                    Intent ssss = new Intent(setting.this, food.class);
                    ssss.putExtra("zaban_fo", zaban);
                    startActivity(ssss);
                } else if (sport_page == 5) {
                    Intent ssss = new Intent(setting.this, food.class);
                    ssss.putExtra("zaban_fo", zaban);
                    startActivity(ssss);
                }

                finish();
                break;

            case R.id.lin_setting_3:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre.isChecked()) {
                        vb.vibrate(100);
                    } else {
                        vb.cancel();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("27"));
                }
                try {

                    click = MediaPlayer.create(setting.this, R.raw.button);
                    if (_sound.isChecked()) {
                        click.start();
                    } else {
                        click.stop();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("28"));
                }


                Intent uou = new Intent(setting.this, setting_language.class);
                uou.putExtra("setting_back", sport_page);
                setting.this.overridePendingTransition(R.anim.in,
                        R.anim.out);
                startActivity(uou);
                finish();
                break;

            case R.id.txt_set_clean_2:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre.isChecked()) {
                        vb.vibrate(100);
                    } else {
                        vb.cancel();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("29"));
                }
                try {

                    click = MediaPlayer.create(setting.this, R.raw.button);
                    if (_sound.isChecked()) {
                        click.start();
                    } else {
                        click.stop();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("30"));
                }


                clean_a = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle_clean);
                clean_a.setTitle(clean_txt1);
                clean_a.setMessage(clean_txt2);
                clean_a.setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {

                            vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            if (vibre.isChecked()) {
                                vb.vibrate(100);
                            } else {
                                vb.cancel();
                            }

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("31"));
                        }
                        try {

                            click = MediaPlayer.create(setting.this, R.raw.button);
                            if (_sound.isChecked()) {
                                click.start();
                            } else {
                                click.stop();
                            }

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("32"));
                        }

                        if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
                            ((ActivityManager) context.getSystemService(ACTIVITY_SERVICE))
                                    .clearApplicationUserData(); // note: it has a return value!
                        } else {
                            dialog.cancel();
                            clean_a2 = new AlertDialog.Builder(setting.this, R.style.MyAlertDialogStyle_clean);
                            clean_a2.setTitle(clean_txt3);
                            clean_a2.setMessage(clean_txt4 + "\n" + "\n" + clean_txt5 + "\n" + "\n" + clean_txt6 + "\n");
                            clean_a2.show();

                        }

                    }
                });
                clean_a.setNegativeButton(stop, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {

                            vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            if (vibre.isChecked()) {
                                vb.vibrate(100);
                            } else {
                                vb.cancel();
                            }

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("33"));
                        }
                        try {

                            click = MediaPlayer.create(setting.this, R.raw.button);
                            if (_sound.isChecked()) {
                                click.start();
                            } else {
                                click.stop();
                            }

                        } catch (Exception e) {
                            FirebaseCrash.report(new Exception("34"));
                        }


                        dialog.cancel();
                    }
                });
                clean_a.show();

                break;
            case R.id.txt_set_Notificaton2:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre.isChecked()) {
                        vb.vibrate(100);
                    } else {
                        vb.cancel();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("29"));
                }
                try {

                    click = MediaPlayer.create(setting.this, R.raw.button);
                    if (_sound.isChecked()) {
                        click.start();
                    } else {
                        click.stop();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("30"));
                }

                Intent alarm = new Intent(this,setting_alarm.class);
                startActivity(alarm);

                break;

        }
        FirebaseCrash.log("log 2");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(setting.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            try {

                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (vibre.isChecked()) {
                    vb.vibrate(100);
                } else {
                    vb.cancel();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("35"));
            }
            try {

                click = MediaPlayer.create(setting.this, R.raw.button);
                if (_sound.isChecked()) {
                    click.start();
                } else {
                    click.stop();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("36"));
            }


            if (sport_page == 1) {
                Intent ssss = new Intent(setting.this, Page_1.class);
                startActivity(ssss);
            } else if (sport_page == 2) {
                Intent ssss = new Intent(setting.this, Page_2.class);
                startActivity(ssss);
            } else if (sport_page == 3) {
                Intent ssss = new Intent(setting.this, sport.class);
                startActivity(ssss);
            } else if (sport_page == 4) {
                Intent ssss = new Intent(setting.this, food.class);
                ssss.putExtra("zaban_fo", zaban);
                startActivity(ssss);
            } else if (sport_page == 5) {
                Intent ssss = new Intent(setting.this, food.class);
                ssss.putExtra("zaban_fo", zaban);
                startActivity(ssss);
            }
            finish();
            FirebaseCrash.log("log 1");
        }
        return false;
    }
}
