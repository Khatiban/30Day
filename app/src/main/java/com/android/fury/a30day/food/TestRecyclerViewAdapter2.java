package com.android.fury.a30day.food;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.fury.a30day.R;
import com.bumptech.glide.Glide;
import com.google.firebase.crash.FirebaseCrash;

import java.util.List;

/**
 * Created by fury on 9/10/2016.
 */
public class TestRecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    CardView cardView, cardView2;

    TextView txt_food_food_name_1, txt_food_food_conteri_1, txt_food_food_how_1, txt_food_food_time_1, txt_food_food_wwww_1, txt_food_food_name_2, txt_food_food_conteri_2, txt_food_food_how_2, txt_food_food_time_2, txt_food_food_wwww_2;

    ImageView im_2_1_food_te_1, im_2_1_food_te_22;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL2 = 1;
    static final int TYPE_CELL3 = 3;
    static final int TYPE_CELL4 = 4;
    static final int TYPE_CELL5 = 5;
    static final int TYPE_CELL6 = 6;
    static final int TYPE_CELL7 = 7;
    static final int TYPE_CELL8 = 8;
    static final int TYPE_CELL9 = 9;
    static final int TYPE_CELL10 = 10;
    static final int TYPE_CELL11 = 11;
    static final int TYPE_CELL12 = 12;
    static final int TYPE_CELL13 = 13;
    static final int TYPE_CELL14 = 14;
    static final int TYPE_CELL15 = 15;
    static final int TYPE_CELL16 = 16;
    static final int TYPE_CELL17 = 17;
    static final int TYPE_CELL18 = 18;


    private Context context;

    Intent food_1;

    public
    TestRecyclerViewAdapter2(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 1:
                return TYPE_HEADER;
            case 0:
                return TYPE_CELL15;
            case 14:
                return TYPE_CELL2;
            case 2:
                return TYPE_CELL16;
            case 15:
                return TYPE_CELL3;
            case 3:
                return TYPE_CELL4;
            case 4:
                return TYPE_CELL17;
            case 16:
                return TYPE_CELL5;
            case 5:
                return TYPE_CELL6;
            case 6:
                return TYPE_CELL18;
            case 17:
                return TYPE_CELL7;
            case 7:
                return TYPE_CELL8;
            case 8:
                return TYPE_CELL9;
            case 9:
                return TYPE_CELL10;
            case 10:
                return TYPE_CELL11;
            case 11:
                return TYPE_CELL12;
            case 12:
                return TYPE_CELL13;
            case 13:
                return TYPE_CELL14;
            default:
                return TYPE_CELL2;
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
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_29);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_29);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_30);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267766000/chocolate_chip_banana_bran_muffins_1086_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267993642/recipe_image_legacy_id_1201615_11_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 29);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 30);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_57);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_58);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268274242/chicken_soup_2400_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268275526/bocconcini_and_tomato_glutenfree_pizza_31733_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 57);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 58);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_1);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_2);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_2);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);


                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267577726/p_RU219045.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267623568/p_R151419.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 1);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 2);
                            context.startActivity(food_1);


                        }
                    });


                }


                FirebaseCrash.log("log 1");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL2: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_31);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_32);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267993868/recipe_image_legacy_id_981494_10.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267994250/spicychickenavocadowraps_5865.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 31);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 32);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_59);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_60);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_19);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268277242/vegetable_frittata_19011_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268277792/tuna_rice_salad_11440_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 59);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 60);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_3);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_2);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_4);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_3);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267626968/p_RU28541.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267625750/p_R132871.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 3);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 4);
                            context.startActivity(food_1);


                        }
                    });


                }


                FirebaseCrash.log("log 2");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL3: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);


                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_33);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_19);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_34);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267994368/recipe_image_legacy_id_1047459_10.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267994618/potato_salad_anchovy_quails_eggs.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 33);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 34);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_61);
                    txt_food_food_conteri_1.setText("");
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText("");

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_62);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText("");
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268279500/rice_cakes_1350_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268280184/spinach_and_ham_frittata_16037_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 61);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 62);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_5);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_5);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_6);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267630100/p_R151409.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267632076/R089890_jpg_rendition_largest.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 5);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 6);
                            context.startActivity(food_1);


                        }
                    });


                }


                FirebaseCrash.log("log 3");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL4: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);


                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_35);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_36);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267994784/recipe_image_legacy_id_1074500_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267994926/recipe_image_legacy_id_1273596_8.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 35);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 36);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_63);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_63);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_64);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268281384/thai_beef_salad_wrap_15356_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268283284/pasta_salad_with_lentils_pesto_beans_29097_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 63);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 64);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_7);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_8);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_8);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_8);


                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267634292/R155075_jpg_rendition_largest.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267634418/R135678_jpg_rendition_largest.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 7);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 8);
                            context.startActivity(food_1);


                        }
                    });


                }


                FirebaseCrash.log("log 4");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL5: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);


                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_37);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_37);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_38);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_9);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267995084/recipe_image_legacy_id_10733_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267995234/recipe_image_legacy_id_1259671_8.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 37);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 38);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_65);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText("");
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_66);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268308300/baked_ling_with_tomatoes_thyme_and_olives_6119_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268309592/freeform_kale_ricotta_and_pesto_lasagne_32279_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 65);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 66);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_9);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_9);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_10);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_10);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);


                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267694668/PiriPiriChickenwtihSlaw_WebReady.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267698684/chicken_parmigiana_WebReady.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);


                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 9);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 10);
                            context.startActivity(food_1);


                        }
                    });


                }


                FirebaseCrash.log("log 5");

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL6: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_39);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_40);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268204976/recipe_image_legacy_id_7360_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268206700/recipe_image_legacy_id_338571_12.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 39);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 40);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_67);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_18);
                    txt_food_food_how_1.setText("");
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_68);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_19);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268310218/kimchi_fried_rice_with_bacon_and_eggs_32154_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268311884/asianstyle_fish_and_sesamesalt_chips_23672_l.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 67);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 68);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_11);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_11);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_11);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_12);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_12);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_12);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267699400/Butter_Chicken_with_Naan_2_WebReady.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267704392/Kickin_Chicken_Kiev_001_1_.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);


                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 11);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 12);
                            context.startActivity(food_1);


                        }
                    });


                }


                FirebaseCrash.log("log 6");


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL7: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);


                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_41);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_41);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_42);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText("");
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268209334/recipe_image_legacy_id_954452_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220126/recipe_image_legacy_id_693594_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 41);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 42);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_69);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_70);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_41);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_37);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268321100/1092820.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268325542/3856414.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 69);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 70);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_13);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_13);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_14);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_11);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_14);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_3);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267707750/4b8a8fcf_ce12_4d23_aa73_2fb75048f73b_Chicken_Burgers_with_Coleslaw_Russia_WebReady_1_.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267710026/Chicken_Tikka_Masala_ep_2_WebReady_1_.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 13);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 14);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL8: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);


                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_43);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_43);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_19);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_44);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_43);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220268/recipe_image_legacy_id_776558_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268220292/recipe_image_legacy_id_1035696_10.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 43);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 44);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_71);
                    txt_food_food_conteri_1.setText("");
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_72);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268327192/butternut_soup_with_crispy_sage_apple_croutons.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268329550/recipe_image_legacy_id_491536_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 71);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 72);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_15);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_15);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_16);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_16);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267720542/falafel_with_chipotle_tahini_dip_WebReady_1_.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267746042/Quick_Ratatouille_jpg_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 15);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 16);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL9: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_45);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_45);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_46);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_46);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268220318/recipe_image_legacy_id_684574_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220376/recipe_image_legacy_id_281726_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 45);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 46);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_73);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_74);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268336992/recipe_image_legacy_id_1915_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268337126/spaghetti_smoky_tomato_seafood_sauce.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 73);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 74);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_17);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_16);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_17);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_11);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_18);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_18);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_14);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267750676/CitrusRoastBeef.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267751792/Pork_Fried_Rice_17201.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 17);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 18);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL10: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_47);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_43);
                    txt_food_food_how_1.setText("");
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_48);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220392/recipe_image_legacy_id_1201548_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220418/recipe_image_legacy_id_967471_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 47);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 48);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_75);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_76);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_10);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268337168/eggs_florentine_pizza.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268337250/recipe_image_legacy_id_659514_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 75);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 76);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_19);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_19);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_19);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_20);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_14);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267758700/9_Presentaci%C3%B3n_sushi_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267759968/sr_fresh_beef_rav_1_.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 19);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 20);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL11: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_49);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_50);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_2);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220468/recipe_image_legacy_id_52118_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268220476/recipe_image_legacy_id_1068489_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 49);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 50);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_77);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_19);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_5);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_78);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_2.setText("");
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_46);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268337334/fish_stew_roast_garlic_saffron.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268339368/spaghetti_squash_casserole_44.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 77);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 78);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_21);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_22);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267761700/chickennuggets_wide_290cf617c0504d91611478afd36223ca5ebbdffe_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267762692/tuna_avocado_sandwich_horiz_800_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 21);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 22);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL12: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_51);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_52);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_1);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268220492/recipe_image_legacy_id_1176498_10.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220526/crunchy_bulghar_salad.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 51);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 52);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_79);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText("");
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_80);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText("");
                    txt_food_food_time_2.setText("");
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268341292/favorite_frittata_22.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268341534/squash_11_700x1045.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 79);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 80);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_23);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_24);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_14);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267763184/pork_schnitzel_with_sweet_potato_chips_1456_l_1_.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267763918/Anova_9_24_14_13_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 23);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 24);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL13: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_53);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_54);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText("");
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220592/veggie_tahini_lentils.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220600/halloumi_with_lemony_lentil_salad.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 53);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 54);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_81);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_1.setText("");
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_82);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText("");
                    txt_food_food_time_2.setText("");
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8268341850/caprese_quinoa_casserole_3.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268342068/22_1_700x1045.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 81);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 82);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_25);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_9);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_26);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_26);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_5);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_3);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267764926/4a4d1de7666835f233b9098a0cf389ca_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s9.picofile.com/file/8267765118/4159_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 25);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 26);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL14: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_55);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_7);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_4);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_1);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_56);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_9);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_10);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220634/recipe_image_legacy_id_5283_11.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268220692/harissa_chicken_traybake.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 55);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 56);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_83);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_18);
                    txt_food_food_time_1.setText("");
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_3);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_84);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_1);
                    txt_food_food_how_2.setText("");
                    txt_food_food_time_2.setText("");
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268342176/1_7_700x1045.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8268342242/18.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 83);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 84);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.food_male_plan_10_food_name_27);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_5);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.food_male_plan_10_food_time_16);
                    txt_food_food_wwww_1.setText(R.string.food_male_plan_10_food_nafr_16);

                    txt_food_food_name_2.setText(R.string.food_male_plan_10_food_name_28);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_6);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.food_male_plan_10_food_time_3);
                    txt_food_food_wwww_2.setText(R.string.food_male_plan_10_food_nafr_16);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267765550/hamburguesas_taberna_la_tata_sevilla_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s8.picofile.com/file/8267765642/deep_fried_cauliflower_1_21_1_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 27);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 28);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL15: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.meal_plan_31_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_31_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_31_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_32_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_32_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_32_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s7.picofile.com/file/8284800192/meatballs.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s7.picofile.com/file/8284800250/1648065.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 101);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 102);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.meal_plan_31_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_31_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_31_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_32_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_32_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_32_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s7.picofile.com/file/8284812784/Chicken_Meatballs_Feature_680x340.jpeg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s1.picofile.com/file/8284812342/Chicken_Olivye_10_187x187.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 103);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 104);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.meal_plan_31_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_31_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_31_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_32_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_32_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_32_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s1.picofile.com/file/8284812818/Glazed_Meatballs_Diethood.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s4.picofile.com/file/8284812400/Screen_Shot_2013_12_10_at_12_41_37_PM.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 105);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 106);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_CELL16: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.meal_plan_33_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_34_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_34_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_34_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_34_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_34_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s3.picofile.com/file/8284814768/veg_cutlet_recipe.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s1.picofile.com/file/8284815334/f66f61b8_60d8_4f6a_8608_ffe98b64e014.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 107);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 108);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.meal_plan_33_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_34_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_34_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_34_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_34_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_34_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s5.picofile.com/file/8284814818/14663694193_e7abc3eda9_o.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s4.picofile.com/file/8284815368/p_RU189256.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 109);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 110);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.meal_plan_33_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_34_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_34_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_34_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_34_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_34_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s6.picofile.com/file/8284814884/dude_diet_chicken_cutlets_and_zucchini_pasta_with_cherry_tomatoes_4.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s7.picofile.com/file/8284815418/Roasted_Vegetable_Pizza.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 111);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 112);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }


            case TYPE_CELL17: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.meal_plan_35_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_35_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_35_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_36_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_36_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_36_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s6.picofile.com/file/8284860226/veggie_pizza.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s5.picofile.com/file/8284860000/hearty_winter_vegetable_soup_3.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 113);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 114);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.meal_plan_35_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_35_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_35_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_36_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_36_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_36_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s1.picofile.com/file/8284860218/vegan_pizza_vegetable.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s2.picofile.com/file/8284860034/Tuscan_Vegetable_Sausage_Soup_1411135505.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 115);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 116);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.meal_plan_35_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_35_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_35_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_36_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_36_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_36_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s5.picofile.com/file/8284860200/Homemade_Roasted_Vegetable_Pizza.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s1.picofile.com/file/8284860042/vegetable_soup3_edit_srgb_.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 117);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 118);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_CELL18: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2_1, parent, false);

                cardView = (CardView) view.findViewById(R.id.card_view2_1);
                cardView2 = (CardView) view.findViewById(R.id.card_view2_2);
                txt_food_food_name_1 = (TextView) view.findViewById(R.id.txt_food_food_name_1);
                txt_food_food_name_2 = (TextView) view.findViewById(R.id.txt_food_food_name_2);
                txt_food_food_conteri_1 = (TextView) view.findViewById(R.id.txt_food_food_conteri_1);
                txt_food_food_conteri_2 = (TextView) view.findViewById(R.id.txt_food_food_conteri_2);
                txt_food_food_how_1 = (TextView) view.findViewById(R.id.txt_food_food_how_1);
                txt_food_food_how_2 = (TextView) view.findViewById(R.id.txt_food_food_how_2);
                txt_food_food_time_1 = (TextView) view.findViewById(R.id.txt_food_food_time_1);
                txt_food_food_time_2 = (TextView) view.findViewById(R.id.txt_food_food_time_2);
                txt_food_food_wwww_1 = (TextView) view.findViewById(R.id.txt_food_food_wwww_1);
                txt_food_food_wwww_2 = (TextView) view.findViewById(R.id.txt_food_food_wwww_2);
                im_2_1_food_te_1 = (ImageView) view.findViewById(R.id.im_2_1_food_te_1);
                im_2_1_food_te_22 = (ImageView) view.findViewById(R.id.im_2_1_food_te_2);

                if (food_male_plan_10.mp_what == 2) {


                    txt_food_food_name_1.setText(R.string.meal_plan_37_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_37_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_37_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_38_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_43);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_38_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_38_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s3.picofile.com/file/8284862776/Beets_Roasted.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s6.picofile.com/file/8284862868/2.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 119);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 120);
                            context.startActivity(food_1);


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    txt_food_food_name_1.setText(R.string.meal_plan_37_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_37_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_37_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_38_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_43);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_38_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_38_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s5.picofile.com/file/8284862784/BX0504H_roasted_beets_s4x3.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s5.picofile.com/file/8284862876/H2_Healthy_Kale_Salad_1.png")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 121);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 122);
                            context.startActivity(food_1);


                        }
                    });


                } else {


                    txt_food_food_name_1.setText(R.string.meal_plan_37_1);
                    txt_food_food_conteri_1.setText(R.string.food_male_plan_10_food_cont_4);
                    txt_food_food_how_1.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_1.setText(R.string.meal_plan_37_time);
                    txt_food_food_wwww_1.setText(R.string.meal_plan_37_tedad);

                    txt_food_food_name_2.setText(R.string.meal_plan_38_1);
                    txt_food_food_conteri_2.setText(R.string.food_male_plan_10_food_cont_43);
                    txt_food_food_how_2.setText(R.string.food_male_plan_10_food_noe_2);
                    txt_food_food_time_2.setText(R.string.meal_plan_38_time);
                    txt_food_food_wwww_2.setText(R.string.meal_plan_38_tedad);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s2.picofile.com/file/8284862792/roasted_beets_balsamic_glaze_vertical_a_2000.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_1);

                    Glide.with(food_male_plan_10.context)
                            .load("http://s6.picofile.com/file/8284862868/2.jpg")
                            .placeholder(R.drawable.hide_food_food1)
                            .crossFade()
                            .thumbnail(0.25f)
                            .into(im_2_1_food_te_22);

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 123);
                            context.startActivity(food_1);

                        }
                    });


                    cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (food_male_plan_10.vibre_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.vb2.cancel();
                            } else {
                                food_male_plan_10.vb2.vibrate(100);
                            }


                            if (food_male_plan_10.music_check == food_male_plan_10.music_off_check) {
                                food_male_plan_10.click2.stop();
                            } else {
                                food_male_plan_10.click2.start();
                            }

                            context = view.getContext();
                            food_1 = new Intent(context, food_male_plan_10_food.class);
                            food_1.putExtra("food_number_1", 124);
                            context.startActivity(food_1);


                        }
                    });


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }


        }
        return null;
    }


    private class GetData extends AsyncTask<String, String, String> {


        public ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            try {
                pDialog = new ProgressDialog(context);
                pDialog.setMessage("لطفا کمی صبر کنید ...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        protected String doInBackground(String... strings) {



            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            pDialog.dismiss();

        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL14:
                break;
        }
    }
}