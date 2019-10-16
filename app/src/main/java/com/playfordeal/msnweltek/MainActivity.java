package com.playfordeal.msnweltek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView neuro,omega,cardez,cardio,joint;
    ImageButton playgame;
    AlertDialog.Builder builder;
    AlertDialog cardiodialog,neurodialog,omegadialog,cardezdialog,jointdialog;
    ImageView  closebutton,backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2500);
        rotate.setInterpolator(new LinearInterpolator());

        neuro= (ImageView) findViewById(R.id.neuro);

        omega= (ImageView) findViewById(R.id.omega);

        cardez= (ImageView) findViewById(R.id.cardez);

        cardio= (ImageView) findViewById(R.id.cardio);

        joint= (ImageView) findViewById(R.id.joint);

        backbutton=findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

       // neuro.startAnimation(rotate);

        playgame=findViewById(R.id.playgamebutton);

        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent heartlayout=new Intent(getApplicationContext(),HeartActivity.class);
                startActivity(heartlayout);
            }
        });




        neuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.neurolayout, null);
                closebutton=mView.findViewById(R.id.closebtn);
                mBuilder.setView(mView);
                neurodialog = mBuilder.create();
                neurodialog.show();
                neurodialog.setCanceledOnTouchOutside(false);

                closebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (neurodialog != null && neurodialog.isShowing()) {
                            neurodialog.dismiss();
                        }
                    }
                });
            }
        });

        omega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.omegalayout, null);
                closebutton=mView.findViewById(R.id.closebtn);
                mBuilder.setView(mView);
                omegadialog = mBuilder.create();
                omegadialog.show();
                omegadialog.setCanceledOnTouchOutside(false);

                closebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (omegadialog != null && omegadialog.isShowing()) {
                            omegadialog.dismiss();
                        }
                    }
                });
            }
        });

        cardez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.cardezlayout, null);
                closebutton=mView.findViewById(R.id.closebtn);
                mBuilder.setView(mView);
                cardezdialog = mBuilder.create();
                cardezdialog.show();
                cardezdialog.setCanceledOnTouchOutside(false);

                closebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cardezdialog != null && cardezdialog.isShowing()) {
                            cardezdialog.dismiss();
                        }
                    }
                });
            }
        });




        cardio.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                 View mView = getLayoutInflater().inflate(R.layout.cardiolayout, null);
                 closebutton=mView.findViewById(R.id.closebtn);
                 mBuilder.setView(mView);
                 cardiodialog = mBuilder.create();
                 cardiodialog.show();
                 cardiodialog.setCanceledOnTouchOutside(false);

                 closebutton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         if (cardiodialog != null && cardiodialog.isShowing()) {
                             cardiodialog.dismiss();
                         }
                     }
                 });
             }
         });


        joint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.jointlayout, null);
                closebutton=mView.findViewById(R.id.closebtn);
                mBuilder.setView(mView);
                jointdialog = mBuilder.create();
                jointdialog.show();
                jointdialog.setCanceledOnTouchOutside(false);

                closebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (jointdialog != null && jointdialog.isShowing()) {
                            jointdialog.dismiss();
                        }
                    }
                });
            }
        });

    }
}
