package com.android.fury.a30day.food;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.DownloadManagerHelper;
import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.List;

/**
 * Created by fury on 9/10/2016.
 */
public class TestRecyclerViewAdapter_food_1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    TextView txt_male_plan_10_food_1, txt_male_plan_10_food_2, txt_male_plan_10_food_re_2, txt_male_plan_10_food_food_p_4, txt_male_plan_10_food_food_p_7, txt_male_plan_10_food_food_p_10, txt_male_plan_10_food_food_p_13, txt_male_plan_10_food_food_p_16;

    CardView card_view_food_1, card_view_food_2;

    ProgressDialog mProgressDialog;


    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL2 = 1;
    static final int TYPE_CELL = 2;
    static final int TYPE_CELL3 = 3;

    private static String fileName = "al.mp4";

    Context context;

    SharedPreferences one_play_preferences;
    SharedPreferences.Editor one_play_editor;

    public TestRecyclerViewAdapter_food_1(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            case 1:
                return TYPE_CELL2;
            case 2:
                return TYPE_CELL;
            default:
                return TYPE_CELL3;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {

            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_food_1, parent, false);

                card_view_food_1 = (CardView) view.findViewById(R.id.card_view_food_1);

                txt_male_plan_10_food_1 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_1);
                txt_male_plan_10_food_2 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_2);

                if (food_male_plan_10_food.fff == 1) {

                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_1);

                } else if (food_male_plan_10_food.fff == 2) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_2);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_2);

                } else if (food_male_plan_10_food.fff == 3) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_3);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_3);

                } else if (food_male_plan_10_food.fff == 4) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_4);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_4);

                } else if (food_male_plan_10_food.fff == 5) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_5);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_5);

                } else if (food_male_plan_10_food.fff == 6) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_6);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_6);

                } else if (food_male_plan_10_food.fff == 7) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_7);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_7);

                } else if (food_male_plan_10_food.fff == 8) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_8);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_8);

                } else if (food_male_plan_10_food.fff == 9) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_9);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_9);

                } else if (food_male_plan_10_food.fff == 10) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_10);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_10);

                } else if (food_male_plan_10_food.fff == 11) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_11);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_11);

                } else if (food_male_plan_10_food.fff == 12) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_12);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_12);

                } else if (food_male_plan_10_food.fff == 13) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_13);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_13);

                } else if (food_male_plan_10_food.fff == 14) {

                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_14);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_14);

                } else if (food_male_plan_10_food.fff == 15) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_15);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_15);

                } else if (food_male_plan_10_food.fff == 16) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_16);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_16);

                } else if (food_male_plan_10_food.fff == 17) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_17);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_17);

                } else if (food_male_plan_10_food.fff == 18) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_18);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_18);

                } else if (food_male_plan_10_food.fff == 19) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_19);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_19);

                } else if (food_male_plan_10_food.fff == 20) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_20);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_20);

                } else if (food_male_plan_10_food.fff == 21) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_21);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_21);

                } else if (food_male_plan_10_food.fff == 22) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_22);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_22);

                } else if (food_male_plan_10_food.fff == 23) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_23);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_23);

                } else if (food_male_plan_10_food.fff == 24) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_24);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_24);

                } else if (food_male_plan_10_food.fff == 25) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_25);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_25);

                } else if (food_male_plan_10_food.fff == 26) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_26);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_26);

                } else if (food_male_plan_10_food.fff == 27) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_27);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_27);

                } else if (food_male_plan_10_food.fff == 28) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_28);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_28);

                } else if (food_male_plan_10_food.fff == 29) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_29);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_29);

                } else if (food_male_plan_10_food.fff == 30) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_30);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_30);

                } else if (food_male_plan_10_food.fff == 31) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_31);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_31);

                } else if (food_male_plan_10_food.fff == 32) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_32);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_32);

                } else if (food_male_plan_10_food.fff == 33) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_33);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_33);

                } else if (food_male_plan_10_food.fff == 34) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_34);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_34);

                } else if (food_male_plan_10_food.fff == 35) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_35);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_35);

                } else if (food_male_plan_10_food.fff == 36) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_36);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_36);

                } else if (food_male_plan_10_food.fff == 37) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_37);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_37);

                } else if (food_male_plan_10_food.fff == 38) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_38);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_38);

                } else if (food_male_plan_10_food.fff == 39) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_39);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_39);

                } else if (food_male_plan_10_food.fff == 40) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_40);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_40);

                } else if (food_male_plan_10_food.fff == 41) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_41);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_41);

                } else if (food_male_plan_10_food.fff == 42) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_42);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_42);

                } else if (food_male_plan_10_food.fff == 43) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_43);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_43);

                } else if (food_male_plan_10_food.fff == 44) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_44);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_44);

                } else if (food_male_plan_10_food.fff == 45) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_45);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_45);

                } else if (food_male_plan_10_food.fff == 46) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_46);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_46);

                } else if (food_male_plan_10_food.fff == 47) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_47);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_47);

                } else if (food_male_plan_10_food.fff == 48) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_48);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_48);

                } else if (food_male_plan_10_food.fff == 49) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_49);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_49);

                } else if (food_male_plan_10_food.fff == 50) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_50);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_50);

                } else if (food_male_plan_10_food.fff == 51) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_51);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_51);

                } else if (food_male_plan_10_food.fff == 52) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_52);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_52);

                } else if (food_male_plan_10_food.fff == 53) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_53);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_53);

                } else if (food_male_plan_10_food.fff == 54) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_54);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_54);

                } else if (food_male_plan_10_food.fff == 55) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_55);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_55);

                } else if (food_male_plan_10_food.fff == 56) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_56);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_56);

                } else if (food_male_plan_10_food.fff == 57) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_57);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_57);

                } else if (food_male_plan_10_food.fff == 58) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_58);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_58);

                } else if (food_male_plan_10_food.fff == 59) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_59);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_59);

                } else if (food_male_plan_10_food.fff == 60) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_60);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_60);

                } else if (food_male_plan_10_food.fff == 61) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_61);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_61);

                } else if (food_male_plan_10_food.fff == 62) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_62);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_62);

                } else if (food_male_plan_10_food.fff == 63) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_63);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_63);

                } else if (food_male_plan_10_food.fff == 64) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_64);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_64);

                } else if (food_male_plan_10_food.fff == 65) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_65);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_65);

                } else if (food_male_plan_10_food.fff == 66) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_66);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_66);

                } else if (food_male_plan_10_food.fff == 67) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_67);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_67);

                } else if (food_male_plan_10_food.fff == 68) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_68);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_68);

                } else if (food_male_plan_10_food.fff == 69) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_69);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_69);

                } else if (food_male_plan_10_food.fff == 70) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_70);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_70);

                } else if (food_male_plan_10_food.fff == 71) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_71);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_71);

                } else if (food_male_plan_10_food.fff == 72) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_72);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_72);

                } else if (food_male_plan_10_food.fff == 73) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_73);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_73);

                } else if (food_male_plan_10_food.fff == 74) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_74);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_74);

                } else if (food_male_plan_10_food.fff == 75) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_75);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_75);

                } else if (food_male_plan_10_food.fff == 76) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_76);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_76);

                } else if (food_male_plan_10_food.fff == 77) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_77);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_77);

                } else if (food_male_plan_10_food.fff == 78) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_78);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_78);

                } else if (food_male_plan_10_food.fff == 79) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_79);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_79);

                } else if (food_male_plan_10_food.fff == 80) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_80);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_80);

                } else if (food_male_plan_10_food.fff == 81) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_81);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_81);

                } else if (food_male_plan_10_food.fff == 82) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_82);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_82);

                } else if (food_male_plan_10_food.fff == 83) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_83);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_83);

                } else if (food_male_plan_10_food.fff == 84) {


                    txt_male_plan_10_food_1.setText(R.string.food_male_plan_10_food_name_84);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_84);

                } else if (food_male_plan_10_food.fff == 101) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_31_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_101);

                } else if (food_male_plan_10_food.fff == 102) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_32_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_102);

                } else if (food_male_plan_10_food.fff == 103) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_31_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_101);

                } else if (food_male_plan_10_food.fff == 104) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_32_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_102);

                } else if (food_male_plan_10_food.fff == 105) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_31_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_101);

                } else if (food_male_plan_10_food.fff == 106) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_32_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_102);

                } else if (food_male_plan_10_food.fff == 107) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_33_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_107);

                } else if (food_male_plan_10_food.fff == 108) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_34_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_108);

                } else if (food_male_plan_10_food.fff == 109) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_33_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_107);

                } else if (food_male_plan_10_food.fff == 110) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_34_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_108);

                } else if (food_male_plan_10_food.fff == 111) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_33_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_107);

                } else if (food_male_plan_10_food.fff == 112) {


                    txt_male_plan_10_food_1.setText(R.string.meal_plan_34_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_108);

                } else if (food_male_plan_10_food.fff == 113) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_35_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_113);

                } else if (food_male_plan_10_food.fff == 114) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_36_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_114);

                } else if (food_male_plan_10_food.fff == 115) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_35_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_113);

                } else if (food_male_plan_10_food.fff == 116) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_36_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_114);

                } else if (food_male_plan_10_food.fff == 117) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_35_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_113);

                } else if (food_male_plan_10_food.fff == 118) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_36_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_114);

                } else if (food_male_plan_10_food.fff == 119) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_37_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_119);

                } else if (food_male_plan_10_food.fff == 120) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_38_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_120);

                } else if (food_male_plan_10_food.fff == 121) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_37_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_119);

                } else if (food_male_plan_10_food.fff == 122) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_38_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_120);

                } else if (food_male_plan_10_food.fff == 123) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_37_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_119);

                } else if (food_male_plan_10_food.fff == 124) {

                    txt_male_plan_10_food_1.setText(R.string.meal_plan_38_1);
                    txt_male_plan_10_food_2.setText(food_male_plan_10_food.food_ma_120);

                }
                FirebaseCrash.log("log 1");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL2: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_food_2, parent, false);

                card_view_food_2 = (CardView) view.findViewById(R.id.card_view_food_2);
                txt_male_plan_10_food_re_2 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_re_2);


                if (food_male_plan_10_food.fff == 1) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_1_r);

                } else if (food_male_plan_10_food.fff == 2) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_2_r);

                } else if (food_male_plan_10_food.fff == 3) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_3_r);

                } else if (food_male_plan_10_food.fff == 4) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_4_r);

                } else if (food_male_plan_10_food.fff == 5) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_5_r);

                } else if (food_male_plan_10_food.fff == 6) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_6_r);

                } else if (food_male_plan_10_food.fff == 7) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_7_r);

                } else if (food_male_plan_10_food.fff == 8) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_8_r);

                } else if (food_male_plan_10_food.fff == 9) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_9_r);

                } else if (food_male_plan_10_food.fff == 10) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_10_r);

                } else if (food_male_plan_10_food.fff == 11) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_11_r);

                } else if (food_male_plan_10_food.fff == 12) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_12_r);

                } else if (food_male_plan_10_food.fff == 13) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_13_r);

                } else if (food_male_plan_10_food.fff == 14) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_14_r);

                } else if (food_male_plan_10_food.fff == 15) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_15_r);

                } else if (food_male_plan_10_food.fff == 16) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_16_r);

                } else if (food_male_plan_10_food.fff == 17) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_17_r);

                } else if (food_male_plan_10_food.fff == 18) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_18_r);

                } else if (food_male_plan_10_food.fff == 19) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_19_r);

                } else if (food_male_plan_10_food.fff == 20) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_20_r);

                } else if (food_male_plan_10_food.fff == 21) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_21_r);

                } else if (food_male_plan_10_food.fff == 22) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_22_r);

                } else if (food_male_plan_10_food.fff == 23) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_23_r);

                } else if (food_male_plan_10_food.fff == 24) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_24_r);

                } else if (food_male_plan_10_food.fff == 25) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_25_r);

                } else if (food_male_plan_10_food.fff == 26) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_26_r);

                } else if (food_male_plan_10_food.fff == 27) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_27_r);

                } else if (food_male_plan_10_food.fff == 28) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_28_r);

                } else if (food_male_plan_10_food.fff == 29) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_29_r);

                } else if (food_male_plan_10_food.fff == 30) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_30_r);

                } else if (food_male_plan_10_food.fff == 31) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_31_r);

                } else if (food_male_plan_10_food.fff == 32) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_32_r);

                } else if (food_male_plan_10_food.fff == 33) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_33_r);

                } else if (food_male_plan_10_food.fff == 34) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_34_r);

                } else if (food_male_plan_10_food.fff == 35) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_35_r);

                } else if (food_male_plan_10_food.fff == 36) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_36_r);

                } else if (food_male_plan_10_food.fff == 37) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_37_r);

                } else if (food_male_plan_10_food.fff == 38) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_38_r);

                } else if (food_male_plan_10_food.fff == 39) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_39_r);

                } else if (food_male_plan_10_food.fff == 40) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_40_r);

                } else if (food_male_plan_10_food.fff == 41) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_41_r);

                } else if (food_male_plan_10_food.fff == 42) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_42_r);

                } else if (food_male_plan_10_food.fff == 43) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_43_r);

                } else if (food_male_plan_10_food.fff == 44) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_44_r);

                } else if (food_male_plan_10_food.fff == 45) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_45_r);

                } else if (food_male_plan_10_food.fff == 46) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_46_r);

                } else if (food_male_plan_10_food.fff == 47) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_47_r);

                } else if (food_male_plan_10_food.fff == 48) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_48_r);

                } else if (food_male_plan_10_food.fff == 49) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_49_r);

                } else if (food_male_plan_10_food.fff == 50) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_50_r);

                } else if (food_male_plan_10_food.fff == 51) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_51_r);

                } else if (food_male_plan_10_food.fff == 52) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_52_r);

                } else if (food_male_plan_10_food.fff == 53) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_53_r);

                } else if (food_male_plan_10_food.fff == 54) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_54_r);

                } else if (food_male_plan_10_food.fff == 55) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_55_r);

                } else if (food_male_plan_10_food.fff == 56) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_56_r);

                } else if (food_male_plan_10_food.fff == 57) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_57_r);

                } else if (food_male_plan_10_food.fff == 58) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_58_r);

                } else if (food_male_plan_10_food.fff == 59) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_59_r);

                } else if (food_male_plan_10_food.fff == 60) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_60_r);

                } else if (food_male_plan_10_food.fff == 61) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_61_r);

                } else if (food_male_plan_10_food.fff == 62) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_62_r);

                } else if (food_male_plan_10_food.fff == 63) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_63_r);

                } else if (food_male_plan_10_food.fff == 64) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_64_r);

                } else if (food_male_plan_10_food.fff == 65) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_65_r);

                } else if (food_male_plan_10_food.fff == 66) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_66_r);

                } else if (food_male_plan_10_food.fff == 67) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_67_r);

                } else if (food_male_plan_10_food.fff == 68) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_68_r);

                } else if (food_male_plan_10_food.fff == 69) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_69_r);

                } else if (food_male_plan_10_food.fff == 70) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_70_r);

                } else if (food_male_plan_10_food.fff == 71) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_71_r);

                } else if (food_male_plan_10_food.fff == 72) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_72_r);

                } else if (food_male_plan_10_food.fff == 73) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_73_r);

                } else if (food_male_plan_10_food.fff == 74) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_74_r);

                } else if (food_male_plan_10_food.fff == 75) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_75_r);

                } else if (food_male_plan_10_food.fff == 76) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_76_r);

                } else if (food_male_plan_10_food.fff == 77) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_77_r);

                } else if (food_male_plan_10_food.fff == 78) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_78_r);

                } else if (food_male_plan_10_food.fff == 79) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_79_r);

                } else if (food_male_plan_10_food.fff == 80) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_80_r);

                } else if (food_male_plan_10_food.fff == 81) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_81_r);

                } else if (food_male_plan_10_food.fff == 82) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_82_r);

                } else if (food_male_plan_10_food.fff == 83) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_83_r);

                } else if (food_male_plan_10_food.fff == 84) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_84_r);

                } else if (food_male_plan_10_food.fff == 101) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_101_r);

                } else if (food_male_plan_10_food.fff == 102) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_102_r);

                } else if (food_male_plan_10_food.fff == 103) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_101_r);

                } else if (food_male_plan_10_food.fff == 104) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_102_r);

                } else if (food_male_plan_10_food.fff == 105) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_101_r);

                } else if (food_male_plan_10_food.fff == 106) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_102_r);

                } else if (food_male_plan_10_food.fff == 107) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_107_r);

                } else if (food_male_plan_10_food.fff == 108) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_108_r);

                } else if (food_male_plan_10_food.fff == 109) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_107_r);

                } else if (food_male_plan_10_food.fff == 110) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_108_r);

                } else if (food_male_plan_10_food.fff == 111) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_107_r);

                } else if (food_male_plan_10_food.fff == 112) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_108_r);

                } else if (food_male_plan_10_food.fff == 113) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_113_r);

                } else if (food_male_plan_10_food.fff == 114) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_114_r);

                } else if (food_male_plan_10_food.fff == 115) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_113_r);

                } else if (food_male_plan_10_food.fff == 116) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_114_r);

                } else if (food_male_plan_10_food.fff == 117) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_113_r);

                } else if (food_male_plan_10_food.fff == 118) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_114_r);

                } else if (food_male_plan_10_food.fff == 119) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_119_r);

                } else if (food_male_plan_10_food.fff == 120) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_120_r);

                } else if (food_male_plan_10_food.fff == 121) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_119_r);

                } else if (food_male_plan_10_food.fff == 122) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_120_r);

                } else if (food_male_plan_10_food.fff == 123) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_119_r);

                } else if (food_male_plan_10_food.fff == 124) {


                    txt_male_plan_10_food_re_2.setText(food_male_plan_10_food.food_male_plan_10_food_120_r);

                }

                FirebaseCrash.log("log 2");

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_food_3, parent, false);


                txt_male_plan_10_food_food_p_4 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_food_p_4);
                txt_male_plan_10_food_food_p_7 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_food_p_7);
                txt_male_plan_10_food_food_p_10 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_food_p_10);
                txt_male_plan_10_food_food_p_13 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_food_p_13);
                txt_male_plan_10_food_food_p_16 = (TextView) view.findViewById(R.id.txt_male_plan_10_food_food_p_16);

                if (food_male_plan_10_food.fff == 1) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_1);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_1);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_1);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_1);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_1);

                } else if (food_male_plan_10_food.fff == 2) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_2);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_2);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_2);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_2);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_2);

                } else if (food_male_plan_10_food.fff == 3) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_3);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_3);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_3);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_3);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_3);

                } else if (food_male_plan_10_food.fff == 4) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_4);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_4);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_4);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_4);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_4);

                } else if (food_male_plan_10_food.fff == 5) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_5);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_5);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_5);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_5);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_5);

                } else if (food_male_plan_10_food.fff == 6) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_6);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_6);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_6);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_6);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_6);

                } else if (food_male_plan_10_food.fff == 7) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_7);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_7);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_7);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_7);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_7);

                } else if (food_male_plan_10_food.fff == 8) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_8);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_8);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_8);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_8);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_8);

                } else if (food_male_plan_10_food.fff == 9) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_9);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_9);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_9);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_9);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_9);

                } else if (food_male_plan_10_food.fff == 10) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_10);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_10);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_10);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_10);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_10);

                } else if (food_male_plan_10_food.fff == 11) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_11);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_11);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_11);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_11);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_11);

                } else if (food_male_plan_10_food.fff == 12) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_12);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_12);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_12);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_12);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_12);

                } else if (food_male_plan_10_food.fff == 13) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_13);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_13);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_13);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_13);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_13);

                } else if (food_male_plan_10_food.fff == 14) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_14);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_14);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_14);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_14);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_14);

                } else if (food_male_plan_10_food.fff == 15) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_15);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_15);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_15);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_15);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_15);

                } else if (food_male_plan_10_food.fff == 16) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_16);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_16);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_15);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_16);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_16);

                } else if (food_male_plan_10_food.fff == 17) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_17);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_17);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_17);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_17);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_17);

                } else if (food_male_plan_10_food.fff == 18) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_18);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_18);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_15);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_18);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_18);

                } else if (food_male_plan_10_food.fff == 19) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_19);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_19);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_19);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_19);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_19);

                } else if (food_male_plan_10_food.fff == 20) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_20);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_20);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_20);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_20);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_20);

                } else if (food_male_plan_10_food.fff == 21) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_21);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_21);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_21);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_21);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_21);

                } else if (food_male_plan_10_food.fff == 22) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_22);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_22);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_22);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_22);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_22);

                } else if (food_male_plan_10_food.fff == 23) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_23);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_23);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_23);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_23);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_23);

                } else if (food_male_plan_10_food.fff == 24) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_24);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_24);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_24);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_24);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_24);

                } else if (food_male_plan_10_food.fff == 25) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_25);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_25);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_25);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_25);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_25);

                } else if (food_male_plan_10_food.fff == 26) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_26);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_26);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_26);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_26);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_26);

                } else if (food_male_plan_10_food.fff == 27) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_27);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_27);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_27);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_27);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_27);

                } else if (food_male_plan_10_food.fff == 28) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_28);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_28);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_28);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_28);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_28);

                } else if (food_male_plan_10_food.fff == 29) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_29);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_29);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_29);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_29);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_29);

                } else if (food_male_plan_10_food.fff == 30) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_30);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_30);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_30);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_30);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_30);

                } else if (food_male_plan_10_food.fff == 31) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_31);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_31);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_31);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_31);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_31);

                } else if (food_male_plan_10_food.fff == 32) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_32);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_32);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_32);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_32);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_32);

                } else if (food_male_plan_10_food.fff == 33) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_33);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_33);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_33);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_33);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_33);

                } else if (food_male_plan_10_food.fff == 34) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_34);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_34);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_34);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_34);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_34);

                } else if (food_male_plan_10_food.fff == 35) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_35);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_35);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_35);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_35);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_35);

                } else if (food_male_plan_10_food.fff == 36) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_36);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_36);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_36);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_36);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_36);

                } else if (food_male_plan_10_food.fff == 37) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_37);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_37);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_37);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_37);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_37);

                } else if (food_male_plan_10_food.fff == 38) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_38);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_38);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_38);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_38);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_38);

                } else if (food_male_plan_10_food.fff == 39) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_39);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_39);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_39);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_39);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_39);

                } else if (food_male_plan_10_food.fff == 40) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_40);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_40);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_40);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_40);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_40);

                } else if (food_male_plan_10_food.fff == 41) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_41);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_41);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_41);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_41);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_41);

                } else if (food_male_plan_10_food.fff == 42) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_42);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_42);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_42);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_42);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_42);

                } else if (food_male_plan_10_food.fff == 43) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_43);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_43);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_43);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_43);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_43);

                } else if (food_male_plan_10_food.fff == 44) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_44);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_44);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_44);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_44);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_44);

                } else if (food_male_plan_10_food.fff == 45) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_45);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_45);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_45);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_45);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_45);

                } else if (food_male_plan_10_food.fff == 46) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_46);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_46);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_46);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_46);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_46);

                } else if (food_male_plan_10_food.fff == 47) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_47);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_47);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_47);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_47);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_47);

                } else if (food_male_plan_10_food.fff == 48) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_48);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_48);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_48);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_48);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_48);

                } else if (food_male_plan_10_food.fff == 49) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_49);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_49);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_49);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_49);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_49);

                } else if (food_male_plan_10_food.fff == 50) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_50);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_50);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_50);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_50);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_50);

                } else if (food_male_plan_10_food.fff == 51) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_51);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_51);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_51);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_51);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_51);

                } else if (food_male_plan_10_food.fff == 52) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_52);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_52);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_52);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_52);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_52);

                } else if (food_male_plan_10_food.fff == 53) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_53);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_53);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_53);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_53);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_53);

                } else if (food_male_plan_10_food.fff == 54) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_54);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_54);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_54);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_54);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_54);

                } else if (food_male_plan_10_food.fff == 55) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_55);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_55);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_55);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_55);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_55);

                } else if (food_male_plan_10_food.fff == 56) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_56);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_56);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_56);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_56);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_56);

                } else if (food_male_plan_10_food.fff == 57) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_57);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_57);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_57);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_57);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_57);

                } else if (food_male_plan_10_food.fff == 58) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_58);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_58);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_58);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_58);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_58);

                } else if (food_male_plan_10_food.fff == 59) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_59);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_59);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_59);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_59);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_59);

                } else if (food_male_plan_10_food.fff == 60) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_60);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_60);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_60);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_60);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_60);

                } else if (food_male_plan_10_food.fff == 61) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_61);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_61);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_61);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_61);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_61);

                } else if (food_male_plan_10_food.fff == 62) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_62);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_62);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_62);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_62);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_62);

                } else if (food_male_plan_10_food.fff == 63) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_63);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_63);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_63);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_63);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_63);

                } else if (food_male_plan_10_food.fff == 64) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_64);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_64);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_64);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_64);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_64);

                } else if (food_male_plan_10_food.fff == 65) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_65);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_65);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_65);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_65);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_65);

                } else if (food_male_plan_10_food.fff == 66) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_66);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_66);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_66);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_66);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_66);

                } else if (food_male_plan_10_food.fff == 67) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_67);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_67);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_67);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_67);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_67);

                } else if (food_male_plan_10_food.fff == 68) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_68);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_68);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 69) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_69);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_69);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_69);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_69);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_69);

                } else if (food_male_plan_10_food.fff == 70) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_70);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_70);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_70);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_70);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_70);

                } else if (food_male_plan_10_food.fff == 71) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_71);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_71);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_71);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_71);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_71);

                } else if (food_male_plan_10_food.fff == 72) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_72);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_72);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_72);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_72);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_72);

                } else if (food_male_plan_10_food.fff == 73) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_73);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_73);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_73);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_73);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_73);

                } else if (food_male_plan_10_food.fff == 74) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_74);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_74);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_74);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_74);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_74);

                } else if (food_male_plan_10_food.fff == 75) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_75);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_75);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_75);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_75);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_75);

                } else if (food_male_plan_10_food.fff == 76) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_76);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_76);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_76);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_76);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_76);

                } else if (food_male_plan_10_food.fff == 77) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_77);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_77);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_77);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_77);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_77);

                } else if (food_male_plan_10_food.fff == 78) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_78);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_78);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_78);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_78);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_78);

                } else if (food_male_plan_10_food.fff == 79) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_79);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_79);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_79);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_79);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_79);

                } else if (food_male_plan_10_food.fff == 80) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_80);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_80);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_80);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_80);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_80);

                } else if (food_male_plan_10_food.fff == 81) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_81);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_81);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_81);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_81);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_81);

                } else if (food_male_plan_10_food.fff == 82) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_82);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_82);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_82);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_82);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_82);

                } else if (food_male_plan_10_food.fff == 83) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_83);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_83);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_83);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_83);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_83);

                } else if (food_male_plan_10_food.fff == 84) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_84);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_84);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_84);

                } else if (food_male_plan_10_food.fff == 101) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 102) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 103) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 104) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 105) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 106) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 107) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 108) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 109) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 110) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 111) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 112) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 113) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 114) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 115) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 116) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 117) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 118) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 119) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 118) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 120) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 121) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 122) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 123) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                } else if (food_male_plan_10_food.fff == 124) {

                    txt_male_plan_10_food_food_p_4.setText(R.string.food_male_plan_10_food_1_f_p_68);
                    txt_male_plan_10_food_food_p_7.setText(R.string.food_male_plan_10_food_1_f_f_68);
                    txt_male_plan_10_food_food_p_10.setText(R.string.food_male_plan_10_food_1_f_c_84);
                    txt_male_plan_10_food_food_p_13.setText(R.string.food_male_plan_10_food_1_f_s_84);
                    txt_male_plan_10_food_food_p_16.setText(R.string.food_male_plan_10_food_1_f_ca_68);

                }

                FirebaseCrash.log("log 3");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL3: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_food_4, parent, false);

                final ImageView im_download_video_1 = (ImageView) view.findViewById(R.id.im_download_video_1);

                ImageView video_play = (ImageView) view.findViewById(R.id.video_play);
                CardView card_view_food_download = (CardView) view.findViewById(R.id.card_view_food_download);


                if (food_male_plan_10_food.fff == 3) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 4) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 5) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 13) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 22) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 25) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 34) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 38) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 43) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 45) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 51) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 51) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 54) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 65) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 68) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 74) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 79) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 81) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 83) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 84) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 101) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 103) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 105) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 107) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 109) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 111) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 119) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 121) {

                    card_view_food_download.setVisibility(View.GONE);

                } else if (food_male_plan_10_food.fff == 123) {

                    card_view_food_download.setVisibility(View.GONE);

                }
                FirebaseCrash.log("log 4");
                video_play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (food_male_plan_10_food.fff == 1) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/polenta.mp4"), "video/*");
                            context.startActivity(tostart);


                        } else if (food_male_plan_10_food.fff == 2) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/mexican-pizza.mp4"), "video/*");
                            context.startActivity(tostart);


                        } else if (food_male_plan_10_food.fff == 3) {


                        } else if (food_male_plan_10_food.fff == 4) {


                        } else if (food_male_plan_10_food.fff == 5) {


                        } else if (food_male_plan_10_food.fff == 6) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/tofu.mp4"), "video/*");
                            context.startActivity(tostart);


                        } else if (food_male_plan_10_food.fff == 7) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/spicy-sausage.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 8) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/green-peans-and-carrots-reccipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 9) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Quick-Piri-Piri-BBQ-Chicken-for-Labor-Day-Weekend-.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 10) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Stuffed-Chicken-Parmesan.m4v"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 11) {


                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/7/furystudio_1/Easy-Butter-Chicken.mp4"), "video/*");
                            context.startActivity(tostart);


                        } else if (food_male_plan_10_food.fff == 12) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Chicken-Kiev-with-Rutabaga-Chilli-Mash-recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 13) {


                        } else if (food_male_plan_10_food.fff == 14) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Curry-Recipes-How-to-Make-Chicken-Tikka-Masala.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 15) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Green-Falafel-Quick-Easy-Vegan-.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 16) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Ratatouille-Boats.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 17) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Mississippi-Roast.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 18) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Mixed-Vegetable-Fried-rice-easy-amp-quick-recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 19) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/NYC-Sushi-Burrito.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 20) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Homemade-Ricotta-Ravioli.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 21) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Stuffed-Chicken-Nuggets.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 22) {


                        } else if (food_male_plan_10_food.fff == 23) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/How-to-Make-Schnitzel.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 24) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Stuffed-Steak-Rolls.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 25) {


                        } else if (food_male_plan_10_food.fff == 26) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Fail-Safe-Roast-Turkey-Jamie-Oliver.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 27) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Sliders-4-Ways.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 28) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Cheddar-Parmesan-Cauliflower-Bites.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 29) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Healthy-Blueberry-Muffin-Recipe-How-To-Make-Low-Fat-Low-Calorie-Blueberry-Muffins.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 30) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Gorgeous-Griddled-Chicken-with-Donal-Skehan.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 31) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Chorizo-Pilaf-One-Pot-Chef.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 32) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Sweet-amp-Spicy-Chicken.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 33) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Prawn-and-Pork-Ribs-Noodle-Soup.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 34) {


                        } else if (food_male_plan_10_food.fff == 35) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Creamy-Carrot-Potato-and-Lentil-Soup.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 36) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/How-to-Make-Simple-Vegetable-Lasagna-MyRecipes.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 37) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Parmesan-Garlic-Roasted-Green-Beans-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 38) {


                        } else if (food_male_plan_10_food.fff == 39) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Gazpacho-Recipe-Cold-Tomato-Cucumber-Pepper-Soup.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 40) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Coconut-Carrot-and-Chickpea-Soup-Special-Diet-Recipes-l-Whole-Foods-Market.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 41) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Zereshk-Polo-ba-morgh-Barberry-Rice-Saffron-Chicken-.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 42) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Pea-and-Bean-Salad-with-Soft-Boiled-Eggs-Waitrose.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 43) {


                        } else if (food_male_plan_10_food.fff == 44) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Chicken-Pot-Pie-As-Made-By-Wolfgang-Puck-.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 45) {


                        } else if (food_male_plan_10_food.fff == 46) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Healthy-Muesli-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 47) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Baked-Eggs-Benedict-Cups.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 48) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Paul-s-delicious-malt-loaf-Paul-Hollywood-s-Bread-BBC-Food.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 49) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Roasted-Chicken-with-an-Easy-Ratatouille-Recipe-From-the-Test-Kitchen.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 50) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Chicken-Stew.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 51) {


                        } else if (food_male_plan_10_food.fff == 52) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/How-to-Make-Bulgur-Salad-Recipe-in-description.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 53) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Sprouted-Lentil-Salad-in-Green-Goddess-Tahini-Dressing.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 54) {


                        } else if (food_male_plan_10_food.fff == 55) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/How-To-Make-Beef-amp-Broccoli-Noodles-Delish.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 56) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Harissa-Chicken-Rule-of-Yum-recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 57) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/One-Pan-Basil-Halloumi-Chicken.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 58) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Quick-Tomato-Pizza-Tomato-cheese-pizza-Recipe-Cheese-And-Tomato-Pizza-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 59) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/sweet-corn-soup-recipe-sweet-corn-and-vegetable-soup-recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 60) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Tuna-Pesto-amp-Rice-Salad.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 61) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Rice-Cooker-Cinnamon-Pancakes.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 62) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Hans-Oliving-Frittata-with-ham-spinach-parmesan-feta-and-a-potato-base.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 63) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Oriental-Beef-Salad-Food-Busker.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 64) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Pasta-Salad-4-Ways.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 65) {


                        } else if (food_male_plan_10_food.fff == 66) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Skillet-Lasagna.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 67) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Rice-Recipes-How-to-Make-Kimchi-Fried-Rice.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 68) {


                        } else if (food_male_plan_10_food.fff == 69) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/90-Second-Parmesan-Celery-Salad.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 70) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/The-Ultimate-Vegetable-Lasagne-The-Happy-Pear-in-2k.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 71) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Creamy-Butternut-Squash-Soup-recipe.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 72) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Pea-Mint-amp-Coconut-Soup-Green-Kitchen-Stories.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 73) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/How-To-Make-Garlic-Sauteed-String-Bean.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 74) {


                        } else if (food_male_plan_10_food.fff == 75) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Florentine-Pizza.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 76) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Double-Cheeseburger-as-made-by-Erik-Anderson-.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 77) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/EASY-FISH-STEW-RECIPE-.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 78) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Spaghetti-4-Ways.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 79) {


                        } else if (food_male_plan_10_food.fff == 80) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/Spaghetti-4-Ways.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 81) {


                        } else if (food_male_plan_10_food.fff == 82) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/8/furystudio_1/No-Mayo-Avocado-Egg-Salad.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 83) {


                        } else if (food_male_plan_10_food.fff == 84) {


                        } else if (food_male_plan_10_food.fff == 102) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Famous-Olivier-Salad-Stolichny-Salad-Russian-Christmas-Dinner-Christmas-amp-New-Year-Recipes.mp4"), "video/*");
                            context.startActivity(tostart);

                        } else if (food_male_plan_10_food.fff == 104) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Famous-Olivier-Salad-Stolichny-Salad-Russian-Christmas-Dinner-Christmas-amp-New-Year-Recipes.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 106) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Famous-Olivier-Salad-Stolichny-Salad-Russian-Christmas-Dinner-Christmas-amp-New-Year-Recipes.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 108) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 110) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 112) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 113) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 114) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/10-lbs-in-1-week-Cabbage-Soup-Diet-Recipe-AKA-Wonder-Soup.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 115) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 116) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/10-lbs-in-1-week-Cabbage-Soup-Diet-Recipe-AKA-Wonder-Soup.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 117) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 118) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/10-lbs-in-1-week-Cabbage-Soup-Diet-Recipe-AKA-Wonder-Soup.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 120) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Low-fat-salad-dressing-The-Vegan-Corner.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 122) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Low-fat-salad-dressing-The-Vegan-Corner.mp4"), "video/*");
                            context.startActivity(tostart);
                        } else if (food_male_plan_10_food.fff == 124) {

                            context = view.getContext();
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("http://vip.opload.ir/vipdl/95/10/furystudio_1/Low-fat-salad-dressing-The-Vegan-Corner.mp4"), "video/*");
                            context.startActivity(tostart);
                        }

                        FirebaseCrash.log("log 5");

                    }
                });

                im_download_video_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (food_male_plan_10_food.fff == 1) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/polenta.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 1.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 2) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/mexican-pizza.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 2.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 3) {


                        } else if (food_male_plan_10_food.fff == 4) {


                        } else if (food_male_plan_10_food.fff == 5) {


                        } else if (food_male_plan_10_food.fff == 6) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/tofu.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 6.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 7) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/spicy-sausage.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 7.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 8) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/green-peans-and-carrots-reccipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 8.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 9) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Quick-Piri-Piri-BBQ-Chicken-for-Labor-Day-Weekend-.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 9.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 10) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Stuffed-Chicken-Parmesan.m4v", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 10.m4v")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 11) {


                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/7/furystudio_1/Easy-Butter-Chicken.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 11.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();


                        } else if (food_male_plan_10_food.fff == 12) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Chicken-Kiev-with-Rutabaga-Chilli-Mash-recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 12.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 13) {


                        } else if (food_male_plan_10_food.fff == 14) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Curry-Recipes-How-to-Make-Chicken-Tikka-Masala.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 14.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 15) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Green-Falafel-Quick-Easy-Vegan-.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 15.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 16) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Ratatouille-Boats.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 16.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 17) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Mississippi-Roast.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 17.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 18) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Mixed-Vegetable-Fried-rice-easy-amp-quick-recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 18.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 19) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/NYC-Sushi-Burrito.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 19.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 20) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Homemade-Ricotta-Ravioli.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 20.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 21) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Stuffed-Chicken-Nuggets.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 21.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 22) {


                        } else if (food_male_plan_10_food.fff == 23) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/How-to-Make-Schnitzel.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 23.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 24) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Stuffed-Steak-Rolls.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 24.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 25) {


                        } else if (food_male_plan_10_food.fff == 26) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Fail-Safe-Roast-Turkey-Jamie-Oliver.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 26.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 27) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Sliders-4-Ways.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 27.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 28) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Cheddar-Parmesan-Cauliflower-Bites.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 28.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 29) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Healthy-Blueberry-Muffin-Recipe-How-To-Make-Low-Fat-Low-Calorie-Blueberry-Muffins.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 29.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 30) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Gorgeous-Griddled-Chicken-with-Donal-Skehan.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 30.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 31) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Chorizo-Pilaf-One-Pot-Chef.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 31.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 32) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Sweet-amp-Spicy-Chicken.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 32.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 33) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Prawn-and-Pork-Ribs-Noodle-Soup.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 33.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 34) {


                        } else if (food_male_plan_10_food.fff == 35) {


                        } else if (food_male_plan_10_food.fff == 36) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/How-to-Make-Simple-Vegetable-Lasagna-MyRecipes.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 36.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 37) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Parmesan-Garlic-Roasted-Green-Beans-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 37.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 38) {


                        } else if (food_male_plan_10_food.fff == 39) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Gazpacho-Recipe-Cold-Tomato-Cucumber-Pepper-Soup.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 39.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 40) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Coconut-Carrot-and-Chickpea-Soup-Special-Diet-Recipes-l-Whole-Foods-Market.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 40.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 41) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Zereshk-Polo-ba-morgh-Barberry-Rice-Saffron-Chicken-.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 41.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 42) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Pea-and-Bean-Salad-with-Soft-Boiled-Eggs-Waitrose.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 42.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 43) {


                        } else if (food_male_plan_10_food.fff == 44) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Chicken-Pot-Pie-As-Made-By-Wolfgang-Puck-.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 44.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 45) {


                        } else if (food_male_plan_10_food.fff == 46) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Healthy-Muesli-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 46.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 47) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Baked-Eggs-Benedict-Cups.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 47.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 48) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Paul-s-delicious-malt-loaf-Paul-Hollywood-s-Bread-BBC-Food.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 48.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 49) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Roasted-Chicken-with-an-Easy-Ratatouille-Recipe-From-the-Test-Kitchen.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 49.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 50) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Chicken-Stew.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 50.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 51) {


                        } else if (food_male_plan_10_food.fff == 51) {


                        } else if (food_male_plan_10_food.fff == 52) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/How-to-Make-Bulgur-Salad-Recipe-in-description.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 52.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 53) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Sprouted-Lentil-Salad-in-Green-Goddess-Tahini-Dressing.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 53.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 54) {


                        } else if (food_male_plan_10_food.fff == 55) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/How-To-Make-Beef-amp-Broccoli-Noodles-Delish.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 55.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 56) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Harissa-Chicken-Rule-of-Yum-recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 56.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 57) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/One-Pan-Basil-Halloumi-Chicken.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 57.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 58) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Quick-Tomato-Pizza-Tomato-cheese-pizza-Recipe-Cheese-And-Tomato-Pizza-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 58.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 59) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/sweet-corn-soup-recipe-sweet-corn-and-vegetable-soup-recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 59.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 60) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Tuna-Pesto-amp-Rice-Salad.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 60.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 61) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Rice-Cooker-Cinnamon-Pancakes.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 61.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 62) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Hans-Oliving-Frittata-with-ham-spinach-parmesan-feta-and-a-potato-base.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 62.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 63) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Oriental-Beef-Salad-Food-Busker.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 63.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 64) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Pasta-Salad-4-Ways.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 64.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 65) {


                        } else if (food_male_plan_10_food.fff == 66) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Skillet-Lasagna.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 66.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 67) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Rice-Recipes-How-to-Make-Kimchi-Fried-Rice.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 67.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 68) {


                        } else if (food_male_plan_10_food.fff == 69) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/90-Second-Parmesan-Celery-Salad.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 69.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 70) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/The-Ultimate-Vegetable-Lasagne-The-Happy-Pear-in-2k.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 70.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 71) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Creamy-Butternut-Squash-Soup-recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 71.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 72) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Pea-Mint-amp-Coconut-Soup-Green-Kitchen-Stories.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 72.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 73) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/How-To-Make-Garlic-Sauteed-String-Bean.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 73.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 74) {


                        } else if (food_male_plan_10_food.fff == 75) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Florentine-Pizza.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 75.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 76) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Double-Cheeseburger-as-made-by-Erik-Anderson-.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 76.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 77) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/EASY-FISH-STEW-RECIPE-.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 77.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 78) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Spaghetti-4-Ways.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 78.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 79) {


                        } else if (food_male_plan_10_food.fff == 80) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/Spaghetti-4-Ways.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 80.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 81) {


                        } else if (food_male_plan_10_food.fff == 82) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/8/furystudio_1/No-Mayo-Avocado-Egg-Salad.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("video food 82.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 83) {


                        } else if (food_male_plan_10_food.fff == 84) {


                        } else if (food_male_plan_10_food.fff == 102) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Famous-Olivier-Salad-Stolichny-Salad-Russian-Christmas-Dinner-Christmas-amp-New-Year-Recipes.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 102.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 104) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Famous-Olivier-Salad-Stolichny-Salad-Russian-Christmas-Dinner-Christmas-amp-New-Year-Recipes.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 104.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 106) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Famous-Olivier-Salad-Stolichny-Salad-Russian-Christmas-Dinner-Christmas-amp-New-Year-Recipes.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 106.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 108) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 108.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 110) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 110.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 112) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 112.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 113) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 113.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 114) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/10-lbs-in-1-week-Cabbage-Soup-Diet-Recipe-AKA-Wonder-Soup.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 114.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 115) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 115.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 116) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/10-lbs-in-1-week-Cabbage-Soup-Diet-Recipe-AKA-Wonder-Soup.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 116.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 117) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Vegetable-Bread-Pizza-Quick-Recipe.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 117.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 118) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/10-lbs-in-1-week-Cabbage-Soup-Diet-Recipe-AKA-Wonder-Soup.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 118.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 120) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Low-fat-salad-dressing-The-Vegan-Corner.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 119.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 122) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Low-fat-salad-dressing-The-Vegan-Corner.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 121.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        } else if (food_male_plan_10_food.fff == 124) {

                            context = view.getContext();
                            new DownloadManagerHelper(food_male_plan_10_food.context, "http://vip.opload.ir/vipdl/95/10/furystudio_1/Low-fat-salad-dressing-The-Vegan-Corner.mp4", Environment.DIRECTORY_DOWNLOADS)
                                    .showNotificationProgress()
                                    .setDownloadFileName("new video food 123.mp4")
                                    .setRequestType("movie/MP4")
                                    .setNotificationTitle("Download Video food")
                                    .setNotificationDescription("DOWNLOADING ...")
                                    .setDownloadCompleteListener(new DownloadManagerHelper.DownloadCompleteListener() {
                                        @Override
                                        public void onDownloadComplete() {
                                            Toast.makeText(context, food_male_plan_10_food.download_video_2, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(context, food_male_plan_10_food.download_video_3, Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setDownloadProgressListener(new DownloadManagerHelper.DownloadProgressListener() {
                                        @Override
                                        public void onDownloadProgressListener(int percent) {
                                            Log.i("LOG", "Percent is : " + percent);
                                        }
                                    })
                                    .startDownload();

                            Toast.makeText(context, food_male_plan_10_food.download_video_1, Toast.LENGTH_SHORT).show();

                        }

                        FirebaseCrash.log("log 5");

                    }
                });

                FirebaseCrash.log("log 6");
                return new RecyclerView.ViewHolder(view) {
                };
            }


        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }


}