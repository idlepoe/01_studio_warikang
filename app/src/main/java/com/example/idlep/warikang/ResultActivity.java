package com.example.idlep.warikang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt1人支払額;
    TextView txt合計金額;
    TextView txt集金金額;
    TextView txt計算人数;
    TextView txt釣銭;

    Button btn戻る;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txt1人支払額 = findViewById(R.id.txt1人支払額);
        txt合計金額 = findViewById(R.id.txt合計金額);
        txt集金金額 = findViewById(R.id.txt集金金額);
        txt計算人数 = findViewById(R.id.txt計算人数);
        txt釣銭 = findViewById(R.id.txt釣銭);

        btn戻る = findViewById(R.id.btn戻る);

        btn戻る.setOnClickListener(this);

        Intent intent = getIntent();

        int p1人支払額 = intent.getIntExtra("p1人支払額", 0);
        int 合計金額 = intent.getIntExtra("合計金額", 0);
        int 集金金額 = intent.getIntExtra("集金金額", 0);
        int 計算人数 = intent.getIntExtra("計算人数", 0);
        int 釣銭 = intent.getIntExtra("釣銭", 0);

        txt1人支払額.setText(p1人支払額 + "");
        txt合計金額.setText(合計金額 + "");
        txt集金金額.setText(集金金額 + "");
        txt計算人数.setText(計算人数 + "");
        txt釣銭.setText(釣銭 + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn戻る:
                this.finish();
                break;
        }
    }
}
