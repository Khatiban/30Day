package com.android.fury.a30day.alarm.ads;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.android.fury.a30day.R;
import com.android.fury.a30day.alarm.myanvade1.NotificationEventReceiver1;
import com.android.fury.a30day.alarm.myanvade2.NotificationEventReceiver2;
import com.android.fury.a30day.alarm.nahar.NotificationEventReceiver3;
import com.android.fury.a30day.alarm.sham.NotificationEventReceiver4;
import com.android.fury.a30day.alarm.sobhane.NotificationEventReceiver5;
import com.android.fury.a30day.alarm.sport.NotificationEventReceiver6;
import com.google.firebase.crash.FirebaseCrash;

import java.util.Calendar;

/**
 * Created by klogi
 *
 *
 */
public class NotificationIntentService extends IntentService {

    private static final int NOTIFICATION_ID = 1;
    private static final String ACTION_START = "ACTION_START";
    private static final String ACTION_DELETE = "ACTION_DELETE";
    String PACKAGE_NAME = "com.android.fury.landenglish";
    int once;
    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;
	
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
        once = one_play_preferences.getInt("one_play_notification_1", 0);
        Calendar rightNow = Calendar.getInstance();
        int date = rightNow.get(Calendar.HOUR_OF_DAY);
        if (date == 19){
            if (once == 0){
                once = 1;
                one_play_editor.putInt("one_play_notification_1", once);
                one_play_editor.apply();
                String t10 = "می خوای زبان انگلیسی با داستان های جذاب به همراه صوت و ترجمه فارسی بخونی ، گوش بدی و لذت ببری؟ هم اکنون اپ سرزمین انگلیسی را رایگان دانلود کن !!!";

                PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
                PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "WakeLock");
                wl.acquire(3000);


                final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setContentTitle("سرزمین انگلیسی")
                        .setAutoCancel(false)
                        .setContentText(t10)
                        .setSmallIcon(R.mipmap.ic_ads)
                        .setStyle(new NotificationCompat.InboxStyle())
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_ads));

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("bazaar://details?id=" + PACKAGE_NAME));
                    intent.setPackage("com.farsitel.bazaar");
                    PendingIntent pendingIntent = PendingIntent.getActivity(this,
                            NOTIFICATION_ID,
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pendingIntent);
                    FirebaseCrash.report(new Exception("ads"));
                }catch (Exception e){
                    PendingIntent pendingIntent = PendingIntent.getActivity(this,
                            NOTIFICATION_ID,
                            new Intent(Intent.ACTION_VIEW, Uri.parse("bazaar://details?id=" + PACKAGE_NAME)),
                            PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pendingIntent);
                    FirebaseCrash.report(new Exception("ads web"));
                }

                final NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID, builder.build());

                NotificationEventReceiver.cancelAlarm(getApplicationContext());

				
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

                if (play_sham) {
                    NotificationEventReceiver4.setupAlarm(getApplicationContext());
                } else {
                    if (play_sobhane) {
                        NotificationEventReceiver5.setupAlarm(getApplicationContext());
                    } else {
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

                                    }
                                }
                            }
                        }
                    }
                }
				
				
                wl.release();
            }
        }else {
            NotificationEventReceiver.getDeleteIntent(this);
            once = 0;
            one_play_editor.putInt("one_play_notification_1", once);
            one_play_editor.apply();
        }

        FirebaseCrash.log("processStartNotification ads log 1");
    }
}
