package com.android.fury.a30day.food;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.fury.a30day.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fury on 9/4/2016.
 */
public class listviewAdapter extends BaseAdapter {

    public static final String FIRST_COLUMN = "Column 1";
    public static final String SECOND_COLUMN = "Column 2";
    public static final String SECOND_COLUMN_2 = "Column 3";

    public ArrayList<HashMap<String, String>> list;

    ArrayList<HashMap<String, String>> mAllData = new ArrayList<HashMap<String, String>>();

    HashMap<String, String> map;

    ViewHolder holder;

    Activity activity;

    public listviewAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        super();
        this.activity = activity;
        this.list = list;
        this.mAllData = list;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }


    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
        TextView txtSecond_2;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub

        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rows, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.column1);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.column2);
            holder.txtSecond_2 = (TextView) convertView.findViewById(R.id.column3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        map = list.get(position);

        holder.txtFirst.setText(map.get(FIRST_COLUMN));
        holder.txtSecond.setText(map.get(SECOND_COLUMN));
        holder.txtSecond_2.setText(map.get(SECOND_COLUMN_2));


        return convertView;
    }


}

