package com.example.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText var1 = findViewById(R.id.Var1);
        final EditText var2 = findViewById(R.id.Var2);

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

        final TextView res = findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(var1.getText().toString());
                int b = Integer.valueOf(var2.getText().toString());

                int c = a + b;

                res.setText(String.valueOf(c));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(var1.getText().toString());
                int b = Integer.valueOf(var2.getText().toString());

                int c = a - b;

                res.setText(String.valueOf(c));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(var1.getText().toString());
                int b = Integer.valueOf(var2.getText().toString());

                int c = a * b;

                res.setText(String.valueOf(c));
            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(var1.getText().toString());
                int b = Integer.valueOf(var2.getText().toString());

                int c = a / b;

                res.setText(String.valueOf(c));
            }
        });
    }
}
