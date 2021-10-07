package com.android.fury.a30day;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Locale;

/**
 * Created by fury on 10/24/2016.
 */
public class instagram extends Activity {

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;
    int oneplay;

    MyDatabaseHelper_lan language;

    String instagram_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insta_app);


        try {

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

            one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            one_play_editor = one_play_preferences.edit();

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }


        CardView text_follow = (CardView) findViewById(R.id.text_follow);
        TextView instagram_2 = (TextView) findViewById(R.id.instagram_2);

        try {

            String instagram_txt_1 = (String) getText(R.string.instagram_text_1);
            String instagram_txt_2 = (String) getText(R.string.instagram_text_2);
            String instagram_txt_3 = (String) getText(R.string.instagram_text_3);
            String instagram_txt_4 = (String) getText(R.string.instagram_text_4);
            String instagram_txt_5 = (String) getText(R.string.instagram_text_5);
            instagram_txt = instagram_txt_1
                    + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + instagram_txt_2
                    + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + instagram_txt_3
                    + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + instagram_txt_4
                    + System.getProperty("line.separator") + "" + System.getProperty("line.separator") + instagram_txt_5;

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("3"));
        }


        try {

            instagram_2.setText(instagram_txt);

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("4"));
        }


        text_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("http://instagram.com/_u/30Dayweigh");
                Intent inestagram = new Intent(Intent.ACTION_VIEW, uri);
                inestagram.setPackage("com.instagram.android");
                try {
                    startActivity(inestagram);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/30Dayweigh")));
                }
                try {

                    one_play_editor.putInt("insta", 2);
                    one_play_editor.commit();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("5"));
                }


            }
        });

        FirebaseCrash.log("log 1");
        System.gc();
    }
}
