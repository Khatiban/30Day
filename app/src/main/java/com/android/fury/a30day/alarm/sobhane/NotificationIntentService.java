package com.android.fury.a30day.alarm.sobhane;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.android.fury.a30day.R;
import com.android.fury.a30day.Start_1;
import com.android.fury.a30day.alarm.myanvade1.NotificationEventReceiver1;
import com.android.fury.a30day.alarm.myanvade2.NotificationEventReceiver2;
import com.android.fury.a30day.alarm.nahar.NotificationEventReceiver3;
import com.android.fury.a30day.alarm.sham.NotificationEventReceiver4;
import com.android.fury.a30day.alarm.sport.NotificationEventReceiver6;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by klogi
 *
 *
 */
public class NotificationIntentService extends IntentService {

    private static final int NOTIFICATION_ID = 6;
    private static final String ACTION_START = "ACTION_START";
    private static final String ACTION_DELETE = "ACTION_DELETE";
    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;
    int once;
    Boolean play_sobhane,play_myanvade_1,play_nahar,play_myanvade_2,play_sport,play_sham;

    public NotificationIntentService() {
        super(NotificationIntentService.class.getSimpleName());
    }

    public static Intent createIntentStartNotificationService(Context context) {
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.setAction(ACTION_START);
        return intent;
    }

    public static Intent createIntentDeleteNotification(Context context) {
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.setAction(ACTION_DELETE);
        return intent;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(getClass().getSimpleName(), "onHandleIntent, started handling a notification event");
        try {
            String action = intent.getAction();
            if (ACTION_START.equals(action)) {
                processStartNotification();
            }
        } finally {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    private void processDeleteNotification(Intent intent) {
        // Log something?
    }

    private void processStartNotification() {
        // Do something. For example, fetch fresh data from backend to create a rich notification?
        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();
        once = one_play_preferences.getInt("one_play_notification_6", 0);
        Calendar rightNow = Calendar.getInstance();
        int date = rightNow.get(Calendar.HOUR_OF_DAY);
        if (date == 7){
            if (once == 0) {
                once = 1;
                one_play_editor.putInt("one_play_notification_6", once);
                one_play_editor.apply();
                int min = 1;
                int max = 9;

                Random r = new Random();

                int khodkar_1 = r.nextInt(max - min + 1) + min;

                String t1 = "صبحانه یادت نره خیلی مهم!";
                String t2 = "صبحانه می دونی باید چی بخوری؟";
                String t3 = "رژیم رعایت کن!";
                String t4 = "روز چند رژیمی ؟";
                String t5 = "صبحانه اصل مهمی برای کم کردن وزنه";
                String t6 = "صبحانه یک راه رسیدن به لاغری";
                String t7 = "در صبحانه زیاده روی نکنی!";
                String t8 = "برنامه غذایی رعایت می کنی؟";
                String t9 = "می دونی صبحانه چی؟";
                String t10 = "صبحانه یادت نره خیلی مهم!";

                if (khodkar_1 == 1) {
                    t10 = "";
                    t10 = t1;
                } else if (khodkar_1 == 2) {
                    t10 = "";
                    t10 = t2;
                } else if (khodkar_1 == 3) {
                    t10 = "";
                    t10 = t3;
                } else if (khodkar_1 == 4) {
                    t10 = "";
                    t10 = t4;
                } else if (khodkar_1 == 5) {
                    t10 = "";
                    t10 = t5;
                } else if (khodkar_1 == 6) {
                    t10 = "";
                    t10 = t6;
                } else if (khodkar_1 == 7) {
                    t10 = "";
                    t10 = t7;
                } else if (khodkar_1 == 8) {
                    t10 = "";
                    t10 = t8;
                } else if (khodkar_1 == 9) {
                    t10 = "";
                    t10 = t9;
                }

                PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "WakeLock");
                wl.acquire(3000);


                final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setContentTitle("برنامه غذایی")
                        .setAutoCancel(true)
                        .setContentText(t10)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setStyle(new NotificationCompat.InboxStyle())
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setVibrate(new long[]{500, 500, 500, 500, 500})
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

                Intent mainIntent = new Intent(this, Start_1.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,
                        NOTIFICATION_ID,
                        mainIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                final NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID, builder.build());

                NotificationEventReceiver5.cancelAlarm(getApplicationContext());

                try {


                    play_sobhane = one_play_preferences.getBoolean("check_show_alarm_1", true);
                    play_myanvade_1 = one_play_preferences.getBoolean("check_show_alarm_2", true);
                    play_nahar = one_play_preferences.getBoolean("check_show_alarm_3", true);
                    play_myanvade_2 = one_play_preferences.getBoolean("check_show_alarm_4", true);
                    play_sport = one_play_preferences.getBoolean("check_show_alarm_5", true);
                    play_sham = one_play_preferences.getBoolean("check_show_alarm_6", true);

                } catch (Exception e) {
                    FirebaseCrash.report(new Exception("4"));
                }

                if (play_myanvade_1) {
                    NotificationEventReceiver1.setupAlarm(getApplicationContext());
                } else {
                    if (play_nahar) {
                        NotificationEventReceiver3.setupAlarm(getApplicationContext());
                    } else {
                        if (play_myanvade_2) {
                            NotificationEventReceiver2.setupAlarm(getApplicationContext());
                        } else {
                            if (play_sport) {
                                NotificationEventReceiver6.setupAlarm(getApplicationContext());
                            } else {
                                if (play_sham) {
                                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                                } else {
                                    if (play_sobhane) {
                                        NotificationEventReceiver5.setupAlarm(getApplicationContext());
                                    } else {

                                    }
                                }
                            }
                        }
                    }
                }

                wl.release();
            }
        }else {
            NotificationEventReceiver5.getDeleteIntent(this);
            once = 0;
            one_play_editor.putInt("one_play_notification_6", once);
            one_play_editor.apply();
        }

        FirebaseCrash.log("processStartNotification sobhane log 1");

    }
}
