package com.example.aaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mp != null) {
            mp.stop();
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(this,
                R.raw.betterdays);
        mp.setLooping(true);
        mp.start();

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(),"You chose: " + spinner.getSelectedItem(), Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void buttonclick(View view) {
        Intent intent=new Intent(this, StudiosActivity.class);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String city=spinner.getSelectedItem().toString();
        intent.putExtra("city", city);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }
}
