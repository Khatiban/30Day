package com.android.fury.a30day.food;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.google.firebase.crash.FirebaseCrash;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by fury on 9/10/2016.
 */
public class food_male_plan_10 extends food_mp_10_Drawer {

    private MaterialViewPager mViewPager;

    //string caleriha ha 59
    public static String size_1, size_2, size_3, size_4, size_5, size_6, size_7, size_8, size_9, size_10, size_11, size_12, size_13, size_14, size_15, size_16, size_17, size_18, size_19, size_20, size_21, size_22, size_23, size_24, size_25, size_26, size_27, size_28, size_29, size_30, size_31, size_32, size_33, size_34, size_35, size_36, size_37, size_38, size_39, size_40, size_41, size_42, size_43, size_44, size_45, size_46, size_47, size_48, size_49, size_50, size_51, size_52, size_53, size_54, size_55, size_56, size_57, size_58, size_59, size_60, size_61, size_62, size_63, size_64, size_65, size_66, size_67, size_68, size_69, size_70, size_71, size_72, size_73, size_74, size_75, size_76, size_77, size_78, size_79, size_80, size_81, size_82, size_83, size_84, size_85, size_86, size_87, size_88, size_89, size_90, size_91, size_92, size_93, size_94, size_95, size_96, size_97, size_98, size_99, size_100, size_101, size_102, size_103, size_104, size_105, size_106, size_107, size_108, size_109, size_110, size_111, size_112, size_113, size_114, size_115, size_116, size_117, size_118, size_119, size_120, size_121, size_122, size_123, size_124, size_125;


    //string caleriha ha 70
    public static String size_1_2, size_2_2, size_3_2, size_4_2, size_5_2, size_6_2, size_7_2, size_8_2, size_9_2, size_10_2, size_11_2, size_12_2, size_13_2, size_14_2, size_15_2, size_16_2, size_17_2, size_18_2, size_19_2, size_20_2, size_21_2, size_22_2, size_23_2, size_24_2, size_25_2, size_26_2, size_27_2, size_28_2, size_29_2, size_30_2, size_31_2, size_32_2, size_33_2, size_34_2, size_35_2, size_36_2, size_37_2, size_38_2, size_39_2, size_40_2, size_41_2, size_42_2, size_43_2, size_44_2, size_45_2, size_46_2, size_47_2, size_48_2, size_49_2, size_50_2, size_51_2, size_52_2, size_53_2, size_54_2, size_55_2, size_56_2, size_57_2, size_58_2, size_59_2, size_60_2, size_61_2, size_62_2, size_63_2, size_64_2, size_65_2, size_66_2, size_67_2, size_68_2, size_69_2, size_70_2, size_71_2, size_72_2, size_73_2, size_74_2, size_75_2, size_76_2, size_77_2, size_78_2, size_79_2, size_80_2, size_81_2, size_82_2, size_83_2, size_84_2, size_85_2, size_86_2, size_87_2, size_88_2, size_89_2, size_90_2, size_91_2, size_92_2, size_93_2, size_94_2, size_95_2, size_96_2, size_97_2, size_98_2, size_99_2, size_100_2, size_101_2, size_102_2, size_103_2, size_104_2, size_105_2, size_106_2, size_107_2, size_108_2, size_109_2, size_110_2, size_111_2, size_112_2, size_113_2, size_114_2, size_115_2, size_116_2, size_117_2, size_118_2, size_119_2, size_120_2, size_121_2, size_122_2, size_123_2, size_124_2, size_125_2;

    //string caleriha ha 81
    public static String size_1_3, size_2_3, size_3_3, size_4_3, size_5_3, size_6_3, size_7_3, size_8_3, size_9_3, size_10_3, size_11_3, size_12_3, size_13_3, size_14_3, size_15_3, size_16_3, size_17_3, size_18_3, size_19_3, size_20_3, size_21_3, size_22_3, size_23_3, size_24_3, size_25_3, size_26_3, size_27_3, size_28_3, size_29_3, size_30_3, size_31_3, size_32_3, size_33_3, size_34_3, size_35_3, size_36_3, size_37_3, size_38_3, size_39_3, size_40_3, size_41_3, size_42_3, size_43_3, size_44_3, size_45_3, size_46_3, size_47_3, size_48_3, size_49_3, size_50_3, size_51_3, size_52_3, size_53_3, size_54_3, size_55_3, size_56_3, size_57_3, size_58_3, size_59_3, size_60_3, size_61_3, size_62_3, size_63_3, size_64_3, size_65_3, size_66_3, size_67_3, size_68_3, size_69_3, size_70_3, size_71_3, size_72_3, size_73_3, size_74_3, size_75_3, size_76_3, size_77_3, size_78_3, size_79_3, size_80_3, size_81_3, size_82_3, size_83_3, size_84_3, size_85_3, size_86_3, size_87_3, size_88_3, size_89_3, size_90_3, size_91_3, size_92_3, size_93_3, size_94_3, size_95_3, size_96_3, size_97_3, size_98_3, size_99_3, size_100_3, size_101_3, size_102_3, size_103_3, size_104_3, size_105_3, size_106_3, size_107_3, size_108_3, size_109_3, size_110_3, size_111_3, size_112_3, size_113_3, size_114_3, size_115_3, size_116_3, size_117_3, size_118_3, size_119_3, size_120_3, size_121_3, size_122_3, size_123_3, size_124_3, size_125_3;

    //string caleriha ha 93
    public static String size_1_4, size_2_4, size_3_4, size_4_4, size_5_4, size_6_4, size_7_4, size_8_4, size_9_4, size_10_4, size_11_4, size_12_4, size_13_4, size_14_4, size_15_4, size_16_4, size_17_4, size_18_4, size_19_4, size_20_4, size_21_4, size_22_4, size_23_4, size_24_4, size_25_4, size_26_4, size_27_4, size_28_4, size_29_4, size_30_4, size_31_4, size_32_4, size_33_4, size_34_4, size_35_4, size_36_4, size_37_4, size_38_4, size_39_4, size_40_4, size_41_4, size_42_4, size_43_4, size_44_4, size_45_4, size_46_4, size_47_4, size_48_4, size_49_4, size_50_4, size_51_4, size_52_4, size_53_4, size_54_4, size_55_4, size_56_4, size_57_4, size_58_4, size_59_4, size_60_4, size_61_4, size_62_4, size_63_4, size_64_4, size_65_4, size_66_4, size_67_4, size_68_4, size_69_4, size_70_4, size_71_4, size_72_4, size_73_4, size_74_4, size_75_4, size_76_4, size_77_4, size_78_4, size_79_4, size_80_4, size_81_4, size_82_4, size_83_4, size_84_4, size_85_4, size_86_4, size_87_4, size_88_4, size_89_4, size_90_4, size_91_4, size_92_4, size_93_4, size_94_4, size_95_4, size_96_4, size_97_4, size_98_4, size_99_4, size_100_4, size_101_4, size_102_4, size_103_4, size_104_4, size_105_4, size_106_4, size_107_4, size_108_4, size_109_4, size_110_4, size_111_4, size_112_4, size_113_4, size_114_4, size_115_4, size_116_4, size_117_4, size_118_4, size_119_4, size_120_4, size_121_4, size_122_4, size_123_4, size_124_4, size_125_4;


