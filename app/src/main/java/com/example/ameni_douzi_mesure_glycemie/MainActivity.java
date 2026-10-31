package com.example.ameni_douzi_mesure_glycemie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnconsulter;
    private TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnconsulter=findViewById(R.id.btnconsulter);//ce que trouve en global recupere by findId
        msg=findViewById(R.id.msg);
        btnconsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.setText("felicitation");
            }
        });


    }
}