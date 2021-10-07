package com.android.fury.a30day.menu_view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.fury.a30day.Database.MyDatabaseHelper_lan;
import com.android.fury.a30day.DownloadManagerHelper;
import com.android.fury.a30day.R;
import com.android.fury.a30day.page.Page_2;
import com.google.firebase.crash.FirebaseCrash;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by raya on 8/2/2016.
 */
public class music extends Activity implements View.OnClickListener {

    Vibrator vb;

    MediaPlayer click;

    String url = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-1-set-2-3-4-5-6-after-4.mp3";
    String url1 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-2-set-2-3-4-5-6-after-music-1.mp3";
    String url2 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-3-set-2-3-4-5-6-after-music-2.mp3";
    String url3 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-4-set-2-3-4-5-6.mp3";
    String url4 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-5-set-2-3-4-5-6.mp3";
    String url5 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-6-set-2-3-4-5-6.mp3";
    String url6 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-7-set-2-3-4-5-6.mp3";
    String url7 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-9-set-2-3-4-5-6.mp3";
    String url8 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-10.mp3";
    String url9 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-11-set-2-3-4-5-6.mp3";
    String url10 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-12-set-2-3-4-5-6-ICY-MONCEY.mp3";
    String url11 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-13-set-2-3-4-5-6.mp3";
    String url12 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-14-set-1.mp3";
    String url13 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-15.mp3";
    String url14 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-1.mp3";
    String url15 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-2-set-2-3-4-5-6.mp3";
    String url16 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-3-set-1.mp3";
    String url17 = "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-4-set-1.mp3";

    int play, back_page;

    ImageView im_play_music, im_donload_music, im_donload_music2, im_donload_music3, im_donload_music4, im_donload_music5, im_donload_music6, im_donload_music7, im_donload_music8, im_donload_music9, im_donload_music10, im_donload_music11, im_donload_music12, im_donload_music13, im_donload_music14, im_donload_music15, im_donload_music16, im_donload_music17, im_donload_music18, im_play_music2, im_play_music3, im_play_music4, im_play_music5, im_play_music6, im_play_music7, im_play_music8, im_play_music9, im_play_music10, im_play_music11, im_play_music12, im_play_music13, im_play_music14, im_play_music15, im_play_music16, im_play_music17, im_play_music18;

    private MediaPlayer mp;
    String s;

