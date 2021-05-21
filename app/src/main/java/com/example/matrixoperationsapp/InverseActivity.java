package com.example.matrixoperationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InverseActivity extends AppCompatActivity {
    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9;
    List<TextView> b;
    Button doneButtoninv;
    static List<Float> aVals;
    static int N=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inverse);

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
        aVals=new ArrayList<>();

        doneButtoninv=findViewById(R.id.doneButtoninv);

        doneButtoninv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InverseActivity.this,MainActivity.class));
                finish();
            }
        });

        Intent intent=getIntent();
        int[][] m1= (int[][]) getIntent().getExtras().getSerializable("matrixAinv");
        int[][] adj=new int[3][3];
        float [][]inv = new float[N][N];

        if (inverse(m1, inv)){
            display(inv);
            for(int i=0;i<9;i++){
                b.get(i).setText(String.valueOf(aVals.get(i)));
            }
        }else{
            Toast.makeText(InverseActivity.this, "Not possible to invert the provided matrix", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(InverseActivity.this,MainActivity.class));
            finish();
        }




    }
    static void getCofactor(int[][] A, int[][] temp, int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Copying into temporary matrix only those element
                // which are not in given row and column
                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];

                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant of matrix.
    n is current dimension of A[][]. */
    static int determinant(int A[][], int n)
    {
        int D = 0; // Initialize result

        // Base case : if matrix contains single element
        if (n == 1)
            return A[0][0];

        int [][]temp = new int[N][N]; // To store cofactors

        int sign = 1; // To store sign multiplier

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of A[0][f]
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);

            // terms are to be added with alternate sign
            sign = -sign;
        }

        return D;
    }

    // Function to get adjoint of A[N][N] in adj[N][N].
    static void adjoint(int[][] A,int[][] adj)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }

        // temp is used to store cofactors of A[][]
        int sign = 1;
        int [][]temp = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // Get cofactor of A[i][j]
                getCofactor(A, temp, i, j, N);

                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0)? 1: -1;

                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign)*(determinant(temp, N-1));
            }
        }
    }

    // Function to calculate and store inverse, returns false if
// matrix is singular
    static boolean inverse(int[][] A, float [][]inverse)
    {
        // Find determinant of A[][]
        int det = determinant(A, N);
        if (det == 0)
        {
            System.out.print("Singular matrix, can't find its inverse");
            return false;
        }

        // Find adjoint
        int [][]adj = new int[N][N];
        adjoint(A, adj);

        // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                inverse[i][j] = adj[i][j]/(float)det;

        return true;
    }
    static void display(float[][] A)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                aVals.add(A[i][j]);
           // System.out.println();
        }
    }
}