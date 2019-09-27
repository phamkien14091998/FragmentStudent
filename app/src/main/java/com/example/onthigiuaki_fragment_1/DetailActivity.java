package com.example.onthigiuaki_fragment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent= getIntent();
        Bundle bundle= intent.getBundleExtra("data");
        Student student= (Student) bundle.getSerializable("student");

        FragmentManager fragmentManager= getSupportFragmentManager();
        DetailFragment detailFragment =(DetailFragment)
                fragmentManager.findFragmentById(R.id.fragDetail);
        detailFragment.applyData(student);

    }
}
