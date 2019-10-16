package com.playfordeal.msnweltek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class FirstScreenActivity extends AppCompatActivity {
    RelativeLayout layout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        layout1=(RelativeLayout)findViewById(R.id.firstscreen);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent heartlayout=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(heartlayout);
            }
        });

    }
}
