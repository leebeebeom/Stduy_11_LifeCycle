package com.beebeom.a11_lifecycle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewLevel;
    private TextView mTextViewScore;
    private int mLevel;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewLevel = findViewById(R.id.level_text);
        mTextViewScore = findViewById(R.id.score_text);
        findViewById(R.id.btn_level_up).setOnClickListener(v -> {
            mLevel++;
            mTextViewLevel.setText("레벨 : " + mLevel);
        });
        findViewById(R.id.btn_score_up).setOnClickListener(v -> {
            mScore += 100;
            mTextViewScore.setText("점수 : " + mScore);
        });

    }
    //액티비티 종료시 호출
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Bundle 객체에 점수 저장
        outState.putInt("level", mLevel);
        outState.putInt("score", mScore);
    }
    //액티비티 재생성시 호출

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mLevel = savedInstanceState.getInt("level");
        mScore = savedInstanceState.getInt("score");
        mTextViewLevel.setText("레벨 : "+mLevel);
        mTextViewScore.setText("점수 : "+mScore);
    }
}

