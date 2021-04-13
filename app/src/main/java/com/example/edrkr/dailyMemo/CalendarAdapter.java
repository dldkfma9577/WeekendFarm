package com.example.edrkr.dailyMemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edrkr.R;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.MyViewHolder> {
    private String tag = "CalendarAdapter";
    private List<MyCalendar> mCalendar;
    private int mode; // 0 : 일간/ 1 : 년간 / 2 : 웕간 / 3 : 주간


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tb_day, tb_date;
        private TextView month;

        public MyViewHolder(View view){
            super(view);
            if(mode == 0){
                tb_day = (TextView)view.findViewById(R.id.day_1);
                tb_date = (TextView)view.findViewById(R.id.date_1);
            }else{
                month = (TextView)view.findViewById(R.id.month);
            }
        }
    }

    public CalendarAdapter (List<MyCalendar> mCalendar, int mode){
        this.mCalendar = mCalendar;
        this.mode = mode;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView;
        if(mode == 0){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_dailymemo_date, parent,false);
        }else{
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_dailymemo_other, parent,false);
        }
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        MyCalendar calendar = mCalendar.get(position);
        switch (mode){
            case 0: //일간
                holder.tb_day.setText(calendar.getDay());
                holder.tb_date.setText(calendar.getDate());
                break;
            case 1: //년간
                holder.month.setText(calendar.getYear());
                break;
            case 2: //월간
                holder.month.setText(calendar.getMonth());
                break;
            case 3: //주간
        }
    }

    @Override
    public int getItemCount() {
        return mCalendar.size();
    }
}