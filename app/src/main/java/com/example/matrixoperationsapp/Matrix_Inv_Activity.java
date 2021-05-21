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

public class Matrix_Inv_Activity extends AppCompatActivity {
    EditText b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int[][] matrixA;
    List<EditText> b;
    Button invertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix__inv_);

        b=new ArrayList<>();
        invertButton=findViewById(R.id.invertButton);

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

        matrixA=new int[3][3];
        invertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(storeDatainArray()){
                   Intent intent=new Intent(Matrix_Inv_Activity.this,InverseActivity.class);
                   Bundle bd=new Bundle();
                   bd.putSerializable("matrixAinv",matrixA);

                   intent.putExtras(bd);
                   startActivity(intent);
               }else{
                   return;
               }
            }
        });
    }

    public boolean storeDatainArray(){
        List<Integer> aVals=new ArrayList<>();
        for(int i=0;i<9;i++){    //get values from A to list bvals
            String s=b.get(i).getText().toString();
            if(TextUtils.isEmpty(s)){
                Toast.makeText(Matrix_Inv_Activity.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                return false;
            }
            aVals.add(Integer.parseInt(s));
        }
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrixA[i][j]=aVals.get(k);
                k++;
            }
        }
    return true;
    }
}