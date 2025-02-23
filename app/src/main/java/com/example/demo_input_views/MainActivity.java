package com.example.demo_input_views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handle_btnOk(view);
            }
        });

        Button btnMoveToRanNumGenerator = findViewById(R.id.btn_move_to_ran_num_generator);
        btnMoveToRanNumGenerator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GenerateRandomNumberActivity.class);
                startActivity(intent);
            }
        });

        setRandomBackground();
        SwitchCompat swchTurnOnWifi = findViewById(R.id.swch_turn_on_wifi);
        swchTurnOnWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this,"Wifi on",Toast.LENGTH_SHORT).show();
                    setRandomBackground();
                }
                else {
                    Toast.makeText(MainActivity.this, "Wifi off", Toast.LENGTH_SHORT).show();
                    setRandomBackground();
                }
            }
        });

        Button btnMoveToLinearLayout1 = findViewById(R.id.btn_move_to_linear_layout_1);
        Button btnMoveToLinearLayout2 = findViewById(R.id.btn_move_to_linear_layout_2);
        btnMoveToLinearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity1.class);
                startActivity(intent);
            }
        });
        btnMoveToLinearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity2.class);
                startActivity(intent);
            }
        });

        Button btnMoveToFastFoodIntro = findViewById(R.id.btn_move_to_fast_food_intro);
        btnMoveToFastFoodIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FastFoodWelcomePageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setRandomBackground() {
        ConstraintLayout mainLayout = findViewById(R.id.main);
        ArrayList<Integer> backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.custom_bg_1);
        backgrounds.add(R.drawable.custom_bg_2);
        backgrounds.add(R.drawable.custom_bg_3);

        // Generate a random index within the bounds of the array
        Random random = new Random();
        int randomIndex = random.nextInt(backgrounds.size());

        // Set the random background
        mainLayout.setBackgroundResource(backgrounds.get(randomIndex));
    }

    private void handle_btnOk(View view) {
        // Perform the desired action; here we display a Toast message
        Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_SHORT).show();
        EditText etxUserInput = findViewById(R.id.etx_user_input);
        TextView tvUserInput = findViewById(R.id.tv_user_input);
        tvUserInput.setText(etxUserInput.getText());
    }

}