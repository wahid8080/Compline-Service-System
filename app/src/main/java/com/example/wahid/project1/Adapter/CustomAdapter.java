package com.example.wahid.project1.Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wahid.project1.Model.Hospital_HelpLine;
import com.example.wahid.project1.Model.UploadProblem;
import com.example.wahid.project1.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Hospital_HelpLine> {

    private Activity context;
    private List<Hospital_HelpLine> hospital_helpLineList;


    public CustomAdapter(Activity context, List<Hospital_HelpLine> hospital_helpLineList) {
        super(context ,R.layout.list_view_viewer,hospital_helpLineList);
        this.context = context;
        this.hospital_helpLineList = hospital_helpLineList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_view_viewer,null,true);

        Hospital_HelpLine hospital_helpLine = hospital_helpLineList.get(position);

        TextView t1 = view.findViewById(R.id.listViewProblemNameId);
        TextView t2 = view.findViewById(R.id.listViewProblemDisId);

        t1.setText("Hospital Name : "+hospital_helpLine.getName());
        t2.setText("Hospital Number : "+hospital_helpLine.getPhone());
        return view;
    }

}

