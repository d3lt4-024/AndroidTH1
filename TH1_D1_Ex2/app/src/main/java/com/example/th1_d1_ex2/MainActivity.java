package com.example.th1_d1_ex2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText txtJobName, txtJobSalary, txtJobDate;
    private RadioButton btnIsActivated;
    private Button btnCreate;

    private ListView lvJob;
    ArrayList<Job> arrayJob;
    JobAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJobName=findViewById(R.id.editJobName);
        txtJobSalary=findViewById(R.id.editTextSalary);
        txtJobDate=findViewById(R.id.editTextDateCreated);
        btnIsActivated=findViewById(R.id.radioButtonIsActivated);
        btnCreate=findViewById(R.id.btnCreate);


        //create date picker
        txtJobDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });
        //btn created clicked
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewJob();
            }
        });

        setView();
        adapter = new JobAdapter(this, R.layout.line_job, arrayJob);
        lvJob.setAdapter(adapter);
    }

    private void datePicker(){
        Calendar calendar=Calendar.getInstance();
        int date=calendar.get(Calendar.DATE);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                txtJobDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,date);
        datePickerDialog.show();
    }

    private void setView(){
        lvJob=findViewById(R.id.listViewJob);
        arrayJob=new ArrayList<>();
        arrayJob.add(new Job("Chiên da 1","10000000","28/03/2021",true,R.drawable.chienda1));
        arrayJob.add(new Job("Chiên da 2","10000000","28/03/2021",true,R.drawable.chienda2));
        arrayJob.add(new Job("Chiên da 3","10000000","28/03/2021",false,R.drawable.chienda3));
        arrayJob.add(new Job("Chiên da 4","10000000","28/03/2021",true,R.drawable.chienda4));
    }

    private void addNewJob(){
        Job newJob=new Job();
        newJob.setImage(R.drawable.chienda1);
        newJob.setName(txtJobName.getText().toString().trim());
        newJob.setSalary(txtJobSalary.getText().toString().trim());
        newJob.setDateCreated(txtJobDate.getText().toString().trim());
        if(btnIsActivated.isChecked()==true){
            newJob.setActivated(true);
        } else newJob.setActivated(false);
        arrayJob.add(newJob);
        adapter.notifyDataSetChanged();
    }

}
