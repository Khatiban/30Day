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
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;
import java.util.Random;

/**
 * Created by fury on 1/22/2017.
 */
public class Meal_plan extends Activity {

    CardView card_meal_nashta, card_meal_sobhane, card_meal_meyan_vade_1, card_meal_nahar, card_meal_meyan_vade_2, card_meal_meyan_vade_3, card_meal_meyan_vade_4, card_meal_sham, card_meal_faleyat, card_meal_anjam;
    TextView meal_calery_nashta, meal_food_nashta, meal_food_noshidan, meal_food_time, meal_calery_sobhane, meal_food_sobhane, meal_food_noshidan_sobhane, meal_food_time_sobhane, meal_calery_meyan_vade_1, meal_food_meyan_vade_1, meal_food_noshidan_meyan_vade_1, meal_food_time_meyan_vade_1, meal_calery_nahar, meal_food_nahar, meal_food_noshidan_nahar, meal_food_time_nahar, meal_calery_meyan_vade_2, meal_food_meyan_vade_2, meal_food_noshidan_meyan_vade_2, meal_food_time_meyan_vade_2, meal_calery_meyan_vade_3, meal_food_meyan_vade_3, meal_food_noshidan_meyan_vade_3, meal_food_time_meyan_vade_3, meal_calery_meyan_vade_4, meal_food_meyan_vade_4, meal_food_noshidan_meyan_vade_4, meal_food_time_meyan_vade_4, meal_calery_sham, meal_food_sham, meal_food_noshidan_sham, meal_food_time_sham, meal_varzesh_faleyat, meal_pyade_rave_faleyat, meal_food_esteraht_faleyat, txt_meal_tavajoh;


    String food_male_plan_10_33,colory_lanch2,colory_dinner2, food_male_plan_10_36, food_male_plan_10_37, food_male_plan_10_38, food_male_plan_10_39, food_male_plan_10_35_1, music_check, music_off_check, vibre_check, st_calery_nashta, st_nashta, st_noshidan, st_food_time, st_calery_sobhane, st_sobhane, st_noshidan_sobhane, st_time_sobhane, st_calery_meyan_vade_1, st_meyan_vade_1, st_noshidan_meyan_vade_1, st_time_meyan_vade_1, st_calery_nahar, st_nahar, st_noshidan_nahar, st_time_nahar, st_calery_meyan_vade_2, st_meyan_vade_2, st_noshidan_meyan_vade_2, st_time_meyan_vade_2, st_calery_meyan_vade_3, st_meyan_vade_3, st_noshidan_meyan_vade_3, st_time_meyan_vade_3, st_calery_meyan_vade_4, st_meyan_vade_4, st_noshidan_meyan_vade_4, st_time_meyan_vade_4, st_calery_sham, st_sham, st_noshidan_sham, st_time_sham, st_varzesh_faleyat, st_pyade_rave_faleyat, st_esteraht_faleyat, colory_sobh, colory_vade, colory_lanch, colory_dinner;

    SharedPreferences meal_save;

    SharedPreferences.Editor nameEditor_meal_save;

    int khodkar_1, min, max, what, geyah, dei, hea, med;

    ImageView imag_meal_me_top, back_page_meal;

    MyDatabaseHelper_lan language;


    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    public static MediaPlayer click;

