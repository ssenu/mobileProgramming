package kr.co.example.week9task2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private TextView displayIdTextView, displayPasswordTextView, statusTextView;
    String id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        displayIdTextView = findViewById(R.id.displayIdTextView);
        displayPasswordTextView = findViewById(R.id.displayPasswordTextView);
        statusTextView = findViewById(R.id.loginSuccess);

        Intent intent = getIntent();
        if (intent != null){
            id = intent.getStringExtra("ID");
            password = intent.getStringExtra("Password");

            displayIdTextView.setText("아이디 : "+id);
            displayPasswordTextView.setText("비밀번호 : "+password);
        }
    }

    public void check(View e){
        Intent intent = new Intent();
        if (isUserValid(id, password)) {
            intent.putExtra("status", "로그인 성공");
        } else {
            intent.putExtra("status", "로그인 실패");
        }
        setResult(RESULT_OK, intent);
        finish();
    }
    private boolean isUserValid(String username, String password) {

        return username.equals("ssenu") && password.equals("1234");
    }
}
