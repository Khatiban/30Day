package com.android.fury.a30day.food;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.android.fury.a30day.app_net;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by fury on 9/10/2016.
 */
public class food_male_plan_10_food extends AppCompatActivity implements View.OnClickListener {

    private MaterialViewPager mViewPager;

    public static Activity context;

    public static String s, fasele, ss1, music_check, music_off_check, vibre_check, net_off, food_ma_1_1, food_ma_1, food_ma_1_2, food_ma_1_3, food_ma_1_4, food_ma_1_5, food_ma_1_6, food_ma_1_7, food_ma_1_8, food_ma_1_9, food_ma_1_10, food_ma_1_11, food_ma_1_12, food_male_plan_10_food_1_r_1, food_male_plan_10_food_1_r_2, food_male_plan_10_food_1_r_3, food_male_plan_10_food_1_r_4, food_male_plan_10_food_1_r, food_ma_2_1, food_ma_2_2, food_ma_2_3, food_ma_2_4, food_ma_2_5, food_ma_2, food_male_plan_10_food_2_r_1, food_male_plan_10_food_2_r_2, food_male_plan_10_food_2_r, food_ma_3_1, food_ma_3_2, food_ma_3_3, food_ma_3_4, food_ma_3_5, food_ma_3_6, food_ma_3_7, food_ma_3_8, food_ma_3_9, food_ma_3, food_male_plan_10_food_3_r_1, food_male_plan_10_food_3_r_2, food_male_plan_10_food_3_r_3, food_male_plan_10_food_3_r_4, food_male_plan_10_food_3_r, food_ma_4_1, food_ma_4_2, food_ma_4_3, food_ma_4_4, food_ma_4_5, food_ma_4_6, food_ma_4_7, food_ma_4_8, food_ma_4_9, food_ma_4_10, food_ma_4_11, food_male_plan_10_food_4_r_1, food_male_plan_10_food_4_r_2, food_ma_4, food_male_plan_10_food_4_r, food_ma_5_1, food_ma_5_2, food_ma_5_3, food_ma_5_4, food_ma_5_5, food_ma_5_6, food_ma_5_7, food_ma_5_8, food_ma_5_9, food_ma_5_10, food_ma_5_11, food_ma_5_12, food_ma_5_13, food_ma_5_14, food_male_plan_10_food_5_r_1, food_male_plan_10_food_5_r_2, food_male_plan_10_food_5_r_3, food_ma_5, food_male_plan_10_food_5_r, food_ma_6_1, food_ma_6_2, food_ma_6_3, food_ma_6_4, food_ma_6_5, food_ma_6_6, food_ma_6_7, food_ma_6_8, food_ma_6_9, food_ma_6_10, food_ma_6_11, food_male_plan_10_food_6_r_1, food_male_plan_10_food_6_r_2, food_male_plan_10_food_6_r_3, food_ma_6, food_male_plan_10_food_6_r, food_ma_7_1, food_ma_7_2, food_ma_7_3, food_ma_7_4, food_ma_7_5, food_ma_7_6, food_ma_7_7, food_ma_7_8, food_ma_7_9, food_ma_7_10, food_ma_7_11, food_male_plan_10_food_7_r_1, food_male_plan_10_food_7_r_2, food_male_plan_10_food_7_r_3, food_male_plan_10_food_7_r, food_ma_7, food_ma_8_1, food_ma_8_2, food_ma_8_3, food_ma_8_4, food_ma_8_5, food_ma_8_6, food_ma_8_7, food_ma_8_8, food_ma_8_9, food_ma_8_10, food_ma_8_11, food_ma_8_12, food_ma_8_13, food_ma_8_14, food_male_plan_10_food_8_r_1, food_male_plan_10_food_8_r_2, food_ma_8, food_male_plan_10_food_8_r, food_ma_9_1, food_ma_9_2, food_ma_9_3, food_ma_9_4, food_ma_9_5, food_ma_9_6, food_ma_9_7, food_ma_9_8, food_male_plan_10_food_9_r_1, food_male_plan_10_food_9_r_2, food_male_plan_10_food_9_r_3, food_male_plan_10_food_9_r_4, food_male_plan_10_food_9_r, food_ma_9, food_ma_10_1, food_ma_10_2, food_ma_10_3, food_ma_10_4, food_ma_10_5, food_ma_10_6, food_ma_10_7, food_ma_10_8, food_ma_10_9, food_ma_10_10, food_ma_10_11, food_ma_10_12, food_ma_10_13, food_ma_10_14, food_ma_10_15, food_ma_10_16, food_ma_10_17, food_ma_10_18, food_ma_10_19, food_ma_10_20, food_ma_10_21, food_ma_10_22, food_male_plan_10_food_10_r_1, food_male_plan_10_food_10_r_2, food_male_plan_10_food_10_r_3, food_male_plan_10_food_10_r_4, food_male_plan_10_food_10_r_5, food_male_plan_10_food_10_r, food_ma_10, food_ma_11_1, food_ma_11_2, food_ma_11_3, food_ma_11_4, food_ma_11_5, food_ma_11_6, food_ma_11_7, food_ma_11_8, food_ma_11_9, food_ma_11_10, food_ma_11_11, food_ma_11_12, food_ma_11_13, food_ma_11_14, food_ma_11_15, food_ma_11_16, food_male_plan_10_food_11_r_1, food_male_plan_10_food_11_r_2, food_male_plan_10_food_11_r_3, food_male_plan_10_food_11_r_4, food_male_plan_10_food_11_r_5, food_male_plan_10_food_11_r_6, food_male_plan_10_food_11_r_7, food_male_plan_10_food_11_r_8, food_male_plan_10_food_11_r_9, food_male_plan_10_food_11_r_10, food_male_plan_10_food_11_r_11, food_male_plan_10_food_11_r, food_ma_11, food_ma_12_1, food_ma_12_2, food_ma_12_3, food_ma_12_4, food_ma_12_5, food_ma_12_6, food_ma_12_7, food_ma_12_8, food_ma_12_9, food_ma_12_10, food_ma_12_11, food_ma_12_12, food_ma_12_13, food_ma_12_14, food_ma_12_15, food_ma_12_16, food_ma_12_17, food_ma_12_18, food_ma_12_19, food_ma_12_20, food_ma_12_21, food_ma_12_22, food_male_plan_10_food_12_r_1, food_male_plan_10_food_12_r_2, food_male_plan_10_food_12_r_3, food_male_plan_10_food_12_r_4, food_male_plan_10_food_12_r_5, food_male_plan_10_food_12_r_6, food_male_plan_10_food_12_r_7, food_male_plan_10_food_12_r_8, food_male_plan_10_food_12_r_9, food_male_plan_10_food_12_r_10, food_male_plan_10_food_12_r_11, food_male_plan_10_food_12_r_12, food_male_plan_10_food_12_r_13, food_male_plan_10_food_12_r_14, food_male_plan_10_food_12_r, food_ma_12, food_ma_13_1, food_ma_13_2, food_ma_13_3, food_ma_13_4, food_ma_13_5, food_ma_13_6, food_ma_13_7, food_ma_13_8, food_ma_13_9, food_ma_13_10, food_ma_13_11, food_ma_13_12, food_ma_13_13, food_ma_13_14, food_male_plan_10_food_13_r_1, food_male_plan_10_food_13_r_2, food_male_plan_10_food_13_r_3, food_male_plan_10_food_13_r_4, food_male_plan_10_food_13_r_5, food_male_plan_10_food_13_r_6, food_male_plan_10_food_13_r_7, food_male_plan_10_food_13_r_8, food_male_plan_10_food_13_r_9, food_male_plan_10_food_13_r_10, food_male_plan_10_food_13_r, food_ma_13, food_ma_14_1, food_ma_14_2, food_ma_14_3, food_ma_14_4, food_ma_14_5, food_ma_14_6, food_ma_14_7, food_ma_14_8, food_ma_14_9, food_ma_14_10, food_ma_14_11, food_ma_14_12, food_ma_14_13, food_ma_14_14, food_ma_14_15, food_ma_14_16, food_ma_14_17, food_ma_14_18, food_ma_14_19, food_ma_14_20, food_ma_14_21, food_ma_14_22, food_male_plan_10_food_14_r_1, food_male_plan_10_food_14_r_2, food_male_plan_10_food_14_r_3, food_male_plan_10_food_14_r_4, food_male_plan_10_food_14_r_5, food_male_plan_10_food_14_r_6, food_male_plan_10_food_14_r_7, food_male_plan_10_food_14_r_8, food_male_plan_10_food_14_r_9, food_male_plan_10_food_14_r_10, food_male_plan_10_food_14_r, food_ma_14, food_ma_15_1, food_ma_15_2, food_ma_15_3, food_ma_15_4, food_ma_15_5, food_ma_15_6, food_ma_15_7, food_ma_15_8, food_ma_15_9, food_ma_15_10, food_ma_15_11, food_ma_15_12, food_ma_15_13, food_ma_15_14, food_ma_15_15, food_ma_15_16, food_ma_15_17, food_ma_15_18, food_ma_15_19, food_ma_15_20, food_male_plan_10_food_15_r_1, food_male_plan_10_food_15_r_2, food_male_plan_10_food_15_r_3, food_male_plan_10_food_15_r_4, food_male_plan_10_food_15_r_5, food_male_plan_10_food_15_r_6, food_male_plan_10_food_15_r_7, food_male_plan_10_food_15_r, food_ma_15, food_ma_16_1, food_ma_16_2, food_ma_16_3, food_ma_16_4, food_ma_16_5, food_ma_16_6, food_ma_16_7, food_ma_16_8, food_ma_16_9, food_male_plan_10_food_16_r_1, food_male_plan_10_food_16_r_2, food_male_plan_10_food_16_r_3, food_male_plan_10_food_16_r_4, food_male_plan_10_food_16_r, food_ma_16, food_ma_17_1, food_ma_17_2, food_ma_17_3, food_ma_17_4, food_ma_17_5, food_ma_17_6, food_ma_17_7, food_ma_17_8, food_ma_17_9, food_ma_17_10, food_ma_17_11, food_ma_17_12, food_male_plan_10_food_17_r_1, food_male_plan_10_food_17_r_2, food_male_plan_10_food_17_r_3, food_male_plan_10_food_17_r_4, food_male_plan_10_food_17_r_5, food_male_plan_10_food_17_r, food_ma_17, food_ma_18_1, food_ma_18_2, food_ma_18_3, food_ma_18_4, food_ma_18_5, food_ma_18_6, food_ma_18_7, food_ma_18_8, food_ma_18_9, food_ma_18_10, food_ma_18_11, food_male_plan_10_food_18_r_1, food_male_plan_10_food_18_r_2, food_male_plan_10_food_18_r_3, food_male_plan_10_food_18_r_4, food_male_plan_10_food_18_r_5, food_male_plan_10_food_18_r_6, food_male_plan_10_food_18_r, food_ma_18, food_ma_19_1, food_ma_19_2, food_ma_19_3, food_ma_19_4, food_ma_19_5, food_ma_19_6, food_ma_19_7, food_ma_19_8, food_ma_20_1, food_ma_20_2, food_ma_20_3, food_ma_20_4, food_ma_20_5, food_ma_20_6, food_ma_20_7, food_ma_20_8, food_ma_20_9, food_ma_20_10, food_ma_21_1, food_ma_21_2, food_ma_21_3, food_ma_21_4, food_ma_21_5, food_ma_21_6, food_ma_21_7, food_ma_22_1, food_ma_22_2, food_ma_22_3, food_ma_22_4, food_ma_22_5, food_ma_22_6, food_ma_22_7, food_ma_23_1, food_ma_23_2, food_ma_23_3, food_ma_23_4, food_ma_23_5, food_ma_23_6, food_ma_24_1, food_ma_24_2, food_ma_24_3, food_ma_24_4, food_ma_24_5, food_ma_24_6, food_ma_24_7, food_ma_25_1, food_ma_25_2, food_ma_25_3, food_ma_25_4, food_ma_25_5, food_ma_25_6, food_ma_25_7, food_ma_25_8, food_ma_26_1, food_ma_26_2, food_ma_26_3, food_ma_26_4, food_ma_26_5, food_ma_26_6, food_ma_26_7, food_ma_26_8, food_ma_26_9, food_ma_26_10, food_ma_27_1, food_ma_27_2, food_ma_27_3, food_ma_27_4, food_ma_27_5, food_ma_27_6, food_ma_27_7, food_ma_28_1, food_ma_28_2, food_ma_28_3, food_ma_28_4, food_ma_28_5, food_ma_28_6, food_ma_28_7, food_ma_29_1, food_ma_29_2, food_ma_29_3, food_ma_29_4, food_ma_29_5, food_ma_29_6, food_ma_29_7, food_ma_29_8, food_ma_29_9, food_ma_29_10, food_ma_30_1, food_ma_30_2, food_ma_30_3, food_ma_30_4, food_ma_30_5, food_ma_30_6, food_ma_30_7, food_ma_30_8, food_ma_30_9, food_ma_30_10, food_ma_31_1, food_ma_31_2, food_ma_31_3, food_ma_31_4, food_ma_31_5, food_ma_31_6, food_ma_31_7, food_ma_31_8, food_ma_31_9, food_ma_31_10, food_ma_32_1, food_ma_32_2, food_ma_32_3, food_ma_32_4, food_ma_32_5, food_ma_32_6, food_ma_32_7, food_ma_32_8, food_ma_32_9, food_ma_33_1, food_ma_33_2, food_ma_33_3, food_ma_33_4, food_ma_33_5, food_ma_33_6, food_ma_33_7, food_ma_33_8, food_ma_33_9, food_ma_34_1, food_ma_34_2, food_ma_34_3, food_ma_34_4, food_ma_34_5, food_ma_34_6, food_ma_34_7, food_ma_35_1, food_ma_35_2, food_ma_35_3, food_ma_35_4, food_ma_35_5, food_ma_35_6, food_ma_35_7, food_ma_35_8, food_ma_36_1, food_ma_36_2, food_ma_36_3, food_ma_36_4, food_ma_36_5, food_ma_36_6, food_ma_36_7, food_ma_36_8, food_ma_36_9, food_ma_36_10, food_ma_37_1, food_ma_37_2, food_ma_37_3, food_ma_37_4, food_ma_38_1, food_ma_38_2, food_ma_38_3, food_ma_38_4, food_ma_38_5, food_ma_38_6, food_ma_38_7, food_ma_38_8, food_ma_38_9, food_ma_38_10, food_ma_39_1, food_ma_39_2, food_ma_39_3, food_ma_39_4, food_ma_39_5, food_ma_39_6, food_ma_40_1, food_ma_40_2, food_ma_40_3, food_ma_40_4, food_ma_40_5, food_ma_40_6, food_ma_40_7, food_ma_41_1, food_ma_41_2, food_ma_41_3, food_ma_41_4, food_ma_41_5, food_ma_41_6, food_ma_41_7, food_ma_41_8, food_ma_41_9, food_ma_41_10, food_ma_42_1, food_ma_42_2, food_ma_42_3, food_ma_42_4, food_ma_42_5, food_ma_42_6, food_ma_42_7, food_ma_43_1, food_ma_43_2, food_ma_43_3, food_ma_43_4, food_ma_43_5, food_ma_43_6, food_ma_43_7, food_ma_44_1, food_ma_44_2, food_ma_44_3, food_ma_44_4, food_ma_44_5, food_ma_44_6, food_ma_44_7, food_ma_44_8, food_ma_44_9, food_male_plan_10_food_19_r_1, food_male_plan_10_food_19_r_2, food_male_plan_10_food_19_r_3, food_male_plan_10_food_19_r_4, food_male_plan_10_food_19_r_5, food_male_plan_10_food_20_r_1, food_male_plan_10_food_20_r_2, food_male_plan_10_food_20_r_3, food_male_plan_10_food_20_r_4, food_male_plan_10_food_20_r_5, food_male_plan_10_food_21_r_1, food_male_plan_10_food_21_r_2, food_male_plan_10_food_21_r_3, food_male_plan_10_food_21_r_4, food_male_plan_10_food_21_r_5, food_male_plan_10_food_22_r_1, food_male_plan_10_food_22_r_2, food_male_plan_10_food_23_r_1, food_male_plan_10_food_23_r_2, food_male_plan_10_food_23_r_3, food_male_plan_10_food_24_r_1, food_male_plan_10_food_24_r_2, food_male_plan_10_food_24_r_3, food_male_plan_10_food_24_r_4, food_male_plan_10_food_25_r_1, food_male_plan_10_food_25_r_2, food_male_plan_10_food_25_r_3, food_male_plan_10_food_25_r_4, food_male_plan_10_food_26_r_1, food_male_plan_10_food_26_r_2, food_male_plan_10_food_26_r_3, food_male_plan_10_food_26_r_4, food_male_plan_10_food_26_r_5, food_male_plan_10_food_27_r_1, food_male_plan_10_food_27_r_2, food_male_plan_10_food_28_r_1, food_male_plan_10_food_28_r_2, food_male_plan_10_food_29_r_1, food_male_plan_10_food_29_r_2, food_male_plan_10_food_29_r_3, food_male_plan_10_food_30_r_1, food_male_plan_10_food_30_r_2, food_male_plan_10_food_30_r_3, food_male_plan_10_food_31_r_1, food_male_plan_10_food_31_r_2, food_male_plan_10_food_31_r_3, food_male_plan_10_food_32_r_1, food_male_plan_10_food_32_r_2, food_male_plan_10_food_32_r_3, food_male_plan_10_food_33_r_1, food_male_plan_10_food_33_r_2, food_male_plan_10_food_34_r_1, food_male_plan_10_food_34_r_2, food_male_plan_10_food_35_r_1, food_male_plan_10_food_35_r_2, food_male_plan_10_food_36_r_1, food_male_plan_10_food_36_r_2, food_male_plan_10_food_37_r_1, food_male_plan_10_food_37_r_2, food_male_plan_10_food_38_r_1, food_male_plan_10_food_38_r_2, food_male_plan_10_food_38_r_3, food_male_plan_10_food_38_r_4, food_male_plan_10_food_39_r_1, food_male_plan_10_food_40_r_1, food_male_plan_10_food_40_r_2, food_male_plan_10_food_41_r_1, food_male_plan_10_food_41_r_2, food_male_plan_10_food_41_r_3, food_male_plan_10_food_41_r_4, food_male_plan_10_food_42_r_1, food_male_plan_10_food_42_r_2, food_male_plan_10_food_42_r_3, food_male_plan_10_food_43_r_1, food_male_plan_10_food_43_r_2, food_male_plan_10_food_43_r_3, food_male_plan_10_food_44_r_1, food_male_plan_10_food_44_r_2, food_male_plan_10_food_44_r_3, food_male_plan_10_food_20_r_6, food_male_plan_10_food_20_r_7, food_male_plan_10_food_20_r_8, food_male_plan_10_food_20_r_9, food_male_plan_10_food_20_r_10, food_male_plan_10_food_20_r_11, food_male_plan_10_food_20_r_12, food_male_plan_10_food_20_r_13, food_ma_26_11, food_ma_26_12, food_male_plan_10_food_26_r_6, food_ma_29_11, food_ma_29_12, food_ma_29_13, food_ma_29_14, food_ma_29_15, food_ma_19, food_ma_20, food_ma_21, food_ma_22, food_ma_23, food_ma_24, food_ma_25, food_ma_26, food_ma_27, food_ma_28, food_ma_29, food_male_plan_10_food_19_r, food_male_plan_10_food_20_r, food_male_plan_10_food_21_r, food_male_plan_10_food_22_r, food_male_plan_10_food_23_r, food_male_plan_10_food_24_r, food_male_plan_10_food_25_r, food_male_plan_10_food_26_r, food_male_plan_10_food_27_r, food_male_plan_10_food_28_r, food_male_plan_10_food_29_r, food_ma_30_11, food_ma_30_12, food_ma_31_11, food_ma_38_11, food_ma_38_12, food_ma_38_13, food_ma_38_14, food_ma_30, food_ma_31, food_ma_32, food_ma_33, food_ma_34, food_ma_35, food_ma_36, food_ma_37, food_ma_38, food_male_plan_10_food_30_r, food_male_plan_10_food_31_r, food_male_plan_10_food_32_r, food_male_plan_10_food_33_r, food_male_plan_10_food_34_r, food_male_plan_10_food_35_r, food_male_plan_10_food_36_r, food_male_plan_10_food_37_r, food_male_plan_10_food_38_r, food_ma_41_11, food_ma_41_12, food_ma_45_1, food_ma_45_2, food_ma_45_3, food_ma_45_4, food_ma_45_5, food_ma_45_6, food_ma_45_7, food_ma_45_8, food_ma_45_9, food_ma_45_10, food_male_plan_10_food_45_r_1, food_male_plan_10_food_45_r_2, food_male_plan_10_food_45_r_3, food_ma_46_1, food_ma_46_2, food_ma_46_3, food_ma_46_4, food_ma_46_5, food_ma_46_6, food_ma_46_7, food_ma_46_8, food_ma_46_9, food_ma_46_10, food_male_plan_10_food_46_r_1, food_male_plan_10_food_46_r_2, food_ma_47_1, food_ma_47_2, food_ma_47_3, food_ma_47_4, food_male_plan_10_food_47_r_1, food_male_plan_10_food_47_r_2, food_ma_48_1, food_ma_48_2, food_ma_48_3, food_ma_48_4, food_male_plan_10_food_48_r_1, food_ma_49_1, food_ma_49_2, food_ma_49_3, food_ma_49_4, food_ma_49_5, food_ma_49_6, food_ma_49_7, food_ma_49_8, food_male_plan_10_food_49_r_1, food_male_plan_10_food_49_r_2, food_ma_50_1, food_ma_50_2, food_ma_50_3, food_ma_50_4, food_ma_50_5, food_ma_50_6, food_ma_50_7, food_ma_50_8, food_ma_50_9, food_ma_50_10, food_male_plan_10_food_50_r_1, food_male_plan_10_food_50_r_2, food_ma_51_1, food_ma_51_2, food_ma_51_3, food_ma_51_4, food_ma_51_5, food_ma_51_6, food_ma_51_7, food_ma_51_8, food_male_plan_10_food_51_r_1, food_male_plan_10_food_51_r_2, food_ma_52_1, food_ma_52_2, food_ma_52_3, food_ma_52_4, food_ma_52_5, food_ma_52_6, food_ma_52_7, food_ma_52_8, food_ma_52_9, food_male_plan_10_food_52_r_1, food_male_plan_10_food_52_r_2, food_ma_53_1, food_ma_53_2, food_ma_53_3, food_ma_53_4, food_ma_53_5, food_ma_53_6, food_ma_53_7, food_ma_53_8, food_ma_53_9, food_ma_53_10, food_male_plan_10_food_53_r_1, food_male_plan_10_food_53_r_2, food_ma_54_1, food_ma_54_2, food_ma_54_3, food_ma_54_4, food_ma_54_5, food_ma_54_6, food_ma_54_7, food_ma_54_8, food_ma_54_9, food_male_plan_10_food_54_r_1, food_male_plan_10_food_54_r_2, food_male_plan_10_food_54_r_3, food_male_plan_10_food_53_r_3, food_ma_55_1, food_ma_55_2, food_ma_55_3, food_ma_55_4, food_ma_55_5, food_ma_55_6, food_ma_55_7, food_ma_55_8, food_ma_55_9, food_ma_55_10, food_ma_55_12, food_ma_55_11, food_male_plan_10_food_55_r_1, food_male_plan_10_food_55_r_2, food_ma_56_1, food_ma_56_2, food_ma_56_3, food_ma_56_4, food_ma_56_5, food_ma_56_6, food_ma_56_7, food_ma_56_8, food_ma_56_9, food_male_plan_10_food_56_r_1, food_male_plan_10_food_56_r_2, food_ma_57_1, food_ma_57_2, food_ma_57_3, food_ma_57_5, food_ma_57_4, food_ma_57_6, food_ma_57_7, food_ma_57_8, food_ma_57_9, food_ma_57_10, food_male_plan_10_food_57_r_1, food_male_plan_10_food_57_r_2, food_male_plan_10_food_57_r_3, food_ma_39, food_ma_40, food_ma_41, food_ma_42, food_ma_43, food_ma_44, food_ma_45, food_ma_46, food_ma_47, food_ma_48, food_ma_49, food_ma_50, food_ma_51, food_ma_52, food_ma_53, food_ma_54, food_ma_55, food_ma_56, food_male_plan_10_food_39_r, food_male_plan_10_food_40_r, food_male_plan_10_food_41_r, food_male_plan_10_food_42_r, food_male_plan_10_food_43_r, food_male_plan_10_food_44_r, food_male_plan_10_food_45_r, food_male_plan_10_food_46_r, food_male_plan_10_food_47_r, food_male_plan_10_food_48_r, food_male_plan_10_food_49_r, food_male_plan_10_food_50_r, food_male_plan_10_food_51_r, food_male_plan_10_food_52_r, food_male_plan_10_food_53_r, food_male_plan_10_food_54_r, food_male_plan_10_food_55_r, food_male_plan_10_food_56_r, food_ma_57_11, food_ma_58_1, food_ma_58_2, food_ma_58_3, food_ma_58_4, food_ma_58_5, food_ma_58_6, food_ma_58_7, food_ma_58_8, food_ma_58_9, food_ma_58_10, food_ma_58_11, food_ma_58_12, food_ma_58_13, food_ma_58_14, food_ma_58_15, food_ma_58_16, food_male_plan_10_food_58_r_1, food_male_plan_10_food_58_r_3, food_male_plan_10_food_58_r_2, food_ma_59_1, food_ma_59_2, food_ma_59_3, food_ma_59_4, food_ma_59_5, food_ma_59_6, food_male_plan_10_food_59_r_1, food_male_plan_10_food_59_r_2, food_male_plan_10_food_59_r_3, food_male_plan_10_food_59_r_4, food_ma_60_1, food_ma_60_2, food_ma_60_3, food_ma_60_4, food_ma_60_5, food_ma_60_6, food_ma_60_7, food_ma_60_8, food_male_plan_10_food_60_r_1, food_male_plan_10_food_60_r_2, food_male_plan_10_food_60_r_3, food_ma_61_1, food_ma_61_2, food_ma_61_3, food_ma_61_4, food_ma_61_5, food_ma_61_6, food_ma_61_7, food_male_plan_10_food_61_r_1, food_male_plan_10_food_61_r_2, food_male_plan_10_food_61_r_3, food_male_plan_10_food_61_r_4, food_ma_62_1, food_ma_62_2, food_ma_62_3, food_ma_62_4, food_ma_62_5, food_ma_62_6, food_ma_62_7, food_male_plan_10_food_62_r_1, food_male_plan_10_food_62_r_2, food_male_plan_10_food_62_r_3, food_male_plan_10_food_62_r_4, food_ma_63_1, food_ma_63_2, food_ma_63_3, food_ma_63_4, food_ma_63_5, food_ma_63_6, food_ma_63_7, food_ma_63_8, food_ma_63_9, food_ma_63_10, food_ma_63_11, food_male_plan_10_food_63_r_1, food_male_plan_10_food_63_r_2, food_ma_64_1, food_ma_64_2, food_ma_64_3, food_ma_64_4, food_ma_64_5, food_ma_64_6, food_ma_64_7, food_male_plan_10_food_64_r_1, food_male_plan_10_food_64_r_2, food_male_plan_10_food_64_r_3, food_ma_65_1, food_ma_65_2, food_ma_65_3, food_ma_65_4, food_ma_65_5, food_ma_65_6, food_ma_65_7, food_ma_65_8, food_ma_65_9, food_male_plan_10_food_65_r_1, food_male_plan_10_food_65_r_2, food_male_plan_10_food_65_r_3, food_male_plan_10_food_65_r_4, food_ma_66_1, food_ma_66_2, food_ma_66_3, food_ma_66_4, food_ma_66_5, food_ma_66_6, food_ma_66_7, food_ma_66_8, food_ma_66_9, food_ma_66_10, food_male_plan_10_food_66_r_1, food_male_plan_10_food_66_r_2, food_male_plan_10_food_66_r_3, food_ma_67_1, food_ma_67_2, food_ma_67_3, food_ma_67_4, food_ma_67_5, food_ma_67_6, food_ma_67_7, food_ma_67_8, food_ma_67_9, food_ma_67_10, food_ma_67_11, food_ma_67_12, food_ma_67_13, food_ma_67_14, food_male_plan_10_food_67_r_1, food_male_plan_10_food_67_r_2, food_male_plan_10_food_67_r_3, food_male_plan_10_food_67_r_4, food_ma_68_1, food_ma_68_2, food_ma_68_3, food_ma_68_4, food_ma_68_5, food_ma_68_6, food_ma_68_7, food_ma_68_8, food_ma_68_9, food_ma_68_10, food_ma_68_11, food_male_plan_10_food_68_r_1, food_male_plan_10_food_68_r_2, food_male_plan_10_food_68_r_3, food_male_plan_10_food_68_r_4, food_male_plan_10_food_68_r_5, food_male_plan_10_food_68_r_6, food_male_plan_10_food_68_r_7, food_ma_69_1, food_ma_69_2, food_ma_69_3, food_ma_69_4, food_ma_69_5, food_ma_69_6, food_ma_69_7, food_ma_69_8, food_ma_69_9, food_ma_69_10, food_male_plan_10_food_69_r_1, food_ma_70_1, food_ma_70_2, food_ma_70_3, food_ma_70_4, food_ma_70_5, food_ma_70_6, food_ma_70_7, food_ma_70_8, food_ma_70_9, food_ma_70_10, food_ma_70_11, food_male_plan_10_food_70_r_1, food_male_plan_10_food_70_r_2, food_male_plan_10_food_70_r_4, food_male_plan_10_food_70_r_3, food_ma_71_1, food_ma_71_2, food_ma_71_3, food_ma_71_4, food_ma_71_5, food_ma_71_6, food_ma_71_7, food_ma_71_8, food_male_plan_10_food_71_r_1, food_male_plan_10_food_71_r_2, food_male_plan_10_food_71_r_3, food_ma_72_1, food_ma_72_2, food_ma_72_3, food_ma_72_4, food_ma_72_5, food_ma_72_6, food_ma_72_7, food_ma_72_8, food_ma_72_9, food_male_plan_10_food_72_r_1, food_male_plan_10_food_72_r_2, food_male_plan_10_food_72_r_3, food_male_plan_10_food_72_r_4, food_ma_73_1, food_ma_73_2, food_ma_73_3, food_ma_73_4, food_ma_73_5, food_male_plan_10_food_73_r_1, food_male_plan_10_food_73_r_2, food_male_plan_10_food_73_r_3, food_ma_74_1, food_ma_74_2, food_ma_74_3, food_ma_74_4, food_ma_74_5, food_ma_74_6, food_ma_74_7, food_ma_74_8, food_ma_74_9, food_ma_74_10, food_male_plan_10_food_74_r_1, food_male_plan_10_food_74_r_2, food_male_plan_10_food_74_r_3, food_ma_75_1, food_ma_75_2, food_ma_75_3, food_ma_75_4, food_ma_75_5, food_ma_75_6, food_ma_75_7, food_ma_75_8, food_ma_75_9, food_ma_75_10, food_ma_75_11, food_ma_75_12, food_ma_75_13, food_ma_75_14, food_male_plan_10_food_75_r_1, food_male_plan_10_food_75_r_2, food_male_plan_10_food_75_r_3, food_male_plan_10_food_75_r_4, food_male_plan_10_food_75_r_5, food_male_plan_10_food_75_r_6, food_ma_76_1, food_ma_76_2, food_ma_76_3, food_ma_76_4, food_ma_76_5, food_ma_76_6, food_ma_76_7, food_ma_76_8, food_ma_76_9, food_ma_76_10, food_ma_76_11, food_ma_76_12, food_ma_76_13, food_ma_76_14, food_ma_76_15, food_ma_76_16, food_ma_76_17, food_male_plan_10_food_76_r_1, food_male_plan_10_food_76_r_2, food_male_plan_10_food_76_r_3, food_male_plan_10_food_76_r_4, food_ma_77_1, food_ma_77_2, food_ma_77_3, food_ma_77_4, food_ma_77_5, food_ma_77_6, food_ma_77_7, food_ma_77_8, food_ma_77_9, food_ma_77_10, food_ma_77_11, food_ma_77_12, food_ma_77_13, food_ma_77_14, food_ma_77_15, food_ma_77_16, food_ma_77_17, food_ma_77_18, food_ma_77_19, food_ma_77_20, food_ma_77_21, food_ma_77_22, food_ma_77_23, food_ma_77_24, food_ma_77_25, food_male_plan_10_food_77_r_1, food_male_plan_10_food_77_r_2, food_male_plan_10_food_77_r_3, food_male_plan_10_food_77_r_4, food_male_plan_10_food_77_r_5, food_male_plan_10_food_77_r_6, food_ma_78_1, food_ma_78_2, food_ma_78_3, food_ma_78_4, food_ma_78_5, food_ma_78_6, food_ma_78_7, food_ma_78_8, food_ma_78_9, food_ma_78_10, food_male_plan_10_food_78_r_1, food_male_plan_10_food_78_r_2, food_male_plan_10_food_78_r_3, food_male_plan_10_food_78_r_5, food_male_plan_10_food_78_r_4, food_ma_57, food_ma_58, food_ma_59, food_ma_60, food_ma_61, food_ma_62, food_ma_63, food_ma_64, food_ma_65, food_ma_66, food_ma_67, food_ma_68, food_ma_69, food_ma_70, food_ma_71, food_ma_72, food_ma_73, food_ma_74, food_ma_75, food_ma_76, food_ma_77, food_male_plan_10_food_57_r, food_male_plan_10_food_58_r, food_male_plan_10_food_59_r, food_male_plan_10_food_60_r, food_male_plan_10_food_61_r, food_male_plan_10_food_62_r, food_male_plan_10_food_63_r, food_male_plan_10_food_64_r, food_male_plan_10_food_65_r, food_male_plan_10_food_66_r, food_male_plan_10_food_67_r, food_male_plan_10_food_68_r, food_male_plan_10_food_69_r, food_male_plan_10_food_70_r, food_male_plan_10_food_71_r, food_male_plan_10_food_72_r, food_male_plan_10_food_73_r, food_male_plan_10_food_74_r, food_male_plan_10_food_75_r, food_male_plan_10_food_76_r, food_male_plan_10_food_77_r, food_ma_78_11, food_ma_78_12, food_ma_78_13, food_ma_78_14, food_male_plan_10_food_78_r_6, food_male_plan_10_food_78_r_7, food_male_plan_10_food_78_r_8, food_male_plan_10_food_78_r_9, food_ma_79_1, food_ma_79_2, food_ma_79_3, food_ma_79_4, food_ma_79_5, food_ma_79_6, food_ma_79_7, food_ma_79_8, food_ma_79_9, food_ma_79_10, food_ma_79_11, food_ma_79_12, food_ma_79_13, food_ma_79_14, food_ma_79_15, food_male_plan_10_food_79_r_1, food_male_plan_10_food_79_r_2, food_male_plan_10_food_79_r_3, food_male_plan_10_food_79_r_4, food_male_plan_10_food_79_r_5, food_ma_80_1, food_ma_80_2, food_ma_80_3, food_ma_80_5, food_ma_80_4, food_ma_80_6, food_ma_80_7, food_ma_80_8, food_ma_80_9, food_ma_80_10, food_ma_80_11, food_ma_80_12, food_ma_80_13, food_male_plan_10_food_80_r_1, food_male_plan_10_food_80_r_2, food_male_plan_10_food_80_r_3, food_male_plan_10_food_80_r_4, food_male_plan_10_food_80_r_5, food_ma_81_1, food_ma_81_2, food_ma_81_3, food_ma_81_4, food_ma_81_5, food_ma_81_6, food_ma_81_7, food_ma_81_8, food_ma_81_9, food_ma_81_10, food_ma_81_11, food_ma_81_12, food_ma_81_13, food_male_plan_10_food_81_r_1, food_male_plan_10_food_81_r_2, food_male_plan_10_food_81_r_3, food_male_plan_10_food_81_r_4, food_male_plan_10_food_81_r_5, food_male_plan_10_food_81_r_6, food_ma_82_1, food_ma_82_2, food_ma_82_3, food_ma_82_4, food_ma_82_5, food_ma_82_7, food_ma_82_6, food_ma_82_8, food_ma_82_9, food_ma_82_10, food_ma_82_11, food_male_plan_10_food_82_r_1, food_male_plan_10_food_82_r_2, food_male_plan_10_food_82_r_3, food_male_plan_10_food_82_r_4, food_ma_83_1, food_ma_83_2, food_ma_83_3, food_ma_83_4, food_ma_83_5, food_ma_83_6, food_ma_83_7, food_ma_83_8, food_ma_83_9, food_ma_83_10, food_ma_83_11, food_ma_83_12, food_ma_83_13, food_male_plan_10_food_83_r_1, food_male_plan_10_food_83_r_2, food_male_plan_10_food_83_r_3, food_male_plan_10_food_83_r_4, food_male_plan_10_food_83_r_5, food_male_plan_10_food_83_r_6, food_male_plan_10_food_83_r_7, food_male_plan_10_food_83_r_8, food_ma_84_1, food_ma_84_2, food_ma_84_3, food_ma_84_4, food_ma_84_5, food_ma_84_6, food_male_plan_10_food_84_r_1, food_male_plan_10_food_84_r_2, food_male_plan_10_food_84_r_3, food_male_plan_10_food_84_r_4, food_ma_78, food_ma_79, food_ma_80, food_ma_81, food_ma_82, food_ma_83, food_ma_84, food_male_plan_10_food_79_r, food_male_plan_10_food_80_r, food_male_plan_10_food_81_r, food_male_plan_10_food_82_r, food_male_plan_10_food_83_r, food_male_plan_10_food_84_r, food_male_plan_10_food_78_r, download_video_1, download_video_2, download_video_3, food_ma_101_1, food_ma_101_2, food_ma_101_3, food_ma_101_4, food_ma_101_5, food_ma_101_6, food_ma_101_7, food_ma_101_8, food_ma_101_9, food_ma_101_10, food_ma_101_11, food_ma_101_12, food_ma_101_13, food_ma_101_14, food_ma_101_15, food_male_plan_10_food_101_r_1, food_male_plan_10_food_101_r_2, food_male_plan_10_food_101_r_3, food_male_plan_10_food_101_r_4, food_male_plan_10_food_101_r_5, food_male_plan_10_food_101_r_6, food_ma_102_1, food_ma_102_2, food_ma_102_3, food_ma_102_4, food_ma_102_5, food_ma_102_6, food_ma_102_7, food_ma_102_8, food_ma_102_9, food_ma_102_10, food_male_plan_10_food_102_r_1, food_male_plan_10_food_102_r_2, food_male_plan_10_food_102_r_3, food_male_plan_10_food_102_r_4, food_male_plan_10_food_102_r_5, food_male_plan_10_food_102_r_6, food_ma_101, food_ma_102, food_male_plan_10_food_101_r, food_male_plan_10_food_102_r, food_ma_103_1, food_ma_103_2, food_ma_103_3, food_ma_103_4, food_ma_103_5, food_ma_103_6, food_ma_103_7, food_male_plan_10_food_103_r_1, food_male_plan_10_food_103_r_2, food_male_plan_10_food_103_r_3, food_male_plan_10_food_103_r_4, food_male_plan_10_food_103_r_5, food_male_plan_10_food_103_r_6, food_ma_104_1, food_ma_104_2, food_ma_104_3, food_ma_104_4, food_ma_104_5, food_ma_104_6, food_ma_104_7, food_ma_104_8, food_ma_104_9, food_male_plan_10_food_104_r_1, food_male_plan_10_food_104_r_2, food_male_plan_10_food_104_r_3, food_male_plan_10_food_104_r_4, food_male_plan_10_food_107_r, food_male_plan_10_food_108_r, food_ma_107, food_ma_108, food_ma_113_1, food_ma_113_2, food_ma_113_3, food_ma_113_4, food_ma_113_5, food_ma_113_6, food_ma_113_7, food_ma_113_8, food_male_plan_10_food_113_r_1, food_male_plan_10_food_113_r_2, food_male_plan_10_food_113_r_3, food_male_plan_10_food_113_r_4, food_ma_114_1, food_ma_114_2, food_ma_114_3, food_ma_114_4, food_ma_114_5, food_ma_114_6, food_ma_114_7, food_ma_114_8, food_male_plan_10_food_114_r_1, food_male_plan_10_food_114_r_2, food_male_plan_10_food_114_r_3, food_ma_113, food_ma_114, food_male_plan_10_food_113_r, food_male_plan_10_food_114_r, food_ma_119_1, food_ma_119_2, food_ma_119_3, food_ma_119_4, food_male_plan_10_food_119_r_1, food_male_plan_10_food_119_r_2, food_male_plan_10_food_119_r_3, food_male_plan_10_food_119_r_4, food_ma_120_1, food_ma_120_2, food_ma_120_3, food_ma_120_4, food_ma_120_5, food_ma_120_6, food_ma_120_7, food_ma_120_8, food_ma_120_9, food_ma_120_10, food_ma_120_11, food_male_plan_10_food_120_r_1, food_male_plan_10_food_119_r, food_male_plan_10_food_120_r, food_ma_119, food_ma_120;


    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    public static int fff;

    public static MediaPlayer click;

    public static Vibrator vb;

    int farsi_zaban;

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

                farsi_zaban = 1;

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
        setContentView(R.layout.food_meal_plan_10_food);

        fasele = System.getProperty("line.separator") + "" + System.getProperty("line.separator");

        context = this;

        download_video_1 = (String) getText(R.string.download_file);
        download_video_2 = (String) getText(R.string.download_file_2);
        download_video_3 = (String) getText(R.string.download_file_3);

        net_off = (String) getText(R.string.food_male_plan_10_food_net_off);
        food_ma_1_1 = (String) getText(R.string.food_male_plan_10_food_1_i_1);
        food_ma_1_2 = (String) getText(R.string.food_male_plan_10_food_1_i_2);
        food_ma_1_3 = (String) getText(R.string.food_male_plan_10_food_1_i_3);
        food_ma_1_4 = (String) getText(R.string.food_male_plan_10_food_1_i_4);
        food_ma_1_5 = (String) getText(R.string.food_male_plan_10_food_1_i_5);
        food_ma_1_6 = (String) getText(R.string.food_male_plan_10_food_1_i_6);
        food_ma_1_7 = (String) getText(R.string.food_male_plan_10_food_1_i_7);
        food_ma_1_8 = (String) getText(R.string.food_male_plan_10_food_1_i_8);
        food_ma_1_9 = (String) getText(R.string.food_male_plan_10_food_1_i_9);
        food_ma_1_10 = (String) getText(R.string.food_male_plan_10_food_1_i_10);
        food_ma_1_11 = (String) getText(R.string.food_male_plan_10_food_1_i_11);
        food_ma_1_12 = (String) getText(R.string.food_male_plan_10_food_1_i_12);
        food_male_plan_10_food_1_r_1 = (String) getText(R.string.food_male_plan_10_food_1_r_1);
        food_male_plan_10_food_1_r_2 = (String) getText(R.string.food_male_plan_10_food_1_r_2);
        food_male_plan_10_food_1_r_3 = (String) getText(R.string.food_male_plan_10_food_1_r_3);
        food_male_plan_10_food_1_r_4 = (String) getText(R.string.food_male_plan_10_food_1_r_4);

        food_ma_2_1 = (String) getText(R.string.food_male_plan_10_food_2_i_1);
        food_ma_2_2 = (String) getText(R.string.food_male_plan_10_food_2_i_2);
        food_ma_2_3 = (String) getText(R.string.food_male_plan_10_food_2_i_3);
        food_ma_2_4 = (String) getText(R.string.food_male_plan_10_food_2_i_4);
        food_ma_2_5 = (String) getText(R.string.food_male_plan_10_food_2_i_5);
        food_male_plan_10_food_2_r_1 = (String) getText(R.string.food_male_plan_10_food_2_r_1);
        food_male_plan_10_food_2_r_2 = (String) getText(R.string.food_male_plan_10_food_2_r_2);

        food_ma_3_1 = (String) getText(R.string.food_male_plan_10_food_3_i_1);
        food_ma_3_2 = (String) getText(R.string.food_male_plan_10_food_3_i_2);
        food_ma_3_3 = (String) getText(R.string.food_male_plan_10_food_3_i_3);
        food_ma_3_4 = (String) getText(R.string.food_male_plan_10_food_3_i_4);
        food_ma_3_5 = (String) getText(R.string.food_male_plan_10_food_3_i_5);
        food_ma_3_6 = (String) getText(R.string.food_male_plan_10_food_3_i_6);
        food_ma_3_7 = (String) getText(R.string.food_male_plan_10_food_3_i_7);
        food_ma_3_8 = (String) getText(R.string.food_male_plan_10_food_3_i_8);
        food_ma_3_9 = (String) getText(R.string.food_male_plan_10_food_3_i_9);
        food_male_plan_10_food_3_r_1 = (String) getText(R.string.food_male_plan_10_food_3_r_1);
        food_male_plan_10_food_3_r_2 = (String) getText(R.string.food_male_plan_10_food_3_r_2);
        food_male_plan_10_food_3_r_3 = (String) getText(R.string.food_male_plan_10_food_3_r_3);
        food_male_plan_10_food_3_r_4 = (String) getText(R.string.food_male_plan_10_food_3_r_4);

        food_ma_4_1 = (String) getText(R.string.food_male_plan_10_food_4_i_1);
        food_ma_4_2 = (String) getText(R.string.food_male_plan_10_food_4_i_2);
        food_ma_4_3 = (String) getText(R.string.food_male_plan_10_food_4_i_3);
        food_ma_4_4 = (String) getText(R.string.food_male_plan_10_food_4_i_4);
        food_ma_4_5 = (String) getText(R.string.food_male_plan_10_food_4_i_5);
        food_ma_4_6 = (String) getText(R.string.food_male_plan_10_food_4_i_6);
        food_ma_4_7 = (String) getText(R.string.food_male_plan_10_food_4_i_7);
        food_ma_4_8 = (String) getText(R.string.food_male_plan_10_food_4_i_8);
        food_ma_4_9 = (String) getText(R.string.food_male_plan_10_food_4_i_9);
        food_ma_4_10 = (String) getText(R.string.food_male_plan_10_food_4_i_10);
        food_ma_4_11 = (String) getText(R.string.food_male_plan_10_food_4_i_11);
        food_male_plan_10_food_4_r_1 = (String) getText(R.string.food_male_plan_10_food_4_r_1);
        food_male_plan_10_food_4_r_2 = (String) getText(R.string.food_male_plan_10_food_4_r_2);

        food_ma_5_1 = (String) getText(R.string.food_male_plan_10_food_5_i_1);
        food_ma_5_2 = (String) getText(R.string.food_male_plan_10_food_5_i_2);
        food_ma_5_3 = (String) getText(R.string.food_male_plan_10_food_5_i_3);
        food_ma_5_4 = (String) getText(R.string.food_male_plan_10_food_5_i_4);
        food_ma_5_5 = (String) getText(R.string.food_male_plan_10_food_5_i_5);
        food_ma_5_6 = (String) getText(R.string.food_male_plan_10_food_5_i_6);
        food_ma_5_7 = (String) getText(R.string.food_male_plan_10_food_5_i_7);
        food_ma_5_8 = (String) getText(R.string.food_male_plan_10_food_5_i_8);
        food_ma_5_9 = (String) getText(R.string.food_male_plan_10_food_5_i_9);
        food_ma_5_10 = (String) getText(R.string.food_male_plan_10_food_5_i_10);
        food_ma_5_11 = (String) getText(R.string.food_male_plan_10_food_5_i_11);
        food_ma_5_12 = (String) getText(R.string.food_male_plan_10_food_5_i_12);
        food_ma_5_13 = (String) getText(R.string.food_male_plan_10_food_5_i_13);
        food_ma_5_14 = (String) getText(R.string.food_male_plan_10_food_5_i_14);
        food_male_plan_10_food_5_r_1 = (String) getText(R.string.food_male_plan_10_food_5_r_1);
        food_male_plan_10_food_5_r_2 = (String) getText(R.string.food_male_plan_10_food_5_r_2);
        food_male_plan_10_food_5_r_3 = (String) getText(R.string.food_male_plan_10_food_5_r_3);

        food_ma_6_1 = (String) getText(R.string.food_male_plan_10_food_6_i_1);
        food_ma_6_2 = (String) getText(R.string.food_male_plan_10_food_6_i_2);
        food_ma_6_3 = (String) getText(R.string.food_male_plan_10_food_6_i_3);
        food_ma_6_4 = (String) getText(R.string.food_male_plan_10_food_6_i_4);
        food_ma_6_5 = (String) getText(R.string.food_male_plan_10_food_6_i_5);
        food_ma_6_6 = (String) getText(R.string.food_male_plan_10_food_6_i_6);
        food_ma_6_7 = (String) getText(R.string.food_male_plan_10_food_6_i_7);
        food_ma_6_8 = (String) getText(R.string.food_male_plan_10_food_6_i_8);
        food_ma_6_9 = (String) getText(R.string.food_male_plan_10_food_6_i_9);
        food_ma_6_10 = (String) getText(R.string.food_male_plan_10_food_6_i_10);
        food_ma_6_11 = (String) getText(R.string.food_male_plan_10_food_6_i_11);
        food_male_plan_10_food_6_r_1 = (String) getText(R.string.food_male_plan_10_food_6_r_1);
        food_male_plan_10_food_6_r_2 = (String) getText(R.string.food_male_plan_10_food_6_r_2);
        food_male_plan_10_food_6_r_3 = (String) getText(R.string.food_male_plan_10_food_6_r_3);

        food_ma_7_1 = (String) getText(R.string.food_male_plan_10_food_7_i_1);
        food_ma_7_2 = (String) getText(R.string.food_male_plan_10_food_7_i_2);
        food_ma_7_3 = (String) getText(R.string.food_male_plan_10_food_7_i_3);
        food_ma_7_4 = (String) getText(R.string.food_male_plan_10_food_7_i_4);
        food_ma_7_5 = (String) getText(R.string.food_male_plan_10_food_7_i_5);
        food_ma_7_6 = (String) getText(R.string.food_male_plan_10_food_7_i_6);
        food_ma_7_7 = (String) getText(R.string.food_male_plan_10_food_7_i_7);
        food_ma_7_8 = (String) getText(R.string.food_male_plan_10_food_7_i_8);
        food_ma_7_9 = (String) getText(R.string.food_male_plan_10_food_7_i_9);
        food_ma_7_10 = (String) getText(R.string.food_male_plan_10_food_7_i_10);
        food_ma_7_11 = (String) getText(R.string.food_male_plan_10_food_7_i_11);
        food_male_plan_10_food_7_r_1 = (String) getText(R.string.food_male_plan_10_food_7_r_1);
        food_male_plan_10_food_7_r_2 = (String) getText(R.string.food_male_plan_10_food_7_r_2);
        food_male_plan_10_food_7_r_3 = (String) getText(R.string.food_male_plan_10_food_7_r_3);

        food_ma_8_1 = (String) getText(R.string.food_male_plan_10_food_8_i_1);
        food_ma_8_2 = (String) getText(R.string.food_male_plan_10_food_8_i_2);
        food_ma_8_3 = (String) getText(R.string.food_male_plan_10_food_8_i_3);
        food_ma_8_4 = (String) getText(R.string.food_male_plan_10_food_8_i_4);
        food_ma_8_5 = (String) getText(R.string.food_male_plan_10_food_8_i_5);
        food_ma_8_6 = (String) getText(R.string.food_male_plan_10_food_8_i_6);
        food_ma_8_7 = (String) getText(R.string.food_male_plan_10_food_8_i_7);
        food_ma_8_8 = (String) getText(R.string.food_male_plan_10_food_8_i_8);
        food_ma_8_9 = (String) getText(R.string.food_male_plan_10_food_8_i_9);
        food_ma_8_10 = (String) getText(R.string.food_male_plan_10_food_8_i_10);
        food_ma_8_11 = (String) getText(R.string.food_male_plan_10_food_8_i_11);
        food_ma_8_12 = (String) getText(R.string.food_male_plan_10_food_8_i_12);
        food_ma_8_13 = (String) getText(R.string.food_male_plan_10_food_8_i_13);
        food_ma_8_14 = (String) getText(R.string.food_male_plan_10_food_8_i_14);
        food_male_plan_10_food_8_r_1 = (String) getText(R.string.food_male_plan_10_food_8_r_1);
        food_male_plan_10_food_8_r_2 = (String) getText(R.string.food_male_plan_10_food_8_r_2);

        food_ma_9_1 = (String) getText(R.string.food_male_plan_10_food_9_i_1);
        food_ma_9_2 = (String) getText(R.string.food_male_plan_10_food_9_i_2);
        food_ma_9_3 = (String) getText(R.string.food_male_plan_10_food_9_i_3);
        food_ma_9_4 = (String) getText(R.string.food_male_plan_10_food_9_i_4);
        food_ma_9_5 = (String) getText(R.string.food_male_plan_10_food_9_i_5);
        food_ma_9_6 = (String) getText(R.string.food_male_plan_10_food_9_i_6);
        food_ma_9_7 = (String) getText(R.string.food_male_plan_10_food_9_i_7);
        food_ma_9_8 = (String) getText(R.string.food_male_plan_10_food_9_i_8);
        food_male_plan_10_food_9_r_1 = (String) getText(R.string.food_male_plan_10_food_9_r_1);
        food_male_plan_10_food_9_r_2 = (String) getText(R.string.food_male_plan_10_food_9_r_2);
        food_male_plan_10_food_9_r_3 = (String) getText(R.string.food_male_plan_10_food_9_r_3);
        food_male_plan_10_food_9_r_4 = (String) getText(R.string.food_male_plan_10_food_9_r_4);

        food_ma_10_1 = (String) getText(R.string.food_male_plan_10_food_10_i_1);
        food_ma_10_2 = (String) getText(R.string.food_male_plan_10_food_10_i_2);
        food_ma_10_3 = (String) getText(R.string.food_male_plan_10_food_10_i_3);
        food_ma_10_4 = (String) getText(R.string.food_male_plan_10_food_10_i_4);
        food_ma_10_5 = (String) getText(R.string.food_male_plan_10_food_10_i_5);
        food_ma_10_6 = (String) getText(R.string.food_male_plan_10_food_10_i_6);
        food_ma_10_7 = (String) getText(R.string.food_male_plan_10_food_10_i_7);
        food_ma_10_8 = (String) getText(R.string.food_male_plan_10_food_10_i_8);
        food_ma_10_9 = (String) getText(R.string.food_male_plan_10_food_10_i_9);
        food_ma_10_10 = (String) getText(R.string.food_male_plan_10_food_10_i_10);
        food_ma_10_11 = (String) getText(R.string.food_male_plan_10_food_10_i_11);
        food_ma_10_12 = (String) getText(R.string.food_male_plan_10_food_10_i_12);
        food_ma_10_13 = (String) getText(R.string.food_male_plan_10_food_10_i_13);
        food_ma_10_14 = (String) getText(R.string.food_male_plan_10_food_10_i_14);
        food_ma_10_15 = (String) getText(R.string.food_male_plan_10_food_10_i_15);
        food_ma_10_16 = (String) getText(R.string.food_male_plan_10_food_10_i_16);
        food_ma_10_17 = (String) getText(R.string.food_male_plan_10_food_10_i_17);
        food_ma_10_18 = (String) getText(R.string.food_male_plan_10_food_10_i_18);
        food_ma_10_19 = (String) getText(R.string.food_male_plan_10_food_10_i_19);
        food_ma_10_20 = (String) getText(R.string.food_male_plan_10_food_10_i_20);
        food_ma_10_21 = (String) getText(R.string.food_male_plan_10_food_10_i_21);
        food_ma_10_22 = (String) getText(R.string.food_male_plan_10_food_10_i_22);
        food_male_plan_10_food_10_r_1 = (String) getText(R.string.food_male_plan_10_food_10_r_1);
        food_male_plan_10_food_10_r_2 = (String) getText(R.string.food_male_plan_10_food_10_r_2);
        food_male_plan_10_food_10_r_3 = (String) getText(R.string.food_male_plan_10_food_10_r_3);
        food_male_plan_10_food_10_r_4 = (String) getText(R.string.food_male_plan_10_food_10_r_4);
        food_male_plan_10_food_10_r_5 = (String) getText(R.string.food_male_plan_10_food_10_r_5);

        food_ma_11_1 = (String) getText(R.string.food_male_plan_10_food_11_i_1);
        food_ma_11_2 = (String) getText(R.string.food_male_plan_10_food_11_i_2);
        food_ma_11_3 = (String) getText(R.string.food_male_plan_10_food_11_i_3);
        food_ma_11_4 = (String) getText(R.string.food_male_plan_10_food_11_i_4);
        food_ma_11_5 = (String) getText(R.string.food_male_plan_10_food_11_i_5);
        food_ma_11_6 = (String) getText(R.string.food_male_plan_10_food_11_i_6);
        food_ma_11_7 = (String) getText(R.string.food_male_plan_10_food_11_i_7);
        food_ma_11_8 = (String) getText(R.string.food_male_plan_10_food_11_i_8);
        food_ma_11_9 = (String) getText(R.string.food_male_plan_10_food_11_i_9);
        food_ma_11_10 = (String) getText(R.string.food_male_plan_10_food_11_i_10);
        food_ma_11_11 = (String) getText(R.string.food_male_plan_10_food_11_i_11);
        food_ma_11_12 = (String) getText(R.string.food_male_plan_10_food_11_i_12);
        food_ma_11_13 = (String) getText(R.string.food_male_plan_10_food_11_i_13);
        food_ma_11_14 = (String) getText(R.string.food_male_plan_10_food_11_i_14);
        food_ma_11_15 = (String) getText(R.string.food_male_plan_10_food_11_i_15);
        food_ma_11_16 = (String) getText(R.string.food_male_plan_10_food_11_i_16);
        food_male_plan_10_food_11_r_1 = (String) getText(R.string.food_male_plan_10_food_11_r_1);
        food_male_plan_10_food_11_r_2 = (String) getText(R.string.food_male_plan_10_food_11_r_2);
        food_male_plan_10_food_11_r_3 = (String) getText(R.string.food_male_plan_10_food_11_r_3);
        food_male_plan_10_food_11_r_4 = (String) getText(R.string.food_male_plan_10_food_11_r_4);
        food_male_plan_10_food_11_r_5 = (String) getText(R.string.food_male_plan_10_food_11_r_5);
        food_male_plan_10_food_11_r_6 = (String) getText(R.string.food_male_plan_10_food_11_r_6);
        food_male_plan_10_food_11_r_7 = (String) getText(R.string.food_male_plan_10_food_11_r_7);
        food_male_plan_10_food_11_r_8 = (String) getText(R.string.food_male_plan_10_food_11_r_8);
        food_male_plan_10_food_11_r_9 = (String) getText(R.string.food_male_plan_10_food_11_r_9);
        food_male_plan_10_food_11_r_10 = (String) getText(R.string.food_male_plan_10_food_11_r_10);
        food_male_plan_10_food_11_r_11 = (String) getText(R.string.food_male_plan_10_food_11_r_11);

        food_ma_12_1 = (String) getText(R.string.food_male_plan_10_food_12_i_1);
        food_ma_12_2 = (String) getText(R.string.food_male_plan_10_food_12_i_2);
        food_ma_12_3 = (String) getText(R.string.food_male_plan_10_food_12_i_3);
        food_ma_12_4 = (String) getText(R.string.food_male_plan_10_food_12_i_4);
        food_ma_12_5 = (String) getText(R.string.food_male_plan_10_food_12_i_5);
        food_ma_12_6 = (String) getText(R.string.food_male_plan_10_food_12_i_6);
        food_ma_12_7 = (String) getText(R.string.food_male_plan_10_food_12_i_7);
        food_ma_12_8 = (String) getText(R.string.food_male_plan_10_food_12_i_8);
        food_ma_12_9 = (String) getText(R.string.food_male_plan_10_food_12_i_9);
        food_ma_12_10 = (String) getText(R.string.food_male_plan_10_food_12_i_10);
        food_ma_12_11 = (String) getText(R.string.food_male_plan_10_food_12_i_11);
        food_ma_12_12 = (String) getText(R.string.food_male_plan_10_food_12_i_12);
        food_ma_12_13 = (String) getText(R.string.food_male_plan_10_food_12_i_13);
        food_ma_12_14 = (String) getText(R.string.food_male_plan_10_food_12_i_14);
        food_ma_12_15 = (String) getText(R.string.food_male_plan_10_food_12_i_15);
        food_ma_12_16 = (String) getText(R.string.food_male_plan_10_food_12_i_16);
        food_ma_12_17 = (String) getText(R.string.food_male_plan_10_food_12_i_17);
        food_ma_12_18 = (String) getText(R.string.food_male_plan_10_food_12_i_18);
        food_ma_12_19 = (String) getText(R.string.food_male_plan_10_food_12_i_19);
        food_ma_12_20 = (String) getText(R.string.food_male_plan_10_food_12_i_20);
        food_ma_12_21 = (String) getText(R.string.food_male_plan_10_food_12_i_21);
        food_ma_12_22 = (String) getText(R.string.food_male_plan_10_food_12_i_22);
        food_male_plan_10_food_12_r_1 = (String) getText(R.string.food_male_plan_10_food_12_r_1);
        food_male_plan_10_food_12_r_2 = (String) getText(R.string.food_male_plan_10_food_12_r_2);
        food_male_plan_10_food_12_r_3 = (String) getText(R.string.food_male_plan_10_food_12_r_3);
        food_male_plan_10_food_12_r_4 = (String) getText(R.string.food_male_plan_10_food_12_r_4);
        food_male_plan_10_food_12_r_5 = (String) getText(R.string.food_male_plan_10_food_12_r_5);
        food_male_plan_10_food_12_r_6 = (String) getText(R.string.food_male_plan_10_food_12_r_6);
        food_male_plan_10_food_12_r_7 = (String) getText(R.string.food_male_plan_10_food_12_r_7);
        food_male_plan_10_food_12_r_8 = (String) getText(R.string.food_male_plan_10_food_12_r_8);
        food_male_plan_10_food_12_r_9 = (String) getText(R.string.food_male_plan_10_food_12_r_9);
        food_male_plan_10_food_12_r_10 = (String) getText(R.string.food_male_plan_10_food_12_r_10);
        food_male_plan_10_food_12_r_11 = (String) getText(R.string.food_male_plan_10_food_12_r_11);
        food_male_plan_10_food_12_r_12 = (String) getText(R.string.food_male_plan_10_food_12_r_12);
        food_male_plan_10_food_12_r_13 = (String) getText(R.string.food_male_plan_10_food_12_r_13);
        food_male_plan_10_food_12_r_14 = (String) getText(R.string.food_male_plan_10_food_12_r_14);

        food_ma_13_1 = (String) getText(R.string.food_male_plan_10_food_13_i_1);
        food_ma_13_2 = (String) getText(R.string.food_male_plan_10_food_13_i_2);
        food_ma_13_3 = (String) getText(R.string.food_male_plan_10_food_13_i_3);
        food_ma_13_4 = (String) getText(R.string.food_male_plan_10_food_13_i_4);
        food_ma_13_5 = (String) getText(R.string.food_male_plan_10_food_13_i_5);
        food_ma_13_6 = (String) getText(R.string.food_male_plan_10_food_13_i_6);
        food_ma_13_7 = (String) getText(R.string.food_male_plan_10_food_13_i_7);
        food_ma_13_8 = (String) getText(R.string.food_male_plan_10_food_13_i_8);
        food_ma_13_9 = (String) getText(R.string.food_male_plan_10_food_13_i_9);
        food_ma_13_10 = (String) getText(R.string.food_male_plan_10_food_13_i_10);
        food_ma_13_11 = (String) getText(R.string.food_male_plan_10_food_13_i_11);
        food_ma_13_12 = (String) getText(R.string.food_male_plan_10_food_13_i_12);
        food_ma_13_13 = (String) getText(R.string.food_male_plan_10_food_13_i_13);
        food_ma_13_14 = (String) getText(R.string.food_male_plan_10_food_13_i_14);
        food_male_plan_10_food_13_r_1 = (String) getText(R.string.food_male_plan_10_food_13_r_1);
        food_male_plan_10_food_13_r_2 = (String) getText(R.string.food_male_plan_10_food_13_r_2);
        food_male_plan_10_food_13_r_3 = (String) getText(R.string.food_male_plan_10_food_13_r_3);
        food_male_plan_10_food_13_r_4 = (String) getText(R.string.food_male_plan_10_food_13_r_4);
        food_male_plan_10_food_13_r_5 = (String) getText(R.string.food_male_plan_10_food_13_r_5);
        food_male_plan_10_food_13_r_6 = (String) getText(R.string.food_male_plan_10_food_13_r_6);
        food_male_plan_10_food_13_r_7 = (String) getText(R.string.food_male_plan_10_food_13_r_7);
        food_male_plan_10_food_13_r_8 = (String) getText(R.string.food_male_plan_10_food_13_r_8);
        food_male_plan_10_food_13_r_9 = (String) getText(R.string.food_male_plan_10_food_13_r_9);
        food_male_plan_10_food_13_r_10 = (String) getText(R.string.food_male_plan_10_food_13_r_10);

        food_ma_14_1 = (String) getText(R.string.food_male_plan_10_food_14_i_1);
        food_ma_14_2 = (String) getText(R.string.food_male_plan_10_food_14_i_2);
        food_ma_14_3 = (String) getText(R.string.food_male_plan_10_food_14_i_3);
        food_ma_14_4 = (String) getText(R.string.food_male_plan_10_food_14_i_4);
        food_ma_14_5 = (String) getText(R.string.food_male_plan_10_food_14_i_5);
        food_ma_14_6 = (String) getText(R.string.food_male_plan_10_food_14_i_6);
        food_ma_14_7 = (String) getText(R.string.food_male_plan_10_food_14_i_7);
        food_ma_14_8 = (String) getText(R.string.food_male_plan_10_food_14_i_8);
        food_ma_14_9 = (String) getText(R.string.food_male_plan_10_food_14_i_9);
        food_ma_14_10 = (String) getText(R.string.food_male_plan_10_food_14_i_10);
        food_ma_14_11 = (String) getText(R.string.food_male_plan_10_food_14_i_11);
        food_ma_14_12 = (String) getText(R.string.food_male_plan_10_food_14_i_12);
        food_ma_14_13 = (String) getText(R.string.food_male_plan_10_food_14_i_13);
        food_ma_14_14 = (String) getText(R.string.food_male_plan_10_food_14_i_14);
        food_ma_14_15 = (String) getText(R.string.food_male_plan_10_food_14_i_15);
        food_ma_14_16 = (String) getText(R.string.food_male_plan_10_food_14_i_16);
        food_ma_14_17 = (String) getText(R.string.food_male_plan_10_food_14_i_17);
        food_ma_14_18 = (String) getText(R.string.food_male_plan_10_food_14_i_18);
        food_ma_14_19 = (String) getText(R.string.food_male_plan_10_food_14_i_19);
        food_ma_14_20 = (String) getText(R.string.food_male_plan_10_food_14_i_20);
        food_ma_14_21 = (String) getText(R.string.food_male_plan_10_food_14_i_21);
        food_ma_14_22 = (String) getText(R.string.food_male_plan_10_food_14_i_22);
        food_male_plan_10_food_14_r_1 = (String) getText(R.string.food_male_plan_10_food_14_r_1);
        food_male_plan_10_food_14_r_2 = (String) getText(R.string.food_male_plan_10_food_14_r_2);
        food_male_plan_10_food_14_r_3 = (String) getText(R.string.food_male_plan_10_food_14_r_3);
        food_male_plan_10_food_14_r_4 = (String) getText(R.string.food_male_plan_10_food_14_r_4);
        food_male_plan_10_food_14_r_5 = (String) getText(R.string.food_male_plan_10_food_14_r_5);
        food_male_plan_10_food_14_r_6 = (String) getText(R.string.food_male_plan_10_food_14_r_6);
        food_male_plan_10_food_14_r_7 = (String) getText(R.string.food_male_plan_10_food_14_r_7);
        food_male_plan_10_food_14_r_8 = (String) getText(R.string.food_male_plan_10_food_14_r_8);
        food_male_plan_10_food_14_r_9 = (String) getText(R.string.food_male_plan_10_food_14_r_9);
        food_male_plan_10_food_14_r_10 = (String) getText(R.string.food_male_plan_10_food_14_r_10);

        food_ma_15_1 = (String) getText(R.string.food_male_plan_10_food_15_i_1);
        food_ma_15_2 = (String) getText(R.string.food_male_plan_10_food_15_i_2);
        food_ma_15_3 = (String) getText(R.string.food_male_plan_10_food_15_i_3);
        food_ma_15_4 = (String) getText(R.string.food_male_plan_10_food_15_i_4);
        food_ma_15_5 = (String) getText(R.string.food_male_plan_10_food_15_i_5);
        food_ma_15_6 = (String) getText(R.string.food_male_plan_10_food_15_i_6);
        food_ma_15_7 = (String) getText(R.string.food_male_plan_10_food_15_i_7);
        food_ma_15_8 = (String) getText(R.string.food_male_plan_10_food_15_i_8);
        food_ma_15_9 = (String) getText(R.string.food_male_plan_10_food_15_i_9);
        food_ma_15_10 = (String) getText(R.string.food_male_plan_10_food_15_i_10);
        food_ma_15_11 = (String) getText(R.string.food_male_plan_10_food_15_i_11);
        food_ma_15_12 = (String) getText(R.string.food_male_plan_10_food_15_i_12);
        food_ma_15_13 = (String) getText(R.string.food_male_plan_10_food_15_i_13);
        food_ma_15_14 = (String) getText(R.string.food_male_plan_10_food_15_i_14);
        food_ma_15_15 = (String) getText(R.string.food_male_plan_10_food_15_i_15);
        food_ma_15_16 = (String) getText(R.string.food_male_plan_10_food_15_i_16);
        food_ma_15_17 = (String) getText(R.string.food_male_plan_10_food_15_i_17);
        food_ma_15_18 = (String) getText(R.string.food_male_plan_10_food_15_i_18);
        food_ma_15_19 = (String) getText(R.string.food_male_plan_10_food_15_i_19);
        food_ma_15_20 = (String) getText(R.string.food_male_plan_10_food_15_i_20);
        food_male_plan_10_food_15_r_1 = (String) getText(R.string.food_male_plan_10_food_15_r_1);
        food_male_plan_10_food_15_r_2 = (String) getText(R.string.food_male_plan_10_food_15_r_2);
        food_male_plan_10_food_15_r_3 = (String) getText(R.string.food_male_plan_10_food_15_r_3);
        food_male_plan_10_food_15_r_4 = (String) getText(R.string.food_male_plan_10_food_15_r_4);
        food_male_plan_10_food_15_r_5 = (String) getText(R.string.food_male_plan_10_food_15_r_5);
        food_male_plan_10_food_15_r_6 = (String) getText(R.string.food_male_plan_10_food_15_r_6);
        food_male_plan_10_food_15_r_7 = (String) getText(R.string.food_male_plan_10_food_15_r_7);

        food_ma_16_1 = (String) getText(R.string.food_male_plan_10_food_16_i_1);
        food_ma_16_2 = (String) getText(R.string.food_male_plan_10_food_16_i_2);
        food_ma_16_3 = (String) getText(R.string.food_male_plan_10_food_16_i_3);
        food_ma_16_4 = (String) getText(R.string.food_male_plan_10_food_16_i_4);
        food_ma_16_5 = (String) getText(R.string.food_male_plan_10_food_16_i_5);
        food_ma_16_6 = (String) getText(R.string.food_male_plan_10_food_16_i_6);
        food_ma_16_7 = (String) getText(R.string.food_male_plan_10_food_16_i_7);
        food_ma_16_8 = (String) getText(R.string.food_male_plan_10_food_16_i_8);
        food_ma_16_9 = (String) getText(R.string.food_male_plan_10_food_16_i_9);
        food_male_plan_10_food_16_r_1 = (String) getText(R.string.food_male_plan_10_food_16_r_1);
        food_male_plan_10_food_16_r_2 = (String) getText(R.string.food_male_plan_10_food_16_r_2);
        food_male_plan_10_food_16_r_3 = (String) getText(R.string.food_male_plan_10_food_16_r_3);
        food_male_plan_10_food_16_r_4 = (String) getText(R.string.food_male_plan_10_food_16_r_4);

        food_ma_17_1 = (String) getText(R.string.food_male_plan_10_food_17_i_1);
        food_ma_17_2 = (String) getText(R.string.food_male_plan_10_food_17_i_2);
        food_ma_17_3 = (String) getText(R.string.food_male_plan_10_food_17_i_3);
        food_ma_17_4 = (String) getText(R.string.food_male_plan_10_food_17_i_4);
        food_ma_17_5 = (String) getText(R.string.food_male_plan_10_food_17_i_5);
        food_ma_17_6 = (String) getText(R.string.food_male_plan_10_food_17_i_6);
        food_ma_17_7 = (String) getText(R.string.food_male_plan_10_food_17_i_7);
        food_ma_17_8 = (String) getText(R.string.food_male_plan_10_food_17_i_8);
        food_ma_17_9 = (String) getText(R.string.food_male_plan_10_food_17_i_9);
        food_ma_17_10 = (String) getText(R.string.food_male_plan_10_food_17_i_10);
        food_ma_17_11 = (String) getText(R.string.food_male_plan_10_food_17_i_11);
        food_ma_17_12 = (String) getText(R.string.food_male_plan_10_food_17_i_12);
        food_male_plan_10_food_17_r_1 = (String) getText(R.string.food_male_plan_10_food_17_r_1);
        food_male_plan_10_food_17_r_2 = (String) getText(R.string.food_male_plan_10_food_17_r_2);
        food_male_plan_10_food_17_r_3 = (String) getText(R.string.food_male_plan_10_food_17_r_3);
        food_male_plan_10_food_17_r_4 = (String) getText(R.string.food_male_plan_10_food_17_r_4);
        food_male_plan_10_food_17_r_5 = (String) getText(R.string.food_male_plan_10_food_17_r_5);

        food_ma_18_1 = (String) getText(R.string.food_male_plan_10_food_18_i_1);
        food_ma_18_2 = (String) getText(R.string.food_male_plan_10_food_18_i_2);
        food_ma_18_3 = (String) getText(R.string.food_male_plan_10_food_18_i_3);
        food_ma_18_4 = (String) getText(R.string.food_male_plan_10_food_18_i_4);
        food_ma_18_5 = (String) getText(R.string.food_male_plan_10_food_18_i_5);
        food_ma_18_6 = (String) getText(R.string.food_male_plan_10_food_18_i_6);
        food_ma_18_7 = (String) getText(R.string.food_male_plan_10_food_18_i_7);
        food_ma_18_8 = (String) getText(R.string.food_male_plan_10_food_18_i_8);
        food_ma_18_9 = (String) getText(R.string.food_male_plan_10_food_18_i_9);
        food_ma_18_10 = (String) getText(R.string.food_male_plan_10_food_18_i_10);
        food_ma_18_11 = (String) getText(R.string.food_male_plan_10_food_18_i_11);
        food_male_plan_10_food_18_r_1 = (String) getText(R.string.food_male_plan_10_food_18_r_1);
        food_male_plan_10_food_18_r_2 = (String) getText(R.string.food_male_plan_10_food_18_r_2);
        food_male_plan_10_food_18_r_3 = (String) getText(R.string.food_male_plan_10_food_18_r_3);
        food_male_plan_10_food_18_r_4 = (String) getText(R.string.food_male_plan_10_food_18_r_4);
        food_male_plan_10_food_18_r_5 = (String) getText(R.string.food_male_plan_10_food_18_r_5);
        food_male_plan_10_food_18_r_6 = (String) getText(R.string.food_male_plan_10_food_18_r_6);

        food_ma_19_1 = (String) getText(R.string.food_male_plan_10_food_19_i_1);
        food_ma_19_2 = (String) getText(R.string.food_male_plan_10_food_19_i_2);
        food_ma_19_3 = (String) getText(R.string.food_male_plan_10_food_19_i_3);
        food_ma_19_4 = (String) getText(R.string.food_male_plan_10_food_19_i_4);
        food_ma_19_5 = (String) getText(R.string.food_male_plan_10_food_19_i_5);
        food_ma_19_6 = (String) getText(R.string.food_male_plan_10_food_19_i_6);
        food_ma_19_7 = (String) getText(R.string.food_male_plan_10_food_19_i_7);
        food_ma_19_8 = (String) getText(R.string.food_male_plan_10_food_19_i_8);
        food_male_plan_10_food_19_r_1 = (String) getText(R.string.food_male_plan_10_food_19_r_1);
        food_male_plan_10_food_19_r_2 = (String) getText(R.string.food_male_plan_10_food_19_r_2);
        food_male_plan_10_food_19_r_3 = (String) getText(R.string.food_male_plan_10_food_19_r_3);
        food_male_plan_10_food_19_r_4 = (String) getText(R.string.food_male_plan_10_food_19_r_4);
        food_male_plan_10_food_19_r_5 = (String) getText(R.string.food_male_plan_10_food_19_r_5);

        food_ma_20_1 = (String) getText(R.string.food_male_plan_10_food_20_i_1);
        food_ma_20_2 = (String) getText(R.string.food_male_plan_10_food_20_i_2);
        food_ma_20_3 = (String) getText(R.string.food_male_plan_10_food_20_i_3);
        food_ma_20_4 = (String) getText(R.string.food_male_plan_10_food_20_i_4);
        food_ma_20_5 = (String) getText(R.string.food_male_plan_10_food_20_i_5);
        food_ma_20_6 = (String) getText(R.string.food_male_plan_10_food_20_i_6);
        food_ma_20_7 = (String) getText(R.string.food_male_plan_10_food_20_i_7);
        food_ma_20_8 = (String) getText(R.string.food_male_plan_10_food_20_i_8);
        food_ma_20_9 = (String) getText(R.string.food_male_plan_10_food_20_i_9);
        food_ma_20_10 = (String) getText(R.string.food_male_plan_10_food_20_i_10);
        food_male_plan_10_food_20_r_1 = (String) getText(R.string.food_male_plan_10_food_20_r_1);
        food_male_plan_10_food_20_r_2 = (String) getText(R.string.food_male_plan_10_food_20_r_2);
        food_male_plan_10_food_20_r_3 = (String) getText(R.string.food_male_plan_10_food_20_r_3);
        food_male_plan_10_food_20_r_4 = (String) getText(R.string.food_male_plan_10_food_20_r_4);
        food_male_plan_10_food_20_r_5 = (String) getText(R.string.food_male_plan_10_food_20_r_5);
        food_male_plan_10_food_20_r_6 = (String) getText(R.string.food_male_plan_10_food_20_r_6);
        food_male_plan_10_food_20_r_7 = (String) getText(R.string.food_male_plan_10_food_20_r_7);
        food_male_plan_10_food_20_r_8 = (String) getText(R.string.food_male_plan_10_food_20_r_8);
        food_male_plan_10_food_20_r_9 = (String) getText(R.string.food_male_plan_10_food_20_r_9);
        food_male_plan_10_food_20_r_10 = (String) getText(R.string.food_male_plan_10_food_20_r_10);
        food_male_plan_10_food_20_r_11 = (String) getText(R.string.food_male_plan_10_food_20_r_11);
        food_male_plan_10_food_20_r_12 = (String) getText(R.string.food_male_plan_10_food_20_r_12);
        food_male_plan_10_food_20_r_13 = (String) getText(R.string.food_male_plan_10_food_20_r_13);

        food_ma_21_1 = (String) getText(R.string.food_male_plan_10_food_21_i_1);
        food_ma_21_2 = (String) getText(R.string.food_male_plan_10_food_21_i_2);
        food_ma_21_3 = (String) getText(R.string.food_male_plan_10_food_21_i_3);
        food_ma_21_4 = (String) getText(R.string.food_male_plan_10_food_21_i_4);
        food_ma_21_5 = (String) getText(R.string.food_male_plan_10_food_21_i_5);
        food_ma_21_6 = (String) getText(R.string.food_male_plan_10_food_21_i_6);
        food_ma_21_7 = (String) getText(R.string.food_male_plan_10_food_21_i_7);
        food_male_plan_10_food_21_r_1 = (String) getText(R.string.food_male_plan_10_food_21_r_1);
        food_male_plan_10_food_21_r_2 = (String) getText(R.string.food_male_plan_10_food_21_r_2);
        food_male_plan_10_food_21_r_3 = (String) getText(R.string.food_male_plan_10_food_21_r_3);
        food_male_plan_10_food_21_r_4 = (String) getText(R.string.food_male_plan_10_food_21_r_4);
        food_male_plan_10_food_21_r_5 = (String) getText(R.string.food_male_plan_10_food_21_r_5);

        food_ma_22_1 = (String) getText(R.string.food_male_plan_10_food_22_i_1);
        food_ma_22_2 = (String) getText(R.string.food_male_plan_10_food_22_i_2);
        food_ma_22_3 = (String) getText(R.string.food_male_plan_10_food_22_i_3);
        food_ma_22_4 = (String) getText(R.string.food_male_plan_10_food_22_i_4);
        food_ma_22_5 = (String) getText(R.string.food_male_plan_10_food_22_i_5);
        food_ma_22_6 = (String) getText(R.string.food_male_plan_10_food_22_i_6);
        food_ma_22_7 = (String) getText(R.string.food_male_plan_10_food_22_i_7);
        food_male_plan_10_food_22_r_1 = (String) getText(R.string.food_male_plan_10_food_22_r_1);
        food_male_plan_10_food_22_r_2 = (String) getText(R.string.food_male_plan_10_food_22_r_2);

        food_ma_23_1 = (String) getText(R.string.food_male_plan_10_food_23_i_1);
        food_ma_23_2 = (String) getText(R.string.food_male_plan_10_food_23_i_2);
        food_ma_23_3 = (String) getText(R.string.food_male_plan_10_food_23_i_3);
        food_ma_23_4 = (String) getText(R.string.food_male_plan_10_food_23_i_4);
        food_ma_23_5 = (String) getText(R.string.food_male_plan_10_food_23_i_5);
        food_ma_23_6 = (String) getText(R.string.food_male_plan_10_food_23_i_6);
        food_male_plan_10_food_23_r_1 = (String) getText(R.string.food_male_plan_10_food_23_r_1);
        food_male_plan_10_food_23_r_2 = (String) getText(R.string.food_male_plan_10_food_23_r_2);
        food_male_plan_10_food_23_r_3 = (String) getText(R.string.food_male_plan_10_food_23_r_3);


        food_ma_24_1 = (String) getText(R.string.food_male_plan_10_food_24_i_1);
        food_ma_24_2 = (String) getText(R.string.food_male_plan_10_food_24_i_2);
        food_ma_24_3 = (String) getText(R.string.food_male_plan_10_food_24_i_3);
        food_ma_24_4 = (String) getText(R.string.food_male_plan_10_food_24_i_4);
        food_ma_24_5 = (String) getText(R.string.food_male_plan_10_food_24_i_5);
        food_ma_24_6 = (String) getText(R.string.food_male_plan_10_food_24_i_6);
        food_ma_24_7 = (String) getText(R.string.food_male_plan_10_food_24_i_7);
        food_male_plan_10_food_24_r_1 = (String) getText(R.string.food_male_plan_10_food_24_r_1);
        food_male_plan_10_food_24_r_2 = (String) getText(R.string.food_male_plan_10_food_24_r_2);
        food_male_plan_10_food_24_r_3 = (String) getText(R.string.food_male_plan_10_food_24_r_3);
        food_male_plan_10_food_24_r_4 = (String) getText(R.string.food_male_plan_10_food_24_r_4);

        food_ma_25_1 = (String) getText(R.string.food_male_plan_10_food_25_i_1);
        food_ma_25_2 = (String) getText(R.string.food_male_plan_10_food_25_i_2);
        food_ma_25_3 = (String) getText(R.string.food_male_plan_10_food_25_i_3);
        food_ma_25_4 = (String) getText(R.string.food_male_plan_10_food_25_i_4);
        food_ma_25_5 = (String) getText(R.string.food_male_plan_10_food_25_i_5);
        food_ma_25_6 = (String) getText(R.string.food_male_plan_10_food_25_i_6);
        food_ma_25_7 = (String) getText(R.string.food_male_plan_10_food_25_i_7);
        food_ma_25_8 = (String) getText(R.string.food_male_plan_10_food_25_i_8);
        food_male_plan_10_food_25_r_1 = (String) getText(R.string.food_male_plan_10_food_25_r_1);
        food_male_plan_10_food_25_r_2 = (String) getText(R.string.food_male_plan_10_food_25_r_2);
        food_male_plan_10_food_25_r_3 = (String) getText(R.string.food_male_plan_10_food_25_r_3);
        food_male_plan_10_food_25_r_4 = (String) getText(R.string.food_male_plan_10_food_25_r_4);

        food_ma_26_1 = (String) getText(R.string.food_male_plan_10_food_26_i_1);
        food_ma_26_2 = (String) getText(R.string.food_male_plan_10_food_26_i_2);
        food_ma_26_3 = (String) getText(R.string.food_male_plan_10_food_26_i_3);
        food_ma_26_4 = (String) getText(R.string.food_male_plan_10_food_26_i_4);
        food_ma_26_5 = (String) getText(R.string.food_male_plan_10_food_26_i_5);
        food_ma_26_6 = (String) getText(R.string.food_male_plan_10_food_26_i_6);
        food_ma_26_7 = (String) getText(R.string.food_male_plan_10_food_26_i_7);
        food_ma_26_8 = (String) getText(R.string.food_male_plan_10_food_26_i_8);
        food_ma_26_9 = (String) getText(R.string.food_male_plan_10_food_26_i_9);
        food_ma_26_10 = (String) getText(R.string.food_male_plan_10_food_26_i_10);
        food_ma_26_11 = (String) getText(R.string.food_male_plan_10_food_26_i_11);
        food_ma_26_12 = (String) getText(R.string.food_male_plan_10_food_26_i_12);
        food_male_plan_10_food_26_r_1 = (String) getText(R.string.food_male_plan_10_food_26_r_1);
        food_male_plan_10_food_26_r_2 = (String) getText(R.string.food_male_plan_10_food_26_r_2);
        food_male_plan_10_food_26_r_3 = (String) getText(R.string.food_male_plan_10_food_26_r_3);
        food_male_plan_10_food_26_r_4 = (String) getText(R.string.food_male_plan_10_food_26_r_4);
        food_male_plan_10_food_26_r_5 = (String) getText(R.string.food_male_plan_10_food_26_r_5);
        food_male_plan_10_food_26_r_6 = (String) getText(R.string.food_male_plan_10_food_26_r_6);

        food_ma_27_1 = (String) getText(R.string.food_male_plan_10_food_27_i_1);
        food_ma_27_2 = (String) getText(R.string.food_male_plan_10_food_27_i_2);
        food_ma_27_3 = (String) getText(R.string.food_male_plan_10_food_27_i_3);
        food_ma_27_4 = (String) getText(R.string.food_male_plan_10_food_27_i_4);
        food_ma_27_5 = (String) getText(R.string.food_male_plan_10_food_27_i_5);
        food_ma_27_6 = (String) getText(R.string.food_male_plan_10_food_27_i_6);
        food_ma_27_7 = (String) getText(R.string.food_male_plan_10_food_27_i_7);
        food_male_plan_10_food_27_r_1 = (String) getText(R.string.food_male_plan_10_food_27_r_1);
        food_male_plan_10_food_27_r_2 = (String) getText(R.string.food_male_plan_10_food_27_r_2);

        food_ma_28_1 = (String) getText(R.string.food_male_plan_10_food_28_i_1);
        food_ma_28_2 = (String) getText(R.string.food_male_plan_10_food_28_i_2);
        food_ma_28_3 = (String) getText(R.string.food_male_plan_10_food_28_i_3);
        food_ma_28_4 = (String) getText(R.string.food_male_plan_10_food_28_i_4);
        food_ma_28_5 = (String) getText(R.string.food_male_plan_10_food_28_i_5);
        food_ma_28_6 = (String) getText(R.string.food_male_plan_10_food_28_i_6);
        food_ma_28_7 = (String) getText(R.string.food_male_plan_10_food_28_i_7);
        food_male_plan_10_food_28_r_1 = (String) getText(R.string.food_male_plan_10_food_28_r_1);
        food_male_plan_10_food_28_r_2 = (String) getText(R.string.food_male_plan_10_food_28_r_2);

        food_ma_29_1 = (String) getText(R.string.food_male_plan_10_food_29_i_1);
        food_ma_29_2 = (String) getText(R.string.food_male_plan_10_food_29_i_2);
        food_ma_29_3 = (String) getText(R.string.food_male_plan_10_food_29_i_3);
        food_ma_29_4 = (String) getText(R.string.food_male_plan_10_food_29_i_4);
        food_ma_29_5 = (String) getText(R.string.food_male_plan_10_food_29_i_5);
        food_ma_29_6 = (String) getText(R.string.food_male_plan_10_food_29_i_6);
        food_ma_29_7 = (String) getText(R.string.food_male_plan_10_food_29_i_7);
        food_ma_29_8 = (String) getText(R.string.food_male_plan_10_food_29_i_8);
        food_ma_29_9 = (String) getText(R.string.food_male_plan_10_food_29_i_9);
        food_ma_29_10 = (String) getText(R.string.food_male_plan_10_food_29_i_10);
        food_ma_29_11 = (String) getText(R.string.food_male_plan_10_food_29_i_11);
        food_ma_29_12 = (String) getText(R.string.food_male_plan_10_food_29_i_12);
        food_ma_29_13 = (String) getText(R.string.food_male_plan_10_food_29_i_13);
        food_ma_29_14 = (String) getText(R.string.food_male_plan_10_food_29_i_14);
        food_ma_29_15 = (String) getText(R.string.food_male_plan_10_food_29_i_15);
        food_male_plan_10_food_29_r_1 = (String) getText(R.string.food_male_plan_10_food_29_r_1);
        food_male_plan_10_food_29_r_2 = (String) getText(R.string.food_male_plan_10_food_29_r_2);
        food_male_plan_10_food_29_r_3 = (String) getText(R.string.food_male_plan_10_food_29_r_3);

        food_ma_30_1 = (String) getText(R.string.food_male_plan_10_food_30_i_1);
        food_ma_30_2 = (String) getText(R.string.food_male_plan_10_food_30_i_2);
        food_ma_30_3 = (String) getText(R.string.food_male_plan_10_food_30_i_3);
        food_ma_30_4 = (String) getText(R.string.food_male_plan_10_food_30_i_4);
        food_ma_30_5 = (String) getText(R.string.food_male_plan_10_food_30_i_5);
        food_ma_30_6 = (String) getText(R.string.food_male_plan_10_food_30_i_6);
        food_ma_30_7 = (String) getText(R.string.food_male_plan_10_food_30_i_7);
        food_ma_30_8 = (String) getText(R.string.food_male_plan_10_food_30_i_8);
        food_ma_30_9 = (String) getText(R.string.food_male_plan_10_food_30_i_9);
        food_ma_30_10 = (String) getText(R.string.food_male_plan_10_food_30_i_10);
        food_ma_30_11 = (String) getText(R.string.food_male_plan_10_food_30_i_11);
        food_ma_30_12 = (String) getText(R.string.food_male_plan_10_food_30_i_12);
        food_male_plan_10_food_30_r_1 = (String) getText(R.string.food_male_plan_10_food_30_r_1);
        food_male_plan_10_food_30_r_2 = (String) getText(R.string.food_male_plan_10_food_30_r_2);
        food_male_plan_10_food_30_r_3 = (String) getText(R.string.food_male_plan_10_food_30_r_3);

        food_ma_31_1 = (String) getText(R.string.food_male_plan_10_food_31_i_1);
        food_ma_31_2 = (String) getText(R.string.food_male_plan_10_food_31_i_2);
        food_ma_31_3 = (String) getText(R.string.food_male_plan_10_food_31_i_3);
        food_ma_31_4 = (String) getText(R.string.food_male_plan_10_food_31_i_4);
        food_ma_31_5 = (String) getText(R.string.food_male_plan_10_food_31_i_5);
        food_ma_31_6 = (String) getText(R.string.food_male_plan_10_food_31_i_6);
        food_ma_31_7 = (String) getText(R.string.food_male_plan_10_food_31_i_7);
        food_ma_31_8 = (String) getText(R.string.food_male_plan_10_food_31_i_8);
        food_ma_31_9 = (String) getText(R.string.food_male_plan_10_food_31_i_9);
        food_ma_31_10 = (String) getText(R.string.food_male_plan_10_food_31_i_10);
        food_ma_31_11 = (String) getText(R.string.food_male_plan_10_food_31_i_11);
        food_male_plan_10_food_31_r_1 = (String) getText(R.string.food_male_plan_10_food_31_r_1);
        food_male_plan_10_food_31_r_2 = (String) getText(R.string.food_male_plan_10_food_31_r_2);
        food_male_plan_10_food_31_r_3 = (String) getText(R.string.food_male_plan_10_food_31_r_3);


        food_ma_32_1 = (String) getText(R.string.food_male_plan_10_food_32_i_1);
        food_ma_32_2 = (String) getText(R.string.food_male_plan_10_food_32_i_2);
        food_ma_32_3 = (String) getText(R.string.food_male_plan_10_food_32_i_3);
        food_ma_32_4 = (String) getText(R.string.food_male_plan_10_food_32_i_4);
        food_ma_32_5 = (String) getText(R.string.food_male_plan_10_food_32_i_5);
        food_ma_32_6 = (String) getText(R.string.food_male_plan_10_food_32_i_6);
        food_ma_32_7 = (String) getText(R.string.food_male_plan_10_food_32_i_7);
        food_ma_32_8 = (String) getText(R.string.food_male_plan_10_food_32_i_8);
        food_ma_32_9 = (String) getText(R.string.food_male_plan_10_food_32_i_9);
        food_male_plan_10_food_32_r_1 = (String) getText(R.string.food_male_plan_10_food_32_r_1);
        food_male_plan_10_food_32_r_2 = (String) getText(R.string.food_male_plan_10_food_32_r_2);
        food_male_plan_10_food_32_r_3 = (String) getText(R.string.food_male_plan_10_food_32_r_3);


        food_ma_33_1 = (String) getText(R.string.food_male_plan_10_food_33_i_1);
        food_ma_33_2 = (String) getText(R.string.food_male_plan_10_food_33_i_2);
        food_ma_33_3 = (String) getText(R.string.food_male_plan_10_food_33_i_3);
        food_ma_33_4 = (String) getText(R.string.food_male_plan_10_food_33_i_4);
        food_ma_33_5 = (String) getText(R.string.food_male_plan_10_food_33_i_5);
        food_ma_33_6 = (String) getText(R.string.food_male_plan_10_food_33_i_6);
        food_ma_33_7 = (String) getText(R.string.food_male_plan_10_food_33_i_7);
        food_ma_33_8 = (String) getText(R.string.food_male_plan_10_food_33_i_8);
        food_ma_33_9 = (String) getText(R.string.food_male_plan_10_food_33_i_9);
        food_male_plan_10_food_33_r_1 = (String) getText(R.string.food_male_plan_10_food_33_r_1);
        food_male_plan_10_food_33_r_2 = (String) getText(R.string.food_male_plan_10_food_33_r_2);

        food_ma_34_1 = (String) getText(R.string.food_male_plan_10_food_34_i_1);
        food_ma_34_2 = (String) getText(R.string.food_male_plan_10_food_34_i_2);
        food_ma_34_3 = (String) getText(R.string.food_male_plan_10_food_34_i_3);
        food_ma_34_4 = (String) getText(R.string.food_male_plan_10_food_34_i_4);
        food_ma_34_5 = (String) getText(R.string.food_male_plan_10_food_34_i_5);
        food_ma_34_6 = (String) getText(R.string.food_male_plan_10_food_34_i_6);
        food_ma_34_7 = (String) getText(R.string.food_male_plan_10_food_34_i_7);
        food_male_plan_10_food_34_r_1 = (String) getText(R.string.food_male_plan_10_food_34_r_1);
        food_male_plan_10_food_34_r_2 = (String) getText(R.string.food_male_plan_10_food_34_r_2);

        food_ma_35_1 = (String) getText(R.string.food_male_plan_10_food_35_i_1);
        food_ma_35_2 = (String) getText(R.string.food_male_plan_10_food_35_i_2);
        food_ma_35_3 = (String) getText(R.string.food_male_plan_10_food_35_i_3);
        food_ma_35_4 = (String) getText(R.string.food_male_plan_10_food_35_i_4);
        food_ma_35_5 = (String) getText(R.string.food_male_plan_10_food_35_i_5);
        food_ma_35_6 = (String) getText(R.string.food_male_plan_10_food_35_i_6);
        food_ma_35_7 = (String) getText(R.string.food_male_plan_10_food_35_i_7);
        food_ma_35_8 = (String) getText(R.string.food_male_plan_10_food_35_i_8);
        food_male_plan_10_food_35_r_1 = (String) getText(R.string.food_male_plan_10_food_35_r_1);

        food_ma_36_1 = (String) getText(R.string.food_male_plan_10_food_36_i_1);
        food_ma_36_2 = (String) getText(R.string.food_male_plan_10_food_36_i_2);
        food_ma_36_3 = (String) getText(R.string.food_male_plan_10_food_36_i_3);
        food_ma_36_4 = (String) getText(R.string.food_male_plan_10_food_36_i_4);
        food_ma_36_5 = (String) getText(R.string.food_male_plan_10_food_36_i_5);
        food_ma_36_6 = (String) getText(R.string.food_male_plan_10_food_36_i_6);
        food_ma_36_7 = (String) getText(R.string.food_male_plan_10_food_36_i_7);
        food_ma_36_8 = (String) getText(R.string.food_male_plan_10_food_36_i_8);
        food_ma_36_9 = (String) getText(R.string.food_male_plan_10_food_36_i_9);
        food_ma_36_10 = (String) getText(R.string.food_male_plan_10_food_36_i_10);
        food_male_plan_10_food_36_r_1 = (String) getText(R.string.food_male_plan_10_food_36_r_1);
        food_male_plan_10_food_36_r_2 = (String) getText(R.string.food_male_plan_10_food_36_r_2);


        food_ma_37_1 = (String) getText(R.string.food_male_plan_10_food_37_i_1);
        food_ma_37_2 = (String) getText(R.string.food_male_plan_10_food_37_i_2);
        food_ma_37_3 = (String) getText(R.string.food_male_plan_10_food_37_i_3);
        food_ma_37_4 = (String) getText(R.string.food_male_plan_10_food_37_i_4);
        food_male_plan_10_food_37_r_1 = (String) getText(R.string.food_male_plan_10_food_37_r_1);
        food_male_plan_10_food_37_r_2 = (String) getText(R.string.food_male_plan_10_food_37_r_2);


        food_ma_38_1 = (String) getText(R.string.food_male_plan_10_food_38_i_1);
        food_ma_38_2 = (String) getText(R.string.food_male_plan_10_food_38_i_2);
        food_ma_38_3 = (String) getText(R.string.food_male_plan_10_food_38_i_3);
        food_ma_38_4 = (String) getText(R.string.food_male_plan_10_food_38_i_4);
        food_ma_38_5 = (String) getText(R.string.food_male_plan_10_food_38_i_5);
        food_ma_38_6 = (String) getText(R.string.food_male_plan_10_food_38_i_6);
        food_ma_38_7 = (String) getText(R.string.food_male_plan_10_food_38_i_7);
        food_ma_38_8 = (String) getText(R.string.food_male_plan_10_food_38_i_8);
        food_ma_38_9 = (String) getText(R.string.food_male_plan_10_food_38_i_9);
        food_ma_38_10 = (String) getText(R.string.food_male_plan_10_food_38_i_10);
        food_ma_38_11 = (String) getText(R.string.food_male_plan_10_food_38_i_11);
        food_ma_38_12 = (String) getText(R.string.food_male_plan_10_food_38_i_12);
        food_ma_38_13 = (String) getText(R.string.food_male_plan_10_food_38_i_13);
        food_ma_38_14 = (String) getText(R.string.food_male_plan_10_food_38_i_14);
        food_male_plan_10_food_38_r_1 = (String) getText(R.string.food_male_plan_10_food_38_r_1);
        food_male_plan_10_food_38_r_2 = (String) getText(R.string.food_male_plan_10_food_38_r_2);
        food_male_plan_10_food_38_r_3 = (String) getText(R.string.food_male_plan_10_food_38_r_3);
        food_male_plan_10_food_38_r_4 = (String) getText(R.string.food_male_plan_10_food_38_r_4);

        food_ma_39_1 = (String) getText(R.string.food_male_plan_10_food_39_i_1);
        food_ma_39_2 = (String) getText(R.string.food_male_plan_10_food_39_i_2);
        food_ma_39_3 = (String) getText(R.string.food_male_plan_10_food_39_i_3);
        food_ma_39_4 = (String) getText(R.string.food_male_plan_10_food_39_i_4);
        food_ma_39_5 = (String) getText(R.string.food_male_plan_10_food_39_i_5);
        food_ma_39_6 = (String) getText(R.string.food_male_plan_10_food_39_i_6);
        food_male_plan_10_food_39_r_1 = (String) getText(R.string.food_male_plan_10_food_39_r_1);


        food_ma_40_1 = (String) getText(R.string.food_male_plan_10_food_40_i_1);
        food_ma_40_2 = (String) getText(R.string.food_male_plan_10_food_40_i_2);
        food_ma_40_3 = (String) getText(R.string.food_male_plan_10_food_40_i_3);
        food_ma_40_4 = (String) getText(R.string.food_male_plan_10_food_40_i_4);
        food_ma_40_5 = (String) getText(R.string.food_male_plan_10_food_40_i_5);
        food_ma_40_6 = (String) getText(R.string.food_male_plan_10_food_40_i_6);
        food_ma_40_7 = (String) getText(R.string.food_male_plan_10_food_40_i_7);
        food_male_plan_10_food_40_r_1 = (String) getText(R.string.food_male_plan_10_food_40_r_1);
        food_male_plan_10_food_40_r_2 = (String) getText(R.string.food_male_plan_10_food_40_r_2);

        food_ma_41_1 = (String) getText(R.string.food_male_plan_10_food_41_i_1);
        food_ma_41_2 = (String) getText(R.string.food_male_plan_10_food_41_i_2);
        food_ma_41_3 = (String) getText(R.string.food_male_plan_10_food_41_i_3);
        food_ma_41_4 = (String) getText(R.string.food_male_plan_10_food_41_i_4);
        food_ma_41_5 = (String) getText(R.string.food_male_plan_10_food_41_i_5);
        food_ma_41_6 = (String) getText(R.string.food_male_plan_10_food_41_i_6);
        food_ma_41_7 = (String) getText(R.string.food_male_plan_10_food_41_i_7);
        food_ma_41_8 = (String) getText(R.string.food_male_plan_10_food_41_i_8);
        food_ma_41_9 = (String) getText(R.string.food_male_plan_10_food_41_i_9);
        food_ma_41_10 = (String) getText(R.string.food_male_plan_10_food_41_i_10);
        food_ma_41_11 = (String) getText(R.string.food_male_plan_10_food_41_i_11);
        food_ma_41_12 = (String) getText(R.string.food_male_plan_10_food_41_i_12);
        food_male_plan_10_food_41_r_1 = (String) getText(R.string.food_male_plan_10_food_41_r_1);
        food_male_plan_10_food_41_r_2 = (String) getText(R.string.food_male_plan_10_food_41_r_2);
        food_male_plan_10_food_41_r_3 = (String) getText(R.string.food_male_plan_10_food_41_r_3);
        food_male_plan_10_food_41_r_4 = (String) getText(R.string.food_male_plan_10_food_41_r_4);

        food_ma_42_1 = (String) getText(R.string.food_male_plan_10_food_42_i_1);
        food_ma_42_2 = (String) getText(R.string.food_male_plan_10_food_42_i_2);
        food_ma_42_3 = (String) getText(R.string.food_male_plan_10_food_42_i_3);
        food_ma_42_4 = (String) getText(R.string.food_male_plan_10_food_42_i_4);
        food_ma_42_5 = (String) getText(R.string.food_male_plan_10_food_42_i_5);
        food_ma_42_6 = (String) getText(R.string.food_male_plan_10_food_42_i_6);
        food_ma_42_7 = (String) getText(R.string.food_male_plan_10_food_42_i_7);
        food_male_plan_10_food_42_r_1 = (String) getText(R.string.food_male_plan_10_food_42_r_1);
        food_male_plan_10_food_42_r_2 = (String) getText(R.string.food_male_plan_10_food_42_r_2);
        food_male_plan_10_food_42_r_3 = (String) getText(R.string.food_male_plan_10_food_42_r_3);

        food_ma_43_1 = (String) getText(R.string.food_male_plan_10_food_43_i_1);
        food_ma_43_2 = (String) getText(R.string.food_male_plan_10_food_43_i_2);
        food_ma_43_3 = (String) getText(R.string.food_male_plan_10_food_43_i_3);
        food_ma_43_4 = (String) getText(R.string.food_male_plan_10_food_43_i_4);
        food_ma_43_5 = (String) getText(R.string.food_male_plan_10_food_43_i_5);
        food_ma_43_6 = (String) getText(R.string.food_male_plan_10_food_43_i_6);
        food_ma_43_7 = (String) getText(R.string.food_male_plan_10_food_43_i_7);
        food_male_plan_10_food_43_r_1 = (String) getText(R.string.food_male_plan_10_food_43_r_1);
        food_male_plan_10_food_43_r_2 = (String) getText(R.string.food_male_plan_10_food_43_r_2);
        food_male_plan_10_food_43_r_3 = (String) getText(R.string.food_male_plan_10_food_43_r_3);

        food_ma_44_1 = (String) getText(R.string.food_male_plan_10_food_44_i_1);
        food_ma_44_2 = (String) getText(R.string.food_male_plan_10_food_44_i_2);
        food_ma_44_3 = (String) getText(R.string.food_male_plan_10_food_44_i_3);
        food_ma_44_4 = (String) getText(R.string.food_male_plan_10_food_44_i_4);
        food_ma_44_5 = (String) getText(R.string.food_male_plan_10_food_44_i_5);
        food_ma_44_6 = (String) getText(R.string.food_male_plan_10_food_44_i_6);
        food_ma_44_7 = (String) getText(R.string.food_male_plan_10_food_44_i_7);
        food_ma_44_8 = (String) getText(R.string.food_male_plan_10_food_44_i_8);
        food_ma_44_9 = (String) getText(R.string.food_male_plan_10_food_44_i_9);
        food_male_plan_10_food_44_r_1 = (String) getText(R.string.food_male_plan_10_food_44_r_1);
        food_male_plan_10_food_44_r_2 = (String) getText(R.string.food_male_plan_10_food_44_r_2);
        food_male_plan_10_food_44_r_3 = (String) getText(R.string.food_male_plan_10_food_44_r_3);

        food_ma_45_1 = (String) getText(R.string.food_male_plan_10_food_45_i_1);
        food_ma_45_2 = (String) getText(R.string.food_male_plan_10_food_45_i_2);
        food_ma_45_3 = (String) getText(R.string.food_male_plan_10_food_45_i_3);
        food_ma_45_4 = (String) getText(R.string.food_male_plan_10_food_45_i_4);
        food_ma_45_5 = (String) getText(R.string.food_male_plan_10_food_45_i_5);
        food_ma_45_6 = (String) getText(R.string.food_male_plan_10_food_45_i_6);
        food_ma_45_7 = (String) getText(R.string.food_male_plan_10_food_45_i_7);
        food_ma_45_8 = (String) getText(R.string.food_male_plan_10_food_45_i_8);
        food_ma_45_9 = (String) getText(R.string.food_male_plan_10_food_45_i_9);
        food_ma_45_10 = (String) getText(R.string.food_male_plan_10_food_45_i_10);
        food_male_plan_10_food_45_r_1 = (String) getText(R.string.food_male_plan_10_food_45_r_1);
        food_male_plan_10_food_45_r_2 = (String) getText(R.string.food_male_plan_10_food_45_r_2);
        food_male_plan_10_food_45_r_3 = (String) getText(R.string.food_male_plan_10_food_45_r_3);

        food_ma_46_1 = (String) getText(R.string.food_male_plan_10_food_46_i_1);
        food_ma_46_2 = (String) getText(R.string.food_male_plan_10_food_46_i_2);
        food_ma_46_3 = (String) getText(R.string.food_male_plan_10_food_46_i_3);
        food_ma_46_4 = (String) getText(R.string.food_male_plan_10_food_46_i_4);
        food_ma_46_5 = (String) getText(R.string.food_male_plan_10_food_46_i_5);
        food_ma_46_6 = (String) getText(R.string.food_male_plan_10_food_46_i_6);
        food_ma_46_7 = (String) getText(R.string.food_male_plan_10_food_46_i_7);
        food_ma_46_8 = (String) getText(R.string.food_male_plan_10_food_46_i_8);
        food_ma_46_9 = (String) getText(R.string.food_male_plan_10_food_46_i_9);
        food_ma_46_10 = (String) getText(R.string.food_male_plan_10_food_46_i_10);
        food_male_plan_10_food_46_r_1 = (String) getText(R.string.food_male_plan_10_food_46_r_1);
        food_male_plan_10_food_46_r_2 = (String) getText(R.string.food_male_plan_10_food_46_r_2);

        food_ma_47_1 = (String) getText(R.string.food_male_plan_10_food_47_i_1);
        food_ma_47_2 = (String) getText(R.string.food_male_plan_10_food_47_i_2);
        food_ma_47_3 = (String) getText(R.string.food_male_plan_10_food_47_i_3);
        food_ma_47_4 = (String) getText(R.string.food_male_plan_10_food_47_i_4);
        food_male_plan_10_food_47_r_1 = (String) getText(R.string.food_male_plan_10_food_47_r_1);
        food_male_plan_10_food_47_r_2 = (String) getText(R.string.food_male_plan_10_food_47_r_2);

        food_ma_48_1 = (String) getText(R.string.food_male_plan_10_food_48_i_1);
        food_ma_48_2 = (String) getText(R.string.food_male_plan_10_food_48_i_2);
        food_ma_48_3 = (String) getText(R.string.food_male_plan_10_food_48_i_3);
        food_ma_48_4 = (String) getText(R.string.food_male_plan_10_food_48_i_4);
        food_male_plan_10_food_48_r_1 = (String) getText(R.string.food_male_plan_10_food_48_r_1);

        food_ma_49_1 = (String) getText(R.string.food_male_plan_10_food_49_i_1);
        food_ma_49_2 = (String) getText(R.string.food_male_plan_10_food_49_i_2);
        food_ma_49_3 = (String) getText(R.string.food_male_plan_10_food_49_i_3);
        food_ma_49_4 = (String) getText(R.string.food_male_plan_10_food_49_i_4);
        food_ma_49_5 = (String) getText(R.string.food_male_plan_10_food_49_i_5);
        food_ma_49_6 = (String) getText(R.string.food_male_plan_10_food_49_i_6);
        food_ma_49_7 = (String) getText(R.string.food_male_plan_10_food_49_i_7);
        food_ma_49_8 = (String) getText(R.string.food_male_plan_10_food_49_i_8);
        food_male_plan_10_food_49_r_1 = (String) getText(R.string.food_male_plan_10_food_49_r_1);
        food_male_plan_10_food_49_r_2 = (String) getText(R.string.food_male_plan_10_food_49_r_2);

        food_ma_50_1 = (String) getText(R.string.food_male_plan_10_food_50_i_1);
        food_ma_50_2 = (String) getText(R.string.food_male_plan_10_food_50_i_2);
        food_ma_50_3 = (String) getText(R.string.food_male_plan_10_food_50_i_3);
        food_ma_50_4 = (String) getText(R.string.food_male_plan_10_food_50_i_4);
        food_ma_50_5 = (String) getText(R.string.food_male_plan_10_food_50_i_5);
        food_ma_50_6 = (String) getText(R.string.food_male_plan_10_food_50_i_6);
        food_ma_50_7 = (String) getText(R.string.food_male_plan_10_food_50_i_7);
        food_ma_50_8 = (String) getText(R.string.food_male_plan_10_food_50_i_8);
        food_ma_50_9 = (String) getText(R.string.food_male_plan_10_food_50_i_9);
        food_ma_50_10 = (String) getText(R.string.food_male_plan_10_food_50_i_10);
        food_male_plan_10_food_50_r_1 = (String) getText(R.string.food_male_plan_10_food_50_r_1);
        food_male_plan_10_food_50_r_2 = (String) getText(R.string.food_male_plan_10_food_50_r_2);

        food_ma_51_1 = (String) getText(R.string.food_male_plan_10_food_51_i_1);
        food_ma_51_2 = (String) getText(R.string.food_male_plan_10_food_51_i_2);
        food_ma_51_3 = (String) getText(R.string.food_male_plan_10_food_51_i_3);
        food_ma_51_4 = (String) getText(R.string.food_male_plan_10_food_51_i_4);
        food_ma_51_5 = (String) getText(R.string.food_male_plan_10_food_51_i_5);
        food_ma_51_6 = (String) getText(R.string.food_male_plan_10_food_51_i_6);
        food_ma_51_7 = (String) getText(R.string.food_male_plan_10_food_51_i_7);
        food_ma_51_8 = (String) getText(R.string.food_male_plan_10_food_51_i_8);
        food_male_plan_10_food_51_r_1 = (String) getText(R.string.food_male_plan_10_food_51_r_1);
        food_male_plan_10_food_51_r_2 = (String) getText(R.string.food_male_plan_10_food_51_r_2);

        food_ma_52_1 = (String) getText(R.string.food_male_plan_10_food_52_i_1);
        food_ma_52_2 = (String) getText(R.string.food_male_plan_10_food_52_i_2);
        food_ma_52_3 = (String) getText(R.string.food_male_plan_10_food_52_i_3);
        food_ma_52_4 = (String) getText(R.string.food_male_plan_10_food_52_i_4);
        food_ma_52_5 = (String) getText(R.string.food_male_plan_10_food_52_i_5);
        food_ma_52_6 = (String) getText(R.string.food_male_plan_10_food_52_i_6);
        food_ma_52_7 = (String) getText(R.string.food_male_plan_10_food_52_i_7);
        food_ma_52_8 = (String) getText(R.string.food_male_plan_10_food_52_i_8);
        food_ma_52_9 = (String) getText(R.string.food_male_plan_10_food_52_i_9);
        food_male_plan_10_food_52_r_1 = (String) getText(R.string.food_male_plan_10_food_52_r_1);
        food_male_plan_10_food_52_r_2 = (String) getText(R.string.food_male_plan_10_food_52_r_2);

        food_ma_53_1 = (String) getText(R.string.food_male_plan_10_food_53_i_1);
        food_ma_53_2 = (String) getText(R.string.food_male_plan_10_food_53_i_2);
        food_ma_53_3 = (String) getText(R.string.food_male_plan_10_food_53_i_3);
        food_ma_53_4 = (String) getText(R.string.food_male_plan_10_food_53_i_4);
        food_ma_53_5 = (String) getText(R.string.food_male_plan_10_food_53_i_5);
        food_ma_53_6 = (String) getText(R.string.food_male_plan_10_food_53_i_6);
        food_ma_53_7 = (String) getText(R.string.food_male_plan_10_food_53_i_7);
        food_ma_53_8 = (String) getText(R.string.food_male_plan_10_food_53_i_8);
        food_ma_53_9 = (String) getText(R.string.food_male_plan_10_food_53_i_9);
        food_ma_53_10 = (String) getText(R.string.food_male_plan_10_food_53_i_10);
        food_male_plan_10_food_53_r_1 = (String) getText(R.string.food_male_plan_10_food_53_r_1);
        food_male_plan_10_food_53_r_2 = (String) getText(R.string.food_male_plan_10_food_53_r_2);
        food_male_plan_10_food_53_r_3 = (String) getText(R.string.food_male_plan_10_food_53_r_3);

        food_ma_54_1 = (String) getText(R.string.food_male_plan_10_food_54_i_1);
        food_ma_54_2 = (String) getText(R.string.food_male_plan_10_food_54_i_2);
        food_ma_54_3 = (String) getText(R.string.food_male_plan_10_food_54_i_3);
        food_ma_54_4 = (String) getText(R.string.food_male_plan_10_food_54_i_4);
        food_ma_54_5 = (String) getText(R.string.food_male_plan_10_food_54_i_5);
        food_ma_54_6 = (String) getText(R.string.food_male_plan_10_food_54_i_6);
        food_ma_54_7 = (String) getText(R.string.food_male_plan_10_food_54_i_7);
        food_ma_54_8 = (String) getText(R.string.food_male_plan_10_food_54_i_8);
        food_ma_54_9 = (String) getText(R.string.food_male_plan_10_food_54_i_9);
        food_male_plan_10_food_54_r_1 = (String) getText(R.string.food_male_plan_10_food_54_r_1);
        food_male_plan_10_food_54_r_2 = (String) getText(R.string.food_male_plan_10_food_54_r_2);
        food_male_plan_10_food_54_r_3 = (String) getText(R.string.food_male_plan_10_food_54_r_3);

        food_ma_55_1 = (String) getText(R.string.food_male_plan_10_food_55_i_1);
        food_ma_55_2 = (String) getText(R.string.food_male_plan_10_food_55_i_2);
        food_ma_55_3 = (String) getText(R.string.food_male_plan_10_food_55_i_3);
        food_ma_55_4 = (String) getText(R.string.food_male_plan_10_food_55_i_4);
        food_ma_55_5 = (String) getText(R.string.food_male_plan_10_food_55_i_5);
        food_ma_55_6 = (String) getText(R.string.food_male_plan_10_food_55_i_6);
        food_ma_55_7 = (String) getText(R.string.food_male_plan_10_food_55_i_7);
        food_ma_55_8 = (String) getText(R.string.food_male_plan_10_food_55_i_8);
        food_ma_55_9 = (String) getText(R.string.food_male_plan_10_food_55_i_9);
        food_ma_55_10 = (String) getText(R.string.food_male_plan_10_food_55_i_10);
        food_ma_55_11 = (String) getText(R.string.food_male_plan_10_food_55_i_11);
        food_ma_55_12 = (String) getText(R.string.food_male_plan_10_food_55_i_12);
        food_male_plan_10_food_55_r_1 = (String) getText(R.string.food_male_plan_10_food_55_r_1);
        food_male_plan_10_food_55_r_2 = (String) getText(R.string.food_male_plan_10_food_55_r_2);

        food_ma_56_1 = (String) getText(R.string.food_male_plan_10_food_56_i_1);
        food_ma_56_2 = (String) getText(R.string.food_male_plan_10_food_56_i_2);
        food_ma_56_3 = (String) getText(R.string.food_male_plan_10_food_56_i_3);
        food_ma_56_4 = (String) getText(R.string.food_male_plan_10_food_56_i_4);
        food_ma_56_5 = (String) getText(R.string.food_male_plan_10_food_56_i_5);
        food_ma_56_6 = (String) getText(R.string.food_male_plan_10_food_56_i_6);
        food_ma_56_7 = (String) getText(R.string.food_male_plan_10_food_56_i_7);
        food_ma_56_8 = (String) getText(R.string.food_male_plan_10_food_56_i_8);
        food_ma_56_9 = (String) getText(R.string.food_male_plan_10_food_56_i_9);
        food_male_plan_10_food_56_r_1 = (String) getText(R.string.food_male_plan_10_food_56_r_1);
        food_male_plan_10_food_56_r_2 = (String) getText(R.string.food_male_plan_10_food_56_r_2);

        food_ma_57_1 = (String) getText(R.string.food_male_plan_10_food_57_i_1);
        food_ma_57_2 = (String) getText(R.string.food_male_plan_10_food_57_i_2);
        food_ma_57_3 = (String) getText(R.string.food_male_plan_10_food_57_i_3);
        food_ma_57_4 = (String) getText(R.string.food_male_plan_10_food_57_i_4);
        food_ma_57_5 = (String) getText(R.string.food_male_plan_10_food_57_i_5);
        food_ma_57_6 = (String) getText(R.string.food_male_plan_10_food_57_i_6);
        food_ma_57_7 = (String) getText(R.string.food_male_plan_10_food_57_i_7);
        food_ma_57_8 = (String) getText(R.string.food_male_plan_10_food_57_i_8);
        food_ma_57_9 = (String) getText(R.string.food_male_plan_10_food_57_i_9);
        food_ma_57_10 = (String) getText(R.string.food_male_plan_10_food_57_i_10);
        food_ma_57_11 = (String) getText(R.string.food_male_plan_10_food_57_i_11);
        food_male_plan_10_food_57_r_1 = (String) getText(R.string.food_male_plan_10_food_57_r_1);
        food_male_plan_10_food_57_r_2 = (String) getText(R.string.food_male_plan_10_food_57_r_2);
        food_male_plan_10_food_57_r_3 = (String) getText(R.string.food_male_plan_10_food_57_r_3);

        food_ma_58_1 = (String) getText(R.string.food_male_plan_10_food_58_i_1);
        food_ma_58_2 = (String) getText(R.string.food_male_plan_10_food_58_i_2);
        food_ma_58_3 = (String) getText(R.string.food_male_plan_10_food_58_i_3);
        food_ma_58_4 = (String) getText(R.string.food_male_plan_10_food_58_i_4);
        food_ma_58_5 = (String) getText(R.string.food_male_plan_10_food_58_i_5);
        food_ma_58_6 = (String) getText(R.string.food_male_plan_10_food_58_i_6);
        food_ma_58_7 = (String) getText(R.string.food_male_plan_10_food_58_i_7);
        food_ma_58_8 = (String) getText(R.string.food_male_plan_10_food_58_i_8);
        food_ma_58_9 = (String) getText(R.string.food_male_plan_10_food_58_i_9);
        food_ma_58_10 = (String) getText(R.string.food_male_plan_10_food_58_i_10);
        food_ma_58_11 = (String) getText(R.string.food_male_plan_10_food_58_i_11);
        food_ma_58_12 = (String) getText(R.string.food_male_plan_10_food_58_i_12);
        food_ma_58_13 = (String) getText(R.string.food_male_plan_10_food_58_i_13);
        food_ma_58_14 = (String) getText(R.string.food_male_plan_10_food_58_i_14);
        food_ma_58_15 = (String) getText(R.string.food_male_plan_10_food_58_i_15);
        food_ma_58_16 = (String) getText(R.string.food_male_plan_10_food_58_i_16);
        food_male_plan_10_food_58_r_1 = (String) getText(R.string.food_male_plan_10_food_58_r_1);
        food_male_plan_10_food_58_r_2 = (String) getText(R.string.food_male_plan_10_food_58_r_2);
        food_male_plan_10_food_58_r_3 = (String) getText(R.string.food_male_plan_10_food_58_r_3);

        food_ma_59_1 = (String) getText(R.string.food_male_plan_10_food_59_i_1);
        food_ma_59_2 = (String) getText(R.string.food_male_plan_10_food_59_i_2);
        food_ma_59_3 = (String) getText(R.string.food_male_plan_10_food_59_i_3);
        food_ma_59_4 = (String) getText(R.string.food_male_plan_10_food_59_i_4);
        food_ma_59_5 = (String) getText(R.string.food_male_plan_10_food_59_i_5);
        food_ma_59_6 = (String) getText(R.string.food_male_plan_10_food_59_i_6);
        food_male_plan_10_food_59_r_1 = (String) getText(R.string.food_male_plan_10_food_59_r_1);
        food_male_plan_10_food_59_r_2 = (String) getText(R.string.food_male_plan_10_food_59_r_2);
        food_male_plan_10_food_59_r_3 = (String) getText(R.string.food_male_plan_10_food_59_r_3);
        food_male_plan_10_food_59_r_4 = (String) getText(R.string.food_male_plan_10_food_59_r_4);

        food_ma_60_1 = (String) getText(R.string.food_male_plan_10_food_60_i_1);
        food_ma_60_2 = (String) getText(R.string.food_male_plan_10_food_60_i_2);
        food_ma_60_3 = (String) getText(R.string.food_male_plan_10_food_60_i_3);
        food_ma_60_4 = (String) getText(R.string.food_male_plan_10_food_60_i_4);
        food_ma_60_5 = (String) getText(R.string.food_male_plan_10_food_60_i_5);
        food_ma_60_6 = (String) getText(R.string.food_male_plan_10_food_60_i_6);
        food_ma_60_7 = (String) getText(R.string.food_male_plan_10_food_60_i_7);
        food_ma_60_8 = (String) getText(R.string.food_male_plan_10_food_60_i_8);
        food_male_plan_10_food_60_r_1 = (String) getText(R.string.food_male_plan_10_food_60_r_1);
        food_male_plan_10_food_60_r_2 = (String) getText(R.string.food_male_plan_10_food_60_r_2);
        food_male_plan_10_food_60_r_3 = (String) getText(R.string.food_male_plan_10_food_60_r_3);

        food_ma_61_1 = (String) getText(R.string.food_male_plan_10_food_61_i_1);
        food_ma_61_2 = (String) getText(R.string.food_male_plan_10_food_61_i_2);
        food_ma_61_3 = (String) getText(R.string.food_male_plan_10_food_61_i_3);
        food_ma_61_4 = (String) getText(R.string.food_male_plan_10_food_61_i_4);
        food_ma_61_5 = (String) getText(R.string.food_male_plan_10_food_61_i_5);
        food_ma_61_6 = (String) getText(R.string.food_male_plan_10_food_61_i_6);
        food_ma_61_7 = (String) getText(R.string.food_male_plan_10_food_61_i_7);
        food_male_plan_10_food_61_r_1 = (String) getText(R.string.food_male_plan_10_food_61_r_1);
        food_male_plan_10_food_61_r_2 = (String) getText(R.string.food_male_plan_10_food_61_r_2);
        food_male_plan_10_food_61_r_3 = (String) getText(R.string.food_male_plan_10_food_61_r_3);
        food_male_plan_10_food_61_r_4 = (String) getText(R.string.food_male_plan_10_food_61_r_4);

        food_ma_62_1 = (String) getText(R.string.food_male_plan_10_food_62_i_1);
        food_ma_62_2 = (String) getText(R.string.food_male_plan_10_food_62_i_2);
        food_ma_62_3 = (String) getText(R.string.food_male_plan_10_food_62_i_3);
        food_ma_62_4 = (String) getText(R.string.food_male_plan_10_food_62_i_4);
        food_ma_62_5 = (String) getText(R.string.food_male_plan_10_food_62_i_5);
        food_ma_62_6 = (String) getText(R.string.food_male_plan_10_food_62_i_6);
        food_ma_62_7 = (String) getText(R.string.food_male_plan_10_food_62_i_7);
        food_male_plan_10_food_62_r_1 = (String) getText(R.string.food_male_plan_10_food_62_r_1);
        food_male_plan_10_food_62_r_2 = (String) getText(R.string.food_male_plan_10_food_62_r_2);
        food_male_plan_10_food_62_r_3 = (String) getText(R.string.food_male_plan_10_food_62_r_3);
        food_male_plan_10_food_62_r_4 = (String) getText(R.string.food_male_plan_10_food_62_r_4);

        food_ma_63_1 = (String) getText(R.string.food_male_plan_10_food_63_i_1);
        food_ma_63_2 = (String) getText(R.string.food_male_plan_10_food_63_i_2);
        food_ma_63_3 = (String) getText(R.string.food_male_plan_10_food_63_i_3);
        food_ma_63_4 = (String) getText(R.string.food_male_plan_10_food_63_i_4);
        food_ma_63_5 = (String) getText(R.string.food_male_plan_10_food_63_i_5);
        food_ma_63_6 = (String) getText(R.string.food_male_plan_10_food_63_i_6);
        food_ma_63_7 = (String) getText(R.string.food_male_plan_10_food_63_i_7);
        food_ma_63_8 = (String) getText(R.string.food_male_plan_10_food_63_i_8);
        food_ma_63_9 = (String) getText(R.string.food_male_plan_10_food_63_i_9);
        food_ma_63_10 = (String) getText(R.string.food_male_plan_10_food_63_i_10);
        food_ma_63_11 = (String) getText(R.string.food_male_plan_10_food_63_i_11);
        food_male_plan_10_food_63_r_1 = (String) getText(R.string.food_male_plan_10_food_63_r_1);
        food_male_plan_10_food_63_r_2 = (String) getText(R.string.food_male_plan_10_food_63_r_2);

        food_ma_64_1 = (String) getText(R.string.food_male_plan_10_food_64_i_1);
        food_ma_64_2 = (String) getText(R.string.food_male_plan_10_food_64_i_2);
        food_ma_64_3 = (String) getText(R.string.food_male_plan_10_food_64_i_3);
        food_ma_64_4 = (String) getText(R.string.food_male_plan_10_food_64_i_4);
        food_ma_64_5 = (String) getText(R.string.food_male_plan_10_food_64_i_5);
        food_ma_64_6 = (String) getText(R.string.food_male_plan_10_food_64_i_6);
        food_ma_64_7 = (String) getText(R.string.food_male_plan_10_food_64_i_7);
        food_male_plan_10_food_64_r_1 = (String) getText(R.string.food_male_plan_10_food_64_r_1);
        food_male_plan_10_food_64_r_2 = (String) getText(R.string.food_male_plan_10_food_64_r_2);
        food_male_plan_10_food_64_r_3 = (String) getText(R.string.food_male_plan_10_food_64_r_3);

        food_ma_65_1 = (String) getText(R.string.food_male_plan_10_food_65_i_1);
        food_ma_65_2 = (String) getText(R.string.food_male_plan_10_food_65_i_2);
        food_ma_65_3 = (String) getText(R.string.food_male_plan_10_food_65_i_3);
        food_ma_65_4 = (String) getText(R.string.food_male_plan_10_food_65_i_4);
        food_ma_65_5 = (String) getText(R.string.food_male_plan_10_food_65_i_5);
        food_ma_65_6 = (String) getText(R.string.food_male_plan_10_food_65_i_6);
        food_ma_65_7 = (String) getText(R.string.food_male_plan_10_food_65_i_7);
        food_ma_65_8 = (String) getText(R.string.food_male_plan_10_food_65_i_8);
        food_ma_65_9 = (String) getText(R.string.food_male_plan_10_food_65_i_9);
        food_male_plan_10_food_65_r_1 = (String) getText(R.string.food_male_plan_10_food_65_r_1);
        food_male_plan_10_food_65_r_2 = (String) getText(R.string.food_male_plan_10_food_65_r_2);
        food_male_plan_10_food_65_r_3 = (String) getText(R.string.food_male_plan_10_food_65_r_3);
        food_male_plan_10_food_65_r_4 = (String) getText(R.string.food_male_plan_10_food_65_r_4);

        food_ma_66_1 = (String) getText(R.string.food_male_plan_10_food_66_i_1);
        food_ma_66_2 = (String) getText(R.string.food_male_plan_10_food_66_i_2);
        food_ma_66_3 = (String) getText(R.string.food_male_plan_10_food_66_i_3);
        food_ma_66_4 = (String) getText(R.string.food_male_plan_10_food_66_i_4);
        food_ma_66_5 = (String) getText(R.string.food_male_plan_10_food_66_i_5);
        food_ma_66_6 = (String) getText(R.string.food_male_plan_10_food_66_i_6);
        food_ma_66_7 = (String) getText(R.string.food_male_plan_10_food_66_i_7);
        food_ma_66_8 = (String) getText(R.string.food_male_plan_10_food_66_i_8);
        food_ma_66_9 = (String) getText(R.string.food_male_plan_10_food_66_i_9);
        food_ma_66_10 = (String) getText(R.string.food_male_plan_10_food_66_i_10);
        food_male_plan_10_food_66_r_1 = (String) getText(R.string.food_male_plan_10_food_66_r_1);
        food_male_plan_10_food_66_r_2 = (String) getText(R.string.food_male_plan_10_food_66_r_2);
        food_male_plan_10_food_66_r_3 = (String) getText(R.string.food_male_plan_10_food_66_r_3);

        food_ma_67_1 = (String) getText(R.string.food_male_plan_10_food_67_i_1);
        food_ma_67_2 = (String) getText(R.string.food_male_plan_10_food_67_i_2);
        food_ma_67_3 = (String) getText(R.string.food_male_plan_10_food_67_i_3);
        food_ma_67_4 = (String) getText(R.string.food_male_plan_10_food_67_i_4);
        food_ma_67_5 = (String) getText(R.string.food_male_plan_10_food_67_i_5);
        food_ma_67_6 = (String) getText(R.string.food_male_plan_10_food_67_i_6);
        food_ma_67_7 = (String) getText(R.string.food_male_plan_10_food_67_i_7);
        food_ma_67_8 = (String) getText(R.string.food_male_plan_10_food_67_i_8);
        food_ma_67_9 = (String) getText(R.string.food_male_plan_10_food_67_i_9);
        food_ma_67_10 = (String) getText(R.string.food_male_plan_10_food_67_i_10);
        food_ma_67_11 = (String) getText(R.string.food_male_plan_10_food_67_i_11);
        food_ma_67_12 = (String) getText(R.string.food_male_plan_10_food_67_i_12);
        food_ma_67_13 = (String) getText(R.string.food_male_plan_10_food_67_i_13);
        food_ma_67_14 = (String) getText(R.string.food_male_plan_10_food_67_i_14);
        food_male_plan_10_food_67_r_1 = (String) getText(R.string.food_male_plan_10_food_67_r_1);
        food_male_plan_10_food_67_r_2 = (String) getText(R.string.food_male_plan_10_food_67_r_2);
        food_male_plan_10_food_67_r_3 = (String) getText(R.string.food_male_plan_10_food_67_r_3);
        food_male_plan_10_food_67_r_4 = (String) getText(R.string.food_male_plan_10_food_67_r_4);

        food_ma_68_1 = (String) getText(R.string.food_male_plan_10_food_68_i_1);
        food_ma_68_2 = (String) getText(R.string.food_male_plan_10_food_68_i_2);
        food_ma_68_3 = (String) getText(R.string.food_male_plan_10_food_68_i_3);
        food_ma_68_4 = (String) getText(R.string.food_male_plan_10_food_68_i_4);
        food_ma_68_5 = (String) getText(R.string.food_male_plan_10_food_68_i_5);
        food_ma_68_6 = (String) getText(R.string.food_male_plan_10_food_68_i_6);
        food_ma_68_7 = (String) getText(R.string.food_male_plan_10_food_68_i_7);
        food_ma_68_8 = (String) getText(R.string.food_male_plan_10_food_68_i_8);
        food_ma_68_9 = (String) getText(R.string.food_male_plan_10_food_68_i_9);
        food_ma_68_10 = (String) getText(R.string.food_male_plan_10_food_68_i_10);
        food_ma_68_11 = (String) getText(R.string.food_male_plan_10_food_68_i_11);
        food_male_plan_10_food_68_r_1 = (String) getText(R.string.food_male_plan_10_food_68_r_1);
        food_male_plan_10_food_68_r_2 = (String) getText(R.string.food_male_plan_10_food_68_r_2);
        food_male_plan_10_food_68_r_3 = (String) getText(R.string.food_male_plan_10_food_68_r_3);
        food_male_plan_10_food_68_r_4 = (String) getText(R.string.food_male_plan_10_food_68_r_4);
        food_male_plan_10_food_68_r_5 = (String) getText(R.string.food_male_plan_10_food_68_r_5);
        food_male_plan_10_food_68_r_6 = (String) getText(R.string.food_male_plan_10_food_68_r_6);
        food_male_plan_10_food_68_r_7 = (String) getText(R.string.food_male_plan_10_food_68_r_7);

        food_ma_69_1 = (String) getText(R.string.food_male_plan_10_food_69_i_1);
        food_ma_69_2 = (String) getText(R.string.food_male_plan_10_food_69_i_2);
        food_ma_69_3 = (String) getText(R.string.food_male_plan_10_food_69_i_3);
        food_ma_69_4 = (String) getText(R.string.food_male_plan_10_food_69_i_4);
        food_ma_69_5 = (String) getText(R.string.food_male_plan_10_food_69_i_5);
        food_ma_69_6 = (String) getText(R.string.food_male_plan_10_food_69_i_6);
        food_ma_69_7 = (String) getText(R.string.food_male_plan_10_food_69_i_7);
        food_ma_69_8 = (String) getText(R.string.food_male_plan_10_food_69_i_8);
        food_ma_69_9 = (String) getText(R.string.food_male_plan_10_food_69_i_9);
        food_ma_69_10 = (String) getText(R.string.food_male_plan_10_food_69_i_10);
        food_male_plan_10_food_69_r_1 = (String) getText(R.string.food_male_plan_10_food_69_r_1);

        food_ma_70_1 = (String) getText(R.string.food_male_plan_10_food_70_i_1);
        food_ma_70_2 = (String) getText(R.string.food_male_plan_10_food_70_i_2);
        food_ma_70_3 = (String) getText(R.string.food_male_plan_10_food_70_i_3);
        food_ma_70_4 = (String) getText(R.string.food_male_plan_10_food_70_i_4);
        food_ma_70_5 = (String) getText(R.string.food_male_plan_10_food_70_i_5);
        food_ma_70_6 = (String) getText(R.string.food_male_plan_10_food_70_i_6);
        food_ma_70_7 = (String) getText(R.string.food_male_plan_10_food_70_i_7);
        food_ma_70_8 = (String) getText(R.string.food_male_plan_10_food_70_i_8);
        food_ma_70_9 = (String) getText(R.string.food_male_plan_10_food_70_i_9);
        food_ma_70_10 = (String) getText(R.string.food_male_plan_10_food_70_i_10);
        food_ma_70_11 = (String) getText(R.string.food_male_plan_10_food_70_i_11);
        food_male_plan_10_food_70_r_1 = (String) getText(R.string.food_male_plan_10_food_70_r_1);
        food_male_plan_10_food_70_r_2 = (String) getText(R.string.food_male_plan_10_food_70_r_2);
        food_male_plan_10_food_70_r_3 = (String) getText(R.string.food_male_plan_10_food_70_r_3);
        food_male_plan_10_food_70_r_4 = (String) getText(R.string.food_male_plan_10_food_70_r_4);

        food_ma_71_1 = (String) getText(R.string.food_male_plan_10_food_71_i_1);
        food_ma_71_2 = (String) getText(R.string.food_male_plan_10_food_71_i_2);
        food_ma_71_3 = (String) getText(R.string.food_male_plan_10_food_71_i_3);
        food_ma_71_4 = (String) getText(R.string.food_male_plan_10_food_71_i_4);
        food_ma_71_5 = (String) getText(R.string.food_male_plan_10_food_71_i_5);
        food_ma_71_6 = (String) getText(R.string.food_male_plan_10_food_71_i_6);
        food_ma_71_7 = (String) getText(R.string.food_male_plan_10_food_71_i_7);
        food_ma_71_8 = (String) getText(R.string.food_male_plan_10_food_71_i_8);
        food_male_plan_10_food_71_r_1 = (String) getText(R.string.food_male_plan_10_food_71_r_1);
        food_male_plan_10_food_71_r_2 = (String) getText(R.string.food_male_plan_10_food_71_r_2);
        food_male_plan_10_food_71_r_3 = (String) getText(R.string.food_male_plan_10_food_71_r_3);

        food_ma_72_1 = (String) getText(R.string.food_male_plan_10_food_72_i_1);
        food_ma_72_2 = (String) getText(R.string.food_male_plan_10_food_72_i_2);
        food_ma_72_3 = (String) getText(R.string.food_male_plan_10_food_72_i_3);
        food_ma_72_4 = (String) getText(R.string.food_male_plan_10_food_72_i_4);
        food_ma_72_5 = (String) getText(R.string.food_male_plan_10_food_72_i_5);
        food_ma_72_6 = (String) getText(R.string.food_male_plan_10_food_72_i_6);
        food_ma_72_7 = (String) getText(R.string.food_male_plan_10_food_72_i_7);
        food_ma_72_8 = (String) getText(R.string.food_male_plan_10_food_72_i_8);
        food_ma_72_9 = (String) getText(R.string.food_male_plan_10_food_72_i_9);
        food_male_plan_10_food_72_r_1 = (String) getText(R.string.food_male_plan_10_food_72_r_1);
        food_male_plan_10_food_72_r_2 = (String) getText(R.string.food_male_plan_10_food_72_r_2);
        food_male_plan_10_food_72_r_3 = (String) getText(R.string.food_male_plan_10_food_72_r_3);
        food_male_plan_10_food_72_r_4 = (String) getText(R.string.food_male_plan_10_food_72_r_4);

        food_ma_73_1 = (String) getText(R.string.food_male_plan_10_food_73_i_1);
        food_ma_73_2 = (String) getText(R.string.food_male_plan_10_food_73_i_2);
        food_ma_73_3 = (String) getText(R.string.food_male_plan_10_food_73_i_3);
        food_ma_73_4 = (String) getText(R.string.food_male_plan_10_food_73_i_4);
        food_ma_73_5 = (String) getText(R.string.food_male_plan_10_food_73_i_5);
        food_male_plan_10_food_73_r_1 = (String) getText(R.string.food_male_plan_10_food_73_r_1);
        food_male_plan_10_food_73_r_2 = (String) getText(R.string.food_male_plan_10_food_73_r_2);
        food_male_plan_10_food_73_r_3 = (String) getText(R.string.food_male_plan_10_food_73_r_3);

        food_ma_74_1 = (String) getText(R.string.food_male_plan_10_food_74_i_1);
        food_ma_74_2 = (String) getText(R.string.food_male_plan_10_food_74_i_2);
        food_ma_74_3 = (String) getText(R.string.food_male_plan_10_food_74_i_3);
        food_ma_74_4 = (String) getText(R.string.food_male_plan_10_food_74_i_4);
        food_ma_74_5 = (String) getText(R.string.food_male_plan_10_food_74_i_5);
        food_ma_74_6 = (String) getText(R.string.food_male_plan_10_food_74_i_6);
        food_ma_74_7 = (String) getText(R.string.food_male_plan_10_food_74_i_7);
        food_ma_74_8 = (String) getText(R.string.food_male_plan_10_food_74_i_8);
        food_ma_74_9 = (String) getText(R.string.food_male_plan_10_food_74_i_9);
        food_ma_74_10 = (String) getText(R.string.food_male_plan_10_food_74_i_10);
        food_male_plan_10_food_74_r_1 = (String) getText(R.string.food_male_plan_10_food_74_r_1);
        food_male_plan_10_food_74_r_2 = (String) getText(R.string.food_male_plan_10_food_74_r_2);
        food_male_plan_10_food_74_r_3 = (String) getText(R.string.food_male_plan_10_food_74_r_3);

        food_ma_75_1 = (String) getText(R.string.food_male_plan_10_food_75_i_1);
        food_ma_75_2 = (String) getText(R.string.food_male_plan_10_food_75_i_2);
        food_ma_75_3 = (String) getText(R.string.food_male_plan_10_food_75_i_3);
        food_ma_75_4 = (String) getText(R.string.food_male_plan_10_food_75_i_4);
        food_ma_75_5 = (String) getText(R.string.food_male_plan_10_food_75_i_5);
        food_ma_75_6 = (String) getText(R.string.food_male_plan_10_food_75_i_6);
        food_ma_75_7 = (String) getText(R.string.food_male_plan_10_food_75_i_7);
        food_ma_75_8 = (String) getText(R.string.food_male_plan_10_food_75_i_8);
        food_ma_75_9 = (String) getText(R.string.food_male_plan_10_food_75_i_9);
        food_ma_75_10 = (String) getText(R.string.food_male_plan_10_food_75_i_10);
        food_ma_75_11 = (String) getText(R.string.food_male_plan_10_food_75_i_11);
        food_ma_75_12 = (String) getText(R.string.food_male_plan_10_food_75_i_12);
        food_ma_75_13 = (String) getText(R.string.food_male_plan_10_food_75_i_13);
        food_ma_75_14 = (String) getText(R.string.food_male_plan_10_food_75_i_14);
        food_male_plan_10_food_75_r_1 = (String) getText(R.string.food_male_plan_10_food_75_r_1);
        food_male_plan_10_food_75_r_2 = (String) getText(R.string.food_male_plan_10_food_75_r_2);
        food_male_plan_10_food_75_r_3 = (String) getText(R.string.food_male_plan_10_food_75_r_3);
        food_male_plan_10_food_75_r_4 = (String) getText(R.string.food_male_plan_10_food_75_r_4);
        food_male_plan_10_food_75_r_5 = (String) getText(R.string.food_male_plan_10_food_75_r_5);
        food_male_plan_10_food_75_r_6 = (String) getText(R.string.food_male_plan_10_food_75_r_6);

        food_ma_76_1 = (String) getText(R.string.food_male_plan_10_food_76_i_1);
        food_ma_76_2 = (String) getText(R.string.food_male_plan_10_food_76_i_2);
        food_ma_76_3 = (String) getText(R.string.food_male_plan_10_food_76_i_3);
        food_ma_76_4 = (String) getText(R.string.food_male_plan_10_food_76_i_4);
        food_ma_76_5 = (String) getText(R.string.food_male_plan_10_food_76_i_5);
        food_ma_76_6 = (String) getText(R.string.food_male_plan_10_food_76_i_6);
        food_ma_76_7 = (String) getText(R.string.food_male_plan_10_food_76_i_7);
        food_ma_76_8 = (String) getText(R.string.food_male_plan_10_food_76_i_8);
        food_ma_76_9 = (String) getText(R.string.food_male_plan_10_food_76_i_9);
        food_ma_76_10 = (String) getText(R.string.food_male_plan_10_food_76_i_10);
        food_ma_76_11 = (String) getText(R.string.food_male_plan_10_food_76_i_11);
        food_ma_76_12 = (String) getText(R.string.food_male_plan_10_food_76_i_12);
        food_ma_76_13 = (String) getText(R.string.food_male_plan_10_food_76_i_13);
        food_ma_76_14 = (String) getText(R.string.food_male_plan_10_food_76_i_14);
        food_ma_76_15 = (String) getText(R.string.food_male_plan_10_food_76_i_15);
        food_ma_76_16 = (String) getText(R.string.food_male_plan_10_food_76_i_16);
        food_ma_76_17 = (String) getText(R.string.food_male_plan_10_food_76_i_17);
        food_male_plan_10_food_76_r_1 = (String) getText(R.string.food_male_plan_10_food_76_r_1);
        food_male_plan_10_food_76_r_2 = (String) getText(R.string.food_male_plan_10_food_76_r_2);
        food_male_plan_10_food_76_r_3 = (String) getText(R.string.food_male_plan_10_food_76_r_3);
        food_male_plan_10_food_76_r_4 = (String) getText(R.string.food_male_plan_10_food_76_r_4);

        food_ma_77_1 = (String) getText(R.string.food_male_plan_10_food_77_i_1);
        food_ma_77_2 = (String) getText(R.string.food_male_plan_10_food_77_i_2);
        food_ma_77_3 = (String) getText(R.string.food_male_plan_10_food_77_i_3);
        food_ma_77_4 = (String) getText(R.string.food_male_plan_10_food_77_i_4);
        food_ma_77_5 = (String) getText(R.string.food_male_plan_10_food_77_i_5);
        food_ma_77_6 = (String) getText(R.string.food_male_plan_10_food_77_i_6);
        food_ma_77_7 = (String) getText(R.string.food_male_plan_10_food_77_i_7);
        food_ma_77_8 = (String) getText(R.string.food_male_plan_10_food_77_i_8);
        food_ma_77_9 = (String) getText(R.string.food_male_plan_10_food_77_i_9);
        food_ma_77_10 = (String) getText(R.string.food_male_plan_10_food_77_i_10);
        food_ma_77_11 = (String) getText(R.string.food_male_plan_10_food_77_i_11);
        food_ma_77_12 = (String) getText(R.string.food_male_plan_10_food_77_i_12);
        food_ma_77_13 = (String) getText(R.string.food_male_plan_10_food_77_i_13);
        food_ma_77_14 = (String) getText(R.string.food_male_plan_10_food_77_i_14);
        food_ma_77_15 = (String) getText(R.string.food_male_plan_10_food_77_i_15);
        food_ma_77_16 = (String) getText(R.string.food_male_plan_10_food_77_i_16);
        food_ma_77_17 = (String) getText(R.string.food_male_plan_10_food_77_i_17);
        food_ma_77_18 = (String) getText(R.string.food_male_plan_10_food_77_i_18);
        food_ma_77_19 = (String) getText(R.string.food_male_plan_10_food_77_i_19);
        food_ma_77_20 = (String) getText(R.string.food_male_plan_10_food_77_i_20);
        food_ma_77_21 = (String) getText(R.string.food_male_plan_10_food_77_i_21);
        food_ma_77_22 = (String) getText(R.string.food_male_plan_10_food_77_i_22);
        food_ma_77_23 = (String) getText(R.string.food_male_plan_10_food_77_i_23);
        food_ma_77_24 = (String) getText(R.string.food_male_plan_10_food_77_i_24);
        food_ma_77_25 = (String) getText(R.string.food_male_plan_10_food_77_i_25);
        food_male_plan_10_food_77_r_1 = (String) getText(R.string.food_male_plan_10_food_77_r_1);
        food_male_plan_10_food_77_r_2 = (String) getText(R.string.food_male_plan_10_food_77_r_2);
        food_male_plan_10_food_77_r_3 = (String) getText(R.string.food_male_plan_10_food_77_r_3);
        food_male_plan_10_food_77_r_4 = (String) getText(R.string.food_male_plan_10_food_77_r_4);
        food_male_plan_10_food_77_r_5 = (String) getText(R.string.food_male_plan_10_food_77_r_5);
        food_male_plan_10_food_77_r_6 = (String) getText(R.string.food_male_plan_10_food_77_r_6);

        food_ma_78_1 = (String) getText(R.string.food_male_plan_10_food_78_i_1);
        food_ma_78_2 = (String) getText(R.string.food_male_plan_10_food_78_i_2);
        food_ma_78_3 = (String) getText(R.string.food_male_plan_10_food_78_i_3);
        food_ma_78_4 = (String) getText(R.string.food_male_plan_10_food_78_i_4);
        food_ma_78_5 = (String) getText(R.string.food_male_plan_10_food_78_i_5);
        food_ma_78_6 = (String) getText(R.string.food_male_plan_10_food_78_i_6);
        food_ma_78_7 = (String) getText(R.string.food_male_plan_10_food_78_i_7);
        food_ma_78_8 = (String) getText(R.string.food_male_plan_10_food_78_i_8);
        food_ma_78_9 = (String) getText(R.string.food_male_plan_10_food_78_i_9);
        food_ma_78_10 = (String) getText(R.string.food_male_plan_10_food_78_i_10);
        food_ma_78_11 = (String) getText(R.string.food_male_plan_10_food_78_i_11);
        food_ma_78_12 = (String) getText(R.string.food_male_plan_10_food_78_i_12);
        food_ma_78_13 = (String) getText(R.string.food_male_plan_10_food_78_i_13);
        food_ma_78_14 = (String) getText(R.string.food_male_plan_10_food_78_i_14);
        food_male_plan_10_food_78_r_1 = (String) getText(R.string.food_male_plan_10_food_78_r_1);
        food_male_plan_10_food_78_r_2 = (String) getText(R.string.food_male_plan_10_food_78_r_2);
        food_male_plan_10_food_78_r_3 = (String) getText(R.string.food_male_plan_10_food_78_r_3);
        food_male_plan_10_food_78_r_4 = (String) getText(R.string.food_male_plan_10_food_78_r_4);
        food_male_plan_10_food_78_r_5 = (String) getText(R.string.food_male_plan_10_food_78_r_5);
        food_male_plan_10_food_78_r_6 = (String) getText(R.string.food_male_plan_10_food_78_r_6);
        food_male_plan_10_food_78_r_7 = (String) getText(R.string.food_male_plan_10_food_78_r_7);
        food_male_plan_10_food_78_r_8 = (String) getText(R.string.food_male_plan_10_food_78_r_8);
        food_male_plan_10_food_78_r_9 = (String) getText(R.string.food_male_plan_10_food_78_r_9);

        food_ma_79_1 = (String) getText(R.string.food_male_plan_10_food_79_i_1);
        food_ma_79_2 = (String) getText(R.string.food_male_plan_10_food_79_i_2);
        food_ma_79_3 = (String) getText(R.string.food_male_plan_10_food_79_i_3);
        food_ma_79_4 = (String) getText(R.string.food_male_plan_10_food_79_i_4);
        food_ma_79_5 = (String) getText(R.string.food_male_plan_10_food_79_i_5);
        food_ma_79_6 = (String) getText(R.string.food_male_plan_10_food_79_i_6);
        food_ma_79_7 = (String) getText(R.string.food_male_plan_10_food_79_i_7);
        food_ma_79_8 = (String) getText(R.string.food_male_plan_10_food_79_i_8);
        food_ma_79_9 = (String) getText(R.string.food_male_plan_10_food_79_i_9);
        food_ma_79_10 = (String) getText(R.string.food_male_plan_10_food_79_i_10);
        food_ma_79_11 = (String) getText(R.string.food_male_plan_10_food_79_i_11);
        food_ma_79_12 = (String) getText(R.string.food_male_plan_10_food_79_i_12);
        food_ma_79_13 = (String) getText(R.string.food_male_plan_10_food_79_i_13);
        food_ma_79_14 = (String) getText(R.string.food_male_plan_10_food_79_i_14);
        food_ma_79_15 = (String) getText(R.string.food_male_plan_10_food_79_i_15);
        food_male_plan_10_food_79_r_1 = (String) getText(R.string.food_male_plan_10_food_79_r_1);
        food_male_plan_10_food_79_r_2 = (String) getText(R.string.food_male_plan_10_food_79_r_2);
        food_male_plan_10_food_79_r_3 = (String) getText(R.string.food_male_plan_10_food_79_r_3);
        food_male_plan_10_food_79_r_4 = (String) getText(R.string.food_male_plan_10_food_79_r_4);
        food_male_plan_10_food_79_r_5 = (String) getText(R.string.food_male_plan_10_food_79_r_5);

        food_ma_80_1 = (String) getText(R.string.food_male_plan_10_food_80_i_1);
        food_ma_80_2 = (String) getText(R.string.food_male_plan_10_food_80_i_2);
        food_ma_80_3 = (String) getText(R.string.food_male_plan_10_food_80_i_3);
        food_ma_80_4 = (String) getText(R.string.food_male_plan_10_food_80_i_4);
        food_ma_80_5 = (String) getText(R.string.food_male_plan_10_food_80_i_5);
        food_ma_80_6 = (String) getText(R.string.food_male_plan_10_food_80_i_6);
        food_ma_80_7 = (String) getText(R.string.food_male_plan_10_food_80_i_7);
        food_ma_80_8 = (String) getText(R.string.food_male_plan_10_food_80_i_8);
        food_ma_80_9 = (String) getText(R.string.food_male_plan_10_food_80_i_9);
        food_ma_80_10 = (String) getText(R.string.food_male_plan_10_food_80_i_10);
        food_ma_80_11 = (String) getText(R.string.food_male_plan_10_food_80_i_11);
        food_ma_80_12 = (String) getText(R.string.food_male_plan_10_food_80_i_12);
        food_ma_80_13 = (String) getText(R.string.food_male_plan_10_food_80_i_13);
        food_male_plan_10_food_80_r_1 = (String) getText(R.string.food_male_plan_10_food_80_r_1);
        food_male_plan_10_food_80_r_2 = (String) getText(R.string.food_male_plan_10_food_80_r_2);
        food_male_plan_10_food_80_r_3 = (String) getText(R.string.food_male_plan_10_food_80_r_3);
        food_male_plan_10_food_80_r_4 = (String) getText(R.string.food_male_plan_10_food_80_r_4);
        food_male_plan_10_food_80_r_5 = (String) getText(R.string.food_male_plan_10_food_80_r_5);

        food_ma_81_1 = (String) getText(R.string.food_male_plan_10_food_81_i_1);
        food_ma_81_2 = (String) getText(R.string.food_male_plan_10_food_81_i_2);
        food_ma_81_3 = (String) getText(R.string.food_male_plan_10_food_81_i_3);
        food_ma_81_4 = (String) getText(R.string.food_male_plan_10_food_81_i_4);
        food_ma_81_5 = (String) getText(R.string.food_male_plan_10_food_81_i_5);
        food_ma_81_6 = (String) getText(R.string.food_male_plan_10_food_81_i_6);
        food_ma_81_7 = (String) getText(R.string.food_male_plan_10_food_81_i_7);
        food_ma_81_8 = (String) getText(R.string.food_male_plan_10_food_81_i_8);
        food_ma_81_9 = (String) getText(R.string.food_male_plan_10_food_81_i_9);
        food_ma_81_10 = (String) getText(R.string.food_male_plan_10_food_81_i_10);
        food_ma_81_11 = (String) getText(R.string.food_male_plan_10_food_81_i_11);
        food_ma_81_12 = (String) getText(R.string.food_male_plan_10_food_81_i_12);
        food_ma_81_13 = (String) getText(R.string.food_male_plan_10_food_81_i_13);
        food_male_plan_10_food_81_r_1 = (String) getText(R.string.food_male_plan_10_food_81_r_1);
        food_male_plan_10_food_81_r_2 = (String) getText(R.string.food_male_plan_10_food_81_r_2);
        food_male_plan_10_food_81_r_3 = (String) getText(R.string.food_male_plan_10_food_81_r_3);
        food_male_plan_10_food_81_r_4 = (String) getText(R.string.food_male_plan_10_food_81_r_4);
        food_male_plan_10_food_81_r_5 = (String) getText(R.string.food_male_plan_10_food_81_r_5);
        food_male_plan_10_food_81_r_6 = (String) getText(R.string.food_male_plan_10_food_81_r_6);

        food_ma_82_1 = (String) getText(R.string.food_male_plan_10_food_82_i_1);
        food_ma_82_2 = (String) getText(R.string.food_male_plan_10_food_82_i_2);
        food_ma_82_3 = (String) getText(R.string.food_male_plan_10_food_82_i_3);
        food_ma_82_4 = (String) getText(R.string.food_male_plan_10_food_82_i_4);
        food_ma_82_5 = (String) getText(R.string.food_male_plan_10_food_82_i_5);
        food_ma_82_6 = (String) getText(R.string.food_male_plan_10_food_82_i_6);
        food_ma_82_7 = (String) getText(R.string.food_male_plan_10_food_82_i_7);
        food_ma_82_8 = (String) getText(R.string.food_male_plan_10_food_82_i_8);
        food_ma_82_9 = (String) getText(R.string.food_male_plan_10_food_82_i_9);
        food_ma_82_10 = (String) getText(R.string.food_male_plan_10_food_82_i_10);
        food_ma_82_11 = (String) getText(R.string.food_male_plan_10_food_82_i_11);
        food_male_plan_10_food_82_r_1 = (String) getText(R.string.food_male_plan_10_food_82_r_1);
        food_male_plan_10_food_82_r_2 = (String) getText(R.string.food_male_plan_10_food_82_r_2);
        food_male_plan_10_food_82_r_3 = (String) getText(R.string.food_male_plan_10_food_82_r_3);
        food_male_plan_10_food_82_r_4 = (String) getText(R.string.food_male_plan_10_food_82_r_4);

        food_ma_83_1 = (String) getText(R.string.food_male_plan_10_food_83_i_1);
        food_ma_83_2 = (String) getText(R.string.food_male_plan_10_food_83_i_2);
        food_ma_83_3 = (String) getText(R.string.food_male_plan_10_food_83_i_3);
        food_ma_83_4 = (String) getText(R.string.food_male_plan_10_food_83_i_4);
        food_ma_83_5 = (String) getText(R.string.food_male_plan_10_food_83_i_5);
        food_ma_83_6 = (String) getText(R.string.food_male_plan_10_food_83_i_6);
        food_ma_83_7 = (String) getText(R.string.food_male_plan_10_food_83_i_7);
        food_ma_83_8 = (String) getText(R.string.food_male_plan_10_food_83_i_8);
        food_ma_83_9 = (String) getText(R.string.food_male_plan_10_food_83_i_9);
        food_ma_83_10 = (String) getText(R.string.food_male_plan_10_food_83_i_10);
        food_ma_83_11 = (String) getText(R.string.food_male_plan_10_food_83_i_11);
        food_ma_83_12 = (String) getText(R.string.food_male_plan_10_food_83_i_12);
        food_ma_83_13 = (String) getText(R.string.food_male_plan_10_food_83_i_13);
        food_male_plan_10_food_83_r_1 = (String) getText(R.string.food_male_plan_10_food_83_r_1);
        food_male_plan_10_food_83_r_2 = (String) getText(R.string.food_male_plan_10_food_83_r_2);
        food_male_plan_10_food_83_r_3 = (String) getText(R.string.food_male_plan_10_food_83_r_3);
        food_male_plan_10_food_83_r_4 = (String) getText(R.string.food_male_plan_10_food_83_r_4);
        food_male_plan_10_food_83_r_5 = (String) getText(R.string.food_male_plan_10_food_83_r_5);
        food_male_plan_10_food_83_r_6 = (String) getText(R.string.food_male_plan_10_food_83_r_6);
        food_male_plan_10_food_83_r_7 = (String) getText(R.string.food_male_plan_10_food_83_r_7);
        food_male_plan_10_food_83_r_8 = (String) getText(R.string.food_male_plan_10_food_83_r_8);

        food_ma_84_1 = (String) getText(R.string.food_male_plan_10_food_84_i_1);
        food_ma_84_2 = (String) getText(R.string.food_male_plan_10_food_84_i_2);
        food_ma_84_3 = (String) getText(R.string.food_male_plan_10_food_84_i_3);
        food_ma_84_4 = (String) getText(R.string.food_male_plan_10_food_84_i_4);
        food_ma_84_5 = (String) getText(R.string.food_male_plan_10_food_84_i_5);
        food_ma_84_6 = (String) getText(R.string.food_male_plan_10_food_84_i_6);
        food_male_plan_10_food_84_r_1 = (String) getText(R.string.food_male_plan_10_food_84_r_1);
        food_male_plan_10_food_84_r_2 = (String) getText(R.string.food_male_plan_10_food_84_r_2);
        food_male_plan_10_food_84_r_3 = (String) getText(R.string.food_male_plan_10_food_84_r_3);
        food_male_plan_10_food_84_r_4 = (String) getText(R.string.food_male_plan_10_food_84_r_4);

        food_ma_101_1 = (String) getText(R.string.meal_plan_31_1);
        food_ma_101_2 = (String) getText(R.string.meal_plan_31_2);
        food_ma_101_3 = (String) getText(R.string.meal_plan_31_3);
        food_ma_101_4 = (String) getText(R.string.meal_plan_31_4);
        food_ma_101_5 = (String) getText(R.string.meal_plan_31_5);
        food_ma_101_6 = (String) getText(R.string.meal_plan_31_6);
        food_ma_101_7 = (String) getText(R.string.meal_plan_31_7);
        food_ma_101_8 = (String) getText(R.string.meal_plan_31_8);
        food_ma_101_9 = (String) getText(R.string.meal_plan_31_9);
        food_ma_101_10 = (String) getText(R.string.meal_plan_31_10);
        food_ma_101_11 = (String) getText(R.string.meal_plan_31_11);
        food_ma_101_12 = (String) getText(R.string.meal_plan_31_12);
        food_ma_101_13 = (String) getText(R.string.meal_plan_31_13);
        food_ma_101_14 = (String) getText(R.string.meal_plan_31_14);
        food_ma_101_15 = (String) getText(R.string.meal_plan_31_15);
        food_male_plan_10_food_101_r_1 = (String) getText(R.string.meal_plan_31_rec_1);
        food_male_plan_10_food_101_r_2 = (String) getText(R.string.meal_plan_31_rec_2);
        food_male_plan_10_food_101_r_3 = (String) getText(R.string.meal_plan_31_rec_3);
        food_male_plan_10_food_101_r_4 = (String) getText(R.string.meal_plan_31_rec_4);
        food_male_plan_10_food_101_r_5 = (String) getText(R.string.meal_plan_31_rec_5);
        food_male_plan_10_food_101_r_6 = (String) getText(R.string.meal_plan_31_rec_6);

        food_ma_102_1 = (String) getText(R.string.meal_plan_32_1);
        food_ma_102_2 = (String) getText(R.string.meal_plan_32_2);
        food_ma_102_3 = (String) getText(R.string.meal_plan_32_3);
        food_ma_102_4 = (String) getText(R.string.meal_plan_32_4);
        food_ma_102_5 = (String) getText(R.string.meal_plan_32_5);
        food_ma_102_6 = (String) getText(R.string.meal_plan_32_6);
        food_ma_102_7 = (String) getText(R.string.meal_plan_32_7);
        food_ma_102_8 = (String) getText(R.string.meal_plan_32_8);
        food_ma_102_9 = (String) getText(R.string.meal_plan_32_9);
        food_ma_102_10 = (String) getText(R.string.meal_plan_32_10);
        food_male_plan_10_food_102_r_1 = (String) getText(R.string.meal_plan_32_rec_1);
        food_male_plan_10_food_102_r_2 = (String) getText(R.string.meal_plan_32_rec_2);
        food_male_plan_10_food_102_r_3 = (String) getText(R.string.meal_plan_32_rec_3);
        food_male_plan_10_food_102_r_4 = (String) getText(R.string.meal_plan_32_rec_4);
        food_male_plan_10_food_102_r_5 = (String) getText(R.string.meal_plan_32_rec_5);
        food_male_plan_10_food_102_r_6 = (String) getText(R.string.meal_plan_32_rec_6);

        food_ma_103_1 = (String) getText(R.string.meal_plan_33_1);
        food_ma_103_2 = (String) getText(R.string.meal_plan_33_2);
        food_ma_103_3 = (String) getText(R.string.meal_plan_33_3);
        food_ma_103_4 = (String) getText(R.string.meal_plan_33_4);
        food_ma_103_5 = (String) getText(R.string.meal_plan_33_5);
        food_ma_103_6 = (String) getText(R.string.meal_plan_33_6);
        food_ma_103_7 = (String) getText(R.string.meal_plan_33_7);
        food_male_plan_10_food_103_r_1 = (String) getText(R.string.meal_plan_33_rec_1);
        food_male_plan_10_food_103_r_2 = (String) getText(R.string.meal_plan_33_rec_2);
        food_male_plan_10_food_103_r_3 = (String) getText(R.string.meal_plan_33_rec_3);
        food_male_plan_10_food_103_r_4 = (String) getText(R.string.meal_plan_33_rec_4);
        food_male_plan_10_food_103_r_5 = (String) getText(R.string.meal_plan_33_rec_5);
        food_male_plan_10_food_103_r_6 = (String) getText(R.string.meal_plan_33_rec_6);

        food_ma_104_1 = (String) getText(R.string.meal_plan_34_1);
        food_ma_104_2 = (String) getText(R.string.meal_plan_34_2);
        food_ma_104_3 = (String) getText(R.string.meal_plan_34_3);
        food_ma_104_4 = (String) getText(R.string.meal_plan_34_4);
        food_ma_104_5 = (String) getText(R.string.meal_plan_34_5);
        food_ma_104_6 = (String) getText(R.string.meal_plan_34_6);
        food_ma_104_7 = (String) getText(R.string.meal_plan_34_7);
        food_ma_104_8 = (String) getText(R.string.meal_plan_34_8);
        food_ma_104_9 = (String) getText(R.string.meal_plan_34_9);
        food_male_plan_10_food_104_r_1 = (String) getText(R.string.meal_plan_34_rec_1);
        food_male_plan_10_food_104_r_2 = (String) getText(R.string.meal_plan_34_rec_2);
        food_male_plan_10_food_104_r_3 = (String) getText(R.string.meal_plan_34_rec_3);
        food_male_plan_10_food_104_r_4 = (String) getText(R.string.meal_plan_34_rec_4);

        food_ma_113_1 = (String) getText(R.string.meal_plan_35_1);
        food_ma_113_2 = (String) getText(R.string.meal_plan_35_2);
        food_ma_113_3 = (String) getText(R.string.meal_plan_35_3);
        food_ma_113_4 = (String) getText(R.string.meal_plan_35_4);
        food_ma_113_5 = (String) getText(R.string.meal_plan_35_5);
        food_ma_113_6 = (String) getText(R.string.meal_plan_35_6);
        food_ma_113_7 = (String) getText(R.string.meal_plan_35_7);
        food_ma_113_8 = (String) getText(R.string.meal_plan_35_8);
        food_male_plan_10_food_113_r_1 = (String) getText(R.string.meal_plan_35_rec_1);
        food_male_plan_10_food_113_r_2 = (String) getText(R.string.meal_plan_35_rec_2);
        food_male_plan_10_food_113_r_3 = (String) getText(R.string.meal_plan_35_rec_3);
        food_male_plan_10_food_113_r_4 = (String) getText(R.string.meal_plan_35_rec_4);

        food_ma_114_1 = (String) getText(R.string.meal_plan_36_1);
        food_ma_114_2 = (String) getText(R.string.meal_plan_36_2);
        food_ma_114_3 = (String) getText(R.string.meal_plan_36_3);
        food_ma_114_4 = (String) getText(R.string.meal_plan_36_4);
        food_ma_114_5 = (String) getText(R.string.meal_plan_36_5);
        food_ma_114_6 = (String) getText(R.string.meal_plan_36_6);
        food_ma_114_7 = (String) getText(R.string.meal_plan_36_7);
        food_ma_114_8 = (String) getText(R.string.meal_plan_36_8);
        food_male_plan_10_food_114_r_1 = (String) getText(R.string.meal_plan_36_rec_1);
        food_male_plan_10_food_114_r_2 = (String) getText(R.string.meal_plan_36_rec_2);
        food_male_plan_10_food_114_r_3 = (String) getText(R.string.meal_plan_36_rec_3);

        food_ma_119_1 = (String) getText(R.string.meal_plan_37_1);
        food_ma_119_2 = (String) getText(R.string.meal_plan_37_2);
        food_ma_119_3 = (String) getText(R.string.meal_plan_37_3);
        food_ma_119_4 = (String) getText(R.string.meal_plan_37_4);
        food_male_plan_10_food_119_r_1 = (String) getText(R.string.meal_plan_37_rec_1);
        food_male_plan_10_food_119_r_2 = (String) getText(R.string.meal_plan_37_rec_2);
        food_male_plan_10_food_119_r_3 = (String) getText(R.string.meal_plan_37_rec_3);
        food_male_plan_10_food_119_r_4 = (String) getText(R.string.meal_plan_37_rec_4);

        food_ma_120_1 = (String) getText(R.string.meal_plan_38_1);
        food_ma_120_2 = (String) getText(R.string.meal_plan_38_2);
        food_ma_120_3 = (String) getText(R.string.meal_plan_38_3);
        food_ma_120_4 = (String) getText(R.string.meal_plan_38_4);
        food_ma_120_5 = (String) getText(R.string.meal_plan_38_5);
        food_ma_120_6 = (String) getText(R.string.meal_plan_38_6);
        food_ma_120_7 = (String) getText(R.string.meal_plan_38_7);
        food_ma_120_8 = (String) getText(R.string.meal_plan_38_8);
        food_ma_120_9 = (String) getText(R.string.meal_plan_38_9);
        food_ma_120_10 = (String) getText(R.string.meal_plan_38_10);
        food_ma_120_11 = (String) getText(R.string.meal_plan_38_11);
        food_male_plan_10_food_120_r_1 = (String) getText(R.string.meal_plan_38_rec_1);


        if (farsi_zaban == 1) {

            //mavad lazem


            food_ma_1 = food_ma_1_1 + System.getProperty("line.separator") + food_ma_1_2 + System.getProperty("line.separator")
                    + food_ma_1_3 + System.getProperty("line.separator") + food_ma_1_4 + System.getProperty("line.separator")
                    + food_ma_1_5 + System.getProperty("line.separator") + food_ma_1_6;

            String sh2_6 = (String) getText(R.string.food_male_plan_10_food_2_i_6);
            String sh2_7 = (String) getText(R.string.food_male_plan_10_food_2_i_7);
            String sh2_8 = (String) getText(R.string.food_male_plan_10_food_2_i_8);
            String sh2_9 = (String) getText(R.string.food_male_plan_10_food_2_i_9);
            food_ma_2 = food_ma_2_1 + System.getProperty("line.separator") + food_ma_2_2 + System.getProperty("line.separator")
                    + food_ma_2_3 + System.getProperty("line.separator") + food_ma_2_4 + System.getProperty("line.separator")
                    + food_ma_2_5 + System.getProperty("line.separator") + sh2_6 + System.getProperty("line.separator")
                    + sh2_7 + System.getProperty("line.separator") + sh2_8 + System.getProperty("line.separator")
                    + sh2_9 + System.getProperty("line.separator");

            food_ma_3 = food_ma_3_1 + System.getProperty("line.separator") + food_ma_3_2 + System.getProperty("line.separator")
                    + food_ma_3_3 + System.getProperty("line.separator") + food_ma_3_4 + System.getProperty("line.separator")
                    + food_ma_3_5 + System.getProperty("line.separator") + food_ma_3_6 + System.getProperty("line.separator")
                    + food_ma_3_7 + System.getProperty("line.separator") + food_ma_3_8 + System.getProperty("line.separator")
                    + food_ma_3_9;

            food_ma_4 = food_ma_4_1 + System.getProperty("line.separator") + food_ma_4_2 + System.getProperty("line.separator")
                    + food_ma_4_3 + System.getProperty("line.separator") + food_ma_4_4 + System.getProperty("line.separator")
                    + food_ma_4_5 + System.getProperty("line.separator") + food_ma_4_6 + System.getProperty("line.separator")
                    + food_ma_4_7;

            food_ma_5 = food_ma_5_1 + System.getProperty("line.separator") + food_ma_5_2 + System.getProperty("line.separator")
                    + food_ma_5_3 + System.getProperty("line.separator") + food_ma_5_4 + System.getProperty("line.separator")
                    + food_ma_5_5 + System.getProperty("line.separator") + food_ma_5_6 + System.getProperty("line.separator")
                    + food_ma_5_7 + System.getProperty("line.separator") + food_ma_5_8 + System.getProperty("line.separator")
                    + food_ma_5_9 + System.getProperty("line.separator") + food_ma_5_10 + System.getProperty("line.separator")
                    + food_ma_5_11 + System.getProperty("line.separator") + food_ma_5_12 + System.getProperty("line.separator")
                    + food_ma_5_13 + System.getProperty("line.separator");

            food_ma_6 = food_ma_6_1 + System.getProperty("line.separator") + food_ma_6_2 + System.getProperty("line.separator")
                    + food_ma_6_3 + System.getProperty("line.separator") + food_ma_6_4 + System.getProperty("line.separator")
                    + food_ma_6_5 + System.getProperty("line.separator") + food_ma_6_6 + System.getProperty("line.separator")
                    + food_ma_6_7 + System.getProperty("line.separator");

            food_ma_7 = food_ma_7_1 + System.getProperty("line.separator") + food_ma_7_2 + System.getProperty("line.separator")
                    + food_ma_7_3 + System.getProperty("line.separator") + food_ma_7_4 + System.getProperty("line.separator")
                    + food_ma_7_5;

            food_ma_8 = food_ma_8_1 + System.getProperty("line.separator") + food_ma_8_2 + System.getProperty("line.separator")
                    + food_ma_8_3 + System.getProperty("line.separator") + food_ma_8_4 + System.getProperty("line.separator")
                    + food_ma_8_5 + System.getProperty("line.separator") + food_ma_8_6 + System.getProperty("line.separator")
                    + food_ma_8_7 + System.getProperty("line.separator") + food_ma_8_8;

            food_ma_9 = food_ma_9_1 + System.getProperty("line.separator") + food_ma_9_2 + System.getProperty("line.separator")
                    + food_ma_9_3 + System.getProperty("line.separator") + food_ma_9_4 + System.getProperty("line.separator")
                    + food_ma_9_5 + System.getProperty("line.separator") + food_ma_9_6 + System.getProperty("line.separator")
                    + food_ma_9_7 + System.getProperty("line.separator") + food_ma_9_8;

            food_ma_10 = food_ma_10_2 + System.getProperty("line.separator")
                    + food_ma_10_4 + System.getProperty("line.separator")
                    + food_ma_10_6 + System.getProperty("line.separator")
                    + food_ma_10_8 + System.getProperty("line.separator")
                    + food_ma_10_10 + System.getProperty("line.separator")
                    + food_ma_10_12 + System.getProperty("line.separator")
                    + food_ma_10_14 + System.getProperty("line.separator")
                    + food_ma_10_16 + System.getProperty("line.separator")
                    + food_ma_10_18 + System.getProperty("line.separator");

            food_ma_11 = food_ma_11_1 + System.getProperty("line.separator") + food_ma_11_2 + System.getProperty("line.separator")
                    + food_ma_11_3 + System.getProperty("line.separator") + food_ma_11_4 + System.getProperty("line.separator")
                    + food_ma_11_5 + System.getProperty("line.separator") + food_ma_11_6 + System.getProperty("line.separator")
                    + food_ma_11_7 + System.getProperty("line.separator") + food_ma_11_8 + System.getProperty("line.separator")
                    + food_ma_11_9 + System.getProperty("line.separator") + food_ma_11_10 + System.getProperty("line.separator")
                    + food_ma_11_11 + System.getProperty("line.separator");

            food_ma_12 = food_ma_12_1 + System.getProperty("line.separator") + food_ma_12_2 + System.getProperty("line.separator")
                    + food_ma_12_3 + System.getProperty("line.separator") + food_ma_12_4 + System.getProperty("line.separator")
                    + food_ma_12_5 + System.getProperty("line.separator") + food_ma_12_6 + System.getProperty("line.separator")
                    + food_ma_12_7 + System.getProperty("line.separator") + food_ma_12_8 + System.getProperty("line.separator")
                    + food_ma_12_9 + System.getProperty("line.separator") + food_ma_12_10 + System.getProperty("line.separator")
                    + food_ma_12_11 + System.getProperty("line.separator") + food_ma_12_12 + System.getProperty("line.separator")
                    + food_ma_12_13 + System.getProperty("line.separator")
                    + food_ma_12_14 + System.getProperty("line.separator")
                    + food_ma_12_15 + System.getProperty("line.separator") + food_ma_12_16 + System.getProperty("line.separator");

            food_ma_13 = food_ma_13_2 + System.getProperty("line.separator")
                    + food_ma_13_4 + System.getProperty("line.separator")
                    + food_ma_13_6 + System.getProperty("line.separator")
                    + food_ma_13_8 + System.getProperty("line.separator")
                    + food_ma_13_10 + System.getProperty("line.separator")
                    + food_ma_13_12 + System.getProperty("line.separator")
                    + food_ma_13_14 + System.getProperty("line.separator");

            food_ma_14 = food_ma_14_4 + System.getProperty("line.separator")
                    + food_ma_14_6 + System.getProperty("line.separator")
                    + food_ma_14_10 + System.getProperty("line.separator")
                    + food_ma_14_12 + System.getProperty("line.separator")
                    + food_ma_14_14 + System.getProperty("line.separator");

            food_ma_15 = food_ma_15_2 + System.getProperty("line.separator")
                    + food_ma_15_4 + System.getProperty("line.separator")
                    + food_ma_15_6 + System.getProperty("line.separator")
                    + food_ma_15_8 + System.getProperty("line.separator")
                    + food_ma_15_10 + System.getProperty("line.separator")
                    + food_ma_15_12 + System.getProperty("line.separator")
                    + food_ma_15_14 + System.getProperty("line.separator")
                    + food_ma_15_16 + System.getProperty("line.separator")
                    + food_ma_15_18 + System.getProperty("line.separator");

            food_ma_16 = food_ma_16_1 + System.getProperty("line.separator") + food_ma_16_2 + System.getProperty("line.separator")
                    + food_ma_16_3 + System.getProperty("line.separator") + food_ma_16_4 + System.getProperty("line.separator")
                    + food_ma_16_5 + System.getProperty("line.separator") + food_ma_16_6 + System.getProperty("line.separator")
                    + food_ma_16_7 + System.getProperty("line.separator") + food_ma_16_8 + System.getProperty("line.separator")
                    + food_ma_16_9;

            food_ma_17 = food_ma_17_1 + System.getProperty("line.separator") + food_ma_17_2 + System.getProperty("line.separator")
                    + food_ma_17_3 + System.getProperty("line.separator") + food_ma_17_4 + System.getProperty("line.separator")
                    + food_ma_17_5 + System.getProperty("line.separator") + food_ma_17_6 + System.getProperty("line.separator")
                    + food_ma_17_7 + System.getProperty("line.separator") + food_ma_17_8 + System.getProperty("line.separator")
                    + food_ma_17_9 + System.getProperty("line.separator") + food_ma_17_10 + System.getProperty("line.separator")
                    + food_ma_17_11 + System.getProperty("line.separator") + food_ma_17_12;

            food_ma_18 = food_ma_18_1 + System.getProperty("line.separator") + food_ma_18_2 + System.getProperty("line.separator")
                    + food_ma_18_3 + System.getProperty("line.separator") + food_ma_18_4 + System.getProperty("line.separator")
                    + food_ma_18_5 + System.getProperty("line.separator") + food_ma_18_6 + System.getProperty("line.separator")
                    + food_ma_18_7 + System.getProperty("line.separator") + food_ma_18_8;

            food_ma_19 = food_ma_19_1 + System.getProperty("line.separator") + food_ma_19_2 + System.getProperty("line.separator")
                    + food_ma_19_3 + System.getProperty("line.separator") + food_ma_19_4 + System.getProperty("line.separator")
                    + food_ma_19_5 + System.getProperty("line.separator") + food_ma_19_6 + System.getProperty("line.separator")
                    + food_ma_19_7 + System.getProperty("line.separator") + food_ma_19_8;

            food_ma_20 = food_ma_20_1 + System.getProperty("line.separator") + food_ma_20_2 + System.getProperty("line.separator")
                    + food_ma_20_3 + System.getProperty("line.separator") + food_ma_20_4 + System.getProperty("line.separator")
                    + food_ma_20_5 + System.getProperty("line.separator") + food_ma_20_6 + System.getProperty("line.separator")
                    + food_ma_20_7 + System.getProperty("line.separator") + food_ma_20_8 + System.getProperty("line.separator")
                    + food_ma_20_9 + System.getProperty("line.separator") + food_ma_20_10;

            food_ma_21 = food_ma_21_1 + System.getProperty("line.separator") + food_ma_21_2 + System.getProperty("line.separator")
                    + food_ma_21_3 + System.getProperty("line.separator") + food_ma_21_4 + System.getProperty("line.separator")
                    + food_ma_21_5 + System.getProperty("line.separator") + food_ma_21_6 + System.getProperty("line.separator")
                    + food_ma_21_7;

            food_ma_22 = food_ma_22_1 + System.getProperty("line.separator") + food_ma_22_2 + System.getProperty("line.separator")
                    + food_ma_22_3 + System.getProperty("line.separator") + food_ma_22_4 + System.getProperty("line.separator")
                    + food_ma_22_5 + System.getProperty("line.separator");

            food_ma_23 = food_ma_23_1 + System.getProperty("line.separator") + food_ma_23_2 + System.getProperty("line.separator")
                    + food_ma_23_3 + System.getProperty("line.separator") + food_ma_23_4 + System.getProperty("line.separator")
                    + food_ma_23_5 + System.getProperty("line.separator") + food_ma_23_6;

            food_ma_24 = food_ma_24_1 + System.getProperty("line.separator") + food_ma_24_2 + System.getProperty("line.separator")
                    + food_ma_24_3 + System.getProperty("line.separator") + food_ma_24_4 + System.getProperty("line.separator")
                    + food_ma_24_5 + System.getProperty("line.separator") + food_ma_24_6 + System.getProperty("line.separator")
                    + food_ma_24_7;

            food_ma_25 = food_ma_25_1 + System.getProperty("line.separator") + food_ma_25_2 + System.getProperty("line.separator")
                    + food_ma_25_3 + System.getProperty("line.separator") + food_ma_25_4 + System.getProperty("line.separator")
                    + food_ma_25_5 + System.getProperty("line.separator") + food_ma_25_6 + System.getProperty("line.separator")
                    + food_ma_25_7 + System.getProperty("line.separator") + food_ma_25_8;

            String sh26_13 = (String) getText(R.string.food_male_plan_10_food_26_i_13);
            String sh26_14 = (String) getText(R.string.food_male_plan_10_food_26_i_14);
            food_ma_26 = food_ma_26_1 + System.getProperty("line.separator") + food_ma_26_2 + System.getProperty("line.separator")
                    + food_ma_26_3 + System.getProperty("line.separator") + food_ma_26_4 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_26_5 + System.getProperty("line.separator") + food_ma_26_6 + System.getProperty("line.separator")
                    + food_ma_26_7 + System.getProperty("line.separator") + food_ma_26_8 + System.getProperty("line.separator")
                    + food_ma_26_9 + System.getProperty("line.separator") + food_ma_26_10 + System.getProperty("line.separator")
                    + food_ma_26_11 + System.getProperty("line.separator") + food_ma_26_12 + System.getProperty("line.separator")
                    + sh26_13 + System.getProperty("line.separator") + sh26_14 + System.getProperty("line.separator");

            food_ma_27 = food_ma_27_1 + System.getProperty("line.separator") + food_ma_27_2 + System.getProperty("line.separator")
                    + food_ma_27_3 + System.getProperty("line.separator") + food_ma_27_4 + System.getProperty("line.separator")
                    + food_ma_27_5 + System.getProperty("line.separator") + food_ma_27_6 + System.getProperty("line.separator")
                    + food_ma_27_7;

            food_ma_28 = food_ma_28_1 + System.getProperty("line.separator") + food_ma_28_2 + System.getProperty("line.separator")
                    + food_ma_28_3 + System.getProperty("line.separator") + food_ma_28_4 + System.getProperty("line.separator")
                    + food_ma_28_5 + System.getProperty("line.separator") + food_ma_28_6;

            food_ma_29 = food_ma_29_1 + System.getProperty("line.separator") + food_ma_29_2 + System.getProperty("line.separator")
                    + food_ma_29_3 + System.getProperty("line.separator") + food_ma_29_4 + System.getProperty("line.separator")
                    + food_ma_29_5 + System.getProperty("line.separator") + food_ma_29_6 + System.getProperty("line.separator")
                    + food_ma_29_7 + System.getProperty("line.separator") + food_ma_29_8 + System.getProperty("line.separator")
                    + food_ma_29_9 + System.getProperty("line.separator") + food_ma_29_10 + System.getProperty("line.separator")
                    + food_ma_29_11 + System.getProperty("line.separator") + food_ma_29_12 + System.getProperty("line.separator")
                    + food_ma_29_13 + System.getProperty("line.separator") + food_ma_29_14 + System.getProperty("line.separator") + food_ma_29_15;

            food_ma_30 = food_ma_30_1 + System.getProperty("line.separator") + food_ma_30_2 + System.getProperty("line.separator")
                    + food_ma_30_3 + System.getProperty("line.separator") + food_ma_30_4 + System.getProperty("line.separator")
                    + food_ma_30_5 + System.getProperty("line.separator") + food_ma_30_6 + System.getProperty("line.separator")
                    + food_ma_30_7 + System.getProperty("line.separator") + food_ma_30_8 + System.getProperty("line.separator")
                    + food_ma_30_9;

            food_ma_31 = food_ma_31_1 + System.getProperty("line.separator") + food_ma_31_2 + System.getProperty("line.separator")
                    + food_ma_31_3 + System.getProperty("line.separator") + food_ma_31_4 + System.getProperty("line.separator")
                    + food_ma_31_5 + System.getProperty("line.separator") + food_ma_31_6 + System.getProperty("line.separator")
                    + food_ma_31_7 + System.getProperty("line.separator") + food_ma_31_8 + System.getProperty("line.separator")
                    + food_ma_31_9;

            String sh32_10 = (String) getText(R.string.food_male_plan_10_food_32_i_10);
            String sh32_11 = (String) getText(R.string.food_male_plan_10_food_32_i_11);
            String sh32_12 = (String) getText(R.string.food_male_plan_10_food_32_i_12);
            food_ma_32 = food_ma_32_1 + System.getProperty("line.separator") + food_ma_32_2 + System.getProperty("line.separator")
                    + food_ma_32_3 + System.getProperty("line.separator") + food_ma_32_4 + System.getProperty("line.separator")
                    + food_ma_32_5 + System.getProperty("line.separator") + food_ma_32_6 + System.getProperty("line.separator")
                    + food_ma_32_7 + System.getProperty("line.separator") + food_ma_32_8 + System.getProperty("line.separator")
                    + food_ma_32_9 + System.getProperty("line.separator") + sh32_10 + System.getProperty("line.separator")
                    + sh32_11 + System.getProperty("line.separator") + sh32_12 + System.getProperty("line.separator");

            food_ma_33 = food_ma_33_1 + System.getProperty("line.separator") + food_ma_33_2 + System.getProperty("line.separator")
                    + food_ma_33_3 + System.getProperty("line.separator") + food_ma_33_4 + System.getProperty("line.separator")
                    + food_ma_33_5 + System.getProperty("line.separator") + food_ma_33_6 + System.getProperty("line.separator")
                    + food_ma_33_7 + System.getProperty("line.separator") + food_ma_33_8 + System.getProperty("line.separator")
                    + food_ma_33_9;

            food_ma_34 = food_ma_34_1 + System.getProperty("line.separator") + food_ma_34_2 + System.getProperty("line.separator")
                    + food_ma_34_3 + System.getProperty("line.separator") + food_ma_34_4 + System.getProperty("line.separator")
                    + food_ma_34_5 + System.getProperty("line.separator") + food_ma_34_6 + System.getProperty("line.separator")
                    + food_ma_34_7;

            food_ma_35 = food_ma_35_1 + System.getProperty("line.separator") + food_ma_35_2 + System.getProperty("line.separator")
                    + food_ma_35_3 + System.getProperty("line.separator") + food_ma_35_4 + System.getProperty("line.separator")
                    + food_ma_35_5 + System.getProperty("line.separator") + food_ma_35_6 + System.getProperty("line.separator")
                    + food_ma_35_7 + System.getProperty("line.separator") + food_ma_35_8;

            food_ma_36 = food_ma_36_1 + System.getProperty("line.separator") + food_ma_36_2 + System.getProperty("line.separator")
                    + food_ma_36_3 + System.getProperty("line.separator") + food_ma_36_4 + System.getProperty("line.separator")
                    + food_ma_36_5 + System.getProperty("line.separator") + food_ma_36_6 + System.getProperty("line.separator")
                    + food_ma_36_7;

            String sh37_5 = (String) getText(R.string.food_male_plan_10_food_37_i_5);
            String sh37_6 = (String) getText(R.string.food_male_plan_10_food_37_i_6);
            String sh37_7 = (String) getText(R.string.food_male_plan_10_food_37_i_7);
            String sh37_8 = (String) getText(R.string.food_male_plan_10_food_37_i_8);
            String sh37_9 = (String) getText(R.string.food_male_plan_10_food_37_i_9);
            String sh37_10 = (String) getText(R.string.food_male_plan_10_food_37_i_10);
            food_ma_37 = food_ma_37_1 + System.getProperty("line.separator") + food_ma_37_2 + System.getProperty("line.separator")
                    + food_ma_37_3 + System.getProperty("line.separator") + food_ma_37_4 + System.getProperty("line.separator")
                    + sh37_5 + System.getProperty("line.separator") + sh37_6 + System.getProperty("line.separator")
                    + sh37_7 + System.getProperty("line.separator") + sh37_8 + System.getProperty("line.separator")
                    + sh37_9 + System.getProperty("line.separator") + sh37_10 + System.getProperty("line.separator");

            food_ma_38 = food_ma_38_1 + System.getProperty("line.separator") + food_ma_38_2 + System.getProperty("line.separator")
                    + food_ma_38_3 + System.getProperty("line.separator") + food_ma_38_4 + System.getProperty("line.separator")
                    + food_ma_38_5 + System.getProperty("line.separator") + food_ma_38_6 + System.getProperty("line.separator")
                    + food_ma_38_7 + System.getProperty("line.separator") + food_ma_38_8;

            String sh39_7 = (String) getText(R.string.food_male_plan_10_food_39_i_7);
            String sh39_8 = (String) getText(R.string.food_male_plan_10_food_39_i_8);
            String sh39_9 = (String) getText(R.string.food_male_plan_10_food_39_i_9);
            String sh39_10 = (String) getText(R.string.food_male_plan_10_food_39_i_10);
            food_ma_39 = food_ma_39_1 + System.getProperty("line.separator") + food_ma_39_2 + System.getProperty("line.separator")
                    + food_ma_39_3 + System.getProperty("line.separator") + food_ma_39_4 + System.getProperty("line.separator")
                    + food_ma_39_5 + System.getProperty("line.separator") + food_ma_39_6 + System.getProperty("line.separator")
                    + sh39_7 + System.getProperty("line.separator") + sh39_8 + System.getProperty("line.separator")
                    + sh39_9 + System.getProperty("line.separator") + sh39_10 + System.getProperty("line.separator");


            String sh40_8 = (String) getText(R.string.food_male_plan_10_food_40_i_8);
            String sh40_9 = (String) getText(R.string.food_male_plan_10_food_40_i_9);
            String sh40_10 = (String) getText(R.string.food_male_plan_10_food_40_i_10);
            String sh40_11 = (String) getText(R.string.food_male_plan_10_food_40_i_11);
            String sh40_12 = (String) getText(R.string.food_male_plan_10_food_40_i_12);
            String sh40_13 = (String) getText(R.string.food_male_plan_10_food_40_i_13);
            String sh40_14 = (String) getText(R.string.food_male_plan_10_food_40_i_14);
            String sh40_15 = (String) getText(R.string.food_male_plan_10_food_40_i_15);
            String sh40_16 = (String) getText(R.string.food_male_plan_10_food_40_i_16);
            String sh40_17 = (String) getText(R.string.food_male_plan_10_food_40_i_17);
            food_ma_40 = food_ma_40_1 + System.getProperty("line.separator") + food_ma_40_2 + System.getProperty("line.separator")
                    + food_ma_40_3 + System.getProperty("line.separator") + food_ma_40_4 + System.getProperty("line.separator")
                    + food_ma_40_5 + System.getProperty("line.separator") + food_ma_40_6 + System.getProperty("line.separator")
                    + food_ma_40_7 + System.getProperty("line.separator") + sh40_8 + System.getProperty("line.separator")
                    + sh40_9 + System.getProperty("line.separator") + sh40_10 + System.getProperty("line.separator")
                    + sh40_11 + System.getProperty("line.separator") + sh40_12 + System.getProperty("line.separator")
                    + sh40_13 + System.getProperty("line.separator") + sh40_14 + System.getProperty("line.separator")
                    + sh40_15 + System.getProperty("line.separator") + sh40_16 + System.getProperty("line.separator")
                    + sh40_17;

            food_ma_41 = food_ma_41_1 + System.getProperty("line.separator") + food_ma_41_2 + System.getProperty("line.separator")
                    + food_ma_41_3 + System.getProperty("line.separator") + food_ma_41_4 + System.getProperty("line.separator")
                    + food_ma_41_5 + System.getProperty("line.separator") + food_ma_41_6 + System.getProperty("line.separator")
                    + food_ma_41_7 + System.getProperty("line.separator") + food_ma_41_8 + System.getProperty("line.separator")
                    + food_ma_41_9;

            String sh42_8 = (String) getText(R.string.food_male_plan_10_food_42_i_8);
            String sh42_9 = (String) getText(R.string.food_male_plan_10_food_42_i_9);
            String sh42_10 = (String) getText(R.string.food_male_plan_10_food_42_i_10);
            food_ma_42 = food_ma_42_1 + System.getProperty("line.separator") + food_ma_42_2 + System.getProperty("line.separator")
                    + food_ma_42_3 + System.getProperty("line.separator") + food_ma_42_4 + System.getProperty("line.separator")
                    + food_ma_42_5 + System.getProperty("line.separator") + food_ma_42_6 + System.getProperty("line.separator")
                    + food_ma_42_7 + System.getProperty("line.separator") + sh42_8 + System.getProperty("line.separator")
                    + sh42_9 + System.getProperty("line.separator") + sh42_10 + System.getProperty("line.separator");

            String sh43_8 = (String) getText(R.string.food_male_plan_10_food_43_i_8);
            String sh43_9 = (String) getText(R.string.food_male_plan_10_food_43_i_9);
            String sh43_10 = (String) getText(R.string.food_male_plan_10_food_43_i_10);
            food_ma_43 = food_ma_43_1 + System.getProperty("line.separator") + food_ma_43_2 + System.getProperty("line.separator")
                    + food_ma_43_3 + System.getProperty("line.separator") + food_ma_43_4 + System.getProperty("line.separator")
                    + food_ma_43_5 + System.getProperty("line.separator") + food_ma_43_6 + System.getProperty("line.separator")
                    + food_ma_43_7 + System.getProperty("line.separator") + sh43_8 + System.getProperty("line.separator")
                    + sh43_9 + System.getProperty("line.separator") + sh43_10 + System.getProperty("line.separator");

            food_ma_44 = food_ma_44_1 + System.getProperty("line.separator") + food_ma_44_2 + System.getProperty("line.separator")
                    + food_ma_44_3 + System.getProperty("line.separator") + food_ma_44_4 + System.getProperty("line.separator")
                    + food_ma_44_5 + System.getProperty("line.separator") + food_ma_44_6 + System.getProperty("line.separator")
                    + food_ma_44_7;

            food_ma_45 = food_ma_45_1 + System.getProperty("line.separator") + food_ma_45_2 + System.getProperty("line.separator")
                    + food_ma_45_3 + System.getProperty("line.separator") + food_ma_45_4 + System.getProperty("line.separator")
                    + food_ma_45_5 + System.getProperty("line.separator") + food_ma_45_6 + System.getProperty("line.separator")
                    + food_ma_45_7 + System.getProperty("line.separator") + food_ma_45_8 + System.getProperty("line.separator")
                    + food_ma_45_9 + System.getProperty("line.separator") + food_ma_45_10;

            food_ma_46 = food_ma_46_1 + System.getProperty("line.separator") + food_ma_46_2 + System.getProperty("line.separator")
                    + food_ma_46_3 + System.getProperty("line.separator") + food_ma_46_4 + System.getProperty("line.separator")
                    + food_ma_46_5 + System.getProperty("line.separator") + food_ma_46_6 + System.getProperty("line.separator")
                    + food_ma_46_7 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_46_8 + System.getProperty("line.separator") + food_ma_46_9 + System.getProperty("line.separator") + food_ma_46_10;

            food_ma_47 = food_ma_47_1;

            String sh48_5 = (String) getText(R.string.food_male_plan_10_food_48_i_5);
            String sh48_6 = (String) getText(R.string.food_male_plan_10_food_48_i_6);
            String sh48_7 = (String) getText(R.string.food_male_plan_10_food_48_i_7);
            food_ma_48 = food_ma_48_1 + System.getProperty("line.separator") + food_ma_48_2 + System.getProperty("line.separator")
                    + food_ma_48_3 + System.getProperty("line.separator") + food_ma_48_4 + System.getProperty("line.separator")
                    + sh48_5 + System.getProperty("line.separator") + sh48_6 + System.getProperty("line.separator")
                    + sh48_7;

            food_ma_49 = food_ma_49_1 + System.getProperty("line.separator") + food_ma_49_2 + System.getProperty("line.separator")
                    + food_ma_49_3 + System.getProperty("line.separator") + food_ma_49_4 + System.getProperty("line.separator")
                    + food_ma_49_5 + System.getProperty("line.separator") + food_ma_49_6 + System.getProperty("line.separator")
                    + food_ma_49_7 + System.getProperty("line.separator") + food_ma_49_8;

            food_ma_50 = food_ma_50_1 + System.getProperty("line.separator") + food_ma_50_2 + System.getProperty("line.separator")
                    + food_ma_50_3 + System.getProperty("line.separator") + food_ma_50_4 + System.getProperty("line.separator")
                    + food_ma_50_5 + System.getProperty("line.separator") + food_ma_50_6 + System.getProperty("line.separator")
                    + food_ma_50_7 + System.getProperty("line.separator") + food_ma_50_8 + System.getProperty("line.separator")
                    + food_ma_50_9;

            String sh51_9 = (String) getText(R.string.food_male_plan_10_food_51_i_9);
            String sh51_10 = (String) getText(R.string.food_male_plan_10_food_51_i_10);
            food_ma_51 = food_ma_51_1 + System.getProperty("line.separator") + food_ma_51_2 + System.getProperty("line.separator")
                    + food_ma_51_3 + System.getProperty("line.separator") + food_ma_51_4 + System.getProperty("line.separator")
                    + food_ma_51_5 + System.getProperty("line.separator") + food_ma_51_6 + System.getProperty("line.separator")
                    + food_ma_51_7 + System.getProperty("line.separator") + food_ma_51_8 + System.getProperty("line.separator")
                    + sh51_9 + System.getProperty("line.separator") + sh51_10 + System.getProperty("line.separator");

            food_ma_52 = food_ma_52_1 + System.getProperty("line.separator") + food_ma_52_2 + System.getProperty("line.separator")
                    + food_ma_52_3 + System.getProperty("line.separator") + food_ma_52_4 + System.getProperty("line.separator")
                    + food_ma_52_5 + System.getProperty("line.separator") + food_ma_52_6 + System.getProperty("line.separator")
                    + food_ma_52_7 + System.getProperty("line.separator") + food_ma_52_8;

            String sh53_11 = (String) getText(R.string.food_male_plan_10_food_53_i_11);
            String sh53_12 = (String) getText(R.string.food_male_plan_10_food_53_i_12);
            String sh53_13 = (String) getText(R.string.food_male_plan_10_food_53_i_13);
            String sh53_14 = (String) getText(R.string.food_male_plan_10_food_53_i_14);
            String sh53_15 = (String) getText(R.string.food_male_plan_10_food_53_i_15);
            String sh53_16 = (String) getText(R.string.food_male_plan_10_food_53_i_16);
            String sh53_17 = (String) getText(R.string.food_male_plan_10_food_53_i_17);
            String sh53_18 = (String) getText(R.string.food_male_plan_10_food_53_i_18);
            String sh53_19 = (String) getText(R.string.food_male_plan_10_food_53_i_19);
            String sh53_20 = (String) getText(R.string.food_male_plan_10_food_53_i_20);
            String sh53_21 = (String) getText(R.string.food_male_plan_10_food_53_i_21);
            food_ma_53 = food_ma_53_1 + System.getProperty("line.separator") + food_ma_53_2 + System.getProperty("line.separator")
                    + food_ma_53_3 + System.getProperty("line.separator") + food_ma_53_4 + System.getProperty("line.separator")
                    + food_ma_53_5 + System.getProperty("line.separator") + food_ma_53_6 + System.getProperty("line.separator")
                    + food_ma_53_7 + System.getProperty("line.separator") + food_ma_53_8 + System.getProperty("line.separator")
                    + food_ma_53_9 + System.getProperty("line.separator") + food_ma_53_10 + System.getProperty("line.separator")
                    + sh53_11 + System.getProperty("line.separator") + sh53_12 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + sh53_13 + System.getProperty("line.separator")
                    + sh53_14 + System.getProperty("line.separator") + sh53_15 + System.getProperty("line.separator")
                    + sh53_16 + System.getProperty("line.separator") + sh53_17 + System.getProperty("line.separator")
                    + sh53_18 + System.getProperty("line.separator") + sh53_19 + System.getProperty("line.separator")
                    + sh53_20 + System.getProperty("line.separator") + sh53_21 + System.getProperty("line.separator");

            food_ma_54 = food_ma_54_1 + System.getProperty("line.separator") + food_ma_54_2 + System.getProperty("line.separator")
                    + food_ma_54_3 + System.getProperty("line.separator") + food_ma_54_4 + System.getProperty("line.separator")
                    + food_ma_54_5;

            food_ma_55 = food_ma_55_1 + System.getProperty("line.separator") + food_ma_55_2 + System.getProperty("line.separator")
                    + food_ma_55_3 + System.getProperty("line.separator") + food_ma_55_4 + System.getProperty("line.separator")
                    + food_ma_55_5 + System.getProperty("line.separator") + food_ma_55_6 + System.getProperty("line.separator")
                    + food_ma_55_7 + System.getProperty("line.separator");

            food_ma_56 = food_ma_56_1 + System.getProperty("line.separator") + food_ma_56_2 + System.getProperty("line.separator")
                    + food_ma_56_3 + System.getProperty("line.separator") + food_ma_56_4 + System.getProperty("line.separator")
                    + food_ma_56_5 + System.getProperty("line.separator") + food_ma_56_6 + System.getProperty("line.separator")
                    + food_ma_56_7 + System.getProperty("line.separator") + food_ma_56_8;

            food_ma_57 = food_ma_57_1 + System.getProperty("line.separator") + food_ma_57_2 + System.getProperty("line.separator")
                    + food_ma_57_3 + System.getProperty("line.separator") + food_ma_57_4 + System.getProperty("line.separator")
                    + food_ma_57_5 + System.getProperty("line.separator") + food_ma_57_6 + System.getProperty("line.separator")
                    + food_ma_57_7 + System.getProperty("line.separator") + food_ma_57_8;

            food_ma_58 = food_ma_58_1 + System.getProperty("line.separator") + food_ma_58_2 + System.getProperty("line.separator")
                    + food_ma_58_3 + System.getProperty("line.separator") + food_ma_58_4 + System.getProperty("line.separator")
                    + food_ma_58_5 + System.getProperty("line.separator") + food_ma_58_6 + System.getProperty("line.separator")
                    + food_ma_58_7 + System.getProperty("line.separator");

            String sh59_7 = (String) getText(R.string.food_male_plan_10_food_59_i_7);
            String sh59_8 = (String) getText(R.string.food_male_plan_10_food_59_i_8);
            String sh59_9 = (String) getText(R.string.food_male_plan_10_food_59_i_9);
            String sh59_10 = (String) getText(R.string.food_male_plan_10_food_59_i_10);
            String sh59_11 = (String) getText(R.string.food_male_plan_10_food_59_i_11);
            food_ma_59 = food_ma_59_1 + System.getProperty("line.separator") + food_ma_59_2 + System.getProperty("line.separator")
                    + food_ma_59_3 + System.getProperty("line.separator") + food_ma_59_4 + System.getProperty("line.separator")
                    + food_ma_59_5 + System.getProperty("line.separator") + food_ma_59_6 + System.getProperty("line.separator")
                    + sh59_7 + System.getProperty("line.separator") + sh59_8 + System.getProperty("line.separator")
                    + sh59_9 + System.getProperty("line.separator") + sh59_10 + System.getProperty("line.separator")
                    + sh59_11;

            String sh60_9 = (String) getText(R.string.food_male_plan_10_food_60_i_9);
            String sh60_10 = (String) getText(R.string.food_male_plan_10_food_60_i_10);
            String sh60_11 = (String) getText(R.string.food_male_plan_10_food_60_i_11);
            String sh60_12 = (String) getText(R.string.food_male_plan_10_food_60_i_12);
            String sh60_13 = (String) getText(R.string.food_male_plan_10_food_60_i_13);
            String sh60_14 = (String) getText(R.string.food_male_plan_10_food_60_i_14);
            String sh60_15 = (String) getText(R.string.food_male_plan_10_food_60_i_15);
            food_ma_60 = food_ma_60_1 + System.getProperty("line.separator") + food_ma_60_2 + System.getProperty("line.separator")
                    + food_ma_60_3 + System.getProperty("line.separator") + food_ma_60_4 + System.getProperty("line.separator")
                    + food_ma_60_5 + System.getProperty("line.separator") + food_ma_60_6 + System.getProperty("line.separator")
                    + food_ma_60_7 + System.getProperty("line.separator") + food_ma_60_8 + System.getProperty("line.separator")
                    + sh60_9 + System.getProperty("line.separator") + sh60_10 + System.getProperty("line.separator")
                    + sh60_11 + System.getProperty("line.separator") + sh60_12 + System.getProperty("line.separator")
                    + sh60_12 + System.getProperty("line.separator") + sh60_13 + System.getProperty("line.separator")
                    + sh60_14 + System.getProperty("line.separator") + sh60_15 + System.getProperty("line.separator");

            food_ma_61 = food_ma_61_1 + System.getProperty("line.separator") + food_ma_61_2 + System.getProperty("line.separator")
                    + food_ma_61_3 + System.getProperty("line.separator") + food_ma_61_4 + System.getProperty("line.separator")
                    + food_ma_61_5 + System.getProperty("line.separator") + food_ma_61_6;

            food_ma_62 = food_ma_62_1 + System.getProperty("line.separator") + food_ma_62_2 + System.getProperty("line.separator")
                    + food_ma_62_3 + System.getProperty("line.separator") + food_ma_62_4 + System.getProperty("line.separator")
                    + food_ma_62_5;

            String sh63_12 = (String) getText(R.string.food_male_plan_10_food_63_i_12);
            String sh63_13 = (String) getText(R.string.food_male_plan_10_food_63_i_13);
            String sh63_14 = (String) getText(R.string.food_male_plan_10_food_63_i_14);
            String sh63_15 = (String) getText(R.string.food_male_plan_10_food_63_i_15);
            String sh63_16 = (String) getText(R.string.food_male_plan_10_food_63_i_16);
            String sh63_17 = (String) getText(R.string.food_male_plan_10_food_63_i_17);
            String sh63_18 = (String) getText(R.string.food_male_plan_10_food_63_i_18);
            String sh63_19 = (String) getText(R.string.food_male_plan_10_food_63_i_19);
            String sh63_20 = (String) getText(R.string.food_male_plan_10_food_63_i_20);
            food_ma_63 = food_ma_63_1 + System.getProperty("line.separator") + food_ma_63_2 + System.getProperty("line.separator")
                    + food_ma_63_3 + System.getProperty("line.separator") + food_ma_63_4 + System.getProperty("line.separator")
                    + food_ma_63_5 + System.getProperty("line.separator") + food_ma_63_6 + System.getProperty("line.separator")
                    + food_ma_63_7 + System.getProperty("line.separator") + System.getProperty("line.separator") + food_ma_63_8 + System.getProperty("line.separator")
                    + food_ma_63_9 + System.getProperty("line.separator") + food_ma_63_10 + System.getProperty("line.separator")
                    + food_ma_63_11 + System.getProperty("line.separator") + sh63_12 + System.getProperty("line.separator")
                    + sh63_13 + System.getProperty("line.separator") + sh63_14 + System.getProperty("line.separator")
                    + sh63_15 + System.getProperty("line.separator") + System.getProperty("line.separator") + sh63_16 + System.getProperty("line.separator")
                    + sh63_17 + System.getProperty("line.separator") + sh63_18 + System.getProperty("line.separator")
                    + sh63_19 + System.getProperty("line.separator") + sh63_20 + System.getProperty("line.separator");

            String sh64_8 = (String) getText(R.string.food_male_plan_10_food_64_i_8);
            food_ma_64 = food_ma_64_1 + System.getProperty("line.separator") + food_ma_64_2 + System.getProperty("line.separator")
                    + food_ma_64_3 + System.getProperty("line.separator") + food_ma_64_4 + System.getProperty("line.separator")
                    + food_ma_64_5 + System.getProperty("line.separator") + food_ma_64_6 + System.getProperty("line.separator")
                    + food_ma_64_7 + System.getProperty("line.separator") + sh64_8;

            food_ma_65 = food_ma_65_1 + System.getProperty("line.separator") + food_ma_65_2 + System.getProperty("line.separator")
                    + food_ma_65_3 + System.getProperty("line.separator") + food_ma_65_4 + System.getProperty("line.separator")
                    + food_ma_65_5 + System.getProperty("line.separator") + food_ma_65_6 + System.getProperty("line.separator")
                    + food_ma_65_7;

            String sh66_11 = (String) getText(R.string.food_male_plan_10_food_66_i_11);
            food_ma_66 = food_ma_66_1 + System.getProperty("line.separator") + food_ma_66_2 + System.getProperty("line.separator")
                    + food_ma_66_3 + System.getProperty("line.separator") + food_ma_66_4 + System.getProperty("line.separator")
                    + food_ma_66_5 + System.getProperty("line.separator") + food_ma_66_6 + System.getProperty("line.separator")
                    + food_ma_66_7 + System.getProperty("line.separator") + food_ma_66_8 + System.getProperty("line.separator")
                    + food_ma_66_9 + System.getProperty("line.separator") + food_ma_66_10 + System.getProperty("line.separator") + sh66_11;

            food_ma_67 = food_ma_67_1 + System.getProperty("line.separator") + food_ma_67_2 + System.getProperty("line.separator")
                    + food_ma_67_3 + System.getProperty("line.separator") + food_ma_67_4 + System.getProperty("line.separator")
                    + food_ma_67_5 + System.getProperty("line.separator") + food_ma_67_6 + System.getProperty("line.separator")
                    + food_ma_67_7 + System.getProperty("line.separator") + food_ma_67_8 + System.getProperty("line.separator")
                    + food_ma_67_9;

            food_ma_68 = food_ma_68_1 + System.getProperty("line.separator") + food_ma_68_2 + System.getProperty("line.separator")
                    + food_ma_68_3 + System.getProperty("line.separator") + food_ma_68_4 + System.getProperty("line.separator")
                    + food_ma_68_5;

            food_ma_69 = food_ma_69_1 + System.getProperty("line.separator") + food_ma_69_2 + System.getProperty("line.separator")
                    + food_ma_69_3 + System.getProperty("line.separator") + food_ma_69_4 + System.getProperty("line.separator")
                    + food_ma_69_5 + System.getProperty("line.separator") + food_ma_69_6 + System.getProperty("line.separator")
                    + food_ma_69_7 + System.getProperty("line.separator") + food_ma_69_8 + System.getProperty("line.separator")
                    + food_ma_69_9 + System.getProperty("line.separator") + food_ma_69_10;

            food_ma_70 = food_ma_70_1 + System.getProperty("line.separator") + food_ma_70_2 + System.getProperty("line.separator")
                    + food_ma_70_3 + System.getProperty("line.separator") + food_ma_70_4 + System.getProperty("line.separator")
                    + food_ma_70_5 + System.getProperty("line.separator") + food_ma_70_6 + System.getProperty("line.separator")
                    + food_ma_70_7 + System.getProperty("line.separator") + food_ma_70_8 + System.getProperty("line.separator")
                    + food_ma_70_9 + System.getProperty("line.separator") + food_ma_70_10 + System.getProperty("line.separator")
                    + food_ma_70_11;

            String sh71_9 = (String) getText(R.string.food_male_plan_10_food_71_i_9);
            String sh71_10 = (String) getText(R.string.food_male_plan_10_food_71_i_10);
            food_ma_71 = food_ma_71_1 + System.getProperty("line.separator") + food_ma_71_2 + System.getProperty("line.separator")
                    + food_ma_71_3 + System.getProperty("line.separator") + food_ma_71_4 + System.getProperty("line.separator")
                    + food_ma_71_5 + System.getProperty("line.separator") + food_ma_71_6 + System.getProperty("line.separator")
                    + food_ma_71_7 + System.getProperty("line.separator") + food_ma_71_8 + System.getProperty("line.separator")
                    + sh71_9 + System.getProperty("line.separator") + sh71_10;

            food_ma_72 = food_ma_72_1 + System.getProperty("line.separator") + food_ma_72_2 + System.getProperty("line.separator")
                    + food_ma_72_3 + System.getProperty("line.separator") + food_ma_72_4 + System.getProperty("line.separator")
                    + food_ma_72_5 + System.getProperty("line.separator") + food_ma_72_6 + System.getProperty("line.separator")
                    + food_ma_72_7 + System.getProperty("line.separator") + food_ma_72_8 + System.getProperty("line.separator")
                    + food_ma_72_9;

            String sh73_6 = (String) getText(R.string.food_male_plan_10_food_73_i_6);
            String sh73_7 = (String) getText(R.string.food_male_plan_10_food_73_i_7);
            String sh73_8 = (String) getText(R.string.food_male_plan_10_food_73_i_8);
            food_ma_73 = food_ma_73_1 + System.getProperty("line.separator") + food_ma_73_2 + System.getProperty("line.separator")
                    + food_ma_73_3 + System.getProperty("line.separator") + food_ma_73_4 + System.getProperty("line.separator")
                    + food_ma_73_5 + System.getProperty("line.separator") + sh73_6 + System.getProperty("line.separator")
                    + sh73_7 + System.getProperty("line.separator") + sh73_8 + System.getProperty("line.separator");

            food_ma_74 = food_ma_74_1 + System.getProperty("line.separator") + food_ma_74_2 + System.getProperty("line.separator")
                    + food_ma_74_3 + System.getProperty("line.separator") + food_ma_74_4 + System.getProperty("line.separator")
                    + food_ma_74_5 + System.getProperty("line.separator") + food_ma_74_6 + System.getProperty("line.separator")
                    + food_ma_74_7;

            food_ma_75 = food_ma_75_1 + System.getProperty("line.separator")
                    + food_ma_75_2 + System.getProperty("line.separator")
                    + food_ma_75_3 + System.getProperty("line.separator") + food_ma_75_4 + System.getProperty("line.separator")
                    + food_ma_75_5 + System.getProperty("line.separator") + food_ma_75_6 + System.getProperty("line.separator")
                    + food_ma_75_7 + System.getProperty("line.separator");

            food_ma_76 = food_ma_76_1 + System.getProperty("line.separator") + food_ma_76_2 + System.getProperty("line.separator")
                    + food_ma_76_3 + System.getProperty("line.separator") + food_ma_76_4 + System.getProperty("line.separator")
                    + food_ma_76_5 + System.getProperty("line.separator") + food_ma_76_6 + System.getProperty("line.separator")
                    + food_ma_76_7 + System.getProperty("line.separator") + food_ma_76_8 + System.getProperty("line.separator")
                    + food_ma_76_9 + System.getProperty("line.separator") + food_ma_76_10 + System.getProperty("line.separator")
                    + food_ma_76_11 + System.getProperty("line.separator") + food_ma_76_12 + System.getProperty("line.separator")
                    + food_ma_76_13 + System.getProperty("line.separator") + food_ma_76_14;

            food_ma_77 = food_ma_77_1 + System.getProperty("line.separator") + food_ma_77_2 + System.getProperty("line.separator")
                    + food_ma_77_3 + System.getProperty("line.separator") + food_ma_77_4 + System.getProperty("line.separator")
                    + food_ma_77_5 + System.getProperty("line.separator") + food_ma_77_6;

            food_ma_78 = food_ma_78_1 + System.getProperty("line.separator") + food_ma_78_2 + System.getProperty("line.separator")
                    + food_ma_78_3 + System.getProperty("line.separator") + food_ma_78_4 + System.getProperty("line.separator")
                    + food_ma_78_5 + System.getProperty("line.separator") + food_ma_78_6 + System.getProperty("line.separator")
                    + food_ma_78_7 + System.getProperty("line.separator") + food_ma_78_8 + System.getProperty("line.separator")
                    + food_ma_78_9 + System.getProperty("line.separator") + food_ma_78_10 + System.getProperty("line.separator")
                    + food_ma_78_11 + System.getProperty("line.separator") + food_ma_78_12 + System.getProperty("line.separator")
                    + food_ma_78_13 + System.getProperty("line.separator") + food_ma_78_14;

            food_ma_79 = food_ma_79_1 + System.getProperty("line.separator") + food_ma_79_2 + System.getProperty("line.separator")
                    + food_ma_79_3 + System.getProperty("line.separator") + food_ma_79_4 + System.getProperty("line.separator")
                    + food_ma_79_5 + System.getProperty("line.separator") + food_ma_79_6;

            food_ma_80 = food_ma_80_1 + System.getProperty("line.separator") + food_ma_80_2 + System.getProperty("line.separator")
                    + food_ma_80_3 + System.getProperty("line.separator") + food_ma_80_4 + System.getProperty("line.separator")
                    + food_ma_80_5 + System.getProperty("line.separator") + food_ma_80_6 + System.getProperty("line.separator")
                    + food_ma_80_7 + System.getProperty("line.separator") + food_ma_80_8 + System.getProperty("line.separator")
                    + food_ma_80_9;

            food_ma_81 = food_ma_81_1 + System.getProperty("line.separator") + food_ma_81_2 + System.getProperty("line.separator")
                    + food_ma_81_3;

            food_ma_82 = food_ma_82_1 + System.getProperty("line.separator") + food_ma_82_2 + System.getProperty("line.separator")
                    + food_ma_82_3 + System.getProperty("line.separator") + food_ma_82_4 + System.getProperty("line.separator")
                    + food_ma_82_5 + System.getProperty("line.separator") + food_ma_82_6 + System.getProperty("line.separator")
                    + food_ma_82_7;

            String sh83_14 = (String) getText(R.string.food_male_plan_10_food_83_i_14);
            String sh83_15 = (String) getText(R.string.food_male_plan_10_food_83_i_15);
            food_ma_83 = food_ma_83_1 + System.getProperty("line.separator") + food_ma_83_2 + System.getProperty("line.separator")
                    + food_ma_83_3 + System.getProperty("line.separator") + food_ma_83_4 + System.getProperty("line.separator")
                    + food_ma_83_5 + System.getProperty("line.separator") + food_ma_83_6 + System.getProperty("line.separator")
                    + food_ma_83_7 + System.getProperty("line.separator") + food_ma_83_8 + System.getProperty("line.separator")
                    + food_ma_83_9 + System.getProperty("line.separator") + food_ma_83_10 + System.getProperty("line.separator")
                    + food_ma_83_11 + System.getProperty("line.separator") + food_ma_83_12 + System.getProperty("line.separator")
                    + food_ma_83_13 + System.getProperty("line.separator") + sh83_14 + System.getProperty("line.separator")
                    + sh83_15;

            String sh84_7 = (String) getText(R.string.food_male_plan_10_food_84_i_7);
            String sh84_8 = (String) getText(R.string.food_male_plan_10_food_84_i_8);
            food_ma_84 = food_ma_84_1 + System.getProperty("line.separator") + food_ma_84_2 + System.getProperty("line.separator")
                    + food_ma_84_3 + System.getProperty("line.separator") + food_ma_84_4 + System.getProperty("line.separator")
                    + food_ma_84_5 + System.getProperty("line.separator") + food_ma_84_6 + System.getProperty("line.separator")
                    + sh84_7 + System.getProperty("line.separator") + sh84_8 + System.getProperty("line.separator");

            food_ma_101 = food_ma_101_1 + System.getProperty("line.separator") + food_ma_101_2 + System.getProperty("line.separator")
                    + food_ma_101_3 + System.getProperty("line.separator") + food_ma_101_4 + System.getProperty("line.separator")
                    + food_ma_101_5 + System.getProperty("line.separator") + food_ma_101_6 + System.getProperty("line.separator")
                    + food_ma_101_7 + System.getProperty("line.separator") + food_ma_101_8 + System.getProperty("line.separator")
                    + food_ma_101_9 + System.getProperty("line.separator") + food_ma_101_10 + System.getProperty("line.separator")
                    + food_ma_101_11 + System.getProperty("line.separator") + food_ma_101_12 + System.getProperty("line.separator")
                    + food_ma_101_13 + System.getProperty("line.separator") + food_ma_101_14 + System.getProperty("line.separator")
                    + food_ma_101_15;

            food_ma_102 = food_ma_102_1 + System.getProperty("line.separator") + food_ma_102_2 + System.getProperty("line.separator")
                    + food_ma_102_3 + System.getProperty("line.separator") + food_ma_102_4 + System.getProperty("line.separator")
                    + food_ma_102_5 + System.getProperty("line.separator") + food_ma_102_6 + System.getProperty("line.separator")
                    + food_ma_102_7 + System.getProperty("line.separator") + food_ma_102_8 + System.getProperty("line.separator")
                    + food_ma_102_9 + System.getProperty("line.separator") + food_ma_102_10;

            food_ma_107 = food_ma_103_1 + System.getProperty("line.separator") + food_ma_103_2 + System.getProperty("line.separator")
                    + food_ma_103_3 + System.getProperty("line.separator") + food_ma_103_4 + System.getProperty("line.separator")
                    + food_ma_103_5 + System.getProperty("line.separator") + food_ma_103_6 + System.getProperty("line.separator")
                    + food_ma_103_7;

            food_ma_108 = food_ma_104_1 + System.getProperty("line.separator") + food_ma_104_2 + System.getProperty("line.separator")
                    + food_ma_104_3 + System.getProperty("line.separator") + food_ma_104_4 + System.getProperty("line.separator")
                    + food_ma_104_5 + System.getProperty("line.separator") + food_ma_104_6 + System.getProperty("line.separator")
                    + food_ma_104_7 + System.getProperty("line.separator") + food_ma_104_8 + System.getProperty("line.separator")
                    + food_ma_104_9;

            food_ma_113 = food_ma_113_1 + System.getProperty("line.separator") + food_ma_113_2 + System.getProperty("line.separator")
                    + food_ma_113_3 + System.getProperty("line.separator") + food_ma_113_4 + System.getProperty("line.separator")
                    + food_ma_113_5 + System.getProperty("line.separator") + food_ma_113_6 + System.getProperty("line.separator")
                    + food_ma_113_7 + System.getProperty("line.separator") + food_ma_113_8;

            food_ma_114 = food_ma_114_1 + System.getProperty("line.separator") + food_ma_114_2 + System.getProperty("line.separator")
                    + food_ma_114_3 + System.getProperty("line.separator") + food_ma_114_4 + System.getProperty("line.separator")
                    + food_ma_114_5 + System.getProperty("line.separator") + food_ma_114_6 + System.getProperty("line.separator")
                    + food_ma_114_7 + System.getProperty("line.separator") + food_ma_114_8;

            food_ma_119 = food_ma_119_1 + System.getProperty("line.separator") + food_ma_119_2 + System.getProperty("line.separator")
                    + food_ma_119_3 + System.getProperty("line.separator") + food_ma_119_4;

            food_ma_120 = food_ma_120_1 + System.getProperty("line.separator") + food_ma_120_2 + System.getProperty("line.separator")
                    + food_ma_120_3 + System.getProperty("line.separator") + food_ma_120_4 + System.getProperty("line.separator")
                    + food_ma_120_5 + System.getProperty("line.separator") + food_ma_120_6 + System.getProperty("line.separator")
                    + food_ma_120_7 + System.getProperty("line.separator") + food_ma_120_8 + System.getProperty("line.separator")
                    + food_ma_120_9 + System.getProperty("line.separator") + food_ma_120_10 + System.getProperty("line.separator")
                    + food_ma_120_11;

        } else {

            food_ma_1 = food_ma_1_1 + System.getProperty("line.separator") + food_ma_1_2 + System.getProperty("line.separator")
                    + food_ma_1_3 + System.getProperty("line.separator") + food_ma_1_4 + System.getProperty("line.separator")
                    + food_ma_1_5 + System.getProperty("line.separator") + food_ma_1_6 + System.getProperty("line.separator")
                    + food_ma_1_7 + System.getProperty("line.separator") + food_ma_1_8 + System.getProperty("line.separator")
                    + food_ma_1_9 + System.getProperty("line.separator") + food_ma_1_10 + System.getProperty("line.separator")
                    + food_ma_1_11 + System.getProperty("line.separator") + food_ma_1_12;

            food_ma_2 = food_ma_2_1 + System.getProperty("line.separator") + food_ma_2_2 + System.getProperty("line.separator")
                    + food_ma_2_3 + System.getProperty("line.separator") + food_ma_2_4 + System.getProperty("line.separator")
                    + food_ma_2_5;

            food_ma_3 = food_ma_3_1 + System.getProperty("line.separator") + food_ma_3_2 + System.getProperty("line.separator")
                    + food_ma_3_3 + System.getProperty("line.separator") + food_ma_3_4 + System.getProperty("line.separator")
                    + food_ma_3_5 + System.getProperty("line.separator") + food_ma_3_6 + System.getProperty("line.separator")
                    + food_ma_3_7 + System.getProperty("line.separator") + food_ma_3_8 + System.getProperty("line.separator")
                    + food_ma_3_9;

            food_ma_4 = food_ma_4_1 + System.getProperty("line.separator") + food_ma_4_2 + System.getProperty("line.separator")
                    + food_ma_4_3 + System.getProperty("line.separator") + food_ma_4_4 + System.getProperty("line.separator")
                    + food_ma_4_5 + System.getProperty("line.separator") + food_ma_4_6 + System.getProperty("line.separator")
                    + food_ma_4_7 + System.getProperty("line.separator") + food_ma_4_8 + System.getProperty("line.separator")
                    + food_ma_4_9 + System.getProperty("line.separator") + food_ma_4_10 + System.getProperty("line.separator")
                    + food_ma_4_11;

            food_ma_5 = food_ma_5_1 + System.getProperty("line.separator") + food_ma_5_2 + System.getProperty("line.separator")
                    + food_ma_5_3 + System.getProperty("line.separator") + food_ma_5_4 + System.getProperty("line.separator")
                    + food_ma_5_5 + System.getProperty("line.separator") + food_ma_5_6 + System.getProperty("line.separator")
                    + food_ma_5_7 + System.getProperty("line.separator") + food_ma_5_8 + System.getProperty("line.separator")
                    + food_ma_5_9 + System.getProperty("line.separator") + food_ma_5_10 + System.getProperty("line.separator")
                    + food_ma_5_11 + System.getProperty("line.separator") + food_ma_5_12 + System.getProperty("line.separator")
                    + food_ma_5_13 + System.getProperty("line.separator") + food_ma_5_14 + System.getProperty("line.separator");

            food_ma_6 = food_ma_6_1 + System.getProperty("line.separator") + food_ma_6_2 + System.getProperty("line.separator")
                    + food_ma_6_3 + System.getProperty("line.separator") + food_ma_6_4 + System.getProperty("line.separator")
                    + food_ma_6_5 + System.getProperty("line.separator") + food_ma_6_6 + System.getProperty("line.separator")
                    + food_ma_6_7 + System.getProperty("line.separator") + food_ma_6_8 + System.getProperty("line.separator")
                    + food_ma_6_9 + System.getProperty("line.separator") + food_ma_6_10 + System.getProperty("line.separator")
                    + food_ma_6_11;

            food_ma_7 = food_ma_7_1 + System.getProperty("line.separator") + food_ma_7_2 + System.getProperty("line.separator")
                    + food_ma_7_3 + System.getProperty("line.separator") + food_ma_7_4 + System.getProperty("line.separator")
                    + food_ma_7_5 + System.getProperty("line.separator") + food_ma_7_6 + System.getProperty("line.separator")
                    + food_ma_7_7 + System.getProperty("line.separator") + food_ma_7_8 + System.getProperty("line.separator")
                    + food_ma_7_9 + System.getProperty("line.separator") + food_ma_7_10 + System.getProperty("line.separator")
                    + food_ma_7_11;

            food_ma_8 = food_ma_8_1 + System.getProperty("line.separator") + food_ma_8_2 + System.getProperty("line.separator")
                    + food_ma_8_3 + System.getProperty("line.separator") + food_ma_8_4 + System.getProperty("line.separator")
                    + food_ma_8_5 + System.getProperty("line.separator") + food_ma_8_6 + System.getProperty("line.separator")
                    + food_ma_8_7 + System.getProperty("line.separator") + food_ma_8_8 + System.getProperty("line.separator")
                    + food_ma_8_9 + System.getProperty("line.separator") + food_ma_8_10 + System.getProperty("line.separator")
                    + food_ma_8_11 + System.getProperty("line.separator") + food_ma_8_12 + System.getProperty("line.separator")
                    + food_ma_8_13 + System.getProperty("line.separator") + food_ma_8_14 + System.getProperty("line.separator");

            food_ma_9 = food_ma_9_1 + System.getProperty("line.separator") + food_ma_9_2 + System.getProperty("line.separator")
                    + food_ma_9_3 + System.getProperty("line.separator") + food_ma_9_4 + System.getProperty("line.separator")
                    + food_ma_9_5 + System.getProperty("line.separator") + food_ma_9_6 + System.getProperty("line.separator")
                    + food_ma_9_7 + System.getProperty("line.separator") + food_ma_9_8;

            food_ma_10 = food_ma_10_1 + System.getProperty("line.separator") + food_ma_10_2 + System.getProperty("line.separator")
                    + food_ma_10_3 + System.getProperty("line.separator") + food_ma_10_4 + System.getProperty("line.separator")
                    + food_ma_10_5 + System.getProperty("line.separator") + food_ma_10_6 + System.getProperty("line.separator")
                    + food_ma_10_7 + System.getProperty("line.separator") + food_ma_10_8 + System.getProperty("line.separator")
                    + food_ma_10_9 + System.getProperty("line.separator") + food_ma_10_10 + System.getProperty("line.separator")
                    + System.getProperty("line.separator") + "" + food_ma_10_11
                    + System.getProperty("line.separator") + "" + System.getProperty("line.separator") +
                    food_ma_10_12 + System.getProperty("line.separator")
                    + food_ma_10_13 + System.getProperty("line.separator") + food_ma_10_14 + System.getProperty("line.separator")
                    + food_ma_10_15 + System.getProperty("line.separator") + food_ma_10_16 + System.getProperty("line.separator")
                    + food_ma_10_17 + System.getProperty("line.separator") + food_ma_10_18 + System.getProperty("line.separator")
                    + food_ma_10_19 + System.getProperty("line.separator") + food_ma_10_20 + System.getProperty("line.separator")
                    + food_ma_10_21 + System.getProperty("line.separator") + food_ma_10_22 + System.getProperty("line.separator");

            food_ma_11 = food_ma_11_1 + System.getProperty("line.separator") + food_ma_11_2 + System.getProperty("line.separator")
                    + food_ma_11_3 + System.getProperty("line.separator") + food_ma_11_4 + System.getProperty("line.separator")
                    + food_ma_11_5 + System.getProperty("line.separator") + food_ma_11_6 + System.getProperty("line.separator")
                    + food_ma_11_7 + System.getProperty("line.separator") + food_ma_11_8 + System.getProperty("line.separator")
                    + food_ma_11_9 + System.getProperty("line.separator") + food_ma_11_10 + System.getProperty("line.separator")
                    + food_ma_11_11 + System.getProperty("line.separator");

            food_ma_12 = food_ma_12_1 + System.getProperty("line.separator") + food_ma_12_2 + System.getProperty("line.separator")
                    + food_ma_12_3 + System.getProperty("line.separator") + food_ma_12_4 + System.getProperty("line.separator")
                    + food_ma_12_5 + System.getProperty("line.separator") + food_ma_12_6 + System.getProperty("line.separator")
                    + food_ma_12_7 + System.getProperty("line.separator") + food_ma_12_8 + System.getProperty("line.separator")
                    + food_ma_12_9 + System.getProperty("line.separator") + food_ma_12_10 + System.getProperty("line.separator")
                    + food_ma_12_11 + System.getProperty("line.separator") + food_ma_12_12 + System.getProperty("line.separator")
                    + food_ma_12_13 + System.getProperty("line.separator") + "" + System.getProperty("line.separator")
                    + food_ma_12_14 + System.getProperty("line.separator")
                    + food_ma_12_15 + System.getProperty("line.separator") + food_ma_12_16 + System.getProperty("line.separator")
                    + food_ma_12_17 + System.getProperty("line.separator") + food_ma_12_18 + System.getProperty("line.separator")
                    + food_ma_12_19 + System.getProperty("line.separator") + food_ma_12_20 + System.getProperty("line.separator")
                    + food_ma_12_21 + System.getProperty("line.separator") + food_ma_12_22 + System.getProperty("line.separator");

            food_ma_13 = food_ma_13_1 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_13_2 + System.getProperty("line.separator")
                    + food_ma_13_3 + System.getProperty("line.separator") + food_ma_13_4 + System.getProperty("line.separator")
                    + food_ma_13_5 + System.getProperty("line.separator") + food_ma_13_6 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_13_7 + System.getProperty("line.separator") + food_ma_13_8 + System.getProperty("line.separator")
                    + food_ma_13_9 + System.getProperty("line.separator") + food_ma_13_10 + System.getProperty("line.separator")
                    + food_ma_13_11 + System.getProperty("line.separator") + food_ma_13_12 + System.getProperty("line.separator")
                    + food_ma_13_13 + System.getProperty("line.separator") + food_ma_13_14 + System.getProperty("line.separator");

            food_ma_14 = food_ma_14_1 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_14_2 + System.getProperty("line.separator")
                    + food_ma_14_3 + System.getProperty("line.separator") + food_ma_14_4 + System.getProperty("line.separator")
                    + food_ma_14_5 + System.getProperty("line.separator") + food_ma_14_6 + System.getProperty("line.separator")
                    + food_ma_14_7 + System.getProperty("line.separator") + food_ma_14_8 + System.getProperty("line.separator")
                    + food_ma_14_9 + System.getProperty("line.separator") + food_ma_14_10 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_14_11 + System.getProperty("line.separator") + food_ma_14_12 + System.getProperty("line.separator")
                    + food_ma_14_13 + System.getProperty("line.separator") + food_ma_14_14 + System.getProperty("line.separator");

            food_ma_15 = food_ma_15_1 + System.getProperty("line.separator") + System.getProperty("line.separator") +
                    food_ma_15_2 + System.getProperty("line.separator")
                    + food_ma_15_3 + System.getProperty("line.separator") + food_ma_15_4 + System.getProperty("line.separator")
                    + food_ma_15_5 + System.getProperty("line.separator") + food_ma_15_6 + System.getProperty("line.separator")
                    + food_ma_15_7 + System.getProperty("line.separator") + System.getProperty("line.separator") + food_ma_15_8 + System.getProperty("line.separator")
                    + food_ma_15_9 + System.getProperty("line.separator") + food_ma_15_10 + System.getProperty("line.separator")
                    + food_ma_15_11 + System.getProperty("line.separator") + food_ma_15_12 + System.getProperty("line.separator")
                    + food_ma_15_13 + System.getProperty("line.separator") + food_ma_15_14 + System.getProperty("line.separator")
                    + food_ma_15_15 + System.getProperty("line.separator") + food_ma_15_16 + System.getProperty("line.separator")
                    + food_ma_15_17 + System.getProperty("line.separator") + food_ma_15_18 + System.getProperty("line.separator")
                    + food_ma_15_19 + System.getProperty("line.separator") + food_ma_15_20;

            food_ma_16 = food_ma_16_1 + System.getProperty("line.separator") + food_ma_16_2 + System.getProperty("line.separator")
                    + food_ma_16_3 + System.getProperty("line.separator") + food_ma_16_4 + System.getProperty("line.separator")
                    + food_ma_16_5 + System.getProperty("line.separator") + food_ma_16_6 + System.getProperty("line.separator")
                    + food_ma_16_7 + System.getProperty("line.separator") + food_ma_16_8 + System.getProperty("line.separator")
                    + food_ma_16_9;

            food_ma_17 = food_ma_17_1 + System.getProperty("line.separator") + food_ma_17_2 + System.getProperty("line.separator")
                    + food_ma_17_3 + System.getProperty("line.separator") + food_ma_17_4 + System.getProperty("line.separator")
                    + food_ma_17_5 + System.getProperty("line.separator") + food_ma_17_6 + System.getProperty("line.separator")
                    + food_ma_17_7 + System.getProperty("line.separator") + food_ma_17_8 + System.getProperty("line.separator")
                    + food_ma_17_9 + System.getProperty("line.separator") + food_ma_17_10 + System.getProperty("line.separator")
                    + food_ma_17_11 + System.getProperty("line.separator") + food_ma_17_12;

            food_ma_18 = food_ma_18_1 + System.getProperty("line.separator") + food_ma_18_2 + System.getProperty("line.separator")
                    + food_ma_18_3 + System.getProperty("line.separator") + food_ma_18_4 + System.getProperty("line.separator")
                    + food_ma_18_5 + System.getProperty("line.separator") + food_ma_18_6 + System.getProperty("line.separator")
                    + food_ma_18_7 + System.getProperty("line.separator") + food_ma_18_8 + System.getProperty("line.separator")
                    + food_ma_18_9 + System.getProperty("line.separator") + food_ma_18_10 + System.getProperty("line.separator")
                    + food_ma_18_11;

            food_ma_19 = food_ma_19_1 + System.getProperty("line.separator") + food_ma_19_2 + System.getProperty("line.separator")
                    + food_ma_19_3 + System.getProperty("line.separator") + food_ma_19_4 + System.getProperty("line.separator")
                    + food_ma_19_5 + System.getProperty("line.separator") + food_ma_19_6 + System.getProperty("line.separator")
                    + food_ma_19_7 + System.getProperty("line.separator") + food_ma_19_8;

            food_ma_20 = food_ma_20_1 + System.getProperty("line.separator") + food_ma_20_2 + System.getProperty("line.separator")
                    + food_ma_20_3 + System.getProperty("line.separator") + food_ma_20_4 + System.getProperty("line.separator")
                    + food_ma_20_5 + System.getProperty("line.separator") + food_ma_20_6 + System.getProperty("line.separator")
                    + food_ma_20_7 + System.getProperty("line.separator") + food_ma_20_8 + System.getProperty("line.separator")
                    + food_ma_20_9 + System.getProperty("line.separator") + food_ma_20_10;

            food_ma_21 = food_ma_21_1 + System.getProperty("line.separator") + food_ma_21_2 + System.getProperty("line.separator")
                    + food_ma_21_3 + System.getProperty("line.separator") + food_ma_21_4 + System.getProperty("line.separator")
                    + food_ma_21_5 + System.getProperty("line.separator") + food_ma_21_6 + System.getProperty("line.separator")
                    + food_ma_21_7;

            food_ma_22 = food_ma_22_1 + System.getProperty("line.separator") + food_ma_22_2 + System.getProperty("line.separator")
                    + food_ma_22_3 + System.getProperty("line.separator") + food_ma_22_4 + System.getProperty("line.separator")
                    + food_ma_22_5 + System.getProperty("line.separator") + food_ma_22_6 + System.getProperty("line.separator")
                    + food_ma_22_7;

            food_ma_23 = food_ma_23_1 + System.getProperty("line.separator") + food_ma_23_2 + System.getProperty("line.separator")
                    + food_ma_23_3 + System.getProperty("line.separator") + food_ma_23_4 + System.getProperty("line.separator")
                    + food_ma_23_5 + System.getProperty("line.separator") + food_ma_23_6;

            food_ma_24 = food_ma_24_1 + System.getProperty("line.separator") + food_ma_24_2 + System.getProperty("line.separator")
                    + food_ma_24_3 + System.getProperty("line.separator") + food_ma_24_4 + System.getProperty("line.separator")
                    + food_ma_24_5 + System.getProperty("line.separator") + food_ma_24_6 + System.getProperty("line.separator")
                    + food_ma_24_7;

            food_ma_25 = food_ma_25_1 + System.getProperty("line.separator") + food_ma_25_2 + System.getProperty("line.separator")
                    + food_ma_25_3 + System.getProperty("line.separator") + food_ma_25_4 + System.getProperty("line.separator")
                    + food_ma_25_5 + System.getProperty("line.separator") + food_ma_25_6 + System.getProperty("line.separator")
                    + food_ma_25_7 + System.getProperty("line.separator") + food_ma_25_8;

            food_ma_26 = food_ma_26_1 + System.getProperty("line.separator") + food_ma_26_2 + System.getProperty("line.separator")
                    + food_ma_26_3 + System.getProperty("line.separator") + food_ma_26_4 + System.getProperty("line.separator")
                    + food_ma_26_5 + System.getProperty("line.separator") + food_ma_26_6 + System.getProperty("line.separator")
                    + food_ma_26_7 + System.getProperty("line.separator") + food_ma_26_8 + System.getProperty("line.separator")
                    + food_ma_26_9 + System.getProperty("line.separator") + food_ma_26_10 + System.getProperty("line.separator")
                    + food_ma_26_11 + System.getProperty("line.separator") + food_ma_26_12;

            food_ma_27 = food_ma_27_1 + System.getProperty("line.separator") + food_ma_27_2 + System.getProperty("line.separator")
                    + food_ma_27_3 + System.getProperty("line.separator") + food_ma_27_4 + System.getProperty("line.separator")
                    + food_ma_27_5 + System.getProperty("line.separator") + food_ma_27_6 + System.getProperty("line.separator")
                    + food_ma_27_7;

            food_ma_28 = food_ma_28_1 + System.getProperty("line.separator") + food_ma_28_2 + System.getProperty("line.separator")
                    + food_ma_28_3 + System.getProperty("line.separator") + food_ma_28_4 + System.getProperty("line.separator")
                    + food_ma_28_5 + System.getProperty("line.separator") + food_ma_28_6 + System.getProperty("line.separator")
                    + food_ma_28_7;

            food_ma_29 = food_ma_29_1 + System.getProperty("line.separator") + food_ma_29_2 + System.getProperty("line.separator")
                    + food_ma_29_3 + System.getProperty("line.separator") + food_ma_29_4 + System.getProperty("line.separator")
                    + food_ma_29_5 + System.getProperty("line.separator") + food_ma_29_6 + System.getProperty("line.separator")
                    + food_ma_29_7 + System.getProperty("line.separator") + food_ma_29_8 + System.getProperty("line.separator")
                    + food_ma_29_9 + System.getProperty("line.separator") + food_ma_29_10 + System.getProperty("line.separator")
                    + food_ma_29_11 + System.getProperty("line.separator") + food_ma_29_12 + System.getProperty("line.separator")
                    + food_ma_29_13 + System.getProperty("line.separator") + food_ma_29_14 + System.getProperty("line.separator") + food_ma_29_15;

            food_ma_30 = food_ma_30_1 + System.getProperty("line.separator") + food_ma_30_2 + System.getProperty("line.separator")
                    + food_ma_30_3 + System.getProperty("line.separator") + food_ma_30_4 + System.getProperty("line.separator")
                    + food_ma_30_5 + System.getProperty("line.separator") + food_ma_30_6 + System.getProperty("line.separator")
                    + food_ma_30_7 + System.getProperty("line.separator") + food_ma_30_8 + System.getProperty("line.separator")
                    + food_ma_30_9 + System.getProperty("line.separator") + food_ma_30_10 + System.getProperty("line.separator")
                    + food_ma_30_11 + System.getProperty("line.separator") + food_ma_30_12;

            food_ma_31 = food_ma_31_1 + System.getProperty("line.separator") + food_ma_31_2 + System.getProperty("line.separator")
                    + food_ma_31_3 + System.getProperty("line.separator") + food_ma_31_4 + System.getProperty("line.separator")
                    + food_ma_31_5 + System.getProperty("line.separator") + food_ma_31_6 + System.getProperty("line.separator")
                    + food_ma_31_7 + System.getProperty("line.separator") + food_ma_31_8 + System.getProperty("line.separator")
                    + food_ma_31_9 + System.getProperty("line.separator") + food_ma_31_10 + System.getProperty("line.separator")
                    + food_ma_31_11;

            food_ma_32 = food_ma_32_1 + System.getProperty("line.separator") + food_ma_32_2 + System.getProperty("line.separator")
                    + food_ma_32_3 + System.getProperty("line.separator") + food_ma_32_4 + System.getProperty("line.separator")
                    + food_ma_32_5 + System.getProperty("line.separator") + food_ma_32_6 + System.getProperty("line.separator")
                    + food_ma_32_7 + System.getProperty("line.separator") + food_ma_32_8 + System.getProperty("line.separator")
                    + food_ma_32_9;

            food_ma_33 = food_ma_33_1 + System.getProperty("line.separator") + food_ma_33_2 + System.getProperty("line.separator")
                    + food_ma_33_3 + System.getProperty("line.separator") + food_ma_33_4 + System.getProperty("line.separator")
                    + food_ma_33_5 + System.getProperty("line.separator") + food_ma_33_6 + System.getProperty("line.separator")
                    + food_ma_33_7 + System.getProperty("line.separator") + food_ma_33_8 + System.getProperty("line.separator")
                    + food_ma_33_9;

            food_ma_34 = food_ma_34_1 + System.getProperty("line.separator") + food_ma_34_2 + System.getProperty("line.separator")
                    + food_ma_34_3 + System.getProperty("line.separator") + food_ma_34_4 + System.getProperty("line.separator")
                    + food_ma_34_5 + System.getProperty("line.separator") + food_ma_34_6 + System.getProperty("line.separator")
                    + food_ma_34_7;

            food_ma_35 = food_ma_35_1 + System.getProperty("line.separator") + food_ma_35_2 + System.getProperty("line.separator")
                    + food_ma_35_3 + System.getProperty("line.separator") + food_ma_35_4 + System.getProperty("line.separator")
                    + food_ma_35_5 + System.getProperty("line.separator") + food_ma_35_6 + System.getProperty("line.separator")
                    + food_ma_35_7 + System.getProperty("line.separator") + food_ma_35_8;

            food_ma_36 = food_ma_36_1 + System.getProperty("line.separator") + food_ma_36_2 + System.getProperty("line.separator")
                    + food_ma_36_3 + System.getProperty("line.separator") + food_ma_36_4 + System.getProperty("line.separator")
                    + food_ma_36_5 + System.getProperty("line.separator") + food_ma_36_6 + System.getProperty("line.separator")
                    + food_ma_36_7 + System.getProperty("line.separator") + food_ma_36_8 + System.getProperty("line.separator")
                    + food_ma_36_9 + System.getProperty("line.separator") + food_ma_36_10;

            food_ma_37 = food_ma_37_1 + System.getProperty("line.separator") + food_ma_37_2 + System.getProperty("line.separator")
                    + food_ma_37_3 + System.getProperty("line.separator") + food_ma_37_4;

            food_ma_38 = food_ma_38_1 + System.getProperty("line.separator") + food_ma_38_2 + System.getProperty("line.separator")
                    + food_ma_38_3 + System.getProperty("line.separator") + food_ma_38_4 + System.getProperty("line.separator")
                    + food_ma_38_5 + System.getProperty("line.separator") + food_ma_38_6 + System.getProperty("line.separator")
                    + food_ma_38_7 + System.getProperty("line.separator") + food_ma_38_8 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_38_9 + System.getProperty("line.separator") + food_ma_38_10 + System.getProperty("line.separator")
                    + food_ma_38_11 + System.getProperty("line.separator") + food_ma_38_12 + System.getProperty("line.separator")
                    + food_ma_38_13 + System.getProperty("line.separator") + food_ma_38_14;

            food_ma_39 = food_ma_39_1 + System.getProperty("line.separator") + food_ma_39_2 + System.getProperty("line.separator")
                    + food_ma_39_3 + System.getProperty("line.separator") + food_ma_39_4 + System.getProperty("line.separator")
                    + food_ma_39_5 + System.getProperty("line.separator") + food_ma_39_6;

            food_ma_40 = food_ma_40_1 + System.getProperty("line.separator") + food_ma_40_2 + System.getProperty("line.separator")
                    + food_ma_40_3 + System.getProperty("line.separator") + food_ma_40_4 + System.getProperty("line.separator")
                    + food_ma_40_5 + System.getProperty("line.separator") + food_ma_40_6 + System.getProperty("line.separator")
                    + food_ma_40_7;

            food_ma_41 = food_ma_41_1 + System.getProperty("line.separator") + food_ma_41_2 + System.getProperty("line.separator")
                    + food_ma_41_3 + System.getProperty("line.separator") + food_ma_41_4 + System.getProperty("line.separator")
                    + food_ma_41_5 + System.getProperty("line.separator") + food_ma_41_6 + System.getProperty("line.separator")
                    + food_ma_41_7 + System.getProperty("line.separator") + food_ma_41_8 + System.getProperty("line.separator")
                    + food_ma_41_9 + System.getProperty("line.separator") + food_ma_41_10 + System.getProperty("line.separator")
                    + food_ma_41_11 + System.getProperty("line.separator") + food_ma_41_12;

            food_ma_42 = food_ma_42_1 + System.getProperty("line.separator") + food_ma_42_2 + System.getProperty("line.separator")
                    + food_ma_42_3 + System.getProperty("line.separator") + food_ma_42_4 + System.getProperty("line.separator")
                    + food_ma_42_5 + System.getProperty("line.separator") + food_ma_42_6 + System.getProperty("line.separator")
                    + food_ma_42_7;

            food_ma_43 = food_ma_43_1 + System.getProperty("line.separator") + food_ma_43_2 + System.getProperty("line.separator")
                    + food_ma_43_3 + System.getProperty("line.separator") + food_ma_43_4 + System.getProperty("line.separator")
                    + food_ma_43_5 + System.getProperty("line.separator") + food_ma_43_6 + System.getProperty("line.separator")
                    + food_ma_43_7;

            food_ma_44 = food_ma_44_1 + System.getProperty("line.separator") + food_ma_44_2 + System.getProperty("line.separator")
                    + food_ma_44_3 + System.getProperty("line.separator") + food_ma_44_4 + System.getProperty("line.separator")
                    + food_ma_44_5 + System.getProperty("line.separator") + food_ma_44_6 + System.getProperty("line.separator")
                    + food_ma_44_7 + System.getProperty("line.separator") + food_ma_44_8 + System.getProperty("line.separator")
                    + food_ma_44_9;

            food_ma_45 = food_ma_45_1 + System.getProperty("line.separator") + food_ma_45_2 + System.getProperty("line.separator")
                    + food_ma_45_3 + System.getProperty("line.separator") + food_ma_45_4 + System.getProperty("line.separator")
                    + food_ma_45_5 + System.getProperty("line.separator") + food_ma_45_6 + System.getProperty("line.separator")
                    + food_ma_45_7 + System.getProperty("line.separator") + food_ma_45_8 + System.getProperty("line.separator")
                    + food_ma_45_9 + System.getProperty("line.separator") + food_ma_45_10;

            food_ma_46 = food_ma_46_1 + System.getProperty("line.separator") + food_ma_46_2 + System.getProperty("line.separator")
                    + food_ma_46_3 + System.getProperty("line.separator") + food_ma_46_4 + System.getProperty("line.separator")
                    + food_ma_46_5 + System.getProperty("line.separator") + food_ma_46_6 + System.getProperty("line.separator")
                    + food_ma_46_7 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_46_8 + System.getProperty("line.separator") + food_ma_46_9 + System.getProperty("line.separator") + food_ma_46_10;

            food_ma_47 = food_ma_47_1 + System.getProperty("line.separator") + food_ma_47_2 + System.getProperty("line.separator")
                    + food_ma_47_3 + System.getProperty("line.separator") + food_ma_47_4;

            food_ma_48 = food_ma_48_1 + System.getProperty("line.separator") + food_ma_48_2 + System.getProperty("line.separator")
                    + food_ma_48_3 + System.getProperty("line.separator") + food_ma_48_4;

            food_ma_49 = food_ma_49_1 + System.getProperty("line.separator") + food_ma_49_2 + System.getProperty("line.separator")
                    + food_ma_49_3 + System.getProperty("line.separator") + food_ma_49_4 + System.getProperty("line.separator")
                    + food_ma_49_5 + System.getProperty("line.separator") + food_ma_49_6 + System.getProperty("line.separator")
                    + food_ma_49_7 + System.getProperty("line.separator") + food_ma_49_8;

            food_ma_50 = food_ma_50_1 + System.getProperty("line.separator") + food_ma_50_2 + System.getProperty("line.separator")
                    + food_ma_50_3 + System.getProperty("line.separator") + food_ma_50_4 + System.getProperty("line.separator")
                    + food_ma_50_5 + System.getProperty("line.separator") + food_ma_50_6 + System.getProperty("line.separator")
                    + food_ma_50_7 + System.getProperty("line.separator") + food_ma_50_8 + System.getProperty("line.separator")
                    + food_ma_50_9 + System.getProperty("line.separator") + food_ma_50_10;

            food_ma_51 = food_ma_51_1 + System.getProperty("line.separator") + food_ma_51_2 + System.getProperty("line.separator")
                    + food_ma_51_3 + System.getProperty("line.separator") + food_ma_51_4 + System.getProperty("line.separator")
                    + food_ma_51_5 + System.getProperty("line.separator") + food_ma_51_6 + System.getProperty("line.separator")
                    + food_ma_51_7 + System.getProperty("line.separator") + food_ma_51_8;

            food_ma_52 = food_ma_52_1 + System.getProperty("line.separator") + food_ma_52_2 + System.getProperty("line.separator")
                    + food_ma_52_3 + System.getProperty("line.separator") + food_ma_52_4 + System.getProperty("line.separator")
                    + food_ma_52_5 + System.getProperty("line.separator") + food_ma_52_6 + System.getProperty("line.separator")
                    + food_ma_52_7 + System.getProperty("line.separator") + food_ma_52_8 + System.getProperty("line.separator")
                    + food_ma_52_9;

            food_ma_53 = food_ma_53_1 + System.getProperty("line.separator") + food_ma_53_2 + System.getProperty("line.separator")
                    + food_ma_53_3 + System.getProperty("line.separator") + food_ma_53_4 + System.getProperty("line.separator")
                    + food_ma_53_5 + System.getProperty("line.separator") + food_ma_53_6 + System.getProperty("line.separator")
                    + food_ma_53_7 + System.getProperty("line.separator") + food_ma_53_8 + System.getProperty("line.separator")
                    + food_ma_53_9 + System.getProperty("line.separator") + food_ma_53_10;

            food_ma_54 = food_ma_54_1 + System.getProperty("line.separator") + food_ma_54_2 + System.getProperty("line.separator")
                    + food_ma_54_3 + System.getProperty("line.separator") + food_ma_54_4 + System.getProperty("line.separator")
                    + food_ma_54_5 + System.getProperty("line.separator") + food_ma_54_6 + System.getProperty("line.separator")
                    + food_ma_54_7 + System.getProperty("line.separator") + food_ma_54_8 + System.getProperty("line.separator")
                    + food_ma_54_9;

            food_ma_55 = food_ma_55_1 + System.getProperty("line.separator") + food_ma_55_2 + System.getProperty("line.separator")
                    + food_ma_55_3 + System.getProperty("line.separator") + food_ma_55_4 + System.getProperty("line.separator")
                    + food_ma_55_5 + System.getProperty("line.separator") + System.getProperty("line.separator") + food_ma_55_6 + System.getProperty("line.separator")
                    + food_ma_55_7 + System.getProperty("line.separator") + food_ma_55_8 + System.getProperty("line.separator")
                    + food_ma_55_9 + System.getProperty("line.separator") + food_ma_55_10 + System.getProperty("line.separator")
                    + food_ma_55_11 + System.getProperty("line.separator") + food_ma_55_12 + System.getProperty("line.separator");

            food_ma_56 = food_ma_56_1 + System.getProperty("line.separator") + food_ma_56_2 + System.getProperty("line.separator")
                    + food_ma_56_3 + System.getProperty("line.separator") + food_ma_56_4 + System.getProperty("line.separator")
                    + food_ma_56_5 + System.getProperty("line.separator") + food_ma_56_6 + System.getProperty("line.separator")
                    + food_ma_56_7 + System.getProperty("line.separator") + food_ma_56_8 + System.getProperty("line.separator")
                    + food_ma_56_9;

            food_ma_57 = food_ma_57_1 + System.getProperty("line.separator") + food_ma_57_2 + System.getProperty("line.separator")
                    + food_ma_57_3 + System.getProperty("line.separator") + food_ma_57_4 + System.getProperty("line.separator")
                    + food_ma_57_5 + System.getProperty("line.separator") + food_ma_57_6 + System.getProperty("line.separator")
                    + food_ma_57_7 + System.getProperty("line.separator") + food_ma_57_8 + System.getProperty("line.separator")
                    + food_ma_57_9 + System.getProperty("line.separator") + food_ma_57_10 + System.getProperty("line.separator")
                    + food_ma_57_11;

            food_ma_58 = food_ma_58_1 + System.getProperty("line.separator") + food_ma_58_2 + System.getProperty("line.separator")
                    + food_ma_58_3 + System.getProperty("line.separator") + food_ma_58_4 + System.getProperty("line.separator")
                    + food_ma_58_5 + System.getProperty("line.separator") + food_ma_58_6 + System.getProperty("line.separator")
                    + food_ma_58_7 + System.getProperty("line.separator") + food_ma_58_8 + System.getProperty("line.separator")
                    + food_ma_58_9 + System.getProperty("line.separator") + food_ma_58_10 + System.getProperty("line.separator")
                    + food_ma_58_11 + System.getProperty("line.separator") + food_ma_58_12 + System.getProperty("line.separator")
                    + food_ma_58_13 + System.getProperty("line.separator") + food_ma_58_14 + System.getProperty("line.separator")
                    + food_ma_58_15 + System.getProperty("line.separator") + food_ma_58_16 + System.getProperty("line.separator");

            food_ma_59 = food_ma_59_1 + System.getProperty("line.separator") + food_ma_59_2 + System.getProperty("line.separator")
                    + food_ma_59_3 + System.getProperty("line.separator") + food_ma_59_4 + System.getProperty("line.separator")
                    + food_ma_59_5 + System.getProperty("line.separator") + food_ma_59_6;

            food_ma_60 = food_ma_60_1 + System.getProperty("line.separator") + food_ma_60_2 + System.getProperty("line.separator")
                    + food_ma_60_3 + System.getProperty("line.separator") + food_ma_60_4 + System.getProperty("line.separator")
                    + food_ma_60_5 + System.getProperty("line.separator") + food_ma_60_6 + System.getProperty("line.separator")
                    + food_ma_60_7 + System.getProperty("line.separator") + food_ma_60_8;

            food_ma_61 = food_ma_61_1 + System.getProperty("line.separator") + food_ma_61_2 + System.getProperty("line.separator")
                    + food_ma_61_3 + System.getProperty("line.separator") + food_ma_61_4 + System.getProperty("line.separator")
                    + food_ma_61_5 + System.getProperty("line.separator") + food_ma_61_6 + System.getProperty("line.separator")
                    + food_ma_61_7;

            food_ma_62 = food_ma_62_1 + System.getProperty("line.separator") + food_ma_62_2 + System.getProperty("line.separator")
                    + food_ma_62_3 + System.getProperty("line.separator") + food_ma_62_4 + System.getProperty("line.separator")
                    + food_ma_62_5 + System.getProperty("line.separator") + food_ma_62_6 + System.getProperty("line.separator")
                    + food_ma_62_7;

            food_ma_63 = food_ma_63_1 + System.getProperty("line.separator") + food_ma_63_2 + System.getProperty("line.separator")
                    + food_ma_63_3 + System.getProperty("line.separator") + food_ma_63_4 + System.getProperty("line.separator")
                    + food_ma_63_5 + System.getProperty("line.separator") + food_ma_63_6 + System.getProperty("line.separator")
                    + food_ma_63_7 + System.getProperty("line.separator") + food_ma_63_8 + System.getProperty("line.separator")
                    + food_ma_63_9 + System.getProperty("line.separator") + food_ma_63_10 + System.getProperty("line.separator")
                    + food_ma_63_11;

            food_ma_64 = food_ma_64_1 + System.getProperty("line.separator") + food_ma_64_2 + System.getProperty("line.separator")
                    + food_ma_64_3 + System.getProperty("line.separator") + food_ma_64_4 + System.getProperty("line.separator")
                    + food_ma_64_5 + System.getProperty("line.separator") + food_ma_64_6 + System.getProperty("line.separator")
                    + food_ma_64_7;

            food_ma_65 = food_ma_65_1 + System.getProperty("line.separator") + food_ma_65_2 + System.getProperty("line.separator")
                    + food_ma_65_3 + System.getProperty("line.separator") + food_ma_65_4 + System.getProperty("line.separator")
                    + food_ma_65_5 + System.getProperty("line.separator") + food_ma_65_6 + System.getProperty("line.separator")
                    + food_ma_65_7 + System.getProperty("line.separator") + food_ma_65_8 + System.getProperty("line.separator")
                    + food_ma_65_9;

            food_ma_66 = food_ma_66_1 + System.getProperty("line.separator") + food_ma_66_2 + System.getProperty("line.separator")
                    + food_ma_66_3 + System.getProperty("line.separator") + food_ma_66_4 + System.getProperty("line.separator")
                    + food_ma_66_5 + System.getProperty("line.separator") + food_ma_66_6 + System.getProperty("line.separator")
                    + food_ma_66_7 + System.getProperty("line.separator") + food_ma_66_8 + System.getProperty("line.separator")
                    + food_ma_66_9 + System.getProperty("line.separator") + food_ma_66_10;

            food_ma_67 = food_ma_67_1 + System.getProperty("line.separator") + food_ma_67_2 + System.getProperty("line.separator")
                    + food_ma_67_3 + System.getProperty("line.separator") + food_ma_67_4 + System.getProperty("line.separator")
                    + food_ma_67_5 + System.getProperty("line.separator") + food_ma_67_6 + System.getProperty("line.separator")
                    + food_ma_67_7 + System.getProperty("line.separator") + food_ma_67_8 + System.getProperty("line.separator")
                    + food_ma_67_9 + System.getProperty("line.separator") + food_ma_67_10 + System.getProperty("line.separator")
                    + food_ma_67_11 + System.getProperty("line.separator") + food_ma_67_12 + System.getProperty("line.separator")
                    + food_ma_67_13 + System.getProperty("line.separator") + food_ma_67_14 + System.getProperty("line.separator");

            food_ma_68 = food_ma_68_1 + System.getProperty("line.separator") + food_ma_68_2 + System.getProperty("line.separator")
                    + food_ma_68_3 + System.getProperty("line.separator") + food_ma_68_4 + System.getProperty("line.separator")
                    + food_ma_68_5 + System.getProperty("line.separator") + food_ma_68_6 + System.getProperty("line.separator")
                    + food_ma_68_7 + System.getProperty("line.separator") + food_ma_68_8 + System.getProperty("line.separator")
                    + food_ma_68_9 + System.getProperty("line.separator") + food_ma_68_10 + System.getProperty("line.separator")
                    + food_ma_68_11;

            food_ma_69 = food_ma_69_1 + System.getProperty("line.separator") + food_ma_69_2 + System.getProperty("line.separator")
                    + food_ma_69_3 + System.getProperty("line.separator") + food_ma_69_4 + System.getProperty("line.separator")
                    + food_ma_69_5 + System.getProperty("line.separator") + food_ma_69_6 + System.getProperty("line.separator")
                    + food_ma_69_7 + System.getProperty("line.separator") + food_ma_69_8 + System.getProperty("line.separator")
                    + food_ma_69_9 + System.getProperty("line.separator") + food_ma_69_10;

            food_ma_70 = food_ma_70_1 + System.getProperty("line.separator") + food_ma_70_2 + System.getProperty("line.separator")
                    + food_ma_70_3 + System.getProperty("line.separator") + food_ma_70_4 + System.getProperty("line.separator")
                    + food_ma_70_5 + System.getProperty("line.separator") + food_ma_70_6 + System.getProperty("line.separator")
                    + food_ma_70_7 + System.getProperty("line.separator") + food_ma_70_8 + System.getProperty("line.separator")
                    + food_ma_70_9 + System.getProperty("line.separator") + food_ma_70_10 + System.getProperty("line.separator")
                    + food_ma_70_11;

            food_ma_71 = food_ma_71_1 + System.getProperty("line.separator") + food_ma_71_2 + System.getProperty("line.separator")
                    + food_ma_71_3 + System.getProperty("line.separator") + food_ma_71_4 + System.getProperty("line.separator")
                    + food_ma_71_5 + System.getProperty("line.separator") + food_ma_71_6 + System.getProperty("line.separator")
                    + food_ma_71_7 + System.getProperty("line.separator") + food_ma_71_8;

            food_ma_72 = food_ma_72_1 + System.getProperty("line.separator") + food_ma_72_2 + System.getProperty("line.separator")
                    + food_ma_72_3 + System.getProperty("line.separator") + food_ma_72_4 + System.getProperty("line.separator")
                    + food_ma_72_5 + System.getProperty("line.separator") + food_ma_72_6 + System.getProperty("line.separator")
                    + food_ma_72_7 + System.getProperty("line.separator") + food_ma_72_8 + System.getProperty("line.separator")
                    + food_ma_72_9;

            food_ma_73 = food_ma_73_1 + System.getProperty("line.separator") + food_ma_73_2 + System.getProperty("line.separator")
                    + food_ma_73_3 + System.getProperty("line.separator") + food_ma_73_4 + System.getProperty("line.separator")
                    + food_ma_73_5;

            food_ma_74 = food_ma_74_1 + System.getProperty("line.separator") + food_ma_74_2 + System.getProperty("line.separator")
                    + food_ma_74_3 + System.getProperty("line.separator") + food_ma_74_4 + System.getProperty("line.separator")
                    + food_ma_74_5 + System.getProperty("line.separator") + food_ma_74_6 + System.getProperty("line.separator")
                    + food_ma_74_7 + System.getProperty("line.separator") + food_ma_74_8 + System.getProperty("line.separator")
                    + food_ma_74_9 + System.getProperty("line.separator") + food_ma_74_10;

            food_ma_75 = food_ma_75_1 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_75_2 + System.getProperty("line.separator")
                    + food_ma_75_3 + System.getProperty("line.separator") + food_ma_75_4 + System.getProperty("line.separator")
                    + food_ma_75_5 + System.getProperty("line.separator") + food_ma_75_6 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_75_7 + System.getProperty("line.separator") + food_ma_75_8 + System.getProperty("line.separator")
                    + food_ma_75_9 + System.getProperty("line.separator") + food_ma_75_10 + System.getProperty("line.separator")
                    + food_ma_75_11 + System.getProperty("line.separator") + food_ma_75_12 + System.getProperty("line.separator")
                    + food_ma_75_13 + System.getProperty("line.separator") + food_ma_75_14 + System.getProperty("line.separator");

            food_ma_76 = food_ma_76_1 + System.getProperty("line.separator") + food_ma_76_2 + System.getProperty("line.separator")
                    + food_ma_76_3 + System.getProperty("line.separator") + food_ma_76_4 + System.getProperty("line.separator")
                    + food_ma_76_5 + System.getProperty("line.separator") + food_ma_76_6 + System.getProperty("line.separator")
                    + food_ma_76_7 + System.getProperty("line.separator") + food_ma_76_8 + System.getProperty("line.separator")
                    + food_ma_76_9 + System.getProperty("line.separator") + food_ma_76_10 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_76_11 + System.getProperty("line.separator") + food_ma_76_12 + System.getProperty("line.separator")
                    + food_ma_76_13 + System.getProperty("line.separator") + food_ma_76_14 + System.getProperty("line.separator")
                    + food_ma_76_15 + System.getProperty("line.separator") + food_ma_76_16 + System.getProperty("line.separator")
                    + food_ma_76_17;

            food_ma_77 = food_ma_77_1 + System.getProperty("line.separator") + System.getProperty("line.separator") + food_ma_77_2 + System.getProperty("line.separator")
                    + food_ma_77_3 + System.getProperty("line.separator") + food_ma_77_4 + System.getProperty("line.separator")
                    + food_ma_77_5 + System.getProperty("line.separator") + food_ma_77_6 + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + food_ma_77_7 + System.getProperty("line.separator") + food_ma_77_8 + System.getProperty("line.separator")
                    + food_ma_77_9 + System.getProperty("line.separator") + food_ma_77_10 + System.getProperty("line.separator")
                    + food_ma_77_11 + System.getProperty("line.separator") + food_ma_77_12 + System.getProperty("line.separator")
                    + food_ma_77_13 + System.getProperty("line.separator") + food_ma_77_14 + System.getProperty("line.separator")
                    + food_ma_77_15 + System.getProperty("line.separator") + food_ma_77_16 + System.getProperty("line.separator")
                    + food_ma_77_17;

            food_ma_78 = food_ma_78_1 + System.getProperty("line.separator") + food_ma_78_2 + System.getProperty("line.separator")
                    + food_ma_78_3 + System.getProperty("line.separator") + food_ma_78_4 + System.getProperty("line.separator")
                    + food_ma_78_5 + System.getProperty("line.separator") + food_ma_78_6 + System.getProperty("line.separator")
                    + food_ma_78_7 + System.getProperty("line.separator") + food_ma_78_8 + System.getProperty("line.separator")
                    + food_ma_78_9 + System.getProperty("line.separator") + food_ma_78_10 + System.getProperty("line.separator")
                    + food_ma_78_11 + System.getProperty("line.separator") + food_ma_78_12 + System.getProperty("line.separator")
                    + food_ma_78_13 + System.getProperty("line.separator") + food_ma_78_14;

            food_ma_79 = food_ma_79_1 + System.getProperty("line.separator") + food_ma_79_2 + System.getProperty("line.separator")
                    + food_ma_79_3 + System.getProperty("line.separator") + food_ma_79_4 + System.getProperty("line.separator")
                    + food_ma_79_5 + System.getProperty("line.separator") + food_ma_79_6 + System.getProperty("line.separator")
                    + food_ma_79_7 + System.getProperty("line.separator") + food_ma_79_8 + System.getProperty("line.separator")
                    + food_ma_79_9 + System.getProperty("line.separator") + food_ma_79_10 + System.getProperty("line.separator")
                    + food_ma_79_11 + System.getProperty("line.separator") + food_ma_79_12 + System.getProperty("line.separator")
                    + food_ma_79_13 + System.getProperty("line.separator") + food_ma_79_14 + System.getProperty("line.separator")
                    + food_ma_79_15;

            food_ma_80 = food_ma_80_1 + System.getProperty("line.separator") + food_ma_80_2 + System.getProperty("line.separator")
                    + food_ma_80_3 + System.getProperty("line.separator") + food_ma_80_4 + System.getProperty("line.separator")
                    + food_ma_80_5 + System.getProperty("line.separator") + food_ma_80_6 + System.getProperty("line.separator")
                    + food_ma_80_7 + System.getProperty("line.separator") + food_ma_80_8 + System.getProperty("line.separator")
                    + food_ma_80_9 + System.getProperty("line.separator") + food_ma_80_10 + System.getProperty("line.separator")
                    + food_ma_80_11 + System.getProperty("line.separator") + food_ma_80_12 + System.getProperty("line.separator")
                    + food_ma_80_13;

            food_ma_81 = food_ma_81_1 + System.getProperty("line.separator") + food_ma_81_2 + System.getProperty("line.separator")
                    + food_ma_81_3 + System.getProperty("line.separator") + food_ma_81_4 + System.getProperty("line.separator")
                    + food_ma_81_5 + System.getProperty("line.separator") + food_ma_81_6 + System.getProperty("line.separator")
                    + food_ma_81_7 + System.getProperty("line.separator") + food_ma_81_8 + System.getProperty("line.separator")
                    + food_ma_81_9 + System.getProperty("line.separator") + food_ma_81_10 + System.getProperty("line.separator")
                    + food_ma_81_11 + System.getProperty("line.separator") + food_ma_81_12 + System.getProperty("line.separator")
                    + food_ma_81_13;

            food_ma_82 = food_ma_82_1 + System.getProperty("line.separator") + food_ma_82_2 + System.getProperty("line.separator")
                    + food_ma_82_3 + System.getProperty("line.separator") + food_ma_82_4 + System.getProperty("line.separator")
                    + food_ma_82_5 + System.getProperty("line.separator") + food_ma_82_6 + System.getProperty("line.separator")
                    + food_ma_82_7 + System.getProperty("line.separator") + food_ma_82_8 + System.getProperty("line.separator")
                    + food_ma_82_9 + System.getProperty("line.separator") + food_ma_82_10 + System.getProperty("line.separator")
                    + food_ma_82_11;

            food_ma_83 = food_ma_83_1 + System.getProperty("line.separator") + food_ma_83_2 + System.getProperty("line.separator")
                    + food_ma_83_3 + System.getProperty("line.separator") + food_ma_83_4 + System.getProperty("line.separator")
                    + food_ma_83_5 + System.getProperty("line.separator") + food_ma_83_6 + System.getProperty("line.separator")
                    + food_ma_83_7 + System.getProperty("line.separator") + food_ma_83_8 + System.getProperty("line.separator")
                    + food_ma_83_9 + System.getProperty("line.separator") + food_ma_83_10 + System.getProperty("line.separator")
                    + food_ma_83_11 + System.getProperty("line.separator") + food_ma_83_12 + System.getProperty("line.separator")
                    + food_ma_83_13;

            food_ma_84 = food_ma_84_1 + System.getProperty("line.separator") + food_ma_84_2 + System.getProperty("line.separator")
                    + food_ma_84_3 + System.getProperty("line.separator") + food_ma_84_4 + System.getProperty("line.separator")
                    + food_ma_84_5 + System.getProperty("line.separator") + food_ma_84_6;

            food_ma_101 = food_ma_101_1 + System.getProperty("line.separator") + food_ma_101_2 + System.getProperty("line.separator")
                    + food_ma_101_3 + System.getProperty("line.separator") + food_ma_101_4 + System.getProperty("line.separator")
                    + food_ma_101_5 + System.getProperty("line.separator") + food_ma_101_6 + System.getProperty("line.separator")
                    + food_ma_101_7 + System.getProperty("line.separator") + food_ma_101_8 + System.getProperty("line.separator")
                    + food_ma_101_9 + System.getProperty("line.separator") + food_ma_101_10 + System.getProperty("line.separator")
                    + food_ma_101_11 + System.getProperty("line.separator") + food_ma_101_12 + System.getProperty("line.separator")
                    + food_ma_101_13 + System.getProperty("line.separator") + food_ma_101_14 + System.getProperty("line.separator")
                    + food_ma_101_15;

            food_ma_102 = food_ma_102_1 + System.getProperty("line.separator") + food_ma_102_2 + System.getProperty("line.separator")
                    + food_ma_102_3 + System.getProperty("line.separator") + food_ma_102_4 + System.getProperty("line.separator")
                    + food_ma_102_5 + System.getProperty("line.separator") + food_ma_102_6 + System.getProperty("line.separator")
                    + food_ma_102_7 + System.getProperty("line.separator") + food_ma_102_8 + System.getProperty("line.separator")
                    + food_ma_102_9 + System.getProperty("line.separator") + food_ma_102_10;

            food_ma_107 = food_ma_103_1 + System.getProperty("line.separator") + food_ma_103_2 + System.getProperty("line.separator")
                    + food_ma_103_3 + System.getProperty("line.separator") + food_ma_103_4 + System.getProperty("line.separator")
                    + food_ma_103_5 + System.getProperty("line.separator") + food_ma_103_6 + System.getProperty("line.separator")
                    + food_ma_103_7;

            food_ma_108 = food_ma_104_1 + System.getProperty("line.separator") + food_ma_104_2 + System.getProperty("line.separator")
                    + food_ma_104_3 + System.getProperty("line.separator") + food_ma_104_4 + System.getProperty("line.separator")
                    + food_ma_104_5 + System.getProperty("line.separator") + food_ma_104_6 + System.getProperty("line.separator")
                    + food_ma_104_7 + System.getProperty("line.separator") + food_ma_104_8 + System.getProperty("line.separator")
                    + food_ma_104_9;

            food_ma_113 = food_ma_113_1 + System.getProperty("line.separator") + food_ma_113_2 + System.getProperty("line.separator")
                    + food_ma_113_3 + System.getProperty("line.separator") + food_ma_113_4 + System.getProperty("line.separator")
                    + food_ma_113_5 + System.getProperty("line.separator") + food_ma_113_6 + System.getProperty("line.separator")
                    + food_ma_113_7 + System.getProperty("line.separator") + food_ma_113_8;

            food_ma_114 = food_ma_114_1 + System.getProperty("line.separator") + food_ma_114_2 + System.getProperty("line.separator")
                    + food_ma_114_3 + System.getProperty("line.separator") + food_ma_114_4 + System.getProperty("line.separator")
                    + food_ma_114_5 + System.getProperty("line.separator") + food_ma_114_6 + System.getProperty("line.separator")
                    + food_ma_114_7 + System.getProperty("line.separator") + food_ma_114_8;

            food_ma_119 = food_ma_119_1 + System.getProperty("line.separator") + food_ma_119_2 + System.getProperty("line.separator")
                    + food_ma_119_3 + System.getProperty("line.separator") + food_ma_119_4;

            food_ma_120 = food_ma_120_1 + System.getProperty("line.separator") + food_ma_120_2 + System.getProperty("line.separator")
                    + food_ma_120_3 + System.getProperty("line.separator") + food_ma_120_4 + System.getProperty("line.separator")
                    + food_ma_120_5 + System.getProperty("line.separator") + food_ma_120_6 + System.getProperty("line.separator")
                    + food_ma_120_7 + System.getProperty("line.separator") + food_ma_120_8 + System.getProperty("line.separator")
                    + food_ma_120_9 + System.getProperty("line.separator") + food_ma_120_10 + System.getProperty("line.separator")
                    + food_ma_120_11;
        }


        if (farsi_zaban == 1) {
            //tarz tahye

            food_male_plan_10_food_1_r = food_male_plan_10_food_1_r_1 + fasele +
                    food_male_plan_10_food_1_r_2
                    + fasele + food_male_plan_10_food_1_r_3
                    + fasele + food_male_plan_10_food_1_r_4;

            food_male_plan_10_food_2_r = food_male_plan_10_food_2_r_1 + fasele +
                    food_male_plan_10_food_2_r_2;

            food_male_plan_10_food_3_r = food_male_plan_10_food_3_r_1 + fasele +
                    food_male_plan_10_food_3_r_2
                    + fasele + food_male_plan_10_food_3_r_3
                    + fasele + food_male_plan_10_food_3_r_4;

            food_male_plan_10_food_4_r = food_male_plan_10_food_4_r_1 + fasele +
                    food_male_plan_10_food_4_r_2;

            food_male_plan_10_food_5_r = food_male_plan_10_food_5_r_1 + fasele +
                    food_male_plan_10_food_5_r_2
                    + fasele + food_male_plan_10_food_5_r_3;

            food_male_plan_10_food_6_r = food_male_plan_10_food_6_r_1 + fasele +
                    food_male_plan_10_food_6_r_2;

            food_male_plan_10_food_7_r = food_male_plan_10_food_7_r_1 + fasele +
                    food_male_plan_10_food_7_r_2
                    + fasele + food_male_plan_10_food_7_r_3;

            food_male_plan_10_food_8_r = food_male_plan_10_food_8_r_1 + fasele +
                    food_male_plan_10_food_8_r_2;

            food_male_plan_10_food_9_r = food_male_plan_10_food_9_r_1
                    + fasele + food_male_plan_10_food_9_r_2
                    + fasele + food_male_plan_10_food_9_r_3
                    + fasele + food_male_plan_10_food_9_r_4;

            food_male_plan_10_food_10_r = food_male_plan_10_food_10_r_1
                    + fasele + food_male_plan_10_food_10_r_2
                    + fasele + food_male_plan_10_food_10_r_3
                    + fasele + food_male_plan_10_food_10_r_4
                    + fasele + food_male_plan_10_food_10_r_5;

            food_male_plan_10_food_11_r = food_male_plan_10_food_11_r_1
                    + fasele + food_male_plan_10_food_11_r_2
                    + fasele + food_male_plan_10_food_11_r_3
                    + fasele + food_male_plan_10_food_11_r_4
                    + fasele + food_male_plan_10_food_11_r_5
                    + fasele + food_male_plan_10_food_11_r_6;

            food_male_plan_10_food_12_r = food_male_plan_10_food_12_r_1
                    + fasele + food_male_plan_10_food_12_r_2
                    + fasele + food_male_plan_10_food_12_r_3
                    + fasele + food_male_plan_10_food_12_r_4
                    + fasele + food_male_plan_10_food_12_r_5
                    + fasele + food_male_plan_10_food_12_r_6
                    + fasele + food_male_plan_10_food_12_r_7
                    + fasele + food_male_plan_10_food_12_r_8
                    + fasele + food_male_plan_10_food_12_r_9
                    + fasele + food_male_plan_10_food_12_r_10;

            food_male_plan_10_food_13_r = food_male_plan_10_food_13_r_1
                    + fasele + food_male_plan_10_food_13_r_3
                    + fasele + food_male_plan_10_food_13_r_4
                    + fasele + food_male_plan_10_food_13_r_5
                    + fasele + food_male_plan_10_food_13_r_7;

            food_male_plan_10_food_14_r = food_male_plan_10_food_14_r_1
                    + fasele + food_male_plan_10_food_14_r_2
                    + fasele + food_male_plan_10_food_14_r_3
                    + fasele + food_male_plan_10_food_14_r_4
                    + fasele + food_male_plan_10_food_14_r_5
                    + fasele + food_male_plan_10_food_14_r_6
                    + fasele + food_male_plan_10_food_14_r_7
                    + fasele + food_male_plan_10_food_14_r_8
                    + fasele + food_male_plan_10_food_14_r_9
                    + fasele + food_male_plan_10_food_14_r_10;

            food_male_plan_10_food_15_r = food_male_plan_10_food_15_r_1
                    + fasele + food_male_plan_10_food_15_r_2
                    + fasele + food_male_plan_10_food_15_r_3
                    + fasele + food_male_plan_10_food_15_r_4
                    + fasele + food_male_plan_10_food_15_r_5
                    + fasele + food_male_plan_10_food_15_r_7;

            food_male_plan_10_food_16_r = food_male_plan_10_food_16_r_1 + fasele +
                    food_male_plan_10_food_16_r_2
                    + fasele + food_male_plan_10_food_16_r_3
                    + fasele + food_male_plan_10_food_16_r_4;

            food_male_plan_10_food_17_r = food_male_plan_10_food_17_r_1
                    + fasele + food_male_plan_10_food_17_r_2
                    + fasele + food_male_plan_10_food_17_r_3
                    + fasele + food_male_plan_10_food_17_r_4
                    + fasele + food_male_plan_10_food_17_r_5;

            food_male_plan_10_food_18_r = food_male_plan_10_food_18_r_1
                    + fasele + food_male_plan_10_food_18_r_2
                    + fasele + food_male_plan_10_food_18_r_3
                    + fasele + food_male_plan_10_food_18_r_4
                    + fasele + food_male_plan_10_food_18_r_5
                    + fasele + food_male_plan_10_food_18_r_6;

            food_male_plan_10_food_19_r = food_male_plan_10_food_19_r_1
                    + fasele + food_male_plan_10_food_19_r_2
                    + fasele + food_male_plan_10_food_19_r_3
                    + fasele + food_male_plan_10_food_19_r_4
                    + fasele + food_male_plan_10_food_19_r_5;

            food_male_plan_10_food_20_r = food_male_plan_10_food_20_r_1
                    + fasele + food_male_plan_10_food_20_r_2
                    + fasele + food_male_plan_10_food_20_r_3
                    + fasele + food_male_plan_10_food_20_r_4
                    + fasele + food_male_plan_10_food_20_r_5
                    + fasele + food_male_plan_10_food_20_r_6
                    + fasele + food_male_plan_10_food_20_r_7
                    + fasele + food_male_plan_10_food_20_r_8
                    + fasele + food_male_plan_10_food_20_r_9
                    + fasele + food_male_plan_10_food_20_r_10
                    + fasele + food_male_plan_10_food_20_r_11
                    + fasele + food_male_plan_10_food_20_r_12
                    + fasele + food_male_plan_10_food_20_r_13;

            food_male_plan_10_food_21_r = food_male_plan_10_food_21_r_1
                    + fasele + food_male_plan_10_food_21_r_2
                    + fasele + food_male_plan_10_food_21_r_3
                    + fasele + food_male_plan_10_food_21_r_4;

            String food_male_plan_10_food_22_r_3 = (String) getText(R.string.food_male_plan_10_food_22_r_3);
            food_male_plan_10_food_22_r = food_male_plan_10_food_22_r_1
                    + fasele + food_male_plan_10_food_22_r_2
                    + fasele + food_male_plan_10_food_22_r_3;

            food_male_plan_10_food_23_r = food_male_plan_10_food_23_r_1
                    + fasele + food_male_plan_10_food_23_r_2
                    + fasele + food_male_plan_10_food_23_r_3;

            food_male_plan_10_food_24_r = food_male_plan_10_food_24_r_1
                    + fasele + food_male_plan_10_food_24_r_2
                    + fasele + food_male_plan_10_food_24_r_3
                    + fasele + food_male_plan_10_food_24_r_4;

            food_male_plan_10_food_25_r = food_male_plan_10_food_25_r_1
                    + fasele + food_male_plan_10_food_25_r_2
                    + fasele + food_male_plan_10_food_25_r_3
                    + fasele + food_male_plan_10_food_25_r_4;

            food_male_plan_10_food_26_r = food_male_plan_10_food_26_r_1
                    + fasele + food_male_plan_10_food_26_r_2
                    + fasele + food_male_plan_10_food_26_r_3
                    + fasele + food_male_plan_10_food_26_r_4
                    + fasele + food_male_plan_10_food_26_r_5
                    + fasele + food_male_plan_10_food_26_r_6;

            food_male_plan_10_food_27_r = food_male_plan_10_food_27_r_1
                    + fasele + food_male_plan_10_food_27_r_2;

            String food_male_plan_10_food_28_r_3 = (String) getText(R.string.food_male_plan_10_food_28_r_3);
            String food_male_plan_10_food_28_r_4 = (String) getText(R.string.food_male_plan_10_food_28_r_4);
            String food_male_plan_10_food_28_r_5 = (String) getText(R.string.food_male_plan_10_food_28_r_5);
            String food_male_plan_10_food_28_r_6 = (String) getText(R.string.food_male_plan_10_food_28_r_6);
            food_male_plan_10_food_28_r = food_male_plan_10_food_28_r_1
                    + fasele + food_male_plan_10_food_28_r_2
                    + fasele + food_male_plan_10_food_28_r_3
                    + fasele + food_male_plan_10_food_28_r_4
                    + fasele + food_male_plan_10_food_28_r_5
                    + fasele + food_male_plan_10_food_28_r_6;

            food_male_plan_10_food_29_r = food_male_plan_10_food_29_r_1
                    + fasele + food_male_plan_10_food_29_r_2
                    + fasele + food_male_plan_10_food_29_r_3;

            food_male_plan_10_food_30_r = food_male_plan_10_food_30_r_1
                    + fasele + food_male_plan_10_food_30_r_2
                    + fasele + food_male_plan_10_food_30_r_3;

            String food_male_plan_10_food_31_r_4 = (String) getText(R.string.food_male_plan_10_food_31_r_4);
            food_male_plan_10_food_31_r = food_male_plan_10_food_31_r_1
                    + fasele + food_male_plan_10_food_31_r_2
                    + fasele + food_male_plan_10_food_31_r_3
                    + fasele + food_male_plan_10_food_31_r_4;

            food_male_plan_10_food_32_r = food_male_plan_10_food_32_r_1
                    + fasele + food_male_plan_10_food_32_r_2
                    + fasele + food_male_plan_10_food_32_r_3;

            food_male_plan_10_food_33_r = food_male_plan_10_food_33_r_1
                    + fasele + food_male_plan_10_food_33_r_2;

            food_male_plan_10_food_34_r = food_male_plan_10_food_34_r_1
                    + fasele + food_male_plan_10_food_34_r_2;

            food_male_plan_10_food_35_r = food_male_plan_10_food_35_r_1
                    + fasele + food_male_plan_10_food_35_r_2;

            String food_male_plan_10_food_36_r_3 = (String) getText(R.string.food_male_plan_10_food_36_r_3);
            food_male_plan_10_food_36_r = food_male_plan_10_food_36_r_1
                    + fasele + food_male_plan_10_food_36_r_2
                    + fasele + food_male_plan_10_food_36_r_3;

            food_male_plan_10_food_37_r = food_male_plan_10_food_37_r_1
                    + fasele + food_male_plan_10_food_37_r_2;

            food_male_plan_10_food_38_r = food_male_plan_10_food_38_r_1
                    + fasele + food_male_plan_10_food_38_r_2
                    + fasele + food_male_plan_10_food_38_r_3
                    + fasele + food_male_plan_10_food_38_r_4;

            String food_male_plan_10_food_39_r_2 = (String) getText(R.string.food_male_plan_10_food_39_r_2);
            String food_male_plan_10_food_39_r_3 = (String) getText(R.string.food_male_plan_10_food_39_r_3);
            String food_male_plan_10_food_39_r_4 = (String) getText(R.string.food_male_plan_10_food_39_r_4);
            food_male_plan_10_food_39_r = food_male_plan_10_food_39_r_1
                    + fasele + food_male_plan_10_food_39_r_2
                    + fasele + food_male_plan_10_food_39_r_3
                    + fasele + food_male_plan_10_food_39_r_4;

            String food_male_plan_10_food_40_r_3 = (String) getText(R.string.food_male_plan_10_food_40_r_3);
            String food_male_plan_10_food_40_r_4 = (String) getText(R.string.food_male_plan_10_food_40_r_4);
            String food_male_plan_10_food_40_r_5 = (String) getText(R.string.food_male_plan_10_food_40_r_5);
            food_male_plan_10_food_40_r = food_male_plan_10_food_40_r_1
                    + fasele + food_male_plan_10_food_40_r_2
                    + fasele + food_male_plan_10_food_40_r_3
                    + fasele + food_male_plan_10_food_40_r_4
                    + fasele + food_male_plan_10_food_40_r_5;

            food_male_plan_10_food_41_r = food_male_plan_10_food_41_r_1
                    + fasele + food_male_plan_10_food_41_r_2
                    + fasele + food_male_plan_10_food_41_r_3
                    + fasele + food_male_plan_10_food_41_r_4;

            food_male_plan_10_food_42_r = food_male_plan_10_food_42_r_1
                    + fasele + food_male_plan_10_food_42_r_2
                    + fasele + food_male_plan_10_food_42_r_3;

            String food_male_plan_10_food_43_r_4 = (String) getText(R.string.food_male_plan_10_food_43_r_4);
            food_male_plan_10_food_43_r = food_male_plan_10_food_43_r_1
                    + fasele + food_male_plan_10_food_43_r_2
                    + fasele + food_male_plan_10_food_43_r_3
                    + fasele + food_male_plan_10_food_43_r_4;

            food_male_plan_10_food_44_r = food_male_plan_10_food_44_r_1
                    + fasele + food_male_plan_10_food_44_r_2
                    + fasele + food_male_plan_10_food_44_r_3;

            food_male_plan_10_food_45_r = food_male_plan_10_food_45_r_1
                    + fasele + food_male_plan_10_food_45_r_2
                    + fasele + food_male_plan_10_food_45_r_3;

            food_male_plan_10_food_46_r = food_male_plan_10_food_46_r_1
                    + fasele + food_male_plan_10_food_46_r_2;

            String food_male_plan_10_food_47_r_3 = (String) getText(R.string.food_male_plan_10_food_47_r_3);
            food_male_plan_10_food_47_r = food_male_plan_10_food_47_r_1
                    + fasele + food_male_plan_10_food_47_r_2
                    + fasele + food_male_plan_10_food_47_r_3;

            String food_male_plan_10_food_48_r_2 = (String) getText(R.string.food_male_plan_10_food_48_r_2);
            food_male_plan_10_food_48_r = food_male_plan_10_food_48_r_1
                    + fasele + food_male_plan_10_food_48_r_2;

            food_male_plan_10_food_49_r = food_male_plan_10_food_49_r_1
                    + fasele + food_male_plan_10_food_49_r_2;

            food_male_plan_10_food_50_r = food_male_plan_10_food_50_r_1
                    + fasele + food_male_plan_10_food_50_r_2;

            String food_male_plan_10_food_51_r_3 = (String) getText(R.string.food_male_plan_10_food_51_r_3);
            String food_male_plan_10_food_51_r_4 = (String) getText(R.string.food_male_plan_10_food_51_r_4);
            String food_male_plan_10_food_51_r_5 = (String) getText(R.string.food_male_plan_10_food_51_r_5);
            food_male_plan_10_food_51_r = food_male_plan_10_food_51_r_1
                    + fasele + food_male_plan_10_food_51_r_2
                    + fasele + food_male_plan_10_food_51_r_3
                    + fasele + food_male_plan_10_food_51_r_4
                    + fasele + food_male_plan_10_food_51_r_5;

            food_male_plan_10_food_52_r = food_male_plan_10_food_52_r_1;

            String food_male_plan_10_food_53_r_4 = (String) getText(R.string.food_male_plan_10_food_53_r_4);
            String food_male_plan_10_food_53_r_5 = (String) getText(R.string.food_male_plan_10_food_53_r_5);
            String food_male_plan_10_food_53_r_6 = (String) getText(R.string.food_male_plan_10_food_53_r_6);
            String food_male_plan_10_food_53_r_7 = (String) getText(R.string.food_male_plan_10_food_53_r_7);
            String food_male_plan_10_food_53_r_8 = (String) getText(R.string.food_male_plan_10_food_53_r_8);
            String food_male_plan_10_food_53_r_9 = (String) getText(R.string.food_male_plan_10_food_53_r_9);
            food_male_plan_10_food_53_r = food_male_plan_10_food_53_r_1
                    + fasele + food_male_plan_10_food_53_r_2
                    + fasele + food_male_plan_10_food_53_r_3
                    + fasele + System.getProperty("line.separator") + food_male_plan_10_food_53_r_4
                    + fasele + food_male_plan_10_food_53_r_5
                    + fasele + food_male_plan_10_food_53_r_6
                    + fasele + food_male_plan_10_food_53_r_7
                    + fasele + food_male_plan_10_food_53_r_8
                    + fasele + food_male_plan_10_food_53_r_9;

            food_male_plan_10_food_54_r = food_male_plan_10_food_54_r_1
                    + fasele + food_male_plan_10_food_54_r_2
                    + fasele + food_male_plan_10_food_54_r_3;

            food_male_plan_10_food_55_r = food_male_plan_10_food_55_r_1
                    + fasele + food_male_plan_10_food_55_r_2;

            String food_male_plan_10_food_56_r_3 = (String) getText(R.string.food_male_plan_10_food_56_r_3);
            String food_male_plan_10_food_56_r_4 = (String) getText(R.string.food_male_plan_10_food_56_r_4);
            String food_male_plan_10_food_56_r_5 = (String) getText(R.string.food_male_plan_10_food_56_r_5);
            food_male_plan_10_food_56_r = food_male_plan_10_food_56_r_1
                    + fasele + food_male_plan_10_food_56_r_2
                    + fasele + food_male_plan_10_food_56_r_3
                    + fasele + food_male_plan_10_food_56_r_4
                    + fasele + food_male_plan_10_food_56_r_5;

            food_male_plan_10_food_57_r = food_male_plan_10_food_57_r_1
                    + fasele + food_male_plan_10_food_57_r_2
                    + fasele + food_male_plan_10_food_57_r_3;

            String food_male_plan_10_food_58_r_4 = (String) getText(R.string.food_male_plan_10_food_58_r_4);
            food_male_plan_10_food_58_r = food_male_plan_10_food_58_r_1
                    + fasele + food_male_plan_10_food_58_r_2
                    + fasele + food_male_plan_10_food_58_r_3
                    + fasele + food_male_plan_10_food_58_r_4;

            food_male_plan_10_food_59_r = food_male_plan_10_food_59_r_1
                    + fasele + food_male_plan_10_food_59_r_2
                    + fasele + food_male_plan_10_food_59_r_3
                    + fasele + food_male_plan_10_food_59_r_4;

            food_male_plan_10_food_60_r = food_male_plan_10_food_60_r_1
                    + fasele + food_male_plan_10_food_60_r_2
                    + fasele + food_male_plan_10_food_60_r_3;

            food_male_plan_10_food_61_r = food_male_plan_10_food_61_r_1
                    + fasele + food_male_plan_10_food_61_r_2
                    + fasele + food_male_plan_10_food_61_r_3
                    + fasele + food_male_plan_10_food_61_r_4;

            String food_male_plan_10_food_62_r_5 = (String) getText(R.string.food_male_plan_10_food_62_r_5);
            food_male_plan_10_food_62_r = food_male_plan_10_food_62_r_1
                    + fasele + food_male_plan_10_food_62_r_2
                    + fasele + food_male_plan_10_food_62_r_3
                    + fasele + food_male_plan_10_food_62_r_4
                    + fasele + food_male_plan_10_food_62_r_5;

            String food_male_plan_10_food_63_r_3 = (String) getText(R.string.food_male_plan_10_food_63_r_3);
            String food_male_plan_10_food_63_r_4 = (String) getText(R.string.food_male_plan_10_food_63_r_4);
            String food_male_plan_10_food_63_r_5 = (String) getText(R.string.food_male_plan_10_food_63_r_5);
            String food_male_plan_10_food_63_r_6 = (String) getText(R.string.food_male_plan_10_food_63_r_6);
            String food_male_plan_10_food_63_r_7 = (String) getText(R.string.food_male_plan_10_food_63_r_7);
            food_male_plan_10_food_63_r = food_male_plan_10_food_63_r_1
                    + fasele + food_male_plan_10_food_63_r_2
                    + fasele + food_male_plan_10_food_63_r_3
                    + fasele + System.getProperty("line.separator") + food_male_plan_10_food_63_r_4
                    + fasele + food_male_plan_10_food_63_r_5
                    + fasele + System.getProperty("line.separator") + food_male_plan_10_food_63_r_6
                    + fasele + food_male_plan_10_food_63_r_7;

            food_male_plan_10_food_64_r = food_male_plan_10_food_64_r_1
                    + fasele + food_male_plan_10_food_64_r_2
                    + fasele + food_male_plan_10_food_64_r_3;

            food_male_plan_10_food_65_r = food_male_plan_10_food_65_r_1
                    + fasele + food_male_plan_10_food_65_r_2
                    + fasele + food_male_plan_10_food_65_r_3
                    + fasele + food_male_plan_10_food_65_r_4;

            String food_male_plan_10_food_66_r_4 = (String) getText(R.string.food_male_plan_10_food_66_r_4);
            String food_male_plan_10_food_66_r_5 = (String) getText(R.string.food_male_plan_10_food_66_r_5);
            String food_male_plan_10_food_66_r_6 = (String) getText(R.string.food_male_plan_10_food_66_r_6);
            String food_male_plan_10_food_66_r_7 = (String) getText(R.string.food_male_plan_10_food_66_r_7);
            food_male_plan_10_food_66_r = food_male_plan_10_food_66_r_1
                    + fasele + food_male_plan_10_food_66_r_2
                    + fasele + food_male_plan_10_food_66_r_3
                    + fasele + food_male_plan_10_food_66_r_4
                    + fasele + food_male_plan_10_food_66_r_5
                    + fasele + food_male_plan_10_food_66_r_6
                    + fasele + food_male_plan_10_food_66_r_7;

            food_male_plan_10_food_67_r = food_male_plan_10_food_67_r_1
                    + fasele + food_male_plan_10_food_67_r_2
                    + fasele + food_male_plan_10_food_67_r_3
                    + fasele + food_male_plan_10_food_67_r_4;

            food_male_plan_10_food_68_r = food_male_plan_10_food_68_r_1
                    + fasele + food_male_plan_10_food_68_r_2
                    + fasele + food_male_plan_10_food_68_r_3
                    + fasele + food_male_plan_10_food_68_r_4
                    + fasele + food_male_plan_10_food_68_r_5
                    + fasele + food_male_plan_10_food_68_r_6
                    + fasele + food_male_plan_10_food_68_r_7;

            String food_male_plan_10_food_69_r_2 = (String) getText(R.string.food_male_plan_10_food_69_r_2);
            String food_male_plan_10_food_69_r_3 = (String) getText(R.string.food_male_plan_10_food_69_r_3);
            String food_male_plan_10_food_69_r_4 = (String) getText(R.string.food_male_plan_10_food_69_r_4);
            String food_male_plan_10_food_69_r_5 = (String) getText(R.string.food_male_plan_10_food_69_r_5);
            food_male_plan_10_food_69_r = food_male_plan_10_food_69_r_1
                    + fasele + food_male_plan_10_food_69_r_2
                    + fasele + food_male_plan_10_food_69_r_3
                    + fasele + food_male_plan_10_food_69_r_4
                    + fasele + food_male_plan_10_food_69_r_5;

            food_male_plan_10_food_70_r = food_male_plan_10_food_70_r_1
                    + fasele + food_male_plan_10_food_70_r_2
                    + fasele + food_male_plan_10_food_70_r_3
                    + fasele + food_male_plan_10_food_70_r_4;

            food_male_plan_10_food_71_r = food_male_plan_10_food_71_r_1
                    + fasele + food_male_plan_10_food_71_r_2
                    + fasele + food_male_plan_10_food_71_r_3;

            food_male_plan_10_food_72_r = food_male_plan_10_food_72_r_1
                    + fasele + food_male_plan_10_food_72_r_2
                    + fasele + food_male_plan_10_food_72_r_3
                    + fasele + food_male_plan_10_food_72_r_4;

            food_male_plan_10_food_73_r = food_male_plan_10_food_73_r_1
                    + fasele + food_male_plan_10_food_73_r_2
                    + fasele + food_male_plan_10_food_73_r_3;

            String food_male_plan_10_food_74_r_4 = (String) getText(R.string.food_male_plan_10_food_74_r_4);
            food_male_plan_10_food_74_r = food_male_plan_10_food_74_r_1
                    + fasele + food_male_plan_10_food_74_r_2
                    + fasele + food_male_plan_10_food_74_r_3
                    + fasele + food_male_plan_10_food_74_r_4;

            food_male_plan_10_food_75_r = food_male_plan_10_food_75_r_1
                    + fasele + food_male_plan_10_food_75_r_2
                    + fasele + food_male_plan_10_food_75_r_3
                    + fasele + food_male_plan_10_food_75_r_4
                    + fasele + food_male_plan_10_food_75_r_5
                    + fasele + food_male_plan_10_food_75_r_6;

            food_male_plan_10_food_76_r = food_male_plan_10_food_76_r_1
                    + fasele + food_male_plan_10_food_76_r_2
                    + fasele + food_male_plan_10_food_76_r_3
                    + fasele + food_male_plan_10_food_76_r_4;

            food_male_plan_10_food_77_r = food_male_plan_10_food_77_r_1
                    + fasele + food_male_plan_10_food_77_r_2
                    + fasele + food_male_plan_10_food_77_r_3
                    + fasele + food_male_plan_10_food_77_r_4
                    + fasele + food_male_plan_10_food_77_r_5
                    + fasele + food_male_plan_10_food_77_r_6;

            food_male_plan_10_food_78_r = food_male_plan_10_food_78_r_1
                    + fasele + food_male_plan_10_food_78_r_2
                    + fasele + food_male_plan_10_food_78_r_3
                    + fasele + food_male_plan_10_food_78_r_4
                    + fasele + food_male_plan_10_food_78_r_5
                    + fasele + food_male_plan_10_food_78_r_6
                    + fasele + food_male_plan_10_food_78_r_7
                    + fasele + food_male_plan_10_food_78_r_8
                    + fasele + food_male_plan_10_food_78_r_9;

            food_male_plan_10_food_79_r = food_male_plan_10_food_79_r_1
                    + fasele + food_male_plan_10_food_79_r_2
                    + fasele + food_male_plan_10_food_79_r_3
                    + fasele + food_male_plan_10_food_79_r_4
                    + fasele + food_male_plan_10_food_79_r_5;

            food_male_plan_10_food_80_r = food_male_plan_10_food_80_r_1
                    + fasele + food_male_plan_10_food_80_r_2
                    + fasele + food_male_plan_10_food_80_r_3
                    + fasele + food_male_plan_10_food_80_r_4
                    + fasele + food_male_plan_10_food_80_r_5;

            food_male_plan_10_food_81_r = food_male_plan_10_food_81_r_1
                    + fasele + food_male_plan_10_food_81_r_2
                    + fasele + food_male_plan_10_food_81_r_3
                    + fasele + food_male_plan_10_food_81_r_4
                    + fasele + food_male_plan_10_food_81_r_5
                    + fasele + food_male_plan_10_food_81_r_6;

            food_male_plan_10_food_82_r = food_male_plan_10_food_82_r_1
                    + fasele + food_male_plan_10_food_82_r_2
                    + fasele + food_male_plan_10_food_82_r_3
                    + fasele + food_male_plan_10_food_82_r_4;

            food_male_plan_10_food_83_r = food_male_plan_10_food_83_r_1
                    + fasele + food_male_plan_10_food_83_r_2
                    + fasele + food_male_plan_10_food_83_r_3
                    + fasele + food_male_plan_10_food_83_r_4
                    + fasele + food_male_plan_10_food_83_r_5;

            food_male_plan_10_food_84_r = food_male_plan_10_food_84_r_1
                    + fasele + food_male_plan_10_food_84_r_2
                    + fasele + food_male_plan_10_food_84_r_3
                    + fasele + food_male_plan_10_food_84_r_4;

            food_male_plan_10_food_101_r = food_male_plan_10_food_101_r_1
                    + fasele + food_male_plan_10_food_101_r_2
                    + fasele + food_male_plan_10_food_101_r_3
                    + fasele + food_male_plan_10_food_101_r_4
                    + fasele + food_male_plan_10_food_101_r_5
                    + fasele + food_male_plan_10_food_101_r_6;

            food_male_plan_10_food_102_r = food_male_plan_10_food_102_r_1
                    + fasele + food_male_plan_10_food_102_r_2
                    + fasele + food_male_plan_10_food_102_r_3
                    + fasele + food_male_plan_10_food_102_r_4
                    + fasele + food_male_plan_10_food_102_r_5
                    + fasele + food_male_plan_10_food_102_r_6;

            food_male_plan_10_food_107_r = food_male_plan_10_food_103_r_1
                    + fasele + food_male_plan_10_food_103_r_2
                    + fasele + food_male_plan_10_food_103_r_3
                    + fasele + food_male_plan_10_food_103_r_4
                    + fasele + food_male_plan_10_food_103_r_5
                    + fasele + food_male_plan_10_food_103_r_6;

            food_male_plan_10_food_108_r = food_male_plan_10_food_104_r_1
                    + fasele + food_male_plan_10_food_104_r_2
                    + fasele + food_male_plan_10_food_104_r_3
                    + fasele + food_male_plan_10_food_104_r_4;

            food_male_plan_10_food_113_r = food_male_plan_10_food_113_r_1
                    + fasele + food_male_plan_10_food_113_r_2
                    + fasele + food_male_plan_10_food_113_r_3
                    + fasele + food_male_plan_10_food_113_r_4;

            food_male_plan_10_food_114_r = food_male_plan_10_food_114_r_1
                    + fasele + food_male_plan_10_food_114_r_2
                    + fasele + food_male_plan_10_food_114_r_3;


            food_male_plan_10_food_119_r = food_male_plan_10_food_119_r_1
                    + fasele + food_male_plan_10_food_119_r_2
                    + fasele + food_male_plan_10_food_119_r_3
                    + fasele + food_male_plan_10_food_119_r_4;

            food_male_plan_10_food_120_r = food_male_plan_10_food_120_r_1;

        } else {

            food_male_plan_10_food_1_r = food_male_plan_10_food_1_r_1 + fasele +
                    food_male_plan_10_food_1_r_2
                    + fasele + food_male_plan_10_food_1_r_3
                    + fasele + food_male_plan_10_food_1_r_4;

            food_male_plan_10_food_2_r = food_male_plan_10_food_2_r_1 + fasele +
                    food_male_plan_10_food_2_r_2;

            food_male_plan_10_food_3_r = food_male_plan_10_food_3_r_1 + fasele +
                    food_male_plan_10_food_3_r_2
                    + fasele + food_male_plan_10_food_3_r_3
                    + fasele + food_male_plan_10_food_3_r_4;

            food_male_plan_10_food_4_r = food_male_plan_10_food_4_r_1 + fasele +
                    food_male_plan_10_food_4_r_2;

            food_male_plan_10_food_5_r = food_male_plan_10_food_5_r_1 + fasele +
                    food_male_plan_10_food_5_r_2
                    + fasele + food_male_plan_10_food_5_r_3;

            food_male_plan_10_food_6_r = food_male_plan_10_food_6_r_1 + fasele +
                    food_male_plan_10_food_6_r_2
                    + fasele + food_male_plan_10_food_6_r_3;

            food_male_plan_10_food_7_r = food_male_plan_10_food_7_r_1 + fasele +
                    food_male_plan_10_food_7_r_2
                    + fasele + food_male_plan_10_food_7_r_3;

            food_male_plan_10_food_8_r = food_male_plan_10_food_8_r_1 + fasele +
                    food_male_plan_10_food_8_r_2;

            food_male_plan_10_food_9_r = food_male_plan_10_food_9_r_1
                    + fasele + food_male_plan_10_food_9_r_2
                    + fasele + food_male_plan_10_food_9_r_3
                    + fasele + food_male_plan_10_food_9_r_4;

            food_male_plan_10_food_10_r = food_male_plan_10_food_10_r_1
                    + fasele + food_male_plan_10_food_10_r_2
                    + fasele + food_male_plan_10_food_10_r_3
                    + fasele + food_male_plan_10_food_10_r_4
                    + fasele + food_male_plan_10_food_10_r_5;

            food_male_plan_10_food_11_r = food_male_plan_10_food_11_r_1
                    + fasele + food_male_plan_10_food_11_r_2
                    + fasele + food_male_plan_10_food_11_r_3
                    + fasele + food_male_plan_10_food_11_r_4
                    + fasele + food_male_plan_10_food_11_r_5
                    + fasele + food_male_plan_10_food_11_r_6
                    + fasele + food_male_plan_10_food_11_r_7
                    + fasele + food_male_plan_10_food_11_r_8
                    + fasele + food_male_plan_10_food_11_r_9
                    + fasele + food_male_plan_10_food_11_r_10
                    + fasele + food_male_plan_10_food_11_r_11;

            food_male_plan_10_food_12_r = food_male_plan_10_food_12_r_1
                    + fasele + food_male_plan_10_food_12_r_2
                    + fasele + food_male_plan_10_food_12_r_3
                    + fasele + food_male_plan_10_food_12_r_4
                    + fasele + food_male_plan_10_food_12_r_5
                    + fasele + food_male_plan_10_food_12_r_6
                    + fasele + food_male_plan_10_food_12_r_7
                    + fasele + food_male_plan_10_food_12_r_8
                    + fasele + food_male_plan_10_food_12_r_9
                    + fasele + food_male_plan_10_food_12_r_10
                    + fasele + food_male_plan_10_food_12_r_11
                    + fasele + food_male_plan_10_food_12_r_12
                    + fasele + food_male_plan_10_food_12_r_13
                    + fasele + food_male_plan_10_food_12_r_14;

            food_male_plan_10_food_13_r = food_male_plan_10_food_13_r_1
                    + fasele + food_male_plan_10_food_13_r_2
                    + fasele + food_male_plan_10_food_13_r_3
                    + fasele + System.getProperty("line.separator")
                    + food_male_plan_10_food_13_r_4
                    + fasele + food_male_plan_10_food_13_r_5
                    + fasele + food_male_plan_10_food_13_r_6
                    + fasele + food_male_plan_10_food_13_r_7
                    + fasele + food_male_plan_10_food_13_r_8
                    + fasele + food_male_plan_10_food_13_r_9
                    + fasele + food_male_plan_10_food_13_r_10;

            food_male_plan_10_food_14_r = food_male_plan_10_food_14_r_1
                    + fasele + food_male_plan_10_food_14_r_2
                    + fasele + food_male_plan_10_food_14_r_3
                    + fasele + food_male_plan_10_food_14_r_4
                    + fasele + System.getProperty("line.separator")
                    + food_male_plan_10_food_14_r_5
                    + fasele + food_male_plan_10_food_14_r_6
                    + fasele + food_male_plan_10_food_14_r_7
                    + fasele + food_male_plan_10_food_14_r_8
                    + fasele + food_male_plan_10_food_14_r_9
                    + fasele + food_male_plan_10_food_14_r_10;

            food_male_plan_10_food_15_r = food_male_plan_10_food_15_r_1
                    + fasele + food_male_plan_10_food_15_r_2
                    + fasele + System.getProperty("line.separator")
                    + food_male_plan_10_food_15_r_3
                    + fasele + food_male_plan_10_food_15_r_4
                    + fasele + food_male_plan_10_food_15_r_5
                    + fasele + food_male_plan_10_food_15_r_6
                    + fasele + food_male_plan_10_food_15_r_7;

            food_male_plan_10_food_16_r = food_male_plan_10_food_16_r_1 + fasele +
                    food_male_plan_10_food_16_r_2
                    + fasele + food_male_plan_10_food_16_r_3
                    + fasele + food_male_plan_10_food_16_r_4;

            food_male_plan_10_food_17_r = food_male_plan_10_food_17_r_1
                    + fasele + food_male_plan_10_food_17_r_2
                    + fasele + food_male_plan_10_food_17_r_3
                    + fasele + food_male_plan_10_food_17_r_4
                    + fasele + food_male_plan_10_food_17_r_5;

            food_male_plan_10_food_18_r = food_male_plan_10_food_18_r_1
                    + fasele + food_male_plan_10_food_18_r_2
                    + fasele + food_male_plan_10_food_18_r_3
                    + fasele + food_male_plan_10_food_18_r_4
                    + fasele + food_male_plan_10_food_18_r_5
                    + fasele + food_male_plan_10_food_18_r_6;

            food_male_plan_10_food_19_r = food_male_plan_10_food_19_r_1
                    + fasele + food_male_plan_10_food_19_r_2
                    + fasele + food_male_plan_10_food_19_r_3
                    + fasele + food_male_plan_10_food_19_r_4
                    + fasele + food_male_plan_10_food_19_r_5;

            food_male_plan_10_food_20_r = food_male_plan_10_food_20_r_1
                    + fasele + food_male_plan_10_food_20_r_2
                    + fasele + food_male_plan_10_food_20_r_3
                    + fasele + food_male_plan_10_food_20_r_4
                    + fasele + food_male_plan_10_food_20_r_5
                    + fasele + food_male_plan_10_food_20_r_6
                    + fasele + food_male_plan_10_food_20_r_7
                    + fasele + food_male_plan_10_food_20_r_8
                    + fasele + food_male_plan_10_food_20_r_9
                    + fasele + food_male_plan_10_food_20_r_10
                    + fasele + food_male_plan_10_food_20_r_11
                    + fasele + food_male_plan_10_food_20_r_12
                    + fasele + food_male_plan_10_food_20_r_13;

            food_male_plan_10_food_21_r = food_male_plan_10_food_21_r_1
                    + fasele + food_male_plan_10_food_21_r_2
                    + fasele + food_male_plan_10_food_21_r_3
                    + fasele + food_male_plan_10_food_21_r_4
                    + fasele + food_male_plan_10_food_21_r_5;

            food_male_plan_10_food_22_r = food_male_plan_10_food_22_r_1
                    + fasele + food_male_plan_10_food_22_r_2;

            food_male_plan_10_food_23_r = food_male_plan_10_food_23_r_1
                    + fasele + food_male_plan_10_food_23_r_2
                    + fasele + food_male_plan_10_food_23_r_3;

            food_male_plan_10_food_24_r = food_male_plan_10_food_24_r_1
                    + fasele + food_male_plan_10_food_24_r_2
                    + fasele + food_male_plan_10_food_24_r_3
                    + fasele + food_male_plan_10_food_24_r_4;

            food_male_plan_10_food_25_r = food_male_plan_10_food_25_r_1
                    + fasele + food_male_plan_10_food_25_r_2
                    + fasele + food_male_plan_10_food_25_r_3
                    + fasele + food_male_plan_10_food_25_r_4;

            food_male_plan_10_food_26_r = food_male_plan_10_food_26_r_1
                    + fasele + food_male_plan_10_food_26_r_2
                    + fasele + food_male_plan_10_food_26_r_3
                    + fasele + food_male_plan_10_food_26_r_4
                    + fasele + food_male_plan_10_food_26_r_5
                    + fasele + food_male_plan_10_food_26_r_6;

            food_male_plan_10_food_27_r = food_male_plan_10_food_27_r_1
                    + fasele + food_male_plan_10_food_27_r_2;

            food_male_plan_10_food_28_r = food_male_plan_10_food_28_r_1
                    + fasele + food_male_plan_10_food_28_r_2;

            food_male_plan_10_food_29_r = food_male_plan_10_food_29_r_1
                    + fasele + food_male_plan_10_food_29_r_2
                    + fasele + food_male_plan_10_food_29_r_3;

            food_male_plan_10_food_30_r = food_male_plan_10_food_30_r_1
                    + fasele + food_male_plan_10_food_30_r_2
                    + fasele + food_male_plan_10_food_30_r_3;

            food_male_plan_10_food_31_r = food_male_plan_10_food_31_r_1
                    + fasele + food_male_plan_10_food_31_r_2
                    + fasele + food_male_plan_10_food_31_r_3;

            food_male_plan_10_food_32_r = food_male_plan_10_food_32_r_1
                    + fasele + food_male_plan_10_food_32_r_2
                    + fasele + food_male_plan_10_food_32_r_3;

            food_male_plan_10_food_33_r = food_male_plan_10_food_33_r_1
                    + fasele + food_male_plan_10_food_33_r_2;

            food_male_plan_10_food_34_r = food_male_plan_10_food_34_r_1
                    + fasele + food_male_plan_10_food_34_r_2;

            food_male_plan_10_food_35_r = food_male_plan_10_food_35_r_1
                    + fasele + food_male_plan_10_food_35_r_2;

            food_male_plan_10_food_36_r = food_male_plan_10_food_36_r_1
                    + fasele + food_male_plan_10_food_36_r_2;

            food_male_plan_10_food_37_r = food_male_plan_10_food_37_r_1
                    + fasele + food_male_plan_10_food_37_r_2;

            food_male_plan_10_food_38_r = food_male_plan_10_food_38_r_1
                    + fasele + food_male_plan_10_food_38_r_2
                    + fasele + food_male_plan_10_food_38_r_3
                    + fasele + food_male_plan_10_food_38_r_4;

            food_male_plan_10_food_39_r = food_male_plan_10_food_39_r_1;

            food_male_plan_10_food_40_r = food_male_plan_10_food_40_r_1
                    + fasele + food_male_plan_10_food_40_r_2;

            food_male_plan_10_food_41_r = food_male_plan_10_food_41_r_1
                    + fasele + food_male_plan_10_food_41_r_2
                    + fasele + food_male_plan_10_food_41_r_3
                    + fasele + food_male_plan_10_food_41_r_4;

            food_male_plan_10_food_42_r = food_male_plan_10_food_42_r_1
                    + fasele + food_male_plan_10_food_42_r_2
                    + fasele + food_male_plan_10_food_42_r_3;

            food_male_plan_10_food_43_r = food_male_plan_10_food_43_r_1
                    + fasele + food_male_plan_10_food_43_r_2
                    + fasele + food_male_plan_10_food_43_r_3;

            food_male_plan_10_food_44_r = food_male_plan_10_food_44_r_1
                    + fasele + food_male_plan_10_food_44_r_2
                    + fasele + food_male_plan_10_food_44_r_3;

            food_male_plan_10_food_45_r = food_male_plan_10_food_45_r_1
                    + fasele + food_male_plan_10_food_45_r_2
                    + fasele + food_male_plan_10_food_45_r_3;

            food_male_plan_10_food_46_r = food_male_plan_10_food_46_r_1
                    + fasele + food_male_plan_10_food_46_r_2;

            food_male_plan_10_food_47_r = food_male_plan_10_food_47_r_1
                    + fasele + food_male_plan_10_food_47_r_2;

            food_male_plan_10_food_48_r = food_male_plan_10_food_48_r_1;

            food_male_plan_10_food_49_r = food_male_plan_10_food_49_r_1
                    + fasele + food_male_plan_10_food_49_r_2;

            food_male_plan_10_food_50_r = food_male_plan_10_food_50_r_1
                    + fasele + food_male_plan_10_food_50_r_2;

            food_male_plan_10_food_51_r = food_male_plan_10_food_51_r_1
                    + fasele + food_male_plan_10_food_51_r_2;

            food_male_plan_10_food_52_r = food_male_plan_10_food_52_r_1
                    + fasele + food_male_plan_10_food_52_r_2;

            food_male_plan_10_food_53_r = food_male_plan_10_food_53_r_1
                    + fasele + food_male_plan_10_food_53_r_2
                    + fasele + food_male_plan_10_food_53_r_3;

            food_male_plan_10_food_54_r = food_male_plan_10_food_54_r_1
                    + fasele + food_male_plan_10_food_54_r_2
                    + fasele + food_male_plan_10_food_54_r_3;

            food_male_plan_10_food_55_r = food_male_plan_10_food_55_r_1
                    + fasele + food_male_plan_10_food_55_r_2;

            food_male_plan_10_food_56_r = food_male_plan_10_food_56_r_1
                    + fasele + food_male_plan_10_food_56_r_2;

            food_male_plan_10_food_57_r = food_male_plan_10_food_57_r_1
                    + fasele + food_male_plan_10_food_57_r_2
                    + fasele + food_male_plan_10_food_57_r_3;

            food_male_plan_10_food_58_r = food_male_plan_10_food_58_r_1
                    + fasele + food_male_plan_10_food_58_r_2
                    + fasele + food_male_plan_10_food_58_r_3;

            food_male_plan_10_food_59_r = food_male_plan_10_food_59_r_1
                    + fasele + food_male_plan_10_food_59_r_2
                    + fasele + food_male_plan_10_food_59_r_3
                    + fasele + food_male_plan_10_food_59_r_4;

            food_male_plan_10_food_60_r = food_male_plan_10_food_60_r_1
                    + fasele + food_male_plan_10_food_60_r_2
                    + fasele + food_male_plan_10_food_60_r_3;

            food_male_plan_10_food_61_r = food_male_plan_10_food_61_r_1
                    + fasele + food_male_plan_10_food_61_r_2
                    + fasele + food_male_plan_10_food_61_r_3
                    + fasele + food_male_plan_10_food_61_r_4;

            food_male_plan_10_food_62_r = food_male_plan_10_food_62_r_1
                    + fasele + food_male_plan_10_food_62_r_2
                    + fasele + food_male_plan_10_food_62_r_3
                    + fasele + food_male_plan_10_food_62_r_4;

            food_male_plan_10_food_63_r = food_male_plan_10_food_63_r_1
                    + fasele + food_male_plan_10_food_63_r_2;

            food_male_plan_10_food_64_r = food_male_plan_10_food_64_r_1
                    + fasele + food_male_plan_10_food_64_r_2
                    + fasele + food_male_plan_10_food_64_r_3;

            food_male_plan_10_food_65_r = food_male_plan_10_food_65_r_1
                    + fasele + food_male_plan_10_food_65_r_2
                    + fasele + food_male_plan_10_food_65_r_3
                    + fasele + food_male_plan_10_food_65_r_4;

            food_male_plan_10_food_66_r = food_male_plan_10_food_66_r_1
                    + fasele + food_male_plan_10_food_66_r_2
                    + fasele + food_male_plan_10_food_66_r_3;

            food_male_plan_10_food_67_r = food_male_plan_10_food_67_r_1
                    + fasele + food_male_plan_10_food_67_r_2
                    + fasele + food_male_plan_10_food_67_r_3
                    + fasele + food_male_plan_10_food_67_r_4;

            food_male_plan_10_food_68_r = food_male_plan_10_food_68_r_1
                    + fasele + food_male_plan_10_food_68_r_2
                    + fasele + food_male_plan_10_food_68_r_3
                    + fasele + food_male_plan_10_food_68_r_4
                    + fasele + food_male_plan_10_food_68_r_5
                    + fasele + food_male_plan_10_food_68_r_6
                    + fasele + food_male_plan_10_food_68_r_7;

            food_male_plan_10_food_69_r = food_male_plan_10_food_69_r_1;

            food_male_plan_10_food_70_r = food_male_plan_10_food_70_r_1
                    + fasele + food_male_plan_10_food_70_r_2
                    + fasele + food_male_plan_10_food_70_r_3
                    + fasele + food_male_plan_10_food_70_r_4;

            food_male_plan_10_food_71_r = food_male_plan_10_food_71_r_1
                    + fasele + food_male_plan_10_food_71_r_2
                    + fasele + food_male_plan_10_food_71_r_3;

            food_male_plan_10_food_72_r = food_male_plan_10_food_72_r_1
                    + fasele + food_male_plan_10_food_72_r_2
                    + fasele + food_male_plan_10_food_72_r_3
                    + fasele + food_male_plan_10_food_72_r_4;

            food_male_plan_10_food_73_r = food_male_plan_10_food_73_r_1
                    + fasele + food_male_plan_10_food_73_r_2
                    + fasele + food_male_plan_10_food_73_r_3;

            food_male_plan_10_food_74_r = food_male_plan_10_food_74_r_1
                    + fasele + food_male_plan_10_food_74_r_2
                    + fasele + food_male_plan_10_food_74_r_3;

            food_male_plan_10_food_75_r = food_male_plan_10_food_75_r_1
                    + fasele + food_male_plan_10_food_75_r_2
                    + fasele + food_male_plan_10_food_75_r_3
                    + fasele + food_male_plan_10_food_75_r_4
                    + fasele + food_male_plan_10_food_75_r_5
                    + fasele + food_male_plan_10_food_75_r_6;

            food_male_plan_10_food_76_r = food_male_plan_10_food_76_r_1
                    + fasele + food_male_plan_10_food_76_r_2
                    + fasele + food_male_plan_10_food_76_r_3
                    + fasele + food_male_plan_10_food_76_r_4;

            food_male_plan_10_food_77_r = food_male_plan_10_food_77_r_1
                    + fasele + food_male_plan_10_food_77_r_2
                    + fasele + food_male_plan_10_food_77_r_3
                    + fasele + food_male_plan_10_food_77_r_4
                    + fasele + food_male_plan_10_food_77_r_5
                    + fasele + food_male_plan_10_food_77_r_6;

            food_male_plan_10_food_78_r = food_male_plan_10_food_78_r_1
                    + fasele + food_male_plan_10_food_78_r_2
                    + fasele + food_male_plan_10_food_78_r_3
                    + fasele + food_male_plan_10_food_78_r_4
                    + fasele + food_male_plan_10_food_78_r_5
                    + fasele + food_male_plan_10_food_78_r_6
                    + fasele + food_male_plan_10_food_78_r_7
                    + fasele + food_male_plan_10_food_78_r_8
                    + fasele + food_male_plan_10_food_78_r_9;

            food_male_plan_10_food_79_r = food_male_plan_10_food_79_r_1
                    + fasele + food_male_plan_10_food_79_r_2
                    + fasele + food_male_plan_10_food_79_r_3
                    + fasele + food_male_plan_10_food_79_r_4
                    + fasele + food_male_plan_10_food_79_r_5;

            food_male_plan_10_food_80_r = food_male_plan_10_food_80_r_1
                    + fasele + food_male_plan_10_food_80_r_2
                    + fasele + food_male_plan_10_food_80_r_3
                    + fasele + food_male_plan_10_food_80_r_4
                    + fasele + food_male_plan_10_food_80_r_5;

            food_male_plan_10_food_81_r = food_male_plan_10_food_81_r_1
                    + fasele + food_male_plan_10_food_81_r_2
                    + fasele + food_male_plan_10_food_81_r_3
                    + fasele + food_male_plan_10_food_81_r_4
                    + fasele + food_male_plan_10_food_81_r_5
                    + fasele + food_male_plan_10_food_81_r_6;

            food_male_plan_10_food_82_r = food_male_plan_10_food_82_r_1
                    + fasele + food_male_plan_10_food_82_r_2
                    + fasele + food_male_plan_10_food_82_r_3
                    + fasele + food_male_plan_10_food_82_r_4;

            food_male_plan_10_food_83_r = food_male_plan_10_food_83_r_1
                    + fasele + food_male_plan_10_food_83_r_2
                    + fasele + food_male_plan_10_food_83_r_3
                    + fasele + food_male_plan_10_food_83_r_4
                    + fasele + food_male_plan_10_food_83_r_5
                    + fasele + food_male_plan_10_food_83_r_6;

            food_male_plan_10_food_84_r = food_male_plan_10_food_84_r_1
                    + fasele + food_male_plan_10_food_84_r_2
                    + fasele + food_male_plan_10_food_84_r_3
                    + fasele + food_male_plan_10_food_84_r_4;

            food_male_plan_10_food_101_r = food_male_plan_10_food_101_r_1
                    + fasele + food_male_plan_10_food_101_r_2
                    + fasele + food_male_plan_10_food_101_r_3
                    + fasele + food_male_plan_10_food_101_r_4
                    + fasele + food_male_plan_10_food_101_r_5
                    + fasele + food_male_plan_10_food_101_r_6;

            food_male_plan_10_food_102_r = food_male_plan_10_food_102_r_1
                    + fasele + food_male_plan_10_food_102_r_2
                    + fasele + food_male_plan_10_food_102_r_3
                    + fasele + food_male_plan_10_food_102_r_4
                    + fasele + food_male_plan_10_food_102_r_5
                    + fasele + food_male_plan_10_food_102_r_6;


            food_male_plan_10_food_107_r = food_male_plan_10_food_103_r_1
                    + fasele + food_male_plan_10_food_103_r_2
                    + fasele + food_male_plan_10_food_103_r_3
                    + fasele + food_male_plan_10_food_103_r_4
                    + fasele + food_male_plan_10_food_103_r_5
                    + fasele + food_male_plan_10_food_103_r_6;

            food_male_plan_10_food_108_r = food_male_plan_10_food_104_r_1
                    + fasele + food_male_plan_10_food_104_r_2
                    + fasele + food_male_plan_10_food_104_r_3
                    + fasele + food_male_plan_10_food_104_r_4;

            food_male_plan_10_food_113_r = food_male_plan_10_food_113_r_1
                    + fasele + food_male_plan_10_food_113_r_2
                    + fasele + food_male_plan_10_food_113_r_3
                    + fasele + food_male_plan_10_food_113_r_4;

            food_male_plan_10_food_114_r = food_male_plan_10_food_114_r_1
                    + fasele + food_male_plan_10_food_114_r_2
                    + fasele + food_male_plan_10_food_114_r_3;


            food_male_plan_10_food_119_r = food_male_plan_10_food_119_r_1
                    + fasele + food_male_plan_10_food_119_r_2
                    + fasele + food_male_plan_10_food_119_r_3
                    + fasele + food_male_plan_10_food_119_r_4;

            food_male_plan_10_food_120_r = food_male_plan_10_food_120_r_1;
        }


        if (app_net.getInstance(this).isOnline()) {

            Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, net_off, Toast.LENGTH_LONG).show();

        }

        try {

            Bundle colery = getIntent().getExtras();
            fff = colery.getInt("food_number_1");

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
                vibre_check = "true";
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }


        ImageView back = (ImageView) findViewById(R.id.im_back_male_plan);

        back.setOnClickListener(this);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager2);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 1) {
                    case 0:
                        return food_male_plan_10_food_1.newInstance();
                    default:
                        return food_male_plan_10_food_1.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 1) {
                    case 0:
                        if (fff == 1) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_1);
                            return ss1;
                        } else if (fff == 2) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_2);
                            return ss1;
                        } else if (fff == 3) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_3);
                            return ss1;
                        } else if (fff == 4) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_4);
                            return ss1;
                        } else if (fff == 5) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_5);
                            return ss1;
                        } else if (fff == 6) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_6);
                            return ss1;
                        } else if (fff == 7) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_7);
                            return ss1;
                        } else if (fff == 8) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_8);
                            return ss1;
                        } else if (fff == 9) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_9);
                            return ss1;
                        } else if (fff == 10) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_10);
                            return ss1;
                        } else if (fff == 11) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_11);
                            return ss1;
                        } else if (fff == 12) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_12);
                            return ss1;
                        } else if (fff == 13) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_13);
                            return ss1;
                        } else if (fff == 14) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_14);
                            return ss1;
                        } else if (fff == 15) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_15);
                            return ss1;
                        } else if (fff == 16) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_16);
                            return ss1;
                        } else if (fff == 17) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_17);
                            return ss1;
                        } else if (fff == 18) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_18);
                            return ss1;
                        } else if (fff == 19) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_19);
                            return ss1;
                        } else if (fff == 20) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_20);
                            return ss1;
                        } else if (fff == 21) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_21);
                            return ss1;
                        } else if (fff == 22) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_22);
                            return ss1;
                        } else if (fff == 23) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_23);
                            return ss1;
                        } else if (fff == 24) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_24);
                            return ss1;
                        } else if (fff == 25) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_25);
                            return ss1;
                        } else if (fff == 26) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_26);
                            return ss1;
                        } else if (fff == 27) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_27);
                            return ss1;
                        } else if (fff == 28) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_28);
                            return ss1;
                        } else if (fff == 29) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_29);
                            return ss1;
                        } else if (fff == 30) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_30);
                            return ss1;
                        } else if (fff == 31) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_31);
                            return ss1;
                        } else if (fff == 32) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_32);
                            return ss1;
                        } else if (fff == 33) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_33);
                            return ss1;
                        } else if (fff == 34) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_34);
                            return ss1;
                        } else if (fff == 35) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_35);
                            return ss1;
                        } else if (fff == 36) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_36);
                            return ss1;
                        } else if (fff == 37) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_37);
                            return ss1;
                        } else if (fff == 38) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_38);
                            return ss1;
                        } else if (fff == 39) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_39);
                            return ss1;
                        } else if (fff == 40) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_40);
                            return ss1;
                        } else if (fff == 41) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_41);
                            return ss1;
                        } else if (fff == 42) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_42);
                            return ss1;
                        } else if (fff == 43) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_43);
                            return ss1;
                        } else if (fff == 44) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_44);
                            return ss1;
                        } else if (fff == 45) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_45);
                            return ss1;
                        } else if (fff == 46) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_46);
                            return ss1;
                        } else if (fff == 47) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_47);
                            return ss1;
                        } else if (fff == 48) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_48);
                            return ss1;
                        } else if (fff == 49) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_49);
                            return ss1;
                        } else if (fff == 50) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_50);
                            return ss1;
                        } else if (fff == 51) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_51);
                            return ss1;
                        } else if (fff == 52) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_52);
                            return ss1;
                        } else if (fff == 53) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_53);
                            return ss1;
                        } else if (fff == 54) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_54);
                            return ss1;
                        } else if (fff == 55) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_55);
                            return ss1;
                        } else if (fff == 56) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_56);
                            return ss1;
                        } else if (fff == 57) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_57);
                            return ss1;
                        } else if (fff == 58) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_58);
                            return ss1;
                        } else if (fff == 59) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_59);
                            return ss1;
                        } else if (fff == 60) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_60);
                            return ss1;
                        } else if (fff == 61) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_61);
                            return ss1;
                        } else if (fff == 62) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_62);
                            return ss1;
                        } else if (fff == 63) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_63);
                            return ss1;
                        } else if (fff == 64) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_64);
                            return ss1;
                        } else if (fff == 65) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_65);
                            return ss1;
                        } else if (fff == 66) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_66);
                            return ss1;
                        } else if (fff == 67) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_67);
                            return ss1;
                        } else if (fff == 68) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_68);
                            return ss1;
                        } else if (fff == 69) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_69);
                            return ss1;
                        } else if (fff == 70) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_70);
                            return ss1;
                        } else if (fff == 71) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_71);
                            return ss1;
                        } else if (fff == 72) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_72);
                            return ss1;
                        } else if (fff == 73) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_73);
                            return ss1;
                        } else if (fff == 74) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_74);
                            return ss1;
                        } else if (fff == 75) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_75);
                            return ss1;
                        } else if (fff == 76) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_76);
                            return ss1;
                        } else if (fff == 77) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_77);
                            return ss1;
                        } else if (fff == 78) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_78);
                            return ss1;
                        } else if (fff == 79) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_79);
                            return ss1;
                        } else if (fff == 80) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_80);
                            return ss1;
                        } else if (fff == 81) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_81);
                            return ss1;
                        } else if (fff == 82) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_82);
                            return ss1;
                        } else if (fff == 83) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_83);
                            return ss1;
                        } else if (fff == 84) {
                            ss1 = (String) getText(R.string.food_male_plan_10_food_name_84);
                            return ss1;
                        } else if (fff == 101) {
                            ss1 = (String) getText(R.string.meal_plan_31_1);
                            return ss1;
                        } else if (fff == 102) {
                            ss1 = (String) getText(R.string.meal_plan_32_1);
                            return ss1;
                        } else if (fff == 103) {
                            ss1 = (String) getText(R.string.meal_plan_31_1);
                            return ss1;
                        } else if (fff == 104) {
                            ss1 = (String) getText(R.string.meal_plan_32_1);
                            return ss1;
                        } else if (fff == 105) {
                            ss1 = (String) getText(R.string.meal_plan_31_1);
                            return ss1;
                        } else if (fff == 106) {
                            ss1 = (String) getText(R.string.meal_plan_32_1);
                            return ss1;
                        } else if (fff == 107) {
                            ss1 = (String) getText(R.string.meal_plan_33_1);
                            return ss1;
                        } else if (fff == 108) {
                            ss1 = (String) getText(R.string.meal_plan_34_1);
                            return ss1;
                        } else if (fff == 109) {
                            ss1 = (String) getText(R.string.meal_plan_33_1);
                            return ss1;
                        } else if (fff == 110) {
                            ss1 = (String) getText(R.string.meal_plan_34_1);
                            return ss1;
                        } else if (fff == 111) {
                            ss1 = (String) getText(R.string.meal_plan_33_1);
                            return ss1;
                        } else if (fff == 112) {
                            ss1 = (String) getText(R.string.meal_plan_34_1);
                            return ss1;
                        } else if (fff == 113) {
                            ss1 = (String) getText(R.string.meal_plan_35_1);
                            return ss1;
                        } else if (fff == 114) {
                            ss1 = (String) getText(R.string.meal_plan_36_1);
                            return ss1;
                        } else if (fff == 115) {
                            ss1 = (String) getText(R.string.meal_plan_35_1);
                            return ss1;
                        } else if (fff == 116) {
                            ss1 = (String) getText(R.string.meal_plan_36_1);
                            return ss1;
                        } else if (fff == 117) {
                            ss1 = (String) getText(R.string.meal_plan_35_1);
                            return ss1;
                        } else if (fff == 118) {
                            ss1 = (String) getText(R.string.meal_plan_36_1);
                            return ss1;
                        } else if (fff == 119) {
                            ss1 = (String) getText(R.string.meal_plan_37_1);
                            return ss1;
                        } else if (fff == 120) {
                            ss1 = (String) getText(R.string.meal_plan_38_1);
                            return ss1;
                        } else if (fff == 121) {
                            ss1 = (String) getText(R.string.meal_plan_37_1);
                            return ss1;
                        } else if (fff == 122) {
                            ss1 = (String) getText(R.string.meal_plan_38_1);
                            return ss1;
                        } else if (fff == 123) {
                            ss1 = (String) getText(R.string.meal_plan_37_1);
                            return ss1;
                        } else if (fff == 124) {
                            ss1 = (String) getText(R.string.meal_plan_38_1);
                            return ss1;
                        }

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
                if (fff == 1) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267577726/p_RU219045.jpg");
                } else if (fff == 2) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267623568/p_R151419.jpg");
                } else if (fff == 3) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267625750/p_R132871.jpg");
                } else if (fff == 4) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267626968/p_RU28541.jpg");
                } else if (fff == 5) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267630100/p_R151409.jpg");
                } else if (fff == 6) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267632076/R089890_jpg_rendition_largest.jpg");
                } else if (fff == 7) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267634292/R155075_jpg_rendition_largest.jpg");
                } else if (fff == 8) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267634418/R135678_jpg_rendition_largest.jpg");
                } else if (fff == 9) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267694668/PiriPiriChickenwtihSlaw_WebReady.png");
                } else if (fff == 10) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267698684/chicken_parmigiana_WebReady.png");
                } else if (fff == 11) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267699400/Butter_Chicken_with_Naan_2_WebReady.png");
                } else if (fff == 12) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267704392/Kickin_Chicken_Kiev_001_1_.png");
                } else if (fff == 13) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267707750/4b8a8fcf_ce12_4d23_aa73_2fb75048f73b_Chicken_Burgers_with_Coleslaw_Russia_WebReady_1_.png");
                } else if (fff == 14) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267710026/Chicken_Tikka_Masala_ep_2_WebReady_1_.png");
                } else if (fff == 15) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267720542/falafel_with_chipotle_tahini_dip_WebReady_1_.png");
                } else if (fff == 16) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267746042/Quick_Ratatouille_jpg_1_.jpg");
                } else if (fff == 17) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267750676/CitrusRoastBeef.jpg");
                } else if (fff == 18) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267751792/Pork_Fried_Rice_17201.jpg");
                } else if (fff == 19) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267758700/9_Presentaci%C3%B3n_sushi_1_.jpg");
                } else if (fff == 20) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267759968/sr_fresh_beef_rav_1_.png");
                } else if (fff == 21) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267761700/chickennuggets_wide_290cf617c0504d91611478afd36223ca5ebbdffe_1_.jpg");
                } else if (fff == 22) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267762692/tuna_avocado_sandwich_horiz_800_1_.jpg");
                } else if (fff == 23) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267763184/pork_schnitzel_with_sweet_potato_chips_1456_l_1_.jpeg");
                } else if (fff == 24) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267763918/Anova_9_24_14_13_1_.jpg");
                } else if (fff == 25) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267764926/4a4d1de7666835f233b9098a0cf389ca_1_.jpg");
                } else if (fff == 26) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267765118/4159_1_.jpg");
                } else if (fff == 27) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267765550/hamburguesas_taberna_la_tata_sevilla_1_.jpg");
                } else if (fff == 28) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267765642/deep_fried_cauliflower_1_21_1_.jpg");
                } else if (fff == 29) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267766000/chocolate_chip_banana_bran_muffins_1086_1_.jpg");
                } else if (fff == 30) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267993642/recipe_image_legacy_id_1201615_11_1_.jpg");
                } else if (fff == 31) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267993868/recipe_image_legacy_id_981494_10.jpg");
                } else if (fff == 32) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267994250/spicychickenavocadowraps_5865.jpg");
                } else if (fff == 33) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8267994368/recipe_image_legacy_id_1047459_10.jpg");
                } else if (fff == 34) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267994618/potato_salad_anchovy_quails_eggs.jpg");
                } else if (fff == 35) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267994784/recipe_image_legacy_id_1074500_11.jpg");
                } else if (fff == 36) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267994926/recipe_image_legacy_id_1273596_8.jpg");
                } else if (fff == 37) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267995084/recipe_image_legacy_id_10733_11.jpg");
                } else if (fff == 38) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8267995234/recipe_image_legacy_id_1259671_8.jpg");
                } else if (fff == 39) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268204976/recipe_image_legacy_id_7360_11.jpg");
                } else if (fff == 40) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268206700/recipe_image_legacy_id_338571_12.jpg");
                } else if (fff == 41) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268209334/recipe_image_legacy_id_954452_11.jpg");
                } else if (fff == 42) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220126/recipe_image_legacy_id_693594_11.jpg");
                } else if (fff == 43) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220268/recipe_image_legacy_id_776558_11.jpg");
                } else if (fff == 44) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268220292/recipe_image_legacy_id_1035696_10.jpg");
                } else if (fff == 45) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268220318/recipe_image_legacy_id_684574_11.jpg");
                } else if (fff == 46) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220376/recipe_image_legacy_id_281726_11.jpg");
                } else if (fff == 47) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220392/recipe_image_legacy_id_1201548_11.jpg");
                } else if (fff == 48) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220418/recipe_image_legacy_id_967471_11.jpg");
                } else if (fff == 49) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220468/recipe_image_legacy_id_52118_11.jpg");
                } else if (fff == 50) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268220476/recipe_image_legacy_id_1068489_11.jpg");
                } else if (fff == 51) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268220492/recipe_image_legacy_id_1176498_10.jpg");
                } else if (fff == 52) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220526/crunchy_bulghar_salad.jpg");
                } else if (fff == 53) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220592/veggie_tahini_lentils.jpg");
                } else if (fff == 54) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220600/halloumi_with_lemony_lentil_salad.jpg");
                } else if (fff == 55) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220634/recipe_image_legacy_id_5283_11.jpg");
                } else if (fff == 56) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268220692/harissa_chicken_traybake.jpg");
                } else if (fff == 57) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268274242/chicken_soup_2400_l.jpeg");
                } else if (fff == 58) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268275526/bocconcini_and_tomato_glutenfree_pizza_31733_l.jpeg");
                } else if (fff == 59) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268277242/vegetable_frittata_19011_l.jpeg");
                } else if (fff == 60) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268277792/tuna_rice_salad_11440_l.jpeg");
                } else if (fff == 61) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268279500/rice_cakes_1350_l.jpeg");
                } else if (fff == 62) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268280184/spinach_and_ham_frittata_16037_l.jpeg");
                } else if (fff == 63) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268281384/thai_beef_salad_wrap_15356_l.jpeg");
                } else if (fff == 64) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268283284/pasta_salad_with_lentils_pesto_beans_29097_l.jpeg");
                } else if (fff == 65) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268308300/baked_ling_with_tomatoes_thyme_and_olives_6119_l.jpeg");
                } else if (fff == 66) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268309592/freeform_kale_ricotta_and_pesto_lasagne_32279_l.jpeg");
                } else if (fff == 67) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268310218/kimchi_fried_rice_with_bacon_and_eggs_32154_l.jpeg");
                } else if (fff == 68) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268311884/asianstyle_fish_and_sesamesalt_chips_23672_l.jpeg");
                } else if (fff == 69) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268321100/1092820.jpg");
                } else if (fff == 70) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268325542/3856414.jpg");
                } else if (fff == 71) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268327192/butternut_soup_with_crispy_sage_apple_croutons.jpg");
                } else if (fff == 72) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268329550/recipe_image_legacy_id_491536_11.jpg");
                } else if (fff == 73) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268336992/recipe_image_legacy_id_1915_11.jpg");
                } else if (fff == 74) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268337126/spaghetti_smoky_tomato_seafood_sauce.jpg");
                } else if (fff == 75) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268337168/eggs_florentine_pizza.jpg");
                } else if (fff == 76) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268337250/recipe_image_legacy_id_659514_11.jpg");
                } else if (fff == 77) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268337334/fish_stew_roast_garlic_saffron.jpg");
                } else if (fff == 78) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268339368/spaghetti_squash_casserole_44.png");
                } else if (fff == 79) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268341292/favorite_frittata_22.png");
                } else if (fff == 80) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268341534/squash_11_700x1045.png");
                } else if (fff == 81) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s9.picofile.com/file/8268341850/caprese_quinoa_casserole_3.png");
                } else if (fff == 82) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268342068/22_1_700x1045.jpg");
                } else if (fff == 83) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268342176/1_7_700x1045.jpg");
                } else if (fff == 84) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s8.picofile.com/file/8268342242/18.jpg");
                } else if (fff == 101) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s7.picofile.com/file/8284800192/meatballs.jpg");
                } else if (fff == 102) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s7.picofile.com/file/8284800250/1648065.jpg");
                } else if (fff == 103) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s7.picofile.com/file/8284812784/Chicken_Meatballs_Feature_680x340.jpeg");
                } else if (fff == 104) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s1.picofile.com/file/8284812342/Chicken_Olivye_10_187x187.jpg");
                } else if (fff == 105) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s1.picofile.com/file/8284812818/Glazed_Meatballs_Diethood.jpg");
                } else if (fff == 106) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s4.picofile.com/file/8284812400/Screen_Shot_2013_12_10_at_12_41_37_PM.png");
                } else if (fff == 107) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s3.picofile.com/file/8284814768/veg_cutlet_recipe.jpg");
                } else if (fff == 108) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s1.picofile.com/file/8284815334/f66f61b8_60d8_4f6a_8608_ffe98b64e014.jpg");
                } else if (fff == 109) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s5.picofile.com/file/8284814818/14663694193_e7abc3eda9_o.jpg");
                } else if (fff == 110) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s4.picofile.com/file/8284815368/p_RU189256.jpg");
                } else if (fff == 111) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s6.picofile.com/file/8284814884/dude_diet_chicken_cutlets_and_zucchini_pasta_with_cherry_tomatoes_4.jpg");
                } else if (fff == 112) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s7.picofile.com/file/8284815418/Roasted_Vegetable_Pizza.jpg");
                } else if (fff == 113) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s6.picofile.com/file/8284860226/veggie_pizza.jpg");
                } else if (fff == 114) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s5.picofile.com/file/8284860000/hearty_winter_vegetable_soup_3.jpg");
                } else if (fff == 115) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s1.picofile.com/file/8284860218/vegan_pizza_vegetable.jpg");
                } else if (fff == 116) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s2.picofile.com/file/8284860034/Tuscan_Vegetable_Sausage_Soup_1411135505.jpg");
                } else if (fff == 117) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s5.picofile.com/file/8284860200/Homemade_Roasted_Vegetable_Pizza.jpg");
                } else if (fff == 118) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s1.picofile.com/file/8284860042/vegetable_soup3_edit_srgb_.jpg");
                } else if (fff == 119) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s3.picofile.com/file/8284862776/Beets_Roasted.jpg");
                } else if (fff == 120) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s6.picofile.com/file/8284862868/2.jpg");
                } else if (fff == 121) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s5.picofile.com/file/8284862784/BX0504H_roasted_beets_s4x3.png");
                } else if (fff == 122) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s5.picofile.com/file/8284862876/H2_Healthy_Kale_Salad_1.png");
                } else if (fff == 123) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s2.picofile.com/file/8284862792/roasted_beets_balsamic_glaze_vertical_a_2000.jpg");
                } else if (fff == 124) {
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.color30day,
                            "http://s6.picofile.com/file/8284862868/2.jpg");
                }


                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });


        FirebaseCrash.log("log 2");
        System.gc();

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
                    FirebaseCrash.report(new Exception("7"));
                }

                try {

                    click = MediaPlayer.create(food_male_plan_10_food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("8"));
                }

                finish();

                break;

        }
        FirebaseCrash.log("log 1");
    }

}

