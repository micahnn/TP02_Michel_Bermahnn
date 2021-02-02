package fr.yahoo.michel.tp02_michel_bermahnn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ComputeActivity extends AppCompatActivity {
    private Button buttonAdd;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private TextView textViewNb1;
    private TextView textViewNb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        initViews_CA();
    }

    /**okiuyhjnbmv
     * Methods that allow to retrieve the instance of views in the layout
     */
    private void initViews_CA() {
        buttonAdd = findViewById(R.id.sum);
        buttonMinus = findViewById(R.id.minus);
        buttonMultiply = findViewById(R.id.multiply);
        buttonDivide = findViewById(R.id.divid);
        textViewNb1 = findViewById(R.id.textNb1);
        textViewNb2 = findViewById(R.id.textNb2);


        Intent intent = getIntent();
        String nb1 = intent.getStringExtra("nb1");
        String nb2 = intent.getStringExtra("nb2");

        textViewNb1.setText("Nombre 1 : "+ nb1);
        textViewNb2.setText("Nombre 2 : "+ nb2);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(nb1) + Integer.parseInt(nb2);
                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(nb1) - Integer.parseInt(nb2);
                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(nb1) * Integer.parseInt(nb2);
                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int entier_Nb1 = Integer.parseInt(nb1);
                int entier_Nb2 = Integer.parseInt(nb2);
                int result;
                if(entier_Nb2 == 0){
                    Toast.makeText(ComputeActivity.this, "La division par zero n'est pas admise.", Toast.LENGTH_SHORT).show();
                    //editTextNb2.setError("Champ obligatoire");
                    result = entier_Nb1/1;
                }
                else{
                    result = entier_Nb1 / entier_Nb2;
                }

                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}