    public static Vibrator vb;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

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

            } else {

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("fa");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }


        try {

            meal_save = PreferenceManager.getDefaultSharedPreferences(this);
            nameEditor_meal_save = meal_save.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        setContentView(R.layout.meal_plan);


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
            FirebaseCrash.report(new Exception("3"));
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
            FirebaseCrash.report(new Exception("4"));
        }


        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();


        Bundle colery = getIntent().getExtras();

        // nashta
        card_meal_nashta = (CardView) findViewById(R.id.card_meal_nashta);
        meal_calery_nashta = (TextView) findViewById(R.id.meal_calery_nashta);
        meal_food_nashta = (TextView) findViewById(R.id.meal_food_nashta);
        meal_food_noshidan = (TextView) findViewById(R.id.meal_food_noshidan);
        meal_food_time = (TextView) findViewById(R.id.meal_food_time);

        // sobhane
        card_meal_sobhane = (CardView) findViewById(R.id.card_meal_sobhane);
        meal_calery_sobhane = (TextView) findViewById(R.id.meal_calery_sobhane);
        meal_food_sobhane = (TextView) findViewById(R.id.meal_food_sobhane);
        meal_food_noshidan_sobhane = (TextView) findViewById(R.id.meal_food_noshidan_sobhane);
        meal_food_time_sobhane = (TextView) findViewById(R.id.meal_food_time_sobhane);

        // meyan vade 1
        card_meal_meyan_vade_1 = (CardView) findViewById(R.id.card_meal_meyan_vade_1);
        meal_calery_meyan_vade_1 = (TextView) findViewById(R.id.meal_calery_meyan_vade_1);
        meal_food_meyan_vade_1 = (TextView) findViewById(R.id.meal_food_meyan_vade_1);
        meal_food_noshidan_meyan_vade_1 = (TextView) findViewById(R.id.meal_food_noshidan_meyan_vade_1);
        meal_food_time_meyan_vade_1 = (TextView) findViewById(R.id.meal_food_time_meyan_vade_1);

        // nahar
        card_meal_nahar = (CardView) findViewById(R.id.card_meal_nahar);
        meal_calery_nahar = (TextView) findViewById(R.id.meal_calery_nahar);
        meal_food_nahar = (TextView) findViewById(R.id.meal_food_nahar);
        meal_food_noshidan_nahar = (TextView) findViewById(R.id.meal_food_noshidan_nahar);
        meal_food_time_nahar = (TextView) findViewById(R.id.meal_food_time_nahar);

        // meyan vade 2
        card_meal_meyan_vade_2 = (CardView) findViewById(R.id.card_meal_meyan_vade_2);
        meal_calery_meyan_vade_2 = (TextView) findViewById(R.id.meal_calery_meyan_vade_2);
        meal_food_meyan_vade_2 = (TextView) findViewById(R.id.meal_food_meyan_vade_2);
        meal_food_noshidan_meyan_vade_2 = (TextView) findViewById(R.id.meal_food_noshidan_meyan_vade_2);
        meal_food_time_meyan_vade_2 = (TextView) findViewById(R.id.meal_food_time_meyan_vade_2);

        // meyan vade 3
        card_meal_meyan_vade_3 = (CardView) findViewById(R.id.card_meal_meyan_vade_3);
        meal_calery_meyan_vade_3 = (TextView) findViewById(R.id.meal_calery_meyan_vade_3);
        meal_food_meyan_vade_3 = (TextView) findViewById(R.id.meal_food_meyan_vade_3);
        meal_food_noshidan_meyan_vade_3 = (TextView) findViewById(R.id.meal_food_noshidan_meyan_vade_3);
        meal_food_time_meyan_vade_3 = (TextView) findViewById(R.id.meal_food_time_meyan_vade_3);

        // meyan vade 4
        card_meal_meyan_vade_4 = (CardView) findViewById(R.id.card_meal_meyan_vade_4);
        meal_calery_meyan_vade_4 = (TextView) findViewById(R.id.meal_calery_meyan_vade_4);
        meal_food_meyan_vade_4 = (TextView) findViewById(R.id.meal_food_meyan_vade_4);
        meal_food_noshidan_meyan_vade_4 = (TextView) findViewById(R.id.meal_food_noshidan_meyan_vade_4);
        meal_food_time_meyan_vade_4 = (TextView) findViewById(R.id.meal_food_time_meyan_vade_4);

        // sham
        card_meal_sham = (CardView) findViewById(R.id.card_meal_sham);
        meal_calery_sham = (TextView) findViewById(R.id.meal_calery_sham);
        meal_food_sham = (TextView) findViewById(R.id.meal_food_sham);
        meal_food_noshidan_sham = (TextView) findViewById(R.id.meal_food_noshidan_sham);
        meal_food_time_sham = (TextView) findViewById(R.id.meal_food_time_sham);

        // faleyat
        card_meal_faleyat = (CardView) findViewById(R.id.card_meal_faleyat);
        meal_varzesh_faleyat = (TextView) findViewById(R.id.meal_varzesh_faleyat);
        meal_pyade_rave_faleyat = (TextView) findViewById(R.id.meal_pyade_rave_faleyat);
        meal_food_esteraht_faleyat = (TextView) findViewById(R.id.meal_food_esteraht_faleyat);

        // at
        txt_meal_tavajoh = (TextView) findViewById(R.id.txt_meal_tavajoh);

        card_meal_anjam = (CardView) findViewById(R.id.card_meal_anjam);
        imag_meal_me_top = (ImageView) findViewById(R.id.imag_meal_me_top);
        back_page_meal = (ImageView) findViewById(R.id.back_page_meal);


        geyah = one_play_preferences.getInt("nov_meal_gyah", 1);
        dei = one_play_preferences.getInt("nov_meal_deiabet", 1);
        hea = one_play_preferences.getInt("nov_meal_heart", 1);
        med = one_play_preferences.getInt("nov_meal_mede", 1);
        colory_sobh = one_play_preferences.getString("colory_sobh_meal_plan", "250");
        colory_vade = one_play_preferences.getString("colory_vade_meal_plan", "70");
        colory_lanch = one_play_preferences.getString("colory_lanch_meal_plan", "260");
        colory_lanch2 = "450";
        colory_dinner = one_play_preferences.getString("colory_dinner_meal_plan", "180");
        colory_dinner2 = "250";


        Random r = new Random();

        min = 1;
        max = 6;

        khodkar_1 = r.nextInt(max - min + 1) + min;

        if (khodkar_1 == 1) {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_1);

        } else if (khodkar_1 == 2) {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_2);

        } else if (khodkar_1 == 3) {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_3);

        } else if (khodkar_1 == 4) {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_4);

        } else if (khodkar_1 == 5) {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_5);

        } else if (khodkar_1 == 6) {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_6);

        } else {

            imag_meal_me_top.setImageResource(R.drawable.imag_top_meal_plan_1);

        }


        try {
            what = colery.getInt("nov_meal");
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("5"));
            Toast.makeText(getApplication(), "متاسفا برنامه غذایی دریافت نشد لطفا مجدد تلاش کنید !", Toast.LENGTH_LONG).show();
            finish();
        }

        food_male_plan_10_33 = (String) getText(R.string.food_male_plan_10_33);
        food_male_plan_10_36 = (String) getText(R.string.food_male_plan_10_36);
        food_male_plan_10_37 = (String) getText(R.string.food_male_plan_10_37);
        food_male_plan_10_38 = (String) getText(R.string.food_male_plan_10_38);
        food_male_plan_10_39 = (String) getText(R.string.food_male_plan_10_39);


        if (what == 1) {

            // kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sham_1);

            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_gyah_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);

            }
            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);


        } else if (what == 2) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_2_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_2_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_gyah_nahar_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_2_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_2_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_nahar_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);

            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);


        } else if (what == 3) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_3_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_3_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_3_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_3_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_3_mede_gyaah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_3_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_3_gyaah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_3_gyaah_sham_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_3_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_nahar_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);

            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 4) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_4_nahar_1);
            st_calery_sham = colory_dinner2;
            st_sham = (String) getText(R.string.txt_meal_plan_4_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_4_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_4_gyaah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_4_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_gyaah_gyah_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_4_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_4_gyaah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_gyaah_sham_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_4_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);

            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 5) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = "200";
            st_nahar = (String) getText(R.string.txt_meal_plan_5_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_5_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_dyabet_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_gyaah_gyah_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_mede_dyabet_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_5_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 6) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_6_nahar_1);
            st_calery_sham = "230";
            st_sham = (String) getText(R.string.txt_meal_plan_6_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_6_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_6_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_6_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_6_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_6_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 7) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_7_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_7_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_7_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_7_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_7_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_7_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_7_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_7_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_7_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 8) {

            // kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_gyah_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 9) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_2_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_2_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_gyah_nahar_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_2_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_2_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_2_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_nahar_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 10) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_3_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_3_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_3_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_3_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_3_mede_gyaah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_3_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_3_gyaah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_3_gyaah_sham_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_3_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_3_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_nahar_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 11) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_4_nahar_1);
            st_calery_sham = colory_dinner2;
            st_sham = (String) getText(R.string.txt_meal_plan_4_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_4_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_4_gyaah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_4_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_gyaah_gyah_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_4_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_4_gyaah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_gyaah_sham_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_4_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_4_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 12) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = "200";
            st_nahar = (String) getText(R.string.txt_meal_plan_5_nahar_1);
            st_calery_sham = "150";
            st_sham = (String) getText(R.string.txt_meal_plan_5_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_dyabet_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_gyaah_gyah_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_mede_dyabet_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_5_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_5_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_5_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 13) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_6_nahar_1);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_6_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_6_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_6_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_6_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_6_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_6_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_6_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 14) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_1);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_7_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_7_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_7_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_dyabet_mede_gyah_sham_1);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_7_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_7_mede_gyah_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_gyah_sham_1);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_7_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_dyabet_sham_1);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_7_gyaah_nahar_1);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_7_nahar_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_7_mede_nahar_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_sham_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 15) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_nahar_15);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nahar_15);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_nahar_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_gyah_nahar_15);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_nahar_15);
            } else if (geyah == 2) {
                //gyah

            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_nahar_15);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 16) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_2_nahar_16);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_2_sham_16);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_sham_16);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_sham_16);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_gyah_nahar_16);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_sham_16);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_2_gyaah_nahar_16);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_2_sham_16);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_nahar_16);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 17) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_3_nahar_17);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_3_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_3_nahar_17);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_3_nahar_17);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_gyah_nahar_17);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_3_nahar_17);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_3_gyaah_nahar_17);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_nahar_17);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_3_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);


            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_nahar_17);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 18) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_4_nahar_18);
            st_calery_sham = colory_dinner2;
            st_sham = (String) getText(R.string.txt_meal_plan_4_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_4_nahar_18);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_4_nahar_18);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_gyah_nahar_18);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_4_nahar_18);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_4_gyaah_nahar_18);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_4_nahar_18);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_nahar_18);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 19) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = "200";
            st_nahar = (String) getText(R.string.txt_meal_plan_5_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_5_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 20) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_6_nahar_20);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_6_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_6_nahar_20);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_6_nahar_20);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_gyah_nahar_20);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_6_nahar_20);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_6_gyaah_nahar_20);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_6_nahar_20);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_nahar_20);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 21) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_7_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_7_sham_21);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_sham = (String) getText(R.string.txt_meal_plan_7_dyabet_mede_gyah_sham_21);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_7_mede_gyah_sham_21);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_dyabet_sham_21);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_sham_21);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }

            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 22) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_nahar_15);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nahar_15);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_nahar_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_gyah_nahar_15);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_nahar_15);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_nahar_15);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 23) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_2_nahar_16);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_2_sham_16);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_sham_16);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_sham_16);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_gyah_nahar_16);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_sham_16);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_2_gyaah_nahar_16);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_2_sham_16);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_nahar_16);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 24) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_3_nahar_17);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_3_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_3_nahar_17);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_3_nahar_17);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_gyah_nahar_17);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_3_nahar_17);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_3_gyaah_nahar_17);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_nahar_17);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_3_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_3_mede_nahar_17);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 25) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_4_nahar_18);
            st_calery_sham = colory_dinner2;
            st_sham = (String) getText(R.string.txt_meal_plan_4_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_4_nahar_18);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_4_nahar_18);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_gyah_nahar_18);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_4_nahar_18);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_4_gyaah_nahar_18);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_4_nahar_18);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_4_mede_nahar_18);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 26) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = "200";
            st_nahar = (String) getText(R.string.txt_meal_plan_5_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_5_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 27) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_6_nahar_20);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_6_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_6_nahar_20);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_6_nahar_20);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_gyah_nahar_20);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_6_nahar_20);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_6_gyaah_nahar_20);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_6_nahar_20);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_6_mede_nahar_20);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 28) {

            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_7_nahar_1);
            st_calery_sham = "120";
            st_sham = (String) getText(R.string.txt_meal_plan_7_sham_21);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_sham = (String) getText(R.string.txt_meal_plan_7_dyabet_mede_gyah_sham_21);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_7_mede_gyah_sham_21);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_dyabet_sham_21);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_3_sham_1);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_3_sham_1);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_sham = (String) getText(R.string.txt_meal_plan_7_mede_sham_21);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }

            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 29) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch;
            st_nahar = (String) getText(R.string.txt_meal_plan_nahar_15);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_sham_1);

            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nahar_15);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_nahar_15);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_gyah_nahar_15);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_nahar_15);
            } else if (geyah == 2) {
                //gyah
            } else if (dei == 2) {
                //deiyabet true

                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_nahar_15);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_sham_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);
            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_nahar_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        } else if (what == 30) {

// kol
            text_meal_1();
            st_calery_sobhane = colory_sobh;
            st_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_15);
            st_calery_nahar = colory_lanch2;
            st_nahar = (String) getText(R.string.txt_meal_plan_2_nahar_16);
            st_calery_sham = colory_dinner;
            st_sham = (String) getText(R.string.txt_meal_plan_2_sham_16);


            if (geyah == 2 && dei == 2 && med == 2) {
                //gosht & deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_nasta_mede_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_mede_gyah_2_sham_16);
            } else if (geyah == 2 && dei == 2) {
                //gyah & deyabet
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_gyah_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_gyah_2_sham_16);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_gyah_vade_4_2);
            } else if (geyah == 2 && med == 2) {
                //gyah & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_gyah_1);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_gyah_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_gyah_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_gyah_nahar_16);
            } else if (dei == 2 && med == 2) {
                //deyabet & mede
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_deyabet_1);
                st_sobhane = (String) getText(R.string.txt_meal_plan_mede_dyabet_sobhane_15);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_deyabet_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_dyabet_vade_4_2);
                st_nahar = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_mede_dyabet_2_sham_16);
            } else if (geyah == 2) {
                //gyah
                st_nahar = (String) getText(R.string.txt_meal_plan_2_gyaah_nahar_16);
            } else if (dei == 2) {
                //deiyabet true
                st_sobhane = (String) getText(R.string.txt_meal_plan_dyabet_sobhane_15);
                st_nahar = (String) getText(R.string.txt_meal_plan_dyabet_2_nahar_16);
                st_sham = (String) getText(R.string.txt_meal_plan_dyabet_2_sham_16);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_dyabet_vade_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_dyabet_vade_4_2);

            } else if (med == 2) {
                //mede true
                st_nashta = (String) getText(R.string.txt_meal_plan_nasta_mede_1);
                st_nahar = (String) getText(R.string.txt_meal_plan_2_mede_nahar_16);
                st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_mede_1_1);
                st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_mede_2_2);
                st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_mede_vade_4_2);
            }


            //string ha
            atev();

            //ja gozary
            text_meal(1, 1, 1, 1, 1, 1, 1, 1, 1);

        }


        card_meal_anjam.setOnClickListener(new View.OnClickListener() {
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
                    FirebaseCrash.report(new Exception("6"));
                }

                try {

                    click = MediaPlayer.create(Meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("7"));
                }

                if (what == 1) {

                    one_play_editor.putInt("im_1_1", 2);
                    one_play_editor.apply();

                } else if (what == 2) {

                    one_play_editor.putInt("im_1_2", 2);
                    one_play_editor.apply();

                } else if (what == 3) {

                    one_play_editor.putInt("im_1_3", 2);
                    one_play_editor.apply();

                } else if (what == 4) {

                    one_play_editor.putInt("im_1_4", 2);
                    one_play_editor.apply();

                } else if (what == 5) {

                    one_play_editor.putInt("im_1_5", 2);
                    one_play_editor.apply();

                } else if (what == 6) {

                    one_play_editor.putInt("im_1_6", 2);
                    one_play_editor.apply();

                } else if (what == 7) {

                    one_play_editor.putInt("im_1_7", 2);
                    one_play_editor.apply();

                } else if (what == 8) {

                    one_play_editor.putInt("im_1_8", 2);
                    one_play_editor.apply();

                } else if (what == 9) {

                    one_play_editor.putInt("im_1_9", 2);
                    one_play_editor.apply();

                } else if (what == 10) {

                    one_play_editor.putInt("im_1_10", 2);
                    one_play_editor.apply();

                } else if (what == 11) {

                    one_play_editor.putInt("im_2_1", 2);
                    one_play_editor.apply();

                } else if (what == 12) {

                    one_play_editor.putInt("im_2_2", 2);
                    one_play_editor.apply();

                } else if (what == 13) {

                    one_play_editor.putInt("im_2_3", 2);
                    one_play_editor.apply();

                } else if (what == 14) {

                    one_play_editor.putInt("im_2_4", 2);
                    one_play_editor.apply();

                } else if (what == 15) {

                    one_play_editor.putInt("im_2_5", 2);
                    one_play_editor.apply();

                } else if (what == 16) {

                    one_play_editor.putInt("im_2_6", 2);
                    one_play_editor.apply();

                } else if (what == 17) {

                    one_play_editor.putInt("im_2_7", 2);
                    one_play_editor.apply();

                } else if (what == 18) {

                    one_play_editor.putInt("im_2_8", 2);
                    one_play_editor.apply();

                } else if (what == 19) {

                    one_play_editor.putInt("im_2_9", 2);
                    one_play_editor.apply();

                } else if (what == 20) {

                    one_play_editor.putInt("im_2_10", 2);
                    one_play_editor.apply();

                } else if (what == 21) {

                    one_play_editor.putInt("im_3_1", 2);
                    one_play_editor.apply();

                } else if (what == 22) {

                    one_play_editor.putInt("im_3_2", 2);
                    one_play_editor.apply();

                } else if (what == 23) {

                    one_play_editor.putInt("im_3_3", 2);
                    one_play_editor.apply();

                } else if (what == 24) {

                    one_play_editor.putInt("im_3_4", 2);
                    one_play_editor.apply();

                } else if (what == 25) {

                    one_play_editor.putInt("im_3_5", 2);
                    one_play_editor.apply();

                } else if (what == 26) {

                    one_play_editor.putInt("im_3_6", 2);
                    one_play_editor.apply();

                } else if (what == 27) {

                    one_play_editor.putInt("im_3_7", 2);
                    one_play_editor.apply();

                } else if (what == 28) {

                    one_play_editor.putInt("im_3_8", 2);
                    one_play_editor.apply();

                } else if (what == 29) {

                    one_play_editor.putInt("im_3_9", 2);
                    one_play_editor.apply();

                } else if (what == 30) {

                    one_play_editor.putInt("im_3_10", 2);
                    one_play_editor.apply();

                }

                String save = (String) getText(R.string.text_tit_meal_save);
                Toast.makeText(getApplication(), save, Toast.LENGTH_LONG).show();


            }
        });


        back_page_meal.setOnClickListener(new View.OnClickListener() {
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
                    FirebaseCrash.report(new Exception("8"));
                }

                try {

                    click = MediaPlayer.create(Meal_plan.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("9"));
                }

                finish();

            }
        });

        FirebaseCrash.log("log 2");
        System.gc();
    }


    public void atev() {
        // set //sorat mtvast // bedon bemary // hamechi kar

//at
        String no_1_1 = (String) getText(R.string.txt_meal_plan_notis_1);
        String no_1_2 = (String) getText(R.string.txt_meal_plan_notis_2);
        String no_1_3 = (String) getText(R.string.txt_meal_plan_notis_3);
        String no_1_4 = (String) getText(R.string.txt_meal_plan_notis_4);
        String no_1_5 = (String) getText(R.string.txt_meal_plan_notis_5);
        String no_1_6 = (String) getText(R.string.txt_meal_plan_notis_6);
        String no_1_7 = (String) getText(R.string.txt_meal_plan_notis_7);
        String no_1_8 = (String) getText(R.string.txt_meal_plan_notis_8);
        String no_1_9 = (String) getText(R.string.txt_meal_plan_notis_9);
        String no_1_10 = (String) getText(R.string.txt_meal_plan_notis_10);
        String no_1_11 = (String) getText(R.string.txt_meal_plan_notis_11);
        String no_1_12 = (String) getText(R.string.txt_meal_plan_notis_12);
        food_male_plan_10_35_1 = food_male_plan_10_38
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_33
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_36
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_37
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_39
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_1
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_2
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_3
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_4
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_5
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_6
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_7
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_8
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_9
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_10
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_11
                + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + no_1_12;

    }

    public void text_meal_1() {

        st_calery_nashta = "5";
        st_nashta = (String) getText(R.string.txt_meal_plan_nasta_1);
        st_noshidan = (String) getText(R.string.txt_meal_plan_nasta_2);
        st_food_time = (String) getText(R.string.txt_meal_plan_nasta_3);
        st_noshidan_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_2);
        st_time_sobhane = (String) getText(R.string.txt_meal_plan_sobhane_3);
        st_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_1_1);
        st_noshidan_meyan_vade_1 = "نوشیدنی صرف نشود";
        st_time_meyan_vade_1 = (String) getText(R.string.txt_meal_plan_vade_1_3);
        st_calery_meyan_vade_3 = colory_vade;
        st_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_2_1);
        st_noshidan_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_2_2);
        st_time_meyan_vade_3 = (String) getText(R.string.txt_meal_plan_vade_2_3);
        st_calery_meyan_vade_4 = colory_vade;
        st_meyan_vade_4 = (String) getText(R.string.txt_meal_plan_vade_3_1);
        st_noshidan_meyan_vade_4 = (String) getText(R.string.txt_meal_plan_vade_3_2);
        st_time_meyan_vade_4 = (String) getText(R.string.txt_meal_plan_vade_3_3);
        st_noshidan_nahar = "نوشیدنی صرف نشود";
        st_time_nahar = (String) getText(R.string.txt_meal_plan_nahar_3);
        st_noshidan_sham = (String) getText(R.string.txt_meal_plan_sham_2);
        st_time_sham = (String) getText(R.string.txt_meal_plan_sham_3);
        st_varzesh_faleyat = (String) getText(R.string.txt_meal_plan_faleyat_1);
        st_pyade_rave_faleyat = (String) getText(R.string.txt_meal_plan_faleyat_2);
        st_esteraht_faleyat = (String) getText(R.string.txt_meal_plan_faleyat_3);
        st_calery_meyan_vade_2 = colory_vade;
        st_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_vade_4_1);
        st_noshidan_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_vade_4_2);
        st_time_meyan_vade_2 = (String) getText(R.string.txt_meal_plan_vade_4_3);
        st_calery_meyan_vade_1 = "100";


    }


    public void text_meal(int nashta, int sobhane, int vade1, int vade3, int vade4, int nahar, int vade2, int sham, int faaliat) {

        if (nashta == 2) {
            try {

                card_meal_nashta.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("10"));
            }
        }

        if (sobhane == 2) {
            try {

                card_meal_sobhane.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("11"));
            }
        }

        if (vade1 == 2) {
            try {

                card_meal_meyan_vade_1.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
            }
        }

        if (vade3 == 2) {
            try {

                card_meal_meyan_vade_3.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12 1"));
            }
        }

        if (vade4 == 2) {
            try {

                card_meal_meyan_vade_4.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12 2"));
            }
        }

        if (nahar == 2) {
            try {

                card_meal_nahar.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("13"));
            }
        }

        if (vade2 == 2) {
            try {

                card_meal_meyan_vade_2.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("14"));
            }
        }

        if (sham == 2) {
            try {

                card_meal_sham.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("15"));
            }
        }

        if (faaliat == 2) {
            try {

                card_meal_faleyat.setVisibility(View.GONE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("16"));
            }
        }


        //string to text
        //nashta
        meal_calery_nashta.setText(st_calery_nashta);
        meal_food_nashta.setText(st_nashta);
        meal_food_noshidan.setText(st_noshidan);
        meal_food_time.setText(st_food_time);
