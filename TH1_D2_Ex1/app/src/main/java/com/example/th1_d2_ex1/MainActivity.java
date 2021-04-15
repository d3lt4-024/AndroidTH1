package com.example.th1_d2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ChieuRong, ChieuDai, ChieuCao;
    private RadioButton checkedBtn;
    private Button buttonCalc;
    private RadioGroup radioGrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChieuRong = findViewById(R.id.editTextChieuRong);
        ChieuDai = findViewById(R.id.editTextChieuDai);
        ChieuCao = findViewById(R.id.editTextChieuCao);
        radioGrp = findViewById(R.id.radioGroup);
        buttonCalc = findViewById(R.id.buttonCalc);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String msg = "";
        double rong = Double.parseDouble(ChieuRong.getText().toString().trim());
        double dai = Double.parseDouble(ChieuDai.getText().toString().trim());
        double cao = Double.parseDouble(ChieuCao.getText().toString().trim());
        int selectedBtn = radioGrp.getCheckedRadioButtonId();
        checkedBtn = findViewById(selectedBtn);
        if (checkedBtn.getText().equals("Diện tích")) {
            double dienTich = 2 * (rong * dai + dai * cao + cao * rong);
            msg = "Diện tích là " + String.valueOf((double) Math.round(dienTich * 100) / 100);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        } else if (checkedBtn.getText().equals("Thể tích")) {
            double theTich = rong * dai * cao;
            msg = "Thể tích là " + String.valueOf((double) Math.round(theTich * 100) / 100);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    }


}