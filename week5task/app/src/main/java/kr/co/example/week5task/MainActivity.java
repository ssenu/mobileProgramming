package kr.co.example.week5task;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView clothingImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clothingImageView = findViewById(R.id.clothingImageView);

        Button colorButton1 = findViewById(R.id.colorButton1);
        Button colorButton2 = findViewById(R.id.colorButton2);
        Button colorButton3 = findViewById(R.id.colorButton3);
        Button colorButton4 = findViewById(R.id.colorButton4);

        colorButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeClothingColor(Color.RED);
            }
        });
        colorButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeClothingColor(Color.BLUE);
            }
        });
        colorButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeClothingColor(Color.GREEN);
            }
        });
        colorButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeClothingColor(Color.YELLOW);
            }
        });
    }

    private void changeClothingColor(int color){
        clothingImageView.setBackgroundColor(color);
    }
}