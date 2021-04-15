package com.example.th1_d1_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText BanKinh, ChieuCao;
    private Button btnSubmit;
    private RadioButton checkedBtn;
    private RadioGroup radioGrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BanKinh=findViewById(R.id.BanKinh);
        ChieuCao=findViewById(R.id.ChieuCao);
        btnSubmit=findViewById(R.id.submit);
        radioGrp=findViewById(R.id.radioGrp);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

    }

    private void calculate(){
        String msg="";
        double r=Double.parseDouble(BanKinh.getText().toString().trim());
        double h=Double.parseDouble(ChieuCao.getText().toString().trim());
        int selectedId=radioGrp.getCheckedRadioButtonId();
        checkedBtn=findViewById(selectedId);
        if(checkedBtn.getText().equals("Diện tích")){
            double area = (Math.PI*r*r)+(2*Math.PI*r*h);
            msg="Dien tich la "+ String.valueOf((double) Math.round(area*100)/100);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        } else if (checkedBtn.getText().equals("Thể tích")){
            double volume = Math.PI*r*r*h;
            msg="The tich la "+ String.valueOf((double) Math.round(volume*100)/100);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    }
}