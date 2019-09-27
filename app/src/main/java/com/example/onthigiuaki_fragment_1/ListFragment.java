package com.example.onthigiuaki_fragment_1;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ListFragment extends androidx.fragment.app.ListFragment {
private ArrayList<Student> students;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        students = new ArrayList<>();
        students.add(new Student("Kien","pham@gmail.com","123 adc",1998));
        students.add(new Student("k","pham@gmail.com","123 adc",1998));
        students.add(new Student("2","pham@gmail.com","123 adc",1998));
        students.add(new Student("dd","pham@gmail.com","123 adc",1998));
        students.add(new Student("11e","pham@gmail.com","123 adc",1998));
        students.add(new Student("dsc","pham@gmail.com","123 adc",1998));
        students.add(new Student("3dd","pham@gmail.com","123 adc",1998));
        students.add(new Student("ll","pham@gmail.com","123 adc",1998));

        CustomAdapter adapter = new CustomAdapter(getActivity(),R.layout.customlistview,students);
        setListAdapter(adapter);

        return view;
    }

    // B2: phương thức này sẽ chuyển thông tin của student qua
    public void openDetailActivity(Student student) {
        Intent intent= new Intent(getActivity(),DetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("student",student);
        intent.putExtra("data",bundle);
        startActivity(intent);
    }

    //
    public void landScapeMode(Student student){
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        DetailFragment detailFragment= (DetailFragment) fragmentManager.findFragmentById(R.id.fragDetail);
        detailFragment.applyData(student);

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        int orient = getResources().getConfiguration().orientation;
        if(orient == Configuration.ORIENTATION_PORTRAIT){
           //B1 khi nhấp vào 1 item thì sự kiện onListItemClick trên hoạt động
            openDetailActivity(students.get(position));
        }else{
            landScapeMode(students.get(position));

        }


    }
}
