package com.example.quizking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionSet extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String[] questions = {
            "Who invented Java Programming?",
            "Which component is used to compile, debug and execute the java programs?",
            "Which of the following is not an OOPS concept in Java?",
            "What is the extension of compiled java classes?",
            "Which of these statements is incorrect about Thread?",
            "Which one of the following is not an access modifier?",
            "What is the numerical range of a char data type in Java?",
            "Which class provides system independent server side implementation?",
            "Which of the following is true about servlets?",
            "Which of the following is a method of wrapper Float for converting the value of an object into byte?",
            "Which of these class is a superclass of all other classes?",
            "Which of these class encapsulate the runtime state of an object or an interface?",
            "Which of these is a process of writing the state of an object to a byte stream?",
            "How an object can become serializable?",
            "What is deserialization?",
            "Which of these process occur automatically by java run time system?",
            "Which of these package contains classes and interfaces for networking?",
            "Which of these is a full form of DNS?",
            "Which of these is an instance variable of class httpd?",
            "Which of these methods of httpd class is used to read data from the stream?" };

    String[] answers = {
            "b) James Gosling",
            "c) JDK",
            "c) Compilation",
            "c) .class",
            "b) run() method is used to begin execution of a thread before start() method in special cases",
            "b) Void",
            "c) 0 to 65535",
            "d) ServerSocket",
            "b) Servlets execute within the address space of web server, platform independent and uses the functionality of java class libraries",
            "b) byte byteValue()",
            "d) Object",
            "a) Class",
            "a) Serialization",
            "b) If a class or any superclass implements java.io.Serializable interface",
            "b) Turning stream of bytes into an object in memory",
            "d) All of the mentioned",
            "c) java.net",
            "d) Domain Name Service",
            "d) All of the mentioned",
            "d) getRawRequest()"};
    String[] opt = {
            "a) Guido van Rossum", "b) James Gosling", "c) Dennis Ritchie", "d) Bjarne Stroustrup",
            "a) JRE", "b) JIT", "c) JDK", "d) JVM",
            "a) Polymorphism", "b) Inheritance", "c) Compilation", "d) Encapsulation",
            "a) .txt", "b) .js", "c) .class", "d) .java",
            "a) start() method is used to begin execution of the thread", "b) run() method is used to begin execution of a thread before start() method in special cases", "c) A thread can be formed by implementing Runnable interface only", "d) A thread can be formed by a class that extends Thread class.",
            "a) Protected", "b) Void", "c) Public", "d) Private",
            "a) 0 to 256", "b) -128 to 127", "c) 0 to 65535", "d) 0 to 32767",
            "a) Server", "b) ServerReader", "c) Socket", "d) ServerSocket",
            "a) Servlets can use the full functionality of the Java class libraries", "b) Servlets execute within the address space of web server, platform independent and uses the functionality of java class libraries", "c) Servlets execute within the address space of web server", "d) Servlets are platform-independent because they are written in java",
            "a) bytevalue()", "b) byte byteValue()", "c) Bytevalue()", "d) Byte Bytevalue()",
            "a) Math", "b) Process", "c) System", "d) Object",
            "a) Class", "b) Object", "c) Runtime", "d) System",
            "a) Serialization", "b) Externalization", "c) File Filtering", "d) All of the mentioned",
            "a) If a class implements java.io.Serializable class", "b) If a class or any superclass implements java.io.Serializable interface", "c) Any object is serializable", "d) No object is serializable",
            "a) Turning object in memory into stream of bytes", "b) Turning stream of bytes into an object in memory", "c) Turning object in memory into stream of bits", "d) Turning stream of bits into an object in memory",
            "a) Serialization", "b) Memory allocation", "c) Deserialization", "d) All of the mentioned",
            "a) java.io", "b) java.util", "c) java.net", "d) java.network",
            "a) Data Network Service", "b) Data Name Service", "c) Domain Network Service", "d) Domain Name Service",
            "a) port", "b) cache", "c) log", "d) All of the mentioned",
            "a) getDta()", "b) GetResponse()", "c) getStream()", "d) getRawRequest()" };
    int flag=0,qNum=1;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_set);
        final TextView score = (TextView)findViewById(R.id.textView4);
        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);
        Intent intentq=getIntent();
        String name=intentq.getStringExtra("myname");

        TextView num=(TextView)findViewById(R.id.questionNumber);
        num.setText(String.format("Question %d", qNum));
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
                if(radio_g.getCheckedRadioButtonId()==-1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uAns = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uAns.getText().toString();
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

                if(flag<questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                    num.setText(String.format("Question %d", ++qNum));
                }
                else {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultSet.class);
                    in.putExtra("myname",name);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultSet.class);
                intent.putExtra("myname",name);
                startActivity(intent);
            }
        });
    }
}