package com.example.matrixoperationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Matrix_Mul_Activity extends AppCompatActivity {
    EditText b1,b2,b3,b4,b5,b6,b7,b8,b9;
    EditText a1,a2,a3,a4,a5,a6,a7,a8,a9;
    int[][] matrixA;
    int[][] matrixB;
    List<EditText> b,a;
    Button multiplyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix__mul_);

        b=new ArrayList<>();
        a=new ArrayList<>();
        multiplyButton=findViewById(R.id.multiplyButton);

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

        a1=findViewById(R.id.a1);    //matrix B et
        a.add(a1);
        a2=findViewById(R.id.a2);
        a.add(a2);
        a3=findViewById(R.id.a3);
        a.add(a3);
        a4=findViewById(R.id.a4);
        a.add(a4);
        a5=findViewById(R.id.a5);
        a.add(a5);
        a6=findViewById(R.id.a6);
        a.add(a6);
        a7=findViewById(R.id.a7);
        a.add(a7);
        a8=findViewById(R.id.a8);
        a.add(a8);
        a9=findViewById(R.id.a9);
        a.add(a9);

        matrixA=new int[3][3];
        matrixB=new int[3][3];

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(storeDataInArrays_mul()){
                    Intent intent=new Intent(Matrix_Mul_Activity.this,MultiplyActivity.class);
                    Bundle bd=new Bundle();
                    bd.putSerializable("matrixAmul",matrixA);
                    bd.putSerializable("matrixBmul",matrixB);
                    intent.putExtras(bd);
                    startActivity(intent);
                }else{
                    return;
                }
            }
        });
    }

    public boolean storeDataInArrays_mul(){
        List<Integer> aVals=new ArrayList<>();
        List<Integer> bVals=new ArrayList<>();
        for(int i=0;i<9;i++){    //get values from A to list bvals
            String s=b.get(i).getText().toString();
            if(TextUtils.isEmpty(s)){
                Toast.makeText(Matrix_Mul_Activity.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                return false;
            }
            aVals.add(Integer.parseInt(s));
        }

        for(int i=0;i<9;i++){   //get values from B to list bvals
            String s=a.get(i).getText().toString();
            if(TextUtils.isEmpty(s)){
                Toast.makeText(Matrix_Mul_Activity.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                return false;
            }
            bVals.add(Integer.parseInt(s));
        }
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrixA[i][j]=aVals.get(k);
                k++;
            }
        }

        k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrixB[i][j]=bVals.get(k);
                k++;
            }
        }
        return true;
    }
}