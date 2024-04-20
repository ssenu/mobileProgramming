package kr.co.example.week6task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView eText;
    ArrayList<Integer> intList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);

        Button numButton0 = findViewById(R.id.numButton0);
        Button numButton1 = findViewById(R.id.numButton1);
        Button numButton2 = findViewById(R.id.numButton2);
        Button numButton3 = findViewById(R.id.numButton3);
        Button numButton4 = findViewById(R.id.numButton4);
        Button numButton5 = findViewById(R.id.numButton5);
        Button numButton6 = findViewById(R.id.numButton6);
        Button numButton7 = findViewById(R.id.numButton7);
        Button numButton8 = findViewById(R.id.numButton8);
        Button numButton9 = findViewById(R.id.numButton9);

        eText = findViewById(R.id.textView);

        numButton0.setOnClickListener(v -> eText.append("0"));
        numButton1.setOnClickListener(v -> eText.append("1"));
        numButton2.setOnClickListener(v -> eText.append("2"));
        numButton3.setOnClickListener(v -> eText.append("3"));
        numButton4.setOnClickListener(v -> eText.append("4"));
        numButton5.setOnClickListener(v -> eText.append("5"));
        numButton6.setOnClickListener(v -> eText.append("6"));
        numButton7.setOnClickListener(v -> eText.append("7"));
        numButton8.setOnClickListener(v -> eText.append("8"));
        numButton9.setOnClickListener(v -> eText.append("9"));

        button1.setOnClickListener(v -> {
            String text = eText.getText().toString();
            if (text.length() > 0 && !isOperator(text.charAt(text.length() - 1))) {
                eText.append("/");
            }
        });

        button2.setOnClickListener(v -> {
            String text = eText.getText().toString();
            if (text.length() > 0 && !isOperator(text.charAt(text.length() - 1))) {
                eText.append("x");
            }
        });

        button3.setOnClickListener(v -> {
            String text = eText.getText().toString();
            if (text.length() > 0 && !isOperator(text.charAt(text.length() - 1))) {
                eText.append("-");
            }
        });

        button4.setOnClickListener(v -> {
            String text = eText.getText().toString();
            if (text.length() > 0 && !isOperator(text.charAt(text.length() - 1))) {
                eText.append("+");
            }
        });

        button5.setOnClickListener(v -> {
            String text = eText.getText().toString();
            if (text.length() > 0) {
                String newText = text.substring(0, text.length() - 1);
                eText.setText(newText);
            }
        });

        button6.setOnClickListener(v -> {
            String text1 = eText.getText().toString();
            if (text1.length() > 0) {
                String newText = "";
                eText.setText(newText);
            }
        });

        button7.setOnClickListener(v -> eText.append("."));
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }


    private void calculate() {

        String expression = eText.getText().toString();

        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            }
            else {
                // 연산자인 경우 이전까지의 숫자를 numbers에 추가하고, 연산자를 operators에 추가합니다.
                if (temp.length() > 0) {
                    numbers.add(Double.parseDouble(temp.toString()));
                    temp.setLength(0); // temp를 비워줍니다.
                }
                operators.add(c);
            }
        }
        // 마지막 숫자를 numbers에 추가합니다.
        if (temp.length() > 0) {
            numbers.add(Double.parseDouble(temp.toString()));
        }

        // 결과를 저장할 변수를 초기화합니다.
        double result = numbers.get(0);
        // 수식을 계산합니다.
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            double nextNumber = numbers.get(i + 1);
            switch (op) {
                case '+':
                    result += nextNumber;
                    break;
                case '-':
                    result -= nextNumber;
                    break;
                case 'x':
                    result *= nextNumber;
                    break;
                case '/':
                    result /= nextNumber;
                    break;
            }
        }

        // 결과를 TextView에 표시합니다.
        eText.setText(String.valueOf(result));
    }

    private boolean isOperator(char c) {
        return c == '/' || c == 'x' || c == '-' || c == '+';
    }

}
