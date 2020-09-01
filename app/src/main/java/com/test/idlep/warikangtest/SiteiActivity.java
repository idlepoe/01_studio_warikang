package com.test.idlep.warikangtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

public class SiteiActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseAnalytics mFirebaseAnalytics;

    TextView txt金額;
    TextView txtお金持ち人数;
    TextView txt二番目お金持ち人数;
    TextView txt三番目お金持ち人数;
    TextView txt残り人数;

    TextView txt超お金持ち金額;
    TextView txt二番目お金持ち金額;
    TextView txt三番目お金持ち金額;

    Button btn一部割引;
    Button btn均等;


    Button btn計算;
    Button btnクリア;

    Button btnエラー;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitei);
        Log.d(TAG,"sitei");

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        txt金額 = findViewById(R.id.txt金額);
        txtお金持ち人数 = findViewById(R.id.txt超お金持ち人数);
        txt二番目お金持ち人数 = findViewById(R.id.txt二番目お金持ち人数);
        txt三番目お金持ち人数 = findViewById(R.id.txt三番目お金持ち人数);
        txt残り人数 = findViewById(R.id.txt残り人数);
        txt超お金持ち金額 = findViewById(R.id.txt超お金持ち金額);
        txt二番目お金持ち金額 = findViewById(R.id.txt二番目お金持ち金額);
        txt三番目お金持ち金額 = findViewById(R.id.txt三番目お金持ち金額);


        btn一部割引 = findViewById(R.id.btn一部割引);
        btn均等 = findViewById(R.id.btn均等);


        btn計算 = findViewById(R.id.btn計算);
        btnクリア = findViewById(R.id.btnクリア);

        btnエラー = findViewById(R.id.btnエラー5);

        btn一部割引.setOnClickListener(this);
        btn均等.setOnClickListener(this);

        btn計算.setOnClickListener(this);
        btnクリア.setOnClickListener(this);

        btnエラー.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new NumberFormatException("指定エラー");
            }
        });
    }

    public boolean chk金額() {
        String 金額 = txt金額.getText().toString();
        return 金額.length() > 0;
    }

    ;

    public boolean chkお金持ち人数() {
        String お金持ち人数 = txtお金持ち人数.getText().toString();

        return お金持ち人数.length() > 0;
    }

    ;

    public boolean chk二番目お金持ち人数() {
        String 二番目お金持ち人数 = txt二番目お金持ち人数.getText().toString();

        return 二番目お金持ち人数.length() > 0;
    }

    ;

    public boolean chk三番目お金持ち人数() {
        String 三番目お金持ち人数 = txt三番目お金持ち人数.getText().toString();

        return 三番目お金持ち人数.length() > 0;
    }

    ;

    public boolean chk超お金持ち金額() {
        String 超お金持ち金額 = txt超お金持ち金額.getText().toString();
        return 超お金持ち金額.length() > 0;
    }

    ;

    public boolean chk二番目お金持ち金額() {
        String 二番目お金持ち金額 = txt二番目お金持ち金額.getText().toString();
        return 二番目お金持ち金額.length() > 0;
    }

    ;

    public boolean chk三番目お金持ち金額() {
        String 三番目お金持ち金額 = txt三番目お金持ち金額.getText().toString();
        return 三番目お金持ち金額.length() > 0;
    }

    ;

    public boolean chk残り人数() {
        String 残り人数 = txt残り人数.getText().toString();
        return 残り人数.length() > 0;
    }

    ;

    @Override
    protected void onResume() {
        super.onResume();
// screen name must be <= 36 characters
        mFirebaseAnalytics.setCurrentScreen(this, "指定", this.getClass().getSimpleName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn計算:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);
                AlertDialog alertDialog;

                boolean error = false;

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
                } else if (!chk残り人数()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("残り人を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (!chkお金持ち人数()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("超金持ち人数を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (chkお金持ち人数() && !chk超お金持ち金額()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("超お金持ち金額を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                } else if (chk二番目お金持ち人数() && !chk二番目お金持ち金額()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("二番目お金持ち金額を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (!chk二番目お金持ち人数() && chk二番目お金持ち金額()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("二番目お金持ち人数を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (chk三番目お金持ち人数() && !chk三番目お金持ち金額()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("三番目お金持ち金額を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                } else if (!chk三番目お金持ち人数() && chk三番目お金持ち金額()) {
                    error = true;

                    alertDialogBuilder
                            .setMessage("三番目お金持ち人数を入力してください。")
                            .setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                }

                if (error) {
                    alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    break;
                }


                int 金額 = Integer.parseInt(txt金額.getText().toString());
                int お金持ち人数 = Integer.parseInt(txtお金持ち人数.getText().toString());
                int 超お金持ち金額 = Integer.parseInt(txt超お金持ち金額.getText().toString());
                int 二番目お金持ち人数 = txt二番目お金持ち人数.getText().toString().equalsIgnoreCase("") ? 0 : Integer.parseInt(txt二番目お金持ち人数.getText().toString());
                int 二番目お金持ち金額 = txt二番目お金持ち金額.getText().toString().equalsIgnoreCase("") ? 0 : Integer.parseInt(txt二番目お金持ち金額.getText().toString());
                int 三番目お金持ち人数 = txt三番目お金持ち人数.getText().toString().equalsIgnoreCase("") ? 0 : Integer.parseInt(txt三番目お金持ち人数.getText().toString());
                int 三番目お金持ち金額 = txt三番目お金持ち金額.getText().toString().equalsIgnoreCase("") ? 0 : Integer.parseInt(txt三番目お金持ち金額.getText().toString());
                int 残り人数 = Integer.parseInt(txt残り人数.getText().toString());

                int 以外金額 = 金額 - (お金持ち人数 * 超お金持ち金額 + 二番目お金持ち人数 * 二番目お金持ち金額 + 三番目お金持ち人数 * 三番目お金持ち金額);
                int 残り金額 = (int) Math.round(以外金額 / 残り人数 / 100.0) * 100;
                int 集金金額 = 残り金額 * 残り人数 + (お金持ち人数 * 超お金持ち金額 + 二番目お金持ち人数 * 二番目お金持ち金額 + 三番目お金持ち人数 * 三番目お金持ち金額);
                int 釣銭 = 集金金額 - 金額;

                Bundle bundle = new Bundle();
                bundle.putString("お金持ち人数", お金持ち人数 + "");
                bundle.putString("二番目お金持ち人数", 二番目お金持ち人数 + "");
                bundle.putString("三番目お金持ち人数", 三番目お金持ち人数 + "");
                bundle.putString("超お金持ち金額", 超お金持ち金額 + "");
                bundle.putString("二番目お金持ち金額", 二番目お金持ち金額 + "");
                bundle.putString("三番目お金持ち金額", 三番目お金持ち金額 + "");
                bundle.putString("残り人数", 残り人数 + "");
                bundle.putString("残り金額", 残り金額 + "");
                bundle.putString("合計金額", 金額 + "");
                bundle.putString("集金金額", 集金金額 + "");
                bundle.putString("計算人数", 残り人数 + お金持ち人数 + 二番目お金持ち人数 + 三番目お金持ち人数 + "");
                mFirebaseAnalytics.logEvent("金額指定", bundle);

                Intent intent_act = new Intent(getApplicationContext(), SiteiResultActivity.class);
                intent_act.putExtra("お金持ち人数", お金持ち人数);
                intent_act.putExtra("二番目お金持ち人数", 二番目お金持ち人数);
                intent_act.putExtra("三番目お金持ち人数", 三番目お金持ち人数);
                intent_act.putExtra("超お金持ち金額", 超お金持ち金額);
                intent_act.putExtra("二番目お金持ち金額", 二番目お金持ち金額);
                intent_act.putExtra("三番目お金持ち金額", 三番目お金持ち金額);
                intent_act.putExtra("残り人数", 残り人数);
                intent_act.putExtra("残り金額", 残り金額);
                intent_act.putExtra("合計金額", 金額);
                intent_act.putExtra("集金金額", 集金金額);
                intent_act.putExtra("計算人数", 残り人数 + お金持ち人数 + 二番目お金持ち人数 + 三番目お金持ち人数);
                intent_act.putExtra("釣銭", 釣銭);
                startActivity(intent_act);

                break;
            case R.id.btnクリア:
                txt金額.setText("");

                break;
            case R.id.btn均等:
                Intent intent_act2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_act2);
                break;
            case R.id.btn一部割引:
                Intent intent_act1 = new Intent(getApplicationContext(), IchibuActivity.class);
                startActivity(intent_act1);
                break;

        }
    }
}
