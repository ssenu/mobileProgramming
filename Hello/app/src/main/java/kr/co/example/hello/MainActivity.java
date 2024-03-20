package kr.co.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eText1;
    EditText eText2;
    EditText eText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bPlus = (Button) findViewById(R.id.buttonPlus);
        Button bMinus = findViewById(R.id.buttonMinus);
        Button bMultiply = findViewById(R.id.buttonMultiply);
        Button bDivide = findViewById(R.id.buttonDivide);
        eText1 = findViewById(R.id.edit1);
        eText2 = findViewById(R.id.edit2);
        eText3 = findViewById(R.id.edit3);

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal_plus();
            }
        });

        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal_minus();
            }
        });

        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal_multiply();
            }
        });

        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal_divide();
            }
        });
    }


    public void cal_plus() {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();
        int result = Integer.parseInt(s1) + Integer.parseInt(s2);
        eText3.setText("" + result);
    }

    public void cal_minus() {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();
        int result = Integer.parseInt(s1) - Integer.parseInt(s2);
        eText3.setText("" + result);
    }

    public void cal_multiply() {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();
        int result = Integer.parseInt(s1) * Integer.parseInt(s2);
        eText3.setText("" + result);
    }

    public void cal_divide() {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();
        int result = Integer.parseInt(s1) / Integer.parseInt(s2);
        eText3.setText("" + result);
    }
}
