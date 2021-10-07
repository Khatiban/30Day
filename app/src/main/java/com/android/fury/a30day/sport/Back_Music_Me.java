package com.android.fury.a30day.sport;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.android.fury.a30day.R;
import com.android.fury.a30day.app_net;
import com.google.firebase.crash.FirebaseCrash;

import java.io.IOException;

/**
 * Created by fury on 2/28/2017.
 */
public class Back_Music_Me extends Service {

    public static MediaPlayer music;

    SharedPreferences sport_namber;

    SharedPreferences.Editor nameEditor_sport_namber;

    int mm,nov ;

    String music_check_1 , music_off_check_1 , m;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            sport_namber = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
            nameEditor_sport_namber = sport_namber.edit();
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("2"));
        }

        m = sport_namber.getString("sport_me_music_url", "s");
        mm = sport_namber.getInt("sport_me_music", 1);
        music_check_1 = sport_namber.getString("music_check_offline", "k");
        music_off_check_1 = sport_namber.getString("music_off_check_offline", "g");



        if (music_check_1 == music_off_check_1) {
        } else {
            if (app_net.getInstance(this).isOnline()) {

                music = new MediaPlayer();
                try {
                    music.setDataSource(m);
                } catch (IllegalArgumentException e) {
                    FirebaseCrash.report(new Exception("65"));
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                music.prepareAsync();

                music.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer music) {
                        // TODO Auto-generated method stub

                        music.start();

                    }
                });

            }else {

                if (mm == 1) {

                    try {
                        music = MediaPlayer.create(this, R.raw.music_2);
                    } catch (Exception e) {
                        try {
                            music = MediaPlayer.create(this, R.raw.music_2);
                        }catch (Exception a){
                            FirebaseCrash.report(new Exception("music offline music 2 in crash 2"));
                        }
                        FirebaseCrash.report(new Exception("music offline music 2"));
                    }

                } else if (mm == 2) {

                    try {
                        music = MediaPlayer.create(this, R.raw.music_1);
                    } catch (Exception e) {
                        try {
                            music = MediaPlayer.create(this, R.raw.music_1);
                        }catch (Exception a){
                            FirebaseCrash.report(new Exception("music offline music 1 in crash 2"));
                        }
                        FirebaseCrash.report(new Exception("music offline music 1"));
                    }

                } else if (mm == 3) {

                    try {
                        music = MediaPlayer.create(this, R.raw.music_3);
                    } catch (Exception e) {
                        try {
                            music = MediaPlayer.create(this, R.raw.music_3);
                        }catch (Exception a){
                            FirebaseCrash.report(new Exception("music offline music 3 in crash 2"));
                        }
                        FirebaseCrash.report(new Exception("music offline music 3"));
                    }

                } else if (mm == 4) {

                    try {
                        music = MediaPlayer.create(this, R.raw.music_4);
                    } catch (Exception e) {
                        try {
                            music = MediaPlayer.create(this, R.raw.music_4);
                        }catch (Exception a){
                            FirebaseCrash.report(new Exception("music offline music 4 in crash 2"));
                        }
                        FirebaseCrash.report(new Exception("music offline music 4"));
                    }

                }

                if (music_check_1 == music_off_check_1) {
                    music.stop();
                } else {
                    music.start();
                }

            }
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        music.stop();
        music.release();
        music = null;
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        music.stop();
        music.release();
        music = null;

    }

}
