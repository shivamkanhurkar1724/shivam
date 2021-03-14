package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private  ImageView map;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3);



        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        return view;

    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Indira College of Commerce and Science Pune");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }

    private void setSliderViews() {
        for(int i=0;i<5;i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/indira-college-app.appspot.com/o/gallery%2F%5BB%40a07708cjpg?alt=media&token=461a7ac3-6497-438c-8031-af90514484e4");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/indira-college-app.appspot.com/o/gallery%2F%5BB%401ec30bdjpg?alt=media&token=2daeadf6-619a-4a07-b4c4-04865d32ec63");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/indira-college-app.appspot.com/o/gallery%2F%5BB%403a3ffc5jpg?alt=media&token=d6c035df-3b3f-4dd0-b47e-f17f83128b0d");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/indira-college-app.appspot.com/o/gallery%2F%5BB%405bacb6ejpg?alt=media&token=1f959537-23d8-4e8d-a9d5-7a3920b0248b");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
             sliderLayout.addSliderView(sliderView);

        }
    }
}