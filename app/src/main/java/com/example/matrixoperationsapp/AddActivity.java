package com.example.matrixoperationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddActivity extends AppCompatActivity {
    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9;
    List<TextView> b;
    Button doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        b=new ArrayList<>();

        b1=findViewById(R.id.b1);   //matrix A et
        b.add(b1);
        b2=findViewById(R.id.b2);
        b.add(b2);
        b3=findViewById(R.id.b3);
        b.add(b3);
        b4=findViewById(R.id.b4);
        b.add(b4);
        b5=findViewById(R.id.b5);
        b.add(b5);
        b6=findViewById(R.id.b6);
        b.add(b6);
        b7=findViewById(R.id.b7);
        b.add(b7);
        b8=findViewById(R.id.b8);
        b.add(b8);
        b9=findViewById(R.id.b9);
        b.add(b9);

        doneButton=findViewById(R.id.doneButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivity.this,MainActivity.class));
                finish();
            }
        });

        Intent intent=getIntent();

        int[][] m1= (int[][]) getIntent().getExtras().getSerializable("matrixA");
        int[][] m2= (int[][]) getIntent().getExtras().getSerializable("matrixB");

        List<Integer> summation=new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                summation.add(m1[i][j]+m2[i][j]);
            }
        }
        //System.out.println(Arrays.asList(summation));
        for(int i=0;i<9;i++){
            b.get(i).setText(String.valueOf(summation.get(i)));
        }


    }
}