package com.examplevinhphutvp.image25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImg;
    Button mBtnNext,mBtnPrevious,mBtnRandom,mBtnAutoNext,mBtnAutoPrevious,mBtnPause;
    ArrayList<Integer>mArrayImageIntegers;
    int mcount = 0;
    int mIndexRandom;
    Random mRandom;
    CountDownTimer mcountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImg = findViewById(R.id.imageview);
        mBtnNext = findViewById(R.id.buttonNext);
        mBtnPrevious = findViewById(R.id.buttonPrevious);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mBtnAutoNext = findViewById(R.id.buttonAutonetx);
        mBtnAutoNext = findViewById(R.id.buttonAutonetx);
        mBtnAutoPrevious = findViewById(R.id.buttonAutoPrevious);
        mBtnPause = findViewById(R.id.buttonPause);

        // Tạo mảng hình
        mArrayImageIntegers = new ArrayList<>();
        mArrayImageIntegers.add(R.drawable.hinh1);
        mArrayImageIntegers.add(R.drawable.hinh2);
        mArrayImageIntegers.add(R.drawable.hinh3);
        mArrayImageIntegers.add(R.drawable.hinh4);
        mArrayImageIntegers.add(R.drawable.hinh5);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcount = mcount >= mArrayImageIntegers.size() - 1 ? 0 : ++mcount;
                mImg.setImageResource(mArrayImageIntegers.get(mcount));
            }
        });
        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcount = mcount <= 0 ? mArrayImageIntegers.size() - 1 : --mcount;
                mImg.setImageResource(mArrayImageIntegers.get(mcount));
            }
        });
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRandom = new Random();
                mIndexRandom = mRandom.nextInt(mArrayImageIntegers.size());
                mcount = mIndexRandom;
                mImg.setImageResource(mArrayImageIntegers.get(mIndexRandom));
            }
        });
        mBtnAutoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcountDownTimer != null) {
                    mcountDownTimer.cancel();
                    mcountDownTimer = null;
                }
                mcountDownTimer = new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mcount = mcount >= mArrayImageIntegers.size() - 1 ? 0 : ++mcount;
                        mImg.setImageResource(mArrayImageIntegers.get(mcount));
                    }

                    @Override
                    public void onFinish() {
                        mcountDownTimer.start();

                    }
                };
                mcountDownTimer.start();
            }
        });
        //task1 : làm chức năng Auto Previous
        //task2 : làm chức năng pause auto
        mBtnAutoPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcountDownTimer = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mcount = mcount <= 0 ? mArrayImageIntegers.size()-1:--mcount;
                        mImg.setImageResource(mArrayImageIntegers.get(mcount));

                    }

                    @Override
                    public void onFinish() {
                        mcountDownTimer .start();

                    }
                };
                mcountDownTimer .start();
            }
        });
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcountDownTimer.cancel();
            }
        });




    }
}
