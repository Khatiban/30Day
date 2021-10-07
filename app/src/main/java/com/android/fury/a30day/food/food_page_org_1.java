package com.android.fury.a30day.food;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.fury.a30day.App_food;
import com.android.fury.a30day.Database.MyDatabaseHelper_sound;
import com.android.fury.a30day.Database.MyDatabaseHelper_vibre;
import com.android.fury.a30day.R;
import com.android.fury.a30day.Search;
import com.google.firebase.crash.FirebaseCrash;

import java.util.HashMap;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Created by fury on 9/1/2016.
 */

public class food_page_org_1 extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    public static ListView lview;

    private int mPage;

    public static listviewAdapter adapter;

    int ms = 1;

    private final int _splashTime3 = 250;



    HashMap<String, String> map;

    EditText et;

    public static int s = 0;

    String colery_2,colery_3,colery_4,colery_5,colery_6;

    int time_1 = 1;


    MediaPlayer click;

    Vibrator vb;


    MyDatabaseHelper_sound sound_data;
    MyDatabaseHelper_vibre vibre_data;


    String music_check, music_off_check, vibre_check;

    //final private String APP_ID  = "app8f399ff0cb6c4f83b4";
    //final private String ZONE_ID = "vzded9a79e5bd84c7d9b";

    //AdColonyVideoAd ad,ad_2,ad_3,ad_4;

    private final int _splashTime = 2050;

    public static food_page_org_1 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        food_page_org_1 fragment = new food_page_org_1();
        fragment.setArguments(args);
        return fragment;

    }

    int help_play, help_play2;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    MaterialTapTargetPrompt mFabPrompt, mFabPrompt4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

        one_play_preferences = getContext().getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        one_play_editor = one_play_preferences.edit();
        help_play = one_play_preferences.getInt("Help_play_7", 1);
        help_play2 = one_play_preferences.getInt("Help_play_org_2", 1);


    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;

        if (mPage == 1) {
            view = inflater.inflate(R.layout.food_page_org_1, container, false);

            try {

                //save music
                sound_data = new MyDatabaseHelper_sound(getActivity());
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
                FirebaseCrash.report(new Exception("1"));
            }

            try {

                //save vibre
                vibre_data = new MyDatabaseHelper_vibre(getActivity());
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
                FirebaseCrash.report(new Exception("2"));
            }


            final TextView about3 = (TextView) view.findViewById(R.id.txt_food_day_1_3);

            final RelativeLayout day10 = (RelativeLayout) view.findViewById(R.id.rl_food_day_1_1);


            if (help_play == 1) {

                final String s1111 = (String) getText(R.string.Help_start_24_1);
                final String s22 = (String) getText(R.string.Help_start_24_2);

                try {
                 mFabPrompt4 = new MaterialTapTargetPrompt.Builder(getActivity())
                 .setTarget(day10)
                 .setPrimaryText(s1111)
                 .setSecondaryText(s22)
                 .setBackgroundColourFromRes(R.color.color30day)
                 .setAnimationInterpolator(new FastOutSlowInInterpolator())
                 .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                @Override
                public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                //Do something such as storing a value so that this prompt is never shown again
                one_play_editor.putInt("Help_play_7", 2);
                one_play_editor.commit();

                mFabPrompt4 = null;
                }

                @Override
                public void onHidePromptComplete() {
                }
                })
                 .show();
                 } catch (Exception e) {
                 FirebaseCrash.report(new Exception("5"));
                 }


            }

            Bundle colery2 = getActivity().getIntent().getExtras();
            try {
                colery_2 = colery2.getString("bmr_food_cahesh");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                colery_3 = colery2.getString("gender_food_1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                colery_4 = colery2.getString("tall_food_1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                colery_5 = colery2.getString("weight_food_meghdar_1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                colery_6 = colery2.getString("weight_food_1");
            } catch (Exception e) {
                e.printStackTrace();
            }

            day10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {

                        vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        if (vibre_check == music_off_check) {
                            vb.cancel();
                        } else {
                            vb.vibrate(100);
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("6"));
                    }

                    try {

                        click = MediaPlayer.create(getActivity(), R.raw.button);
                        if (music_check == music_off_check) {
                            click.stop();
                        } else {
                            click.start();
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("7"));
                    }

                    if (help_play == 1) {
                        try {
                            one_play_editor.putInt("Help_play_7", 2);
                            one_play_editor.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        about3.setTextColor(getResources().getColor(R.color.background_sport));
                        day10.setBackgroundResource(R.drawable.circle_food_confirm_on);
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                about3.setTextColor(getResources().getColor(R.color.color30day));
                                day10.setBackgroundResource(R.drawable.circle_food_day_off);
                            } catch (Resources.NotFoundException e) {
                                e.printStackTrace();
                            }

                            /*Bundle colery2 = getActivity().getIntent().getExtras();
                            String colery_2 = colery2.getString("bmr_food_cahesh");
                            String colery_3 = colery2.getString("gender_food_1");
                            String colery_4 = colery2.getString("tall_food_1");
                            String colery_5 = colery2.getString("weight_food_meghdar_1");
                            String colery_6 = colery2.getString("weight_food_1");

                            Intent uou2 = new Intent(getActivity(), food_male_plan_10.class);
                            uou2.putExtra("colery2_came", colery_2);
                            uou2.putExtra("gender_food_2", colery_3);
                            uou2.putExtra("tall_food_2", colery_4);
                            uou2.putExtra("weight_food_meghdar_2", colery_5);
                            uou2.putExtra("weight_food_2", colery_6);
                            uou2.putExtra("zaban_fo", food_page_org.zaban);
                            startActivity(uou2);

                            try {
                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        App_food.close();
                                        getActivity().finish();
                                    }
                                }, _splashTime3);
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("8"));
                            }*/

                        }
                    }, _splashTime3);




                    Intent uou2 = new Intent(getActivity(), food_male_plan_10.class);
                    uou2.putExtra("colery2_came", colery_2);
                    uou2.putExtra("gender_food_2", colery_3);
                    uou2.putExtra("tall_food_2", colery_4);
                    uou2.putExtra("weight_food_meghdar_2", colery_5);
                    uou2.putExtra("weight_food_2", colery_6);
                    uou2.putExtra("mp", 1);
                    startActivity(uou2);

                    try {
                        App_food.close();
                        getActivity().finish();
                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("8"));
                    }
                }

            });


            final TextView about31 = (TextView) view.findViewById(R.id.txt_food_day_2_3);
            final RelativeLayout day101 = (RelativeLayout) view.findViewById(R.id.rl_food_day_2_1);


            day101.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        if (vibre_check == music_off_check) {
                            vb.cancel();
                        } else {
                            vb.vibrate(100);
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("9"));
                    }

                    try {

                        click = MediaPlayer.create(getActivity(), R.raw.button);
                        if (music_check == music_off_check) {
                            click.stop();
                        } else {
                            click.start();
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("10"));
                    }

                    try {
                        about31.setTextColor(getResources().getColor(R.color.background_sport));
                        day101.setBackgroundResource(R.drawable.circle_food_confirm_on);
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                about31.setTextColor(getResources().getColor(R.color.color30day));
                                day101.setBackgroundResource(R.drawable.circle_food_day_off);
                            } catch (Resources.NotFoundException e) {
                                e.printStackTrace();
                            }

                            Intent uou2 = new Intent(getActivity(), food_male_plan_10.class);
                            uou2.putExtra("colery2_came", colery_2);
                            uou2.putExtra("gender_food_2", colery_3);
                            uou2.putExtra("tall_food_2", colery_4);
                            uou2.putExtra("weight_food_meghdar_2", colery_5);
                            uou2.putExtra("weight_food_2", colery_6);
                            uou2.putExtra("mp", 2);
                            startActivity(uou2);

                            try {
                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        App_food.close();
                                        getActivity().finish();
                                    }
                                }, _splashTime3);
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("11"));
                            }


                        }
                    }, _splashTime3);

                }

            });

            final TextView about311 = (TextView) view.findViewById(R.id.txt_food_day_3_3);
            final RelativeLayout day1011 = (RelativeLayout) view.findViewById(R.id.rl_food_day_3_1);

            day1011.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        if (vibre_check == music_off_check) {
                            vb.cancel();
                        } else {
                            vb.vibrate(100);
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("12"));
                    }

                    try {

                        click = MediaPlayer.create(getActivity(), R.raw.button);
                        if (music_check == music_off_check) {
                            click.stop();
                        } else {
                            click.start();
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("13"));
                    }

                    try {
                        about311.setTextColor(getResources().getColor(R.color.background_sport));
                        day1011.setBackgroundResource(R.drawable.circle_food_confirm_on);
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                    }

                    new Handler().postDelayed(new Thread() {
                        @Override
                        public void run() {
                            super.run();

                            try {
                                about311.setTextColor(getResources().getColor(R.color.color30day));
                                day1011.setBackgroundResource(R.drawable.circle_food_day_off);
                            } catch (Resources.NotFoundException e) {
                                e.printStackTrace();
                            }

                            Intent uou2 = new Intent(getActivity(), food_male_plan_10.class);
                            uou2.putExtra("colery2_came", colery_2);
                            uou2.putExtra("gender_food_2", colery_3);
                            uou2.putExtra("tall_food_2", colery_4);
                            uou2.putExtra("weight_food_meghdar_2", colery_5);
                            uou2.putExtra("weight_food_2", colery_6);
                            uou2.putExtra("mp", 3);
                            startActivity(uou2);

                            try {
                                new Handler().postDelayed(new Thread() {
                                    @Override
                                    public void run() {
                                        App_food.close();
                                        getActivity().finish();
                                    }
                                }, _splashTime3);
                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("8"));
                            }


                        }
                    }, _splashTime3);

                }

            });

            FirebaseCrash.log("log 4");

        } else if (mPage == 2) {

            view = inflater.inflate(R.layout.food_page_org_2, container, false);

            lview = (ListView) view.findViewById(R.id.listview);

            try {

                list_food_cal.getInstance(getActivity()).populateList();

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("16"));
            }

            try {

                adapter = new listviewAdapter(getActivity(), list_food_cal.list);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("17"));
            }

            try {

                lview.setAdapter(adapter);
                lview.setFastScrollEnabled(false);
                lview.setVerticalScrollBarEnabled(false);
                lview.setTextFilterEnabled(true);

            } catch (Exception e) {
                FirebaseCrash.report(new Exception("18"));
            }


            TextView txt_ser = (TextView) view.findViewById(R.id.txt_ser);
            txt_ser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {

                        vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        if (vibre_check == music_off_check) {
                            vb.cancel();
                        } else {
                            vb.vibrate(100);
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("19"));
                    }

                    try {

                        click = MediaPlayer.create(getActivity(), R.raw.button);
                        if (music_check == music_off_check) {
                            click.stop();
                        } else {
                            click.start();
                        }

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("20"));
                    }


                    ms = 2;
                    Intent search = new Intent(getActivity(), Search.class);
                    getActivity().startActivity(search);

                    try {

                        list_food_cal.list.clear();
                        list_food_cal.list.addAll(list_food_cal.list_b);

                    } catch (Exception e) {
                        FirebaseCrash.report(new Exception("21"));
                    }


                }
                //   }
            });


            FirebaseCrash.log("log 3");
        }

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        //AdColony.resume(getActivity());
        FirebaseCrash.log("log 2");
        System.gc();
    }

    @Override
    public void onPause() {
        super.onPause();
        //AdColony.pause();
        FirebaseCrash.log("log 1");
        System.gc();
    }
}