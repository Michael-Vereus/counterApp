package com.mika.counterapp;

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

private Button addBtn;
private Button deductBtn;
private Button resetBtn;
private Button hundredBtn;
private TextView result;
private Counter count;
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
        count = new Counter(0);
        addBtn = findViewById(R.id.btnAdd);
        resetBtn = findViewById(R.id.btnReset);
        deductBtn = findViewById(R.id.btnDeduct);
        result  = findViewById(R.id.result);
        hundredBtn = findViewById(R.id.btnAddHundred);

        // +1 for counter
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.addValue();
                result.setText(getStringOf(count.getValue()));
            }
        });
        // -1 for counter
        deductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.deductValue();
                result.setText(getStringOf(count.getValue()));
            }
        });
        // return to 0 counter
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.resetValue();
                result.setText(getStringOf(count.getValue()));
            }
        });
        // +100 for counter
        hundredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.addHundred();
                result.setText(getStringOf(count.getValue()));
            }
        });
    }
    // To convert the int value to string
    private String getStringOf(int num){
        return String.valueOf(num);
    }
}