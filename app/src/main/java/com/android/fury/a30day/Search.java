package com.android.fury.a30day;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.food.food_page_org_1;
import com.android.fury.a30day.food.list_food_cal;
import com.android.fury.a30day.food.listviewAdapter;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Comparator;

/**
 * Created by fury on 12/14/2016.
 */
public class Search extends ListActivity {


    ArrayAdapter<String> adapter;

    MyDatabaseHelper_lan language;

    String[] str = {"آدامس", "گیلاس کنسرو", "گیلاس هسته", "زرد آلو", "آلو قرمز",
            "آناناس", "انبه", "مواد غذایی با چربی کم", "مواد غذایی با چربی بالا", "دانه انار", "انار تازه", "انجیر تازه", "انجیر خشک",
            "انجیر", "انگور", "شراب", "آب ترش", "آجیل مخلوط", "بادام ها", "بادام زمینی", "بستنی", "بستنی عروسکی", "یخ", "بستنی موزی",
            "بیسکویت بدون کرم", "کوکی ها کرم", "برنج پخته شده", "پیتزا", "باقلوا", "باربیکیو", "بامیه سبز", "برگ مو", "نارنگی", "آب پرتقال",
            "پسته", "پنیر تازه ها ", "نوعی پنیر دلمه شده", "پنیر خامه ای", "پیتزای پنیری", "پیازچه", "پیاز", "پفک",
            "پوره سیب زمینی", "اسب", "تربچه", "تخم مرغ", "زرده تخم مرغ", "سفید تخم مرغ", "تخم مرغ نیمرو", "دانه های آفتابگردان", "دانه کدو تنبل", "توت خشک",
            "تمبر هندی", "تمشک", "توت های تازه", "ماهی تن", "حلیم", "حلوا", "حلوا ارده", "چیپس", "خامه", "خیار", "خیار قلمی", "خیار شور", "خربزه", "خرمالو",
            "خرما", "دلمه", "خمیر", "ذرت بو داده", "روغن مایع", "ریواس", "خمیر", "زالزالک", "زبان گوسفند", "زبان گوساله", "کلوچه زردآلو", "زردالو",
            "زردآلو کنسرو", "زیتون خام", "زیتون سیاه و سفید", "ژله", "سالاد بدون سس مایونز", "سنگدان مرغ", "سیب", "آب سیب", "سیب زمینی", "سمبوسه", "سویا",
            "کاسه سوپ", "سوپ مرغ با گیاهان", "سیر", "سوسیس", "ساندویچ همبرگر", "سس مایونز", "سمنو", "سیرابی", "توت سیاه", "شلیل", "پودر شیر", "کوکی", "قند",
            "شکلات", "شلغم", "عدس خام", "عناب", "عسل", "فرنی", "فندق", "قارچ خوراکی", "ترش", "قهوه", "قند", "قره قروت", "کارامل", "کاهو", "کاکائو", "کدو خورشتی",
            "اسکواش", "کرفس", "کره", "کشمش", "کلم", "کیک", "سوسیس", "کشک", "کتلت", "کباب کوبیده", "برگ کباب", "نان شیرین و پهن", "گردو", "گریپ فروت", "طالبی", "گلابی",
            "گوجه فرنگی", "سس", "گوشت ماهی", "جوجه", "گوشت گاو", "گوشت گوسفند", "گیلاس", "گز", "سبز گوجه فرنگی", "چغندر", "لوبیا", "لپه", "لیمو ترش", "ماست کم چرب", "ماست چکیده",
            "پاستا", "ماهی", "مربا", "موز", "میگو", "نارنگی", "نارگیل", "نان جو", "نان خشک", "نان سوخاری", "نان روغنی", "نخود", "نوشابه", "نوشابه رژیمی", "هلو", "برگ خشک هلو",
            "هلو کمپوت", "هویج ها", "لیمو شیرین", "هندوانه", "نوشابه", "کوکتل", "لیکور", "شراب قرمز", "شراب سفید", "گوشت چرخ كرده", "فلفلی", "استیک گوشت گاو با استخوان",
            "نان شیرینی حلقوی", "نان", "تخم مرغ", "کلوچه انگلیسی", "نان پیتا", "تمام سبوس", "برشتوک", "بلغور ذرت", "برنج", "خرد گندم", "پنیر آبی", "پنیر بری", "پنیر نرم فرانسوی",
            "پنیر چدار", "پنیر فتا", "پنیر خامه ای", "پنیر", "پنیر بز", "پنیر پرولون", "شکلات", "شربت شکلات", "کاپوچینو", "کافه آمریکایی", "نشاسته ذرت", "کرم تارتار", "ژلاتین",
            "سس گوجه", "سس مایونز", "خردل", "پودر پیاز", "ترشی", "سالسا", "خامه ترش", "رب", "عصاره وانیل", "سرکه", "جوانه گندم", "مخمر", "شیر بادام", "دوغ", "اوت داگ", "شیر نارگیل",
            "شیر بز", "شیر سویا", "گوشت خوک", "نوتلا", "آرد جو", "آرد نان", "آرد کیک", "آرد نارگیل", "آرد ذرت", "آرد برنج", "آرد سویا", "سس سیب",
            "آوکادو", "چیپس موز", "کران پری", "آب گریپ فروت", "کیوی", "آلو", "توت فرنگی", "زیره", "دانه رازیانه", "دانه خشخاش", "دانه کنجد", "دانه گندم", "فلفل شیرین", "هل", "پودر فلفل قرمز",
            "دارچین", "برگ گشنیز", "پودر کاری", "پودر سیر", "زنجبیل", "جعفری", "رزماری", "زعفران", "نمک", "آویشن", "زرد چوبه", "گوشت بره", "آجیل برزیلی", "رشته فرنگی", "بیکن", "ژامبون",
            "کباب گوشت خوک", "سینه مرغ", "پای مرغ", "ران مرغ", "بوقلمون", "خاویار", "گوشت خرچنگ", "صدف", "ماهی سالمون", "ماهی قزل آلا", "ماهی تن", "شربت ذرت", "اختاپوس",
            "کلم بروکلی", "بادمجان"};

    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;

