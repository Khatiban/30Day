package com.android.fury.a30day.food;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.fury.a30day.R;

import java.util.List;

/**
 * Created by fury on 9/10/2016.
 */
public class TestRecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_HEADER2 = 1;
    static final int TYPE_HEADER3 = 2;
    static final int TYPE_HEADER4 = 3;
    static final int TYPE_HEADER5 = 4;
    static final int TYPE_HEADER6 = 5;
    static final int TYPE_HEADER7 = 6;
    static final int TYPE_HEADER8 = 7;
    static final int TYPE_HEADER9 = 8;
    static final int TYPE_HEADER10 = 9;
    static final int TYPE_HEADER11 = 10;
    static final int TYPE_HEADER12 = 11;
    static final int TYPE_HEADER13 = 12;
    static final int TYPE_HEADER14 = 13;
    static final int TYPE_HEADER15 = 14;
    static final int TYPE_HEADER16 = 15;
    static final int TYPE_HEADER17 = 16;
    static final int TYPE_HEADER18 = 17;
    static final int TYPE_HEADER19 = 18;
    static final int TYPE_HEADER20 = 19;
    static final int TYPE_HEADER21 = 20;
    static final int TYPE_HEADER22 = 21;
    static final int TYPE_HEADER23 = 22;
    static final int TYPE_HEADER24 = 23;
    static final int TYPE_HEADER25 = 24;
    static final int TYPE_HEADER26 = 25;
    static final int TYPE_HEADER27 = 26;
    static final int TYPE_HEADER28 = 27;
    static final int TYPE_HEADER29 = 28;
    static final int TYPE_HEADER30 = 29;
    static final int TYPE_HEADER31 = 30;
    static final int TYPE_HEADER32 = 31;
    static final int TYPE_HEADER33 = 32;
    static final int TYPE_HEADER34 = 33;
    static final int TYPE_HEADER35 = 34;
    static final int TYPE_HEADER36 = 35;
    static final int TYPE_HEADER37 = 36;
    static final int TYPE_HEADER38 = 37;
    static final int TYPE_HEADER39 = 38;
    static final int TYPE_HEADER40 = 39;
    static final int TYPE_HEADER41 = 40;
    static final int TYPE_HEADER42 = 41;
    static final int TYPE_HEADER43 = 42;
    static final int TYPE_HEADER44 = 43;
    static final int TYPE_HEADER45 = 44;
    static final int TYPE_HEADER46 = 45;
    static final int TYPE_HEADER47 = 46;
    static final int TYPE_HEADER48 = 47;
    static final int TYPE_HEADER49 = 48;
    static final int TYPE_HEADER50 = 49;
    static final int TYPE_HEADER51 = 50;
    static final int TYPE_HEADER52 = 51;
    static final int TYPE_HEADER53 = 52;
    static final int TYPE_HEADER54 = 53;
    static final int TYPE_HEADER55 = 54;
    static final int TYPE_HEADER56 = 55;
    static final int TYPE_HEADER57 = 56;
    static final int TYPE_HEADER58 = 57;
    static final int TYPE_HEADER59 = 58;
    static final int TYPE_HEADER60 = 59;
    static final int TYPE_HEADER61 = 60;
    static final int TYPE_HEADER62 = 61;
    static final int TYPE_HEADER63 = 62;
    static final int TYPE_HEADER64 = 63;
    static final int TYPE_HEADER65 = 64;
    static final int TYPE_HEADER66 = 65;
    static final int TYPE_HEADER67 = 66;
    static final int TYPE_HEADER68 = 67;
    static final int TYPE_HEADER69 = 68;
    static final int TYPE_HEADER70 = 69;
    static final int TYPE_HEADER71 = 70;
    static final int TYPE_HEADER72 = 71;
    static final int TYPE_HEADER73 = 72;
    static final int TYPE_HEADER74 = 73;
    static final int TYPE_HEADER75 = 74;
    static final int TYPE_HEADER76 = 75;
    static final int TYPE_HEADER77 = 76;
    static final int TYPE_HEADER78 = 77;
    static final int TYPE_HEADER79 = 78;
    static final int TYPE_HEADER80 = 79;
    static final int TYPE_HEADER81 = 80;
    static final int TYPE_HEADER82 = 81;
    static final int TYPE_HEADER83 = 82;
    static final int TYPE_HEADER84 = 83;
    static final int TYPE_HEADER85 = 84;
    static final int TYPE_HEADER86 = 85;
    static final int TYPE_HEADER87 = 86;
    static final int TYPE_HEADER88 = 87;
    static final int TYPE_HEADER89 = 88;
    static final int TYPE_HEADER90 = 89;
    static final int TYPE_HEADER91 = 90;
    static final int TYPE_HEADER92 = 91;
    static final int TYPE_HEADER93 = 92;
    static final int TYPE_HEADER94 = 93;
    static final int TYPE_HEADER95 = 94;
    static final int TYPE_HEADER96 = 95;
    static final int TYPE_HEADER97 = 96;
    static final int TYPE_HEADER98 = 97;
    static final int TYPE_HEADER99 = 98;
    static final int TYPE_HEADER100 = 99;
    static final int TYPE_HEADER101 = 100;
    static final int TYPE_HEADER102 = 101;
    static final int TYPE_HEADER103 = 102;
    static final int TYPE_HEADER104 = 103;
    static final int TYPE_HEADER105 = 104;
    static final int TYPE_HEADER106 = 105;
    static final int TYPE_HEADER107 = 106;
    static final int TYPE_HEADER108 = 107;
    static final int TYPE_HEADER109 = 108;
    static final int TYPE_HEADER110 = 109;
    static final int TYPE_HEADER111 = 110;
    static final int TYPE_HEADER112 = 111;
    static final int TYPE_HEADER113 = 112;
    static final int TYPE_HEADER114 = 113;
    static final int TYPE_HEADER115 = 114;
    static final int TYPE_HEADER116 = 115;
    static final int TYPE_HEADER117 = 116;
    static final int TYPE_HEADER118 = 117;
    static final int TYPE_HEADER119 = 118;
    static final int TYPE_HEADER120 = 119;
    static final int TYPE_HEADER121 = 120;
    static final int TYPE_HEADER122 = 121;
    static final int TYPE_HEADER123 = 122;
    static final int TYPE_HEADER124 = 123;
    static final int TYPE_HEADER125 = 124;
    static final int TYPE_HEADER126 = 125;


    TextView txt_food_activity_2, txt_food_activity_1;

    public TestRecyclerViewAdapter3(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            case 1:
                return TYPE_HEADER126;
            case 2:
                return TYPE_HEADER2;
            case 3:
                return TYPE_HEADER3;
            case 4:
                return TYPE_HEADER4;
            case 5:
                return TYPE_HEADER5;
            case 6:
                return TYPE_HEADER6;
            case 7:
                return TYPE_HEADER7;
            case 8:
                return TYPE_HEADER8;
            case 9:
                return TYPE_HEADER9;
            case 10:
                return TYPE_HEADER10;
            case 11:
                return TYPE_HEADER11;
            case 12:
                return TYPE_HEADER12;
            case 13:
                return TYPE_HEADER13;
            case 14:
                return TYPE_HEADER14;
            case 15:
                return TYPE_HEADER15;
            case 16:
                return TYPE_HEADER16;
            case 17:
                return TYPE_HEADER17;
            case 18:
                return TYPE_HEADER18;
            case 19:
                return TYPE_HEADER19;
            case 20:
                return TYPE_HEADER20;
            case 21:
                return TYPE_HEADER21;
            case 22:
                return TYPE_HEADER22;
            case 23:
                return TYPE_HEADER23;
            case 24:
                return TYPE_HEADER24;
            case 25:
                return TYPE_HEADER25;
            case 26:
                return TYPE_HEADER26;
            case 27:
                return TYPE_HEADER27;
            case 28:
                return TYPE_HEADER28;
            case 29:
                return TYPE_HEADER29;
            case 30:
                return TYPE_HEADER30;
            case 31:
                return TYPE_HEADER31;
            case 32:
                return TYPE_HEADER32;
            case 33:
                return TYPE_HEADER33;
            case 34:
                return TYPE_HEADER34;
            case 35:
                return TYPE_HEADER35;
            case 36:
                return TYPE_HEADER36;
            case 37:
                return TYPE_HEADER37;
            case 38:
                return TYPE_HEADER38;
            case 39:
                return TYPE_HEADER39;
            case 40:
                return TYPE_HEADER40;
            case 41:
                return TYPE_HEADER41;
            case 42:
                return TYPE_HEADER42;
            case 43:
                return TYPE_HEADER43;
            case 44:
                return TYPE_HEADER44;
            case 45:
                return TYPE_HEADER45;
            case 46:
                return TYPE_HEADER46;
            case 47:
                return TYPE_HEADER47;
            case 48:
                return TYPE_HEADER48;
            case 49:
                return TYPE_HEADER49;
            case 50:
                return TYPE_HEADER50;
            case 51:
                return TYPE_HEADER51;
            case 52:
                return TYPE_HEADER52;
            case 53:
                return TYPE_HEADER53;
            case 54:
                return TYPE_HEADER54;
            case 55:
                return TYPE_HEADER55;
            case 56:
                return TYPE_HEADER56;
            case 57:
                return TYPE_HEADER57;
            case 58:
                return TYPE_HEADER58;
            case 59:
                return TYPE_HEADER59;
            case 60:
                return TYPE_HEADER60;
            case 61:
                return TYPE_HEADER61;
            case 62:
                return TYPE_HEADER62;
            case 63:
                return TYPE_HEADER63;
            case 64:
                return TYPE_HEADER64;
            case 65:
                return TYPE_HEADER65;
            case 66:
                return TYPE_HEADER66;
            case 67:
                return TYPE_HEADER67;
            case 68:
                return TYPE_HEADER68;
            case 69:
                return TYPE_HEADER69;
            case 70:
                return TYPE_HEADER70;
            case 71:
                return TYPE_HEADER71;
            case 72:
                return TYPE_HEADER72;
            case 73:
                return TYPE_HEADER73;
            case 74:
                return TYPE_HEADER74;
            case 75:
                return TYPE_HEADER75;
            case 76:
                return TYPE_HEADER76;
            case 77:
                return TYPE_HEADER77;
            case 78:
                return TYPE_HEADER78;
            case 79:
                return TYPE_HEADER79;
            case 80:
                return TYPE_HEADER80;
            case 81:
                return TYPE_HEADER81;
            case 82:
                return TYPE_HEADER82;
            case 83:
                return TYPE_HEADER83;
            case 84:
                return TYPE_HEADER84;
            case 85:
                return TYPE_HEADER85;
            case 86:
                return TYPE_HEADER86;
            case 87:
                return TYPE_HEADER87;
            case 88:
                return TYPE_HEADER88;
            case 89:
                return TYPE_HEADER89;
            case 90:
                return TYPE_HEADER90;
            case 91:
                return TYPE_HEADER91;
            case 92:
                return TYPE_HEADER92;
            case 93:
                return TYPE_HEADER93;
            case 94:
                return TYPE_HEADER94;
            case 95:
                return TYPE_HEADER95;
            case 96:
                return TYPE_HEADER96;
            case 97:
                return TYPE_HEADER97;
            case 98:
                return TYPE_HEADER98;
            case 99:
                return TYPE_HEADER99;
            case 100:
                return TYPE_HEADER100;
            case 101:
                return TYPE_HEADER101;
            case 102:
                return TYPE_HEADER102;
            case 103:
                return TYPE_HEADER103;
            case 104:
                return TYPE_HEADER104;
            case 105:
                return TYPE_HEADER105;
            case 106:
                return TYPE_HEADER106;
            case 107:
                return TYPE_HEADER107;
            case 108:
                return TYPE_HEADER108;
            case 109:
                return TYPE_HEADER109;
            case 110:
                return TYPE_HEADER110;
            case 111:
                return TYPE_HEADER111;
            case 112:
                return TYPE_HEADER112;
            case 113:
                return TYPE_HEADER113;
            case 114:
                return TYPE_HEADER114;
            case 115:
                return TYPE_HEADER115;
            case 116:
                return TYPE_HEADER116;
            case 117:
                return TYPE_HEADER117;
            case 118:
                return TYPE_HEADER118;
            case 119:
                return TYPE_HEADER119;
            case 120:
                return TYPE_HEADER120;
            case 121:
                return TYPE_HEADER121;
            case 122:
                return TYPE_HEADER122;
            case 123:
                return TYPE_HEADER123;
            case 124:
                return TYPE_HEADER124;
            case 125:
                return TYPE_HEADER125;
            default:
                return TYPE_HEADER2;
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
                        .inflate(R.layout.food_male_plan_10_fragment_3_1, parent, false);


                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_HEADER2: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_1);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_1);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_1_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_1_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_1_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER3: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_2);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_2);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_2_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_2_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_2_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER4: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_3);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_3);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_3_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_3_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_3_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER5: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_4);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_4);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_4_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_4_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_4_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER6: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_5);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_5);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_5_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_5_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_5_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER7: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_6);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_6);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_6_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_6_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_6_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER8: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_7);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_7);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_7_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_7_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_7_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER9: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_8);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_8);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_8_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_8_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_8_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER10: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_9);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_9);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_9_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_9_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_9_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER11: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_10);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_10);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_10_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_10_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_1_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER12: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_11);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_11);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_11_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_11_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_11_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER13: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_12);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_12);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_12_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_12_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_12_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER14: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_13);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_13);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_13_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_13_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_13_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER15: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_14);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_14);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_14_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_14_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_14_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER16: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_15);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_15);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_15_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_15_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_15_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER17: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_16);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_16);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_16_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_16_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_16_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER18: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_17);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_17);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_17_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_17_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_17_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER19: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_18);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_18);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_18_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_18_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_18_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER20: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_19);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_19);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_19_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_19_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_19_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER21: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_20);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_20);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_20_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_20_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_20_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER22: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_21);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_21);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_21_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_21_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_21_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER23: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_22);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_22);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_22_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_22_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_22_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER24: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_23);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_23);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_23_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_23_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_23_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER25: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_24);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_24);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_24_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_24_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_24_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER26: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_25);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_25);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_25_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_25_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_25_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER27: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_26);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_26);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_26_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_26_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_26_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER28: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_27);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_27);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_27_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_27_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_27_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER29: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_28);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_28);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_28_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_28_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_28_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER30: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_29);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_29);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_29_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_29_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_29_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER31: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_30);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_30);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_30_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_30_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_30_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER32: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_31);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_31);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_31_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_31_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_31_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER33: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_32);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_32);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_32_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_32_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_32_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER34: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_33);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_33);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_33_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_33_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_33_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER35: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_34);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_34);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_34_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_34_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_34_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER36: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_35);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_35);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_35_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_35_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_35_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER37: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_36);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_36);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_36_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_36_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_36_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER38: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_37);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_37);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_37_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_37_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_37_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER39: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_38);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_38);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_38_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_38_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_38_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER40: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_39);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_39);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_39_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_39_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_39_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER41: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_40);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_40);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_40_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_40_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_40_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER42: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_41);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_41);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_41_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_41_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_41_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER43: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_42);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_42);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_42_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_42_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_42_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER44: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_43);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_43);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_43_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_43_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_43_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER45: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_44);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_44);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_44_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_44_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_44_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER46: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_45);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_45);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_45_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_45_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_45_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER47: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_46);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_46);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_46_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_46_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_46_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER48: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_47);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_47);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_47_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_47_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_47_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER49: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_48);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_48);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_48_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_48_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_48_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER50: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_49);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_49);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_49_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_49_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_49_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER51: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_50);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_50);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_50_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_50_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_50_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER52: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_51);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_51);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_51_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_51_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_51_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER53: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_52);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_52);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_52_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_52_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_52_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER54: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_53);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_53);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_53_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_53_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_53_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER55: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_54);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_54);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_54_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_54_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_54_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER56: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_55);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_55);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_55_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_55_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_55_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER57: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_56);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_56);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_56_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_56_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_56_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER58: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_57);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_57);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_57_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_57_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_57_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER59: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_58);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_58);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_58_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_58_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_58_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER60: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_59);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_59);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_59_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_59_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_59_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER61: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_60);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_60);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_60_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_60_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_60_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER62: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_61);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_61);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_61_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_61_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_61_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER63: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_62);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_62);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_62_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_62_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_62_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER64: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_63);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_63);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_63_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_63_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_63_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER65: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_64);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_64);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_64_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_64_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_64_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER66: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_66);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_66);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_66_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_66_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_66_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER67: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_67);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_67);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_67_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_67_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_67_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER68: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_68);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_68);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_68_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_68_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_68_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER69: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_69);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_69);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_69_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_69_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_69_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER70: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_70);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_70);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_70_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_70_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_70_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER71: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_71);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_71);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_71_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_71_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_71_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER72: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_72);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_72);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_72_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_72_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_72_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER73: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_73);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_73);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_73_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_73_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_73_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER74: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_74);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_74);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_74_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_74_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_74_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER75: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_75);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_75);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_75_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_75_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_75_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER76: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_76);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_76);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_76_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_76_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_76_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER77: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_77);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_77);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_77_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_77_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_77_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER78: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_78);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_78);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_78_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_78_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_78_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER79: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_79);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_79);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_79_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_79_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_79_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER80: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_80);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_80);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_80_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_80_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_80_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER81: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_81);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_81);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_81_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_81_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_81_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER82: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_82);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_82);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_82_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_82_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_82_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER83: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_83);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_83);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_83_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_83_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_83_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER84: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_84);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_84);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_84_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_84_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_84_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER85: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_85);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_85);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_85_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_85_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_85_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER86: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_86);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_86);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_86_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_86_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_86_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER87: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_87);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_87);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_87_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_87_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_87_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER88: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_88);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_88);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_88_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_88_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_88_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER89: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_89);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_89);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_89_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_89_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_89_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER90: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_90);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_90);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_90_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_90_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_90_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER91: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_91);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_91);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_91_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_91_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_91_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER92: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_92);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_92);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_92_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_92_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_92_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER93: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_93);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_93);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_93_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_93_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_93_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER94: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_94);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_94);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_94_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_94_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_94_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER95: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_95);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_95);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_95_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_95_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_95_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER96: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_96);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_96);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_96_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_96_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_96_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER97: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_97);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_97);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_97_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_97_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_97_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER98: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_98);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_98);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_98_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_98_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_98_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER99: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_99);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_99);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_99_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_99_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_99_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER100: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_100);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_100);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_100_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_100_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_100_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER101: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_101);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_101);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_101_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_101_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_101_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER102: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_102);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_102);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_102_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_102_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_102_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER103: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_103);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_103);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_103_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_103_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_103_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER104: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_104);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_104);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_104_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_104_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_104_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER105: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_105);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_105);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_105_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_105_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_105_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER106: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_106);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_106);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_106_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_106_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_106_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER107: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_107);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_107);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_107_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_107_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_107_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER108: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_108);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_108);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_108_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_108_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_108_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER109: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_109);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_109);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_109_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_109_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_109_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER110: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_110);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_110);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_110_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_110_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_110_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER111: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_111);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_111);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_111_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_111_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_111_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER112: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_112);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_112);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_112_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_112_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_112_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER113: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_113);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_113);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_113_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_113_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_113_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER114: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_114);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_114);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_114_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_114_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_114_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER115: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_115);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_115);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_115_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_115_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_115_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER116: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_116);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_116);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_116_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_116_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_116_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER117: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_117);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_117);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_117_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_117_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_117_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER118: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_118);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_118);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_118_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_118_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_118_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER119: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_119);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_119);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_119_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_119_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_119_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER120: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_120);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_120);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_120_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_120_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_120_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER121: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_121);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_121);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_121_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_121_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_121_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER122: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_122);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_122);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_122_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_122_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_122_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER123: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_123);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_123);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_123_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_123_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_123_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER124: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_124);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_124);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_124_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_124_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_124_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER125: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_125);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_125);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_125_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_125_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_125_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_HEADER126: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_male_plan_10_fragment_3_2, parent, false);

                txt_food_activity_2 = (TextView) view.findViewById(R.id.txt_food_activity_2);
                txt_food_activity_1 = (TextView) view.findViewById(R.id.txt_food_activity_1);

                txt_food_activity_1.setText(food_male_plan_10.food_65);

                if (food_male_plan_10.weight_activ.length() == 8) {
                    txt_food_activity_2.setText(food_male_plan_10.size_65);
                } else if (food_male_plan_10.weight_activ.length() == 9) {
                    txt_food_activity_2.setText(food_male_plan_10.size_65_2);
                } else if (food_male_plan_10.weight_activ.length() == 10) {
                    txt_food_activity_2.setText(food_male_plan_10.size_65_3);
                } else if (food_male_plan_10.weight_activ.length() == 11) {
                    txt_food_activity_2.setText(food_male_plan_10.size_65_4);
                } else {
                    txt_food_activity_2.setText("not");
                }

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
        }
    }
}