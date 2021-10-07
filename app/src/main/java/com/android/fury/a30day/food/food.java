package com.android.fury.a30day.food;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.App;
import com.android.fury.a30day.App_food;
import com.android.fury.a30day.Database.MyDatabaseHelper_food_1;
import com.android.fury.a30day.Database.MyDatabaseHelper_food_2;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.Not_net;
import com.android.fury.a30day.R;
import com.android.fury.a30day.Suport.Suport_me;
import com.android.fury.a30day.alert.SweetAlertDialog;
import com.android.fury.a30day.app_net;
import com.android.fury.a30day.page.Page_1;
import com.android.fury.a30day.sport.sport;
import com.google.firebase.crash.FirebaseCrash;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.text.DecimalFormat;
import java.util.Locale;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Created by fury on 8/30/2016.
 */
public class food extends Activity implements View.OnClickListener {


    private final int _splashTime = 1000;
    private final int _splashTime2 = 500;

    public static Activity fa;

    int time_1 = 1;

    private SharedPreferences seek_old_preferences, seek_weight_preferences, seek_length_preferences, save_info_preferences;
    private SharedPreferences.Editor seek_old_editor, seek_weight_editor, seek_length_editor, save_info_editor;
    private int CHECKED_STATE_4, CHECKED_STATE_5, CHECKED_STATE_7;

    TextView weight, old, kg_1, year_1, female_111, male_111, confirm, length, cm, inactive_, low_, medium_, hard_, veryhard_, alakiha_26;

    ImageView back_page, female_off, female_on, male_off, male_on, confirm_off, inactive_off, inactive_on, low_off, low_on, medium_off, medium_on, hard_off, hard_on, veryhard_off, veryhard_on, btn_menu;

    LinearLayout sports, diet, dmusic, settings, about, help, exit;

    String menu_exit, about_alertdialog_6, about_alertdialog_7, about_alertdialog_8, about_alertdialog_9, no, yes, music_check, music_off_check, vibre_check, id, check_fm, yaer, kg, strI_3, strI_2, strI_1, strI, strI_5, cm_1, check_ac, send_length, send_year, send_weight, bundle_food_1, bundle_food_2, bundle_food_3, bundle_food_gender, bundle_food_tall, bundle_food_weight, weight_not, year_not, gernder_not, food_hight_not, food_activity_not, food_next_not, food_show_1, food_show_2, food_show_3, food_show_4, food_show_5, food_show_6;

    DrawerLayout drawerlayout;

    RelativeLayout rl_food_f_m_2, rl_food_f_m_1;

    MediaPlayer click;

    Vibrator vb;

    Double answer, answer_kahesh, answer_test, answer_test_2, answer_test_3, answer_test_4;

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;
    MyDatabaseHelper_food_1 food_data_1;
    MyDatabaseHelper_food_2 food_data_2;

    DecimalFormat df;

    int help_play, zab, play_dalog;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MaterialTapTargetPrompt mFabPrompt;

    SweetAlertDialog sd2;


    private boolean CHECKED_STATE_9;

