package kr.co.example.week13task;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuizFragment extends Fragment {

    private static final String ARG_QUESTION_NUMBER = "question_number";
    private int questionNumber;

    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment newInstance(int questionNumber) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_QUESTION_NUMBER, questionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionNumber = getArguments().getInt(ARG_QUESTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        TextView questionText = view.findViewById(R.id.question_text);
        Button nextButton = view.findViewById(R.id.next_button);

        // Set the question text to "퀴즈 1", "퀴즈 2", etc.
        questionText.setText("퀴즈 " + questionNumber);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNumber < 5) {
                    // Load the next question fragment
                    QuizFragment nextQuestionFragment = QuizFragment.newInstance(questionNumber + 1);
                    ((QuizActivity) getActivity()).replaceFragment(nextQuestionFragment);
                } else {
                    // Quiz end
                    questionText.setText("퀴즈가 끝났습니다.");
                    nextButton.setVisibility(View.GONE);
                }
            }
        });

        return view;
    }
}
