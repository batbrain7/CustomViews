package com.example.mohitkumar.custom1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;

public class Profile extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile");
        linearLayout = (LinearLayout) findViewById(R.id.lin_1);
        android.view.ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Display display = getWindowManager().getDefaultDisplay();
        layoutParams.height = (int) (display.getHeight()*0.50);
        layoutParams.width = display.getWidth();
        linearLayout.setLayoutParams(layoutParams);
        viewPager = (ViewPager) findViewById(R.id.view_pager1);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragments(new BlankFragment(),"Portfolio");
        viewPagerAdapter.AddFragments(new BlankFragment(),"Skills");
        viewPagerAdapter.AddFragments(new BlankFragment(),"Contact");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
