package com.example.fragmentbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String [] DATA = new String[]{"quiz 1","quiz 2","quiz 3","quiz 4","quiz 5"};
    int Quiz_count= DATA.length;
    int currentPage=-1;
TextView pageNumber;
Button previousButton,nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageNumber = findViewById(R.id.pageNumber);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuiz();

            }
        });
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevQuiz();

            }
        });
        nextQuiz();
    }
    public void nextQuiz(){
        currentPage +=1;
        if (currentPage > Quiz_count-1){
        currentPage = Quiz_count-1;
        }
        String title = DATA[currentPage];
        createPage(title);
        updatePageCount();
    }
        public void prevQuiz(){

            currentPage -=1;
            if (currentPage < 0){
                currentPage = 0;
            }

            String title = DATA[currentPage];
            createPage(title);
            updatePageCount();

        }
        public void createPage(String title){
//        1.create an fragement manager
//        2.set up transaction
//            3.commit transaction
            FragmentManager fragmentManager =getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();

//            create an fragements
            Quiz_Fragment quiz_fragment= Quiz_Fragment.getInstance(title);

// add transcation
            transaction.replace(R.id.quizContainer,quiz_fragment,title);
            transaction.commit();

        }
//page count
    public void updatePageCount(){
        String pageCount =""+(currentPage+1)+"/"+Quiz_count;
        pageNumber.setText(pageCount);
    }
        }





