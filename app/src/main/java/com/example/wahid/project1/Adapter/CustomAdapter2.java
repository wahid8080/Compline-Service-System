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

import com.example.wahid.project1.Model.UploadProblem;
import com.example.wahid.project1.R;

import java.util.List;

public class CustomAdapter2 extends ArrayAdapter<UploadProblem> {

    private Activity context;
    private List<UploadProblem> uploadProblemList;


    public CustomAdapter2(Activity context, List<UploadProblem> uploadProblemList) {
        super(context ,R.layout.list_view_problem_view,uploadProblemList);
        this.context = context;
        this.uploadProblemList = uploadProblemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_view_problem_view,null,true);

        UploadProblem uploadProblem = uploadProblemList.get(position);

        ImageView mImage = view.findViewById(R.id.listViewImageId);
        TextView mProblemDes = view.findViewById(R.id.listViewProblemDiscreptionId);
        TextView mProblemCatagory = view.findViewById(R.id.listViewProblemCatagoryId);

        Bitmap bm = StringToBitMap(uploadProblem.getImage());

        mImage.setImageBitmap(bm);
        mProblemCatagory.setText(uploadProblem.getProblemType());
        mProblemDes.setText(uploadProblem.getProblemDiscreption());


        return view;
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}

