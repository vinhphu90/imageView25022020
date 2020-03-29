package com.examplevinhphutvp.image25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView mImg;
    Button mBtnNext,mBtnPrevious,mBtnRandom,mBtnAutoNext,mBtnAutoPrevious;
    ArrayList<Integer>mArrayImageIntegers;
    int count = 0;
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
//                count = count >= mArrayImageIntegers.size() - 1 ? 0 : ++count;
                if (count >= mArrayImageIntegers.size()-1){
                    count = 0;
                }
                mImg.setImageResource(mArrayImageIntegers.get(count));
            }
        });
    }
}
