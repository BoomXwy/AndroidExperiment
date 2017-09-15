package com.example.xwy.calculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMI extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final EditText weight = (EditText)findViewById(R.id.weight);
        final EditText height = (EditText)findViewById(R.id.height);
        final TextView bmi = (TextView)findViewById(R.id.BMI);
        final TextView situation = (TextView)findViewById(R.id.Situation);
        Button calculationbmi = (Button)findViewById(R.id.calculationbmi);
        calculationbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()) {
                    bmi.setText("ERROR");
                }else{
                    double w = Double.parseDouble(weight.getText().toString());
                    double h = Double.parseDouble(height.getText().toString());
                    double result = Double.parseDouble(df.format(w / (h * h) * 10000));
                    bmi.setText(String.valueOf(result));
                    if (result < 18.5) {
                        situation.setText("过轻");
                    } else if (result < 24) {
                        situation.setText("正常");
                    } else if (result < 27) {
                        situation.setText("过重");
                    } else if (result < 30) {
                        situation.setText("轻度肥胖");
                    } else if (result < 35) {
                        situation.setText("中度肥胖");
                    } else {
                        situation.setText("重度肥胖");
                    }
                }
            }
        });
    }
}
