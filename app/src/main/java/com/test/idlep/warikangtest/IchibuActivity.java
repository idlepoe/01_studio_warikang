package com.test.idlep.warikangtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class IchibuActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAnalytics mFirebaseAnalytics;

    TextView txt金額;
    TextView txt多め;
    TextView txt多めに;
    TextView txt少なめ;

    Button btn均等;
    Button btn金額指定;


    Button btn計算;
    Button btnクリア;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ichibu);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        txt金額 = findViewById(R.id.txt金額);
        txt多め = findViewById(R.id.txt多め);
        txt多めに = findViewById(R.id.txt多めに);
        txt少なめ = findViewById(R.id.txt超お金持ち人数);

        btn均等 = findViewById(R.id.btn均等);
        btn金額指定 = findViewById(R.id.btn金額指定);


        btn計算 = findViewById(R.id.btn計算);
        btnクリア = findViewById(R.id.btnクリア);

        btn均等.setOnClickListener(this);
        btn金額指定.setOnClickListener(this);

        btn計算.setOnClickListener(this);
        btnクリア.setOnClickListener(this);
    }

    public boolean chk金額() {
        String 金額 = txt金額.getText().toString();
        return 金額.length() > 0 || 金額.equalsIgnoreCase("0");
    };


    public boolean chk多め() {
        String 多め = txt多め.getText().toString();
        return 多め.length() > 0 || 多め.equalsIgnoreCase("0");
    };

    public boolean chk少なめ() {
        String 少なめ = txt少なめ.getText().toString();
        return 少なめ.length() > 0 || 少なめ.equalsIgnoreCase("0");
    };

    public boolean chk多めに() {
        String 多めに = txt多めに.getText().toString();
        return 多めに.length() > 0 || 多めに.equalsIgnoreCase("0");
    };

    @Override
    protected void onResume() {
        super.onResume();
// screen name must be <= 36 characters
        mFirebaseAnalytics.setCurrentScreen(this, "CurrentScreen: " + getClass().getSimpleName(), null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn計算:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);
                AlertDialog alertDialog;

                boolean error=false;

                if (!chk金額()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("金額を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (!chk多め()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("多めを入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (!chk少なめ()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("少なめを入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (!chk多めに()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("多めにを入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                }

                if(error){
                    alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    break;
                }

                int 金額=Integer.parseInt(txt金額.getText().toString());
                int 多め = Integer.parseInt(txt多め.getText().toString());
                int 多めに = Integer.parseInt(txt多めに.getText().toString());
                int 少なめ = Integer.parseInt(txt少なめ.getText().toString());
                int 人数 = 多め+少なめ;

                int p1人支払額 = (int) Math.round(金額/人数/100.0)*100;

                int p多めに = p1人支払額 + 多めに;

                int p多め = p多めに;

                int p少なめ= p1人支払額;

                int 合計金額 = 金額;

                int 集金金額 = p多めに*多め + p1人支払額*少なめ;

                int 釣銭 = 集金金額 - 合計金額;

                while(釣銭-(100*人数)>0){
                    p多め = p多め - 100;
                    p少なめ = p少なめ-100;
                    集金金額 = p多めに*多め + p少なめ*少なめ;
                    釣銭 = 集金金額 - 合計金額;
                }

                Bundle bundle = new Bundle();
                bundle.putString("多め",p多め+"");
                bundle.putString("少なめ",p少なめ+"");
                bundle.putString("合計金額",合計金額+"");
                bundle.putString("集金金額",集金金額+"");
                bundle.putString("計算人数",人数+"");
                bundle.putString("釣銭",釣銭+"");
                mFirebaseAnalytics.logEvent("IchibuActivity", bundle);

                Intent intent_act = new Intent(getApplicationContext(), IchibuResultActivity.class);
                intent_act.putExtra("多め",p多め);
                intent_act.putExtra("少なめ",p少なめ);
                intent_act.putExtra("合計金額",合計金額);
                intent_act.putExtra("集金金額",集金金額);
                intent_act.putExtra("計算人数",人数);
                intent_act.putExtra("釣銭",釣銭);
                startActivity(intent_act);

                break;
            case R.id.btnクリア:
                txt金額.setText("");
                txt多め.setText("");
                txt多めに.setText("");
                txt少なめ.setText("");
                break;
            case R.id.btn均等:
                Intent intent_act2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_act2);
                break;
            case R.id.btn金額指定:
                Intent intent_act1 = new Intent(getApplicationContext(), SiteiActivity.class);
                startActivity(intent_act1);
            break;

        }
    }
}
