package com.example.onthigiuaki_fragment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resource;
    private ArrayList<Student> students;

    public CustomAdapter(Context context, int resource, ArrayList<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.resource = resource;
        this.students = students;
    }

    // ctr + o để @Override phưowng thức
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.customlistview, parent,false);

        }

        TextView tvName= convertView.findViewById(R.id.tvName);
        tvName.setText(students.get(position).getName());

        return convertView;
    }
}
