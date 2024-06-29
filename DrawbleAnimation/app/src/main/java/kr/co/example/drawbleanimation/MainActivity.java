package kr.co.example.drawbleanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView rocketImage = findViewById(R.id.rocket_image); // 변수명을 "focket_image"에서 "rocket_image"로 수정
        rocketImage.setBackgroundResource(R.drawable.rocket);

        // 애니메이션 객체를 얻는다
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 화면을 터치하면 애니메이션을 시작한다
            rocketAnimation.start();
            return true;
        }
        return super.onTouchEvent(event);
    }
}