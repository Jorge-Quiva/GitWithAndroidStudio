package com.example.mostraryocultar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    FloatingActionButton fabadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabadd = findViewById(R.id.fab_add);
    }

    public void onClickOcultar(View view) {
        if (fabadd.getVisibility() == View.VISIBLE){
            AnimationSet hideFab = (AnimationSet) AnimationUtils
                    .loadAnimation(this, R.anim.hide_fab);
            hideFab.setAnimationListener(this);
            fabadd.startAnimation(hideFab);
        }
    }

    public void onClickMostrar(View view) {
        if (fabadd.getVisibility() == View.GONE){
            AnimationSet showFab = (AnimationSet) AnimationUtils
                    .loadAnimation(this, R.anim.show_fab);
            showFab.setAnimationListener(this);
            fabadd.startAnimation(showFab);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        fabadd.setVisibility(fabadd.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}