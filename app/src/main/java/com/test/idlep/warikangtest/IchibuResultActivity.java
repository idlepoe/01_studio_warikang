package com.test.idlep.warikangtest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class IchibuResultActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = MainActivity.class.getSimpleName();

    TextView txt多め;
    TextView txt少なめ;
    TextView txt合計金額;
    TextView txt集金金額;
    TextView txt計算人数;
    TextView txt釣銭;

    Button btn戻る;

    Button btnエラー;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ichibu_activity_result);
        Log.d(TAG,"ichibu_activity_result");

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        txt多め = findViewById(R.id.txt多め);
        txt少なめ = findViewById(R.id.txt超お金持ち人数);
        txt合計金額 = findViewById(R.id.txt合計金額);
        txt集金金額 = findViewById(R.id.txt集金金額);
        txt計算人数 = findViewById(R.id.txt合計人数);
        txt釣銭 = findViewById(R.id.txt釣銭);

        btn戻る = findViewById(R.id.btn戻る);

        btnエラー = findViewById(R.id.btnエラー4);

        btn戻る.setOnClickListener(this);

        Intent intent = getIntent();

        int 多め = intent.getIntExtra("多め", 0);
        int 少なめ = intent.getIntExtra("少なめ", 0);
        int 合計金額 = intent.getIntExtra("合計金額", 0);
        int 集金金額 = intent.getIntExtra("集金金額", 0);
        int 計算人数 = intent.getIntExtra("計算人数", 0);
        int 釣銭 = intent.getIntExtra("釣銭", 0);

        txt多め.setText(多め + "");
        txt少なめ.setText(少なめ + "");
        txt合計金額.setText(合計金額 + "");
        txt集金金額.setText(集金金額 + "");
        txt計算人数.setText(計算人数 + "");
        txt釣銭.setText(釣銭 + "");

        btnエラー.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new ArrayIndexOutOfBoundsException("一部結果エラー");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn戻る:
                this.finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
// screen name must be <= 36 characters
        mFirebaseAnalytics.setCurrentScreen(this, "一部結果", this.getClass().getSimpleName());
    }

}
