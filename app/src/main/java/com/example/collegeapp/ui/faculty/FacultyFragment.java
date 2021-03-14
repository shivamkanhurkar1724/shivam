package com.example.collegeapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView bcaDepartment,bcsDepartment,bbaDepartment,bcomDepartment;
    private LinearLayout bcaNoData,bcsNoData,bbaNoData,bcomNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);

        bcaDepartment = view.findViewById(R.id.bcaDepartment);
        bcsDepartment =  view.findViewById(R.id.bcsDepartment);
        bbaDepartment =  view.findViewById(R.id.bbaDepartment);
        bcomDepartment =  view.findViewById(R.id.bcomDepartment);



        bcaNoData =  view.findViewById(R.id.bcaNoData);
        bcsNoData =  view.findViewById(R.id.bcsNoData);
        bbaNoData =  view.findViewById(R.id.bbaNoData);
        bcomNoData =  view.findViewById(R.id.bcomNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        bcaDepartment();
        bcsDepartment();
        bbaDepartment();
        bcomDepartment();

     return  view;

    }

    private void bcaDepartment() {
        dbRef = reference.child("BCA");
        dbRef .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcaNoData.setVisibility(View.VISIBLE);
                    bcaDepartment.setVisibility(View.GONE);

                }else {

                    bcaNoData.setVisibility(View.GONE);
                    bcaDepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    bcaDepartment.setHasFixedSize(true);
                    bcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter= new TeacherAdapter(list1,getContext());
                    bcaDepartment.setAdapter(adapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bcsDepartment() {
        dbRef = reference.child("BCS");
        dbRef .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcsNoData.setVisibility(View.VISIBLE);
                    bcsDepartment.setVisibility(View.GONE);

                }else {

                    bcsNoData.setVisibility(View.GONE);
                    bcsDepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    bcsDepartment.setHasFixedSize(true);
                    bcsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter= new TeacherAdapter(list2,getContext());
                    bcsDepartment.setAdapter(adapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bbaDepartment() {
        dbRef = reference.child("BBA");
        dbRef .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcaNoData.setVisibility(View.VISIBLE);
                    bcaDepartment.setVisibility(View.GONE);

                }else {
                    bbaNoData.setVisibility(View.GONE);
                    bbaDepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    bbaDepartment.setHasFixedSize(true);
                    bbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter= new TeacherAdapter(list3,getContext() );
                    bbaDepartment.setAdapter(adapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bcomDepartment() {
        dbRef = reference.child("BCOM");
        dbRef .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot  dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcomNoData.setVisibility(View.VISIBLE);
                    bcomDepartment.setVisibility(View.GONE);

                }else {
                    bcomNoData.setVisibility(View.GONE);
                    bcomDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    bcomDepartment.setHasFixedSize(true);
                    bcomDepartment.setLayoutManager(new LinearLayoutManager(getContext() ));
                    adapter= new TeacherAdapter(list4,getContext());
                    bcomDepartment.setAdapter(adapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}