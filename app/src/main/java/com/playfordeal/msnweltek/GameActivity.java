package com.playfordeal.msnweltek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class GameActivity extends AppCompatActivity {

    Button fifty,fourty,thirty,twenty,ten,nine,eight,seven,six,five,four,three,two,one,tabomega;

    int clickcount=0;
    ImageView homebutton,test;
    TextView textView;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textView=findViewById(R.id.textView);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        ten=findViewById(R.id.ten);
        twenty=findViewById(R.id.twenty);
        thirty=findViewById(R.id.thirty);
        fourty=findViewById(R.id.fourty);
        fifty=findViewById(R.id.fifty);

        tabomega=findViewById(R.id.tabomega);
        test=findViewById(R.id.test);
        Glide.with(getApplicationContext()).asGif().load(R.raw.clean).into(test);
        tabomega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                clickcount=clickcount+1;
                if(clickcount==1)
                {


                    new CountDownTimer(10000, 1000){
                        public void onTick(long millisUntilFinished){
                            textView.setText(String.valueOf(counter));
                            counter++;
                        }
                        public  void onFinish(){
                            textView.setText("FINISH!!");
                            tabomega.setVisibility(View.INVISIBLE);
                            // Toast.makeText(getApplicationContext(),"amDone",Toast.LENGTH_LONG).show();
                        }
                    }.start();
                    fifty.setBackgroundResource(R.drawable.button_green_round);

                 //   ImageView imageView = (ImageView) findViewById(R.id.imageView);
                /*    Glide.with(getApplicationContext()).asGif().load(R.raw.clean).listener(new RequestListener<GifDrawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {

                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                            resource.setLoopCount(1);
                            return false;
                        }
                    }).into(test);*/

                    // here we are adding glide library for showing gif images

                    //first time clicked to do this
                  //  Toast.makeText(getApplicationContext(),"Button clicked first time!", Toast.LENGTH_LONG).show();
                }
                else if(clickcount==6)
                {
                    fourty.setBackgroundResource(R.drawable.button_green_round);
                   // fourty.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    //check how many times clicked and so on
                   // Toast.makeText(getApplicationContext(),"Button clicked count is"+clickcount, Toast.LENGTH_LONG).show();
                }

                else if(clickcount==12)
                {
                    thirty.setBackgroundResource(R.drawable.button_green_round);
                  //  thirty.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }


                else if(clickcount==15)
                {
                    twenty.setBackgroundResource(R.drawable.button_green_round);
                    //twenty.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==19)
                {
                    ten.setBackgroundResource(R.drawable.button_green_round);
                  //  ten.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==25)
                {
                    nine.setBackgroundResource(R.drawable.button_green_round);
                  // nine.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==31)
                {
                    eight.setBackgroundResource(R.drawable.button_green_round);
                  //  eight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==40)
                {
                    seven.setBackgroundResource(R.drawable.button_green_round);
                    //  eight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }


                else if(clickcount==50)
                {
                    six.setBackgroundResource(R.drawable.button_green_round);
                    //  eight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==60)
                {
                    five.setBackgroundResource(R.drawable.button_green_round);
                    //  eight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==70)
                {
                    four.setBackgroundResource(R.drawable.button_green_round);
                    //  eight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

                else if(clickcount==82)
                {
                    three.setBackgroundResource(R.drawable.button_green_round);
                    //  eight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

            }
        });

        homebutton=findViewById(R.id.homebutton);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Homegame=new Intent(getApplicationContext(),FirstScreenActivity.class);
                startActivity(Homegame);
            }
        });
    }
}
