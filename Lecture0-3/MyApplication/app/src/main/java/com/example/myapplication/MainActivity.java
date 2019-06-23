package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editVar1 = findViewById(R.id.editVar1);
        final EditText editVar2 = findViewById(R.id.editVar2);
        Button button = findViewById(R.id.button);
        final TextView textview = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(editVar1.getText().toString());
                int b = Integer.valueOf(editVar2.getText().toString());

                int c = a + b;

                textview.setText(String.valueOf(c));

            }
        });
    }
}
