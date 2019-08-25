package com.tdf.tdfapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tdf.tdfapplication.R;

import java.util.Date;

public class SectionAdapter extends ArrayAdapter<String> {

    public SectionAdapter(@NonNull Context context, String[] sectionList) {
        super(context, 0, sectionList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view_content,parent,false);

        }

        TextView nameTextView = listItemView.findViewById(R.id.section_item_view);
        nameTextView.setText(getItem(position));

        return listItemView;

    }

}

