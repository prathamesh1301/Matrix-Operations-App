package com.example.matrixoperationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addMat=findViewById(R.id.addMat);
        Button multiplyMat=findViewById(R.id.multiplyMat);
        Button inverseMat=findViewById(R.id.inverseMat);
        addMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Matrix_Add_Activity.class));
            }
        });

        multiplyMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Matrix_Mul_Activity.class));
            }
        });

        inverseMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Matrix_Inv_Activity.class));
            }
        });
    }
}