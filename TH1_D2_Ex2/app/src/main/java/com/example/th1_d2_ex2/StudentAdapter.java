package com.example.th1_d2_ex2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> listStudent;

    public StudentAdapter(Context context, int layout, List<Student> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout, null);

        TextView txtName=convertView.findViewById(R.id.textViewName);
        TextView txtId=convertView.findViewById(R.id.textViewId);
        TextView txtBoD=convertView.findViewById(R.id.textViewBoD);
        RadioButton radioBtnMale=convertView.findViewById(R.id.radioBtnMale);
        RadioButton radioBtnFemale=convertView.findViewById(R.id.radioBtnFemale);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        Button btnDelete=convertView.findViewById(R.id.buttonDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudent.remove(position);
                notifyDataSetChanged();
            }
        });

        Student student=listStudent.get(position);
        txtName.setText(student.getName());
        txtId.setText(student.getId());
        radioBtnMale.setClickable(false);
        radioBtnFemale.setClickable(false);
        if(student.getGender().equals("Nam")){
            radioBtnMale.setChecked(true);
        } else if(student.getGender().equals("Nữ")){
            radioBtnFemale.setChecked(true);
        }
        txtBoD.setText(student.getBoD());
        imageView.setImageResource(student.getImage());
        return convertView;
    }
}
