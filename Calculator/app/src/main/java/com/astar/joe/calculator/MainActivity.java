package com.astar.joe.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList arrayList = new ArrayList();

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_c = (Button) findViewById(R.id.btn_c);
        Button btn_ac = (Button) findViewById(R.id.btn_ac);
        Button btn_dot = (Button) findViewById(R.id.btn_dot);

        Button btn_00 = (Button) findViewById(R.id.btn_00);
        Button btn_0 = (Button) findViewById(R.id.btn_0);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);

        Button btn_plus = (Button) findViewById(R.id.btn_plus);
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_div = (Button) findViewById(R.id.btn_div);

        Button btn_equ = (Button) findViewById(R.id.btn_equ);

        btn_c.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_dot.setOnClickListener(this);

        btn_plus.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);

        btn_equ.setOnClickListener(this);

        btn_00.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        TextView tv_memo = (TextView) findViewById(R.id.tv_memo);
        switch (v.getId()) {


            case R.id.btn_dot:

                tv_memo.setText(tv_memo.getText().toString() + ".");

                break;
            case R.id.btn_c:

                arrayList.clear();
                tv_memo.setText("0");

                break;


            case R.id.btn_ac:
                if (tv_memo.getText().toString() != "") {
                    tv_memo.setText("0");
                }

                break;



            case R.id.btn_00:
                tv_memo.setText(tv_memo.getText().toString()+"00");
                tv_memo.setText(tv_memo.getText().toString()+"00");
                break;
            case R.id.btn_0:
                tv_memo.setText(tv_memo.getText().toString() + "0");
                break;
            case R.id.btn_1:
                tv_memo.setText(tv_memo.getText().toString() + "1");
                break;
            case R.id.btn_2:
                tv_memo.setText(tv_memo.getText().toString() + "2");
                break;
            case R.id.btn_3:
                tv_memo.setText(tv_memo.getText().toString() + "3");
                break;
            case R.id.btn_4:
                tv_memo.setText(tv_memo.getText().toString() + "4");
                break;
            case R.id.btn_5:
                tv_memo.setText(tv_memo.getText().toString() + "5");
                break;
            case R.id.btn_6:
                tv_memo.setText(tv_memo.getText().toString() + "6");
                break;
            case R.id.btn_7:
                tv_memo.setText(tv_memo.getText().toString() + "7");
                break;
            case R.id.btn_8:
                tv_memo.setText(tv_memo.getText().toString() + "8");
                break;
            case R.id.btn_9:
                tv_memo.setText(tv_memo.getText().toString() + "9");
                break;


            case R.id.btn_plus:
                arrayList.add(tv_memo.getText().toString());
                tv_memo.setText("");
                count = 1;
                break;

            case R.id.btn_sub:
                arrayList.add(tv_memo.getText().toString());
                tv_memo.setText("");
                count = 2;
                break;

            case R.id.btn_mul:
                arrayList.add(tv_memo.getText().toString());
                tv_memo.setText("");
                count = 3;
                break;

            case R.id.btn_div:
                arrayList.add(tv_memo.getText().toString());
                tv_memo.setText("");
                count = 4;
                break;


            case R.id.btn_equ:

                int sum1 = 0, sum2 = 0, sum3, count2 = 0;

                double fsum1 = 0, fsum2 = 0, fsum3 = 0;


                if (arrayList.isEmpty()) {


                    tv_memo.setText("");
                } else {

                    Object obj = arrayList.get(0);
                    String num1 = (String) obj;
                    String num2 = tv_memo.getText().toString();

                    if (num1.contains(".") || num2.contains(".")) {

                        count2 = 1;
                        fsum1 = Float.parseFloat(num1);
                        fsum2 = Float.parseFloat(num2);

                    } else {
                        sum1 = Integer.parseInt(num1);
                        sum2 = Integer.parseInt(num2);
                        sum3 = 0;
                    }

                    String val = "";

                    switch (count) {
                        case 0:

                            tv_memo.setText("");


                        case 1:

                            if (count2 == 1) {

                                fsum3 = fsum1 + fsum2;

                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 + sum2;
                                val = String.valueOf(sum3);

                            }

                            tv_memo.setText(val);
                            arrayList.clear();
                            break;

                        case 2:

                            if (count2 == 1) {

                                fsum3 = fsum1 - fsum2;
                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 - sum2;
                                val = String.valueOf(sum3);

                            }
                            tv_memo.setText(val);
                            arrayList.clear();
                            break;

                        case 3:

                            if (count2 == 1) {

                                fsum3 = fsum1 * fsum2;
                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 * sum2;
                                val = String.valueOf(sum3);

                            }
                            tv_memo.setText(val);
                            arrayList.clear();
                            break;

                        case 4:

                            if (count2 == 1) {

                                fsum3 = fsum1 / fsum2;
                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 / sum2;
                                val = String.valueOf(sum3);

                            }
                            tv_memo.setText(val);
                            arrayList.clear();
                            break;
                    }


                }


                break;

        }


    }
}