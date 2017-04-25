package com.example.mohitkumar.custom1;

import android.animation.Animator;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnimLog extends AppCompatActivity {

    TextInputLayout fname,sname;
    TextView name1,name2;
    EditText fname1,sname1;
    FloatingActionButton edit;
    boolean b = true;
    Animation open,animation,animation1;
    LinearLayout linearLayout;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_log);
        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView)findViewById(R.id.name2);
        fname = (TextInputLayout)findViewById(R.id.name);
        sname = (TextInputLayout)findViewById(R.id.sname);
        fname1 = (EditText)findViewById(R.id.ed_fname);
        cardView = (CardView) findViewById(R.id.card_view1);
        open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.open);
        animation = AnimationUtils.loadAnimation(this,R.anim.trans_edit);
        animation1 = AnimationUtils.loadAnimation(this,R.anim.trans_edit2);
        sname1 = (EditText)findViewById(R.id.ed_sname);
        linearLayout = (LinearLayout) findViewById(R.id.lin_3);






        edit = (FloatingActionButton) findViewById(R.id.edit_1);
        edit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(b) {
                  //  start();
                    //edit.setImageResource(R.drawable.tick);
                   // b = false;

                    int cx = cardView.getWidth();
                    int cy = cardView.getHeight();

                    float finalradius = (float) Math.hypot(cx,cy);
                    Animator animator = ViewAnimationUtils.createCircularReveal(cardView,cx,cy,0,finalradius);
                    cardView.setVisibility(View.VISIBLE);
                    animator.start();


                } else  {
                    stop();
                    b = true;
                    edit.setImageResource(R.drawable.edit);
                }
            }
        });
    }

    public void anim1() {
        RelativeLayout.LayoutParams position = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
                ,RelativeLayout.LayoutParams.WRAP_CONTENT);

       // position.addRule();

      //  position.addRule();
    }

    public void start() {

        final String tfname = name1.getText().toString();
        final String tsname = name2.getText().toString();
        name1.startAnimation(animation);
        name2.startAnimation(animation1);
        fname.startAnimation(open);
        sname.startAnimation(open);
        animation.setFillAfter(true);
        animation1.setFillAfter(true);
        linearLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                fname1.setText(tfname);
                sname1.setText(tsname);
                name1.setVisibility(View.INVISIBLE);
                name2.setVisibility(View.INVISIBLE);
            //    fname.setAlpha(1);
            //    sname.setAlpha(1);
            }
        },801);
        //name1.setVisibility(View.INVISIBLE);
        //name2.setVisibility(View.INVISIBLE);
        //fname.setVisibility(View.VISIBLE);
        //sname.setVisibility(View.VISIBLE);

      //  fname.setVisibility(View.VISIBLE);
      //  sname.setVisibility(View.VISIBLE);
    }

    public void stop() {

        Animation animationrev = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trans_edit);
        Animation animation1rev = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trans_edit2);
        Animation close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close);
        name1.setVisibility(View.VISIBLE);
        name2.setVisibility(View.VISIBLE);
        animation1.setRepeatMode(Animation.REVERSE);
        animation.setRepeatMode(Animation.REVERSE);
        sname.startAnimation(close);
        name1.startAnimation(animation);
        name2.startAnimation(animation1);
    }
}

