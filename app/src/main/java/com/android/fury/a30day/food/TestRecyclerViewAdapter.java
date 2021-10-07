package com.android.fury.a30day.food;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by fury on 9/10/2016.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Double sei;

    List<Object> contents;

    private Context context;

    double S0;

    EditText co_food_1;

    TextView txt_food_m_p_co_1, txt_food_m_p_co_2;

    CardView card_view2, card_view4;

    String end_co;

    static final int TYPE_HEADER = 1;
    static final int TYPE_CELL2 = 0;
    static final int TYPE_CELL = 4;
    static final int TYPE_CELL6 = 2;
    static final int TYPE_CELL3 = 3;

    public TestRecyclerViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 1:
                return TYPE_HEADER;
            case 0:
                return TYPE_CELL2;
            case 2:
                return TYPE_CELL6;
            case 3:
                return TYPE_CELL3;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        View view2 = null;
        View view3 = null;
        View view4 = null;
        View view5 = null;
        View view6 = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_1, parent, false);


                Button card_view_meal_1 = (Button) view.findViewById(R.id.btn_start_meal_day_1);
                Button card_view_meal_2 = (Button) view.findViewById(R.id.btn_start_meal_day_2);
                Button card_view_meal_3 = (Button) view.findViewById(R.id.btn_start_meal_day_3);
                Button card_view_meal_4 = (Button) view.findViewById(R.id.btn_start_meal_day_4);
                Button card_view_meal_5 = (Button) view.findViewById(R.id.btn_start_meal_day_5);
                Button card_view_meal_6 = (Button) view.findViewById(R.id.btn_start_meal_day_6);
                Button card_view_meal_7 = (Button) view.findViewById(R.id.btn_start_meal_day_7);
                Button card_view_meal_8 = (Button) view.findViewById(R.id.btn_start_meal_day_8);
                Button card_view_meal_9 = (Button) view.findViewById(R.id.btn_start_meal_day_9);
                Button card_view_meal_10 = (Button) view.findViewById(R.id.btn_start_meal_day_10);
                Button img_meal_1 = (Button) view.findViewById(R.id.img_meal_1);
                Button img_meal_2 = (Button) view.findViewById(R.id.img_meal_2);
                Button img_meal_3 = (Button) view.findViewById(R.id.img_meal_3);
                Button img_meal_4 = (Button) view.findViewById(R.id.img_meal_4);
                Button img_meal_5 = (Button) view.findViewById(R.id.img_meal_5);
                Button img_meal_6 = (Button) view.findViewById(R.id.img_meal_6);
                Button img_meal_7 = (Button) view.findViewById(R.id.img_meal_7);
                Button img_meal_8 = (Button) view.findViewById(R.id.img_meal_8);
                Button img_meal_9 = (Button) view.findViewById(R.id.img_meal_9);
                Button img_meal_10 = (Button) view.findViewById(R.id.img_meal_10);
                TextView hide25 = (TextView) view.findViewById(R.id.txt_male_plan_10_23);

                context = view.getContext();
                hide25.setText(food_male_plan_10.colory_low_5);


                if (food_male_plan_10.mp_what == 2) {

                    if (food_male_plan_10.im_chengh_11 != 1) {

                        img_meal_1.setText("");
                        img_meal_1.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_12 != 1) {

                        img_meal_2.setText("");
                        img_meal_2.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_13 != 1) {

                        img_meal_3.setText("");
                        img_meal_3.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_14 != 1) {

                        img_meal_4.setText("");
                        img_meal_4.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_15 != 1) {

                        img_meal_5.setText("");
                        img_meal_5.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_16 != 1) {

                        img_meal_6.setText("");
                        img_meal_6.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_17 != 1) {

                        img_meal_7.setText("");
                        img_meal_7.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_18 != 1) {

                        img_meal_8.setText("");
                        img_meal_8.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_19 != 1) {

                        img_meal_9.setText("");
                        img_meal_9.setBackgroundResource(R.drawable.day_pass);
                    }

                    if (food_male_plan_10.im_chengh_20 != 1) {

                        img_meal_10.setText("");
                        img_meal_10.setBackgroundResource(R.drawable.day_pass);
                    }


                    card_view_meal_1.setOnClickListener(new View.OnClickListener() {
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

                            try {

                                Intent p_1 = new Intent(context, Meal_plan.class);
                                p_1.putExtra("nov_meal", 11);
                                context.startActivity(p_1);

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("1"));
                            }


                        }
                    });


                    card_view_meal_2.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {
                                    Intent p_1 = new Intent(context, Meal_plan.class);
                                    p_1.putExtra("nov_meal", 12);
                                    context.startActivity(p_1);
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("2"));
                                }

                            }

                        }
                    });


                    card_view_meal_3.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {
                                    Intent p_2 = new Intent(context, Meal_plan.class);
                                    p_2.putExtra("nov_meal", 13);
                                    context.startActivity(p_2);
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("3"));
                                }

                            }


                        }
                    });


                    card_view_meal_4.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {


                                try {
                                    Intent p_3 = new Intent(context, Meal_plan.class);
                                    p_3.putExtra("nov_meal", 14);
                                    context.startActivity(p_3);
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("4"));
                                }

                            }

                        }
                    });


                    card_view_meal_5.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_4 = new Intent(context, Meal_plan.class);
                                    p_4.putExtra("nov_meal", 15);
                                    context.startActivity(p_4);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("5"));
                                }

                            }


                        }
                    });


                    card_view_meal_6.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_6 = new Intent(context, Meal_plan.class);
                                    p_6.putExtra("nov_meal", 16);
                                    context.startActivity(p_6);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("6"));
                                }

                            }


                        }
                    });


                    card_view_meal_7.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_7 = new Intent(context, Meal_plan.class);
                                    p_7.putExtra("nov_meal", 17);
                                    context.startActivity(p_7);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("7"));
                                }

                            }


                        }
                    });


                    card_view_meal_8.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_8 = new Intent(context, Meal_plan.class);
                                    p_8.putExtra("nov_meal", 18);
                                    context.startActivity(p_8);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("8"));
                                }

                            }


                        }
                    });


                    card_view_meal_9.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_9 = new Intent(context, Meal_plan.class);
                                    p_9.putExtra("nov_meal", 19);
                                    context.startActivity(p_9);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("9"));
                                }

                            }


                        }
                    });


                    card_view_meal_10.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_10 = new Intent(context, Meal_plan.class);
                                    p_10.putExtra("nov_meal", 20);
                                    context.startActivity(p_10);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("10"));
                                }

                            }


                        }
                    });


                } else if (food_male_plan_10.mp_what == 3) {


                    if (food_male_plan_10.im_chengh_21 != 1) {

                        img_meal_1.setText("");
                        img_meal_1.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_22 != 1) {

                        img_meal_2.setText("");
                        img_meal_2.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_23 != 1) {

                        img_meal_3.setText("");
                        img_meal_3.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_24 != 1) {

                        img_meal_4.setText("");
                        img_meal_4.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_25 != 1) {

                        img_meal_5.setText("");
                        img_meal_5.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_26 != 1) {

                        img_meal_6.setText("");
                        img_meal_6.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_27 != 1) {

                        img_meal_7.setText("");
                        img_meal_7.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_28 != 1) {

                        img_meal_8.setText("");
                        img_meal_8.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_29 != 1) {

                        img_meal_9.setText("");
                        img_meal_9.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_30 != 1) {

                        img_meal_10.setText("");
                        img_meal_10.setBackgroundResource(R.drawable.day_pass);

                    }


                    card_view_meal_1.setOnClickListener(new View.OnClickListener() {
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

                            try {

                                Intent p_1 = new Intent(context, Meal_plan.class);
                                p_1.putExtra("nov_meal", 21);
                                context.startActivity(p_1);

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("11"));
                            }


                        }
                    });


                    card_view_meal_2.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_1 = new Intent(context, Meal_plan.class);
                                    p_1.putExtra("nov_meal", 22);
                                    context.startActivity(p_1);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("12"));
                                }

                            }


                        }
                    });


                    card_view_meal_3.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_2 = new Intent(context, Meal_plan.class);
                                    p_2.putExtra("nov_meal", 23);
                                    context.startActivity(p_2);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("13"));
                                }

                            }


                        }
                    });


                    card_view_meal_4.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_3 = new Intent(context, Meal_plan.class);
                                    p_3.putExtra("nov_meal", 24);
                                    context.startActivity(p_3);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("14"));
                                }

                            }


                        }
                    });


                    card_view_meal_5.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_4 = new Intent(context, Meal_plan.class);
                                    p_4.putExtra("nov_meal", 25);
                                    context.startActivity(p_4);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("15"));
                                }

                            }


                        }
                    });


                    card_view_meal_6.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_6 = new Intent(context, Meal_plan.class);
                                    p_6.putExtra("nov_meal", 26);
                                    context.startActivity(p_6);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("16"));
                                }

                            }


                        }
                    });


                    card_view_meal_7.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_7 = new Intent(context, Meal_plan.class);
                                    p_7.putExtra("nov_meal", 27);
                                    context.startActivity(p_7);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("17"));
                                }

                            }


                        }
                    });


                    card_view_meal_8.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_8 = new Intent(context, Meal_plan.class);
                                    p_8.putExtra("nov_meal", 28);
                                    context.startActivity(p_8);


                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("18"));
                                }

                            }


                        }
                    });


                    card_view_meal_9.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {


                                try {

                                    Intent p_9 = new Intent(context, Meal_plan.class);
                                    p_9.putExtra("nov_meal", 29);
                                    context.startActivity(p_9);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("19"));
                                }

                            }


                        }
                    });


                    card_view_meal_10.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_10 = new Intent(context, Meal_plan.class);
                                    p_10.putExtra("nov_meal", 30);
                                    context.startActivity(p_10);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("20"));
                                }


                            }


                        }
                    });


                } else {


                    if (food_male_plan_10.im_chengh_1 != 1) {

                        img_meal_1.setText("");
                        img_meal_1.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_2 != 1) {

                        img_meal_2.setText("");
                        img_meal_2.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_3 != 1) {

                        img_meal_3.setText("");
                        img_meal_3.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_4 != 1) {

                        img_meal_4.setText("");
                        img_meal_4.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_5 != 1) {

                        img_meal_5.setText("");
                        img_meal_5.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_6 != 1) {

                        img_meal_6.setText("");
                        img_meal_6.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_7 != 1) {

                        img_meal_7.setText("");
                        img_meal_7.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_8 != 1) {

                        img_meal_8.setText("");
                        img_meal_8.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_9 != 1) {

                        img_meal_9.setText("");
                        img_meal_9.setBackgroundResource(R.drawable.day_pass);

                    }

                    if (food_male_plan_10.im_chengh_10 != 1) {

                        img_meal_10.setText("");
                        img_meal_10.setBackgroundResource(R.drawable.day_pass);

                    }


                    card_view_meal_1.setOnClickListener(new View.OnClickListener() {
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

                            try {

                                Intent st = new Intent(context, nov_meal_plan.class);
                                context.startActivity(st);

                            } catch (Exception e) {
                                FirebaseCrash.report(new Exception("21"));
                            }


                        }
                    });


                    card_view_meal_2.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_1 = new Intent(context, Meal_plan.class);
                                    p_1.putExtra("nov_meal", 2);
                                    context.startActivity(p_1);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("22"));
                                }

                            }


                        }
                    });


                    card_view_meal_3.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_2 = new Intent(context, Meal_plan.class);
                                    p_2.putExtra("nov_meal", 3);
                                    context.startActivity(p_2);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("23"));
                                }

                            }


                        }
                    });


                    card_view_meal_4.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_3 = new Intent(context, Meal_plan.class);
                                    p_3.putExtra("nov_meal", 4);
                                    context.startActivity(p_3);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("24"));
                                }

                            }


                        }
                    });


                    card_view_meal_5.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_4 = new Intent(context, Meal_plan.class);
                                    p_4.putExtra("nov_meal", 5);
                                    context.startActivity(p_4);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("25"));
                                }

                            }


                        }
                    });


                    card_view_meal_6.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_6 = new Intent(context, Meal_plan.class);
                                    p_6.putExtra("nov_meal", 6);
                                    context.startActivity(p_6);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("26"));
                                }

                            }


                        }
                    });


                    card_view_meal_7.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_7 = new Intent(context, Meal_plan.class);
                                    p_7.putExtra("nov_meal", 7);
                                    context.startActivity(p_7);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("27"));
                                }

                            }


                        }
                    });


                    card_view_meal_8.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_8 = new Intent(context, Meal_plan.class);
                                    p_8.putExtra("nov_meal", 8);
                                    context.startActivity(p_8);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("28"));
                                }

                            }


                        }
                    });


                    card_view_meal_9.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_9 = new Intent(context, Meal_plan.class);
                                    p_9.putExtra("nov_meal", 9);
                                    context.startActivity(p_9);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("29"));
                                }

                            }


                        }
                    });


                    card_view_meal_10.setOnClickListener(new View.OnClickListener() {
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

                            if (food_male_plan_10.s_5 == 1) {
                                try {
                                    food_male_plan_10.show_dialog();
                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("alert dialog no nov_meal_plan"));
                                }
                            } else {

                                try {

                                    Intent p_10 = new Intent(context, Meal_plan.class);
                                    p_10.putExtra("nov_meal", 10);
                                    context.startActivity(p_10);

                                } catch (Exception e) {
                                    FirebaseCrash.report(new Exception("30"));
                                }

                            }


                        }
                    });


                    FirebaseCrash.log("log 1");


                }


                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL2: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2, parent, false);

                TextView hide1 = (TextView) view.findViewById(R.id.txt_hide_food_m_p_10_1);
                TextView hide2 = (TextView) view.findViewById(R.id.txt_food_m_p_10_2);


                hide1.setText(food_male_plan_10.colory_low);
                hide2.setText(food_male_plan_10.s);

                FirebaseCrash.log("log 2");
                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL6: {
                view5 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_6, parent, false);

                txt_food_m_p_co_1 = (TextView) view5.findViewById(R.id.txt_food_m_p_co_1);
                txt_food_m_p_co_2 = (TextView) view5.findViewById(R.id.txt_food_m_p_co_2);
                co_food_1 = (EditText) view5.findViewById(R.id.co_food_1);


                txt_food_m_p_co_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (co_food_1.getText().length() == 0) {
                            co_food_1.setText("0");
                        }


                        if (co_food_1.getText().length() != 0) {

                            S0 = Double.parseDouble(co_food_1.getText().toString());

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

                            DecimalFormat df = new DecimalFormat("#.##");
                            sei = (S0 * 2.54);
                            sei = Double.valueOf(df.format(sei));
                            end_co = String.valueOf(sei);
                            txt_food_m_p_co_2.setText(end_co);

                        } else {
                            Toast.makeText(context, "please set inches", Toast.LENGTH_LONG);
                        }

                    }
                });
                FirebaseCrash.log("log 3");
                return new RecyclerView.ViewHolder(view5) {
                };

            }
            case TYPE_CELL3: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3, parent, false);

                    card_view4 = (CardView) view.findViewById(R.id.card_view4);

                    card_view4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            context = view.getContext();
                            Intent food_1 = new Intent(context, body_heath.class);
                            food_1.putExtra("gender_food_3", food_male_plan_10.colery_6);
                            food_1.putExtra("tall_food_3", food_male_plan_10.colery_4);
                            food_1.putExtra("weight_food_meghdar_3", food_male_plan_10.colery_5);
                            context.startActivity(food_1);

                        }
                    });


                FirebaseCrash.log("log 4");

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_2, parent, false);

                card_view2 = (CardView) view.findViewById(R.id.card_view2);

                TextView hide1 = (TextView) view.findViewById(R.id.txt_hide_food_m_p_10_1);
                TextView hide2 = (TextView) view.findViewById(R.id.txt_food_m_p_10_2);


                hide1.setText(food_male_plan_10.colory_low_3);
                hide2.setText(food_male_plan_10.food_male_plan_10_35_1);
                FirebaseCrash.log("log 5");
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