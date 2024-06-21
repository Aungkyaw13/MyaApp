package it.kyaw.myapp;

//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.Random;
//
//public class DiceRoller extends AppCompatActivity {
//    TextView tvDice;
//    Button btRoll;
//    ImageView imageView;
//
//    int[] imgRes = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4,
//            R.drawable.dice_5, R.drawable.dice_6};
//    int index;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_dice_roller);
//        initUI();
//        initListener();
//
//    }
//
//    private void initListener() {
//        btRoll.setOnClickListener(v -> {
//            index = new Random().nextInt(imgRes.length);
//            imageView.setImageResource(imgRes[index]);
//            tvDice.setText(String.valueOf(index+1));
//        });
//    }
//
//    private void initUI() {
//        btRoll = findViewById(R.id.btRoll);
//        tvDice = findViewById(R.id.tvShow);
//        imageView = findViewById(R.id.imageView);
//        imageView.setImageResource(imgRes[0]);
//    }
//}

//package com.example.loginscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DiceRoller extends AppCompatActivity {

    DiceRoller binding;
    TextView scoreTxt;
    ImageView diceImage;
    Button btnRoll, btnChoose;

    ImageView btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dice_roller);
//        IsetVisible();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        scoreTxt = findViewById(R.id.scoreTxt);
        diceImage = findViewById(R.id.diceImage);
        btnRoll = findViewById(R.id.btnRoll);
        btnChoose =findViewById(R.id.btnChoose);
        btn_back = findViewById(R.id.btn_back);

//        btnChoose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DiceRollActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int score = random.nextInt(6)+1;
                scoreTxt.setText(String.valueOf(score));

                switch (score){
                    case  1:
                        diceImage.setImageResource(R.drawable.dice_1);
                        break;
                    case  2:
                        diceImage.setImageResource(R.drawable.dice_2);
                        break;
                    case  3:
                        diceImage.setImageResource(R.drawable.dice_3);
                        break;
                    case  4:
                        diceImage.setImageResource(R.drawable.dice_4);
                        break;
                    case  5:
                        diceImage.setImageResource(R.drawable.dice_5);
                        break;
                    case  6:
                        diceImage.setImageResource(R.drawable.dice_6);
                        break;
                }
            }
        });
///

    }
}