    private SharedPreferences food_preferences;
    private SharedPreferences.Editor food_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_food);


        try {

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();
            help_play = one_play_preferences.getInt("Help_play_6", 1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

        try {


            save_info_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            save_info_editor = save_info_preferences.edit();
            play_dalog = save_info_preferences.getInt("play_number_dalog", 1);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("save info 1"));
        }

        try {

            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        try {

            food_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            food_editor = food_preferences.edit();
            CHECKED_STATE_9 = food_preferences.getBoolean("check_show_food", true);
            food_show_1 = one_play_preferences.getString("gender_food_1_show", "NO INFO");
            food_show_2 = one_play_preferences.getString("weight_food_1_show", "NO INFO");
            food_show_3 = one_play_preferences.getString("bmr_food_1_show", "NO INFO");
            food_show_4 = one_play_preferences.getString("bmr_food_cahesh_show", "NO INFO");
            food_show_5 = one_play_preferences.getString("tall_food_1_show", "NO INFO");
            food_show_6 = one_play_preferences.getString("weight_food_meghdar_1_show", "NO INFO");

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("get save food info"));
        }

        if (CHECKED_STATE_9) {
        } else {
            try {
                Intent co_food_1 = new Intent(this, food_page_org.class);
                co_food_1.putExtra("gender_food_1", food_show_1);
                co_food_1.putExtra("weight_food_1", food_show_2);
                co_food_1.putExtra("bmr_food_1", food_show_3);
                co_food_1.putExtra("bmr_food_cahesh", food_show_4);
                co_food_1.putExtra("tall_food_1", food_show_5);
                co_food_1.putExtra("weight_food_meghdar_1", food_show_6);
                startActivity(co_food_1);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("start food show 1"));
            }
            finish();
        }


        Bundle colery = getIntent().getExtras();
        zab = colery.getInt("zaban_fo");

        df = new DecimalFormat("#.##");

        fa = this;

        try {

            food_data_1 = new MyDatabaseHelper_food_1(this);
            food_data_2 = new MyDatabaseHelper_food_2(this);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }


        //az bein bordn shekle scrollview
        ScrollView sView = (ScrollView) findViewById(R.id.scrollview_1);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        final ScrollView sView_2 = (ScrollView) findViewById(R.id.scrollView2);
        sView_2.setVerticalScrollBarEnabled(false);
        sView_2.setHorizontalScrollBarEnabled(false);


        final DiscreteSeekBar seekbar_weight = (DiscreteSeekBar) findViewById(R.id.seekbar_weight);
        final DiscreteSeekBar seekbar_old = (DiscreteSeekBar) findViewById(R.id.seekbar_old);
        final DiscreteSeekBar seekbar_length = (DiscreteSeekBar) findViewById(R.id.seekbar_length);
        weight = (TextView) findViewById(R.id.txt_food_weight);
        kg_1 = (TextView) findViewById(R.id.txt_food_weight_kg);
        old = (TextView) findViewById(R.id.txt_food_old);
        cm = (TextView) findViewById(R.id.txt_food_cm);
        year_1 = (TextView) findViewById(R.id.txt_food_old_yaer);
        female_111 = (TextView) findViewById(R.id.txt_food_female);
        confirm = (TextView) findViewById(R.id.txt_confirm_1);
        male_111 = (TextView) findViewById(R.id.txt_food_male);
        length = (TextView) findViewById(R.id.txt_food_length);
        inactive_ = (TextView) findViewById(R.id.txt_activity_inactive);
        low_ = (TextView) findViewById(R.id.txt_activity_low);
        medium_ = (TextView) findViewById(R.id.txt_activity_medium);
        hard_ = (TextView) findViewById(R.id.txt_activity_hard);
        veryhard_ = (TextView) findViewById(R.id.txt_activity_veryhard);
        back_page = (ImageView) findViewById(R.id.btn_back_page2);
        btn_menu = (ImageView) findViewById(R.id.btn_menu);
        about = (LinearLayout) findViewById(R.id.lin_menu_ab);
        diet = (LinearLayout) findViewById(R.id.lin_menu_d);
        dmusic = (LinearLayout) findViewById(R.id.lin_menu_dm);
        exit = (LinearLayout) findViewById(R.id.lin_menu_ex);
        settings = (LinearLayout) findViewById(R.id.lin_menu_sit);
        sports = (LinearLayout) findViewById(R.id.lin_menu_sp);
        help = (LinearLayout) findViewById(R.id.lin_menu_gu);
        female_off = (ImageView) findViewById(R.id.im_female_off);
        female_on = (ImageView) findViewById(R.id.im_female_on);
        male_off = (ImageView) findViewById(R.id.im_male_off);
        male_on = (ImageView) findViewById(R.id.im_male_on);
        confirm_off = (ImageView) findViewById(R.id.im_food_confirm_off);
        inactive_off = (ImageView) findViewById(R.id.im_activity_inactive_off);
        inactive_on = (ImageView) findViewById(R.id.im_activity_inactive_on);
        low_on = (ImageView) findViewById(R.id.im_activity_low_on);
        low_off = (ImageView) findViewById(R.id.im_activity_low_off);
        medium_off = (ImageView) findViewById(R.id.im_activity_medium_off);
        medium_on = (ImageView) findViewById(R.id.im_activity_medium_on);
        hard_on = (ImageView) findViewById(R.id.im_activity_hard_on);
        hard_off = (ImageView) findViewById(R.id.im_activity_hard_off);
        veryhard_off = (ImageView) findViewById(R.id.im_activity_veryhard_off);
        veryhard_on = (ImageView) findViewById(R.id.im_activity_veryhard_on);
        rl_food_f_m_2 = (RelativeLayout) findViewById(R.id.rl_food_f_m_2);
        rl_food_f_m_1 = (RelativeLayout) findViewById(R.id.rl_food_f_m_1);
        alakiha_26 = (TextView) findViewById(R.id.alakiha_26);

        back_page.setOnClickListener(this);
        btn_menu.setOnClickListener(this);
        about.setOnClickListener(this);
        dmusic.setOnClickListener(this);
        diet.setOnClickListener(this);
        sports.setOnClickListener(this);
        settings.setOnClickListener(this);
        exit.setOnClickListener(this);
        help.setOnClickListener(this);
        female_off.setOnClickListener(this);
        female_on.setOnClickListener(this);
        male_off.setOnClickListener(this);
        male_on.setOnClickListener(this);
        confirm_off.setOnClickListener(this);
        inactive_off.setOnClickListener(this);
        inactive_on.setOnClickListener(this);
        low_on.setOnClickListener(this);
        low_off.setOnClickListener(this);
        medium_off.setOnClickListener(this);
        medium_on.setOnClickListener(this);
        hard_on.setOnClickListener(this);
        hard_off.setOnClickListener(this);
        veryhard_off.setOnClickListener(this);
        veryhard_on.setOnClickListener(this);

        if (zab == 1) {

            TextView text_food_zab_1 = (TextView) findViewById(R.id.text_food_zab_1);
            TextView text_food_zab_2 = (TextView) findViewById(R.id.text_food_zab_2);
            TextView text_food_zab_3 = (TextView) findViewById(R.id.text_food_zab_3);
            TextView txt_activity = (TextView) findViewById(R.id.txt_activity);
            TextView txt_gender_1 = (TextView) findViewById(R.id.txt_gender_1);
            TextView text_food_rem_1 = (TextView) findViewById(R.id.text_food_rem_1);

            text_food_zab_1.setText("وزن شما ");
            text_food_zab_2.setText("سن");
            text_food_zab_3.setText("قد");
            txt_activity.setText("فعالیت روزانه خود را انتخاب کنید ?");
            txt_gender_1.setText("جنسیت شما چیست ?");
            text_food_rem_1.setText("سعی کنید هر 7 روز وزن خود را چک کنید");

            yaer = " سال ";
            kg = " کیلوگرم ";
            cm_1 = " سانتی متر ";

            low_.setText("کم");
            medium_.setText("متوسط");
            hard_.setText("سخت");
            veryhard_.setText("خیلی سخت");
            inactive_.setText("غیر فعال");
            male_111.setText("آقا");
            female_111.setText("خانم");
            confirm.setText("تایید");

            about_alertdialog_6 = "میخواهی بروی ؟";
            about_alertdialog_7 = "آیا مطمئن هستید؟";
            about_alertdialog_8 = "بعدا میبینمت";
            about_alertdialog_9 = "خداحافظ :)";
            menu_exit = "خروج!";
            no = "نه";
            yes = "بله";


            weight_not = "لطفا وزن خود را وارد کنید";
            year_not = "لطفا سن خود را وارد کنید";
            gernder_not = "لطفا جنسیت خود را وارد کنید";
            food_hight_not = "لطفا قد خود را وارد کنید";
            food_activity_not = "لطفا فعالیت خود را وارد کنید";
            food_next_not = "لطفا اطلاعات خود را وارد کنید.";

        } else if (zab == 3) {

            yaer = " Year ";
            kg = " KG ";
            cm_1 = " Cm ";

            about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
            about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);
            about_alertdialog_8 = (String) getText(R.string.about_alertdialog_8);
            about_alertdialog_9 = (String) getText(R.string.about_alertdialog_9);
            menu_exit = (String) getText(R.string.menu_exit2);
            no = (String) getText(R.string.no);
            yes = (String) getText(R.string.yes);

            weight_not = (String) getText(R.string.food_weight_not);
            year_not = (String) getText(R.string.food_year_not);
            gernder_not = (String) getText(R.string.food_gender_not);
            food_hight_not = (String) getText(R.string.food_height_not);
            food_activity_not = (String) getText(R.string.food_activity_not);
            food_next_not = (String) getText(R.string.food_next_not);

        } else if (zab == 4) {

            yaer = " Year ";
            kg = " KG ";
            cm_1 = " Cm ";

            about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
            about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);
            about_alertdialog_8 = (String) getText(R.string.about_alertdialog_8);
            about_alertdialog_9 = (String) getText(R.string.about_alertdialog_9);
            menu_exit = (String) getText(R.string.menu_exit2);
            no = (String) getText(R.string.no);
            yes = (String) getText(R.string.yes);

            weight_not = (String) getText(R.string.food_weight_not);
            year_not = (String) getText(R.string.food_year_not);
            gernder_not = (String) getText(R.string.food_gender_not);
            food_hight_not = (String) getText(R.string.food_height_not);
            food_activity_not = (String) getText(R.string.food_activity_not);
            food_next_not = (String) getText(R.string.food_next_not);

        } else if (zab == 2) {

            yaer = " Year ";
            kg = " KG ";
            cm_1 = " Cm ";

            about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
            about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);
            about_alertdialog_8 = (String) getText(R.string.about_alertdialog_8);
            about_alertdialog_9 = (String) getText(R.string.about_alertdialog_9);
            menu_exit = (String) getText(R.string.menu_exit2);
            no = (String) getText(R.string.no);
            yes = (String) getText(R.string.yes);

            weight_not = (String) getText(R.string.food_weight_not);
            year_not = (String) getText(R.string.food_year_not);
            gernder_not = (String) getText(R.string.food_gender_not);
            food_hight_not = (String) getText(R.string.food_height_not);
            food_activity_not = (String) getText(R.string.food_activity_not);
            food_next_not = (String) getText(R.string.food_next_not);

        } else {

            yaer = " Year ";
            kg = " KG ";
            cm_1 = " Cm ";

            about_alertdialog_6 = (String) getText(R.string.about_alertdialog_6);
            about_alertdialog_7 = (String) getText(R.string.about_alertdialog_7);
            about_alertdialog_8 = (String) getText(R.string.about_alertdialog_8);
            about_alertdialog_9 = (String) getText(R.string.about_alertdialog_9);
            menu_exit = (String) getText(R.string.menu_exit2);
            no = (String) getText(R.string.no);
            yes = (String) getText(R.string.yes);

            weight_not = (String) getText(R.string.food_weight_not);
            year_not = (String) getText(R.string.food_year_not);
            gernder_not = (String) getText(R.string.food_gender_not);
            food_hight_not = (String) getText(R.string.food_height_not);
            food_activity_not = (String) getText(R.string.food_activity_not);
            food_next_not = (String) getText(R.string.food_next_not);

        }

        try {

            confirm.setTextColor(getResources().getColor(R.color.color30day));

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }

        try {

            //sliding view
            drawerlayout = (DrawerLayout) findViewById(R.id.root_food);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("5"));
        }


        Cursor res_4 = food_data_1.showAllData();
        StringBuffer data_4 = new StringBuffer();
        while (res_4.moveToNext()) {
            data_4.append(res_4.getString(1));
        }
        if (data_4.toString().length() == 5) {
            try {

                male_111.setTextColor(getResources().getColor(R.color.color30day));
                female_111.setTextColor(getResources().getColor(R.color.color30day_hide));
                male_off.setVisibility(View.INVISIBLE);
                male_on.setVisibility(View.VISIBLE);
                female_on.setVisibility(View.INVISIBLE);
                female_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("6"));
            }

        } else if (data_4.toString().length() == 8) {
            try {

                female_111.setTextColor(getResources().getColor(R.color.color30day));
                male_111.setTextColor(getResources().getColor(R.color.color30day_hide));
                male_off.setVisibility(View.VISIBLE);
                male_on.setVisibility(View.INVISIBLE);
                female_on.setVisibility(View.VISIBLE);
                female_off.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("7"));
            }

        } else {
            try {

                male_off.setVisibility(View.VISIBLE);
                male_on.setVisibility(View.INVISIBLE);
                female_on.setVisibility(View.INVISIBLE);
                female_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("8"));
            }

        }


        Cursor res_8 = food_data_2.showAllData();
        StringBuffer data_8 = new StringBuffer();
        while (res_8.moveToNext()) {
            data_8.append(res_8.getString(1));
        }
        if (data_8.toString().length() == 1) {
            try {

                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                inactive_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_on.setVisibility(View.VISIBLE);
                low_on.setVisibility(View.INVISIBLE);
                medium_on.setVisibility(View.INVISIBLE);
                hard_on.setVisibility(View.INVISIBLE);
                veryhard_on.setVisibility(View.INVISIBLE);
                inactive_off.setVisibility(View.INVISIBLE);
                low_off.setVisibility(View.VISIBLE);
                medium_off.setVisibility(View.VISIBLE);
                hard_off.setVisibility(View.VISIBLE);
                veryhard_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("9"));
            }

        } else if (data_8.toString().length() == 2) {
            try {

                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_on.setVisibility(View.INVISIBLE);
                low_on.setVisibility(View.VISIBLE);
                medium_on.setVisibility(View.INVISIBLE);
                hard_on.setVisibility(View.INVISIBLE);
                veryhard_on.setVisibility(View.INVISIBLE);
                inactive_off.setVisibility(View.VISIBLE);
                low_off.setVisibility(View.INVISIBLE);
                medium_off.setVisibility(View.VISIBLE);
                hard_off.setVisibility(View.VISIBLE);
                veryhard_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("10"));
            }

        } else if (data_8.toString().length() == 3) {
            try {

                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_on.setVisibility(View.INVISIBLE);
                low_on.setVisibility(View.INVISIBLE);
                medium_on.setVisibility(View.VISIBLE);
                hard_on.setVisibility(View.INVISIBLE);
                veryhard_on.setVisibility(View.INVISIBLE);
                inactive_off.setVisibility(View.VISIBLE);
                low_off.setVisibility(View.VISIBLE);
                medium_off.setVisibility(View.INVISIBLE);
                hard_off.setVisibility(View.VISIBLE);
                veryhard_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("11"));
            }

        } else if (data_8.toString().length() == 4) {
            try {

                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_on.setVisibility(View.INVISIBLE);
                low_on.setVisibility(View.INVISIBLE);
                medium_on.setVisibility(View.INVISIBLE);
                hard_on.setVisibility(View.VISIBLE);
                veryhard_on.setVisibility(View.INVISIBLE);
                inactive_off.setVisibility(View.VISIBLE);
                low_off.setVisibility(View.VISIBLE);
                medium_off.setVisibility(View.VISIBLE);
                hard_off.setVisibility(View.INVISIBLE);
                veryhard_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("12"));
            }

        } else if (data_8.toString().length() == 5) {
            try {

                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_on.setVisibility(View.INVISIBLE);
                low_on.setVisibility(View.INVISIBLE);
                medium_on.setVisibility(View.INVISIBLE);
                hard_on.setVisibility(View.INVISIBLE);
                veryhard_on.setVisibility(View.VISIBLE);
                inactive_off.setVisibility(View.VISIBLE);
                low_off.setVisibility(View.VISIBLE);
                medium_off.setVisibility(View.VISIBLE);
                hard_off.setVisibility(View.VISIBLE);
                veryhard_off.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("13"));
            }

        } else {
            try {

                inactive_on.setVisibility(View.INVISIBLE);
                low_on.setVisibility(View.INVISIBLE);
                medium_on.setVisibility(View.INVISIBLE);
                hard_on.setVisibility(View.INVISIBLE);
                veryhard_on.setVisibility(View.INVISIBLE);
                inactive_off.setVisibility(View.VISIBLE);
                low_off.setVisibility(View.VISIBLE);
                medium_off.setVisibility(View.VISIBLE);
                hard_off.setVisibility(View.VISIBLE);
                veryhard_off.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("14"));
            }

        }


        final int minimumVal = 2;
        final int minimumVal_1 = 21;
        final int minimumVal_2 = 81;


        try {

            seek_weight_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_weight_editor = seek_weight_preferences.edit();
            CHECKED_STATE_5 = seek_weight_preferences.getInt("seek_weight_1", 20);
            seekbar_weight.setProgress(CHECKED_STATE_5);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("15"));
        }

        strI_3 = String.valueOf(CHECKED_STATE_5);
        if (CHECKED_STATE_5 >= minimumVal_1) {
            weight.setText(strI_3);
            kg_1.setText(kg);
        } else {
            weight.setText("");
            kg_1.setText("");
        }
        seekbar_weight.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_weight_editor.putInt("seek_weight_1", value);
                    seek_weight_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                }

                try {

                    strI = String.valueOf(value);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }


                if (value >= minimumVal_1) {
                    try {

                        seekbar_weight.setProgress(value);
                        weight.setText(strI);
                        kg_1.setText(kg);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("18"));
                    }

                } else {

                    weight.setText("");
                    kg_1.setText("");
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

            seek_old_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_old_editor = seek_old_preferences.edit();
            CHECKED_STATE_4 = seek_old_preferences.getInt("seek_old_1", 1);
            seekbar_old.setProgress(CHECKED_STATE_4);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("19"));
        }
        strI_2 = String.valueOf(CHECKED_STATE_4);
        if (CHECKED_STATE_4 >= minimumVal) {
            old.setText(strI_2);
            year_1.setText(yaer);
        } else {
            old.setText("");
            year_1.setText("");
        }
        seekbar_old.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                try {

                    seek_old_editor.putInt("seek_old_1", value);
                    seek_old_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("20"));
                }

                try {

                    strI_1 = String.valueOf(value);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("21"));
                }


                if (value >= minimumVal) {
                    try {

                        seekbar_old.setProgress(value);
                        old.setText(strI_1);
                        year_1.setText(yaer);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("22"));
                    }

                } else {

                    old.setText("");
                    year_1.setText("");
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

            seek_length_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            seek_length_editor = seek_length_preferences.edit();
            CHECKED_STATE_7 = seek_length_preferences.getInt("seek_length_1", 80);
            seekbar_length.setProgress(CHECKED_STATE_7);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("23"));
        }
        strI_5 = String.valueOf(CHECKED_STATE_7);
        if (CHECKED_STATE_7 >= minimumVal_2) {
            length.setText(strI_5);
            cm.setText(cm_1);
        } else {
            length.setText("");
            cm.setText("");
        }
        seekbar_length.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                try {

                    seek_length_editor.putInt("seek_length_1", value);
                    seek_length_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("24"));
                }


                strI = String.valueOf(value);

                if (value >= minimumVal_2) {
                    try {

                        seekbar_length.setProgress(value);
                        length.setText(strI);
                        cm.setText(cm_1);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("25"));
                    }

                } else {

                    length.setText("");
                    cm.setText("");
                }

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });


        if (help_play == 1) {

            try {
                alakiha_26.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("26"));
            }

            final String s2 = (String) getText(R.string.Help_start_15_2);

            try {
                mFabPrompt = new MaterialTapTargetPrompt.Builder(food.this)
                        .setTarget(alakiha_26)
                        .setPrimaryText("")
                        .setSecondaryText(s2)
                        .setBackgroundColourFromRes(R.color.color30day)
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                            @Override
                            public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                //Do something such as storing a value so that this prompt is never shown again
                                one_play_editor.putInt("Help_play_6", 3);
                                one_play_editor.apply();

                                mFabPrompt = null;
                                alakiha_26.setVisibility(View.GONE);
                            }

                            @Override
                            public void onHidePromptComplete() {
                            }
                        })
                        .show();
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("27"));
            }
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
            FirebaseCrash.report(new Exception("28"));
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
            FirebaseCrash.report(new Exception("29"));
        }


        FirebaseCrash.log("log 6");
        System.gc();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_back_page2:

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

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("31"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            finish();
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("32"));
                    finish();
                }


                break;

            case R.id.btn_menu:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("33"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("34"));
                }

                try {

                    if (drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerlayout.closeDrawer(Gravity.LEFT);
                    } else {
                        drawerlayout.openDrawer(Gravity.LEFT);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("35"));
                }

                break;

            case R.id.lin_menu_ex:

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

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("37"));
                }

                try {
                    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText(about_alertdialog_7)
                            .setContentText(about_alertdialog_6)
                            .setCancelText(no)
                            .setConfirmText(yes)
                            .showCancelButton(true)
                            .setCancelClickListener(null)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {

                                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                    if (vibre_check == music_off_check) {
                                        vb.cancel();
                                    } else {
                                        vb.vibrate(100);
                                    }

                                    click = MediaPlayer.create(food.this, R.raw.button);
                                    if (music_check == music_off_check) {
                                        click.stop();
                                    } else {
                                        click.start();
                                    }

                                    new Handler().postDelayed(new Thread() {
                                        @Override
                                        public void run() {
                                            super.run();

                                            App.close();

                                        }
                                    }, _splashTime);
                                    sDialog.setTitleText(menu_exit)
                                            .setContentText(about_alertdialog_8)
                                            .setConfirmText(about_alertdialog_9)
                                            .showCancelButton(false)
                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                }
                            })
                            .show();
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("37"));
                    App.close();
                }

                break;

            case R.id.lin_menu_ab:

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

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("39"));
                }
                try {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_1 = new Intent(food.this, com.android.fury.a30day.menu_view.about.class);
                            about_1.putExtra("about_back", 4);
                            food.this.startActivity(about_1);
                            food.this.finish();
                        }
                    }, _splashTime2);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("40"));
                }

                break;

            case R.id.lin_menu_sit:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("41"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("42"));
                }
                try {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent about_2 = new Intent(food.this, com.android.fury.a30day.menu_view.setting.class);
                            about_2.putExtra("setting_back", 4);
                            food.this.startActivity(about_2);
                            food.this.finish();
                        }
                    }, _splashTime2);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("43"));
                }

                break;

            case R.id.lin_menu_gu:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("44"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("45"));
                }

                try {

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent suport = new Intent(food.this, Suport_me.class);
                            startActivity(suport);
                        }
                    }, _splashTime2);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("start support"));
                }
                break;

            case R.id.lin_menu_dm:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("60"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("61"));
                }
                try {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            if (app_net.getInstance(food.this).isOnline()) {

                                Intent music = new Intent(food.this, com.android.fury.a30day.menu_view.music.class);
                                music.putExtra("d_m_b", 2);
                                food.this.startActivity(music);
                                finish();

                            } else {

                                Intent music_not = new Intent(food.this, Not_net.class);
                                music_not.putExtra("d_m_b", 2);
                                food.this.startActivity(music_not);
                                finish();

                            }
                        }
                    }, _splashTime2);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("62"));
                }

                break;

            case R.id.lin_menu_sp:

                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("63"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("64"));
                }
                try {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Intent sport_page = new Intent(food.this, sport.class);
                            sport_page.putExtra("sport_back", 4);
                            food.this.startActivity(sport_page);
                            food.this.finish();
                        }
                    }, _splashTime2);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("65"));
                }


                break;

            case R.id.lin_menu_d:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("66"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("67"));
                }
                try {
                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            String go_music = (String) getText(R.string.food_go_food);
                            Toast.makeText(food.this, go_music, Toast.LENGTH_LONG).show();
                        }
                    }, _splashTime2);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("68"));
                }

                break;


            // end sliding menu


            case R.id.im_male_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("69"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("70"));
                }
                id = "1";
                try {
                    male_111.setTextColor(getResources().getColor(R.color.color30day));
                    female_111.setTextColor(getResources().getColor(R.color.color30day_hide));

                    male_off.setVisibility(View.INVISIBLE);
                    male_on.setVisibility(View.VISIBLE);
                    female_on.setVisibility(View.INVISIBLE);
                    female_off.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("71"));
                }

                try {
                    check_fm = "malef";
                    food_data_1.deleteData(id);
                    food_data_1.insertData(check_fm, id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("72"));
                }


                break;

            case R.id.im_male_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("73"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("74"));
                }
                id = "1";
                try {
                    male_111.setTextColor(getResources().getColor(R.color.color30day_hide));
                    male_off.setVisibility(View.VISIBLE);
                    male_on.setVisibility(View.INVISIBLE);
                    female_on.setVisibility(View.INVISIBLE);
                    female_off.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("75"));
                }

                try {
                    check_fm = "male";
                    food_data_1.deleteData(id);
                    food_data_1.insertData(check_fm, id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("76"));
                }


                break;

            case R.id.im_female_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("77"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("78"));
                }
                id = "1";
                try {
                    female_111.setTextColor(getResources().getColor(R.color.color30day));
                    male_111.setTextColor(getResources().getColor(R.color.color30day_hide));
                    male_off.setVisibility(View.VISIBLE);
                    male_on.setVisibility(View.INVISIBLE);
                    female_on.setVisibility(View.VISIBLE);
                    female_off.setVisibility(View.INVISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("79"));
                }

                try {
                    check_fm = "female_f";
                    food_data_1.deleteData(id);
                    food_data_1.insertData(check_fm, id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("80"));
                }


                break;

            case R.id.im_female_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("81"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("82"));
                }
                id = "1";
                try {
                    female_111.setTextColor(getResources().getColor(R.color.color30day_hide));
                    male_off.setVisibility(View.VISIBLE);
                    male_on.setVisibility(View.INVISIBLE);
                    female_on.setVisibility(View.INVISIBLE);
                    female_off.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("83"));
                }

                try {
                    check_fm = "female";
                    food_data_1.deleteData(id);
                    food_data_1.insertData(check_fm, id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("84"));
                }


                break;


            case R.id.im_activity_inactive_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("85"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("86"));
                }
                id = "1";

                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("87"));
                }


                try {
                    food_data_2.deleteData(id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("88"));
                }

                break;

            case R.id.im_activity_low_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("89"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("90"));
                }
                id = "1";

                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("91"));
                }

                try {
                    food_data_2.deleteData(id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("92"));
                }


                break;

            case R.id.im_activity_medium_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("93"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("94"));
                }
                id = "1";

                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("95"));
                }

                try {
                    food_data_2.deleteData(id);
                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("96"));
                }


                break;

            case R.id.im_activity_hard_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("97"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("98"));
                }
                id = "1";

                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("99"));
                }

                try {
                    food_data_2.deleteData(id);


                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("100"));
                }

                break;

            case R.id.im_activity_veryhard_on:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("101"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("102"));
                }
                id = "1";

                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("103"));
                }

                try {
                    food_data_2.deleteData(id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("104"));
                }


                break;

            case R.id.im_activity_inactive_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("105"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("106"));
                }
                id = "1";

                inactive_.setTextColor(getResources().getColor(R.color.color30day));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.VISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.INVISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("107"));
                }


                try {
                    check_ac = "A";
                    food_data_2.deleteData(id);
                    food_data_2.insertData(check_ac, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("108"));
                }


                break;

            case R.id.im_activity_low_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("109"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("110"));
                }
                id = "1";

                low_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.VISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.INVISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("111"));
                }


                try {
                    check_ac = "AA";
                    food_data_2.deleteData(id);
                    food_data_2.insertData(check_ac, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("112"));
                }


                break;

            case R.id.im_activity_medium_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("113"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("114"));
                }
                id = "1";

                medium_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));
                try {
                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.VISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.INVISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("115"));
                }


                try {

                    check_ac = "AAA";
                    food_data_2.deleteData(id);
                    food_data_2.insertData(check_ac, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("116"));
                }


                break;

            case R.id.im_activity_hard_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("117"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("118"));
                }
                id = "1";

                hard_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                veryhard_.setTextColor(getResources().getColor(R.color.color30day_hide));

                try {

                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.VISIBLE);
                    veryhard_on.setVisibility(View.INVISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.INVISIBLE);
                    veryhard_off.setVisibility(View.VISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("119"));
                }


                try {

                    check_ac = "AAAa";
                    food_data_2.deleteData(id);
                    food_data_2.insertData(check_ac, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("120"));
                }


                break;

            case R.id.im_activity_veryhard_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("121"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("122"));
                }
                id = "1";

                veryhard_.setTextColor(getResources().getColor(R.color.color30day));
                inactive_.setTextColor(getResources().getColor(R.color.color30day_hide));
                low_.setTextColor(getResources().getColor(R.color.color30day_hide));
                medium_.setTextColor(getResources().getColor(R.color.color30day_hide));
                hard_.setTextColor(getResources().getColor(R.color.color30day_hide));

                try {

                    inactive_on.setVisibility(View.INVISIBLE);
                    low_on.setVisibility(View.INVISIBLE);
                    medium_on.setVisibility(View.INVISIBLE);
                    hard_on.setVisibility(View.INVISIBLE);
                    veryhard_on.setVisibility(View.VISIBLE);

                    inactive_off.setVisibility(View.VISIBLE);
                    low_off.setVisibility(View.VISIBLE);
                    medium_off.setVisibility(View.VISIBLE);
                    hard_off.setVisibility(View.VISIBLE);
                    veryhard_off.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("123"));
                }


                try {

                    check_ac = "AAAaa";
                    food_data_2.deleteData(id);
                    food_data_2.insertData(check_ac, id);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("124"));
                }


                break;


            case R.id.im_food_confirm_off:
                try {

                    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibre_check == music_off_check) {
                        vb.cancel();
                    } else {
                        vb.vibrate(100);
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("125"));
                }

                try {

                    click = MediaPlayer.create(food.this, R.raw.button);
                    if (music_check == music_off_check) {
                        click.stop();
                    } else {
                        click.start();
                    }

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("126"));
                }


                confirm.setTextColor(getResources().getColor(R.color.background_sport));
                confirm_off.setImageResource(R.drawable.circle_food_confirm_on);

                new Handler().postDelayed(new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        confirm.setTextColor(getResources().getColor(R.color.color30day));
                        confirm_off.setImageResource(R.drawable.circle_food_confirm_off);
                    }
                }, 50);


                int weight_age_s = seek_weight_preferences.getInt("seek_weight_1", 20);
                int yaer_age_s = seek_old_preferences.getInt("seek_old_1", 1);
                int length_age_s = seek_length_preferences.getInt("seek_length_1", 80);

                send_weight = String.valueOf(seek_weight_preferences.getInt("seek_weight_1", 20));
                send_year = String.valueOf(seek_old_preferences.getInt("seek_old_1", 1));
                send_length = String.valueOf(seek_length_preferences.getInt("seek_length_1", 80));


                Cursor res_5 = food_data_1.showAllData();
                StringBuffer data_5 = new StringBuffer();
                while (res_5.moveToNext()) {
                    data_5.append(res_5.getString(1));
                }

                Cursor res_7 = food_data_2.showAllData();
                StringBuffer data_7 = new StringBuffer();
                while (res_7.moveToNext()) {
                    data_7.append(res_7.getString(1));
                }


                if (yaer_age_s != 1 && weight_age_s == 20 && data_5.toString().length() >= 5 && data_5.toString().length() <= 8 &&
                        data_7.toString().length() >= 1 && data_7.toString().length() <= 5 && length_age_s != 80) {

                    Toast.makeText(food.this, weight_not, Toast.LENGTH_LONG).show();

                } else if (yaer_age_s == 1 && weight_age_s != 20 && data_5.toString().length() >= 5 && data_5.toString().length() <= 8 &&
                        data_7.toString().length() >= 1 && data_7.toString().length() <= 5 && length_age_s != 80) {

                    Toast.makeText(food.this, year_not, Toast.LENGTH_LONG).show();

                } else if (yaer_age_s != 1 && weight_age_s != 20 && data_5.toString().length() != 5 && data_5.toString().length() != 8 &&
                        data_7.toString().length() >= 1 && data_7.toString().length() <= 5 && length_age_s != 80) {

                    Toast.makeText(food.this, gernder_not, Toast.LENGTH_LONG).show();

                } else if (yaer_age_s != 1 && weight_age_s != 20 && data_5.toString().length() >= 5 && data_5.toString().length() <= 8 &&
                        data_7.toString().length() >= 1 && data_7.toString().length() <= 5 && length_age_s == 80) {

                    Toast.makeText(food.this, food_hight_not, Toast.LENGTH_LONG).show();

                } else if (yaer_age_s != 1 && weight_age_s != 20 && data_5.toString().length() >= 4 && data_5.toString().length() <= 8 &&
                        data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                        data_7.toString().length() != 4 && data_7.toString().length() != 5 && length_age_s != 80) {

                    Toast.makeText(food.this, food_activity_not, Toast.LENGTH_LONG).show();

                } else if (yaer_age_s != 1 && weight_age_s != 20 && data_5.toString().length() == 5 && data_5.toString().length() != 8 &&
                        data_7.toString().length() >= 1 && data_7.toString().length() <= 5 && length_age_s != 80) {

                    bundle_food_gender = "male";
                    bundle_food_tall = String.valueOf(length_age_s);
                    bundle_food_weight = String.valueOf(weight_age_s);


                    if (weight_age_s >= 21 && weight_age_s <= 64) {
                        bundle_food_1 = "weight_a";
                    } else if (weight_age_s >= 65 && weight_age_s <= 75) {
                        bundle_food_1 = "weight_aa";
                    } else if (weight_age_s >= 76 && weight_age_s <= 88) {
                        bundle_food_1 = "weight_aaa";
                    } else if (weight_age_s >= 89 && weight_age_s <= 160) {
                        bundle_food_1 = "weight_aaaa";
                    } else {
                        finish();

                        ////////////////////////////////////////////////////////////////////

                    }


                    if (data_7.toString().length() == 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() != 5) {

                        answer_test = (13.7 * Double.parseDouble(send_weight));
                        answer_test_2 = (5 * Double.parseDouble(send_length));
                        answer_test_3 = (6.8 * Double.parseDouble(send_year));
                        answer_test_4 = ((66 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.2);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() == 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() != 5) {

                        answer_test = (13.7 * Double.parseDouble(send_weight));
                        answer_test_2 = (5 * Double.parseDouble(send_length));
                        answer_test_3 = (6.8 * Double.parseDouble(send_year));
                        answer_test_4 = ((66 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.375);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() == 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() != 5) {


                        answer_test = (13.7 * Double.parseDouble(send_weight));
                        answer_test_2 = (5 * Double.parseDouble(send_length));
                        answer_test_3 = (6.8 * Double.parseDouble(send_year));
                        answer_test_4 = ((66 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.55);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() == 4 && data_7.toString().length() != 5) {


                        answer_test = (13.7 * Double.parseDouble(send_weight));
                        answer_test_2 = (5 * Double.parseDouble(send_length));
                        answer_test_3 = (6.8 * Double.parseDouble(send_year));
                        answer_test_4 = ((66 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.725);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() == 5) {

                        answer_test = (13.7 * Double.parseDouble(send_weight));
                        answer_test_2 = (5 * Double.parseDouble(send_length));
                        answer_test_3 = (6.8 * Double.parseDouble(send_year));
                        answer_test_4 = ((66 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.9);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    }

                    save_info_editor.putString("gender_food_1_show", bundle_food_gender);
                    save_info_editor.putString("weight_food_1_show", bundle_food_1);
                    save_info_editor.putString("bmr_food_1_show", bundle_food_2);
                    save_info_editor.putString("bmr_food_cahesh_show", bundle_food_3);
                    save_info_editor.putString("tall_food_1_show", bundle_food_tall);
                    save_info_editor.putString("weight_food_meghdar_1_show", bundle_food_weight);
                    save_info_editor.commit();

                    try {
                        sd2 = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
                        sd2.setTitleText("گرفتن اطلاعات");
                        sd2.setContentText("آیا می خواهید این صفحه دفع بعد نشان داده نشود؟");
                        sd2.setCancelText(no);
                        sd2.setConfirmText(yes);
                        sd2.showCancelButton(true);
                        sd2.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(final SweetAlertDialog sweetAlertDialog) {

                                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                if (vibre_check == music_off_check) {
                                    vb.cancel();
                                } else {
                                    vb.vibrate(100);
                                }

                                click = MediaPlayer.create(food.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        super.run();

                                        Intent co_food_2 = new Intent(food.this, food_page_org.class);
                                        co_food_2.putExtra("gender_food_1", bundle_food_gender);
                                        co_food_2.putExtra("weight_food_1", bundle_food_1);
                                        co_food_2.putExtra("bmr_food_1", bundle_food_2);
                                        co_food_2.putExtra("bmr_food_cahesh", bundle_food_3);
                                        co_food_2.putExtra("tall_food_1", bundle_food_tall);
                                        co_food_2.putExtra("weight_food_meghdar_1", bundle_food_weight);
                                        startActivity(co_food_2);
                                        sweetAlertDialog.cancel();
                                    }
                                }, _splashTime);

                            }
                        });
                        sd2.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(final SweetAlertDialog sDialog) {

                                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                if (vibre_check == music_off_check) {
                                    vb.cancel();
                                } else {
                                    vb.vibrate(100);
                                }

                                click = MediaPlayer.create(food.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                save_info_editor.putBoolean("check_show_food", false);
                                save_info_editor.apply();

                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        super.run();

                                        Intent co_food_2 = new Intent(food.this, food_page_org.class);
                                        co_food_2.putExtra("gender_food_1", bundle_food_gender);
                                        co_food_2.putExtra("weight_food_1", bundle_food_1);
                                        co_food_2.putExtra("bmr_food_1", bundle_food_2);
                                        co_food_2.putExtra("bmr_food_cahesh", bundle_food_3);
                                        co_food_2.putExtra("tall_food_1", bundle_food_tall);
                                        co_food_2.putExtra("weight_food_meghdar_1", bundle_food_weight);
                                        startActivity(co_food_2);
                                        sDialog.cancel();
                                    }
                                }, _splashTime);

                                sDialog.setTitleText("در حال ذخیره اطلاعات")
                                        .setConfirmText("صبر کنید")
                                        .showCancelButton(false)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);


                            }
                        });
                        sd2.show();


                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("save check food"));
                    }

                    if (sd2 == null) {

                        Intent co_food_2 = new Intent(this, food_page_org.class);
                        co_food_2.putExtra("gender_food_1", bundle_food_gender);
                        co_food_2.putExtra("weight_food_1", bundle_food_1);
                        co_food_2.putExtra("bmr_food_1", bundle_food_2);
                        co_food_2.putExtra("bmr_food_cahesh", bundle_food_3);
                        co_food_2.putExtra("tall_food_1", bundle_food_tall);
                        co_food_2.putExtra("weight_food_meghdar_1", bundle_food_weight);
                        startActivity(co_food_2);

                    }


                } else if (yaer_age_s != 1 && weight_age_s != 20 && data_5.toString().length() == 8 &&
                        data_7.toString().length() >= 1 && data_7.toString().length() <= 5 && length_age_s != 80) {


                    bundle_food_gender = "female";
                    bundle_food_tall = String.valueOf(length_age_s);
                    bundle_food_weight = String.valueOf(weight_age_s);


                    if (weight_age_s >= 21 && weight_age_s <= 64) {
                        bundle_food_1 = "weight_a";
                    } else if (weight_age_s >= 65 && weight_age_s <= 75) {
                        bundle_food_1 = "weight_aa";
                    } else if (weight_age_s >= 76 && weight_age_s <= 88) {
                        bundle_food_1 = "weight_aaa";
                    } else if (weight_age_s >= 89 && weight_age_s <= 160) {
                        bundle_food_1 = "weight_aaaa";
                    } else {
                        finish();

                        ////////////////////////////////////////////////////////////////////

                    }


                    if (data_7.toString().length() == 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() != 5) {

                        answer_test = (9.6 * Double.parseDouble(send_weight));
                        answer_test_2 = (1.7 * Double.parseDouble(send_length));
                        answer_test_3 = (4.7 * Double.parseDouble(send_year));
                        answer_test_4 = ((655 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.2);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() == 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() != 5) {

                        answer_test = (9.6 * Double.parseDouble(send_weight));
                        answer_test_2 = (1.7 * Double.parseDouble(send_length));
                        answer_test_3 = (4.7 * Double.parseDouble(send_year));
                        answer_test_4 = ((655 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.275);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() == 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() != 5) {

                        answer_test = (9.6 * Double.parseDouble(send_weight));
                        answer_test_2 = (1.7 * Double.parseDouble(send_length));
                        answer_test_3 = (4.7 * Double.parseDouble(send_year));
                        answer_test_4 = ((655 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.45);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() == 4 && data_7.toString().length() != 5) {

                        answer_test = (9.6 * Double.parseDouble(send_weight));
                        answer_test_2 = (1.7 * Double.parseDouble(send_length));
                        answer_test_3 = (4.7 * Double.parseDouble(send_year));
                        answer_test_4 = ((655 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.6);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    } else if (data_7.toString().length() != 1 && data_7.toString().length() != 2 && data_7.toString().length() != 3 &&
                            data_7.toString().length() != 4 && data_7.toString().length() == 5) {

                        answer_test = (9.6 * Double.parseDouble(send_weight));
                        answer_test_2 = (1.7 * Double.parseDouble(send_length));
                        answer_test_3 = (4.7 * Double.parseDouble(send_year));
                        answer_test_4 = ((655 + answer_test + answer_test_2) - answer_test_3);

                        answer = (answer_test_4 * 1.8);
                        answer = Double.valueOf(df.format(answer));

                        answer_kahesh = (answer - 1100);
                        answer_kahesh = Double.valueOf(df.format(answer_kahesh));

                        bundle_food_2 = String.valueOf(answer);
                        bundle_food_3 = String.valueOf(answer_kahesh);

                    }


                    save_info_editor.putString("gender_food_1_show", bundle_food_gender);
                    save_info_editor.putString("weight_food_1_show", bundle_food_1);
                    save_info_editor.putString("bmr_food_1_show", bundle_food_2);
                    save_info_editor.putString("bmr_food_cahesh_show", bundle_food_3);
                    save_info_editor.putString("tall_food_1_show", bundle_food_tall);
                    save_info_editor.putString("weight_food_meghdar_1_show", bundle_food_weight);
                    save_info_editor.commit();


                    try {
                        sd2 = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
                        sd2.setTitleText("گرفتن اطلاعات");
                        sd2.setContentText("آیا می خواهید این صفحه دفع بعد نشان داده نشود؟");
                        sd2.setCancelText(no);
                        sd2.setConfirmText(yes);
                        sd2.showCancelButton(true);
                        sd2.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(final SweetAlertDialog sweetAlertDialog) {

                                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                if (vibre_check == music_off_check) {
                                    vb.cancel();
                                } else {
                                    vb.vibrate(100);
                                }

                                click = MediaPlayer.create(food.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        super.run();

                                        Intent co_food_1 = new Intent(food.this, food_page_org.class);
                                        co_food_1.putExtra("gender_food_1", bundle_food_gender);
                                        co_food_1.putExtra("weight_food_1", bundle_food_1);
                                        co_food_1.putExtra("bmr_food_1", bundle_food_2);
                                        co_food_1.putExtra("bmr_food_cahesh", bundle_food_3);
                                        co_food_1.putExtra("tall_food_1", bundle_food_tall);
                                        co_food_1.putExtra("weight_food_meghdar_1", bundle_food_weight);
                                        startActivity(co_food_1);
                                        sweetAlertDialog.cancel();
                                    }
                                }, _splashTime);

                            }
                        });
                        sd2.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(final SweetAlertDialog sDialog) {

                                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                if (vibre_check == music_off_check) {
                                    vb.cancel();
                                } else {
                                    vb.vibrate(100);
                                }

                                click = MediaPlayer.create(food.this, R.raw.button);
                                if (music_check == music_off_check) {
                                    click.stop();
                                } else {
                                    click.start();
                                }

                                save_info_editor.putBoolean("check_show_food", false);
                                save_info_editor.apply();

                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        super.run();

                                        Intent co_food_1 = new Intent(food.this, food_page_org.class);
                                        co_food_1.putExtra("gender_food_1", bundle_food_gender);
                                        co_food_1.putExtra("weight_food_1", bundle_food_1);
                                        co_food_1.putExtra("bmr_food_1", bundle_food_2);
                                        co_food_1.putExtra("bmr_food_cahesh", bundle_food_3);
                                        co_food_1.putExtra("tall_food_1", bundle_food_tall);
                                        co_food_1.putExtra("weight_food_meghdar_1", bundle_food_weight);
                                        startActivity(co_food_1);
                                        sDialog.cancel();

                                    }
                                }, _splashTime);

                                sDialog.setTitleText("در حال ذخیره اطلاعات")
                                        .setConfirmText("صبر کنید")
                                        .showCancelButton(false)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                            }
                        });
                        sd2.show();


                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("save check food"));
                    }

                    if (sd2 == null) {
                        Intent co_food_1 = new Intent(this, food_page_org.class);
                        co_food_1.putExtra("gender_food_1", bundle_food_gender);
                        co_food_1.putExtra("weight_food_1", bundle_food_1);
                        co_food_1.putExtra("bmr_food_1", bundle_food_2);
                        co_food_1.putExtra("bmr_food_cahesh", bundle_food_3);
                        co_food_1.putExtra("tall_food_1", bundle_food_tall);
                        co_food_1.putExtra("weight_food_meghdar_1", bundle_food_weight);
                        startActivity(co_food_1);
                    }


                } else {

                    Toast.makeText(food.this, food_next_not, Toast.LENGTH_LONG).show();
                }


                break;

        }
        FirebaseCrash.log("log 5");
    }


    @Override
    protected void onStart() {
        super.onStart();

        App.activity_food_1 = this;
        App_food.activity_food_1 = this;
        FirebaseCrash.log("log 3");
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        App.activity_food_1 = null;
        App_food.activity_food_1 = null;
        FirebaseCrash.log("log 2");
        System.gc();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(food.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("130"));
            }

            try {

                click = MediaPlayer.create(food.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("131"));
            }

            Intent back_page = new Intent(food.this, Page_1.class);
            food.this.startActivity(back_page);
            finish();
            FirebaseCrash.log("log 1");
        }
        return false;
    }

}
