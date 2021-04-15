package com.example.th1_d1_ex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class JobAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Job> listJob;

    public JobAdapter(Context context, int layout, List<Job> listJob) {
        this.context = context;
        this.layout = layout;
        this.listJob = listJob;
    }

    @Override
    public int getCount() {
        return listJob.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,null);
        //find view in line_job.xml
        TextView txtName=convertView.findViewById(R.id.textViewName);
        TextView txtSalary=convertView.findViewById(R.id.textViewSalary);
        TextView txtDate=convertView.findViewById(R.id.textViewDate);
        RadioButton btnActivated=convertView.findViewById(R.id.radioBtnActivated);
        ImageView viewImg=convertView.findViewById(R.id.imageView);
        Button btnDelete=convertView.findViewById(R.id.btnDelete);
        //button delete clicked
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listJob.remove(position);
                notifyDataSetChanged();
            }
        });
        //set data for line
        Job congViec= listJob.get(position);
        txtName.setText(congViec.getName());
        txtSalary.setText(String.valueOf(congViec.getSalary()));
        txtDate.setText(congViec.getDateCreated());
        btnActivated.setClickable(false);
        if(congViec.isActivated()==true){
            btnActivated.setChecked(true);
        } else btnActivated.setChecked(false);
        viewImg.setImageResource(congViec.getImage());
        return convertView;
    }
}
