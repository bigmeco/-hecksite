package com.example.bigi.checksite;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by bigmeco on 21.12.2017.
 */
class UrlAdapter extends BaseAdapter {
    private SharedPreferences preferences;
    Context context;
    ArrayList<UrlPojo> data;
    private static LayoutInflater inflater = null;

    public UrlAdapter(Context context, ArrayList<UrlPojo> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        preferences = context.getSharedPreferences("Devise", MODE_PRIVATE);
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_url, null);
        TextView textNameUrl = (TextView) vi.findViewById(R.id.textNameUrl);
        TextView status = (TextView) vi.findViewById(R.id.status);

        ConstraintLayout colorStatus = (ConstraintLayout) vi.findViewById(R.id.colorStatus);
        textNameUrl.setText(data.get(position).getUrl());
        status.setText(context.getResources().getString(R.string.status)+ data.get(position).getStatus());
        colorStatus.setBackgroundColor(data.get(position).getColor());


        return vi;
    }


}