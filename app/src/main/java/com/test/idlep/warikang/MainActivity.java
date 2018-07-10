package com.test.idlep.warikang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt金額;
    TextView txt人数;

    Button btn一部割引;
    Button btn金額指定3;

    Button btn計算;
    Button btnクリア;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt金額 = findViewById(R.id.txt金額);
        txt人数 = findViewById(R.id.txt超お金持ち人数);

        btn一部割引 = findViewById(R.id.btn一部割引);
        btn金額指定3 = findViewById(R.id.btn金額指定3);

        btn計算 = findViewById(R.id.btn計算);
        btnクリア = findViewById(R.id.btnクリア);

        btn一部割引.setOnClickListener(this);
        btn金額指定3.setOnClickListener(this);

        btn計算.setOnClickListener(this);
        btnクリア.setOnClickListener(this);
    }

    public boolean chk金額() {
        String 金額 = txt金額.getText().toString();
        return 金額.length() > 0 || 金額.equalsIgnoreCase("0");
    }

    ;

    public boolean chk人数() {
        String 人数 = txt人数.getText().toString();
        return 人数.length() > 0 || 人数.equalsIgnoreCase("0");
    }

    ;

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
                } else if (!chk人数()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("人数を入力してください。")
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
                int 人数 = Integer.parseInt(txt人数.getText().toString());


                int p1人支払額 = (int) Math.round(金額/人数/100.0)*100;

                int 合計金額 = 金額;
                int 集金金額 = p1人支払額*人数;
                int 計算人数 = 人数;
                int 釣銭 = 集金金額 - 合計金額;


                Intent intent_act = new Intent(getApplicationContext(), ResultActivity.class);
                intent_act.putExtra("p1人支払額",p1人支払額);
                intent_act.putExtra("合計金額",合計金額);
                intent_act.putExtra("集金金額",集金金額);
                intent_act.putExtra("計算人数",人数);
                intent_act.putExtra("釣銭",釣銭);
                startActivity(intent_act);

                break;

            case R.id.btn一部割引:
                Intent intent_act2 = new Intent(getApplicationContext(), IchibuActivity.class);
                startActivity(intent_act2);
                break;
            case R.id.btn金額指定3:
                Intent intent_act1 = new Intent(getApplicationContext(), SiteiActivity.class);
                startActivity(intent_act1);
                break;
            case R.id.btnクリア:
                txt金額.setText("");
                txt人数.setText("");
                break;

        }
    }
}