    //string food ha
    public static String food_1, food_2, food_3, food_4, food_5, food_6, food_7, food_8, food_9, food_10, food_11, food_12, food_13, food_14, food_15, food_16, food_17, food_18, food_19, food_20, food_21, food_22, food_23, food_24, food_25, food_26, food_27, food_28, food_29, food_30, food_31, food_32, food_33, food_34, food_35, food_36, food_37, food_38, food_39, food_40, food_41, food_42, food_43, food_44, food_45, food_46, food_47, food_48, food_49, food_50, food_51, food_52, food_53, food_54, food_55, food_56, food_57, food_58, food_59, food_60, food_61, food_62, food_63, food_64, food_65, food_66, food_67, food_68, food_69, food_70, food_71, food_72, food_73, food_74, food_75, food_76, food_77, food_78, food_79, food_80, food_81, food_82, food_83, food_84, food_85, food_86, food_87, food_88, food_89, food_90, food_91, food_92, food_93, food_94, food_95, food_96, food_97, food_98, food_99, food_100, food_101, food_102, food_103, food_104, food_105, food_106, food_107, food_108, food_109, food_110, food_111, food_112, food_113, food_114, food_115, food_116, food_117, food_118, food_119, food_120, food_121, food_122, food_123, food_124, food_125, food_male_plan_10_38, food_male_plan_10_39;


    public static String s, colory_low, colory_low_1_1, colory_low_1_2, colory_low_1_3, colory_low_1_4, colory_low_1_4_1, colory_low_1_4_2, colory_low_1_4_3, colory_low_1_4_4, colory_low_1_4_5, colory_low_1_5, colory_low_1_5_1, colory_low_1_5_2, colory_low_1_5_3, colory_low_1_5_4, colory_low_1_5_5, colory_low_1_6, colory_low_1_6_1, colory_low_1_6_2, colory_low_1_6_3, colory_low_1_6_4, colory_low_1_6_5, colory_low_1_7, colory_low_1_7_1, colory_low_1_7_2, colory_low_1_7_3, colory_low_1_7_4, colory_low_1_7_5, colory_low_1_8, colory_low_1_8_1, colory_low_1_8_2, colory_low_1_8_3, colory_low_1_8_4, colory_low_1_8_5, colory_low_2, colory_low_3, colory_low_4, colory_sobh, colory_vade, colory_lanch, colory_dinner, colory_low_5, music_check, music_off_check, vibre_check, food_male_plan_10_32, food_male_plan_10_33, weight_activ, colery_4, colery_5, colery_6, food_male_plan_10_36, food_male_plan_10_37, language1, food_male_plan_10_35_1, net_off, fars, en, de, ca, am, ch, title_1, title_2, title_3;

    public static Double colory_1, colory_12, colory_13, colory_14, colory_15;

    public static DecimalFormat df;

    public static int sk, mp_what, zaban;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    public static MediaPlayer click, click2;

    public static Vibrator vb, vb2;

    public static Context context;

    MyDatabaseHelper_lan language;

    public static int im_chengh_1, im_chengh_2, im_chengh_3, im_chengh_4, im_chengh_5, im_chengh_6, im_chengh_7, im_chengh_8, im_chengh_9, im_chengh_10, im_chengh_11, im_chengh_12, im_chengh_13, im_chengh_14, im_chengh_15, im_chengh_16, im_chengh_17, im_chengh_18, im_chengh_19, im_chengh_20, im_chengh_21, im_chengh_22, im_chengh_23, im_chengh_24, im_chengh_25, im_chengh_26, im_chengh_27, im_chengh_28, im_chengh_29, im_chengh_30, s_5;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    static SweetAlertDialog sd2;


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

