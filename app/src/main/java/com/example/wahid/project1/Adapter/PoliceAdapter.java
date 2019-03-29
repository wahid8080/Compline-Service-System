package com.example.wahid.project1.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wahid.project1.Model.Hospital_HelpLine;
import com.example.wahid.project1.Model.Police_Helpline;
import com.example.wahid.project1.R;

import java.util.List;

public class PoliceAdapter extends ArrayAdapter<Police_Helpline> {

    private Activity context;
    private List<Police_Helpline> police_helplineList;


    public PoliceAdapter(Activity context, List<Police_Helpline> police_helplineList) {
        super(context ,R.layout.list_view_for_police,police_helplineList);
        this.context = context;
        this.police_helplineList = police_helplineList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_view_for_police,null,true);

        Police_Helpline policeHelpline = police_helplineList.get(position);

        TextView t1 = view.findViewById(R.id.thanaNameid);
        TextView t2 = view.findViewById(R.id.thanaNumberId);

        t1.setText("Thana Name : "+policeHelpline.getThana());
        t2.setText("Thana Number : "+policeHelpline.getNumber());
        return view;
    }

}

