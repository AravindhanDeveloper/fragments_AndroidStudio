package com.example.fragmentbasics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Quiz_Fragment  extends Fragment {
    private TextView titleTxt;
    public static Quiz_Fragment getInstance(String title){
        Quiz_Fragment quizFragment = new Quiz_Fragment();
        Bundle bundle= new Bundle();
        bundle.putString("title",title);
        quizFragment.setArguments(bundle);
        return quizFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.quiz_fragment, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    String title = getArguments().getString("title");
    titleTxt = view.findViewById(R.id.dummyQuiz);
    setTitle(title);

    }

    private void setTitle(String title){
        titleTxt.setText(title);

    }
}