                language1 = "fa";

            } else if (dadeha.toString().length() == 2) {
                //english.usa.canada

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("en");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language1 = "en";

            } else if (dadeha.toString().length() == 3) {
                //chine

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("zh");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language1 = "zh";

            } else if (dadeha.toString().length() == 6) {
                //german

                Configuration conf = getResources().getConfiguration();
                conf.locale = new Locale("de");
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                Resources resources = new Resources(getAssets(), metrics, conf);

                language1 = "de";

            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

        //start activ
        setContentView(R.layout.food_meal_plan_10);


        try {
            context = this;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sk = getResources().getColor(R.color.color30day);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }

        net_off = (String) getText(R.string.food_male_plan_10_food_net_off);

        if (app_net.getInstance(this).isOnline()) {
        } else {

            Toast.makeText(this, net_off, Toast.LENGTH_LONG).show();

        }

        Bundle colery = getIntent().getExtras();

        try {

            food_male_plan_10.vb2 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            food_male_plan_10.click2 = MediaPlayer.create(food_male_plan_10.this, R.raw.button);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
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
                vibre_check = "false";
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }


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


        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();



        // gerd konndeh adad
        try {
            df = new DecimalFormat("#.##");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mp_what = colery.getInt("mp");
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("7 Bundle mp"));
        }


            try {
                colory_low = colery.getString("colery2_came");
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7 Bundle colery2_came"));
            }
            try {
                weight_activ = colery.getString("weight_food_2");
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7 Bundle weight_food_2"));
            }
            try {
                colery_4 = colery.getString("tall_food_2");
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7 Bundle tall_food_2"));
            }
            try {
                colery_5 = colery.getString("weight_food_meghdar_2");
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7 Bundle weight_food_meghdar_2"));
            }
            try {
                colery_6 = colery.getString("gender_food_2");
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7 Bundle gender_food_2"));
            }


        s_5 = one_play_preferences.getInt("nov_meal_sped", 1);
        im_chengh_1 = one_play_preferences.getInt("im_1_1", 1);
        im_chengh_2 = one_play_preferences.getInt("im_1_2", 1);
        im_chengh_3 = one_play_preferences.getInt("im_1_3", 1);
        im_chengh_4 = one_play_preferences.getInt("im_1_4", 1);
        im_chengh_5 = one_play_preferences.getInt("im_1_5", 1);
        im_chengh_6 = one_play_preferences.getInt("im_1_6", 1);
        im_chengh_7 = one_play_preferences.getInt("im_1_7", 1);
        im_chengh_8 = one_play_preferences.getInt("im_1_8", 1);
        im_chengh_9 = one_play_preferences.getInt("im_1_9", 1);
        im_chengh_10 = one_play_preferences.getInt("im_1_10", 1);
        im_chengh_11 = one_play_preferences.getInt("im_2_1", 1);
        im_chengh_12 = one_play_preferences.getInt("im_2_2", 1);
        im_chengh_13 = one_play_preferences.getInt("im_2_3", 1);
        im_chengh_14 = one_play_preferences.getInt("im_2_4", 1);
        im_chengh_15 = one_play_preferences.getInt("im_2_5", 1);
        im_chengh_16 = one_play_preferences.getInt("im_2_6", 1);
        im_chengh_17 = one_play_preferences.getInt("im_2_7", 1);
        im_chengh_18 = one_play_preferences.getInt("im_2_8", 1);
        im_chengh_19 = one_play_preferences.getInt("im_2_9", 1);
        im_chengh_20 = one_play_preferences.getInt("im_2_10", 1);
        im_chengh_21 = one_play_preferences.getInt("im_3_1", 1);
        im_chengh_22 = one_play_preferences.getInt("im_3_2", 1);
        im_chengh_23 = one_play_preferences.getInt("im_3_3", 1);
        im_chengh_24 = one_play_preferences.getInt("im_3_4", 1);
        im_chengh_25 = one_play_preferences.getInt("im_3_5", 1);
        im_chengh_26 = one_play_preferences.getInt("im_3_6", 1);
        im_chengh_27 = one_play_preferences.getInt("im_3_7", 1);
        im_chengh_28 = one_play_preferences.getInt("im_3_8", 1);
        im_chengh_29 = one_play_preferences.getInt("im_3_9", 1);
        im_chengh_30 = one_play_preferences.getInt("im_3_10", 1);


        ddw();

        /**if (mp_what == 2) {

            colory_1 = Double.parseDouble(colory_low);
            colory_12 = ((colory_1 / 100) * 15);
            colory_12 = Double.valueOf(df.format(colory_12));
            colory_13 = ((colory_1 / 100) * 15) / 2;
            colory_13 = Double.valueOf(df.format(colory_13));
            colory_14 = ((colory_1 / 100) * 20);
            colory_14 = Double.valueOf(df.format(colory_14));
            colory_15 = ((colory_1 / 100) * 30);
            colory_15 = Double.valueOf(df.format(colory_15));

        } else if (mp_what == 3) {

            colory_1 = Double.parseDouble(colory_low);
            colory_12 = ((colory_1 / 100) * 30);
            colory_12 = Double.valueOf(df.format(colory_12));
            colory_13 = ((colory_1 / 100) * 5) / 2;
            colory_13 = Double.valueOf(df.format(colory_13));
            colory_14 = ((colory_1 / 100) * 20);
            colory_14 = Double.valueOf(df.format(colory_14));
            colory_15 = ((colory_1 / 100) * 35);
            colory_15 = Double.valueOf(df.format(colory_15));

        } else {

            colory_1 = Double.parseDouble(colory_low);
            colory_12 = ((colory_1 / 100) * 20);
            colory_12 = Double.valueOf(df.format(colory_12));
            colory_13 = ((colory_1 / 100) * 10) / 2;
            colory_13 = Double.valueOf(df.format(colory_13));
            colory_14 = ((colory_1 / 100) * 30);
            colory_14 = Double.valueOf(df.format(colory_14));
            colory_15 = ((colory_1 / 100) * 25);
            colory_15 = Double.valueOf(df.format(colory_15));

        }

        colory_sobh = String.valueOf(colory_12);
        colory_vade = String.valueOf(colory_13);
        colory_lanch = String.valueOf(colory_14);
        colory_dinner = String.valueOf(colory_15);*/

        ImageView back = (ImageView) findViewById(R.id.im_back_male_plan);

        back.setOnClickListener(this);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 3) {
                    case 0:
                        return food_male_plan_10_f_1.newInstance();
                    case 1:
                        return food_male_plan_10_f_2.newInstance();
                    case 2:
                        return food_male_plan_10_f_3.newInstance();
                    default:
                        return food_male_plan_10_f_1.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 3) {
                    case 0:
                        return getText(R.string.name_adp_1);
                    case 1:
                        return getText(R.string.name_adp_2);
                    case 2:
                        return getText(R.string.name_adp_3);
                }
                return "";
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        mViewPager.getViewPager().setCurrentItem(0);


        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        if (food_male_plan_10.mp_what == 2) {

                            return HeaderDesign.fromColorResAndUrl(
                                    R.color.color30day,
                                    "http://s8.picofile.com/file/8268180892/59168174_Medium.png");

                        } else if (food_male_plan_10.mp_what == 3) {

                            return HeaderDesign.fromColorResAndUrl(
                                    R.color.color30day,
                                    "http://s9.picofile.com/file/8268180934/Clean_Pack_NEW.png");

                        } else {

                            return HeaderDesign.fromColorResAndUrl(
                                    R.color.color30day,
                                    "http://s7.picofile.com/file/8267039784/1176924_healthy_eating_dark_style_eating_food_design_photocase_stock_photo_large.png");

                        }
                    case 1:

                        if (food_male_plan_10.mp_what == 2) {
                            return HeaderDesign.fromColorResAndUrl(
                                    R.color.color30day,
                                    "http://s8.picofile.com/file/8268201492/Dollarphotoclub_74900997.png");
                        } else if (food_male_plan_10.mp_what == 3) {
                            return HeaderDesign.fromColorResAndUrl(
                                    R.color.color30day,
                                    "http://s9.picofile.com/file/8268180984/RawMeat_1024x683.png");
                        } else {
                            return HeaderDesign.fromColorResAndUrl(
                                    R.color.color30day,
                                    "http://s6.picofile.com/file/8267039692/Yak3.png");
                        }
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.color30day,
                                "http://s9.picofile.com/file/8268179484/optimizedailyactivity.jpg");
                }
                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });


        getd();


        FirebaseCrash.log("log 2");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back_male_plan:
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

                    click = MediaPlayer.create(food_male_plan_10.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("9"));
                }


                Intent food_ = new Intent(food_male_plan_10.this, food.class);
                food_.putExtra("zaban_fo", zaban);
                food_male_plan_10.this.startActivity(food_);
                finish();

                break;


        }
        FirebaseCrash.log("log 1");

    }

    public static void show_dialog() {

        String no = (String) context.getText(R.string.ok);
        String t_1 = (String) context.getText(R.string.tit_dalog_not_nov);
        String t_2 = (String) context.getText(R.string.txt_dalog_not_nov);

        try {
            sd2 = new SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE);
            sd2.setTitleText(t_1);
            sd2.setContentText(t_2);
            sd2.setConfirmText(no);
            sd2.showCancelButton(false);
            sd2.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(final SweetAlertDialog sDialog) {

                    if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                        food_male_plan_10.vb2.cancel();
                    } else {
                        food_male_plan_10.vb2.vibrate(50);
                    }

                    if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                        food_male_plan_10.click2.stop();
                    } else {
                        food_male_plan_10.click2.start();
                    }

                    sDialog.cancel();

                }
            });
            sd2.show();
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("save check food"));
        }

    }


    private class GetData_one_play_preferences extends AsyncTask<String, String, String> {


        public ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(food_male_plan_10.this);
            pDialog.setMessage("لطفا کمی صبر کنید ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... strings) {



            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            pDialog.dismiss();

        }
    }

    public void ddw(){


            if (mp_what == 2) {

                s = (String) getText(R.string.food_male_plan_colory);
                colory_low_1_1 = (String) getText(R.string.food_male_plan_10_2);
                colory_low_1_2 = (String) getText(R.string.food_male_plan_10_3);
                colory_low_1_3 = (String) getText(R.string.food_male_plan_10_4);
                colory_low_1_4 = (String) getText(R.string.food_male_plan_10_5);
                colory_low_1_4_1 = (String) getText(R.string.food_male_plan_10_6_1);
                colory_low_1_4_2 = (String) getText(R.string.food_male_plan_10_6_2);
                colory_low_1_4_3 = (String) getText(R.string.food_male_plan_10_6_3);
                colory_low_1_4_4 = (String) getText(R.string.food_male_plan_10_6_4);
                colory_low_1_4_5 = (String) getText(R.string.food_male_plan_10_6_5);
                colory_low_1_5 = (String) getText(R.string.food_male_plan_10_9);
                colory_low_1_5_1 = (String) getText(R.string.food_male_plan_10_9_1);
                colory_low_1_5_2 = (String) getText(R.string.food_male_plan_10_9_2);
                colory_low_1_5_3 = (String) getText(R.string.food_male_plan_10_9_3);
                colory_low_1_5_4 = (String) getText(R.string.food_male_plan_10_9_4);
                colory_low_1_5_5 = (String) getText(R.string.food_male_plan_10_9_5);
                colory_low_1_6 = (String) getText(R.string.food_male_plan_10_7);
                colory_low_1_6_1 = (String) getText(R.string.food_male_plan_10_8_1);
                colory_low_1_6_2 = (String) getText(R.string.food_male_plan_10_8_2);
                colory_low_1_6_3 = (String) getText(R.string.food_male_plan_10_8_3);
                colory_low_1_6_4 = (String) getText(R.string.food_male_plan_10_8_4);
                colory_low_1_6_5 = (String) getText(R.string.food_male_plan_10_8_5);
                colory_low_1_7 = (String) getText(R.string.food_male_plan_10_9);
                colory_low_1_7_1 = (String) getText(R.string.food_male_plan_10_10_1);
                colory_low_1_7_2 = (String) getText(R.string.food_male_plan_10_10_2);
                colory_low_1_7_3 = (String) getText(R.string.food_male_plan_10_10_3);
                colory_low_1_7_4 = (String) getText(R.string.food_male_plan_10_10_4);
                colory_low_1_7_5 = (String) getText(R.string.food_male_plan_10_10_5);
                colory_low_1_8 = (String) getText(R.string.food_male_plan_10_11);
                colory_low_1_8_1 = (String) getText(R.string.food_male_plan_10_11_1);
                colory_low_1_8_2 = (String) getText(R.string.food_male_plan_10_11_2);
                colory_low_1_8_3 = (String) getText(R.string.food_male_plan_10_11_3);
                colory_low_1_8_4 = (String) getText(R.string.food_male_plan_10_11_4);
                colory_low_1_8_5 = (String) getText(R.string.food_male_plan_10_11_5);
                colory_low_2 = (String) getText(R.string.food_male_plan_10_12);
                colory_low_3 = (String) getText(R.string.food_male_plan_10_13);
                colory_low_4 = (String) getText(R.string.food_male_plan_10_14);
                colory_low_5 = (String) getText(R.string.food_male_plan_10_1);
                title_1 = (String) getText(R.string.name_adp_1);
                title_2 = (String) getText(R.string.name_adp_2);
                title_3 = (String) getText(R.string.name_adp_3);


                food_male_plan_10_32 = (String) getText(R.string.food_male_plan_10_32);
                food_male_plan_10_33 = (String) getText(R.string.food_male_plan_10_33);
                food_male_plan_10_36 = (String) getText(R.string.food_male_plan_10_36);
                food_male_plan_10_37 = (String) getText(R.string.food_male_plan_10_37);
                food_male_plan_10_38 = (String) getText(R.string.food_male_plan_10_38);
                food_male_plan_10_39 = (String) getText(R.string.food_male_plan_10_39);


                food_male_plan_10_35_1 = food_male_plan_10_38
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_33
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_36
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_37
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_39;

            } else if (mp_what == 3) {

                s = (String) getText(R.string.food_male_plan_colory);
                colory_low_1_1 = (String) getText(R.string.food_male_plan_10_2);
                colory_low_1_2 = (String) getText(R.string.food_male_plan_10_3);
                colory_low_1_3 = (String) getText(R.string.food_male_plan_10_4);
                colory_low_1_4 = (String) getText(R.string.food_male_plan_10_5);
                colory_low_1_6 = (String) getText(R.string.food_male_plan_10_7);
                colory_low_1_8 = (String) getText(R.string.food_male_plan_10_11);

                String bf_1 = (String) getText(R.string.food_male_plan_10_6_3_1);
                String bf_2 = (String) getText(R.string.food_male_plan_10_6_3_2);
                String bf_3 = (String) getText(R.string.food_male_plan_10_6_3_3);
                String bf_4 = (String) getText(R.string.food_male_plan_10_6_3_4);
                String bf_5 = (String) getText(R.string.food_male_plan_10_6_3_5);
                String bf_6 = (String) getText(R.string.food_male_plan_10_6_3_6);
                String bf_7 = (String) getText(R.string.food_male_plan_10_6_3_7);
                String bf_8 = (String) getText(R.string.food_male_plan_10_6_3_8);
                String bf_9 = (String) getText(R.string.food_male_plan_10_6_3_9);
                String bf_10 = (String) getText(R.string.food_male_plan_10_6_3_10);

                colory_low_1_4_1 = bf_1
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_2
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_3
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_4
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_5
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_6
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_7
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_8
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_9
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + bf_10;


                String l_1 = (String) getText(R.string.food_male_plan_30_2_1);
                String l_2 = (String) getText(R.string.food_male_plan_30_2_2);
                String l_3 = (String) getText(R.string.food_male_plan_30_2_3);
                String l_4 = (String) getText(R.string.food_male_plan_30_2_4);
                String l_5 = (String) getText(R.string.food_male_plan_30_2_5);
                String l_6 = (String) getText(R.string.food_male_plan_30_2_6);
                String l_7 = (String) getText(R.string.food_male_plan_30_2_7);
                String l_8 = (String) getText(R.string.food_male_plan_30_2_8);
                String l_9 = (String) getText(R.string.food_male_plan_30_2_9);
                String l_10 = (String) getText(R.string.food_male_plan_30_2_10);

                colory_low_1_6_1 = l_1
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_2
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_3
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_4
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_5
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_6
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_7
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_8
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_9
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + l_10;

                String d_1 = (String) getText(R.string.food_male_plan_30_3_1);
                String d_2 = (String) getText(R.string.food_male_plan_30_3_2);
                String d_3 = (String) getText(R.string.food_male_plan_30_3_3);
                String d_4 = (String) getText(R.string.food_male_plan_30_3_4);
                String d_5 = (String) getText(R.string.food_male_plan_30_3_5);
                String d_6 = (String) getText(R.string.food_male_plan_30_3_6);
                String d_7 = (String) getText(R.string.food_male_plan_30_3_7);
                String d_8 = (String) getText(R.string.food_male_plan_30_3_8);
                String d_9 = (String) getText(R.string.food_male_plan_30_3_9);
                String d_10 = (String) getText(R.string.food_male_plan_30_3_10);


                colory_low_1_8_1 = d_1
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_2
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_3
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_4
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_5
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_6
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_7
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_8
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_9
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + d_10;


                String at_1 = (String) getText(R.string.food_male_plan_10_14_1);
                String at_2 = (String) getText(R.string.food_male_plan_10_14_2);
                String at_3 = (String) getText(R.string.food_male_plan_10_14_3);
                String at_4 = (String) getText(R.string.food_male_plan_10_14_4);

                colory_low_4 = at_1
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + at_2
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + at_3
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + at_4;


                colory_low_2 = (String) getText(R.string.food_male_plan_10_12);
                colory_low_3 = (String) getText(R.string.food_male_plan_10_13);
                colory_low_5 = (String) getText(R.string.food_male_plan_10_1);


                food_male_plan_10_32 = (String) getText(R.string.food_male_plan_10_32);
                food_male_plan_10_33 = (String) getText(R.string.food_male_plan_10_33);
                food_male_plan_10_36 = (String) getText(R.string.food_male_plan_10_36);
                food_male_plan_10_37 = (String) getText(R.string.food_male_plan_10_37);
                food_male_plan_10_38 = (String) getText(R.string.food_male_plan_10_38);
                food_male_plan_10_39 = (String) getText(R.string.food_male_plan_10_39);


                food_male_plan_10_35_1 = food_male_plan_10_38
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_33
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_36
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_37
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_39;

            } else {

                s = (String) getText(R.string.food_male_plan_colory);
                colory_low_1_1 = (String) getText(R.string.food_male_plan_10_2);
                colory_low_1_2 = (String) getText(R.string.food_male_plan_10_3);
                colory_low_1_3 = (String) getText(R.string.food_male_plan_10_4);
                colory_low_1_4 = (String) getText(R.string.food_male_plan_10_5);
                colory_low_1_4_1 = (String) getText(R.string.food_male_plan_10_6_1);
                colory_low_1_4_2 = (String) getText(R.string.food_male_plan_10_6_2);
                colory_low_1_4_3 = (String) getText(R.string.food_male_plan_10_6_3);
                colory_low_1_4_4 = (String) getText(R.string.food_male_plan_10_6_4);
                colory_low_1_4_5 = (String) getText(R.string.food_male_plan_10_6_5);
                colory_low_1_5 = (String) getText(R.string.food_male_plan_10_9);
                colory_low_1_5_1 = (String) getText(R.string.food_male_plan_10_9_1);
                colory_low_1_5_2 = (String) getText(R.string.food_male_plan_10_9_2);
                colory_low_1_5_3 = (String) getText(R.string.food_male_plan_10_9_3);
                colory_low_1_5_4 = (String) getText(R.string.food_male_plan_10_9_4);
                colory_low_1_5_5 = (String) getText(R.string.food_male_plan_10_9_5);
                colory_low_1_6 = (String) getText(R.string.food_male_plan_10_7);
                colory_low_1_6_1 = (String) getText(R.string.food_male_plan_10_8_1);
                colory_low_1_6_2 = (String) getText(R.string.food_male_plan_10_8_2);
                colory_low_1_6_3 = (String) getText(R.string.food_male_plan_10_8_3);
                colory_low_1_6_4 = (String) getText(R.string.food_male_plan_10_8_4);
                colory_low_1_6_5 = (String) getText(R.string.food_male_plan_10_8_5);
                colory_low_1_7 = (String) getText(R.string.food_male_plan_10_9);
                colory_low_1_7_1 = (String) getText(R.string.food_male_plan_10_10_1);
                colory_low_1_7_2 = (String) getText(R.string.food_male_plan_10_10_2);
                colory_low_1_7_3 = (String) getText(R.string.food_male_plan_10_10_3);
                colory_low_1_7_4 = (String) getText(R.string.food_male_plan_10_10_4);
                colory_low_1_7_5 = (String) getText(R.string.food_male_plan_10_10_5);
                colory_low_1_8 = (String) getText(R.string.food_male_plan_10_11);
                colory_low_1_8_1 = (String) getText(R.string.food_male_plan_10_11_1);
                colory_low_1_8_2 = (String) getText(R.string.food_male_plan_10_11_2);
                colory_low_1_8_3 = (String) getText(R.string.food_male_plan_10_11_3);
                colory_low_1_8_4 = (String) getText(R.string.food_male_plan_10_11_4);
                colory_low_1_8_5 = (String) getText(R.string.food_male_plan_10_11_5);
                colory_low_2 = (String) getText(R.string.food_male_plan_10_12);
                colory_low_3 = (String) getText(R.string.food_male_plan_10_13);
                colory_low_4 = (String) getText(R.string.food_male_plan_10_14);
                colory_low_5 = (String) getText(R.string.food_male_plan_10_1);


                food_male_plan_10_32 = (String) getText(R.string.food_male_plan_10_32);
                food_male_plan_10_33 = (String) getText(R.string.food_male_plan_10_33);
                food_male_plan_10_36 = (String) getText(R.string.food_male_plan_10_36);
                food_male_plan_10_37 = (String) getText(R.string.food_male_plan_10_37);
                food_male_plan_10_38 = (String) getText(R.string.food_male_plan_10_38);
                food_male_plan_10_39 = (String) getText(R.string.food_male_plan_10_39);


                food_male_plan_10_35_1 = food_male_plan_10_38
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_33
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_36
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_37
                        + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + food_male_plan_10_39;

            }


    }

    public void getd(){

            food_1 = (String) getText(R.string.food_male_plan_10_food_actiy_1_1);
            food_2 = (String) getText(R.string.food_male_plan_10_food_actiy_1_2);
            food_3 = (String) getText(R.string.food_male_plan_10_food_actiy_1_3);
            food_4 = (String) getText(R.string.food_male_plan_10_food_actiy_1_4);
            food_5 = (String) getText(R.string.food_male_plan_10_food_actiy_1_5);
            food_6 = (String) getText(R.string.food_male_plan_10_food_actiy_1_6);
            food_7 = (String) getText(R.string.food_male_plan_10_food_actiy_1_7);
            food_8 = (String) getText(R.string.food_male_plan_10_food_actiy_1_8);
            food_9 = (String) getText(R.string.food_male_plan_10_food_actiy_1_9);
            food_10 = (String) getText(R.string.food_male_plan_10_food_actiy_1_10);
            food_11 = (String) getText(R.string.food_male_plan_10_food_actiy_1_11);
            food_12 = (String) getText(R.string.food_male_plan_10_food_actiy_1_12);
            food_13 = (String) getText(R.string.food_male_plan_10_food_actiy_1_13);
            food_14 = (String) getText(R.string.food_male_plan_10_food_actiy_1_14);
            food_15 = (String) getText(R.string.food_male_plan_10_food_actiy_1_15);
            food_16 = (String) getText(R.string.food_male_plan_10_food_actiy_1_16);
            food_17 = (String) getText(R.string.food_male_plan_10_food_actiy_1_17);
            food_18 = (String) getText(R.string.food_male_plan_10_food_actiy_1_18);
            food_19 = (String) getText(R.string.food_male_plan_10_food_actiy_1_19);
            food_20 = (String) getText(R.string.food_male_plan_10_food_actiy_1_20);
            food_21 = (String) getText(R.string.food_male_plan_10_food_actiy_1_21);
            food_22 = (String) getText(R.string.food_male_plan_10_food_actiy_1_22);
            food_23 = (String) getText(R.string.food_male_plan_10_food_actiy_1_23);
            food_24 = (String) getText(R.string.food_male_plan_10_food_actiy_1_24);
            food_25 = (String) getText(R.string.food_male_plan_10_food_actiy_1_25);
            food_26 = (String) getText(R.string.food_male_plan_10_food_actiy_1_26);
            food_27 = (String) getText(R.string.food_male_plan_10_food_actiy_1_27);
            food_28 = (String) getText(R.string.food_male_plan_10_food_actiy_1_28);
            food_29 = (String) getText(R.string.food_male_plan_10_food_actiy_1_29);
            food_30 = (String) getText(R.string.food_male_plan_10_food_actiy_1_30);
            food_31 = (String) getText(R.string.food_male_plan_10_food_actiy_1_31);
            food_32 = (String) getText(R.string.food_male_plan_10_food_actiy_1_32);
            food_33 = (String) getText(R.string.food_male_plan_10_food_actiy_1_33);
            food_34 = (String) getText(R.string.food_male_plan_10_food_actiy_1_34);
            food_35 = (String) getText(R.string.food_male_plan_10_food_actiy_1_35);
            food_36 = (String) getText(R.string.food_male_plan_10_food_actiy_1_36);
            food_37 = (String) getText(R.string.food_male_plan_10_food_actiy_1_37);
            food_38 = (String) getText(R.string.food_male_plan_10_food_actiy_1_38);
            food_39 = (String) getText(R.string.food_male_plan_10_food_actiy_1_39);
            food_40 = (String) getText(R.string.food_male_plan_10_food_actiy_1_40);
            food_41 = (String) getText(R.string.food_male_plan_10_food_actiy_1_41);
            food_42 = (String) getText(R.string.food_male_plan_10_food_actiy_1_42);
            food_43 = (String) getText(R.string.food_male_plan_10_food_actiy_1_43);
            food_44 = (String) getText(R.string.food_male_plan_10_food_actiy_1_44);
            food_45 = (String) getText(R.string.food_male_plan_10_food_actiy_1_45);
            food_46 = (String) getText(R.string.food_male_plan_10_food_actiy_1_46);
            food_47 = (String) getText(R.string.food_male_plan_10_food_actiy_1_47);
            food_48 = (String) getText(R.string.food_male_plan_10_food_actiy_1_48);
            food_49 = (String) getText(R.string.food_male_plan_10_food_actiy_1_49);
            food_50 = (String) getText(R.string.food_male_plan_10_food_actiy_1_50);
            food_51 = (String) getText(R.string.food_male_plan_10_food_actiy_1_51);
            food_52 = (String) getText(R.string.food_male_plan_10_food_actiy_1_52);
            food_53 = (String) getText(R.string.food_male_plan_10_food_actiy_1_53);
            food_54 = (String) getText(R.string.food_male_plan_10_food_actiy_1_54);
            food_55 = (String) getText(R.string.food_male_plan_10_food_actiy_1_55);
            food_56 = (String) getText(R.string.food_male_plan_10_food_actiy_1_56);
            food_57 = (String) getText(R.string.food_male_plan_10_food_actiy_1_57);
            food_58 = (String) getText(R.string.food_male_plan_10_food_actiy_1_58);
            food_59 = (String) getText(R.string.food_male_plan_10_food_actiy_1_59);
            food_60 = (String) getText(R.string.food_male_plan_10_food_actiy_1_60);
            food_61 = (String) getText(R.string.food_male_plan_10_food_actiy_1_61);
            food_62 = (String) getText(R.string.food_male_plan_10_food_actiy_1_62);
            food_63 = (String) getText(R.string.food_male_plan_10_food_actiy_1_63);
            food_64 = (String) getText(R.string.food_male_plan_10_food_actiy_1_64);
            food_65 = (String) getText(R.string.food_male_plan_10_food_actiy_1_65);
            food_66 = (String) getText(R.string.food_male_plan_10_food_actiy_1_66);
            food_67 = (String) getText(R.string.food_male_plan_10_food_actiy_1_67);
            food_68 = (String) getText(R.string.food_male_plan_10_food_actiy_1_68);
            food_69 = (String) getText(R.string.food_male_plan_10_food_actiy_1_69);
            food_70 = (String) getText(R.string.food_male_plan_10_food_actiy_1_70);
            food_71 = (String) getText(R.string.food_male_plan_10_food_actiy_1_71);
            food_72 = (String) getText(R.string.food_male_plan_10_food_actiy_1_72);
            food_73 = (String) getText(R.string.food_male_plan_10_food_actiy_1_73);
            food_74 = (String) getText(R.string.food_male_plan_10_food_actiy_1_74);
            food_75 = (String) getText(R.string.food_male_plan_10_food_actiy_1_75);
            food_76 = (String) getText(R.string.food_male_plan_10_food_actiy_1_76);
            food_77 = (String) getText(R.string.food_male_plan_10_food_actiy_1_77);
            food_78 = (String) getText(R.string.food_male_plan_10_food_actiy_1_78);
            food_79 = (String) getText(R.string.food_male_plan_10_food_actiy_1_79);
            food_80 = (String) getText(R.string.food_male_plan_10_food_actiy_1_80);
            food_81 = (String) getText(R.string.food_male_plan_10_food_actiy_1_81);
            food_82 = (String) getText(R.string.food_male_plan_10_food_actiy_1_82);
            food_83 = (String) getText(R.string.food_male_plan_10_food_actiy_1_83);
            food_84 = (String) getText(R.string.food_male_plan_10_food_actiy_1_84);
            food_85 = (String) getText(R.string.food_male_plan_10_food_actiy_1_85);
            food_86 = (String) getText(R.string.food_male_plan_10_food_actiy_1_86);
            food_87 = (String) getText(R.string.food_male_plan_10_food_actiy_1_87);
            food_88 = (String) getText(R.string.food_male_plan_10_food_actiy_1_88);
            food_89 = (String) getText(R.string.food_male_plan_10_food_actiy_1_89);
            food_90 = (String) getText(R.string.food_male_plan_10_food_actiy_1_90);
            food_91 = (String) getText(R.string.food_male_plan_10_food_actiy_1_91);
            food_92 = (String) getText(R.string.food_male_plan_10_food_actiy_1_92);
            food_93 = (String) getText(R.string.food_male_plan_10_food_actiy_1_93);
            food_94 = (String) getText(R.string.food_male_plan_10_food_actiy_1_94);
            food_95 = (String) getText(R.string.food_male_plan_10_food_actiy_1_95);
            food_96 = (String) getText(R.string.food_male_plan_10_food_actiy_1_96);
            food_97 = (String) getText(R.string.food_male_plan_10_food_actiy_1_97);
            food_98 = (String) getText(R.string.food_male_plan_10_food_actiy_1_98);
            food_99 = (String) getText(R.string.food_male_plan_10_food_actiy_1_99);
            food_100 = (String) getText(R.string.food_male_plan_10_food_actiy_1_100);
            food_101 = (String) getText(R.string.food_male_plan_10_food_actiy_1_101);
            food_102 = (String) getText(R.string.food_male_plan_10_food_actiy_1_102);
            food_103 = (String) getText(R.string.food_male_plan_10_food_actiy_1_103);
            food_104 = (String) getText(R.string.food_male_plan_10_food_actiy_1_104);
            food_105 = (String) getText(R.string.food_male_plan_10_food_actiy_1_105);
            food_106 = (String) getText(R.string.food_male_plan_10_food_actiy_1_106);
            food_107 = (String) getText(R.string.food_male_plan_10_food_actiy_1_107);
            food_108 = (String) getText(R.string.food_male_plan_10_food_actiy_1_108);
            food_109 = (String) getText(R.string.food_male_plan_10_food_actiy_1_109);
            food_110 = (String) getText(R.string.food_male_plan_10_food_actiy_1_110);
            food_111 = (String) getText(R.string.food_male_plan_10_food_actiy_1_111);
            food_112 = (String) getText(R.string.food_male_plan_10_food_actiy_1_112);
            food_113 = (String) getText(R.string.food_male_plan_10_food_actiy_1_113);
            food_114 = (String) getText(R.string.food_male_plan_10_food_actiy_1_114);
            food_115 = (String) getText(R.string.food_male_plan_10_food_actiy_1_115);
            food_116 = (String) getText(R.string.food_male_plan_10_food_actiy_1_116);
            food_117 = (String) getText(R.string.food_male_plan_10_food_actiy_1_117);
            food_118 = (String) getText(R.string.food_male_plan_10_food_actiy_1_118);
            food_119 = (String) getText(R.string.food_male_plan_10_food_actiy_1_119);
            food_120 = (String) getText(R.string.food_male_plan_10_food_actiy_1_120);
            food_121 = (String) getText(R.string.food_male_plan_10_food_actiy_1_121);
            food_122 = (String) getText(R.string.food_male_plan_10_food_actiy_1_122);
            food_123 = (String) getText(R.string.food_male_plan_10_food_actiy_1_123);
            food_124 = (String) getText(R.string.food_male_plan_10_food_actiy_1_124);
            food_125 = (String) getText(R.string.food_male_plan_10_food_actiy_1_125);


            size_1 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_1);
            size_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_2);
            size_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_3);
            size_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_4);
            size_5 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_5);
            size_6 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_6);
            size_7 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_7);
            size_8 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_8);
            size_9 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_9);
            size_10 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_10);
            size_11 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_11);
            size_12 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_12);
            size_13 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_13);
            size_14 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_14);
            size_15 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_15);
            size_16 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_16);
            size_17 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_17);
            size_18 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_18);
            size_19 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_19);
            size_20 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_20);
            size_21 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_21);
            size_22 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_22);
            size_23 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_23);
            size_24 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_24);
            size_25 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_25);
            size_26 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_26);
            size_27 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_27);
            size_28 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_28);
            size_29 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_29);
            size_30 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_30);
            size_31 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_31);
            size_32 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_32);
            size_33 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_33);
            size_34 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_34);
            size_35 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_35);
            size_36 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_36);
            size_37 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_37);
            size_38 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_38);
            size_39 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_39);
            size_40 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_40);
            size_41 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_41);
            size_42 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_42);
            size_43 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_43);
            size_44 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_44);
            size_45 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_45);
            size_46 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_46);
            size_47 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_47);
            size_48 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_48);
            size_49 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_49);
            size_50 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_50);
            size_51 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_51);
            size_52 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_52);
            size_53 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_53);
            size_54 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_54);
            size_55 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_55);
            size_56 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_56);
            size_57 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_57);
            size_58 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_58);
            size_59 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_59);
            size_60 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_60);
            size_61 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_61);
            size_62 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_62);
            size_63 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_63);
            size_64 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_64);
            size_65 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_65);
            size_66 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_66);
            size_67 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_67);
            size_68 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_68);
            size_69 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_69);
            size_70 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_70);
            size_71 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_71);
            size_72 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_72);
            size_73 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_73);
            size_74 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_74);
            size_75 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_75);
            size_76 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_76);
            size_77 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_77);
            size_78 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_78);
            size_79 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_79);
            size_80 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_80);
            size_81 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_81);
            size_82 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_82);
            size_83 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_83);
            size_84 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_84);
            size_85 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_85);
            size_86 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_86);
            size_87 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_87);
            size_88 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_88);
            size_89 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_89);
            size_90 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_90);
            size_91 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_91);
            size_92 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_92);
            size_93 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_93);
            size_94 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_94);
            size_95 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_95);
            size_96 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_96);
            size_97 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_97);
            size_98 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_98);
            size_99 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_99);
            size_100 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_100);
            size_101 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_101);
            size_102 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_102);
            size_103 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_103);
            size_104 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_104);
            size_105 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_105);
            size_106 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_106);
            size_107 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_107);
            size_108 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_108);
            size_109 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_109);
            size_110 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_110);
            size_111 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_111);
            size_112 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_112);
            size_113 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_113);
            size_114 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_114);
            size_115 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_115);
            size_116 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_116);
            size_117 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_117);
            size_118 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_118);
            size_119 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_119);
            size_120 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_120);
            size_121 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_121);
            size_122 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_122);
            size_123 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_123);
            size_124 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_124);
            size_125 = (String) getText(R.string.food_male_plan_10_food_actiy_2_1_125);


            size_1_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_1);
            size_2_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_2);
            size_3_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_3);
            size_4_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_4);
            size_5_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_5);
            size_6_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_6);
            size_7_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_7);
            size_8_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_8);
            size_9_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_9);
            size_10_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_10);
            size_11_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_11);
            size_12_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_12);
            size_13_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_13);
            size_14_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_14);
            size_15_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_15);
            size_16_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_16);
            size_17_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_17);
            size_18_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_18);
            size_19_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_19);
            size_20_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_20);
            size_21_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_21);
            size_22_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_22);
            size_23_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_23);
            size_24_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_24);
            size_25_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_25);
            size_26_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_26);
            size_27_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_27);
            size_28_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_28);
            size_29_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_29);
            size_30_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_30);
            size_31_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_31);
            size_32_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_32);
            size_33_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_33);
            size_34_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_34);
            size_35_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_35);
            size_36_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_36);
            size_37_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_37);
            size_38_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_38);
            size_39_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_39);
            size_40_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_40);
            size_41_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_41);
            size_42_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_42);
            size_43_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_43);
            size_44_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_44);
            size_45_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_45);
            size_46_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_46);
            size_47_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_47);
            size_48_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_48);
            size_49_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_49);
            size_50_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_50);
            size_51_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_51);
            size_52_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_52);
            size_53_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_53);
            size_54_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_54);
            size_55_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_55);
            size_56_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_56);
            size_57_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_57);
            size_58_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_58);
            size_59_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_59);
            size_60_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_60);
            size_61_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_61);
            size_62_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_62);
            size_63_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_63);
            size_64_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_64);
            size_65_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_65);
            size_66_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_66);
            size_67_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_67);
            size_68_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_68);
            size_69_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_69);
            size_70_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_70);
            size_71_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_71);
            size_72_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_72);
            size_73_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_73);
            size_74_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_74);
            size_75_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_75);
            size_76_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_76);
            size_77_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_77);
            size_78_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_78);
            size_79_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_79);
            size_80_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_80);
            size_81_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_81);
            size_82_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_82);
            size_83_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_83);
            size_84_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_84);
            size_85_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_85);
            size_86_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_86);
            size_87_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_87);
            size_88_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_88);
            size_89_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_89);
            size_90_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_90);
            size_91_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_91);
            size_92_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_92);
            size_93_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_93);
            size_94_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_94);
            size_95_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_95);
            size_96_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_96);
            size_97_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_97);
            size_98_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_98);
            size_99_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_99);
            size_100_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_100);
            size_101_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_101);
            size_102_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_102);
            size_103_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_103);
            size_104_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_104);
            size_105_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_105);
            size_106_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_106);
            size_107_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_107);
            size_108_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_108);
            size_109_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_109);
            size_110_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_110);
            size_111_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_111);
            size_112_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_112);
            size_113_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_113);
            size_114_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_114);
            size_115_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_115);
            size_116_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_116);
            size_117_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_117);
            size_118_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_118);
            size_119_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_119);
            size_120_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_120);
            size_121_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_121);
            size_122_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_122);
            size_123_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_123);
            size_124_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_124);
            size_125_2 = (String) getText(R.string.food_male_plan_10_food_actiy_2_2_125);


            size_1_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_1);
            size_2_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_2);
            size_3_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_3);
            size_4_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_4);
            size_5_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_5);
            size_6_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_6);
            size_7_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_7);
            size_8_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_8);
            size_9_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_9);
            size_10_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_10);
            size_11_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_11);
            size_12_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_12);
            size_13_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_13);
            size_14_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_14);
            size_15_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_15);
            size_16_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_16);
            size_17_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_17);
            size_18_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_18);
            size_19_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_19);
            size_20_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_20);
            size_21_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_21);
            size_22_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_22);
            size_23_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_23);
            size_24_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_24);
            size_25_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_25);
            size_26_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_26);
            size_27_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_27);
            size_28_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_28);
            size_29_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_29);
            size_30_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_30);
            size_31_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_31);
            size_32_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_32);
            size_33_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_33);
            size_34_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_34);
            size_35_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_35);
            size_36_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_36);
            size_37_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_37);
            size_38_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_38);
            size_39_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_39);
            size_40_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_40);
            size_41_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_41);
            size_42_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_42);
            size_43_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_43);
            size_44_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_44);
            size_45_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_45);
            size_46_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_46);
            size_47_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_47);
            size_48_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_48);
            size_49_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_49);
            size_50_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_50);
            size_51_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_51);
            size_52_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_52);
            size_53_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_53);
            size_54_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_54);
            size_55_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_55);
            size_56_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_56);
            size_57_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_57);
            size_58_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_58);
            size_59_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_59);
            size_60_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_60);
            size_61_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_61);
            size_62_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_62);
            size_63_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_63);
            size_64_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_64);
            size_65_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_65);
            size_66_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_66);
            size_67_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_67);
            size_68_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_68);
            size_69_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_69);
            size_70_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_70);
            size_71_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_71);
            size_72_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_72);
            size_73_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_73);
            size_74_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_74);
            size_75_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_75);
            size_76_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_76);
            size_77_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_77);
            size_78_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_78);
            size_79_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_79);
            size_80_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_80);
            size_81_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_81);
            size_82_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_82);
            size_83_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_83);
            size_84_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_84);
            size_85_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_85);
            size_86_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_86);
            size_87_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_87);
            size_88_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_88);
            size_89_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_89);
            size_90_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_90);
            size_91_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_91);
            size_92_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_92);
            size_93_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_93);
            size_94_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_94);
            size_95_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_95);
            size_96_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_96);
            size_97_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_97);
            size_98_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_98);
            size_99_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_99);
            size_100_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_100);
            size_101_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_101);
            size_102_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_102);
            size_103_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_103);
            size_104_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_104);
            size_105_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_105);
            size_106_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_106);
            size_107_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_107);
            size_108_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_108);
            size_109_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_109);
            size_110_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_110);
            size_111_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_111);
            size_112_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_112);
            size_113_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_113);
            size_114_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_114);
            size_115_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_115);
            size_116_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_116);
            size_117_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_117);
            size_118_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_118);
            size_119_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_119);
            size_120_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_120);
            size_121_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_121);
            size_122_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_122);
            size_123_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_123);
            size_124_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_124);
            size_125_3 = (String) getText(R.string.food_male_plan_10_food_actiy_2_3_125);


            size_1_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_1);
            size_2_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_2);
            size_3_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_3);
            size_4_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_4);
            size_5_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_5);
            size_6_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_6);
            size_7_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_7);
            size_8_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_8);
            size_9_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_9);
            size_10_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_10);
            size_11_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_11);
            size_12_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_12);
            size_13_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_13);
            size_14_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_14);
            size_15_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_15);
            size_16_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_16);
            size_17_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_17);
            size_18_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_18);
            size_19_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_19);
            size_20_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_20);
            size_21_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_21);
            size_22_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_22);
            size_23_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_23);
            size_24_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_24);
            size_25_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_25);
            size_26_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_26);
            size_27_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_27);
            size_28_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_28);
            size_29_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_29);
            size_30_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_30);
            size_31_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_31);
            size_32_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_32);
            size_33_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_33);
            size_34_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_34);
            size_35_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_35);
            size_36_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_36);
            size_37_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_37);
            size_38_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_38);
            size_39_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_39);
            size_40_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_40);
            size_41_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_41);
            size_42_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_42);
            size_43_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_43);
            size_44_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_44);
            size_45_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_45);
            size_46_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_46);
            size_47_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_47);
            size_48_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_48);
            size_49_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_49);
            size_50_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_50);
            size_51_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_51);
            size_52_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_52);
            size_53_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_53);
            size_54_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_54);
            size_55_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_55);
            size_56_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_56);
            size_57_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_57);
            size_58_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_58);
            size_59_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_59);
            size_60_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_60);
            size_61_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_61);
            size_62_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_62);
            size_63_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_63);
            size_64_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_64);
            size_65_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_65);
            size_66_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_66);
            size_67_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_67);
            size_68_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_68);
            size_69_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_69);
            size_70_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_70);
            size_71_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_71);
            size_72_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_72);
            size_73_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_73);
            size_74_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_74);
            size_75_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_75);
            size_76_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_76);
            size_77_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_77);
            size_78_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_78);
            size_79_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_79);
            size_80_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_80);
            size_81_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_81);
            size_82_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_82);
            size_83_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_83);
            size_84_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_84);
            size_85_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_85);
            size_86_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_86);
            size_87_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_87);
            size_88_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_88);
            size_89_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_89);
            size_90_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_90);
            size_91_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_91);
            size_92_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_92);
            size_93_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_93);
            size_94_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_94);
            size_95_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_95);
            size_96_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_96);
            size_97_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_97);
            size_98_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_98);
            size_99_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_99);
            size_100_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_100);
            size_101_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_101);
            size_102_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_102);
            size_103_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_103);
            size_104_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_104);
            size_105_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_105);
            size_106_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_106);
            size_107_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_107);
            size_108_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_108);
            size_109_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_109);
            size_110_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_110);
            size_111_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_111);
            size_112_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_112);
            size_113_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_113);
            size_114_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_114);
            size_115_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_115);
            size_116_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_116);
            size_117_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_117);
            size_118_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_118);
            size_119_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_119);
            size_120_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_120);
            size_121_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_121);
            size_122_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_122);
            size_123_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_123);
            size_124_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_124);
            size_125_4 = (String) getText(R.string.food_male_plan_10_food_actiy_2_4_125);

        }

}

