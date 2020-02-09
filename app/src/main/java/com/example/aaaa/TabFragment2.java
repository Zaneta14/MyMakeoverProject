package com.example.aaaa;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class TabFragment2 extends Fragment {


    public TabFragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView=(TextView) getActivity().findViewById(R.id.address);
        String addr=getActivity().getIntent().getStringExtra(Studio.ADDR_KEY);
        textView.setText(addr);
        final String name=getActivity().getIntent().getStringExtra(Studio.NAME_KEY);
        Button button=(Button) getActivity().findViewById(R.id.confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView d=(TextView) getActivity().findViewById(R.id.datechosen);
                TextView t=(TextView) getActivity().findViewById(R.id.timechosen);
                String date=d.getText().toString();
                String time=t.getText().toString();
                Log.d("date", date);
                Log.d("time", time);
                if (date.length()!=0 && time.length()!=0) {
                    Integer hour=Integer.valueOf(time.split(":")[0]);
                    Integer month=Integer.valueOf(date.split("/")[0]);
                    Integer day=Integer.valueOf(date.split("/")[1]);
                    Integer year=Integer.valueOf(date.split("/")[2]);
                    final Calendar c = Calendar.getInstance();
                    int year1 = c.get(Calendar.YEAR);
                    int month1 = c.get(Calendar.MONTH);
                    month1++;
                    Log.d("month1", Integer.valueOf(month1).toString());
                    Log.d("month", Integer.valueOf(month).toString());
                    int day1 = c.get(Calendar.DAY_OF_MONTH);
                    if (day==day1 && month==month1 && year==year1) {
                        Log.d("same1", day.toString());
                        Log.d("same2", month.toString());
                        Log.d("same3", year.toString());
                        Toast.makeText(getContext(), "You have to book at least a day before your appointment", Toast.LENGTH_LONG).show();
                    }
                    else if (hour<9 || hour>20)
                        Toast.makeText(getContext(), "Invalid time.", Toast.LENGTH_SHORT).show();
                    else if (year<year1)
                        Toast.makeText(getContext(), "Invalid date.", Toast.LENGTH_SHORT).show();
                    else if (year==year1 && month<month1)
                        Toast.makeText(getContext(), "Invalid date.", Toast.LENGTH_SHORT).show();
                    else if (year==year1 && month==month1 && day<day1)
                        Toast.makeText(getContext(), "Invalid date.", Toast.LENGTH_SHORT).show();
                    else {
                        String title = "Booking successful";
                        String text = "You have booked an appointment at "
                                + name + " on " + date + " at " + time + ".";
                        Notification.Builder builder = new Notification.Builder(getActivity())
                                .setContentTitle(title)
                                .setContentText(text)
                                .setAutoCancel(true)
                                .setSmallIcon(R.drawable.notification);
                        Notification notification = builder.build();
                        NotificationManager manager = (NotificationManager)
                                getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                        manager.notify(DetailsActivity.ID_NOTIFICATION, notification);
                    }
                }
                else if (date.length()==0 && time.length()==0){
                    Toast.makeText(getContext(), "Please enter the date and time", Toast.LENGTH_SHORT).show();
                }
                else if (date.length()==0) {
                    Toast.makeText(getContext(), "Please enter the date", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "Please enter the time", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}