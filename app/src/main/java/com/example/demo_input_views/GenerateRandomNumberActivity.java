package com.example.demo_input_views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GenerateRandomNumberActivity extends AppCompatActivity {

    private Random random;
    private TextView txvRandomNumber;
    private Button btnGenerateRanNum;

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_generate_random_number);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        random = new Random();
        txvRandomNumber = findViewById(R.id.txv_random_number);
        btnGenerateRanNum = findViewById(R.id.btn_generate_ran_num);
        btnGenerateRanNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handle_btnGenerateRanNum(view);
            }
        });

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void handle_btnGenerateRanNum(View view) {
        // Generate and display a random number (between 1 and 100)
        int randomNumber = random.nextInt(100) + 1;
        txvRandomNumber.setText("" + randomNumber);
    }

}