    MyDatabaseHelper_lan language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);


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

        Bundle back = getIntent().getExtras();
        back_page = back.getInt("d_m_b");

        im_donload_music = (ImageView) findViewById(R.id.im_donload_music);
        im_donload_music2 = (ImageView) findViewById(R.id.im_donload_music2);
        im_donload_music3 = (ImageView) findViewById(R.id.im_donload_music3);
        im_donload_music4 = (ImageView) findViewById(R.id.im_donload_music4);
        im_donload_music5 = (ImageView) findViewById(R.id.im_donload_music5);
        im_donload_music6 = (ImageView) findViewById(R.id.im_donload_music6);
        im_donload_music7 = (ImageView) findViewById(R.id.im_donload_music7);
        im_donload_music8 = (ImageView) findViewById(R.id.im_donload_music8);
        im_donload_music9 = (ImageView) findViewById(R.id.im_donload_music9);
        im_donload_music10 = (ImageView) findViewById(R.id.im_donload_music10);
        im_donload_music11 = (ImageView) findViewById(R.id.im_donload_music11);
        im_donload_music12 = (ImageView) findViewById(R.id.im_donload_music12);
        im_donload_music13 = (ImageView) findViewById(R.id.im_donload_music13);
        im_donload_music14 = (ImageView) findViewById(R.id.im_donload_music14);
        im_donload_music15 = (ImageView) findViewById(R.id.im_donload_music15);
        im_donload_music16 = (ImageView) findViewById(R.id.im_donload_music16);
        im_donload_music17 = (ImageView) findViewById(R.id.im_donload_music17);
        im_donload_music18 = (ImageView) findViewById(R.id.im_donload_music18);
        im_play_music = (ImageView) findViewById(R.id.im_play_music);
        im_play_music2 = (ImageView) findViewById(R.id.im_play_music2);
        im_play_music3 = (ImageView) findViewById(R.id.im_play_music3);
        im_play_music4 = (ImageView) findViewById(R.id.im_play_music4);
        im_play_music5 = (ImageView) findViewById(R.id.im_play_music5);
        im_play_music6 = (ImageView) findViewById(R.id.im_play_music6);
        im_play_music7 = (ImageView) findViewById(R.id.im_play_music7);
        im_play_music8 = (ImageView) findViewById(R.id.im_play_music8);
        im_play_music9 = (ImageView) findViewById(R.id.im_play_music9);
        im_play_music10 = (ImageView) findViewById(R.id.im_play_music10);
        im_play_music11 = (ImageView) findViewById(R.id.im_play_music11);
        im_play_music12 = (ImageView) findViewById(R.id.im_play_music12);
        im_play_music13 = (ImageView) findViewById(R.id.im_play_music13);
        im_play_music14 = (ImageView) findViewById(R.id.im_play_music14);
        im_play_music15 = (ImageView) findViewById(R.id.im_play_music15);
        im_play_music16 = (ImageView) findViewById(R.id.im_play_music16);
        im_play_music17 = (ImageView) findViewById(R.id.im_play_music17);
        im_play_music18 = (ImageView) findViewById(R.id.im_play_music18);

        im_play_music.setOnClickListener(this);
        im_play_music2.setOnClickListener(this);
        im_play_music3.setOnClickListener(this);
        im_play_music4.setOnClickListener(this);
        im_play_music5.setOnClickListener(this);
        im_play_music6.setOnClickListener(this);
        im_play_music7.setOnClickListener(this);
        im_play_music8.setOnClickListener(this);
        im_play_music9.setOnClickListener(this);
        im_play_music10.setOnClickListener(this);
        im_play_music11.setOnClickListener(this);
        im_play_music12.setOnClickListener(this);
        im_play_music13.setOnClickListener(this);
        im_play_music14.setOnClickListener(this);
        im_play_music15.setOnClickListener(this);
        im_play_music16.setOnClickListener(this);
        im_play_music17.setOnClickListener(this);
        im_play_music18.setOnClickListener(this);
        im_donload_music.setOnClickListener(this);
        im_donload_music2.setOnClickListener(this);
        im_donload_music3.setOnClickListener(this);
        im_donload_music4.setOnClickListener(this);
        im_donload_music5.setOnClickListener(this);
        im_donload_music6.setOnClickListener(this);
        im_donload_music7.setOnClickListener(this);
        im_donload_music8.setOnClickListener(this);
        im_donload_music9.setOnClickListener(this);
        im_donload_music10.setOnClickListener(this);
        im_donload_music11.setOnClickListener(this);
        im_donload_music12.setOnClickListener(this);
        im_donload_music13.setOnClickListener(this);
        im_donload_music14.setOnClickListener(this);
        im_donload_music15.setOnClickListener(this);
        im_donload_music16.setOnClickListener(this);
        im_donload_music17.setOnClickListener(this);
        im_donload_music18.setOnClickListener(this);


        s = (String) getText(R.string.download_file);

        play = 1;
        FirebaseCrash.log("log 3");
        System.gc();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_donload_music:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-1-set-2-3-4-5-6-after-4.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_1.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("2"));
                }


                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();


                break;
            case R.id.im_donload_music2:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-2-set-2-3-4-5-6-after-music-1.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_2.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("3"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music3:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-3-set-2-3-4-5-6-after-music-2.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_3.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("4"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music4:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-4-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_4.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("5"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music5:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-5-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_5.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("6"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music6:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-6-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_6.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("7"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music7:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-7-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_7.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("8"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music8:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-9-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_8.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("9"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music9:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-10.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_9.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("10"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music10:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-11-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_10.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("11"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music11:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-12-set-2-3-4-5-6-ICY-MONCEY.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_11.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("12"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music12:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-13-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_12.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("13"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music13:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-14-set-1.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_13.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("14"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music14:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-online-15.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_14.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("15"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music15:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-1.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_15.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("16"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music16:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-2-set-2-3-4-5-6.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_16.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("17"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music17:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-3-set-1.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_17.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("18"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;
            case R.id.im_donload_music18:

                try {

                    new DownloadManagerHelper(music.this, "http://vip.opload.ir/vipdl/95/8/furystudio_1/music-4-set-1.mp3", Environment.DIRECTORY_DOWNLOADS)
                            .showNotificationProgress()
                            .setDownloadFileName("music_18.mp3")
                            .setRequestType("music/MP3")
                            .setNotificationTitle("Download Music")
                            .setNotificationDescription("DOWNLOADING ...")
                            .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                @Override
                                public void onDownloadComplete() {
                                    String a = (String) getText(R.string.download_file_2);
                                    String aa = (String) getText(R.string.download_file_3);
                                    Toast.makeText(music.this, a, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(music.this, aa, Toast.LENGTH_LONG).show();
                                }
                            })
                            .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                @Override
                                public void onDownloadProgressListener(int percent) {
                                    Log.i("LOG", "Percent is : " + percent);
                                }
                            })
                            .startDownload();

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("19"));
                }

                Toast.makeText(music.this, s, Toast.LENGTH_SHORT).show();

                break;


            case R.id.im_play_music:


                if (play == 1) {

                    try {

                        im_play_music.setImageResource(R.drawable.btn_stop_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("20"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("22"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {

                        mp.prepareAsync();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("21"));
                    }

                    try {

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("23"));
                    }


                    play = 2;

                } else if (play == 2) {

                    try {

                        im_play_music.setImageResource(R.drawable.btn_volume_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("24"));
                    }


                    try {

                        mp.reset();
                        mp.stop();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("25"));
                    }


                    play = 1;

                }
                break;
            case R.id.im_play_music2:

                if (play == 1) {
                    try {

                        im_play_music.setImageResource(R.drawable.btn_stop_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("26"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url1);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("27"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {

                        mp.prepareAsync();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("28"));
                    }

                    try {

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("29"));
                    }


                    play = 2;

                } else if (play == 2) {

                    try {

                        im_play_music.setImageResource(R.drawable.btn_volume_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("30"));
                    }

                    try {

                        mp.reset();
                        mp.stop();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("31"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music3:

                if (play == 1) {
                    try {

                        im_play_music.setImageResource(R.drawable.btn_stop_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("32"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url2);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("33"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {

                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("34"));
                    }


                    play = 2;

                } else if (play == 2) {

                    try {

                        im_play_music.setImageResource(R.drawable.btn_volume_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("35"));
                    }

                    try {

                        mp.reset();
                        mp.stop();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("36"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music4:

                if (play == 1) {
                    try {

                        im_play_music.setImageResource(R.drawable.btn_stop_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("37"));
                    }


                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url3);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("38"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {

                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("39"));
                    }


                    play = 2;

                } else if (play == 2) {

                    try {

                        im_play_music.setImageResource(R.drawable.btn_volume_sport);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("40"));
                    }


                    try {

                        mp.reset();
                        mp.stop();

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("41"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music5:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("42"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url4);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("43"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("44"));
                    }


                    play = 2;

                } else if (play == 2) {

                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("45"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("46"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music6:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("47"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url5);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("48"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("49"));
                    }


                    play = 2;

                } else if (play == 2) {

                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("50"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("51"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music7:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("52"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url6);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("53"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("54"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("55"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("56"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music8:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("57"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url7);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("58"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("59"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("60"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("61"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music9:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("62"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url8);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("63"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("64"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("65"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("66"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music10:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("67"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url9);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("68"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("69"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("70"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("71"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music11:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("72"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url10);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("73"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("74"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("75"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("76"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music12:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("77"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url11);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("78"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("79"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("80"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("81"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music13:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("82"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url12);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("83"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("84"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("85"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("86"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music14:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("87"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url13);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("88"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("89"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("90"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("91"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music15:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("92"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url14);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("93"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("94"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("95"));
                    }


                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("96"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music16:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("97"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url15);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("98"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("99"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("100"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("101"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music17:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("102"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url16);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("103"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("104"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("105"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("106"));
                    }


                    play = 1;

                }

                break;
            case R.id.im_play_music18:

                if (play == 1) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_stop_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("107"));
                    }

                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(url17);
                    } catch (IllegalArgumentException e) {
                        FirebaseCrash.report(new Exception("108"));
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepareAsync();

                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // TODO Auto-generated method stub

                                mp.start();

                            }
                        });
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("109"));
                    }


                    play = 2;

                } else if (play == 2) {
                    try {
                        im_play_music.setImageResource(R.drawable.btn_volume_sport);
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("110"));
                    }

                    try {
                        mp.reset();
                        mp.stop();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("111"));
                    }


                    play = 1;

                }

                break;


        }
        FirebaseCrash.log("log 2");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(music.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(100);

                click = MediaPlayer.create(music.this, R.raw.button);
                click.start();
            } catch (Exception e) {
                FirebaseCrash.report(new Exception("112"));
            }

            if (back_page == 1) {

                finish();

            } else if (back_page == 2) {

                Intent back_p = new Intent(music.this, Page_2.class);
                music.this.startActivity(back_p);

                finish();

            }
            FirebaseCrash.log("log 1");
        }
        return false;
    }


}
