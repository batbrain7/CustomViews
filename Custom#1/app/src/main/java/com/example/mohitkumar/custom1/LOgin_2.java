package com.example.mohitkumar.custom1;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.transition.Fade;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.transition.Fade.IN;

public class LOgin_2 extends AppCompatActivity {


    RelativeLayout relativeLayout, relativeLayout1;
    TextView textView, signtext;
    EditText pass, user, email;
    CardView cardView;
    LinearLayout linearLayout;
    private ViewGroup viewGroup1, viewGroup2, viewGroup3;
    Fade fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.bottomsheet_text);
        cardView = (CardView) findViewById(R.id.card_sheet);
        linearLayout = (LinearLayout) findViewById(R.id.lin_layout);
        relativeLayout = (RelativeLayout) findViewById(R.id.design_bottom_sheet1);

        BottomSheetBehavior behavior = BottomSheetBehavior.from(relativeLayout);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.d("BottomSheetCallback", "BottomSheetBehavior.STATE_EXPANDED");
                        textView.setVisibility(View.GONE);

                        fade = new Fade(IN);

                        int cx = cardView.getWidth() / 2;
                        int cy = cardView.getHeight() / 2;

                        float finalradius = (float) Math.hypot(cx, cy);
                        Animator animator = ViewAnimationUtils.createCircularReveal(cardView, cx, cy, 0, finalradius);
                        final Animation alphaAnimation = AnimationUtils.loadAnimation(LOgin_2.this, R.anim.fade);
                        cardView.setVisibility(View.VISIBLE);
                        animator.start();
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                linearLayout.setVisibility(View.VISIBLE);
                                linearLayout.startAnimation(alphaAnimation);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.d("BottomSheetCallback", "BottomSheetBehavior.STATE_COLLAPSED");
                        textView.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.GONE);
                        cardView.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
}