// sobhane
        meal_calery_sobhane.setText(st_calery_sobhane);
        meal_food_sobhane.setText(st_sobhane);
        meal_food_noshidan_sobhane.setText(st_noshidan_sobhane);
        meal_food_time_sobhane.setText(st_time_sobhane);
// meyan vade 1
        meal_calery_meyan_vade_1.setText(st_calery_meyan_vade_1);
        meal_food_meyan_vade_1.setText(st_meyan_vade_1);
        meal_food_noshidan_meyan_vade_1.setText(st_noshidan_meyan_vade_1);
        meal_food_time_meyan_vade_1.setText(st_time_meyan_vade_1);
// nahar
        meal_calery_nahar.setText(st_calery_nahar);
        meal_food_nahar.setText(st_nahar);
        meal_food_noshidan_nahar.setText(st_noshidan_nahar);
        meal_food_time_nahar.setText(st_time_nahar);
// meyan vade 2
        meal_calery_meyan_vade_2.setText(st_calery_meyan_vade_2);
        meal_food_meyan_vade_2.setText(st_meyan_vade_2);
        meal_food_noshidan_meyan_vade_2.setText(st_noshidan_meyan_vade_2);
        meal_food_time_meyan_vade_2.setText(st_time_meyan_vade_2);
        // meyan vade 3
        meal_calery_meyan_vade_3.setText(st_calery_meyan_vade_3);
        meal_food_meyan_vade_3.setText(st_meyan_vade_3);
        meal_food_noshidan_meyan_vade_3.setText(st_noshidan_meyan_vade_3);
        meal_food_time_meyan_vade_3.setText(st_time_meyan_vade_3);
        // meyan vade 4
        meal_calery_meyan_vade_4.setText(st_calery_meyan_vade_4);
        meal_food_meyan_vade_4.setText(st_meyan_vade_4);
        meal_food_noshidan_meyan_vade_4.setText(st_noshidan_meyan_vade_4);
        meal_food_time_meyan_vade_4.setText(st_time_meyan_vade_4);
// sham
        meal_calery_sham.setText(st_calery_sham);
        meal_food_sham.setText(st_sham);
        meal_food_noshidan_sham.setText(st_noshidan_sham);
        meal_food_time_sham.setText(st_time_sham);
// faleyat
        meal_varzesh_faleyat.setText(st_varzesh_faleyat);
        meal_pyade_rave_faleyat.setText(st_pyade_rave_faleyat);
        meal_food_esteraht_faleyat.setText(st_esteraht_faleyat);
// at
        txt_meal_tavajoh.setText(food_male_plan_10_35_1);

        FirebaseCrash.log("log 1");

    }


}
