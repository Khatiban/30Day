package com.android.fury.a30day;

import android.app.Activity;

import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by fury on 9/5/2016.
 */
public class App {
    ////////////////////////////////////////////////////////////////
    // INSTANTIATED ACTIVITY VARIABLES
    ////////////////////////////////////////////////////////////////

    public static Activity activity_page_1;
    public static Activity activity_page_2;
    public static Activity activity_food_1;
    public static Activity activity_food_page_org;
    public static Activity activity_sport_start;

    ////////////////////////////////////////////////////////////////
    // CLOSE APP METHOD
    ////////////////////////////////////////////////////////////////

    public static void close() {

        try {

            if (App.activity_page_1 != null) {
                App.activity_page_1.finish();
            }
            if (App.activity_page_2 != null) {
                App.activity_page_2.finish();
            }
            if (App.activity_food_1 != null) {
                App.activity_food_1.finish();
            }
            if (App.activity_food_page_org != null) {
                App.activity_food_page_org.finish();
            }
            if (App.activity_sport_start != null) {
                App.activity_sport_start.finish();
            }

            if (App.activity_page_1 != null) {
                App.activity_page_1.finish();
            }
            if (App.activity_page_2 != null) {
                App.activity_page_2.finish();
            }
            if (App.activity_food_1 != null) {
                App.activity_food_1.finish();
            }
            if (App.activity_food_page_org != null) {
                App.activity_food_page_org.finish();
            }
            if (App.activity_sport_start != null) {
                App.activity_sport_start.finish();
            }

            if (App.activity_page_1 != null) {
                App.activity_page_1.finish();
            }
            if (App.activity_page_2 != null) {
                App.activity_page_2.finish();
            }
            if (App.activity_food_1 != null) {
                App.activity_food_1.finish();
            }
            if (App.activity_food_page_org != null) {
                App.activity_food_page_org.finish();
            }
            if (App.activity_sport_start != null) {
                App.activity_sport_start.finish();
            }

            if (App.activity_page_1 != null) {
                App.activity_page_1.finish();
            }
            if (App.activity_page_2 != null) {
                App.activity_page_2.finish();
            }
            if (App.activity_food_1 != null) {
                App.activity_food_1.finish();
            }
            if (App.activity_food_page_org != null) {
                App.activity_food_page_org.finish();
            }
            if (App.activity_sport_start != null) {
                App.activity_sport_start.finish();
            }

            if (App.activity_page_1 != null) {
                App.activity_page_1.finish();
            }
            if (App.activity_page_2 != null) {
                App.activity_page_2.finish();
            }
            if (App.activity_food_1 != null) {
                App.activity_food_1.finish();
            }
            if (App.activity_food_page_org != null) {
                App.activity_food_page_org.finish();
            }
            if (App.activity_sport_start != null) {
                App.activity_sport_start.finish();
            }

        } catch (Exception e) {
            FirebaseCrash.report(new Exception("1"));
        }

    }
}
