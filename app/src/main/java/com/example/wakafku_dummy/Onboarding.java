 package com.example.wakafku_dummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class Onboarding extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicator;
    private MaterialButton buttonOnboardingAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        layoutOnboardingIndicator = findViewById(R.id.item_onboarding_indicator);
        buttonOnboardingAction = findViewById(R.id.activity_onboarding_action);


        setOnboardingItems();
        setupOnboardingIndicator();
        setCurrentOnboardingIndicator(0);

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager2);
        onboardingViewPager.setAdapter(onboardingAdapter);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

//        buttonOnboardingAction.setTextColor(Color.parseColor("#FFFFF"));
        buttonOnboardingAction.setOnClickListener(v -> {
            if (onboardingViewPager.getCurrentItem()+1 < onboardingAdapter.getItemCount()){
                onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
            }else {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

    }
    private void setOnboardingItems(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem itemNavigation = new OnboardingItem();
        itemNavigation.setTittle("GPS Akurat ");
        itemNavigation.setDesciption("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ornare orci, ac dignissim vitae, rutrum tincidunt amet nunc. ");
        itemNavigation.setImage(R.drawable.ic_navigation);

        OnboardingItem itemInovation = new OnboardingItem();
        itemInovation.setTittle("Pembelajaran ter-arah");
        itemInovation.setDesciption("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ornare orci, ac dignissim vitae, rutrum tincidunt amet nunc. ");
        itemInovation.setImage(R.drawable.ic_inovation);

        OnboardingItem itemSearch = new OnboardingItem();
        itemSearch.setTittle("Fitur lengkap");
        itemSearch.setDesciption("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ornare orci, ac dignissim vitae, rutrum tincidunt amet nunc. ");
        itemSearch.setImage(R.drawable.ic_search_engine);

        onboardingItems.add(itemNavigation);
        onboardingItems.add(itemInovation);
        onboardingItems.add(itemSearch);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }

    private void setupOnboardingIndicator(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i=0; i<indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicator.getChildCount();
        for (int i=0;i<childCount;i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if (i==index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                );
            }else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onboardingAdapter.getItemCount() - 1){
            buttonOnboardingAction.setText("Mulai");

        }else{
            buttonOnboardingAction.setText("Next");
        }
    }

    public void skip(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
