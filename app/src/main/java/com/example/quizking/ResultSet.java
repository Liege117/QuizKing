package com.example.quizking;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultSet extends AppCompatActivity {
    TextView tv, tv2, tv3,qTv;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_set);

        tv = (TextView)findViewById(R.id.tvRes);
        tv2 = (TextView)findViewById(R.id.tvRes2);
        tv3 = (TextView)findViewById(R.id.tvRes3);
        qTv=(TextView)findViewById(R.id.DispName);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        Intent intent = getIntent();
        String name=intent.getStringExtra("myname");
        if (name.trim().equals(""))
            qTv.setText("Hey User, Your Score:");
        else
            qTv.setText("Hey " + name+", Your Score: ");

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionSet.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionSet.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionSet.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionSet.correct=0;
        QuestionSet.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}