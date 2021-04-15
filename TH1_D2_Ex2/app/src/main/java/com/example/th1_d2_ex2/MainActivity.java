package com.example.th1_d2_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextId, editTextBoD;
    private RadioGroup radioGroup;
    private Button buttonAdd;
    private RadioButton checkedBtn;
    private ListView listView;

    ArrayList<Student> listStudent;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName=findViewById(R.id.editTextName);
        editTextId=findViewById(R.id.editTextId);
        editTextBoD=findViewById(R.id.editTextBoD);
        radioGroup=findViewById(R.id.radioGroup);
        buttonAdd=findViewById(R.id.buttonAdd);

        editTextBoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        listView=findViewById(R.id.listView);
        listStudent=new ArrayList<>();
        adapter=new StudentAdapter(this,R.layout.student_line,listStudent);
        listView.setAdapter(adapter);

    }


    private void datePicker(){
        Calendar calendar=Calendar.getInstance();
        int date=calendar.get(Calendar.DATE);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                editTextBoD.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },year,month,date);
        datePickerDialog.show();
    }

    private void addStudent(){
        Student student=new Student();
        student.setImage(R.drawable.chienda3);
        student.setName(editTextName.getText().toString().trim());
        student.setId(editTextId.getText().toString().trim());
        int selectedBtn=radioGroup.getCheckedRadioButtonId();
        checkedBtn=findViewById(selectedBtn);
        if(checkedBtn.getText().equals("Nam")){
            student.setGender("Nam");
        } else if(checkedBtn.getText().equals("Nữ")){
            student.setGender("Nữ");
        }
        student.setBoD(editTextBoD.getText().toString().trim());
        listStudent.add(student);
        adapter.notifyDataSetChanged();
    }



}