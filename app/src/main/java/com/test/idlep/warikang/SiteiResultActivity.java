package com.test.idlep.warikang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SiteiResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt超お金持ち;
    TextView txt二番目お金持ち人数;
    TextView txt三番目お金持ち人数;
    TextView txt残り人数;

    TextView txt超お金持ち金額;
    TextView txt二番目お金持ち金額;
    TextView txt三番目お金持ち金額;
    TextView txt残り金額;

    TextView txt合計金額;
    TextView txt集金金額;
    TextView txt計算人数;
    TextView txt釣銭;

    Button btn戻る;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitei_result);

        txt超お金持ち = findViewById(R.id.txt超金持ち人数);
        txt二番目お金持ち人数 = findViewById(R.id.txt超お金持ち人数);
        txt三番目お金持ち人数 = findViewById(R.id.txt三番目お金持ち人数);
        txt残り人数 = findViewById(R.id.txt三番目お金持ち人数2);
        txt超お金持ち金額 = findViewById(R.id.txtお金持ち);
        txt二番目お金持ち金額 = findViewById(R.id.txt二番目お金持ち);
        txt三番目お金持ち金額 = findViewById(R.id.txt三番目お金持ち);
        txt残り金額 = findViewById(R.id.txt残り);


        txt合計金額 = findViewById(R.id.txt合計金額);
        txt集金金額 = findViewById(R.id.txt集金金額);
        txt計算人数 = findViewById(R.id.txt合計人数);
        txt釣銭 = findViewById(R.id.txt釣銭);

        btn戻る = findViewById(R.id.btn戻る);

        btn戻る.setOnClickListener(this);

        Intent intent = getIntent();

        int お金持ち人数 = intent.getIntExtra("お金持ち人数", 0);
        int 二番目お金持ち人数 = intent.getIntExtra("二番目お金持ち人数", 0);
        int 三番目お金持ち人数 = intent.getIntExtra("三番目お金持ち人数", 0);
        int 超お金持ち金額 = intent.getIntExtra("超お金持ち金額", 0);
        int 二番目お金持ち金額 = intent.getIntExtra("二番目お金持ち金額", 0);
        int 三番目お金持ち金額 = intent.getIntExtra("三番目お金持ち金額", 0);
        int 残り人数 = intent.getIntExtra("残り人数", 0);
        int 残り金額 = intent.getIntExtra("残り金額", 0);


        int 合計金額 = intent.getIntExtra("合計金額", 0);
        int 集金金額 = intent.getIntExtra("集金金額", 0);
        int 計算人数 = intent.getIntExtra("計算人数", 0);
        int 釣銭 = intent.getIntExtra("釣銭", 0);

        txt超お金持ち.setText(お金持ち人数 + "");
        txt二番目お金持ち人数.setText(二番目お金持ち人数 + "");
        txt三番目お金持ち人数.setText(三番目お金持ち人数 + "");
        txt残り人数.setText(残り人数 + "");
        txt超お金持ち金額.setText(超お金持ち金額 + "");
        txt二番目お金持ち金額.setText(二番目お金持ち金額 + "");
        txt三番目お金持ち金額.setText(三番目お金持ち金額 + "");
        txt残り金額.setText(残り金額 + "");

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
