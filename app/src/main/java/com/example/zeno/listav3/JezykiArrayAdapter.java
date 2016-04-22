package com.example.zeno.listav3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by zeno on 2016-04-22.
 */
public class JezykiArrayAdapter extends ArrayAdapter<String> {
    private Activity context;
    private String[] jezyki;

    public JezykiArrayAdapter(Activity context, String[] jezyki) {
        super(context, R.layout.custom_list_item, jezyki);
        this.context = context;
        this.jezyki = jezyki;
    }

    static class ViewHolder {
        public TextView tvLanguage;
        public TextView tvItemNumber;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;
        if(rowView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            rowView = layoutInflater.inflate(R.layout.custom_list_item, null, true);
            viewHolder = new ViewHolder();
            viewHolder.tvLanguage = (TextView) rowView.findViewById(R.id.tvLanguage);
            viewHolder.tvItemNumber = (TextView) rowView.findViewById(R.id.tvItemNumber);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }
        viewHolder.tvItemNumber.setText(Integer.toString(position));
        viewHolder.tvLanguage.setText(jezyki[position]);
        return rowView;
    }
}