    Vibrator vb;

    public static MediaPlayer click;

    String vibre_check, music_check, music_off_check;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.search);


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

        adapter = new ArrayAdapter<String>(this,
                R.layout.rows_serch, str);

        adapter.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        setListAdapter(adapter);

        EditText ed = (EditText) findViewById(R.id.search_food_2);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setTextFilterEnabled(true);


        TextView search_food_2 = (TextView) findViewById(R.id.search_food_2);
        search_food_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });

        TextView txt_ser = (TextView) findViewById(R.id.txt_ser);
        txt_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (vibre_check == music_off_check) {
                    vb.cancel();
                } else {
                    vb.vibrate(100);
                }

                click = MediaPlayer.create(Search.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });


        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Search.this.adapter.getFilter().filter(editable);
            }
        });

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibre_check == music_off_check) {
            vb.cancel();
        } else {
            vb.vibrate(100);
        }

        click = MediaPlayer.create(Search.this, R.raw.button);
        if (music_check == music_off_check) {
            click.stop();
        } else {
            click.start();
        }

        text = String.valueOf(getListView().getItemAtPosition(position));
        itm_search();


    }


    public void itm_search() {

        try {

            if (text.toLowerCase().trim().equals(list_food_cal.food_1.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_2.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp2);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_3.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp3);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_4.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp4);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_5.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp5);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_6.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp6);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_7.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp7);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_8.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp8);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_8.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp8);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_9.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp9);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_10.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp10);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_11.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp11);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_12.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp12);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_13.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp13);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_14.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp14);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_15.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp15);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_16.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp16);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_17.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp17);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_18.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp18);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_19.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp19);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_20.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp20);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_21.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp21);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_22.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp22);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_23.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp23);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_24.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp24);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_25.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp25);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_26.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp26);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_27.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp27);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_28.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp28);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_29.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp29);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_30.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp30);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_31.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp31);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_32.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp32);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_33.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp33);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_34.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp34);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_35.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp35);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_36.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp36);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_37.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp37);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_38.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp38);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_39.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp39);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_40.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp40);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_41.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp41);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_42.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp42);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_43.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp43);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_44.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp44);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_45.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp45);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_46.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp46);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_47.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp47);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_48.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp48);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_49.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp49);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_50.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp50);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_51.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp51);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_52.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp52);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_53.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp53);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_54.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp54);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_55.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp55);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_56.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp56);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_57.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp57);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_58.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp58);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_59.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp59);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_60.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp60);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_61.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp61);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_62.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp62);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_63.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp63);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_64.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp64);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_65.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp65);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_66.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp66);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_67.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp67);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_68.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp68);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_69.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp69);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_70.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp70);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_71.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp71);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_72.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp72);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_73.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp73);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_74.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp74);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_75.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp75);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_76.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp76);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_77.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp77);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_78.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp78);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_79.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp79);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_80.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp80);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_81.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp81);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_82.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp82);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_83.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp83);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_84.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp84);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_85.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp85);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_86.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp86);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_87.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp87);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_88.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp88);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_89.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp89);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_90.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp90);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_91.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp91);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_92.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp92);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_93.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp93);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_94.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp94);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_95.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp95);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_96.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp96);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_97.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp97);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_98.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp98);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_99.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp99);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_100.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp100);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_101.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp101);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_102.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp102);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_103.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp103);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_104.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp104);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_105.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp105);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_106.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp106);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_107.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp107);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_108.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp108);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_109.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp109);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_110.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp110);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_111.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp111);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_112.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp112);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_114.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp114);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_115.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp115);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_116.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp116);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_117.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp117);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_118.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp118);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_119.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp119);
            }else if (text.toLowerCase().trim().equals(list_food_cal.food_120.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp120);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_121.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp121);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_122.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp122);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_123.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp123);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_124.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp124);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_125.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp125);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_126.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp126);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_128.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp128);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_129.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp129);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_130.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp130);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_131.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp131);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_132.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp132);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_133.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp133);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_134.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp134);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_135.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp135);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_136.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp136);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_137.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp137);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_138.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp138);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_139.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp139);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_140.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp140);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_141.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp141);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_142.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp142);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_143.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp143);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_144.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp144);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_145.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp145);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_146.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp146);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_147.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp147);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_148.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp148);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_149.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp149);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_150.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp150);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_151.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp151);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_152.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp152);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_153.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp153);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_154.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp154);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_155.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp155);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_156.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp156);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_157.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp157);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_158.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp158);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_159.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp159);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_160.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp160);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_161.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp161);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_162.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp162);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_163.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp163);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_164.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp164);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_165.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp165);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_167.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp167);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_168.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp168);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_169.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp169);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_171.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp171);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_172.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp172);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_173.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp173);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_174.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp174);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_175.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp175);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_176.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp176);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_177.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp177);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_178.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp178);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_179.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp179);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_180.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp180);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_181.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp181);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_182.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp182);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_183.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp183);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_184.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp184);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_185.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp185);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_186.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp186);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_187.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp187);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_188.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp188);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_189.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp189);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_190.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp190);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_191.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp191);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_192.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp192);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_193.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp193);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_194.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp194);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_195.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp195);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_196.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp196);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_197.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp197);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_198.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp198);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_199.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp199);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_200.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp200);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_201.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp201);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_202.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp202);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_203.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp203);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_204.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp204);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_205.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp205);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_206.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp206);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_207.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp207);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_208.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp208);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_209.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp209);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_210.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp210);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_212.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp212);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_213.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp213);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_214.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp214);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_215.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp215);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_216.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp216);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_217.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp217);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_218.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp218);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_219.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp219);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_220.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp220);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_221.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp221);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_222.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp222);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_223.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp223);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_224.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp224);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_225.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp225);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_226.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp226);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_227.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp227);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_228.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp228);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_229.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp229);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_230.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp230);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_231.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp231);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_232.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp232);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_233.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp233);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_234.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp234);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_235.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp235);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_236.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp236);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_237.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp237);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_238.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp238);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_240.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp240);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_241.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp241);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_242.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp242);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_243.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp243);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_244.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp244);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_245.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp245);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_246.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp246);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_247.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp247);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_248.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp248);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_249.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp249);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_250.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp250);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_251.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp251);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_252.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp252);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_253.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp253);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_254.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp254);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_255.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp255);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_256.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp256);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_257.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp257);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_258.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp258);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_259.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp259);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_260.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp260);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_261.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp261);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_262.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp262);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_263.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp263);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_264.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp264);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_265.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp265);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_266.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp266);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_267.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp267);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_268.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp268);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_269.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp269);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_270.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp270);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_271.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp271);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_272.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp272);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_273.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp273);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_274.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp274);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_275.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp275);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_276.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp276);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_277.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp277);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_278.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp278);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_279.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp279);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_280.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp280);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_281.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp281);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_282.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp282);
            } else if (text.toLowerCase().trim().equals(list_food_cal.food_283.toLowerCase().trim())) {
                list_food_cal.list.clear();
                list_food_cal.list.add(list_food_cal.temp283);
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

        food_page_org_1.adapter = new listviewAdapter(this, list_food_cal.list);
        food_page_org_1.lview.setAdapter(food_page_org_1.adapter);
        finish();
        FirebaseCrash.log("log 2");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(Search.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
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
                FirebaseCrash.report(new Exception("2"));
            }


            try {

                click = MediaPlayer.create(Search.this, R.raw.button);
                if (music_check == music_off_check) {
                    click.stop();
                } else {
                    click.start();
                }

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("3"));
            }

            try {

                list_food_cal.list.clear();
                list_food_cal.list.addAll(list_food_cal.list_c);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("4"));
            }

            FirebaseCrash.log("log 1");
            finish();

        }
        return false;
    }


}

    

