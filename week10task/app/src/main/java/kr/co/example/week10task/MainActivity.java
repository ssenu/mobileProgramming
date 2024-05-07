package kr.co.example.week10task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        int viewId = view.getId(); // 클릭된 View의 ID를 저장

        // 클릭된 View의 ID에 따라 처리
        if (viewId == R.id.web) {
            intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.google.com"));
        } else if (viewId == R.id.call) {
            intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:(+82)23107280"));
        } else if (viewId == R.id.map) {
            intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:37.30,127.2?z=10"));
        } else if (viewId == R.id.contact) {
            intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("content://contacts/people/"));
        } else {
            // 다른 ID의 경우 처리
        }

        if (intent != null) {
            startActivity(intent); // Intent 실행
        }
    }


}