package com.example.collegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {


       private ViewPager viewPager;
       private BranchAdapter adapter;
       private List<BrachModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_about, container, false);

       list= new ArrayList<>();
       list.add(new BrachModel(R.drawable.ic_bca,"BCA","Level:Under Graduate Intake: 160 Seats Assessment Pattern: Semester + Annual  Starting: June 2020 Study Mode: Full Time (3 Years) Location: Universe Campus, Tathawade, Pune"));
       list.add(new BrachModel(R.drawable.ic_bcs,"BCS", "Level: Under GraduateIntake : 240 Seats Assessment Pattern: Semester + Annual Starting: June 2020 Study Mode: Full Time (3 Years) Location: Universe Campus, Tathawade, Pune"));

      adapter = new BranchAdapter(getContext(),list);


      viewPager= view.findViewById(R.id.viewPager);

      viewPager.setAdapter(adapter);

        ImageView imageView= view.findViewById(R.id.college_image);

        Glide.with(getContext())
        .load("college url to paste")
        .into(imageView);




       return view;

    }
}