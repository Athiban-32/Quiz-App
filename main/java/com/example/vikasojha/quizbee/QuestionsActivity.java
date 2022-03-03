package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "1)I feel nervous",
                            "2)During competition, I find myself thinking about unrelated things",
                            "3)I have self-doubts",
                            "4)My body feels tense",
                            "5)I am concerned that I may not do as well in competition as I could",
                            "6)My mind wanders during sport competition",
                            "7)While performing, I often do not pay attention to what’s going on",
                            "8)I feel tense in my stomach",
                            "9)Thoughts of doing poorly interfere with my concentration during",
                            "10)I’m concerned about choking under pressure",
                            "11)My heart races",
                            "12)I feel my stomach sinking",
                            "13)I’m concerned about performing poorly",
                            "14)I have lapses of concentration during competition because of nervousness",
                            "15)I sometimes find myself trembling before or during a competitive event",
                            "16)I’m worried about reaching my goal",
                            "17)My body feels tight",
                            "18)I’m concerned that others will be disappointed in my performance",
                            "19)My stomach gets upset before or during a competitive event",
                            "20)I’m concerned I won’t be able to concentrate",
                            "21)My heart pounds before competition"
                         };
    String answers[] = {"Not At All","Somewhat","Moderately So","Very Much So", "Not At All","Somewhat","Moderately So","Very Much So", "Not At All","Somewhat","Moderately So","Very Much So", "Not At All","Somewhat","Moderately So","Very Much So","Not At All","Somewhat","Moderately So","Very Much So","Not At All"};
    String opt[] = {
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",
                    "Not At All","Somewhat","Moderately So","Very Much So",

                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}